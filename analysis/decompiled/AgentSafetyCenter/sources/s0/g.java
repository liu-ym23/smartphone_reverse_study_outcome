package s0;

import k0.c0;
import k0.s1;
import k0.u2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends p0.b implements c0 {

    /* renamed from: h, reason: collision with root package name */
    public static final g f11181h = new g(p0.j.f9671e, 0);

    public final g b(s1 s1Var, u2 u2Var) {
        wd.a aVarU = this.f9658c.u(s1Var, s1Var.hashCode(), 0, u2Var);
        return aVarU == null ? this : new g((p0.j) aVarU.f15390g, this.f9659f + aVarU.f15389f);
    }

    @Override // p0.b, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof s1) {
            return super.containsKey((s1) obj);
        }
        return false;
    }

    @Override // p0.b, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof u2) {
            return super.containsValue((u2) obj);
        }
        return false;
    }

    @Override // p0.b, java.util.Map
    public final /* bridge */ Object get(Object obj) {
        if (obj instanceof s1) {
            return (u2) super.get((s1) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof s1) ? obj2 : (u2) super.getOrDefault((s1) obj, (u2) obj2);
    }
}
