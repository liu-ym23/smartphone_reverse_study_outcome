package ay3;

import android.animation.Animator;
import com.bytedance.awemeopen.apps.framework.base.view.xtoast.XToast;

/* JADX INFO: loaded from: classes14.dex */
public final class b implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XToast f16743a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f16744b;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
        XToast r101 = this.f16743a;
        r101.f193805b.removeView(r101.f193806c);
        this.f16744b.sendEmptyMessage(1929);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        XToast r101 = this.f16743a;
        r101.f193805b.removeView(r101.f193806c);
        this.f16744b.sendEmptyMessage(1929);
    }

    public b(c r100, XToast r101) {
        this.f16744b = r100;
        this.f16743a = r101;
    }
}
