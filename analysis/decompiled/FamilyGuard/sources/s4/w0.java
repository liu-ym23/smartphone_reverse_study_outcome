package s4;

import a4.C0428b;
import y4.C1327a;

/* loaded from: classes.dex */
final class w0 extends D0 {

    /* renamed from: d, reason: collision with root package name */
    private final Z3.e<V3.v> f20391d;

    public w0(Z3.i iVar, i4.p<? super I, ? super Z3.e<? super V3.v>, ? extends Object> pVar) {
        super(iVar, false);
        this.f20391d = C0428b.a(pVar, this, this);
    }

    @Override // s4.u0
    protected void u0() throws Throwable {
        C1327a.b(this.f20391d, this);
    }
}
