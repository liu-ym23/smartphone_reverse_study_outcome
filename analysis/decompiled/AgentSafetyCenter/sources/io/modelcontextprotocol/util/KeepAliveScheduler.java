package io.modelcontextprotocol.util;

import b8.g0;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpSession;
import io.modelcontextprotocol.spec.h;
import java.lang.invoke.VarHandle;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import od.f;
import qd.c;
import rd.b;
import rd.d;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class KeepAliveScheduler {
    private Disposable currentSubscription;
    private final Duration initialDelay;
    private final Duration interval;
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    private final Supplier<Flux<McpSession>> mcpSessions;
    private final Scheduler scheduler;
    private static final b logger = d.b(KeepAliveScheduler.class);
    private static final TypeRef<Object> OBJECT_TYPE_REF = new TypeRef<Object>() { // from class: io.modelcontextprotocol.util.KeepAliveScheduler.1
    };

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class Builder {
        private Supplier<Flux<McpSession>> mcpSessions;
        private Scheduler scheduler = Schedulers.boundedElastic();
        private Duration initialDelay = Duration.ofSeconds(0);
        private Duration interval = Duration.ofSeconds(30);

        public Builder(Supplier<Flux<McpSession>> supplier) {
            Assert.notNull(supplier, "McpSessions supplier must not be null");
            this.mcpSessions = supplier;
        }

        public KeepAliveScheduler build() {
            return new KeepAliveScheduler(this.scheduler, this.initialDelay, this.interval, this.mcpSessions);
        }

        public Builder initialDelay(Duration duration) {
            Assert.notNull(duration, "Initial delay must not be null");
            this.initialDelay = duration;
            return this;
        }

        public Builder interval(Duration duration) {
            Assert.notNull(duration, "Interval must not be null");
            this.interval = duration;
            return this;
        }

        public Builder scheduler(Scheduler scheduler) {
            Assert.notNull(scheduler, "Scheduler must not be null");
            this.scheduler = scheduler;
            return this;
        }
    }

    public KeepAliveScheduler(Scheduler scheduler, Duration duration, Duration duration2, Supplier<Flux<McpSession>> supplier) {
        this.scheduler = scheduler;
        this.initialDelay = duration;
        this.interval = duration2;
        this.mcpSessions = supplier;
    }

    public static Builder builder(Supplier<Flux<McpSession>> supplier) {
        return new Builder(supplier);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$start$0(McpSession mcpSession, Throwable th) {
        logger.c("Failed to send keep-alive ping to session {}: {}", mcpSession, th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c lambda$start$1(McpSession mcpSession) {
        Mono monoSendRequest = mcpSession.sendRequest(McpSchema.METHOD_PING, null, OBJECT_TYPE_REF);
        g0 g0Var = new g0(9);
        g0Var.f1963f = mcpSession;
        VarHandle.storeStoreFence();
        return monoSendRequest.doOnError(g0Var).onErrorComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$2(Long l2) {
        this.mcpSessions.get().flatMap(new a8.b(23)).subscribe();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$3() {
        this.isRunning.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$4() {
        this.isRunning.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$start$5(Throwable th) {
        logger.error("KeepAlive scheduler error", th);
        this.isRunning.set(false);
        return true;
    }

    public boolean isRunning() {
        return this.isRunning.get();
    }

    public void shutdown() {
        stop();
        if (this.scheduler != null) {
            this.scheduler.dispose();
        }
    }

    public Disposable start() {
        int i = 0;
        int i3 = 1;
        if (!this.isRunning.compareAndSet(false, true)) {
            f.e("KeepAlive scheduler is already running. Stop it first.");
            return null;
        }
        Flux<Long> fluxInterval = Flux.interval(this.initialDelay, this.interval, this.scheduler);
        g0 g0Var = new g0(8);
        g0Var.f1963f = this;
        VarHandle.storeStoreFence();
        Flux<Long> fluxDoOnNext = fluxInterval.doOnNext(g0Var);
        a aVar = new a(i);
        aVar.f6369f = this;
        VarHandle.storeStoreFence();
        Flux<Long> fluxDoOnCancel = fluxDoOnNext.doOnCancel(aVar);
        a aVar2 = new a(i3);
        aVar2.f6369f = this;
        VarHandle.storeStoreFence();
        Flux<Long> fluxDoOnComplete = fluxDoOnCancel.doOnComplete(aVar2);
        h hVar = new h(i3);
        hVar.f6367f = this;
        VarHandle.storeStoreFence();
        Disposable disposableSubscribe = fluxDoOnComplete.onErrorComplete(hVar).subscribe();
        this.currentSubscription = disposableSubscribe;
        return disposableSubscribe;
    }

    public void stop() {
        Disposable disposable = this.currentSubscription;
        if (disposable != null && !disposable.isDisposed()) {
            this.currentSubscription.dispose();
        }
        this.isRunning.set(false);
    }
}
