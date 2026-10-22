package com.stepos.motionkit.fx.backend;

import C7.r;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import stepai.android.llm.base.twoway.FlowType;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u000e\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0082\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0017\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0011J\u001b\u0010\u0018\u001a\u00020\b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\f¢\u0006\u0004\b\u0018\u0010\u000fJ\r\u0010\u0019\u001a\u00020\b¢\u0006\u0004\b\u0019\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010!R\u0014\u0010'\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010+R\u0016\u0010-\u001a\u00020)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010+R\u0018\u0010.\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00101\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00102R\u0014\u00104\u001a\u0002008\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00102¨\u00065"}, d2 = {"Lcom/stepos/motionkit/fx/backend/RenderSession;", "", "Lcom/stepos/motionkit/fx/backend/RenderQueue;", "queue", "Lcom/stepos/motionkit/fx/backend/RenderDriver;", "driver", "Lkotlin/Function1;", "", "LC7/r;", "onFailure", AppAgent.CONSTRUCT, "(Lcom/stepos/motionkit/fx/backend/RenderQueue;Lcom/stepos/motionkit/fx/backend/RenderDriver;LS7/k;)V", "Lkotlin/Function0;", GuiTaskProgressKt.GuiTaskProgress_KEY_ACTION, "runDriver", "(LS7/a;)V", "cleanup", "()V", "start", "", "elapsedMs", "renderFrame", "(J)V", "stop", "whenStopped", "stopAndWait", "Lcom/stepos/motionkit/fx/backend/RenderQueue;", "Lcom/stepos/motionkit/fx/backend/RenderDriver;", "LS7/k;", "admission", "Ljava/lang/Object;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cancelled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/CompletableFuture;", FlowType.COMPLETED, "Ljava/util/concurrent/CompletableFuture;", "framePending", "Ljava/util/concurrent/atomic/AtomicLong;", "frameTime", "Ljava/util/concurrent/atomic/AtomicLong;", "", "started", "Z", "ready", "cleaned", "failure", "Ljava/lang/Throwable;", "Ljava/lang/Runnable;", "initTask", "Ljava/lang/Runnable;", "frameTask", "cleanupTask", "motionkit-fx_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RenderSession {
    private final Object admission;
    private final AtomicBoolean cancelled;
    private boolean cleaned;
    private final Runnable cleanupTask;
    private final CompletableFuture<r> completed;
    private final RenderDriver driver;
    private Throwable failure;
    private final AtomicBoolean framePending;
    private final Runnable frameTask;
    private final AtomicLong frameTime;
    private final Runnable initTask;
    private final S7.k onFailure;
    private final RenderQueue queue;
    private boolean ready;
    private boolean started;

    public RenderSession(RenderQueue queue, RenderDriver driver, S7.k onFailure) {
        kotlin.jvm.internal.k.f(queue, "queue");
        kotlin.jvm.internal.k.f(driver, "driver");
        kotlin.jvm.internal.k.f(onFailure, "onFailure");
        this.queue = queue;
        this.driver = driver;
        this.onFailure = onFailure;
        this.admission = new Object();
        final int i = 0;
        this.cancelled = new AtomicBoolean(false);
        this.completed = new CompletableFuture<>();
        this.framePending = new AtomicBoolean(false);
        this.frameTime = new AtomicLong();
        this.initTask = new Runnable(this) { // from class: com.stepos.motionkit.fx.backend.d
            public final /* synthetic */ RenderSession b;

            {
                this.b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i6 = i;
                RenderSession renderSession = this.b;
                switch (i6) {
                    case 0:
                        RenderSession.initTask$lambda$1(renderSession);
                        break;
                    case 1:
                        RenderSession.frameTask$lambda$3(renderSession);
                        break;
                    default:
                        renderSession.cleanup();
                        break;
                }
            }
        };
        final int i6 = 1;
        this.frameTask = new Runnable(this) { // from class: com.stepos.motionkit.fx.backend.d
            public final /* synthetic */ RenderSession b;

            {
                this.b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i62 = i6;
                RenderSession renderSession = this.b;
                switch (i62) {
                    case 0:
                        RenderSession.initTask$lambda$1(renderSession);
                        break;
                    case 1:
                        RenderSession.frameTask$lambda$3(renderSession);
                        break;
                    default:
                        renderSession.cleanup();
                        break;
                }
            }
        };
        final int i10 = 2;
        this.cleanupTask = new Runnable(this) { // from class: com.stepos.motionkit.fx.backend.d
            public final /* synthetic */ RenderSession b;

            {
                this.b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i62 = i10;
                RenderSession renderSession = this.b;
                switch (i62) {
                    case 0:
                        RenderSession.initTask$lambda$1(renderSession);
                        break;
                    case 1:
                        RenderSession.frameTask$lambda$3(renderSession);
                        break;
                    default:
                        renderSession.cleanup();
                        break;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cleanup() {
        r rVar = r.f317a;
        if (this.cleaned) {
            return;
        }
        this.cleaned = true;
        this.ready = false;
        try {
            try {
                try {
                    this.driver.release();
                    try {
                        Throwable th = this.failure;
                        if (th != null) {
                            this.onFailure.invoke(th);
                        }
                    } finally {
                    }
                } catch (Exception e) {
                    Throwable th2 = this.failure;
                    if (th2 != null) {
                        S0.b.e0(th2, e);
                    } else {
                        this.failure = e;
                    }
                    try {
                        Throwable th3 = this.failure;
                        if (th3 != null) {
                            this.onFailure.invoke(th3);
                        }
                    } finally {
                    }
                }
            } catch (LinkageError e6) {
                Throwable th4 = this.failure;
                if (th4 != null) {
                    S0.b.e0(th4, e6);
                } else {
                    this.failure = e6;
                }
                try {
                    Throwable th5 = this.failure;
                    if (th5 != null) {
                        this.onFailure.invoke(th5);
                    }
                } finally {
                }
            }
        } catch (Throwable th6) {
            try {
                Throwable th7 = this.failure;
                if (th7 != null) {
                    this.onFailure.invoke(th7);
                }
                throw th6;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void frameTask$lambda$3(RenderSession renderSession) {
        renderSession.framePending.set(false);
        if (renderSession.cancelled.get() || !renderSession.ready) {
            return;
        }
        try {
            renderSession.driver.draw(renderSession.frameTime.get());
        } catch (Exception e) {
            renderSession.failure = e;
            renderSession.stop();
        } catch (LinkageError e6) {
            renderSession.failure = e6;
            renderSession.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initTask$lambda$1(RenderSession renderSession) {
        if (renderSession.cancelled.get()) {
            return;
        }
        try {
            boolean z10 = renderSession.driver.initialize(new RenderSession$initTask$1$1$1(renderSession.cancelled)) && !renderSession.cancelled.get();
            renderSession.ready = z10;
            if (z10) {
                return;
            }
            if (!renderSession.cancelled.get()) {
                renderSession.failure = new IllegalStateException("Surface unavailable during renderer initialization");
            }
            renderSession.stop();
        } catch (Exception e) {
            renderSession.failure = e;
            renderSession.stop();
        } catch (LinkageError e6) {
            renderSession.failure = e6;
            renderSession.stop();
        }
    }

    private final void runDriver(S7.a action) {
        try {
            action.invoke();
        } catch (Exception e) {
            this.failure = e;
            stop();
        } catch (LinkageError e6) {
            this.failure = e6;
            stop();
        }
    }

    public final void renderFrame(long elapsedMs) {
        synchronized (this.admission) {
            if (!this.cancelled.get() && this.started) {
                this.frameTime.set(elapsedMs);
                if (this.framePending.compareAndSet(false, true) && !this.queue.post(this.frameTask)) {
                    this.framePending.set(false);
                }
            }
        }
    }

    public final void start() {
        synchronized (this.admission) {
            if (!this.started && !this.cancelled.get()) {
                this.started = true;
                if (!this.queue.post(this.initTask)) {
                    throw new IllegalStateException("Render queue rejected initialization");
                }
            }
        }
    }

    public final void stop() {
        synchronized (this.admission) {
            if (this.cancelled.compareAndSet(false, true)) {
                this.queue.remove(this.initTask);
                this.queue.remove(this.frameTask);
                this.framePending.set(false);
                if (!this.queue.post(this.cleanupTask)) {
                    throw new IllegalStateException("Render queue rejected teardown");
                }
            }
        }
    }

    public final void stopAndWait() {
        if (this.queue.isCurrentThread()) {
            throw new IllegalStateException("A renderer cannot wait for its own teardown");
        }
        stop();
        this.completed.join();
    }

    public final void whenStopped(S7.a action) {
        kotlin.jvm.internal.k.f(action, "action");
        this.completed.thenRun((Runnable) new i(action, 2));
    }
}
