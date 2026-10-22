package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* JADX INFO: loaded from: classes4.dex */
public class ThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f37664a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f37665b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static boolean f37666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static Handler f37667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static boolean f37668e;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ boolean f37669a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f37670b;

        static {
            f37669a = true;
        }

        public a() {
            this.f37670b = Process.myTid();
        }

        public void a() {
            if (f37669a == false) goto L5;
            return;
        L5:
            if (ThreadUtils.f() == false) goto L7;
            return;
        L7:
            if (this.f37670b != Process.myTid()) goto L10;
            return;
        L10:
            throw new AssertionError("Must only be used on a single thread.");
        }
    }

    public ThreadUtils() {
    }

    static /* synthetic */ boolean f() {
        return f37668e;
    }

    static {
        f37665b = new Object();
    }

    public static Handler a() {
        Object r0 = f37665b;
        monitor-enter(r0);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (f37667d == null) goto L7;
        boolean r1 = false;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L17
        if (r1 == false) goto L16;
        TraceEvent.a();
    L16:
        return f37667d;
    L7:
        if (f37666c == true) goto L10;
        f37667d = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L17
        r1 = true;
        goto L12
    L10:
        throw new RuntimeException("Did not yet override the UI thread");     // Catch: Throwable -> L17
    }

    @Deprecated
    public static <T> T a(Callable<T> r2) {
        return (T) b((Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.aiagent.plugin"));
    L5:
        e = move-exception;
        throw new RuntimeException("Error occurred waiting for callable", e);
    }

    @Deprecated
    public static <T> T b(Callable<T> r2) {
        FutureTask r0 = new FutureTask((Callable) ZeusTransformUtils.wrapperContextForParams(r2, Callable.class, "com.obric.aiagent.plugin"));
        a(r0);
        return (T) r0.get();
    L5:
        e = move-exception;
        throw new RuntimeException("Interrupted waiting for callable", e);
    }

    @Deprecated
    public static <T> FutureTask<T> a(FutureTask<T> r1) {
        if (d() == false) goto L5;
        r1.run();
    L6:
        return r1;
    L5:
        b(r1);
        goto L6
    }

    @Deprecated
    public static void a(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        if (d() == false) goto L5;
        r3.run();
        return;
    L5:
        a().post(r3);
    }

    @Deprecated
    public static <T> FutureTask<T> b(FutureTask<T> r1) {
        a().post(r1);
        return r1;
    }

    @Deprecated
    public static void b(Runnable r2) {
        Runnable r3 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin");
        a().post(r3);
    }

    public static void b() {
        if (f37668e == false) goto L6;
        return;
    L6:
        if (f37664a == false) goto L8;
        return;
    L8:
        if (d() == false) goto L11;
        return;
    L11:
        throw new AssertionError("Must be called on the UI thread.");
    }

    public static void c() {
        if (f37668e == false) goto L6;
        return;
    L6:
        if (f37664a == false) goto L8;
        return;
    L8:
        if (d() == true) goto L11;
        return;
    L11:
        throw new AssertionError("Must be called on a thread other than UI.");
    }

    public static boolean d() {
        if (a().getLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static Looper e() {
        return a().getLooper();
    }

    public static void setThreadPriorityAudio(int r1) {
        Process.setThreadPriority(r1, -16);
    }

    private static boolean isThreadPriorityAudio(int r1) {
        if (Process.getThreadPriority(r1) != (-16)) goto L5;
        return true;
    L5:
        return false;
    }
}
