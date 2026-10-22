package w;

import u1.q1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h0 extends w0.l implements q1 {

    /* renamed from: s, reason: collision with root package name */
    public float f14980s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f14981t;

    @Override // u1.q1
    public final Object b0(o2.c cVar, Object obj) {
        o0 o0Var = obj instanceof o0 ? (o0) obj : null;
        if (o0Var == null) {
            o0Var = new o0();
        }
        o0Var.f15017a = this.f14980s;
        o0Var.f15018b = this.f14981t;
        return o0Var;
    }
}
