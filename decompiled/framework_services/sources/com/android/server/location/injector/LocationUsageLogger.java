package com.android.server.location.injector;

import android.location.Geofence;
import android.location.LocationRequest;
import android.util.Log;
import com.android.internal.util.FrameworkStatsLog;
import com.android.server.location.LocationManagerService;
import java.time.Instant;

/* JADX INFO: loaded from: classes2.dex */
public class LocationUsageLogger {
    private static final int API_USAGE_LOG_HOURLY_CAP = 60;
    private static final int ONE_HOUR_IN_MILLIS = 3600000;
    private static final int ONE_MINUTE_IN_MILLIS = 60000;
    private static final int ONE_SEC_IN_MILLIS = 1000;
    private int mApiUsageLogHourlyCount;
    private long mLastApiUsageLogHour;

    public LocationUsageLogger() {
        this.mLastApiUsageLogHour = 0;
        this.mApiUsageLogHourlyCount = 0;
    }

    public void logLocationApiUsage(int usageType, int apiInUse, String packageName, String attributionTag, String provider, LocationRequest locationRequest, boolean hasListener, boolean hasIntent, Geofence geofence, boolean foreground) {
    L35:
        e = e;
    L47:
        Log.w(LocationManagerService.TAG, "Failed to log API usage to statsd.", e);
        return;
    L3:
        if (hitApiUsageLogCap() == false) goto L6;
        return;
    L6:
        if (locationRequest != null) goto L8;
        boolean isLocationRequestNull = true;
    L9:
        if (geofence != null) goto L11;
        boolean isGeofenceNull = true;
    L13:
        if (isLocationRequestNull == false) goto L15;
        int r9 = 0;
    L16:
        if (isLocationRequestNull == false) goto L18;
        int r10 = 0;
    L19:
        if (isLocationRequestNull == false) goto L21;
        int r11 = 0;
    L22:
        if (isLocationRequestNull == false) goto L24;
        int r12 = 0;
    L25:
        if (isLocationRequestNull == false) goto L28;
        long r4 = 0;
    L27:
        long r13 = r4;
        if (isLocationRequestNull == true) goto L37;
        int r6 = usageType;
        if (r6 == 1) goto L38;
        int r15 = bucketizeExpireIn(locationRequest.getDurationMillis());     // Catch: Exception -> L35
    L51:
        int r16 = getCallbackType(apiInUse, hasListener, hasIntent);     // Catch: Exception -> L46
        if (isGeofenceNull == false) goto L43;
        int r17 = 0;
    L44:
        FrameworkStatsLog.write(210, r6, apiInUse, packageName, r9, r10, r11, r12, r13, r15, r16, r17, categorizeActivityImportance(foreground), attributionTag);     // Catch: Exception -> L46
        return;
    L43:
        r17 = bucketizeRadius(geofence.getRadius());     // Catch: Exception -> L46
    L46:
        e = e;
    L38:
        r15 = 0;
        goto L51
    L37:
        r6 = usageType;
        goto L38
    L28:
        r4 = locationRequest.getMaxUpdates();     // Catch: Exception -> L35
        goto L27
    L24:
        r12 = bucketizeDistance(locationRequest.getMinUpdateDistanceMeters());     // Catch: Exception -> L35
        goto L25
    L21:
        r11 = bucketizeInterval(locationRequest.getIntervalMillis());     // Catch: Exception -> L35
        goto L22
    L18:
        r10 = locationRequest.getQuality();     // Catch: Exception -> L35
        goto L19
    L15:
        r9 = bucketizeProvider(provider);     // Catch: Exception -> L35
        goto L16
    L11:
        isGeofenceNull = false;
        goto L13
    L8:
        isLocationRequestNull = false;
        goto L9
    }

    public void logLocationApiUsage(int usageType, int apiInUse, String providerName) {
    L7:
        e = move-exception;
        Log.w(LocationManagerService.TAG, "Failed to log API usage to statsd.", e);
        return;
    L3:
        if (hitApiUsageLogCap() == false) goto L5;
        return;
    L5:
        FrameworkStatsLog.write(210, usageType, apiInUse, null, bucketizeProvider(providerName), 0, 0, 0, 0, 0, getCallbackType(apiInUse, true, true), 0, 0, null);     // Catch: Exception -> L7
    }

    public synchronized void logLocationEnabledStateChanged(boolean enabled) {
        monitor-enter(this);
        FrameworkStatsLog.write(FrameworkStatsLog.LOCATION_ENABLED_STATE_CHANGED, enabled);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void logEmergencyStateChanged(boolean isInEmergency) {
        monitor-enter(this);
        FrameworkStatsLog.write(FrameworkStatsLog.EMERGENCY_STATE_CHANGED, isInEmergency);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private static int bucketizeProvider(String provider) {
        if ("network".equals(provider) == false) goto L7;
        return 1;
    L7:
        if ("gps".equals(provider) == false) goto L11;
        return 2;
    L11:
        if ("passive".equals(provider) == false) goto L15;
        return 3;
    L15:
        if ("fused".equals(provider) == false) goto L18;
        return 4;
    L18:
        return 0;
    }

    private static int bucketizeInterval(long interval) {
        if (interval >= 1000) goto L7;
        return 1;
    L7:
        if (interval >= 5000) goto L11;
        return 2;
    L11:
        if (interval >= 60000) goto L15;
        return 3;
    L15:
        if (interval >= 600000) goto L19;
        return 4;
    L19:
        if (interval >= 3600000) goto L22;
        return 5;
    L22:
        return 6;
    }

    private static int bucketizeDistance(float smallestDisplacement) {
        if (smallestDisplacement > 0.0f) goto L7;
        return 1;
    L7:
        if (smallestDisplacement > 0.0f) goto L9;
        return 3;
    L9:
        if (smallestDisplacement > 100.0f) goto L14;
        return 2;
    L14:
        return 3;
    }

    private static int bucketizeRadius(float radius) {
        if (radius >= 0.0f) goto L7;
        return 7;
    L7:
        if (radius >= 100.0f) goto L11;
        return 1;
    L11:
        if (radius >= 200.0f) goto L15;
        return 2;
    L15:
        if (radius >= 300.0f) goto L19;
        return 3;
    L19:
        if (radius >= 1000.0f) goto L23;
        return 4;
    L23:
        if (radius >= 10000.0f) goto L26;
        return 5;
    L26:
        return 6;
    }

    private static int bucketizeExpireIn(long expireIn) {
        if (expireIn != Long.MAX_VALUE) goto L7;
        return 6;
    L7:
        if (expireIn >= 20000) goto L11;
        return 1;
    L11:
        if (expireIn >= 60000) goto L15;
        return 2;
    L15:
        if (expireIn >= 600000) goto L19;
        return 3;
    L19:
        if (expireIn >= 3600000) goto L22;
        return 4;
    L22:
        return 5;
    }

    private static int categorizeActivityImportance(boolean foreground) {
        if (foreground == false) goto L5;
        return 1;
    L5:
        return 3;
    }

    private static int getCallbackType(int apiType, boolean hasListener, boolean hasIntent) {
        if (apiType != 5) goto L6;
        return 1;
    L6:
        if (hasIntent == false) goto L9;
        return 3;
    L9:
        if (hasListener == false) goto L12;
        return 2;
    L12:
        return 0;
    }

    private synchronized boolean hitApiUsageLogCap() {
        monitor-enter(this);
        long currentHour = Instant.now().toEpochMilli() / 3600000;     // Catch: Throwable -> L8
        boolean r3 = false;
        if (currentHour <= this.mLastApiUsageLogHour) goto L10;
        this.mLastApiUsageLogHour = currentHour;     // Catch: Throwable -> L8
        this.mApiUsageLogHourlyCount = 0;     // Catch: Throwable -> L8
        monitor-exit(this);
        return false;
    L10:
        this.mApiUsageLogHourlyCount = Math.min(this.mApiUsageLogHourlyCount + 1, 60);     // Catch: Throwable -> L8
        if (this.mApiUsageLogHourlyCount < 60) goto L13;
        r3 = true;
    L13:
        monitor-exit(this);
        return r3;
    L8:
        th = move-exception;
        throw th;
    }
}
