package com.stepos.core.ability.speech;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class TtsStreamCallbackQueue {
    private final Object lock = new Object();
    private final mb.k<zb.a<lb.n>> queue = new mb.k<>();
    private final AtomicBoolean draining = new AtomicBoolean(false);

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.stepos.core.ability.speech.TtsStreamCallbackQueue$enqueue$2, reason: invalid class name */
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements zb.a<lb.n> {
        public AnonymousClass2(Object obj) {
            super(0, obj, TtsStreamCallbackQueue.class, "drainLoop", "drainLoop()V", 0);
        }

        @Override // zb.a
        public /* bridge */ /* synthetic */ lb.n invoke() {
            invoke2();
            return lb.n.f10413a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((TtsStreamCallbackQueue) this.receiver).drainLoop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drainLoop() {
        zb.a<lb.n> aVarRemoveFirst;
        while (true) {
            try {
                synchronized (this.lock) {
                    aVarRemoveFirst = this.queue.isEmpty() ? null : this.queue.removeFirst();
                }
                if (aVarRemoveFirst == null) {
                    break;
                }
                try {
                    aVarRemoveFirst.invoke();
                } catch (Throwable th) {
                    kotlin.c.a(th);
                }
            } catch (Throwable th2) {
                this.draining.set(false);
                synchronized (this.lock) {
                    try {
                        if (!this.queue.isEmpty() && this.draining.compareAndSet(false, true)) {
                            TtsStreamCallbackExecutor.INSTANCE.execute(new TtsStreamCallbackQueue$drainLoop$1$1(this));
                        }
                        lb.n nVar = lb.n.f10413a;
                        throw th2;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
            }
        }
        this.draining.set(false);
        synchronized (this.lock) {
            try {
                if (!this.queue.isEmpty() && this.draining.compareAndSet(false, true)) {
                    TtsStreamCallbackExecutor.INSTANCE.execute(new TtsStreamCallbackQueue$drainLoop$1$1(this));
                }
                lb.n nVar2 = lb.n.f10413a;
            } finally {
            }
        }
    }

    public final void enqueue(zb.a<lb.n> block) {
        kotlin.jvm.internal.g.f(block, "block");
        synchronized (this.lock) {
            this.queue.addLast(block);
            lb.n nVar = lb.n.f10413a;
        }
        if (this.draining.compareAndSet(false, true)) {
            TtsStreamCallbackExecutor.INSTANCE.execute(new AnonymousClass2(this));
        }
    }
}
