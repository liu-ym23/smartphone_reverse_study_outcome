package io.modelcontextprotocol.spec;

import a4.t;
import java.lang.invoke.VarHandle;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import reactor.core.Disposable;
import reactor.core.Disposables;
import reactor.core.publisher.Mono;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class DefaultMcpTransportSession implements McpTransportSession<Disposable> {
    private static final rd.b logger = rd.d.b(DefaultMcpTransportSession.class);
    private final Function<String, qd.c> onClose;
    private final Disposable.Composite openConnections = Disposables.composite();
    private final AtomicBoolean initialized = new AtomicBoolean(false);
    private final AtomicReference<String> sessionId = new AtomicReference<>();

    public DefaultMcpTransportSession(Function<String, qd.c> function) {
        this.onClose = function;
    }

    @Override // io.modelcontextprotocol.spec.McpTransportSession
    public void close() {
        closeGracefully().subscribe();
    }

    @Override // io.modelcontextprotocol.spec.McpTransportSession
    public Mono<Void> closeGracefully() {
        Mono monoFrom = Mono.from(this.onClose.apply(this.sessionId.get()));
        Disposable.Composite composite = this.openConnections;
        Objects.requireNonNull(composite);
        t tVar = new t(16);
        tVar.f200f = composite;
        VarHandle.storeStoreFence();
        return monoFrom.then(Mono.fromRunnable(tVar));
    }

    @Override // io.modelcontextprotocol.spec.McpTransportSession
    public boolean markInitialized(String str) {
        boolean zCompareAndSet = this.initialized.compareAndSet(false, true);
        if (zCompareAndSet) {
            this.sessionId.set(str);
            logger.h(str, "Established session with id {}");
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
    public void removeConnection(Disposable disposable) {
        this.openConnections.remove(disposable);
    }
}
