package x4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import s4.AbstractC1056E;
import s4.C1058G;
import s4.InterfaceC1080k;
import s4.Q;

/* renamed from: x4.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1313m extends AbstractC1056E implements Q {

    /* renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f23863h = AtomicIntegerFieldUpdater.newUpdater(C1313m.class, "runningWorkers$volatile");

    /* renamed from: c, reason: collision with root package name */
    private final AbstractC1056E f23864c;

    /* renamed from: d, reason: collision with root package name */
    private final int f23865d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ Q f23866e;

    /* renamed from: f, reason: collision with root package name */
    private final r<Runnable> f23867f;

    /* renamed from: g, reason: collision with root package name */
    private final Object f23868g;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* renamed from: x4.m$a */
    private final class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private Runnable f23869a;

        public a(Runnable runnable) {
            this.f23869a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i5 = 0;
            while (true) {
                try {
                    this.f23869a.run();
                } catch (Throwable th) {
                    C1058G.a(Z3.j.f6656a, th);
                }
                Runnable runnableL0 = C1313m.this.l0();
                if (runnableL0 == null) {
                    return;
                }
                this.f23869a = runnableL0;
                i5++;
                if (i5 >= 16 && C1313m.this.f23864c.c0(C1313m.this)) {
                    C1313m.this.f23864c.Y(C1313m.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1313m(AbstractC1056E abstractC1056E, int i5) {
        this.f23864c = abstractC1056E;
        this.f23865d = i5;
        Q q5 = abstractC1056E instanceof Q ? (Q) abstractC1056E : null;
        this.f23866e = q5 == null ? s4.O.a() : q5;
        this.f23867f = new r<>(false);
        this.f23868g = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Runnable l0() {
        while (true) {
            Runnable runnableE = this.f23867f.e();
            if (runnableE != null) {
                return runnableE;
            }
            synchronized (this.f23868g) {
                f23863h.decrementAndGet(this);
                if (this.f23867f.c() == 0) {
                    return null;
                }
                f23863h.incrementAndGet(this);
            }
        }
    }

    private final boolean m0() {
        synchronized (this.f23868g) {
            if (f23863h.get(this) >= this.f23865d) {
                return false;
            }
            f23863h.incrementAndGet(this);
            return true;
        }
    }

    @Override // s4.AbstractC1056E
    public void Y(Z3.i iVar, Runnable runnable) {
        Runnable runnableL0;
        this.f23867f.a(runnable);
        if (f23863h.get(this) >= this.f23865d || !m0() || (runnableL0 = l0()) == null) {
            return;
        }
        this.f23864c.Y(this, new a(runnableL0));
    }

    @Override // s4.Q
    public void r(long j5, InterfaceC1080k<? super V3.v> interfaceC1080k) {
        this.f23866e.r(j5, interfaceC1080k);
    }
}
