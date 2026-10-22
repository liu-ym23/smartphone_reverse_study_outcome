package w1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6086a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ e f6087b;

    public /* synthetic */ d(e eVar, int i8) {
        this.f6086a = i8;
        this.f6087b = eVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f6086a) {
            case 1:
                this.f6087b.f6140b.h(false);
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f6086a) {
            case 0:
                this.f6087b.f6140b.h(true);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
