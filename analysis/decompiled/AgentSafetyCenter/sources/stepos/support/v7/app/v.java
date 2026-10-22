package stepos.support.v7.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.util.Log;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class v extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12508a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w f12509b;

    public /* synthetic */ v(w wVar, int i) {
        this.f12508a = i;
        this.f12509b = wVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.f12508a) {
            case 1:
                super.onAnimationEnd(animator);
                w wVar = this.f12509b;
                wVar.f12513d.d();
                wVar.f12513d.overridePendingTransition(0, 0);
                wVar.f12515f = null;
                r2.i.m().getClass();
                r2.i.f10408f = null;
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.f12508a) {
            case 0:
                if (!this.f12509b.a()) {
                    r2.i.m().getClass();
                    break;
                }
                break;
            default:
                if (!this.f12509b.a()) {
                    Log.d("popup_stack", " top stack start exit Anim, try to call bottom stack do stackExit ");
                    r2.i.m().getClass();
                    Log.e("popup_stack", "  call bottom stack do stackExit , but state error, return ");
                    break;
                }
                break;
        }
    }
}
