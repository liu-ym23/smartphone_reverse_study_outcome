package B3;

/* loaded from: classes2.dex */
public final class i implements t3.a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f230a;

    public i(Object obj) {
        this.f230a = obj;
    }

    @Override // x3.b
    public final void call(Object obj) {
        t3.g gVar = (t3.g) obj;
        boolean z4 = k.f234c;
        Object obj2 = this.f230a;
        gVar.i(z4 ? new z3.a(gVar, obj2) : new l1.g(gVar, obj2));
    }
}
