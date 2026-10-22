package com.stepos.motionkit.fx.backend;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.autofill.HintConstants;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\u00128\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/motionkit/fx/backend/HandlerRenderQueue;", "Lcom/stepos/motionkit/fx/backend/RenderQueue;", "", HintConstants.AUTOFILL_HINT_NAME, AppAgent.CONSTRUCT, "(Ljava/lang/String;)V", "Ljava/lang/Runnable;", "task", "", "post", "(Ljava/lang/Runnable;)Z", "LC7/r;", "remove", "(Ljava/lang/Runnable;)V", "isCurrentThread", "()Z", "quit", "()V", "Landroid/os/HandlerThread;", "thread", "Landroid/os/HandlerThread;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HandlerRenderQueue implements RenderQueue {
    private final Handler handler;
    private final HandlerThread thread;

    public HandlerRenderQueue(String name) {
        kotlin.jvm.internal.k.f(name, "name");
        HandlerThread handlerThread = new HandlerThread(name);
        handlerThread.start();
        this.thread = handlerThread;
        this.handler = new Handler(handlerThread.getLooper());
    }

    @Override // com.stepos.motionkit.fx.backend.RenderQueue
    public boolean isCurrentThread() {
        return Looper.myLooper() == this.thread.getLooper();
    }

    @Override // com.stepos.motionkit.fx.backend.RenderQueue
    public boolean post(Runnable task) {
        kotlin.jvm.internal.k.f(task, "task");
        return this.handler.post(task);
    }

    @Override // com.stepos.motionkit.fx.backend.RenderQueue
    public void quit() {
        this.thread.quitSafely();
    }

    @Override // com.stepos.motionkit.fx.backend.RenderQueue
    public void remove(Runnable task) {
        kotlin.jvm.internal.k.f(task, "task");
        this.handler.removeCallbacks(task);
    }
}
