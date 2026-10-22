package v9;

import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class f0 extends n0 {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10549c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f10550d;

    public /* synthetic */ f0(int i2, Object obj) {
        this.f10549c = i2;
        this.f10550d = obj;
    }

    @Override // v9.s0
    public boolean a() {
        switch (this.f10549c) {
            case 1:
                return false;
            default:
                return super.a();
        }
    }

    @Override // v9.s0
    public boolean e() {
        switch (this.f10549c) {
            case 1:
                return ((Map) this.f10550d).isEmpty();
            default:
                return super.e();
        }
    }

    @Override // v9.n0
    public final p0 g(m0 m0Var) {
        switch (this.f10549c) {
            case 0:
                q7.k.e(m0Var, "key");
                if (!((ArrayList) this.f10550d).contains(m0Var)) {
                    return null;
                }
                f8.g gVarC = m0Var.c();
                q7.k.c(gVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
                return x0.j((f8.q0) gVarC);
            default:
                q7.k.e(m0Var, "key");
                return (p0) ((Map) this.f10550d).get(m0Var);
        }
    }
}
