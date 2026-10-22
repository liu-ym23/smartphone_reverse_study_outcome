package com.stepos.taskrobot.llmapi.stepfun.view;

import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/HandleSlideAnimator;", "", "Lkotlin/Function0;", "LC7/r;", "onTriggered", AppAgent.CONSTRUCT, "(LS7/a;)V", "Landroid/view/View;", "handle", "playReboundOnHandle", "(Landroid/view/View;)V", "host", "playDismiss", "(Landroid/view/View;Landroid/view/View;)V", "cancelRunning", "()V", "LS7/a;", "Landroidx/dynamicanimation/animation/SpringAnimation;", "rebound", "Landroidx/dynamicanimation/animation/SpringAnimation;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HandleSlideAnimator {
    private final S7.a onTriggered;
    private SpringAnimation rebound;

    public HandleSlideAnimator(S7.a onTriggered) {
        k.f(onTriggered, "onTriggered");
        this.onTriggered = onTriggered;
    }

    public final void cancelRunning() {
        SpringAnimation springAnimation = this.rebound;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        this.rebound = null;
    }

    public final void playDismiss(View host, View handle) {
        k.f(host, "host");
        SpringAnimation springAnimation = this.rebound;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        this.rebound = null;
        if (handle != null) {
            handle.setTranslationY(0.0f);
        }
        this.onTriggered.invoke();
    }

    public final void playReboundOnHandle(View handle) {
        k.f(handle, "handle");
        SpringAnimation springAnimation = this.rebound;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        SpringAnimation springAnimation2 = new SpringAnimation(handle, DynamicAnimation.TRANSLATION_Y);
        SpringForce springForce = new SpringForce(0.0f);
        springForce.setStiffness(1500.0f);
        springForce.setDampingRatio(0.75f);
        springAnimation2.setSpring(springForce);
        springAnimation2.start();
        this.rebound = springAnimation2;
    }
}
