package stepos.support.v7.app;

import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;
import fa.C1449a;
import h2.RunnableC1484b;

/* renamed from: stepos.support.v7.app.t, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1970t extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6339a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C1970t(Object obj, int i) {
        this.f6339a = i;
        this.b = obj;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationEnd(View view) {
        switch (this.f6339a) {
            case 0:
                RunnableC1484b runnableC1484b = (RunnableC1484b) this.b;
                ViewCompat.setAlpha(((AbstractC1975y) runnableC1484b.b).u, 1.0f);
                ((AbstractC1975y) runnableC1484b.b).f6368x.setListener(null);
                ((AbstractC1975y) runnableC1484b.b).f6368x = null;
                break;
            case 1:
                AbstractC1975y abstractC1975y = (AbstractC1975y) this.b;
                ViewCompat.setAlpha(abstractC1975y.u, 1.0f);
                abstractC1975y.f6368x.setListener(null);
                abstractC1975y.f6368x = null;
                break;
            default:
                C1449a c1449a = (C1449a) this.b;
                ((AbstractC1975y) c1449a.c).u.setVisibility(8);
                AbstractC1975y abstractC1975y2 = (AbstractC1975y) c1449a.c;
                PopupWindow popupWindow = abstractC1975y2.f6366v;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (abstractC1975y2.u.getParent() instanceof View) {
                    ViewCompat.requestApplyInsets((View) ((AbstractC1975y) c1449a.c).u.getParent());
                }
                ((AbstractC1975y) c1449a.c).u.removeAllViews();
                ((AbstractC1975y) c1449a.c).f6368x.setListener(null);
                ((AbstractC1975y) c1449a.c).f6368x = null;
                break;
        }
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart(View view) {
        switch (this.f6339a) {
            case 0:
                ((AbstractC1975y) ((RunnableC1484b) this.b).b).u.setVisibility(0);
                break;
            case 1:
                AbstractC1975y abstractC1975y = (AbstractC1975y) this.b;
                abstractC1975y.u.setVisibility(0);
                abstractC1975y.u.sendAccessibilityEvent(32);
                if (abstractC1975y.u.getParent() != null) {
                    ViewCompat.requestApplyInsets((View) abstractC1975y.u.getParent());
                    break;
                }
                break;
            default:
                super.onAnimationStart(view);
                break;
        }
    }
}
