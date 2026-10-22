package r1;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f23676a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.apm.trace.a.C0075a f23677b;

    /* JADX INFO: renamed from: r1.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0348a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f23678a = null;

        static {
            f23678a = new a(null);
        }

        public static /* synthetic */ a a() {
            return f23678a;
        }
    }

    public /* synthetic */ a(C0348a r10) {
        this();
    }

    public static a b() {
        return b.a();
    }

    public synchronized c a() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.f23676a != null) goto L8;
        this.f23676a = new c.a().a();     // Catch: Throwable -> L6
    L8:
        c r10 = this.f23676a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    }

    public synchronized com.bytedance.apm.trace.a.C0075a c() {
        monitor-enter(this);
    L6:
        th = move-exception;
        throw th;
    L4:
        if (this.f23677b != null) goto L8;
        this.f23677b = new com.bytedance.apm.trace.a.C0075a.C0076a().e();     // Catch: Throwable -> L6
    L8:
        com.bytedance.apm.trace.a.C0075a r10 = this.f23677b;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    }

    public void d(String r10) {
        if (w0.c.B() == false) goto L6;
        Log.d("LaunchAnalysis", r10);
        return;
    }

    public void e(String r10) {
        Log.e("LaunchAnalysis", "notice!!!+ " + r10);
    }

    public synchronized void f(c r10) {
        monitor-enter(this);
        this.f23676a = r10;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public a() {
    }
}
