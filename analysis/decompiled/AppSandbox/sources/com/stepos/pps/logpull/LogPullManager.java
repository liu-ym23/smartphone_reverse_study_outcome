package com.stepos.pps.logpull;

import android.content.Context;
import android.os.SystemProperties;
import android.util.Log;
import com.stepos.logreport.sdk.LogPullQueryClient;
import com.stepos.pps.logpull.LogPullIdleStrategy;
import com.stepos.pps.logpull.LogPullNetworkResumeStrategy;
import com.stepos.pps.logpull.LogPullStatusReporter;
import com.stepos.pps.logpull.LogPullTaskStore;
import com.stepos.pps.logpull.LogPullUploader;
import com.stepos.pps.logpull.LogPullZipPacker;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import okhttp3.internal.ws.RealWebSocket;
import org.json.JSONException;

/* loaded from: classes.dex */
public class LogPullManager {
    private static final String CLOUD_TZ_DEFAULT = "Asia/Shanghai";
    private static final long DEFAULT_CHOICE_TIMEOUT_MS = 86400000;
    private static final long DEFAULT_MULTIPART_THRESHOLD_MB = 10;
    private static final long DEFAULT_PART_SIZE_MB = 10;
    private static final String FULLDUMP_NAME_PREFIX = "Fulldump";
    private static final String FULLDUMP_NAME_SUFFIX = ".tar.gz";
    private static final String FULLDUMP_SRC_DIR = "/sdcard/sysmonfulldump";
    private static final int MAX_PART_COUNT = 1024;
    private static final int MAX_TOTAL_UPLOAD_ROUNDS = 512;
    private static final int MAX_UPLOAD_ROUNDS = 3;
    private static final long MIN_PART_SIZE_BYTES = 5242880;
    private static final String PROP_CLOUD_TZ = "persist.sys.logpull.tz";
    private static final String PROP_MULTIPART_THRESHOLD_MB = "persist.sys.logpull.multipart_mb";
    private static final String PROP_PART_SIZE_MB = "persist.sys.logpull.partsize_mb";
    private static final String TAG = "LogPull.Manager";
    private static final long UPLOAD_HARD_TIMEOUT_MS = 7200000;
    private volatile AuthQueueCleaner authQueueCleaner;
    private volatile String cancelReason;
    private final Context context;
    private final LogPullDiskManager diskManager;
    private final LogPullIdleStrategy idleStrategy;
    private final LogPullNetworkResumeStrategy networkStrategy;
    private final LogPullNotification notification;
    private final LogPullStatusReporter reporter;
    private final LogPullTaskStore taskStore;
    private final LogPullUploader uploader;
    private final AtomicBoolean busy = new AtomicBoolean(false);
    private final AtomicBoolean uploading = new AtomicBoolean(false);
    private final ExecutorService uploadExecutor = Executors.newSingleThreadExecutor();
    private volatile boolean cancelled = false;
    private volatile int serverTerminalStatus = -1;

    public interface AuthQueueCleaner {
        void purgeAuth(long j);
    }

    public enum UploadChoice {
        NOW,
        IDLE
    }

    public void setAuthQueueCleaner(AuthQueueCleaner authQueueCleaner) {
        this.authQueueCleaner = authQueueCleaner;
    }

    public LogPullManager(Context context, Supplier<String> supplier) {
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        this.diskManager = new LogPullDiskManager();
        this.reporter = new LogPullStatusReporter(applicationContext, supplier);
        LogPullTaskStore logPullTaskStore = new LogPullTaskStore(applicationContext);
        this.taskStore = logPullTaskStore;
        this.uploader = new LogPullUploader(logPullTaskStore);
        this.idleStrategy = new LogPullIdleStrategy(applicationContext);
        this.networkStrategy = new LogPullNetworkResumeStrategy(applicationContext);
        this.notification = new LogPullNotification(applicationContext);
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v18, types: [com.stepos.pps.logpull.LogPullManager] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v28 */
    /* JADX WARN: Type inference failed for: r2v0, types: [com.stepos.pps.logpull.LogPullConfig] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v17, types: [long] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public void execute(LogPullConfig logPullConfig, String str, UploadChoice uploadChoice) throws Throwable {
        long j;
        File file;
        final long j2;
        ?? r1;
        LogPullManager logPullManager;
        LogPullManager logPullManager2 = this;
        final ?? r2 = logPullConfig;
        long j3 = r2.configId;
        LogPullTaskStore.PendingTask pendingTaskLoad = logPullManager2.taskStore.load();
        if (pendingTaskLoad != null && pendingTaskLoad.configId != j3 && (("upload".equals(pendingTaskLoad.phase) || "idle".equals(pendingTaskLoad.phase)) && !logPullManager2.isPastDeadline(pendingTaskLoad.deadlineTime))) {
            Log.e(TAG, "已有待上传任务 configId=" + pendingTaskLoad.configId + "，拒绝新任务 configId=" + j3);
            logPullManager2.reporter.reportStatus(j3, str, 3, "端侧已有任务待上传");
            logPullManager2.reporter.reportStatus(j3, str, 4, "端侧已有任务待上传，未能执行本任务");
            logPullManager2.notification.showFailed(j3, "端侧忙，稍后重试");
            logPullManager2.advanceAuthQueue(j3);
            return;
        }
        long j4 = j3;
        if (!logPullManager2.busy.compareAndSet(false, true)) {
            Log.e(TAG, "已有任务在执行，无法执行 configId=" + j4);
            logPullManager2.reporter.reportStatus(j4, str, 3, "端侧已有任务执行中");
            logPullManager2.reporter.reportStatus(j4, str, 4, "端侧已有任务执行中，未能执行本任务");
            logPullManager2.notification.showFailed(j4, "端侧忙，稍后重试");
            logPullManager2.advanceAuthQueue(j4);
            return;
        }
        logPullManager2.cancelled = false;
        logPullManager2.cancelReason = null;
        UploadChoice uploadChoice2 = uploadChoice != null ? uploadChoice : UploadChoice.NOW;
        String str2 = "/data/misc/pps/logpull/" + j4 + "/";
        String str3 = str2 + "logpull_" + j4 + ".zip";
        try {
            try {
            } catch (Exception e) {
                e = e;
            }
            try {
                if (logPullManager2.isPastDeadline(r2.deadlineTime)) {
                    logPullManager2.failAfterAcked(j4, str, "已过 deadlineTime", "任务已过期");
                    logPullManager2.busy.set(false);
                    return;
                }
                long j5 = j4;
                try {
                    logPullManager2.taskStore.save(LogPullTaskStore.newCollecting(logPullConfig, str));
                    UploadChoice uploadChoice3 = uploadChoice2;
                    if (!logPullManager2.diskManager.hasEnoughSpace(r2.maxLimit > 0 ? r2.maxLimit : 104857600L)) {
                        try {
                            logPullManager2.failAfterAcked(j5, str, "磁盘空间不足", "磁盘空间不足");
                            logPullManager2.busy.set(false);
                            return;
                        } catch (Exception e2) {
                            e = e2;
                            j5 = j5;
                            j = j5;
                            Log.e(TAG, "任务异常: configId=" + j, e);
                            logPullManager2.failAfterAcked(j, str, "异常: " + e.getMessage(), "任务异常");
                            logPullManager2.taskStore.clear();
                            logPullManager2.busy.set(false);
                        }
                    }
                    File file2 = new File(str2);
                    try {
                        if (!file2.exists() && !file2.mkdirs()) {
                            String str4 = "工作目录创建失败: " + str2;
                            Log.e(TAG, str4);
                            logPullManager2.failAfterAcked(j5, str, str4, "工作目录创建失败");
                            logPullManager2.busy.set(false);
                            return;
                        }
                        j = j5;
                        try {
                            long timeToMs = logPullManager2.parseTimeToMs(r2.logStartTime);
                            long timeToMs2 = logPullManager2.parseTimeToMs(r2.logEndTime);
                            boolean zContainsType = logPullManager2.containsType(r2.logTypes, "fulldump");
                            List<String> listResolveLogdTypes = LogPullCollector.resolveLogdTypes(r2.logTypes);
                            if (zContainsType) {
                                try {
                                    try {
                                        int iCountFulldumpFiles = countFulldumpFiles(FULLDUMP_SRC_DIR);
                                        File file3 = iCountFulldumpFiles > 0 ? new File(FULLDUMP_SRC_DIR) : null;
                                        Log.i(TAG, "fulldump 源扫描 configId=" + j + " dir=/sdcard/sysmonfulldump 匹配 Fulldump*.tar.gz=" + iCountFulldumpFiles);
                                        file = file3;
                                    } catch (Throwable th) {
                                        th = th;
                                        logPullManager2 = this;
                                        logPullManager2.busy.set(false);
                                        throw th;
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                    logPullManager2 = this;
                                    Log.e(TAG, "任务异常: configId=" + j, e);
                                    logPullManager2.failAfterAcked(j, str, "异常: " + e.getMessage(), "任务异常");
                                    logPullManager2.taskStore.clear();
                                    logPullManager2.busy.set(false);
                                }
                            } else {
                                file = null;
                            }
                            List arrayList = new ArrayList();
                            if (listResolveLogdTypes.isEmpty()) {
                                r1 = this;
                                j2 = j;
                                Log.i(TAG, "本任务不含 logd 流水类型，跳过时间窗查询 configId=" + j2 + " logTypes=" + Arrays.toString(r2.logTypes));
                            } else {
                                try {
                                    if (!LogPullQueryClient.isAvailable()) {
                                        Log.e(TAG, "daemon 不支持 LogPull 查询（logreportd_logpull 未注册），请确认 logreportd 与 PPS 版本匹配");
                                        failAfterAcked(j, str, "daemon 不支持 LogPull 查询（logreportd_logpull 未注册），请确认 logreportd 与 PPS 版本匹配", "采集服务不可用");
                                        this.busy.set(false);
                                        return;
                                    }
                                    LogPullManager logPullManager3 = this;
                                    try {
                                        LogPullQueryClient.QueryResult queryResultQuery = LogPullQueryClient.query(timeToMs, timeToMs2, listResolveLogdTypes);
                                        if (!queryResultQuery.isSuccess()) {
                                            String str5 = "时间窗查询失败: code=" + queryResultQuery.code;
                                            Log.e(TAG, str5);
                                            logPullManager3.failAfterAcked(j, str, str5, "采集失败");
                                            logPullManager3.busy.set(false);
                                            return;
                                        }
                                        j2 = j;
                                        List list = queryResultQuery.files;
                                        Log.i(TAG, "查询命中 configId=" + j2 + " types=" + listResolveLogdTypes + " files=" + queryResultQuery.files.size() + " bytes=" + queryResultQuery.totalBoundedBytes() + " spansReboot=" + queryResultQuery.spansReboot);
                                        arrayList = list;
                                        r1 = logPullManager3;
                                    } catch (Exception e4) {
                                        e = e4;
                                        logPullManager2 = logPullManager3;
                                        Log.e(TAG, "任务异常: configId=" + j, e);
                                        logPullManager2.failAfterAcked(j, str, "异常: " + e.getMessage(), "任务异常");
                                        logPullManager2.taskStore.clear();
                                        logPullManager2.busy.set(false);
                                    }
                                } catch (Exception e5) {
                                    e = e5;
                                    logPullManager2 = this;
                                }
                            }
                            if (arrayList.isEmpty() && file == null) {
                                r1.failAfterAcked(j2, str, "无匹配日志", "无匹配日志");
                                r1.busy.set(false);
                                return;
                            }
                            r1.notification.showPacking(j2, 0, arrayList.size());
                            try {
                                LogPullZipPacker.PackResult packResultPack = new LogPullZipPacker().pack(arrayList, file, str3, new LogPullZipPacker.Progress() { // from class: com.stepos.pps.logpull.LogPullManager.1
                                    @Override // com.stepos.pps.logpull.LogPullZipPacker.Progress
                                    public void onProgress(int i, int i2) {
                                        LogPullManager.this.notification.showPacking(j2, i, i2);
                                    }

                                    @Override // com.stepos.pps.logpull.LogPullZipPacker.Progress
                                    public boolean shouldContinue() {
                                        return (LogPullManager.this.cancelled || LogPullManager.this.isPastDeadline(r2.deadlineTime)) ? false : true;
                                    }
                                });
                                r1.notification.dismissPacking(j2);
                                if (!packResultPack.cancelled) {
                                    if (!packResultPack.success) {
                                        String str6 = "打包失败: " + packResultPack.error + " failedCount=" + packResultPack.failedCount;
                                        Log.e(TAG, str6);
                                        r1.failAfterAcked(j2, str, str6, packResultPack.failedCount > 0 ? "采集不完整" : "打包失败");
                                        r1.busy.set(false);
                                        return;
                                    }
                                    Log.i(TAG, "打包完成 configId=" + j2 + " zip=" + packResultPack.zipPath + " entries=" + packResultPack.entryCount + " size=" + packResultPack.sizeBytes);
                                    r1.onPackaged(r2, str, uploadChoice3, packResultPack.zipPath, packResultPack.sizeBytes, file != null);
                                    r1.busy.set(false);
                                    return;
                                }
                                if (r1.cancelled) {
                                    try {
                                        Log.i(TAG, "打包被用户停止 configId=" + j2);
                                        r2 = j2;
                                    } catch (Exception e6) {
                                        e = e6;
                                        r2 = j2;
                                    }
                                    try {
                                        r1.finishAbandoned(r2, str, 9, r1.mobileDeletedReason(), "拉取失败：" + r1.mobileDeletedReason());
                                        logPullManager = this;
                                    } catch (Exception e7) {
                                        e = e7;
                                        logPullManager2 = this;
                                        j = r2;
                                        Log.e(TAG, "任务异常: configId=" + j, e);
                                        logPullManager2.failAfterAcked(j, str, "异常: " + e.getMessage(), "任务异常");
                                        logPullManager2.taskStore.clear();
                                        logPullManager2.busy.set(false);
                                    }
                                } else {
                                    logPullManager = this;
                                    logPullManager.finishAbandoned(j2, str, 7, "打包期间已过 deadlineTime", "任务已过期");
                                }
                                logPullManager.busy.set(false);
                            } catch (Throwable th2) {
                                r1.notification.dismissPacking(j2);
                                throw th2;
                            }
                        } catch (Exception e8) {
                            e = e8;
                        }
                    } catch (Exception e9) {
                        e = e9;
                    }
                } catch (Exception e10) {
                    e = e10;
                }
            } catch (Exception e11) {
                e = e11;
                j4 = r2;
                j = j4;
                Log.e(TAG, "任务异常: configId=" + j, e);
                logPullManager2.failAfterAcked(j, str, "异常: " + e.getMessage(), "任务异常");
                logPullManager2.taskStore.clear();
                logPullManager2.busy.set(false);
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private void onPackaged(LogPullConfig logPullConfig, String str, UploadChoice uploadChoice, String str2, long j, boolean z) throws JSONException {
        int iDetectServerTerminalReject;
        long j2 = logPullConfig.configId;
        if (logPullConfig.maxLimit > 0 && j > logPullConfig.maxLimit) {
            failPackSizeExceeded(j2, str, j, logPullConfig.maxLimit);
            return;
        }
        LogPullStatusReporter.ReportResult reportResultReportStatusResult = this.reporter.reportStatusResult(j2, str, 3, "已打包完成");
        if (!reportResultReportStatusResult.ok && (iDetectServerTerminalReject = LogPullStatus.detectServerTerminalReject(reportResultReportStatusResult.message)) >= 0) {
            Log.w(TAG, "打包后报 TASK_BUILT 命中服务端终态，直接收口 configId=" + j2 + " status=" + iDetectServerTerminalReject + " msg=" + reportResultReportStatusResult.message);
            abandonLocallyNoReport(j2, iDetectServerTerminalReject);
            return;
        }
        String str3 = uploadChoice == UploadChoice.IDLE ? "idle" : "upload";
        Log.i(TAG, "打包完成 configId=" + j2 + " size=" + j + " → phase=" + str3 + " (授权选定 " + uploadChoice + ")");
        LogPullTaskStore.PendingTask pendingTaskNewPending = newPending(j2, str, str2, j, logPullConfig.deadlineTime, str3, z);
        this.taskStore.save(pendingTaskNewPending);
        armAndTryUpload(pendingTaskNewPending);
    }

    public boolean resumeIfNeeded() {
        LogPullTaskStore.PendingTask pendingTaskLoad = this.taskStore.load();
        if (pendingTaskLoad == null) {
            return false;
        }
        if (!this.busy.compareAndSet(false, true)) {
            Log.w(TAG, "resume 跳过：忙 configId=" + pendingTaskLoad.configId);
            return false;
        }
        this.cancelled = false;
        this.cancelReason = null;
        try {
            try {
                Log.i(TAG, "恢复待上报任务: configId=" + pendingTaskLoad.configId + " phase=" + pendingTaskLoad.phase + " zip=" + pendingTaskLoad.zipPath);
                if ("collecting".equals(pendingTaskLoad.phase)) {
                    Log.w(TAG, "恢复：上次采集/打包被中断 configId=" + pendingTaskLoad.configId);
                    failAfterAcked(pendingTaskLoad.configId, pendingTaskLoad.oaid, "采集/打包期间进程中断或设备重启", "拉取失败：采集被中断");
                } else if (pendingTaskLoad.zipPath == null || !new File(pendingTaskLoad.zipPath).isFile()) {
                    Log.e(TAG, "恢复失败：zip 不存在 " + pendingTaskLoad.zipPath);
                    finishAbandoned(pendingTaskLoad.configId, pendingTaskLoad.oaid, 9, mobileDeletedReason(), "拉取失败：" + mobileDeletedReason());
                } else if (isPastDeadline(pendingTaskLoad.deadlineTime)) {
                    this.reporter.reportStatus(pendingTaskLoad.configId, pendingTaskLoad.oaid, 7, "重启后已过 deadlineTime");
                    this.diskManager.cleanupTask(pendingTaskLoad.configId);
                    this.taskStore.clear();
                    this.notification.showFailed(pendingTaskLoad.configId, "任务已过期");
                } else {
                    if (pendingTaskLoad.sizeBytes <= 0) {
                        pendingTaskLoad.sizeBytes = new File(pendingTaskLoad.zipPath).length();
                    } else if (!isZipIntact(pendingTaskLoad.zipPath, pendingTaskLoad.sizeBytes)) {
                        String str = "恢复时包大小不一致 expect=" + pendingTaskLoad.sizeBytes + " actual=" + new File(pendingTaskLoad.zipPath).length();
                        Log.e(TAG, str);
                        finishAbandoned(pendingTaskLoad.configId, pendingTaskLoad.oaid, 4, str, "拉取失败：本地包异常");
                    }
                    if (pendingTaskLoad.fileName == null || pendingTaskLoad.fileName.isEmpty()) {
                        pendingTaskLoad.fileName = new File(pendingTaskLoad.zipPath).getName();
                    }
                    armAndTryUpload(pendingTaskLoad);
                }
            } catch (Exception e) {
                Log.e(TAG, "恢复任务异常: configId=" + pendingTaskLoad.configId, e);
                this.taskStore.clear();
                this.notification.showFailed(pendingTaskLoad.configId, "恢复任务异常");
            }
            return true;
        } finally {
            this.busy.set(false);
        }
    }

    private void armAndTryUpload(LogPullTaskStore.PendingTask pendingTask) {
        if (isPastDeadline(pendingTask.deadlineTime)) {
            failByDeadline(pendingTask, "arm 时已过 deadlineTime");
            return;
        }
        if (pendingTask.zipPath == null || !new File(pendingTask.zipPath).isFile()) {
            finishAbandoned(pendingTask.configId, pendingTask.oaid, 4, "本地包缺失 path=" + pendingTask.zipPath, "拉取失败：本地包异常");
            return;
        }
        scheduleDeadlineJob(pendingTask);
        if ("idle".equals(pendingTask.phase)) {
            armIdle(pendingTask);
        } else {
            armNetwork(pendingTask);
        }
    }

    private void armNetwork(LogPullTaskStore.PendingTask pendingTask) {
        final long j = pendingTask.configId;
        this.idleStrategy.stopMonitoring();
        this.networkStrategy.startMonitoring(new LogPullNetworkResumeStrategy.Callback() { // from class: com.stepos.pps.logpull.LogPullManager.2
            @Override // com.stepos.pps.logpull.LogPullNetworkResumeStrategy.Callback
            public void onWifiValidated() {
                LogPullManager.this.postAttempt();
            }

            @Override // com.stepos.pps.logpull.LogPullNetworkResumeStrategy.Callback
            public void onNonWifiValidated() {
                LogPullManager.this.notification.showCellularChoice(j);
            }

            @Override // com.stepos.pps.logpull.LogPullNetworkResumeStrategy.Callback
            public void onLost() {
                LogPullManager.this.notification.showWaitingNetwork(j);
            }
        });
        if (this.networkStrategy.hasValidatedWifi()) {
            Log.i(TAG, "NOW 当前已是 WiFi 有效网络，立即续传 configId=" + j);
            postAttempt();
            return;
        }
        if (this.networkStrategy.hasValidatedNonWifi()) {
            Log.i(TAG, "NOW 当前为非 WiFi 有效网络，弹窗询问 configId=" + j);
            this.notification.showCellularChoice(j);
            return;
        }
        Log.i(TAG, "NOW 当前无有效网络，挂等待续传通知 configId=" + j);
        this.notification.showWaitingNetwork(j);
    }

    private void armIdle(LogPullTaskStore.PendingTask pendingTask) {
        final long j = pendingTask.configId;
        this.networkStrategy.stopMonitoring();
        this.idleStrategy.startMonitoring(new LogPullIdleStrategy.IdleCallback() { // from class: com.stepos.pps.logpull.LogPullManager.3
            @Override // com.stepos.pps.logpull.LogPullIdleStrategy.IdleCallback
            public void onIdleConditionsMet() {
                LogPullManager.this.postAttempt();
            }

            @Override // com.stepos.pps.logpull.LogPullIdleStrategy.IdleCallback
            public void onIdleConditionsLost() {
                LogPullManager.this.notification.showIdleWaiting(j, LogPullManager.this.idleStrategy.isWifi(), LogPullManager.this.idleStrategy.isCharging(), LogPullManager.this.idleStrategy.isScreenOff());
            }
        });
        if (this.idleStrategy.isAllConditionsMet()) {
            Log.i(TAG, "IDLE 闲时条件已满足，立即续传 configId=" + j);
            postAttempt();
            return;
        }
        this.notification.showIdleWaiting(j, this.idleStrategy.isWifi(), this.idleStrategy.isCharging(), this.idleStrategy.isScreenOff());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postAttempt() {
        this.uploadExecutor.execute(new Runnable() { // from class: com.stepos.pps.logpull.LogPullManager$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                this.f$0.attemptUploadNow();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0038, code lost:
    
        if ("idle".equals(r13.phase) == false) goto L74;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void attemptUploadNow() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 493
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.logpull.LogPullManager.attemptUploadNow():void");
    }

    private void completeAndCleanup(long j, String str, String str2, long j2) throws JSONException {
        int iCompleteUpload;
        if (!isZipIntact(str2, j2)) {
            long length = new File(str2).isFile() ? new File(str2).length() : -1L;
            if (this.cancelled || length <= 0) {
                Log.e(TAG, "complete 前包缺失（用户删除或清理）actual=" + length);
                finishAbandoned(j, str, 9, mobileDeletedReason(), "拉取失败：" + mobileDeletedReason());
                return;
            }
            String str3 = "complete 前大小变化 expect=" + j2 + " actual=" + length;
            Log.e(TAG, str3);
            finishAbandoned(j, str, 4, str3, "拉取失败：本地包异常");
            return;
        }
        long length2 = new File(str2).length();
        LogPullUploader.UploadState uploadStateLoadState = this.uploader.loadState();
        String str4 = uploadStateLoadState != null ? uploadStateLoadState.objectKey : null;
        if (str4 == null) {
            Log.e(TAG, "缺少 objectKey，保留 pending 待续传 configId=" + j);
            this.notification.showFailed(j, "缺少 objectKey");
            return;
        }
        LogPullTaskStore.PendingTask pendingTaskLoad = this.taskStore.load();
        boolean z = pendingTaskLoad != null && pendingTaskLoad.configId == j && pendingTaskLoad.fulldump;
        if (uploadStateLoadState != null && uploadStateLoadState.isMultipart()) {
            iCompleteUpload = this.reporter.completeUpload(j, str, str4, length2, uploadStateLoadState.uploadId, uploadStateLoadState.toCompletedPartList());
        } else {
            iCompleteUpload = this.reporter.completeUpload(j, str, str4, length2);
        }
        clearTriggers();
        this.uploader.clearState();
        this.diskManager.cleanupTask(j);
        this.taskStore.clear();
        if (iCompleteUpload == 6) {
            if (z) {
                deleteFulldumpSources();
            }
            this.notification.showComplete(j);
            Log.i(TAG, "任务完成: configId=" + j);
        } else if (iCompleteUpload == 8) {
            this.notification.showFailed(j, "拉取失败：校验失败（size 不一致）");
            Log.w(TAG, "校验失败(size): configId=" + j);
        } else {
            this.notification.showFailed(j, "完成通知失败");
            Log.w(TAG, "complete 异常返回: " + iCompleteUpload);
        }
        advanceAuthQueue(j);
    }

    private void clearTriggers() {
        this.networkStrategy.stopMonitoring();
        this.idleStrategy.stopMonitoring();
        LogPullDeadlineJobService.cancel(this.context);
    }

    private void failByDeadline(LogPullTaskStore.PendingTask pendingTask, String str) {
        Log.w(TAG, "deadline 收口 configId=" + pendingTask.configId + " " + str);
        finishAbandoned(pendingTask.configId, pendingTask.oaid, 7, str, "上传超时");
    }

    private void scheduleDeadlineJob(LogPullTaskStore.PendingTask pendingTask) {
        long timeToMs = parseTimeToMs(pendingTask.deadlineTime);
        if (timeToMs <= 0) {
            timeToMs = System.currentTimeMillis() + 86400000;
        }
        LogPullDeadlineJobService.schedule(this.context, timeToMs);
    }

    public void switchToIdle(long j) {
        LogPullTaskStore.PendingTask pendingTaskLoad = this.taskStore.load();
        if (pendingTaskLoad == null || pendingTaskLoad.configId != j) {
            Log.w(TAG, "switchToIdle 无对应待传任务 configId=" + j);
            return;
        }
        Log.i(TAG, "用户选择闲时上传，转 IDLE configId=" + j);
        this.networkStrategy.stopMonitoring();
        this.taskStore.updatePhase("idle");
        pendingTaskLoad.phase = "idle";
        armIdle(pendingTaskLoad);
    }

    public void triggerUploadNow(long j) {
        LogPullTaskStore.PendingTask pendingTaskLoad = this.taskStore.load();
        if (pendingTaskLoad == null || pendingTaskLoad.configId != j) {
            Log.w(TAG, "triggerUploadNow 无对应待传任务 configId=" + j);
            return;
        }
        postAttempt();
    }

    public void failIfPastDeadline() {
        LogPullTaskStore.PendingTask pendingTaskLoad = this.taskStore.load();
        if (pendingTaskLoad == null) {
            LogPullDeadlineJobService.cancel(this.context);
            return;
        }
        boolean z = (pendingTaskLoad.deadlineTime == null || pendingTaskLoad.deadlineTime.isEmpty()) ? false : true;
        if (z && !isPastDeadline(pendingTaskLoad.deadlineTime)) {
            scheduleDeadlineJob(pendingTaskLoad);
        } else {
            failByDeadline(pendingTaskLoad, z ? "已过 deadlineTime" : "无 deadline 兜底超时");
        }
    }

    public void stopPacking(long j) {
        Log.i(TAG, "停止打包 configId=" + j);
        this.cancelled = true;
        this.notification.dismissPacking(j);
    }

    private LogPullTaskStore.PendingTask newPending(long j, String str, String str2, long j2, String str3, String str4, boolean z) {
        LogPullTaskStore.PendingTask pendingTask = new LogPullTaskStore.PendingTask();
        pendingTask.configId = j;
        pendingTask.oaid = str;
        pendingTask.zipPath = str2;
        pendingTask.sizeBytes = j2;
        pendingTask.deadlineTime = str3;
        pendingTask.fileName = new File(str2).getName();
        pendingTask.phase = str4;
        pendingTask.fulldump = z;
        return pendingTask;
    }

    private void failAfterAcked(long j, String str, String str2, String str3) {
        this.reporter.reportStatus(j, str, 3, "采集结束，准备上报失败原因");
        this.reporter.reportStatus(j, str, 4, str2);
        this.diskManager.cleanupTask(j);
        clearOwnTaskRecord(j);
        if (str3 != null) {
            this.notification.showFailed(j, str3);
        }
        advanceAuthQueue(j);
    }

    private void clearOwnTaskRecord(long j) {
        LogPullTaskStore.PendingTask pendingTaskLoad = this.taskStore.load();
        if (pendingTaskLoad == null || pendingTaskLoad.configId == j) {
            this.taskStore.clear();
            return;
        }
        Log.w(TAG, "保留他人待恢复记录: pending configId=" + pendingTaskLoad.configId + " 当前 configId=" + j);
    }

    private void failPackSizeExceeded(long j, String str, long j2, long j3) {
        long jBytesToCeilMb = bytesToCeilMb(j2);
        long jBytesToCeilMb2 = bytesToCeilMb(j3);
        String str2 = "打包大小超限: 当前 " + jBytesToCeilMb + " MB, 限制 " + jBytesToCeilMb2 + " MB (" + j2 + " > " + j3 + ")";
        Log.w(TAG, str2);
        this.reporter.reportStatus(j, str, 3, "已打包，校验大小上限 sizeMb=" + jBytesToCeilMb);
        LogPullStatusReporter.UploadUrlResult uploadUrlResultRequestUploadUrl = this.reporter.requestUploadUrl(j, str, j2);
        if (uploadUrlResultRequestUploadUrl != null && uploadUrlResultRequestUploadUrl.ok) {
            Log.w(TAG, "超限场景仍签发了 uploadUrl（异常），继续标 FETCH_FAILED objectKey=" + uploadUrlResultRequestUploadUrl.objectKey);
        } else {
            StringBuilder sb = new StringBuilder("upload/url 超限拒签: code=");
            sb.append(uploadUrlResultRequestUploadUrl != null ? uploadUrlResultRequestUploadUrl.code : -1);
            sb.append(" msg=");
            sb.append(uploadUrlResultRequestUploadUrl != null ? uploadUrlResultRequestUploadUrl.message : "null");
            Log.i(TAG, sb.toString());
        }
        this.reporter.reportStatus(j, str, 4, str2);
        this.diskManager.cleanupTask(j);
        this.taskStore.clear();
        this.notification.showFailed(j, "打包大小超出限制: " + jBytesToCeilMb + "MB > " + jBytesToCeilMb2 + "MB");
        advanceAuthQueue(j);
    }

    private static long bytesToCeilMb(long j) {
        if (j <= 0) {
            return 0L;
        }
        return Math.max(1L, (j + 1048575) / 1048576);
    }

    private void abandonLocallyNoReport(long j, int i) {
        Log.w(TAG, "服务端终态本地收口 configId=" + j + " status=" + i);
        clearTriggers();
        this.uploader.clearState();
        this.diskManager.cleanupTask(j);
        this.taskStore.clear();
        AuthQueueCleaner authQueueCleaner = this.authQueueCleaner;
        if (authQueueCleaner != null) {
            authQueueCleaner.purgeAuth(j);
        }
        this.notification.showFailed(j, LogPullStatus.terminalReason(i));
    }

    private void advanceAuthQueue(long j) {
        AuthQueueCleaner authQueueCleaner = this.authQueueCleaner;
        if (authQueueCleaner != null) {
            authQueueCleaner.purgeAuth(j);
        }
    }

    private void finishAbandoned(long j, String str, int i, String str2, String str3) {
        clearTriggers();
        this.reporter.reportStatus(j, str, i, str2);
        this.uploader.clearState();
        this.diskManager.cleanupTask(j);
        this.taskStore.clear();
        if (str3 != null) {
            this.notification.showFailed(j, str3);
        } else if (i == 9) {
            this.notification.dismissAllFor(j);
        }
        advanceAuthQueue(j);
    }

    public void abandonAsUserDeleted(long j, String str) {
        abandonWithReason(j, str, LogPullUserDeleteReceiver.REASON_USER_DELETED_LOGS);
    }

    public void abandonWithReason(long j, String str, String str2) {
        Log.i(TAG, "abandonWithReason configId=" + j + " reason=" + str2);
        this.cancelReason = str2;
        this.cancelled = true;
        if (this.busy.get() || this.uploading.get()) {
            Log.i(TAG, "任务进行中，已置 cancelled，等待主流程收尾 configId=" + j);
            return;
        }
        LogPullTaskStore.PendingTask pendingTaskLoad = this.taskStore.load();
        if ((str == null || str.isEmpty()) && pendingTaskLoad != null && pendingTaskLoad.configId == j) {
            str = pendingTaskLoad.oaid;
        }
        String str3 = str;
        if (str3 != null && !str3.isEmpty()) {
            finishAbandoned(j, str3, 9, str2, "拉取失败：" + str2);
            return;
        }
        this.uploader.clearState();
        this.diskManager.cleanupTask(j);
        this.taskStore.clear();
        this.notification.showFailed(j, "拉取失败：" + str2);
        Log.w(TAG, "abandon 无 oaid，仅本地清理 configId=" + j);
    }

    public void requestCancelForGateClose() {
        this.cancelReason = LogCollectionGate.REASON_GATE_CLOSED;
        this.cancelled = true;
    }

    private String mobileDeletedReason() {
        if (this.cancelReason != null) {
            return this.cancelReason;
        }
        return LogPullUserDeleteReceiver.REASON_USER_DELETED_LOGS;
    }

    private static boolean isZipIntact(String str, long j) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        File file = new File(str);
        if (!file.isFile()) {
            return false;
        }
        long length = file.length();
        if (length <= 0) {
            return false;
        }
        return j <= 0 || length == j;
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x01bd, code lost:
    
        return r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x023d, code lost:
    
        android.util.Log.w(r7, "上传放弃 configId=" + r1 + " rounds=" + r9 + " 连续无进展=" + r3 + " doneParts=" + r4.completedParts.size());
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0270, code lost:
    
        return r17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v31, types: [int] */
    /* JADX WARN: Type inference failed for: r3v32 */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean uploadWithUrlRefresh(long r25, java.lang.String r27, java.lang.String r28, long r29, final java.lang.String r31) throws org.json.JSONException, java.lang.InterruptedException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.pps.logpull.LogPullManager.uploadWithUrlRefresh(long, java.lang.String, java.lang.String, long, java.lang.String):boolean");
    }

    private LogPullUploader.UploadState restoreOrNewState(long j, String str, String str2, long j2, boolean z) {
        String str3;
        LogPullUploader.UploadState uploadStateLoadState = this.uploader.loadState();
        if (uploadStateLoadState != null) {
            if (z && uploadStateLoadState.configId == j && str2.equals(uploadStateLoadState.filePath) && uploadStateLoadState.totalSize == j2 && uploadStateLoadState.isMultipart() && uploadStateLoadState.partSize > 0 && uploadStateLoadState.uploadId != null && !uploadStateLoadState.uploadId.isEmpty() && uploadStateLoadState.objectKey != null && !uploadStateLoadState.objectKey.isEmpty() && !uploadStateLoadState.completedParts.isEmpty()) {
                Log.i(TAG, "续传：复用已完成分片 configId=" + j + " parts=" + uploadStateLoadState.completedParts.size() + "/" + uploadStateLoadState.totalParts() + " partSize=" + uploadStateLoadState.partSize + " uploadId=" + uploadStateLoadState.uploadId);
                uploadStateLoadState.oaid = str;
                return uploadStateLoadState;
            }
            Log.i(TAG, "上次上传进度不可复用，丢弃后重新开始 configId=" + j);
            this.uploader.clearState();
        }
        LogPullUploader.UploadState uploadState = new LogPullUploader.UploadState();
        uploadState.configId = j;
        uploadState.oaid = str;
        uploadState.filePath = str2;
        uploadState.totalSize = j2;
        if (z) {
            str3 = LogPullStatusReporter.UPLOAD_TYPE_MULTIPART;
        } else {
            str3 = LogPullStatusReporter.UPLOAD_TYPE_NORMAL;
        }
        uploadState.uploadType = str3;
        uploadState.partSize = z ? resolvePartSize(j2) : 0L;
        return uploadState;
    }

    private static boolean pinPartSize(LogPullUploader.UploadState uploadState, long j) {
        if (j > 0 && j != uploadState.partSize) {
            if (!uploadState.completedParts.isEmpty()) {
                return false;
            }
            uploadState.partSize = j;
        }
        return true;
    }

    private static long resolveMultipartThreshold() {
        long longProp = getLongProp(PROP_MULTIPART_THRESHOLD_MB, 10L);
        return (longProp > 0 ? longProp : 10L) * 1048576;
    }

    private static long resolvePartSize(long j) {
        long longProp = getLongProp(PROP_PART_SIZE_MB, 10L);
        long jMax = Math.max((longProp > 0 ? longProp : 10L) * 1048576, MIN_PART_SIZE_BYTES);
        long j2 = (1023 + j) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        if (j2 <= jMax) {
            return jMax;
        }
        long j3 = ((j2 + 1048575) / 1048576) * 1048576;
        Log.w(TAG, "片数将超服务端上限(1024)，partSize 自适应放大 " + jMax + " -> " + j3 + " (size=" + j + ")");
        return j3;
    }

    private static long getLongProp(String str, long j) {
        try {
            String str2 = SystemProperties.get(str, "");
            if (str2 != null && !str2.isEmpty()) {
                return Long.parseLong(str2.trim());
            }
        } catch (Exception unused) {
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isPastDeadline(String str) {
        if (str != null && !str.isEmpty()) {
            long timeToMs = parseTimeToMs(str);
            if (timeToMs > 0 && System.currentTimeMillis() > timeToMs) {
                return true;
            }
        }
        return false;
    }

    public boolean isConfigExpired(String str) {
        return isPastDeadline(str);
    }

    private boolean containsType(String[] strArr, String str) {
        if (strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private long parseTimeToMs(String str) {
        Date date;
        Date date2;
        if (str != null && !str.isEmpty()) {
            String[] strArr = {"yyyy-MM-dd'T'HH:mm:ssXXX", "yyyy-MM-dd'T'HH:mm:ss.SSSXXX"};
            for (int i = 0; i < 2; i++) {
                try {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(strArr[i], Locale.US);
                    simpleDateFormat.setLenient(false);
                    date2 = simpleDateFormat.parse(str);
                } catch (Exception unused) {
                }
                if (date2 != null) {
                    return date2.getTime();
                }
                continue;
            }
            TimeZone timeZoneResolveCloudTimeZone = resolveCloudTimeZone();
            String[] strArr2 = {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ss.SSS", "yyyy-MM-dd"};
            for (int i2 = 0; i2 < 4; i2++) {
                try {
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(strArr2[i2], Locale.US);
                    simpleDateFormat2.setTimeZone(timeZoneResolveCloudTimeZone);
                    date = simpleDateFormat2.parse(str);
                } catch (Exception unused2) {
                }
                if (date != null) {
                    return date.getTime();
                }
                continue;
            }
            Log.w(TAG, "无法解析时间字符串: " + str);
        }
        return 0L;
    }

    private static TimeZone resolveCloudTimeZone() {
        String str;
        try {
            str = SystemProperties.get(PROP_CLOUD_TZ, "");
        } catch (Exception unused) {
            str = null;
        }
        if (str == null || str.isEmpty()) {
            return TimeZone.getTimeZone(CLOUD_TZ_DEFAULT);
        }
        if ("device".equalsIgnoreCase(str)) {
            return TimeZone.getDefault();
        }
        TimeZone timeZone = TimeZone.getTimeZone(str);
        if (!"GMT".equals(timeZone.getID()) || str.startsWith("GMT") || "UTC".equalsIgnoreCase(str)) {
            return timeZone;
        }
        Log.w(TAG, "非法时区属性 persist.sys.logpull.tz=" + str + "，回退 Asia/Shanghai");
        return TimeZone.getTimeZone(CLOUD_TZ_DEFAULT);
    }

    private static int countFulldumpFiles(String str) {
        File[] fileArrListFiles = new File(str).listFiles();
        if (fileArrListFiles == null) {
            return 0;
        }
        int i = 0;
        for (File file : fileArrListFiles) {
            if (file.isFile() && isFulldumpFile(file.getName())) {
                i++;
            }
        }
        return i;
    }

    private static boolean isFulldumpFile(String str) {
        return str.startsWith(FULLDUMP_NAME_PREFIX) && str.endsWith(FULLDUMP_NAME_SUFFIX);
    }

    private static void deleteFulldumpSources() {
        File[] fileArrListFiles = new File(FULLDUMP_SRC_DIR).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        int i = 0;
        for (File file : fileArrListFiles) {
            if (file.isFile() && isFulldumpFile(file.getName()) && file.delete()) {
                i++;
            }
        }
        if (i > 0) {
            Log.i(TAG, "已回收 fulldump 源文件 " + i + " 个 @ /sdcard/sysmonfulldump");
        }
    }
}
