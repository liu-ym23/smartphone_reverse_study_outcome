package com.android.server.location.fudger;

import android.location.provider.IS2CellIdsCallback;
import android.location.provider.IS2LevelCallback;
import com.android.internal.location.geometry.S2CellIdUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.location.provider.proxy.ProxyPopulationDensityProvider;

/* JADX INFO: loaded from: classes2.dex */
public class LocationFudgerCache {
    protected static final int LOG_DENSITY_BASED_LOCS_USED_RATE_LIMIT_MS = 600000;
    protected static final int MAX_CACHE_SIZE = 20;
    private static String sTAG;
    private final long[] mCache;
    private int mCacheSize;
    private Integer mDefaultCoarseningLevel;
    private long mLastQueryToLogDensityBasedLocsUsedMs;
    private final Object mLock;
    private final ProxyPopulationDensityProvider mPopulationDensityProvider;
    private int mPosInCache;

    /* JADX INFO: renamed from: -$$Nest$fgetmLock, reason: not valid java name */
    static /* bridge */ /* synthetic */ Object m5217$$Nest$fgetmLock(LocationFudgerCache r0) {
        return r0.mLock;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDefaultCoarseningLevel, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5218$$Nest$fputmDefaultCoarseningLevel(LocationFudgerCache r0, Integer r1) {
        r0.mDefaultCoarseningLevel = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsTAG, reason: not valid java name */
    static /* bridge */ /* synthetic */ String m5219$$Nest$sfgetsTAG() {
        return sTAG;
    }

    static {
        sTAG = "LocationFudgerCache";
    }

    public LocationFudgerCache(ProxyPopulationDensityProvider provider) {
        this.mLock = new Object();
        this.mCache = new long[20];
        this.mPosInCache = 0;
        this.mCacheSize = 0;
        this.mDefaultCoarseningLevel = null;
        this.mLastQueryToLogDensityBasedLocsUsedMs = -600000;
        provider.getClass();
        this.mPopulationDensityProvider = provider;
        asyncFetchDefaultCoarseningLevel();
    }

    public void onDefaultCoarseningLevelNotSet() {
        if (hasDefaultValue() == true) goto L5;
        asyncFetchDefaultCoarseningLevel();
    L5:
        logDensityBasedLocsUsed(System.currentTimeMillis(), true, false, -1);
    }

    public boolean hasDefaultValue() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mDefaultCoarseningLevel == null) goto L7;
        boolean r1 = true;
    L8:
        monitor-exit(r0);     // Catch: Throwable -> L10
        return r1;
    L7:
        r1 = false;
        goto L8
    }

    public int getCoarseningLevel(double latitudeDegrees, double longitudeDegrees) {
        if (hasDefaultValue() == true) goto L5;
        asyncFetchDefaultCoarseningLevel();
    L5:
        Long s2CellId = readCacheForLatLng(latitudeDegrees, longitudeDegrees);
        int defaultLevel = getDefaultCoarseningLevel();
        if (s2CellId != null) goto L9;
        refreshCache(latitudeDegrees, longitudeDegrees);
        logDensityBasedLocsUsed(System.currentTimeMillis(), false, false, defaultLevel);
        return defaultLevel;
    L9:
        logDensityBasedLocsUsed(System.currentTimeMillis(), false, true, defaultLevel);
        return S2CellIdUtils.getLevel(s2CellId.longValue());
    }

    protected boolean logDensityBasedLocsUsed(long nowMs, boolean skippedNoDefault, boolean isCacheHit, int defaultCoarseningLevel) {
        if ((nowMs - this.mLastQueryToLogDensityBasedLocsUsedMs) >= 600000) goto L6;
        return false;
    L6:
        this.mLastQueryToLogDensityBasedLocsUsedMs = nowMs;
        FrameworkStatsLog.write(1003, skippedNoDefault, isCacheHit, defaultCoarseningLevel);
        return true;
    }

    private Long readCacheForLatLng(double latDegrees, double lngDegrees) {
        Object r1 = this.mLock;
        monitor-enter(r1);
        int i = 0;
    L25:
    L17:
        th = move-exception;
        Throwable r10 = th;
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L14
        throw r10;
    L6:
        if (i >= this.mCacheSize) goto L20;
        double latDegrees2 = latDegrees;
        double lngDegrees2 = lngDegrees;
    L14:
        th = move-exception;
        r10 = th;
        goto L23
    L10:
        if (S2CellIdUtils.containsLatLngDegrees(this.mCache[i], latDegrees2, lngDegrees2) == true) goto L11;
        i = i + 1;     // Catch: Throwable -> L14
        latDegrees = latDegrees2;
        lngDegrees = lngDegrees2;
        goto L25
    L11:
        Long r11 = Long.valueOf(this.mCache[i]);     // Catch: Throwable -> L14
        monitor-exit(r1);     // Catch: Throwable -> L14
        return r11;
    L20:
        monitor-exit(r1);     // Catch: Throwable -> L14
        return null;
    }

    public void addToCache(long s2CellId) {
        addToCache(new long[]{s2CellId});
    }

    public void addToCache(long[] s2CellIds) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        int end = Math.min(s2CellIds.length, 20);     // Catch: Throwable -> L7
        this.mCacheSize = Math.min(this.mCacheSize + end, 20);     // Catch: Throwable -> L7
        int i = end - 1;     // Catch: Throwable -> L7
    L5:
        if (i < 0) goto L10;
        this.mCache[this.mPosInCache] = s2CellIds[i];     // Catch: Throwable -> L7
        this.mPosInCache = (this.mPosInCache + 1) % 20;     // Catch: Throwable -> L7
        i = i - 1;     // Catch: Throwable -> L7
        goto L5
    L10:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void asyncFetchDefaultCoarseningLevel() {
        IS2LevelCallback callback = new AnonymousClass1(this);
        this.mPopulationDensityProvider.getDefaultCoarseningLevel(callback);
    }

    private void refreshCache(double latitude, double longitude) {
        final long startTime = System.currentTimeMillis();
        IS2CellIdsCallback callback = new AnonymousClass2(this, startTime);
        this.mPopulationDensityProvider.getCoarsenedS2Cells(latitude, longitude, 19, callback);
    }

    private int getDefaultCoarseningLevel() {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mDefaultCoarseningLevel != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return 0;
    L11:
        int r1 = this.mDefaultCoarseningLevel.intValue();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    }
}
