package com.obric.autoaction.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.bdturing.BdTuringConfig;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aiagent.plugin.R;
import com.obric.common.oea.foundation.animation.d.b;
import com.obric.common.oea.foundation.animation.h.e;
import com.obric.common.oea.foundation.animation.manager.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import d.x;

/* JADX INFO: compiled from: AiStrokeView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AiStrokeView extends View {
    private final long AUTO_FREEZE_DELAY_MS;
    private boolean autoFreeze;
    private boolean autoReverseColors;
    private final int[] baseGradientColors;
    private final Path cachedPath;
    private int colorRepeatCount;
    private int cornerRadius;
    private int cornerRadiusBottomLeft;
    private int cornerRadiusBottomRight;
    private int cornerRadiusTopLeft;
    private int cornerRadiusTopRight;
    private float cornerSmoothness;
    private final float density;
    private final Runnable freezeRunnable;
    private SweepGradient gradient;
    private final Matrix gradientMatrix;
    private boolean isPlaying;
    private d rotationAnimator;
    private float rotationDegrees;
    private float speedMultiplier;
    private long startTime;
    private float strokeAlpha;
    private final Paint strokePaint;
    private final RectF strokeRect;
    private int strokeWidthPx;

    public AiStrokeView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public AiStrokeView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ x lambda$OugoNNpf_3qOgwOCjBLyl1XGxjM(AiStrokeView r0, String r1, Object r2, Object r3) {
        return initAnimator$lambda$3(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$XxvubvL4j-LxLvDxWWvsIcFOyDM, reason: not valid java name */
    public static /* synthetic */ void m707lambda$XxvubvL4jLxLvDxWWvsIcFOyDM(AiStrokeView r0) {
        freezeRunnable$lambda$1(r0);
    }

    private final void updateAnimatorSpeed() {
    }

    public /* synthetic */ AiStrokeView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public AiStrokeView(Context r6, AttributeSet r7, int r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r9, "context");
        super(r9, r10, r8);
        this.cachedPath = new Path();
        Paint r0 = new Paint(1);
        r0.setStyle(Paint.Style.STROKE);
        r0.setStrokeCap(Paint.Cap.ROUND);
        r0.setStrokeJoin(Paint.Join.ROUND);
        this.strokePaint = r0;
        this.strokeRect = new RectF();
        this.gradientMatrix = new Matrix();
        float r1 = ZeusTransformUtils.getResources(r9, "com.obric.aiagent.plugin").getDisplayMetrics().density;
        this.density = r1;
        this.startTime = System.currentTimeMillis();
        this.AUTO_FREEZE_DELAY_MS = OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS;
        this.freezeRunnable = new $$Lambda$AiStrokeView$XxvubvL4jLxLvDxWWvsIcFOyDM(this);
        this.baseGradientColors = new int[]{-13402625, -11699713, -10390273, -9211649, -8229889, -7313665, -5152013, -2333999, -431447, -33920, -27554, -20401};
        this.strokeWidthPx = d.i.a.a(r1 * 2.0f);
        this.strokeAlpha = 1.0f;
        this.speedMultiplier = 1.0f;
        this.colorRepeatCount = 1;
        this.autoReverseColors = true;
        this.cornerSmoothness = 0.6f;
        TypedArray r11 = r9.getTheme().obtainStyledAttributes(r10, R.styleable.AiStrokeView, r8, 0);
        o.c(r11, "obtainStyledAttributes(...)");
        setStrokeWidthPx(d.i.a.a(r11.getDimension(ZeusTransformUtils.mapRes(R.styleable.AiStrokeView_strokeWidth, "styleable", "AiStrokeView_strokeWidth"), this.strokeWidthPx)));
        setStrokeAlpha(n.a(r11.getFloat(ZeusTransformUtils.mapRes(R.styleable.AiStrokeView_strokeAlpha, "styleable", "AiStrokeView_strokeAlpha"), this.strokeAlpha), 0.0f, 1.0f));
        setCornerRadius(d.i.a.a(r11.getDimension(ZeusTransformUtils.mapRes(R.styleable.AiStrokeView_strokeCornerRadius, "styleable", "AiStrokeView_strokeCornerRadius"), this.cornerRadius)));
        setSpeedMultiplier(r11.getFloat(ZeusTransformUtils.mapRes(R.styleable.AiStrokeView_strokeSpeed, "styleable", "AiStrokeView_strokeSpeed"), this.speedMultiplier));
        setColorRepeatCount(n.c(r11.getInt(ZeusTransformUtils.mapRes(R.styleable.AiStrokeView_strokeColorRepeatCount, "styleable", "AiStrokeView_strokeColorRepeatCount"), this.colorRepeatCount), 1));
        setAutoReverseColors(r11.getBoolean(ZeusTransformUtils.mapRes(R.styleable.AiStrokeView_strokeColorAutoReverse, "styleable", "AiStrokeView_strokeColorAutoReverse"), this.autoReverseColors));
        x r12 = x.f38692a;
        r11.recycle();
        r0.setStrokeWidth(this.strokeWidthPx);
        r0.setAlpha((int) (this.strokeAlpha * 255));
        initAnimator();
    }

    public final boolean getAutoFreeze() {
        return this.autoFreeze;
    }

    public final void setAutoFreeze(boolean r1) {
        this.autoFreeze = r1;
        resetAutoFreezeTimer();
    }

    private static final void freezeRunnable$lambda$1(AiStrokeView r1) {
        if (r1.autoFreeze == true) goto L5;
        return;
    L5:
        if (r1.isPlaying == false) goto L9;
        r1.stop();
        return;
    }

    public final int getStrokeWidthPx() {
        return this.strokeWidthPx;
    }

    public final void setStrokeWidthPx(int r2) {
        int r3 = n.c(r2, 0);
        if (this.strokeWidthPx == r3) goto L6;
        this.strokeWidthPx = r3;
        this.strokePaint.setStrokeWidth(r3);
        updatePath();
        invalidate();
        return;
    }

    public final float getStrokeAlpha() {
        return this.strokeAlpha;
    }

    public final void setStrokeAlpha(float r3) {
        float r4 = n.a(r3, 0.0f, 1.0f);
        if (this.strokeAlpha != r4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.strokeAlpha = r4;
        this.strokePaint.setAlpha((int) (r4 * 255));
        invalidate();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final int getCornerRadius() {
        return this.cornerRadius;
    }

    public final void setCornerRadius(int r2) {
        int r3 = n.c(r2, 0);
        this.cornerRadius = r3;
        setAllCornerRadii(r3);
        updatePath();
        invalidate();
    }

    public final int getCornerRadiusTopLeft() {
        return this.cornerRadiusTopLeft;
    }

    public final void setCornerRadiusTopLeft(int r1) {
        this.cornerRadiusTopLeft = r1;
        updatePath();
        invalidate();
    }

    public final int getCornerRadiusTopRight() {
        return this.cornerRadiusTopRight;
    }

    public final void setCornerRadiusTopRight(int r1) {
        this.cornerRadiusTopRight = r1;
        updatePath();
        invalidate();
    }

    public final int getCornerRadiusBottomRight() {
        return this.cornerRadiusBottomRight;
    }

    public final void setCornerRadiusBottomRight(int r1) {
        this.cornerRadiusBottomRight = r1;
        updatePath();
        invalidate();
    }

    public final int getCornerRadiusBottomLeft() {
        return this.cornerRadiusBottomLeft;
    }

    public final void setCornerRadiusBottomLeft(int r1) {
        this.cornerRadiusBottomLeft = r1;
        updatePath();
        invalidate();
    }

    public final float getSpeedMultiplier() {
        return this.speedMultiplier;
    }

    public final void setSpeedMultiplier(float r2) {
        if (this.speedMultiplier != r2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.speedMultiplier = r2;
        updateAnimatorSpeed();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final int getColorRepeatCount() {
        return this.colorRepeatCount;
    }

    public final void setColorRepeatCount(int r2) {
        if (this.colorRepeatCount == r2) goto L6;
        this.colorRepeatCount = n.c(r2, 1);
        updateGradient();
        invalidate();
        return;
    }

    public final boolean getAutoReverseColors() {
        return this.autoReverseColors;
    }

    public final void setAutoReverseColors(boolean r2) {
        if (this.autoReverseColors == r2) goto L6;
        this.autoReverseColors = r2;
        updateGradient();
        invalidate();
        return;
    }

    public final float getCornerSmoothness() {
        return this.cornerSmoothness;
    }

    public final void setCornerSmoothness(float r3) {
        float r4 = n.a(r3, 0.0f, 1.0f);
        if (this.cornerSmoothness != r4) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L9;
        this.cornerSmoothness = r4;
        updatePath();
        invalidate();
        return;
    L9:
        return;
    L5:
        r0 = false;
        goto L6
    }

    private final void initAnimator() {
        if (this.rotationAnimator == null) goto L6;
        return;
    L6:
        if (this.isPlaying == true) goto L8;
        return;
    L8:
        this.rotationAnimator = com.obric.common.oea.foundation.animation.a.d.a.a(new com.obric.common.oea.foundation.animation.a.d.a().b(30.0f), 0.0f, 360.0f, (com.obric.common.oea.foundation.animation.g.a) ZeusTransformUtils.preCheckCast(new com.obric.common.oea.foundation.animation.g.b.a(BdTuringConfig.DEFAULT_EVENT_COUNT, 0, e.d.f32443a, 2, null), com.obric.common.oea.foundation.animation.g.a.class, "com.obric.aiagent.plugin"), null, 8, null).a(new $$Lambda$AiStrokeView$OugoNNpf_3qOgwOCjBLyl1XGxjM(this)).a().a(b.f32345b, com.obric.common.oea.foundation.animation.d.a.f32341b, true);
        updateAnimatorSpeed();
    }

    private static final x initAnimator$lambda$3(AiStrokeView r2, String r3, Object r4, Object r5) {
        o.e(r3, "spec");
        o.e(r4, "value");
        o.e(r5, "<unused var>");
        float r6 = r2.rotationDegrees + ((System.currentTimeMillis() - r2.startTime) * 0.06f);
        r2.rotationDegrees = r6;
        r2.rotationDegrees = r6 % 360;
        r2.invalidate();
        r2.startTime = System.currentTimeMillis();
        return x.f38692a;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        checkAnimationState();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d r0 = this.rotationAnimator;
        if (r0 == null) goto L5;
        r0.a();
    L5:
        d r1 = this.rotationAnimator;
        if (r1 == null) goto L8;
        d.a(r1, false, 1, null);
    L8:
        this.rotationAnimator = null;
        removeCallbacks(this.freezeRunnable);
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r2, int r3) {
        o.e(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        checkAnimationState();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        checkAnimationState();
    }

    public final void checkAnimationState() {
        if (isAttachedToWindow() == true) goto L5;
    L11:
        boolean r0 = false;
    L12:
        if (r0 == false) goto L14;
        initAnimator();
        resetAutoFreezeTimer();
        return;
    L14:
        d r1 = this.rotationAnimator;
        if (r1 == null) goto L17;
        r1.a();
    L17:
        d r2 = this.rotationAnimator;
        if (r2 == null) goto L20;
        d.a(r2, false, 1, null);
    L20:
        this.rotationAnimator = null;
        removeCallbacks(this.freezeRunnable);
        return;
    L5:
        if (getVisibility() != 0) goto L11;
        if (getWindowVisibility() != 0) goto L11;
        if (this.isPlaying == false) goto L11;
        r0 = true;
        goto L12
    }

    public final void syncAnimation() {
        if (this.isPlaying == true) goto L5;
        return;
    L5:
        d r0 = this.rotationAnimator;
        if (r0 == null) goto L8;
        r0.a();
    L8:
        d r1 = this.rotationAnimator;
        if (r1 == null) goto L12;
        r1.b();
        return;
    }

    public final void play() {
        if (this.isPlaying == false) goto L5;
        return;
    L5:
        this.isPlaying = true;
        checkAnimationState();
    }

    public final void stop() {
        if (this.isPlaying == true) goto L5;
        return;
    L5:
        this.isPlaying = false;
        checkAnimationState();
    }

    private final void resetAutoFreezeTimer() {
        removeCallbacks(this.freezeRunnable);
        if (this.autoFreeze == true) goto L5;
        return;
    L5:
        if (this.isPlaying == false) goto L9;
        postDelayed(this.freezeRunnable, this.AUTO_FREEZE_DELAY_MS);
        return;
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        updatePath();
        updateGradient();
    }

    private final void updatePath() {
        int r0 = getWidth();
        int r1 = getHeight();
        if (r0 == 0) goto L8;
        if (r1 == 0) goto L9;
        float r2 = this.strokePaint.getStrokeWidth() / 2.0f;
        this.strokeRect.set(getPaddingLeft() + r2, getPaddingTop() + r2, (r0 - getPaddingRight()) - r2, (r1 - getPaddingBottom()) - r2);
        float r3 = maxOuterRadius();
        float r4 = this.strokePaint.getStrokeWidth() / 2.0f;
        com.obric.design.a.a.a(this.cachedPath, this.strokeRect, calculateInnerRadius(this.cornerRadiusTopLeft, r3, r4), calculateInnerRadius(this.cornerRadiusTopRight, r3, r4), calculateInnerRadius(this.cornerRadiusBottomRight, r3, r4), calculateInnerRadius(this.cornerRadiusBottomLeft, r3, r4), this.cornerSmoothness);
        return;
    L9:
        return;
    }

    @Override // android.view.View
    public void onDraw(Canvas r7) {
        o.e(r7, "canvas");
        if (this.strokeWidthPx > 0.0f) goto L5;
        return;
    L5:
        SweepGradient r0 = this.gradient;
        if (r0 == null) goto L9;
        this.gradientMatrix.setRotate(this.rotationDegrees, getWidth() / 2.0f, getHeight() / 2.0f);
        r0.setLocalMatrix(this.gradientMatrix);
        this.strokePaint.setShader((Shader) ZeusTransformUtils.preCheckCast(r0, Shader.class, "com.obric.aiagent.plugin"));
        r7.drawPath(this.cachedPath, this.strokePaint);
        return;
    }

    private final float maxOuterRadius() {
        return n.a(Math.min(this.strokeRect.width(), this.strokeRect.height()) / 2.0f, 0.0f);
    }

    private final float calculateInnerRadius(float r1, float r2, float r3) {
        return n.a(n.b(r1, r2) - r3, 0.0f);
    }

    private final void setAllCornerRadii(int r1) {
        setCornerRadiusTopLeft(r1);
        setCornerRadiusTopRight(r1);
        setCornerRadiusBottomRight(r1);
        setCornerRadiusBottomLeft(r1);
    }

    private final void updateGradient() {
        if (getWidth() != 0) goto L5;
        return;
    L5:
        if (getHeight() == 0) goto L45;
        int r0 = this.baseGradientColors.length;
        if (r0 != 0) goto L11;
        this.gradient = null;
        return;
    L11:
        int r2 = 0;
        if (this.autoReverseColors == true) goto L14;
    L16:
        int r1 = 0;
    L17:
        int r4 = this.colorRepeatCount;
        int r3 = (r0 + r1) * r4;
        if (r3 != 0) goto L20;
        return;
    L20:
        int[] r5 = new int[r3];
        float[] r6 = new float[r3];
        int r7 = 0;
        int r8 = 0;
    L21:
        if (r7 >= r4) goto L31;
        int r9 = 0;
    L23:
        if (r9 >= r0) goto L25;
        r5[r8] = this.baseGradientColors[r9];
        r9 = r9 + 1;
        r8 = r8 + 1;
        goto L23
    L25:
        if (r1 <= 0) goto L29;
        int r10 = r0 - 2;
    L27:
        if (r10 <= 0) goto L29;
        r5[r8] = this.baseGradientColors[r10];
        r10 = r10 - 1;
        r8 = r8 + 1;
    L29:
        r7 = r7 + 1;
        goto L21
    L31:
        if (r3 <= 1) goto L36;
        int r11 = r3 - 1;
        float r12 = 1.0f / r11;
    L33:
        if (r2 >= r3) goto L35;
        r6[r2] = r2 * r12;
        r2 = r2 + 1;
        goto L33
    L35:
        r6[r11] = 1.0f;
    L37:
        this.gradient = new SweepGradient(getWidth() / 2.0f, getHeight() / 2.0f, r5, r6);
        return;
    L36:
        r6[0] = 0.0f;
        goto L37
    L14:
        if (r0 <= 2) goto L16;
        r1 = r0 - 2;
        goto L17
    }
}
