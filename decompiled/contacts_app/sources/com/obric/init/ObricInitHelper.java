package com.obric.init;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.UserManager;
import com.GlobalProxyLancet;
import com.android.contacts.BuildConfig;
import com.android.contacts.ContactsProcessUtils;
import com.bytedance.apm.Apm;
import com.bytedance.apm.config.ApmInitConfig;
import com.bytedance.apm.config.ApmStartConfig;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.launch.LaunchInitConfig;
import com.obric.account.Account;
import com.obric.aikernel.phx.sdk.AIKernelManager;
import com.obric.aikernel.sdk.AIKernelConfig;
import com.obric.callandsms.common.DonationTrackerDelegate;
import com.obric.callsummary.CallSummaryGenerateManager;
import com.obric.feedback.sdk.FeedbackSdk;
import com.obric.feedback.sdk.IAppInfoProvider;
import com.obric.feedback.sdk.IFeedbackSdkLogger;
import com.obric.matrix.platform.sdk.ones.dataanalysis.MatrixTeaManager;
import com.obric.matrix.platform.sdk.ones.init.BaseComponentConfig;
import com.obric.matrix.platform.sdk.ones.init.BaseComponentInitHelper;
import com.obric.model.CallFeatureModel;
import com.obric.network.ttnet.TTNetInitHelper;
import com.obric.olog.OLog;
import com.obric.olog.OLogConfig;
import com.obric.tracker.EventTrackerManager;
import com.obric.utils.DeviceIdPrivacy;
import com.obric.voice.AIVoiceTaskWrapper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObricInitHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001eH\u0002J\u0018\u0010 \u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0006H\u0002J\u0010\u0010\"\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010#\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001eH\u0007J\u0006\u0010$\u001a\u00020\u0017R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/init/ObricInitHelper;", "", "()V", "APM_BLOCK_THRESHOLD_MS", "", "APM_CHANNEL", "", "APM_EVIL_METHOD_THRESHOLD_MS", "APM_REGION", "APP_ID", "", "INIT_TIME_LIMIT", "TAG", "hasRegisteredApmDidListener", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasStartedApm", "isScreenReceiverRegistered", "", "latch", "Ljava/util/concurrent/CountDownLatch;", "screenReceiver", "Landroid/content/BroadcastReceiver;", "init", "", "context", "Landroid/app/Application;", "initApm", "initFeedbackSdk", "initOLog", "ctx", "Landroid/content/Context;", "registerScreenReceiver", "startApm", "did", "startApmWhenDidReady", "unregisterScreenReceiver", "waitForInitDone", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ObricInitHelper {
    private static final long APM_BLOCK_THRESHOLD_MS = 2500;
    private static final String APM_CHANNEL = "release";
    private static final long APM_EVIL_METHOD_THRESHOLD_MS = 1000;
    private static final String APM_REGION = "CN";
    private static final int APP_ID = 900285;
    private static final long INIT_TIME_LIMIT = 10;
    public static final ObricInitHelper INSTANCE = null;
    private static final String TAG = "ObricInitHelper";
    private static final AtomicBoolean hasRegisteredApmDidListener = null;
    private static final AtomicBoolean hasStartedApm = null;
    private static boolean isScreenReceiverRegistered;
    private static final CountDownLatch latch = null;
    private static BroadcastReceiver screenReceiver;

    /* JADX INFO: renamed from: $r8$lambda$qbhMJzNQSXCa-r42D67cwIjTbhg, reason: not valid java name */
    public static /* synthetic */ void m351$r8$lambda$qbhMJzNQSXCar42D67cwIjTbhg(Application r0, boolean r1) {
        init$lambda$0(r0, r1);
    }

    private ObricInitHelper() {
    }

    public static final /* synthetic */ AtomicBoolean access$getHasStartedApm$p() {
        return hasStartedApm;
    }

    public static final /* synthetic */ void access$startApm(ObricInitHelper r0, Context r1, String r2) {
        r0.startApm(r1, r2);
    }

    public static final /* synthetic */ void access$startApmWhenDidReady(ObricInitHelper r0, Application r1) {
        r0.startApmWhenDidReady(r1);
    }

    static {
        INSTANCE = new ObricInitHelper();
        latch = new CountDownLatch(1);
        hasStartedApm = new AtomicBoolean(false);
        hasRegisteredApmDidListener = new AtomicBoolean(false);
    }

    public final void init(final Application r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        final boolean r0 = ContactsProcessUtils.isMainProcess(Application.getProcessName(), r5.getPackageName());
        new Thread(new ObricInitHelper$$ExternalSyntheticLambda0(r5, r0)).start();
        EventTrackerManager.INSTANCE.init(r5);
        initApm(r5);
        BaseComponentInitHelper.init(r5, new BaseComponentConfig.Builder().setIsBoe(false).setAppId(APP_ID).setUseTTNet(r0).build());
        DonationTrackerDelegate.INSTANCE.setTracker(new AnonymousClass2());
        DeviceIdPrivacy.INSTANCE.init();
        initFeedbackSdk(r5);
    }

    private static final void init$lambda$0(Application r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "$context");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "init start!");
        Application r2 = r5;
        AIKernelConfig.Builder r0 = new AIKernelConfig.Builder(r2).appId(0);
        String r3 = r5.getPackageName();
        Intrinsics.checkNotNullExpressionValue(r3, "context.packageName");
        AIKernelConfig r1 = r0.packageName(r3).build();
        AIKernelManager.INSTANCE.init(r1);
        CallSummaryGenerateManager.INSTANCE.init(r2);
        CallFeatureModel.INSTANCE.init(r2);
        Account.INSTANCE.init(r5);
        if (r6 == false) goto L5;
        TTNetInitHelper r7 = TTNetInitHelper.INSTANCE;
        Context r4 = r5.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(r4, "context.applicationContext");
        r7.initTTNet(r4, r5);
    L5:
        AIVoiceTaskWrapper.INSTANCE.initVoiceServer(r2);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "init done!");
        latch.countDown();
    }

    public final void waitForInitDone() {
        latch.await(10, TimeUnit.SECONDS);
    }

    @JvmStatic
    public static final void initOLog(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "ctx");
        UserManager r0 = (UserManager) r3.getSystemService(UserManager.class);
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        if (r1 == false) goto L17;
        Context r2 = r3.createDeviceProtectedStorageContext();
        if (r2 == null) goto L17;
        r3 = r2;
    L17:
        OLog.init(new OLogConfig.Builder(r3).setLevel(2).setSaveToDisk(true).setLogFileExpDays(30).build());     // Catch: IllegalStateException -> L14
        OLog.setOutputToLogd(true);     // Catch: IllegalStateException -> L14
        return;
    L14:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "OLog init failed in Direct Boot", e);
        return;
    L5:
        if (r0.isUserUnlocked() == true) goto L7;
        r1 = true;
        goto L7
    }

    private final void initApm(Application r8) {
        Application r1 = r8;
        Apm.getInstance().init(r1, ApmInitConfig.builder().fullFpsTracer(true).launchInitConfig(new LaunchInitConfig.Builder().collectPerfData().collectNetData().collectTimingTrace().collectDeviceInfo().setMaxCollectTimeMs(TraceStatsConsts.PAGE_LOAD_MAX_LIMIT_MS).build()).reportEvilMethodSwitch(true).evilMethodThresholdMs(1000).debugMode(false).build());
        registerScreenReceiver(r1);
        startApmWhenDidReady(r8);
    }

    private final void startApmWhenDidReady(final Application r6) {
        MatrixTeaManager r0 = MatrixTeaManager.Companion.getInstance();
        String r1 = r0.getDeviceId();
        String r2 = r1;
        if (r2 != null) goto L5;
    L8:
        boolean r3 = true;
    L9:
        if (r3 == true) goto L13;
        startApm(r6, r1);
        return;
    L13:
        if (hasRegisteredApmDidListener.compareAndSet(false, true) == true) goto L15;
        return;
    L15:
        r0.addDeviceInfoListener(new C02931(r6));
        return;
    L5:
        if (r2.length() == 0) goto L8;
        r3 = false;
        goto L9
    }

    private final void startApm(Context r3, String r4) {
        if (r4.length() != 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L8;
        return;
    L8:
        if (hasStartedApm.compareAndSet(false, true) == false) goto L13;
        Apm.getInstance().start(ApmStartConfig.builder().aid(APP_ID).appVersion(BuildConfig.VERSION_NAME).channel("release").deviceId(r4).updateVersionCode("200301587").dynamicParams(new C02921()).batteryDetect(true).blockDetect(true).seriousBlockDetect(true).blockThresholdMs(2500).build());
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "startApm success, did=" + r4 + ", sdk=" + Build.VERSION.SDK_INT);
        return;
    L13:
        return;
    L5:
        r2 = false;
        goto L6
    }

    private final void registerScreenReceiver(final Context r2) {
        if (isScreenReceiverRegistered == false) goto L10;
        return;
    L10:
        IntentFilter r1 = new IntentFilter();     // Catch: Exception -> L7
        r1.addAction("android.intent.action.SCREEN_ON");     // Catch: Exception -> L7
        r1.addAction("android.intent.action.SCREEN_OFF");     // Catch: Exception -> L7
        screenReceiver = new AnonymousClass1(r2);     // Catch: Exception -> L7
        GlobalProxyLancet.com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(r2.getApplicationContext(), screenReceiver, r1);     // Catch: Exception -> L7
        isScreenReceiverRegistered = true;     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "registerScreenReceiver failed", e);
    }

    @JvmStatic
    public static final void unregisterScreenReceiver(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        if (isScreenReceiverRegistered == true) goto L5;
        return;
    L5:
        BroadcastReceiver r0 = screenReceiver;
        if (r0 != null) goto L19;
        return;
    L19:
        r4.getApplicationContext().unregisterReceiver(r0);     // Catch: Throwable -> L11 Exception -> L13
    L10:
        screenReceiver = null;
        isScreenReceiverRegistered = false;
        return;
    L13:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "unregisterScreenReceiver failed", e);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        screenReceiver = null;
        isScreenReceiverRegistered = false;
        throw th;
    }

    private final void initFeedbackSdk(Application r4) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "initFeedbackSdk start");
        IAppInfoProvider r3 = new ObricInitHelper$initFeedbackSdk$appInfo$1();
        IFeedbackSdkLogger r1 = new ObricInitHelper$initFeedbackSdk$logger$1();
        FeedbackSdk.INSTANCE.init(r4, r3, r1);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "initFeedbackSdk end");
    }
}
