package s1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b1 extends yb.l implements xb.p {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11217c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ n[] f11218f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b1(n[] nVarArr, int i) {
        super(2);
        this.f11217c = i;
        this.f11218f = nVarArr;
    }

    @Override // xb.p
    public final Object invoke(Object obj, Object obj2) {
        switch (this.f11217c) {
            case 0:
                return Float.valueOf(v0.e((n0) obj, true, this.f11218f, ((Number) obj2).floatValue()));
            default:
                return Float.valueOf(v0.e((n0) obj, false, this.f11218f, ((Number) obj2).floatValue()));
        }
    }
}
