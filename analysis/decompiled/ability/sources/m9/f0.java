package m9;

/* loaded from: classes4.dex */
public final class f0 extends C1718k {
    public final kotlinx.coroutines.c i;

    public f0(H7.c cVar, kotlinx.coroutines.c cVar2) {
        super(1, cVar);
        this.i = cVar2;
    }

    @Override // m9.C1718k
    public final String D() {
        return "AwaitContinuation";
    }

    @Override // m9.C1718k
    public final Throwable w(kotlinx.coroutines.c cVar) {
        Throwable thC;
        kotlinx.coroutines.c cVar2 = this.i;
        cVar2.getClass();
        Object obj = kotlinx.coroutines.c.f5183a.get(cVar2);
        return (!(obj instanceof h0) || (thC = ((h0) obj).c()) == null) ? obj instanceof C1727t ? ((C1727t) obj).f5333a : cVar.i() : thC;
    }
}
