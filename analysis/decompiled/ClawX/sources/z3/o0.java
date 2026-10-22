package z3;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o0 implements y0 {

    /* renamed from: a, reason: collision with root package name */
    public final p5.q f6489a;

    /* renamed from: b, reason: collision with root package name */
    public final y0 f6490b;

    public o0(p5.q interceptor, y0 y0Var) {
        kotlin.jvm.internal.p.e(interceptor, "interceptor");
        this.f6489a = interceptor;
        this.f6490b = y0Var;
    }

    @Override // z3.y0
    public final Object a(f4.c cVar, h5.c cVar2) {
        return this.f6489a.invoke(this.f6490b, cVar, cVar2);
    }
}
