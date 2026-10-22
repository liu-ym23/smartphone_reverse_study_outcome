package com.obric.design.edgeglow;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.autogui.common.api.logging.Loog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: AiScreenEdgeEffectView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AiScreenEdgeEffectView extends View {
    private final long DELAY_HIGH_FPS;
    private final long DELAY_LOW_FPS;
    private final float SCALE;
    private boolean autoFreeze;
    private ValueAnimator colorAnimator;
    private float currentColorfulness;
    private long currentFrameDelay;
    private final Runnable dropFpsRunnable;
    private final Path framePath;
    private float internalTime;
    private boolean isAnimating;
    private final a loopRunnable;
    private final Paint paint;
    private final AiScreenEdgeEffectShader shader;

    /* JADX INFO: compiled from: AiScreenEdgeEffectView.kt */
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AiScreenEdgeEffectView f32661a;

        a(AiScreenEdgeEffectView r1) {
            this.f32661a = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AiScreenEdgeEffectView.access$isAnimating$p(this.f32661a) == true) goto L5;
            return;
        L5:
            AiScreenEdgeEffectView r0 = this.f32661a;
            AiScreenEdgeEffectView.access$setInternalTime$p(r0, AiScreenEdgeEffectView.access$getInternalTime$p(r0) + 0.033f);
            if (AiScreenEdgeEffectView.access$getInternalTime$p(this.f32661a) <= 1000.0f) goto L8;
            AiScreenEdgeEffectView r1 = this.f32661a;
            AiScreenEdgeEffectView.access$setInternalTime$p(r1, AiScreenEdgeEffectView.access$getInternalTime$p(r1) - 1000.0f);
        L8:
            AiScreenEdgeEffectView.access$getShader$p(this.f32661a).setTime(AiScreenEdgeEffectView.access$getInternalTime$p(this.f32661a));
            this.f32661a.invalidate();
            this.f32661a.postDelayed((Runnable) ZeusTransformUtils.preCheckCast(this, Runnable.class, "com.obric.aiagent.plugin"), AiScreenEdgeEffectView.access$getCurrentFrameDelay$p(this.f32661a));
        }
    }

    public AiScreenEdgeEffectView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public AiScreenEdgeEffectView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ void lambda$ZtDUI5gBBfotgAMaJMo2gY7OP64(AiScreenEdgeEffectView r0) {
        dropFpsRunnable$lambda$0(r0);
    }

    public static /* synthetic */ void lambda$lEiyb8bUGkSIRplPOWnwUpPXnQw(AiScreenEdgeEffectView r0, ValueAnimator r1) {
        playColorAnimation$lambda$4$lambda$2(r0, r1);
    }

    public /* synthetic */ AiScreenEdgeEffectView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r8 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(r7, r8, r4);
    }

    public static final /* synthetic */ long access$getCurrentFrameDelay$p(AiScreenEdgeEffectView r2) {
        return r2.currentFrameDelay;
    }

    public static final /* synthetic */ float access$getInternalTime$p(AiScreenEdgeEffectView r0) {
        return r0.internalTime;
    }

    public static final /* synthetic */ AiScreenEdgeEffectShader access$getShader$p(AiScreenEdgeEffectView r0) {
        return r0.shader;
    }

    public static final /* synthetic */ boolean access$isAnimating$p(AiScreenEdgeEffectView r0) {
        return r0.isAnimating;
    }

    public static final /* synthetic */ void access$setInternalTime$p(AiScreenEdgeEffectView r0, float r1) {
        r0.internalTime = r1;
    }

    public static final /* synthetic */ void access$stopTimeAnimation(AiScreenEdgeEffectView r0) {
        r0.stopTimeAnimation();
    }

    public AiScreenEdgeEffectView(Context r7, AttributeSet r8, int r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        super(r10, r11, r9);
        AiScreenEdgeEffectShader r12 = new AiScreenEdgeEffectShader();
        this.shader = r12;
        Paint r13 = new Paint();
        this.paint = r13;
        this.currentColorfulness = 1.0f;
        this.framePath = new Path();
        this.DELAY_HIGH_FPS = 33;
        this.DELAY_LOW_FPS = 10000000;
        this.currentFrameDelay = 33;
        this.SCALE = 8.0f;
        this.dropFpsRunnable = new $$Lambda$AiScreenEdgeEffectView$ZtDUI5gBBfotgAMaJMo2gY7OP64(this);
        this.loopRunnable = new a(this);
        setBackground(null);
        setScaleX(8.0f);
        setScaleY(8.0f);
        setPivotX(0.0f);
        setPivotY(0.0f);
        initializeShader();
        startTimeAnimation();
        r13.setShader((Shader) ZeusTransformUtils.preCheckCast(r12, Shader.class, "com.obric.aiagent.plugin"));
    }

    public final boolean getAutoFreeze() {
        return this.autoFreeze;
    }

    public final void setAutoFreeze(boolean r2) {
        if (this.autoFreeze == r2) goto L6;
        this.autoFreeze = r2;
        resetFrameRateLogic();
        return;
    }

    private static final void dropFpsRunnable$lambda$0(AiScreenEdgeEffectView r2) {
        if (r2.autoFreeze == false) goto L6;
        r2.currentFrameDelay = r2.DELAY_LOW_FPS;
        ILogDepend.Companion.d("effect", "change to low fps");
        return;
    }

    private final void initializeShader() {
        AiScreenEdgeEffectShader r0 = this.shader;
        r0.setTime(0.0f);
        r0.setAlpha(1.0f);
        r0.setSoftness(1.0f);
        r0.setColorfulness(this.currentColorfulness);
        r0.setColor(-2147434752);
    }

    private final void startTimeAnimation() {
        if (this.isAnimating == false) goto L5;
        return;
    L5:
        Loog.INSTANCE.d("effect", "start anim");
        this.isAnimating = true;
        resetFrameRateLogic();
        removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(this.loopRunnable, Runnable.class, "com.obric.aiagent.plugin"));
        post((Runnable) ZeusTransformUtils.preCheckCast(this.loopRunnable, Runnable.class, "com.obric.aiagent.plugin"));
    }

    private final void stopTimeAnimation() {
        Loog.INSTANCE.d("effect", "stop anim");
        this.isAnimating = false;
        removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(this.loopRunnable, Runnable.class, "com.obric.aiagent.plugin"));
        removeCallbacks(this.dropFpsRunnable);
    }

    private final void resetFrameRateLogic() {
        restoreHighFps();
        removeCallbacks(this.dropFpsRunnable);
        if (this.autoFreeze == false) goto L5;
        postDelayed(this.dropFpsRunnable, OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS);
    L5:
        Loog.INSTANCE.d("effect", "reset frame rate auto-freeze=" + this.autoFreeze);
    }

    private final void restoreHighFps() {
        long r0 = this.currentFrameDelay;
        long r2 = this.DELAY_HIGH_FPS;
        if (r0 == r2) goto L9;
        this.currentFrameDelay = r2;
        if (this.isAnimating == false) goto L7;
        removeCallbacks((Runnable) ZeusTransformUtils.preCheckCast(this.loopRunnable, Runnable.class, "com.obric.aiagent.plugin"));
        post((Runnable) ZeusTransformUtils.preCheckCast(this.loopRunnable, Runnable.class, "com.obric.aiagent.plugin"));
    L7:
        Loog.INSTANCE.d("effect", "change to high fps");
        return;
    }

    public final void playColorAnimation(final float r5) {
        if (this.currentColorfulness != r5) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        resetFrameRateLogic();
        ValueAnimator r1 = this.colorAnimator;
        if (r1 == null) goto L11;
        r1.cancel();
    L11:
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{this.currentColorfulness, r5});
        r2.setDuration(500);
        r2.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r2.addUpdateListener(new $$Lambda$AiScreenEdgeEffectView$lEiyb8bUGkSIRplPOWnwUpPXnQw(this));
        o.a(r2);
        Animator r3 = (Animator) ZeusTransformUtils.preCheckCast(r2, Animator.class, "com.obric.aiagent.plugin");
        Animator.AnimatorListener r4 = new AiScreenEdgeEffectView$playColorAnimation$lambda$4$$inlined$addListener$default$1(r5, this);
        r3.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r4, Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        Animator.AnimatorListener r6 = (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r4, Animator.AnimatorListener.class, "com.obric.aiagent.plugin");
        r2.start();
        this.colorAnimator = r2;
        if (this.isAnimating == true) goto L15;
        startTimeAnimation();
        return;
    L15:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private static final void playColorAnimation$lambda$4$lambda$2(AiScreenEdgeEffectView r2, ValueAnimator r3) {
        o.e(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        o.a(r4, "null cannot be cast to non-null type kotlin.Float");
        float r5 = ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).floatValue();
        r2.currentColorfulness = r5;
        r2.shader.setColorfulness(r5);
        if (r2.isAnimating == true) goto L6;
        r2.invalidate();
        return;
    }

    @Override // android.view.View
    public void onSizeChanged(int r7, int r8, int r9, int r10) {
        super.onSizeChanged(r7, r8, r9, r10);
        AiScreenEdgeEffectShader r11 = this.shader;
        float r12 = r7;
        float r13 = r8;
        r11.setResolution(r12, r13);
        Float r14 = Float.valueOf(Math.abs(getScaleX()));
        if (((Number) ZeusTransformUtils.preCheckCast(r14, Number.class, "com.obric.aiagent.plugin")).floatValue() <= 0.0f) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        r14 = null;
    L9:
        if (r14 == null) goto L11;
        float r15 = r14.floatValue();
    L12:
        r11.setDensity(ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().density / r15);
        float r16 = 50.0f * (ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics().density / this.SCALE);
        this.framePath.reset();
        this.framePath.addRect(0.0f, 0.0f, r12, r13, Path.Direction.CW);
        float r17 = 2 * r16;
        if (r12 > r17) goto L15;
        return;
    L15:
        if (r13 <= r17) goto L19;
        this.framePath.addRect(r16, r16, r12 - r16, r13 - r16, Path.Direction.CCW);
        return;
    L19:
        return;
    L11:
        r15 = 1.0f;
        goto L12
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.view.View
    public void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        int r5 = View.MeasureSpec.getSize(r3);
        int r6 = View.MeasureSpec.getSize(r4);
        float r0 = this.SCALE;
        setMeasuredDimension(r5 / ((int) r0), r6 / ((int) r0));
    }

    @Override // android.view.View
    public void onDraw(Canvas r2) {
        o.e(r2, "canvas");
        r2.drawPath(this.framePath, this.paint);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r2) {
        super.onWindowVisibilityChanged(r2);
        if (r2 == 0) goto L5;
    L10:
        stopTimeAnimation();
        return;
    L5:
        if (((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")).getVisibility() != 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == false) goto L10;
        startTimeAnimation();
        return;
    L7:
        r3 = false;
        goto L8
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r2, int r3) {
        o.e(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        if (r3 == 0) goto L5;
    L7:
        stopTimeAnimation();
        return;
    L5:
        if (isShown() == false) goto L7;
        startTimeAnimation();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopTimeAnimation();
        ValueAnimator r0 = this.colorAnimator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        removeCallbacks(this.dropFpsRunnable);
    }
}
