package s;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o0 implements x {

    /* renamed from: a, reason: collision with root package name */
    public final float f11062a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11063b;

    public o0(float f5, Object obj) {
        this.f11062a = f5;
        this.f11063b = obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [xb.l, yb.l] */
    @Override // s.h
    public final j1 a(n6.a aVar) {
        a2.i iVar;
        Object obj = this.f11063b;
        n nVar = obj == null ? null : (n) ((yb.l) aVar.f8776c).invoke(obj);
        float f5 = this.f11062a;
        if (nVar != null) {
            ne.b bVar = new ne.b();
            ec.g gVarO = p5.f.O(0, nVar.b());
            ArrayList arrayList = new ArrayList(kb.m.m0(gVarO, 10));
            ec.a aVarC = gVarO.iterator();
            while (aVarC.f3752h) {
                arrayList.add(new z(f5, nVar.a(aVarC.nextInt())));
            }
            bVar.f8958c = arrayList;
            VarHandle.storeStoreFence();
            iVar = bVar;
        } else {
            a2.i iVar2 = new a2.i(28);
            iVar2.f49f = new z(f5, 0.01f);
            VarHandle.storeStoreFence();
            iVar = iVar2;
        }
        a2.i iVar3 = new a2.i(29);
        iVar3.f49f = new p5.i(iVar);
        VarHandle.storeStoreFence();
        return iVar3;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o0)) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return o0Var.f11062a == this.f11062a && yb.k.a(o0Var.f11063b, this.f11063b);
    }

    public final int hashCode() {
        Object obj = this.f11063b;
        return Float.hashCode(this.f11062a) + k0.a.g((obj != null ? obj.hashCode() : 0) * 31, 1.0f, 31);
    }
}
