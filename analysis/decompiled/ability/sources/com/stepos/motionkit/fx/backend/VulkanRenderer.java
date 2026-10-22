package com.stepos.motionkit.fx.backend;

import C7.r;
import android.view.Surface;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.motionkit.MKLog;
import com.stepos.motionkit.fx.uniform.UniformBinder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 32\u00020\u0001:\u00013B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ \u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0002H\u0082 ¢\u0006\u0004\b\r\u0010\u000eJ \u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0082 ¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\fH\u0082 ¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u001a\u0010\u0016J\r\u0010\u001b\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u0018J\u000f\u0010\u001d\u001a\u00020\u0012H\u0000¢\u0006\u0004\b\u001c\u0010\u0018J\u001d\u0010\"\u001a\u00020\u00122\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u001eH\u0000¢\u0006\u0004\b \u0010!R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010#R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010$R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010%R\u0016\u0010&\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R0\u0010*\u001a\u0010\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u0012\u0018\u00010(8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/stepos/motionkit/fx/backend/VulkanRenderer;", "", "", "shaderSource", "Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "binder", "Lcom/stepos/motionkit/fx/backend/RenderTarget;", TypedValues.AttributesType.S_TARGET, AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/stepos/motionkit/fx/uniform/UniformBinder;Lcom/stepos/motionkit/fx/backend/RenderTarget;)V", "surface", "spirvSource", "", "nativeInit", "(Ljava/lang/Object;Ljava/lang/String;)J", "handle", "", "time", "LC7/r;", "nativeRenderFrame", "(JF)V", "nativeDestroy", "(J)V", "start", "()V", "elapsedMs", "renderFrame", "stop", "stopAndWait$motionkit_fx_release", "stopAndWait", "Lkotlin/Function0;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "whenStopped$motionkit_fx_release", "(LS7/a;)V", "whenStopped", "Ljava/lang/String;", "Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "Lcom/stepos/motionkit/fx/backend/RenderTarget;", "nativeHandle", "J", "Lkotlin/Function1;", "", "onFailure", "LS7/k;", "getOnFailure$motionkit_fx_release", "()LS7/k;", "setOnFailure$motionkit_fx_release", "(LS7/k;)V", "Lcom/stepos/motionkit/fx/backend/RenderSession;", "session", "Lcom/stepos/motionkit/fx/backend/RenderSession;", "Companion", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class VulkanRenderer {
    private final UniformBinder binder;
    private long nativeHandle;
    private S7.k onFailure;
    private final RenderSession session;
    private final String shaderSource;
    private final RenderTarget target;

    static {
        try {
            System.loadLibrary("motionkit_vulkan");
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    public VulkanRenderer(String shaderSource, UniformBinder binder, RenderTarget target) {
        kotlin.jvm.internal.k.f(shaderSource, "shaderSource");
        kotlin.jvm.internal.k.f(binder, "binder");
        kotlin.jvm.internal.k.f(target, "target");
        this.shaderSource = shaderSource;
        this.binder = binder;
        this.target = target;
        this.session = new RenderSession(new HandlerRenderQueue("VulkanRenderer"), new RenderDriver() { // from class: com.stepos.motionkit.fx.backend.VulkanRenderer$session$1
            @Override // com.stepos.motionkit.fx.backend.RenderDriver
            public void draw(long elapsedMs) {
                this.this$0.binder.resolve(elapsedMs);
                VulkanRenderer vulkanRenderer = this.this$0;
                vulkanRenderer.nativeRenderFrame(vulkanRenderer.nativeHandle, elapsedMs / 1000.0f);
            }

            @Override // com.stepos.motionkit.fx.backend.RenderDriver
            public boolean initialize(S7.a isCancelled) {
                Surface surface;
                kotlin.jvm.internal.k.f(isCancelled, "isCancelled");
                if (((Boolean) isCancelled.invoke()).booleanValue() || (surface = this.this$0.target.getSurface()) == null || !surface.isValid()) {
                    return false;
                }
                VulkanRenderer vulkanRenderer = this.this$0;
                vulkanRenderer.nativeHandle = vulkanRenderer.nativeInit(surface, vulkanRenderer.shaderSource);
                if (this.this$0.nativeHandle != 0) {
                    return !((Boolean) isCancelled.invoke()).booleanValue();
                }
                throw new IllegalStateException("nativeInit failed");
            }

            @Override // com.stepos.motionkit.fx.backend.RenderDriver
            public void release() {
                long j5 = this.this$0.nativeHandle;
                this.this$0.nativeHandle = 0L;
                if (j5 != 0) {
                    this.this$0.nativeDestroy(j5);
                }
            }
        }, new a(this, 2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeDestroy(long handle);

    /* JADX INFO: Access modifiers changed from: private */
    public final native long nativeInit(Object surface, String spirvSource);

    /* JADX INFO: Access modifiers changed from: private */
    public final native void nativeRenderFrame(long handle, float time);

    /* JADX INFO: Access modifiers changed from: private */
    public static final r session$lambda$0(VulkanRenderer vulkanRenderer, Throwable error) {
        kotlin.jvm.internal.k.f(error, "error");
        MKLog.INSTANCE.e("Surface", "Vulkan renderer failed; releasing this effect", error);
        S7.k kVar = vulkanRenderer.onFailure;
        if (kVar != null) {
            kVar.invoke(error);
        }
        return r.f317a;
    }

    /* renamed from: getOnFailure$motionkit_fx_release, reason: from getter */
    public final S7.k getOnFailure() {
        return this.onFailure;
    }

    public final void renderFrame(long elapsedMs) {
        this.session.renderFrame(elapsedMs);
    }

    public final void setOnFailure$motionkit_fx_release(S7.k kVar) {
        this.onFailure = kVar;
    }

    public final void start() {
        this.session.start();
    }

    public final void stop() {
        this.session.stop();
    }

    public final void stopAndWait$motionkit_fx_release() {
        this.session.stopAndWait();
    }

    public final void whenStopped$motionkit_fx_release(S7.a action) {
        kotlin.jvm.internal.k.f(action, "action");
        this.session.whenStopped(action);
    }
}
