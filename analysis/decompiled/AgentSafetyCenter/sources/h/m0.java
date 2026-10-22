package h;

import android.view.View;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class m0 extends ac.a {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f4854g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ o0 f4855h;

    public /* synthetic */ m0(o0 o0Var, int i) {
        this.f4854g = i;
        this.f4855h = o0Var;
    }

    @Override // n3.p0
    public final void d() {
        View view;
        int i = this.f4854g;
        o0 o0Var = this.f4855h;
        switch (i) {
            case 0:
                if (o0Var.f4875o && (view = o0Var.f4868g) != null) {
                    view.setTranslationY(0.0f);
                    o0Var.f4865d.setTranslationY(0.0f);
                }
                o0Var.f4865d.setVisibility(8);
                o0Var.f4865d.setTransitioning(false);
                o0Var.f4879s = null;
                p5.l lVar = o0Var.f4871k;
                if (lVar != null) {
                    lVar.n(o0Var.f4870j);
                    o0Var.f4870j = null;
                    o0Var.f4871k = null;
                }
                ActionBarOverlayLayout actionBarOverlayLayout = o0Var.f4864c;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = n3.k0.f8724a;
                    actionBarOverlayLayout.requestApplyInsets();
                    break;
                }
                break;
            default:
                o0Var.f4879s = null;
                o0Var.f4865d.requestLayout();
                break;
        }
    }
}
