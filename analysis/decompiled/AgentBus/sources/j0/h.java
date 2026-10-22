package j0;

import b0.e3;
import b0.t1;
import b0.w1;

/* loaded from: classes.dex */
public final class h extends g0.c implements t1 {

    /* renamed from: i, reason: collision with root package name */
    public static final h f5083i = new h(g0.k.f3687e, 0);

    public final h c(w1 w1Var, e3 e3Var) {
        d1.b bVarU = this.f3673f.u(w1Var.hashCode(), 0, w1Var, e3Var);
        return bVarU == null ? this : new h((g0.k) bVarU.f2768h, this.f3674g + bVarU.f2767g);
    }

    @Override // g0.c, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof w1) {
            return super.containsKey((w1) obj);
        }
        return false;
    }

    @Override // d7.g, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof e3) {
            return super.containsValue((e3) obj);
        }
        return false;
    }

    @Override // g0.c, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof w1) {
            return (e3) super.get((w1) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof w1) ? obj2 : (e3) super.getOrDefault((w1) obj, (e3) obj2);
    }
}
