package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class u0 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ yb.u f11128c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float f11129f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ e f11130g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ i f11131h;
    public final /* synthetic */ xb.l i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(yb.u uVar, float f5, e eVar, i iVar, xb.l lVar) {
        super(1);
        this.f11128c = uVar;
        this.f11129f = f5;
        this.f11130g = eVar;
        this.f11131h = iVar;
        this.i = lVar;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        long jLongValue = ((Number) obj).longValue();
        Object obj2 = this.f11128c.f16098c;
        obj2.getClass();
        d.j((g) obj2, jLongValue, this.f11129f, this.f11130g, this.f11131h, this.i);
        return jb.v.f6774a;
    }
}
