package com.android.server.location.provider;

import android.app.AlarmManager;
import android.app.BroadcastOptions;
import android.app.PendingIntent;
import android.app.compat.CompatChanges;
import android.content.Context;
import android.content.Intent;
import android.location.ILocationCallback;
import android.location.ILocationListener;
import android.location.LastLocationRequest;
import android.location.Location;
import android.location.LocationManagerInternal;
import android.location.LocationRequest;
import android.location.LocationResult;
import android.location.altitude.AltitudeConverter;
import android.location.provider.IProviderRequestListener;
import android.location.provider.ProviderProperties;
import android.location.provider.ProviderRequest;
import android.location.util.identity.CallerIdentity;
import android.os.Binder;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.ICancellationSignal;
import android.os.IRemoteCallback;
import android.os.Message;
import android.os.Parcelable;
import android.os.PowerManager;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.os.UserHandle;
import android.os.WorkSource;
import android.provider.DeviceConfig;
import android.text.TextUtils;
import android.util.ArraySet;
import android.util.EventLog;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.TimeUtils;
import com.android.internal.listeners.ListenerExecutor;
import com.android.internal.util.ConcurrentUtils;
import com.android.internal.util.FrameworkStatsLog;
import com.android.internal.util.Preconditions;
import com.android.server.FgThread;
import com.android.server.IoThread;
import com.android.server.LocalServices;
import com.android.server.SysOptBridge;
import com.android.server.location.GPOStateMachine;
import com.android.server.location.LocationEventsTracker;
import com.android.server.location.LocationLogsRecorder;
import com.android.server.location.LocationManagerService;
import com.android.server.location.LocationPermissions;
import com.android.server.location.StarLocation;
import com.android.server.location.eventlog.LocationEventLog;
import com.android.server.location.fudger.LocationFudger;
import com.android.server.location.fudger.LocationFudgerCache;
import com.android.server.location.injector.AlarmHelper;
import com.android.server.location.injector.AppForegroundHelper;
import com.android.server.location.injector.AppOpsHelper;
import com.android.server.location.injector.EmergencyHelper;
import com.android.server.location.injector.Injector;
import com.android.server.location.injector.LocationPermissionsHelper;
import com.android.server.location.injector.LocationPowerSaveModeHelper;
import com.android.server.location.injector.LocationUsageLogger;
import com.android.server.location.injector.PackageResetHelper;
import com.android.server.location.injector.ScreenInteractiveHelper;
import com.android.server.location.injector.SettingsHelper;
import com.android.server.location.injector.UserInfoHelper;
import com.android.server.location.listeners.ListenerMultiplexer;
import com.android.server.location.listeners.ListenerRegistration;
import com.android.server.location.listeners.RemovableListenerRegistration;
import com.android.server.location.settings.LocationSettings;
import com.android.server.location.settings.LocationUserSettings;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class LocationProviderManager extends ListenerMultiplexer<Object, LocationTransport, Registration, ProviderRequest> implements AbstractLocationProvider.Listener {
    private static final float FASTEST_INTERVAL_JITTER_PERCENTAGE = 0.1f;
    private static final long MAX_CURRENT_LOCATION_AGE_MS = 30000;
    private static final int MAX_FASTEST_INTERVAL_JITTER_MS = 30000;
    private static final long MAX_GET_CURRENT_LOCATION_TIMEOUT_MS = 30000;
    private static final long MAX_HIGH_POWER_INTERVAL_MS = 300000;
    private static final long MIN_COARSE_INTERVAL_MS = 600000;
    private static final long MIN_REQUEST_DELAY_MS = 30000;
    private static final int STATE_STARTED = 0;
    private static final int STATE_STOPPED = 2;
    private static final int STATE_STOPPING = 1;
    private static final long TEMPORARY_APP_ALLOWLIST_DURATION_MS = 10000;
    private static final String WAKELOCK_TAG = "*location*";
    private static final long WAKELOCK_TIMEOUT_MS = 30000;
    private static final String[] WHITELIST = null;
    private final SettingsHelper.GlobalSettingChangedListener mAdasPackageAllowlistChangedListener;
    protected final AlarmHelper mAlarmHelper;
    private final AltitudeConverter mAltitudeConverter;
    private final AppForegroundHelper.AppForegroundListener mAppForegroundChangedListener;
    protected final AppForegroundHelper mAppForegroundHelper;
    protected final AppOpsHelper mAppOpsHelper;
    private final SettingsHelper.GlobalSettingChangedListener mBackgroundThrottleIntervalChangedListener;
    private final SettingsHelper.GlobalSettingChangedListener mBackgroundThrottlePackageWhitelistChangedListener;
    protected final Context mContext;
    private AlarmManager.OnAlarmListener mDelayedRegister;
    protected final EmergencyHelper mEmergencyHelper;
    private final EmergencyHelper.EmergencyStateChangedListener mEmergencyStateChangedListener;
    private final SparseBooleanArray mEnabled;
    private final ArrayList<LocationManagerInternal.ProviderEnabledListener> mEnabledListeners;
    private final SettingsHelper.GlobalSettingChangedListener mIgnoreSettingsPackageWhitelistChangedListener;
    private volatile boolean mIsAltitudeConverterIdle;
    private final SparseArray<LastLocation> mLastLocations;
    private final SettingsHelper.UserSettingChangedListener mLocationEnabledChangedListener;
    protected final LocationFudger mLocationFudger;
    protected final LocationManagerInternal mLocationManagerInternal;
    private final SettingsHelper.UserSettingChangedListener mLocationPackageBlacklistChangedListener;
    protected final LocationPermissionsHelper mLocationPermissionsHelper;
    private final LocationPermissionsHelper.LocationPermissionsListener mLocationPermissionsListener;
    private final LocationPowerSaveModeHelper.LocationPowerSaveModeChangedListener mLocationPowerSaveModeChangedListener;
    protected final LocationPowerSaveModeHelper mLocationPowerSaveModeHelper;
    protected final LocationSettings mLocationSettings;
    protected final LocationUsageLogger mLocationUsageLogger;
    private final LocationSettings.LocationUserSettingsListener mLocationUserSettingsListener;
    protected final String mName;
    private final PackageResetHelper mPackageResetHelper;
    private final PackageResetHelper.Responder mPackageResetResponder;
    private final PassiveLocationProviderManager mPassiveManager;
    protected final MockableLocationProvider mProvider;
    private final CopyOnWriteArrayList<IProviderRequestListener> mProviderRequestListeners;
    private final Collection<String> mRequiredPermissions;
    private final ScreenInteractiveHelper.ScreenInteractiveChangedListener mScreenInteractiveChangedListener;
    protected final ScreenInteractiveHelper mScreenInteractiveHelper;
    protected final SettingsHelper mSettingsHelper;
    private int mState;
    private StateChangedListener mStateChangedListener;
    private final UserInfoHelper.UserListener mUserChangedListener;
    protected final UserInfoHelper mUserHelper;

    private static class ExternalWakeLockReleaser extends IRemoteCallback.Stub {
        private final CallerIdentity mIdentity;
        private final PowerManager.WakeLock mWakeLock;

        public static /* synthetic */ void $r8$lambda$41z9UhXZibwPQ8l3P_c8tZE_MBc(RuntimeException r0) {
            lambda$sendResult$0(r0);
        }

        ExternalWakeLockReleaser(CallerIdentity identity, PowerManager.WakeLock wakeLock) {
            this.mIdentity = identity;
            wakeLock.getClass();
            this.mWakeLock = wakeLock;
        }

        public void sendResult(Bundle data) {
            long identity = Binder.clearCallingIdentity();
            this.mWakeLock.release();     // Catch: Throwable -> L5 RuntimeException -> L7
        L4:
            Binder.restoreCallingIdentity(identity);
            return;
        L7:
            e = move-exception;
            if (e.getClass() != RuntimeException.class) goto L12;
            Log.e(LocationManagerService.TAG, "wakelock over-released by " + this.mIdentity, e);     // Catch: Throwable -> L5
            goto L4
        L12:
            FgThread.getExecutor().execute(new LocationProviderManager$ExternalWakeLockReleaser$$ExternalSyntheticLambda0(e));     // Catch: Throwable -> L5
            throw e;     // Catch: Throwable -> L5
        L5:
            th = move-exception;
            Binder.restoreCallingIdentity(identity);
            throw th;
        }

        private static /* synthetic */ void lambda$sendResult$0(RuntimeException e) {
            throw new AssertionError(e);
        }
    }

    protected final class GetCurrentLocationListenerRegistration extends Registration implements IBinder.DeathRecipient, AlarmManager.OnAlarmListener {
        private long mExpirationRealtimeMs;
        final /* synthetic */ LocationProviderManager this$0;

        GetCurrentLocationListenerRegistration(LocationProviderManager this$0, LocationRequest request, CallerIdentity identity, LocationTransport transport, int permissionLevel) {
            this.this$0 = this$0;
            if (identity.isMyProcess() == false) goto L6;
            Executor r0 = FgThread.getExecutor();
        L7:
            super(this$0, request, identity, r0, transport, permissionLevel);
            this.mExpirationRealtimeMs = Long.MAX_VALUE;
            return;
        L6:
            r0 = ConcurrentUtils.DIRECT_EXECUTOR;
            goto L7
        }

        @Override // com.android.server.location.provider.LocationProviderManager.Registration, com.android.server.location.listeners.RemovableListenerRegistration
        protected void onRegister() {
            super.onRegister();
            ((IBinder) getKey()).linkToDeath(this, 0);     // Catch: RemoteException -> L5
        L7:
            long registerTimeMs = SystemClock.elapsedRealtime();
            this.mExpirationRealtimeMs = getRequest().getExpirationRealtimeMs(registerTimeMs);
            if (this.mExpirationRealtimeMs > registerTimeMs) goto L11;
            onAlarm();
        L13:
            LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_LOCATION, "[" + this.this$0.mUserHelper.getCurrentUserId() + "]" + this.this$0.mName + " provider getCurrentLocation added from " + getIdentity());
            return;
        L11:
            if (this.mExpirationRealtimeMs >= Long.MAX_VALUE) goto L13;
            this.this$0.mAlarmHelper.setDelayedAlarm(this.mExpirationRealtimeMs - registerTimeMs, this, null);
        L6:
            remove();
            goto L7
        }

        @Override // com.android.server.location.provider.LocationProviderManager.Registration, com.android.server.location.listeners.RemovableListenerRegistration, com.android.server.location.listeners.ListenerRegistration
        protected void onUnregister() {
            if (this.mExpirationRealtimeMs >= Long.MAX_VALUE) goto L11;
            this.this$0.mAlarmHelper.cancel(this);
        L11:
            ((IBinder) getKey()).unlinkToDeath(this, 0);     // Catch: NoSuchElementException -> L7
        L9:
            super.onUnregister();
            LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_LOCATION, "[" + this.this$0.mUserHelper.getCurrentUserId() + "]" + this.this$0.mName + " provider getCurrentLocation removed from " + getIdentity());
            return;
        L7:
            e = move-exception;
            Log.w(getTag(), "failed to unregister binder death listener", e);
            goto L9
        }

        @Override // com.android.server.location.provider.LocationProviderManager.Registration, com.android.server.location.listeners.ListenerRegistration
        protected void onActive() {
            super.onActive();
            Location lastLocation = this.this$0.getLastLocationUnsafe(getIdentity().getUserId(), getPermissionLevel(), getRequest().isBypass(), 30000);
            if (lastLocation == null) goto L6;
            executeOperation(acceptLocationChange(LocationResult.wrap(new Location[]{lastLocation})));
            return;
        }

        @Override // com.android.server.location.provider.LocationProviderManager.Registration, com.android.server.location.listeners.ListenerRegistration
        protected void onInactive() {
            executeOperation(acceptLocationChange(null));
            super.onInactive();
        }

        void deliverNull() {
            executeOperation(acceptLocationChange(null));
        }

        @Override // android.app.AlarmManager.OnAlarmListener
        public void onAlarm() {
            if (LocationManagerService.D == false) goto L5;
            Log.d(LocationManagerService.TAG, this.this$0.mName + " provider registration " + getIdentity() + " expired at " + TimeUtils.formatRealtime(this.mExpirationRealtimeMs));
        L5:
            Object r0 = LocationProviderManager.access$1500(this.this$0);
            monitor-enter(r0);
            this.mExpirationRealtimeMs = Long.MAX_VALUE;     // Catch: Throwable -> L11
            executeOperation(acceptLocationChange(null));     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.location.provider.LocationProviderManager.Registration
        ListenerExecutor.ListenerOperation<LocationTransport> acceptLocationChange(LocationResult fineLocationResult) {
            if (SystemClock.elapsedRealtime() >= this.mExpirationRealtimeMs) goto L5;
        L8:
            if (fineLocationResult != null) goto L10;
        L19:
            if (fineLocationResult == null) goto L21;
            fineLocationResult = fineLocationResult.asLastLocationResult();
        L21:
            final LocationResult locationResult = this.this$0.getPermittedLocationResult(fineLocationResult, getPermissionLevel());
            return new AnonymousClass1(this, locationResult);
        L10:
            if (isOnlyBypassPermitted() == false) goto L12;
            int op = 147;
        L14:
            if (this.this$0.mAppOpsHelper.noteOpNoThrow(op, getIdentity()) == true) goto L19;
            if (LocationManagerService.D == false) goto L18;
            Log.w(LocationManagerService.TAG, "noteOp denied for " + getIdentity());
        L18:
            fineLocationResult = null;
            goto L19
        L12:
            op = LocationPermissions.asAppOp(getPermissionLevel());
            goto L14
        L5:
            if (LocationManagerService.D == false) goto L7;
            Log.d(LocationManagerService.TAG, this.this$0.mName + " provider registration " + getIdentity() + " expired at " + TimeUtils.formatRealtime(this.mExpirationRealtimeMs));
        L7:
            fineLocationResult = null;
            goto L8
        }

        @Override // com.android.server.location.listeners.ListenerRegistration
        public void onOperationFailure(ListenerExecutor.ListenerOperation<LocationTransport> operation, Exception e) {
            if ((e instanceof RemoteException) == false) goto L7;
            Log.w(LocationManagerService.TAG, this.this$0.mName + " provider registration " + getIdentity() + " removed", e);
            remove();
            return;
        L7:
            throw new AssertionError(e);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
        L5:
            e = move-exception;
            throw new AssertionError(e);
        L3:
            if (LocationManagerService.D == false) goto L7;
            Log.d(LocationManagerService.TAG, this.this$0.mName + " provider registration " + getIdentity() + " died");     // Catch: RuntimeException -> L5
        L7:
            remove();     // Catch: RuntimeException -> L5
        }
    }

    protected static final class GetCurrentLocationTransport implements LocationTransport {
        private final ILocationCallback mCallback;

        public static /* synthetic */ void $r8$lambda$aOq8QFW_mCPXmb4k1j_GZgjQtbw(RuntimeException r0) {
            lambda$deliverOnLocationChanged$0(r0);
        }

        GetCurrentLocationTransport(ILocationCallback callback) {
            callback.getClass();
            this.mCallback = callback;
        }

        @Override // com.android.server.location.provider.LocationProviderManager.LocationTransport
        public void deliverOnLocationChanged(LocationResult locationResult, IRemoteCallback onCompleteCallback) throws RemoteException {
            if (onCompleteCallback != null) goto L4;
            boolean r0 = true;
        L5:
            Preconditions.checkState(r0);
            if (locationResult == null) goto L10;
            this.mCallback.onLocation(locationResult.getLastLocation());     // Catch: RuntimeException -> L8
        L14:
            return;
        L10:
            this.mCallback.onLocation(null);     // Catch: RuntimeException -> L8
        L8:
            e = move-exception;
            final RuntimeException wrapper = new RuntimeException(e);
            FgThread.getExecutor().execute(new LocationProviderManager$GetCurrentLocationTransport$$ExternalSyntheticLambda0(wrapper));
            return;
        L4:
            r0 = false;
            goto L5
        }

        private static /* synthetic */ void lambda$deliverOnLocationChanged$0(RuntimeException wrapper) {
            throw wrapper;
        }

        @Override // com.android.server.location.provider.LocationProviderManager.LocationTransport
        public void deliverOnFlushComplete(int requestCode) {
        }
    }

    private static class LastLocation {
        private Location mCoarseBypassLocation;
        private Location mCoarseLocation;
        private Location mFineBypassLocation;
        private Location mFineLocation;

        LastLocation() {
        }

        public void clearMock() {
            if (this.mFineLocation == null) goto L8;
            if (this.mFineLocation.isMock() == false) goto L8;
            this.mFineLocation = null;
        L8:
            if (this.mCoarseLocation == null) goto L13;
            if (this.mCoarseLocation.isMock() == false) goto L13;
            this.mCoarseLocation = null;
        L13:
            if (this.mFineBypassLocation == null) goto L18;
            if (this.mFineBypassLocation.isMock() == false) goto L18;
            this.mFineBypassLocation = null;
        L18:
            if (this.mCoarseBypassLocation != null) goto L20;
            return;
        L20:
            if (this.mCoarseBypassLocation.isMock() == false) goto L24;
            this.mCoarseBypassLocation = null;
            return;
        }

        public void clearLocations() {
            this.mFineLocation = null;
            this.mCoarseLocation = null;
        }

        public Location get(int permissionLevel, boolean isBypass) {
            switch(permissionLevel) {
                case 1: goto L10;
                case 2: goto L5;
                default: goto L4;
            };
        L5:
            if (isBypass == false) goto L9;
            return this.mFineBypassLocation;
        L9:
            return this.mFineLocation;
        L10:
            if (isBypass == false) goto L14;
            return this.mCoarseBypassLocation;
        L14:
            return this.mCoarseLocation;
        L4:
            throw new AssertionError();
        }

        public void set(Location location) {
            this.mFineLocation = calculateNextFine(this.mFineLocation, location);
            this.mCoarseLocation = calculateNextCoarse(this.mCoarseLocation, location);
        }

        public void setBypass(Location location) {
            this.mFineBypassLocation = calculateNextFine(this.mFineBypassLocation, location);
            this.mCoarseBypassLocation = calculateNextCoarse(this.mCoarseBypassLocation, location);
        }

        private Location calculateNextFine(Location oldFine, Location newFine) {
            if (oldFine != null) goto L5;
            return newFine;
        L5:
            if (newFine.getElapsedRealtimeNanos() <= oldFine.getElapsedRealtimeNanos()) goto L7;
            return newFine;
        L7:
            return oldFine;
        }

        private Location calculateNextCoarse(Location oldCoarse, Location newCoarse) {
            if (oldCoarse != null) goto L5;
            return newCoarse;
        L5:
            if ((newCoarse.getElapsedRealtimeMillis() - 600000) <= oldCoarse.getElapsedRealtimeMillis()) goto L7;
            return newCoarse;
        L7:
            return oldCoarse;
        }
    }

    protected final class LocationListenerRegistration extends LocationRegistration implements IBinder.DeathRecipient {
        final /* synthetic */ LocationProviderManager this$0;

        LocationListenerRegistration(LocationProviderManager this$0, LocationRequest request, CallerIdentity identity, LocationListenerTransport transport, int permissionLevel) {
            this.this$0 = this$0;
            if (identity.isMyProcess() == false) goto L6;
            Executor r0 = FgThread.getExecutor();
        L7:
            super(this$0, request, identity, r0, transport, permissionLevel);
            return;
        L6:
            r0 = ConcurrentUtils.DIRECT_EXECUTOR;
            goto L7
        }

        @Override // com.android.server.location.provider.LocationProviderManager.LocationRegistration, com.android.server.location.provider.LocationProviderManager.Registration, com.android.server.location.listeners.RemovableListenerRegistration
        protected void onRegister() {
            super.onRegister();
            ((IBinder) getKey()).linkToDeath(this, 0);     // Catch: RemoteException -> L5
            return;
        L6:
            remove();
        }

        @Override // com.android.server.location.provider.LocationProviderManager.LocationRegistration, com.android.server.location.provider.LocationProviderManager.Registration, com.android.server.location.listeners.RemovableListenerRegistration, com.android.server.location.listeners.ListenerRegistration
        protected void onUnregister() {
            ((IBinder) getKey()).unlinkToDeath(this, 0);     // Catch: NoSuchElementException -> L4
        L6:
            super.onUnregister();
            return;
        L4:
            e = move-exception;
            Log.w(getTag(), "failed to unregister binder death listener", e);
            goto L6
        }

        @Override // com.android.server.location.provider.LocationProviderManager.LocationRegistration
        protected void onProviderOperationFailure(ListenerExecutor.ListenerOperation<ProviderTransport> operation, Exception exception) {
            onTransportFailure(exception);
        }

        @Override // com.android.server.location.listeners.ListenerRegistration
        public void onOperationFailure(ListenerExecutor.ListenerOperation<LocationTransport> operation, Exception exception) {
            onTransportFailure(exception);
        }

        private void onTransportFailure(Exception e) {
            if ((e instanceof RemoteException) == false) goto L7;
            Log.w(LocationManagerService.TAG, this.this$0.mName + " provider registration " + getIdentity() + " removed", e);
            remove();
            return;
        L7:
            throw new AssertionError(e);
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
        L5:
            e = move-exception;
            throw new AssertionError(e);
        L3:
            if (LocationManagerService.D == false) goto L7;
            Log.d(LocationManagerService.TAG, this.this$0.mName + " provider registration " + getIdentity() + " died");     // Catch: RuntimeException -> L5
        L7:
            remove();     // Catch: RuntimeException -> L5
        }
    }

    protected static final class LocationListenerTransport implements LocationTransport, ProviderTransport {
        private final ILocationListener mListener;

        /* JADX INFO: renamed from: $r8$lambda$LPy2C7-fORETh6fKOUitbzZ7Tw0, reason: not valid java name */
        public static /* synthetic */ void m5409$r8$lambda$LPy2C7fORETh6fKOUitbzZ7Tw0(RuntimeException r0) {
            lambda$deliverOnFlushComplete$1(r0);
        }

        public static /* synthetic */ void $r8$lambda$mfMtHciOGaSofys5oqDc04MIvTE(RuntimeException r0) {
            lambda$deliverOnProviderEnabledChanged$2(r0);
        }

        /* JADX INFO: renamed from: $r8$lambda$ppxAAOAWtb6OKOUCQf8OF39w-os, reason: not valid java name */
        public static /* synthetic */ void m5410$r8$lambda$ppxAAOAWtb6OKOUCQf8OF39wos(RuntimeException r0) {
            lambda$deliverOnLocationChanged$0(r0);
        }

        LocationListenerTransport(ILocationListener listener) {
            listener.getClass();
            this.mListener = listener;
        }

        @Override // com.android.server.location.provider.LocationProviderManager.LocationTransport
        public void deliverOnLocationChanged(LocationResult locationResult, IRemoteCallback onCompleteCallback) throws RemoteException {
            this.mListener.onLocationChanged(locationResult.asList(), onCompleteCallback);     // Catch: RuntimeException -> L4
            return;
        L4:
            e = move-exception;
            final RuntimeException wrapper = new RuntimeException(e);
            FgThread.getExecutor().execute(new LocationProviderManager$LocationListenerTransport$$ExternalSyntheticLambda1(wrapper));
        }

        private static /* synthetic */ void lambda$deliverOnLocationChanged$0(RuntimeException wrapper) {
            throw wrapper;
        }

        @Override // com.android.server.location.provider.LocationProviderManager.LocationTransport
        public void deliverOnFlushComplete(int requestCode) throws RemoteException {
            this.mListener.onFlushComplete(requestCode);     // Catch: RuntimeException -> L4
            return;
        L4:
            e = move-exception;
            final RuntimeException wrapper = new RuntimeException(e);
            FgThread.getExecutor().execute(new LocationProviderManager$LocationListenerTransport$$ExternalSyntheticLambda2(wrapper));
        }

        private static /* synthetic */ void lambda$deliverOnFlushComplete$1(RuntimeException wrapper) {
            throw wrapper;
        }

        @Override // com.android.server.location.provider.LocationProviderManager.ProviderTransport
        public void deliverOnProviderEnabledChanged(String provider, boolean enabled) throws RemoteException {
            this.mListener.onProviderEnabledChanged(provider, enabled);     // Catch: RuntimeException -> L4
            return;
        L4:
            e = move-exception;
            final RuntimeException wrapper = new RuntimeException(e);
            FgThread.getExecutor().execute(new LocationProviderManager$LocationListenerTransport$$ExternalSyntheticLambda0(wrapper));
        }

        private static /* synthetic */ void lambda$deliverOnProviderEnabledChanged$2(RuntimeException wrapper) {
            throw wrapper;
        }
    }

    protected final class LocationPendingIntentRegistration extends LocationRegistration implements PendingIntent.CancelListener {
        final /* synthetic */ LocationProviderManager this$0;

        LocationPendingIntentRegistration(LocationProviderManager this$0, LocationRequest request, CallerIdentity identity, LocationPendingIntentTransport transport, int permissionLevel) {
            this.this$0 = this$0;
            super(this$0, request, identity, ConcurrentUtils.DIRECT_EXECUTOR, transport, permissionLevel);
        }

        @Override // com.android.server.location.provider.LocationProviderManager.LocationRegistration, com.android.server.location.provider.LocationProviderManager.Registration, com.android.server.location.listeners.RemovableListenerRegistration
        protected void onRegister() {
            super.onRegister();
            if (((PendingIntent) getKey()).addCancelListener(ConcurrentUtils.DIRECT_EXECUTOR, this) == true) goto L6;
            remove();
            return;
        }

        @Override // com.android.server.location.provider.LocationProviderManager.LocationRegistration, com.android.server.location.provider.LocationProviderManager.Registration, com.android.server.location.listeners.RemovableListenerRegistration, com.android.server.location.listeners.ListenerRegistration
        protected void onUnregister() {
            ((PendingIntent) getKey()).removeCancelListener(this);
            super.onUnregister();
        }

        @Override // com.android.server.location.provider.LocationProviderManager.LocationRegistration
        protected void onProviderOperationFailure(ListenerExecutor.ListenerOperation<ProviderTransport> operation, Exception exception) {
            onTransportFailure(exception);
        }

        @Override // com.android.server.location.listeners.ListenerRegistration
        public void onOperationFailure(ListenerExecutor.ListenerOperation<LocationTransport> operation, Exception exception) {
            onTransportFailure(exception);
        }

        private void onTransportFailure(Exception e) {
            if ((e instanceof PendingIntent.CanceledException) == false) goto L7;
            Log.w(LocationManagerService.TAG, this.this$0.mName + " provider registration " + getIdentity() + " removed", e);
            remove();
            return;
        L7:
            throw new AssertionError(e);
        }

        public void onCanceled(PendingIntent intent) {
            if (LocationManagerService.D == false) goto L5;
            Log.d(LocationManagerService.TAG, this.this$0.mName + " provider registration " + getIdentity() + " canceled");
        L5:
            remove();
        }
    }

    protected static final class LocationPendingIntentTransport implements LocationTransport, ProviderTransport {
        private final Context mContext;
        private final PendingIntent mPendingIntent;

        public static /* synthetic */ void $r8$lambda$xT3xqpwcN8SJd6VDT4OWsOeOb58(IRemoteCallback r0) {
            lambda$deliverOnLocationChanged$0(r0);
        }

        public LocationPendingIntentTransport(Context context, PendingIntent pendingIntent) {
            this.mContext = context;
            this.mPendingIntent = pendingIntent;
        }

        @Override // com.android.server.location.provider.LocationProviderManager.LocationTransport
        public void deliverOnLocationChanged(LocationResult locationResult, final IRemoteCallback onCompleteCallback) throws PendingIntent.CanceledException {
            BroadcastOptions options = BroadcastOptions.makeBasic();
            options.setDontSendToRestrictedApps(true);
            options.setPendingIntentBackgroundActivityLaunchAllowed(false);
            options.setTemporaryAppAllowlist(10000, 0, FrameworkStatsLog.APP_BACKGROUND_RESTRICTIONS_INFO__EXEMPTION_REASON__REASON_LOCATION_PROVIDER, "");
            Intent intent = new Intent().putExtra(LocationLogsRecorder.KEY_FILE_LOCATION, locationResult.getLastLocation());
            if (locationResult.size() <= 1) goto L5;
            intent.putExtra("locations", (Parcelable[]) locationResult.asList().toArray(new Location[0]));
        L5:
            Runnable callback = null;
            if (onCompleteCallback == null) goto L8;
            callback = new LocationProviderManager$LocationPendingIntentTransport$$ExternalSyntheticLambda0(onCompleteCallback);
        L8:
            PendingIntentSender.send(this.mPendingIntent, this.mContext, intent, callback, options.toBundle());
        }

        private static /* synthetic */ void lambda$deliverOnLocationChanged$0(IRemoteCallback onCompleteCallback) {
            onCompleteCallback.sendResult(null);     // Catch: RemoteException -> L5
            return;
        L5:
            e = move-exception;
            throw e.rethrowFromSystemServer();
        }

        @Override // com.android.server.location.provider.LocationProviderManager.LocationTransport
        public void deliverOnFlushComplete(int requestCode) throws PendingIntent.CanceledException {
            BroadcastOptions options = BroadcastOptions.makeBasic();
            options.setDontSendToRestrictedApps(true);
            options.setPendingIntentBackgroundActivityLaunchAllowed(false);
            this.mPendingIntent.send(this.mContext, 0, new Intent().putExtra("flushComplete", requestCode), null, null, null, options.toBundle());
        }

        @Override // com.android.server.location.provider.LocationProviderManager.ProviderTransport
        public void deliverOnProviderEnabledChanged(String provider, boolean enabled) throws PendingIntent.CanceledException {
            BroadcastOptions options = BroadcastOptions.makeBasic();
            options.setDontSendToRestrictedApps(true);
            options.setPendingIntentBackgroundActivityLaunchAllowed(false);
            this.mPendingIntent.send(this.mContext, 0, new Intent().putExtra("providerEnabled", enabled), null, null, null, options.toBundle());
        }
    }

    protected abstract class LocationRegistration extends Registration implements AlarmManager.OnAlarmListener, LocationManagerInternal.ProviderEnabledListener {
        private long mExpirationRealtimeMs;
        private int mNumLocationsDelivered;
        private volatile ProviderTransport mProviderTransport;
        final PowerManager.WakeLock mWakeLock;
        final ExternalWakeLockReleaser mWakeLockReleaser;
        final /* synthetic */ LocationProviderManager this$0;

        public static /* synthetic */ void $r8$lambda$HKlWp9d0ULfN4Uyj27WwtckCg8Y(LocationRegistration r0, boolean r1, ProviderTransport r2) {
            r0.lambda$onProviderEnabledChanged$1(r1, r2);
        }

        public static /* synthetic */ ProviderTransport $r8$lambda$MbgOAywiWwljbCZ3_TvCtA84c4I(LocationRegistration r0) {
            return r0.lambda$onProviderEnabledChanged$0();
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmNumLocationsDelivered, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m5411$$Nest$fgetmNumLocationsDelivered(LocationRegistration r0) {
            return r0.mNumLocationsDelivered;
        }

        /* JADX INFO: renamed from: -$$Nest$fputmNumLocationsDelivered, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m5412$$Nest$fputmNumLocationsDelivered(LocationRegistration r0, int r1) {
            r0.mNumLocationsDelivered = r1;
        }

        protected abstract void onProviderOperationFailure(ListenerExecutor.ListenerOperation<ProviderTransport> r1, Exception r2);

        protected <TTransport extends LocationTransport & ProviderTransport> LocationRegistration(LocationProviderManager this$0, LocationRequest request, CallerIdentity identity, Executor executor, TTransport transport, int permissionLevel) {
            this.this$0 = this$0;
            super(this$0, request, identity, executor, transport, permissionLevel);
            this.mNumLocationsDelivered = 0;
            this.mExpirationRealtimeMs = Long.MAX_VALUE;
            this.mProviderTransport = transport;
            PowerManager r1 = (PowerManager) this$0.mContext.getSystemService(PowerManager.class);
            r1.getClass();
            this.mWakeLock = r1.newWakeLock(1, LocationProviderManager.WAKELOCK_TAG);
            this.mWakeLock.setReferenceCounted(true);
            this.mWakeLock.setWorkSource(request.getWorkSource());
            this.mWakeLockReleaser = new ExternalWakeLockReleaser(identity, this.mWakeLock);
        }

        @Override // com.android.server.location.listeners.ListenerRegistration
        protected void onListenerUnregister() {
            this.mProviderTransport = null;
        }

        @Override // com.android.server.location.provider.LocationProviderManager.Registration, com.android.server.location.listeners.RemovableListenerRegistration
        protected void onRegister() {
            super.onRegister();
            long registerTimeMs = SystemClock.elapsedRealtime();
            this.mExpirationRealtimeMs = getRequest().getExpirationRealtimeMs(registerTimeMs);
            if (this.mExpirationRealtimeMs > registerTimeMs) goto L6;
            onAlarm();
        L8:
            this.this$0.addEnabledListener(this);
            int userId = getIdentity().getUserId();
            if (this.this$0.isEnabled(userId) == true) goto L12;
            onProviderEnabledChanged(this.this$0.mName, userId, false);
            return;
        L12:
            return;
        L6:
            if (this.mExpirationRealtimeMs >= Long.MAX_VALUE) goto L8;
            this.this$0.mAlarmHelper.setDelayedAlarm(this.mExpirationRealtimeMs - registerTimeMs, this, null);
            goto L8
        }

        @Override // com.android.server.location.provider.LocationProviderManager.Registration, com.android.server.location.listeners.RemovableListenerRegistration, com.android.server.location.listeners.ListenerRegistration
        protected void onUnregister() {
            this.this$0.removeEnabledListener(this);
            if (this.mExpirationRealtimeMs >= Long.MAX_VALUE) goto L5;
            this.this$0.mAlarmHelper.cancel(this);
        L5:
            super.onUnregister();
        }

        @Override // com.android.server.location.provider.LocationProviderManager.Registration, com.android.server.location.listeners.ListenerRegistration
        protected void onActive() {
            super.onActive();
            if (CompatChanges.isChangeEnabled(73144566, getIdentity().getUid()) == false) goto L14;
            long maxLocationAgeMs = getRequest().getIntervalMillis();
            Location lastDeliveredLocation = getLastDeliveredLocation();
            if (lastDeliveredLocation == null) goto L7;
            long maxLocationAgeMs2 = Math.min(maxLocationAgeMs, lastDeliveredLocation.getElapsedRealtimeAgeMillis() - 1);
        L9:
            if (maxLocationAgeMs2 <= 30000) goto L15;
            Location lastLocation = this.this$0.getLastLocationUnsafe(getIdentity().getUserId(), getPermissionLevel(), getRequest().isBypass(), maxLocationAgeMs2);
            if (lastLocation == null) goto L16;
            executeOperation(acceptLocationChange(LocationResult.wrap(new Location[]{lastLocation})));
            return;
        L16:
            return;
        L15:
            return;
        L7:
            maxLocationAgeMs2 = maxLocationAgeMs;
            goto L9
        }

        @Override // android.app.AlarmManager.OnAlarmListener
        public void onAlarm() {
            if (LocationManagerService.D == false) goto L5;
            Log.d(LocationManagerService.TAG, this.this$0.mName + " provider registration " + getIdentity() + " expired at " + TimeUtils.formatRealtime(this.mExpirationRealtimeMs));
        L5:
            Object r0 = LocationProviderManager.access$1400(this.this$0);
            monitor-enter(r0);
            this.mExpirationRealtimeMs = Long.MAX_VALUE;     // Catch: Throwable -> L11
            remove();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return;
        L11:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.location.provider.LocationProviderManager.Registration
        ListenerExecutor.ListenerOperation<LocationTransport> acceptLocationChange(LocationResult fineLocationResult) {
            if (SystemClock.elapsedRealtime() >= this.mExpirationRealtimeMs) goto L5;
            LocationResult permittedLocationResult = this.this$0.getPermittedLocationResult(fineLocationResult, getPermissionLevel());
            permittedLocationResult.getClass();
            final LocationResult locationResult = permittedLocationResult.filter(new AnonymousClass1(this));
            if (locationResult != null) goto L13;
            return null;
        L13:
            if (isOnlyBypassPermitted() == false) goto L15;
            int op = 147;
        L17:
            if (this.this$0.mAppOpsHelper.noteOpNoThrow(op, getIdentity()) == true) goto L23;
            if (LocationManagerService.D == false) goto L21;
            Log.w(LocationManagerService.TAG, this.this$0.mName + " provider registration " + getIdentity() + " noteOp denied");
        L21:
            return null;
        L23:
            if (getRequest().getIntervalMillis() == Long.MAX_VALUE) goto L25;
            final boolean useWakeLock = true;
        L27:
            return new AnonymousClass2(this, locationResult, useWakeLock);
        L25:
            useWakeLock = false;
            goto L27
        L15:
            op = LocationPermissions.asAppOp(getPermissionLevel());
            goto L17
        L5:
            if (LocationManagerService.D == false) goto L7;
            Log.d(LocationManagerService.TAG, this.this$0.mName + " provider registration " + getIdentity() + " expired at " + TimeUtils.formatRealtime(this.mExpirationRealtimeMs));
        L7:
            remove();
            return null;
        }

        public void onProviderEnabledChanged(String provider, int userId, final boolean enabled) {
            Preconditions.checkState(this.this$0.mName.equals(provider));
            if (userId == getIdentity().getUserId()) goto L5;
            return;
        L5:
            executeSafely(getExecutor(), new LocationProviderManager$LocationRegistration$$ExternalSyntheticLambda0(this), new LocationProviderManager$LocationRegistration$$ExternalSyntheticLambda1(this, enabled), new LocationProviderManager$LocationRegistration$$ExternalSyntheticLambda2(this));
        }

        private /* synthetic */ ProviderTransport lambda$onProviderEnabledChanged$0() {
            return this.mProviderTransport;
        }

        private /* synthetic */ void lambda$onProviderEnabledChanged$1(boolean enabled, ProviderTransport listener) throws Exception {
            listener.deliverOnProviderEnabledChanged(this.this$0.mName, enabled);
        }
    }

    protected interface LocationTransport {
        void deliverOnFlushComplete(int r1) throws Exception;

        void deliverOnLocationChanged(LocationResult r1, IRemoteCallback r2) throws Exception;
    }

    private static class PendingIntentSender {

        private static class GatedCallback implements Runnable {
            private Runnable mCallback;
            private boolean mGate;
            private boolean mRun;

            /* synthetic */ GatedCallback(Runnable r1, LocationProviderManagerIA r2) {
                this(r1);
            }

            private GatedCallback(Runnable callback) {
                this.mCallback = callback;
            }

            public void allow() {
                Runnable callback = null;
                monitor-enter(this);
                this.mGate = true;     // Catch: Throwable -> L10
                if (this.mRun == true) goto L8;
            L12:
                monitor-exit(this);     // Catch: Throwable -> L10
                if (callback == null) goto L20;
                callback.run();
                return;
            L20:
                return;
            L8:
                if (this.mCallback == null) goto L12;
                callback = this.mCallback;     // Catch: Throwable -> L10
                this.mCallback = null;     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                throw th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Runnable callback = null;
                monitor-enter(this);
                this.mRun = true;     // Catch: Throwable -> L10
                if (this.mGate == true) goto L8;
            L12:
                monitor-exit(this);     // Catch: Throwable -> L10
                if (callback == null) goto L20;
                callback.run();
                return;
            L20:
                return;
            L8:
                if (this.mCallback == null) goto L12;
                callback = this.mCallback;     // Catch: Throwable -> L10
                this.mCallback = null;     // Catch: Throwable -> L10
            L10:
                th = move-exception;
                throw th;
            }
        }

        public static /* synthetic */ void $r8$lambda$3a9iOp88jp07_HXeAkGCZJb_3Ps(GatedCallback r0, PendingIntent r1, Intent r2, int r3, String r4, Bundle r5) {
            lambda$send$0(r0, r1, r2, r3, r4, r5);
        }

        private PendingIntentSender() {
        }

        public static void send(PendingIntent pendingIntent, Context context, Intent intent, Runnable callback, Bundle options) throws PendingIntent.CanceledException {
            if (callback == null) goto L4;
            final GatedCallback gatedCallback = new GatedCallback(callback, null);
            PendingIntent.OnFinished onFinished = new LocationProviderManager$PendingIntentSender$$ExternalSyntheticLambda0(gatedCallback);
        L5:
            pendingIntent.send(context, 0, intent, onFinished, null, null, options);
            if (gatedCallback == null) goto L9;
            gatedCallback.allow();
            return;
        L9:
            return;
        L4:
            gatedCallback = null;
            onFinished = null;
            goto L5
        }

        private static /* synthetic */ void lambda$send$0(GatedCallback gatedCallback, PendingIntent pI, Intent i, int rC, String rD, Bundle rE) {
            gatedCallback.run();
        }
    }

    protected interface ProviderTransport {
        void deliverOnProviderEnabledChanged(String r1, boolean r2) throws Exception;
    }

    protected abstract class Registration extends RemovableListenerRegistration<Object, LocationTransport> {
        private final LocationRequest mBaseRequest;
        private boolean mBypassPermitted;
        private boolean mForeground;
        private final CallerIdentity mIdentity;
        private boolean mIsUsingHighPower;
        private Location mLastLocation;
        private final int mPermissionLevel;
        private boolean mPermitted;
        private LocationRequest mProviderLocationRequest;
        final /* synthetic */ LocationProviderManager this$0;

        public static /* synthetic */ void $r8$lambda$8BrL0bYcdddbxH8FhcjM4iSczjc(int r0, LocationTransport r1) {
            lambda$flush$0(r0, r1);
        }

        public static /* synthetic */ void $r8$lambda$NzjnRYkoQ2fYT4ZS7vARkAYegW0(Registration r0, int r1) {
            r0.lambda$flush$1(r1);
        }

        abstract ListenerExecutor.ListenerOperation<LocationTransport> acceptLocationChange(LocationResult r1);

        @Override // com.android.server.location.listeners.RemovableListenerRegistration
        protected /* bridge */ /* synthetic */ ListenerMultiplexer<Object, ? super LocationTransport, ?, ?> getOwner() {
            return getOwner2();
        }

        protected Registration(LocationProviderManager this$0, LocationRequest request, CallerIdentity identity, Executor executor, LocationTransport transport, int permissionLevel) {
            this.this$0 = this$0;
            super(executor, transport);
            this.mLastLocation = null;
            boolean r1 = false;
            if (identity.getListenerId() == null) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0);
            if (permissionLevel <= 0) goto L9;
            r1 = true;
        L9:
            Preconditions.checkArgument(r1);
            Preconditions.checkArgument(!request.getWorkSource().isEmpty());
            request.getClass();
            this.mBaseRequest = request;
            identity.getClass();
            this.mIdentity = identity;
            this.mPermissionLevel = permissionLevel;
            this.mProviderLocationRequest = request;
            return;
        L5:
            r0 = false;
            goto L6
        }

        public final CallerIdentity getIdentity() {
            return this.mIdentity;
        }

        public final LocationRequest getRequest() {
            Object r0 = LocationProviderManager.access$000(this.this$0);
            monitor-enter(r0);
            LocationRequest r1 = this.mProviderLocationRequest;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // com.android.server.location.listeners.RemovableListenerRegistration
        protected void onRegister() {
            super.onRegister();
            LocationEventLog.EVENT_LOG.logProviderClientRegistered(this.this$0.mName, getIdentity(), this.mBaseRequest);
            onLocationPermissionsChanged();
            onBypassLocationPermissionsChanged(this.this$0.mEmergencyHelper.isInEmergency(0));
            this.mForeground = this.this$0.mAppForegroundHelper.isAppForeground(getIdentity().getUid());
            this.mProviderLocationRequest = calculateProviderLocationRequest();
            this.mIsUsingHighPower = isUsingHighPower();
            if ("gps".equals(this.this$0.mName) == false) goto L8;
            if (isActive() == false) goto L8;
            GPOStateMachine sm = GPOStateMachine.getGpoStateMachine();
            Message msg = sm.obtainMessage(1, this);
            sm.sendMessage(msg);
        L8:
            if (this.mForeground == false) goto L10;
            LocationEventLog.EVENT_LOG.logProviderClientForeground(this.this$0.mName, getIdentity());
        L10:
            String requestInfo = "[" + this.this$0.mUserHelper.getCurrentUserId() + "]" + this.this$0.mName + " provider added registration from " + getIdentity() + " -> " + getRequest() + " active: " + isActive();
            if (this.mPermitted == true) goto L13;
            requestInfo = requestInfo + " permitted: " + this.mPermitted + " bypassPermitted: " + this.mBypassPermitted + " permissionLevel: " + LocationPermissions.asPermission(this.mPermissionLevel) + " foreground: " + this.mForeground + " isUsingHighPower: " + this.mIsUsingHighPower;
        L13:
            LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_LOCATION, requestInfo);
            LocationEventsTracker.getInstance().recordAppLocationRequest(this.this$0.mName, this.this$0.mProvider.isMock(), getIdentity(), getRequest());
            LocationEventsTracker.getInstance().recordRegistrationActive(getIdentity(), isActive());
            LocationEventsTracker.getInstance().recordRegistrationForeground(getIdentity(), this.mForeground);
        }

        @Override // com.android.server.location.listeners.RemovableListenerRegistration, com.android.server.location.listeners.ListenerRegistration
        protected void onUnregister() {
            if ("gps".equals(this.this$0.mName) == false) goto L11;
            GPOStateMachine sm = GPOStateMachine.getGpoStateMachine();
            Message msg = sm.obtainMessage(2, this);
            sm.sendMessage(msg);
        L11:
            LocationEventLog.EVENT_LOG.logProviderClientUnregistered(this.this$0.mName, getIdentity());     // Catch: IllegalStateException -> L7
        L9:
            LocationEventsTracker.getInstance().removeAppLocationRequest(getIdentity());
            LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_LOCATION, "[" + this.this$0.mUserHelper.getCurrentUserId() + "]" + this.this$0.mName + " provider removed registration from " + getIdentity());
            super.onUnregister();
            return;
        L7:
            e = move-exception;
            LocationEventLog.EVENT_LOG.logErrorEvent(e.toString());
            Log.e(LocationManagerService.TAG, e.toString());
            goto L9
        }

        @Override // com.android.server.location.listeners.ListenerRegistration
        protected void onActive() {
            LocationEventLog.EVENT_LOG.logProviderClientActive(this.this$0.mName, getIdentity());
            LocationEventsTracker.getInstance().recordRegistrationActive(getIdentity(), true);
            LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_LOCATION, "[" + this.this$0.mUserHelper.getCurrentUserId() + "]" + this.this$0.mName + " provider " + getIdentity() + " active = true");
            if ("gps".equals(this.this$0.mName) == false) goto L6;
            GPOStateMachine sm = GPOStateMachine.getGpoStateMachine();
            Message msg = sm.obtainMessage(3, this);
            sm.sendMessage(msg);
        L6:
            if (getRequest().isHiddenFromAppOps() == true) goto L8;
            this.this$0.mAppOpsHelper.startOpNoThrow(41, getIdentity());
        L8:
            onHighPowerUsageChanged();
        }

        @Override // com.android.server.location.listeners.ListenerRegistration
        protected void onInactive() {
            onHighPowerUsageChanged();
            if (getRequest().isHiddenFromAppOps() == true) goto L5;
            this.this$0.mAppOpsHelper.finishOp(41, getIdentity());
        L5:
            LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_LOCATION, "[" + this.this$0.mUserHelper.getCurrentUserId() + "]" + this.this$0.mName + " provider " + getIdentity() + " active = false");
            if ("gps".equals(this.this$0.mName) == false) goto L14;
            GPOStateMachine sm = GPOStateMachine.getGpoStateMachine();
            Message msg = sm.obtainMessage(4, this);
            sm.sendMessage(msg);
        L14:
            LocationEventLog.EVENT_LOG.logProviderClientInactive(this.this$0.mName, getIdentity());     // Catch: IllegalStateException -> L10
        L12:
            LocationEventsTracker.getInstance().recordRegistrationActive(getIdentity(), false);
            return;
        L10:
            e = move-exception;
            LocationEventLog.EVENT_LOG.logErrorEvent(e.toString());
            Log.e(LocationManagerService.TAG, e.toString());
            goto L12
        }

        final void setLastDeliveredLocation(Location location) {
            this.mLastLocation = location;
        }

        public final Location getLastDeliveredLocation() {
            Object r0 = LocationProviderManager.access$100(this.this$0);
            monitor-enter(r0);
            Location r1 = this.mLastLocation;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public int getPermissionLevel() {
            Object r0 = LocationProviderManager.access$200(this.this$0);
            monitor-enter(r0);
            int r1 = this.mPermissionLevel;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public final boolean isForeground() {
            Object r0 = LocationProviderManager.access$300(this.this$0);
            monitor-enter(r0);
            boolean r1 = this.mForeground;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L7
            return r1;
        L7:
            th = move-exception;
            throw th;
        }

        public final boolean isPermitted() {
            Object r0 = LocationProviderManager.access$400(this.this$0);
            monitor-enter(r0);
        L10:
            th = move-exception;
            throw th;
        L5:
            if (this.mPermitted == true) goto L12;
            if (this.mBypassPermitted == true) goto L12;
            boolean r1 = false;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L10
            return r1;
        L12:
            r1 = true;
            goto L13
        }

        public final boolean isOnlyBypassPermitted() {
            Object r0 = LocationProviderManager.access$500(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (this.mBypassPermitted == true) goto L7;
        L11:
            boolean r1 = false;
        L12:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r1;
        L7:
            if (this.mPermitted == true) goto L11;
            r1 = true;
            goto L12
        }

        private /* synthetic */ void lambda$flush$1(final int requestCode) {
            executeOperation(new LocationProviderManager$Registration$$ExternalSyntheticLambda0(requestCode));
        }

        public final void flush(final int requestCode) {
            this.this$0.mProvider.getController().flush(new LocationProviderManager$Registration$$ExternalSyntheticLambda1(this, requestCode));
        }

        private static /* synthetic */ void lambda$flush$0(int requestCode, LocationTransport listener) throws Exception {
            listener.deliverOnFlushComplete(requestCode);
        }

        @Override // com.android.server.location.listeners.RemovableListenerRegistration
        /* JADX INFO: renamed from: getOwner, reason: avoid collision after fix types in other method */
        protected final ListenerMultiplexer<Object, ? super LocationTransport, ?, ?> getOwner2() {
            return this.this$0;
        }

        final boolean onProviderPropertiesChanged() {
            Object r0 = LocationProviderManager.access$600(this.this$0);
            monitor-enter(r0);
            onHighPowerUsageChanged();     // Catch: Throwable -> L8
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L8:
            th = move-exception;
            throw th;
        }

        private void onHighPowerUsageChanged() {
            boolean isUsingHighPower = isUsingHighPower();
            if (isUsingHighPower == this.mIsUsingHighPower) goto L11;
            this.mIsUsingHighPower = isUsingHighPower;
            if (getRequest().isHiddenFromAppOps() == false) goto L7;
            return;
        L7:
            if (this.mIsUsingHighPower == false) goto L9;
            this.this$0.mAppOpsHelper.startOpNoThrow(42, getIdentity());
            return;
        L9:
            this.this$0.mAppOpsHelper.finishOp(42, getIdentity());
            return;
        }

        private boolean isUsingHighPower() {
            ProviderProperties properties = this.this$0.getProperties();
            if (properties != null) goto L6;
            return false;
        L6:
            if (isActive() == true) goto L8;
            return false;
        L8:
            if (getRequest().getIntervalMillis() < 300000) goto L10;
            return false;
        L10:
            if (properties.getPowerUsage() != 3) goto L16;
            return true;
        L16:
            return false;
        }

        final boolean onLocationPermissionsChanged(String packageName) {
            Object r0 = LocationProviderManager.access$700(this.this$0);
            monitor-enter(r0);
            if (packageName == null) goto L13;
        L11:
            th = move-exception;
            throw th;
        L6:
            if (getIdentity().getPackageName().equals(packageName) == true) goto L13;
            monitor-exit(r0);     // Catch: Throwable -> L11
            return false;
        L13:
            boolean r1 = onLocationPermissionsChanged();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            return r1;
        }

        final boolean onLocationPermissionsChanged(int uid) {
            Object r0 = LocationProviderManager.access$800(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (getIdentity().getUid() != uid) goto L11;
            boolean r1 = onLocationPermissionsChanged();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r1;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        }

        boolean onBypassLocationPermissionsChanged(boolean isInEmergency) {
            Object r0 = LocationProviderManager.access$900(this.this$0);
            monitor-enter(r0);
            if (isInEmergency == true) goto L24;
        L11:
            boolean bypassPermitted = false;
        L13:
            if (this.mBypassPermitted != bypassPermitted) goto L15;
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        L15:
            if (LocationManagerService.D == false) goto L17;
            Log.v(LocationManagerService.TAG, this.this$0.mName + " provider package " + getIdentity().getPackageName() + " bypass permitted = " + bypassPermitted);     // Catch: Throwable -> L9
        L17:
            this.mBypassPermitted = bypassPermitted;     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return true;
        L24:
        L9:
            th = move-exception;
            throw th;
        L7:
            if (this.this$0.mContext.checkPermission("android.permission.LOCATION_BYPASS", this.mIdentity.getPid(), this.mIdentity.getUid()) != 0) goto L11;
            bypassPermitted = true;
            goto L13
        }

        private boolean onLocationPermissionsChanged() {
            boolean permitted = this.this$0.mLocationPermissionsHelper.hasLocationPermissions(this.mPermissionLevel, getIdentity());
            if (permitted != this.mPermitted) goto L5;
            return false;
        L5:
            if (LocationManagerService.D == false) goto L7;
            Log.v(LocationManagerService.TAG, this.this$0.mName + " provider package " + getIdentity().getPackageName() + " permitted = " + permitted);
        L7:
            this.mPermitted = permitted;
            if (this.mPermitted == false) goto L10;
            LocationEventLog.EVENT_LOG.logProviderClientPermitted(this.this$0.mName, getIdentity());
            return true;
        L10:
            LocationEventLog.EVENT_LOG.logProviderClientUnpermitted(this.this$0.mName, getIdentity());
            return true;
        }

        final boolean onAdasGnssLocationEnabledChanged(int userId) {
            Object r0 = LocationProviderManager.access$1000(this.this$0);
            monitor-enter(r0);
        L9:
            th = move-exception;
            throw th;
        L5:
            if (getIdentity().getUserId() != userId) goto L11;
            boolean r1 = onProviderLocationRequestChanged();     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            return r1;
        L11:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return false;
        }

        final boolean onForegroundChanged(int uid, boolean foreground) {
            Object r0 = LocationProviderManager.access$1100(this.this$0);
            monitor-enter(r0);
            boolean r2 = false;
            if (getIdentity().getUid() == uid) goto L7;
        L25:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return false;
        L7:
            if (foreground == this.mForeground) goto L25;
            LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_LOCATION, "[" + this.this$0.mUserHelper.getCurrentUserId() + "]" + this.this$0.mName + " provider " + getIdentity() + " foreground = " + foreground);     // Catch: Throwable -> L12
            this.mForeground = foreground;     // Catch: Throwable -> L12
            LocationEventsTracker.getInstance().recordRegistrationForeground(getIdentity(), this.mForeground);     // Catch: Throwable -> L12
            if (this.mForeground == false) goto L30;
            LocationEventLog.EVENT_LOG.logProviderClientForeground(this.this$0.mName, getIdentity());     // Catch: Throwable -> L12
        L19:
            if (onProviderLocationRequestChanged() == false) goto L21;
        L22:
            r2 = true;
        L23:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r2;
        L21:
            if (this.this$0.mLocationPowerSaveModeHelper.getLocationPowerSaveMode() != 3) goto L23;
        L30:
            LocationEventLog.EVENT_LOG.logProviderClientBackground(this.this$0.mName, getIdentity());     // Catch: Throwable -> L12 IllegalStateException -> L16
        L16:
            e = move-exception;
            LocationEventLog.EVENT_LOG.logErrorEvent(e.toString());     // Catch: Throwable -> L12
            Log.e(LocationManagerService.TAG, e.toString());     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;
        }

        final boolean onProviderLocationRequestChanged() {
            Object r0 = LocationProviderManager.access$1200(this.this$0);
            monitor-enter(r0);
            LocationRequest newRequest = calculateProviderLocationRequest();     // Catch: Throwable -> L8
            boolean r3 = false;
            if (this.mProviderLocationRequest.equals(newRequest) == false) goto L10;
            monitor-exit(r0);     // Catch: Throwable -> L8
            return false;
        L10:
            LocationRequest oldRequest = this.mProviderLocationRequest;     // Catch: Throwable -> L8
            this.mProviderLocationRequest = newRequest;     // Catch: Throwable -> L8
            onHighPowerUsageChanged();     // Catch: Throwable -> L8
            LocationProviderManager.access$1300(this.this$0);     // Catch: Throwable -> L8
            if (oldRequest.isBypass() == newRequest.isBypass()) goto L13;
            r3 = true;
        L13:
            monitor-exit(r0);     // Catch: Throwable -> L8
            return r3;
        L8:
            th = move-exception;
            throw th;
        }

        private LocationRequest calculateProviderLocationRequest() {
            LocationRequest.Builder builder = new LocationRequest.Builder(this.mBaseRequest);
            if (this.mPermissionLevel >= 2) goto L10;
            builder.setQuality(104);
            if (this.mBaseRequest.getIntervalMillis() >= 600000) goto L8;
            builder.setIntervalMillis(600000);
        L8:
            if (this.mBaseRequest.getMinUpdateIntervalMillis() >= 600000) goto L10;
            builder.setMinUpdateIntervalMillis(600000);
        L10:
            boolean locationSettingsIgnored = this.mBaseRequest.isLocationSettingsIgnored();
            if (locationSettingsIgnored == true) goto L13;
        L18:
            boolean adasGnssBypass = this.mBaseRequest.isAdasGnssBypass();
            if (adasGnssBypass == true) goto L21;
        L33:
            if (locationSettingsIgnored == true) goto L40;
            if (isThrottlingExempt() == true) goto L40;
            if (this.mForeground == true) goto L40;
            builder.setIntervalMillis(Math.max(this.mBaseRequest.getIntervalMillis(), this.this$0.mSettingsHelper.getBackgroundThrottleIntervalMs()));
        L40:
            return builder.build();
        L21:
            if ("gps".equals(this.this$0.mName) == true) goto L24;
            Log.e(LocationManagerService.TAG, "adas gnss bypass request received in non-gps provider");
            adasGnssBypass = false;
        L32:
            builder.setAdasGnssBypass(adasGnssBypass);
            goto L33
        L24:
            if (this.this$0.mUserHelper.isCurrentUserId(getIdentity().getUserId()) == true) goto L27;
            adasGnssBypass = false;
            goto L32
        L27:
            if (this.this$0.mLocationSettings.getUserSettings(getIdentity().getUserId()).isAdasGnssLocationEnabled() == true) goto L30;
            adasGnssBypass = false;
            goto L32
        L30:
            if (this.this$0.mSettingsHelper.getAdasAllowlist().contains(getIdentity().getPackageName(), getIdentity().getAttributionTag()) == true) goto L32;
            adasGnssBypass = false;
            goto L32
        L13:
            if (this.this$0.mSettingsHelper.getIgnoreSettingsAllowlist().contains(getIdentity().getPackageName(), getIdentity().getAttributionTag()) == false) goto L15;
        L17:
            builder.setLocationSettingsIgnored(locationSettingsIgnored);
            goto L18
        L15:
            if (this.this$0.mLocationManagerInternal.isProvider(null, getIdentity()) == true) goto L17;
            locationSettingsIgnored = false;
            goto L17
        }

        private boolean isThrottlingExempt() {
            if (this.this$0.mSettingsHelper.getBackgroundThrottlePackageWhitelist().contains(getIdentity().getPackageName()) == false) goto L5;
            return true;
        L5:
            if (LocationProviderManager.m5404$$Nest$minWhiteList(this.this$0, getIdentity().getPackageName()) == false) goto L8;
            return true;
        L8:
            return this.this$0.mLocationManagerInternal.isProvider(null, getIdentity());
        }

        @Override // com.android.server.location.listeners.ListenerRegistration
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append(getIdentity());
            ArraySet<String> flags = new ArraySet(2);
            if (isForeground() == true) goto L6;
            flags.add("bg");
        L6:
            if (isPermitted() == true) goto L9;
            flags.add("na");
        L9:
            if (flags.isEmpty() == true) goto L12;
            builder.append(" ");
            builder.append(flags);
        L12:
            if (this.mPermissionLevel != 1) goto L14;
            builder.append(" (COARSE)");
        L14:
            builder.append(" ");
            builder.append(getRequest());
            return builder.toString();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface State {
    }

    public interface StateChangedListener {
        void onStateChanged(String r1, AbstractLocationProvider.State r2, AbstractLocationProvider.State r3);
    }

    public static /* synthetic */ void $r8$lambda$2Txn4JahnVziiUFlJ2Tn6uMF8_E(LocationProviderManager r0, LocationManagerInternal.ProviderEnabledListener[] r1, int r2, boolean r3) {
        r0.lambda$onEnabledChanged$24(r1, r2, r3);
    }

    public static /* synthetic */ boolean $r8$lambda$51DJZnSFsHaB0grBYq2xNJlHPLI(boolean r0, Registration r1) {
        return lambda$onEmergencyStateChanged$9(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$5WFz9G7WRD7zxHjQZ5ArYZQ75o4(Object r0) {
        return lambda$stopManager$0(r0);
    }

    public static /* synthetic */ void $r8$lambda$5iQjh8EE3FPrmivvlPb3c2PMFpA(LocationProviderManager r0) {
        r0.onBackgroundThrottlePackageWhitelistChanged();
    }

    public static /* synthetic */ void $r8$lambda$7dtSysLGgcVrXhe4MUTzi03qUaU(LocationProviderManager r0, int r1, LocationUserSettings r2, LocationUserSettings r3) {
        r0.onLocationUserSettingsChanged(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$BAw8KhPGgRgYx-vUfk3_wmk7oJI, reason: not valid java name */
    public static /* synthetic */ boolean m5389$r8$lambda$BAw8KhPGgRgYxvUfk3_wmk7oJI(Location r0) {
        return lambda$onReportLocation$20(r0);
    }

    public static /* synthetic */ void $r8$lambda$BdUB__o6u_lJsqreFzvuZ5h1yeE(LocationProviderManager r0, ProviderRequest r1) {
        r0.lambda$setProviderRequest$5(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$FyHSmY-NKsgBLThTf9JyOLHE3ZQ, reason: not valid java name */
    public static /* synthetic */ boolean m5390$r8$lambda$FyHSmYNKsgBLThTf9JyOLHE3ZQ(int r0, Registration r1) {
        return lambda$flush$3(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$GiZoVA4SpzOqdnke443dgGZ9qsI(Registration r0) {
        return lambda$onLocationPowerSaveModeChanged$10(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$JovZIj_pUrKs6VlHywK-w4tfsc8, reason: not valid java name */
    public static /* synthetic */ void m5391$r8$lambda$JovZIj_pUrKs6VlHywKw4tfsc8(RuntimeException r0) {
        lambda$getCurrentLocation$1(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$KEBzXCodHz2e9jyNz2PO4hi9hcM(int r0, boolean r1, Registration r2) {
        return lambda$onAppForegroundChanged$11(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$L2loaW_YIGuxUq693vGSDrpYkNo(LocationProviderManager r0) {
        r0.onAdasAllowlistChanged();
    }

    public static /* synthetic */ void $r8$lambda$Ogb0dgpiU2TFckJSwOP6u4xLmTU(LocationProviderManager r0) {
        r0.onEmergencyStateChanged();
    }

    /* JADX INFO: renamed from: $r8$lambda$P-_NnVDCrvY6rryuxlEpGIK8zVc, reason: not valid java name */
    public static /* synthetic */ void m5392$r8$lambda$P_NnVDCrvY6rryuxlEpGIK8zVc(LocationProviderManager r0, StateChangedListener r1, AbstractLocationProvider.State r2, AbstractLocationProvider.State r3) {
        r0.lambda$onStateChanged$19(r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$Qe5jTJjaSJU7ImULkZAW4-kNw9M, reason: not valid java name */
    public static /* synthetic */ boolean m5393$r8$lambda$Qe5jTJjaSJU7ImULkZAW4kNw9M(String r0, Registration r1) {
        return lambda$onPackageReset$17(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$TkAhbdNUsCCUziTe8aGu6Brc-XA, reason: not valid java name */
    public static /* synthetic */ void m5394$r8$lambda$TkAhbdNUsCCUziTe8aGu6BrcXA(LocationProviderManager r0) {
        r0.onIgnoreSettingsWhitelistChanged();
    }

    public static /* synthetic */ boolean $r8$lambda$UTCpk95Vv15pE_v1KFHCIiq6q2A(int r0, Registration r1) {
        return lambda$onUserChanged$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$UwaoFDDWsSF9fseHy_nG1YkTvtY(LocationProviderManager r0, Location r1) {
        r0.lambda$processReportedLocation$22(r1);
    }

    public static /* synthetic */ void $r8$lambda$VwFP57pdaHi7KZNl8UYXKlc9QV0(LocationProviderManager r0, boolean r1) {
        r0.onScreenInteractiveChanged(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$WPmdafRgcyxAbdkLfhoBrLmQZUM(int r0, Registration r1) {
        return lambda$onLocationUserSettingsChanged$7(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$X8AP7J5FlpBRm8JxQOZTluAZCxc(String r0, Registration r1) {
        return lambda$isResetableForPackage$18(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$ZXN_h6DDTo8Q9vBhqWUlQSLwz7I(LocationProviderManager r0, int r1, int r2) {
        r0.onUserChanged(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$a3Z8nDABZyLkK2LFh8YIMBZZX6E(LocationProviderManager r0, int r1, boolean r2) {
        r0.onAppForegroundChanged(r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$aBFEV3wFX3ivmCvDsz7trSjEq5I(LocationProviderManager r0, int r1) {
        r0.onLocationPowerSaveModeChanged(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$c7z2-hPVP12GIvztzAGjONiu6b8, reason: not valid java name */
    public static /* synthetic */ boolean m5395$r8$lambda$c7z2hPVP12GIvztzAGjONiu6b8(String r0, Registration r1) {
        return lambda$onLocationPermissionsChanged$15(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$cE89NxEIbs1FfUXQTwtiPpqt5vg(Registration r0) {
        return lambda$onScreenInteractiveChanged$8(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$dnZwHxJ7HYRE9rtfrw3YhFQUa6A(int r0, Registration r1) {
        return lambda$onLocationPermissionsChanged$16(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$eXeGsBMR0F6K_EqEIBw61OEiEAk(LocationProviderManager r0) {
        r0.onBackgroundThrottleIntervalChanged();
    }

    /* JADX INFO: renamed from: $r8$lambda$eoUbbp7rF9-VS9hg-gK9dc3RYic, reason: not valid java name */
    public static /* synthetic */ boolean m5396$r8$lambda$eoUbbp7rF9VS9hggK9dc3RYic(int r0, Registration r1) {
        return lambda$onLocationPackageBlacklistChanged$14(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$f_ftJLLok4YXekq-L2Xg6qZGeVI, reason: not valid java name */
    public static /* synthetic */ ListenerExecutor.ListenerOperation m5397$r8$lambda$f_ftJLLok4YXekqL2Xg6qZGeVI(LocationResult r0, Registration r1) {
        return lambda$onReportLocation$21(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$g6Fribzg1JWWpgEvLcreQ2iGA-w, reason: not valid java name */
    public static /* synthetic */ Location m5398$r8$lambda$g6Fribzg1JWWpgEvLcreQ2iGAw(LocationProviderManager r0, Location r1) {
        return r0.lambda$processReportedLocation$23(r1);
    }

    public static /* synthetic */ boolean $r8$lambda$hJs5nu7gbHa81ez0rMYcC_ealjY(int r0, boolean r1, Registration r2) {
        return lambda$onAppForegroundChanged$12(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$hZRiCnTV5TywYMZ2jlcrR7xk8rM(LocationProviderManager r0, int r1) {
        r0.onLocationPackageBlacklistChanged(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$jIF-79JVnUdEG5sKmrDBya8srbM, reason: not valid java name */
    public static /* synthetic */ void m5399$r8$lambda$jIF79JVnUdEG5sKmrDBya8srbM(LocationProviderManager r0, ILocationCallback r1, GetCurrentLocationListenerRegistration r2) {
        r0.lambda$getCurrentLocation$2(r1, r2);
    }

    public static /* synthetic */ boolean $r8$lambda$q7Uj89kQ5Nr9dnuzWuAD87GXETY(int r0, Registration r1) {
        return lambda$onAppUidFrozenChanged$13(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$sVxlyQVInrORO8WR9z1p0lPyhmk(LocationProviderManager r0, int r1) {
        r0.onLocationEnabledChanged(r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$uNlR-vO2aZC65G2-hm6M6-T66Hw, reason: not valid java name */
    public static /* synthetic */ boolean m5400$r8$lambda$uNlRvO2aZC65G2hm6M6T66Hw(int r0, Registration r1) {
        return lambda$onEnabledChanged$25(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$y-HZVR05Lb-x_x5B-bj24m1E8G8, reason: not valid java name */
    public static /* synthetic */ boolean m5401$r8$lambda$yHZVR05Lbx_x5Bbj24m1E8G8(int r0, Registration r1) {
        return lambda$flush$4(r0, r1);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmDelayedRegister, reason: not valid java name */
    static /* bridge */ /* synthetic */ AlarmManager.OnAlarmListener m5402$$Nest$fgetmDelayedRegister(LocationProviderManager r0) {
        return r0.mDelayedRegister;
    }

    /* JADX INFO: renamed from: -$$Nest$fputmDelayedRegister, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5403$$Nest$fputmDelayedRegister(LocationProviderManager r0, AlarmManager.OnAlarmListener r1) {
        r0.mDelayedRegister = r1;
    }

    /* JADX INFO: renamed from: -$$Nest$minWhiteList, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5404$$Nest$minWhiteList(LocationProviderManager r0, String r1) {
        return r0.inWhiteList(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$misResetableForPackage, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m5405$$Nest$misResetableForPackage(LocationProviderManager r0, String r1) {
        return r0.isResetableForPackage(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monLocationPermissionsChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5406$$Nest$monLocationPermissionsChanged(LocationProviderManager r0, int r1) {
        r0.onLocationPermissionsChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monLocationPermissionsChanged, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5407$$Nest$monLocationPermissionsChanged(LocationProviderManager r0, String r1) {
        r0.onLocationPermissionsChanged(r1);
    }

    /* JADX INFO: renamed from: -$$Nest$monPackageReset, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m5408$$Nest$monPackageReset(LocationProviderManager r0, String r1) {
        r0.onPackageReset(r1);
    }

    static /* synthetic */ Object access$000(LocationProviderManager x0) {
        return x0.mMultiplexerLock;
    }

    static /* synthetic */ Object access$100(LocationProviderManager x0) {
        return x0.mMultiplexerLock;
    }

    static /* synthetic */ Object access$1000(LocationProviderManager x0) {
        return x0.mMultiplexerLock;
    }

    static /* synthetic */ Object access$1100(LocationProviderManager x0) {
        return x0.mMultiplexerLock;
    }

    static /* synthetic */ Object access$1200(LocationProviderManager x0) {
        return x0.mMultiplexerLock;
    }

    static /* synthetic */ void access$1300(LocationProviderManager x0) {
        x0.updateService();
    }

    static /* synthetic */ Object access$1400(LocationProviderManager x0) {
        return x0.mMultiplexerLock;
    }

    static /* synthetic */ Object access$1500(LocationProviderManager x0) {
        return x0.mMultiplexerLock;
    }

    static /* synthetic */ Object access$1600(LocationProviderManager x0) {
        return x0.mMultiplexerLock;
    }

    static /* synthetic */ Object access$200(LocationProviderManager x0) {
        return x0.mMultiplexerLock;
    }

    static /* synthetic */ Object access$300(LocationProviderManager x0) {
        return x0.mMultiplexerLock;
    }

    static /* synthetic */ Object access$400(LocationProviderManager x0) {
        return x0.mMultiplexerLock;
    }

    static /* synthetic */ Object access$500(LocationProviderManager x0) {
        return x0.mMultiplexerLock;
    }

    static /* synthetic */ Object access$600(LocationProviderManager x0) {
        return x0.mMultiplexerLock;
    }

    static /* synthetic */ Object access$700(LocationProviderManager x0) {
        return x0.mMultiplexerLock;
    }

    static /* synthetic */ Object access$800(LocationProviderManager x0) {
        return x0.mMultiplexerLock;
    }

    static /* synthetic */ Object access$900(LocationProviderManager x0) {
        return x0.mMultiplexerLock;
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ boolean isActive(ListenerRegistration r1) {
        return isActive((Registration) r1);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ ProviderRequest mergeRegistrations(Collection r1) {
        return mergeRegistrations(r1);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ void onRegistrationAdded(Object r1, ListenerRegistration r2) {
        onRegistrationAdded(r1, (Registration) r2);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ void onRegistrationRemoved(Object r1, ListenerRegistration r2) {
        onRegistrationRemoved(r1, (Registration) r2);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ void onRegistrationReplaced(Object r1, ListenerRegistration r2, Object r3, ListenerRegistration r4) {
        onRegistrationReplaced(r1, (Registration) r2, r3, (Registration) r4);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ boolean registerWithService(ProviderRequest r1, Collection r2) {
        return registerWithService2(r1, r2);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected /* bridge */ /* synthetic */ boolean reregisterWithService(ProviderRequest r1, ProviderRequest r2, Collection r3) {
        return reregisterWithService2(r1, r2, r3);
    }

    public LocationProviderManager(Context context, Injector injector, String name, PassiveLocationProviderManager passiveManager) {
        this(context, injector, name, passiveManager, Collections.emptyList());
    }

    public LocationProviderManager(Context context, Injector injector, String name, PassiveLocationProviderManager passiveManager, Collection<String> requiredPermissions) {
        this.mUserChangedListener = new LocationProviderManager$$ExternalSyntheticLambda5(this);
        this.mLocationUserSettingsListener = new LocationProviderManager$$ExternalSyntheticLambda8(this);
        this.mLocationEnabledChangedListener = new LocationProviderManager$$ExternalSyntheticLambda9(this);
        this.mBackgroundThrottlePackageWhitelistChangedListener = new LocationProviderManager$$ExternalSyntheticLambda10(this);
        this.mLocationPackageBlacklistChangedListener = new LocationProviderManager$$ExternalSyntheticLambda11(this);
        this.mLocationPermissionsListener = new AnonymousClass1(this);
        this.mAppForegroundChangedListener = new LocationProviderManager$$ExternalSyntheticLambda12(this);
        this.mBackgroundThrottleIntervalChangedListener = new LocationProviderManager$$ExternalSyntheticLambda13(this);
        this.mAdasPackageAllowlistChangedListener = new LocationProviderManager$$ExternalSyntheticLambda14(this);
        this.mIgnoreSettingsPackageWhitelistChangedListener = new LocationProviderManager$$ExternalSyntheticLambda15(this);
        this.mLocationPowerSaveModeChangedListener = new LocationProviderManager$$ExternalSyntheticLambda16(this);
        this.mScreenInteractiveChangedListener = new LocationProviderManager$$ExternalSyntheticLambda6(this);
        this.mEmergencyStateChangedListener = new LocationProviderManager$$ExternalSyntheticLambda7(this);
        this.mPackageResetResponder = new AnonymousClass2(this);
        this.mAltitudeConverter = new AltitudeConverter();
        this.mIsAltitudeConverterIdle = true;
        this.mContext = context;
        name.getClass();
        this.mName = name;
        this.mPassiveManager = passiveManager;
        this.mState = 2;
        this.mEnabled = new SparseBooleanArray(2);
        this.mLastLocations = new SparseArray(2);
        this.mRequiredPermissions = requiredPermissions;
        this.mEnabledListeners = new ArrayList();
        this.mProviderRequestListeners = new CopyOnWriteArrayList();
        LocationManagerInternal r0 = (LocationManagerInternal) LocalServices.getService(LocationManagerInternal.class);
        r0.getClass();
        this.mLocationManagerInternal = r0;
        this.mLocationSettings = injector.getLocationSettings();
        this.mSettingsHelper = injector.getSettingsHelper();
        this.mUserHelper = injector.getUserInfoHelper();
        this.mAlarmHelper = injector.getAlarmHelper();
        this.mAppOpsHelper = injector.getAppOpsHelper();
        this.mLocationPermissionsHelper = injector.getLocationPermissionsHelper();
        this.mAppForegroundHelper = injector.getAppForegroundHelper();
        this.mLocationPowerSaveModeHelper = injector.getLocationPowerSaveModeHelper();
        this.mScreenInteractiveHelper = injector.getScreenInteractiveHelper();
        this.mLocationUsageLogger = injector.getLocationUsageLogger();
        this.mLocationFudger = new LocationFudger(this.mSettingsHelper.getCoarseLocationAccuracyM());
        this.mEmergencyHelper = injector.getEmergencyHelper();
        this.mPackageResetHelper = injector.getPackageResetHelper();
        this.mProvider = new MockableLocationProvider(this.mMultiplexerLock);
        this.mProvider.getController().setListener(this);
        SysOptBridge.getFactory().getLocationProvider().init(this, this.mContext);
    }

    public void startManager(StateChangedListener listener) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != 2) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1);     // Catch: Throwable -> L13
        this.mState = 0;     // Catch: Throwable -> L13
        this.mStateChangedListener = listener;     // Catch: Throwable -> L13
        this.mUserHelper.addListener(this.mUserChangedListener);     // Catch: Throwable -> L13
        this.mLocationSettings.registerLocationUserSettingsListener(this.mLocationUserSettingsListener);     // Catch: Throwable -> L13
        this.mSettingsHelper.addOnLocationEnabledChangedListener(this.mLocationEnabledChangedListener);     // Catch: Throwable -> L13
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L13
        this.mProvider.getController().start();     // Catch: Throwable -> L15
        onUserStarted(-1);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L7:
        r1 = false;
        goto L8
    }

    public void stopManager() {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != 0) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1);     // Catch: Throwable -> L14
        this.mState = 1;     // Catch: Throwable -> L14
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L14
        onEnabledChanged(-1);     // Catch: Throwable -> L16
        removeRegistrationIf(new LocationProviderManager$$ExternalSyntheticLambda19());     // Catch: Throwable -> L16
        this.mProvider.getController().stop();     // Catch: Throwable -> L16
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L14
        this.mUserHelper.removeListener(this.mUserChangedListener);     // Catch: Throwable -> L14
        this.mLocationSettings.unregisterLocationUserSettingsListener(this.mLocationUserSettingsListener);     // Catch: Throwable -> L14
        this.mSettingsHelper.removeOnLocationEnabledChangedListener(this.mLocationEnabledChangedListener);     // Catch: Throwable -> L14
        Preconditions.checkState(this.mEnabledListeners.isEmpty());     // Catch: Throwable -> L14
        this.mProviderRequestListeners.clear();     // Catch: Throwable -> L14
        this.mEnabled.clear();     // Catch: Throwable -> L14
        this.mLastLocations.clear();     // Catch: Throwable -> L14
        this.mStateChangedListener = null;     // Catch: Throwable -> L14
        this.mState = 2;     // Catch: Throwable -> L14
        monitor-exit(r0);     // Catch: Throwable -> L14
        return;
    L16:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L14
        throw th;     // Catch: Throwable -> L14
    L7:
        r1 = false;
        goto L8
    }

    private static /* synthetic */ boolean lambda$stopManager$0(Object key) {
        return true;
    }

    public String getName() {
        return this.mName;
    }

    public AbstractLocationProvider.State getState() {
        return this.mProvider.getState();
    }

    public CallerIdentity getProviderIdentity() {
        return this.mProvider.getState().identity;
    }

    public ProviderProperties getProperties() {
        return this.mProvider.getState().properties;
    }

    public boolean hasProvider() {
        if (this.mProvider.getProvider() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isEnabled(int userId) {
        boolean r1 = false;
        if (userId != (-10000)) goto L6;
        return false;
    L6:
        if (userId == (-2)) goto L8;
        if (userId < 0) goto L11;
        r1 = true;
    L11:
        Preconditions.checkArgument(r1);
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
        int index = this.mEnabled.indexOfKey(userId);     // Catch: Throwable -> L16
        if (index >= 0) goto L18;
        Log.w(LocationManagerService.TAG, this.mName + " provider saw user " + userId + " unexpectedly");     // Catch: Throwable -> L16
        onEnabledChanged(userId);     // Catch: Throwable -> L16
        index = this.mEnabled.indexOfKey(userId);     // Catch: Throwable -> L16
    L18:
        boolean r2 = this.mEnabled.valueAt(index);     // Catch: Throwable -> L16
        monitor-exit(r0);     // Catch: Throwable -> L16
        return r2;
    L16:
        th = move-exception;
        throw th;
    L8:
        return isEnabled(this.mUserHelper.getCurrentUserId());
    }

    public void setLocationFudgerCache(LocationFudgerCache cache) {
        this.mLocationFudger.setLocationFudgerCache(cache);
    }

    public boolean isVisibleToCaller() {
        if (Binder.getCallingUid() != 1000) goto L6;
        return true;
    L6:
        if (this.mProvider.isMock() == false) goto L8;
        return true;
    L8:
        Iterator<String> r0 = this.mRequiredPermissions.iterator();
    L10:
        if (r0.hasNext() == false) goto L16;
        String permission = r0.next();
        if (this.mContext.checkCallingOrSelfPermission(permission) == 0) goto L10;
        return false;
    L16:
        return true;
    }

    public void addEnabledListener(LocationManagerInternal.ProviderEnabledListener listener) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mState == 2) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1);     // Catch: Throwable -> L11
        this.mEnabledListeners.add(listener);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        r1 = false;
        goto L8
    }

    public void removeEnabledListener(LocationManagerInternal.ProviderEnabledListener listener) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mState == 2) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1);     // Catch: Throwable -> L11
        this.mEnabledListeners.remove(listener);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L7:
        r1 = false;
        goto L8
    }

    public void addProviderRequestListener(IProviderRequestListener listener) {
        this.mProviderRequestListeners.add(listener);
    }

    public void removeProviderRequestListener(IProviderRequestListener listener) {
        this.mProviderRequestListeners.remove(listener);
    }

    public void setRealProvider(AbstractLocationProvider provider) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mState == 2) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1);     // Catch: Throwable -> L13
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L13
        this.mProvider.setRealProvider(provider);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L7:
        r1 = false;
        goto L8
    }

    public void setMockProvider(MockLocationProvider provider) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
        boolean r3 = false;
        if (this.mState == 2) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1);     // Catch: Throwable -> L18
        LocationEventLog r2 = LocationEventLog.EVENT_LOG;     // Catch: Throwable -> L18
        String r4 = this.mName;     // Catch: Throwable -> L18
        if (provider == null) goto L11;
        r3 = true;
    L11:
        r2.logProviderMocked(r4, r3);     // Catch: Throwable -> L18
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L18
        this.mProvider.setMockProvider(provider);     // Catch: Throwable -> L23
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L18
        if (provider != null) goto L21;
        int lastLocationSize = this.mLastLocations.size();     // Catch: Throwable -> L18
        int i = 0;
    L16:
        if (i >= lastLocationSize) goto L20;
        this.mLastLocations.valueAt(i).clearMock();     // Catch: Throwable -> L18
        i = i + 1;     // Catch: Throwable -> L18
        goto L16
    L20:
        this.mLocationFudger.resetOffsets();     // Catch: Throwable -> L18
    L21:
        monitor-exit(r0);     // Catch: Throwable -> L18
        return;
    L23:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L7:
        r1 = false;
    L18:
        th = move-exception;
        throw th;
    }

    public void setMockProviderAllowed(boolean enabled) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mProvider.isMock() == false) goto L17;
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L11
        this.mProvider.setMockProviderAllowed(enabled);     // Catch: Throwable -> L13
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L13:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L17:
        throw new IllegalArgumentException(this.mName + " provider is not a test provider");     // Catch: Throwable -> L11
    }

    public void setMockProviderLocation(Location location) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (this.mProvider.isMock() == false) goto L22;
        String locationProvider = location.getProvider();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(locationProvider) == false) goto L9;
    L13:
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L11
        this.mProvider.setMockProviderLocation(location);     // Catch: Throwable -> L18
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L18:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L11
        throw th;     // Catch: Throwable -> L11
    L9:
        if (this.mName.equals(locationProvider) == true) goto L13;
        EventLog.writeEvent(1397638484, new Object[]{"33091107", Integer.valueOf(Binder.getCallingUid()), this.mName + "!=" + locationProvider});     // Catch: Throwable -> L11
        goto L13
    L22:
        throw new IllegalArgumentException(this.mName + " provider is not a test provider");     // Catch: Throwable -> L11
    }

    public Location getLastLocation(LastLocationRequest request, CallerIdentity identity, int permissionLevel) {
        LastLocationRequest request2 = calculateLastLocationRequest(request, identity);
        if (isActive(request2.isBypass(), identity) == true) goto L6;
        return null;
    L6:
        if (StarLocation.getInstance().isZppEnabled() == true) goto L8;
    L14:
        LocationProviderManager r2 = this;
        int permissionLevel2 = permissionLevel;
        Location location = getPermittedLocation(r2.getLastLocationUnsafe(identity.getUserId(), permissionLevel2, request2.isBypass(), Long.MAX_VALUE), permissionLevel2);
    L15:
        if (location != null) goto L17;
    L31:
        return location;
    L17:
        if (r2.mLocationPermissionsHelper.hasLocationPermissions(permissionLevel2, identity) == false) goto L19;
    L23:
        int op = LocationPermissions.asAppOp(permissionLevel2);
    L25:
        if (r2.mAppOpsHelper.noteOpNoThrow(op, identity) == true) goto L28;
        return null;
    L28:
        if (identity.getPid() != Process.myPid()) goto L30;
        location = new Location(location);
    L30:
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_LOCATION, "[" + r2.mUserHelper.getCurrentUserId() + "]" + r2.mName + " provider getLastLocation " + location + " from " + identity);
        goto L31
    L19:
        if (r2.mEmergencyHelper.isInEmergency(0) == false) goto L23;
        if (r2.mContext.checkPermission("android.permission.LOCATION_BYPASS", identity.getPid(), identity.getUid()) != 0) goto L23;
        op = 147;
        goto L25
    L8:
        if (StarLocation.getInstance().checkZppProviderValid(this.mName) == false) goto L14;
        if (StarLocation.getInstance().checkPackageEnabled(identity.getPackageName()) == false) goto L14;
        if (this.mProvider.isMock() == true) goto L14;
        location = getPermittedLocation(StarLocation.getInstance().getLastKnownLocationFromZpp(identity.getUserId(), this.mName), permissionLevel);
        r2 = this;
        permissionLevel2 = permissionLevel;
        goto L15
    }

    private LastLocationRequest calculateLastLocationRequest(LastLocationRequest baseRequest, CallerIdentity identity) {
        LastLocationRequest.Builder builder = new LastLocationRequest.Builder(baseRequest);
        boolean locationSettingsIgnored = baseRequest.isLocationSettingsIgnored();
        if (locationSettingsIgnored == true) goto L5;
    L10:
        boolean adasGnssBypass = baseRequest.isAdasGnssBypass();
        if (adasGnssBypass == false) goto L26;
        if ("gps".equals(this.mName) == true) goto L16;
        Log.e(LocationManagerService.TAG, "adas gnss bypass request received in non-gps provider");
        adasGnssBypass = false;
    L24:
        builder.setAdasGnssBypass(adasGnssBypass);
        goto L26
    L16:
        if (this.mUserHelper.isCurrentUserId(identity.getUserId()) == true) goto L19;
        adasGnssBypass = false;
        goto L24
    L19:
        if (this.mLocationSettings.getUserSettings(identity.getUserId()).isAdasGnssLocationEnabled() == true) goto L22;
        adasGnssBypass = false;
        goto L24
    L22:
        if (this.mSettingsHelper.getAdasAllowlist().contains(identity.getPackageName(), identity.getAttributionTag()) == true) goto L24;
        adasGnssBypass = false;
    L26:
        return builder.build();
    L5:
        if (this.mSettingsHelper.getIgnoreSettingsAllowlist().contains(identity.getPackageName(), identity.getAttributionTag()) == false) goto L7;
    L9:
        builder.setLocationSettingsIgnored(locationSettingsIgnored);
        goto L10
    L7:
        if (this.mLocationManagerInternal.isProvider(null, identity) == true) goto L9;
        locationSettingsIgnored = false;
        goto L9
    }

    public Location getLastLocationUnsafe(int userId, int permissionLevel, boolean isBypass, long maximumAgeMs) {
        if (userId != (-1)) goto L17;
        Location lastLocation = null;
        int[] runningUserIds = this.mUserHelper.getRunningUserIds();
        int i = 0;
    L6:
        if (i >= runningUserIds.length) goto L15;
        Location next = getLastLocationUnsafe(runningUserIds[i], permissionLevel, isBypass, maximumAgeMs);
        if (lastLocation == null) goto L12;
        if (next == null) goto L13;
        if (next.getElapsedRealtimeNanos() > lastLocation.getElapsedRealtimeNanos()) goto L12;
    L13:
        i = i + 1;
    L12:
        lastLocation = next;
        goto L13
    L15:
        return lastLocation;
    L17:
        if (userId == (-2)) goto L19;
        boolean r0 = false;
        if (userId < 0) goto L23;
        boolean r2 = true;
    L24:
        Preconditions.checkArgument(r2);
        Object r3 = this.mMultiplexerLock;
        monitor-enter(r3);
    L41:
        th = move-exception;
        throw th;
    L27:
        if (this.mState == 2) goto L29;
        r0 = true;
    L29:
        Preconditions.checkState(r0);     // Catch: Throwable -> L41
        LastLocation lastLocation2 = this.mLastLocations.get(userId);     // Catch: Throwable -> L41
        if (lastLocation2 != null) goto L32;
        Location location = null;
    L33:
        monitor-exit(r3);     // Catch: Throwable -> L41
        if (location != null) goto L38;
        return null;
    L38:
        if (location.getElapsedRealtimeAgeMillis() <= maximumAgeMs) goto L40;
        return null;
    L40:
        return location;
    L32:
        location = lastLocation2.get(permissionLevel, isBypass);     // Catch: Throwable -> L41
        goto L33
    L23:
        r2 = false;
        goto L24
    L19:
        return getLastLocationUnsafe(this.mUserHelper.getCurrentUserId(), permissionLevel, isBypass, maximumAgeMs);
    }

    public void injectLastLocation(Location location, int userId) {
        Object r1 = this.mMultiplexerLock;
        monitor-enter(r1);
    L13:
        th = move-exception;
        Throwable r10 = th;
    L19:
        monitor-exit(r1);     // Catch: Throwable -> L13
        throw r10;
    L17:
        th = move-exception;
        r10 = th;
        goto L19
    L5:
        if (this.mState == 2) goto L7;
        boolean r0 = true;
    L8:
        Preconditions.checkState(r0);     // Catch: Throwable -> L17
        if (getLastLocationUnsafe(userId, 2, false, Long.MAX_VALUE) != null) goto L15;
        setLastLocation(location, userId);     // Catch: Throwable -> L13
    L15:
        monitor-exit(r1);     // Catch: Throwable -> L13
        return;
    L7:
        r0 = false;
        goto L8
    }

    private void setLastLocation(Location location, int userId) {
        if (userId != (-1)) goto L11;
        int[] runningUserIds = this.mUserHelper.getRunningUserIds();
        int i = 0;
    L6:
        if (i >= runningUserIds.length) goto L9;
        setLastLocation(location, runningUserIds[i]);
        i = i + 1;
        goto L6
    L9:
        return;
    L11:
        if (userId != (-2)) goto L14;
        setLastLocation(location, this.mUserHelper.getCurrentUserId());
        return;
    L14:
        if (userId < 0) goto L16;
        boolean r0 = true;
    L17:
        Preconditions.checkArgument(r0);
        Object r1 = this.mMultiplexerLock;
        monitor-enter(r1);
        LastLocation lastLocation = this.mLastLocations.get(userId);     // Catch: Throwable -> L22
        if (lastLocation != null) goto L25;
        lastLocation = new LastLocation();     // Catch: Throwable -> L22
        this.mLastLocations.put(userId, lastLocation);     // Catch: Throwable -> L22
    L25:
        if (isEnabled(userId) == false) goto L27;
        lastLocation.set(location);     // Catch: Throwable -> L22
    L27:
        lastLocation.setBypass(location);     // Catch: Throwable -> L22
        monitor-exit(r1);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    L16:
        r0 = false;
        goto L17
    }

    public ICancellationSignal getCurrentLocation(LocationRequest request, CallerIdentity identity, int permissionLevel, final ILocationCallback callback) {
        if (request.getDurationMillis() <= 30000) goto L5;
        LocationRequest request2 = new LocationRequest.Builder(request).setDurationMillis(30000).build();
    L6:
        final GetCurrentLocationListenerRegistration registration = new GetCurrentLocationListenerRegistration(this, request2, identity, new GetCurrentLocationTransport(callback), permissionLevel);
        Object r10 = this.mMultiplexerLock;
        monitor-enter(r10);
    L23:
        th = move-exception;
        throw th;
    L9:
        if (this.mState == 2) goto L11;
        boolean r11 = true;
    L12:
        Preconditions.checkState(r11);     // Catch: Throwable -> L23
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L23
        putRegistration(callback.asBinder(), registration);     // Catch: Throwable -> L17
        if (registration.isActive() == true) goto L19;
        registration.deliverNull();     // Catch: Throwable -> L17
    L19:
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L23
        monitor-exit(r10);     // Catch: Throwable -> L23
        ICancellationSignal cancelTransport = CancellationSignal.createTransport();
        CancellationSignal.fromTransport(cancelTransport).setOnCancelListener(new LocationProviderManager$$ExternalSyntheticLambda24(this, callback, registration));
        return cancelTransport;
    L17:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L23
        throw th;     // Catch: Throwable -> L23
    L11:
        r11 = false;
        goto L12
    L5:
        request2 = request;
        goto L6
    }

    private /* synthetic */ void lambda$getCurrentLocation$2(ILocationCallback callback, GetCurrentLocationListenerRegistration registration) {
        long ident = Binder.clearCallingIdentity();
        removeRegistration(callback.asBinder(), registration);     // Catch: Throwable -> L6 RuntimeException -> L8
        Binder.restoreCallingIdentity(ident);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);
        throw th;
    L8:
        e = move-exception;
        FgThread.getExecutor().execute(new LocationProviderManager$$ExternalSyntheticLambda0(e));     // Catch: Throwable -> L6
        throw e;     // Catch: Throwable -> L6
    }

    private static /* synthetic */ void lambda$getCurrentLocation$1(RuntimeException e) {
        throw new AssertionError(e);
    }

    public void sendExtraCommand(int uid, int pid, String command, Bundle extras) {
        long identity = Binder.clearCallingIdentity();
        this.mProvider.getController().sendExtraCommand(uid, pid, command, extras);     // Catch: Throwable -> L6
        Binder.restoreCallingIdentity(identity);
        return;
    L6:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    public void registerLocationRequest(LocationRequest request, CallerIdentity identity, int permissionLevel, ILocationListener listener) {
        LocationListenerRegistration registration = new LocationListenerRegistration(this, request, identity, new LocationListenerTransport(listener), permissionLevel);
        Object r10 = this.mMultiplexerLock;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mState == 2) goto L7;
        boolean r11 = true;
    L8:
        Preconditions.checkState(r11);     // Catch: Throwable -> L13
        long ident = Binder.clearCallingIdentity();     // Catch: Throwable -> L13
        putRegistration(listener.asBinder(), registration);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(ident);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L7:
        r11 = false;
        goto L8
    }

    public void registerLocationRequest(LocationRequest request, CallerIdentity callerIdentity, int permissionLevel, PendingIntent pendingIntent) {
        LocationPendingIntentRegistration registration = new LocationPendingIntentRegistration(this, request, callerIdentity, new LocationPendingIntentTransport(this.mContext, pendingIntent), permissionLevel);
        Object r10 = this.mMultiplexerLock;
        monitor-enter(r10);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mState == 2) goto L7;
        boolean r11 = true;
    L8:
        Preconditions.checkState(r11);     // Catch: Throwable -> L13
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L13
        putRegistration(pendingIntent, registration);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L13
        monitor-exit(r10);     // Catch: Throwable -> L13
        return;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L7:
        r11 = false;
        goto L8
    }

    public void flush(ILocationListener listener, final int requestCode) {
        long identity = Binder.clearCallingIdentity();
        boolean flushed = updateRegistration(listener.asBinder(), new LocationProviderManager$$ExternalSyntheticLambda35(requestCode));     // Catch: Throwable -> L9
        if (flushed == false) goto L8;
        Binder.restoreCallingIdentity(identity);
        return;
    L8:
        throw new IllegalArgumentException("unregistered listener cannot be flushed");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private static /* synthetic */ boolean lambda$flush$3(int requestCode, Registration registration) {
        registration.flush(requestCode);
        return false;
    }

    public void flush(PendingIntent pendingIntent, final int requestCode) {
        long identity = Binder.clearCallingIdentity();
        boolean flushed = updateRegistration(pendingIntent, new LocationProviderManager$$ExternalSyntheticLambda34(requestCode));     // Catch: Throwable -> L9
        if (flushed == false) goto L8;
        Binder.restoreCallingIdentity(identity);
        return;
    L8:
        throw new IllegalArgumentException("unregistered pending intent cannot be flushed");     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);
        throw th;
    }

    private static /* synthetic */ boolean lambda$flush$4(int requestCode, Registration registration) {
        registration.flush(requestCode);
        return false;
    }

    public void unregisterLocationRequest(ILocationListener listener) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mState == 2) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1);     // Catch: Throwable -> L13
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L13
        removeRegistration(listener.asBinder());     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L7:
        r1 = false;
        goto L8
    }

    public void unregisterLocationRequest(PendingIntent pendingIntent) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (this.mState == 2) goto L7;
        boolean r1 = true;
    L8:
        Preconditions.checkState(r1);     // Catch: Throwable -> L13
        long identity = Binder.clearCallingIdentity();     // Catch: Throwable -> L13
        removeRegistration(pendingIntent);     // Catch: Throwable -> L15
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L15:
        th = move-exception;
        Binder.restoreCallingIdentity(identity);     // Catch: Throwable -> L13
        throw th;     // Catch: Throwable -> L13
    L7:
        r1 = false;
        goto L8
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected void onRegister() {
        this.mSettingsHelper.addOnBackgroundThrottleIntervalChangedListener(this.mBackgroundThrottleIntervalChangedListener);
        this.mSettingsHelper.addOnBackgroundThrottlePackageWhitelistChangedListener(this.mBackgroundThrottlePackageWhitelistChangedListener);
        this.mSettingsHelper.addOnLocationPackageBlacklistChangedListener(this.mLocationPackageBlacklistChangedListener);
        this.mSettingsHelper.addAdasAllowlistChangedListener(this.mAdasPackageAllowlistChangedListener);
        this.mSettingsHelper.addIgnoreSettingsAllowlistChangedListener(this.mIgnoreSettingsPackageWhitelistChangedListener);
        this.mLocationPermissionsHelper.addListener(this.mLocationPermissionsListener);
        this.mAppForegroundHelper.addListener(this.mAppForegroundChangedListener);
        this.mLocationPowerSaveModeHelper.addListener(this.mLocationPowerSaveModeChangedListener);
        this.mScreenInteractiveHelper.addListener(this.mScreenInteractiveChangedListener);
        this.mEmergencyHelper.addOnEmergencyStateChangedListener(this.mEmergencyStateChangedListener);
        this.mPackageResetHelper.register(this.mPackageResetResponder);
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected void onUnregister() {
        this.mSettingsHelper.removeOnBackgroundThrottleIntervalChangedListener(this.mBackgroundThrottleIntervalChangedListener);
        this.mSettingsHelper.removeOnBackgroundThrottlePackageWhitelistChangedListener(this.mBackgroundThrottlePackageWhitelistChangedListener);
        this.mSettingsHelper.removeOnLocationPackageBlacklistChangedListener(this.mLocationPackageBlacklistChangedListener);
        this.mSettingsHelper.removeAdasAllowlistChangedListener(this.mAdasPackageAllowlistChangedListener);
        this.mSettingsHelper.removeIgnoreSettingsAllowlistChangedListener(this.mIgnoreSettingsPackageWhitelistChangedListener);
        this.mLocationPermissionsHelper.removeListener(this.mLocationPermissionsListener);
        this.mAppForegroundHelper.removeListener(this.mAppForegroundChangedListener);
        this.mLocationPowerSaveModeHelper.removeListener(this.mLocationPowerSaveModeChangedListener);
        this.mScreenInteractiveHelper.removeListener(this.mScreenInteractiveChangedListener);
        this.mEmergencyHelper.removeOnEmergencyStateChangedListener(this.mEmergencyStateChangedListener);
        this.mPackageResetHelper.unregister(this.mPackageResetResponder);
    }

    protected void onRegistrationAdded(Object key, Registration registration) {
        this.mLocationUsageLogger.logLocationApiUsage(0, 1, registration.getIdentity().getPackageName(), registration.getIdentity().getAttributionTag(), this.mName, registration.getRequest(), key instanceof PendingIntent, key instanceof IBinder, null, registration.isForeground());
    }

    protected void onRegistrationReplaced(Object oldKey, Registration oldRegistration, Object newKey, Registration newRegistration) {
        newRegistration.setLastDeliveredLocation(oldRegistration.getLastDeliveredLocation());
        super.onRegistrationReplaced(oldKey, oldRegistration, newKey, newRegistration);
    }

    protected void onRegistrationRemoved(Object key, Registration registration) {
        this.mLocationUsageLogger.logLocationApiUsage(1, 1, registration.getIdentity().getPackageName(), registration.getIdentity().getAttributionTag(), this.mName, registration.getRequest(), key instanceof PendingIntent, key instanceof IBinder, null, registration.isForeground());
    }

    /* JADX INFO: renamed from: registerWithService, reason: avoid collision after fix types in other method */
    protected boolean registerWithService2(ProviderRequest request, Collection<Registration> registrations) {
        if (request.isActive() == true) goto L7;
        return true;
    L7:
        return reregisterWithService2(ProviderRequest.EMPTY_REQUEST, request, registrations);
    }

    /* JADX INFO: renamed from: reregisterWithService, reason: avoid collision after fix types in other method */
    protected boolean reregisterWithService2(ProviderRequest oldRequest, final ProviderRequest newRequest, Collection<Registration> registrations) {
        if (oldRequest.isBypass() == false) goto L5;
    L7:
        long delayMs = newRequest.getIntervalMillis();
        if (delayMs <= oldRequest.getIntervalMillis()) goto L10;
        long delayMs2 = 0;
    L12:
        if (delayMs2 >= 0) goto L14;
    L16:
        boolean r2 = false;
    L17:
        Preconditions.checkState(r2);
        if (delayMs2 >= 30000) goto L21;
        setProviderRequest(newRequest);
    L27:
        return true;
    L21:
        if (LocationManagerService.D == false) goto L24;
        Log.d(LocationManagerService.TAG, this.mName + " provider delaying request update " + newRequest + " by " + TimeUtils.formatDuration(delayMs2));
    L24:
        if (this.mDelayedRegister == null) goto L26;
        this.mAlarmHelper.cancel(this.mDelayedRegister);
        this.mDelayedRegister = null;
    L26:
        this.mDelayedRegister = new AnonymousClass3(this, newRequest);
        this.mAlarmHelper.setDelayedAlarm(delayMs2, this.mDelayedRegister, null);
        goto L27
    L14:
        if (delayMs2 > newRequest.getIntervalMillis()) goto L16;
        r2 = true;
        goto L17
    L10:
        long delayMs3 = newRequest.getIntervalMillis();
        delayMs2 = calculateRequestDelayMillis(delayMs3, registrations);
        goto L12
    L5:
        if (newRequest.isBypass() == false) goto L7;
        delayMs2 = 0;
        goto L12
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected void unregisterWithService() {
        setProviderRequest(ProviderRequest.EMPTY_REQUEST);
    }

    void setProviderRequest(final ProviderRequest request) {
        if (this.mDelayedRegister == null) goto L5;
        this.mAlarmHelper.cancel(this.mDelayedRegister);
        this.mDelayedRegister = null;
    L5:
        LocationEventLog.EVENT_LOG.logProviderUpdateRequest(this.mName, request);
        if (LocationManagerService.D == false) goto L8;
        Log.d(LocationManagerService.TAG, this.mName + " provider request changed to " + request);
    L8:
        this.mProvider.getController().setRequest(request);
        FgThread.getHandler().post(new LocationProviderManager$$ExternalSyntheticLambda23(this, request));
    }

    private /* synthetic */ void lambda$setProviderRequest$5(ProviderRequest request) {
        Iterator<IProviderRequestListener> r0 = this.mProviderRequestListeners.iterator();
    L4:
        if (r0.hasNext() == false) goto L11;
        IProviderRequestListener listener = r0.next();
        listener.onProviderRequestChanged(this.mName, request);     // Catch: RemoteException -> L8
    L9:
        this.mProviderRequestListeners.remove(listener);
        goto L4
    }

    protected boolean isActive(Registration registration) {
        if (registration.isPermitted() == true) goto L5;
        return false;
    L5:
        boolean isBypass = registration.getRequest().isBypass();
        if (isActive(isBypass, registration.getIdentity()) == true) goto L8;
        return false;
    L8:
        if (isBypass == false) goto L10;
        return true;
    L10:
        switch(this.mLocationPowerSaveModeHelper.getLocationPowerSaveMode()) {
            case 1: goto L16;
            case 2: goto L19;
            case 3: goto L13;
            case 4: goto L19;
            default: goto L21;
        };
    L21:
        boolean isFrozen = SysOptBridge.getFactory().getLocationProvider().checkUidFreeze(registration.getIdentity().getUid());
        if (isFrozen == false) goto L27;
        Log.i(LocationManagerService.TAG, "uid: " + registration.getIdentity().getUid() + " is frozen, isActive: false");
        return false;
    L27:
        return true;
    L13:
        if (registration.isForeground() == true) goto L21;
        return false;
    L16:
        if ("gps".equals(this.mName) == false) goto L21;
    L19:
        if (this.mScreenInteractiveHelper.isInteractive() == true) goto L21;
        return false;
    }

    private boolean isActive(boolean isBypass, CallerIdentity identity) {
        if (identity.isSystemServer() == false) goto L8;
        if (isBypass == false) goto L6;
        return true;
    L6:
        if (isEnabled(this.mUserHelper.getCurrentUserId()) == true) goto L20;
        return false;
    L20:
        return true;
    L8:
        if (isBypass == true) goto L16;
        if (isEnabled(identity.getUserId()) == true) goto L13;
        return false;
    L13:
        if (this.mUserHelper.isVisibleUserId(identity.getUserId()) == true) goto L16;
        return false;
    L16:
        if (this.mSettingsHelper.isLocationPackageBlacklisted(identity.getUserId(), identity.getPackageName()) == false) goto L21;
        return false;
    L21:
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected ProviderRequest mergeRegistrations(Collection<Registration> registrations) {
        Iterator<Registration> r8 = registrations.iterator();
        boolean lowPower = true;
        boolean lowPower2 = false;
        boolean locationSettingsIgnored = false;
        long maxUpdateDelayMs = Long.MAX_VALUE;
        int quality = 104;
        long intervalMs = Long.MAX_VALUE;
    L4:
        if (r8.hasNext() == false) goto L13;
        Registration registration = r8.next();
        LocationRequest request = registration.getRequest();
        if (request.getIntervalMillis() == Long.MAX_VALUE) goto L4;
        if (SysOptBridge.getFactory().getLocationProvider().checkUidFreeze(registration.getIdentity().getUid()) == true) goto L4;
        intervalMs = Math.min(request.getIntervalMillis(), intervalMs);
        quality = Math.min(request.getQuality(), quality);
        maxUpdateDelayMs = Math.min(request.getMaxUpdateDelayMillis(), maxUpdateDelayMs);
        locationSettingsIgnored = locationSettingsIgnored | request.isAdasGnssBypass();
        lowPower2 = lowPower2 | request.isLocationSettingsIgnored();
        lowPower = lowPower & request.isLowPower();
        goto L4
    L13:
        if (intervalMs != Long.MAX_VALUE) goto L17;
        return ProviderRequest.EMPTY_REQUEST;
    L17:
        if ((maxUpdateDelayMs / 2) >= intervalMs) goto L33;
        maxUpdateDelayMs = 0;
    L33:
        long thresholdIntervalMs = Math.multiplyExact(Math.addExact(intervalMs, 1000) / 2, 3);     // Catch: ArithmeticException -> L22
    L24:
        WorkSource workSource = new WorkSource();
        Iterator<Registration> r9 = registrations.iterator();
    L26:
        if (r9.hasNext() == false) goto L32;
        Registration registration2 = r9.next();
        if (registration2.getRequest().getIntervalMillis() > thresholdIntervalMs) goto L26;
        workSource.add(registration2.getRequest().getWorkSource());
        goto L26
    L32:
        return new ProviderRequest.Builder().setIntervalMillis(intervalMs).setQuality(quality).setMaxUpdateDelayMillis(maxUpdateDelayMs).setAdasGnssBypass(locationSettingsIgnored).setLocationSettingsIgnored(lowPower2).setLowPower(lowPower).setWorkSource(workSource).build();
    L23:
        thresholdIntervalMs = 9223372036854775806L;
        goto L24
    }

    protected long calculateRequestDelayMillis(long newIntervalMs, Collection<Registration> registrations) {
        long delayMs = newIntervalMs;
        Iterator<Registration> r2 = registrations.iterator();
    L4:
        if (r2.hasNext() == false) goto L17;
        Registration registration = r2.next();
        if (delayMs == 0) goto L17;
        LocationRequest locationRequest = registration.getRequest();
        Location last = registration.getLastDeliveredLocation();
        if (last == null) goto L11;
    L13:
        if (last != null) goto L15;
        long registrationDelayMs = 0;
    L16:
        delayMs = Math.min(delayMs, registrationDelayMs);
        goto L4
    L15:
        registrationDelayMs = Math.max(0, locationRequest.getIntervalMillis() - last.getElapsedRealtimeAgeMillis());
        goto L16
    L11:
        if (locationRequest.isLocationSettingsIgnored() == true) goto L13;
        last = getLastLocationUnsafe(registration.getIdentity().getUserId(), registration.getPermissionLevel(), false, locationRequest.getIntervalMillis());
    L17:
        return delayMs;
    }

    private void onUserChanged(final int userId, int change) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != 2) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        switch(change) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L14;
            default: goto L15;
        };     // Catch: Throwable -> L8
    L12:
        onUserStopped(userId);     // Catch: Throwable -> L8
        goto L15
    L13:
        onUserStarted(userId);     // Catch: Throwable -> L8
        goto L15
    L14:
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda17(userId));     // Catch: Throwable -> L8
    L15:
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private static /* synthetic */ boolean lambda$onUserChanged$6(int userId, Registration registration) {
        if (registration.getIdentity().getUserId() != userId) goto L5;
        return true;
    L5:
        return false;
    }

    private void onLocationUserSettingsChanged(final int userId, LocationUserSettings oldSettings, LocationUserSettings newSettings) {
        if (oldSettings.isAdasGnssLocationEnabled() == newSettings.isAdasGnssLocationEnabled()) goto L6;
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda32(userId));
        return;
    }

    private static /* synthetic */ boolean lambda$onLocationUserSettingsChanged$7(int userId, Registration registration) {
        return registration.onAdasGnssLocationEnabledChanged(userId);
    }

    private void onLocationEnabledChanged(int userId) {
        Object r0 = this.mMultiplexerLock;
        monitor-enter(r0);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (this.mState != 2) goto L10;
        monitor-exit(r0);     // Catch: Throwable -> L8
        return;
    L10:
        onEnabledChanged(userId);     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
    }

    private void onScreenInteractiveChanged(boolean screenInteractive) {
        switch(this.mLocationPowerSaveModeHelper.getLocationPowerSaveMode()) {
            case 1: goto L6;
            case 2: goto L8;
            case 3: goto L10;
            case 4: goto L8;
            default: goto L10;
        };
    L8:
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda37());
        return;
    L10:
        return;
    L6:
        if ("gps".equals(this.mName) == true) goto L8;
    }

    private static /* synthetic */ boolean lambda$onScreenInteractiveChanged$8(Registration registration) {
        return true;
    }

    private void onEmergencyStateChanged() {
        final boolean inEmergency = this.mEmergencyHelper.isInEmergency(0);
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda39(inEmergency));
    }

    private static /* synthetic */ boolean lambda$onEmergencyStateChanged$9(boolean inEmergency, Registration registration) {
        return registration.onBypassLocationPermissionsChanged(inEmergency);
    }

    private void onBackgroundThrottlePackageWhitelistChanged() {
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda25());
    }

    private void onBackgroundThrottleIntervalChanged() {
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda25());
    }

    private static /* synthetic */ boolean lambda$onLocationPowerSaveModeChanged$10(Registration registration) {
        return true;
    }

    private void onLocationPowerSaveModeChanged(int locationPowerSaveMode) {
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda20());
        LocationLogsRecorder.getInstance().writeLocationLogsAsync(LocationLogsRecorder.KEY_FILE_LOCATION, "Location Power Save mode changed to " + PowerManager.locationPowerSaveModeToString(locationPowerSaveMode));
    }

    private static /* synthetic */ boolean lambda$onAppForegroundChanged$11(int uid, boolean foreground, Registration registration) {
        return registration.onForegroundChanged(uid, foreground);
    }

    private void onAppForegroundChanged(final int uid, final boolean foreground) {
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda27(uid, foreground));
    }

    private static /* synthetic */ boolean lambda$onAppForegroundChanged$12(int uid, boolean foreground, Registration registration) {
        return registration.onForegroundChanged(uid, foreground);
    }

    public void onAppForegroundChanged(final int uid, final boolean foreground, boolean freezeChanged) {
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda36(uid, foreground));
    }

    private static /* synthetic */ boolean lambda$onAppUidFrozenChanged$13(int uid, Registration registration) {
        if (registration.getIdentity().getUid() != uid) goto L5;
        return true;
    L5:
        return false;
    }

    public void onAppUidFrozenChanged(final int uid) {
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda31(uid));
    }

    private void onAdasAllowlistChanged() {
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda25());
    }

    private void onIgnoreSettingsWhitelistChanged() {
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda25());
    }

    private static /* synthetic */ boolean lambda$onLocationPackageBlacklistChanged$14(int userId, Registration registration) {
        if (registration.getIdentity().getUserId() != userId) goto L5;
        return true;
    L5:
        return false;
    }

    private void onLocationPackageBlacklistChanged(final int userId) {
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda38(userId));
    }

    private void onLocationPermissionsChanged(final String packageName) {
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda26(packageName));
    }

    private static /* synthetic */ boolean lambda$onLocationPermissionsChanged$15(String packageName, Registration registration) {
        return registration.onLocationPermissionsChanged(packageName);
    }

    private static /* synthetic */ boolean lambda$onLocationPermissionsChanged$16(int uid, Registration registration) {
        return registration.onLocationPermissionsChanged(uid);
    }

    private void onLocationPermissionsChanged(final int uid) {
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda18(uid));
    }

    private void onPackageReset(final String packageName) {
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda33(packageName));
    }

    private static /* synthetic */ boolean lambda$onPackageReset$17(String packageName, Registration registration) {
        if (registration.getIdentity().getPackageName().equals(packageName) == true) goto L5;
        return false;
    L5:
        if (LocationManagerService.D == false) goto L7;
        Log.d(LocationManagerService.TAG, "package reset remove registration " + registration);
    L7:
        registration.remove();
        return false;
    }

    private boolean isResetableForPackage(final String packageName) {
        return findRegistration(new LocationProviderManager$$ExternalSyntheticLambda1(packageName));
    }

    private static /* synthetic */ boolean lambda$isResetableForPackage$18(String packageName, Registration registration) {
        return registration.getIdentity().getPackageName().equals(packageName);
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider.Listener
    public void onStateChanged(final AbstractLocationProvider.State oldState, final AbstractLocationProvider.State newState) {
        if (oldState.allowed == newState.allowed) goto L6;
        onEnabledChanged(-1);
    L6:
        if (Objects.equals(oldState.properties, newState.properties) == true) goto L9;
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda2());
    L9:
        if (this.mStateChangedListener == null) goto L12;
        final StateChangedListener listener = this.mStateChangedListener;
        FgThread.getExecutor().execute(new LocationProviderManager$$ExternalSyntheticLambda3(this, listener, oldState, newState));
        return;
    }

    private /* synthetic */ void lambda$onStateChanged$19(StateChangedListener listener, AbstractLocationProvider.State oldState, AbstractLocationProvider.State newState) {
        listener.onStateChanged(this.mName, oldState, newState);
    }

    @Override // com.android.server.location.provider.AbstractLocationProvider.Listener
    public void onReportLocation(LocationResult locationResult) {
        if ("network".equals(this.mName) == false) goto L8;
        locationResult = locationResult.filter(new LocationProviderManager$$ExternalSyntheticLambda21());
        if (locationResult != null) goto L8;
        return;
    L8:
        if (this.mPassiveManager == null) goto L13;
        final LocationResult processed = processReportedLocation(locationResult);
        if (processed != null) goto L12;
        return;
    L12:
        LocationEventLog.EVENT_LOG.logProviderReceivedLocations(this.mName, processed.size());
    L15:
        if (this.mPassiveManager == null) goto L21;
        LocationProviderManager r2 = this;
        Location last = r2.getLastLocationUnsafe(-2, 2, true, Long.MAX_VALUE);
        if (last != null) goto L19;
    L22:
        setLastLocation(processed.getLastLocation(), -1);
        deliverToListeners(new LocationProviderManager$$ExternalSyntheticLambda22(processed));
        if (r2.mPassiveManager == null) goto L26;
        r2.mPassiveManager.updateLocation(processed);
        return;
    L26:
        return;
    L19:
        if (locationResult.get(0).getElapsedRealtimeNanos() >= last.getElapsedRealtimeNanos()) goto L22;
        Log.e(LocationManagerService.TAG, "non-monotonic location received from " + r2.mName + " provider");
        goto L22
    L21:
        r2 = this;
        goto L22
    L13:
        processed = locationResult;
        goto L15
    }

    private static /* synthetic */ boolean lambda$onReportLocation$20(Location location) {
        return !StarLocation.getInstance().updateLastCoarseNlpLocation(location);
    }

    private static /* synthetic */ ListenerExecutor.ListenerOperation lambda$onReportLocation$21(LocationResult processed, Registration registration) {
        return registration.acceptLocationChange(processed);
    }

    private LocationResult processReportedLocation(LocationResult locationResult) {
        locationResult.validate();     // Catch: LocationResult.BadLocationException -> L8
        if (DeviceConfig.getBoolean(LocationLogsRecorder.KEY_FILE_LOCATION, "enable_location_provider_manager_msl", true) == true) goto L6;
        return locationResult;
    L6:
        return locationResult.map(new LocationProviderManager$$ExternalSyntheticLambda30(this));
    L8:
        e = move-exception;
        Log.e(LocationManagerService.TAG, "Dropping invalid locations: " + e);
        return null;
    }

    private /* synthetic */ Location lambda$processReportedLocation$23(Location location) {
        if (location.hasMslAltitude() == false) goto L5;
    L17:
        return location;
    L5:
        if (location.hasAltitude() == false) goto L17;
        final Location locationCopy = new Location(location);     // Catch: IllegalArgumentException -> L13
        if (this.mAltitudeConverter.tryAddMslAltitudeToLocation(locationCopy) == false) goto L10;
        return locationCopy;
    L10:
        if (this.mIsAltitudeConverterIdle == false) goto L17;
        this.mIsAltitudeConverterIdle = false;     // Catch: IllegalArgumentException -> L13
        IoThread.getExecutor().execute(new LocationProviderManager$$ExternalSyntheticLambda4(this, locationCopy));     // Catch: IllegalArgumentException -> L13
    L13:
        e = move-exception;
        Log.e(LocationManagerService.TAG, "not adding MSL altitude to location: " + e);
        goto L17
    }

    private /* synthetic */ void lambda$processReportedLocation$22(Location locationCopy) {
        this.mAltitudeConverter.addMslAltitudeToLocation(this.mContext, locationCopy);     // Catch: IOException -> L4
    L6:
        this.mIsAltitudeConverterIdle = true;
        return;
    L4:
        e = move-exception;
        Log.e(LocationManagerService.TAG, "not loading MSL altitude assets: " + e);
        goto L6
    }

    private void onUserStarted(int userId) {
        if (userId != (-10000)) goto L6;
        return;
    L6:
        if (userId != (-1)) goto L8;
        this.mEnabled.clear();
        onEnabledChanged(-1);
        return;
    L8:
        if (userId < 0) goto L10;
        boolean r0 = true;
    L11:
        Preconditions.checkArgument(r0);
        this.mEnabled.delete(userId);
        onEnabledChanged(userId);
        return;
    L10:
        r0 = false;
        goto L11
    }

    private void onUserStopped(int userId) {
        if (userId != (-10000)) goto L6;
        return;
    L6:
        if (userId != (-1)) goto L8;
        this.mEnabled.clear();
        this.mLastLocations.clear();
        return;
    L8:
        if (userId < 0) goto L10;
        boolean r0 = true;
    L11:
        Preconditions.checkArgument(r0);
        this.mEnabled.delete(userId);
        this.mLastLocations.remove(userId);
        return;
    L10:
        r0 = false;
        goto L11
    }

    private void onEnabledChanged(final int userId) {
        if (userId != (-10000)) goto L6;
        return;
    L6:
        if (userId != (-1)) goto L13;
        int[] runningUserIds = this.mUserHelper.getRunningUserIds();
        int i = 0;
    L9:
        if (i >= runningUserIds.length) goto L12;
        onEnabledChanged(runningUserIds[i]);
        i = i + 1;
        goto L9
    L12:
        return;
    L13:
        final boolean enabled = true;
        if (userId < 0) goto L16;
        boolean r2 = true;
    L17:
        Preconditions.checkArgument(r2);
        if (this.mState == 0) goto L20;
    L24:
        enabled = false;
    L25:
        int index = this.mEnabled.indexOfKey(userId);
        if (index >= 0) goto L28;
        Boolean wasEnabled = null;
    L29:
        if (wasEnabled != null) goto L31;
    L33:
        this.mEnabled.put(userId, enabled);
        if (wasEnabled != null) goto L37;
        if (enabled == true) goto L37;
    L40:
        if (enabled == true) goto L44;
        LastLocation lastLocation = this.mLastLocations.get(userId);
        if (lastLocation == null) goto L44;
        lastLocation.clearLocations();
    L44:
        if (wasEnabled != null) goto L46;
    L51:
        updateRegistrations(new LocationProviderManager$$ExternalSyntheticLambda29(userId));
        return;
    L46:
        if ("passive".equals(this.mName) == true) goto L49;
        Intent intent = new Intent("android.location.PROVIDERS_CHANGED").putExtra("android.location.extra.PROVIDER_NAME", this.mName).putExtra("android.location.extra.PROVIDER_ENABLED", enabled).addFlags(1073741824).addFlags(268435456);
        this.mContext.sendBroadcastAsUser(intent, UserHandle.of(userId));
    L49:
        if (this.mEnabledListeners.isEmpty() == true) goto L51;
        final LocationManagerInternal.ProviderEnabledListener[] listeners = (LocationManagerInternal.ProviderEnabledListener[]) this.mEnabledListeners.toArray(new LocationManagerInternal.ProviderEnabledListener[0]);
        FgThread.getHandler().post(new LocationProviderManager$$ExternalSyntheticLambda28(this, listeners, userId, enabled));
    L37:
        if (LocationManagerService.D == false) goto L39;
        Log.d(LocationManagerService.TAG, "[u" + userId + "] " + this.mName + " provider enabled = " + enabled);
    L39:
        LocationEventLog.EVENT_LOG.logProviderEnabled(this.mName, userId, enabled);
        goto L40
    L31:
        if (wasEnabled.booleanValue() != enabled) goto L33;
        return;
    L28:
        wasEnabled = Boolean.valueOf(this.mEnabled.valueAt(index));
        goto L29
    L20:
        if (this.mProvider.getState().allowed == false) goto L24;
        if (this.mSettingsHelper.isLocationEnabled(userId) == false) goto L24;
    L16:
        r2 = false;
        goto L17
    }

    private /* synthetic */ void lambda$onEnabledChanged$24(LocationManagerInternal.ProviderEnabledListener[] listeners, int userId, boolean enabled) {
        int i = 0;
    L4:
        if (i >= listeners.length) goto L7;
        listeners[i].onProviderEnabledChanged(this.mName, userId, enabled);
        i = i + 1;
        goto L4
    }

    private static /* synthetic */ boolean lambda$onEnabledChanged$25(int userId, Registration registration) {
        if (registration.getIdentity().getUserId() != userId) goto L5;
        return true;
    L5:
        return false;
    }

    Location getPermittedLocation(Location fineLocation, int permissionLevel) {
        switch(permissionLevel) {
            case 1: goto L6;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return fineLocation;
    L6:
        if (fineLocation != null) goto L10;
        return null;
    L10:
        return this.mLocationFudger.createCoarse(fineLocation);
    L4:
        throw new AssertionError();
    }

    LocationResult getPermittedLocationResult(LocationResult fineLocationResult, int permissionLevel) {
        switch(permissionLevel) {
            case 1: goto L6;
            case 2: goto L5;
            default: goto L4;
        };
    L5:
        return fineLocationResult;
    L6:
        if (fineLocationResult != null) goto L10;
        return null;
    L10:
        return this.mLocationFudger.createCoarse(fineLocationResult);
    L4:
        throw new AssertionError();
    }

    public void dump(FileDescriptor fd, IndentingPrintWriter ipw, String[] args) {
        Object r1 = this.mMultiplexerLock;
        monitor-enter(r1);
        ipw.print(this.mName);     // Catch: Throwable -> L7
        ipw.print(" provider");     // Catch: Throwable -> L7
        if (this.mProvider.isMock() == false) goto L9;
        ipw.print(" [mock]");     // Catch: Throwable -> L7
    L9:
        ipw.println(":");     // Catch: Throwable -> L7
        ipw.increaseIndent();     // Catch: Throwable -> L7
        super.dump(fd, ipw, args);     // Catch: Throwable -> L7
        int[] userIds = this.mUserHelper.getRunningUserIds();     // Catch: Throwable -> L7
        int r2 = userIds.length;     // Catch: Throwable -> L7
        int r3 = 0;
    L10:
        if (r3 >= r2) goto L23;
        int userId = userIds[r3];     // Catch: Throwable -> L7
        if (userIds.length == 1) goto L14;
        ipw.print("user ");     // Catch: Throwable -> L7
        ipw.print(userId);     // Catch: Throwable -> L7
        ipw.println(":");     // Catch: Throwable -> L7
        ipw.increaseIndent();     // Catch: Throwable -> L7
    L14:
        ipw.print("last location=");     // Catch: Throwable -> L7
        ipw.println(getLastLocationUnsafe(userId, 2, false, Long.MAX_VALUE));     // Catch: Throwable -> L19
        ipw.print("enabled=");     // Catch: Throwable -> L19
        ipw.println(isEnabled(userId));     // Catch: Throwable -> L19
        if (userIds.length == 1) goto L21;
        ipw.decreaseIndent();     // Catch: Throwable -> L19
    L21:
        r3 = r3 + 1;     // Catch: Throwable -> L19
        goto L10
    L23:
        monitor-exit(r1);     // Catch: Throwable -> L19
        this.mProvider.dump(fd, ipw, args);
        ipw.decreaseIndent();
        return;
    L19:
        th = th;
    L26:
        monitor-exit(r1);     // Catch: Throwable -> L19
        throw th;
    L7:
        th = th;
        goto L26
    }

    @Override // com.android.server.location.listeners.ListenerMultiplexer
    protected String getServiceState() {
        return this.mProvider.getCurrentRequest().toString();
    }

    private boolean inWhiteList(String packageName) {
        String[] r0 = WHITELIST;
        int r1 = r0.length;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L9;
        String whiteName = r0[r3];
        if (whiteName.contains(packageName) == true) goto L6;
        r3 = r3 + 1;
        goto L3
    L6:
        return true;
    L9:
        return false;
    }

    static {
        WHITELIST = new String[]{"com.autonavi.minimap", "com.baidu.BaiduMap", "com.tencent.map", "com.google.android.apps.maps", "com.sogou.map.android.maps", "com.tigerknows", "com.autonavi.xmgd.navigator", "com.autonavi.cmccmap", "cld.navi.mainframe", "com.gotokeep.keep", "com.jingyao.easybike", "im.xingzhe"};
    }
}
