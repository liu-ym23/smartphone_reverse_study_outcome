package com.obric.android.agilelogger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.profileinstaller.ProfileVerifier;
import com.android.contacts.common.SimContactsConstants;
import com.obric.android.agilelogger.utils.FileUtils;
import com.obric.android.agilelogger.utils.FormatUtils;
import com.obric.android.agilelogger.utils.StackTraceUtils;
import com.obric.android.alog.Alog;
import com.obric.android.alog.IMessageInterceptor;
import com.obric.android.alog.Log;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class ALog {
    private static final int MSG_ASYNC_FLUSH = 2;
    private static final int MSG_ASYNC_LOG = 1;
    private static volatile Set<String> mBlockTagSet = null;
    private static Alog mainThreadRef = null;
    private static int prio = 3;
    private static Handler sAsyncHandler = null;
    private static HandlerThread sAsyncLogThread = null;
    public static ALogConfig sConfig = null;
    private static volatile boolean sDebug = false;
    private static volatile ILogCacheCallback sILogCacheCallback = null;
    private static volatile List<INativeFuncAddrCallback> sINativeFuncAddrCallbackList = null;
    private static Object sInitLock = null;
    private static volatile boolean sInitSuccess = false;
    private static boolean sInitialized;
    private static ScheduledExecutorService sOuterExecutorService;
    private static ExecutorService sSingleThreadExecutor;
    private static ArrayList<WeakReference<Alog>> sStandaloneInstances;
    private static final ThreadLocal<Long> sThreadId = null;

    /* JADX INFO: renamed from: com.obric.android.agilelogger.ALog$14, reason: invalid class name */
    static /* synthetic */ class AnonymousClass14 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$android$agilelogger$utils$FormatUtils$TYPE = null;

        static {
            int[] r0 = new int[FormatUtils.TYPE.values().length];
            $SwitchMap$com$obric$android$agilelogger$utils$FormatUtils$TYPE = r0;
            r0[FormatUtils.TYPE.MSG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L24:
            $SwitchMap$com$obric$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.STACKTRACE_STR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L28:
            $SwitchMap$com$obric$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.BORDER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L38:
            $SwitchMap$com$obric$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.JSON.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$com$obric$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.BUNDLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L30:
            $SwitchMap$com$obric$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.INTENT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L32:
            $SwitchMap$com$obric$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.THROWABLE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L34:
            $SwitchMap$com$obric$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.THREAD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L22:
            $SwitchMap$com$obric$android$agilelogger$utils$FormatUtils$TYPE[FormatUtils.TYPE.STACKTRACE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L21
            return;
        }
    }

    private static class AsyncLog {
        private static final int MAX_POOL_SIZE = 50;
        private static AsyncLog sPool;
        private static int sPoolSize;
        private static final Object sPoolSync = null;
        public FormatUtils.TYPE formatType;
        public Object infoObject;
        public int level;
        public String msg;
        public AsyncLog next;
        public String tag;
        public Throwable throwable;
        public long tid;
        public long timestampMs;

        private AsyncLog() {
            this.formatType = null;
        }

        static {
            sPoolSync = new Object();
        }

        public static AsyncLog obtain() {
            Object r0 = sPoolSync;
            monitor-enter(r0);
            AsyncLog r1 = sPool;     // Catch: Throwable -> L12
            if (r1 == null) goto L9;
            sPool = r1.next;     // Catch: Throwable -> L12
            r1.next = null;     // Catch: Throwable -> L12
            sPoolSize--;     // Catch: Throwable -> L12
            monitor-exit(r0);     // Catch: Throwable -> L12
            return r1;
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L12
            return new AsyncLog();
        L12:
            th = move-exception;
            throw th;
        }

        public void recycle() {
            this.tag = null;
            this.msg = null;
            this.throwable = null;
            this.formatType = null;
            this.infoObject = null;
            this.tid = -1;
            this.timestampMs = 0;
            this.next = null;
            Object r0 = sPoolSync;
            monitor-enter(r0);
            int r1 = sPoolSize;     // Catch: Throwable -> L9
            if (r1 >= 50) goto L7;
            this.next = sPool;     // Catch: Throwable -> L9
            sPool = this;     // Catch: Throwable -> L9
            sPoolSize = r1 + 1;     // Catch: Throwable -> L9
        L7:
            monitor-exit(r0);     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            throw th;
        }
    }

    public static class LogInstance {
        private final Alog mAlog;

        LogInstance(Alog r1) {
            this.mAlog = r1;
        }

        public void v(String r2, String r3) {
            if (ALog.checkPrioAndTag(2, r2) == false) goto L6;
            this.mAlog.v(r2, r3);
            return;
        }

        public void d(String r2, String r3) {
            if (ALog.checkPrioAndTag(3, r2) == false) goto L6;
            this.mAlog.d(r2, r3);
            return;
        }

        public void i(String r2, String r3) {
            if (ALog.checkPrioAndTag(4, r2) == false) goto L6;
            this.mAlog.i(r2, r3);
            return;
        }

        public void w(String r2, String r3) {
            if (ALog.checkPrioAndTag(5, r2) == false) goto L6;
            this.mAlog.w(r2, r3);
            return;
        }

        public void e(String r2, String r3) {
            if (ALog.checkPrioAndTag(6, r2) == false) goto L6;
            this.mAlog.e(r2, r3);
            return;
        }

        public long getNativeRef() {
            return this.mAlog.getNativeRef();
        }

        public List<String> getFiles(long r2, long r4) {
            ArrayList r0 = new ArrayList();
            File[] r1 = this.mAlog.getLogs(r2, r4);     // Catch: Exception -> L8
            int r3 = r1.length;     // Catch: Exception -> L8
            int r5 = 0;
        L4:
            if (r5 >= r3) goto L7;
            r0.add(r1[r5].getAbsolutePath());     // Catch: Exception -> L8
            r5 = r5 + 1;
        L7:
            return r0;
        }

        public List<String> getFilesOfAllProcesses(long r8, long r10) {
            ArrayList r0 = new ArrayList();
            File[] r7 = this.mAlog.getLogs(null, r8, r10);     // Catch: Exception -> L8
            int r9 = r7.length;     // Catch: Exception -> L8
            int r11 = 0;
        L4:
            if (r11 >= r9) goto L7;
            r0.add(r7[r11].getAbsolutePath());     // Catch: Exception -> L8
            r11 = r11 + 1;
        L7:
            return r0;
        }

        public void asyncFlush() {
            this.mAlog.asyncFlush();
        }

        public void syncFlush() {
            this.mAlog.syncFlush();
        }

        public void timedSyncFlush(int r1) {
            this.mAlog.timedSyncFlush(r1);
        }
    }

    @Deprecated
    public static void forceLogSharding() {
    }

    private static int level2AlogCoreLevel(int r0) {
        return r0 - 2;
    }

    @Deprecated
    public static void setPrintStackTrace(boolean r0) {
    }

    @Deprecated
    public static void setsPackageClassName(String r0) {
    }

    public ALog() {
    }

    static /* synthetic */ void access$000(AsyncLog r0) {
        handleAsyncLog(r0);
    }

    static /* synthetic */ void access$100(Queue r0) {
        writeCachedItems(r0);
    }

    static /* synthetic */ ILogCacheCallback access$200() {
        return sILogCacheCallback;
    }

    static /* synthetic */ void access$300(String r0, String r1) {
        removeLegacyFiles(r0, r1);
    }

    static /* synthetic */ int access$400(int r0) {
        return level2AlogCoreLevel(r0);
    }

    static {
        sINativeFuncAddrCallbackList = new ArrayList();
        sOuterExecutorService = null;
        mainThreadRef = null;
        sStandaloneInstances = new ArrayList();
        sSingleThreadExecutor = null;
        sInitialized = false;
        sInitLock = new Object();
        sThreadId = new AnonymousClass1();
    }

    public static boolean init(ALogConfig r10) {
        boolean r0 = false;
        if (r10 != null) goto L5;
        return false;
    L5:
        sConfig = r10;
        Alog.init(new LibLoader());     // Catch: Throwable -> L96
        Object r1 = sInitLock;
        monitor-enter(r1);
    L93:
        th = move-exception;
        throw th;
    L10:
        if (sInitialized == false) goto L13;
        monitor-exit(r1);     // Catch: Throwable -> L93
        return false;
    L13:
        sInitialized = true;     // Catch: Throwable -> L93
        monitor-exit(r1);     // Catch: Throwable -> L93
        prio = r10.getLevel();
        boolean r2 = Util.isMainProcess(r10.getContext());
        boolean r3 = r10.isOffloadMainThreadWrite();
        if (r3 == false) goto L18;
    L21:
        boolean r4 = false;
    L22:
        boolean r5 = r10.enableOffloadInAllProcess();
        boolean r6 = r10.isNewThreadPoolImplementation();
        if (r2 == true) goto L25;
        r10.setMaxDirSize((int) (r10.getMaxDirSize() * r10.getSubProcessMaxDirSizeRatio()));
    L25:
        Alog.Builder r7 = new Alog.Builder(r10.getContext()).setInstanceName("default").setLevel(level2AlogCoreLevel(r10.getLevel())).setSyslog(sDebug).setLogFileDir(r10.getLogDirPath()).setLogFileSizeEach(r10.getPerSize());
        if (r4 == false) goto L28;
        int r8 = (r10.getMaxDirSize() / 3) * 2;
    L29:
        Alog.Builder r9 = r7.setLogFileSizeTotal(r8).setLogFileExpDays(r10.getLogFileExpDays()).setCacheFileDir(r10.getBufferDirPath());
        if (r2 == false) goto L32;
        int r11 = r10.getCacheFileSizeInKB() * 1024;
    L33:
        Alog.Builder r12 = r9.setCacheFileSizeEach(r11);
        if (r2 == false) goto L36;
        int r13 = (r10.getCacheFileSizeInKB() * 3) * 1024;
    L37:
        Alog.Builder r14 = r12.setCacheFileSizeTotal(r13).setMode(Alog.Mode.SAFE).setTimeFormat(Alog.TimeFormat.RAW).setPrefixFormat(Alog.PrefixFormat.LEGACY);
        if (r10.isCompress() == false) goto L40;
        Alog.Compress r15 = Alog.Compress.ZSTD;
    L41:
        Alog.Builder r16 = r14.setCompress(r15);
        if (r10.isEncrypt() == false) goto L44;
        Alog.SymCrypt r17 = Alog.SymCrypt.TEA_16;
    L45:
        Alog.Builder r18 = r16.setSymCrypt(r17);
        if (r10.isEncrypt() == false) goto L48;
        Alog.AsymCrypt r19 = Alog.AsymCrypt.EC_SECP256K1;
    L49:
        Log.setInstance(r18.setAsymCrypt(r19).setServerPublicKey(r10.getPubKey()).build());
        if (r3 == false) goto L56;
        if (r5 == true) goto L53;
        if (r2 == false) goto L56;
    L53:
        if (r6 == false) goto L55;
        sSingleThreadExecutor = Executors.newSingleThreadExecutor(new AnonymousClass2());
        goto L56
    L55:
        HandlerThread r20 = new HandlerThread("Alog_main_delegate");
        sAsyncLogThread = r20;
        r20.start();
        final Looper r21 = sAsyncLogThread.getLooper();
        sAsyncHandler = new AnonymousClass3(r21);
    L56:
        if (r4 == false) goto L70;
        Alog.Builder r22 = new Alog.Builder(r10.getContext()).setInstanceName("main").setLevel(level2AlogCoreLevel(r10.getLevel())).setSyslog(sDebug).setLogFileDir(r10.getLogDirPath()).setLogFileSizeEach(r10.getPerSize() / 2).setLogFileSizeTotal(r10.getMaxDirSize() / 3).setLogFileExpDays(r10.getLogFileExpDays()).setCacheFileDir(r10.getBufferDirPath()).setCacheFileSizeEach(32768).setCacheFileSizeTotal(98304).setMode(Alog.Mode.SAFE).setTimeFormat(Alog.TimeFormat.RAW).setPrefixFormat(Alog.PrefixFormat.LEGACY);
        if (r10.isCompress() == false) goto L60;
        Alog.Compress r23 = Alog.Compress.ZSTD;
    L61:
        Alog.Builder r24 = r22.setCompress(r23);
        if (r10.isEncrypt() == false) goto L64;
        Alog.SymCrypt r25 = Alog.SymCrypt.TEA_16;
    L65:
        Alog.Builder r26 = r24.setSymCrypt(r25);
        if (r10.isEncrypt() == false) goto L68;
        Alog.AsymCrypt r27 = Alog.AsymCrypt.EC_SECP256K1;
    L69:
        mainThreadRef = r26.setAsymCrypt(r27).setServerPublicKey(r10.getPubKey()).build();
        goto L70
    L68:
        r27 = Alog.AsymCrypt.NONE;
        goto L69
    L64:
        r25 = Alog.SymCrypt.NONE;
        goto L65
    L60:
        r23 = Alog.Compress.NONE;
    L70:
        final String r28 = r10.getBufferDirPath();
        final String r110 = r10.getLogDirPath();
        final Queue<LogItem> r29 = null;
        if (sILogCacheCallback == null) goto L78;
        Queue<LogItem> r30 = sILogCacheCallback.getCachedLog();
        if (r30 != null) goto L75;
    L77:
        r29 = r30;
        goto L78
    L75:
        if (r30.size() != 0) goto L77;
    L78:
        if (r29 == null) goto L80;
    L81:
        Runnable r31 = new AnonymousClass4(r29, r28, r110);
        ScheduledExecutorService r32 = sOuterExecutorService;
        if (r32 != null) goto L84;
        new Thread(r31, "_ALOG_OPT_").start();
    L85:
        r0 = true;
    L86:
        if (r0 == true) goto L91;
        ScheduledExecutorService r33 = sOuterExecutorService;
        if (r33 != null) goto L90;
        new Timer("_ALOG_OPT_").schedule(new AnonymousClass5(r28, r110), 15000);
        goto L91
    L90:
        r33.schedule(new AnonymousClass6(r28, r110), 15, TimeUnit.SECONDS);
    L91:
        sInitSuccess = true;
        return true;
    L84:
        r32.execute(r31);
        goto L85
    L80:
        if (getNativeFuncAddrCallbackList().size() <= 0) goto L86;
    L48:
        r19 = Alog.AsymCrypt.NONE;
        goto L49
    L44:
        r17 = Alog.SymCrypt.NONE;
        goto L45
    L40:
        r15 = Alog.Compress.NONE;
        goto L41
    L36:
        r13 = 65536;
        goto L37
    L32:
        r11 = 32768;
        goto L33
    L28:
        r8 = r10.getMaxDirSize();
        goto L29
    L18:
        if (r10.isMainThreadSpeedUp() == false) goto L21;
        if (r2 == false) goto L21;
        r4 = true;
    L96:
        return false;
    }

    private static void removeLegacyFiles(String r4, String r5) {
        File r0 = new File(r4);
        int r1 = 0;
        if (r0.exists() == false) goto L9;
        File[] r6 = r0.listFiles(new AnonymousClass7());
        if (r6 == null) goto L9;
        int r2 = r6.length;
        int r3 = 0;
    L7:
        if (r3 >= r2) goto L9;
        r6[r3].delete();
        r3 = r3 + 1;
    L9:
        File r7 = new File(r5);
        if (r7.exists() == false) goto L16;
        File[] r8 = r7.listFiles(new AnonymousClass8());
        if (r8 == null) goto L19;
        int r9 = r8.length;
    L14:
        if (r1 >= r9) goto L20;
        r8[r1].delete();
        r1 = r1 + 1;
        goto L14
    L20:
        return;
    L19:
        return;
    }

    private static void writeCachedItems(Queue<LogItem> r3) {
        Iterator<LogItem> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L8;
        LogItem r0 = r4.next();
        if (checkPrioAndTag(r0.mLevel, r0.mTag) == false) goto L4;
        handleItemMsg(r0);
        Log.innerWrite(level2AlogCoreLevel(r0.mLevel), r0.mTag, r0.mMsg);
        goto L4
    }

    private static void handleItemMsg(LogItem r2) {
        switch(AnonymousClass14.$SwitchMap$com$obric$android$agilelogger$utils$FormatUtils$TYPE[r2.mFormatType.ordinal()]) {
            case 1: goto L15;
            case 2: goto L12;
            case 3: goto L10;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L4;
        };
    L4:
        String r0 = "";
    L16:
        r2.mMsg = r0;
        return;
    L5:
        r0 = FormatUtils.format(r2.mFormatType, (StackTraceElement[]) r2.mObj);
        goto L16
    L6:
        r0 = FormatUtils.format(r2.mFormatType, (Thread) r2.mObj);
        goto L16
    L7:
        r0 = FormatUtils.format(r2.mFormatType, (Throwable) r2.mObj);
        goto L16
    L8:
        r0 = FormatUtils.format(r2.mFormatType, (Intent) r2.mObj);
        goto L16
    L9:
        r0 = FormatUtils.format(r2.mFormatType, (Bundle) r2.mObj);
        goto L16
    L10:
        r0 = FormatUtils.format(r2.mFormatType, (String) r2.mObj);
        goto L16
    L15:
        r0 = (String) r2.mObj;
        goto L16
    L12:
        if (r2.mObj2 != null) goto L14;
        r0 = StackTraceUtils.getStackTraceString((Throwable) r2.mObj);
        goto L16
    L14:
        r0 = r2.mObj2 + StackTraceUtils.getStackTraceString((Throwable) r2.mObj);
        goto L16
    }

    public static void setDebug(boolean r1) {
        sDebug = r1;
        Log.setSyslog(sDebug);
        Alog r2 = mainThreadRef;
        if (r2 == null) goto L6;
        r2.setSyslog(sDebug);
        return;
    }

    public static boolean isInitSuccess() {
        return sInitSuccess;
    }

    public static void setBlockTagSet(Set<String> r0) {
        mBlockTagSet = Collections.unmodifiableSet(r0);
    }

    public static Set<String> getBlockTagSet() {
        return mBlockTagSet;
    }

    public static void setILogCacheCallback(ILogCacheCallback r0) {
        sILogCacheCallback = r0;
    }

    public static void addNativeFuncAddrCallback(INativeFuncAddrCallback r1) {
        sINativeFuncAddrCallbackList.add(r1);
    }

    public static List<INativeFuncAddrCallback> getNativeFuncAddrCallbackList() {
        return sINativeFuncAddrCallbackList;
    }

    public static boolean checkPrioAndTag(int r2, String r3) {
        if (r2 >= prio) goto L5;
        return false;
    L5:
        Set<String> r4 = mBlockTagSet;
        if (r4 != null) goto L8;
        return true;
    L8:
        if (TextUtils.isEmpty(r3) == false) goto L10;
        return true;
    L10:
        if (r4.contains(r3) == false) goto L15;
        return false;
    L15:
        return true;
    }

    public static void v(String r3, String r4) {
        if (checkPrioAndTag(2, r3) == false) goto L37;
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L7;
    L12:
        ALogConfig r2 = sConfig;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = Util.isMainThread();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.v(r3, r4);
        return;
    L35:
        Log.innerVerbose(r3, r4);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(2, r3, r4);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(2, r3, r4);
        return;
    L15:
        if (r2.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(2, r3, r4);
        return;
    L7:
        if (r1.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(2, r3, r4);
        return;
    }

    public static void d(String r3, String r4) {
        if (checkPrioAndTag(3, r3) == false) goto L37;
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L7;
    L12:
        ALogConfig r2 = sConfig;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = Util.isMainThread();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.d(r3, r4);
        return;
    L35:
        Log.innerDebug(r3, r4);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(3, r3, r4);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(3, r3, r4);
        return;
    L15:
        if (r2.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(3, r3, r4);
        return;
    L7:
        if (r1.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(3, r3, r4);
        return;
    }

    public static void i(String r3, String r4) {
        if (checkPrioAndTag(4, r3) == false) goto L37;
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L7;
    L12:
        ALogConfig r2 = sConfig;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = Util.isMainThread();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.i(r3, r4);
        return;
    L35:
        Log.innerInfo(r3, r4);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(4, r3, r4);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(4, r3, r4);
        return;
    L15:
        if (r2.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(4, r3, r4);
        return;
    L7:
        if (r1.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(4, r3, r4);
        return;
    }

    public static void w(String r3, String r4) {
        if (checkPrioAndTag(5, r3) == false) goto L37;
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L7;
    L12:
        ALogConfig r2 = sConfig;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = Util.isMainThread();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.w(r3, r4);
        return;
    L35:
        Log.innerWarn(r3, r4);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(5, r3, r4);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(5, r3, r4);
        return;
    L15:
        if (r2.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(5, r3, r4);
        return;
    L7:
        if (r1.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(5, r3, r4);
        return;
    }

    public static void w(String r8, String r9, Throwable r10) {
        if (checkPrioAndTag(5, r8) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = Util.isMainThread();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        String r11 = r9 + "\n" + StackTraceUtils.getStackTraceString(r10);
        Alog r12 = mainThreadRef;
        if (r12 == null) goto L35;
        if (r2 == false) goto L35;
        r12.w(r8, r11);
        return;
    L35:
        Log.innerWarn(r8, r11);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(5, r8, r9, r10, null, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(5, r8, r9, r10, null, null);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(5, r8, r9, r10, null, null);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(5, r8, r9, r10, null, null);
        return;
    }

    public static void w(String r8, Throwable r9) {
        if (checkPrioAndTag(5, r8) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = Util.isMainThread();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        String r10 = StackTraceUtils.getStackTraceString(r9);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.w(r8, r10);
        return;
    L35:
        Log.innerWarn(r8, r10);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(5, r8, null, r9, null, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(5, r8, null, r9, null, null);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(5, r8, null, r9, null, null);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(5, r8, null, r9, null, null);
        return;
    }

    public static void e(String r3, String r4) {
        if (checkPrioAndTag(6, r3) == false) goto L37;
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L7;
    L12:
        ALogConfig r2 = sConfig;
        if (r2 != null) goto L15;
    L20:
        boolean r5 = Util.isMainThread();
        if (r5 == true) goto L23;
    L26:
        if (r5 == true) goto L28;
    L31:
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L35;
        if (r5 == false) goto L35;
        r0.e(r3, r4);
        return;
    L35:
        Log.innerError(r3, r4);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(6, r3, r4);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(6, r3, r4);
        return;
    L15:
        if (r2.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(6, r3, r4);
        return;
    L7:
        if (r1.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(6, r3, r4);
        return;
    }

    public static void e(String r8, String r9, Throwable r10) {
        if (checkPrioAndTag(6, r8) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = Util.isMainThread();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        String r11 = r9 + "\n" + StackTraceUtils.getStackTraceString(r10);
        Alog r12 = mainThreadRef;
        if (r12 == null) goto L35;
        if (r2 == false) goto L35;
        r12.e(r8, r11);
        return;
    L35:
        Log.innerError(r8, r11);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(6, r8, r9, r10, null, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(6, r8, r9, r10, null, null);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(6, r8, r9, r10, null, null);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(6, r8, r9, r10, null, null);
        return;
    }

    public static void e(String r8, Throwable r9) {
        if (checkPrioAndTag(6, r8) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = Util.isMainThread();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        String r10 = StackTraceUtils.getStackTraceString(r9);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.e(r8, r10);
        return;
    L35:
        Log.innerError(r8, r10);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(6, r8, null, r9, null, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(6, r8, null, r9, null, null);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(6, r8, null, r9, null, null);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(6, r8, null, r9, null, null);
        return;
    }

    public static void header(int r8, String r9, String r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = Util.isMainThread();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = FormatUtils.format(FormatUtils.TYPE.BORDER, r10);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.write(r11, r9, r12);
        return;
    L35:
        Log.innerWrite(r11, r9, r12);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r8, r9, r10, null, FormatUtils.TYPE.BORDER, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r8, r9, r10, null, FormatUtils.TYPE.BORDER, null);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r8, r9, r10, null, FormatUtils.TYPE.BORDER, null);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r8, r9, r10, null, FormatUtils.TYPE.BORDER, null);
        return;
    }

    public static void json(int r8, String r9, String r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = Util.isMainThread();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = FormatUtils.format(FormatUtils.TYPE.JSON, r10);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.write(r11, r9, r12);
        return;
    L35:
        Log.innerWrite(r11, r9, r12);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r8, r9, r10, null, FormatUtils.TYPE.JSON, null);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r8, r9, r10, null, FormatUtils.TYPE.JSON, null);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r8, r9, r10, null, FormatUtils.TYPE.JSON, null);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r8, r9, r10, null, FormatUtils.TYPE.JSON, null);
        return;
    }

    public static void bundle(int r8, String r9, Bundle r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = Util.isMainThread();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = FormatUtils.format(FormatUtils.TYPE.BUNDLE, r10);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.write(r11, r9, r12);
        return;
    L35:
        Log.innerWrite(r11, r9, r12);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.BUNDLE, r10);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r8, r9, null, null, FormatUtils.TYPE.BUNDLE, r10);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.BUNDLE, r10);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r8, r9, null, null, FormatUtils.TYPE.BUNDLE, r10);
        return;
    }

    public static void intent(int r8, String r9, Intent r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = Util.isMainThread();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = FormatUtils.format(FormatUtils.TYPE.INTENT, r10);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.write(r11, r9, r12);
        return;
    L35:
        Log.innerWrite(r11, r9, r12);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.INTENT, r10);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r8, r9, null, null, FormatUtils.TYPE.INTENT, r10);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.INTENT, r10);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r8, r9, null, null, FormatUtils.TYPE.INTENT, r10);
        return;
    }

    public static void throwable(int r8, String r9, Throwable r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = Util.isMainThread();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = FormatUtils.format(FormatUtils.TYPE.THROWABLE, r10);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.write(r11, r9, r12);
        return;
    L35:
        Log.innerWrite(r11, r9, r12);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.THROWABLE, r10);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r8, r9, null, r10, FormatUtils.TYPE.THROWABLE, null);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r8, r9, null, r10, FormatUtils.TYPE.THROWABLE, null);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r8, r9, null, r10, FormatUtils.TYPE.THROWABLE, null);
        return;
    }

    public static void thread(int r8, String r9, Thread r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = Util.isMainThread();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = FormatUtils.format(FormatUtils.TYPE.THREAD, r10);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.write(r11, r9, r12);
        return;
    L35:
        Log.innerWrite(r11, r9, r12);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.THREAD, r10);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r8, r9, null, null, FormatUtils.TYPE.THREAD, r10);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.THREAD, r10);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r8, r9, null, null, FormatUtils.TYPE.THREAD, r10);
        return;
    }

    public static void stacktrace(int r8, String r9, StackTraceElement[] r10) {
        if (checkPrioAndTag(r8, r9) == false) goto L37;
        ALogConfig r0 = sConfig;
        if (r0 != null) goto L7;
    L12:
        ALogConfig r1 = sConfig;
        if (r1 != null) goto L15;
    L20:
        boolean r2 = Util.isMainThread();
        if (r2 == true) goto L23;
    L26:
        if (r2 == true) goto L28;
    L31:
        int r11 = level2AlogCoreLevel(r8);
        String r12 = FormatUtils.format(FormatUtils.TYPE.STACKTRACE, r10);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L35;
        if (r2 == false) goto L35;
        r3.write(r11, r9, r12);
        return;
    L35:
        Log.innerWrite(r11, r9, r12);
        return;
    L28:
        if (sAsyncHandler == null) goto L31;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.STACKTRACE, r10);
        return;
    L23:
        if (sSingleThreadExecutor == null) goto L26;
        postAsyncLogByThreadPool(r8, r9, null, null, FormatUtils.TYPE.STACKTRACE, r10);
        return;
    L15:
        if (r1.enableOffloadInAllThread() == false) goto L20;
        if (sAsyncHandler == null) goto L20;
        postAsyncLog(r8, r9, null, null, FormatUtils.TYPE.STACKTRACE, r10);
        return;
    L7:
        if (r0.enableOffloadInAllThread() == false) goto L12;
        if (sSingleThreadExecutor == null) goto L12;
        postAsyncLogByThreadPool(r8, r9, null, null, FormatUtils.TYPE.STACKTRACE, r10);
        return;
    }

    public static void statcktrace(int r0, String r1, StackTraceElement[] r2) {
        stacktrace(r0, r1, r2);
    }

    public static void println(int r2, String r3, Object r4, FormatUtils.TYPE r5) {
        if (checkPrioAndTag(r2, r3) == false) goto L49;
        int r0 = level2AlogCoreLevel(r2);
        switch(AnonymousClass14.$SwitchMap$com$obric$android$agilelogger$utils$FormatUtils$TYPE[r5.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            default: goto L6;
        };
    L6:
        String r6 = "";
    L16:
        ALogConfig r7 = sConfig;
        if (r7 != null) goto L19;
    L24:
        ALogConfig r8 = sConfig;
        if (r8 != null) goto L27;
    L32:
        boolean r9 = Util.isMainThread();
        if (r9 == true) goto L35;
    L38:
        if (r9 == true) goto L40;
    L43:
        Alog r10 = mainThreadRef;
        if (r10 == null) goto L47;
        if (r9 == false) goto L47;
        r10.write(r0, r3, r6);
        return;
    L47:
        Log.innerWrite(r0, r3, r6);
        return;
    L40:
        if (sAsyncHandler == null) goto L43;
        postAsyncLog(r2, r3, r6);
        return;
    L35:
        if (sSingleThreadExecutor == null) goto L38;
        postAsyncLogByThreadPool(r2, r3, r6);
        return;
    L27:
        if (r8.enableOffloadInAllThread() == false) goto L32;
        if (sAsyncHandler == null) goto L32;
        postAsyncLog(r2, r3, r6);
        return;
    L19:
        if (r7.enableOffloadInAllThread() == false) goto L24;
        if (sSingleThreadExecutor == null) goto L24;
        postAsyncLogByThreadPool(r2, r3, r6);
        return;
    L7:
        r6 = FormatUtils.format(FormatUtils.TYPE.STACKTRACE, (StackTraceElement[]) r4);
        goto L16
    L8:
        r6 = FormatUtils.format(FormatUtils.TYPE.THREAD, (Thread) r4);
        goto L16
    L9:
        r6 = FormatUtils.format(FormatUtils.TYPE.THROWABLE, (Throwable) r4);
        goto L16
    L10:
        r6 = FormatUtils.format(FormatUtils.TYPE.INTENT, (Intent) r4);
        goto L16
    L11:
        r6 = FormatUtils.format(FormatUtils.TYPE.BUNDLE, (Bundle) r4);
        goto L16
    L12:
        r6 = FormatUtils.format(FormatUtils.TYPE.JSON, (String) r4);
        goto L16
    L13:
        r6 = FormatUtils.format(FormatUtils.TYPE.BORDER, (String) r4);
        goto L16
    L14:
        r6 = StackTraceUtils.getStackTraceString((Throwable) r4);
        goto L16
    L15:
        r6 = (String) r4;
        goto L16
    }

    public static void asyncFlush() {
        ExecutorService r0 = sSingleThreadExecutor;
        if (r0 == null) goto L5;
        r0.execute(new AnonymousClass9());
    L8:
        Log.asyncFlush();
        Alog r1 = mainThreadRef;
        if (r1 == null) goto L11;
        r1.asyncFlush();
    L11:
        Iterator<WeakReference<Alog>> r2 = sStandaloneInstances.iterator();
    L13:
        if (r2.hasNext() == false) goto L20;
        WeakReference<Alog> r3 = r2.next();
        if (r3 == null) goto L13;
        Alog r4 = r3.get();
        if (r4 == null) goto L13;
        r4.asyncFlush();
        goto L13
    L20:
        return;
    L5:
        Handler r5 = sAsyncHandler;
        if (r5 == null) goto L8;
        r5.sendEmptyMessage(2);
        goto L8
    }

    public static void syncFlush() {
        ExecutorService r0 = sSingleThreadExecutor;
        if (r0 == null) goto L5;
        r0.execute(new AnonymousClass10());
    L5:
        Handler r1 = sAsyncHandler;
        if (r1 == null) goto L8;
        r1.sendEmptyMessage(2);
    L8:
        Log.syncFlush();
        Alog r2 = mainThreadRef;
        if (r2 == null) goto L11;
        r2.syncFlush();
    L11:
        Iterator<WeakReference<Alog>> r3 = sStandaloneInstances.iterator();
    L13:
        if (r3.hasNext() == false) goto L17;
        Alog r4 = r3.next().get();
        if (r4 == null) goto L13;
        r4.syncFlush();
        goto L13
    }

    public static void timedSyncFlush(int r2) {
        ExecutorService r0 = sSingleThreadExecutor;
        if (r0 == null) goto L5;
        r0.execute(new AnonymousClass11());
    L5:
        Handler r1 = sAsyncHandler;
        if (r1 == null) goto L8;
        r1.sendEmptyMessage(2);
    L8:
        Log.timedSyncFlush(r2);
        Alog r3 = mainThreadRef;
        if (r3 == null) goto L11;
        r3.timedSyncFlush(r2);
    L11:
        Iterator<WeakReference<Alog>> r4 = sStandaloneInstances.iterator();
    L13:
        if (r4.hasNext() == false) goto L17;
        Alog r5 = r4.next().get();
        if (r5 == null) goto L13;
        r5.timedSyncFlush(r2);
        goto L13
    }

    public static void setOuterExecutorService(ScheduledExecutorService r0) {
        sOuterExecutorService = r0;
    }

    public static void changeLevel(int r1) {
        prio = r1;
        Log.setLevel(level2AlogCoreLevel(r1));
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.setLevel(level2AlogCoreLevel(r1));
        return;
    }

    public static List<String> getALogFiles(long r7, long r9) {
        ArrayList r0 = new ArrayList();
        File[] r8 = Log.getLogs(null, null, r7 * 1000, r9 * 1000);     // Catch: Exception -> L8
        int r10 = r8.length;     // Catch: Exception -> L8
        int r11 = 0;
    L4:
        if (r11 >= r10) goto L7;
        r0.add(r8[r11].getAbsolutePath());     // Catch: Exception -> L8
        r11 = r11 + 1;
    L7:
        return r0;
    }

    public static HashMap<String, String> getLastFetchErrorInfo() {
        return Log.getLastFetchErrorInfo();
    }

    public static String getStatus() {
        return Log.getStatus();
    L4:
        return "getStatus exception";
    }

    public static List<String> getALogFiles(String r9, String r10, long r11, long r13) {
        ArrayList r0 = new ArrayList();
        File[] r12 = Log.getLogs(r9, r10, r11 * 1000, r13 * 1000);     // Catch: Exception -> L8
        int r14 = r12.length;     // Catch: Exception -> L8
        int r15 = 0;
    L4:
        if (r15 >= r14) goto L7;
        r0.add(r12[r15].getAbsolutePath());     // Catch: Exception -> L8
        r15 = r15 + 1;
    L7:
        return r0;
    }

    public static void destroy() {
        Log.close();
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.close();
    L6:
        if (sAsyncHandler == null) goto L8;
        sAsyncLogThread.quit();
        sAsyncLogThread = null;
        sAsyncHandler = null;
    L8:
        ExecutorService r1 = sSingleThreadExecutor;
        if (r1 == null) goto L12;
        r1.shutdown();
        sSingleThreadExecutor = null;
        return;
    }

    public static void release() {
        Log.close();
        Alog r0 = mainThreadRef;
        if (r0 == null) goto L6;
        r0.close();
    L6:
        if (sAsyncHandler == null) goto L8;
        sAsyncLogThread.quit();
        sAsyncLogThread = null;
        sAsyncHandler = null;
    L8:
        ExecutorService r1 = sSingleThreadExecutor;
        if (r1 == null) goto L12;
        r1.shutdown();
        sSingleThreadExecutor = null;
        return;
    }

    @Deprecated
    public static void flush() {
        ExecutorService r0 = sSingleThreadExecutor;
        if (r0 == null) goto L5;
        r0.execute(new AnonymousClass12());
    L5:
        Handler r1 = sAsyncHandler;
        if (r1 == null) goto L8;
        r1.sendEmptyMessage(2);
    L8:
        Log.asyncFlush();
        Alog r2 = mainThreadRef;
        if (r2 == null) goto L12;
        r2.asyncFlush();
        return;
    }

    public static long getALogWriteFuncAddr() {
        return Log.getLegacyWriteFuncAddr();
    }

    public static long getAlogNativeFlushV2FuncAddr() {
        return Log.getLegacyFlushFuncAddr();
    }

    public static long getAlogNativeLogStoreDirFuncAddr() {
        return Log.getLegacyGetLogFileDirFuncAddr();
    }

    public static long getALogSimpleWriteFuncAddr() {
        return Log.getNativeWriteFuncAddr();
    }

    public static void writeAsyncLog(int r7, String r8, String r9, long r10, long r12) {
        Log.innerWriteAsyncMsg(level2AlogCoreLevel(r7), r8, r9, r10, r12);
    }

    private static void postAsyncLogByThreadPool(int r6, String r7, String r8) {
        postAsyncLogByThreadPool(r6, r7, r8, null, null, null);
    }

    private static void postAsyncLogByThreadPool(final int r13, final String r14, final String r15, final Throwable r16, final FormatUtils.TYPE r17, final Object r18) {
        final long r7 = getThreadId();
        final long r9 = System.currentTimeMillis();
        sSingleThreadExecutor.execute(new AnonymousClass13(r13, r17, r16, r15, r18, r14, r7, r9));
    }

    private static void postAsyncLog(int r6, String r7, String r8) {
        postAsyncLog(r6, r7, r8, null, null, null);
    }

    private static void postAsyncLog(int r1, String r2, String r3, Throwable r4, FormatUtils.TYPE r5, Object r6) {
        AsyncLog r0 = AsyncLog.obtain();
        r0.level = r1;
        r0.tag = r2;
        r0.msg = r3;
        r0.throwable = r4;
        r0.formatType = r5;
        r0.infoObject = r6;
        r0.tid = getThreadId();
        r0.timestampMs = System.currentTimeMillis();
        Message r7 = Message.obtain();
        r7.what = 1;
        r7.obj = r0;
        sAsyncHandler.sendMessage(r7);
    }

    private static long getThreadId() {
        return sThreadId.get().longValue();
    }

    private static void handleAsyncLog(AsyncLog r8) {
        int r1 = level2AlogCoreLevel(r8.level);
        String r2 = "";
        if (r8.formatType != null) goto L13;
        if (r8.throwable != null) goto L8;
        String r0 = r8.msg;
    L15:
        String r3 = r0;
    L35:
        Log.innerWriteAsyncMsg(r1, r8.tag, r3, r8.tid, r8.timestampMs);
        r8.recycle();
        return;
    L8:
        if (r8.msg == null) goto L11;
        r2 = r8.msg + "\n";
    L11:
        r0 = r2 + StackTraceUtils.getStackTraceString(r8.throwable);
        goto L15
    L13:
        if (r8.formatType != FormatUtils.TYPE.BORDER) goto L17;
        r0 = FormatUtils.format(FormatUtils.TYPE.BORDER, r8.msg);
        goto L15
    L17:
        if (r8.formatType != FormatUtils.TYPE.JSON) goto L20;
        r0 = FormatUtils.format(FormatUtils.TYPE.JSON, r8.msg);
        goto L15
    L20:
        if (r8.formatType != FormatUtils.TYPE.BUNDLE) goto L23;
        r0 = FormatUtils.format(FormatUtils.TYPE.BUNDLE, (Bundle) r8.infoObject);
        goto L15
    L23:
        if (r8.formatType != FormatUtils.TYPE.INTENT) goto L26;
        r0 = FormatUtils.format(FormatUtils.TYPE.INTENT, (Intent) r8.infoObject);
        goto L15
    L26:
        if (r8.formatType != FormatUtils.TYPE.THROWABLE) goto L29;
        r0 = FormatUtils.format(FormatUtils.TYPE.THROWABLE, (Throwable) r8.infoObject);
        goto L15
    L29:
        if (r8.formatType != FormatUtils.TYPE.THREAD) goto L32;
        r0 = FormatUtils.format(FormatUtils.TYPE.THREAD, (Thread) r8.infoObject);
        goto L15
    L32:
        if (r8.formatType != FormatUtils.TYPE.STACKTRACE) goto L34;
        r0 = FormatUtils.format(FormatUtils.TYPE.STACKTRACE, (StackTraceElement[]) r8.infoObject);
        goto L15
    L34:
        r3 = "";
        goto L35
    }

    public static LogInstance createInstance(String r1, Context r2) {
        if (r2 != null) goto L6;
        return null;
    L6:
        return createInstance(r1, new ALogConfig.Builder(r2).build());
    }

    public static LogInstance createInstance(String r3, ALogConfig r4) {
        if (r4 != null) goto L6;
        return null;
    L6:
        if (sInitSuccess == false) goto L35;
    L10:
        Alog.Builder r5 = new Alog.Builder(r4.getContext()).setInstanceName(r3).setLevel(level2AlogCoreLevel(r4.getLevel())).setSyslog(sDebug);
        ALogConfig r1 = sConfig;
        if (r1 == null) goto L13;
        String r2 = r1.getLogDirPath();
    L14:
        Alog.Builder r6 = r5.setLogFileDir(r2).setLogFileSizeEach(r4.getPerSize()).setLogFileSizeTotal(r4.getMaxDirSize()).setLogFileExpDays(r4.getLogFileExpDays());
        ALogConfig r7 = sConfig;
        if (r7 == null) goto L17;
        String r8 = r7.getBufferDirPath();
    L18:
        Alog.Builder r9 = r6.setCacheFileDir(r8).setCacheFileSizeEach(65536).setCacheFileSizeTotal(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE).setMode(Alog.Mode.SAFE).setTimeFormat(Alog.TimeFormat.RAW).setPrefixFormat(Alog.PrefixFormat.LEGACY);
        if (r4.isCompress() == false) goto L21;
        Alog.Compress r10 = Alog.Compress.ZSTD;
    L22:
        Alog.Builder r11 = r9.setCompress(r10);
        if (r4.isEncrypt() == false) goto L25;
        Alog.SymCrypt r12 = Alog.SymCrypt.TEA_16;
    L26:
        Alog.Builder r13 = r11.setSymCrypt(r12);
        if (r4.isEncrypt() == false) goto L29;
        Alog.AsymCrypt r14 = Alog.AsymCrypt.EC_SECP256K1;
    L30:
        Alog r15 = r13.setAsymCrypt(r14).setServerPublicKey(r4.getPubKey()).build();
        if (r15 != null) goto L33;
        return null;
    L33:
        sStandaloneInstances.add(new WeakReference(r15));
        return new LogInstance(r15);
    L29:
        r14 = Alog.AsymCrypt.NONE;
        goto L30
    L25:
        r12 = Alog.SymCrypt.NONE;
        goto L26
    L21:
        r10 = Alog.Compress.NONE;
        goto L22
    L17:
        r8 = r4.getBufferDirPath();
        goto L18
    L13:
        r2 = r4.getLogDirPath();
        goto L14
    L35:
        Alog.init(new LibLoader());     // Catch: Throwable -> L9
    L9:
        return null;
    }

    public static void removeObsoleteInstance(String r10, Context r11, boolean r12) {
        String r0 = Util.getProcessName();
        if (r0 != null) goto L6;
        return;
    L6:
        if (r0.contains(SimContactsConstants.ANR_SEP) == false) goto L8;
        return;
    L8:
        if (r12 == true) goto L11;
        r0 = r0 + '-';
    L11:
        ALogConfig r13 = sConfig;
        if (r13 == null) goto L14;
        String r14 = r13.getLogDirPath();
        String r15 = sConfig.getBufferDirPath();
    L15:
        File r1 = new File(r14);
        if (r1.exists() == true) goto L18;
        return;
    L18:
        if (r1.isDirectory() == false) goto L57;
        String r16 = "__" + r10 + ".olog";
        File[] r2 = r1.listFiles();
        int r3 = r2.length;
        int r4 = 0;
        int r5 = 0;
    L21:
        if (r5 >= r3) goto L30;
        File r6 = r2[r5];
        String r7 = r6.getName();
        if (r7 == null) goto L29;
        if (r7.endsWith(r16) == false) goto L29;
        if (r7.contains(r0) == false) goto L29;
        r6.delete();
    L29:
        r5 = r5 + 1;
        goto L21
    L30:
        File r17 = new File(r15);
        if (r17.exists() == true) goto L33;
        return;
    L33:
        if (r17.isDirectory() == false) goto L58;
        String r18 = "__" + r10;
        File[] r19 = r17.listFiles();
        int r110 = r19.length;
    L36:
        if (r4 >= r110) goto L59;
        File r8 = r19[r4];
        String r9 = r8.getName();
        if (r9 == null) goto L44;
        if (r9.contains(r18) == false) goto L44;
        if (r9.contains(r0) == false) goto L44;
        r8.delete();
    L44:
        r4 = r4 + 1;
        goto L36
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L14:
        String r111 = FileUtils.getDefaultLogDir(r11).getAbsolutePath();
        r15 = FileUtils.getBufferDirPath(r11);
        r14 = r111;
        goto L15
    }

    public static void addMessageInterceptor(IMessageInterceptor r0) {
        Alog.addMessageInterceptor(r0);
    }

    public static void removeMessageInterceptor(IMessageInterceptor r0) {
        Alog.removeMessageInterceptor(r0);
    }
}
