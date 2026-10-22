package com.stepos.motionkit;

import S7.k;
import android.view.Choreographer;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import g1.AbstractC1451a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006*\u0001\u001d\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J!\u0010\t\u001a\u00020\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b\u000b\u0010\u0003J\r\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u0003J\r\u0010\r\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u0003R$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/stepos/motionkit/FrameLoop;", "", AppAgent.CONSTRUCT, "()V", "LC7/r;", "scheduleNext", "Lkotlin/Function1;", "", "onFrame", "start", "(LS7/k;)V", "pause", "resume", "stop", "callback", "LS7/k;", "", "running", "Z", "", "lastFrameTimeNanos", "J", "", "targetFps", "I", "getTargetFps", "()I", "setTargetFps", "(I)V", "com/stepos/motionkit/FrameLoop$frameCallback$1", "frameCallback", "Lcom/stepos/motionkit/FrameLoop$frameCallback$1;", "isRunning", "()Z", "motionkit-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class FrameLoop {
    private k callback;
    private final FrameLoop$frameCallback$1 frameCallback = new Choreographer.FrameCallback() { // from class: com.stepos.motionkit.FrameLoop$frameCallback$1
        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long frameTimeNanos) {
            if (this.this$0.running) {
                float fT = this.this$0.lastFrameTimeNanos == 0 ? 0.016f : AbstractC1451a.t((frameTimeNanos - this.this$0.lastFrameTimeNanos) / 1.0E9f, 0.0f, 0.1f);
                this.this$0.lastFrameTimeNanos = frameTimeNanos;
                k kVar = this.this$0.callback;
                if (kVar != null) {
                    kVar.invoke(Float.valueOf(fT));
                }
                this.this$0.scheduleNext();
            }
        }
    };
    private long lastFrameTimeNanos;
    private boolean running;
    private volatile int targetFps;

    /* JADX INFO: Access modifiers changed from: private */
    public final void scheduleNext() {
        int i = this.targetFps;
        if (i <= 0) {
            Choreographer.getInstance().postFrameCallback(this.frameCallback);
            return;
        }
        long j5 = 1000 / i;
        if (j5 < 1) {
            j5 = 1;
        }
        Choreographer.getInstance().postFrameCallbackDelayed(this.frameCallback, j5);
    }

    public final int getTargetFps() {
        return this.targetFps;
    }

    /* renamed from: isRunning, reason: from getter */
    public final boolean getRunning() {
        return this.running;
    }

    public final void pause() {
        this.running = false;
        Choreographer.getInstance().removeFrameCallback(this.frameCallback);
    }

    public final void resume() {
        if (this.running) {
            return;
        }
        this.running = true;
        this.lastFrameTimeNanos = 0L;
        Choreographer.getInstance().postFrameCallback(this.frameCallback);
    }

    public final void setTargetFps(int i) {
        this.targetFps = i;
    }

    public final void start(k onFrame) {
        kotlin.jvm.internal.k.f(onFrame, "onFrame");
        this.callback = onFrame;
        resume();
    }

    public final void stop() {
        pause();
        this.callback = null;
    }
}
