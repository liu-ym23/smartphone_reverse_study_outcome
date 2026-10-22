package com.bytedance.sliver;

import android.os.AsyncTask;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
@Keep
public final class Sliver {
    private static final int SUPPORT_API_MAX = 31;
    private static final int SUPPORT_API_MIN = 19;
    private static final String TAG = "SLIVER";
    private static final Map<Thread, e> cache = null;
    private static final boolean isArt = false;
    private static volatile boolean isInit = false;
    private static final Map<String, Long> mark = null;
    private static final SliverExecutor sDefaultExecutor = null;
    private static final SliverLogger sDefaultLogger = null;
    private static SliverExecutor sExecutor;
    private static SliverLogger sLogger;
    private static boolean sLoggerEnable;
    private static final Field threadPeerField = null;
    private static final Field threadPeerFieldDalvik = null;

    public static final enum Mode extends Enum<Mode> {
        private static final /* synthetic */ Mode[] $VALUES = null;
        public static final Mode NORMAL = null;
        public static final Mode RING = null;

        static {
            Mode r10 = new Mode("RING", 0);
            RING = r10;
            Mode r11 = new Mode("NORMAL", 1);
            NORMAL = r11;
            $VALUES = new Mode[]{r10, r11};
        }

        private Mode(String r10, int r11) {
            super(r10, r11);
        }

        public static Mode valueOf(String r10) {
            return (Mode) Enum.valueOf(Mode.class, r10);
        }

        public static Mode[] values() {
            return (Mode[]) $VALUES.clone();
        }
    }

    public interface SliverExecutor {
        void execute(Runnable r10);
    }

    public interface SliverLogger {
        void onError(String r10, Throwable r11);

        void onStep(String r10);
    }

    public interface ThreadFilter {
        boolean traceEnable(Thread r10);
    }

    public static class a implements SliverLogger {
        public a() {
        }

        @Override // com.bytedance.sliver.Sliver.SliverLogger
        public void onError(String r10, Throwable r11) {
            Log.e(Sliver.TAG, r10, r11);
        }

        @Override // com.bytedance.sliver.Sliver.SliverLogger
        public void onStep(String r10) {
            Log.i(Sliver.TAG, r10);
        }
    }

    public static class b implements SliverExecutor {
        public b() {
        }

        @Override // com.bytedance.sliver.Sliver.SliverExecutor
        public void execute(Runnable r10) {
            AsyncTask.execute(r10);
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f8084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f8085b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f8086c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Thread f8087d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ boolean f8088e;

        public c(String r10, e r11, String r12, Thread r13, boolean r14) {
            this.f8084a = r10;
            this.f8085b = r11;
            this.f8086c = r12;
            this.f8087d = r13;
            this.f8088e = r14;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (TextUtils.isEmpty(this.f8084a) == true) goto L7;
            Long r10 = (Long) Sliver.access$100().get(this.f8084a);
            if (r10 == null) goto L7;
            long r11 = r10.longValue();
        L8:
            Sliver.access$200(this.f8085b.f8091a, this.f8086c, r11);
            StringBuilder r12 = new StringBuilder();
            r12.append(this.f8087d);
            r12.append(" dump ");
            if (this.f8088e == false) goto L11;
            String r13 = "sync";
        L12:
            r12.append(r13);
            r12.append(" success");
            Sliver.onStep(r12.toString());
            return;
        L11:
            r13 = "async";
        L7:
            r11 = -1;
            goto L8
        }
    }

    public static class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f8089a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Thread f8090b;

        public d(e r10, Thread r11) {
            this.f8089a = r10;
            this.f8090b = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            Sliver.access$300(this.f8089a.f8091a);
            Sliver.onStep(this.f8090b + " clear success");
        }
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f8091a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Thread f8092b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8093c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8094d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f8095e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f8096f;

        public e() {
        }

        public /* synthetic */ e(a r10) {
            this();
        }
    }

    static {
        cache = new ConcurrentHashMap(16);
        mark = new ConcurrentHashMap(16);
        a r10 = new a();
        sDefaultLogger = r10;
        sLogger = r10;
        sLoggerEnable = false;
        b r11 = new b();
        sDefaultExecutor = r11;
        sExecutor = r11;
        isArt = isArt();
        Field r12 = null;
    L8:
        Field r13 = null;
    L13:
        threadPeerField = r12;
        threadPeerFieldDalvik = r13;
        return;
    L5:
        if (isArt() == false) goto L9;
        Field r14 = Thread.class.getDeclaredField("nativePeer");     // Catch: Throwable -> L8
    L7:
        Field r15 = r14;
        r13 = r12;
        r12 = r15;
        r12.setAccessible(true);     // Catch: Throwable -> L16
        goto L13
    L9:
        r14 = Thread.class.getDeclaredField("vmThread");     // Catch: Throwable -> L8
        r12 = Class.forName("java.lang.VMThread").getDeclaredField("vmData");     // Catch: Throwable -> L14
        r12.setAccessible(true);     // Catch: Throwable -> L14
    L14:
        r13 = r12;
        r12 = r14;
        goto L13
    }

    public Sliver() {
    }

    public static /* synthetic */ Map access$100() {
        return mark;
    }

    public static /* synthetic */ void access$200(long r10, String r11, long r12) {
        nDump(r10, r11, r12);
    }

    public static /* synthetic */ void access$300(long r10) {
        nClear(r10);
    }

    public static boolean clear() {
        return clear(Thread.currentThread());
    }

    public static synchronized boolean clearAll() {
        monitor-enter(Sliver.class);
        boolean r10 = SliverAllThreadSupport.clearAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean dump(String r10) {
        return dump(Thread.currentThread(), r10);
    }

    public static synchronized boolean dumpAll(String r10) {
        monitor-enter(Sliver.class);
        boolean r11 = dumpAll(r10, false);     // Catch: Throwable -> L8
        monitor-exit(Sliver.class);
        return r11;
    L8:
        th = move-exception;
        throw th;
    }

    public static void enableLog() {
        sLoggerEnable = true;
    }

    public static synchronized long[] getMethodStackTrace(Thread r10) {
        monitor-enter(Sliver.class);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (init(false) == true) goto L12;
        long[] r11 = new long[0];     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return r11;
    L12:
        long r12 = getThreadPeer(r10);     // Catch: Throwable -> L10
        if (r12 != 0) goto L17;
        long[] r13 = new long[0];     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return r13;
    L17:
        long[] r14 = nGetMethodStackTrace(r10, r12);     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return r14;
    }

    public static synchronized String getStackTrace(long[] r10) {
        monitor-enter(Sliver.class);
        if (r10 == null) goto L14;
    L11:
        th = move-exception;
        throw th;
    L6:
        if (r10.length == 0) goto L14;
        String r11 = nGetStackTrace(r10);     // Catch: Throwable -> L11
        monitor-exit(Sliver.class);
        return r11;
    L14:
        monitor-exit(Sliver.class);
        return "";
    }

    public static long getThreadPeer(Thread r10) {
        if (isArt() == false) goto L11;
        Field r11 = threadPeerField;
        if (r11 == null) goto L24;
        Object r12 = r11.get(r10);     // Catch: Throwable -> L21
        if (r12 != null) goto L10;
        return 0;
    L10:
        return ((Long) r12).longValue();
    L24:
        return 0;
    L11:
        Field r13 = threadPeerField;
        if (r13 == null) goto L25;
        Field r14 = threadPeerFieldDalvik;
        if (r14 == null) goto L26;
        Object r15 = r14.get(r13.get(r10));     // Catch: Throwable -> L21
        if (r15 != null) goto L20;
        return 0;
    L20:
        return ((Integer) r15).intValue();
    L26:
        return 0;
    L25:
        return 0;
    L28:
        return 0;
    }

    public static synchronized boolean init(boolean r10) {
        monitor-enter(Sliver.class);
        int r11 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L9
        if (r11 <= 31) goto L12;
        onError("not support api : " + r11 + ", sliver support 19-31", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L12:
        if (isInit == false) goto L17;
        onStep("sliver already init");     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    L17:
        if (loadLibrary() == true) goto L20;
        monitor-exit(Sliver.class);
        return false;
    L20:
        Method r12 = null;
        r12 = Looper.class.getMethod("loop", null);     // Catch: Throwable -> L32
    L23:
        if (nInit(r11, r12, r10, isArt) == true) goto L27;
        onError("sliver init failed, because native init error", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L27:
        isInit = true;     // Catch: Throwable -> L9
        onStep("sliver init success, protect is " + r10);     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    L9:
        th = move-exception;
        throw th;
    }

    private static boolean isArt() {
        return true;
    }

    private static boolean loadLibrary() {
        System.loadLibrary("sliver");     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        onError("sliver so load failed", th);
        return false;
    }

    public static void mark(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return;
    L5:
        mark.put(r10, Long.valueOf(System.nanoTime()));
    }

    public static int mode2Int(Mode r10) {
        if (r10 != Mode.RING) goto L6;
        return 0;
    L6:
        if (r10 != Mode.NORMAL) goto L9;
        return 1;
    L9:
        return 0;
    }

    private static native void nClear(long r10);

    private static native void nDump(long r10, String r11, long r12);

    private static native long[] nGetMethodStackTrace(Thread r10, long r11);

    private static native String nGetStackTrace(Thread r10, long r11);

    private static native String nGetStackTrace(long[] r10);

    private static native boolean nInit(int r10, Method r11, boolean r12, boolean r13);

    private static native void nPause(long r10);

    private static native void nResetSamplingMs(long r10, int r11);

    private static native void nResume(long r10);

    private static native long nStart(Thread r10, long r11, int r12, int r13, int r14);

    private static native void nStop(long r10);

    public static void onError(String r10, Throwable r11) {
        if (sLoggerEnable == true) goto L5;
        return;
    L5:
        sLogger.onError(r10, r11);
    }

    public static void onStep(String r10) {
        if (sLoggerEnable == true) goto L5;
        return;
    L5:
        sLogger.onStep(r10);
    }

    public static boolean pause() {
        return pause(Thread.currentThread());
    }

    public static synchronized boolean pauseAll() {
        monitor-enter(Sliver.class);
        boolean r10 = SliverAllThreadSupport.pauseAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resetSamplingMs(int r10) {
        monitor-enter(Sliver.class);
        boolean r11 = resetSamplingMs(Thread.currentThread(), r10);     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r11;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean resume() {
        return resume(Thread.currentThread());
    }

    public static synchronized boolean resumeAll() {
        monitor-enter(Sliver.class);
        boolean r10 = SliverAllThreadSupport.resumeAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static void setExecutor(SliverExecutor r10) {
        if (r10 == null) goto L5;
        sExecutor = r10;
        return;
    }

    public static void setLogger(SliverLogger r10) {
        if (r10 == null) goto L5;
        enableLog();
        sLogger = r10;
        return;
    }

    public static boolean start(int r10) {
        return start(Thread.currentThread(), r10, 100000, Mode.RING);
    }

    public static boolean startAll(int r10, int r11) {
        return startAll(r10, r11, 50000, Mode.RING, null);
    }

    public static boolean stop() {
        return stop(Thread.currentThread());
    }

    public static synchronized boolean stopAll() {
        monitor-enter(Sliver.class);
        boolean r10 = SliverAllThreadSupport.stopAll();     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r10;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean clear(Thread r10) {
        monitor-enter(Sliver.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L11;
        onError(r10 + " clear failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L11:
        e r11 = cache.get(r10);     // Catch: Throwable -> L9
        if (r11 != null) goto L16;
        onError(r10 + " clear failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L16:
        sExecutor.execute(new d(r11, r10));     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    }

    public static boolean dump(String r10, String r11) {
        return dump(Thread.currentThread(), r10, r11);
    }

    public static synchronized boolean dumpAll(String r10, boolean r11) {
        monitor-enter(Sliver.class);
        boolean r12 = SliverAllThreadSupport.dumpAll(r10, r11);     // Catch: Throwable -> L7
        monitor-exit(Sliver.class);
        return r12;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean pause(Thread r10) {
        monitor-enter(Sliver.class);
        e r11 = cache.get(r10);     // Catch: Throwable -> L9
        if (r11 != null) goto L12;
        onError(r10 + " pause failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L12:
        if (r11.f8095e == true) goto L16;
        onStep(r10 + " already pause");     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    L16:
        nPause(r11.f8091a);     // Catch: Throwable -> L9
        r11.f8095e = false;     // Catch: Throwable -> L9
        onStep(r10 + " pause success");     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    L9:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean resetSamplingMs(Thread r10, int r11) {
        monitor-enter(Sliver.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L11;
        onError(r10 + " reset sampling ms  failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L11:
        e r12 = cache.get(r10);     // Catch: Throwable -> L9
        if (r12 != null) goto L16;
        onError(r10 + " reset sampling ms  failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L16:
        nResetSamplingMs(r12.f8091a, r11);     // Catch: Throwable -> L9
        onStep(r10 + " reset sampling ms success");     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    }

    public static synchronized boolean resume(Thread r10) {
        monitor-enter(Sliver.class);
        e r11 = cache.get(r10);     // Catch: Throwable -> L10
        if (r11 != null) goto L13;
        onError(r10 + " resume failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return false;
    L13:
        if (r11.f8095e == false) goto L17;
        onStep(r10 + " already resume");     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return true;
    L17:
        nResume(r11.f8091a);     // Catch: Throwable -> L10
        r11.f8095e = true;     // Catch: Throwable -> L10
        onStep(r10 + " resume success");     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return true;
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean start(Thread r14, int r15, int r16, Mode r17) {
        monitor-enter(Sliver.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (SliverAllThreadSupport.isStart() == false) goto L12;
        onError("sliver start failed , because sliver all thread was started", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L12:
        if (init(false) == true) goto L16;
        onError("sliver start failed , because sliver init failed", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L16:
        Map<Thread, e> r10 = cache;     // Catch: Throwable -> L9
        if (r10.containsKey(r14) == false) goto L21;
        onStep(r14 + " already sampling by sliver");     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    L21:
        long r11 = getThreadPeer(r14);     // Catch: Throwable -> L9
        if (r11 != 0) goto L26;
        onError("sliver start failed , because can't get thread peer", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L26:
        int r13 = mode2Int(r17);     // Catch: Throwable -> L9
        long r12 = nStart(r14, r11, r15, r16, r13);     // Catch: Throwable -> L9
        if (r12 != 0) goto L31;
        onError("sliver start failed , because can't get native peer", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L31:
        e r18 = new e(null);     // Catch: Throwable -> L9
        r18.f8091a = r12;     // Catch: Throwable -> L9
        r18.f8092b = r14;     // Catch: Throwable -> L9
        r18.f8093c = r15;     // Catch: Throwable -> L9
        r18.f8094d = r16;     // Catch: Throwable -> L9
        r18.f8095e = true;     // Catch: Throwable -> L9
        r18.f8096f = r13;     // Catch: Throwable -> L9
        r10.put(r14, r18);     // Catch: Throwable -> L9
        onStep(r14 + " sampling by sliver success");     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return true;
    }

    public static synchronized boolean startAll(int r10, int r11, int r12, Mode r13, ThreadFilter r14) {
        monitor-enter(Sliver.class);
    L16:
        th = move-exception;
        throw th;
    L6:
        if (cache.isEmpty() == true) goto L10;
        monitor-exit(Sliver.class);
        return false;
    L10:
        if (init(false) == true) goto L13;
        monitor-exit(Sliver.class);
        return false;
    L13:
        boolean r15 = SliverAllThreadSupport.startAll(r10, r11, r12, r13, r14);     // Catch: Throwable -> L16
        monitor-exit(Sliver.class);
        return r15;
    }

    public static synchronized boolean stop(Thread r10) {
        monitor-enter(Sliver.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L12;
        onError(r10 + " stop failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return false;
    L12:
        e r11 = cache.remove(r10);     // Catch: Throwable -> L10
        if (r11 != null) goto L17;
        onError(r10 + " stop failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return true;
    L17:
        nStop(r11.f8091a);     // Catch: Throwable -> L10
        onStep(r10 + " stop success");     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return true;
    }

    public static boolean dump(Thread r10, String r11) {
        return dump(r10, r11, false);
    }

    public static boolean dump(Thread r10, String r11, String r12) {
        return dump(r10, r11, false, r12);
    }

    public static synchronized String getStackTrace(Thread r10) {
        monitor-enter(Sliver.class);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (init(false) == false) goto L8;
        long r11 = getThreadPeer(r10);     // Catch: Throwable -> L10
        if (r11 == 0) goto L15;
        String r12 = nGetStackTrace(r10, r11);     // Catch: Throwable -> L10
        monitor-exit(Sliver.class);
        return r12;
    L15:
        monitor-exit(Sliver.class);
        return "";
    L8:
        monitor-exit(Sliver.class);
        return "";
    }

    public static synchronized boolean dump(Thread r10, String r11, boolean r12) {
        monitor-enter(Sliver.class);
        boolean r13 = dump(r10, r11, r12, null);     // Catch: Throwable -> L8
        monitor-exit(Sliver.class);
        return r13;
    L8:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean dump(Thread r10, String r11, boolean r12, String r13) {
        monitor-enter(Sliver.class);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (isInit == true) goto L11;
        onError(r10 + " dump failed, because sliver is not init", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L11:
        e r14 = cache.get(r10);     // Catch: Throwable -> L9
        if (r14 != null) goto L16;
        onError(r10 + " stop failed, because thread is not sampling", new Throwable());     // Catch: Throwable -> L9
        monitor-exit(Sliver.class);
        return false;
    L16:
        c r15 = new c(r13, r14, r11, r10, r12);     // Catch: Throwable -> L9
        StringBuilder r16 = new StringBuilder();     // Catch: Throwable -> L9
        r16.append(r10);     // Catch: Throwable -> L9
        r16.append(" dump ");     // Catch: Throwable -> L9
        if (r12 == false) goto L19;
        String r17 = "sync";
    L20:
        r16.append(r17);     // Catch: Throwable -> L9
        r16.append(" start");     // Catch: Throwable -> L9
        onStep(r16.toString());     // Catch: Throwable -> L9
        if (r12 == false) goto L23;
        r15.run();     // Catch: Throwable -> L9
    L24:
        monitor-exit(Sliver.class);
        return true;
    L23:
        sExecutor.execute(r15);     // Catch: Throwable -> L9
        goto L24
    L19:
        r17 = "async";
        goto L20
    }
}
