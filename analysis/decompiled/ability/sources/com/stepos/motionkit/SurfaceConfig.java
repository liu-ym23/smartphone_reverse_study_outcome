package com.stepos.motionkit;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/motionkit/SurfaceConfig;", "", AppAgent.CONSTRUCT, "()V", "renderer", "Lcom/stepos/motionkit/SurfaceRendererType;", "getRenderer", "()Lcom/stepos/motionkit/SurfaceRendererType;", "setRenderer", "(Lcom/stepos/motionkit/SurfaceRendererType;)V", "presentation", "Lcom/stepos/motionkit/SurfacePresentation;", "getPresentation", "()Lcom/stepos/motionkit/SurfacePresentation;", "setPresentation", "(Lcom/stepos/motionkit/SurfacePresentation;)V", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SurfaceConfig {
    private SurfaceRendererType renderer = SurfaceRendererType.AGSL;
    private SurfacePresentation presentation = SurfacePresentation.SURFACE_VIEW;

    public final SurfacePresentation getPresentation() {
        return this.presentation;
    }

    public final SurfaceRendererType getRenderer() {
        return this.renderer;
    }

    public final void setPresentation(SurfacePresentation surfacePresentation) {
        k.f(surfacePresentation, "<set-?>");
        this.presentation = surfacePresentation;
    }

    public final void setRenderer(SurfaceRendererType surfaceRendererType) {
        k.f(surfaceRendererType, "<set-?>");
        this.renderer = surfaceRendererType;
    }
}
