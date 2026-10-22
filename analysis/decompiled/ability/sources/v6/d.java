package v6;

import android.view.View;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

/* loaded from: classes3.dex */
public final class d extends ViewPropertyAnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6784a;

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationEnd(View view) {
        switch (this.f6784a) {
            case 1:
                view.setVisibility(4);
                break;
            default:
                super.onAnimationEnd(view);
                break;
        }
    }

    @Override // androidx.core.view.ViewPropertyAnimatorListenerAdapter, androidx.core.view.ViewPropertyAnimatorListener
    public void onAnimationStart(View view) {
        switch (this.f6784a) {
            case 0:
                view.setVisibility(0);
                break;
            default:
                super.onAnimationStart(view);
                break;
        }
    }
}
