package y4;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements p7.n {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ int f11554f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ h f11555g;

    public /* synthetic */ c(h hVar, int i2) {
        this.f11554f = i2;
        this.f11555g = hVar;
    }

    @Override // p7.n
    public final Object invoke(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        switch (this.f11554f) {
            case 0:
                q7.k.e(str, "role");
                q7.k.e(str2, "msg");
                k5.s.info$default(this.f11555g.f11569c, "openclaw-edge", a1.a.k("[", str, "] OFFLINE: ", str2), null, 4, null);
                break;
            default:
                q7.k.e(str, "role");
                q7.k.e(str2, "msg");
                k5.s.info$default(this.f11555g.f11569c, "openclaw-cloud", a1.a.k("[", str, "] OFFLINE: ", str2), null, 4, null);
                break;
        }
        return c7.r.f1986a;
    }
}
