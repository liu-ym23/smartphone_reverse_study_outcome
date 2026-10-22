package io.modelcontextprotocol.util;

import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpSession;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/* loaded from: classes4.dex */
public class KeepAliveScheduler {
    private Disposable currentSubscription;
    private final Duration initialDelay;
    private final Duration interval;
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    private final Supplier<Flux<McpSession>> mcpSessions;
    private final Scheduler scheduler;
    private static final vc.c logger = vc.e.l(KeepAliveScheduler.class);
    private static final TypeRef<Object> OBJECT_TYPE_REF = new TypeRef<Object>() { // from class: io.modelcontextprotocol.util.KeepAliveScheduler.1
    };

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
    public /* synthetic */ void lambda$start$2(Long l10) {
        this.mcpSessions.get().flatMap(new Function() { // from class: io.modelcontextprotocol.util.a
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                McpSession mcpSession = (McpSession) obj;
                return mcpSession.sendRequest(McpSchema.METHOD_PING, null, KeepAliveScheduler.OBJECT_TYPE_REF).doOnError(new Consumer() { // from class: io.modelcontextprotocol.util.f
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj2) {
                        KeepAliveScheduler.logger.c("Failed to send keep-alive ping to session {}: {}", mcpSession, ((Throwable) obj2).getMessage());
                    }
                }).onErrorComplete();
            }
        }).subscribe();
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
        if (!this.isRunning.compareAndSet(false, true)) {
            throw new IllegalStateException("KeepAlive scheduler is already running. Stop it first.");
        }
        Disposable disposableSubscribe = Flux.interval(this.initialDelay, this.interval, this.scheduler).doOnNext(new Consumer() { // from class: io.modelcontextprotocol.util.b
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.f34195a.lambda$start$2((Long) obj);
            }
        }).doOnCancel(new Runnable() { // from class: io.modelcontextprotocol.util.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f34196a.lambda$start$3();
            }
        }).doOnComplete(new Runnable() { // from class: io.modelcontextprotocol.util.d
            @Override // java.lang.Runnable
            public final void run() {
                this.f34197a.lambda$start$4();
            }
        }).onErrorComplete(new Predicate() { // from class: io.modelcontextprotocol.util.e
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return this.f34198a.lambda$start$5((Throwable) obj);
            }
        }).subscribe();
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
