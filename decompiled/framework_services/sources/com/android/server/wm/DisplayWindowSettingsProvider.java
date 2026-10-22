package com.android.server.wm;

import android.os.Environment;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.Xml;
import android.view.DisplayAddress;
import android.view.DisplayInfo;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
class DisplayWindowSettingsProvider implements DisplayWindowSettings.SettingsProvider {
    private static final String DATA_DISPLAY_SETTINGS_FILE_PATH = "system/display_settings.xml";
    private static final int IDENTIFIER_PORT = 1;
    private static final int IDENTIFIER_UNIQUE_ID = 0;
    private static final String TAG = "WindowManager";
    private static final String VENDOR_DISPLAY_SETTINGS_FILE_PATH = "etc/display_settings.xml";
    private static final String WM_DISPLAY_COMMIT_TAG = "wm-displays";
    private ReadableSettings mBaseSettings;
    private WritableSettings mOverrideSettings;

    private static final class AtomicFileStorage implements WritableSettingsStorage {
        private final AtomicFile mAtomicFile;

        AtomicFileStorage(AtomicFile atomicFile) {
            this.mAtomicFile = atomicFile;
        }

        @Override // com.android.server.wm.DisplayWindowSettingsProvider.ReadableSettingsStorage
        public InputStream openRead() throws FileNotFoundException {
            return this.mAtomicFile.openRead();
        }

        @Override // com.android.server.wm.DisplayWindowSettingsProvider.WritableSettingsStorage
        public OutputStream startWrite() throws IOException {
            return this.mAtomicFile.startWrite();
        }

        @Override // com.android.server.wm.DisplayWindowSettingsProvider.WritableSettingsStorage
        public void finishWrite(OutputStream os, boolean success) {
            if ((os instanceof FileOutputStream) == false) goto L10;
            FileOutputStream fos = (FileOutputStream) os;
            if (success == false) goto L7;
            this.mAtomicFile.finishWrite(fos);
            return;
        L7:
            this.mAtomicFile.failWrite(fos);
            return;
        L10:
            throw new IllegalArgumentException("Unexpected OutputStream as argument: " + os);
        }
    }

    @interface DisplayIdentifierType {
    }

    private static final class FileData {
        int mIdentifierType;
        final Map<String, DisplayWindowSettings.SettingsProvider.SettingsEntry> mSettings;

        /* synthetic */ FileData(DisplayWindowSettingsProviderIA r1) {
            this();
        }

        private FileData() {
            this.mSettings = new ArrayMap();
        }

        public String toString() {
            return "FileData{mIdentifierType=" + this.mIdentifierType + ", mSettings=" + this.mSettings + '}';
        }
    }

    private static class ReadableSettings {
        protected int mIdentifierType;
        protected final ArrayMap<String, DisplayWindowSettings.SettingsProvider.SettingsEntry> mSettings;

        ReadableSettings(ReadableSettingsStorage settingsStorage) {
            this.mSettings = new ArrayMap();
            loadSettings(settingsStorage);
        }

        final DisplayWindowSettings.SettingsProvider.SettingsEntry getSettingsEntry(DisplayInfo info) {
            String identifier = getIdentifier(info);
            DisplayWindowSettings.SettingsProvider.SettingsEntry settings = this.mSettings.get(identifier);
            if (settings == null) goto L5;
            return settings;
        L5:
            DisplayWindowSettings.SettingsProvider.SettingsEntry settings2 = this.mSettings.get(info.name);
            if (settings2 == null) goto L9;
            this.mSettings.remove(info.name);
            this.mSettings.put(identifier, settings2);
            return settings2;
        L9:
            return null;
        }

        protected final String getIdentifier(DisplayInfo displayInfo) {
            if (this.mIdentifierType != 1) goto L11;
            if (displayInfo.address == null) goto L11;
            if ((displayInfo.address instanceof DisplayAddress.Physical) == false) goto L11;
            return "port:" + displayInfo.address.getPort();
        L11:
            return displayInfo.uniqueId;
        }

        private void loadSettings(ReadableSettingsStorage settingsStorage) {
            FileData fileData = DisplayWindowSettingsProvider.m9983$$Nest$smreadSettings(settingsStorage);
            if (fileData == null) goto L6;
            this.mIdentifierType = fileData.mIdentifierType;
            this.mSettings.putAll(fileData.mSettings);
            return;
        }
    }

    interface ReadableSettingsStorage {
        InputStream openRead() throws IOException;
    }

    private static final class WritableSettings extends ReadableSettings {
        private final WritableSettingsStorage mSettingsStorage;
        private final ArraySet<String> mVirtualDisplayIdentifiers;

        WritableSettings(WritableSettingsStorage settingsStorage) {
            super(settingsStorage);
            this.mVirtualDisplayIdentifiers = new ArraySet();
            this.mSettingsStorage = settingsStorage;
        }

        DisplayWindowSettings.SettingsProvider.SettingsEntry getOrCreateSettingsEntry(DisplayInfo info) {
            String identifier = getIdentifier(info);
            DisplayWindowSettings.SettingsProvider.SettingsEntry settings = this.mSettings.get(identifier);
            if (settings == null) goto L5;
            return settings;
        L5:
            DisplayWindowSettings.SettingsProvider.SettingsEntry settings2 = this.mSettings.get(info.name);
            if (settings2 == null) goto L9;
            this.mSettings.remove(info.name);
            this.mSettings.put(identifier, settings2);
            writeSettings();
            return settings2;
        L9:
            DisplayWindowSettings.SettingsProvider.SettingsEntry settings3 = new DisplayWindowSettings.SettingsProvider.SettingsEntry();
            this.mSettings.put(identifier, settings3);
            if (info.type != 5) goto L12;
            this.mVirtualDisplayIdentifiers.add(identifier);
        L12:
            return settings3;
        }

        void updateSettingsEntry(DisplayInfo info, DisplayWindowSettings.SettingsProvider.SettingsEntry settings) {
            DisplayWindowSettings.SettingsProvider.SettingsEntry overrideSettings = getOrCreateSettingsEntry(info);
            boolean changed = overrideSettings.setTo(settings);
            if (changed == true) goto L5;
            return;
        L5:
            if (info.type == 5) goto L9;
            writeSettings();
            return;
        }

        void onDisplayRemoved(DisplayInfo info) {
            String identifier = getIdentifier(info);
            if (this.mSettings.containsKey(identifier) == true) goto L6;
            return;
        L6:
            if (this.mVirtualDisplayIdentifiers.remove(identifier) == false) goto L8;
        L9:
            this.mSettings.remove(identifier);
            return;
        L8:
            if (this.mSettings.get(identifier).isEmpty() == true) goto L9;
        }

        void clearDisplaySettings(DisplayInfo info) {
            String identifier = getIdentifier(info);
            this.mSettings.remove(identifier);
            this.mVirtualDisplayIdentifiers.remove(identifier);
        }

        void removeStaleDisplaySettings(Set<String> currentDisplayIdentifiers) {
            if (this.mSettings.retainAll(currentDisplayIdentifiers) == false) goto L6;
            writeSettings();
            return;
        }

        private void writeSettings() {
            FileData fileData = new FileData(null);
            fileData.mIdentifierType = this.mIdentifierType;
            int size = this.mSettings.size();
            int i = 0;
        L3:
            if (i >= size) goto L9;
            String identifier = this.mSettings.keyAt(i);
            if (this.mVirtualDisplayIdentifiers.contains(identifier) == true) goto L8;
            fileData.mSettings.put(identifier, this.mSettings.get(identifier));
        L8:
            i = i + 1;
            goto L3
        L9:
            DisplayWindowSettingsProvider.m9984$$Nest$smwriteSettings(this.mSettingsStorage, fileData);
        }
    }

    interface WritableSettingsStorage extends ReadableSettingsStorage {
        void finishWrite(OutputStream r1, boolean r2);

        OutputStream startWrite() throws IOException;
    }

    public static /* synthetic */ void $r8$lambda$b0RL9JPXUM35c9H8FLHfRJnOKvU(Consumer r0, WindowManagerService r1, DisplayContent r2) {
        lambda$removeStaleDisplaySettingsLocked$1(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$eM_ZFLJ2IWWSfNJX2VvEsDuGSdI(DisplayWindowSettingsProvider r0, Set r1, DisplayInfo r2) {
        r0.lambda$removeStaleDisplaySettingsLocked$0(r1, r2);
    }

    /* JADX INFO: renamed from: -$$Nest$smreadSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ FileData m9983$$Nest$smreadSettings(ReadableSettingsStorage r0) {
        return readSettings(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$smwriteSettings, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m9984$$Nest$smwriteSettings(WritableSettingsStorage r0, FileData r1) {
        writeSettings(r0, r1);
    }

    DisplayWindowSettingsProvider() {
        this(new AtomicFileStorage(getVendorSettingsFile()), new AtomicFileStorage(getOverrideSettingsFileForUser(0)));
    }

    DisplayWindowSettingsProvider(ReadableSettingsStorage baseSettingsStorage, WritableSettingsStorage overrideSettingsStorage) {
        this.mBaseSettings = new ReadableSettings(baseSettingsStorage);
        this.mOverrideSettings = new WritableSettings(overrideSettingsStorage);
    }

    void setBaseSettingsFilePath(String path) {
        if (path == null) goto L4;
        File file = new File(path);
    L5:
        if (file != null) goto L7;
    L9:
        Slog.w(TAG, "display settings " + path + " does not exist, using vendor defaults");
        AtomicFile settingsFile = getVendorSettingsFile();
    L10:
        setBaseSettingsStorage(new AtomicFileStorage(settingsFile));
        return;
    L7:
        if (file.exists() == false) goto L9;
        settingsFile = new AtomicFile(file, WM_DISPLAY_COMMIT_TAG);
        goto L10
    L4:
        file = null;
        goto L5
    }

    void setBaseSettingsStorage(ReadableSettingsStorage baseSettingsStorage) {
        this.mBaseSettings = new ReadableSettings(baseSettingsStorage);
    }

    void setOverrideSettingsForUser(int userId) {
        AtomicFile settingsFile = getOverrideSettingsFileForUser(userId);
        setOverrideSettingsStorage(new AtomicFileStorage(settingsFile));
    }

    void removeStaleDisplaySettingsLocked(final WindowManagerService wms, RootWindowContainer root) {
        final Set<String> displayIdentifiers = new ArraySet();
        final Consumer<DisplayInfo> addDisplayIdentifier = new DisplayWindowSettingsProvider$$ExternalSyntheticLambda0(this, displayIdentifiers);
        root.forAllDisplays(new DisplayWindowSettingsProvider$$ExternalSyntheticLambda1(addDisplayIdentifier, wms));
        this.mOverrideSettings.removeStaleDisplaySettings(displayIdentifiers);
    }

    private /* synthetic */ void lambda$removeStaleDisplaySettingsLocked$0(Set displayIdentifiers, DisplayInfo displayInfo) {
        displayIdentifiers.add(this.mOverrideSettings.getIdentifier(displayInfo));
    }

    private static /* synthetic */ void lambda$removeStaleDisplaySettingsLocked$1(Consumer addDisplayIdentifier, WindowManagerService wms, DisplayContent dc) {
        addDisplayIdentifier.accept(dc.getDisplayInfo());
        List<DisplayInfo> displayInfos = wms.getPossibleDisplayInfoLocked(dc.mDisplayId);
        int size = displayInfos.size();
        int i = 0;
    L3:
        if (i >= size) goto L6;
        addDisplayIdentifier.accept(displayInfos.get(i));
        i = i + 1;
        goto L3
    }

    void setOverrideSettingsStorage(WritableSettingsStorage overrideSettingsStorage) {
        this.mOverrideSettings = new WritableSettings(overrideSettingsStorage);
    }

    @Override // com.android.server.wm.DisplayWindowSettings.SettingsProvider
    public DisplayWindowSettings.SettingsProvider.SettingsEntry getSettings(DisplayInfo info) {
        DisplayWindowSettings.SettingsProvider.SettingsEntry baseSettings = this.mBaseSettings.getSettingsEntry(info);
        DisplayWindowSettings.SettingsProvider.SettingsEntry overrideSettings = this.mOverrideSettings.getOrCreateSettingsEntry(info);
        if (baseSettings == null) goto L5;
        DisplayWindowSettings.SettingsProvider.SettingsEntry mergedSettings = new DisplayWindowSettings.SettingsProvider.SettingsEntry(baseSettings);
        mergedSettings.updateFrom(overrideSettings);
        return mergedSettings;
    L5:
        return new DisplayWindowSettings.SettingsProvider.SettingsEntry(overrideSettings);
    }

    @Override // com.android.server.wm.DisplayWindowSettings.SettingsProvider
    public DisplayWindowSettings.SettingsProvider.SettingsEntry getOverrideSettings(DisplayInfo info) {
        return new DisplayWindowSettings.SettingsProvider.SettingsEntry(this.mOverrideSettings.getOrCreateSettingsEntry(info));
    }

    @Override // com.android.server.wm.DisplayWindowSettings.SettingsProvider
    public void updateOverrideSettings(DisplayInfo info, DisplayWindowSettings.SettingsProvider.SettingsEntry overrides) {
        this.mOverrideSettings.updateSettingsEntry(info, overrides);
    }

    @Override // com.android.server.wm.DisplayWindowSettings.SettingsProvider
    public void onDisplayRemoved(DisplayInfo info) {
        this.mOverrideSettings.onDisplayRemoved(info);
    }

    @Override // com.android.server.wm.DisplayWindowSettings.SettingsProvider
    public void clearDisplaySettings(DisplayInfo info) {
        this.mOverrideSettings.clearDisplaySettings(info);
    }

    int getOverrideSettingsSize() {
        return this.mOverrideSettings.mSettings.size();
    }

    private static AtomicFile getVendorSettingsFile() {
        File vendorFile = new File(Environment.getProductDirectory(), VENDOR_DISPLAY_SETTINGS_FILE_PATH);
        if (vendorFile.exists() == true) goto L6;
        vendorFile = new File(Environment.getVendorDirectory(), VENDOR_DISPLAY_SETTINGS_FILE_PATH);
    L6:
        return new AtomicFile(vendorFile, WM_DISPLAY_COMMIT_TAG);
    }

    private static AtomicFile getOverrideSettingsFileForUser(int userId) {
        if (userId != 0) goto L4;
        File directory = Environment.getDataDirectory();
    L5:
        File overrideSettingsFile = new File(directory, DATA_DISPLAY_SETTINGS_FILE_PATH);
        return new AtomicFile(overrideSettingsFile, WM_DISPLAY_COMMIT_TAG);
    L4:
        directory = Environment.getDataSystemCeDirectory(userId);
        goto L5
    }

    private static FileData readSettings(ReadableSettingsStorage storage) {
        DisplayWindowSettingsProviderIA r2 = null;
        InputStream stream = storage.openRead();     // Catch: IOException -> L84
        FileData fileData = new FileData(r2);
        boolean success = false;
        TypedXmlPullParser parser = Xml.resolvePullParser(stream);     // Catch: Throwable -> L19 IndexOutOfBoundsException -> L21 IOException -> L23 XmlPullParserException -> L25 NumberFormatException -> L27 NullPointerException -> L29 IllegalStateException -> L31
    L6:
        int type = parser.next();     // Catch: Throwable -> L19 IndexOutOfBoundsException -> L21 IOException -> L23 XmlPullParserException -> L25 NumberFormatException -> L27 NullPointerException -> L29 IllegalStateException -> L31
        if (type == 2) goto L10;
        if (type != 1) goto L6;
    L10:
        if (type != 2) goto L52;
        int outerDepth = parser.getDepth();     // Catch: Throwable -> L19 IndexOutOfBoundsException -> L21 IOException -> L23 XmlPullParserException -> L25 NumberFormatException -> L27 NullPointerException -> L29 IllegalStateException -> L31
    L12:
        int type2 = parser.next();     // Catch: Throwable -> L19 IndexOutOfBoundsException -> L21 IOException -> L23 XmlPullParserException -> L25 NumberFormatException -> L27 NullPointerException -> L29 IllegalStateException -> L31
        if (type2 == 1) goto L46;
        if (type2 == 3) goto L17;
    L34:
        if (type2 == 3) goto L12;
        if (type2 == 4) goto L12;
        String tagName = parser.getName();     // Catch: Throwable -> L19 IndexOutOfBoundsException -> L21 IOException -> L23 XmlPullParserException -> L25 NumberFormatException -> L27 NullPointerException -> L29 IllegalStateException -> L31
        if (tagName.equals("display") == true) goto L40;
        if (tagName.equals("config") == true) goto L43;
        Slog.w(TAG, "Unknown element under <display-settings>: " + parser.getName());     // Catch: Throwable -> L19 IndexOutOfBoundsException -> L21 IOException -> L23 XmlPullParserException -> L25 NumberFormatException -> L27 NullPointerException -> L29 IllegalStateException -> L31
        XmlUtils.skipCurrentTag(parser);     // Catch: Throwable -> L19 IndexOutOfBoundsException -> L21 IOException -> L23 XmlPullParserException -> L25 NumberFormatException -> L27 NullPointerException -> L29 IllegalStateException -> L31
        goto L12
    L43:
        readConfig(parser, fileData);     // Catch: Throwable -> L19 IndexOutOfBoundsException -> L21 IOException -> L23 XmlPullParserException -> L25 NumberFormatException -> L27 NullPointerException -> L29 IllegalStateException -> L31
        goto L12
    L40:
        readDisplay(parser, fileData);     // Catch: Throwable -> L19 IndexOutOfBoundsException -> L21 IOException -> L23 XmlPullParserException -> L25 NumberFormatException -> L27 NullPointerException -> L29 IllegalStateException -> L31
        goto L12
    L17:
        if (parser.getDepth() > outerDepth) goto L34;
    L46:
        success = true;
        stream.close();     // Catch: IOException -> L49
    L92:
        goto L77
    L52:
        throw new IllegalStateException("no start tag found");     // Catch: Throwable -> L19 IndexOutOfBoundsException -> L21 IOException -> L23 XmlPullParserException -> L25 NumberFormatException -> L27 NullPointerException -> L29 IllegalStateException -> L31
    L19:
        th = move-exception;
        stream.close();     // Catch: IOException -> L82
    L83:
        throw th;
    L31:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L19
        stream.close();     // Catch: IOException -> L49
    L23:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L19
        stream.close();     // Catch: IOException -> L49
    L21:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L19
        stream.close();     // Catch: IOException -> L49
    L27:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L19
        stream.close();     // Catch: IOException -> L49
    L29:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L19
        stream.close();     // Catch: IOException -> L49
    L25:
        e = move-exception;
        Slog.w(TAG, "Failed parsing " + e);     // Catch: Throwable -> L19
        stream.close();     // Catch: IOException -> L49
    L77:
        if (success == true) goto L79;
        fileData.mSettings.clear();
    L79:
        return fileData;
    L85:
        Slog.i(TAG, "No existing display settings, starting empty");
        return null;
    }

    private static int getIntAttribute(TypedXmlPullParser parser, String name, int defaultValue) {
        return parser.getAttributeInt(null, name, defaultValue);
    }

    private static Integer getIntegerAttribute(TypedXmlPullParser parser, String name, Integer defaultValue) {
        return Integer.valueOf(parser.getAttributeInt(null, name));
    L6:
        return defaultValue;
    }

    private static Boolean getBooleanAttribute(TypedXmlPullParser parser, String name, Boolean defaultValue) {
        return Boolean.valueOf(parser.getAttributeBoolean(null, name));
    L6:
        return defaultValue;
    }

    private static void readDisplay(TypedXmlPullParser parser, FileData fileData) throws NumberFormatException, XmlPullParserException, IOException {
        String name = parser.getAttributeValue(null, "name");
        if (name == null) goto L13;
        DisplayWindowSettings.SettingsProvider.SettingsEntry settingsEntry = new DisplayWindowSettings.SettingsProvider.SettingsEntry();
        int r4 = 0;
        settingsEntry.mWindowingMode = getIntAttribute(parser, "windowingMode", 0);
        settingsEntry.mUserRotationMode = getIntegerAttribute(parser, "userRotationMode", null);
        settingsEntry.mUserRotation = getIntegerAttribute(parser, "userRotation", null);
        settingsEntry.mForcedWidth = getIntAttribute(parser, "forcedWidth", 0);
        settingsEntry.mForcedHeight = getIntAttribute(parser, "forcedHeight", 0);
        settingsEntry.mForcedDensity = getIntAttribute(parser, "forcedDensity", 0);
        settingsEntry.mForcedDensityRatio = parser.getAttributeFloat(null, "forcedDensityRatio", 0.0f);
        settingsEntry.mForcedScalingMode = getIntegerAttribute(parser, "forcedScalingMode", null);
        settingsEntry.mRemoveContentMode = getIntAttribute(parser, "removeContentMode", 0);
        settingsEntry.mShouldShowWithInsecureKeyguard = getBooleanAttribute(parser, "shouldShowWithInsecureKeyguard", null);
        settingsEntry.mShouldShowSystemDecors = getBooleanAttribute(parser, "shouldShowSystemDecors", null);
        Boolean shouldShowIme = getBooleanAttribute(parser, "shouldShowIme", null);
        if (shouldShowIme != null) goto L7;
        settingsEntry.mImePolicy = getIntegerAttribute(parser, "imePolicy", null);
    L12:
        settingsEntry.mFixedToUserRotation = getIntegerAttribute(parser, "fixedToUserRotation", null);
        settingsEntry.mIgnoreOrientationRequest = getBooleanAttribute(parser, "ignoreOrientationRequest", null);
        settingsEntry.mIgnoreDisplayCutout = getBooleanAttribute(parser, "ignoreDisplayCutout", null);
        settingsEntry.mDontMoveToTop = getBooleanAttribute(parser, "dontMoveToTop", null);
        fileData.mSettings.put(name, settingsEntry);
        goto L13
    L7:
        if (shouldShowIme.booleanValue() == true) goto L10;
        r4 = 1;
    L10:
        settingsEntry.mImePolicy = Integer.valueOf(r4);
    L13:
        XmlUtils.skipCurrentTag(parser);
    }

    private static void readConfig(TypedXmlPullParser parser, FileData fileData) throws NumberFormatException, XmlPullParserException, IOException {
        fileData.mIdentifierType = getIntAttribute(parser, "identifier", 0);
        XmlUtils.skipCurrentTag(parser);
    }

    private static void writeSettings(WritableSettingsStorage storage, FileData data) {
        OutputStream stream = storage.startWrite();     // Catch: IOException -> L72
        boolean success = false;
        TypedXmlSerializer out = Xml.resolveSerializer(stream);     // Catch: Throwable -> L14 IOException -> L16
        out.startDocument(null, true);     // Catch: Throwable -> L14 IOException -> L16
        out.startTag(null, "display-settings");     // Catch: Throwable -> L14 IOException -> L16
        out.startTag(null, "config");     // Catch: Throwable -> L14 IOException -> L16
        out.attributeInt(null, "identifier", data.mIdentifierType);     // Catch: Throwable -> L14 IOException -> L16
        out.endTag(null, "config");     // Catch: Throwable -> L14 IOException -> L16
        Iterator<Map.Entry<String, DisplayWindowSettings.SettingsProvider.SettingsEntry>> r2 = data.mSettings.entrySet().iterator();     // Catch: Throwable -> L14 IOException -> L16
    L7:
        if (r2.hasNext() == false) goto L63;
        Map.Entry<String, DisplayWindowSettings.SettingsProvider.SettingsEntry> entry = r2.next();     // Catch: Throwable -> L14 IOException -> L16
        String displayIdentifier = entry.getKey();     // Catch: Throwable -> L14 IOException -> L16
        DisplayWindowSettings.SettingsProvider.SettingsEntry settingsEntry = entry.getValue();     // Catch: Throwable -> L14 IOException -> L16
        if (settingsEntry.isEmpty() == true) goto L7;
        out.startTag(null, "display");     // Catch: Throwable -> L14 IOException -> L16
        out.attribute(null, "name", displayIdentifier);     // Catch: Throwable -> L14 IOException -> L16
        if (settingsEntry.mWindowingMode == 0) goto L19;
        out.attributeInt(null, "windowingMode", settingsEntry.mWindowingMode);     // Catch: Throwable -> L14 IOException -> L16
    L19:
        if (settingsEntry.mUserRotationMode == null) goto L22;
        out.attributeInt(null, "userRotationMode", settingsEntry.mUserRotationMode.intValue());     // Catch: Throwable -> L14 IOException -> L16
    L22:
        if (settingsEntry.mUserRotation == null) goto L25;
        out.attributeInt(null, "userRotation", settingsEntry.mUserRotation.intValue());     // Catch: Throwable -> L14 IOException -> L16
    L25:
        if (settingsEntry.mForcedWidth == 0) goto L30;
        if (settingsEntry.mForcedHeight == 0) goto L30;
        out.attributeInt(null, "forcedWidth", settingsEntry.mForcedWidth);     // Catch: Throwable -> L14 IOException -> L16
        out.attributeInt(null, "forcedHeight", settingsEntry.mForcedHeight);     // Catch: Throwable -> L14 IOException -> L16
    L30:
        if (settingsEntry.mForcedDensity == 0) goto L33;
        out.attributeInt(null, "forcedDensity", settingsEntry.mForcedDensity);     // Catch: Throwable -> L14 IOException -> L16
    L33:
        if (settingsEntry.mForcedDensityRatio == 0.0f) goto L36;
        out.attributeFloat(null, "forcedDensityRatio", settingsEntry.mForcedDensityRatio);     // Catch: Throwable -> L14 IOException -> L16
    L36:
        if (settingsEntry.mForcedScalingMode == null) goto L39;
        out.attributeInt(null, "forcedScalingMode", settingsEntry.mForcedScalingMode.intValue());     // Catch: Throwable -> L14 IOException -> L16
    L39:
        if (settingsEntry.mRemoveContentMode == 0) goto L42;
        out.attributeInt(null, "removeContentMode", settingsEntry.mRemoveContentMode);     // Catch: Throwable -> L14 IOException -> L16
    L42:
        if (settingsEntry.mShouldShowWithInsecureKeyguard == null) goto L45;
        out.attributeBoolean(null, "shouldShowWithInsecureKeyguard", settingsEntry.mShouldShowWithInsecureKeyguard.booleanValue());     // Catch: Throwable -> L14 IOException -> L16
    L45:
        if (settingsEntry.mShouldShowSystemDecors == null) goto L48;
        out.attributeBoolean(null, "shouldShowSystemDecors", settingsEntry.mShouldShowSystemDecors.booleanValue());     // Catch: Throwable -> L14 IOException -> L16
    L48:
        if (settingsEntry.mImePolicy == null) goto L51;
        out.attributeInt(null, "imePolicy", settingsEntry.mImePolicy.intValue());     // Catch: Throwable -> L14 IOException -> L16
    L51:
        if (settingsEntry.mFixedToUserRotation == null) goto L54;
        out.attributeInt(null, "fixedToUserRotation", settingsEntry.mFixedToUserRotation.intValue());     // Catch: Throwable -> L14 IOException -> L16
    L54:
        if (settingsEntry.mIgnoreOrientationRequest == null) goto L57;
        out.attributeBoolean(null, "ignoreOrientationRequest", settingsEntry.mIgnoreOrientationRequest.booleanValue());     // Catch: Throwable -> L14 IOException -> L16
    L57:
        if (settingsEntry.mIgnoreDisplayCutout == null) goto L60;
        out.attributeBoolean(null, "ignoreDisplayCutout", settingsEntry.mIgnoreDisplayCutout.booleanValue());     // Catch: Throwable -> L14 IOException -> L16
    L60:
        if (settingsEntry.mDontMoveToTop == null) goto L62;
        out.attributeBoolean(null, "dontMoveToTop", settingsEntry.mDontMoveToTop.booleanValue());     // Catch: Throwable -> L14 IOException -> L16
    L62:
        out.endTag(null, "display");     // Catch: Throwable -> L14 IOException -> L16
        goto L7
    L63:
        out.endTag(null, "display-settings");     // Catch: Throwable -> L14 IOException -> L16
        out.endDocument();     // Catch: Throwable -> L14 IOException -> L16
        success = true;
    L65:
        storage.finishWrite(stream, success);
        return;
    L14:
        th = move-exception;
        storage.finishWrite(stream, false);
        throw th;
    L16:
        e = move-exception;
        Slog.w(TAG, "Failed to write display window settings.", e);     // Catch: Throwable -> L14
    L72:
        e = move-exception;
        Slog.w(TAG, "Failed to write display settings: " + e);
    }
}
