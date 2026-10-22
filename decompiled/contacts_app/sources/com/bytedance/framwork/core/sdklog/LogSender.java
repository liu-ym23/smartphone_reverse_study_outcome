package com.bytedance.framwork.core.sdklog;

import android.content.Context;
import android.database.sqlite.SQLiteFullException;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
final class LogSender extends Thread {
    private static final long CLEAN_LOG_INTERVAL = 600000;
    private static final long DEFAULT_SCAN_LOG_INTERVAL = 120000;
    static final String KEY_MAGIC_TAG = "magic_tag";
    static final String KEY_MESSAGE = "message";
    static final String MAGIC_TAG = "log_queue";
    private static final long MAX_EXPIRE_TIME = 864000000;
    static final String STATUS_OK = "success";
    private static final String TAG = "LogSender";
    private int mChannelPosition;
    private final Context mContext;
    private final LogQueueManager mDbHelper;
    private long mLastCleanTime;
    private final Object mLock;
    private LogQueue mLogQueue;
    private long mMinLog;
    private final LinkedList<LogItem> mPendingQueue;
    private long mScanLogInterval;
    private final AtomicBoolean mStopFlag;

    LogSender(Context r3, LogQueue r4, LinkedList<LogItem> r5, AtomicBoolean r6) {
        super(TAG);
        this.mLock = new Object();
        this.mMinLog = -1;
        this.mLastCleanTime = 0;
        this.mScanLogInterval = 120000;
        this.mLogQueue = r4;
        this.mContext = r3;
        this.mPendingQueue = r5;
        this.mStopFlag = r6;
        this.mDbHelper = LogQueueManager.getInstance(r3);
    }

    private void cleanLog() {
        if (isStop() == false) goto L5;
        return;
    L5:
        Map<String, LogHandler> r0 = this.mLogQueue.getAllLogHandler();
        if (r0 != null) goto L8;
    L22:
        this.mDbHelper.cleanExpireLog(null, -1, MAX_EXPIRE_TIME);
        return;
    L8:
        if (r0.isEmpty() == true) goto L22;
        Iterator<String> r1 = r0.keySet().iterator();
    L11:
        if (r1.hasNext() == false) goto L22;
        String r2 = r1.next();
        if (isStop() == true) goto L22;
        LogHandler r3 = r0.get(r2);
        if (r3 == null) goto L11;
        LogHandler.IConfig r4 = r3.getConfig();
        if (r4 == null) goto L11;
        this.mDbHelper.cleanExpireLog(r2, r4.getMaxRetryCount(), r4.getLogExpireTime());
        goto L11
    }

    private boolean processPendingQueue() {
        boolean r1 = false;
        if (isStop() == false) goto L5;
        return false;
    L5:
        LinkedList<LogItem> r0 = this.mPendingQueue;
        monitor-enter(r0);
    L26:
        th = move-exception;
        throw th;
    L8:
        if (isStop() == false) goto L12;
        monitor-exit(r0);     // Catch: Throwable -> L26
        return false;
    L12:
        if (this.mPendingQueue.isEmpty() == true) goto L14;
        LogItem r2 = this.mPendingQueue.poll();     // Catch: Throwable -> L26
    L16:
        if (this.mPendingQueue.isEmpty() == true) goto L18;
        r1 = true;
    L18:
        monitor-exit(r0);     // Catch: Throwable -> L26
        if (r2 != null) goto L30;
    L25:
        return r1;
    L30:
    L24:
        this.mDbHelper.recreateTableQueue();
        goto L25
    L21:
        if (this.mDbHelper.insertLog(r2.type, r2.value) < Long.MAX_VALUE) goto L25;
        this.mDbHelper.recreateTableQueue();     // Catch: SQLiteFullException -> L24
        goto L25
    L14:
        r2 = null;
        goto L16
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v38 */
    /* JADX WARN: Type inference failed for: r20v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r24v0, types: [com.bytedance.framwork.core.sdklog.LogSender] */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.framwork.core.sdklog.LogQueueManager] */
    /* JADX WARN: Type inference failed for: r3v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v21 */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference failed for: r3v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r3v5, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [com.bytedance.framwork.core.sdklog.LogHandler] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private boolean scanAndSendLog() {
        boolean r2 = false;
        if (isStop() == false) goto L6;
        return false;
    L6:
        if (this.mMinLog >= 0) goto L11;
        if ((System.currentTimeMillis() - this.mLastCleanTime) <= 600000) goto L11;
        this.mMinLog = 0;
        cleanLog();
        this.mLastCleanTime = System.currentTimeMillis();
    L11:
        if (LogLib.isNetworkAvailable(this.mContext) == true) goto L14;
        this.mScanLogInterval = 120000;
        return false;
    L14:
        LogItem r7 = this.mDbHelper.getLog(this.mMinLog);
        LogHandler.IConfig r0 = null;
        if (r7 != null) goto L28;
        if (this.mMinLog != 0) goto L23;
        if (this.mDbHelper.getEventCount(null) != 0) goto L23;
        this.mScanLogInterval = 0;
        return false;
    L23:
        if (this.mMinLog != (-1)) goto L25;
        this.mScanLogInterval = 120000;
    L25:
        this.mMinLog = -1;
        return false;
    L28:
        if (this.mMinLog >= r7.id) goto L30;
        this.mMinLog = r7.id;
    L32:
        if (r7.value != null) goto L34;
    L89:
        ?? r8 = 0;
        ?? r3 = 0;
        r2 = true;
    L91:
        if (isStop() == false) goto L93;
        return true;
    L93:
        if (r2 == false) goto L96;
        this.mDbHelper.onLogSent(r7.id, true, 0, 0);
    L103:
        return true;
    L96:
        if (this.mDbHelper.onLogSent(r7.id, r3, r0.getLogExpireTime(), r0.getMaxRetryCount()) == false) goto L101;
        long r10 = r0.getRetryInterval() * ((long) (r7.retryCount + 1));
        if (r10 <= 0) goto L100;
        this.mScanLogInterval = r10;
    L100:
        this.mScanLogInterval = Math.min(120000, this.mScanLogInterval);
    L102:
        r8.onLogSent(r7.value, r3);
        goto L103
    L101:
        this.mScanLogInterval = 120000;
        goto L102
    L34:
        if (r7.value.length <= 0) goto L89;
        LogHandler r9 = this.mLogQueue.getLogHandler(r7.type);
        if (r9 != null) goto L39;
        return true;
    L39:
        LogHandler.IConfig r11 = r9.getConfig();
        LogHandler.IResponseConfig r1 = r9.getResponseConfig();
        long r12 = System.currentTimeMillis();
        long r13 = r11.getRetryInterval();
        if (r1 == null) goto L52;
        if (r1.getRemoveSwitch() == false) goto L45;
        ?? r4 = 1;
    L44:
        r0 = r11;
        r3 = r4;
        r8 = r9;
        goto L91
    L45:
        long r15 = r1.getStopInterval();
        if (r15 > 0) goto L48;
    L50:
        r9.setLastStopTime(System.currentTimeMillis());
        goto L52
    L48:
        if ((r12 - r9.getLastStopTime()) >= r15) goto L50;
        return true;
    L52:
        if (r13 > 0) goto L54;
    L58:
        ?? r5 = r9.getLastSuccessChannel();
        List<String> r6 = r11.getChannels();
        if (r6 != null) goto L104;
        return true;
    L104:
        String r14 = r11.getRedirectUrl();     // Catch: Throwable -> L86
        if (TextUtils.isEmpty(r14) == true) goto L106;
        ?? r16 = sendLog(r9, r14, r7.value);     // Catch: Throwable -> L86
    L85:
        r4 = r16;
        goto L44
    L106:
        if (TextUtils.isEmpty(r5) == true) goto L74;
        r5 = sendLog(r9, r5, r7.value);     // Catch: Throwable -> L86
        if (r5 != 0) goto L72;
        r9.setLastSuccessChannel("");     // Catch: Throwable -> L70
        r5 = r5;
    L105:
    L72:
        r16 = r5;
        goto L85
    L74:
        if (r1.getMoreChannelSwitch() == false) goto L76;
        this.mChannelPosition++;     // Catch: Throwable -> L86
    L76:
        int r17 = r6.size();     // Catch: Throwable -> L86
        int r18 = this.mChannelPosition;     // Catch: Throwable -> L86
        if (r17 <= r18) goto L80;
        if (r18 < 0) goto L80;
        String r19 = r6.get(r18);     // Catch: Throwable -> L86
    L81:
        r5 = sendLog(r9, r19, r7.value);     // Catch: Throwable -> L86
        if (r5 == 0) goto L72;
        r9.setLastSuccessChannel(r19);     // Catch: Throwable -> L70
        r5 = r5;
    L80:
        this.mChannelPosition = 0;     // Catch: Throwable -> L86
        r19 = r6.get(0);     // Catch: Throwable -> L86
    L70:
        th = th;
    L88:
        LogQueue.log(TAG, "send log exception: " + th);
        r4 = r5;
    L86:
        th = th;
        r5 = 0;
        goto L88
    L54:
        if (r7.retryCount <= 0) goto L58;
        if ((r12 - r7.retryTime) >= (r13 * ((long) r7.retryCount))) goto L58;
        return true;
    L30:
        this.mMinLog++;
        goto L32
    }

    private boolean sendLog(LogHandler r1, String r2, byte[] r3) throws Throwable {
        if (r3 != null) goto L4;
        return false;
    L4:
        if (r3.length <= 0) goto L13;
        if (r1 != null) goto L7;
        return false;
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L10;
        return false;
    L10:
        return r1.send(r2, r3);
    L13:
        return false;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        LogQueue.log(TAG, "LogSender start");
    L4:
        if (isStop() == true) goto L32;
        boolean r0 = processPendingQueue();
        if (isStop() == true) goto L32;
        if (scanAndSendLog() == true) goto L13;
        if (r0 == true) goto L13;
        boolean r1 = false;
    L15:
        if (isStop() == true) goto L32;
        if (r1 == true) goto L4;
        Object r2 = this.mLock;
        monitor-enter(r2);
        long r3 = this.mScanLogInterval;     // Catch: Throwable -> L26 InterruptedException -> L34
        if (r3 != 0) goto L24;
        this.mLock.wait();     // Catch: Throwable -> L26 InterruptedException -> L34
        goto L28
    L24:
        this.mLock.wait(r3);     // Catch: Throwable -> L26 InterruptedException -> L34
        goto L28
    L26:
        th = move-exception;
        throw th;
    L28:
        monitor-exit(r2);     // Catch: Throwable -> L26
    L13:
        r1 = true;
    L32:
        LogQueue.log(TAG, "LogSender quit");
    }

    private boolean isStop() {
        return this.mStopFlag.get();
    }

    void awaken() {
        Object r0 = this.mLock;
        monitor-enter(r0);
        this.mLock.notify();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    void quit() {
        awaken();
        this.mDbHelper.closeDatabase();
    }
}
