package com.android.server.location.provider;

import android.location.Location;
import android.location.LocationResult;
import android.location.provider.ProviderRequest;
import android.os.SystemClock;
import android.util.Log;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.Preconditions;
import com.android.server.DeviceIdleInternal;
import com.android.server.FgThread;
import com.android.server.location.LocationManagerService;
import com.android.server.location.eventlog.LocationEventLog;
import com.android.server.location.injector.DeviceIdleHelper;
import com.android.server.location.injector.DeviceStationaryHelper;
import com.android.server.location.injector.Injector;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public final class StationaryThrottlingLocationProvider extends DelegateLocationProvider implements DeviceIdleHelper.DeviceIdleListener, DeviceIdleInternal.StationaryListener {
    private static final long MAX_STATIONARY_LOCATION_AGE_MS = 30000;
    private static final long MIN_INTERVAL_MS = 1000;
    DeliverLastLocationRunnable mDeliverLastLocationCallback;
    private boolean mDeviceIdle;
    private final DeviceIdleHelper mDeviceIdleHelper;
    private boolean mDeviceStationary;
    private final DeviceStationaryHelper mDeviceStationaryHelper;
    private long mDeviceStationaryRealtimeMs;
    private ProviderRequest mIncomingRequest;
    Location mLastLocation;
    final Object mLock;
    private final String mName;
    private ProviderRequest mOutgoingRequest;
    long mThrottlingIntervalMs;

    private class DeliverLastLocationRunnable implements Runnable {
        final /* synthetic */ StationaryThrottlingLocationProvider this$0;

        DeliverLastLocationRunnable(StationaryThrottlingLocationProvider r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r0 = this.this$0.mLock;
            monitor-enter(r0);
        L8:
            th = move-exception;
            throw th;
        L5:
            if (this.this$0.mDeliverLastLocationCallback == this) goto L11;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L11:
            if (this.this$0.mLastLocation != null) goto L14;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return;
        L14:
            Location location = new Location(this.this$0.mLastLocation);     // Catch: Throwable -> L8
            location.setTime(System.currentTimeMillis());     // Catch: Throwable -> L8
            location.setElapsedRealtimeNanos(SystemClock.elapsedRealtimeNanos());     // Catch: Throwable -> L8
            if (location.hasSpeed() == false) goto L20;
            location.removeSpeed();     // Catch: Throwable -> L8
            if (location.hasSpeedAccuracy() == false) goto L20;
            location.removeSpeedAccuracy();     // Catch: Throwable -> L8
        L20:
            if (location.hasBearing() == false) goto L24;
            location.removeBearing();     // Catch: Throwable -> L8
            if (location.hasBearingAccuracy() == false) goto L24;
            location.removeBearingAccuracy();     // Catch: Throwable -> L8
        L24:
            this.this$0.mLastLocation = location;     // Catch: Throwable -> L8
            FgThread.getHandler().postDelayed(this, this.this$0.mThrottlingIntervalMs);     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            this.this$0.reportLocation(LocationResult.wrap(new Location[]{location}));
        }
    }

    @Override // com.android.server.location.provider.DelegateLocationProvider, com.android.server.location.provider.AbstractLocationProvider.Listener
    public /* bridge */ /* synthetic */ void onStateChanged(AbstractLocationProvider.State r1, AbstractLocationProvider.State r2) {
        super.onStateChanged(r1, r2);
    }

    public StationaryThrottlingLocationProvider(String name, Injector injector, AbstractLocationProvider delegate) {
        super(ConcurrentUtils.DIRECT_EXECUTOR, delegate);
        this.mLock = new Object();
        this.mDeviceIdle = false;
        this.mDeviceStationary = false;
        this.mDeviceStationaryRealtimeMs = Long.MIN_VALUE;
        this.mIncomingRequest = ProviderRequest.EMPTY_REQUEST;
        this.mOutgoingRequest = ProviderRequest.EMPTY_REQUEST;
        this.mThrottlingIntervalMs = Long.MAX_VALUE;
        this.mDeliverLastLocationCallback = null;
        this.mName = name;
        this.mDeviceIdleHelper = injector.getDeviceIdleHelper();
        this.mDeviceStationaryHelper = injector.getDeviceStationaryHelper();
        initializeDelegate();
    }

    @Override // com.android.server.location.provider.DelegateLocationProvider, com.android.server.location.provider.AbstractLocationProvider.Listener
    public void onReportLocation(LocationResult locationResult) {
        super.onReportLocation(locationResult);
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLastLocation = locationResult.getLastLocation();     // Catch: Throwable -> L7
        onThrottlingChangedLocked(false);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.location.provider.DelegateLocationProvider, com.android.server.location.provider.AbstractLocationProvider
    protected void onStart() {
        this.mDelegate.getController().start();
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDeviceIdleHelper.addListener(this);     // Catch: Throwable -> L7
        onDeviceIdleChanged(this.mDeviceIdleHelper.isDeviceIdle());     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.location.provider.DelegateLocationProvider, com.android.server.location.provider.AbstractLocationProvider
    protected void onStop() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mDeviceIdleHelper.removeListener(this);     // Catch: Throwable -> L7
        onDeviceIdleChanged(false);     // Catch: Throwable -> L7
        this.mIncomingRequest = ProviderRequest.EMPTY_REQUEST;     // Catch: Throwable -> L7
        this.mOutgoingRequest = ProviderRequest.EMPTY_REQUEST;     // Catch: Throwable -> L7
        this.mThrottlingIntervalMs = Long.MAX_VALUE;     // Catch: Throwable -> L7
        if (this.mDeliverLastLocationCallback == null) goto L9;
        FgThread.getHandler().removeCallbacks(this.mDeliverLastLocationCallback);     // Catch: Throwable -> L7
        this.mDeliverLastLocationCallback = null;     // Catch: Throwable -> L7
    L9:
        this.mLastLocation = null;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        this.mDelegate.getController().stop();
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.location.provider.DelegateLocationProvider, com.android.server.location.provider.AbstractLocationProvider
    protected void onSetRequest(ProviderRequest request) {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mIncomingRequest = request;     // Catch: Throwable -> L7
        onThrottlingChangedLocked(true);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.android.server.location.injector.DeviceIdleHelper.DeviceIdleListener
    public void onDeviceIdleChanged(boolean deviceIdle) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (deviceIdle != this.mDeviceIdle) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        this.mDeviceIdle = deviceIdle;     // Catch: Throwable -> L8
        if (deviceIdle == false) goto L13;
        this.mDeviceStationaryHelper.addListener(this);     // Catch: Throwable -> L8
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L13:
        this.mDeviceStationaryHelper.removeListener(this);     // Catch: Throwable -> L8
        this.mDeviceStationary = false;     // Catch: Throwable -> L8
        this.mDeviceStationaryRealtimeMs = Long.MIN_VALUE;     // Catch: Throwable -> L8
        onThrottlingChangedLocked(false);     // Catch: Throwable -> L8
        goto L14
    }

    public void onDeviceStationaryChanged(boolean deviceStationary) {
        Object r0 = this.mLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mDeviceIdle == true) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L11:
        if (this.mDeviceStationary != deviceStationary) goto L14;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L14:
        this.mDeviceStationary = deviceStationary;     // Catch: Throwable -> L8
        if (this.mDeviceStationary == false) goto L17;
        this.mDeviceStationaryRealtimeMs = SystemClock.elapsedRealtime();     // Catch: Throwable -> L8
    L18:
        onThrottlingChangedLocked(false);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L17:
        this.mDeviceStationaryRealtimeMs = Long.MIN_VALUE;     // Catch: Throwable -> L8
        goto L18
    }

    private void onThrottlingChangedLocked(boolean deliverImmediate) {
        long throttlingIntervalMs = Long.MAX_VALUE;
        if (this.mDeviceStationary == false) goto L16;
        if (this.mDeviceIdle == false) goto L16;
        if (this.mIncomingRequest.isLocationSettingsIgnored() == true) goto L16;
        if (this.mIncomingRequest.getQuality() == 100) goto L16;
        if (this.mLastLocation == null) goto L16;
        if (this.mLastLocation.getElapsedRealtimeAgeMillis(this.mDeviceStationaryRealtimeMs) > 30000) goto L16;
        throttlingIntervalMs = Math.max(this.mIncomingRequest.getIntervalMillis(), 1000);
    L16:
        if (throttlingIntervalMs == Long.MAX_VALUE) goto L18;
        ProviderRequest newRequest = ProviderRequest.EMPTY_REQUEST;
    L20:
        if (newRequest.equals(this.mOutgoingRequest) == true) goto L23;
        this.mOutgoingRequest = newRequest;
        this.mDelegate.getController().setRequest(this.mOutgoingRequest);
    L23:
        if (throttlingIntervalMs != this.mThrottlingIntervalMs) goto L25;
        return;
    L25:
        long oldThrottlingIntervalMs = this.mThrottlingIntervalMs;
        this.mThrottlingIntervalMs = throttlingIntervalMs;
        boolean r8 = false;
        if (this.mThrottlingIntervalMs == Long.MAX_VALUE) goto L44;
        if (oldThrottlingIntervalMs != Long.MAX_VALUE) goto L34;
        if (LocationManagerService.D == false) goto L32;
        Log.d(LocationManagerService.TAG, this.mName + " provider stationary throttled");
    L32:
        LocationEventLog.EVENT_LOG.logProviderStationaryThrottled(this.mName, true, this.mOutgoingRequest);
    L34:
        if (this.mDeliverLastLocationCallback == null) goto L36;
        FgThread.getHandler().removeCallbacks(this.mDeliverLastLocationCallback);
    L36:
        this.mDeliverLastLocationCallback = new DeliverLastLocationRunnable(this);
        if (this.mLastLocation == null) goto L39;
        r8 = true;
    L39:
        Preconditions.checkState(r8);
        if (deliverImmediate == false) goto L42;
        FgThread.getHandler().post(this.mDeliverLastLocationCallback);
        return;
    L42:
        long delayMs = this.mThrottlingIntervalMs - this.mLastLocation.getElapsedRealtimeAgeMillis();
        FgThread.getHandler().postDelayed(this.mDeliverLastLocationCallback, delayMs);
        return;
    L44:
        if (oldThrottlingIntervalMs == Long.MAX_VALUE) goto L48;
        LocationEventLog.EVENT_LOG.logProviderStationaryThrottled(this.mName, false, this.mOutgoingRequest);
        if (LocationManagerService.D == false) goto L48;
        Log.d(LocationManagerService.TAG, this.mName + " provider stationary unthrottled");
    L48:
        FgThread.getHandler().removeCallbacks(this.mDeliverLastLocationCallback);
        this.mDeliverLastLocationCallback = null;
        return;
    L18:
        newRequest = this.mIncomingRequest;
        goto L20
    }

    @Override // com.android.server.location.provider.DelegateLocationProvider, com.android.server.location.provider.AbstractLocationProvider
    public void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (this.mThrottlingIntervalMs == Long.MAX_VALUE) goto L5;
        pw.println("stationary throttled=" + this.mLastLocation);
    L12:
        this.mDelegate.dump(fd, pw, args);
        return;
    L5:
        pw.print("stationary throttled=false");
        if (this.mDeviceIdle == true) goto L9;
        pw.print(" (not idle)");
    L9:
        if (this.mDeviceStationary == true) goto L11;
        pw.print(" (not stationary)");
    L11:
        pw.println();
        goto L12
    }
}
