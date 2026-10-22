package m;

import android.content.Context;
import android.view.MenuItem;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b2 extends w1 implements x1 {
    public a1.g E;

    @Override // m.x1
    public final void g(l.l lVar, MenuItem menuItem) {
        a1.g gVar = this.E;
        if (gVar != null) {
            gVar.g(lVar, menuItem);
        }
    }

    @Override // m.x1
    public final void n(l.l lVar, l.n nVar) {
        a1.g gVar = this.E;
        if (gVar != null) {
            gVar.n(lVar, nVar);
        }
    }

    @Override // m.w1
    public final j1 q(Context context, boolean z10) {
        a2 a2Var = new a2(context, z10);
        if (1 == context.getResources().getConfiguration().getLayoutDirection()) {
            a2Var.f7874q = 21;
            a2Var.f7875r = 22;
        } else {
            a2Var.f7874q = 22;
            a2Var.f7875r = 21;
        }
        VarHandle.storeStoreFence();
        a2Var.setHoverListener(this);
        return a2Var;
    }
}
