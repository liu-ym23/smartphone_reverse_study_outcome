package com.stepos.taskrobot.llmapi.stepfun.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.FrameLayout;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.llmapi.stepfun.R;
import kotlin.Metadata;
import kotlin.jvm.internal.e;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0014\u0010\u000eJ\u0015\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b\u0015\u0010\u000eJ\u0015\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001f\u0010\u001eJ\r\u0010 \u001a\u00020\f¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\fH\u0014¢\u0006\u0004\b\"\u0010!R\u0014\u0010#\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$R\u0014\u0010&\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00168\u0002X\u0082D¢\u0006\u0006\n\u0004\b(\u0010'R\u0016\u0010)\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010*\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00100\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010.R\u0018\u00103\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u00068"}, d2 = {"Lcom/stepos/taskrobot/llmapi/stepfun/view/PullableHandleHost;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", AppAgent.CONSTRUCT, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Landroid/view/View;", "body", "LC7/r;", "reboundCardAlpha", "(Landroid/view/View;)V", "Lcom/stepos/taskrobot/llmapi/stepfun/view/HandleSlideAnimator;", "a", "bindAnimator", "(Lcom/stepos/taskrobot/llmapi/stepfun/view/HandleSlideAnimator;)V", "v", "bindHandle", "bindCardBody", "", "px", "setMaxRubberPx", "(F)V", "Landroid/view/MotionEvent;", "ev", "", "onInterceptTouchEvent", "(Landroid/view/MotionEvent;)Z", "onTouchEvent", "resetCardAlpha", "()V", "onDetachedFromWindow", "handleHotZoneHeight", "I", "triggerDistancePx", "defaultMaxRubberPx", "F", "flingVelocityThreshold", "dragStartY", "currentOffsetY", "animator", "Lcom/stepos/taskrobot/llmapi/stepfun/view/HandleSlideAnimator;", "handle", "Landroid/view/View;", "Landroid/view/VelocityTracker;", "velocityTracker", "Landroid/view/VelocityTracker;", "cardBody", "maxRubberOverridePx", "Ljava/lang/Float;", "Landroidx/dynamicanimation/animation/SpringAnimation;", "cardAlphaSpring", "Landroidx/dynamicanimation/animation/SpringAnimation;", "stepfun_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PullableHandleHost extends FrameLayout {
    private HandleSlideAnimator animator;
    private SpringAnimation cardAlphaSpring;
    private View cardBody;
    private float currentOffsetY;
    private final float defaultMaxRubberPx;
    private float dragStartY;
    private final float flingVelocityThreshold;
    private View handle;
    private final int handleHotZoneHeight;
    private Float maxRubberOverridePx;
    private final int triggerDistancePx;
    private VelocityTracker velocityTracker;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PullableHandleHost(Context context) {
        this(context, null, 0, 6, null);
        k.f(context, "context");
    }

    private final void reboundCardAlpha(View body) {
        SpringAnimation springAnimation = this.cardAlphaSpring;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        SpringAnimation springAnimation2 = new SpringAnimation(body, DynamicAnimation.ALPHA);
        SpringForce springForce = new SpringForce(1.0f);
        springForce.setStiffness(1500.0f);
        springForce.setDampingRatio(0.75f);
        springAnimation2.setSpring(springForce);
        springAnimation2.start();
        this.cardAlphaSpring = springAnimation2;
    }

    public final void bindAnimator(HandleSlideAnimator a3) {
        k.f(a3, "a");
        this.animator = a3;
    }

    public final void bindCardBody(View v10) {
        k.f(v10, "v");
        this.cardBody = v10;
    }

    public final void bindHandle(View v10) {
        k.f(v10, "v");
        this.handle = v10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        HandleSlideAnimator handleSlideAnimator = this.animator;
        if (handleSlideAnimator != null) {
            handleSlideAnimator.cancelRunning();
        }
        SpringAnimation springAnimation = this.cardAlphaSpring;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        this.cardAlphaSpring = null;
        View view = this.cardBody;
        if (view != null) {
            view.setAlpha(1.0f);
        }
        VelocityTracker velocityTracker = this.velocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.velocityTracker = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        k.f(ev, "ev");
        return ev.getAction() == 0 && ev.getY() <= ((float) this.handleHotZoneHeight);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0062  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            java.lang.String r0 = "ev"
            kotlin.jvm.internal.k.f(r8, r0)
            android.view.VelocityTracker r0 = r7.velocityTracker
            if (r0 != 0) goto Lf
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r7.velocityTracker = r0
        Lf:
            r0.addMovement(r8)
            int r1 = r8.getAction()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto La7
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            if (r1 == r3) goto L62
            r6 = 2
            if (r1 == r6) goto L27
            r8 = 3
            if (r1 == r8) goto L62
            goto Lbd
        L27:
            float r8 = r8.getRawY()
            float r0 = r7.dragStartY
            float r8 = r8 - r0
            java.lang.Float r0 = r7.maxRubberOverridePx
            if (r0 == 0) goto L37
            float r0 = r0.floatValue()
            goto L39
        L37:
            float r0 = r7.defaultMaxRubberPx
        L39:
            int r1 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r1 >= 0) goto L44
            float r8 = -r8
            float r1 = r0 * r8
            float r8 = r8 + r0
            float r1 = r1 / r8
            float r8 = -r1
            goto L45
        L44:
            r8 = r5
        L45:
            r7.currentOffsetY = r8
            android.view.View r0 = r7.handle
            if (r0 == 0) goto L4e
            r0.setTranslationY(r8)
        L4e:
            android.view.View r8 = r7.cardBody
            if (r8 == 0) goto Lbd
            float r0 = r7.currentOffsetY
            float r0 = -r0
            int r7 = r7.triggerDistancePx
            float r7 = (float) r7
            float r0 = r0 / r7
            float r7 = g1.AbstractC1451a.t(r0, r5, r4)
            float r4 = r4 - r7
            r8.setAlpha(r4)
            goto Lbd
        L62:
            r8 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r8)
            float r8 = r0.getYVelocity()
            float r1 = r7.currentOffsetY
            float r1 = -r1
            int r6 = r7.triggerDistancePx
            float r6 = (float) r6
            int r1 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r1 >= 0) goto L8f
            float r1 = r7.flingVelocityThreshold
            int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r8 > 0) goto L7c
            goto L8f
        L7c:
            android.view.View r8 = r7.handle
            if (r8 == 0) goto L87
            com.stepos.taskrobot.llmapi.stepfun.view.HandleSlideAnimator r1 = r7.animator
            if (r1 == 0) goto L87
            r1.playReboundOnHandle(r8)
        L87:
            android.view.View r8 = r7.cardBody
            if (r8 == 0) goto L9f
            r7.reboundCardAlpha(r8)
            goto L9f
        L8f:
            android.view.View r8 = r7.cardBody
            if (r8 == 0) goto L96
            r8.setAlpha(r4)
        L96:
            com.stepos.taskrobot.llmapi.stepfun.view.HandleSlideAnimator r8 = r7.animator
            if (r8 == 0) goto L9f
            android.view.View r1 = r7.handle
            r8.playDismiss(r7, r1)
        L9f:
            r7.currentOffsetY = r5
            r0.recycle()
            r7.velocityTracker = r2
            goto Lbd
        La7:
            com.stepos.taskrobot.llmapi.stepfun.view.HandleSlideAnimator r0 = r7.animator
            if (r0 == 0) goto Lae
            r0.cancelRunning()
        Lae:
            androidx.dynamicanimation.animation.SpringAnimation r0 = r7.cardAlphaSpring
            if (r0 == 0) goto Lb5
            r0.cancel()
        Lb5:
            r7.cardAlphaSpring = r2
            float r8 = r8.getRawY()
            r7.dragStartY = r8
        Lbd:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.taskrobot.llmapi.stepfun.view.PullableHandleHost.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void resetCardAlpha() {
        SpringAnimation springAnimation = this.cardAlphaSpring;
        if (springAnimation != null) {
            springAnimation.cancel();
        }
        this.cardAlphaSpring = null;
        View view = this.cardBody;
        if (view != null) {
            view.setAlpha(1.0f);
        }
    }

    public final void setMaxRubberPx(float px) {
        this.maxRubberOverridePx = Float.valueOf(px);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PullableHandleHost(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        k.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PullableHandleHost(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        k.f(context, "context");
        this.handleHotZoneHeight = getResources().getDimensionPixelSize(R.dimen.overlay_handle_hot_zone_height);
        this.triggerDistancePx = getResources().getDimensionPixelSize(R.dimen.overlay_pull_trigger_distance);
        this.defaultMaxRubberPx = getResources().getDimensionPixelSize(R.dimen.overlay_pull_max_rubber);
        this.flingVelocityThreshold = -1000.0f;
    }

    public /* synthetic */ PullableHandleHost(Context context, AttributeSet attributeSet, int i, int i6, e eVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? 0 : i);
    }
}
