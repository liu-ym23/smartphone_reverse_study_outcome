package ch.qos.logback.core.net.server;

import ch.qos.logback.core.AppenderBase;
import ch.qos.logback.core.net.AbstractSocketAppender;
import ch.qos.logback.core.spi.PreSerializationTransformer;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.UnknownHostException;
import java.util.concurrent.Executor;
import javax.net.ServerSocketFactory;

/* loaded from: classes.dex */
public abstract class AbstractServerSocketAppender<E> extends AppenderBase<E> {
    public static final int DEFAULT_BACKLOG = 50;
    public static final int DEFAULT_CLIENT_QUEUE_SIZE = 100;
    private String address;
    private ServerRunner<RemoteReceiverClient> runner;
    private int port = AbstractSocketAppender.DEFAULT_PORT;
    private int backlog = 50;
    private int clientQueueSize = 100;

    @Override // ch.qos.logback.core.AppenderBase
    public void append(E e4) {
        if (e4 == null) {
            return;
        }
        postProcessEvent(e4);
        final Serializable serializableTransform = getPST().transform(e4);
        this.runner.accept(new ClientVisitor<RemoteReceiverClient>() { // from class: ch.qos.logback.core.net.server.AbstractServerSocketAppender.1
            @Override // ch.qos.logback.core.net.server.ClientVisitor
            public void visit(RemoteReceiverClient remoteReceiverClient) {
                remoteReceiverClient.offer(serializableTransform);
            }
        });
    }

    public ServerListener<RemoteReceiverClient> createServerListener(ServerSocket serverSocket) {
        return new RemoteReceiverServerListener(serverSocket);
    }

    public ServerRunner<RemoteReceiverClient> createServerRunner(ServerListener<RemoteReceiverClient> serverListener, Executor executor) {
        return new RemoteReceiverServerRunner(serverListener, executor, getClientQueueSize());
    }

    public String getAddress() {
        return this.address;
    }

    public int getBacklog() {
        return this.backlog;
    }

    public int getClientQueueSize() {
        return this.clientQueueSize;
    }

    public InetAddress getInetAddress() throws UnknownHostException {
        if (getAddress() == null) {
            return null;
        }
        return InetAddress.getByName(getAddress());
    }

    public abstract PreSerializationTransformer<E> getPST();

    public int getPort() {
        return this.port;
    }

    public ServerSocketFactory getServerSocketFactory() throws Exception {
        return ServerSocketFactory.getDefault();
    }

    public abstract void postProcessEvent(E e4);

    public void setAddress(String str) {
        this.address = str;
    }

    public void setBacklog(int i4) {
        this.backlog = i4;
    }

    public void setClientQueueSize(int i4) {
        this.clientQueueSize = i4;
    }

    public void setPort(int i4) {
        this.port = i4;
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (isStarted()) {
            return;
        }
        try {
            ServerRunner<RemoteReceiverClient> serverRunnerCreateServerRunner = createServerRunner(createServerListener(getServerSocketFactory().createServerSocket(getPort(), getBacklog(), getInetAddress())), getContext().getExecutorService());
            this.runner = serverRunnerCreateServerRunner;
            serverRunnerCreateServerRunner.setContext(getContext());
            getContext().getExecutorService().execute(this.runner);
            super.start();
        } catch (Exception e4) {
            addError("server startup error: " + e4, e4);
        }
    }

    @Override // ch.qos.logback.core.AppenderBase, ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        if (isStarted()) {
            try {
                this.runner.stop();
                super.stop();
            } catch (IOException e4) {
                addError("server shutdown error: " + e4, e4);
            }
        }
    }
}
