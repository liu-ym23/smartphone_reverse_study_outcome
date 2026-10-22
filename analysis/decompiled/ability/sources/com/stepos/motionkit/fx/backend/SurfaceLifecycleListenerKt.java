package com.stepos.motionkit.fx.backend;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/motionkit/fx/backend/FxRenderSurface;", "Lcom/stepos/motionkit/fx/backend/SurfaceLifecycleListener;", "listener", "LC7/r;", "setLifecycleListener", "(Lcom/stepos/motionkit/fx/backend/FxRenderSurface;Lcom/stepos/motionkit/fx/backend/SurfaceLifecycleListener;)V", "motionkit-fx_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SurfaceLifecycleListenerKt {
    public static final void setLifecycleListener(FxRenderSurface fxRenderSurface, SurfaceLifecycleListener surfaceLifecycleListener) {
        kotlin.jvm.internal.k.f(fxRenderSurface, "<this>");
        if (fxRenderSurface instanceof TransparentSurfaceView) {
            ((TransparentSurfaceView) fxRenderSurface).setSurfaceLifecycleListener$motionkit_fx_release(surfaceLifecycleListener);
        } else {
            if (!(fxRenderSurface instanceof TransparentTextureView)) {
                throw new IllegalStateException("Unsupported internal render surface");
            }
            ((TransparentTextureView) fxRenderSurface).setSurfaceLifecycleListener$motionkit_fx_release(surfaceLifecycleListener);
        }
    }
}
