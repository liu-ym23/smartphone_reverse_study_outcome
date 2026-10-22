package androidx.core.animation;

import android.animation.Animator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.x;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatorKt$addPauseListener$listener$1 implements Animator.AnimatorPauseListener {
    final /* synthetic */ b<Animator, x> $onPause;
    final /* synthetic */ b<Animator, x> $onResume;

    AnimatorKt$addPauseListener$listener$1(b<? super Animator, x> r3, b<? super Animator, x> r4) {
        b<Animator, x> r5 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        b<Animator, x> r6 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        this.$onPause = r5;
        this.$onResume = r6;
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationPause(Animator r1) {
        this.$onPause.invoke(r1);
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationResume(Animator r1) {
        this.$onResume.invoke(r1);
    }
}
