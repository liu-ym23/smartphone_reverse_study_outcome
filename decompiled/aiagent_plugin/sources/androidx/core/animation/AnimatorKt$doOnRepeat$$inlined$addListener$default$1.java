package androidx.core.animation;

import android.animation.Animator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatorKt$doOnRepeat$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ b $onRepeat;

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r1) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r1) {
    }

    public AnimatorKt$doOnRepeat$$inlined$addListener$default$1(b r3) {
        this.$onRepeat = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator r1) {
        this.$onRepeat.invoke(r1);
    }
}
