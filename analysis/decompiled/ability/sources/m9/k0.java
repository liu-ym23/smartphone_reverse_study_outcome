package m9;

import s9.AbstractC1921a;

/* loaded from: classes4.dex */
public final class k0 extends q0 {
    public final H7.c d;

    public k0(H7.h hVar, S7.n nVar) {
        super(hVar, false);
        this.d = U7.a.u(this, this, nVar);
    }

    @Override // kotlinx.coroutines.c
    public final void a0() {
        try {
            AbstractC1921a.h(U7.a.I(this.d), C7.r.f317a);
        } catch (Throwable th) {
            resumeWith(kotlin.b.a(th));
            throw th;
        }
    }
}
