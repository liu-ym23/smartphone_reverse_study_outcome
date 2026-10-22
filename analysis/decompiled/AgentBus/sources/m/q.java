package m;

import b0.b3;
import b0.o1;
import i1.m0;
import i1.w1;
import i1.x1;
import ia.g1;
import java.util.concurrent.CancellationException;
import m4.u0;
import p.w0;
import p.y0;
import u0.f0;

/* loaded from: classes.dex */
public final class q extends q7.m implements p7.k {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f6091g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Object f6092h;

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ Object f6093i;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Object f6094j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ q(Object obj, Object obj2, Object obj3, int i2) {
        super(1);
        this.f6091g = i2;
        this.f6092h = obj;
        this.f6093i = obj2;
        this.f6094j = obj3;
    }

    /* JADX WARN: Type inference failed for: r7v31, types: [p7.k, q7.m] */
    /* JADX WARN: Type inference failed for: r8v3, types: [p7.a, q7.m] */
    @Override // p7.k
    public final Object invoke(Object obj) {
        long j2;
        boolean zBooleanValue;
        switch (this.f6091g) {
            case 0:
                u0.a0 a0Var = (u0.a0) obj;
                b3 b3Var = (b3) this.f6093i;
                b3 b3Var2 = (b3) this.f6092h;
                a0Var.a(b3Var2 != null ? ((Number) b3Var2.getValue()).floatValue() : 1.0f);
                a0Var.b(b3Var != null ? ((Number) b3Var.getValue()).floatValue() : 1.0f);
                a0Var.e(b3Var != null ? ((Number) b3Var.getValue()).floatValue() : 1.0f);
                b3 b3Var3 = (b3) this.f6094j;
                if (b3Var3 != null) {
                    ((f0) b3Var3.getValue()).getClass();
                    j2 = 0;
                } else {
                    j2 = f0.f9906a;
                }
                a0Var.f(j2);
                return c7.r.f1986a;
            case 1:
                n.g gVar = (n.g) obj;
                n.c cVar = (n.c) this.f6092h;
                n.d.j(gVar, cVar.f6559c);
                o1 o1Var = gVar.f6615e;
                Object objA = n.c.a(cVar, o1Var.getValue());
                if (!q7.k.a(objA, o1Var.getValue())) {
                    cVar.f6559c.f6632g.setValue(objA);
                    ((n.i) this.f6093i).f6632g.setValue(objA);
                    gVar.f6619i.setValue(Boolean.FALSE);
                    gVar.f6614d.c();
                    ((q7.r) this.f6094j).f8816f = true;
                }
                return c7.r.f1986a;
            case 2:
                float fFloatValue = ((Number) obj).floatValue();
                p.i iVar = (p.i) this.f6092h;
                float f10 = iVar.f8119v ? 1.0f : -1.0f;
                y0 y0Var = iVar.f8118u;
                w0 w0Var = (w0) this.f6094j;
                long jD = y0Var.d(y0Var.g(f10 * fFloatValue));
                y0 y0Var2 = w0Var.f8200a;
                float f11 = y0Var.f(y0Var.d(y0.a(y0Var2, y0Var2.f8223h, jD, 1))) * f10;
                if (Math.abs(f11) < Math.abs(fFloatValue)) {
                    g1 g1Var = (g1) this.f6093i;
                    CancellationException cancellationException = new CancellationException("Scroll animation cancelled because scroll was not consumed (" + f11 + " < " + fFloatValue + ')');
                    cancellationException.initCause(null);
                    g1Var.d(cancellationException);
                }
                return c7.r.f1986a;
            case 3:
                x1 x1Var = (x1) obj;
                q0.d dVar = (q0.d) x1Var;
                if (!((q0.a) ((j1.y) i1.l.v((q0.d) this.f6093i)).m19getDragAndDropManager()).f8619b.contains(dVar) || !n7.a.a(dVar, n7.b.o((o4.d0) this.f6094j))) {
                    return w1.f4626f;
                }
                ((q7.v) this.f6092h).f8820f = x1Var;
                return w1.f4628h;
            case 4:
                g1.s sVar = (g1.s) this.f6093i;
                g1.r rVar = (g1.r) obj;
                m0 m0Var = (m0) this.f6094j;
                r.b0 b0Var = (r.b0) this.f6092h;
                if (b0Var.f8849x) {
                    g1.r.i(rVar, sVar, m0Var.y(b0Var.f8845t), m0Var.y(b0Var.f8846u));
                } else {
                    g1.r.g(rVar, sVar, m0Var.y(b0Var.f8845t), m0Var.y(b0Var.f8846u));
                }
                return c7.r.f1986a;
            case 5:
                g1.r rVar2 = (g1.r) obj;
                g1.s sVar2 = (g1.s) this.f6092h;
                m0 m0Var2 = (m0) this.f6093i;
                r.d0 d0Var = (r.d0) this.f6094j;
                r.c0 c0Var = d0Var.f8856t;
                d2.l lVarC0 = m0Var2.c0();
                c0Var.getClass();
                g1.r.g(rVar2, sVar2, m0Var2.y(lVarC0 == d2.l.f2793f ? c0Var.f8850a : c0Var.f8852c), m0Var2.y(d0Var.f8856t.f8851b));
                return c7.r.f1986a;
            default:
                s0.q qVar = (s0.q) obj;
                if (q7.k.a(qVar, (s0.q) this.f6092h)) {
                    zBooleanValue = false;
                } else {
                    if (q7.k.a(qVar, (s0.q) ((u0) this.f6093i).f6343c)) {
                        throw new IllegalStateException("Focus search landed at the root.");
                    }
                    zBooleanValue = ((Boolean) ((q7.m) this.f6094j).invoke(qVar)).booleanValue();
                }
                return Boolean.valueOf(zBooleanValue);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public q(s0.q qVar, u0 u0Var, p7.k kVar) {
        super(1);
        this.f6091g = 6;
        this.f6092h = qVar;
        this.f6093i = u0Var;
        this.f6094j = (q7.m) kVar;
    }
}
