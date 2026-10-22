package com.bytedance.apm.block.trace;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import com.byted.cast.common.api.FirewallError;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import es3.h;
import es3.m;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes14.dex */
public class MethodCollector {
    public static final int DEFAULT_STACK_DEPTH = 5;
    public static final int METHOD_ID_DISPATCH = 1048574;
    private static final int METHOD_ID_MAX = 1048575;
    private static final int STATUS_DEFAULT = Integer.MAX_VALUE;
    private static final int STATUS_EXPIRED_START = -2;
    private static final int STATUS_NO_PERMIT = -4;
    private static final int STATUS_OUT_RELEASE = -3;
    private static final int STATUS_READY = 1;
    private static final int STATUS_STARTED = 2;
    private static final int STATUS_STOPPED = -1;
    private static final String TAG = "MethodCollector";
    private static boolean assertIn;
    private static Runnable checkStartExpiredRunnable;
    private static boolean isPauseUpdateTime;
    private static b27.a looperMonitorListener;
    private static long[] sBuffer;
    private static volatile long sCurrentDiffTime;
    private static volatile long sDiffTime;
    private static volatile boolean sDontRecord;
    private static Handler sHandler;
    private static int sIndex;
    private static g sIndexRecordHead;
    private static g sIndexRecordTail;
    private static MethodCollector sInstance;
    private static int sLastIndex;
    private static Thread sMainThread;
    private static volatile Runnable sReleaseOnMainThread;
    private static HandlerThread sTimerUpdateThread;
    private static Runnable sUpdateDiffTimeRunnable;
    private static volatile int status;
    private static final Object statusLock = null;
    private static Object updateTimeLock;

    public static class a extends b27.a {
        @Override // b27.a
        public final void a() {
            this.f17030a = false;
            MethodCollector.access$300();
        }

        @Override // b27.a
        public final boolean c() {
            if (MethodCollector.access$000() == null) goto L6;
            MethodCollector.access$000().run();
            MethodCollector.access$002(null);
        L6:
            if (MethodCollector.access$100() >= 1) goto L10;
            return false;
        L10:
            return true;
        }

        public a() {
        }

        @Override // b27.a
        public final void b(String r100) {
            this.f17030a = true;
            MethodCollector.access$200();
        }
    }

    public static class b implements Runnable {
        public b() {
        }

        public static void a() {
        L16:
        L15:
            return;
        L3:
            if (MethodCollector.access$400() == true) goto L7;
            if (MethodCollector.access$100() <= (-1)) goto L7;
            MethodCollector.access$502(MethodCollector.access$600() - MethodCollector.access$700());     // Catch: InterruptedException -> L15
            MethodCollector.access$502(MethodCollector.access$500() & 8796093022207L);     // Catch: InterruptedException -> L15
            SystemClock.sleep(5);     // Catch: InterruptedException -> L15
        L7:
            Object r100 = MethodCollector.access$800();     // Catch: InterruptedException -> L15
            monitor-enter(r100);     // Catch: InterruptedException -> L15
            MethodCollector.access$800().wait();     // Catch: Throwable -> L12
            monitor-exit(r100);     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            throw th;     // Catch: InterruptedException -> L15
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MethodCollector.access$900();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MethodCollector.access$1000().removeCallbacksAndMessages(null);     // Catch: Throwable -> L4
            b27.e.h(MethodCollector.access$1100());     // Catch: Throwable -> L4
            MethodCollector.access$1200().quit();     // Catch: Throwable -> L4
            MethodCollector.access$1302(null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            MethodCollector.access$1000().removeCallbacksAndMessages(null);     // Catch: Throwable -> L4
            b27.e.h(MethodCollector.access$1100());     // Catch: Throwable -> L4
            MethodCollector.access$1200().quit();     // Catch: Throwable -> L4
            MethodCollector.access$1302(null);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object r100 = MethodCollector.access$1400();     // Catch: Throwable -> L14
            monitor-enter(r100);     // Catch: Throwable -> L14
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
        L5:
            if (MethodCollector.access$100() != Integer.MAX_VALUE) goto L7;
        L8:
            MethodCollector.access$102(-2);     // Catch: Throwable -> L11
            MethodCollector.access$1502(true);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L11
        L17:
            return;
        L7:
            if (MethodCollector.access$100() != 1) goto L9;
        L14:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L22;
            throw th;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f190381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f190382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public g f190383c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public g f190384d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f190385e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f190386f;

        public final String toString() {
            return "index:" + this.f190381a + ",\tisValid:true source:" + this.f190385e;
        }

        public g(int r100) {
            this.f190381a = r100;
        }
    }

    public MethodCollector() {
    }

    private static void dispatchEnd() {
        isPauseUpdateTime = true;
    }

    private static long getTime(long r100) {
        return r100 & 8796093022207L;
    }

    public long[] copyAllData() {
        g r100 = sIndexRecordHead;     // Catch: Throwable -> L14
        if (r100 == null) goto L17;
        g r101 = sIndexRecordTail;     // Catch: Throwable -> L14
        if (r101 == null) goto L18;
        if (r100 == r101) goto L19;
        int r102 = r100.f190382b;     // Catch: Throwable -> L14
        if (r102 != 0) goto L12;
        r102 = sIndex - 1;     // Catch: Throwable -> L14
    L12:
        return copyData(r101.f190381a, r102);
    L19:
        return null;
    L18:
        return null;
    L17:
        return null;
    L20:
        return null;
    }

    static {
        sInstance = new MethodCollector();
        status = Integer.MAX_VALUE;
        sDontRecord = false;
        Object r100 = new Object();
        statusLock = r100;
        sBuffer = null;
        sIndex = 0;
        sLastIndex = -1;
        assertIn = false;
        sCurrentDiffTime = getCurrentTime();
        sDiffTime = sCurrentDiffTime;
        sMainThread = ThreadMethodProxy.getLooperThread(Looper.getMainLooper());
        sReleaseOnMainThread = null;
        sTimerUpdateThread = getTimerUpdateThread();
        sHandler = new Handler(sTimerUpdateThread.getLooper());
        updateTimeLock = new Object();
        isPauseUpdateTime = false;
        checkStartExpiredRunnable = null;
        looperMonitorListener = new a();
        sUpdateDiffTimeRunnable = new b();
        if (Build.VERSION.SDK_INT >= 24) goto L5;
        status = -4;
        sDontRecord = true;
    L17:
        sHandler.postDelayed(new c(), 15000);
        return;
    L5:
        sBuffer = new long[FirewallError.FIREWALL_OK];
        if (status != Integer.MAX_VALUE) goto L16;
        monitor-enter(r100);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (status != Integer.MAX_VALUE) goto L11;
        realExecute();     // Catch: Throwable -> L13
        status = 1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r100);     // Catch: Throwable -> L13
    L16:
        i(METHOD_ID_DISPATCH, 0);
        maskIndex("EvilMethodTracer#message_0", b27.a.f17028b);
        goto L17
    }

    private static void dispatchBegin() {
        sCurrentDiffTime = b27.a.f17028b - sDiffTime;
        isPauseUpdateTime = false;
        Object r100 = updateTimeLock;
        monitor-enter(r100);
        updateTimeLock.notify();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static int getLastMethodIndex() {
        return sIndex - 1;
    }

    public static long getLastMethodTime() {
        return getTime(sBuffer[sIndex - 1]);
    }

    private static HandlerThread getTimerUpdateThread() {
        PthreadHandlerThreadV2 r100 = new PthreadHandlerThreadV2("trace_time_update_thread");
        ThreadMethodProxy.start(r100);
        return r100;
    }

    public static boolean isRealTrace() {
        if (status >= 1) goto L7;
        return false;
    L7:
        return true;
    }

    private static void realRelease() {
        Object r100 = statusLock;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (status != Integer.MAX_VALUE) goto L7;
    L8:
        status = -3;     // Catch: Throwable -> L11
        sDontRecord = true;     // Catch: Throwable -> L11
        sReleaseOnMainThread = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L7:
        if (status != (-4)) goto L9;
        goto L8
    }

    public static void releaseForOpt() {
        Object r100 = statusLock;
        monitor-enter(r100);
        status = -3;     // Catch: Throwable -> L8
        sDontRecord = true;     // Catch: Throwable -> L8
        sReleaseOnMainThread = new e();     // Catch: Throwable -> L8
        monitor-exit(r100);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public static void unRegisterListener() {
        b27.e.h(looperMonitorListener);
    }

    public boolean isAlive() {
        if (status < 2) goto L5;
        return true;
    L5:
        return false;
    }

    public void onStart() {
        Object r100 = statusLock;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (status < 2) goto L7;
    L13:
        monitor-exit(r100);     // Catch: Throwable -> L15
        return;
    L7:
        if (status < (-2)) goto L13;
        sHandler.removeCallbacks(checkStartExpiredRunnable);     // Catch: Throwable -> L15
        if (sBuffer == null) goto L12;
        status = 2;     // Catch: Throwable -> L15
        sDontRecord = false;     // Catch: Throwable -> L15
        goto L13
    L12:
        throw new RuntimeException("MethodCollector sBuffer == null");     // Catch: Throwable -> L15
    }

    public void onStop() {
        Object r100 = statusLock;
        monitor-enter(r100);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (status != 2) goto L7;
        status = -1;     // Catch: Throwable -> L9
        sDontRecord = true;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
    }

    public static /* synthetic */ long access$600() {
        return getCurrentTime();
    }

    private static long getCurrentTime() {
        return SystemClock.uptimeMillis();
    }

    public static String getVisibleScene() {
        return ActivityLifeObserver.getInstance().getTopActivityClassName();
    }

    private static void realExecute() {
        sCurrentDiffTime = getCurrentTime() - sDiffTime;
        sHandler.removeCallbacksAndMessages(null);
        sHandler.postDelayed(sUpdateDiffTimeRunnable, 5);
        Handler r100 = sHandler;
        f r101 = new f();
        checkStartExpiredRunnable = r101;
        r100.postDelayed(r101, 15000);
        b27.a r102 = looperMonitorListener;
        CopyOnWriteArrayList<b27.a> r103 = b27.e.f17037d;
        monitor-enter(r103);
        if (r102 != null) goto L15;
    L10:
        monitor-exit(r103);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L15:
        if (r103.contains(r102) == true) goto L10;
        r103.add(r102);     // Catch: Throwable -> L12
        if (h.f473717z.f473740w == false) goto L10;
        b27.e.g();     // Catch: Throwable -> L12
        goto L10
    }

    public static /* synthetic */ Runnable access$000() {
        return sReleaseOnMainThread;
    }

    public static /* synthetic */ int access$100() {
        return status;
    }

    public static /* synthetic */ Handler access$1000() {
        return sHandler;
    }

    public static /* synthetic */ b27.a access$1100() {
        return looperMonitorListener;
    }

    public static /* synthetic */ HandlerThread access$1200() {
        return sTimerUpdateThread;
    }

    public static /* synthetic */ Object access$1400() {
        return statusLock;
    }

    public static /* synthetic */ void access$200() {
        dispatchBegin();
    }

    public static /* synthetic */ void access$300() {
        dispatchEnd();
    }

    public static /* synthetic */ boolean access$400() {
        return isPauseUpdateTime;
    }

    public static /* synthetic */ long access$500() {
        return sCurrentDiffTime;
    }

    public static /* synthetic */ long access$700() {
        return sDiffTime;
    }

    public static /* synthetic */ Object access$800() {
        return updateTimeLock;
    }

    public static /* synthetic */ void access$900() {
        realRelease();
    }

    public static long getCurrentDiffTime() {
        return sCurrentDiffTime;
    }

    public static long getDiffTime() {
        return sDiffTime;
    }

    public static MethodCollector getInstance() {
        return sInstance;
    }

    public static /* synthetic */ Runnable access$002(Runnable r100) {
        sReleaseOnMainThread = r100;
        return r100;
    }

    public static /* synthetic */ int access$102(int r100) {
        status = r100;
        return r100;
    }

    public static /* synthetic */ long[] access$1302(long[] r100) {
        sBuffer = r100;
        return r100;
    }

    public static /* synthetic */ boolean access$1502(boolean r100) {
        sDontRecord = r100;
        return r100;
    }

    public static /* synthetic */ long access$502(long r100) {
        sCurrentDiffTime = r100;
        return r100;
    }

    public long[] copyData(g r100) {
        return copyData(r100, new g(sIndex - 1));
    }

    public g getCurrentMethodIndex(String r100) {
        int r101 = sIndex - 1;
        g r102 = new g(r101);
        r102.f190385e = r100;
        if (r101 < 0) goto L7;
        long[] r103 = sBuffer;
        if (r101 >= r103.length) goto L7;
        r102.f190386f = getTime(r103[r101]);
    L7:
        return r102;
    }

    public static void i(int r100, long r101) {
        if (sDontRecord == false) goto L6;
        return;
    L6:
        if (r100 < METHOD_ID_MAX) goto L9;
        return;
    L9:
        if (ThreadMethodProxy.currentThread() == sMainThread) goto L11;
        return;
    L11:
        if (assertIn == false) goto L13;
        return;
    L13:
        assertIn = true;
        if (r101 == 0) goto L16;
        sCurrentDiffTime = r101 - sDiffTime;
        sCurrentDiffTime &= 8796093022207L;
    L16:
        long r102 = ((((long) r100) << 43) | Long.MIN_VALUE) | sCurrentDiffTime;
        long[] r103 = sBuffer;
        int r104 = sIndex;
        r103[r104] = r102;
        int r105 = r104 + 1;
        sIndex = r105;
        if (r105 != 600000) goto L19;
        sIndex = 0;
    L19:
        assertIn = false;
        g r106 = sIndexRecordTail;
        if (r106 != null) goto L23;
        return;
    L23:
        if (r106.f190381a != sIndex) goto L30;
        g r107 = r106.f190384d;
        sIndexRecordTail = r107;
        if (r107 == null) goto L27;
        r107.f190383c = null;
        return;
    L27:
        sIndexRecordHead = null;
        return;
    }

    public static g maskIndex(String r100, long r101) {
        if (sIndexRecordHead != null) goto L9;
        g r102 = new g(sIndex);
        sIndexRecordHead = r102;
        if (r101 > 0) goto L7;
        r101 = SystemClock.uptimeMillis();
    L7:
        r102.f190386f = r101;
        g r103 = sIndexRecordHead;
        r103.f190385e = r100;
        sIndexRecordTail = r103;
        return r103;
    L9:
        int r104 = sIndex;
        g r105 = new g(r104);
        if (r101 > 0) goto L12;
        r101 = SystemClock.uptimeMillis();
    L12:
        r105.f190386f = r101;
        r105.f190385e = r100;
        g r106 = sIndexRecordHead;
        r105.f190383c = r106;
        r106.f190382b = r104 - 1;
        r106.f190384d = r105;
        sIndexRecordHead = r105;
        return r105;
    }

    public static void o(int r100, long r101) {
        if (sDontRecord == false) goto L6;
        return;
    L6:
        if (r100 < METHOD_ID_MAX) goto L9;
        return;
    L9:
        if (ThreadMethodProxy.currentThread() == sMainThread) goto L11;
        return;
    L11:
        if (r101 == 0) goto L13;
        sCurrentDiffTime = r101 - sDiffTime;
        sCurrentDiffTime &= 8796093022207L;
    L13:
        long r102 = ((((long) r100) << 43) | 0) | sCurrentDiffTime;
        long[] r103 = sBuffer;
        int r104 = sIndex;
        r103[r104] = r102;
        int r105 = r104 + 1;
        sIndex = r105;
        if (r105 != 600000) goto L16;
        sIndex = 0;
    L16:
        g r106 = sIndexRecordTail;
        if (r106 != null) goto L19;
        return;
    L19:
        if (r106.f190381a != sIndex) goto L27;
        g r107 = r106.f190384d;
        sIndexRecordTail = r107;
        if (r107 == null) goto L23;
        r107.f190383c = null;
        return;
    L23:
        sIndexRecordHead = null;
        return;
    }

    public long[] copyData(int r100, int r101) {
        long[] r102 = new long[0];
        int r103 = Math.max(0, r100);
        int r104 = Math.max(0, r101);
        if (r104 <= r103) goto L5;
        int r105 = (r104 - r103) + 1;
        long[] r106 = new long[r105];
        System.arraycopy(sBuffer, r103, r106, 0, r105);
        return r106;
    L5:
        if (r104 >= r103) goto L9;
        int r107 = r104 + 1;
        long[] r108 = sBuffer;
        long[] r109 = new long[(r108.length - r103) + r107];
        System.arraycopy(r108, r103, r109, 0, r108.length - r103);
        long[] r110 = sBuffer;
        System.arraycopy(r110, 0, r109, r110.length - r103, r107);
        return r109;
    L9:
        return r102;
    }

    public String evilMethodString(long[] r100, long r101) {
        if (r100 != null) goto L5;
        return "";
    L5:
        LinkedList r102 = new LinkedList();
        z37.a.f(r100, r102, r101);
        ListIterator r103 = r102.listIterator(r102.size());
    L7:
        if (r103.hasPrevious() == false) goto L13;
        m r104 = (m) r103.previous();
        if (r104 == null) goto L7;
        if (r104.f473763b >= 1) goto L7;
        r103.remove();
        goto L7
    L13:
        StringBuilder r105 = new StringBuilder();
        z37.a.e(r102, r105);
        return r105.toString();
    }

    public String getEvilMethod(long r100, long r101) {
        long r102 = SystemClock.uptimeMillis();
        return evilMethodString(copyData(r100, r101), r102);
    }

    private long[] copyData(long r100, long r101) {
        g r102 = sIndexRecordHead;
        if (r102 == null) goto L19;
        g r103 = sIndexRecordTail;
        if (r103 == null) goto L28;
    L7:
        if (r102 == r103) goto L14;
        g r104 = r102.f190383c;
        if (r104.f190386f > r101) goto L10;
        g r105 = r103.f190384d;
        if (r105.f190386f >= r100) goto L14;
        r103 = r105;
        goto L7
    L10:
        r102 = r104;
    L14:
        int r106 = r102.f190382b;
        if (r106 != 0) goto L18;
        r106 = sIndex - 1;
    L18:
        return copyData(r103.f190381a, r106);
    L28:
        return null;
    L19:
        return null;
    }

    public long[] copyData(g r100, g r101) {
        if (status != (-3)) goto L6;
        return null;
    L6:
        long[] r102 = new long[0];
        r100.getClass();     // Catch: OutOfMemoryError -> L9
        r101.getClass();     // Catch: OutOfMemoryError -> L9
        return copyData(r100.f190381a - 1, r101.f190381a);
    L9:
        return r102;
    }
}
