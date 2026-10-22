package k;

import java.util.concurrent.Executor;

/* renamed from: k.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C4794c extends AbstractC4796e {

    /* renamed from: c, reason: collision with root package name */
    public static volatile C4794c f34564c;

    /* renamed from: d, reason: collision with root package name */
    public static final Executor f34565d = new Executor() { // from class: k.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            C4794c.g().c(runnable);
        }
    };

    /* renamed from: e, reason: collision with root package name */
    public static final Executor f34566e = new Executor() { // from class: k.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            C4794c.g().a(runnable);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public AbstractC4796e f34567a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC4796e f34568b;

    public C4794c() {
        C4795d c4795d = new C4795d();
        this.f34568b = c4795d;
        this.f34567a = c4795d;
    }

    public static Executor f() {
        return f34566e;
    }

    public static C4794c g() {
        if (f34564c != null) {
            return f34564c;
        }
        synchronized (C4794c.class) {
            try {
                if (f34564c == null) {
                    f34564c = new C4794c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f34564c;
    }

    @Override // k.AbstractC4796e
    public void a(Runnable runnable) {
        this.f34567a.a(runnable);
    }

    @Override // k.AbstractC4796e
    public boolean b() {
        return this.f34567a.b();
    }

    @Override // k.AbstractC4796e
    public void c(Runnable runnable) {
        this.f34567a.c(runnable);
    }
}
