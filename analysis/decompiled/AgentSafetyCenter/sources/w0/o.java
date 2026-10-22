package w0;

import kb.t;
import s1.e0;
import s1.g0;
import u1.o0;
import u1.w;
import v1.i0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class o extends l implements w {

    /* renamed from: s, reason: collision with root package name */
    public float f15127s;

    @Override // u1.w
    public final g0 f(o0 o0Var, e0 e0Var, long j10) {
        s1.o0 o0VarQ = e0Var.q(j10);
        return o0Var.Y(o0VarQ.f11277c, o0VarQ.f11278f, t.f7405c, new i0(8, o0VarQ, this));
    }

    public final String toString() {
        return k0.a.q(new StringBuilder("ZIndexModifier(zIndex="), this.f15127s, ')');
    }
}
