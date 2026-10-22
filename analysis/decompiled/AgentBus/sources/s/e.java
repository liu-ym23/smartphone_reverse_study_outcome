package s;

import android.graphics.Rect;
import android.view.View;
import c7.r;
import i1.d1;
import i1.j;
import i7.i;
import n0.l;

/* loaded from: classes.dex */
public final class e implements a {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ j f9161f;

    public e(j jVar) {
        this.f9161f = jVar;
    }

    @Override // s.a
    public final Object A(d1 d1Var, p7.a aVar, i iVar) {
        j jVar = this.f9161f;
        if (!((l) jVar).f6797f.f6810s) {
            f1.a.b("Cannot get View because the Modifier node is not currently attached.");
        }
        View view = (View) i1.l.w(i1.l.u(jVar));
        long jJ0 = d1Var.J0(0L);
        t0.c cVar = (t0.c) aVar.c();
        t0.c cVarE = cVar != null ? cVar.e(jJ0) : null;
        if (cVarE != null) {
            view.requestRectangleOnScreen(new Rect((int) cVarE.f9656a, (int) cVarE.f9657b, (int) cVarE.f9658c, (int) cVarE.f9659d), false);
        }
        return r.f1986a;
    }
}
