package z;

import android.graphics.Rect;
import android.view.View;
import jb.v;
import pb.i;
import u1.f;
import u1.g1;
import u1.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e implements a {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ l f16137c;

    @Override // z.a
    public final Object N(g1 g1Var, xb.a aVar, i iVar) {
        View viewW = f.w(this.f16137c);
        long jD = g1Var.D(0L);
        c1.c cVar = (c1.c) aVar.invoke();
        c1.c cVarE = cVar != null ? cVar.e(jD) : null;
        if (cVarE != null) {
            viewW.requestRectangleOnScreen(new Rect((int) cVarE.f2167a, (int) cVarE.f2168b, (int) cVarE.f2169c, (int) cVarE.f2170d), false);
        }
        return v.f6774a;
    }
}
