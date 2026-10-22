package j0;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class z extends kotlin.jvm.internal.q implements p5.l {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c0 f3470b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(c0 c0Var) {
        super(1);
        this.f3470b = c0Var;
    }

    @Override // p5.l
    public final Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        c0 c0Var = this.f3470b;
        b5.k kVar = c0Var.f3329k;
        if (th != null) {
            c0Var.f3327h.q(new m0(th));
        }
        if (kVar.a()) {
            ((j0) kVar.getValue()).close();
        }
        return b5.a0.f883a;
    }
}
