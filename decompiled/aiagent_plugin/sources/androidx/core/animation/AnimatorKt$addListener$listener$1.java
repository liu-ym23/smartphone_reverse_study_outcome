package androidx.core.animation;

import android.animation.Animator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.a.b;
import d.x;

/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AnimatorKt$addListener$listener$1 implements Animator.AnimatorListener {
    final /* synthetic */ b<Animator, x> $onCancel;
    final /* synthetic */ b<Animator, x> $onEnd;
    final /* synthetic */ b<Animator, x> $onRepeat;
    final /* synthetic */ b<Animator, x> $onStart;

    public AnimatorKt$addListener$listener$1(b<? super Animator, x> r3, b<? super Animator, x> r4, b<? super Animator, x> r5, b<? super Animator, x> r6) {
        b<Animator, x> r7 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        b<Animator, x> r8 = (b) ZeusTransformUtils.wrapperContextForParams(r4, b.class, "com.obric.aiagent.plugin");
        b<Animator, x> r9 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        b<Animator, x> r10 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.aiagent.plugin");
        this.$onRepeat = r7;
        this.$onEnd = r8;
        this.$onCancel = r9;
        this.$onStart = r10;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator r1) {
        this.$onRepeat.invoke(r1);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r1) {
        this.$onEnd.invoke(r1);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r1) {
        this.$onCancel.invoke(r1);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r1) {
        this.$onStart.invoke(r1);
    }
}
