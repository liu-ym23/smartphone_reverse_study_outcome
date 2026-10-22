package stepos.support.v7.app;

import stepos.support.v7.widget.s1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class o0 implements s1, te.u {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ q0 f12408c;

    @Override // te.u
    public void b(te.l lVar, boolean z10) {
        p0 p0Var = this.f12408c.f12454c;
        if (p0Var != null) {
            p0Var.onPanelClosed(0, lVar);
        }
    }

    @Override // te.u
    public boolean e(te.l lVar) {
        p0 p0Var;
        if (lVar != null || (p0Var = this.f12408c.f12454c) == null) {
            return true;
        }
        p0Var.onMenuOpened(0, lVar);
        return true;
    }
}
