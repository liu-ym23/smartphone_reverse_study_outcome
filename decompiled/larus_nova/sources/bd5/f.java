package bd5;

import android.animation.Animator;
import com.bytedance.ee.bear.list.homepage.title.HomeMainTitleBar;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HomeMainTitleBar f18664a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    public f(HomeMainTitleBar r100) {
        this.f18664a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        this.f18664a.f228359k = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        HomeMainTitleBar r101 = this.f18664a;
        if (r101.f228360l == true) goto L5;
        r101.setVisibility(8);
    L5:
        this.f18664a.f228359k = null;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
        HomeMainTitleBar r101 = this.f18664a;
        if (r101.f228360l == false) goto L6;
        r101.setVisibility(0);
        return;
    }
}
