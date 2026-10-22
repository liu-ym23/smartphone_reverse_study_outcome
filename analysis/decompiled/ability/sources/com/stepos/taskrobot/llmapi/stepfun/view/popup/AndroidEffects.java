package com.stepos.taskrobot.llmapi.stepfun.view.popup;

import android.view.View;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.llmapi.stepfun.view.popup.HandleVerticalDragger;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\fJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\fJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0010R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/AndroidEffects;", "Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/HandleVerticalDragger$Effects;", "Landroid/view/View;", "handle", AppAgent.CONSTRUCT, "(Landroid/view/View;)V", "", "value", "LC7/r;", "setTranslationY", "(F)V", "setVisibilityGone", "()V", "startReboundSpring", "cancelReboundSpring", "resetForRestore", "Landroid/view/View;", "Landroidx/dynamicanimation/animation/SpringAnimation;", "rebound", "Landroidx/dynamicanimation/animation/SpringAnimation;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidEffects implements HandleVerticalDragger.Effects {
    private final View handle;
    private SpringAnimation rebound;

    public AndroidEffects(View handle) {
        k.f(handle, "handle");
        this.handle = handle;
    }

    @Override // com.stepos.taskrobot.llmapi.stepfun.view.popup.HandleVerticalDragger.Effects
    public void cancelReboundSpring() {
        SpringAnimation springAnimation = this.rebound;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        this.rebound = null;
    }

    @Override // com.stepos.taskrobot.llmapi.stepfun.view.popup.HandleVerticalDragger.Effects
    public void resetForRestore() {
        SpringAnimation springAnimation = this.rebound;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        this.rebound = null;
        this.handle.setTranslationY(0.0f);
        this.handle.setVisibility(0);
    }

    @Override // com.stepos.taskrobot.llmapi.stepfun.view.popup.HandleVerticalDragger.Effects
    public void setTranslationY(float value) {
        this.handle.setTranslationY(value);
    }

    @Override // com.stepos.taskrobot.llmapi.stepfun.view.popup.HandleVerticalDragger.Effects
    public void setVisibilityGone() {
        this.handle.setVisibility(8);
    }

    @Override // com.stepos.taskrobot.llmapi.stepfun.view.popup.HandleVerticalDragger.Effects
    public void startReboundSpring() {
        SpringAnimation springAnimation = this.rebound;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        SpringAnimation springAnimation2 = new SpringAnimation(this.handle, DynamicAnimation.TRANSLATION_Y);
        SpringForce springForce = new SpringForce(0.0f);
        springForce.setStiffness(200.0f);
        springForce.setDampingRatio(0.5f);
        springAnimation2.setSpring(springForce);
        springAnimation2.start();
        this.rebound = springAnimation2;
    }
}
