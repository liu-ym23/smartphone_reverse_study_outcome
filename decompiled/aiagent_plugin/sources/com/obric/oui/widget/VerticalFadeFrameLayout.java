package com.obric.oui.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.obric.aiagent.plugin.R;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class VerticalFadeFrameLayout extends FrameLayout {
    private static final float DEFAULT_FADE_DP = 24.0f;
    private static final long FADE_ANIMATION_DURATION = 120;
    private static final float[] FADE_POSITIONS = null;
    private ValueAnimator animator;
    private float bottomFadeStrength;
    private LinearGradient bottomShader;
    private final Matrix bottomShaderMatrix;
    private final PorterDuffXfermode dstInXfermode;
    private float fadeLength;
    private final Paint fadePaint;
    private float lastTargetBottomStrength;
    private float lastTargetTopStrength;
    private ViewTreeObserver observedViewTreeObserver;
    private float shaderBottomStrength;
    private float shaderFadeLength;
    private int shaderHeight;
    private float shaderTopStrength;
    private int shaderWidth;
    private final ViewTreeObserver.OnScrollChangedListener targetScrollChangedListener;
    private View targetView;
    private float topFadeStrength;
    private LinearGradient topShader;
    private final Matrix topShaderMatrix;

    static /* synthetic */ float access$002(VerticalFadeFrameLayout r0, float r1) {
        r0.topFadeStrength = r1;
        return r1;
    }

    static /* synthetic */ float access$102(VerticalFadeFrameLayout r0, float r1) {
        r0.bottomFadeStrength = r1;
        return r1;
    }

    static /* synthetic */ void access$200(VerticalFadeFrameLayout r0) {
        r0.invalidateFade();
    }

    static {
        FADE_POSITIONS = new float[]{0.0f, 1.0f};
    }

    public VerticalFadeFrameLayout(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null);
    }

    public VerticalFadeFrameLayout(Context r3, AttributeSet r4) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), 0);
    }

    public VerticalFadeFrameLayout(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        super(r6, r7, r5);
        this.fadePaint = new Paint(1);
        this.dstInXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.topShaderMatrix = new Matrix();
        this.bottomShaderMatrix = new Matrix();
        this.targetScrollChangedListener = new AnonymousClass1(this);
        this.shaderWidth = -1;
        this.shaderHeight = -1;
        this.shaderFadeLength = -1.0f;
        this.shaderTopStrength = Float.NaN;
        this.shaderBottomStrength = Float.NaN;
        this.topFadeStrength = 0.0f;
        this.bottomFadeStrength = 0.0f;
        this.lastTargetTopStrength = 0.0f;
        this.lastTargetBottomStrength = 0.0f;
        this.fadeLength = defaultFadeLength();
        parseAttributes(r7, r5);
        setWillNotDraw(false);
    }

    public float getFadeLength() {
        return this.fadeLength;
    }

    public void setFadeLength(float r2) {
        float r3 = Math.max(0.0f, r2);
        if (this.fadeLength != r3) goto L5;
        return;
    L5:
        this.fadeLength = r3;
        invalidateFade();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View r1 = getChildAt(0);
        this.targetView = r1;
        if (r1 == null) goto L5;
        registerScrollObserver(r1);
    L5:
        updateFadeVisibility(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        View r0 = this.targetView;
        if (r0 == null) goto L6;
        registerScrollObserver(r0);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        View r0 = this.targetView;
        if (r0 == null) goto L6;
        unregisterScrollObserver(r0);
        return;
    }

    public void refreshFade() {
        updateFadeVisibility(false);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (r1 == false) goto L6;
        updateFadeVisibility(false);
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r11) {
        if (shouldDrawFade() == true) goto L6;
        super.dispatchDraw(r11);
        return;
    L6:
        View r0 = this.targetView;
        if (r0 != null) goto L10;
        super.dispatchDraw(r11);
        return;
    L10:
        RectF r1 = getFadeBounds(r0);
        if (r1 != null) goto L14;
        super.dispatchDraw(r11);
        return;
    L14:
        float r2 = this.topFadeStrength;
        if (r2 <= 0.0f) goto L17;
    L20:
        ensureFadeShaders(r1, r2, this.bottomFadeStrength);
        int r3 = r11.saveLayer(r1.left, r1.top, r1.right, r1.bottom, null);
        super.dispatchDraw(r11);
        this.fadePaint.setXfermode(this.dstInXfermode);
        if (this.topFadeStrength <= 0.0f) goto L24;
        drawTopFade(r11, r1);
    L24:
        if (this.bottomFadeStrength <= 0.0f) goto L26;
        drawBottomFade(r11, r1);
    L26:
        this.fadePaint.setXfermode(null);
        this.fadePaint.setShader(null);
        r11.restoreToCount(r3);
        return;
    L17:
        if (this.bottomFadeStrength > 0.0f) goto L20;
        super.dispatchDraw(r11);
    }

    private boolean shouldDrawFade() {
        View r0 = this.targetView;
        if (r0 != null) goto L6;
        return false;
    L6:
        if (this.fadeLength > 0.0f) goto L8;
        return false;
    L8:
        if (r0.getWidth() > 0) goto L10;
        return false;
    L10:
        if (r0.getHeight() > 0) goto L13;
        return false;
    L13:
        if (this.topFadeStrength <= 0.0f) goto L15;
    L16:
        return true;
    L15:
        if (this.bottomFadeStrength > 0.0f) goto L16;
        return false;
    }

    private RectF getFadeBounds(View r4) {
        float r3 = r4.getLeft();
        float r0 = r4.getTop();
        float r1 = r4.getRight();
        float r5 = r4.getBottom();
        if (r1 > r3) goto L5;
        return null;
    L5:
        if (r5 > r0) goto L8;
        return null;
    L8:
        return new RectF(r3, r0, r1, r5);
    }

    private void drawTopFade(Canvas r11, RectF r12) {
        float r0 = effectiveFadeLength(r12);
        if (r0 > 0.0f) goto L5;
        return;
    L5:
        LinearGradient r1 = this.topShader;
        if (r1 != null) goto L8;
        return;
    L8:
        this.topShaderMatrix.reset();
        this.topShaderMatrix.setTranslate(r12.left, r12.top);
        r1.setLocalMatrix(this.topShaderMatrix);
        this.fadePaint.setShader(r1);
        View r2 = this.targetView;
        int r3 = 0;
        if (r2 == null) goto L11;
        int r4 = r2.getPaddingLeft();
    L12:
        if (r2 == null) goto L14;
        r3 = r2.getPaddingRight();
    L14:
        r11.drawRect(r12.left + r4, r12.top, r12.right - r3, r12.top + r0, this.fadePaint);
        return;
    L11:
        r4 = 0;
        goto L12
    }

    private void drawBottomFade(Canvas r10, RectF r11) {
        float r0 = effectiveFadeLength(r11);
        if (r0 > 0.0f) goto L5;
        return;
    L5:
        LinearGradient r1 = this.bottomShader;
        if (r1 != null) goto L8;
        return;
    L8:
        float r5 = Math.max(r11.bottom - r0, r11.top);
        this.bottomShaderMatrix.reset();
        this.bottomShaderMatrix.setTranslate(r11.left, r5);
        r1.setLocalMatrix(this.bottomShaderMatrix);
        this.fadePaint.setShader(r1);
        View r2 = this.targetView;
        int r3 = 0;
        if (r2 == null) goto L11;
        int r4 = r2.getPaddingLeft();
    L12:
        if (r2 == null) goto L14;
        r3 = r2.getPaddingRight();
    L14:
        r10.drawRect(r11.left + r4, r5, r11.right - r3, r11.bottom, this.fadePaint);
        return;
    L11:
        r4 = 0;
        goto L12
    }

    private void ensureFadeShaders(RectF r4, float r5, float r6) {
        int r0 = (int) r4.width();
        int r7 = (int) r4.height();
        if (this.shaderWidth == r0) goto L5;
    L9:
        rebuildFadeShaders(r0, r7, r5, r6);
        return;
    L5:
        if (this.shaderHeight != r7) goto L9;
        if (this.shaderFadeLength != this.fadeLength) goto L9;
    }

    private void rebuildFadeShaders(int r20, int r21, float r22, float r23) {
        this.shaderWidth = r20;
        this.shaderHeight = r21;
        this.shaderFadeLength = this.fadeLength;
        this.shaderTopStrength = r22;
        this.shaderBottomStrength = r23;
        float r5 = effectiveFadeLength(new RectF(0.0f, 0.0f, r20, r21));
        if (r20 <= 0) goto L17;
        if (r21 <= 0) goto L17;
        if (r5 <= 0.0f) goto L17;
        int r1 = Math.max(0, Math.min(255, (int) ((1.0f - clamp01(r22)) * 255.0f)));
        int r2 = Math.max(0, Math.min(255, (int) ((1.0f - clamp01(r23)) * 255.0f)));
        if (r22 <= 0.0f) goto L11;
        this.topShader = new LinearGradient(0.0f, 0.0f, 0.0f, r5, new int[]{Color.argb(r1, 0, 0, 0), -16777216}, FADE_POSITIONS, Shader.TileMode.CLAMP);
    L13:
        if (r23 <= 0.0f) goto L15;
        this.bottomShader = new LinearGradient(0.0f, r5, 0.0f, 0.0f, new int[]{Color.argb(r2, 0, 0, 0), -16777216}, FADE_POSITIONS, Shader.TileMode.CLAMP);
        return;
    L15:
        this.bottomShader = null;
        return;
    L11:
        this.topShader = null;
    L17:
        this.topShader = null;
        this.bottomShader = null;
    }

    private float effectiveFadeLength(RectF r1) {
        return Math.min(this.fadeLength, r1.height());
    }

    public void updateFadeVisibility() {
        updateFadeVisibility(true);
    }

    public void updateFadeVisibility(boolean r6) {
        View r0 = this.targetView;
        float r1 = 1.0f;
        if (r0 != null) goto L5;
    L7:
        float r3 = 0.0f;
    L8:
        if (r0 != null) goto L10;
    L12:
        r1 = 0.0f;
    L13:
        if (r6 == true) goto L15;
        ValueAnimator r7 = this.animator;
        if (r7 == null) goto L24;
        r7.cancel();
    L24:
        this.lastTargetTopStrength = r3;
        this.lastTargetBottomStrength = r1;
        this.topFadeStrength = r3;
        this.bottomFadeStrength = r1;
        invalidateFade();
        return;
    L15:
        if (this.lastTargetTopStrength == r3) goto L17;
    L19:
        this.lastTargetTopStrength = r3;
        this.lastTargetBottomStrength = r1;
        animateFadeStrength(r3, r1);
        return;
    L17:
        if (this.lastTargetBottomStrength != r1) goto L19;
        return;
    L10:
        if (r0.canScrollVertically(1) == false) goto L12;
    L5:
        if (r0.canScrollVertically(-1) == false) goto L7;
        r3 = 1.0f;
        goto L8
    }

    private void animateFadeStrength(final float r9, final float r10) {
        final float r2 = this.topFadeStrength;
        final float r4 = this.bottomFadeStrength;
        if (r2 == r9) goto L5;
    L7:
        ValueAnimator r0 = this.animator;
        if (r0 == null) goto L10;
        r0.cancel();
    L10:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.animator = r1;
        r1.setDuration(120);
        this.animator.addUpdateListener(new AnonymousClass2(this, r2, r9, r4, r10));
        this.animator.start();
        return;
    L5:
        if (r4 != r10) goto L7;
    }

    private void invalidateFade() {
        this.topShader = null;
        this.bottomShader = null;
        this.shaderWidth = -1;
        this.shaderHeight = -1;
        this.shaderFadeLength = -1.0f;
        this.shaderTopStrength = Float.NaN;
        this.shaderBottomStrength = Float.NaN;
        invalidate();
    }

    private void registerScrollObserver(View r3) {
        ViewTreeObserver r4 = r3.getViewTreeObserver();
        ViewTreeObserver r0 = this.observedViewTreeObserver;
        if (r0 != r4) goto L5;
        return;
    L5:
        if (r0 != null) goto L7;
    L9:
        r4.addOnScrollChangedListener(this.targetScrollChangedListener);
        this.observedViewTreeObserver = r4;
        return;
    L7:
        if (r0.isAlive() == false) goto L9;
        this.observedViewTreeObserver.removeOnScrollChangedListener(this.targetScrollChangedListener);
        goto L9
    }

    private void unregisterScrollObserver(View r2) {
        ViewTreeObserver r0 = this.observedViewTreeObserver;
        if (r0 != null) goto L6;
        r0 = r2.getViewTreeObserver();
    L6:
        if (r0 == null) goto L11;
        if (r0.isAlive() == false) goto L11;
        r0.removeOnScrollChangedListener(this.targetScrollChangedListener);
    L11:
        if (this.observedViewTreeObserver != r0) goto L14;
        this.observedViewTreeObserver = null;
        return;
    }

    private void parseAttributes(AttributeSet r4, int r5) {
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        if (r6 != null) goto L5;
        return;
    L5:
        TypedArray r7 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getTheme().obtainStyledAttributes(r6, R.styleable.VerticalFadeFrameLayout, r5, 0);
        setFadeLength(r7.getDimension(ZeusTransformUtils.mapRes(R.styleable.VerticalFadeFrameLayout_fadeLength, "styleable", "VerticalFadeFrameLayout_fadeLength"), this.fadeLength));     // Catch: Throwable -> L9
        r7.recycle();
        return;
    L9:
        th = move-exception;
        r7.recycle();
        throw th;
    }

    private float defaultFadeLength() {
        return TypedValue.applyDimension(1, 24.0f, ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics());
    }

    private static float clamp01(float r1) {
        return Math.max(0.0f, Math.min(1.0f, r1));
    }
}
