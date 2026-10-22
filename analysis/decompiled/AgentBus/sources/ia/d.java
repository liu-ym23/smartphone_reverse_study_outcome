package ia;

/* loaded from: classes.dex */
public final class d implements i {

    /* renamed from: a, reason: collision with root package name */
    public final c[] f4934a;

    public d(c[] cVarArr) {
        this.f4934a = cVarArr;
    }

    @Override // ia.i
    public final void a(Throwable th) {
        b();
    }

    public final void b() {
        for (c cVar : this.f4934a) {
            p0 p0Var = cVar.f4924k;
            if (p0Var == null) {
                q7.k.j("handle");
                throw null;
            }
            p0Var.a();
        }
    }

    public final String toString() {
        return "DisposeHandlersOnCancel[" + this.f4934a + ']';
    }
}
