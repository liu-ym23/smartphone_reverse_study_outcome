package j9;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import k0.c1;
import o1.i0;
import t.m0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a0 implements PointerInputEventHandler {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ c1 f6625c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ c1 f6626f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ float f6627g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ c1 f6628h;

    public static final void a(o1.w wVar, float f5, c1 c1Var, float f10, xb.l lVar) {
        i0 i0Var = (i0) wVar;
        float f11 = (int) (i0Var.C & 4294967295L);
        float f12 = 2.0f * f5;
        if (f11 < f12) {
            f11 = f12;
        }
        float fP = p5.f.p(f10, f5, f11 - f5);
        float f13 = (int) (i0Var.C & 4294967295L);
        if (f13 < 1.0f) {
            f13 = 1.0f;
        }
        String str = (String) b0.f6645n.get(p5.f.q(ac.a.Q((fP / f13) * ac.a.x(r8)), 0, r8.size() - 1));
        ((xb.p) c1Var.getValue()).invoke(str, Float.valueOf(fP));
        lVar.invoke(str);
    }

    @Override // androidx.compose.ui.input.pointer.PointerInputEventHandler
    public final Object invoke(o1.w wVar, nb.c cVar) {
        Object objG = m0.g(wVar, new z(this.f6625c, this.f6626f, wVar, this.f6627g, this.f6628h, null), cVar);
        return objG == ob.a.f9351c ? objG : jb.v.f6774a;
    }
}
