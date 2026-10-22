package p0;

import i1.f0;
import p.q;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a extends q {

    /* renamed from: h, reason: collision with root package name */
    public f0 f9656h;
    public Object i;

    @Override // p.q, java.util.Map.Entry
    public final Object getValue() {
        return this.i;
    }

    @Override // p.q, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object obj2 = this.i;
        this.i = obj;
        f0 f0Var = this.f9656h;
        Object obj3 = this.f9612f;
        d dVar = (d) f0Var.f5669f;
        s0.f fVar = dVar.f9663h;
        if (!fVar.containsKey(obj3)) {
            return obj2;
        }
        boolean z10 = dVar.f9662g;
        if (!z10) {
            fVar.put(obj3, obj);
        } else {
            if (!z10) {
                g5.f.k();
                return null;
            }
            k kVar = dVar.f9660c[dVar.f9661f];
            Object obj4 = kVar.f9676c[kVar.f9678g];
            fVar.put(obj3, obj);
            dVar.c(obj4 != null ? obj4.hashCode() : 0, fVar.f11177f, obj4, 0);
        }
        dVar.f9665k = fVar.f11179h;
        return obj2;
    }
}
