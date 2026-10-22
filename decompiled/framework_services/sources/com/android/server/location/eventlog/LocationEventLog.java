package com.android.server.location.eventlog;

import android.location.GnssMeasurementRequest;
import android.location.LocationRequest;
import android.location.provider.ProviderRequest;
import android.location.util.identity.CallerIdentity;
import android.os.SystemClock;
import android.util.ArrayMap;
import android.util.TimeUtils;
import com.android.internal.util.Preconditions;
import com.android.server.location.LocationLogsRecorder;
import com.android.server.location.LocationManagerService;
import com.android.server.slice.SliceClientPermissions;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes2.dex */
public class LocationEventLog extends LocalEventLog<Object> {
    public static final LocationEventLog EVENT_LOG = null;
    private final ArrayMap<String, ArrayMap<CallerIdentity, AggregateStats>> mAggregateStats;
    private final ArrayMap<CallerIdentity, GnssMeasurementAggregateStats> mGnssMeasAggregateStats;
    private final LocationsEventLog mLocationsLog;

    public static final class AggregateStats {
        private int mActiveRequestCount;
        private long mActiveTimeLastUpdateRealtimeMs;
        private long mActiveTimeTotalMs;
        private int mAddedRequestCount;
        private long mAddedTimeLastUpdateRealtimeMs;
        private long mAddedTimeTotalMs;
        private int mDeliveredLocationCount;
        private long mFastestIntervalMs;
        private int mForegroundRequestCount;
        private long mForegroundTimeLastUpdateRealtimeMs;
        private long mForegroundTimeTotalMs;
        private long mSlowestIntervalMs;

        AggregateStats() {
            this.mFastestIntervalMs = Long.MAX_VALUE;
            this.mSlowestIntervalMs = 0;
        }

        synchronized void markRequestAdded(long intervalMillis) {
            monitor-enter(this);
            int r0 = this.mAddedRequestCount;     // Catch: Throwable -> L6
            this.mAddedRequestCount = r0 + 1;     // Catch: Throwable -> L6
            if (r0 != 0) goto L8;
            this.mAddedTimeLastUpdateRealtimeMs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L6
        L8:
            this.mFastestIntervalMs = Math.min(intervalMillis, this.mFastestIntervalMs);     // Catch: Throwable -> L6
            this.mSlowestIntervalMs = Math.max(intervalMillis, this.mSlowestIntervalMs);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void markRequestRemoved() {
            monitor-enter(this);
            updateTotals();     // Catch: Throwable -> L8
            int r0 = this.mAddedRequestCount - 1;     // Catch: Throwable -> L8
            this.mAddedRequestCount = r0;     // Catch: Throwable -> L8
            if (r0 < 0) goto L10;
            this.mActiveRequestCount = Math.min(this.mAddedRequestCount, this.mActiveRequestCount);     // Catch: Throwable -> L8
            this.mForegroundRequestCount = Math.min(this.mAddedRequestCount, this.mForegroundRequestCount);     // Catch: Throwable -> L8
            monitor-exit(this);
            return;
        L10:
            StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L8
            r1.append("count error and reset mAddedRequestCount, mAddedRequestCount: ");     // Catch: Throwable -> L8
            int r2 = this.mAddedRequestCount;     // Catch: Throwable -> L8
            this.mAddedRequestCount = r2 + 1;     // Catch: Throwable -> L8
            r1.append(r2);     // Catch: Throwable -> L8
            r1.append(", mActiveRequestCount: ");     // Catch: Throwable -> L8
            r1.append(this.mActiveRequestCount);     // Catch: Throwable -> L8
            r1.append(", mForegroundRequestCount: ");     // Catch: Throwable -> L8
            r1.append(this.mForegroundRequestCount);     // Catch: Throwable -> L8
            throw new IllegalStateException(r1.toString());     // Catch: Throwable -> L8
        L8:
            th = move-exception;
            throw th;
        }

        synchronized void markRequestActive() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mAddedRequestCount <= 0) goto L6;
            boolean r0 = true;
        L7:
            Preconditions.checkState(r0);     // Catch: Throwable -> L11
            int r1 = this.mActiveRequestCount;     // Catch: Throwable -> L11
            this.mActiveRequestCount = r1 + 1;     // Catch: Throwable -> L11
            if (r1 != 0) goto L13;
            this.mActiveTimeLastUpdateRealtimeMs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        L13:
            monitor-exit(this);
            return;
        L6:
            r0 = false;
            goto L7
        }

        synchronized void markRequestInactive() {
            monitor-enter(this);
            updateTotals();     // Catch: Throwable -> L9
            int r0 = this.mActiveRequestCount - 1;     // Catch: Throwable -> L9
            this.mActiveRequestCount = r0;     // Catch: Throwable -> L9
            if (r0 < 0) goto L7;
            monitor-exit(this);
            return;
        L7:
            StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L9
            r1.append("count error and reset mActiveRequestCount, mAddedRequestCount: ");     // Catch: Throwable -> L9
            r1.append(this.mAddedRequestCount);     // Catch: Throwable -> L9
            r1.append(", mActiveRequestCount: ");     // Catch: Throwable -> L9
            int r2 = this.mActiveRequestCount;     // Catch: Throwable -> L9
            this.mActiveRequestCount = r2 + 1;     // Catch: Throwable -> L9
            r1.append(r2);     // Catch: Throwable -> L9
            r1.append(", mForegroundRequestCount: ");     // Catch: Throwable -> L9
            r1.append(this.mForegroundRequestCount);     // Catch: Throwable -> L9
            throw new IllegalStateException(r1.toString());     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        synchronized void markRequestForeground() {
            monitor-enter(this);
        L11:
            th = move-exception;
            throw th;
        L4:
            if (this.mAddedRequestCount <= 0) goto L6;
            boolean r0 = true;
        L7:
            Preconditions.checkState(r0);     // Catch: Throwable -> L11
            int r1 = this.mForegroundRequestCount;     // Catch: Throwable -> L11
            this.mForegroundRequestCount = r1 + 1;     // Catch: Throwable -> L11
            if (r1 != 0) goto L13;
            this.mForegroundTimeLastUpdateRealtimeMs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L11
        L13:
            monitor-exit(this);
            return;
        L6:
            r0 = false;
            goto L7
        }

        synchronized void markRequestBackground() {
            monitor-enter(this);
            updateTotals();     // Catch: Throwable -> L9
            int r0 = this.mForegroundRequestCount - 1;     // Catch: Throwable -> L9
            this.mForegroundRequestCount = r0;     // Catch: Throwable -> L9
            if (r0 < 0) goto L7;
            monitor-exit(this);
            return;
        L7:
            StringBuilder r1 = new StringBuilder();     // Catch: Throwable -> L9
            r1.append("count error and reset mForegroundRequestCount, mAddedRequestCount: ");     // Catch: Throwable -> L9
            r1.append(this.mAddedRequestCount);     // Catch: Throwable -> L9
            r1.append(", mActiveRequestCount: ");     // Catch: Throwable -> L9
            r1.append(this.mActiveRequestCount);     // Catch: Throwable -> L9
            r1.append(", mForegroundRequestCount: ");     // Catch: Throwable -> L9
            int r2 = this.mForegroundRequestCount;     // Catch: Throwable -> L9
            this.mForegroundRequestCount = r2 + 1;     // Catch: Throwable -> L9
            r1.append(r2);     // Catch: Throwable -> L9
            throw new IllegalStateException(r1.toString());     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            throw th;
        }

        synchronized void markLocationDelivered() {
            monitor-enter(this);
            this.mDeliveredLocationCount++;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void updateTotals() {
            monitor-enter(this);
        L6:
            th = move-exception;
            throw th;
        L4:
            if (this.mAddedRequestCount <= 0) goto L9;
            long realtimeMs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L6
            this.mAddedTimeTotalMs += realtimeMs - this.mAddedTimeLastUpdateRealtimeMs;     // Catch: Throwable -> L6
            this.mAddedTimeLastUpdateRealtimeMs = realtimeMs;     // Catch: Throwable -> L6
        L9:
            if (this.mActiveRequestCount <= 0) goto L12;
            long realtimeMs2 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L6
            this.mActiveTimeTotalMs += realtimeMs2 - this.mActiveTimeLastUpdateRealtimeMs;     // Catch: Throwable -> L6
            this.mActiveTimeLastUpdateRealtimeMs = realtimeMs2;     // Catch: Throwable -> L6
        L12:
            if (this.mForegroundRequestCount <= 0) goto L14;
            long realtimeMs3 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L6
            this.mForegroundTimeTotalMs += realtimeMs3 - this.mForegroundTimeLastUpdateRealtimeMs;     // Catch: Throwable -> L6
            this.mForegroundTimeLastUpdateRealtimeMs = realtimeMs3;     // Catch: Throwable -> L6
        L14:
            monitor-exit(this);
        }

        public synchronized String toString() {
            monitor-enter(this);
            String r0 = "min/max interval = " + intervalToString(this.mFastestIntervalMs) + SliceClientPermissions.SliceAuthority.DELIMITER + intervalToString(this.mSlowestIntervalMs) + ", total/active/foreground duration = " + TimeUtils.formatDuration(this.mAddedTimeTotalMs) + SliceClientPermissions.SliceAuthority.DELIMITER + TimeUtils.formatDuration(this.mActiveTimeTotalMs) + SliceClientPermissions.SliceAuthority.DELIMITER + TimeUtils.formatDuration(this.mForegroundTimeTotalMs) + ", locations = " + this.mDeliveredLocationCount;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        private static String intervalToString(long intervalMs) {
            if (intervalMs != Long.MAX_VALUE) goto L7;
            return "passive";
        L7:
            return TimeUnit.MILLISECONDS.toSeconds(intervalMs) + "s";
        }
    }

    public static final class GnssMeasurementAggregateStats {
        private int mAddedRequestCount;
        private long mAddedTimeLastUpdateRealtimeMs;
        private long mAddedTimeTotalMs;
        private long mFastestIntervalMs;
        private boolean mHasDutyCycling;
        private boolean mHasFullTracking;
        private int mReceivedMeasurementEventCount;
        private long mSlowestIntervalMs;

        GnssMeasurementAggregateStats() {
            this.mFastestIntervalMs = Long.MAX_VALUE;
            this.mSlowestIntervalMs = 0;
        }

        synchronized void markRequestAdded(long intervalMillis, boolean fullTracking) {
            monitor-enter(this);
            int r0 = this.mAddedRequestCount;     // Catch: Throwable -> L6
            this.mAddedRequestCount = r0 + 1;     // Catch: Throwable -> L6
            if (r0 != 0) goto L9;
            this.mAddedTimeLastUpdateRealtimeMs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L6
        L9:
            if (fullTracking == false) goto L11;
            this.mHasFullTracking = true;     // Catch: Throwable -> L6
        L12:
            this.mFastestIntervalMs = Math.min(intervalMillis, this.mFastestIntervalMs);     // Catch: Throwable -> L6
            this.mSlowestIntervalMs = Math.max(intervalMillis, this.mSlowestIntervalMs);     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L11:
            this.mHasDutyCycling = true;     // Catch: Throwable -> L6
        L6:
            th = move-exception;
            throw th;
        }

        synchronized void markRequestRemoved() {
            monitor-enter(this);
            updateTotals();     // Catch: Throwable -> L10
            boolean r1 = true;
            this.mAddedRequestCount--;     // Catch: Throwable -> L10
            if (this.mAddedRequestCount >= 0) goto L7;
            r1 = false;
        L7:
            Preconditions.checkState(r1);     // Catch: Throwable -> L10
            monitor-exit(this);
            return;
        L10:
            th = move-exception;
            throw th;
        }

        synchronized void markGnssMeasurementDelivered() {
            monitor-enter(this);
            this.mReceivedMeasurementEventCount++;     // Catch: Throwable -> L6
            monitor-exit(this);
            return;
        L6:
            th = move-exception;
            throw th;
        }

        public synchronized void updateTotals() {
            monitor-enter(this);
        L7:
            th = move-exception;
            throw th;
        L4:
            if (this.mAddedRequestCount <= 0) goto L9;
            long realtimeMs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L7
            this.mAddedTimeTotalMs += realtimeMs - this.mAddedTimeLastUpdateRealtimeMs;     // Catch: Throwable -> L7
            this.mAddedTimeLastUpdateRealtimeMs = realtimeMs;     // Catch: Throwable -> L7
        L9:
            monitor-exit(this);
        }

        public synchronized String toString() {
            monitor-enter(this);
            String r0 = "min/max interval = " + intervalToString(this.mFastestIntervalMs) + SliceClientPermissions.SliceAuthority.DELIMITER + intervalToString(this.mSlowestIntervalMs) + ", total duration = " + TimeUtils.formatDuration(this.mAddedTimeTotalMs) + ", tracking mode = " + trackingModeToString() + ", GNSS measurement events = " + this.mReceivedMeasurementEventCount;     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }

        private static String intervalToString(long intervalMs) {
            if (intervalMs != 2147483647L) goto L7;
            return "passive";
        L7:
            return TimeUnit.MILLISECONDS.toSeconds(intervalMs) + "s";
        }

        private String trackingModeToString() {
            if (this.mHasFullTracking == false) goto L9;
            if (this.mHasDutyCycling == false) goto L9;
            return "mixed tracking mode";
        L9:
            if (this.mHasFullTracking == false) goto L12;
            return "always full-tracking";
        L12:
            return "always duty-cycling";
        }
    }

    private static final class GnssMeasurementClientRegisterEvent {
        private final GnssMeasurementRequest mGnssMeasurementRequest;
        private final CallerIdentity mIdentity;
        private final boolean mRegistered;

        GnssMeasurementClientRegisterEvent(boolean registered, CallerIdentity identity, GnssMeasurementRequest measurementRequest) {
            this.mRegistered = registered;
            this.mIdentity = identity;
            this.mGnssMeasurementRequest = measurementRequest;
        }

        public String toString() {
            if (this.mRegistered == false) goto L7;
            return "gnss measurements +registration " + this.mIdentity + " -> " + this.mGnssMeasurementRequest;
        L7:
            return "gnss measurements -registration " + this.mIdentity;
        }
    }

    private static final class GnssMeasurementDeliverEvent {
        private final CallerIdentity mIdentity;
        private final int mNumGnssMeasurements;

        GnssMeasurementDeliverEvent(int numGnssMeasurements, CallerIdentity identity) {
            this.mNumGnssMeasurements = numGnssMeasurements;
            this.mIdentity = identity;
        }

        public String toString() {
            return "gnss measurements delivered GnssMeasurements[" + this.mNumGnssMeasurements + "] to " + this.mIdentity;
        }
    }

    private static final class LocationAdasEnabledEvent {
        private final boolean mEnabled;
        private final int mUserId;

        LocationAdasEnabledEvent(int userId, boolean enabled) {
            this.mUserId = userId;
            this.mEnabled = enabled;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("adas location [u");
            r0.append(this.mUserId);
            r0.append("] ");
            if (this.mEnabled == false) goto L5;
            String r1 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
        L6:
            r0.append(r1);
            return r0.toString();
        L5:
            r1 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
            goto L6
        }
    }

    private static final class LocationEnabledEvent {
        private final boolean mEnabled;
        private final int mUserId;

        LocationEnabledEvent(int userId, boolean enabled) {
            this.mUserId = userId;
            this.mEnabled = enabled;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("location [u");
            r0.append(this.mUserId);
            r0.append("] ");
            if (this.mEnabled == false) goto L5;
            String r1 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
        L6:
            r0.append(r1);
            return r0.toString();
        L5:
            r1 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
            goto L6
        }
    }

    private static final class LocationPowerSaveModeEvent {
        private final int mLocationPowerSaveMode;

        LocationPowerSaveModeEvent(int locationPowerSaveMode) {
            this.mLocationPowerSaveMode = locationPowerSaveMode;
        }

        public String toString() {
            switch(this.mLocationPowerSaveMode) {
                case 0: goto L9;
                case 1: goto L8;
                case 2: goto L7;
                case 3: goto L6;
                case 4: goto L5;
                default: goto L4;
            };
        L4:
            String mode = "UNKNOWN";
        L11:
            return "location power save mode changed to " + mode;
        L5:
            mode = "THROTTLE_REQUESTS_WHEN_SCREEN_OFF";
            goto L11
        L6:
            mode = "FOREGROUND_ONLY";
            goto L11
        L7:
            mode = "ALL_DISABLED_WHEN_SCREEN_OFF";
            goto L11
        L8:
            mode = "GPS_DISABLED_WHEN_SCREEN_OFF";
            goto L11
        L9:
            mode = "NO_CHANGE";
            goto L11
        }
    }

    private static final class LocationsEventLog extends LocalEventLog<Object> {
        LocationsEventLog(int size) {
            super(size, Object.class);
        }

        public void logProviderReceivedLocations(String provider, int numLocations) {
            addLog(new ProviderReceiveLocationEvent(provider, numLocations));
        }

        public void logDeliveredGnssMeasurements(int numGnssMeasurements, CallerIdentity identity) {
            addLog(new GnssMeasurementDeliverEvent(numGnssMeasurements, identity));
        }

        public void logProviderDeliveredLocations(String provider, int numLocations, CallerIdentity identity) {
            LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_GNSS, new ProviderDeliverLocationEvent(provider, numLocations, identity).toString());
        }

        private void addLog(Object logEvent) {
            addLog(SystemClock.elapsedRealtime(), logEvent);
        }
    }

    private static final class ProviderClientForegroundEvent extends ProviderEvent {
        private final boolean mForeground;
        private final CallerIdentity mIdentity;

        ProviderClientForegroundEvent(String provider, boolean foreground, CallerIdentity identity) {
            super(provider);
            this.mForeground = foreground;
            this.mIdentity = identity;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append(this.mProvider);
            r0.append(" provider client ");
            r0.append(this.mIdentity);
            r0.append(" -> ");
            if (this.mForeground == false) goto L5;
            String r1 = "foreground";
        L6:
            r0.append(r1);
            return r0.toString();
        L5:
            r1 = "background";
            goto L6
        }
    }

    private static final class ProviderClientPermittedEvent extends ProviderEvent {
        private final CallerIdentity mIdentity;
        private final boolean mPermitted;

        ProviderClientPermittedEvent(String provider, boolean permitted, CallerIdentity identity) {
            super(provider);
            this.mPermitted = permitted;
            this.mIdentity = identity;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append(this.mProvider);
            r0.append(" provider client ");
            r0.append(this.mIdentity);
            r0.append(" -> ");
            if (this.mPermitted == false) goto L5;
            String r1 = "permitted";
        L6:
            r0.append(r1);
            return r0.toString();
        L5:
            r1 = "unpermitted";
            goto L6
        }
    }

    private static final class ProviderClientRegisterEvent extends ProviderEvent {
        private final CallerIdentity mIdentity;
        private final LocationRequest mLocationRequest;
        private final boolean mRegistered;

        ProviderClientRegisterEvent(String provider, boolean registered, CallerIdentity identity, LocationRequest locationRequest) {
            super(provider);
            this.mRegistered = registered;
            this.mIdentity = identity;
            this.mLocationRequest = locationRequest;
        }

        public String toString() {
            if (this.mRegistered == false) goto L7;
            return this.mProvider + " provider +registration " + this.mIdentity + " -> " + this.mLocationRequest;
        L7:
            return this.mProvider + " provider -registration " + this.mIdentity;
        }
    }

    private static final class ProviderDeliverLocationEvent extends ProviderEvent {
        private final CallerIdentity mIdentity;
        private final int mNumLocations;

        ProviderDeliverLocationEvent(String provider, int numLocations, CallerIdentity identity) {
            super(provider);
            this.mNumLocations = numLocations;
            this.mIdentity = identity;
        }

        public String toString() {
            return this.mProvider + " provider delivered location[" + this.mNumLocations + "] to " + this.mIdentity;
        }
    }

    private static final class ProviderEnabledEvent extends ProviderEvent {
        private final boolean mEnabled;
        private final int mUserId;

        ProviderEnabledEvent(String provider, int userId, boolean enabled) {
            super(provider);
            this.mUserId = userId;
            this.mEnabled = enabled;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append(this.mProvider);
            r0.append(" provider [u");
            r0.append(this.mUserId);
            r0.append("] ");
            if (this.mEnabled == false) goto L5;
            String r1 = ServiceConfigAccessor.PROVIDER_MODE_ENABLED;
        L6:
            r0.append(r1);
            return r0.toString();
        L5:
            r1 = ServiceConfigAccessor.PROVIDER_MODE_DISABLED;
            goto L6
        }
    }

    private static abstract class ProviderEvent {
        protected final String mProvider;

        ProviderEvent(String provider) {
            this.mProvider = provider;
        }
    }

    private static final class ProviderMockedEvent extends ProviderEvent {
        private final boolean mMocked;

        ProviderMockedEvent(String provider, boolean mocked) {
            super(provider);
            this.mMocked = mocked;
        }

        public String toString() {
            if (this.mMocked == false) goto L7;
            return this.mProvider + " provider added mock provider override";
        L7:
            return this.mProvider + " provider removed mock provider override";
        }
    }

    private static final class ProviderReceiveLocationEvent extends ProviderEvent {
        private final int mNumLocations;

        ProviderReceiveLocationEvent(String provider, int numLocations) {
            super(provider);
            this.mNumLocations = numLocations;
        }

        public String toString() {
            return this.mProvider + " provider received location[" + this.mNumLocations + "]";
        }
    }

    private static final class ProviderStationaryThrottledEvent extends ProviderEvent {
        private final ProviderRequest mRequest;
        private final boolean mStationaryThrottled;

        ProviderStationaryThrottledEvent(String provider, boolean stationaryThrottled, ProviderRequest request) {
            super(provider);
            this.mStationaryThrottled = stationaryThrottled;
            this.mRequest = request;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append(this.mProvider);
            r0.append(" provider stationary/idle ");
            if (this.mStationaryThrottled == false) goto L5;
            String r1 = "throttled";
        L6:
            r0.append(r1);
            r0.append(", request = ");
            r0.append(this.mRequest);
            return r0.toString();
        L5:
            r1 = "unthrottled";
            goto L6
        }
    }

    private static final class ProviderUpdateEvent extends ProviderEvent {
        private final ProviderRequest mRequest;

        ProviderUpdateEvent(String provider, ProviderRequest request) {
            super(provider);
            this.mRequest = request;
        }

        public String toString() {
            return this.mProvider + " provider request = " + this.mRequest;
        }
    }

    private static final class UserSwitchedEvent {
        private final int mUserIdFrom;
        private final int mUserIdTo;

        UserSwitchedEvent(int userIdFrom, int userIdTo) {
            this.mUserIdFrom = userIdFrom;
            this.mUserIdTo = userIdTo;
        }

        public String toString() {
            return "current user switched from u" + this.mUserIdFrom + " to u" + this.mUserIdTo;
        }
    }

    private static final class UserVisibilityChangedEvent {
        private final int mUserId;
        private final boolean mVisible;

        UserVisibilityChangedEvent(int userId, boolean visible) {
            this.mUserId = userId;
            this.mVisible = visible;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("[u");
            r0.append(this.mUserId);
            r0.append("] ");
            if (this.mVisible == false) goto L5;
            String r1 = "visible";
        L6:
            r0.append(r1);
            return r0.toString();
        L5:
            r1 = "invisible";
            goto L6
        }
    }

    public static /* synthetic */ void $r8$lambda$KOd46brQpZVZRvRPF6zGed26kJM(String r0, StringBuilder r1, long r2, Consumer r4, long r5, Object r7) {
        lambda$iterate$0(r0, r1, r2, r4, r5, r7);
    }

    static {
        EVENT_LOG = new LocationEventLog();
    }

    private static int getLogSize() {
        if (LocationManagerService.D == false) goto L6;
        return 600;
    L6:
        return 300;
    }

    private static int getLocationsLogSize() {
        if (LocationManagerService.D == false) goto L6;
        return 400;
    L6:
        return 200;
    }

    private LocationEventLog() {
        super(getLogSize(), Object.class);
        this.mAggregateStats = new ArrayMap(4);
        this.mGnssMeasAggregateStats = new ArrayMap();
        this.mLocationsLog = new LocationsEventLog(getLocationsLogSize());
    }

    public ArrayMap<String, ArrayMap<CallerIdentity, AggregateStats>> copyAggregateStats() {
        ArrayMap<String, ArrayMap<CallerIdentity, AggregateStats>> r0 = this.mAggregateStats;
        monitor-enter(r0);
        ArrayMap<String, ArrayMap<CallerIdentity, AggregateStats>> copy = new ArrayMap(this.mAggregateStats);     // Catch: Throwable -> L8
        int i = 0;
    L6:
        if (i >= copy.size()) goto L11;
        copy.setValueAt(i, new ArrayMap(copy.valueAt(i)));     // Catch: Throwable -> L8
        i = i + 1;     // Catch: Throwable -> L8
        goto L6
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return copy;
    L8:
        th = move-exception;
        throw th;
    }

    private AggregateStats getAggregateStats(String provider, CallerIdentity identity) {
        ArrayMap<String, ArrayMap<CallerIdentity, AggregateStats>> r0 = this.mAggregateStats;
        monitor-enter(r0);
        ArrayMap<CallerIdentity, AggregateStats> packageMap = this.mAggregateStats.get(provider);     // Catch: Throwable -> L7
        if (packageMap != null) goto L9;
        packageMap = new ArrayMap(2);     // Catch: Throwable -> L7
        this.mAggregateStats.put(provider, packageMap);     // Catch: Throwable -> L7
    L9:
        CallerIdentity aggregate = CallerIdentity.forAggregation(identity);     // Catch: Throwable -> L7
        AggregateStats stats = packageMap.get(aggregate);     // Catch: Throwable -> L7
        if (stats != null) goto L12;
        stats = new AggregateStats();     // Catch: Throwable -> L7
        packageMap.put(aggregate, stats);     // Catch: Throwable -> L7
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return stats;
    L7:
        th = move-exception;
        throw th;
    }

    public ArrayMap<CallerIdentity, GnssMeasurementAggregateStats> copyGnssMeasurementAggregateStats() {
        ArrayMap<CallerIdentity, GnssMeasurementAggregateStats> r0 = this.mGnssMeasAggregateStats;
        monitor-enter(r0);
        ArrayMap<CallerIdentity, GnssMeasurementAggregateStats> copy = new ArrayMap(this.mGnssMeasAggregateStats);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return copy;
    L7:
        th = move-exception;
        throw th;
    }

    private GnssMeasurementAggregateStats getGnssMeasurementAggregateStats(CallerIdentity identity) {
        ArrayMap<CallerIdentity, GnssMeasurementAggregateStats> r0 = this.mGnssMeasAggregateStats;
        monitor-enter(r0);
        CallerIdentity aggregate = CallerIdentity.forAggregation(identity);     // Catch: Throwable -> L7
        GnssMeasurementAggregateStats stats = this.mGnssMeasAggregateStats.get(aggregate);     // Catch: Throwable -> L7
        if (stats != null) goto L9;
        stats = new GnssMeasurementAggregateStats();     // Catch: Throwable -> L7
        this.mGnssMeasAggregateStats.put(aggregate, stats);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
        return stats;
    L7:
        th = move-exception;
        throw th;
    }

    public void logUserSwitched(int userIdFrom, int userIdTo) {
        addLog(new UserSwitchedEvent(userIdFrom, userIdTo));
    }

    public void logUserVisibilityChanged(int userId, boolean visible) {
        addLog(new UserVisibilityChangedEvent(userId, visible));
    }

    public void logLocationEnabled(int userId, boolean enabled) {
        addLog(new LocationEnabledEvent(userId, enabled));
    }

    public void logAdasLocationEnabled(int userId, boolean enabled) {
        addLog(new LocationAdasEnabledEvent(userId, enabled));
    }

    public void logProviderEnabled(String provider, int userId, boolean enabled) {
        addLog(new ProviderEnabledEvent(provider, userId, enabled));
    }

    public void logProviderMocked(String provider, boolean mocked) {
        addLog(new ProviderMockedEvent(provider, mocked));
    }

    public void logErrorEvent(String errMsg) {
        addLog(errMsg);
    }

    public void logProviderClientRegistered(String provider, CallerIdentity identity, LocationRequest request) {
        addLog(new ProviderClientRegisterEvent(provider, true, identity, request));
        getAggregateStats(provider, identity).markRequestAdded(request.getIntervalMillis());
    }

    public void logProviderClientUnregistered(String provider, CallerIdentity identity) {
        addLog(new ProviderClientRegisterEvent(provider, false, identity, null));
        getAggregateStats(provider, identity).markRequestRemoved();
    }

    public void logProviderClientActive(String provider, CallerIdentity identity) {
        getAggregateStats(provider, identity).markRequestActive();
    }

    public void logProviderClientInactive(String provider, CallerIdentity identity) {
        getAggregateStats(provider, identity).markRequestInactive();
    }

    public void logProviderClientForeground(String provider, CallerIdentity identity) {
        if (LocationManagerService.D == false) goto L5;
        addLog(new ProviderClientForegroundEvent(provider, true, identity));
    L5:
        getAggregateStats(provider, identity).markRequestForeground();
    }

    public void logProviderClientBackground(String provider, CallerIdentity identity) {
        if (LocationManagerService.D == false) goto L5;
        addLog(new ProviderClientForegroundEvent(provider, false, identity));
    L5:
        getAggregateStats(provider, identity).markRequestBackground();
    }

    public void logProviderClientPermitted(String provider, CallerIdentity identity) {
        if (LocationManagerService.D == false) goto L6;
        addLog(new ProviderClientPermittedEvent(provider, true, identity));
        return;
    }

    public void logProviderClientUnpermitted(String provider, CallerIdentity identity) {
        if (LocationManagerService.D == false) goto L6;
        addLog(new ProviderClientPermittedEvent(provider, false, identity));
        return;
    }

    public void logProviderUpdateRequest(String provider, ProviderRequest request) {
        addLog(new ProviderUpdateEvent(provider, request));
    }

    public void logProviderReceivedLocations(String provider, int numLocations) {
        monitor-enter(this);
        this.mLocationsLog.logProviderReceivedLocations(provider, numLocations);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void logProviderDeliveredLocations(String provider, int numLocations, CallerIdentity identity) {
        monitor-enter(this);
        this.mLocationsLog.logProviderDeliveredLocations(provider, numLocations, identity);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        getAggregateStats(provider, identity).markLocationDelivered();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void logProviderStationaryThrottled(String provider, boolean throttled, ProviderRequest request) {
        addLog(new ProviderStationaryThrottledEvent(provider, throttled, request));
    }

    public void logLocationPowerSaveMode(int locationPowerSaveMode) {
        addLog(new LocationPowerSaveModeEvent(locationPowerSaveMode));
    }

    public void logGnssMeasurementClientRegistered(CallerIdentity identity, GnssMeasurementRequest request) {
        addLog(new GnssMeasurementClientRegisterEvent(true, identity, request));
        getGnssMeasurementAggregateStats(identity).markRequestAdded(request.getIntervalMillis(), request.isFullTracking());
    }

    public void logGnssMeasurementClientUnregistered(CallerIdentity identity) {
        addLog(new GnssMeasurementClientRegisterEvent(false, identity, null));
        getGnssMeasurementAggregateStats(identity).markRequestRemoved();
    }

    public void logGnssMeasurementsDelivered(int numGnssMeasurements, CallerIdentity identity) {
        monitor-enter(this);
        this.mLocationsLog.logDeliveredGnssMeasurements(numGnssMeasurements, identity);     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        getGnssMeasurementAggregateStats(identity).markGnssMeasurementDelivered();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void addLog(Object logEvent) {
        addLog(SystemClock.elapsedRealtime(), logEvent);
    }

    @Override // com.android.server.location.eventlog.LocalEventLog
    public synchronized void iterate(LocalEventLog.LogConsumer<? super Object> consumer) {
        monitor-enter(this);
        LocalEventLog.iterate(consumer, new LocalEventLog[]{this, this.mLocationsLog});     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void iterate(Consumer<String> consumer) {
        iterate(consumer, null);
    }

    public void iterate(final Consumer<String> consumer, final String providerFilter) {
        final long systemTimeDeltaMs = System.currentTimeMillis() - SystemClock.elapsedRealtime();
        final StringBuilder builder = new StringBuilder();
        iterate(new LocationEventLog$$ExternalSyntheticLambda0(providerFilter, builder, systemTimeDeltaMs, consumer));
    }

    private static /* synthetic */ void lambda$iterate$0(String providerFilter, StringBuilder builder, long systemTimeDeltaMs, Consumer consumer, long time, Object logEvent) {
        if (providerFilter != null) goto L5;
    L10:
        boolean match = true;
    L12:
        if (match == false) goto L15;
        builder.setLength(0);
        builder.append(TimeUtils.logTimeOfDay(time + systemTimeDeltaMs));
        builder.append(": ");
        builder.append(logEvent);
        consumer.accept(builder.toString());
        return;
    L15:
        return;
    L5:
        if ((logEvent instanceof ProviderEvent) == true) goto L7;
    L9:
        match = false;
        goto L12
    L7:
        if (providerFilter.equals(((ProviderEvent) logEvent).mProvider) == false) goto L9;
        goto L9
    }
}
