package r;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h0 {

    /* renamed from: b, reason: collision with root package name */
    public static final h0 f10296b = new h0(new q0((j0) null, (o0) null, (id.c) null, (id.k) null, (LinkedHashMap) null, 63));

    /* renamed from: a, reason: collision with root package name */
    public final q0 f10297a;

    public h0(q0 q0Var) {
        this.f10297a = q0Var;
    }

    public final h0 a(h0 h0Var) {
        q0 q0Var = h0Var.f10297a;
        j0 j0Var = q0Var.f10337a;
        q0 q0Var2 = this.f10297a;
        if (j0Var == null) {
            j0Var = q0Var2.f10337a;
        }
        o0 o0Var = q0Var.f10338b;
        if (o0Var == null) {
            o0Var = q0Var2.f10338b;
        }
        Map map = q0Var2.f10340d;
        Map map2 = q0Var.f10340d;
        map.getClass();
        map2.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return new h0(new q0(j0Var, o0Var, (id.c) null, (id.k) null, linkedHashMap, 16));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof h0) && ((h0) obj).f10297a.equals(this.f10297a);
    }

    public final int hashCode() {
        return this.f10297a.hashCode();
    }

    public final String toString() {
        if (equals(f10296b)) {
            return "EnterTransition.None";
        }
        StringBuilder sb2 = new StringBuilder("EnterTransition: \nFade - ");
        q0 q0Var = this.f10297a;
        j0 j0Var = q0Var.f10337a;
        sb2.append(j0Var != null ? j0Var.toString() : null);
        sb2.append(",\nSlide - ");
        o0 o0Var = q0Var.f10338b;
        sb2.append(o0Var != null ? o0Var.toString() : null);
        sb2.append(",\nShrink - ");
        sb2.append((String) null);
        sb2.append(",\nScale - ");
        sb2.append((String) null);
        return sb2.toString();
    }
}
