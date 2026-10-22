package com.android.server.display;

import android.graphics.Point;
import android.hardware.display.BrightnessConfiguration;
import android.hardware.display.WifiDisplay;
import android.os.Handler;
import android.pico.utils.ExtImplFactory;
import android.util.AtomicFile;
import android.util.Slog;
import android.util.SparseArray;
import android.util.SparseLongArray;
import android.util.TimeUtils;
import android.util.Xml;
import com.android.internal.os.BackgroundThread;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
final class PersistentDataStore {
    private static final String ATTR_DEVICE_ADDRESS = "deviceAddress";
    private static final String ATTR_DEVICE_ALIAS = "deviceAlias";
    private static final String ATTR_DEVICE_NAME = "deviceName";
    private static final String ATTR_PACKAGE_NAME = "package-name";
    private static final String ATTR_TIME_STAMP = "timestamp";
    private static final String ATTR_UNIQUE_ID = "unique-id";
    private static final String ATTR_USER_SERIAL = "user-serial";
    public static final int DEFAULT_USER_ID = -1;
    static final String TAG = "DisplayManager.PersistentDataStore";
    private static final String TAG_BRIGHTNESS_CONFIGURATION = "brightness-configuration";
    private static final String TAG_BRIGHTNESS_CONFIGURATIONS = "brightness-configurations";
    private static final String TAG_BRIGHTNESS_NITS_FOR_DEFAULT_DISPLAY = "brightness-nits-for-default-display";
    private static final String TAG_BRIGHTNESS_VALUE = "brightness-value";
    private static final String TAG_COLOR_MODE = "color-mode";
    private static final String TAG_DISPLAY = "display";
    private static final String TAG_DISPLAY_MANAGER_STATE = "display-manager-state";
    private static final String TAG_DISPLAY_STATES = "display-states";
    private static final String TAG_REFRESH_RATE = "refresh-rate";
    private static final String TAG_REMEMBERED_WIFI_DISPLAYS = "remembered-wifi-displays";
    private static final String TAG_RESOLUTION_HEIGHT = "resolution-height";
    private static final String TAG_RESOLUTION_WIDTH = "resolution-width";
    private static final String TAG_STABLE_DEVICE_VALUES = "stable-device-values";
    private static final String TAG_STABLE_DISPLAY_HEIGHT = "stable-display-height";
    private static final String TAG_STABLE_DISPLAY_WIDTH = "stable-display-width";
    private static final String TAG_WIFI_DISPLAY = "wifi-display";
    private float mBrightnessNitsForDefaultDisplay;
    private boolean mDirty;
    private final HashMap<String, DisplayState> mDisplayStates;
    private IExtPersistentDataStore mExt;
    private final Object mFileAccessLock;
    private BrightnessConfigurations mGlobalBrightnessConfigurations;
    private final Handler mHandler;
    private Injector mInjector;
    private boolean mLoaded;
    private ArrayList<WifiDisplay> mRememberedWifiDisplays;
    private final StableDeviceValues mStableDeviceValues;

    private static final class BrightnessConfigurations {
        private final SparseArray<BrightnessConfiguration> mConfigurations;
        private final SparseArray<String> mPackageNames;
        private final SparseLongArray mTimeStamps;

        /* JADX INFO: renamed from: -$$Nest$fgetmConfigurations, reason: not valid java name */
        static /* bridge */ /* synthetic */ SparseArray m3877$$Nest$fgetmConfigurations(BrightnessConfigurations r0) {
            return r0.mConfigurations;
        }

        /* JADX INFO: renamed from: -$$Nest$msetBrightnessConfigurationForUser, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m3878$$Nest$msetBrightnessConfigurationForUser(BrightnessConfigurations r0, BrightnessConfiguration r1, int r2, String r3) {
            return r0.setBrightnessConfigurationForUser(r1, r2, r3);
        }

        public BrightnessConfigurations() {
            this.mConfigurations = new SparseArray();
            this.mTimeStamps = new SparseLongArray();
            this.mPackageNames = new SparseArray();
        }

        private boolean setBrightnessConfigurationForUser(BrightnessConfiguration c, int userSerial, String packageName) {
            BrightnessConfiguration currentConfig = this.mConfigurations.get(userSerial);
            if (currentConfig == c) goto L15;
            if (currentConfig != null) goto L6;
        L7:
            if (c == null) goto L12;
            if (packageName != null) goto L10;
            this.mPackageNames.remove(userSerial);
        L11:
            this.mTimeStamps.put(userSerial, System.currentTimeMillis());
            this.mConfigurations.put(userSerial, c);
            return true;
        L10:
            this.mPackageNames.put(userSerial, packageName);
            goto L11
        L12:
            this.mPackageNames.remove(userSerial);
            this.mTimeStamps.delete(userSerial);
            this.mConfigurations.remove(userSerial);
            return true;
        L6:
            if (currentConfig.equals(c) == false) goto L7;
            return false;
        L15:
            return false;
        }

        public BrightnessConfiguration getBrightnessConfiguration(int userSerial) {
            return this.mConfigurations.get(userSerial);
        }

        public void loadFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
            int outerDepth = parser.getDepth();
        L4:
            if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L26;
            if (PersistentDataStore.TAG_BRIGHTNESS_CONFIGURATION.equals(parser.getName()) == false) goto L4;
            int userSerial = parser.getAttributeInt(null, PersistentDataStore.ATTR_USER_SERIAL);     // Catch: NumberFormatException -> L10
        L12:
            String packageName = parser.getAttributeValue(null, PersistentDataStore.ATTR_PACKAGE_NAME);
            long timeStamp = parser.getAttributeLong(null, "timestamp", -1);
            BrightnessConfiguration config = BrightnessConfiguration.loadFromXml(parser);     // Catch: IllegalArgumentException -> L19
            if (userSerial < 0) goto L4;
            if (config == null) goto L4;
            this.mConfigurations.put(userSerial, config);     // Catch: IllegalArgumentException -> L19
            if (timeStamp == (-1)) goto L21;
            this.mTimeStamps.put(userSerial, timeStamp);     // Catch: IllegalArgumentException -> L19
        L21:
            if (packageName == null) goto L4;
            this.mPackageNames.put(userSerial, packageName);     // Catch: IllegalArgumentException -> L19
        L19:
            iae = move-exception;
            Slog.e(PersistentDataStore.TAG, "Failed to load brightness configuration!", iae);
        L10:
            nfe = move-exception;
            Slog.e(PersistentDataStore.TAG, "Failed to read in brightness configuration", nfe);
            userSerial = -1;
            goto L12
        }

        public void saveToXml(TypedXmlSerializer serializer) throws IOException {
            int i = 0;
        L4:
            if (i >= this.mConfigurations.size()) goto L13;
            int userSerial = this.mConfigurations.keyAt(i);
            BrightnessConfiguration config = this.mConfigurations.valueAt(i);
            serializer.startTag(null, PersistentDataStore.TAG_BRIGHTNESS_CONFIGURATION);
            serializer.attributeInt(null, PersistentDataStore.ATTR_USER_SERIAL, userSerial);
            String packageName = this.mPackageNames.get(userSerial);
            if (packageName == null) goto L8;
            serializer.attribute(null, PersistentDataStore.ATTR_PACKAGE_NAME, packageName);
        L8:
            long timestamp = this.mTimeStamps.get(userSerial, -1);
            if (timestamp == (-1)) goto L11;
            serializer.attributeLong(null, "timestamp", timestamp);
        L11:
            config.saveToXml(serializer);
            serializer.endTag(null, PersistentDataStore.TAG_BRIGHTNESS_CONFIGURATION);
            i = i + 1;
            goto L4
        }

        public void dump(PrintWriter pw, String prefix) {
            int i = 0;
        L4:
            if (i >= this.mConfigurations.size()) goto L12;
            int userSerial = this.mConfigurations.keyAt(i);
            long time = this.mTimeStamps.get(userSerial, -1);
            String packageName = this.mPackageNames.get(userSerial);
            pw.println(prefix + "User " + userSerial + ":");
            if (time == (-1)) goto L8;
            pw.println(prefix + "  set at: " + TimeUtils.formatForLogging(time));
        L8:
            if (packageName == null) goto L10;
            pw.println(prefix + "  set by: " + packageName);
        L10:
            pw.println(prefix + "  " + this.mConfigurations.valueAt(i));
            i = i + 1;
            goto L4
        }
    }

    private static final class DisplayState {
        private int mColorMode;
        private BrightnessConfigurations mDisplayBrightnessConfigurations;
        private int mHeight;
        private SparseArray<Float> mPerUserBrightness;
        private float mRefreshRate;
        private int mWidth;

        /* synthetic */ DisplayState(PersistentDataStoreIA r1) {
            this();
        }

        private DisplayState() {
            this.mPerUserBrightness = new SparseArray();
            this.mDisplayBrightnessConfigurations = new BrightnessConfigurations();
        }

        public boolean setColorMode(int colorMode) {
            if (colorMode != this.mColorMode) goto L6;
            return false;
        L6:
            this.mColorMode = colorMode;
            return true;
        }

        public int getColorMode() {
            return this.mColorMode;
        }

        public boolean setBrightness(float brightness, int userSerial) {
            this.mPerUserBrightness.remove(-1);
            if (getBrightness(userSerial) != brightness) goto L6;
            return false;
        L6:
            this.mPerUserBrightness.set(userSerial, Float.valueOf(brightness));
            return true;
        }

        public float getBrightness(int userSerial) {
            SparseArray<Float> r0 = this.mPerUserBrightness;
            Float r1 = Float.valueOf(Float.NaN);
            float brightness = r0.get(userSerial, r1).floatValue();
            if (Float.isNaN(brightness) == true) goto L5;
            return brightness;
        L5:
            return this.mPerUserBrightness.get(-1, r1).floatValue();
        }

        public boolean setBrightnessConfiguration(BrightnessConfiguration configuration, int userSerial, String packageName) {
            BrightnessConfigurations.m3878$$Nest$msetBrightnessConfigurationForUser(this.mDisplayBrightnessConfigurations, configuration, userSerial, packageName);
            return true;
        }

        public BrightnessConfiguration getBrightnessConfiguration(int userSerial) {
            return (BrightnessConfiguration) BrightnessConfigurations.m3877$$Nest$fgetmConfigurations(this.mDisplayBrightnessConfigurations).get(userSerial);
        }

        public boolean setResolution(int width, int height) {
            if (width == this.mWidth) goto L5;
        L8:
            this.mWidth = width;
            this.mHeight = height;
            return true;
        L5:
            if (height != this.mHeight) goto L8;
            return false;
        }

        public Point getResolution() {
            return new Point(this.mWidth, this.mHeight);
        }

        public boolean setRefreshRate(float refreshRate) {
            if (refreshRate != this.mRefreshRate) goto L6;
            return false;
        L6:
            this.mRefreshRate = refreshRate;
            return true;
        }

        public float getRefreshRate() {
            return this.mRefreshRate;
        }

        public void loadFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
            int outerDepth = parser.getDepth();
        L4:
            if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L36;
            String r1 = parser.getName();
            switch(r1.hashCode()) {
                case -1377859227: goto L24;
                case -1321967815: goto L21;
                case -945778443: goto L18;
                case -196957848: goto L15;
                case -92443502: goto L12;
                case 1243304397: goto L9;
                default: goto L26;
            };
        L26:
            byte r2 = -1;
        L27:
            switch(r2) {
                case 0: goto L34;
                case 1: goto L33;
                case 2: goto L32;
                case 3: goto L31;
                case 4: goto L30;
                case 5: goto L29;
                default: goto L4;
            };
        L29:
            String refreshRate = parser.nextText();
            this.mRefreshRate = Float.parseFloat(refreshRate);
            goto L4
        L30:
            String height = parser.nextText();
            this.mHeight = Integer.parseInt(height);
            goto L4
        L31:
            String width = parser.nextText();
            this.mWidth = Integer.parseInt(width);
            goto L4
        L32:
            this.mDisplayBrightnessConfigurations.loadFromXml(parser);
            goto L4
        L33:
            loadBrightnessFromXml(parser);
            goto L4
        L34:
            String value = parser.nextText();
            this.mColorMode = Integer.parseInt(value);
            goto L4
        L9:
            if (r1.equals(PersistentDataStore.TAG_COLOR_MODE) == false) goto L26;
            r2 = 0;
            goto L27
        L12:
            if (r1.equals(PersistentDataStore.TAG_REFRESH_RATE) == false) goto L26;
            r2 = 5;
            goto L27
        L15:
            if (r1.equals(PersistentDataStore.TAG_RESOLUTION_HEIGHT) == false) goto L26;
            r2 = 4;
            goto L27
        L18:
            if (r1.equals(PersistentDataStore.TAG_BRIGHTNESS_VALUE) == false) goto L26;
            r2 = 1;
            goto L27
        L21:
            if (r1.equals(PersistentDataStore.TAG_BRIGHTNESS_CONFIGURATIONS) == false) goto L26;
            r2 = 2;
            goto L27
        L24:
            if (r1.equals(PersistentDataStore.TAG_RESOLUTION_WIDTH) == false) goto L26;
            r2 = 3;
            goto L27
        }

        public void saveToXml(TypedXmlSerializer serializer) throws IOException {
            serializer.startTag(null, PersistentDataStore.TAG_COLOR_MODE);
            serializer.text(Integer.toString(this.mColorMode));
            serializer.endTag(null, PersistentDataStore.TAG_COLOR_MODE);
            int i = 0;
        L4:
            if (i >= this.mPerUserBrightness.size()) goto L6;
            serializer.startTag(null, PersistentDataStore.TAG_BRIGHTNESS_VALUE);
            serializer.attributeInt(null, PersistentDataStore.ATTR_USER_SERIAL, this.mPerUserBrightness.keyAt(i));
            serializer.text(Float.toString(this.mPerUserBrightness.valueAt(i).floatValue()));
            serializer.endTag(null, PersistentDataStore.TAG_BRIGHTNESS_VALUE);
            i = i + 1;
            goto L4
        L6:
            serializer.startTag(null, PersistentDataStore.TAG_BRIGHTNESS_CONFIGURATIONS);
            this.mDisplayBrightnessConfigurations.saveToXml(serializer);
            serializer.endTag(null, PersistentDataStore.TAG_BRIGHTNESS_CONFIGURATIONS);
            serializer.startTag(null, PersistentDataStore.TAG_RESOLUTION_WIDTH);
            serializer.text(Integer.toString(this.mWidth));
            serializer.endTag(null, PersistentDataStore.TAG_RESOLUTION_WIDTH);
            serializer.startTag(null, PersistentDataStore.TAG_RESOLUTION_HEIGHT);
            serializer.text(Integer.toString(this.mHeight));
            serializer.endTag(null, PersistentDataStore.TAG_RESOLUTION_HEIGHT);
            serializer.startTag(null, PersistentDataStore.TAG_REFRESH_RATE);
            serializer.text(Float.toString(this.mRefreshRate));
            serializer.endTag(null, PersistentDataStore.TAG_REFRESH_RATE);
        }

        public void dump(PrintWriter pw, String prefix) {
            pw.println(prefix + "ColorMode=" + this.mColorMode);
            StringBuilder r0 = new StringBuilder();
            r0.append(prefix);
            r0.append("BrightnessValues: ");
            pw.println(r0.toString());
            int i = 0;
        L4:
            if (i >= this.mPerUserBrightness.size()) goto L6;
            pw.println("User: " + this.mPerUserBrightness.keyAt(i) + " Value: " + this.mPerUserBrightness.valueAt(i));
            i = i + 1;
            goto L4
        L6:
            pw.println(prefix + "DisplayBrightnessConfigurations: ");
            this.mDisplayBrightnessConfigurations.dump(pw, prefix);
            pw.println(prefix + "Resolution=" + this.mWidth + " " + this.mHeight);
            StringBuilder r1 = new StringBuilder();
            r1.append(prefix);
            r1.append("RefreshRate=");
            r1.append(this.mRefreshRate);
            pw.println(r1.toString());
        }

        private void loadBrightnessFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
            int userSerial = parser.getAttributeInt(null, PersistentDataStore.ATTR_USER_SERIAL);     // Catch: Throwable -> L5
        L7:
            String brightness = parser.nextText();
            this.mPerUserBrightness.set(userSerial, Float.valueOf(Float.parseFloat(brightness)));     // Catch: NumberFormatException -> L10
            return;
        L10:
            nfe = move-exception;
            Slog.e(PersistentDataStore.TAG, "Failed to read brightness", nfe);
            return;
        L5:
            e = move-exception;
            Slog.e(PersistentDataStore.TAG, "Failed to read user serial", e);
            userSerial = -1;
            goto L7
        }
    }

    static class Injector {
        private final AtomicFile mAtomicFile;

        public Injector() {
            this.mAtomicFile = new AtomicFile(new File("/data/system/display-manager-state.xml"), "display-state");
        }

        public InputStream openRead() throws FileNotFoundException {
            return this.mAtomicFile.openRead();
        }

        public OutputStream startWrite() throws IOException {
            return this.mAtomicFile.startWrite();
        }

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

    private static final class StableDeviceValues {
        private int mHeight;
        private int mWidth;

        /* JADX INFO: renamed from: -$$Nest$mgetDisplaySize, reason: not valid java name */
        static /* bridge */ /* synthetic */ Point m3879$$Nest$mgetDisplaySize(StableDeviceValues r0) {
            return r0.getDisplaySize();
        }

        /* synthetic */ StableDeviceValues(PersistentDataStoreIA r1) {
            this();
        }

        private StableDeviceValues() {
        }

        private Point getDisplaySize() {
            return new Point(this.mWidth, this.mHeight);
        }

        public boolean setDisplaySize(Point r) {
            if (this.mWidth == r.x) goto L5;
        L9:
            this.mWidth = r.x;
            this.mHeight = r.y;
            return true;
        L5:
            if (this.mHeight != r.y) goto L9;
            return false;
        }

        public void loadFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
            int outerDepth = parser.getDepth();
        L4:
            if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L20;
            String r1 = parser.getName();
            switch(r1.hashCode()) {
                case -1635792540: goto L12;
                case 1069578729: goto L9;
                default: goto L14;
            };
        L14:
            byte r2 = -1;
        L15:
            switch(r2) {
                case 0: goto L18;
                case 1: goto L17;
                default: goto L4;
            };
        L17:
            this.mHeight = loadIntValue(parser);
            goto L4
        L18:
            this.mWidth = loadIntValue(parser);
            goto L4
        L9:
            if (r1.equals(PersistentDataStore.TAG_STABLE_DISPLAY_WIDTH) == false) goto L14;
            r2 = 0;
            goto L15
        L12:
            if (r1.equals(PersistentDataStore.TAG_STABLE_DISPLAY_HEIGHT) == false) goto L14;
            r2 = 1;
            goto L15
        }

        private static int loadIntValue(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
            String value = parser.nextText();     // Catch: NumberFormatException -> L4
            return Integer.parseInt(value);
        L5:
            return 0;
        }

        public void saveToXml(TypedXmlSerializer serializer) throws IOException {
            if (this.mWidth > 0) goto L5;
            return;
        L5:
            if (this.mHeight <= 0) goto L9;
            serializer.startTag(null, PersistentDataStore.TAG_STABLE_DISPLAY_WIDTH);
            serializer.text(Integer.toString(this.mWidth));
            serializer.endTag(null, PersistentDataStore.TAG_STABLE_DISPLAY_WIDTH);
            serializer.startTag(null, PersistentDataStore.TAG_STABLE_DISPLAY_HEIGHT);
            serializer.text(Integer.toString(this.mHeight));
            serializer.endTag(null, PersistentDataStore.TAG_STABLE_DISPLAY_HEIGHT);
            return;
        }

        public void dump(PrintWriter pw, String prefix) {
            pw.println(prefix + "StableDisplayWidth=" + this.mWidth);
            pw.println(prefix + "StableDisplayHeight=" + this.mHeight);
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$UdAI9akrjrdWLmT-CFr3jYi7VZw, reason: not valid java name */
    public static /* synthetic */ void m3876$r8$lambda$UdAI9akrjrdWLmTCFr3jYi7VZw(PersistentDataStore r0, ByteArrayOutputStream r1) {
        r0.lambda$save$0(r1);
    }

    public PersistentDataStore() {
        this(new Injector());
    }

    PersistentDataStore(Injector injector) {
        this(injector, new Handler(BackgroundThread.getHandler().getLooper()));
    }

    PersistentDataStore(Injector injector, Handler handler) {
        this.mRememberedWifiDisplays = new ArrayList();
        this.mDisplayStates = new HashMap();
        this.mBrightnessNitsForDefaultDisplay = -1.0f;
        this.mStableDeviceValues = new StableDeviceValues(null);
        this.mGlobalBrightnessConfigurations = new BrightnessConfigurations();
        this.mFileAccessLock = new Object();
        this.mExt = (IExtPersistentDataStore) ExtImplFactory.getImpl(IExtPersistentDataStore.class, new Object[]{this});
        this.mInjector = injector;
        this.mHandler = handler;
    }

    public void saveIfNeeded() {
        if (this.mDirty == false) goto L6;
        save();
        this.mDirty = false;
        return;
    }

    public WifiDisplay getRememberedWifiDisplay(String deviceAddress) {
        loadIfNeeded();
        int index = findRememberedWifiDisplay(deviceAddress);
        if (index >= 0) goto L5;
        return null;
    L5:
        return this.mRememberedWifiDisplays.get(index);
    }

    public WifiDisplay[] getRememberedWifiDisplays() {
        loadIfNeeded();
        return (WifiDisplay[]) this.mRememberedWifiDisplays.toArray(new WifiDisplay[this.mRememberedWifiDisplays.size()]);
    }

    public WifiDisplay applyWifiDisplayAlias(WifiDisplay display) {
        if (display == null) goto L11;
        loadIfNeeded();
        int index = findRememberedWifiDisplay(display.getDeviceAddress());
        if (index < 0) goto L6;
        String alias = this.mRememberedWifiDisplays.get(index).getDeviceAlias();
        String alias2 = alias;
    L7:
        String alias3 = display.getDeviceAlias();
        if (Objects.equals(alias3, alias2) == true) goto L11;
        return new WifiDisplay(display.getDeviceAddress(), display.getDeviceName(), alias2, display.isAvailable(), display.canConnect(), display.isRemembered());
    L6:
        alias2 = null;
    L11:
        return display;
    }

    public WifiDisplay[] applyWifiDisplayAliases(WifiDisplay[] displays) {
        WifiDisplay[] results = displays;
        if (results == null) goto L12;
        int count = displays.length;
        int i = 0;
    L5:
        if (i >= count) goto L12;
        WifiDisplay result = applyWifiDisplayAlias(displays[i]);
        if (result == displays[i]) goto L11;
        if (results != displays) goto L10;
        results = new WifiDisplay[count];
        System.arraycopy(displays, 0, results, 0, count);
    L10:
        results[i] = result;
    L11:
        i = i + 1;
    L12:
        return results;
    }

    public boolean rememberWifiDisplay(WifiDisplay display) {
        loadIfNeeded();
        int index = findRememberedWifiDisplay(display.getDeviceAddress());
        if (index < 0) goto L9;
        WifiDisplay other = this.mRememberedWifiDisplays.get(index);
        if (other.equals(display) == false) goto L8;
        return false;
    L8:
        this.mRememberedWifiDisplays.set(index, display);
    L10:
        setDirty();
        return true;
    L9:
        this.mRememberedWifiDisplays.add(display);
        goto L10
    }

    public boolean forgetWifiDisplay(String deviceAddress) {
        loadIfNeeded();
        int index = findRememberedWifiDisplay(deviceAddress);
        if (index < 0) goto L6;
        this.mRememberedWifiDisplays.remove(index);
        setDirty();
        return true;
    L6:
        return false;
    }

    private int findRememberedWifiDisplay(String deviceAddress) {
        int count = this.mRememberedWifiDisplays.size();
        int i = 0;
    L3:
        if (i >= count) goto L8;
        if (this.mRememberedWifiDisplays.get(i).getDeviceAddress().equals(deviceAddress) == true) goto L6;
        i = i + 1;
        goto L3
    L6:
        return i;
    L8:
        return -1;
    }

    public int getColorMode(DisplayDevice device) {
        if (device.hasStableUniqueId() == true) goto L5;
        return -1;
    L5:
        DisplayState state = getDisplayState(device.getUniqueId(), false);
        if (state != null) goto L9;
        return -1;
    L9:
        return state.getColorMode();
    }

    public boolean setColorMode(DisplayDevice device, int colorMode) {
        if (device.hasStableUniqueId() == true) goto L5;
        return false;
    L5:
        DisplayState state = getDisplayState(device.getUniqueId(), true);
        if (state.setColorMode(colorMode) == false) goto L9;
        setDirty();
        return true;
    L9:
        return false;
    }

    public float getBrightness(DisplayDevice device, int userSerial) {
        if (device != null) goto L5;
    L12:
        return Float.NaN;
    L5:
        if (device.hasStableUniqueId() == false) goto L12;
        DisplayState state = getDisplayState(device.getUniqueId(), false);
        if (state != null) goto L11;
        return Float.NaN;
    L11:
        return state.getBrightness(userSerial);
    }

    public boolean setBrightness(DisplayDevice displayDevice, float brightness, int userSerial) {
        if (displayDevice != null) goto L5;
    L15:
        return false;
    L5:
        if (displayDevice.hasStableUniqueId() == false) goto L15;
        String displayDeviceUniqueId = displayDevice.getUniqueId();
        if (displayDeviceUniqueId != null) goto L10;
        return false;
    L10:
        DisplayState state = getDisplayState(displayDeviceUniqueId, true);
        if (state.setBrightness(brightness, userSerial) == false) goto L14;
        setDirty();
        return true;
    L14:
        return false;
    }

    public float getBrightnessNitsForDefaultDisplay() {
        return this.mBrightnessNitsForDefaultDisplay;
    }

    public boolean setBrightnessNitsForDefaultDisplay(float nits) {
        if (nits == this.mBrightnessNitsForDefaultDisplay) goto L6;
        this.mBrightnessNitsForDefaultDisplay = nits;
        setDirty();
        return true;
    L6:
        return false;
    }

    public boolean setUserPreferredRefreshRate(DisplayDevice displayDevice, float refreshRate) {
        String displayDeviceUniqueId = displayDevice.getUniqueId();
        if (displayDevice.hasStableUniqueId() == false) goto L11;
        if (displayDeviceUniqueId == null) goto L11;
        DisplayState state = getDisplayState(displayDevice.getUniqueId(), true);
        if (state.setRefreshRate(refreshRate) == false) goto L10;
        setDirty();
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public float getUserPreferredRefreshRate(DisplayDevice device) {
        if (device != null) goto L5;
    L12:
        return Float.NaN;
    L5:
        if (device.hasStableUniqueId() == false) goto L12;
        DisplayState state = getDisplayState(device.getUniqueId(), false);
        if (state != null) goto L11;
        return Float.NaN;
    L11:
        return state.getRefreshRate();
    }

    public boolean setUserPreferredResolution(DisplayDevice displayDevice, int width, int height) {
        String displayDeviceUniqueId = displayDevice.getUniqueId();
        if (displayDevice.hasStableUniqueId() == false) goto L11;
        if (displayDeviceUniqueId == null) goto L11;
        DisplayState state = getDisplayState(displayDevice.getUniqueId(), true);
        if (state.setResolution(width, height) == false) goto L10;
        setDirty();
        return true;
    L10:
        return false;
    L11:
        return false;
    }

    public Point getUserPreferredResolution(DisplayDevice displayDevice) {
        if (displayDevice != null) goto L5;
    L12:
        return null;
    L5:
        if (displayDevice.hasStableUniqueId() == false) goto L12;
        DisplayState state = getDisplayState(displayDevice.getUniqueId(), false);
        if (state != null) goto L11;
        return null;
    L11:
        return state.getResolution();
    }

    public Point getStableDisplaySize() {
        loadIfNeeded();
        return StableDeviceValues.m3879$$Nest$mgetDisplaySize(this.mStableDeviceValues);
    }

    public void setStableDisplaySize(Point size) {
        loadIfNeeded();
        if (this.mStableDeviceValues.setDisplaySize(size) == false) goto L6;
        setDirty();
        return;
    }

    public void setBrightnessConfigurationForUser(BrightnessConfiguration c, int userSerial, String packageName) {
        loadIfNeeded();
        if (BrightnessConfigurations.m3878$$Nest$msetBrightnessConfigurationForUser(this.mGlobalBrightnessConfigurations, c, userSerial, packageName) == false) goto L6;
        setDirty();
        return;
    }

    public boolean setBrightnessConfigurationForDisplayLocked(BrightnessConfiguration configuration, DisplayDevice device, int userSerial, String packageName) {
        if (device != null) goto L5;
    L12:
        return false;
    L5:
        if (device.hasStableUniqueId() == false) goto L12;
        DisplayState state = getDisplayState(device.getUniqueId(), true);
        if (state.setBrightnessConfiguration(configuration, userSerial, packageName) == false) goto L11;
        setDirty();
        return true;
    L11:
        return false;
    }

    public BrightnessConfiguration getBrightnessConfigurationForDisplayLocked(String uniqueDisplayId, int userSerial) {
        loadIfNeeded();
        DisplayState state = this.mDisplayStates.get(uniqueDisplayId);
        if (state != null) goto L5;
        return null;
    L5:
        return state.getBrightnessConfiguration(userSerial);
    }

    public BrightnessConfiguration getBrightnessConfiguration(int userSerial) {
        loadIfNeeded();
        return this.mGlobalBrightnessConfigurations.getBrightnessConfiguration(userSerial);
    }

    private DisplayState getDisplayState(String uniqueId, boolean createIfAbsent) {
        loadIfNeeded();
        DisplayState state = this.mDisplayStates.get(uniqueId);
        if (state != null) goto L7;
        if (createIfAbsent == false) goto L8;
        DisplayState state2 = new DisplayState(null);
        this.mDisplayStates.put(uniqueId, state2);
        setDirty();
        return state2;
    L8:
        return state;
    L7:
        return state;
    }

    public void loadIfNeeded() {
        if (this.mLoaded == true) goto L6;
        load();
        this.mLoaded = true;
        return;
    }

    void setDirty() {
        this.mDirty = true;
    }

    private void clearState() {
        this.mRememberedWifiDisplays.clear();
    }

    private void load() {
        Object r0 = this.mFileAccessLock;
        monitor-enter(r0);
        clearState();     // Catch: Throwable -> L9
        InputStream is = this.mInjector.openRead();     // Catch: Throwable -> L9 FileNotFoundException -> L28
        goto L30
    L37:
        TypedXmlPullParser parser = Xml.resolvePullParser(is);     // Catch: Throwable -> L11 XmlPullParserException -> L13 IOException -> L15
        loadFromXml(parser);     // Catch: Throwable -> L11 XmlPullParserException -> L13 IOException -> L15
        IoUtils.closeQuietly(is);     // Catch: Throwable -> L9
    L24:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L15:
        ex = move-exception;
        Slog.w(TAG, "Failed to load display manager persistent store data.", ex);     // Catch: Throwable -> L11
        clearState();     // Catch: Throwable -> L11
        IoUtils.closeQuietly(is);     // Catch: Throwable -> L9
    L13:
        ex = move-exception;
        Slog.w(TAG, "Failed to load display manager persistent store data.", ex);     // Catch: Throwable -> L11
        clearState();     // Catch: Throwable -> L11
        IoUtils.closeQuietly(is);     // Catch: Throwable -> L9
    L11:
        th = move-exception;
        IoUtils.closeQuietly(is);     // Catch: Throwable -> L9
        throw th;     // Catch: Throwable -> L9
    L30:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private void save() {
        final ByteArrayOutputStream os = new ByteArrayOutputStream();     // Catch: IOException -> L4
        TypedXmlSerializer serializer = Xml.resolveSerializer(os);     // Catch: IOException -> L4
        saveToXml(serializer);     // Catch: IOException -> L4
        serializer.flush();     // Catch: IOException -> L4
        this.mHandler.removeCallbacksAndMessages(null);     // Catch: IOException -> L4
        this.mHandler.post(new PersistentDataStore$$ExternalSyntheticLambda0(this, os));     // Catch: IOException -> L4
        return;
    L4:
        ex = move-exception;
        Slog.w(TAG, "Failed to process the XML serializer.", ex);
    }

    private /* synthetic */ void lambda$save$0(ByteArrayOutputStream os) {
        Object r0 = this.mFileAccessLock;
        monitor-enter(r0);
        OutputStream fileOutput = null;
        fileOutput = this.mInjector.startWrite();     // Catch: Throwable -> L11 IOException -> L13
        os.writeTo(fileOutput);     // Catch: Throwable -> L11 IOException -> L13
        fileOutput.flush();     // Catch: Throwable -> L11 IOException -> L13
        Injector r3 = this.mInjector;     // Catch: Throwable -> L9
    L7:
        r3.finishWrite(fileOutput, true);     // Catch: Throwable -> L9
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return;
    L13:
        ex = move-exception;
        Slog.w(TAG, "Failed to save display manager persistent store data.", ex);     // Catch: Throwable -> L11
        if (fileOutput == null) goto L17;
        r3 = this.mInjector;     // Catch: Throwable -> L9
    L11:
        th = move-exception;
        if (fileOutput == null) goto L22;
        this.mInjector.finishWrite(fileOutput, true);     // Catch: Throwable -> L9
    L22:
        throw th;     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    }

    private void loadFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        XmlUtils.beginDocument(parser, TAG_DISPLAY_MANAGER_STATE);
        int outerDepth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L21;
        if (parser.getName().equals(TAG_REMEMBERED_WIFI_DISPLAYS) == false) goto L9;
        loadRememberedWifiDisplaysFromXml(parser);
    L9:
        if (parser.getName().equals(TAG_DISPLAY_STATES) == false) goto L12;
        loadDisplaysFromXml(parser);
    L12:
        if (parser.getName().equals(TAG_STABLE_DEVICE_VALUES) == false) goto L15;
        this.mStableDeviceValues.loadFromXml(parser);
    L15:
        if (parser.getName().equals(TAG_BRIGHTNESS_CONFIGURATIONS) == false) goto L18;
        this.mGlobalBrightnessConfigurations.loadFromXml(parser);
    L18:
        if (parser.getName().equals(TAG_BRIGHTNESS_NITS_FOR_DEFAULT_DISPLAY) == false) goto L20;
        String value = parser.nextText();
        this.mBrightnessNitsForDefaultDisplay = Float.parseFloat(value);
    L20:
        getExt().loadFromXml(parser);
        goto L4
    }

    private void loadRememberedWifiDisplaysFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        int outerDepth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L17;
        if (parser.getName().equals(TAG_WIFI_DISPLAY) == false) goto L4;
        String deviceAddress = parser.getAttributeValue(null, ATTR_DEVICE_ADDRESS);
        String deviceName = parser.getAttributeValue(null, ATTR_DEVICE_NAME);
        String deviceAlias = parser.getAttributeValue(null, ATTR_DEVICE_ALIAS);
        if (deviceAddress == null) goto L16;
        if (deviceName == null) goto L16;
        if (findRememberedWifiDisplay(deviceAddress) >= 0) goto L14;
        this.mRememberedWifiDisplays.add(new WifiDisplay(deviceAddress, deviceName, deviceAlias, false, false, false));
        goto L4
    L14:
        throw new XmlPullParserException("Found duplicate wifi display device address.");
    L16:
        throw new XmlPullParserException("Missing deviceAddress or deviceName attribute on wifi-display.");
    }

    private void loadDisplaysFromXml(TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        int outerDepth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L16;
        if (parser.getName().equals(TAG_DISPLAY) == false) goto L4;
        PersistentDataStoreIA r2 = null;
        String uniqueId = parser.getAttributeValue(null, ATTR_UNIQUE_ID);
        if (uniqueId == null) goto L15;
        if (this.mDisplayStates.containsKey(uniqueId) == true) goto L13;
        DisplayState state = new DisplayState(r2);
        state.loadFromXml(parser);
        this.mDisplayStates.put(uniqueId, state);
        goto L4
    L13:
        throw new XmlPullParserException("Found duplicate display.");
    L15:
        throw new XmlPullParserException("Missing unique-id attribute on display.");
    }

    private void saveToXml(TypedXmlSerializer serializer) throws IOException {
        serializer.startDocument(null, true);
        serializer.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
        serializer.startTag(null, TAG_DISPLAY_MANAGER_STATE);
        serializer.startTag(null, TAG_REMEMBERED_WIFI_DISPLAYS);
        Iterator<WifiDisplay> r3 = this.mRememberedWifiDisplays.iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        WifiDisplay display = r3.next();
        serializer.startTag(null, TAG_WIFI_DISPLAY);
        serializer.attribute(null, ATTR_DEVICE_ADDRESS, display.getDeviceAddress());
        serializer.attribute(null, ATTR_DEVICE_NAME, display.getDeviceName());
        if (display.getDeviceAlias() == null) goto L8;
        serializer.attribute(null, ATTR_DEVICE_ALIAS, display.getDeviceAlias());
    L8:
        serializer.endTag(null, TAG_WIFI_DISPLAY);
        goto L4
    L9:
        serializer.endTag(null, TAG_REMEMBERED_WIFI_DISPLAYS);
        serializer.startTag(null, TAG_DISPLAY_STATES);
        Iterator<Map.Entry<String, DisplayState>> r4 = this.mDisplayStates.entrySet().iterator();
    L11:
        if (r4.hasNext() == false) goto L13;
        Map.Entry<String, DisplayState> entry = r4.next();
        String uniqueId = entry.getKey();
        DisplayState state = entry.getValue();
        serializer.startTag(null, TAG_DISPLAY);
        serializer.attribute(null, ATTR_UNIQUE_ID, uniqueId);
        state.saveToXml(serializer);
        serializer.endTag(null, TAG_DISPLAY);
        goto L11
    L13:
        serializer.endTag(null, TAG_DISPLAY_STATES);
        serializer.startTag(null, TAG_STABLE_DEVICE_VALUES);
        this.mStableDeviceValues.saveToXml(serializer);
        serializer.endTag(null, TAG_STABLE_DEVICE_VALUES);
        serializer.startTag(null, TAG_BRIGHTNESS_CONFIGURATIONS);
        this.mGlobalBrightnessConfigurations.saveToXml(serializer);
        serializer.endTag(null, TAG_BRIGHTNESS_CONFIGURATIONS);
        serializer.startTag(null, TAG_BRIGHTNESS_NITS_FOR_DEFAULT_DISPLAY);
        serializer.text(Float.toString(this.mBrightnessNitsForDefaultDisplay));
        serializer.endTag(null, TAG_BRIGHTNESS_NITS_FOR_DEFAULT_DISPLAY);
        getExt().saveToXml(serializer);
        serializer.endTag(null, TAG_DISPLAY_MANAGER_STATE);
        serializer.endDocument();
    }

    public void dump(PrintWriter pw) {
        pw.println("PersistentDataStore:");
        pw.println("--------------------");
        pw.println("  mLoaded=" + this.mLoaded);
        pw.println("  mDirty=" + this.mDirty);
        pw.println("  RememberedWifiDisplays:");
        int i = 0;
        Iterator<WifiDisplay> r1 = this.mRememberedWifiDisplays.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        WifiDisplay display = r1.next();
        StringBuilder r5 = new StringBuilder();
        r5.append("    ");
        r5.append(i);
        r5.append(": ");
        r5.append(display);
        pw.println(r5.toString());
        i = i + 1;
        goto L4
    L6:
        pw.println("  DisplayStates:");
        int i2 = 0;
        Iterator<Map.Entry<String, DisplayState>> r2 = this.mDisplayStates.entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L10;
        Map.Entry<String, DisplayState> entry = r2.next();
        StringBuilder r6 = new StringBuilder();
        r6.append("    ");
        r6.append(i2);
        r6.append(": ");
        r6.append(entry.getKey());
        pw.println(r6.toString());
        entry.getValue().dump(pw, "      ");
        i2 = i2 + 1;
        goto L8
    L10:
        pw.println("  StableDeviceValues:");
        this.mStableDeviceValues.dump(pw, "      ");
        pw.println("  GlobalBrightnessConfigurations:");
        this.mGlobalBrightnessConfigurations.dump(pw, "      ");
        pw.println("  mBrightnessNitsForDefaultDisplay=" + this.mBrightnessNitsForDefaultDisplay);
    }

    public IExtPersistentDataStore getExt() {
        return this.mExt;
    }
}
