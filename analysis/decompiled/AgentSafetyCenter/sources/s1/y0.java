package s1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: a, reason: collision with root package name */
    public final a1 f11331a;

    /* renamed from: b, reason: collision with root package name */
    public b0 f11332b;

    /* renamed from: c, reason: collision with root package name */
    public final x0 f11333c = new x0(this, 2);

    /* renamed from: d, reason: collision with root package name */
    public final x0 f11334d = new x0(this, 0);

    /* renamed from: e, reason: collision with root package name */
    public final x0 f11335e = new x0(this, 1);

    public y0(a1 a1Var) {
        this.f11331a = a1Var;
    }

    public final b0 a() {
        b0 b0Var = this.f11332b;
        if (b0Var != null) {
            return b0Var;
        }
        g5.f.s("SubcomposeLayoutState is not attached to SubcomposeLayout");
        return null;
    }
}
