package r;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class i0 {

    /* renamed from: b, reason: collision with root package name */
    public static final i0 f10304b;

    /* renamed from: c, reason: collision with root package name */
    public static final i0 f10305c;

    /* renamed from: a, reason: collision with root package name */
    public final q0 f10306a;

    static {
        LinkedHashMap linkedHashMap = null;
        j0 j0Var = null;
        o0 o0Var = null;
        id.c cVar = null;
        id.k kVar = null;
        f10304b = new i0(new q0(j0Var, o0Var, cVar, kVar, linkedHashMap, 63));
        f10305c = new i0(new q0(j0Var, o0Var, cVar, kVar, linkedHashMap, 47));
    }

    public i0(q0 q0Var) {
        this.f10306a = q0Var;
    }

    public final i0 a(i0 i0Var) {
        q0 q0Var = i0Var.f10306a;
        j0 j0Var = q0Var.f10337a;
        q0 q0Var2 = this.f10306a;
        if (j0Var == null) {
            j0Var = q0Var2.f10337a;
        }
        o0 o0Var = q0Var.f10338b;
        if (o0Var == null) {
            o0Var = q0Var2.f10338b;
        }
        boolean z10 = q0Var.f10339c || q0Var2.f10339c;
        Map map = q0Var2.f10340d;
        Map map2 = q0Var.f10340d;
        map.getClass();
        map2.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.putAll(map2);
        return new i0(new q0(j0Var, o0Var, (id.c) null, (id.k) null, z10, linkedHashMap));
    }

    public final boolean equals(Object obj) {
        return (obj instanceof i0) && ((i0) obj).f10306a.equals(this.f10306a);
    }

    public final int hashCode() {
        return this.f10306a.hashCode();
    }

    public final String toString() {
        if (equals(f10304b)) {
            return "ExitTransition.None";
        }
        if (equals(f10305c)) {
            return "ExitTransition.KeepUntilTransitionsFinished";
        }
        StringBuilder sb2 = new StringBuilder("ExitTransition: \nFade - ");
        q0 q0Var = this.f10306a;
        j0 j0Var = q0Var.f10337a;
        sb2.append(j0Var != null ? j0Var.toString() : null);
        sb2.append(",\nSlide - ");
        o0 o0Var = q0Var.f10338b;
        sb2.append(o0Var != null ? o0Var.toString() : null);
        sb2.append(",\nShrink - ");
        sb2.append((String) null);
        sb2.append(",\nScale - ");
        sb2.append((String) null);
        sb2.append(",\nKeepUntilTransitionsFinished - ");
        sb2.append(q0Var.f10339c);
        return sb2.toString();
    }
}
