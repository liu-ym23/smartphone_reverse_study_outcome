package h0;

import androidx.compose.foundation.BorderModifierNodeElement;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class q1 {

    /* renamed from: a, reason: collision with root package name */
    public static final k0.e0 f5118a = k0.z.n(a0.f4912o);

    public static final void a(w0.m mVar, d1.j0 j0Var, long j10, long j11, float f5, float f10, s0.c cVar, k0.s sVar, int i, int i3) {
        if ((i3 & 1) != 0) {
            mVar = w0.j.f15113c;
        }
        w0.m mVar2 = mVar;
        if ((i3 & 2) != 0) {
            j0Var = d1.f0.f2972a;
        }
        d1.j0 j0Var2 = j0Var;
        long jB = (i3 & 8) != 0 ? b0.b(j10, sVar) : j11;
        float f11 = (i3 & 16) != 0 ? 0 : f5;
        float f12 = (i3 & 32) != 0 ? 0 : f10;
        k0.e0 e0Var = f5118a;
        float f13 = ((o2.f) sVar.j(e0Var)).f9114c + f11;
        k0.z.b(new k0.t1[]{f0.f4961a.a(d1.p.a(jB)), e0Var.a(o2.f.a(f13))}, s0.h.d(-70914509, new o1(mVar2, j0Var2, j10, f13, null, f12, cVar), sVar), sVar, 56);
    }

    public static final void b(xb.a aVar, w0.m mVar, boolean z10, d1.j0 j0Var, long j10, long j11, float f5, td.h hVar, v.k kVar, s0.c cVar, k0.s sVar, int i, int i3) {
        boolean z11 = (i3 & 4) != 0 ? true : z10;
        long jB = (i3 & 32) != 0 ? b0.b(j10, sVar) : j11;
        float f10 = 0;
        float f11 = (i3 & 128) != 0 ? 0 : f5;
        td.h hVar2 = (i3 & ErrorReportConfiguration.DEFAULT_MAX_ERROR_TOKEN_LENGTH) != 0 ? null : hVar;
        v.k kVar2 = (i3 & 512) != 0 ? null : kVar;
        k0.e0 e0Var = f5118a;
        float f12 = ((o2.f) sVar.j(e0Var)).f9114c + f10;
        k0.z.b(new k0.t1[]{f0.f4961a.a(d1.p.a(jB)), e0Var.a(o2.f.a(f12))}, s0.h.d(1279702876, new p1(mVar, j0Var, j10, f12, hVar2, kVar2, z11, aVar, f11, cVar), sVar), sVar, 56);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final w0.m c(w0.m mVar, d1.j0 j0Var, long j10, td.h hVar, float f5) {
        w0.j jVar = w0.j.f15113c;
        w0.m mVarD = mVar.d(f5 > 0.0f ? androidx.compose.ui.graphics.a.b(jVar, f5, j0Var, 124895) : jVar);
        w0.j jVar2 = jVar;
        if (hVar != null) {
            float f10 = j0.i.f6440a;
            BorderModifierNodeElement borderModifierNodeElement = new BorderModifierNodeElement();
            borderModifierNodeElement.f840c = f10;
            borderModifierNodeElement.f841f = null;
            borderModifierNodeElement.f842g = j0Var;
            VarHandle.storeStoreFence();
            jVar2 = borderModifierNodeElement;
        }
        return com.stepos.statsrpk.h.g(androidx.compose.foundation.a.b(mVarD.d(jVar2), j10, j0Var), j0Var);
    }

    public static final long d(long j10, float f5, k0.s sVar) {
        z zVar = (z) sVar.j(b0.f4919a);
        boolean zBooleanValue = ((Boolean) sVar.j(b0.f4920b)).booleanValue();
        long j11 = zVar.f5258p;
        return (d1.p.d(j10, j11) && zBooleanValue) ? o2.f.b(f5, (float) 0) ? j11 : d1.f0.h(d1.p.c(((((float) Math.log(f5 + 1)) * 4.5f) + 2.0f) / 100.0f, zVar.f5262t), j11) : j10;
    }
}
