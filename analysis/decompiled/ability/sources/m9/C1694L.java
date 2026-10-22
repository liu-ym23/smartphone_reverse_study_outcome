package m9;

/* renamed from: m9.L, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1694L extends e0 {
    public final /* synthetic */ int e;
    public final Object f;

    public /* synthetic */ C1694L(Object obj, int i) {
        this.e = i;
        this.f = obj;
    }

    @Override // m9.e0
    public final boolean i() {
        switch (this.e) {
        }
        return false;
    }

    @Override // m9.e0
    public final void j(Throwable th) {
        switch (this.e) {
            case 0:
                ((InterfaceC1693K) this.f).dispose();
                break;
            case 1:
                ((S7.k) this.f).invoke(th);
                break;
            default:
                f0 f0Var = (f0) this.f;
                Object obj = kotlinx.coroutines.c.f5183a.get(h());
                if (!(obj instanceof C1727t)) {
                    f0Var.resumeWith(AbstractC1683A.u(obj));
                    break;
                } else {
                    f0Var.resumeWith(kotlin.b.a(((C1727t) obj).f5333a));
                    break;
                }
        }
    }
}
