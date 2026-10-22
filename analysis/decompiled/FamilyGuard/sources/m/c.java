package m;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class c extends e {

    /* renamed from: c, reason: collision with root package name */
    private static volatile c f18801c;

    /* renamed from: d, reason: collision with root package name */
    private static final Executor f18802d = new Executor() { // from class: m.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.h().d(runnable);
        }
    };

    /* renamed from: e, reason: collision with root package name */
    private static final Executor f18803e = new Executor() { // from class: m.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.h().a(runnable);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private e f18804a;

    /* renamed from: b, reason: collision with root package name */
    private final e f18805b;

    private c() {
        d dVar = new d();
        this.f18805b = dVar;
        this.f18804a = dVar;
    }

    public static Executor g() {
        return f18803e;
    }

    public static c h() {
        if (f18801c != null) {
            return f18801c;
        }
        synchronized (c.class) {
            try {
                if (f18801c == null) {
                    f18801c = new c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f18801c;
    }

    @Override // m.e
    public void a(Runnable runnable) {
        this.f18804a.a(runnable);
    }

    @Override // m.e
    public boolean c() {
        return this.f18804a.c();
    }

    @Override // m.e
    public void d(Runnable runnable) {
        this.f18804a.d(runnable);
    }
}
