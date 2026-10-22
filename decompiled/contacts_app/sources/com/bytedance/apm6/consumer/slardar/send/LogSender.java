package com.bytedance.apm6.consumer.slardar.send;

import com.android.contacts.util.HanziToPinyin;
import com.bytedance.apm.doctor.DoctorDataUtil;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.persistent.LogFile;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.common.utility.NetworkUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class LogSender implements WeedOutStrategy {
    private static final int DEFAULT_SEND_LOG_INTERVAL = 30000;
    private static final int MAX_COUNT = 10;
    private static final long MAX_SEND_LOG_INTERVAL = 120000;
    private static final String TYPE_WEED_OUT = "second_log_dir";
    private AsyncTask asyncTask;
    private LinkedHashMap<UploadLogInfo, ConcurrentLinkedQueue<LogModel>> cacheLog;
    private volatile boolean isPaused;
    private long lastSendTime;
    private long retryCount;
    private long retryPollingInterval;

    private static class InnerHolder {
        private static final LogSender instance = null;

        private InnerHolder() {
        }

        static /* synthetic */ LogSender access$000() {
            return instance;
        }

        static {
            instance = new LogSender(null);
        }
    }

    private static final class LogModel {
        byte[] bytes;
        long nextSendTime;
        int retryCount;

        LogModel(byte[] r1, int r2, long r3) {
            this.bytes = r1;
            this.retryCount = r2;
            this.nextSendTime = r3;
        }
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public String getName() {
        return TYPE_WEED_OUT;
    }

    /* synthetic */ LogSender(AnonymousClass1 r1) {
        this();
    }

    static /* synthetic */ long access$100(LogSender r2) {
        return r2.lastSendTime;
    }

    static /* synthetic */ long access$102(LogSender r0, long r1) {
        r0.lastSendTime = r1;
        return r1;
    }

    static /* synthetic */ long access$200(LogSender r2) {
        return r2.retryPollingInterval;
    }

    static /* synthetic */ boolean access$300(LogSender r0) {
        return r0.isPaused;
    }

    static /* synthetic */ void access$400(LogSender r0) {
        r0.send();
    }

    private LogSender() {
        this.cacheLog = new LinkedHashMap();
        this.retryPollingInterval = 30000;
        this.lastSendTime = 0;
        this.retryCount = 1;
        this.isPaused = false;
    }

    public static LogSender getInstance() {
        return InnerHolder.access$000();
    }

    public void init() {
        final long r2 = 0;
        final long r4 = 30000;
        this.asyncTask = new AnonymousClass1(this, r2, r4);
        AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).sendTask(this.asyncTask);
    }

    public void sendLog(List<LogFile> r19, int r20) {
    L62:
        th = move-exception;
        Logger.e(Constants.TAG, "sendLog", th);
        return;
    L4:
        if (LogReportController.getInstance().isStopCollect() == true) goto L6;
        Map<UploadLogInfo, byte[]> r1 = UploadLogManager.serialize(r19, r20);     // Catch: Throwable -> L62
        if (r1 != null) goto L18;
        deleteFiles(r19);     // Catch: Throwable -> L62
        return;
    L18:
        boolean r2 = NetworkUtils.isNetworkAvailable(ApmContext.getContext());     // Catch: Throwable -> L62
        Iterator<UploadLogInfo> r3 = r1.keySet().iterator();     // Catch: Throwable -> L62
        boolean r5 = false;
    L20:
        if (r3.hasNext() == false) goto L58;
        UploadLogInfo r6 = r3.next();     // Catch: Throwable -> L62
        byte[] r7 = r1.get(r6);     // Catch: Throwable -> L62
        if (r7 == null) goto L20;
        if (LogReportController.getInstance().isReportLogEnable() == false) goto L36;
        if (r2 == false) goto L36;
        if (ApmContext.isDebugMode() == false) goto L30;
        DoctorDataUtil.sendBeginEvent(r7);     // Catch: Throwable -> L62
    L30:
        boolean r8 = NetworkSender.getInstance(r6).sendLog(r7);     // Catch: Throwable -> L62
        if (ApmContext.isDebugMode() == false) goto L35;
        if (r8 == false) goto L34;
        DoctorDataUtil.sendSuccessEvent(r7);     // Catch: Throwable -> L62
        goto L35
    L34:
        DoctorDataUtil.sendFailEvent(r7);     // Catch: Throwable -> L62
    L35:
        this.lastSendTime = System.currentTimeMillis();     // Catch: Throwable -> L62
        r5 = r5 | r8;     // Catch: Throwable -> L62
        int r14 = 1;
    L38:
        if (ApmContext.isDebugMode() == false) goto L40;
        Logger.d(Constants.TAG, "sendDirect:isReportLogEnable " + LogReportController.getInstance().isReportLogEnable() + " :sendResult " + r8);     // Catch: Throwable -> L62
    L40:
        if (r8 == true) goto L56;
        long r12 = LogReportController.getInstance().getRetryInterval(r14);     // Catch: Throwable -> L62
        long r10 = System.currentTimeMillis() + r12;     // Catch: Throwable -> L62
        if (ApmContext.isMainProcess() == false) goto L44;
        long r16 = r10;
        r8 = DiskFileHelper.getInstance().saveFile(r7, r6.getName(), r14, r16);     // Catch: Throwable -> L62
    L46:
        if (ApmContext.isDebugMode() == false) goto L48;
        Logger.d(Constants.TAG, "saveFile:Result:" + r8 + ":isMaiProcess:" + ApmContext.isMainProcess() + " :" + r14 + HanziToPinyin.Token.SEPARATOR + r12);     // Catch: Throwable -> L62
    L48:
        if (r8 == false) goto L50;
    L57:
        r5 = r5;
        goto L20
    L50:
        if (this.cacheLog.containsKey(r6) == false) goto L52;
        ConcurrentLinkedQueue<LogModel> r4 = this.cacheLog.get(r6);     // Catch: Throwable -> L62
    L54:
        if (r4.size() <= 10) goto L57;
        r4.poll();     // Catch: Throwable -> L62
        goto L57
    L52:
        r4 = new ConcurrentLinkedQueue();     // Catch: Throwable -> L62
        r4.add(new LogModel(r7, r14, r16));     // Catch: Throwable -> L62
        goto L54
    L44:
        r16 = r10;
        goto L46
    L56:
        r5 = r5;
    L36:
        r8 = false;
        r14 = 0;
        goto L38
    L58:
        if (r5 == false) goto L60;
        reset();     // Catch: Throwable -> L62
    L60:
        deleteFiles(r19);     // Catch: Throwable -> L62
        return;
    L6:
        if (ApmContext.isDebugMode() == false) goto L8;
        Logger.d(Constants.TAG, "stop collect log");     // Catch: Throwable -> L62
    L8:
        Iterator<LogFile> r9 = r19.iterator();     // Catch: Throwable -> L62
        long r11 = 0;
        long r13 = 0;
    L10:
        if (r9.hasNext() == false) goto L12;
        LogFile r15 = r9.next();     // Catch: Throwable -> L62
        r11 = r11 + ((long) r15.getTotalCount());     // Catch: Throwable -> L62
        r13 = r13 + ((long) r15.getTotalBytes());     // Catch: Throwable -> L62
        goto L10
    L12:
        DropDataMonitor.getInstance().monitorDropLog(r11, r13, System.currentTimeMillis(), DropDataMonitor.Reason.SERVER_DROP);     // Catch: Throwable -> L62
        deleteFiles(r19);     // Catch: Throwable -> L62
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOut(long r6) {
        File[] r5 = DiskFileHelper.getInstance().listFiles();
        if (r5 != null) goto L5;
        return;
    L5:
        int r0 = r5.length;
        int r1 = 0;
    L6:
        if (r1 >= r0) goto L11;
        File r2 = r5[r1];
        if (DiskFileHelper.getCreateTime(r2) > r6) goto L10;
        FileUtils.deleteFile(r2);
    L10:
        r1 = r1 + 1;
        goto L6
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOutSize(long r10) {
        File[] r0 = DiskFileHelper.getInstance().listFiles();
        if (r0 != null) goto L5;
        return;
    L5:
        Arrays.sort(r0, new AnonymousClass2(this));
        int r9 = r0.length;
        int r1 = 0;
        long r2 = 0;
        int r4 = 0;
        long r5 = 0;
    L6:
        if (r4 >= r9) goto L13;
        File r7 = r0[r4];
        if (r7.exists() == false) goto L12;
        if (r7.isFile() == false) goto L12;
        r5 = r5 + r7.length();
    L12:
        r4 = r4 + 1;
        goto L6
    L13:
        int r11 = r0.length;
    L14:
        if (r1 >= r11) goto L36;
        File r6 = r0[r1];
        if ((r5 - r2) <= r10) goto L25;
        if (r6.exists() == false) goto L24;
        if (r6.isFile() == false) goto L24;
        long r8 = r6.length();
        if (FileUtils.deleteFileWithResult(r6) == false) goto L24;
        r2 = r2 + r8;
    L24:
        r1 = r1 + 1;
        goto L14
    L25:
        return;
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public long getSize() {
        File[] r6 = DiskFileHelper.getInstance().listFiles();
        long r0 = 0;
        if (r6 != null) goto L5;
        return 0;
    L5:
        int r2 = r6.length;
        int r3 = 0;
    L6:
        if (r3 >= r2) goto L8;
        r0 = r0 + r6[r3].length();
        r3 = r3 + 1;
        goto L6
    L8:
        return r0;
    }

    public void pause() {
        this.isPaused = true;
    }

    public void resume() {
        this.isPaused = false;
    }

    private void send() {
        if (NetworkUtils.isNetworkAvailable(ApmContext.getContext()) == true) goto L5;
        return;
    L5:
        if (LogReportController.getInstance().isReportLogEnable() == false) goto L21;
        if (ApmContext.isDebugMode() == false) goto L9;
        Logger.d(Constants.TAG, "trigger send.");
    L9:
        boolean r0 = sendMemory();
        if (ApmContext.isMainProcess() == false) goto L12;
        r0 = sendFile();
    L12:
        if (r0 == false) goto L15;
        reset();
        goto L21
    L15:
        if (this.retryPollingInterval >= 120000) goto L18;
        long r1 = this.retryCount;
        this.retryPollingInterval = (r1 + 1) * 30000;
        this.retryCount = r1 + 1;
    L18:
        if (this.retryPollingInterval <= 120000) goto L21;
        this.retryPollingInterval = 120000;
    L21:
        if (ApmContext.isDebugMode() == true) goto L23;
        return;
    L23:
        if (LogReportController.getInstance().isReportLogEnable() == true) goto L28;
        Logger.d(Constants.TAG, "report log disable");
        return;
    }

    private boolean sendMemory() {
        if (this.cacheLog.isEmpty() == false) goto L5;
        return true;
    L5:
        Iterator<UploadLogInfo> r0 = this.cacheLog.keySet().iterator();
        boolean r2 = true;
    L7:
        if (r0.hasNext() == false) goto L35;
        UploadLogInfo r3 = r0.next();
        ConcurrentLinkedQueue<LogModel> r4 = this.cacheLog.get(r3);
        if (r4 == null) goto L7;
        LogModel[] r6 = (LogModel[]) r4.toArray(new LogModel[0]);
        int r7 = r6.length;
        int r8 = 0;
    L12:
        if (r8 >= r7) goto L19;
        LogModel r9 = r6[r8];
        if (r9.retryCount <= 0) goto L20;
        if ((System.currentTimeMillis() - r9.nextSendTime) > 0) goto L20;
        r8 = r8 + 1;
    L20:
        if (r9 == null) goto L22;
    L24:
        if (r9 == null) goto L7;
        if (ApmContext.isDebugMode() == false) goto L29;
        Logger.d(Constants.TAG, "sendMemory");
    L29:
        boolean r5 = NetworkSender.getInstance(r3).sendLog(r9.bytes);
        if (r5 == false) goto L32;
        r4.remove(r9);
    L33:
        if (r5 == true) goto L7;
        r2 = false;
        goto L7
    L32:
        r9.retryCount++;
        r9.nextSendTime = LogReportController.getInstance().getRetryInterval(r9.retryCount) + System.currentTimeMillis();
        goto L33
    L22:
        if (r4.size() <= 0) goto L24;
        r9 = r4.peek();
        goto L24
    L19:
        r9 = null;
        goto L20
    L35:
        return r2;
    }

    private boolean sendFile() {
        Iterator<UploadLogInfo> r9 = UploadLogManager.getUploadType().iterator();
        boolean r1 = true;
    L4:
        if (r9.hasNext() == false) goto L24;
        UploadLogInfo r2 = r9.next();
        File r3 = DiskFileHelper.getInstance().getSendFile(r2.getName());
        if (r3 == null) goto L4;
        if (r3.exists() == false) goto L4;
        if (NetworkSender.getInstance(r2).sendLog(FileUtils.readFileToByteArray(r3)) == true) goto L13;
        DiskFileHelper.RetryMessage r4 = DiskFileHelper.getInstance().getReportMessage(r3);
        if (r4 == null) goto L19;
        int r5 = r4.getRetryCount() + 1;
    L20:
        long r6 = LogReportController.getInstance().getRetryInterval(r5) + System.currentTimeMillis();
        DiskFileHelper.getInstance().updateRetryMessage(r3, r5, r6);
        if (ApmContext.isDebugMode() == false) goto L23;
        Logger.d(Constants.TAG, "sendfile error retry count:" + r3.getName() + "  " + r5 + " nextRetryTime:" + r6);
    L23:
        r1 = false;
        goto L4
    L19:
        r5 = 0;
        goto L20
    L13:
        if (ApmContext.isDebugMode() == false) goto L15;
        Logger.d(Constants.TAG, "sendFile: success");
    L15:
        DiskFileHelper.getInstance().deleteLog(r3);
        goto L4
    L24:
        return r1;
    }

    private void reset() {
        this.retryCount = 1;
        this.retryPollingInterval = 30000;
    }

    private void deleteFiles(List<LogFile> r4) {
        Iterator<LogFile> r3 = r4.iterator();
    L4:
        if (r3.hasNext() == false) goto L11;
        LogFile r5 = r3.next();
    L10:
        Logger.w(Constants.TAG, "delete LogFile's source File failed. logFile=" + r5.getSource());
        goto L4
    L7:
        if (r5.getSource() == null) goto L4;
        FileUtils.deleteFile(r5.getSource());     // Catch: Exception -> L10
        goto L4
    }
}
