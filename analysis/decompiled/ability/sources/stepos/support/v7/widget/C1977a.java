package stepos.support.v7.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewPropertyAnimatorListener;

/* renamed from: stepos.support.v7.widget.a, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C1977a implements ViewPropertyAnimatorListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6600a;
    public boolean b;
    public int c;
    public final Object d;

    public /* synthetic */ C1977a(ViewGroup viewGroup, int i) {
        this.f6600a = i;
        this.d = viewGroup;
        this.b = false;
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationCancel(View view) {
        switch (this.f6600a) {
            case 0:
                this.b = true;
                break;
            default:
                this.b = true;
                break;
        }
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd(View view) {
        ActionMenuView actionMenuView;
        switch (this.f6600a) {
            case 0:
                if (!this.b) {
                    AbstractC1979b abstractC1979b = (AbstractC1979b) this.d;
                    abstractC1979b.i = null;
                    super/*android.view.View*/.setVisibility(this.c);
                    break;
                }
                break;
            default:
                Toolbar toolbar = (Toolbar) this.d;
                if (!this.b && (actionMenuView = toolbar.f6579a) != null) {
                    actionMenuView.setVisibility(this.c);
                    break;
                }
                break;
        }
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart(View view) {
        switch (this.f6600a) {
            case 0:
                super/*android.view.View*/.setVisibility(0);
                this.b = false;
                break;
            default:
                ActionMenuView actionMenuView = ((Toolbar) this.d).f6579a;
                if (actionMenuView != null) {
                    actionMenuView.setVisibility(0);
                }
                this.b = false;
                break;
        }
    }

    public C1977a(X8.A a3, int i, boolean z10) {
        this.f6600a = 2;
        this.d = a3;
        this.c = i;
        this.b = z10;
    }
}
