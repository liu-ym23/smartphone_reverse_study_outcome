package com.android.server.profcollect;

import android.R;
import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.camera2.CameraManager;
import android.hardware.usb.UsbManager;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.RemoteException;
import android.os.ServiceManager;
import android.os.SystemProperties;
import android.os.UpdateEngine;
import android.provider.DeviceConfig;
import android.provider.Settings;
import android.util.Log;
import com.android.internal.os.BackgroundThread;
import com.android.server.IoThread;
import com.android.server.LocalManagerRegistry;
import com.android.server.LocalServices;
import com.android.server.SystemServerInitThreadPool$$ExternalSyntheticLambda0;
import com.android.server.SystemService;
import com.android.server.art.ArtManagerLocal;
import com.android.server.art.model.BatchDexoptParams;
import com.android.server.pm.PackageManagerLocal;
import com.android.server.pm.PackageManagerService;
import com.android.server.timezonedetector.ServiceConfigAccessor;
import com.android.server.wm.ActivityMetricsLaunchObserver;
import com.android.server.wm.ActivityMetricsLaunchObserverRegistry;
import com.android.server.wm.ActivityTaskManagerInternal;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public final class ProfcollectForwardingService extends SystemService {
    private static final long BG_PROCESS_INTERVAL = 0;
    private static final String INTENT_UPLOAD_PROFILES = "com.android.server.profcollect.UPLOAD_PROFILES";
    public static final String LOG_TAG = "ProfcollectForwardingService";
    static boolean sAdbActive;
    private static IProfCollectd sIProfcollect;
    static boolean sIsBatteryLow;
    static boolean sIsInteractive;
    private static ProfcollectForwardingService sSelfService;
    static boolean sVerityEnforced;
    private final AppLaunchObserver mAppLaunchObserver;
    private final BroadcastReceiver mBroadcastReceiver;
    private final Handler mHandler;
    private IProviderStatusCallback mProviderStatusCallback;
    private boolean mUploadEnabled;
    private int mUsageSetting;

    private class AppLaunchObserver extends ActivityMetricsLaunchObserver {
        /* synthetic */ AppLaunchObserver(ProfcollectForwardingService r1, ProfcollectForwardingServiceIA r2) {
            this(r1);
        }

        private AppLaunchObserver(ProfcollectForwardingService r1) {
        }

        @Override // com.android.server.wm.ActivityMetricsLaunchObserver
        public void onIntentStarted(Intent intent, long timestampNanos) {
            if (Utils.withFrequency("applaunch_trace_freq", 5) == false) goto L6;
            Utils.traceSystem(ProfcollectForwardingService.m7966$$Nest$sfgetsIProfcollect(), "applaunch");
            return;
        }
    }

    public static class PeriodicTraceJobService extends JobService {
        private static final ComponentName JOB_SERVICE_NAME = null;
        private static final int PERIODIC_TRACE_JOB_ID = 241207;

        public PeriodicTraceJobService() {
        }

        static {
            JOB_SERVICE_NAME = new ComponentName(PackageManagerService.PLATFORM_PACKAGE_NAME, PeriodicTraceJobService.class.getName());
        }

        public static void schedule(Context context) {
            int interval = DeviceConfig.getInt("profcollect_native_boot", "collection_interval", 600);
            JobScheduler js = (JobScheduler) context.getSystemService(JobScheduler.class);
            js.schedule(new JobInfo.Builder(PERIODIC_TRACE_JOB_ID, JOB_SERVICE_NAME).setPeriodic(TimeUnit.SECONDS.toMillis(interval)).setPriority(300).build());
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters params) {
            if (ProfcollectForwardingService.m7966$$Nest$sfgetsIProfcollect() == null) goto L5;
            Utils.traceSystem(ProfcollectForwardingService.m7966$$Nest$sfgetsIProfcollect(), "periodic");
        L5:
            jobFinished(params, false);
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters params) {
            return false;
        }
    }

    private class ProfcollectdDeathRecipient implements IBinder.DeathRecipient {
        final /* synthetic */ ProfcollectForwardingService this$0;

        /* synthetic */ ProfcollectdDeathRecipient(ProfcollectForwardingService r1, ProfcollectForwardingServiceIA r2) {
            this(r1);
        }

        private ProfcollectdDeathRecipient(ProfcollectForwardingService r1) {
            this.this$0 = r1;
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            Log.w(ProfcollectForwardingService.LOG_TAG, "profcollectd has died");
            ProfcollectForwardingService.m7968$$Nest$sfputsIProfcollect(null);
            ProfcollectForwardingService.m7964$$Nest$mtryConnectNativeService(this.this$0);
        }
    }

    private class ProfcollectdHandler extends Handler {
        public static final int MESSAGE_BINDER_CONNECT = 0;
        public static final int MESSAGE_REGISTER_SCHEDULERS = 1;
        final /* synthetic */ ProfcollectForwardingService this$0;

        public ProfcollectdHandler(ProfcollectForwardingService r1, Looper looper) {
            this.this$0 = r1;
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch(message.what) {
                case 0: goto L7;
                case 1: goto L6;
                default: goto L5;
            };
        L6:
            ProfcollectForwardingService.m7963$$Nest$mregisterObservers(this.this$0);
            PeriodicTraceJobService.schedule(this.this$0.getContext());
            ReportProcessJobService.schedule(this.this$0.getContext());
            return;
        L7:
            ProfcollectForwardingService.m7962$$Nest$mconnectNativeService(this.this$0);
            return;
        L5:
            throw new AssertionError("Unknown message: " + message);
        }
    }

    public static class ReportProcessJobService extends JobService {
        private static final ComponentName JOB_SERVICE_NAME = null;
        private static final int REPORT_PROCESS_JOB_ID = 260817;

        public ReportProcessJobService() {
        }

        static {
            JOB_SERVICE_NAME = new ComponentName(PackageManagerService.PLATFORM_PACKAGE_NAME, ReportProcessJobService.class.getName());
        }

        public static void schedule(Context context) {
            JobScheduler js = (JobScheduler) context.getSystemService(JobScheduler.class);
            js.schedule(new JobInfo.Builder(REPORT_PROCESS_JOB_ID, JOB_SERVICE_NAME).setRequiresDeviceIdle(true).setRequiresCharging(true).setPeriodic(ProfcollectForwardingService.m7965$$Nest$sfgetBG_PROCESS_INTERVAL()).setPriority(100).build());
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters params) {
            ProfcollectForwardingService.m7969$$Nest$smcreateAndUploadReport(ProfcollectForwardingService.m7967$$Nest$sfgetsSelfService());
            jobFinished(params, false);
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters params) {
            return false;
        }
    }

    public static /* synthetic */ void $r8$lambda$1JszTNP0Wjdi3llSjRuXlKdX2Gc(ProfcollectForwardingService r0) {
        r0.lambda$onBootPhase$0();
    }

    public static /* synthetic */ void $r8$lambda$Z7z3slCDjiUYKGoo7Kkfo2a4OEw(ProfcollectForwardingService r0, PackageManagerLocal.FilteredSnapshot r1, String r2, List r3, BatchDexoptParams.Builder r4, CancellationSignal r5) {
        r0.lambda$registerDex2oatObserver$2(r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void $r8$lambda$iDnCUu1hMoq27JBaZJhWxOSzgiw(ProfcollectForwardingService r0) {
        r0.lambda$registerObservers$1();
    }

    public static /* synthetic */ void $r8$lambda$pF8vnaAFWj32BPKHKrXbd4S1cW0(ProfcollectForwardingService r0) {
        lambda$createAndUploadReport$3(r0);
    }

    /* JADX INFO: renamed from: -$$Nest$fgetmHandler, reason: not valid java name */
    static /* bridge */ /* synthetic */ Handler m7961$$Nest$fgetmHandler(ProfcollectForwardingService r0) {
        return r0.mHandler;
    }

    /* JADX INFO: renamed from: -$$Nest$mconnectNativeService, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7962$$Nest$mconnectNativeService(ProfcollectForwardingService r0) {
        return r0.connectNativeService();
    }

    /* JADX INFO: renamed from: -$$Nest$mregisterObservers, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7963$$Nest$mregisterObservers(ProfcollectForwardingService r0) {
        r0.registerObservers();
    }

    /* JADX INFO: renamed from: -$$Nest$mtryConnectNativeService, reason: not valid java name */
    static /* bridge */ /* synthetic */ boolean m7964$$Nest$mtryConnectNativeService(ProfcollectForwardingService r0) {
        return r0.tryConnectNativeService();
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetBG_PROCESS_INTERVAL, reason: not valid java name */
    static /* bridge */ /* synthetic */ long m7965$$Nest$sfgetBG_PROCESS_INTERVAL() {
        return BG_PROCESS_INTERVAL;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsIProfcollect, reason: not valid java name */
    static /* bridge */ /* synthetic */ IProfCollectd m7966$$Nest$sfgetsIProfcollect() {
        return sIProfcollect;
    }

    /* JADX INFO: renamed from: -$$Nest$sfgetsSelfService, reason: not valid java name */
    static /* bridge */ /* synthetic */ ProfcollectForwardingService m7967$$Nest$sfgetsSelfService() {
        return sSelfService;
    }

    /* JADX INFO: renamed from: -$$Nest$sfputsIProfcollect, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7968$$Nest$sfputsIProfcollect(IProfCollectd r0) {
        sIProfcollect = r0;
    }

    /* JADX INFO: renamed from: -$$Nest$smcreateAndUploadReport, reason: not valid java name */
    static /* bridge */ /* synthetic */ void m7969$$Nest$smcreateAndUploadReport(ProfcollectForwardingService r0) {
        createAndUploadReport(r0);
    }

    static {
        BG_PROCESS_INTERVAL = TimeUnit.HOURS.toMillis(4);
    }

    public ProfcollectForwardingService(Context context) {
        super(context);
        this.mHandler = new ProfcollectdHandler(this, IoThread.getHandler().getLooper());
        this.mProviderStatusCallback = new AnonymousClass1(this);
        this.mBroadcastReceiver = new AnonymousClass2(this);
        this.mAppLaunchObserver = new AppLaunchObserver(this, null);
        if (sSelfService != null) goto L15;
        sSelfService = this;
        this.mUsageSetting = Settings.Global.getInt(context.getContentResolver(), "multi_cb");     // Catch: Settings.SettingNotFoundException -> L7
    L9:
        String verityMode = SystemProperties.get("ro.boot.veritymode");
        sVerityEnforced = verityMode.equals("enforcing");
        if (sVerityEnforced == true) goto L12;
        Log.d(LOG_TAG, "verity is not enforced: " + verityMode);
    L12:
        this.mUploadEnabled = context.getResources().getBoolean(R.bool.config_resetScreenTimeoutOnUnexpectedDreamExit);
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.intent.action.BATTERY_LOW");
        filter.addAction("android.intent.action.BATTERY_OKAY");
        filter.addAction("android.intent.action.SCREEN_ON");
        filter.addAction("android.intent.action.SCREEN_OFF");
        filter.addAction(INTENT_UPLOAD_PROFILES);
        filter.addAction("android.hardware.usb.action.USB_STATE");
        context.registerReceiver(this.mBroadcastReceiver, filter, 4);
        return;
    L7:
        e = move-exception;
        Log.e(LOG_TAG, "Usage setting not found: " + e.getMessage());
        this.mUsageSetting = -1;
        goto L9
    L15:
        throw new AssertionError("only one service instance allowed");
    }

    public static boolean enabled() {
        if (DeviceConfig.getBoolean("profcollect_native_boot", ServiceConfigAccessor.PROVIDER_MODE_ENABLED, false) == false) goto L5;
    L6:
        return true;
    L5:
        if (SystemProperties.getBoolean("persist.profcollectd.enabled_override", false) == true) goto L6;
        return false;
    }

    @Override // com.android.server.SystemService
    public void onStart() {
        connectNativeService();
    }

    @Override // com.android.server.SystemService
    public void onBootPhase(int phase) {
        if (phase != 500) goto L16;
        UsbManager usbManager = (UsbManager) getContext().getSystemService(UsbManager.class);
        boolean r3 = false;
        if (usbManager != null) goto L8;
        sAdbActive = false;
        Log.d(LOG_TAG, "USBManager is not ready");
    L11:
        PowerManager powerManager = (PowerManager) getContext().getSystemService(PowerManager.class);
        if (powerManager != null) goto L14;
        sIsInteractive = true;
        Log.d(LOG_TAG, "PowerManager is not ready");
        goto L16
    L14:
        sIsInteractive = powerManager.isInteractive();
        Log.d(LOG_TAG, "Device is interactive " + sIsInteractive + " on system startup");
        goto L16
    L8:
        if ((usbManager.getCurrentFunctions() & 1) != 1) goto L10;
        r3 = true;
    L10:
        sAdbActive = r3;
        Log.d(LOG_TAG, "ADB is " + sAdbActive + " on system startup");
    L16:
        if (phase == 1000) goto L18;
        return;
    L18:
        if (sIProfcollect != null) goto L20;
        return;
    L20:
        BackgroundThread.get().getThreadHandler().post(new ProfcollectForwardingService$$ExternalSyntheticLambda0(this));
    }

    private /* synthetic */ void lambda$onBootPhase$0() {
        if (serviceHasSupportedTraceProvider() == false) goto L6;
        registerProviderStatusCallback();
        return;
    }

    private void registerProviderStatusCallback() {
        if (sIProfcollect != null) goto L10;
        return;
    L10:
        sIProfcollect.registerProviderStatusCallback(this.mProviderStatusCallback);     // Catch: RemoteException -> L7
        return;
    L7:
        e = move-exception;
        Log.e(LOG_TAG, "Failed to register provider status callback: " + e.getMessage());
    }

    private boolean serviceHasSupportedTraceProvider() {
        if (sIProfcollect != null) goto L11;
        return false;
    L11:
        return !sIProfcollect.get_supported_provider().isEmpty();
    L8:
        e = move-exception;
        Log.e(LOG_TAG, "Failed to get supported provider: " + e.getMessage());
        return false;
    }

    private boolean tryConnectNativeService() {
        if (connectNativeService() == false) goto L6;
        return true;
    L6:
        this.mHandler.sendEmptyMessageDelayed(0, 5000);
        return false;
    }

    private boolean connectNativeService() {
        IProfCollectd profcollectd = IProfCollectd.Stub.asInterface(ServiceManager.getServiceOrThrow("profcollectd"));     // Catch: Throwable -> L6
        profcollectd.asBinder().linkToDeath(new ProfcollectdDeathRecipient(this, null), 0);     // Catch: Throwable -> L6
        sIProfcollect = profcollectd;     // Catch: Throwable -> L6
        return true;
    L7:
        Log.w(LOG_TAG, "Failed to connect profcollectd binder service.");
        return false;
    }

    private void registerObservers() {
        BackgroundThread.get().getThreadHandler().post(new ProfcollectForwardingService$$ExternalSyntheticLambda1(this));
    }

    private /* synthetic */ void lambda$registerObservers$1() {
        registerAppLaunchObserver();
        registerCameraOpenObserver();
        registerDex2oatObserver();
        registerOTAObserver();
    }

    private void registerAppLaunchObserver() {
        ActivityTaskManagerInternal atmInternal = (ActivityTaskManagerInternal) LocalServices.getService(ActivityTaskManagerInternal.class);
        ActivityMetricsLaunchObserverRegistry launchObserverRegistry = atmInternal.getLaunchObserverRegistry();
        launchObserverRegistry.registerLaunchObserver(this.mAppLaunchObserver);
    }

    private void registerDex2oatObserver() {
        ArtManagerLocal aml = (ArtManagerLocal) LocalManagerRegistry.getManager(ArtManagerLocal.class);
        if (aml != null) goto L6;
        Log.w(LOG_TAG, "Couldn't get ArtManagerLocal");
        return;
    L6:
        aml.setBatchDexoptStartCallback(new SystemServerInitThreadPool$$ExternalSyntheticLambda0(), new ProfcollectForwardingService$$ExternalSyntheticLambda2(this));
    }

    private /* synthetic */ void lambda$registerDex2oatObserver$2(PackageManagerLocal.FilteredSnapshot snapshot, String reason, List defaultPackages, BatchDexoptParams.Builder builder, CancellationSignal passedSignal) {
        traceOnDex2oatStart();
    }

    private void traceOnDex2oatStart() {
        if (Utils.withFrequency("dex2oat_trace_freq", 25) == false) goto L6;
        Utils.traceSystem(sIProfcollect, "dex2oat", 1000);
        return;
    }

    private void registerOTAObserver() {
        UpdateEngine updateEngine = new UpdateEngine();
        updateEngine.bind(new AnonymousClass3(this));
    }

    private static void createAndUploadReport(final ProfcollectForwardingService pfs) {
        BackgroundThread.get().getThreadHandler().post(new ProfcollectForwardingService$$ExternalSyntheticLambda3(pfs));
    }

    private static /* synthetic */ void lambda$createAndUploadReport$3(ProfcollectForwardingService pfs) {
        if (sIProfcollect != null) goto L19;
        return;
    L19:
        String reportName = sIProfcollect.report(pfs.mUsageSetting) + ".zip";     // Catch: RemoteException -> L16
        if (pfs.mUploadEnabled == true) goto L11;
        Log.i(LOG_TAG, "Upload is not enabled.");
        return;
    L11:
        if (sVerityEnforced == true) goto L14;
        Log.i(LOG_TAG, "Verity is not enforced.");
        return;
    L14:
        Intent intent = new Intent().setPackage("com.android.shell").setAction("com.android.shell.action.PROFCOLLECT_UPLOAD").putExtra("filename", reportName);
        pfs.getContext().sendBroadcast(intent);
        return;
    L16:
        e = move-exception;
        Log.e(LOG_TAG, "Failed to create report: " + e.getMessage());
    }

    private void registerCameraOpenObserver() {
        CameraManager cm = (CameraManager) getContext().getSystemService(CameraManager.class);
        cm.registerAvailabilityCallback(new AnonymousClass4(this), null);
    }
}
