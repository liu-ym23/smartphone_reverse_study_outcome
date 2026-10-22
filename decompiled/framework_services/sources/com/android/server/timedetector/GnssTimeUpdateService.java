package com.android.server.timedetector;

import android.app.AlarmManager;
import android.app.time.UnixEpochTime;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationManagerInternal;
import android.location.LocationRequest;
import android.location.LocationTime;
import android.os.Binder;
import android.os.Handler;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.os.SystemClock;
import android.util.LocalLog;
import android.util.Log;
import com.android.internal.util.DumpUtils;
import com.android.server.FgThread;
import com.android.server.LocalServices;
import com.android.server.SystemService;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
public final class GnssTimeUpdateService extends Binder {
    private static final String ATTRIBUTION_TAG = "GnssTimeUpdateService";
    private static final boolean D = false;
    private static final Duration GNSS_TIME_UPDATE_ALARM_INTERVAL = null;
    private static final String TAG = "GnssTimeUpdateService";
    private AlarmManager.OnAlarmListener mAlarmListener;
    private final AlarmManager mAlarmManager;
    private final Context mContext;
    private final Executor mExecutor;
    private final Handler mHandler;
    private volatile UnixEpochTime mLastSuggestedGnssTime;
    private final LocalLog mLocalLog;
    private LocationListener mLocationListener;
    private final LocationManager mLocationManager;
    private final LocationManagerInternal mLocationManagerInternal;
    private final Object mLock;
    private final TimeDetectorInternal mTimeDetectorInternal;

    public static class Lifecycle extends SystemService {
        private GnssTimeUpdateService mService;

        public Lifecycle(Context context) {
            super(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            Context context = getContext().createAttributionContext("GnssTimeUpdateService");
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(AlarmManager.class);
            LocationManager locationManager = (LocationManager) context.getSystemService(LocationManager.class);
            LocationManagerInternal locationManagerInternal = (LocationManagerInternal) LocalServices.getService(LocationManagerInternal.class);
            TimeDetectorInternal timeDetectorInternal = (TimeDetectorInternal) LocalServices.getService(TimeDetectorInternal.class);
            this.mService = new GnssTimeUpdateService(context, alarmManager, locationManager, locationManagerInternal, timeDetectorInternal);
            publishBinderService("gnss_time_update_service", this.mService);
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (phase != 600) goto L6;
            this.mService.startGnssListeningInternal();
            return;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$XecnK8MW6u--EMgleTYtRmL2pJQ, reason: not valid java name */
    public static /* synthetic */ void m8548$r8$lambda$XecnK8MW6uEMgleTYtRmL2pJQ(GnssTimeUpdateService r0) {
        r0.handleAlarmFired();
    }

    public static /* synthetic */ void $r8$lambda$cmXF1vg9wuwtSmQdYD7XxzAlzFU(GnssTimeUpdateService r0, Location r1) {
        r0.lambda$startGnssListeningLocked$0(r1);
    }

    static {
        D = Log.isLoggable("GnssTimeUpdateService", 3);
        GNSS_TIME_UPDATE_ALARM_INTERVAL = Duration.ofHours(4);
    }

    GnssTimeUpdateService(Context context, AlarmManager alarmManager, LocationManager locationManager, LocationManagerInternal locationManagerInternal, TimeDetectorInternal timeDetectorInternal) {
        this.mLocalLog = new LocalLog(10, false);
        this.mExecutor = FgThread.getExecutor();
        this.mHandler = FgThread.getHandler();
        this.mLock = new Object();
        context.getClass();
        this.mContext = context;
        alarmManager.getClass();
        this.mAlarmManager = alarmManager;
        locationManager.getClass();
        this.mLocationManager = locationManager;
        locationManagerInternal.getClass();
        this.mLocationManagerInternal = locationManagerInternal;
        timeDetectorInternal.getClass();
        this.mTimeDetectorInternal = timeDetectorInternal;
    }

    boolean startGnssListening() {
        this.mContext.enforceCallingPermission("android.permission.SET_TIME", "Start GNSS listening");
        this.mLocalLog.log("startGnssListening() called");
        long token = Binder.clearCallingIdentity();
        boolean r2 = startGnssListeningInternal();     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(token);
        return r2;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(token);
        throw th;
    }

    boolean startGnssListeningInternal() {
        if (this.mLocationManager.hasProvider("gps") == true) goto L6;
        logError("GPS provider does not exist on this device");
        return false;
    L6:
        Object r0 = this.mLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (this.mLocationListener == null) goto L16;
        logDebug("Already listening for GNSS updates");     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L16:
        if (this.mAlarmListener == null) goto L18;
        this.mAlarmManager.cancel(this.mAlarmListener);     // Catch: Throwable -> L13
        this.mAlarmListener = null;     // Catch: Throwable -> L13
    L18:
        startGnssListeningLocked();     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    }

    private void startGnssListeningLocked() {
        logDebug("startGnssListeningLocked()");
        this.mLocationListener = new GnssTimeUpdateService$$ExternalSyntheticLambda1(this);
        this.mLocationManager.requestLocationUpdates("gps", new LocationRequest.Builder(Long.MAX_VALUE).setMinUpdateIntervalMillis(0).build(), this.mExecutor, this.mLocationListener);
    }

    private /* synthetic */ void lambda$startGnssListeningLocked$0(Location location) {
        handleLocationAvailable();
    }

    private void handleLocationAvailable() {
        logDebug("handleLocationAvailable()");
        LocationTime locationTime = this.mLocationManagerInternal.getGnssTimeMillis();
        if (locationTime == null) goto L5;
        String msg = "Passive location time received: " + locationTime;
        logDebug(msg);
        this.mLocalLog.log(msg);
        suggestGnssTime(locationTime);
    L6:
        Object r2 = this.mLock;
        monitor-enter(r2);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (this.mLocationListener != null) goto L13;
        logWarning("mLocationListener unexpectedly null");     // Catch: Throwable -> L11
    L15:
        if (this.mAlarmListener == null) goto L17;
        logWarning("mAlarmListener was unexpectedly non-null");     // Catch: Throwable -> L11
        this.mAlarmManager.cancel(this.mAlarmListener);     // Catch: Throwable -> L11
    L17:
        long next = SystemClock.elapsedRealtime() + GNSS_TIME_UPDATE_ALARM_INTERVAL.toMillis();     // Catch: Throwable -> L11
        this.mAlarmListener = new GnssTimeUpdateService$$ExternalSyntheticLambda0(this);     // Catch: Throwable -> L11
        this.mAlarmManager.set(2, next, "GnssTimeUpdateService", this.mAlarmListener, this.mHandler);     // Catch: Throwable -> L11
        monitor-exit(r2);     // Catch: Throwable -> L11
        return;
    L13:
        this.mLocationManager.removeUpdates(this.mLocationListener);     // Catch: Throwable -> L11
        this.mLocationListener = null;     // Catch: Throwable -> L11
        goto L15
    L5:
        logDebug("getGnssTimeMillis() returned null");
        goto L6
    }

    private void handleAlarmFired() {
        logDebug("handleAlarmFired()");
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mAlarmListener = null;     // Catch: Throwable -> L8
        startGnssListeningLocked();     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    private void suggestGnssTime(LocationTime locationTime) {
        logDebug("suggestGnssTime()");
        long gnssUnixEpochTimeMillis = locationTime.getUnixEpochTimeMillis();
        long elapsedRealtimeMs = locationTime.getElapsedRealtimeNanos() / 1000000;
        UnixEpochTime unixEpochTime = new UnixEpochTime(elapsedRealtimeMs, gnssUnixEpochTimeMillis);
        this.mLastSuggestedGnssTime = unixEpochTime;
        GnssTimeSuggestion suggestion = new GnssTimeSuggestion(unixEpochTime);
        this.mTimeDetectorInternal.suggestGnssTime(suggestion);
    }

    @Override // android.os.Binder
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, "GnssTimeUpdateService", pw) == true) goto L5;
        return;
    L5:
        pw.println("mLastSuggestedGnssTime: " + this.mLastSuggestedGnssTime);
        Object r0 = this.mLock;
        monitor-enter(r0);
        pw.print("state: ");     // Catch: Throwable -> L10
        if (this.mLocationListener == null) goto L12;
        pw.println("time updates enabled");     // Catch: Throwable -> L10
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L10
        pw.println("Log:");
        this.mLocalLog.dump(pw);
        return;
    L12:
        pw.println("alarm enabled");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new GnssTimeUpdateServiceShellCommand(this).exec(this, in, out, err, args, callback, resultReceiver);
    }

    private void logError(String msg) {
        Log.e("GnssTimeUpdateService", msg);
        this.mLocalLog.log(msg);
    }

    private void logWarning(String msg) {
        Log.w("GnssTimeUpdateService", msg);
        this.mLocalLog.log(msg);
    }

    private void logDebug(String msg) {
        if (D == false) goto L6;
        Log.d("GnssTimeUpdateService", msg);
        return;
    }
}
