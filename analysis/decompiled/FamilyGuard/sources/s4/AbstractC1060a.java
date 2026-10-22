package s4;

/* renamed from: s4.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1060a<T> extends u0 implements n0, Z3.e<T>, I {

    /* renamed from: c, reason: collision with root package name */
    private final Z3.i f20329c;

    public AbstractC1060a(Z3.i iVar, boolean z5, boolean z6) {
        super(z6);
        if (z5) {
            g0((n0) iVar.a(n0.f20363P));
        }
        this.f20329c = iVar.C(this);
    }

    @Override // s4.I
    public Z3.i G() {
        return this.f20329c;
    }

    protected void J0(Object obj) {
        l(obj);
    }

    protected void K0(Throwable th, boolean z5) {
    }

    protected void L0(T t5) {
    }

    public final <R> void M0(K k5, R r5, i4.p<? super R, ? super Z3.e<? super T>, ? extends Object> pVar) {
        k5.d(pVar, r5, this);
    }

    @Override // s4.u0, s4.n0
    public boolean c() {
        return super.c();
    }

    @Override // s4.u0
    public final void f0(Throwable th) {
        C1058G.a(this.f20329c, th);
    }

    @Override // Z3.e
    public final Z3.i getContext() {
        return this.f20329c;
    }

    @Override // s4.u0
    public String o0() {
        String strB = C1055D.b(this.f20329c);
        if (strB == null) {
            return super.o0();
        }
        return '\"' + strB + "\":" + super.o0();
    }

    @Override // Z3.e
    public final void resumeWith(Object obj) {
        Object objM0 = m0(C1053B.d(obj, null, 1, null));
        if (objM0 == v0.f20385b) {
            return;
        }
        J0(objM0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s4.u0
    protected final void t0(Object obj) {
        if (!(obj instanceof C1096y)) {
            L0(obj);
        } else {
            C1096y c1096y = (C1096y) obj;
            K0(c1096y.f20398a, c1096y.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s4.u0
    public String z() {
        return M.a(this) + " was cancelled";
    }
}
