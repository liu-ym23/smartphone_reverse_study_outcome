package a1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.behavior.HideViewOnScrollBehavior;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f28a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f29b;

    public /* synthetic */ k(int i8, Object obj) {
        this.f28a = i8;
        this.f29b = obj;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f28a) {
            case 1:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f29b;
                actionBarOverlayLayout.f308u = null;
                actionBarOverlayLayout.f297j = false;
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f28a) {
            case 0:
                ((o) this.f29b).m();
                animator.removeListener(this);
                break;
            case 1:
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.f29b;
                actionBarOverlayLayout.f308u = null;
                actionBarOverlayLayout.f297j = false;
                break;
            case 2:
                ((HideBottomViewOnScrollBehavior) this.f29b).f1215k = null;
                break;
            case 3:
                ((HideViewOnScrollBehavior) this.f29b).f1225k = null;
                break;
            default:
                w1.l lVar = (w1.l) this.f29b;
                lVar.p();
                lVar.f6115r.start();
                break;
        }
    }
}
