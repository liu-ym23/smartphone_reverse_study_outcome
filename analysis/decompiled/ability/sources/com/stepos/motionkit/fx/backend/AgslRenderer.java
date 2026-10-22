package com.stepos.motionkit.fx.backend;

import C7.r;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RuntimeShader;
import android.view.Surface;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import com.stepos.motionkit.MKLog;
import com.stepos.motionkit.fx.uniform.UniformBinder;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u000eJ\r\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0013\u0010\u0010J\u001d\u0010\u0019\u001a\u00020\f2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0015H\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R0\u0010%\u001a\u0010\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\f\u0018\u00010#8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00100¨\u00062"}, d2 = {"Lcom/stepos/motionkit/fx/backend/AgslRenderer;", "", "", AgentBusWakeContract.EXTRA_SOURCE, "Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "binder", "Lcom/stepos/motionkit/fx/backend/RenderTarget;", TypedValues.AttributesType.S_TARGET, AppAgent.CONSTRUCT, "(Ljava/lang/String;Lcom/stepos/motionkit/fx/uniform/UniformBinder;Lcom/stepos/motionkit/fx/backend/RenderTarget;)V", "", "elapsedMs", "LC7/r;", "drawFrame", "(J)V", "start", "()V", "renderFrame", "stop", "stopAndWait$motionkit_fx_release", "stopAndWait", "Lkotlin/Function0;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "whenStopped$motionkit_fx_release", "(LS7/a;)V", "whenStopped", "Ljava/lang/String;", "Lcom/stepos/motionkit/fx/uniform/UniformBinder;", "Lcom/stepos/motionkit/fx/backend/RenderTarget;", "Landroid/graphics/RuntimeShader;", "shader", "Landroid/graphics/RuntimeShader;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "Lkotlin/Function1;", "", "onFailure", "LS7/k;", "getOnFailure$motionkit_fx_release", "()LS7/k;", "setOnFailure$motionkit_fx_release", "(LS7/k;)V", "Lcom/stepos/motionkit/fx/backend/RenderSession;", "session", "Lcom/stepos/motionkit/fx/backend/RenderSession;", "", "hasResolution", "Z", "hasTime", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AgslRenderer {
    private final UniformBinder binder;
    private boolean hasResolution;
    private boolean hasTime;
    private S7.k onFailure;
    private final Paint paint;
    private final RenderSession session;
    private final RuntimeShader shader;
    private final String source;
    private final RenderTarget target;

    public AgslRenderer(String source, UniformBinder binder, RenderTarget target) {
        kotlin.jvm.internal.k.f(source, "source");
        kotlin.jvm.internal.k.f(binder, "binder");
        kotlin.jvm.internal.k.f(target, "target");
        this.source = source;
        this.binder = binder;
        this.target = target;
        RuntimeShader runtimeShader = new RuntimeShader(source);
        this.shader = runtimeShader;
        Paint paint = new Paint();
        paint.setShader(runtimeShader);
        this.paint = paint;
        this.session = new RenderSession(new HandlerRenderQueue("AgslRenderer"), new RenderDriver() { // from class: com.stepos.motionkit.fx.backend.AgslRenderer$session$1
            @Override // com.stepos.motionkit.fx.backend.RenderDriver
            public void draw(long elapsedMs) {
                this.this$0.drawFrame(elapsedMs);
            }

            @Override // com.stepos.motionkit.fx.backend.RenderDriver
            public boolean initialize(S7.a isCancelled) {
                kotlin.jvm.internal.k.f(isCancelled, "isCancelled");
                return !((Boolean) isCancelled.invoke()).booleanValue();
            }

            @Override // com.stepos.motionkit.fx.backend.RenderDriver
            public void release() {
            }
        }, new a(this, 0));
        this.hasResolution = true;
        this.hasTime = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawFrame(long elapsedMs) {
        Canvas canvasLockHardwareCanvas;
        Surface surface = this.target.getSurface();
        if (surface == null || !surface.isValid() || (canvasLockHardwareCanvas = surface.lockHardwareCanvas()) == null) {
            return;
        }
        try {
            canvasLockHardwareCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            this.binder.resolve(elapsedMs);
            this.binder.applyTo(this.shader);
            if (this.hasResolution) {
                try {
                    this.shader.setFloatUniform("iResolution", canvasLockHardwareCanvas.getWidth(), canvasLockHardwareCanvas.getHeight());
                } catch (IllegalArgumentException unused) {
                    this.hasResolution = false;
                }
            }
            if (this.hasTime) {
                try {
                    this.shader.setFloatUniform("iTime", elapsedMs / 1000.0f);
                } catch (IllegalArgumentException unused2) {
                    this.hasTime = false;
                }
            }
            canvasLockHardwareCanvas.drawRect(0.0f, 0.0f, canvasLockHardwareCanvas.getWidth(), canvasLockHardwareCanvas.getHeight(), this.paint);
            surface.unlockCanvasAndPost(canvasLockHardwareCanvas);
        } catch (Throwable th) {
            surface.unlockCanvasAndPost(canvasLockHardwareCanvas);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r session$lambda$1(AgslRenderer agslRenderer, Throwable error) {
        kotlin.jvm.internal.k.f(error, "error");
        MKLog.INSTANCE.e("Surface", "AGSL renderer failed; releasing this effect", error);
        S7.k kVar = agslRenderer.onFailure;
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
