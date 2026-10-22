package com.stepos.pps.logpull;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemProperties;
import android.util.Log;
import com.stepos.pps.data.ouc.cloud.UserConfig;
import com.stepos.pps.logpull.LogPullManager;
import com.stepos.pps.logpull.LogPullTaskStore;
import java.net.URL;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class LogPullPoller {
    private static final String HOST_PROD = "mic-collect.stepaos.com";
    private static final String HOST_TEST = "mic-collect.t-stepos.com";
    private static final String PROP_ENV = "persist.sys.logpull.env";
    private static final String PROP_SERVER_URL = "persist.sys.logpull.server";
    public static final int RESULT_EMPTY = 0;
    public static final int RESULT_ERROR = -1;
    public static final int RESULT_HAS_TASKS = 1;
    private static final String TAG = "LogPull.Poller";
    private BroadcastReceiver authReceiver;
    private LogPullAuthStore authStore;
    private final Context context;
    private String deviceOaid;
    private Handler handler;
    private HandlerThread handlerThread;
    private LogPullManager manager;
    private LogPullNotification notification;
    private LogPullConfig pendingAuthConfig;
    private BroadcastReceiver uploadActionReceiver;
    private final AtomicBoolean running = new AtomicBoolean(false);
    private final Set<Long> ackedOrActiveIds = new HashSet();
    private final Object checkLock = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    public String getServerUrl() {
        String str;
        if (!isDebuggableBuild() || (str = SystemProperties.get(PROP_SERVER_URL, "")) == null || str.isEmpty()) {
            return "https://".concat(UserConfig.USER_TEST.equalsIgnoreCase(SystemProperties.get(PROP_ENV, "prod")) ? HOST_TEST : HOST_PROD);
        }
        return str;
    }

    private static boolean isDebuggableBuild() {
        String str = Build.TYPE;
        return "userdebug".equals(str) || "eng".equals(str);
    }

    public LogPullPoller(Context context) {
        this.context = context.getApplicationContext();
    }

    public void start(String str) {
        if (this.running.getAndSet(true)) {
            Log.w(TAG, "Poller已在运行");
            return;
        }
        this.deviceOaid = str;
        LogPullManager logPullManager = new LogPullManager(this.context, new LogPullPoller$$ExternalSyntheticLambda1(this));
        this.manager = logPullManager;
        logPullManager.setAuthQueueCleaner(new LogPullPoller$$ExternalSyntheticLambda4(this));
        this.authStore = new LogPullAuthStore(this.context);
        this.notification = new LogPullNotification(this.context);
        StringBuilder sb = new StringBuilder("Poller启动, oaidLen=");
        sb.append(str == null ? 0 : str.length());
        sb.append(" serverHost=");
        sb.append(hostOf(getServerUrl()));
        Log.i(TAG, sb.toString());
        HandlerThread handlerThread = new HandlerThread("LogPullPoller");
        this.handlerThread = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(this.handlerThread.getLooper());
        this.handler = handler;
        handler.post(new Runnable() { // from class: com.stepos.pps.logpull.LogPullPoller$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$start$0();
            }
        });
        registerAuthReceiver();
        registerUploadActionReceiver();
        LogPullCheckJobService.ensureScheduled(this.context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$0() {
        try {
            if (this.manager.resumeIfNeeded()) {
                Log.i(TAG, "已恢复本地待上报任务");
            }
        } catch (Exception e) {
            Log.e(TAG, "恢复待上报任务失败", e);
        }
        restoreAuthQueue();
    }

    public void forceCheck() {
        if (!LogCollectionGate.isLogPullAllowed(this.context)) {
            Log.w(TAG, "forceCheck 忽略：稳定性体验计划未开启或 mp 机型");
            return;
        }
        if (!this.running.get()) {
            Log.w(TAG, "forceCheck 忽略：Poller 未运行");
            return;
        }
        String serverUrl = getServerUrl();
        if (this.manager == null) {
            LogPullManager logPullManager = new LogPullManager(this.context, new LogPullPoller$$ExternalSyntheticLambda1(this));
            this.manager = logPullManager;
            logPullManager.setAuthQueueCleaner(new LogPullPoller$$ExternalSyntheticLambda4(this));
        }
        Log.i(TAG, "forceCheck: 立即调度 host=" + hostOf(serverUrl));
        LogPullCheckJobService.scheduleImmediate(this.context);
    }

    public void onUserDelete(final long j) {
        Handler handler = this.handler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.stepos.pps.logpull.LogPullPoller$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.lambda$onUserDelete$1(j);
                }
            });
        } else {
            lambda$onUserDelete$1(j);
        }
    }

    public void onPackStop(long j) {
        LogPullManager logPullManager = this.manager;
        if (logPullManager == null) {
            Log.w(TAG, "manager 未就绪，无法停止打包 configId=" + j);
            return;
        }
        logPullManager.stopPacking(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: handleUserDelete, reason: merged with bridge method [inline-methods] */
    public void lambda$onUserDelete$1(long j) {
        Log.i(TAG, "处理用户删除 configId=" + j);
        LogPullAuthStore logPullAuthStore = this.authStore;
        LogPullConfig logPullConfigFind = logPullAuthStore != null ? logPullAuthStore.find(j) : null;
        LogPullConfig logPullConfig = this.pendingAuthConfig;
        boolean z = logPullConfig != null && logPullConfig.configId == j;
        if (logPullConfigFind != null || z) {
            LogPullAuthStore logPullAuthStore2 = this.authStore;
            if (logPullAuthStore2 != null) {
                logPullAuthStore2.remove(j);
            }
            if (z) {
                this.pendingAuthConfig = null;
                LogPullAuthStore logPullAuthStore3 = this.authStore;
                if (logPullAuthStore3 != null) {
                    logPullAuthStore3.clearShowing();
                }
            }
            this.ackedOrActiveIds.remove(Long.valueOf(j));
            String str = this.deviceOaid;
            if ((str == null || str.isEmpty()) && logPullConfigFind != null) {
                str = logPullConfigFind.oaid;
            }
            if (str != null && !str.isEmpty()) {
                if (!new LogPullStatusReporter(this.context, new LogPullPoller$$ExternalSyntheticLambda1(this)).reportStatus(j, str, 9, LogPullUserDeleteReceiver.REASON_USER_DELETED_LOGS)) {
                    Log.e(TAG, "授权阶段用户删除上报失败 configId=" + j);
                }
            } else {
                Log.w(TAG, "授权阶段用户删除无 oaid，跳过上报 configId=" + j);
            }
            new LogPullDiskManager().cleanupTask(j);
            LogPullNotification logPullNotification = this.notification;
            if (logPullNotification != null) {
                logPullNotification.dismissAuth(j);
                this.notification.showFailed(j, "拉取失败：用户删除日志");
            }
            LogPullAuthActivity.sendDismiss(this.context, j);
            maybeShowNextAuth();
            return;
        }
        LogPullTaskStore.PendingTask pendingTaskLoad = new LogPullTaskStore(this.context).load();
        if (pendingTaskLoad == null || pendingTaskLoad.configId != j) {
            Log.i(TAG, "忽略 USER_DELETE：任务已不在授权/待传队列 configId=" + j);
            return;
        }
        String str2 = this.deviceOaid;
        if (str2 == null || str2.isEmpty()) {
            str2 = pendingTaskLoad.oaid;
        }
        LogPullManager logPullManager = this.manager;
        if (logPullManager != null) {
            logPullManager.abandonAsUserDeleted(j, str2);
            return;
        }
        if (str2 != null && !str2.isEmpty()) {
            new LogPullStatusReporter(this.context, new LogPullPoller$$ExternalSyntheticLambda1(this)).reportStatus(j, str2, 9, LogPullUserDeleteReceiver.REASON_USER_DELETED_LOGS);
        }
        new LogPullDiskManager().cleanupTask(j);
        LogPullNotification logPullNotification2 = this.notification;
        if (logPullNotification2 != null) {
            logPullNotification2.showFailed(j, "拉取失败：用户删除日志");
        }
    }

    public void stop() {
        this.running.set(false);
        LogPullCheckJobService.cancel(this.context);
        HandlerThread handlerThread = this.handlerThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            this.handlerThread = null;
            this.handler = null;
        }
        unregisterAuthReceiver();
        unregisterUploadActionReceiver();
        this.pendingAuthConfig = null;
        this.ackedOrActiveIds.clear();
        this.manager = null;
        this.authStore = null;
        this.notification = null;
        Log.i(TAG, "Poller停止");
    }

    public void abortAllForGateClosed(final String str) {
        if (this.handler == null) {
            abortAllForGateClosedOnHandler(str);
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.handler.post(new Runnable() { // from class: com.stepos.pps.logpull.LogPullPoller$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$abortAllForGateClosed$2(str, countDownLatch);
            }
        });
        try {
            if (countDownLatch.await(10L, TimeUnit.SECONDS)) {
                return;
            }
            Log.w(TAG, "abortAllForGateClosed timeout reason=" + str);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            Log.w(TAG, "abortAllForGateClosed interrupted", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$abortAllForGateClosed$2(String str, CountDownLatch countDownLatch) {
        try {
            abortAllForGateClosedOnHandler(str);
        } finally {
            countDownLatch.countDown();
        }
    }

    private void abortAllForGateClosedOnHandler(String str) {
        String str2;
        Log.i(TAG, "abortAllForGateClosed reason=" + str);
        LogPullStatusReporter logPullStatusReporter = new LogPullStatusReporter(this.context, new LogPullPoller$$ExternalSyntheticLambda1(this));
        LogPullAuthStore logPullAuthStore = this.authStore;
        if (logPullAuthStore != null) {
            for (LogPullConfig logPullConfig : logPullAuthStore.loadAll()) {
                String str3 = this.deviceOaid;
                if ((str3 == null || str3.isEmpty()) && logPullConfig != null) {
                    str3 = logPullConfig.oaid;
                }
                String str4 = str3;
                if (str4 == null || str4.isEmpty()) {
                    str2 = str;
                } else {
                    str2 = str;
                    logPullStatusReporter.reportStatus(logPullConfig.configId, str4, 9, str2);
                }
                this.authStore.remove(logPullConfig.configId);
                this.ackedOrActiveIds.remove(Long.valueOf(logPullConfig.configId));
                new LogPullDiskManager().cleanupTask(logPullConfig.configId);
                LogPullNotification logPullNotification = this.notification;
                if (logPullNotification != null) {
                    logPullNotification.dismissAuth(logPullConfig.configId);
                    this.notification.showFailed(logPullConfig.configId, "拉取失败：" + str2);
                }
                LogPullAuthActivity.sendDismiss(this.context, logPullConfig.configId);
                str = str2;
            }
        }
        String str5 = str;
        this.pendingAuthConfig = null;
        LogPullAuthStore logPullAuthStore2 = this.authStore;
        if (logPullAuthStore2 != null) {
            logPullAuthStore2.clearShowing();
        }
        if (this.manager != null) {
            LogPullTaskStore.PendingTask pendingTaskLoad = new LogPullTaskStore(this.context).load();
            if (pendingTaskLoad != null) {
                String str6 = this.deviceOaid;
                if (str6 == null || str6.isEmpty()) {
                    str6 = pendingTaskLoad.oaid;
                }
                this.manager.abandonWithReason(pendingTaskLoad.configId, str6, str5);
                return;
            }
            this.manager.requestCancelForGateClose();
        }
    }

    public int runScheduledCheck() {
        int iPollOnce;
        if (!this.running.get()) {
            return -1;
        }
        if (!LogCollectionGate.isLogPullAllowed(this.context)) {
            Log.w(TAG, "check gated: 稳定性体验计划未开启或 mp 机型");
            return 0;
        }
        synchronized (this.checkLock) {
            iPollOnce = pollOnce();
        }
        return iPollOnce;
    }

    private void restoreAuthQueue() {
        reconcileAuthDeadlines();
        List<LogPullConfig> listLoadAll = this.authStore.loadAll();
        if (listLoadAll.isEmpty()) {
            Log.i(TAG, "无待授权任务需恢复");
            return;
        }
        Iterator<LogPullConfig> it = listLoadAll.iterator();
        while (it.hasNext()) {
            this.ackedOrActiveIds.add(Long.valueOf(it.next().configId));
        }
        LogPullConfig logPullConfig = listLoadAll.get(0);
        this.pendingAuthConfig = logPullConfig;
        this.authStore.setShowing(logPullConfig.configId);
        this.notification.showAuthPending(logPullConfig, this.deviceOaid);
        Log.i(TAG, "已恢复授权通知: configId=" + logPullConfig.configId + " queue=" + listLoadAll.size());
    }

    private int pollOnce() {
        if (!this.running.get()) {
            return -1;
        }
        try {
            if (reconcileAuthDeadlines() > 0) {
                maybeShowNextAuth();
            }
            Log.i(TAG, "轮询云端 config/check...");
            LogPullStatusReporter logPullStatusReporter = new LogPullStatusReporter(this.context, new LogPullPoller$$ExternalSyntheticLambda1(this));
            List<LogPullConfig> listCheck = logPullStatusReporter.check(this.deviceOaid);
            if (listCheck == null) {
                Log.w(TAG, "config/check 失败，按 ERROR 短重试（不累加空退避）");
                return -1;
            }
            if (listCheck.isEmpty()) {
                return 0;
            }
            Log.i(TAG, "领取到 " + listCheck.size() + " 条待办任务");
            for (int i = 0; i < listCheck.size(); i++) {
                LogPullConfig logPullConfig = listCheck.get(i);
                Log.i(TAG, "待办任务[" + i + "] configId=" + logPullConfig.configId + " types=" + Arrays.toString(logPullConfig.logTypes) + " range=" + logPullConfig.logStartTime + "~" + logPullConfig.logEndTime);
            }
            for (LogPullConfig logPullConfig2 : listCheck) {
                if (!this.ackedOrActiveIds.contains(Long.valueOf(logPullConfig2.configId))) {
                    if (this.authStore.find(logPullConfig2.configId) != null) {
                        this.ackedOrActiveIds.add(Long.valueOf(logPullConfig2.configId));
                    } else if (logPullStatusReporter.reportStatus(logPullConfig2.configId, this.deviceOaid, 1, null)) {
                        this.ackedOrActiveIds.add(Long.valueOf(logPullConfig2.configId));
                        if (logPullConfig2.oaid == null || logPullConfig2.oaid.isEmpty()) {
                            logPullConfig2.oaid = this.deviceOaid;
                        }
                        this.authStore.enqueue(logPullConfig2);
                        Log.i(TAG, "已 ACK 并入待授权队列 configId=" + logPullConfig2.configId + " types=" + Arrays.toString(logPullConfig2.logTypes));
                    } else {
                        Log.w(TAG, "ACK 失败, configId=" + logPullConfig2.configId + "，下轮重试");
                    }
                }
            }
            maybeShowNextAuth();
            return 1;
        } catch (Exception e) {
            Log.e(TAG, "轮询失败", e);
            return -1;
        }
    }

    private void maybeShowNextAuth() {
        LogPullConfig logPullConfig = this.pendingAuthConfig;
        if (logPullConfig != null) {
            this.notification.showAuthPending(logPullConfig, this.deviceOaid);
            return;
        }
        if (new LogPullTaskStore(this.context).load() != null) {
            return;
        }
        List<LogPullConfig> listLoadAll = this.authStore.loadAll();
        if (listLoadAll.isEmpty()) {
            return;
        }
        LogPullConfig logPullConfig2 = listLoadAll.get(0);
        this.pendingAuthConfig = logPullConfig2;
        this.authStore.setShowing(logPullConfig2.configId);
        this.notification.showAuthPending(logPullConfig2, this.deviceOaid);
    }

    /* renamed from: com.stepos.pps.logpull.LogPullPoller$1, reason: invalid class name */
    class AnonymousClass1 extends BroadcastReceiver {
        AnonymousClass1() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            long longExtra = intent.getLongExtra("config_id", -1L);
            final String stringExtra = intent.getStringExtra("decision");
            if (stringExtra == null || stringExtra.isEmpty()) {
                Log.w(LogPullPoller.TAG, "授权结果缺少 decision, configId=" + longExtra);
                return;
            }
            Log.i(LogPullPoller.TAG, "收到授权结果: configId=" + longExtra + " decision=" + stringExtra);
            final LogPullConfig logPullConfigFind = LogPullPoller.this.pendingAuthConfig;
            if (logPullConfigFind == null || logPullConfigFind.configId != longExtra) {
                logPullConfigFind = LogPullPoller.this.authStore.find(longExtra);
            }
            if (logPullConfigFind == null) {
                Log.w(LogPullPoller.TAG, "授权结果无对应任务: configId=" + longExtra);
            } else {
                LogPullPoller.this.pendingAuthConfig = null;
                LogPullPoller.this.authStore.clearShowing();
                if (LogPullPoller.this.handler == null) {
                    return;
                }
                LogPullPoller.this.handler.post(new Runnable() { // from class: com.stepos.pps.logpull.LogPullPoller$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.lambda$onReceive$0(logPullConfigFind, stringExtra);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onReceive$0(LogPullConfig logPullConfig, String str) {
            LogPullPoller.this.handleAuthDecision(logPullConfig, str);
        }
    }

    private void registerAuthReceiver() {
        this.authReceiver = new AnonymousClass1();
        this.context.registerReceiver(this.authReceiver, new IntentFilter(LogPullAuthActivity.ACTION_AUTH_RESULT), 4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Finally extract failed */
    public void handleAuthDecision(LogPullConfig logPullConfig, String str) {
        LogPullManager.UploadChoice uploadChoice;
        LogPullStatusReporter logPullStatusReporter = new LogPullStatusReporter(this.context, new LogPullPoller$$ExternalSyntheticLambda1(this));
        long j = logPullConfig.configId;
        if (LogPullAuthActivity.DECISION_REJECT.equals(str)) {
            if (!logPullStatusReporter.reportStatus(j, this.deviceOaid, 2, "用户拒绝")) {
                Log.e(TAG, "用户拒绝状态上报失败, configId=" + j);
            }
            this.authStore.remove(j);
            this.ackedOrActiveIds.remove(Long.valueOf(j));
            this.notification.showAuthRejected(j);
            maybeShowNextAuth();
            return;
        }
        if ("idle".equals(str)) {
            uploadChoice = LogPullManager.UploadChoice.IDLE;
        } else {
            uploadChoice = LogPullManager.UploadChoice.NOW;
        }
        this.authStore.remove(j);
        this.notification.dismissAuth(j);
        try {
            this.manager.execute(logPullConfig, this.deviceOaid, uploadChoice);
            this.ackedOrActiveIds.remove(Long.valueOf(j));
        } catch (Throwable th) {
            this.ackedOrActiveIds.remove(Long.valueOf(j));
            throw th;
        }
    }

    private void unregisterAuthReceiver() {
        BroadcastReceiver broadcastReceiver = this.authReceiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
            this.authReceiver = null;
        }
    }

    private void registerUploadActionReceiver() {
        this.uploadActionReceiver = new BroadcastReceiver() { // from class: com.stepos.pps.logpull.LogPullPoller.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (action == null || LogPullPoller.this.manager == null) {
                    return;
                }
                if (LogPullUploadChoiceActivity.ACTION_UPLOAD_CHOICE.equals(action)) {
                    long longExtra = intent.getLongExtra("config_id", -1L);
                    String stringExtra = intent.getStringExtra("decision");
                    Log.i(LogPullPoller.TAG, "收到上传方式选择 configId=" + longExtra + " decision=" + stringExtra);
                    if (LogPullPoller.this.notification != null) {
                        LogPullPoller.this.notification.dismissChoice(longExtra);
                    }
                    if ("idle".equals(stringExtra)) {
                        LogPullPoller.this.manager.switchToIdle(longExtra);
                        return;
                    } else {
                        LogPullPoller.this.manager.triggerUploadNow(longExtra);
                        return;
                    }
                }
                if (LogPullNotification.ACTION_UPLOAD_NOW.equals(action)) {
                    long longExtra2 = intent.getLongExtra("config_id", -1L);
                    Log.i(LogPullPoller.TAG, "收到「立即上报」 configId=" + longExtra2);
                    LogPullPoller.this.manager.triggerUploadNow(longExtra2);
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(LogPullUploadChoiceActivity.ACTION_UPLOAD_CHOICE);
        intentFilter.addAction(LogPullNotification.ACTION_UPLOAD_NOW);
        this.context.registerReceiver(this.uploadActionReceiver, intentFilter, 4);
    }

    private void unregisterUploadActionReceiver() {
        BroadcastReceiver broadcastReceiver = this.uploadActionReceiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
            this.uploadActionReceiver = null;
        }
    }

    public void onDeadlineCheck() {
        LogPullManager logPullManager = this.manager;
        if (logPullManager != null) {
            logPullManager.failIfPastDeadline();
        }
    }

    public boolean isAuthPending(long j) {
        LogPullConfig logPullConfig = this.pendingAuthConfig;
        if (logPullConfig != null && logPullConfig.configId == j) {
            return true;
        }
        LogPullAuthStore logPullAuthStore = this.authStore;
        return (logPullAuthStore == null || logPullAuthStore.find(j) == null) ? false : true;
    }

    public void purgeAuthForConfig(final long j) {
        Runnable runnable = new Runnable() { // from class: com.stepos.pps.logpull.LogPullPoller$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.lambda$purgeAuthForConfig$3(j);
            }
        };
        Handler handler = this.handler;
        if (handler != null) {
            handler.post(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$purgeAuthForConfig$3(long j) {
        purgeAuthStateInternal(j);
        maybeShowNextAuth();
        Log.i(TAG, "服务端终态：已清理授权侧并推进队列 configId=" + j);
    }

    private void purgeAuthStateInternal(long j) {
        LogPullAuthStore logPullAuthStore = this.authStore;
        if (logPullAuthStore != null) {
            logPullAuthStore.remove(j);
        }
        LogPullConfig logPullConfig = this.pendingAuthConfig;
        if (logPullConfig != null && logPullConfig.configId == j) {
            this.pendingAuthConfig = null;
            LogPullAuthStore logPullAuthStore2 = this.authStore;
            if (logPullAuthStore2 != null) {
                logPullAuthStore2.clearShowing();
            }
        }
        this.ackedOrActiveIds.remove(Long.valueOf(j));
        LogPullNotification logPullNotification = this.notification;
        if (logPullNotification != null) {
            logPullNotification.dismissAuth(j);
        }
        LogPullAuthActivity.sendDismiss(this.context, j);
    }

    private int reconcileAuthDeadlines() {
        LogPullAuthStore logPullAuthStore = this.authStore;
        int i = 0;
        if (logPullAuthStore != null && this.manager != null) {
            for (LogPullConfig logPullConfig : logPullAuthStore.loadAll()) {
                if (this.manager.isConfigExpired(logPullConfig.deadlineTime)) {
                    Log.w(TAG, "待授权任务已过 deadline，端侧收口 configId=" + logPullConfig.configId + " deadline=" + logPullConfig.deadlineTime);
                    String str = this.deviceOaid;
                    if (str == null || str.isEmpty()) {
                        str = logPullConfig.oaid;
                    }
                    String str2 = str;
                    if (str2 == null || str2.isEmpty()) {
                        Log.w(TAG, "待授权过期无 oaid，仅本地收口 configId=" + logPullConfig.configId);
                    } else {
                        new LogPullStatusReporter(this.context, new LogPullPoller$$ExternalSyntheticLambda1(this)).reportStatus(logPullConfig.configId, str2, 7, "待授权阶段超过 deadline，端侧收口");
                    }
                    new LogPullDiskManager().cleanupTask(logPullConfig.configId);
                    purgeAuthStateInternal(logPullConfig.configId);
                    LogPullNotification logPullNotification = this.notification;
                    if (logPullNotification != null) {
                        logPullNotification.showFailed(logPullConfig.configId, "任务已过期，已取消本次日志拉取");
                    }
                    i++;
                }
            }
        }
        return i;
    }

    private static String hostOf(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }
        try {
            return new URL(str).getHost();
        } catch (Exception unused) {
            return "invalid";
        }
    }
}
