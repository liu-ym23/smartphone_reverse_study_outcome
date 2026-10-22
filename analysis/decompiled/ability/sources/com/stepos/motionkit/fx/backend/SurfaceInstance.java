package com.stepos.motionkit.fx.backend;

import C7.r;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.Surface;
import android.view.ViewGroup;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.motionkit.MKLog;
import com.stepos.motionkit.fx.uniform.UniformBinder;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\r¢\u0006\u0004\b\u0013\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0014\u0010\u0012J\u0015\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\r¢\u0006\u0004\b\u0019\u0010\u0012J\u000f\u0010\u001a\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001a\u0010\u0012R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001eR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u001fR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010 R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00063"}, d2 = {"Lcom/stepos/motionkit/fx/backend/SurfaceInstance;", "Lcom/stepos/motionkit/fx/backend/SurfaceLifecycleListener;", "Lcom/stepos/motionkit/fx/backend/FxRenderSurface;", "renderSurface", "Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "binder", "", "shaderSource", "Lcom/stepos/motionkit/fx/backend/SurfaceRenderer;", "rendererType", "Landroid/view/ViewGroup;", "parent", "Lkotlin/Function0;", "LC7/r;", "onFailure", AppAgent.CONSTRUCT, "(Lcom/stepos/motionkit/fx/backend/FxRenderSurface;Lcom/stepos/motionkit/fx/uniform/UniformBinder;Ljava/lang/String;Lcom/stepos/motionkit/fx/backend/SurfaceRenderer;Landroid/view/ViewGroup;LS7/a;)V", "clearRenderers", "()V", "attach", "onAvailable", "", "elapsedMs", "renderFrame", "(J)V", "release", "onDestroyed", "Lcom/stepos/motionkit/fx/backend/FxRenderSurface;", "Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "Ljava/lang/String;", "Lcom/stepos/motionkit/fx/backend/SurfaceRenderer;", "Landroid/view/ViewGroup;", "LS7/a;", "Landroid/os/Handler;", "owner", "Landroid/os/Handler;", "Lcom/stepos/motionkit/fx/backend/SurfaceGeneration;", "lifetime", "Lcom/stepos/motionkit/fx/backend/SurfaceGeneration;", "Lcom/stepos/motionkit/fx/backend/AgslRenderer;", "agslRenderer", "Lcom/stepos/motionkit/fx/backend/AgslRenderer;", "Lcom/stepos/motionkit/fx/backend/GlesRenderer;", "glesRenderer", "Lcom/stepos/motionkit/fx/backend/GlesRenderer;", "Lcom/stepos/motionkit/fx/backend/VulkanRenderer;", "vulkanRenderer", "Lcom/stepos/motionkit/fx/backend/VulkanRenderer;", "Ljava/lang/Runnable;", "attachTask", "Ljava/lang/Runnable;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
final class SurfaceInstance implements SurfaceLifecycleListener {
    private AgslRenderer agslRenderer;
    private final Runnable attachTask;
    private final UniformBinder binder;
    private GlesRenderer glesRenderer;
    private final SurfaceGeneration lifetime;
    private final S7.a onFailure;
    private final Handler owner;
    private final ViewGroup parent;
    private final FxRenderSurface renderSurface;
    private final SurfaceRenderer rendererType;
    private final String shaderSource;
    private VulkanRenderer vulkanRenderer;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SurfaceRenderer.values().length];
            try {
                iArr[SurfaceRenderer.AGSL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SurfaceRenderer.GLES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SurfaceRenderer.VULKAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SurfaceInstance(FxRenderSurface renderSurface, UniformBinder binder, String shaderSource, SurfaceRenderer rendererType, ViewGroup parent, S7.a onFailure) {
        kotlin.jvm.internal.k.f(renderSurface, "renderSurface");
        kotlin.jvm.internal.k.f(binder, "binder");
        kotlin.jvm.internal.k.f(shaderSource, "shaderSource");
        kotlin.jvm.internal.k.f(rendererType, "rendererType");
        kotlin.jvm.internal.k.f(parent, "parent");
        kotlin.jvm.internal.k.f(onFailure, "onFailure");
        this.renderSurface = renderSurface;
        this.binder = binder;
        this.shaderSource = shaderSource;
        this.rendererType = rendererType;
        this.parent = parent;
        this.onFailure = onFailure;
        this.owner = new Handler(Looper.getMainLooper());
        this.lifetime = new SurfaceGeneration();
        this.attachTask = new i(this, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void attachTask$lambda$0(SurfaceInstance surfaceInstance) {
        if (surfaceInstance.lifetime.getReleased()) {
            return;
        }
        surfaceInstance.renderSurface.setRenderScale(0.5f);
        surfaceInstance.renderSurface.attachTo(surfaceInstance.parent);
    }

    private final void clearRenderers() {
        this.agslRenderer = null;
        this.glesRenderer = null;
        this.vulkanRenderer = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAvailable$lambda$1(SurfaceInstance surfaceInstance, long j5) {
        if (surfaceInstance.lifetime.isCurrent(j5)) {
            surfaceInstance.onFailure.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r onAvailable$lambda$3(SurfaceInstance surfaceInstance, long j5, Throwable it) {
        kotlin.jvm.internal.k.f(it, "it");
        surfaceInstance.owner.post(new j(surfaceInstance, j5, 1));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onAvailable$lambda$3$lambda$2(SurfaceInstance surfaceInstance, long j5) {
        if (surfaceInstance.lifetime.isCurrent(j5)) {
            surfaceInstance.onFailure.invoke();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r release$lambda$5(SurfaceInstance surfaceInstance) {
        surfaceInstance.owner.post(new i(surfaceInstance, 0));
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void release$lambda$5$lambda$4(SurfaceInstance surfaceInstance) {
        SurfaceLifecycleListenerKt.setLifecycleListener(surfaceInstance.renderSurface, null);
        surfaceInstance.parent.removeView(surfaceInstance.renderSurface.asView());
        surfaceInstance.clearRenderers();
    }

    public final void attach() {
        SurfaceLifecycleListenerKt.setLifecycleListener(this.renderSurface, this);
        this.parent.post(this.attachTask);
    }

    @Override // com.stepos.motionkit.fx.backend.SurfaceLifecycleListener
    public void onAvailable() {
        Long lAvailable = this.lifetime.available();
        if (lAvailable != null) {
            final long jLongValue = lAvailable.longValue();
            final Surface surface = this.renderSurface.getSurface();
            if (surface == null) {
                this.owner.post(new j(this, jLongValue, 0));
                return;
            }
            final int renderWidth = this.renderSurface.getRenderWidth();
            final int renderHeight = this.renderSurface.getRenderHeight();
            RenderTarget renderTarget = new RenderTarget(surface, renderWidth, renderHeight) { // from class: com.stepos.motionkit.fx.backend.SurfaceInstance$onAvailable$target$1
                private final int renderHeight;
                private final int renderWidth;
                private final Surface surface;

                {
                    this.surface = surface;
                    this.renderWidth = renderWidth;
                    this.renderHeight = renderHeight;
                }

                @Override // com.stepos.motionkit.fx.backend.RenderTarget
                public int getRenderHeight() {
                    return this.renderHeight;
                }

                @Override // com.stepos.motionkit.fx.backend.RenderTarget
                public int getRenderWidth() {
                    return this.renderWidth;
                }

                @Override // com.stepos.motionkit.fx.backend.RenderTarget
                public Surface getSurface() {
                    return this.surface;
                }
            };
            S7.k kVar = new S7.k() { // from class: com.stepos.motionkit.fx.backend.k
                @Override // S7.k
                public final Object invoke(Object obj) {
                    return SurfaceInstance.onAvailable$lambda$3(this.f3856a, jLongValue, (Throwable) obj);
                }
            };
            try {
                int i = WhenMappings.$EnumSwitchMapping$0[this.rendererType.ordinal()];
                if (i == 1) {
                    AgslRenderer agslRenderer = new AgslRenderer(this.shaderSource, this.binder, renderTarget);
                    this.agslRenderer = agslRenderer;
                    agslRenderer.setOnFailure$motionkit_fx_release(kVar);
                    agslRenderer.start();
                    return;
                }
                if (i == 2) {
                    GlesRenderer glesRenderer = new GlesRenderer(this.shaderSource, this.binder, renderTarget);
                    this.glesRenderer = glesRenderer;
                    glesRenderer.setOnFailure$motionkit_fx_release(kVar);
                    glesRenderer.start();
                    return;
                }
                if (i != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                VulkanRenderer vulkanRenderer = new VulkanRenderer(this.shaderSource, this.binder, renderTarget);
                this.vulkanRenderer = vulkanRenderer;
                vulkanRenderer.setOnFailure$motionkit_fx_release(kVar);
                vulkanRenderer.start();
            } catch (Exception e) {
                MKLog.INSTANCE.e("Surface", "SurfaceBackend initRenderer failed: " + e.getMessage(), e);
                kVar.invoke(e);
            }
        }
    }

    @Override // com.stepos.motionkit.fx.backend.SurfaceLifecycleListener
    public void onDestroyed() {
        this.lifetime.lost();
        long jUptimeMillis = SystemClock.uptimeMillis();
        AgslRenderer agslRenderer = this.agslRenderer;
        if (agslRenderer != null) {
            agslRenderer.stopAndWait$motionkit_fx_release();
        }
        GlesRenderer glesRenderer = this.glesRenderer;
        if (glesRenderer != null) {
            glesRenderer.stopAndWait$motionkit_fx_release();
        }
        VulkanRenderer vulkanRenderer = this.vulkanRenderer;
        if (vulkanRenderer != null) {
            vulkanRenderer.stopAndWait$motionkit_fx_release();
        }
        long jUptimeMillis2 = SystemClock.uptimeMillis() - jUptimeMillis;
        if (jUptimeMillis2 > 100) {
            MKLog.w$default(MKLog.INSTANCE, "Surface", androidx.compose.foundation.b.q(jUptimeMillis2, "Waiting for renderer teardown took ", "ms"), null, 4, null);
        }
        clearRenderers();
    }

    public final void release() {
        if (this.lifetime.release()) {
            this.parent.removeCallbacks(this.attachTask);
            AgslRenderer agslRenderer = this.agslRenderer;
            if (agslRenderer != null) {
                agslRenderer.stop();
            }
            GlesRenderer glesRenderer = this.glesRenderer;
            if (glesRenderer != null) {
                glesRenderer.stop();
            }
            VulkanRenderer vulkanRenderer = this.vulkanRenderer;
            if (vulkanRenderer != null) {
                vulkanRenderer.stop();
            }
            l lVar = new l(this, 0);
            AgslRenderer agslRenderer2 = this.agslRenderer;
            if (agslRenderer2 != null) {
                agslRenderer2.whenStopped$motionkit_fx_release(lVar);
                return;
            }
            GlesRenderer glesRenderer2 = this.glesRenderer;
            if (glesRenderer2 != null) {
                glesRenderer2.whenStopped$motionkit_fx_release(lVar);
                return;
            }
            VulkanRenderer vulkanRenderer2 = this.vulkanRenderer;
            if (vulkanRenderer2 != null) {
                vulkanRenderer2.whenStopped$motionkit_fx_release(lVar);
            } else {
                lVar.invoke();
            }
        }
    }

    public final void renderFrame(long elapsedMs) {
        if (this.lifetime.getReleased()) {
            return;
        }
        AgslRenderer agslRenderer = this.agslRenderer;
        if (agslRenderer != null) {
            agslRenderer.renderFrame(elapsedMs);
        }
        GlesRenderer glesRenderer = this.glesRenderer;
        if (glesRenderer != null) {
            glesRenderer.renderFrame(elapsedMs);
        }
        VulkanRenderer vulkanRenderer = this.vulkanRenderer;
        if (vulkanRenderer != null) {
            vulkanRenderer.renderFrame(elapsedMs);
        }
    }
}
