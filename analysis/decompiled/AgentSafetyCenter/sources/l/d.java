package l;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import java.util.ArrayList;
import m.b2;
import m.k0;
import m.n0;
import stepos.support.v7.view.menu.ListMenuItemView;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7542c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ Object f7543f;

    public /* synthetic */ d(int i) {
        this.f7542c = i;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        switch (this.f7542c) {
            case 0:
                f fVar = (f) this.f7543f;
                ArrayList arrayList = fVar.f7553l;
                if (fVar.b() && arrayList.size() > 0) {
                    int i = 0;
                    if (!((e) arrayList.get(0)).f7545a.C) {
                        View view = fVar.f7560s;
                        if (view != null && view.isShown()) {
                            int size = arrayList.size();
                            while (i < size) {
                                Object obj = arrayList.get(i);
                                i++;
                                ((e) obj).f7545a.f();
                            }
                            break;
                        } else {
                            fVar.dismiss();
                            break;
                        }
                    }
                }
                break;
            case 1:
                c0 c0Var = (c0) this.f7543f;
                b2 b2Var = c0Var.f7529l;
                if (c0Var.b() && !b2Var.C) {
                    View view2 = c0Var.f7534q;
                    if (view2 != null && view2.isShown()) {
                        b2Var.f();
                        break;
                    } else {
                        c0Var.dismiss();
                        break;
                    }
                }
                break;
            case 2:
                n0 n0Var = (n0) this.f7543f;
                if (!n0Var.getInternalPopup().b()) {
                    n0Var.f8016j.m(n0Var.getTextDirection(), n0Var.getTextAlignment());
                }
                ViewTreeObserver viewTreeObserver = n0Var.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                    break;
                }
                break;
            case 3:
                k0 k0Var = (k0) this.f7543f;
                n0 n0Var2 = k0Var.I;
                if (!n0Var2.isAttachedToWindow() || !n0Var2.getGlobalVisibleRect(k0Var.G)) {
                    k0Var.dismiss();
                    break;
                } else {
                    k0Var.s();
                    k0Var.f();
                    break;
                }
                break;
            default:
                ListMenuItemView listMenuItemView = (ListMenuItemView) this.f7543f;
                listMenuItemView.f12547h.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                if (listMenuItemView.f12547h.getLineCount() > 1) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) listMenuItemView.getLayoutParams();
                    layoutParams.height = -1;
                    listMenuItemView.setLayoutParams(layoutParams);
                    break;
                }
                break;
        }
    }
}
