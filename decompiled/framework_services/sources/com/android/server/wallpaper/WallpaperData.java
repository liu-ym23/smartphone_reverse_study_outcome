package com.android.server.wallpaper;

import android.app.IWallpaperManagerCallback;
import android.app.WallpaperColors;
import android.app.wallpaper.WallpaperDescription;
import android.content.ComponentName;
import android.graphics.Rect;
import android.os.RemoteCallbackList;
import android.util.SparseArray;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
class WallpaperData {
    boolean allowBackup;
    RemoteCallbackList<IWallpaperManagerCallback> callbacks;
    String callingPackage;
    WallpaperManagerService.WallpaperConnection connection;
    final Rect cropHint;
    public boolean fromForegroundApp;
    boolean imageWallpaperPending;
    long lastDiedTime;
    BindSource mBindSource;
    private final SparseArray<File> mCropFiles;
    SparseArray<Rect> mCropHints;
    private WallpaperDescription mDescription;
    boolean mIsColorExtractedFromDim;
    int mOrientationWhenSet;
    float mSampleSize;
    boolean mSystemWasBoth;
    SparseArray<Float> mUidToDimAmount;
    private ComponentName mWallpaperComponent;
    float mWallpaperDimAmount;
    private final SparseArray<File> mWallpaperFiles;
    int mWhich;
    String name;
    ComponentName nextWallpaperComponent;
    WallpaperColors primaryColors;
    IWallpaperManagerCallback setComplete;
    final int userId;
    int wallpaperId;
    WallpaperManagerService.WallpaperObserver wallpaperObserver;
    boolean wallpaperUpdating;

    static final enum BindSource extends Enum<BindSource> {
        private static final /* synthetic */ BindSource[] $VALUES = null;
        public static final BindSource CONNECTION_TRY_TO_REBIND = null;
        public static final BindSource CONNECT_LOCKED = null;
        public static final BindSource FALLBACK_DEFAULT_MISSING = null;
        public static final BindSource INITIALIZE_FALLBACK = null;
        public static final BindSource PACKAGE_UPDATE_FINISHED = null;
        public static final BindSource RESTORE_SETTINGS_LIVE_FAILURE = null;
        public static final BindSource RESTORE_SETTINGS_LIVE_SUCCESS = null;
        public static final BindSource RESTORE_SETTINGS_STATIC = null;
        public static final BindSource SET_LIVE = null;
        public static final BindSource SET_LIVE_TO_CLEAR = null;
        public static final BindSource SET_STATIC = null;
        public static final BindSource SWITCH_WALLPAPER_FAILURE = null;
        public static final BindSource SWITCH_WALLPAPER_SWITCH_USER = null;
        public static final BindSource SWITCH_WALLPAPER_UNLOCK_USER = null;
        public static final BindSource UNKNOWN = null;

        private static /* synthetic */ BindSource[] $values() {
            return new BindSource[]{UNKNOWN, CONNECT_LOCKED, CONNECTION_TRY_TO_REBIND, FALLBACK_DEFAULT_MISSING, INITIALIZE_FALLBACK, PACKAGE_UPDATE_FINISHED, RESTORE_SETTINGS_LIVE_FAILURE, RESTORE_SETTINGS_LIVE_SUCCESS, RESTORE_SETTINGS_STATIC, SET_LIVE, SET_LIVE_TO_CLEAR, SET_STATIC, SWITCH_WALLPAPER_FAILURE, SWITCH_WALLPAPER_SWITCH_USER, SWITCH_WALLPAPER_UNLOCK_USER};
        }

        private BindSource(String r1, int r2) {
            super(r1, r2);
        }

        public static BindSource valueOf(String name) {
            return (BindSource) Enum.valueOf(BindSource.class, name);
        }

        public static BindSource[] values() {
            return (BindSource[]) $VALUES.clone();
        }

        static {
            UNKNOWN = new BindSource("UNKNOWN", 0);
            CONNECT_LOCKED = new BindSource("CONNECT_LOCKED", 1);
            CONNECTION_TRY_TO_REBIND = new BindSource("CONNECTION_TRY_TO_REBIND", 2);
            FALLBACK_DEFAULT_MISSING = new BindSource("FALLBACK_DEFAULT_MISSING", 3);
            INITIALIZE_FALLBACK = new BindSource("INITIALIZE_FALLBACK", 4);
            PACKAGE_UPDATE_FINISHED = new BindSource("PACKAGE_UPDATE_FINISHED", 5);
            RESTORE_SETTINGS_LIVE_FAILURE = new BindSource("RESTORE_SETTINGS_LIVE_FAILURE", 6);
            RESTORE_SETTINGS_LIVE_SUCCESS = new BindSource("RESTORE_SETTINGS_LIVE_SUCCESS", 7);
            RESTORE_SETTINGS_STATIC = new BindSource("RESTORE_SETTINGS_STATIC", 8);
            SET_LIVE = new BindSource("SET_LIVE", 9);
            SET_LIVE_TO_CLEAR = new BindSource("SET_LIVE_TO_CLEAR", 10);
            SET_STATIC = new BindSource("SET_STATIC", 11);
            SWITCH_WALLPAPER_FAILURE = new BindSource("SWITCH_WALLPAPER_FAILURE", 12);
            SWITCH_WALLPAPER_SWITCH_USER = new BindSource("SWITCH_WALLPAPER_SWITCH_USER", 13);
            SWITCH_WALLPAPER_UNLOCK_USER = new BindSource("SWITCH_WALLPAPER_UNLOCK_USER", 14);
            $VALUES = $values();
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$nGJ0uxZXd7JBpGkou3f2CJc-xIQ, reason: not valid java name */
    public static /* synthetic */ void m9498$r8$lambda$nGJ0uxZXd7JBpGkou3f2CJcxIQ(StringBuilder r0, WallpaperManagerService.DisplayConnector r1) {
        lambda$toString$0(r0, r1);
    }

    WallpaperData(int userId, int wallpaperType) {
        this.name = "";
        this.mWallpaperDimAmount = 0.0f;
        this.mUidToDimAmount = new SparseArray();
        this.callbacks = new RemoteCallbackList();
        this.cropHint = new Rect(0, 0, 0, 0);
        this.mSampleSize = 1.0f;
        this.mBindSource = BindSource.UNKNOWN;
        this.mWallpaperFiles = new SparseArray();
        this.mCropFiles = new SparseArray();
        this.mCropHints = new SparseArray();
        this.mOrientationWhenSet = -1;
        this.mDescription = new WallpaperDescription.Builder().build();
        this.userId = userId;
        this.mWhich = wallpaperType;
    }

    WallpaperData(WallpaperData source) {
        this.name = "";
        this.mWallpaperDimAmount = 0.0f;
        this.mUidToDimAmount = new SparseArray();
        this.callbacks = new RemoteCallbackList();
        this.cropHint = new Rect(0, 0, 0, 0);
        this.mSampleSize = 1.0f;
        this.mBindSource = BindSource.UNKNOWN;
        this.mWallpaperFiles = new SparseArray();
        this.mCropFiles = new SparseArray();
        this.mCropHints = new SparseArray();
        this.mOrientationWhenSet = -1;
        this.mDescription = new WallpaperDescription.Builder().build();
        this.userId = source.userId;
        this.mWallpaperComponent = source.mWallpaperComponent;
        this.mWhich = source.mWhich;
        this.wallpaperId = source.wallpaperId;
        this.cropHint.set(source.cropHint);
        if (source.mCropHints == null) goto L5;
        this.mCropHints = source.mCropHints.clone();
    L5:
        this.allowBackup = source.allowBackup;
        this.primaryColors = source.primaryColors;
        this.mWallpaperDimAmount = source.mWallpaperDimAmount;
        this.connection = source.connection;
        setDescription(source.getDescription());
        if (this.connection == null) goto L9;
        this.connection.mWallpaper = this;
        return;
    }

    File getWallpaperFile() {
        if (this.mWhich != 2) goto L5;
        String fileName = "wallpaper_lock_orig";
    L7:
        return getFile(this.mWallpaperFiles, fileName);
    L5:
        fileName = "wallpaper_orig";
        goto L7
    }

    File getCropFile() {
        if (this.mWhich != 2) goto L5;
        String fileName = "wallpaper_lock";
    L7:
        return getFile(this.mCropFiles, fileName);
    L5:
        fileName = "wallpaper";
        goto L7
    }

    private File getFile(SparseArray<File> map, String fileName) {
        File result = map.get(this.mWhich);
        if (result != null) goto L6;
        File result2 = new File(WallpaperUtils.getWallpaperDir(this.userId), fileName);
        map.put(this.userId, result2);
        return result2;
    L6:
        return result;
    }

    ComponentName getComponent() {
        return this.mDescription.getComponent();
    }

    void setComponent(ComponentName componentName) {
        throw new IllegalStateException("Use \"setDescription\" when content handling is enabled");
    }

    WallpaperDescription getDescription() {
        return this.mDescription;
    }

    void setDescription(WallpaperDescription description) {
        if (description == null) goto L10;
        if (description.getComponent() == null) goto L8;
        this.mDescription = description;
        return;
    L8:
        throw new IllegalArgumentException("WallpaperDescription component must not be null");
    L10:
        throw new IllegalArgumentException("WallpaperDescription must not be null");
    }

    public String toString() {
        final StringBuilder out = new StringBuilder(defaultString(this));
        out.append(", id: ");
        out.append(this.wallpaperId);
        out.append(", which: ");
        out.append(this.mWhich);
        out.append(", file mod: ");
        if (getWallpaperFile() == null) goto L5;
        Object r1 = Long.valueOf(getWallpaperFile().lastModified());
    L6:
        out.append(r1);
        if (this.connection != null) goto L9;
        out.append(", no connection");
    L11:
        return out.toString();
    L9:
        out.append(", info: ");
        out.append(this.connection.mInfo);
        out.append(", engine(s):");
        this.connection.forEachDisplayConnector(new WallpaperData$$ExternalSyntheticLambda0(out));
        goto L11
    L5:
        r1 = "null";
        goto L6
    }

    private static /* synthetic */ void lambda$toString$0(StringBuilder out, WallpaperManagerService.DisplayConnector connector) {
        if (connector.mEngine == null) goto L5;
        out.append(" ");
        out.append(defaultString(connector.mEngine));
        return;
    L5:
        out.append(" null");
    }

    private static String defaultString(Object o) {
        return o.getClass().getSimpleName() + "@" + Integer.toHexString(o.hashCode());
    }

    boolean cropExists() {
        return getCropFile().exists();
    }

    boolean sourceExists() {
        return getWallpaperFile().exists();
    }
}
