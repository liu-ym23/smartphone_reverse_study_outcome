package kc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h0 extends a1 {
    public final /* synthetic */ int i;

    /* renamed from: j, reason: collision with root package name */
    public Object f7439j;

    public h0(xb.l lVar) {
        this.i = 1;
        this.f7439j = lVar;
    }

    @Override // kc.a1
    public final boolean k() {
        switch (this.i) {
        }
        return false;
    }

    @Override // kc.a1
    public final void l(Throwable th) {
        switch (this.i) {
            case 0:
                ((g0) this.f7439j).dispose();
                break;
            case 1:
                ((xb.l) this.f7439j).invoke(th);
                break;
            default:
                Object obj = e1.f7431c.get(j());
                boolean z10 = obj instanceof n;
                b1 b1Var = (b1) this.f7439j;
                if (!z10) {
                    b1Var.resumeWith(w.C(obj));
                    break;
                } else {
                    b1Var.resumeWith(id.c.l(((n) obj).f7461a));
                    break;
                }
        }
    }

    public /* synthetic */ h0(int i) {
        this.i = i;
    }
}
