package com.stepos.motionkit.fx.backend;

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\r\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001b\u001a\u00020\n2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\n0\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J/\u0010%\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!H\u0016¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b'\u0010 R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u001e\u0010+\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010-\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u0004\u0018\u00010/8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u00105\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0014\u00107\u001a\u00020!8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00104¨\u00068"}, d2 = {"Lcom/stepos/motionkit/fx/backend/TransparentSurfaceView;", "Landroid/view/SurfaceView;", "Landroid/view/SurfaceHolder$Callback;", "Lcom/stepos/motionkit/fx/backend/FxRenderSurface;", "Landroid/content/Context;", "context", AppAgent.CONSTRUCT, "(Landroid/content/Context;)V", "Lcom/stepos/motionkit/fx/backend/SurfaceLifecycleListener;", "listener", "LC7/r;", "setSurfaceLifecycleListener$motionkit_fx_release", "(Lcom/stepos/motionkit/fx/backend/SurfaceLifecycleListener;)V", "setSurfaceLifecycleListener", "Landroid/view/View;", "asView", "()Landroid/view/View;", "Landroid/view/ViewGroup;", "parent", "attachTo", "(Landroid/view/ViewGroup;)V", "", "scale", "setRenderScale", "(F)V", "Lkotlin/Function0;", "callback", "setOnReady", "(LS7/a;)V", "Landroid/view/SurfaceHolder;", "holder", "surfaceCreated", "(Landroid/view/SurfaceHolder;)V", "", "format", "width", "height", "surfaceChanged", "(Landroid/view/SurfaceHolder;III)V", "surfaceDestroyed", "", "surfaceReady", "Z", "onReady", "LS7/a;", "lifecycleListener", "Lcom/stepos/motionkit/fx/backend/SurfaceLifecycleListener;", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "surface", "getRenderWidth", "()I", "renderWidth", "getRenderHeight", "renderHeight", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TransparentSurfaceView extends SurfaceView implements SurfaceHolder.Callback, FxRenderSurface {
    private SurfaceLifecycleListener lifecycleListener;
    private S7.a onReady;
    private boolean surfaceReady;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransparentSurfaceView(Context context) {
        super(context);
        kotlin.jvm.internal.k.f(context, "context");
        setZOrderOnTop(true);
        getHolder().setFormat(-3);
        getHolder().addCallback(this);
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
    public int getRenderHeight() {
        return getHolder().getSurfaceFrame().height();
    }

    @Override // com.stepos.motionkit.fx.backend.RenderTarget
    public int getRenderWidth() {
        return getHolder().getSurfaceFrame().width();
    }

    @Override // com.stepos.motionkit.fx.backend.RenderTarget
    public Surface getSurface() {
        Surface surface = getHolder().getSurface();
        if (surface == null || !surface.isValid()) {
            return null;
        }
        return surface;
    }

    @Override // com.stepos.motionkit.fx.backend.FxRenderSurface
    public void setOnReady(S7.a callback) {
        kotlin.jvm.internal.k.f(callback, "callback");
        if (this.surfaceReady) {
            callback.invoke();
        } else {
            this.onReady = callback;
        }
    }

    @Override // com.stepos.motionkit.fx.backend.FxRenderSurface
    public void setRenderScale(float scale) {
        SurfaceHolder holder = getHolder();
        int i = (int) (getResources().getDisplayMetrics().widthPixels * scale);
        if (i < 1) {
            i = 1;
        }
        int i6 = (int) (getResources().getDisplayMetrics().heightPixels * scale);
        holder.setFixedSize(i, i6 >= 1 ? i6 : 1);
    }

    public final void setSurfaceLifecycleListener$motionkit_fx_release(SurfaceLifecycleListener listener) {
        this.lifecycleListener = listener;
        if (!this.surfaceReady || listener == null) {
            return;
        }
        listener.onAvailable();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        kotlin.jvm.internal.k.f(holder, "holder");
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder holder) {
        kotlin.jvm.internal.k.f(holder, "holder");
        this.surfaceReady = true;
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

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder holder) {
        kotlin.jvm.internal.k.f(holder, "holder");
        this.surfaceReady = false;
        SurfaceLifecycleListener surfaceLifecycleListener = this.lifecycleListener;
        if (surfaceLifecycleListener != null) {
            surfaceLifecycleListener.onDestroyed();
        }
    }
}
