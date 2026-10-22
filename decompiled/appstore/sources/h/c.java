package h;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class c extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f20137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Executor f20138d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Executor f20139e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f20140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f20141b;

    static {
        f20138d = new a();
        f20139e = new b();
    }

    public c() {
        d r10 = new d();
        this.f20141b = r10;
        this.f20140a = r10;
    }

    public static /* synthetic */ void e(Runnable r10) {
        i(r10);
    }

    public static /* synthetic */ void f(Runnable r10) {
        j(r10);
    }

    public static Executor g() {
        return f20139e;
    }

    public static c h() {
        if (f20137c == null) goto L7;
        return f20137c;
    L7:
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L9:
        if (f20137c != null) goto L13;
        f20137c = new c();     // Catch: Throwable -> L11
    L13:
        monitor-exit(c.class);     // Catch: Throwable -> L11
        return f20137c;
    }

    public static /* synthetic */ void i(Runnable r10) {
        h().d(r10);
    }

    public static /* synthetic */ void j(Runnable r10) {
        h().a(r10);
    }

    @Override // h.e
    public void a(Runnable r10) {
        this.f20140a.a(r10);
    }

    @Override // h.e
    public boolean c() {
        return this.f20140a.c();
    }

    @Override // h.e
    public void d(Runnable r10) {
        this.f20140a.d(r10);
    }
}
