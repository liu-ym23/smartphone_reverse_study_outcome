package g;

import androidx.appcompat.widget.Toolbar;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class u1 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2841a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Toolbar f2842b;

    public /* synthetic */ u1(Toolbar toolbar, int i8) {
        this.f2841a = i8;
        this.f2842b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i8 = this.f2841a;
        Toolbar toolbar = this.f2842b;
        switch (i8) {
            case 0:
                z1 z1Var = toolbar.L;
                f.k kVar = z1Var == null ? null : z1Var.f2878b;
                if (kVar != null) {
                    kVar.collapseActionView();
                    break;
                }
                break;
            default:
                toolbar.l();
                break;
        }
    }
}
