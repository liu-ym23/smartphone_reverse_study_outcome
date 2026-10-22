package bd5;

import android.animation.Animator;
import com.bytedance.ee.bear.list.homepage.title.MainTabTitleBar;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainTabTitleBar f18667a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    public i(MainTabTitleBar r100) {
        this.f18667a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        this.f18667a.f228380f = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        MainTabTitleBar r101 = this.f18667a;
        if (r101.f228381g == true) goto L5;
        r101.setVisibility(8);
    L5:
        this.f18667a.f228380f = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        MainTabTitleBar r101 = this.f18667a;
        if (r101.f228381g == false) goto L6;
        r101.setVisibility(0);
        return;
    }
}
