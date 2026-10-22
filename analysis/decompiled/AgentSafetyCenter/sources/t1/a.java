package t1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: b, reason: collision with root package name */
    public g f13126b;

    @Override // t1.e
    public final boolean d(i iVar) {
        return iVar == this.f13126b.getKey();
    }

    @Override // t1.e
    public final Object h(i iVar) {
        if (iVar != this.f13126b.getKey()) {
            r1.a.b("Check failed.");
        }
        return this.f13126b.getValue();
    }
}
