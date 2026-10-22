package m9;

/* renamed from: m9.o, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1722o extends e0 implements InterfaceC1721n {
    public final kotlinx.coroutines.c e;

    public C1722o(kotlinx.coroutines.c cVar) {
        this.e = cVar;
    }

    @Override // m9.InterfaceC1721n
    public final boolean a(Throwable th) {
        return h().E(th);
    }

    @Override // m9.e0
    public final boolean i() {
        return true;
    }

    @Override // m9.e0
    public final void j(Throwable th) {
        this.e.A(h());
    }
}
