package com.android.server.location.fudger;

import android.location.Location;
import android.location.LocationResult;
import android.os.SystemClock;
import com.android.internal.location.geometry.S2CellIdUtils;
import java.security.SecureRandom;
import java.time.Clock;
import java.util.Random;

/* JADX INFO: loaded from: classes2.dex */
public class LocationFudger {
    private static final int APPROXIMATE_METERS_PER_DEGREE_AT_EQUATOR = 111000;
    private static final double CHANGE_PER_INTERVAL = 0.03d;
    private static final double MAX_LATITUDE = 89.999990990991d;
    private static final float MIN_ACCURACY_M = 200.0f;
    private static final double NEW_WEIGHT = 0.03d;
    static final long OFFSET_UPDATE_INTERVAL_MS = 3600000;
    private static final double OLD_WEIGHT = 0.0d;
    private static final float[] S2_CELL_AVG_EDGE_PER_LEVEL = null;
    private final float mAccuracyM;
    private Location mCachedCoarseLocation;
    private LocationResult mCachedCoarseLocationResult;
    private Location mCachedFineLocation;
    private LocationResult mCachedFineLocationResult;
    private final Clock mClock;
    private double mLatitudeOffsetM;
    private LocationFudgerCache mLocationFudgerCache;
    private double mLongitudeOffsetM;
    private long mNextUpdateRealtimeMs;
    private final Random mRandom;

    static {
        OLD_WEIGHT = Math.sqrt(0.9991d);
        S2_CELL_AVG_EDGE_PER_LEVEL = new float[]{9220.14f, 4610.07f, 2305.04f, 1152.52f, 576.26f, 288.13f, 144.06f, 72.03f, 36.02f, 20.79f, 9.0f, 5.05f, 2.25f, 1.13f, 0.57f};
    }

    public LocationFudger(float accuracyM) {
        this(accuracyM, SystemClock.elapsedRealtimeClock(), new SecureRandom());
    }

    LocationFudger(float accuracyM, Clock clock, Random random) {
        this.mLocationFudgerCache = null;
        this.mClock = clock;
        this.mRandom = random;
        this.mAccuracyM = Math.max(accuracyM, MIN_ACCURACY_M);
        resetOffsets();
    }

    public void setLocationFudgerCache(LocationFudgerCache cache) {
        monitor-enter(this);
        this.mLocationFudgerCache = cache;     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void resetOffsets() {
        this.mLatitudeOffsetM = nextRandomOffset();
        this.mLongitudeOffsetM = nextRandomOffset();
        this.mNextUpdateRealtimeMs = this.mClock.millis() + 3600000;
    }

    public LocationResult createCoarse(LocationResult fineLocationResult) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (fineLocationResult == this.mCachedFineLocationResult) goto L19;
        if (fineLocationResult == this.mCachedCoarseLocationResult) goto L19;
        monitor-exit(this);     // Catch: Throwable -> L17
        LocationResult coarseLocationResult = fineLocationResult.map(new LocationFudger$$ExternalSyntheticLambda0(this));
        monitor-enter(this);
        this.mCachedFineLocationResult = fineLocationResult;     // Catch: Throwable -> L14
        this.mCachedCoarseLocationResult = coarseLocationResult;     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return coarseLocationResult;
    L14:
        th = move-exception;
        throw th;
    L19:
        LocationResult r0 = this.mCachedCoarseLocationResult;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        return r0;
    }

    public Location createCoarse(Location fine) {
        monitor-enter(this);
    L40:
        th = th;
    L41:
        monitor-exit(this);     // Catch: Throwable -> L40
        throw th;
    L34:
        th = th;
        goto L41
    L4:
        if (fine == this.mCachedFineLocation) goto L37;
        if (fine == this.mCachedCoarseLocation) goto L37;
        monitor-exit(this);     // Catch: Throwable -> L34
        updateOffsets();
        Location coarse = new Location(fine);
        coarse.removeBearing();
        coarse.removeSpeed();
        coarse.removeAltitude();
        coarse.setExtras(null);
        double latitude = wrapLatitude(coarse.getLatitude());
        double longitude = wrapLongitude(coarse.getLongitude()) + wrapLongitude(metersToDegreesLongitude(this.mLongitudeOffsetM, latitude));
        double longitude2 = this.mLatitudeOffsetM;
        double latitude2 = latitude + wrapLatitude(metersToDegreesLatitude(longitude2));
        monitor-enter(this);
        LocationFudgerCache cacheCopy = this.mLocationFudgerCache;     // Catch: Throwable -> L28
        monitor-exit(this);     // Catch: Throwable -> L28
        double[] r0 = {0.0d, 0.0d};
        float accuracy = this.mAccuracyM;
        if (cacheCopy != null) goto L16;
        LocationFudger r8 = this;
        double[] coarsened = snapToGrid(latitude2, longitude);
        float accuracy2 = accuracy;
        double[] coarsened2 = coarsened;
    L20:
        coarse.setLatitude(coarsened2[0]);
        coarse.setLongitude(coarsened2[1]);
        coarse.setAccuracy(Math.max(accuracy2, coarse.getAccuracy()));
        monitor-enter(this);
        r8.mCachedFineLocation = fine;     // Catch: Throwable -> L25
        r8.mCachedCoarseLocation = coarse;     // Catch: Throwable -> L25
        monitor-exit(this);     // Catch: Throwable -> L25
        return coarse;
    L25:
        th = move-exception;
        throw th;
    L16:
        if (cacheCopy.hasDefaultValue() == false) goto L18;
        int level = cacheCopy.getCoarseningLevel(latitude2, longitude);
        r8 = this;
        double[] coarsened3 = r8.snapToCenterOfS2Cell(latitude2, longitude, level);
        accuracy2 = getS2CellApproximateEdge(level);
        coarsened2 = coarsened3;
        goto L20
    L18:
        r8 = this;
        cacheCopy.onDefaultCoarseningLevelNotSet();
        double[] coarsened4 = snapToGrid(latitude2, longitude);
        accuracy2 = accuracy;
        coarsened2 = coarsened4;
    L28:
        th = th;
    L48:
        throw th;
    L32:
        th = th;
    L37:
        Location r1 = this.mCachedCoarseLocation;     // Catch: Throwable -> L40
        monitor-exit(this);     // Catch: Throwable -> L40
        return r1;
    }

    protected float getS2CellApproximateEdge(int level) {
        if (level >= 0) goto L5;
        level = 0;
    L8:
        return S2_CELL_AVG_EDGE_PER_LEVEL[level] * 1000.0f;
    L5:
        if (level < S2_CELL_AVG_EDGE_PER_LEVEL.length) goto L8;
        level = S2_CELL_AVG_EDGE_PER_LEVEL.length - 1;
        goto L8
    }

    private double[] snapToGrid(double latitude, double longitude) {
        double[] center = {0.0d, 0.0d};
        double latGranularity = metersToDegreesLatitude(this.mAccuracyM);
        center[0] = wrapLatitude(Math.round(latitude / latGranularity) * latGranularity);
        double lonGranularity = metersToDegreesLongitude(this.mAccuracyM, latitude);
        center[1] = wrapLongitude(Math.round(longitude / lonGranularity) * lonGranularity);
        return center;
    }

    protected double[] snapToCenterOfS2Cell(double latDegrees, double lngDegrees, int level) {
        long leafCell = S2CellIdUtils.fromLatLngDegrees(latDegrees, lngDegrees);
        long coarsenedCell = S2CellIdUtils.getParent(leafCell, level);
        double[] center = {0.0d, 0.0d};
        S2CellIdUtils.toLatLngDegrees(coarsenedCell, center);
        return center;
    }

    private synchronized void updateOffsets() {
        monitor-enter(this);
        long now = this.mClock.millis();     // Catch: Throwable -> L11
        if (now >= this.mNextUpdateRealtimeMs) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.mLatitudeOffsetM = (OLD_WEIGHT * this.mLatitudeOffsetM) + (nextRandomOffset() * 0.03d);     // Catch: Throwable -> L11
        this.mLongitudeOffsetM = (OLD_WEIGHT * this.mLongitudeOffsetM) + (nextRandomOffset() * 0.03d);     // Catch: Throwable -> L11
        this.mNextUpdateRealtimeMs = 3600000 + now;     // Catch: Throwable -> L11
        monitor-exit(this);
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private double nextRandomOffset() {
        return this.mRandom.nextGaussian() * (((double) this.mAccuracyM) / 4.0d);
    }

    private static double wrapLatitude(double lat) {
        if (lat <= MAX_LATITUDE) goto L6;
        lat = MAX_LATITUDE;
    L6:
        if (lat >= (-89.999990990991d)) goto L9;
        return -89.999990990991d;
    L9:
        return lat;
    }

    private static double wrapLongitude(double lon) {
        double lon2 = lon % 360.0d;
        if (lon2 < 180.0d) goto L6;
        lon2 = lon2 - 360.0d;
    L6:
        if (lon2 < (-180.0d)) goto L8;
        return lon2;
    L8:
        return lon2 + 360.0d;
    }

    private static double metersToDegreesLatitude(double distance) {
        return distance / 111000.0d;
    }

    private static double metersToDegreesLongitude(double distance, double lat) {
        double cosLat = Math.cos(Math.toRadians(lat));
        if (cosLat != 0.0d) goto L7;
        return 1.0E-4d;
    L7:
        return (distance / 111000.0d) / cosLat;
    }
}
