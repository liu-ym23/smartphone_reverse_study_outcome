package com.obric.autogui.animation;

import android.animation.Animator;
import android.util.Log;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import kotlinx.coroutines.a.q;
import kotlinx.coroutines.a.t;

/* JADX INFO: compiled from: Animation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AnimationKt$animateTo$1$2 implements Animator.AnimatorListener {
    final /* synthetic */ q<Integer> $$this$channelFlow;
    final /* synthetic */ int $to;

    public static /* synthetic */ String lambda$IuPstUjoMzguQKpuHFKhLU6_NDQ(int r0) {
        return onAnimationCancel$lambda$0(r0);
    }

    public static /* synthetic */ String lambda$MUvNoTKSVVfX4lB6041KbyRMevo() {
        return onAnimationCancel$lambda$1();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator r1) {
        o.e(r1, "animation");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator r1) {
        o.e(r1, "animation");
    }

    AnimationKt$animateTo$1$2(q<? super Integer> r3, int r4) {
        this.$$this$channelFlow = (q) ZeusTransformUtils.wrapperContextForParams(r3, q.class, "com.obric.aiagent.plugin");
        this.$to = r4;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator r2) {
        o.e(r2, "animation");
        t.a.a((t) ZeusTransformUtils.preCheckCast(this.$$this$channelFlow, t.class, "com.obric.aiagent.plugin"), null, 1, null);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator r4) {
        o.e(r4, "animation");
        Loog r5 = Loog.INSTANCE;
        final int r0 = this.$to;
        r5.ep("launchTextAnimation", new $$Lambda$AnimationKt$animateTo$1$2$IuPstUjoMzguQKpuHFKhLU6_NDQ(r0), $$Lambda$AnimationKt$animateTo$1$2$MUvNoTKSVVfX4lB6041KbyRMevo.INSTANCE);
        t.a.a((t) ZeusTransformUtils.preCheckCast(this.$$this$channelFlow, t.class, "com.obric.aiagent.plugin"), null, 1, null);
    }

    private static final String onAnimationCancel$lambda$0(int r2) {
        return "onAnimationCancel, value=" + r2 + ", stack=" + Log.getStackTraceString(new Throwable());
    }

    private static final String onAnimationCancel$lambda$1() {
        return "onAnimationCancel, stack=" + Log.getStackTraceString(new Throwable());
    }
}
