package x4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import s4.AbstractC1056E;
import s4.AbstractC1061a0;
import s4.C1053B;
import s4.C1082l;
import s4.C1097z;
import s4.H0;
import s4.InterfaceC1080k;
import s4.U;

/* renamed from: x4.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C1310j<T> extends U<T> implements kotlin.coroutines.jvm.internal.e, Z3.e<T> {

    /* renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f23856h = AtomicReferenceFieldUpdater.newUpdater(C1310j.class, Object.class, "_reusableCancellableContinuation$volatile");
    private volatile /* synthetic */ Object _reusableCancellableContinuation$volatile;

    /* renamed from: d, reason: collision with root package name */
    public final AbstractC1056E f23857d;

    /* renamed from: e, reason: collision with root package name */
    public final Z3.e<T> f23858e;

    /* renamed from: f, reason: collision with root package name */
    public Object f23859f;

    /* renamed from: g, reason: collision with root package name */
    public final Object f23860g;

    /* JADX WARN: Multi-variable type inference failed */
    public C1310j(AbstractC1056E abstractC1056E, Z3.e<? super T> eVar) {
        super(-1);
        this.f23857d = abstractC1056E;
        this.f23858e = eVar;
        this.f23859f = C1311k.f23861a;
        this.f23860g = C1298J.b(getContext());
    }

    private final C1082l<?> o() {
        Object obj = f23856h.get(this);
        if (obj instanceof C1082l) {
            return (C1082l) obj;
        }
        return null;
    }

    @Override // s4.U
    public void a(Object obj, Throwable th) {
        if (obj instanceof C1097z) {
            ((C1097z) obj).f20400b.invoke(th);
        }
    }

    @Override // s4.U
    public Z3.e<T> g() {
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        Z3.e<T> eVar = this.f23858e;
        if (eVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) eVar;
        }
        return null;
    }

    @Override // Z3.e
    public Z3.i getContext() {
        return this.f23858e.getContext();
    }

    @Override // s4.U
    public Object l() {
        Object obj = this.f23859f;
        this.f23859f = C1311k.f23861a;
        return obj;
    }

    public final void m() {
        while (f23856h.get(this) == C1311k.f23862b) {
        }
    }

    public final C1082l<T> n() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f23856h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                f23856h.set(this, C1311k.f23862b);
                return null;
            }
            if (obj instanceof C1082l) {
                if (f23856h.compareAndSet(this, obj, C1311k.f23862b)) {
                    return (C1082l) obj;
                }
            } else if (obj != C1311k.f23862b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final boolean q() {
        return f23856h.get(this) != null;
    }

    public final boolean r(Throwable th) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f23856h;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            C1294F c1294f = C1311k.f23862b;
            if (j4.k.b(obj, c1294f)) {
                if (f23856h.compareAndSet(this, c1294f, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (f23856h.compareAndSet(this, obj, null)) {
                    return false;
                }
            }
        }
    }

    @Override // Z3.e
    public void resumeWith(Object obj) {
        Z3.i context = this.f23858e.getContext();
        Object objD = C1053B.d(obj, null, 1, null);
        if (this.f23857d.c0(context)) {
            this.f23859f = objD;
            this.f20322c = 0;
            this.f23857d.Y(context, this);
            return;
        }
        AbstractC1061a0 abstractC1061a0B = H0.f20303a.b();
        if (abstractC1061a0B.p0()) {
            this.f23859f = objD;
            this.f20322c = 0;
            abstractC1061a0B.l0(this);
            return;
        }
        abstractC1061a0B.n0(true);
        try {
            Z3.i context2 = getContext();
            Object objC = C1298J.c(context2, this.f23860g);
            try {
                this.f23858e.resumeWith(obj);
                V3.v vVar = V3.v.f5542a;
                while (abstractC1061a0B.w0()) {
                }
            } finally {
                C1298J.a(context2, objC);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public final void s() {
        m();
        C1082l<?> c1082lO = o();
        if (c1082lO != null) {
            c1082lO.s();
        }
    }

    public final Throwable t(InterfaceC1080k<?> interfaceC1080k) {
        C1294F c1294f;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f23856h;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            c1294f = C1311k.f23862b;
            if (obj != c1294f) {
                if (obj instanceof Throwable) {
                    if (f23856h.compareAndSet(this, obj, null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.");
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!f23856h.compareAndSet(this, c1294f, interfaceC1080k));
        return null;
    }

    public String toString() {
        return "DispatchedContinuation[" + this.f23857d + ", " + s4.M.c(this.f23858e) + ']';
    }
}
