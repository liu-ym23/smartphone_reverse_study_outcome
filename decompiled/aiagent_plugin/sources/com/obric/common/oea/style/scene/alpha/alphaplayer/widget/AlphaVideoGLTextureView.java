package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.obric.common.oea.style.scene.alpha.alphaplayer.a.d;
import com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Objects;

/* JADX INFO: compiled from: AlphaVideoGLTextureView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AlphaVideoGLTextureView extends GLTextureView implements com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a {
    private final int GL_CONTEXT_VERSION;
    private volatile boolean isSurfaceCreated;
    private com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b mPlayerController;
    private IRender mRenderer;
    private d mScaleType;
    private Surface mSurface;
    private final a mSurfaceListener;
    private float mVideoHeight;
    private float mVideoWidth;

    /* JADX INFO: compiled from: AlphaVideoGLTextureView.kt */
    public static final class a implements IRender.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AlphaVideoGLTextureView f32531a;

        a(AlphaVideoGLTextureView r1) {
            this.f32531a = r1;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender.a
        public void a(Surface r3) {
            o.e(r3, "surface");
            Surface r0 = this.f32531a.getMSurface();
            if (r0 == null) goto L5;
            r0.release();
        L5:
            this.f32531a.setMSurface(r3);
            AlphaVideoGLTextureView.access$setSurfaceCreated$p(this.f32531a, true);
            com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b r1 = this.f32531a.getMPlayerController();
            if (r1 == null) goto L8;
            r1.surfacePrepared(r3);
        L8:
            com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b r2 = this.f32531a.getMPlayerController();
            if (r2 == null) goto L12;
            r2.resume();
            return;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender.a
        public void a() {
            Surface r0 = this.f32531a.getMSurface();
            if (r0 == null) goto L5;
            r0.release();
        L5:
            this.f32531a.setMSurface((Surface) ZeusTransformUtils.preCheckCast(null, Surface.class, "com.obric.aiagent.plugin"));
            AlphaVideoGLTextureView.access$setSurfaceCreated$p(this.f32531a, false);
        }
    }

    /* JADX INFO: compiled from: AlphaVideoGLTextureView.kt */
    static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IRender f32532a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f32533b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f32534c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ AlphaVideoGLTextureView f32535d;

        b(IRender r3, int r4, int r5, AlphaVideoGLTextureView r6) {
            this.f32532a = (IRender) ZeusTransformUtils.wrapperContextForParams(r3, IRender.class, "com.obric.aiagent.plugin");
            this.f32533b = r4;
            this.f32534c = r5;
            this.f32535d = r6;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f32532a.measureInternal(this.f32533b, this.f32534c, AlphaVideoGLTextureView.access$getMVideoWidth$p(this.f32535d), AlphaVideoGLTextureView.access$getMVideoHeight$p(this.f32535d));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AlphaVideoGLTextureView(Context r3) {
        this((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), null, 2, 0 == true ? 1 : 0);
    }

    public /* synthetic */ AlphaVideoGLTextureView(Context r2, AttributeSet r3, int r4, h r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        if ((r4 & 2) == 0) goto L5;
        r7 = (AttributeSet) ZeusTransformUtils.preCheckCast(null, AttributeSet.class, "com.obric.aiagent.plugin");
    L5:
        this(r6, r7);
    }

    public static final /* synthetic */ float access$getMVideoHeight$p(AlphaVideoGLTextureView r0) {
        return r0.mVideoHeight;
    }

    public static final /* synthetic */ float access$getMVideoWidth$p(AlphaVideoGLTextureView r0) {
        return r0.mVideoWidth;
    }

    public static final /* synthetic */ boolean access$isSurfaceCreated$p(AlphaVideoGLTextureView r0) {
        return r0.isSurfaceCreated;
    }

    public static final /* synthetic */ void access$setMVideoHeight$p(AlphaVideoGLTextureView r0, float r1) {
        r0.mVideoHeight = r1;
    }

    public static final /* synthetic */ void access$setMVideoWidth$p(AlphaVideoGLTextureView r0, float r1) {
        r0.mVideoWidth = r1;
    }

    public static final /* synthetic */ void access$setSurfaceCreated$p(AlphaVideoGLTextureView r0, boolean r1) {
        r0.isSurfaceCreated = r1;
    }

    public AlphaVideoGLTextureView(Context r8, AttributeSet r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r11 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r9, AttributeSet.class, "com.obric.aiagent.plugin");
        o.e(r10, "context");
        super(r10, r11);
        this.GL_CONTEXT_VERSION = 2;
        this.mScaleType = d.f32495c;
        this.mSurfaceListener = new a(this);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        addOnSurfacePreparedListener();
        setPreserveEGLContextOnPause(true);
        setOpaque(false);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public boolean isSurfaceCreated() {
        return this.isSurfaceCreated;
    }

    public final com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b getMPlayerController() {
        return this.mPlayerController;
    }

    public final void setMPlayerController(com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b r3) {
        this.mPlayerController = (com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b.class, "com.obric.aiagent.plugin");
    }

    public final Surface getMSurface() {
        return this.mSurface;
    }

    public final void setMSurface(Surface r1) {
        this.mSurface = r1;
    }

    private final void addOnSurfacePreparedListener() {
        IRender r0 = this.mRenderer;
        if (r0 == null) goto L6;
        r0.setSurfaceListener((IRender.a) ZeusTransformUtils.preCheckCast(this.mSurfaceListener, IRender.a.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void addParentView(ViewGroup r4) {
        o.e(r4, "parentView");
        if (r4.indexOfChild((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin")) != (-1)) goto L9;
        ViewParent r0 = getParent();
        if (r0 == null) goto L7;
        Objects.requireNonNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) ZeusTransformUtils.preCheckCast(r0, ViewGroup.class, "com.obric.aiagent.plugin")).removeView((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    L7:
        r4.addView((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void removeParentView(ViewGroup r3) {
        o.e(r3, "parentView");
        r3.removeView((View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin"));
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public View getView() {
        return (View) ZeusTransformUtils.preCheckCast(this, View.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void setPlayerController(com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b r3) {
        com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b r4 = (com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.common.oea.style.scene.alpha.alphaplayer.controller.b.class, "com.obric.aiagent.plugin");
        o.e(r4, "playerController");
        this.mPlayerController = r4;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void setVideoRenderer(IRender r3) {
        IRender r4 = (IRender) ZeusTransformUtils.wrapperContextForParams(r3, IRender.class, "com.obric.aiagent.plugin");
        o.e(r4, "renderer");
        this.mRenderer = r4;
        setRenderer((GLTextureView.m) ZeusTransformUtils.preCheckCast(r4, GLTextureView.m.class, "com.obric.aiagent.plugin"));
        addOnSurfacePreparedListener();
        setRenderMode(0);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void setScaleType(d r2) {
        o.e(r2, "scaleType");
        this.mScaleType = r2;
        IRender r1 = this.mRenderer;
        if (r1 == null) goto L6;
        r1.setScaleType(r2);
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public d getScaleType() {
        return this.mScaleType;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void measureInternal(float r3, float r4) {
        float r0 = 0;
        if (r3 > r0) goto L5;
    L7:
        IRender r5 = this.mRenderer;
        if (r5 == null) goto L11;
        queueEvent((Runnable) ZeusTransformUtils.preCheckCast(new b(r5, getMeasuredWidth(), getMeasuredHeight(), this), Runnable.class, "com.obric.aiagent.plugin"));
        return;
    L11:
        return;
    L5:
        if (r4 <= r0) goto L7;
        this.mVideoWidth = r3;
        this.mVideoHeight = r4;
        goto L7
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void onFirstFrame() {
        IRender r0 = this.mRenderer;
        if (r0 == null) goto L6;
        r0.onFirstFrame();
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void onCompletion() {
        IRender r0 = this.mRenderer;
        if (r0 == null) goto L6;
        r0.onCompletion();
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r1, int r2) {
        super.onMeasure(r1, r2);
        measureInternal(this.mVideoWidth, this.mVideoHeight);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.a
    public void release() {
        this.mSurfaceListener.a();
    }
}
