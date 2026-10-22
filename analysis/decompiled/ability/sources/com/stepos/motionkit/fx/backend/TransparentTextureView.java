package com.stepos.motionkit.fx.backend;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000f\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001d\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010$\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0016¢\u0006\u0004\b$\u0010%J'\u0010&\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!H\u0016¢\u0006\u0004\b&\u0010%J\u0017\u0010(\u001a\u00020'2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\b2\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b*\u0010+R\u001e\u0010,\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010.\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00108R\u0016\u0010<\u001a\u0004\u0018\u0001028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0014\u0010A\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b@\u0010>¨\u0006B"}, d2 = {"Lcom/stepos/motionkit/fx/backend/TransparentTextureView;", "Landroid/view/TextureView;", "Landroid/view/TextureView$SurfaceTextureListener;", "Lcom/stepos/motionkit/fx/backend/FxRenderSurface;", "Landroid/content/Context;", "context", AppAgent.CONSTRUCT, "(Landroid/content/Context;)V", "LC7/r;", "applyScale", "()V", "Lcom/stepos/motionkit/fx/backend/SurfaceLifecycleListener;", "listener", "setSurfaceLifecycleListener$motionkit_fx_release", "(Lcom/stepos/motionkit/fx/backend/SurfaceLifecycleListener;)V", "setSurfaceLifecycleListener", "Landroid/view/View;", "asView", "()Landroid/view/View;", "Landroid/view/ViewGroup;", "parent", "attachTo", "(Landroid/view/ViewGroup;)V", "", "scale", "setRenderScale", "(F)V", "Lkotlin/Function0;", "callback", "setOnReady", "(LS7/a;)V", "Landroid/graphics/SurfaceTexture;", "st", "", "width", "height", "onSurfaceTextureAvailable", "(Landroid/graphics/SurfaceTexture;II)V", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "(Landroid/graphics/SurfaceTexture;)Z", "onSurfaceTextureUpdated", "(Landroid/graphics/SurfaceTexture;)V", "onReady", "LS7/a;", "lifecycleListener", "Lcom/stepos/motionkit/fx/backend/SurfaceLifecycleListener;", "ready", "Z", "Landroid/view/Surface;", "cachedSurface", "Landroid/view/Surface;", "pendingScale", "F", "bufferWidth", "I", "bufferHeight", "getSurface", "()Landroid/view/Surface;", "surface", "getRenderWidth", "()I", "renderWidth", "getRenderHeight", "renderHeight", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TransparentTextureView extends TextureView implements TextureView.SurfaceTextureListener, FxRenderSurface {
    private int bufferHeight;
    private int bufferWidth;
    private Surface cachedSurface;
    private SurfaceLifecycleListener lifecycleListener;
    private S7.a onReady;
    private float pendingScale;
    private boolean ready;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransparentTextureView(Context context) {
        super(context);
        kotlin.jvm.internal.k.f(context, "context");
        this.pendingScale = 1.0f;
        setOpaque(false);
        setSurfaceTextureListener(this);
    }

    private final void applyScale() {
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture == null) {
            return;
        }
        int i = (int) (getResources().getDisplayMetrics().widthPixels * this.pendingScale);
        if (i < 1) {
            i = 1;
        }
        this.bufferWidth = i;
        int i6 = (int) (getResources().getDisplayMetrics().heightPixels * this.pendingScale);
        int i10 = i6 >= 1 ? i6 : 1;
        this.bufferHeight = i10;
        surfaceTexture.setDefaultBufferSize(this.bufferWidth, i10);
    }

    @Override // com.stepos.motionkit.fx.backend.FxRenderSurface
    public View asView() {
        return this;
    }

    @Override // com.stepos.motionkit.fx.backend.FxRenderSurface
    public void attachTo(ViewGroup parent) {
        kotlin.jvm.internal.k.f(parent, "parent");
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        parent.addView(this);
    }

    @Override // com.stepos.motionkit.fx.backend.RenderTarget
    /* renamed from: getRenderHeight, reason: from getter */
    public int getBufferHeight() {
        return this.bufferHeight;
    }

    @Override // com.stepos.motionkit.fx.backend.RenderTarget
    /* renamed from: getRenderWidth, reason: from getter */
    public int getBufferWidth() {
        return this.bufferWidth;
    }

    @Override // com.stepos.motionkit.fx.backend.RenderTarget
    public Surface getSurface() {
        Surface surface = this.cachedSurface;
        if (surface == null || !surface.isValid()) {
            return null;
        }
        return surface;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture st, int width, int height) {
        kotlin.jvm.internal.k.f(st, "st");
        applyScale();
        this.cachedSurface = new Surface(st);
        this.ready = true;
        SurfaceLifecycleListener surfaceLifecycleListener = this.lifecycleListener;
        if (surfaceLifecycleListener != null) {
            surfaceLifecycleListener.onAvailable();
        }
        S7.a aVar = this.onReady;
        if (aVar != null) {
            aVar.invoke();
        }
        this.onReady = null;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture st) {
        kotlin.jvm.internal.k.f(st, "st");
        this.ready = false;
        SurfaceLifecycleListener surfaceLifecycleListener = this.lifecycleListener;
        if (surfaceLifecycleListener != null) {
            surfaceLifecycleListener.onDestroyed();
        }
        Surface surface = this.cachedSurface;
        if (surface != null) {
            surface.release();
        }
        this.cachedSurface = null;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture st, int width, int height) {
        kotlin.jvm.internal.k.f(st, "st");
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture st) {
        kotlin.jvm.internal.k.f(st, "st");
    }

    @Override // com.stepos.motionkit.fx.backend.FxRenderSurface
    public void setOnReady(S7.a callback) {
        kotlin.jvm.internal.k.f(callback, "callback");
        if (this.ready) {
            callback.invoke();
        } else {
            this.onReady = callback;
        }
    }

    @Override // com.stepos.motionkit.fx.backend.FxRenderSurface
    public void setRenderScale(float scale) {
        this.pendingScale = scale;
        applyScale();
    }

    public final void setSurfaceLifecycleListener$motionkit_fx_release(SurfaceLifecycleListener listener) {
        this.lifecycleListener = listener;
        if (!this.ready || listener == null) {
            return;
        }
        listener.onAvailable();
    }
}
