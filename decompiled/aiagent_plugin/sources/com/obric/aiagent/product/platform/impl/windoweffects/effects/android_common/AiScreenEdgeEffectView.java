package com.obric.aiagent.product.platform.impl.windoweffects.effects.android_common;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.obric.aiagent.product.ObricProductSdk;
import com.obric.aiagent.product.feature.api.IFeatureServiceKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.g;
import d.h.a.b;
import d.h.b.h;
import d.h.b.o;
import d.h.b.z;
import d.x;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: AiScreenEdgeEffectView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AiScreenEdgeEffectView extends View {
    public static final a Companion = null;
    private static final String TAG = "AiScreenEdgeEffectView";
    private final long activeEffectTimeoutMs;
    private ValueAnimator captureAnimator;
    private float currentAlpha;
    private float currentCaptureProgress;
    private float currentShimmerProgress;
    private final f density$delegate;
    private ValueAnimator fadeAnimator;
    private AtomicBoolean isPreparedToShow;
    private final Paint paint;
    private final AiScreenEdgeEffectShader shader;
    private ValueAnimator shimmerAnimator;
    private ValueAnimator timeAnimator;

    /* JADX INFO: compiled from: AiScreenEdgeEffectView.kt */
    public static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public AiScreenEdgeEffectView(Context r9) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        o.e(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public AiScreenEdgeEffectView(Context r11, AttributeSet r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public AiScreenEdgeEffectView(Context r11, AttributeSet r12, int r13) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r11, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r12, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r3, "context");
        this(r3, r4, r13, 0, 8, null);
    }

    public static /* synthetic */ void lambda$0Dna9Z3CjhtHGgkE5mAZraiQxwg(AiScreenEdgeEffectView r0, ValueAnimator r1) {
        playShimmerAnimation$lambda$11$lambda$10(r0, r1);
    }

    public static /* synthetic */ x lambda$ARIUnbFsyRi6_BHgKYK25ebyfmo() {
        return playFadeInAnimation$lambda$0();
    }

    public static /* synthetic */ x lambda$I4Sremovu2GsQfR55sd9MOR0n0o(Animator r0) {
        return playShimmerAnimation$lambda$9(r0);
    }

    /* JADX INFO: renamed from: lambda$Q59fWvy6_nFJY6a5S2-QxHYTop8, reason: not valid java name */
    public static /* synthetic */ void m240lambda$Q59fWvy6_nFJY6a5S2QxHYTop8(AiScreenEdgeEffectView r0, ValueAnimator r1) {
        playFadeInAnimation$lambda$4$lambda$2(r0, r1);
    }

    public static /* synthetic */ x lambda$WjVoQHYZDoLg03l4cmL3aL1TN_A(Animator r0) {
        return playFadeInAnimation$lambda$1(r0);
    }

    public static /* synthetic */ float lambda$WyEl3vLAL1mu0QvhRUsgiGLvMmo() {
        return density_delegate$lambda$21();
    }

    public static /* synthetic */ void lambda$XEobn7vfXMS1wY8oiD3S6pcnYI4(AiScreenEdgeEffectView r0, ValueAnimator r1) {
        playFadeOutAnimation$lambda$8$lambda$7(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$bWm9O-H8Anl_GKD73zgJGFNzyU8, reason: not valid java name */
    public static /* synthetic */ x m241lambda$bWm9OH8Anl_GKD73zgJGFNzyU8(Animator r0) {
        return playFadeOutAnimation$lambda$5(r0);
    }

    /* JADX INFO: renamed from: lambda$mQabZUq1OacYuhlDGjVT-qCxGwU, reason: not valid java name */
    public static /* synthetic */ x m242lambda$mQabZUq1OacYuhlDGjVTqCxGwU(Animator r0) {
        return playCaptureAnimation$lambda$12(r0);
    }

    public static /* synthetic */ void lambda$ptU96Egww2wlmxte94O9ugNam04(AiScreenEdgeEffectView r0, ValueAnimator r1) {
        playCaptureAnimation$lambda$14$lambda$13(r0, r1);
    }

    public static /* synthetic */ void lambda$rBGwBoFHNf64V5lnrDsdomHB_nQ(AiScreenEdgeEffectView r0, z.e r1, long r2, ValueAnimator r4) {
        startTimeAnimation$lambda$19$lambda$18(r0, r1, r2, r4);
    }

    /* JADX INFO: renamed from: lambda$yAsEAuk6kFN-5mwHq7S3sC6_q_k, reason: not valid java name */
    public static /* synthetic */ x m243lambda$yAsEAuk6kFN5mwHq7S3sC6_q_k(Animator r0) {
        return playFadeOutAnimation$lambda$6(r0);
    }

    public /* synthetic */ AiScreenEdgeEffectView(Context r4, AttributeSet r5, int r6, long r7, int r9, h r10) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r9 & 2) == 0) goto L5;
        r11 = null;
    L5:
        AttributeSet r12 = r11;
        if ((r9 & 4) == 0) goto L8;
        r6 = 0;
    L8:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L11;
        r7 = 300000;
    L11:
        this(r8, r12, r0, r7);
    }

    public final long getActiveEffectTimeoutMs() {
        return this.activeEffectTimeoutMs;
    }

    public AiScreenEdgeEffectView(Context r3, AttributeSet r4, int r5, long r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r8 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r7, "context");
        super(r7, r8, r5);
        this.activeEffectTimeoutMs = r6;
        AiScreenEdgeEffectShader r9 = new AiScreenEdgeEffectShader();
        this.shader = r9;
        Paint r10 = new Paint();
        this.paint = r10;
        this.isPreparedToShow = new AtomicBoolean(false);
        setLayerType(2, null);
        setBackground(null);
        r10.setShader((Shader) ZeusTransformUtils.preCheckCast(r9, Shader.class, "com.obric.aiagent.plugin"));
        this.density$delegate = g.a($$Lambda$AiScreenEdgeEffectView$WyEl3vLAL1mu0QvhRUsgiGLvMmo.INSTANCE);
    }

    public final void prepareToShow() {
        ILogDepend.Companion.i(TAG, "prepareToShow");
        if (this.isPreparedToShow.compareAndSet(false, true) == false) goto L6;
        setVisibility(0);
        initializeShader();
        startTimeAnimation();
        return;
    }

    public final void cancelShow() {
        ILogDepend.Companion.i(TAG, "cancelShow");
        setVisibility(8);
        this.isPreparedToShow.set(false);
        ValueAnimator r0 = this.timeAnimator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        ValueAnimator r1 = this.fadeAnimator;
        if (r1 == null) goto L8;
        r1.cancel();
    L8:
        ValueAnimator r2 = this.shimmerAnimator;
        if (r2 == null) goto L11;
        r2.cancel();
    L11:
        ValueAnimator r3 = this.captureAnimator;
        if (r3 == null) goto L14;
        r3.cancel();
    L14:
        this.timeAnimator = null;
        this.fadeAnimator = null;
        this.shimmerAnimator = null;
        this.captureAnimator = null;
    }

    public static /* synthetic */ void playFadeInAnimation$default(AiScreenEdgeEffectView r1, d.h.a.a r2, b r3, int r4, Object r5) {
        d.h.a.a<x> r6 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r2, d.h.a.a.class, "com.obric.aiagent.plugin");
        b<? super Animator, x> r7 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = $$Lambda$AiScreenEdgeEffectView$ARIUnbFsyRi6_BHgKYK25ebyfmo.INSTANCE;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r7 = $$Lambda$AiScreenEdgeEffectView$WjVoQHYZDoLg03l4cmL3aL1TN_A.INSTANCE;
    L8:
        r1.playFadeInAnimation(r6, r7);
    }

    private static final x playFadeInAnimation$lambda$0() {
        return x.f38692a;
    }

    private static final x playFadeInAnimation$lambda$1(Animator r1) {
        o.e(r1, "it");
        return x.f38692a;
    }

    public final void playFadeInAnimation(d.h.a.a<x> r8, b<? super Animator, x> r9) {
        final d.h.a.a r10 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r8, d.h.a.a.class, "com.obric.aiagent.plugin");
        final b r11 = (b) ZeusTransformUtils.wrapperContextForParams(r9, b.class, "com.obric.aiagent.plugin");
        o.e(r10, "onEnd");
        o.e(r11, "onCancel");
        ILogDepend.Companion.i(TAG, "playFadeInAnimation");
        ValueAnimator r0 = this.fadeAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (com.obric.aiagent.product.platform.impl.windoweffects.a.a.a(this.currentAlpha, 1.0f, 0.0f, 2, null) == false) goto L9;
        ILogDepend.Companion.i(TAG, "playFadeInAnimation: no need to play");
        r10.invoke();
        return;
    L9:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{this.currentAlpha, 1.0f});
        r1.setDuration(300);
        r1.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new DecelerateInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r1.addUpdateListener(new $$Lambda$AiScreenEdgeEffectView$Q59fWvy6_nFJY6a5S2QxHYTop8(this));
        o.a(r1);
        Animator r2 = (Animator) ZeusTransformUtils.preCheckCast(r1, Animator.class, "com.obric.aiagent.plugin");
        Animator.AnimatorListener r3 = new AiScreenEdgeEffectView$playFadeInAnimation$lambda$4$$inlined$addListener$default$1(r11, r10);
        r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r3, Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        Animator.AnimatorListener r12 = (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r3, Animator.AnimatorListener.class, "com.obric.aiagent.plugin");
        r1.start();
        this.fadeAnimator = r1;
    }

    private static final void playFadeInAnimation$lambda$4$lambda$2(AiScreenEdgeEffectView r2, ValueAnimator r3) {
        o.e(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        o.a(r4, "null cannot be cast to non-null type kotlin.Float");
        r2.currentAlpha = ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).floatValue();
    }

    public static /* synthetic */ void playFadeOutAnimation$default(AiScreenEdgeEffectView r1, b r2, b r3, int r4, Object r5) {
        b<? super Animator, x> r6 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        b<? super Animator, x> r7 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.aiagent.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = $$Lambda$AiScreenEdgeEffectView$bWm9OH8Anl_GKD73zgJGFNzyU8.INSTANCE;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r7 = $$Lambda$AiScreenEdgeEffectView$yAsEAuk6kFN5mwHq7S3sC6_q_k.INSTANCE;
    L8:
        r1.playFadeOutAnimation(r6, r7);
    }

    private static final x playFadeOutAnimation$lambda$5(Animator r0) {
        return x.f38692a;
    }

    private static final x playFadeOutAnimation$lambda$6(Animator r1) {
        o.e(r1, "it");
        return x.f38692a;
    }

    public final void playFadeOutAnimation(b<? super Animator, x> r7, b<? super Animator, x> r8) {
        final b r9 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.aiagent.plugin");
        final b r10 = (b) ZeusTransformUtils.wrapperContextForParams(r8, b.class, "com.obric.aiagent.plugin");
        o.e(r9, "onEnd");
        o.e(r10, "onCancel");
        ILogDepend.Companion.i(TAG, "playFadeOutAnimation");
        ValueAnimator r0 = this.fadeAnimator;
        if (r0 == null) goto L6;
        r0.cancel();
    L6:
        if (com.obric.aiagent.product.platform.impl.windoweffects.a.a.a(this.currentAlpha, 0.0f, 0.0f, 2, null) == false) goto L9;
        ILogDepend.Companion.i(TAG, "playFadeOutAnimation: no need to play");
        r9.invoke(null);
        return;
    L9:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{this.currentAlpha, 0.0f});
        r1.setDuration(100);
        r1.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new LinearInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r1.addUpdateListener(new $$Lambda$AiScreenEdgeEffectView$XEobn7vfXMS1wY8oiD3S6pcnYI4(this));
        o.a(r1);
        Animator r2 = (Animator) ZeusTransformUtils.preCheckCast(r1, Animator.class, "com.obric.aiagent.plugin");
        Animator.AnimatorListener r3 = new AiScreenEdgeEffectView$playFadeOutAnimation$lambda$8$$inlined$addListener$default$1(r9, r10);
        r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r3, Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        Animator.AnimatorListener r11 = (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r3, Animator.AnimatorListener.class, "com.obric.aiagent.plugin");
        r1.start();
        this.fadeAnimator = r1;
    }

    private static final void playFadeOutAnimation$lambda$8$lambda$7(AiScreenEdgeEffectView r2, ValueAnimator r3) {
        o.e(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        o.a(r4, "null cannot be cast to non-null type kotlin.Float");
        float r5 = ((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).floatValue();
        r2.currentAlpha = r5;
        r2.shader.setAlpha(r5);
    }

    public static /* synthetic */ void playShimmerAnimation$default(AiScreenEdgeEffectView r1, b r2, int r3, Object r4) {
        b<? super Animator, x> r5 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = $$Lambda$AiScreenEdgeEffectView$I4Sremovu2GsQfR55sd9MOR0n0o.INSTANCE;
    L5:
        r1.playShimmerAnimation(r5);
    }

    private static final x playShimmerAnimation$lambda$9(Animator r1) {
        o.e(r1, "it");
        return x.f38692a;
    }

    public final void playShimmerAnimation(b<? super Animator, x> r6) {
        final b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.aiagent.plugin");
        o.e(r7, "onEnd");
        ILogDepend.Companion.i(TAG, "playShimmerAnimation");
        ValueAnimator r0 = this.shimmerAnimator;
        boolean r3 = true;
        if (r0 != null) goto L5;
    L7:
        r3 = false;
    L8:
        if (r3 == false) goto L11;
        ILogDepend.Companion.i(TAG, "playShimmerAnimation: is playing shimmer animation");
        return;
    L11:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.setDuration(882);
        r1.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new SmoothInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r1.addUpdateListener(new $$Lambda$AiScreenEdgeEffectView$0Dna9Z3CjhtHGgkE5mAZraiQxwg(this));
        o.a(r1);
        Animator r2 = (Animator) ZeusTransformUtils.preCheckCast(r1, Animator.class, "com.obric.aiagent.plugin");
        Animator.AnimatorListener r4 = new AiScreenEdgeEffectView$playShimmerAnimation$lambda$11$$inlined$addListener$default$1(r7, r7);
        r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r4, Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        Animator.AnimatorListener r8 = (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r4, Animator.AnimatorListener.class, "com.obric.aiagent.plugin");
        r1.start();
        this.shimmerAnimator = r1;
        return;
    L5:
        if (r0.isRunning() != true) goto L7;
        goto L7
    }

    private static final void playShimmerAnimation$lambda$11$lambda$10(AiScreenEdgeEffectView r2, ValueAnimator r3) {
        o.e(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        o.a(r4, "null cannot be cast to non-null type kotlin.Float");
        r2.setShimmerProgress(((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).floatValue());
    }

    public static /* synthetic */ void playCaptureAnimation$default(AiScreenEdgeEffectView r1, b r2, int r3, Object r4) {
        b<? super Animator, x> r5 = (b) ZeusTransformUtils.wrapperContextForParams(r2, b.class, "com.obric.aiagent.plugin");
        if ((r3 & 1) == 0) goto L5;
        r5 = $$Lambda$AiScreenEdgeEffectView$mQabZUq1OacYuhlDGjVTqCxGwU.INSTANCE;
    L5:
        r1.playCaptureAnimation(r5);
    }

    private static final x playCaptureAnimation$lambda$12(Animator r1) {
        o.e(r1, "it");
        return x.f38692a;
    }

    public final void playCaptureAnimation(b<? super Animator, x> r5) {
        final b r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.aiagent.plugin");
        o.e(r6, "onEnd");
        ILogDepend.Companion.i(TAG, "playCaptureAnimation");
        ValueAnimator r0 = this.captureAnimator;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        ValueAnimator r1 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r1.setDuration(882);
        r1.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new SmoothInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r1.addUpdateListener(new $$Lambda$AiScreenEdgeEffectView$ptU96Egww2wlmxte94O9ugNam04(this));
        o.a(r1);
        Animator r2 = (Animator) ZeusTransformUtils.preCheckCast(r1, Animator.class, "com.obric.aiagent.plugin");
        Animator.AnimatorListener r3 = new AiScreenEdgeEffectView$playCaptureAnimation$lambda$14$$inlined$addListener$default$1(r6);
        r2.addListener((Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r3, Animator.AnimatorListener.class, "com.obric.aiagent.plugin"));
        Animator.AnimatorListener r7 = (Animator.AnimatorListener) ZeusTransformUtils.preCheckCast(r3, Animator.AnimatorListener.class, "com.obric.aiagent.plugin");
        r1.start();
        this.captureAnimator = r1;
    }

    private static final void playCaptureAnimation$lambda$14$lambda$13(AiScreenEdgeEffectView r2, ValueAnimator r3) {
        o.e(r3, "animator");
        Object r4 = r3.getAnimatedValue();
        o.a(r4, "null cannot be cast to non-null type kotlin.Float");
        r2.setCaptureProgress(((Float) ZeusTransformUtils.preCheckCast(r4, Float.class, "com.obric.aiagent.plugin")).floatValue());
    }

    public final boolean isPlayingShimmerAnimation() {
        ValueAnimator r2 = this.shimmerAnimator;
        if (r2 == null) goto L8;
        if (r2.isRunning() != true) goto L8;
        return true;
    L8:
        return false;
    }

    public final boolean isPlayingCaptureAnimation() {
        ValueAnimator r2 = this.captureAnimator;
        if (r2 == null) goto L8;
        if (r2.isRunning() != true) goto L8;
        return true;
    L8:
        return false;
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        AiScreenEdgeEffectShader r5 = this.shader;
        r5.setResolution(r1, r2);
        r5.setDensity(Resources.getSystem().getDisplayMetrics().density);
        setScreenCornerRadii();
    }

    @Override // android.view.View
    public void onDraw(Canvas r2) {
        o.e(r2, "canvas");
        if (r2.isHardwareAccelerated() == true) goto L5;
        return;
    L5:
        super.onDraw(r2);
        r2.drawPaint(this.paint);
    }

    private final void setShimmerProgress(float r1) {
        this.currentShimmerProgress = r1;
    }

    private final void setCaptureProgress(float r1) {
        this.currentCaptureProgress = r1;
    }

    private final void initializeShader() {
        this.currentAlpha = 0.0f;
        setCaptureProgress(0.0f);
        setShimmerProgress(0.0f);
        AiScreenEdgeEffectShader r1 = this.shader;
        r1.setTime(0.0f);
        r1.setAlpha(this.currentAlpha);
        r1.setCaptureProgress(this.currentCaptureProgress);
        r1.setShimmerProgress(this.currentShimmerProgress);
    }

    private final void startTimeAnimation() {
        ValueAnimator r0 = this.timeAnimator;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        r1 = false;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        ValueAnimator r2 = ValueAnimator.ofFloat(new float[]{0.0f, Float.MAX_VALUE});
        r2.setDuration(Long.MAX_VALUE);
        r2.setInterpolator((TimeInterpolator) ZeusTransformUtils.preCheckCast(new LinearInterpolator(), TimeInterpolator.class, "com.obric.aiagent.plugin"));
        r2.setRepeatCount(-1);
        final z.e r3 = new z.e();
        final long r4 = SystemClock.elapsedRealtime();
        r2.addUpdateListener(new $$Lambda$AiScreenEdgeEffectView$rBGwBoFHNf64V5lnrDsdomHB_nQ(this, r3, r4));
        r2.start();
        this.timeAnimator = r2;
        return;
    L5:
        if (r0.isRunning() != true) goto L7;
        goto L7
    }

    private static final void startTimeAnimation$lambda$19$lambda$18(AiScreenEdgeEffectView r6, z.e r7, long r8, ValueAnimator r10) {
        o.e(r10, "animator");
        AiScreenEdgeEffectShader r0 = r6.shader;
        r0.setTime((r10.getCurrentPlayTime() / 1000.0f) % 1000.0f);
        r0.setAlpha(r6.currentAlpha);
        float r1 = 1.0f;
        if (r6.isPlayingShimmerAnimation() == false) goto L5;
        float r11 = r6.currentShimmerProgress;
    L6:
        r0.setShimmerProgress(r11);
        if (r6.isPlayingCaptureAnimation() == false) goto L9;
        r1 = r6.currentCaptureProgress;
    L9:
        r0.setCaptureProgress(r1);
        long r2 = SystemClock.elapsedRealtime();
        if ((r2 - r7.f38503a) < 1000) goto L14;
        r7.f38503a = r2;
        long r3 = r2 - r8;
        ILogDepend.Companion.i(TAG, "is animating. played time = " + r3 + " ms");
        if (r3 < r6.activeEffectTimeoutMs) goto L14;
        ILogDepend.Companion.i(TAG, "time out for " + r3 + " ms");
        r6.cancelShow();
    L14:
        r6.invalidate();
        return;
    L5:
        r11 = 1.0f;
        goto L6
    }

    private final void setScreenCornerRadii() {
        AiScreenEdgeEffectShader r0 = this.shader;
        String r1 = ObricProductSdk.INSTANCE.featureService().getObricProductName();
        switch(r1.hashCode()) {
            case -2002884280: goto L23;
            case -2002884275: goto L20;
            case -1048984789: goto L16;
            case -807117175: goto L13;
            case 3440915: goto L9;
            case 1328894480: goto L6;
            default: goto L26;
        };
    L26:
        r0.setScreenCornerRadii(getDp(44.0f), getDp(44.0f), getDp(42.0f), getDp(42.0f));
        return;
    L6:
        if (r1.equals(IFeatureServiceKt.PRODUCT_NERIDA_LITE) == false) goto L26;
    L18:
        r0.setScreenCornerRadii(getDp(47.0f), getDp(47.0f), getDp(47.0f), getDp(47.0f));
        return;
    L9:
        if (r1.equals(IFeatureServiceKt.PRODUCT_PIKE) == false) goto L26;
        r0.setScreenCornerRadii(134.0f, 134.0f, 134.0f, 134.0f);
        return;
    L13:
        if (r1.equals("pacific") == false) goto L26;
        r0.setScreenCornerRadii(getDp(44.0f), getDp(44.0f), getDp(42.0f), getDp(42.0f));
        return;
    L16:
        if (r1.equals(IFeatureServiceKt.PRODUCT_NERIDA) == true) goto L18;
    L20:
        if (r1.equals(IFeatureServiceKt.PRODUCT_GENESIS_R) == false) goto L26;
    L25:
        r0.setScreenCornerRadii(getDp(57.0f), getDp(57.0f), getDp(57.0f), getDp(57.0f));
        return;
    L23:
        if (r1.equals(IFeatureServiceKt.PRODUCT_GENESIS_M) == true) goto L25;
        goto L25
    }

    private static final float density_delegate$lambda$21() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    private final float getDensity() {
        return ((Number) ZeusTransformUtils.preCheckCast(this.density$delegate.b(), Number.class, "com.obric.aiagent.plugin")).floatValue();
    }

    private final float getDp(float r1) {
        return r1 * getDensity();
    }
}
