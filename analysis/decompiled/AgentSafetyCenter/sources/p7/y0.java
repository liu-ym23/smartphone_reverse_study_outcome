package p7;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y0 implements m7.o {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ Class f9917c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Class f9918f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ m7.n f9919g;

    @Override // m7.o
    public final m7.n a(m7.e eVar, t7.a aVar) {
        Class rawType = aVar.getRawType();
        if (rawType == this.f9917c || rawType == this.f9918f) {
            return this.f9919g;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.f9918f.getName() + "+" + this.f9917c.getName() + ",adapter=" + this.f9919g + "]";
    }
}
