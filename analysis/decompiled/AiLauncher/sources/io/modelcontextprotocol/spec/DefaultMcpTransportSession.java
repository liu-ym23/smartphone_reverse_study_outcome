package io.modelcontextprotocol.spec;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.publisher.Mono;

/* loaded from: classes4.dex */
public class DefaultMcpTransportSession implements McpTransportSession<Disposable> {
    private static final vc.c logger = vc.e.l(DefaultMcpTransportSession.class);
    private final Function<String, qc.b<Void>> onClose;
    private final Disposable.Composite openConnections = Disposables.composite();
    private final AtomicBoolean initialized = new AtomicBoolean(false);
    private final AtomicReference<String> sessionId = new AtomicReference<>();

    public DefaultMcpTransportSession(Function<String, qc.b<Void>> function) {
        this.onClose = function;
    }

    @Override // io.modelcontextprotocol.spec.McpTransportSession
    public void close() {
        closeGracefully().subscribe();
    }

    @Override // io.modelcontextprotocol.spec.McpTransportSession
    public boolean markInitialized(String str) {
        boolean zCompareAndSet = this.initialized.compareAndSet(false, true);
        if (zCompareAndSet) {
            this.sessionId.set(str);
            logger.t("Established session with id {}", str);
            return zCompareAndSet;
        }
        if (str != null && !str.equals(this.sessionId.get())) {
            logger.c("Different session id provided in response. Expecting {} but server returned {}", this.sessionId.get(), str);
        }
        return zCompareAndSet;
    }

    @Override // io.modelcontextprotocol.spec.McpTransportSession
    public Optional<String> sessionId() {
        return Optional.ofNullable(this.sessionId.get());
    }

    @Override // io.modelcontextprotocol.spec.McpTransportSession
    public void addConnection(Disposable disposable) {
        this.openConnections.add(disposable);
    }

    @Override // io.modelcontextprotocol.spec.McpTransportSession
    public Mono<Void> closeGracefully() {
        Mono monoFrom = Mono.from(this.onClose.apply(this.sessionId.get()));
        final Disposable.Composite composite = this.openConnections;
        Objects.requireNonNull(composite);
        return monoFrom.then(Mono.fromRunnable(new Runnable() { // from class: io.modelcontextprotocol.spec.a
            @Override // java.lang.Runnable
            public final void run() {
                composite.dispose();
            }
        }));
    }

    @Override // io.modelcontextprotocol.spec.McpTransportSession
    public void removeConnection(Disposable disposable) {
        this.openConnections.remove(disposable);
    }
}
