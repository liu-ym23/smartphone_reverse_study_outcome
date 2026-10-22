package com.stepos.taskrobot.llmapi.stepfun.view.popup;

import S7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0002 \u001fB5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u000fJ\r\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0015R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u0016R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0015R$\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001a8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001e¨\u0006!"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/HandleVerticalDragger;", "", "", "triggerPx", "maxRubberPx", "flingVyThreshold", "Lkotlin/Function0;", "LC7/r;", "onTriggered", "Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/HandleVerticalDragger$Effects;", "effects", AppAgent.CONSTRUCT, "(FFFLS7/a;Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/HandleVerticalDragger$Effects;)V", "rawY", "onDown", "(F)V", "onMove", "velocityY", "onUp", "restore", "()V", "F", "LS7/a;", "Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/HandleVerticalDragger$Effects;", "dragStartY", "currentOffsetY", "", "value", "isTriggered", "Z", "()Z", "Companion", "Effects", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HandleVerticalDragger {
    private static final float TRIGGER_TOLERANCE_PX = 0.5f;
    private float currentOffsetY;
    private float dragStartY;
    private final Effects effects;
    private final float flingVyThreshold;
    private boolean isTriggered;
    private final float maxRubberPx;
    private final a onTriggered;
    private final float triggerPx;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\bJ\u000f\u0010\u000b\u001a\u00020\u0004H&¢\u0006\u0004\b\u000b\u0010\b¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/popup/HandleVerticalDragger$Effects;", "", "", "value", "LC7/r;", "setTranslationY", "(F)V", "setVisibilityGone", "()V", "startReboundSpring", "cancelReboundSpring", "resetForRestore", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Effects {
        void cancelReboundSpring();

        void resetForRestore();

        void setTranslationY(float value);

        void setVisibilityGone();

        void startReboundSpring();
    }

    public HandleVerticalDragger(float f, float f7, float f9, a onTriggered, Effects effects) {
        k.f(onTriggered, "onTriggered");
        k.f(effects, "effects");
        this.triggerPx = f;
        this.maxRubberPx = f7;
        this.flingVyThreshold = f9;
        this.onTriggered = onTriggered;
        this.effects = effects;
    }

    /* renamed from: isTriggered, reason: from getter */
    public final boolean getIsTriggered() {
        return this.isTriggered;
    }

    public final void onDown(float rawY) {
        if (this.isTriggered) {
            return;
        }
        this.effects.cancelReboundSpring();
        this.dragStartY = rawY;
        this.currentOffsetY = 0.0f;
    }

    public final void onMove(float rawY) {
        if (this.isTriggered) {
            return;
        }
        float f = rawY - this.dragStartY;
        float f7 = 0.0f;
        if (f < 0.0f) {
            float f9 = -f;
            float f10 = this.maxRubberPx;
            f7 = -((f10 * f9) / (f9 + f10));
        }
        this.currentOffsetY = f7;
        this.effects.setTranslationY(f7);
    }

    public final void onUp(float velocityY) {
        if (this.isTriggered) {
            return;
        }
        if ((-this.currentOffsetY) >= this.triggerPx - 0.5f || velocityY <= this.flingVyThreshold) {
            this.isTriggered = true;
            this.effects.setTranslationY(0.0f);
            this.effects.setVisibilityGone();
            this.onTriggered.invoke();
        } else {
            this.effects.startReboundSpring();
        }
        this.currentOffsetY = 0.0f;
    }

    public final void restore() {
        this.effects.cancelReboundSpring();
        this.isTriggered = false;
        this.currentOffsetY = 0.0f;
        this.effects.resetForRestore();
    }
}
