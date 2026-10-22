package com.stepos.motionkit;

import S7.a;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\b\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u0003J1\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010\"\u001a\u00020!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010)\u001a\u00020(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R*\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lcom/stepos/motionkit/FxConfig;", "", AppAgent.CONSTRUCT, "()V", "Lkotlin/Function1;", "Lcom/stepos/motionkit/SurfaceConfig;", "LC7/r;", "block", "surface", "(LS7/k;)V", "sf", "", "durationMs", "Lcom/stepos/motionkit/EndBehavior;", "endBehavior", "Lkotlin/Function0;", "onComplete", "once", "(JLcom/stepos/motionkit/EndBehavior;LS7/a;)V", "Lcom/stepos/motionkit/BackendHint;", "backend", "Lcom/stepos/motionkit/BackendHint;", "getBackend", "()Lcom/stepos/motionkit/BackendHint;", "setBackend", "(Lcom/stepos/motionkit/BackendHint;)V", "Lcom/stepos/motionkit/SurfaceRendererType;", "surfaceRenderer", "Lcom/stepos/motionkit/SurfaceRendererType;", "getSurfaceRenderer", "()Lcom/stepos/motionkit/SurfaceRendererType;", "setSurfaceRenderer", "(Lcom/stepos/motionkit/SurfaceRendererType;)V", "Lcom/stepos/motionkit/SurfacePresentation;", "surfacePresentation", "Lcom/stepos/motionkit/SurfacePresentation;", "getSurfacePresentation", "()Lcom/stepos/motionkit/SurfacePresentation;", "setSurfacePresentation", "(Lcom/stepos/motionkit/SurfacePresentation;)V", "Lcom/stepos/motionkit/PlayMode;", "playMode", "Lcom/stepos/motionkit/PlayMode;", "getPlayMode", "()Lcom/stepos/motionkit/PlayMode;", "setPlayMode", "(Lcom/stepos/motionkit/PlayMode;)V", "J", "getDurationMs", "()J", "setDurationMs", "(J)V", "Lcom/stepos/motionkit/EndBehavior;", "getEndBehavior", "()Lcom/stepos/motionkit/EndBehavior;", "setEndBehavior", "(Lcom/stepos/motionkit/EndBehavior;)V", "LS7/a;", "getOnComplete", "()LS7/a;", "setOnComplete", "(LS7/a;)V", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FxConfig {
    private long durationMs;
    private a onComplete;
    private BackendHint backend = BackendHint.AUTO;
    private SurfaceRendererType surfaceRenderer = SurfaceRendererType.AGSL;
    private SurfacePresentation surfacePresentation = SurfacePresentation.SURFACE_VIEW;
    private PlayMode playMode = PlayMode.LOOP;
    private EndBehavior endBehavior = EndBehavior.FREEZE;

    public static /* synthetic */ void once$default(FxConfig fxConfig, long j5, EndBehavior endBehavior, a aVar, int i, Object obj) {
        if ((i & 2) != 0) {
            endBehavior = EndBehavior.FREEZE;
        }
        if ((i & 4) != 0) {
            aVar = null;
        }
        fxConfig.once(j5, endBehavior, aVar);
    }

    public final BackendHint getBackend() {
        return this.backend;
    }

    public final long getDurationMs() {
        return this.durationMs;
    }

    public final EndBehavior getEndBehavior() {
        return this.endBehavior;
    }

    public final a getOnComplete() {
        return this.onComplete;
    }

    public final PlayMode getPlayMode() {
        return this.playMode;
    }

    public final SurfacePresentation getSurfacePresentation() {
        return this.surfacePresentation;
    }

    public final SurfaceRendererType getSurfaceRenderer() {
        return this.surfaceRenderer;
    }

    public final void once(long durationMs, EndBehavior endBehavior, a onComplete) {
        k.f(endBehavior, "endBehavior");
        this.playMode = PlayMode.ONCE;
        this.durationMs = durationMs;
        this.endBehavior = endBehavior;
        this.onComplete = onComplete;
    }

    public final void setBackend(BackendHint backendHint) {
        k.f(backendHint, "<set-?>");
        this.backend = backendHint;
    }

    public final void setDurationMs(long j5) {
        this.durationMs = j5;
    }

    public final void setEndBehavior(EndBehavior endBehavior) {
        k.f(endBehavior, "<set-?>");
        this.endBehavior = endBehavior;
    }

    public final void setOnComplete(a aVar) {
        this.onComplete = aVar;
    }

    public final void setPlayMode(PlayMode playMode) {
        k.f(playMode, "<set-?>");
        this.playMode = playMode;
    }

    public final void setSurfacePresentation(SurfacePresentation surfacePresentation) {
        k.f(surfacePresentation, "<set-?>");
        this.surfacePresentation = surfacePresentation;
    }

    public final void setSurfaceRenderer(SurfaceRendererType surfaceRendererType) {
        k.f(surfaceRendererType, "<set-?>");
        this.surfaceRenderer = surfaceRendererType;
    }

    public final void sf() {
        this.backend = BackendHint.SF;
    }

    public final void surface(S7.k block) {
        k.f(block, "block");
        this.backend = BackendHint.SURFACE;
        SurfaceConfig surfaceConfig = new SurfaceConfig();
        block.invoke(surfaceConfig);
        this.surfaceRenderer = surfaceConfig.getRenderer();
        this.surfacePresentation = surfaceConfig.getPresentation();
    }
}
