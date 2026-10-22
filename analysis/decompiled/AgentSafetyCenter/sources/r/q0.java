package r;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class q0 {

    /* renamed from: a, reason: collision with root package name */
    public final j0 f10337a;

    /* renamed from: b, reason: collision with root package name */
    public final o0 f10338b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f10339c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f10340d;

    public /* synthetic */ q0(j0 j0Var, o0 o0Var, id.c cVar, id.k kVar, LinkedHashMap linkedHashMap, int i) {
        this((i & 1) != 0 ? null : j0Var, (i & 2) != 0 ? null : o0Var, (i & 4) != 0 ? null : cVar, (i & 8) != 0 ? null : kVar, (i & 16) == 0, (i & 32) != 0 ? kb.t.f7405c : linkedHashMap);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q0)) {
            return false;
        }
        q0 q0Var = (q0) obj;
        return yb.k.a(this.f10337a, q0Var.f10337a) && yb.k.a(this.f10338b, q0Var.f10338b) && yb.k.a(null, null) && yb.k.a(null, null) && this.f10339c == q0Var.f10339c && yb.k.a(this.f10340d, q0Var.f10340d);
    }

    public final int hashCode() {
        j0 j0Var = this.f10337a;
        int iHashCode = (j0Var == null ? 0 : j0Var.hashCode()) * 31;
        o0 o0Var = this.f10338b;
        return this.f10340d.hashCode() + k0.a.h((((((iHashCode + (o0Var == null ? 0 : o0Var.hashCode())) * 31) + 0) * 31) + 0) * 31, 31, this.f10339c);
    }

    public final String toString() {
        return "TransitionData(fade=" + this.f10337a + ", slide=" + this.f10338b + ", changeSize=" + ((Object) null) + ", scale=" + ((Object) null) + ", hold=" + this.f10339c + ", effectsMap=" + this.f10340d + ')';
    }

    public q0(j0 j0Var, o0 o0Var, id.c cVar, id.k kVar, boolean z10, Map map) {
        this.f10337a = j0Var;
        this.f10338b = o0Var;
        this.f10339c = z10;
        this.f10340d = map;
    }
}
