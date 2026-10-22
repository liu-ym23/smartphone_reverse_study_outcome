package io.ktor.server.engine;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import p9.InterfaceC5063a;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lio/ktor/server/engine/ShutdownHook;", "Ljava/lang/Thread;", "Lkotlin/Function0;", "LY8/t;", "stopFunction", "<init>", "(Lp9/a;)V", "run", "()V", "Lp9/a;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "shouldStop", "Ljava/util/concurrent/atomic/AtomicBoolean;", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
final class ShutdownHook extends Thread {
    private final AtomicBoolean shouldStop;
    private final InterfaceC5063a<Y8.t> stopFunction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShutdownHook(InterfaceC5063a<Y8.t> stopFunction) {
        super("KtorShutdownHook");
        kotlin.jvm.internal.p.i(stopFunction, "stopFunction");
        this.stopFunction = stopFunction;
        this.shouldStop = new AtomicBoolean(true);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.shouldStop.compareAndSet(true, false)) {
            this.stopFunction.invoke();
        }
    }
}
