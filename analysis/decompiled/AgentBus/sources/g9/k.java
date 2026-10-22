package g9;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public Object f3962a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l f3963b;

    public k(Object obj, l lVar) {
        this.f3963b = lVar;
        this.f3962a = obj;
    }

    public final Object a(Object obj, w7.t tVar) {
        q7.k.e(tVar, "property");
        return this.f3962a;
    }

    public final void b(Object obj, w7.t tVar) {
        q7.k.e(tVar, "property");
        if (this.f3963b.f3964a) {
            throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
        }
        this.f3962a = obj;
    }

    public final String toString() {
        return "ObservableProperty(value=" + this.f3962a + ')';
    }
}
