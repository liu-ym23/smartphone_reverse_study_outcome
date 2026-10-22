package m7;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m extends n {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ n f8268a;

    @Override // m7.n
    public final Object read(u7.a aVar) {
        if (aVar.Y() != u7.b.f14169m) {
            return this.f8268a.read(aVar);
        }
        aVar.U();
        return null;
    }

    public final String toString() {
        return "NullSafeTypeAdapter[" + this.f8268a + "]";
    }

    @Override // m7.n
    public final void write(u7.c cVar, Object obj) {
        if (obj == null) {
            cVar.C();
        } else {
            this.f8268a.write(cVar, obj);
        }
    }
}
