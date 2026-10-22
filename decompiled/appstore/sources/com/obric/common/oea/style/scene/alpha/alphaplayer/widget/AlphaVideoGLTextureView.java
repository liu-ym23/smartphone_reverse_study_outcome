package com.obric.common.oea.style.scene.alpha.alphaplayer.widget;

import android.content.Context;
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
@Metadata(d1 = {"\u0000q\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\b\u0004*\u0001P\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u001fH\u0016¢\u0006\u0004\b#\u0010$J\u001f\u0010(\u001a\u00020\t2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\tH\u0016¢\u0006\u0004\b*\u0010\u000bJ\u000f\u0010+\u001a\u00020\tH\u0016¢\u0006\u0004\b+\u0010\u000bJ\u001f\u0010/\u001a\u00020\t2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,H\u0014¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020\tH\u0016¢\u0006\u0004\b1\u0010\u000bR\u0014\u00104\u001a\u00020,8\u0002X\u0082D¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010>\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010A\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010@R$\u0010G\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010\u001aR$\u0010O\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0014\u0010R\u001a\u00020P8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010Q¨\u0006S"}, d2 = {"Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLTextureView;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/GLTextureView;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/IAlphaVideoView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "v", "()V", "", "isSurfaceCreated", "()Z", "Landroid/view/ViewGroup;", "parentView", "addParentView", "(Landroid/view/ViewGroup;)V", "removeParentView", "Landroid/view/View;", "getView", "()Landroid/view/View;", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;", "playerController", "setPlayerController", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;)V", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;", "renderer", "setVideoRenderer", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;)V", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "scaleType", "setScaleType", "(Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;)V", "getScaleType", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "", "videoWidth", "videoHeight", "measureInternal", "(FF)V", "onFirstFrame", "onCompletion", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "(II)V", "release", "n", "I", "GL_CONTEXT_VERSION", "o", "Z", "p", "F", "mVideoWidth", "q", "mVideoHeight", "r", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/model/ScaleType;", "mScaleType", "s", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/render/IRender;", "mRenderer", "t", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;", "getMPlayerController", "()Lcom/obric/common/oea/style/scene/alpha/alphaplayer/controller/IPlayerControllerExt;", "setMPlayerController", "mPlayerController", "Landroid/view/Surface;", "u", "Landroid/view/Surface;", "getMSurface", "()Landroid/view/Surface;", "setMSurface", "(Landroid/view/Surface;)V", "mSurface", "com/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLTextureView$a", "Lcom/obric/common/oea/style/scene/alpha/alphaplayer/widget/AlphaVideoGLTextureView$a;", "mSurfaceListener", "style_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class AlphaVideoGLTextureView extends GLTextureView implements IAlphaVideoView {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f11768n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile boolean f11769o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public float f11770p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public float f11771q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public ScaleType f11772r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public IRender f11773s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public IPlayerControllerExt f11774t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Surface f11775u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final a f11776v;

    public static final class a implements IRender.SurfaceListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AlphaVideoGLTextureView f11777a;

        public a(AlphaVideoGLTextureView r10) {
            this.f11777a = r10;
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender.SurfaceListener
        public void onSurfaceDestroyed() {
            Surface r10 = this.f11777a.getMSurface();
            if (r10 == null) goto L5;
            r10.release();
        L5:
            this.f11777a.setMSurface(null);
            AlphaVideoGLTextureView.u(this.f11777a, false);
        }

        @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.render.IRender.SurfaceListener
        public void onSurfacePrepared(Surface r10) {
            q.g(r10, "surface");
            Surface r11 = this.f11777a.getMSurface();
            if (r11 == null) goto L5;
            r11.release();
        L5:
            this.f11777a.setMSurface(r10);
            AlphaVideoGLTextureView.u(this.f11777a, true);
            IPlayerControllerExt r12 = this.f11777a.getMPlayerController();
            if (r12 == null) goto L8;
            r12.surfacePrepared(r10);
        L8:
            IPlayerControllerExt r13 = this.f11777a.getMPlayerController();
            if (r13 == null) goto L12;
            r13.resume();
            return;
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IRender f11778a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f11779b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f11780c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ AlphaVideoGLTextureView f11781d;

        public b(IRender r10, int r11, int r12, AlphaVideoGLTextureView r13) {
            this.f11778a = r10;
            this.f11779b = r11;
            this.f11780c = r12;
            this.f11781d = r13;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f11778a.measureInternal(this.f11779b, this.f11780c, AlphaVideoGLTextureView.t(this.f11781d), AlphaVideoGLTextureView.s(this.f11781d));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public AlphaVideoGLTextureView(@NotNull Context r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ float s(AlphaVideoGLTextureView r10) {
        return r10.f11771q;
    }

    public static final /* synthetic */ float t(AlphaVideoGLTextureView r10) {
        return r10.f11770p;
    }

    public static final /* synthetic */ void u(AlphaVideoGLTextureView r10, boolean r11) {
        r10.f11769o = r11;
    }

    private final void v() {
        IRender r10 = this.f11773s;
        if (r10 == null) goto L6;
        r10.setSurfaceListener(this.f11776v);
        return;
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

    @Nullable
    public final IPlayerControllerExt getMPlayerController() {
        return this.f11774t;
    }

    @Nullable
    public final Surface getMSurface() {
        return this.f11775u;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    @NotNull
    public ScaleType getScaleType() {
        return this.f11772r;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    @NotNull
    public View getView() {
        return this;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public boolean isSurfaceCreated() {
        return this.f11769o;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void measureInternal(float r10, float r11) {
        float r12 = 0;
        if (r10 > r12) goto L5;
    L7:
        IRender r13 = this.f11773s;
        if (r13 == null) goto L11;
        m(new b(r13, getMeasuredWidth(), getMeasuredHeight(), this));
        return;
    L11:
        return;
    L5:
        if (r11 <= r12) goto L7;
        this.f11770p = r10;
        this.f11771q = r11;
        goto L7
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void onCompletion() {
        IRender r10 = this.f11773s;
        if (r10 == null) goto L6;
        r10.onCompletion();
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void onFirstFrame() {
        IRender r10 = this.f11773s;
        if (r10 == null) goto L6;
        r10.onFirstFrame();
        return;
    }

    @Override // android.view.View
    public void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
        measureInternal(this.f11770p, this.f11771q);
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void release() {
        this.f11776v.onSurfaceDestroyed();
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void removeParentView(ViewGroup r10) {
        q.g(r10, "parentView");
        r10.removeView(this);
    }

    public final void setMPlayerController(@Nullable IPlayerControllerExt r10) {
        this.f11774t = r10;
    }

    public final void setMSurface(@Nullable Surface r10) {
        this.f11775u = r10;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void setPlayerController(@NotNull IPlayerControllerExt r10) {
        q.g(r10, "playerController");
        this.f11774t = r10;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void setScaleType(@NotNull ScaleType r10) {
        q.g(r10, "scaleType");
        this.f11772r = r10;
        IRender r11 = this.f11773s;
        if (r11 == null) goto L6;
        r11.setScaleType(r10);
        return;
    }

    @Override // com.obric.common.oea.style.scene.alpha.alphaplayer.widget.IAlphaVideoView
    public void setVideoRenderer(@NotNull IRender r10) {
        q.g(r10, "renderer");
        this.f11773s = r10;
        setRenderer(r10);
        v();
        setRenderMode(0);
    }

    public /* synthetic */ AlphaVideoGLTextureView(Context r10, AttributeSet r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public AlphaVideoGLTextureView(@NotNull Context r10, @Nullable AttributeSet r11) {
        q.g(r10, "context");
        super(r10, r11);
        this.f11768n = 2;
        this.f11772r = ScaleType.ScaleAspectFill;
        this.f11776v = new a(this);
        setEGLContextClientVersion(2);
        o(8, 8, 8, 8, 16, 0);
        v();
        setPreserveEGLContextOnPause(true);
        setOpaque(false);
    }
}
