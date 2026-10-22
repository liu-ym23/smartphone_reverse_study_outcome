package u5;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.apm.constant.PerfConsts;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class f24864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Object f24865b;

    /* JADX INFO: renamed from: u5.a$a, reason: collision with other inner class name */
    public static class RunnableC0387a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f24866a;

        public RunnableC0387a(Object r10) {
            this.f24866a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.a(d6.d.c(a.b(), "currentActivityThread", new Object[0]));     // Catch: Throwable -> L11 Exception -> L20
            Object r10 = this.f24866a;
            monitor-enter(r10);
            this.f24866a.notify();     // Catch: Throwable -> L8
            monitor-exit(r10);     // Catch: Throwable -> L8
            return;
        L8:
            th = move-exception;
            throw th;
        L11:
            th = move-exception;
            monitor-enter(this.f24866a);
            this.f24866a.notify();     // Catch: Throwable -> L17
            throw th;
        L17:
            th = move-exception;
            throw th;
        L21:
            monitor-enter(this.f24866a);
            this.f24866a.notify();     // Catch: Throwable -> L25
            return;
        L25:
            th = move-exception;
            throw th;
        }
    }

    public static /* synthetic */ Object a(Object r10) {
        f24865b = r10;
        return r10;
    }

    public static /* synthetic */ Class b() {
        return f24864a;
    }

    public static Object c() {
        if (f24865b != null) goto L37;
        monitor-enter(a.class);     // Catch: Exception -> L34
    L11:
        th = move-exception;
        throw th;     // Catch: Exception -> L34
    L7:
        if (f24865b != null) goto L15;
        if (f24864a != null) goto L13;
        f24864a = Class.forName("android.app.ActivityThread");     // Catch: Throwable -> L11
    L13:
        f24865b = d6.d.c(f24864a, "currentActivityThread", new Object[0]);     // Catch: Throwable -> L11
    L15:
        if (f24865b == null) goto L17;
    L30:
        monitor-exit(a.class);     // Catch: Throwable -> L11
        goto L37
    L17:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L30;
        Object r10 = new Object();     // Catch: Throwable -> L11
        new Handler(Looper.getMainLooper()).post(new RunnableC0387a(r10));     // Catch: Throwable -> L11
        if (f24865b != null) goto L30;
        monitor-enter(r10);     // Catch: Throwable -> L11
        r10.wait(PerfConsts.DEFAULT_SERIOUS_BLOCK_INTERVAL_MS);     // Catch: Throwable -> L24 InterruptedException -> L38
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L26:
        monitor-exit(r10);     // Catch: Throwable -> L24
    L34:
        e = move-exception;
        e.printStackTrace();
    L37:
        return f24865b;
    }
}
