package stepos.support.v7.widget;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* loaded from: classes4.dex */
public final class F0 extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6459a = false;
    public final /* synthetic */ int b;
    public final /* synthetic */ G0 c;

    public F0(G0 g02, int i) {
        this.c = g02;
        this.b = i;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationCancel(View view) {
        this.f6459a = true;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationEnd(View view) {
        if (this.f6459a) {
            return;
        }
        G0 g02 = this.c;
        Toolbar toolbar = g02.f6462a;
        int i = this.b;
        toolbar.setVisibility(i);
        g02.f6462a.setMenuVisibility(i);
        if (i == 4) {
            g02.f6462a.requestLayout();
        }
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public final void onAnimationStart(View view) {
        this.c.f6462a.setVisibility(0);
    }
}
