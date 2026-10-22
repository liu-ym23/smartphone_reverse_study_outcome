package g;

import android.view.View;
import androidx.appcompat.widget.Toolbar;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class w1 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2852a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2853b;

    public w1(e2 e2Var) {
        this.f2853b = e2Var;
        e2Var.f2691a.getContext();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2852a) {
            case 0:
                z1 z1Var = ((Toolbar) this.f2853b).L;
                f.k kVar = z1Var == null ? null : z1Var.f2878b;
                if (kVar != null) {
                    kVar.collapseActionView();
                    break;
                }
                break;
            default:
                e2 e2Var = (e2) this.f2853b;
                if (e2Var.f2700k != null) {
                    e2Var.getClass();
                    break;
                }
                break;
        }
    }

    public w1(Toolbar toolbar) {
        this.f2853b = toolbar;
    }
}
