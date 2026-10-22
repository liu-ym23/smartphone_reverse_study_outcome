package nc;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l0 extends oc.d {

    /* renamed from: a, reason: collision with root package name */
    public long f8876a;

    /* renamed from: b, reason: collision with root package name */
    public kc.g f8877b;

    @Override // oc.d
    public final boolean a(oc.b bVar) {
        j0 j0Var = (j0) bVar;
        if (this.f8876a >= 0) {
            return false;
        }
        long j10 = j0Var.f8863m;
        if (j10 < j0Var.f8864n) {
            j0Var.f8864n = j10;
        }
        this.f8876a = j10;
        return true;
    }

    @Override // oc.d
    public final nb.c[] b(oc.b bVar) {
        long j10 = this.f8876a;
        this.f8876a = -1L;
        this.f8877b = null;
        return ((j0) bVar).t(j10);
    }
}
