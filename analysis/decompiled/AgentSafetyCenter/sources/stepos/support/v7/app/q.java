package stepos.support.v7.app;

import android.view.MenuItem;
import android.view.Window;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class q implements te.j, te.u {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ o f12451c;

    public q(o oVar) {
        this.f12451c = oVar;
    }

    @Override // te.u
    public void b(te.l lVar, boolean z10) {
        this.f12451c.m(lVar);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, stepos.support.v7.app.k] */
    @Override // te.j
    public boolean c(te.l lVar, MenuItem menuItem) {
        o oVar = this.f12451c;
        ?? r12 = oVar.i;
        if (r12 == 0 || oVar.f12400s || !(menuItem instanceof te.h)) {
            return false;
        }
        return r12.onBottomItemSelected((te.h) menuItem);
    }

    @Override // te.u
    public boolean e(te.l lVar) {
        Window.Callback callback = this.f12451c.f12388f.getCallback();
        if (callback == null) {
            return true;
        }
        callback.onMenuOpened(108, lVar);
        return true;
    }

    @Override // te.j
    public void d(te.l lVar) {
    }
}
