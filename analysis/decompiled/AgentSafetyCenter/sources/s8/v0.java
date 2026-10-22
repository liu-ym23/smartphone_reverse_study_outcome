package s8;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class v0 implements PointerInputEventHandler {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ int f12020c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ float f12021f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ xb.l f12022g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ xb.l f12023h;
    public /* synthetic */ xb.l i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ xb.l f12024j;

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(o1.w wVar, nb.c cVar) {
        int i = this.f12020c;
        jb.v vVar = jb.v.f6774a;
        if (i <= 0) {
            return vVar;
        }
        o1.i0 i0Var = (o1.i0) wVar;
        float fA = i0Var.a() * this.f12021f;
        float f5 = (i * fA) - 0.001f;
        if (fA > 0.0f && f5 > 0.0f) {
            Object objG = t.m0.g(i0Var, new u0(this.f12022g, u1.f.u(i0Var).C.e(), this.f12023h, f5, fA, this.f12020c, this.i, this.f12024j, null), cVar);
            if (objG == ob.a.f9351c) {
                return objG;
            }
        }
        return vVar;
    }
}
