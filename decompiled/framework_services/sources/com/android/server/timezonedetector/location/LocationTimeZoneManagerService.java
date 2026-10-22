package com.android.server.timezonedetector.location;

import android.content.Context;
import android.os.Binder;
import android.os.Handler;
import android.os.ResultReceiver;
import android.os.ShellCallback;
import android.util.IndentingPrintWriter;
import android.util.Log;
import android.util.Slog;
import com.android.internal.util.DumpUtils;
import com.android.internal.util.Preconditions;
import com.android.server.FgThread;
import com.android.server.SystemService;
import com.android.server.timezonedetector.Dumpable;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import com.android.server.timezonedetector.ServiceConfigAccessorImpl;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class LocationTimeZoneManagerService extends Binder {
    private static final String ATTRIBUTION_TAG = "LocationTimeZoneService";
    private static final long BLOCKING_OP_WAIT_DURATION_MILLIS = 0;
    static final String TAG = "LocationTZDetector";
    private final Context mContext;
    private final Handler mHandler;
    private LocationTimeZoneProviderController mLocationTimeZoneProviderController;
    private LocationTimeZoneProviderControllerEnvironmentImpl mLocationTimeZoneProviderControllerEnvironment;
    private final ProviderConfig mPrimaryProviderConfig;
    private final ProviderConfig mSecondaryProviderConfig;
    private final ServiceConfigAccessor mServiceConfigAccessor;
    private final Object mSharedLock;
    private final ThreadingDomain mThreadingDomain;

    public static class Lifecycle extends SystemService {
        private LocationTimeZoneManagerService mService;
        private final ServiceConfigAccessor mServiceConfigAccessor;

        public Lifecycle(Context context) {
            context.getClass();
            super(context);
            this.mServiceConfigAccessor = ServiceConfigAccessorImpl.getInstance(context);
        }

        @Override // com.android.server.SystemService
        public void onStart() {
            Context context = getContext();
            if (this.mServiceConfigAccessor.isGeoTimeZoneDetectionFeatureSupportedInConfig() == false) goto L5;
            this.mService = new LocationTimeZoneManagerService(context, this.mServiceConfigAccessor);
            publishBinderService("location_time_zone_manager", this.mService);
            return;
        L5:
            Slog.d(LocationTimeZoneManagerService.TAG, "Geo time zone detection feature is disabled in config");
        }

        @Override // com.android.server.SystemService
        public void onBootPhase(int phase) {
            if (this.mServiceConfigAccessor.isGeoTimeZoneDetectionFeatureSupportedInConfig() == true) goto L5;
            return;
        L5:
            if (phase != 500) goto L8;
            this.mService.onSystemReady();
            return;
        L8:
            if (phase != 600) goto L13;
            this.mService.onSystemThirdPartyAppsCanStart();
            return;
        }
    }

    private final class ProviderConfig implements Dumpable {
        private final int mIndex;
        private final String mName;
        private final String mServiceAction;
        final /* synthetic */ LocationTimeZoneManagerService this$0;

        ProviderConfig(LocationTimeZoneManagerService r1, int index, String name, String serviceAction) {
            this.this$0 = r1;
            if (index < 0) goto L7;
            boolean r2 = true;
            if (index > 1) goto L7;
        L8:
            Preconditions.checkArgument(r2);
            this.mIndex = index;
            name.getClass();
            this.mName = name;
            serviceAction.getClass();
            this.mServiceAction = serviceAction;
            return;
        L7:
            r2 = false;
            goto L8
        }

        LocationTimeZoneProvider createProvider() {
            LocationTimeZoneProvider.ProviderMetricsLogger providerMetricsLogger = new RealProviderMetricsLogger(this.mIndex);
            String mode = getMode();
            if (Objects.equals(mode, ServiceConfigAccessor.PROVIDER_MODE_DISABLED) == true) goto L5;
            LocationTimeZoneProviderProxy proxy = createBinderProxy();
            return new BinderLocationTimeZoneProvider(providerMetricsLogger, LocationTimeZoneManagerService.m8608$$Nest$fgetmThreadingDomain(this.this$0), this.mName, proxy, LocationTimeZoneManagerService.m8607$$Nest$fgetmServiceConfigAccessor(this.this$0).getRecordStateChangesForTests());
        L5:
            return new DisabledLocationTimeZoneProvider(providerMetricsLogger, LocationTimeZoneManagerService.m8608$$Nest$fgetmThreadingDomain(this.this$0), this.mName, LocationTimeZoneManagerService.m8607$$Nest$fgetmServiceConfigAccessor(this.this$0).getRecordStateChangesForTests());
        }

        @Override // com.android.server.timezonedetector.Dumpable
        public void dump(IndentingPrintWriter ipw, String[] args) {
            ipw.printf("getMode()=%s\n", new Object[]{getMode()});
            ipw.printf("getPackageName()=%s\n", new Object[]{getPackageName()});
        }

        private String getMode() {
            if (this.mIndex != 0) goto L7;
            return LocationTimeZoneManagerService.m8607$$Nest$fgetmServiceConfigAccessor(this.this$0).getPrimaryLocationTimeZoneProviderMode();
        L7:
            return LocationTimeZoneManagerService.m8607$$Nest$fgetmServiceConfigAccessor(this.this$0).getSecondaryLocationTimeZoneProviderMode();
        }

        private RealLocationTimeZoneProviderProxy createBinderProxy() {
            String providerServiceAction = this.mServiceAction;
            boolean isTestProvider = isTestProvider();
            String providerPackageName = getPackageName();
            return new RealLocationTimeZoneProviderProxy(LocationTimeZoneManagerService.m8605$$Nest$fgetmContext(this.this$0), LocationTimeZoneManagerService.m8606$$Nest$fgetmHandler(this.this$0), LocationTimeZoneManagerService.m8608$$Nest$fgetmThreadingDomain(this.this$0), providerServiceAction, providerPackageName, isTestProvider);
        }

        private boolean isTestProvider() {
            if (this.mIndex != 0) goto L7;
            return LocationTimeZoneManagerService.m8607$$Nest$fgetmServiceConfigAccessor(this.this$0).isTestPrimaryLocationTimeZoneProvider();
        L7:
            return LocationTimeZoneManagerService.m8607$$Nest$fgetmServiceConfigAccessor(this.this$0).isTestSecondaryLocationTimeZoneProvider();
        }

        private String getPackageName() {
            if (this.mIndex != 0) goto L7;
            return LocationTimeZoneManagerService.m8607$$Nest$fgetmServiceConfigAccessor(this.this$0).getPrimaryLocationTimeZoneProviderPackageName();
        L7:
            return LocationTimeZoneManagerService.m8607$$Nest$fgetmServiceConfigAccessor(this.this$0).getSecondaryLocationTimeZoneProviderPackageName();
        }
    }

    public static /* synthetic */ void $r8$lambda$8118QYMiFAeYIlyZW5D0zmj4Aks(LocationTimeZoneManagerService r0) {
        r0.stopOnDomainThread();
    }

    /* JADX INFO: renamed from: $r8$lambda$ah8EMlZZEBRVGKsuu-47e1hCU2w, reason: not valid java name */
    public static /* synthetic */ void m8601$r8$lambda$ah8EMlZZEBRVGKsuu47e1hCU2w(LocationTimeZoneManagerService r0) {
        r0.lambda$clearRecordedProviderStates$1();
    }

    /* JADX INFO: renamed from: $r8$lambda$fMXlW-LDzjcvWEDpPPCwU1GOJc0, reason: not valid java name */
    public static /* synthetic */ void m8602$r8$lambda$fMXlWLDzjcvWEDpPPCwU1GOJc0(LocationTimeZoneManagerService r0) {
        r0.restartIfRequiredOnDomainThread();
    }

    /* JADX INFO: renamed from: $r8$lambda$id8PvZ4NKluHjFWGvLvt4r-Ve2M, reason: not valid java name */
    public static /* synthetic */ void m8603$r8$lambda$id8PvZ4NKluHjFWGvLvt4rVe2M(LocationTimeZoneManagerService r0) {
        r0.startOnDomainThread();
    }

    /* JADX INFO: renamed from: $r8$lambda$jjR2k3Q-QiLcfTP03xwwQtVqWzQ, reason: not valid java name */
    public static /* synthetic */ void m8604$r8$lambda$jjR2k3QQiLcfTP03xwwQtVqWzQ(LocationTimeZoneManagerService r0) {
        r0.handleServiceConfigurationChangedOnMainThread();
    }

    public static /* synthetic */ void $r8$lambda$xykaW0r5xdGqwOwSuMhdptUYPMA(LocationTimeZoneManagerService r0, String r1, String r2, boolean r3) {
        r0.lambda$startWithTestProviders$0(r1, r2, r3);
    }

    public static /* synthetic */ LocationTimeZoneManagerServiceState $r8$lambda$zr4gfHZR02Qoo19QWbH0IFlG1Yk(LocationTimeZoneManagerService r0) {
        return r0.lambda$getStateForTests$2();
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmContext, reason: not valid java name */
    static /* bridge */ /* synthetic */ Context m8605$$Nest$fgetmContext(LocationTimeZoneManagerService r0) {
        return r0.mContext;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m8606$$Nest$fgetmHandler(LocationTimeZoneManagerService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmServiceConfigAccessor, reason: not valid java name */
    static /* bridge */ /* synthetic */ ServiceConfigAccessor m8607$$Nest$fgetmServiceConfigAccessor(LocationTimeZoneManagerService r0) {
        return r0.mServiceConfigAccessor;
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmThreadingDomain, reason: not valid java name */
    static /* bridge */ /* synthetic */ ThreadingDomain m8608$$Nest$fgetmThreadingDomain(LocationTimeZoneManagerService r0) {
        return r0.mThreadingDomain;
    }

    static {
        BLOCKING_OP_WAIT_DURATION_MILLIS = Duration.ofSeconds(20).toMillis();
    }

    LocationTimeZoneManagerService(Context context, ServiceConfigAccessor serviceConfigAccessor) {
        this.mPrimaryProviderConfig = new ProviderConfig(this, 0, "primary", "android.service.timezone.PrimaryLocationTimeZoneProviderService");
        this.mSecondaryProviderConfig = new ProviderConfig(this, 1, "secondary", "android.service.timezone.SecondaryLocationTimeZoneProviderService");
        this.mContext = context.createAttributionContext(ATTRIBUTION_TAG);
        this.mHandler = FgThread.getHandler();
        this.mThreadingDomain = new HandlerThreadingDomain(this.mHandler);
        this.mSharedLock = this.mThreadingDomain.getLockObject();
        serviceConfigAccessor.getClass();
        this.mServiceConfigAccessor = serviceConfigAccessor;
    }

    void onSystemReady() {
        this.mServiceConfigAccessor.addLocationTimeZoneManagerConfigListener(new LocationTimeZoneManagerService$$ExternalSyntheticLambda4(this));
    }

    private void handleServiceConfigurationChangedOnMainThread() {
        this.mThreadingDomain.post(new LocationTimeZoneManagerService$$ExternalSyntheticLambda3(this));
    }

    private void restartIfRequiredOnDomainThread() {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mLocationTimeZoneProviderController == null) goto L9;
        stopOnDomainThread();     // Catch: Throwable -> L7
        startOnDomainThread();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    void onSystemThirdPartyAppsCanStart() {
        startInternal(false);
    }

    void start() {
        enforceManageTimeZoneDetectorPermission();
        startInternal(true);
    }

    private void startInternal(boolean waitForCompletion) {
        Runnable runnable = new LocationTimeZoneManagerService$$ExternalSyntheticLambda2(this);
        if (waitForCompletion == false) goto L5;
        this.mThreadingDomain.postAndWait(runnable, BLOCKING_OP_WAIT_DURATION_MILLIS);
        return;
    L5:
        this.mThreadingDomain.post(runnable);
    }

    void startWithTestProviders(final String testPrimaryProviderPackageName, final String testSecondaryProviderPackageName, final boolean recordStateChanges) {
        enforceManageTimeZoneDetectorPermission();
        if (testPrimaryProviderPackageName != null) goto L8;
        if (testSecondaryProviderPackageName != null) goto L8;
        throw new IllegalArgumentException("One or both test package names must be provided.");
    L8:
        this.mThreadingDomain.postAndWait(new LocationTimeZoneManagerService$$ExternalSyntheticLambda5(this, testPrimaryProviderPackageName, testSecondaryProviderPackageName, recordStateChanges), BLOCKING_OP_WAIT_DURATION_MILLIS);
    }

    private /* synthetic */ void lambda$startWithTestProviders$0(String testPrimaryProviderPackageName, String testSecondaryProviderPackageName, boolean recordStateChanges) {
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
        stopOnDomainThread();     // Catch: Throwable -> L7
        this.mServiceConfigAccessor.setTestPrimaryLocationTimeZoneProviderPackageName(testPrimaryProviderPackageName);     // Catch: Throwable -> L7
        this.mServiceConfigAccessor.setTestSecondaryLocationTimeZoneProviderPackageName(testSecondaryProviderPackageName);     // Catch: Throwable -> L7
        this.mServiceConfigAccessor.setRecordStateChangesForTests(recordStateChanges);     // Catch: Throwable -> L7
        startOnDomainThread();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void startOnDomainThread() {
        this.mThreadingDomain.assertCurrentThread();
        Object r1 = this.mSharedLock;
        monitor-enter(r1);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mServiceConfigAccessor.isGeoTimeZoneDetectionFeatureSupported() == true) goto L12;
        debugLog("Not starting location_time_zone_manager: it is disabled in service config");     // Catch: Throwable -> L9
        monitor-exit(r1);     // Catch: Throwable -> L9
        return;
    L12:
        if (this.mLocationTimeZoneProviderController != null) goto L14;
        LocationTimeZoneProvider primary = this.mPrimaryProviderConfig.createProvider();     // Catch: Throwable -> L9
        LocationTimeZoneProvider secondary = this.mSecondaryProviderConfig.createProvider();     // Catch: Throwable -> L9
        LocationTimeZoneProviderController.MetricsLogger metricsLogger = new RealControllerMetricsLogger();     // Catch: Throwable -> L9
        boolean recordStateChanges = this.mServiceConfigAccessor.getRecordStateChangesForTests();     // Catch: Throwable -> L9
        LocationTimeZoneProviderController controller = new LocationTimeZoneProviderController(this.mThreadingDomain, metricsLogger, primary, secondary, recordStateChanges);     // Catch: Throwable -> L9
        LocationTimeZoneProviderControllerEnvironmentImpl environment = new LocationTimeZoneProviderControllerEnvironmentImpl(this.mThreadingDomain, this.mServiceConfigAccessor, controller);     // Catch: Throwable -> L9
        LocationTimeZoneProviderControllerCallbackImpl callback = new LocationTimeZoneProviderControllerCallbackImpl(this.mThreadingDomain);     // Catch: Throwable -> L9
        controller.initialize(environment, callback);     // Catch: Throwable -> L9
        this.mLocationTimeZoneProviderControllerEnvironment = environment;     // Catch: Throwable -> L9
        this.mLocationTimeZoneProviderController = controller;     // Catch: Throwable -> L9
    L14:
        monitor-exit(r1);     // Catch: Throwable -> L9
    }

    void stop() {
        enforceManageTimeZoneDetectorPermission();
        this.mThreadingDomain.postAndWait(new LocationTimeZoneManagerService$$ExternalSyntheticLambda1(this), BLOCKING_OP_WAIT_DURATION_MILLIS);
    }

    private void stopOnDomainThread() {
        this.mThreadingDomain.assertCurrentThread();
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mLocationTimeZoneProviderController == null) goto L9;
        this.mLocationTimeZoneProviderController.destroy();     // Catch: Throwable -> L7
        this.mLocationTimeZoneProviderController = null;     // Catch: Throwable -> L7
        this.mLocationTimeZoneProviderControllerEnvironment.destroy();     // Catch: Throwable -> L7
        this.mLocationTimeZoneProviderControllerEnvironment = null;     // Catch: Throwable -> L7
        this.mServiceConfigAccessor.resetVolatileTestConfig();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    public void onShellCommand(FileDescriptor in, FileDescriptor out, FileDescriptor err, String[] args, ShellCallback callback, ResultReceiver resultReceiver) {
        new LocationTimeZoneManagerShellCommand(this).exec(this, in, out, err, args, callback, resultReceiver);
    }

    void clearRecordedProviderStates() {
        enforceManageTimeZoneDetectorPermission();
        this.mThreadingDomain.postAndWait(new LocationTimeZoneManagerService$$ExternalSyntheticLambda6(this), BLOCKING_OP_WAIT_DURATION_MILLIS);
    }

    private /* synthetic */ void lambda$clearRecordedProviderStates$1() {
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.mLocationTimeZoneProviderController == null) goto L9;
        this.mLocationTimeZoneProviderController.clearRecordedStates();     // Catch: Throwable -> L7
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L7
    }

    LocationTimeZoneManagerServiceState getStateForTests() {
        enforceManageTimeZoneDetectorPermission();
        return (LocationTimeZoneManagerServiceState) this.mThreadingDomain.postAndWait(new LocationTimeZoneManagerService$$ExternalSyntheticLambda0(this), BLOCKING_OP_WAIT_DURATION_MILLIS);
    L5:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private /* synthetic */ LocationTimeZoneManagerServiceState lambda$getStateForTests$2() throws Exception {
        Object r0 = this.mSharedLock;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.mLocationTimeZoneProviderController != null) goto L11;
        monitor-exit(r0);     // Catch: Throwable -> L9
        return null;
    L11:
        LocationTimeZoneManagerServiceState r1 = this.mLocationTimeZoneProviderController.getStateForTests();     // Catch: Throwable -> L9
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    }

    @Override // android.os.Binder
    protected void dump(FileDescriptor fd, PrintWriter pw, String[] args) {
        if (DumpUtils.checkDumpPermission(this.mContext, TAG, pw) == true) goto L5;
        return;
    L5:
        IndentingPrintWriter ipw = new IndentingPrintWriter(pw);
        Object r1 = this.mSharedLock;
        monitor-enter(r1);
        ipw.println("LocationTimeZoneManagerService:");     // Catch: Throwable -> L10
        ipw.increaseIndent();     // Catch: Throwable -> L10
        ipw.println("Primary provider config:");     // Catch: Throwable -> L10
        ipw.increaseIndent();     // Catch: Throwable -> L10
        this.mPrimaryProviderConfig.dump(ipw, args);     // Catch: Throwable -> L10
        ipw.decreaseIndent();     // Catch: Throwable -> L10
        ipw.println("Secondary provider config:");     // Catch: Throwable -> L10
        ipw.increaseIndent();     // Catch: Throwable -> L10
        this.mSecondaryProviderConfig.dump(ipw, args);     // Catch: Throwable -> L10
        ipw.decreaseIndent();     // Catch: Throwable -> L10
        if (this.mLocationTimeZoneProviderController != null) goto L12;
        ipw.println("{Stopped}");     // Catch: Throwable -> L10
    L13:
        ipw.decreaseIndent();     // Catch: Throwable -> L10
        monitor-exit(r1);     // Catch: Throwable -> L10
        return;
    L12:
        this.mLocationTimeZoneProviderController.dump(ipw, args);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    static void debugLog(String msg) {
        if (Log.isLoggable(TAG, 3) == false) goto L6;
        Slog.d(TAG, msg);
        return;
    }

    static void infoLog(String msg) {
        if (Log.isLoggable(TAG, 4) == false) goto L6;
        Slog.i(TAG, msg);
        return;
    }

    static void warnLog(String msg) {
        warnLog(msg, null);
    }

    static void warnLog(String msg, Throwable t) {
        if (Log.isLoggable(TAG, 5) == false) goto L6;
        Slog.w(TAG, msg, t);
        return;
    }

    private void enforceManageTimeZoneDetectorPermission() {
        this.mContext.enforceCallingPermission("android.permission.MANAGE_TIME_AND_ZONE_DETECTION", "manage time and time zone detection");
    }
}
