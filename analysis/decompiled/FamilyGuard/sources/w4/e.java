package w4;

import Z3.i;
import i4.p;

/* loaded from: classes.dex */
public final class e implements Z3.i {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f23717a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ Z3.i f23718b;

    public e(Throwable th, Z3.i iVar) {
        this.f23717a = th;
        this.f23718b = iVar;
    }

    @Override // Z3.i
    public Z3.i C(Z3.i iVar) {
        return this.f23718b.C(iVar);
    }

    @Override // Z3.i
    public Z3.i W(i.c<?> cVar) {
        return this.f23718b.W(cVar);
    }

    @Override // Z3.i
    public <E extends i.b> E a(i.c<E> cVar) {
        return (E) this.f23718b.a(cVar);
    }

    @Override // Z3.i
    public <R> R o(R r5, p<? super R, ? super i.b, ? extends R> pVar) {
        return (R) this.f23718b.o(r5, pVar);
    }
}
