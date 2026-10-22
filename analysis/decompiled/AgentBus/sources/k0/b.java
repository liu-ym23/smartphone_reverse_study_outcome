package k0;

import b0.a2;
import b0.b1;
import b0.k2;
import i5.l;
import l0.n;

/* loaded from: classes.dex */
public final class b implements k2 {

    /* renamed from: f, reason: collision with root package name */
    public f f5564f;

    /* renamed from: g, reason: collision with root package name */
    public c f5565g;

    /* renamed from: h, reason: collision with root package name */
    public String f5566h;

    /* renamed from: i, reason: collision with root package name */
    public Object f5567i;

    /* renamed from: j, reason: collision with root package name */
    public Object[] f5568j;

    /* renamed from: k, reason: collision with root package name */
    public l f5569k;

    /* renamed from: l, reason: collision with root package name */
    public final a2 f5570l = new a2(6, this);

    public b(f fVar, c cVar, String str, Object obj, Object[] objArr) {
        this.f5564f = fVar;
        this.f5565g = cVar;
        this.f5566h = str;
        this.f5567i = obj;
        this.f5568j = objArr;
    }

    public final void a() {
        String strN;
        c cVar = this.f5565g;
        if (this.f5569k != null) {
            throw new IllegalArgumentException(("entry(" + this.f5569k + ") is not null").toString());
        }
        if (cVar != null) {
            a2 a2Var = this.f5570l;
            Object objC = a2Var.c();
            if (objC == null || cVar.b(objC)) {
                this.f5569k = cVar.a(this.f5566h, a2Var);
                return;
            }
            if (objC instanceof n) {
                n nVar = (n) objC;
                if (nVar.b() == b1.f1108h || nVar.b() == b1.f1111k || nVar.b() == b1.f1109i) {
                    strN = "MutableState containing " + nVar.getValue() + " cannot be saved using the current SaveableStateRegistry. The default implementation only supports types which can be stored inside the Bundle. Please consider implementing a custom Saver for this class and pass it as a stateSaver parameter to rememberSaveable().";
                } else {
                    strN = "If you use a custom SnapshotMutationPolicy for your MutableState you have to write a custom Saver";
                }
            } else {
                strN = a.a.N(objC);
            }
            throw new IllegalArgumentException(strN);
        }
    }

    @Override // b0.k2
    public final void c() {
        a();
    }

    @Override // b0.k2
    public final void f() {
        l lVar = this.f5569k;
        if (lVar != null) {
            lVar.S();
        }
    }

    @Override // b0.k2
    public final void h() {
        l lVar = this.f5569k;
        if (lVar != null) {
            lVar.S();
        }
    }
}
