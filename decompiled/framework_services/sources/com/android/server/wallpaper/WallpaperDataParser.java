package com.android.server.wallpaper;

import android.R;
import android.app.WallpaperColors;
import android.app.wallpaper.WallpaperDescription;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.FileUtils;
import android.util.Pair;
import android.util.Slog;
import android.util.SparseArray;
import android.util.Xml;
import com.android.internal.util.JournaledFile;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.am.HostingRecord;
import com.android.server.pm.PackageManagerService;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import libcore.io.IoUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
public class WallpaperDataParser {
    private static final boolean DEBUG = false;
    private static final String TAG = null;
    private final Context mContext;
    private final ComponentName mImageWallpaper;
    private final WallpaperCropper mWallpaperCropper;
    private final WallpaperDisplayHelper mWallpaperDisplayHelper;

    static class WallpaperLoadingResult {
        private final WallpaperData mLockWallpaperData;
        private final boolean mSuccess;
        private final WallpaperData mSystemWallpaperData;

        /* synthetic */ WallpaperLoadingResult(WallpaperData r1, WallpaperData r2, boolean r3, WallpaperDataParserIA r4) {
            this(r1, r2, r3);
        }

        private WallpaperLoadingResult(WallpaperData systemWallpaperData, WallpaperData lockWallpaperData, boolean success) {
            this.mSystemWallpaperData = systemWallpaperData;
            this.mLockWallpaperData = lockWallpaperData;
            this.mSuccess = success;
        }

        public WallpaperData getSystemWallpaperData() {
            return this.mSystemWallpaperData;
        }

        public WallpaperData getLockWallpaperData() {
            return this.mLockWallpaperData;
        }

        public boolean success() {
            return this.mSuccess;
        }
    }

    static {
        TAG = WallpaperDataParser.class.getSimpleName();
    }

    WallpaperDataParser(Context context, WallpaperDisplayHelper wallpaperDisplayHelper, WallpaperCropper wallpaperCropper) {
        this.mContext = context;
        this.mWallpaperDisplayHelper = wallpaperDisplayHelper;
        this.mWallpaperCropper = wallpaperCropper;
        this.mImageWallpaper = ComponentName.unflattenFromString(context.getResources().getString(R.string.keyguard_accessibility_pattern_area));
    }

    private JournaledFile makeJournaledFile(int userId) {
        String base = new File(WallpaperUtils.getWallpaperDir(userId), "wallpaper_info.xml").getAbsolutePath();
        return new JournaledFile(new File(base), new File(base + ".tmp"));
    }

    public WallpaperLoadingResult loadSettingsLocked(int userId, boolean keepDimensionHints, boolean migrateFromOld, int which) {
        JournaledFile journal = makeJournaledFile(userId);
        FileInputStream stream = null;
        File file = journal.chooseForRead();
        int r12 = 1;
        if ((which & 1) == 0) goto L5;
        boolean loadSystem = true;
    L7:
        if ((which & 2) == 0) goto L9;
        boolean loadLock = true;
    L10:
        WallpaperData lockWallpaper = null;
        if (loadSystem == false) goto L21;
        if (migrateFromOld == false) goto L14;
        migrateFromOld();
    L14:
        int r4 = userId;
        WallpaperData wallpaper = new WallpaperData(r4, 1);
        wallpaper.allowBackup = true;
        if (wallpaper.cropExists() == false) goto L17;
    L20:
        WallpaperData wallpaper2 = wallpaper;
    L22:
        WallpaperDisplayHelper.DisplayData wpdData = this.mWallpaperDisplayHelper.getDisplayDataOrCreate(0);
        boolean success = false;
        FileInputStream stream2 = new FileInputStream(file);     // Catch: Throwable -> L31 FileNotFoundException -> L33
        TypedXmlPullParser parser = Xml.resolvePullParser(stream2);     // Catch: Throwable -> L27 FileNotFoundException -> L29
        lockWallpaper = loadSettingsFromSerializer(parser, wallpaper2, r4, loadSystem, loadLock, keepDimensionHints, wpdData);     // Catch: Throwable -> L27 FileNotFoundException -> L29
        success = true;
    L37:
        IoUtils.closeQuietly(stream2);
        this.mWallpaperDisplayHelper.ensureSaneWallpaperDisplaySize(wpdData, 0);
        if (loadSystem == false) goto L49;
        if (success == true) goto L42;
        wallpaper2.cropHint.set(0, 0, 0, 0);
        wpdData.mPadding.set(0, 0, 0, 0);
        wallpaper2.name = "";
    L44:
        ensureSaneWallpaperData(wallpaper2);
        if (lockWallpaper != null) goto L48;
        r12 = 3;
    L48:
        wallpaper2.mWhich = r12;
        goto L49
    L42:
        if (wallpaper2.wallpaperId > 0) goto L44;
        wallpaper2.wallpaperId = WallpaperUtils.makeWallpaperIdLocked();
    L49:
        if (loadLock == false) goto L55;
        if (success == true) goto L52;
        lockWallpaper = null;
    L52:
        if (lockWallpaper == null) goto L55;
        ensureSaneWallpaperData(lockWallpaper);
        lockWallpaper.mWhich = 2;
    L55:
        return new WallpaperLoadingResult(wallpaper2, lockWallpaper, success, null);
    L27:
        e = e;
        stream = stream2;
    L35:
        Slog.w(TAG, "failed parsing " + file + " " + e);
        stream2 = stream;
    L30:
        stream = stream2;
        goto L36
    L31:
        e = e;
    L36:
        Slog.w(TAG, "no current wallpaper -- first boot?");
        stream2 = stream;
        goto L37
    L17:
        if (wallpaper.sourceExists() == false) goto L19;
        this.mWallpaperCropper.generateCrop(wallpaper);
        goto L20
    L19:
        Slog.i(TAG, "No static wallpaper imagery; defaults will be shown");
        goto L20
    L21:
        r4 = userId;
        wallpaper2 = null;
        goto L22
    L9:
        loadLock = false;
        goto L10
    L5:
        loadSystem = false;
        goto L7
    }

    WallpaperData loadSettingsFromSerializer(TypedXmlPullParser parser, WallpaperData wallpaper, int userId, boolean loadSystem, boolean loadLock, boolean keepDimensionHints, WallpaperDisplayHelper.DisplayData wpdData) throws IOException, XmlPullParserException {
        WallpaperData lockWallpaper = null;
    L3:
        int type = parser.next();
        if (type != 2) goto L20;
        String tag = parser.getName();
        if ("wp".equals(tag) == false) goto L9;
        if (loadSystem == false) goto L9;
    L12:
        if ("kwp".equals(tag) == false) goto L15;
        lockWallpaper = new WallpaperData(userId, 2);
    L15:
        if ("wp".equals(tag) == false) goto L17;
        WallpaperData wallpaperToParse = wallpaper;
    L18:
        parseComponentName(parser);
        parseWallpaperAttributes(parser, wallpaperToParse, keepDimensionHints);
        goto L20
    L17:
        wallpaperToParse = lockWallpaper;
    L9:
        if ("kwp".equals(tag) == false) goto L20;
        if (loadLock == true) goto L12;
    L20:
        if (type != 1) goto L3;
        return lockWallpaper;
    }

    private ComponentName parseComponentName(TypedXmlPullParser parser) {
        ComponentName c = null;
        String comp = parser.getAttributeValue(null, "component");
        if (comp == null) goto L5;
        c = ComponentName.unflattenFromString(comp);
    L5:
        if (c != null) goto L7;
    L8:
        ComponentName c2 = this.mImageWallpaper;
        return c2;
    L7:
        if (PackageManagerService.PLATFORM_PACKAGE_NAME.equals(c.getPackageName()) == true) goto L8;
        return c;
    }

    private void ensureSaneWallpaperData(WallpaperData wallpaper) {
        if (wallpaper.cropHint.width() >= 0) goto L5;
    L6:
        wallpaper.cropHint.set(0, 0, 0, 0);
        return;
    L5:
        if (wallpaper.cropHint.height() < 0) goto L6;
    }

    private void migrateFromOld() {
        File preNWallpaper = new File(WallpaperUtils.getWallpaperDir(0), "wallpaper");
        File originalWallpaper = new File("/data/data/com.android.settings/files/wallpaper");
        File newWallpaper = new File(WallpaperUtils.getWallpaperDir(0), "wallpaper_orig");
        if (preNWallpaper.exists() == false) goto L8;
        if (newWallpaper.exists() == true) goto L14;
        FileUtils.copyFile(preNWallpaper, newWallpaper);
        return;
    L14:
        return;
    L8:
        if (originalWallpaper.exists() == false) goto L16;
        File oldInfo = new File("/data/system/wallpaper_info.xml");
        if (oldInfo.exists() == false) goto L12;
        File newInfo = new File(WallpaperUtils.getWallpaperDir(0), "wallpaper_info.xml");
        oldInfo.renameTo(newInfo);
    L12:
        FileUtils.copyFile(originalWallpaper, preNWallpaper);
        originalWallpaper.renameTo(newWallpaper);
        return;
    }

    void parseWallpaperDescription(TypedXmlPullParser parser, WallpaperData wallpaper) throws XmlPullParserException, IOException {
        int type = parser.next();
        if (type == 2) goto L5;
        return;
    L5:
        if ("description".equals(parser.getName()) == false) goto L12;
        WallpaperDescription description = WallpaperDescription.restoreFromXml(parser);
        if (description.getComponent() != null) goto L9;
        description = description.toBuilder().setComponent(parseComponentName(parser)).build();
    L9:
        wallpaper.setDescription(description);
        return;
    }

    void parseWallpaperAttributes(TypedXmlPullParser parser, WallpaperData wallpaper, boolean keepDimensionHints) throws XmlPullParserException, IOException {
        int id = parser.getAttributeInt(null, "id", -1);
        if (id == (-1)) goto L7;
        wallpaper.wallpaperId = id;
        if (id <= WallpaperUtils.getCurrentWallpaperId()) goto L8;
        WallpaperUtils.setCurrentWallpaperId(id);
    L8:
        String r5 = "cropLeft";
        String r9 = "cropTop";
        String r11 = "cropRight";
        Rect legacyCropHint = new Rect(getAttributeInt(parser, "cropLeft", 0), getAttributeInt(parser, "cropTop", 0), getAttributeInt(parser, "cropRight", 0), getAttributeInt(parser, "cropBottom", 0));
        Rect totalCropHint = new Rect(getAttributeInt(parser, "totalCropLeft", 0), getAttributeInt(parser, "totalCropTop", 0), getAttributeInt(parser, "totalCropRight", 0), getAttributeInt(parser, "totalCropBottom", 0));
        ComponentName componentName = parseComponentName(parser);
        if (this.mImageWallpaper.equals(componentName) == false) goto L32;
        wallpaper.mCropHints = new SparseArray();
        Iterator<Pair<Integer, String>> r0 = screenDimensionPairs().iterator();
    L12:
        if (r0.hasNext() == false) goto L23;
        Pair<Integer, String> pair = r0.next();
        String r16 = r5;
        int id2 = id;
        String r18 = r9;
        String r19 = r11;
        Rect cropHint = new Rect(parser.getAttributeInt(null, r5 + ((String) pair.second), 0), parser.getAttributeInt(null, r9 + ((String) pair.second), 0), parser.getAttributeInt(null, r11 + ((String) pair.second), 0), parser.getAttributeInt(null, "cropBottom" + ((String) pair.second), 0));
        if (cropHint.isEmpty() == true) goto L17;
        wallpaper.mCropHints.put(((Integer) pair.first).intValue(), cropHint);
    L17:
        if (cropHint.isEmpty() == true) goto L21;
        if (cropHint.equals(legacyCropHint) == false) goto L21;
        wallpaper.mOrientationWhenSet = ((Integer) pair.first).intValue();
    L21:
        r5 = r16;
        id = id2;
        r9 = r18;
        r11 = r19;
        goto L12
    L23:
        if (wallpaper.mCropHints.size() == 0) goto L25;
    L29:
        wallpaper.cropHint.set(totalCropHint);
    L30:
        wallpaper.mSampleSize = parser.getAttributeFloat(null, "sampleSize", 1.0f);
        goto L32
    L25:
        if (totalCropHint.isEmpty() == false) goto L29;
        if (legacyCropHint.isEmpty() == true) goto L30;
        wallpaper.cropHint.set(legacyCropHint);
    L32:
        this.mWallpaperDisplayHelper.getDisplayDataOrCreate(0);
        wallpaper.mWallpaperDimAmount = getAttributeFloat(parser, "dimAmount", 0.0f);
        WallpaperData.BindSource bindSource = (WallpaperData.BindSource) Enum.valueOf(WallpaperData.BindSource.class, getAttributeString(parser, "bindSource", WallpaperData.BindSource.UNKNOWN.name()));     // Catch: Throwable -> L35
    L37:
        wallpaper.mBindSource = bindSource;
        int dimAmountsCount = getAttributeInt(parser, "dimAmountsCount", 0);
        if (dimAmountsCount <= 0) goto L43;
        SparseArray<Float> allDimAmounts = new SparseArray(dimAmountsCount);
        int i = 0;
    L40:
        if (i >= dimAmountsCount) goto L42;
        int uid = getAttributeInt(parser, "dimUID" + i, 0);
        float dimValue = getAttributeFloat(parser, "dimValue" + i, 0.0f);
        allDimAmounts.put(uid, Float.valueOf(dimValue));
        i = i + 1;
        goto L40
    L42:
        wallpaper.mUidToDimAmount = allDimAmounts;
    L43:
        int colorsCount = getAttributeInt(parser, "colorsCount", 0);
        int allColorsCount = getAttributeInt(parser, "allColorsCount", 0);
        if (allColorsCount <= 0) goto L51;
        Map<Integer, Integer> allColors = new HashMap(allColorsCount);
        int i2 = 0;
    L46:
        if (i2 >= allColorsCount) goto L48;
        int colorInt = getAttributeInt(parser, "allColorsValue" + i2, 0);
        StringBuilder r15 = new StringBuilder();
        WallpaperData.BindSource bindSource2 = bindSource;
        r15.append("allColorsPopulation");
        r15.append(i2);
        int population = getAttributeInt(parser, r15.toString(), 0);
        allColors.put(Integer.valueOf(colorInt), Integer.valueOf(population));
        i2 = i2 + 1;
        bindSource = bindSource2;
        goto L46
    L48:
        int colorHints = getAttributeInt(parser, "colorHints", 0);
        wallpaper.primaryColors = new WallpaperColors(allColors, colorHints);
    L65:
        wallpaper.name = parser.getAttributeValue(null, "name");
        wallpaper.allowBackup = parser.getAttributeBoolean(null, HostingRecord.HOSTING_TYPE_BACKUP, false);
        parseWallpaperDescription(parser, wallpaper);
        if (wallpaper.getDescription().getComponent() != null) goto L82;
        wallpaper.setDescription(new WallpaperDescription.Builder().setComponent(componentName).build());
        return;
    L82:
        return;
    L51:
        if (colorsCount <= 0) goto L65;
        Color primary = null;
        Color secondary = null;
        Color tertiary = null;
        int i3 = 0;
    L53:
        if (i3 >= colorsCount) goto L64;
        Color color = Color.valueOf(getAttributeInt(parser, "colorValue" + i3, 0));
        if (i3 != 0) goto L58;
        primary = color;
    L63:
        i3 = i3 + 1;
        goto L53
    L58:
        if (i3 != 1) goto L61;
        secondary = color;
        goto L63
    L61:
        if (i3 != 2) goto L64;
        tertiary = color;
    L64:
        int colorHints2 = getAttributeInt(parser, "colorHints", 0);
        wallpaper.primaryColors = new WallpaperColors(primary, secondary, tertiary, colorHints2);
    L36:
        bindSource = WallpaperData.BindSource.UNKNOWN;
        goto L37
    L7:
        wallpaper.wallpaperId = WallpaperUtils.makeWallpaperIdLocked();
        goto L8
    }

    private static int getAttributeInt(TypedXmlPullParser parser, String name, int defValue) {
        return parser.getAttributeInt(null, name, defValue);
    }

    private static float getAttributeFloat(TypedXmlPullParser parser, String name, float defValue) {
        return parser.getAttributeFloat(null, name, defValue);
    }

    private String getAttributeString(XmlPullParser parser, String name, String defValue) {
        String s = parser.getAttributeValue(null, name);
        if (s == null) goto L6;
        return s;
    L6:
        return defValue;
    }

    void saveSettingsLocked(int userId, WallpaperData wallpaper, WallpaperData lockWallpaper) {
        JournaledFile journal = makeJournaledFile(userId);
        FileOutputStream fstream = null;
        fstream = new FileOutputStream(journal.chooseForWrite(), false);     // Catch: IOException -> L5
        TypedXmlSerializer out = Xml.resolveSerializer(fstream);     // Catch: IOException -> L5
        saveSettingsToSerializer(out, wallpaper, lockWallpaper);     // Catch: IOException -> L5
        fstream.flush();     // Catch: IOException -> L5
        FileUtils.sync(fstream);     // Catch: IOException -> L5
        fstream.close();     // Catch: IOException -> L5
        journal.commit();     // Catch: IOException -> L5
        return;
    L6:
        IoUtils.closeQuietly(fstream);
        journal.rollback();
    }

    void saveSettingsToSerializer(TypedXmlSerializer out, WallpaperData wallpaper, WallpaperData lockWallpaper) throws IOException {
        out.startDocument(null, true);
        if (wallpaper == null) goto L5;
        writeWallpaperAttributes(out, "wp", wallpaper);
    L5:
        if (lockWallpaper == null) goto L7;
        writeWallpaperAttributes(out, "kwp", lockWallpaper);
    L7:
        out.endDocument();
    }

    void writeWallpaperAttributes(TypedXmlSerializer out, String tag, WallpaperData wallpaper) throws IllegalArgumentException, IllegalStateException, IOException {
        out.startTag(null, tag);
        out.attributeInt(null, "id", wallpaper.wallpaperId);
        if (this.mImageWallpaper.equals(wallpaper.getComponent()) == true) goto L5;
    L25:
        out.attributeFloat(null, "dimAmount", wallpaper.mWallpaperDimAmount);
        out.attribute(null, "bindSource", wallpaper.mBindSource.name());
        int dimAmountsCount = wallpaper.mUidToDimAmount.size();
        out.attributeInt(null, "dimAmountsCount", dimAmountsCount);
        if (dimAmountsCount <= 0) goto L32;
        int index = 0;
        int i = 0;
    L29:
        if (i >= wallpaper.mUidToDimAmount.size()) goto L32;
        out.attributeInt(null, "dimUID" + index, wallpaper.mUidToDimAmount.keyAt(i));
        out.attributeFloat(null, "dimValue" + index, wallpaper.mUidToDimAmount.valueAt(i).floatValue());
        index = index + 1;
        i = i + 1;
    L32:
        if (wallpaper.primaryColors == null) goto L45;
        int colorsCount = wallpaper.primaryColors.getMainColors().size();
        out.attributeInt(null, "colorsCount", colorsCount);
        if (colorsCount <= 0) goto L38;
        int i2 = 0;
    L36:
        if (i2 >= colorsCount) goto L38;
        Color wc = (Color) wallpaper.primaryColors.getMainColors().get(i2);
        out.attributeInt(null, "colorValue" + i2, wc.toArgb());
        i2 = i2 + 1;
    L38:
        int allColorsCount = wallpaper.primaryColors.getAllColors().size();
        out.attributeInt(null, "allColorsCount", allColorsCount);
        if (allColorsCount <= 0) goto L44;
        int index2 = 0;
        Iterator r5 = wallpaper.primaryColors.getAllColors().entrySet().iterator();
    L42:
        if (r5.hasNext() == false) goto L44;
        Map.Entry<Integer, Integer> entry = (Map.Entry) r5.next();
        out.attributeInt(null, "allColorsValue" + index2, entry.getKey().intValue());
        out.attributeInt(null, "allColorsPopulation" + index2, entry.getValue().intValue());
        index2 = index2 + 1;
    L44:
        out.attributeInt(null, "colorHints", wallpaper.primaryColors.getColorHints());
    L45:
        out.attribute(null, "name", wallpaper.name);
        if (wallpaper.getComponent() == null) goto L51;
        if (wallpaper.getComponent().equals(this.mImageWallpaper) == true) goto L51;
        out.attribute(null, "component", wallpaper.getComponent().flattenToShortString());
    L51:
        if (wallpaper.allowBackup == false) goto L53;
        out.attributeBoolean(null, HostingRecord.HOSTING_TYPE_BACKUP, true);
    L53:
        writeWallpaperDescription(out, wallpaper);
        out.endTag(null, tag);
        return;
    L5:
        if (wallpaper.mCropHints != null) goto L7;
        Slog.e(TAG, "cropHints should not be null when saved");
        wallpaper.mCropHints = new SparseArray();
    L7:
        Rect rectToPutInLegacyCrop = new Rect(wallpaper.cropHint);
        Iterator<Pair<Integer, String>> r2 = screenDimensionPairs().iterator();
    L9:
        if (r2.hasNext() == false) goto L22;
        Pair<Integer, String> pair = r2.next();
        Rect cropHint = wallpaper.mCropHints.get(((Integer) pair.first).intValue());
        if (cropHint == null) goto L9;
        out.attributeInt(null, "cropLeft" + ((String) pair.second), cropHint.left);
        out.attributeInt(null, "cropTop" + ((String) pair.second), cropHint.top);
        out.attributeInt(null, "cropRight" + ((String) pair.second), cropHint.right);
        out.attributeInt(null, "cropBottom" + ((String) pair.second), cropHint.bottom);
        int orientationToPutInLegacyCrop = wallpaper.mOrientationWhenSet;
        WallpaperDefaultDisplayInfo defaultDisplayInfo = this.mWallpaperDisplayHelper.getDefaultDisplayInfo();
        if (defaultDisplayInfo.isFoldable == false) goto L19;
        int unfoldedOrientation = defaultDisplayInfo.getUnfoldedOrientation(orientationToPutInLegacyCrop);
        if (unfoldedOrientation == (-1)) goto L19;
        orientationToPutInLegacyCrop = unfoldedOrientation;
    L19:
        if (((Integer) pair.first).intValue() != orientationToPutInLegacyCrop) goto L9;
        rectToPutInLegacyCrop.set(cropHint);
        goto L9
    L22:
        out.attributeInt(null, "cropLeft", rectToPutInLegacyCrop.left);
        out.attributeInt(null, "cropTop", rectToPutInLegacyCrop.top);
        out.attributeInt(null, "cropRight", rectToPutInLegacyCrop.right);
        out.attributeInt(null, "cropBottom", rectToPutInLegacyCrop.bottom);
        out.attributeInt(null, "totalCropLeft", wallpaper.cropHint.left);
        out.attributeInt(null, "totalCropTop", wallpaper.cropHint.top);
        out.attributeInt(null, "totalCropRight", wallpaper.cropHint.right);
        out.attributeInt(null, "totalCropBottom", wallpaper.cropHint.bottom);
        out.attributeFloat(null, "sampleSize", wallpaper.mSampleSize);
        goto L25
    }

    void writeWallpaperDescription(TypedXmlSerializer out, WallpaperData wallpaper) throws IOException {
        WallpaperDescription description = wallpaper.getDescription();
        if (description == null) goto L13;
        out.startTag(null, "description");
        description.saveToXml(out);     // Catch: XmlPullParserException -> L7
    L9:
        out.endTag(null, "description");
        return;
    L7:
        e = move-exception;
        Slog.e(TAG, "Error writing wallpaper description", e);
        goto L9
    }

    boolean restoreNamedResourceLocked(WallpaperData wallpaper) {
        if (wallpaper.name.length() <= 4) goto L94;
        if ("res:".equals(wallpaper.name.substring(0, 4)) == false) goto L94;
        String resName = wallpaper.name.substring(4);
        int colon = resName.indexOf(58);
        if (colon <= 0) goto L9;
        String pkg = resName.substring(0, colon);
        String pkg2 = pkg;
    L10:
        int slash = resName.lastIndexOf(47);
        if (slash <= 0) goto L13;
        String ident = resName.substring(slash + 1);
        String ident2 = ident;
    L15:
        if (colon <= 0) goto L20;
        if (slash <= 0) goto L20;
        if ((slash - colon) <= 1) goto L20;
        String type = resName.substring(colon + 1, slash);
        String type2 = type;
    L21:
        if (pkg2 == null) goto L101;
        if (ident2 == null) goto L101;
        if (type2 == null) goto L101;
        int resId = -1;
        Context c = this.mContext.createPackageContext(pkg2, 4);     // Catch: Throwable -> L38 IOException -> L40 Resources.NotFoundException -> L42 PackageManager.NameNotFoundException -> L44
        Resources r = c.getResources();     // Catch: Throwable -> L38 IOException -> L40 Resources.NotFoundException -> L42 PackageManager.NameNotFoundException -> L44
        resId = r.getIdentifier(resName, null, null);     // Catch: Throwable -> L38 IOException -> L40 Resources.NotFoundException -> L42 PackageManager.NameNotFoundException -> L44
        if (resId == 0) goto L97;
        int r17 = 0;
        InputStream res = r.openRawResource(resId);     // Catch: Throwable -> L38 IOException -> L40 Resources.NotFoundException -> L42 PackageManager.NameNotFoundException -> L44
        if (wallpaper.getWallpaperFile().exists() == false) goto L56;
        wallpaper.getWallpaperFile().delete();     // Catch: Throwable -> L38 IOException -> L40 Resources.NotFoundException -> L42 PackageManager.NameNotFoundException -> L44
        wallpaper.getCropFile().delete();     // Catch: Throwable -> L38 IOException -> L40 Resources.NotFoundException -> L42 PackageManager.NameNotFoundException -> L44
    L56:
        FileOutputStream fos = new FileOutputStream(wallpaper.getWallpaperFile());     // Catch: Throwable -> L38 IOException -> L40 Resources.NotFoundException -> L42 PackageManager.NameNotFoundException -> L44
        FileOutputStream cos = new FileOutputStream(wallpaper.getCropFile());     // Catch: Throwable -> L38 IOException -> L40 Resources.NotFoundException -> L42 PackageManager.NameNotFoundException -> L44
        byte[] buffer = new byte[32768];     // Catch: Throwable -> L38 IOException -> L40 Resources.NotFoundException -> L42 PackageManager.NameNotFoundException -> L44
    L57:
        int amt = res.read(buffer);     // Catch: Throwable -> L38 IOException -> L40 Resources.NotFoundException -> L42 PackageManager.NameNotFoundException -> L44
        if (amt <= 0) goto L60;
        int r2 = r17;
        fos.write(buffer, r2, amt);     // Catch: Throwable -> L38 IOException -> L40 Resources.NotFoundException -> L42 PackageManager.NameNotFoundException -> L44
        cos.write(buffer, r2, amt);     // Catch: Throwable -> L38 IOException -> L40 Resources.NotFoundException -> L42 PackageManager.NameNotFoundException -> L44
        r17 = 0;
        goto L57
    L60:
        Slog.v(TAG, "Restored wallpaper: " + resName);     // Catch: Throwable -> L38 IOException -> L40 Resources.NotFoundException -> L42 PackageManager.NameNotFoundException -> L44
        IoUtils.closeQuietly(res);
        FileUtils.sync(fos);
        FileUtils.sync(cos);
        IoUtils.closeQuietly(fos);
        IoUtils.closeQuietly(cos);
        return true;
    L97:
    L30:
        Slog.e(TAG, "couldn't resolve identifier pkg=" + pkg2 + " type=" + type2 + " ident=" + ident2);     // Catch: Throwable -> L38 IOException -> L40 Resources.NotFoundException -> L42 PackageManager.NameNotFoundException -> L44
        IoUtils.closeQuietly(null);
        if (0 == 0) goto L34;
        FileUtils.sync(null);
    L34:
        if (0 == 0) goto L36;
        FileUtils.sync(null);
    L36:
        IoUtils.closeQuietly(null);
        IoUtils.closeQuietly(null);
        return false;
    L46:
        e = e;
    L64:
        Slog.e(TAG, "IOException while restoring wallpaper ", e);     // Catch: Throwable -> L38
        IoUtils.closeQuietly(null);
        if (0 == 0) goto L68;
        FileUtils.sync(null);
    L68:
        if (0 == 0) goto L70;
    L69:
        FileUtils.sync(null);
    L70:
        IoUtils.closeQuietly(null);
        IoUtils.closeQuietly(null);
        return false;
    L38:
        th = move-exception;
        IoUtils.closeQuietly(null);
        if (0 == 0) goto L88;
        FileUtils.sync(null);
    L88:
        if (0 == 0) goto L90;
        FileUtils.sync(null);
    L90:
        IoUtils.closeQuietly(null);
        IoUtils.closeQuietly(null);
        throw th;
    L40:
        e = e;
    L79:
        Slog.e(TAG, "Package name " + pkg2 + " not found");     // Catch: Throwable -> L38
        IoUtils.closeQuietly(null);
        if (0 == 0) goto L83;
        FileUtils.sync(null);
    L83:
        if (0 == 0) goto L70;
    L72:
        Slog.e(TAG, "Resource not found: " + resId);     // Catch: Throwable -> L38
        IoUtils.closeQuietly(null);
        if (0 == 0) goto L76;
        FileUtils.sync(null);
    L76:
        if (0 == 0) goto L70;
    L101:
        return false;
    L20:
        type2 = null;
        goto L21
    L13:
        ident2 = null;
        goto L15
    L9:
        pkg2 = null;
    L94:
        return false;
    }

    private static List<Pair<Integer, String>> screenDimensionPairs() {
        return List.of(new Pair(0, "Portrait"), new Pair(1, "Landscape"), new Pair(2, "SquarePortrait"), new Pair(3, "SquareLandscape"));
    }
}
