package s4;

import Z3.i;

/* loaded from: classes.dex */
final class K0 implements i.b, i.c<K0> {

    /* renamed from: a, reason: collision with root package name */
    public static final K0 f20314a = new K0();

    private K0() {
    }

    @Override // Z3.i
    public Z3.i C(Z3.i iVar) {
        return i.b.a.d(this, iVar);
    }

    @Override // Z3.i
    public Z3.i W(i.c<?> cVar) {
        return i.b.a.c(this, cVar);
    }

    @Override // Z3.i.b, Z3.i
    public <E extends i.b> E a(i.c<E> cVar) {
        return (E) i.b.a.b(this, cVar);
    }

    @Override // Z3.i.b
    public i.c<?> getKey() {
        return this;
    }

    @Override // Z3.i
    public <R> R o(R r5, i4.p<? super R, ? super i.b, ? extends R> pVar) {
        return (R) i.b.a.a(this, r5, pVar);
    }
}
