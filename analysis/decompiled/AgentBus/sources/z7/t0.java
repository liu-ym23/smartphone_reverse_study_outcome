package z7;

import java.lang.reflect.Type;

/* loaded from: classes.dex */
public final class t0 extends q7.m implements p7.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f11957g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ u0 f11958h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t0(u0 u0Var, int i2) {
        super(0);
        this.f11957g = i2;
        this.f11958h = u0Var;
    }

    @Override // p7.a
    public final Object c() {
        switch (this.f11957g) {
            case 0:
                return x1.d(this.f11958h.a());
            default:
                u0 u0Var = this.f11958h;
                f8.j0 j0VarA = u0Var.a();
                s sVar = u0Var.f11962f;
                if (!(j0VarA instanceof i8.v) || !q7.k.a(x1.g(sVar.B()), j0VarA) || sVar.B().getKind() != 2) {
                    return (Type) sVar.y().i().get(u0Var.f11963g);
                }
                f8.j jVarP = sVar.B().p();
                q7.k.c(jVarP, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                Class clsJ = x1.j((f8.e) jVarP);
                if (clsJ != null) {
                    return clsJ;
                }
                throw new c7.i("Cannot determine receiver Java type of inherited declaration: " + j0VarA, 3);
        }
    }
}
