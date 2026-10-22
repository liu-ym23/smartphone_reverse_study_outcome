package io.modelcontextprotocol.util;

import E3.d;
import Z9.c;
import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import androidx.window.embedding.b;
import io.modelcontextprotocol.json.TypeRef;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpSession;
import java.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Supplier;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/* loaded from: classes3.dex */
public class KeepAliveScheduler {
    private Disposable currentSubscription;
    private final Duration initialDelay;
    private final Duration interval;
    private final AtomicBoolean isRunning = new AtomicBoolean(false);
    private final Supplier<Flux<McpSession>> mcpSessions;
    private final Scheduler scheduler;
    private static final InterfaceC0315b logger = AbstractC0317d.b(KeepAliveScheduler.class);
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
    public static /* synthetic */ void lambda$start$0(McpSession mcpSession, Throwable th) {
        logger.c("Failed to send keep-alive ping to session {}: {}", mcpSession, th.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c lambda$start$1(McpSession mcpSession) {
        return mcpSession.sendRequest(McpSchema.METHOD_PING, null, OBJECT_TYPE_REF).doOnError(new com.stepos.mcp.sdk.java.a(mcpSession, 6)).onErrorComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$2(Long l) {
        this.mcpSessions.get().flatMap(new d(22)).subscribe();
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
        final int i = 0;
        Flux<Long> fluxDoOnCancel = Flux.interval(this.initialDelay, this.interval, this.scheduler).doOnNext(new com.stepos.mcp.sdk.java.a(this, 5)).doOnCancel(new Runnable(this) { // from class: io.modelcontextprotocol.util.a
            public final /* synthetic */ KeepAliveScheduler b;

            {
                this.b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i6 = i;
                KeepAliveScheduler keepAliveScheduler = this.b;
                switch (i6) {
                    case 0:
                        keepAliveScheduler.lambda$start$3();
                        break;
                    default:
                        keepAliveScheduler.lambda$start$4();
                        break;
                }
            }
        });
        final int i6 = 1;
        Disposable disposableSubscribe = fluxDoOnCancel.doOnComplete(new Runnable(this) { // from class: io.modelcontextprotocol.util.a
            public final /* synthetic */ KeepAliveScheduler b;

            {
                this.b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                int i62 = i6;
                KeepAliveScheduler keepAliveScheduler = this.b;
                switch (i62) {
                    case 0:
                        keepAliveScheduler.lambda$start$3();
                        break;
                    default:
                        keepAliveScheduler.lambda$start$4();
                        break;
                }
            }
        }).onErrorComplete(new b(this, 7)).subscribe();
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
