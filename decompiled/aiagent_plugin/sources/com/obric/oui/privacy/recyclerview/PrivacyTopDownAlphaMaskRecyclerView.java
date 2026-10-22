package com.obric.oui.privacy.recyclerview;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.obric.oui.orecyclerview.widget.LinearLayoutManager;
import com.obric.oui.orecyclerview.widget.RecyclerView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.l.n;
import java.util.Objects;

/* JADX INFO: compiled from: PrivacyTopDownAlphaMaskRecyclerView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class PrivacyTopDownAlphaMaskRecyclerView extends RecyclerView {
    public static final a Companion = null;
    private static final int DEFAULT_FADE_EDGE_DP = 75;
    private static final long FADE_ANIMATION_DURATION = 100;
    private static final float[] FADE_POSITIONS = null;
    private boolean allowFadeUpdates;
    private ValueAnimator animator;
    private float bottomFadeStrength;
    private LinearGradient bottomShader;
    private final Matrix bottomShaderMatrix;
    private boolean detectStackTypeChanged;
    private final PorterDuffXfermode dstInXfermode;
    private boolean dynamicFade;
    private boolean fadeBottom;
    private float fadeEdgeLength;
    private final Paint fadePaint;
    private boolean fadeTop;
    private float lastTargetBottomStrength;
    private float lastTargetTopStrength;
    private float shaderBottomStrength;
    private float shaderFadeEdgeLength;
    private int shaderHeight;
    private float shaderTopStrength;
    private int shaderWidth;
    private float topFadeStrength;
    private LinearGradient topShader;
    private final Matrix topShaderMatrix;

    /* JADX INFO: compiled from: PrivacyTopDownAlphaMaskRecyclerView.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    public PrivacyTopDownAlphaMaskRecyclerView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public PrivacyTopDownAlphaMaskRecyclerView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static /* synthetic */ void lambda$597EiQ9LW45s6htDZiN4ifMgXDU(PrivacyTopDownAlphaMaskRecyclerView r0, float r1, float r2, float r3, float r4, ValueAnimator r5) {
        m1146animateFadeStrength$lambda2$lambda1(r0, r1, r2, r3, r4, r5);
    }

    public static /* synthetic */ void lambda$TLlQ6YUx1d0nGDY1kTW4R4joph8(PrivacyTopDownAlphaMaskRecyclerView r0) {
        m1147onSizeChanged$lambda0(r0);
    }

    public /* synthetic */ PrivacyTopDownAlphaMaskRecyclerView(Context r2, AttributeSet r3, int r4, int r5, h r6) {
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

    public static final /* synthetic */ boolean access$getAllowFadeUpdates$p(PrivacyTopDownAlphaMaskRecyclerView r0) {
        return r0.allowFadeUpdates;
    }

    public static final /* synthetic */ void access$setAllowFadeUpdates$p(PrivacyTopDownAlphaMaskRecyclerView r0, boolean r1) {
        r0.allowFadeUpdates = r1;
    }

    public PrivacyTopDownAlphaMaskRecyclerView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r6, "context");
        super(r6, r7, r5);
        this.fadeEdgeLength = defaultFadeEdgeLength();
        this.dynamicFade = true;
        this.fadeTop = true;
        this.fadeBottom = true;
        this.fadePaint = new Paint(1);
        this.dstInXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        this.topShaderMatrix = new Matrix();
        this.bottomShaderMatrix = new Matrix();
        this.shaderWidth = -1;
        this.shaderHeight = -1;
        this.shaderFadeEdgeLength = -1.0f;
        this.shaderTopStrength = Float.NaN;
        this.shaderBottomStrength = Float.NaN;
        this.detectStackTypeChanged = true;
        if (this.dynamicFade == false) goto L6;
        addOnScrollListener((RecyclerView.m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(this), RecyclerView.m.class, "com.obric.aiagent.plugin"));
        return;
    }

    static {
        Companion = new a(null);
        FADE_POSITIONS = new float[]{0.0f, 1.0f};
    }

    public final float getFadeEdgeLength() {
        return this.fadeEdgeLength;
    }

    public final void setFadeEdgeLength(float r2) {
        float r3 = n.a(r2, 0.0f);
        if (this.fadeEdgeLength != r3) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        this.fadeEdgeLength = r3;
        invalidateFadeShaders();
        invalidate();
        return;
    L5:
        r0 = false;
        goto L6
    }

    public final boolean getDynamicFade() {
        return this.dynamicFade;
    }

    public final void setDynamicFade(boolean r1) {
        this.dynamicFade = r1;
    }

    public final boolean getFadeTop() {
        return this.fadeTop;
    }

    public final void setFadeTop(boolean r2) {
        if (this.fadeTop != r2) goto L5;
        return;
    L5:
        this.fadeTop = r2;
        invalidate();
    }

    public final boolean getFadeBottom() {
        return this.fadeBottom;
    }

    public final void setFadeBottom(boolean r2) {
        if (this.fadeBottom != r2) goto L5;
        return;
    L5:
        this.fadeBottom = r2;
        invalidate();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int r5, int r6) {
        super.onMeasure(r5, r6);
        if (ZeusTransformUtils.instanceOf(getLayoutManager(), LinearLayoutManager.class) == true) goto L5;
        return;
    L5:
        if (this.detectStackTypeChanged == false) goto L20;
        int r7 = computeVerticalScrollRange();
        if (r7 <= 0) goto L21;
        int r8 = 0;
        this.detectStackTypeChanged = false;
        if (r7 > ((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom())) goto L11;
        boolean r9 = true;
    L12:
        RecyclerView.h r0 = getLayoutManager();
        Objects.requireNonNull(r0, "null cannot be cast to non-null type com.obric.oui.orecyclerview.widget.LinearLayoutManager");
        if (((LinearLayoutManager) ZeusTransformUtils.preCheckCast(r0, LinearLayoutManager.class, "com.obric.aiagent.plugin")).h() == r9) goto L15;
        RecyclerView.h r1 = getLayoutManager();
        Objects.requireNonNull(r1, "null cannot be cast to non-null type com.obric.oui.orecyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) ZeusTransformUtils.preCheckCast(r1, LinearLayoutManager.class, "com.obric.aiagent.plugin")).a(r9);
    L15:
        if (r9 == false) goto L17;
        r8 = 2;
    L17:
        setOverScrollMode(r8);
        return;
    L11:
        r9 = false;
        goto L12
    L21:
        return;
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        invalidateFadeShaders();
        post(new $$Lambda$PrivacyTopDownAlphaMaskRecyclerView$TLlQ6YUx1d0nGDY1kTW4R4joph8(this));
    }

    /* JADX INFO: renamed from: onSizeChanged$lambda-0, reason: not valid java name */
    private static final void m1147onSizeChanged$lambda0(PrivacyTopDownAlphaMaskRecyclerView r1) {
        o.e(r1, "this$0");
        if (r1.dynamicFade == false) goto L5;
        r1.allowFadeUpdates = false;
        r1.updateFadeVisibility(false);
        return;
    L5:
        r1.topFadeStrength = 1.0f;
        r1.bottomFadeStrength = 1.0f;
        r1.invalidateFadeShaders();
        r1.invalidate();
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.View
    public void draw(Canvas r9) {
        o.e(r9, "canvas");
        if (getWidth() > 0) goto L5;
    L31:
        super.draw(r9);
        return;
    L5:
        if (getHeight() <= 0) goto L31;
        if (this.fadeEdgeLength <= 0.0f) goto L31;
        if (this.fadeTop == true) goto L14;
        if (this.fadeBottom == true) goto L14;
    L17:
        super.draw(r9);
        return;
    L14:
        if (this.topFadeStrength <= 0.0f) goto L16;
    L19:
        ensureFadeShaders();
        int r0 = r9.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null);
        super.draw(r9);
        this.fadePaint.setXfermode((Xfermode) ZeusTransformUtils.preCheckCast(this.dstInXfermode, Xfermode.class, "com.obric.aiagent.plugin"));
        if (this.fadeTop == false) goto L25;
        if (this.topFadeStrength <= 0.0f) goto L25;
        drawTopFade(r9);
    L25:
        if (this.fadeBottom == true) goto L27;
    L29:
        this.fadePaint.setXfermode(null);
        this.fadePaint.setShader(null);
        r9.restoreToCount(r0);
        return;
    L27:
        if (this.bottomFadeStrength <= 0.0f) goto L29;
        drawBottomFade(r9);
        goto L29
    L16:
        if (this.bottomFadeStrength > 0.0f) goto L19;
        goto L17
    }

    public static /* synthetic */ void updateFadeVisibility$default(PrivacyTopDownAlphaMaskRecyclerView r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.updateFadeVisibility(r1);
    }

    public final void updateFadeVisibility(boolean r7) {
        boolean r0 = canScrollVertically(-1);
        boolean r1 = true;
        boolean r2 = canScrollVertically(1);
        float r4 = 1.0f;
        if (this.fadeTop == false) goto L6;
        if (r0 == false) goto L6;
        float r3 = 1.0f;
    L8:
        if (this.fadeBottom == false) goto L11;
        if (r2 == false) goto L11;
    L12:
        if (r7 == true) goto L14;
        this.lastTargetTopStrength = r3;
        this.lastTargetBottomStrength = r4;
        this.topFadeStrength = r3;
        this.bottomFadeStrength = r4;
        invalidateFadeShaders();
        invalidate();
        return;
    L14:
        if (this.lastTargetTopStrength != r3) goto L16;
        boolean r8 = true;
    L17:
        if (r8 == true) goto L19;
    L24:
        this.lastTargetTopStrength = r3;
        this.lastTargetBottomStrength = r4;
        animateFadeStrength(r3, r4);
        return;
    L19:
        if (this.lastTargetBottomStrength == r4) goto L22;
        r1 = false;
    L22:
        if (r1 == false) goto L24;
        return;
    L16:
        r8 = false;
    L11:
        r4 = 0.0f;
    L6:
        r3 = 0.0f;
        goto L8
    }

    private final void animateFadeStrength(final float r9, final float r10) {
        final float r2 = this.topFadeStrength;
        final float r4 = this.bottomFadeStrength;
        boolean r1 = true;
        if (r2 != r9) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L13:
        ValueAnimator r3 = this.animator;
        if (r3 == null) goto L17;
        r3.cancel();
    L17:
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r6.setDuration(100);
        r6.addUpdateListener(new $$Lambda$PrivacyTopDownAlphaMaskRecyclerView$597EiQ9LW45s6htDZiN4ifMgXDU(this, r2, r9, r4, r10));
        this.animator = r6;
        if (r6 == null) goto L22;
        r6.start();
        return;
    L22:
        return;
    L8:
        if (r4 == r10) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        return;
    L5:
        r0 = false;
        goto L6
    }

    /* JADX INFO: renamed from: animateFadeStrength$lambda-2$lambda-1, reason: not valid java name */
    private static final void m1146animateFadeStrength$lambda2$lambda1(PrivacyTopDownAlphaMaskRecyclerView r2, float r3, float r4, float r5, float r6, ValueAnimator r7) {
        o.e(r2, "this$0");
        o.e(r7, "anim");
        Object r8 = r7.getAnimatedValue();
        Objects.requireNonNull(r8, "null cannot be cast to non-null type kotlin.Float");
        float r9 = ((Float) ZeusTransformUtils.preCheckCast(r8, Float.class, "com.obric.aiagent.plugin")).floatValue();
        r2.topFadeStrength = r3 + ((r4 - r3) * r9);
        r2.bottomFadeStrength = r5 + ((r6 - r5) * r9);
        r2.invalidateFadeShaders();
        r2.invalidate();
    }

    private final void drawTopFade(Canvas r7) {
        float r4 = effectiveFadeEdgeLength();
        if (r4 > 0.0f) goto L5;
        return;
    L5:
        LinearGradient r0 = this.topShader;
        if (r0 != null) goto L8;
        return;
    L8:
        this.topShaderMatrix.reset();
        r0.setLocalMatrix(this.topShaderMatrix);
        this.fadePaint.setShader((Shader) ZeusTransformUtils.preCheckCast(r0, Shader.class, "com.obric.aiagent.plugin"));
        r7.drawRect(0.0f, 0.0f, getWidth(), r4, this.fadePaint);
    }

    private final void drawBottomFade(Canvas r10) {
        float r0 = effectiveFadeEdgeLength();
        if (r0 > 0.0f) goto L5;
        return;
    L5:
        float r7 = getHeight();
        float r5 = n.a(r7 - r0, 0.0f);
        LinearGradient r1 = this.bottomShader;
        if (r1 != null) goto L8;
        return;
    L8:
        this.bottomShaderMatrix.reset();
        this.bottomShaderMatrix.setTranslate(0.0f, r5);
        r1.setLocalMatrix(this.bottomShaderMatrix);
        this.fadePaint.setShader((Shader) ZeusTransformUtils.preCheckCast(r1, Shader.class, "com.obric.aiagent.plugin"));
        r10.drawRect(0.0f, r5, getWidth(), r7, this.fadePaint);
    }

    private final void ensureFadeShaders() {
        if (this.shaderWidth == getWidth()) goto L5;
    L22:
        rebuildFadeShaders();
        return;
    L5:
        if (this.shaderHeight != getHeight()) goto L22;
        boolean r1 = true;
        if (this.shaderFadeEdgeLength != this.fadeEdgeLength) goto L9;
        boolean r0 = true;
    L10:
        if (r0 == false) goto L22;
        if (this.shaderTopStrength != this.topFadeStrength) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == false) goto L22;
        if (this.shaderBottomStrength == this.bottomFadeStrength) goto L20;
        r1 = false;
    L20:
        if (r1 == false) goto L22;
        return;
    L14:
        r2 = false;
        goto L15
    L9:
        r0 = false;
        goto L10
    }

    private final void rebuildFadeShaders() {
        this.shaderWidth = getWidth();
        this.shaderHeight = getHeight();
        this.shaderFadeEdgeLength = this.fadeEdgeLength;
        this.shaderTopStrength = this.topFadeStrength;
        this.shaderBottomStrength = this.bottomFadeStrength;
        float r1 = effectiveFadeEdgeLength();
        if (getWidth() > 0) goto L5;
    L23:
        this.topShader = null;
        this.bottomShader = null;
        return;
    L5:
        if (getHeight() <= 0) goto L23;
        if (r1 <= 0.0f) goto L23;
        float r2 = n.a(this.topFadeStrength, 0.0f, 1.0f);
        float r12 = n.a(this.bottomFadeStrength, 0.0f, 1.0f);
        int r4 = n.a((int) ((1.0f - r2) * 255.0f), 0, 255);
        int r15 = n.a((int) ((1.0f - r12) * 255.0f), 0, 255);
        if (r2 > 0.0f) goto L12;
    L14:
        String r14 = "com.obric.aiagent.plugin";
        LinearGradient r3 = (LinearGradient) ZeusTransformUtils.preCheckCast(null, LinearGradient.class, r14);
    L15:
        this.topShader = r3;
        if (r12 > 0.0f) goto L18;
    L20:
        LinearGradient r10 = (LinearGradient) ZeusTransformUtils.preCheckCast(null, LinearGradient.class, r14);
    L21:
        this.bottomShader = r10;
        return;
    L18:
        if (this.bottomShader != null) goto L20;
        r10 = new LinearGradient(0.0f, r1, 0.0f, 0.0f, new int[]{Color.argb(r15, 0, 0, 0), Color.argb(255, 0, 0, 0)}, FADE_POSITIONS, Shader.TileMode.CLAMP);
        goto L21
    L12:
        if (this.topShader != null) goto L14;
        r14 = "com.obric.aiagent.plugin";
        r3 = new LinearGradient(0.0f, 0.0f, 0.0f, r1, new int[]{Color.argb(r4, 0, 0, 0), Color.argb(255, 0, 0, 0)}, FADE_POSITIONS, Shader.TileMode.CLAMP);
        goto L15
    }

    private final void invalidateFadeShaders() {
        this.shaderWidth = -1;
        this.shaderHeight = -1;
        this.shaderFadeEdgeLength = -1.0f;
        this.shaderTopStrength = Float.NaN;
        this.shaderBottomStrength = Float.NaN;
        this.topShader = null;
        this.bottomShader = null;
    }

    private final float effectiveFadeEdgeLength() {
        return n.b(this.fadeEdgeLength, getHeight());
    }

    private final float defaultFadeEdgeLength() {
        return TypedValue.applyDimension(1, 75.0f, ZeusTransformUtils.getResources(this, "com.obric.aiagent.plugin").getDisplayMetrics());
    }

    @Override // com.obric.oui.orecyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator r0 = this.animator;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        removeCallbacks(null);
    }
}
