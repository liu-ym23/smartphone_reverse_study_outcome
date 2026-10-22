package com.obric.autoaction.app.launcherpage.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: FluidColorfulBlobView.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class FluidColorfulBlobView extends View {
    public static final a Companion = null;
    public static final int FRAME_RATE_MAX = 0;
    private float accumulatedSeconds;
    private Choreographer choreographer;
    private FluidColorfulBlobShader.a colorTheme;
    private final FluidColorfulBlobView$frameCallback$1 frameCallback;
    private boolean isAnimationRunning;
    private long lastFrameNanos;
    private final Paint paint;
    private final FluidColorfulBlobShader shader;
    private float speed;
    private int targetFrameRate;

    /* JADX INFO: compiled from: FluidColorfulBlobView.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    static {
        Companion = new a(null);
    }

    public FluidColorfulBlobView(Context r7) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r1, "context");
        this(r1, null, 0, 6, null);
    }

    public FluidColorfulBlobView(Context r9, AttributeSet r10) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r3, "context");
        this(r3, r4, 0, 4, null);
    }

    public static final /* synthetic */ long access$frameIntervalNanos(FluidColorfulBlobView r2) {
        return r2.frameIntervalNanos();
    }

    public static final /* synthetic */ float access$getAccumulatedSeconds$p(FluidColorfulBlobView r0) {
        return r0.accumulatedSeconds;
    }

    public static final /* synthetic */ long access$getLastFrameNanos$p(FluidColorfulBlobView r2) {
        return r2.lastFrameNanos;
    }

    public static final /* synthetic */ boolean access$isAnimationRunning$p(FluidColorfulBlobView r0) {
        return r0.isAnimationRunning;
    }

    public static final /* synthetic */ void access$renderCurrentFrame(FluidColorfulBlobView r0) {
        r0.renderCurrentFrame();
    }

    public static final /* synthetic */ void access$scheduleNextFrame(FluidColorfulBlobView r0) {
        r0.scheduleNextFrame();
    }

    public static final /* synthetic */ void access$setAccumulatedSeconds$p(FluidColorfulBlobView r0, float r1) {
        r0.accumulatedSeconds = r1;
    }

    public static final /* synthetic */ void access$setLastFrameNanos$p(FluidColorfulBlobView r0, long r1) {
        r0.lastFrameNanos = r1;
    }

    public /* synthetic */ FluidColorfulBlobView(Context r2, AttributeSet r3, int r4, int r5, d.h.b.h r6) {
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

    /* JADX WARN: Type inference failed for: r5v5, types: [com.obric.autoaction.app.launcherpage.ui.FluidColorfulBlobView$frameCallback$1] */
    public FluidColorfulBlobView(Context r3, AttributeSet r4, int r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        super(r6, r7, r5);
        FluidColorfulBlobShader r8 = new FluidColorfulBlobShader();
        this.shader = r8;
        Paint r9 = new Paint();
        this.paint = r9;
        this.speed = 1.0f;
        this.colorTheme = FluidColorfulBlobShader.Companion.a();
        this.targetFrameRate = 60;
        this.frameCallback = new FluidColorfulBlobView$frameCallback$1(this);
        setLayerType(2, null);
        setBackground(null);
        initializeShader();
        startTimeAnimation();
        r9.setShader((Shader) ZeusTransformUtils.preCheckCast(r8, Shader.class, "com.obric.aiagent.plugin"));
    }

    public final float getSpeed() {
        return this.speed;
    }

    public final void setSpeed(float r1) {
        this.speed = r1;
    }

    public final FluidColorfulBlobShader.a getColorTheme() {
        return this.colorTheme;
    }

    public final void setColorTheme(FluidColorfulBlobShader.a r2) {
        d.h.b.o.e(r2, "value");
        this.colorTheme = r2;
        this.shader.applyTheme(r2);
        invalidate();
    }

    public final int getTargetFrameRate() {
        return this.targetFrameRate;
    }

    public final void setTargetFrameRate(int r3) {
        if (r3 < 0) goto L4;
        boolean r0 = true;
    L5:
        if (r0 == false) goto L9;
        this.targetFrameRate = r3;
        this.lastFrameNanos = 0;
        return;
    L9:
        throw new IllegalArgumentException("targetFrameRate must be 0 or a positive integer.".toString());
    L4:
        r0 = false;
        goto L5
    }

    private final void initializeShader() {
        this.shader.applyTheme(this.colorTheme);
        this.shader.setTime(0.0f);
    }

    private final long frameIntervalNanos() {
        int r4 = this.targetFrameRate;
        if (r4 != 0) goto L7;
        return 0;
    L7:
        return 1000000000 / ((long) r4);
    }

    private final void renderCurrentFrame() {
        this.shader.setTime(this.accumulatedSeconds);
        invalidate();
    }

    private final void scheduleNextFrame() {
        Choreographer r0 = this.choreographer;
        if (r0 == null) goto L6;
        r0.postFrameCallback((Choreographer.FrameCallback) ZeusTransformUtils.preCheckCast(this.frameCallback, Choreographer.FrameCallback.class, "com.obric.aiagent.plugin"));
        return;
    }

    private final void startTimeAnimation() {
        if (this.isAnimationRunning == false) goto L5;
        return;
    L5:
        this.isAnimationRunning = true;
        this.lastFrameNanos = 0;
        this.choreographer = Choreographer.getInstance();
        scheduleNextFrame();
    }

    private final void stopTimeAnimation() {
        this.isAnimationRunning = false;
        Choreographer r0 = this.choreographer;
        if (r0 == null) goto L5;
        r0.removeFrameCallback((Choreographer.FrameCallback) ZeusTransformUtils.preCheckCast(this.frameCallback, Choreographer.FrameCallback.class, "com.obric.aiagent.plugin"));
    L5:
        this.choreographer = null;
    }

    @Override // android.view.View
    public void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        this.shader.setResolution(r1, r2);
    }

    @Override // android.view.View
    public void onDraw(Canvas r2) {
        d.h.b.o.e(r2, "canvas");
        super.onDraw(r2);
        r2.drawPaint(this.paint);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startTimeAnimation();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopTimeAnimation();
    }

    @Override // android.view.View
    public void onVisibilityChanged(View r2, int r3) {
        d.h.b.o.e(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        handleVisibilityChange();
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int r1) {
        super.onWindowVisibilityChanged(r1);
        handleVisibilityChange();
    }

    private final void handleVisibilityChange() {
        if (isShown() == true) goto L5;
    L7:
        stopTimeAnimation();
        return;
    L5:
        if (isAttachedToWindow() == false) goto L7;
        startTimeAnimation();
    }
}
