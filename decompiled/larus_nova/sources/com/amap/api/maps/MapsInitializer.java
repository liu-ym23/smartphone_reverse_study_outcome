package com.amap.api.maps;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.amap.api.mapcore.util.b0;
import com.amap.api.mapcore.util.l5;
import com.amap.api.mapcore.util.m5;
import com.amap.api.mapcore.util.o5;
import com.amap.api.mapcore.util.p3;
import com.amap.api.mapcore.util.r7;
import com.amap.api.mapcore.util.u5;
import com.amap.api.mapcore.util.w3;
import com.amap.api.mapcore.util.z8;
import com.amap.api.maps.model.LatLng;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.bytedance.ai.api.navi.AppletNaviThirdApp;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import java.io.File;

/* JADX INFO: loaded from: classes28.dex */
public final class MapsInitializer {
    public static final int HTTP = 1;
    public static final int HTTPS = 2;
    public static String TERRAIN_LOCAL_DEM_SOURCE_PATH = null;
    public static final int TILE_REQUEST_LOG_DETAIL = 2;
    public static final int TILE_REQUEST_LOG_OFF = 0;
    public static final int TILE_REQUEST_LOG_SUMMARY = 1;
    public static final long alc_level_ALC_HEADER = 2048;
    public static final long alc_level_ALL = 4088;
    public static final long alc_level_DEBUG = 8;
    public static final long alc_level_ERR = 64;
    public static final long alc_level_FATAL = 128;
    public static final long alc_level_INFO = 16;
    public static final long alc_level_PERFORMANCE = 256;
    public static final long alc_level_PRISM_TRACING = 1024;
    public static final long alc_level_TRACING = 512;
    public static final long alc_level_WARNING = 32;
    private static boolean closeTileOverlay;
    private static ExceptionLogger exceptionLogger;
    private static boolean isContourLineEnable;
    private static boolean isLoadWorldGridMap;
    private static boolean isNeedDownloadCoordinateConvertLibrary;
    private static boolean isNetWorkEnable;
    private static boolean isPolyline2Enable;
    private static boolean isSupportRecycleView;
    private static boolean isTerrainEnable;
    private static boolean isTextureDestroyedRender;
    private static boolean isTextureSizeChangedInvoked;
    private static boolean isTextureViewDestorySync;
    private static boolean isloadWorldVectorMap;
    private static int mMapVersion;
    private static int mProtocol;
    private static String mWorldVectorOfflineMapStyleAssetsPath;
    private static String mWorldVectorOfflineMapStyleFilePath;
    private static volatile long sAlcLogLevelMask;
    private static volatile boolean sAlcRecordStorage;
    private static String sLibAbi;
    private static String sLibPath;
    private static String sLogoLanguage;
    private static LatLng sRegionLocation;
    private static volatile int sTileRequestLogLevel;
    public static String sdcardDir;

    public static void disableCachedMapDataUpdate(boolean r100) {
    }

    public static boolean getPolyline2Enable() {
        return true;
    }

    public static String getVersion() {
        return "11.2.101";
    }

    public static boolean isDisableCachedMapDataUpdate() {
        return false;
    }

    public static void setBuildingHeight(int r100) {
    }

    public static void setPolyline2Enable(boolean r100) {
    }

    static {
        l5.a("ZH", 0);
        sdcardDir = "";
        sLibPath = "";
        sLibAbi = "";
        isNetWorkEnable = true;
        isNeedDownloadCoordinateConvertLibrary = true;
        TERRAIN_LOCAL_DEM_SOURCE_PATH = null;
        isLoadWorldGridMap = false;
        closeTileOverlay = false;
        isTextureViewDestorySync = true;
        isTextureDestroyedRender = false;
        isTextureSizeChangedInvoked = false;
        isSupportRecycleView = true;
        exceptionLogger = null;
        isloadWorldVectorMap = false;
        mWorldVectorOfflineMapStyleFilePath = "";
        mWorldVectorOfflineMapStyleAssetsPath = "";
        isPolyline2Enable = true;
        isTerrainEnable = false;
        isContourLineEnable = false;
        sRegionLocation = new LatLng(39.909016d, 116.39746d);
        mMapVersion = 0;
        sLogoLanguage = "zh_cn";
        mProtocol = 1;
    }

    public static String getLogoLanguage() {
        if (isOverSea() == false) goto L7;
        return "en";
    L7:
        return sLogoLanguage;
    }

    public static int getNetworkThreadPoolCoreSize() {
        return z8.i();
    }

    public static int getNetworkThreadPoolMaxSize() {
        return z8.j();
    }

    public static int getRegionLanguageType() {
        return l5.c();
    }

    public static boolean isOverSea() {
        return l5.e();
    }

    public MapsInitializer() {
    }

    public static long getAlcLogLevelMask() {
        return sAlcLogLevelMask;
    }

    public static ExceptionLogger getExceptionLogger() {
        return exceptionLogger;
    }

    public static String getLibAbi() {
        return sLibAbi;
    }

    public static String getLibPath() {
        return sLibPath;
    }

    public static boolean getNetWorkEnable() {
        return isNetWorkEnable;
    }

    public static int getProtocol() {
        return mProtocol;
    }

    public static LatLng getRegionLocation() {
        return sRegionLocation;
    }

    public static boolean getTextureDestroyRender() {
        return isTextureDestroyedRender;
    }

    public static boolean getTextureSizeChangedInvoked() {
        return isTextureSizeChangedInvoked;
    }

    public static boolean getTextureViewDestorySync() {
        return isTextureViewDestorySync;
    }

    public static int getTileRequestLogLevel() {
        return sTileRequestLogLevel;
    }

    public static String getWorldVectorOfflineMapStyleAssetsPath() {
        return mWorldVectorOfflineMapStyleAssetsPath;
    }

    public static String getWorldVectorOfflineMapStyleFilePath() {
        return mWorldVectorOfflineMapStyleFilePath;
    }

    public static boolean isAlcRecordStorage() {
        return sAlcRecordStorage;
    }

    public static boolean isContourLineEnable() {
        return isContourLineEnable;
    }

    public static boolean isDownloadCoordinateConvertLibrary() {
        return isNeedDownloadCoordinateConvertLibrary;
    }

    public static boolean isLoadWorldGridMap() {
        return isLoadWorldGridMap;
    }

    public static boolean isLoadWorldVectorMap() {
        return isloadWorldVectorMap;
    }

    public static boolean isSupportRecycleView() {
        return isSupportRecycleView;
    }

    public static boolean isTerrainEnable() {
        return isTerrainEnable;
    }

    public static String getDeviceId(Context r100) {
        return o5.m(r100);
    }

    public static void initRegionLanguageType(int r100) {
        l5.a(r100);
    }

    public static void initialize(Context r100) throws RemoteException {
        if (r100 == null) goto L5;
        b0.f27047f = r100.getApplicationContext();
        return;
    }

    public static void loadWorldVectorMap(boolean r100) {
        isloadWorldVectorMap = r100;
    }

    public static boolean removecache(Context r100) {
        if (r100 != null) goto L34;
        return false;
    L34:
        boolean r101 = true;
        if (FileUtil.deleteFile(new PolarisFileWrapper(w3.c(r100))) == false) goto L13;
        PolarisFileWrapper r102 = new PolarisFileWrapper(w3.b(r100));     // Catch: Throwable -> L29
        if (r102.exists() == true) goto L10;
        boolean r103 = true;
    L11:
        if (r103 == false) goto L13;
        boolean r104 = true;
    L32:
        File r105 = r100.getExternalFilesDir(null);     // Catch: Throwable -> L24
        if (r105 == null) goto L26;
        PolarisFileWrapper r106 = new PolarisFileWrapper(new PolarisFileWrapper(r105, AppletNaviThirdApp.AMAP), ChameleonOpenTracker.Stage.RENDER);     // Catch: Throwable -> L24
        if (r106.exists() == false) goto L26;
        if (r104 == false) goto L23;
        if (FileUtil.deleteFile(r106) == false) goto L23;
    L27:
        GLMapEngine.clearMapDataCache();     // Catch: Throwable -> L29
        return r101;
    L23:
        r101 = false;
    L26:
        r101 = r104;
    L24:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L29
        goto L26
    L10:
        r103 = FileUtil.deleteFile(r102);     // Catch: Throwable -> L29
    L13:
        r104 = false;
    L29:
        th = move-exception;
        th.printStackTrace();
        return false;
    }

    public static void setApiKey(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.trim().length() <= 0) goto L8;
        m5.a(b0.f27047f, r100);
        return;
    }

    public static void setContourLIneEnable(boolean r100) {
        isContourLineEnable = r100;
    }

    public static void setCurrentLocation(LatLng r100) {
        sRegionLocation = r100;
    }

    public static void setDownloadCoordinateConvertLibrary(boolean r100) {
        isNeedDownloadCoordinateConvertLibrary = r100;
    }

    public static void setExceptionLogger(ExceptionLogger r100) {
        exceptionLogger = r100;
    }

    public static void setExternalBasePath(String r100) {
        p3.a(r100);
    }

    public static void setHost(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        r7.f27936a = -1;
        r7.f27937b = "";
        return;
    L5:
        r7.f27936a = 1;
        r7.f27937b = r100;
    }

    public static void setLogoLanguage(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (isOverSea() == false) goto L10;
        sLogoLanguage = "en";
        return;
    L10:
        if ("en".equals(r100) == false) goto L12;
        sLogoLanguage = "en";
        return;
    L12:
        sLogoLanguage = "zh_cn";
    }

    public static void setNetWorkEnable(boolean r100) {
        isNetWorkEnable = r100;
    }

    public static boolean setNetworkThreadPoolSize(int r100) {
        return z8.a(r100);
    }

    public static void setProtocol(int r100) {
        mProtocol = r100;
    }

    public static void setSupportRecycleView(boolean r100) {
        isSupportRecycleView = r100;
    }

    public static void setTerrainEnable(boolean r100) {
        isTerrainEnable = r100;
    }

    public static void setTextureDestroyedRender(boolean r100) {
        isTextureDestroyedRender = r100;
    }

    public static void setTextureSizeChangedInvoked(boolean r100) {
        isTextureSizeChangedInvoked = r100;
    }

    public static void setTextureViewDestorySync(boolean r100) {
        isTextureViewDestorySync = r100;
    }

    public static void setTileRequestLogLevel(int r100) {
        if (r100 >= 0) goto L4;
    L5:
        r100 = 0;
    L7:
        if (sTileRequestLogLevel != r100) goto L9;
        return;
    L9:
        sTileRequestLogLevel = r100;
        GLMapEngine.onTileRequestLogLevelChanged(r100);
        return;
    L4:
        if (r100 <= 2) goto L7;
        goto L5
    }

    public static void setWorldVectorOfflineMapStyleAssetsPath(String r100) {
        mWorldVectorOfflineMapStyleAssetsPath = r100;
    }

    public static void setWorldVectorOfflineMapStyleFilePath(String r100) {
        mWorldVectorOfflineMapStyleFilePath = r100;
    }

    public static void updateCountryCode(String r100) {
        l5.b(r100);
    }

    public static void setAlcLogConfig(long r100, boolean r101) {
        sAlcLogLevelMask = r100;
        sAlcRecordStorage = r101;
    }

    public static void setLibPath(String r100, String r101) {
        sLibPath = r100;
        sLibAbi = r101;
    }

    public static boolean setNetworkThreadPoolSize(int r100, int r101) {
        return z8.a(r100, r101);
    }

    public static synchronized void updatePrivacyAgree(Context r100, boolean r101) {
        monitor-enter(MapsInitializer.class);
        u5.a(r100, r101, w3.b());     // Catch: Throwable -> L7
        monitor-exit(MapsInitializer.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void updatePrivacyShow(Context r100, boolean r101, boolean r102) {
        monitor-enter(MapsInitializer.class);
        u5.a(r100, r101, r102, w3.b());     // Catch: Throwable -> L7
        monitor-exit(MapsInitializer.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
