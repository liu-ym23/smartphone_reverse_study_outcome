package ch.qos.logback.core.net.server;

import ch.qos.logback.core.net.server.Client;
import ch.qos.logback.core.spi.ContextAwareBase;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public abstract class ConcurrentServerRunner<T extends Client> extends ContextAwareBase implements Runnable, ServerRunner<T> {
    private final Executor executor;
    private final ServerListener<T> listener;
    private boolean running;
    private final Lock clientsLock = new ReentrantLock();
    private final Collection<T> clients = new ArrayList();

    public class ClientWrapper implements Client {
        private final T delegate;

        public ClientWrapper(T t4) {
            this.delegate = t4;
        }

        @Override // ch.qos.logback.core.net.server.Client, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // java.lang.Runnable
        public void run() {
            ConcurrentServerRunner.this.addClient(this.delegate);
            try {
                this.delegate.run();
            } finally {
                ConcurrentServerRunner.this.removeClient(this.delegate);
            }
        }
    }

    public ConcurrentServerRunner(ServerListener<T> serverListener, Executor executor) {
        this.listener = serverListener;
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addClient(T t4) {
        this.clientsLock.lock();
        try {
            this.clients.add(t4);
        } finally {
            this.clientsLock.unlock();
        }
    }

    private Collection<T> copyClients() {
        this.clientsLock.lock();
        try {
            return new ArrayList(this.clients);
        } finally {
            this.clientsLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeClient(T t4) {
        this.clientsLock.lock();
        try {
            this.clients.remove(t4);
        } finally {
            this.clientsLock.unlock();
        }
    }

    @Override // ch.qos.logback.core.net.server.ServerRunner
    public void accept(ClientVisitor<T> clientVisitor) {
        for (T t4 : copyClients()) {
            try {
                clientVisitor.visit(t4);
            } catch (RuntimeException e4) {
                addError(t4 + ": " + e4);
            }
        }
    }

    public abstract boolean configureClient(T t4);

    @Override // ch.qos.logback.core.net.server.ServerRunner
    public boolean isRunning() {
        return this.running;
    }

    @Override // java.lang.Runnable
    public void run() {
        setRunning(true);
        try {
            addInfo("listening on " + this.listener);
            while (!Thread.currentThread().isInterrupted()) {
                Client clientAcceptClient = this.listener.acceptClient();
                if (configureClient(clientAcceptClient)) {
                    try {
                        this.executor.execute(new ClientWrapper(clientAcceptClient));
                    } catch (RejectedExecutionException unused) {
                        addError(clientAcceptClient + ": connection dropped");
                        clientAcceptClient.close();
                    }
                } else {
                    addError(clientAcceptClient + ": connection dropped");
                    clientAcceptClient.close();
                }
            }
        } catch (InterruptedException unused2) {
        } catch (Exception e4) {
            addError("listener: " + e4);
        }
        setRunning(false);
        addInfo("shutting down");
        this.listener.close();
    }

    public void setRunning(boolean z4) {
        this.running = z4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ch.qos.logback.core.net.server.ServerRunner
    public void stop() throws IOException {
        this.listener.close();
        accept(new ClientVisitor<T>() { // from class: ch.qos.logback.core.net.server.ConcurrentServerRunner.1
            @Override // ch.qos.logback.core.net.server.ClientVisitor
            public void visit(T t4) {
                t4.close();
            }
        });
    }
}
