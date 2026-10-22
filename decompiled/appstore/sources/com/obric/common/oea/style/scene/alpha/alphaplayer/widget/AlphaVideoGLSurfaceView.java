package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.obric.common.oea.style.scene.alpha.alphaplayer.controller.IPlayerControllerExt;
import com.obric.common.oea.style.scene.alpha.alphaplayer.model.ScaleType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0005*\u0001\\\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\r\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\f2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u001fH\u0016¢\u0006\u0004\b#\u0010$J\u001f\u0010(\u001a\u00020\f2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\fH\u0016¢\u0006\u0004\b*\u0010\u000eJ\u000f\u0010+\u001a\u00020\fH\u0016¢\u0006\u0004\b+\u0010\u000eJ\u001f\u0010/\u001a\u00020\f2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,H\u0014¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\fH\u0016¢\u0006\u0004\b1\u0010\u000eR\u001a\u00106\u001a\u00020,8\u0006X\u0086D¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u00107R\"\u0010>\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010B\u001a\u00020%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b?\u00109\u001a\u0004\b@\u0010;\"\u0004\bA\u0010=R\"\u0010G\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010$\"\u0004\bF\u0010\"R$\u0010M\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010\u001eR$\u0010S\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010\u001aR$\u0010[\u001a\u0004\u0018\u00010T8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b]\u0010^¨\u0006`"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLSurfaceView;", "Landroid/opengl/GLSurfaceView;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/IAlphaVideoView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "isSurfaceCreated", "()Z", "", "b", "()V", "Landroid/view/ViewGroup;", "parentView", "addParentView", "(Landroid/view/ViewGroup;)V", "removeParentView", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;", "playerController", "setPlayerController", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;)V", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;", "renderer", "setVideoRenderer", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;)V", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "scaleType", "setScaleType", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;)V", "getScaleType", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "", "videoWidth", "videoHeight", "measureInternal", "(FF)V", "onFirstFrame", "onCompletion", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "release", "a", "I", "getGL_CONTEXT_VERSION", "()I", "GL_CONTEXT_VERSION", "Z", "c", "F", "getMVideoWidth", "()F", "setMVideoWidth", "(F)V", "mVideoWidth", "d", "getMVideoHeight", "setMVideoHeight", "mVideoHeight", "e", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "getMScaleType", "setMScaleType", "mScaleType", "f", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;", "getMRenderer", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;", "setMRenderer", "mRenderer", "g", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;", "getMPlayerController", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;", "setMPlayerController", "mPlayerController", "Landroid/view/Surface;", "h", "Landroid/view/Surface;", "getMSurface", "()Landroid/view/Surface;", "setMSurface", "(Landroid/view/Surface;)V", "mSurface", "com/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLSurfaceView$a", "i", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLSurfaceView$a;", "mSurfaceListener", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaVideoGLSurfaceView extends GLSurfaceView implements IAlphaVideoView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f11755b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f11756c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f11757d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ScaleType f11758e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IRender f11759f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IPlayerControllerExt f11760g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Surface f11761h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final a f11762i;

    public static final class a implements IRender.SurfaceListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlphaVideoGLSurfaceView f11763a;

        public a(AlphaVideoGLSurfaceView r10) {
            this.f11763a = r10;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender.SurfaceListener
        public void onSurfaceDestroyed() {
            Surface r10 = this.f11763a.getMSurface();
            if (r10 == null) goto L5;
            r10.release();
        L5:
            this.f11763a.setMSurface(null);
            AlphaVideoGLSurfaceView.a(this.f11763a, false);
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender.SurfaceListener
        public void onSurfacePrepared(Surface r10) {
            q.g(r10, "surface");
            Surface r11 = this.f11763a.getMSurface();
            if (r11 == null) goto L5;
            r11.release();
        L5:
            this.f11763a.setMSurface(r10);
            AlphaVideoGLSurfaceView.a(this.f11763a, true);
            IPlayerControllerExt r12 = this.f11763a.getMPlayerController();
            if (r12 == null) goto L8;
            r12.surfacePrepared(r10);
        L8:
            IPlayerControllerExt r13 = this.f11763a.getMPlayerController();
            if (r13 == null) goto L12;
            r13.resume();
            return;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IRender f11764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f11766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AlphaVideoGLSurfaceView f11767d;

        public b(IRender r10, int r11, int r12, AlphaVideoGLSurfaceView r13) {
            this.f11764a = r10;
            this.f11765b = r11;
            this.f11766c = r12;
            this.f11767d = r13;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f11764a.measureInternal(this.f11765b, this.f11766c, this.f11767d.getMVideoWidth(), this.f11767d.getMVideoHeight());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public AlphaVideoGLSurfaceView(@NotNull Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ void a(AlphaVideoGLSurfaceView r10, boolean r11) {
        r10.f11755b = r11;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void addParentView(ViewGroup r10) {
        q.g(r10, "parentView");
        if (r10.indexOfChild(this) != (-1)) goto L9;
        ViewParent r11 = getParent();
        if (r11 == null) goto L7;
        ((ViewGroup) r11).removeView(this);
    L7:
        r10.addView(this);
        return;
    }

    public final void b() {
        IRender r10 = this.f11759f;
        if (r10 == null) goto L6;
        r10.setSurfaceListener(this.f11762i);
        return;
    }

    public final int getGL_CONTEXT_VERSION() {
        return this.f11754a;
    }

    @Nullable
    public final IPlayerControllerExt getMPlayerController() {
        return this.f11760g;
    }

    @Nullable
    public final IRender getMRenderer() {
        return this.f11759f;
    }

    @NotNull
    public final ScaleType getMScaleType() {
        return this.f11758e;
    }

    @Nullable
    public final Surface getMSurface() {
        return this.f11761h;
    }

    public final float getMVideoHeight() {
        return this.f11757d;
    }

    public final float getMVideoWidth() {
        return this.f11756c;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    @NotNull
    public ScaleType getScaleType() {
        return this.f11758e;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    @NotNull
    public View getView() {
        return this;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public boolean isSurfaceCreated() {
        return this.f11755b;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void measureInternal(float r10, float r11) {
        float r12 = 0;
        if (r10 > r12) goto L5;
    L7:
        IRender r13 = this.f11759f;
        if (r13 == null) goto L11;
        queueEvent(new b(r13, getMeasuredWidth(), getMeasuredHeight(), this));
        return;
    L11:
        return;
    L5:
        if (r11 <= r12) goto L7;
        this.f11756c = r10;
        this.f11757d = r11;
        goto L7
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void onCompletion() {
        IRender r10 = this.f11759f;
        if (r10 == null) goto L6;
        r10.onCompletion();
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void onFirstFrame() {
        IRender r10 = this.f11759f;
        if (r10 == null) goto L6;
        r10.onFirstFrame();
        return;
    }

    @Override // android.view.SurfaceView, android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        measureInternal(this.f11756c, this.f11757d);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void release() {
        this.f11762i.onSurfaceDestroyed();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void removeParentView(ViewGroup r10) {
        q.g(r10, "parentView");
        r10.removeView(this);
    }

    public final void setMPlayerController(@Nullable IPlayerControllerExt r10) {
        this.f11760g = r10;
    }

    public final void setMRenderer(@Nullable IRender r10) {
        this.f11759f = r10;
    }

    public final void setMScaleType(@NotNull ScaleType r10) {
        q.g(r10, "<set-?>");
        this.f11758e = r10;
    }

    public final void setMSurface(@Nullable Surface r10) {
        this.f11761h = r10;
    }

    public final void setMVideoHeight(float r10) {
        this.f11757d = r10;
    }

    public final void setMVideoWidth(float r10) {
        this.f11756c = r10;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void setPlayerController(@NotNull IPlayerControllerExt r10) {
        q.g(r10, "playerController");
        this.f11760g = r10;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void setScaleType(@NotNull ScaleType r10) {
        q.g(r10, "scaleType");
        this.f11758e = r10;
        IRender r11 = this.f11759f;
        if (r11 == null) goto L6;
        r11.setScaleType(r10);
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void setVideoRenderer(@NotNull IRender r10) {
        q.g(r10, "renderer");
        this.f11759f = r10;
        setRenderer(r10);
        b();
        setRenderMode(0);
    }

    public /* synthetic */ AlphaVideoGLSurfaceView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public AlphaVideoGLSurfaceView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f11754a = 2;
        this.f11758e = ScaleType.ScaleAspectFill;
        this.f11762i = new a(this);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        getHolder().setFormat(-3);
        b();
        setZOrderOnTop(true);
        setPreserveEGLContextOnPause(true);
    }
}
