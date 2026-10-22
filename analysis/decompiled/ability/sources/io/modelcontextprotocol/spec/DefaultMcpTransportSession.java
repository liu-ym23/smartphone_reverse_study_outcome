package io.modelcontextprotocol.spec;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.publisher.Mono;

/* loaded from: classes3.dex */
public class DefaultMcpTransportSession implements McpTransportSession<Disposable> {
    private static final InterfaceC0315b logger = AbstractC0317d.b(DefaultMcpTransportSession.class);
    private final Function<String, Z9.c> onClose;
    private final Disposable.Composite openConnections = Disposables.composite();
    private final AtomicBoolean initialized = new AtomicBoolean(false);
    private final AtomicReference<String> sessionId = new AtomicReference<>();

    public DefaultMcpTransportSession(Function<String, Z9.c> function) {
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
            logger.j(str, "Established session with id {}");
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
        Disposable.Composite composite = this.openConnections;
        Objects.requireNonNull(composite);
        return monoFrom.then(Mono.fromRunnable(new D6.b(composite, 29)));
    }

    @Override // io.modelcontextprotocol.spec.McpTransportSession
    public void removeConnection(Disposable disposable) {
        this.openConnections.remove(disposable);
    }
}
