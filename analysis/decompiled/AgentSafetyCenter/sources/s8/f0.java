package s8;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class f0 implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f11589c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ k0.c1 f11590f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ k0.c1 f11591g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ k0.c1 f11592h;

    public /* synthetic */ f0(int i) {
        this.f11589c = i;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f11589c) {
            case 0:
                k0.c1 c1Var = this.f11590f;
                k0.c1 c1Var2 = this.f11591g;
                k0.c1 c1Var3 = this.f11592h;
                s1.q qVar = (s1.q) obj;
                qVar.getClass();
                c1Var.setValue(qVar);
                w0.q(c1Var2, c1Var, c1Var3);
                break;
            default:
                k0.c1 c1Var4 = this.f11590f;
                k0.c1 c1Var5 = this.f11591g;
                k0.c1 c1Var6 = this.f11592h;
                s1.q qVar2 = (s1.q) obj;
                qVar2.getClass();
                if (qVar2.k() && ((int) (qVar2.l() >> 32)) > 0) {
                    c1Var4.setValue(qVar2);
                    w0.r(c1Var5, c1Var4, c1Var6);
                }
                break;
        }
        return jb.v.f6774a;
    }
}
