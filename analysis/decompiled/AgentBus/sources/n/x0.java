package n;

import b0.o1;
import b0.v2;

/* loaded from: classes.dex */
public final class x0 extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ b1 f6758g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ float f6759h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x0(b1 b1Var, float f10) {
        super(1);
        this.f6758g = b1Var;
        this.f6759h = f10;
    }

    @Override // p7.k
    public final Object invoke(Object obj) {
        long jLongValue = ((Number) obj).longValue();
        b1 b1Var = this.f6758g;
        boolean zG = b1Var.g();
        b0.m1 m1Var = b1Var.f6552g;
        if (!zG) {
            if (((v2) l0.m.t(m1Var.f1241g, m1Var)).f1386c == Long.MIN_VALUE) {
                m1Var.e(jLongValue);
                ((o1) b1Var.f6546a.f8788h).setValue(Boolean.TRUE);
            }
            long jV = jLongValue - ((v2) l0.m.t(m1Var.f1241g, m1Var)).f1386c;
            float f10 = this.f6759h;
            if (f10 != 0.0f) {
                jV = s7.a.V(jV / f10);
            }
            if (b1Var.f6547b == null) {
                b1Var.f6551f.e(jV);
            }
            b1Var.h(jV, f10 == 0.0f);
        }
        return c7.r.f1986a;
    }
}
