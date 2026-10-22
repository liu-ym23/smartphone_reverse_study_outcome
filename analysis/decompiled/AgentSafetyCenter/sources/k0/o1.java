package k0;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o1 implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ p1 f6992c;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // xb.a
    public final Object invoke() {
        ArrayList arrayList = this.f6992c.f7008a;
        p.f0 f0Var = new p.f0(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            v0 v0Var = (v0) arrayList.get(i);
            Object obj = v0Var.f7085b;
            int i3 = v0Var.f7084a;
            Object u0Var = obj != null ? new u0(Integer.valueOf(i3), v0Var.f7085b) : Integer.valueOf(i3);
            int iF = f0Var.f(u0Var);
            boolean z10 = iF < 0;
            Object obj2 = z10 ? null : f0Var.f9554c[iF];
            if (obj2 != null) {
                if (obj2 instanceof p.a0) {
                    p.a0 a0Var = (p.a0) obj2;
                    a0Var.a(v0Var);
                    v0Var = a0Var;
                } else {
                    Object[] objArr = p.k0.f9587a;
                    p.a0 a0Var2 = new p.a0(2);
                    a0Var2.a(obj2);
                    a0Var2.a(v0Var);
                    v0Var = a0Var2;
                }
            }
            if (z10) {
                int i10 = ~iF;
                f0Var.f9553b[i10] = u0Var;
                f0Var.f9554c[i10] = v0Var;
            } else {
                f0Var.f9554c[iF] = v0Var;
            }
        }
        m0.a aVar = new m0.a();
        aVar.f8151a = f0Var;
        VarHandle.storeStoreFence();
        return aVar;
    }
}
