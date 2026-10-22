package s;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c1 extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ e1 f10974c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ float f10975f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(e1 e1Var, float f5) {
        super(1);
        this.f10974c = e1Var;
        this.f10975f = f5;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        long jLongValue = ((Number) obj).longValue();
        e1 e1Var = this.f10974c;
        boolean zG = e1Var.g();
        k0.i1 i1Var = e1Var.f10995g;
        if (!zG) {
            if (i1Var.g() == Long.MIN_VALUE) {
                i1Var.h(jLongValue);
                ((k0.k1) e1Var.f10989a.f9807f).setValue(Boolean.TRUE);
            }
            long jG = jLongValue - i1Var.g();
            float f5 = this.f10975f;
            if (f5 != 0.0f) {
                jG = ac.a.R(jG / f5);
            }
            if (e1Var.f10990b == null) {
                e1Var.f10994f.h(jG);
            }
            e1Var.h(jG, f5 == 0.0f);
        }
        return jb.v.f6774a;
    }
}
