package Z3;

import Z3.i;
import i4.p;
import j4.k;

/* loaded from: classes.dex */
public abstract class a implements i.b {

    /* renamed from: a, reason: collision with root package name */
    private final i.c<?> f6649a;

    public a(i.c<?> cVar) {
        k.g(cVar, "key");
        this.f6649a = cVar;
    }

    @Override // Z3.i
    public /* bridge */ i C(i iVar) {
        return i.b.a.d(this, iVar);
    }

    @Override // Z3.i
    public /* bridge */ i W(i.c<?> cVar) {
        return i.b.a.c(this, cVar);
    }

    @Override // Z3.i.b, Z3.i
    public /* bridge */ <E extends i.b> E a(i.c<E> cVar) {
        return (E) i.b.a.b(this, cVar);
    }

    @Override // Z3.i.b
    public i.c<?> getKey() {
        return this.f6649a;
    }

    @Override // Z3.i
    public /* bridge */ <R> R o(R r5, p<? super R, ? super i.b, ? extends R> pVar) {
        return (R) i.b.a.a(this, r5, pVar);
    }
}
