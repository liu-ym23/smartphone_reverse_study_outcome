package v0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class i extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5835a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ j f5836b;

    public i(j jVar) {
        this.f5836b = jVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f5835a = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (this.f5835a) {
            this.f5835a = false;
            return;
        }
        j jVar = this.f5836b;
        if (((Float) jVar.f5857u.getAnimatedValue()).floatValue() == 0.0f) {
            jVar.f5858v = 0;
            jVar.f(0);
        } else {
            jVar.f5858v = 2;
            jVar.f5850n.invalidate();
        }
    }
}
