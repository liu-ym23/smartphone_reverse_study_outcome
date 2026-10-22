package Z2;

import kotlin.Unit;

/* loaded from: classes2.dex */
public final class u0 extends s0 {

    /* renamed from: e, reason: collision with root package name */
    public final x0 f2245e;

    /* renamed from: f, reason: collision with root package name */
    public final v0 f2246f;

    /* renamed from: g, reason: collision with root package name */
    public final C0136l f2247g;

    /* renamed from: h, reason: collision with root package name */
    public final Object f2248h;

    public u0(x0 x0Var, v0 v0Var, C0136l c0136l, Object obj) {
        this.f2245e = x0Var;
        this.f2246f = v0Var;
        this.f2247g = c0136l;
        this.f2248h = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        j((Throwable) obj);
        return Unit.INSTANCE;
    }

    @Override // Z2.s0
    public final void j(Throwable th) {
        x0 x0Var = this.f2245e;
        x0Var.getClass();
        C0136l c0136lP = x0.P(this.f2247g);
        v0 v0Var = this.f2246f;
        Object obj = this.f2248h;
        if (c0136lP != null) {
            while (AbstractC0139m0.a(c0136lP.f2227e, false, new u0(x0Var, v0Var, c0136lP, obj), 1) == A0.f2162a) {
                c0136lP = x0.P(c0136lP);
                if (c0136lP == null) {
                }
            }
            return;
        }
        x0Var.s(x0Var.B(v0Var, obj));
    }
}
