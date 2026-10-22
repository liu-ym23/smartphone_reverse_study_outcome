package b0;

/* loaded from: classes.dex */
public final class x1 {

    /* renamed from: a, reason: collision with root package name */
    public final w1 f1418a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1419b;

    /* renamed from: c, reason: collision with root package name */
    public final x2 f1420c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f1421d;

    /* renamed from: e, reason: collision with root package name */
    public final Object f1422e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f1423f = true;

    public x1(w1 w1Var, Object obj, boolean z4, x2 x2Var, boolean z10) {
        this.f1418a = w1Var;
        this.f1419b = z4;
        this.f1420c = x2Var;
        this.f1421d = z10;
        this.f1422e = obj;
    }

    public final Object a() {
        if (this.f1419b) {
            return null;
        }
        Object obj = this.f1422e;
        if (obj != null) {
            return obj;
        }
        s.d("Unexpected form of a provided value");
        throw new a4.u();
    }
}
