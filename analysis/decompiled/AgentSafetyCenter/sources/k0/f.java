package k0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ e f6895c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ g f6896f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ yb.s f6897g;

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i;
        e eVar = this.f6895c;
        eVar.f6877a = null;
        eVar.f6878b = null;
        s0.a aVar = this.f6896f.f6913h;
        int i3 = this.f6897g.f16096c;
        do {
            i = aVar.get();
        } while (!aVar.compareAndSet(i, ((i >>> 27) & 15) == i3 ? i - 1 : i));
        return jb.v.f6774a;
    }
}
