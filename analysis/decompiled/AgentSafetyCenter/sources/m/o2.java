package m;

import androidx.appcompat.widget.Toolbar;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class o2 implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8041c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Toolbar f8042f;

    public /* synthetic */ o2(int i) {
        this.f8041c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f8041c;
        Toolbar toolbar = this.f8042f;
        switch (i) {
            case 0:
                q2 q2Var = toolbar.P;
                l.n nVar = q2Var == null ? null : q2Var.f8052f;
                if (nVar != null) {
                    nVar.collapseActionView();
                    break;
                }
                break;
            default:
                toolbar.m();
                break;
        }
    }
}
