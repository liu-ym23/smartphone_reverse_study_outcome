package m;

import androidx.appcompat.widget.ActionBarContextView;
import stepos.support.v7.widget.ActionMenuView;
import stepos.support.v7.widget.Toolbar;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class a implements n3.p0 {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7863c;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7864f;

    /* renamed from: g, reason: collision with root package name */
    public int f7865g;

    /* renamed from: h, reason: collision with root package name */
    public Object f7866h;

    public /* synthetic */ a(int i) {
        this.f7863c = i;
    }

    @Override // n3.p0
    public void a() {
        switch (this.f7863c) {
            case 0:
                this.f7864f = true;
                break;
            case 1:
                this.f7864f = true;
                break;
            default:
                this.f7864f = true;
                break;
        }
    }

    @Override // n3.p0
    public void c() {
        switch (this.f7863c) {
            case 0:
                super/*android.view.View*/.setVisibility(0);
                this.f7864f = false;
                break;
            case 1:
                super/*android.view.View*/.setVisibility(0);
                this.f7864f = false;
                break;
            default:
                ActionMenuView actionMenuView = ((Toolbar) this.f7866h).f12681c;
                if (actionMenuView != null) {
                    actionMenuView.setVisibility(0);
                }
                this.f7864f = false;
                break;
        }
    }

    @Override // n3.p0
    public void d() {
        ActionMenuView actionMenuView;
        switch (this.f7863c) {
            case 0:
                if (!this.f7864f) {
                    ActionBarContextView actionBarContextView = (ActionBarContextView) this.f7866h;
                    actionBarContextView.f756j = null;
                    super/*android.view.View*/.setVisibility(this.f7865g);
                    break;
                }
                break;
            case 1:
                if (!this.f7864f) {
                    stepos.support.v7.widget.ActionBarContextView actionBarContextView2 = (stepos.support.v7.widget.ActionBarContextView) this.f7866h;
                    actionBarContextView2.f12715m = null;
                    super/*android.view.View*/.setVisibility(this.f7865g);
                    break;
                }
                break;
            default:
                Toolbar toolbar = (Toolbar) this.f7866h;
                if (!this.f7864f && (actionMenuView = toolbar.f12681c) != null) {
                    actionMenuView.setVisibility(this.f7865g);
                    break;
                }
                break;
        }
    }
}
