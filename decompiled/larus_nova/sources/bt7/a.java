package bt7;

import android.animation.Animator;
import com.enroll.audio.enroll.ui.fragment.r;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements Animator.AnimatorListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function0 f20565a;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator r100) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r100) {
    }

    public a(r r100) {
        this.f20565a = r100;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r100) {
        this.f20565a.invoke();
    }
}
