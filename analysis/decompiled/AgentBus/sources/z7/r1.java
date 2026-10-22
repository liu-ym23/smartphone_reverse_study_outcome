package z7;

/* loaded from: classes.dex */
public final class r1 extends s1 {

    /* renamed from: g, reason: collision with root package name */
    public final q7.m f11946g;

    /* renamed from: h, reason: collision with root package name */
    public volatile Object f11947h = null;

    /* JADX WARN: Multi-variable type inference failed */
    public r1(p7.a aVar) {
        this.f11946g = (q7.m) aVar;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [p7.a, q7.m] */
    public final Object c() {
        Object obj = s1.f11954f;
        Object obj2 = this.f11947h;
        if (obj2 != null) {
            if (obj2 == obj) {
                return null;
            }
            return obj2;
        }
        Object objC = this.f11946g.c();
        if (objC != null) {
            obj = objC;
        }
        this.f11947h = obj;
        return objC;
    }
}
