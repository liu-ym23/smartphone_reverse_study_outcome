package androidx.appcompat.app;

import K.S;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.WeakHashMap;
import stepos.support.v7.app.AbstractC0880z;
import stepos.support.v7.app.RunnableC0876v;
import stepos.support.v7.widget.ActionBarContextView;

/* loaded from: classes.dex */
public final class t extends C.b {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f2680e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f2681f;

    public /* synthetic */ t(int i4, Object obj) {
        this.f2680e = i4;
        this.f2681f = obj;
    }

    @Override // C.b, K.f0
    public final void c(View view) {
        int i4 = this.f2680e;
        Object obj = this.f2681f;
        switch (i4) {
            case 0:
                r rVar = (r) obj;
                rVar.f2677b.f2521n.setAlpha(1.0f);
                F f4 = rVar.f2677b;
                f4.f2524q.e(null);
                f4.f2524q = null;
                break;
            case 1:
                F f5 = (F) obj;
                f5.f2521n.setAlpha(1.0f);
                f5.f2524q.e(null);
                f5.f2524q = null;
                break;
            case 2:
                u uVar = (u) obj;
                uVar.f2683b.f2521n.setVisibility(8);
                F f6 = uVar.f2683b;
                PopupWindow popupWindow = f6.f2522o;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (f6.f2521n.getParent() instanceof View) {
                    View view2 = (View) f6.f2521n.getParent();
                    WeakHashMap weakHashMap = S.f939a;
                    K.H.c(view2);
                }
                f6.f2521n.e();
                f6.f2524q.e(null);
                f6.f2524q = null;
                ViewGroup viewGroup = f6.f2527t;
                WeakHashMap weakHashMap2 = S.f939a;
                K.H.c(viewGroup);
                break;
            case 3:
                RunnableC0876v runnableC0876v = (RunnableC0876v) obj;
                ActionBarContextView actionBarContextView = runnableC0876v.f14591b.f14632u;
                WeakHashMap weakHashMap3 = S.f939a;
                actionBarContextView.setAlpha(1.0f);
                AbstractC0880z abstractC0880z = runnableC0876v.f14591b;
                abstractC0880z.f14635x.e(null);
                abstractC0880z.f14635x = null;
                break;
            case 4:
                AbstractC0880z abstractC0880z2 = (AbstractC0880z) obj;
                ActionBarContextView actionBarContextView2 = abstractC0880z2.f14632u;
                WeakHashMap weakHashMap4 = S.f939a;
                actionBarContextView2.setAlpha(1.0f);
                abstractC0880z2.f14635x.e(null);
                abstractC0880z2.f14635x = null;
                break;
            default:
                B0.e eVar = (B0.e) obj;
                ((AbstractC0880z) eVar.f143c).f14632u.setVisibility(8);
                AbstractC0880z abstractC0880z3 = (AbstractC0880z) eVar.f143c;
                PopupWindow popupWindow2 = abstractC0880z3.f14633v;
                if (popupWindow2 != null) {
                    popupWindow2.dismiss();
                } else if (abstractC0880z3.f14632u.getParent() instanceof View) {
                    View view3 = (View) ((AbstractC0880z) eVar.f143c).f14632u.getParent();
                    WeakHashMap weakHashMap5 = S.f939a;
                    K.H.c(view3);
                }
                ((AbstractC0880z) eVar.f143c).f14632u.removeAllViews();
                ((AbstractC0880z) eVar.f143c).f14635x.e(null);
                ((AbstractC0880z) eVar.f143c).f14635x = null;
                break;
        }
    }

    @Override // C.b, K.f0
    public final void d(View view) {
        int i4 = this.f2680e;
        Object obj = this.f2681f;
        switch (i4) {
            case 0:
                ((r) obj).f2677b.f2521n.setVisibility(0);
                break;
            case 1:
                F f4 = (F) obj;
                f4.f2521n.setVisibility(0);
                if (f4.f2521n.getParent() instanceof View) {
                    View view2 = (View) f4.f2521n.getParent();
                    WeakHashMap weakHashMap = S.f939a;
                    K.H.c(view2);
                    break;
                }
                break;
            case 3:
                ((RunnableC0876v) obj).f14591b.f14632u.setVisibility(0);
                break;
            case 4:
                AbstractC0880z abstractC0880z = (AbstractC0880z) obj;
                abstractC0880z.f14632u.setVisibility(0);
                abstractC0880z.f14632u.sendAccessibilityEvent(32);
                if (abstractC0880z.f14632u.getParent() != null) {
                    View view3 = (View) abstractC0880z.f14632u.getParent();
                    WeakHashMap weakHashMap2 = S.f939a;
                    K.H.c(view3);
                    break;
                }
                break;
        }
    }
}
