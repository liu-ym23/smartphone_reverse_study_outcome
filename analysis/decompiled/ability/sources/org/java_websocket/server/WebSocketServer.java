package org.java_websocket.server;

import aa.AbstractC0317d;
import aa.InterfaceC0315b;
import java.io.IOException;
import java.lang.Thread;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.java_websocket.AbstractWebSocket;
import org.java_websocket.SocketChannelIOHelper;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketFactory;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.WebSocketServerFactory;
import org.java_websocket.WrappedByteChannel;
import org.java_websocket.drafts.Draft;
import org.java_websocket.exceptions.WebsocketNotConnectedException;
import org.java_websocket.exceptions.WrappedIOException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.handshake.Handshakedata;

/* loaded from: classes4.dex */
public abstract class WebSocketServer extends AbstractWebSocket implements Runnable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int AVAILABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private final InetSocketAddress address;
    private BlockingQueue<ByteBuffer> buffers;
    private final Collection<WebSocket> connections;
    protected List<WebSocketWorker> decoders;
    private List<Draft> drafts;
    private List<WebSocketImpl> iqueue;
    private final AtomicBoolean isclosed;
    private final InterfaceC0315b log;
    private int maxPendingConnections;
    private int queueinvokes;
    private final AtomicInteger queuesize;
    private Selector selector;
    private Thread selectorthread;
    private ServerSocketChannel server;
    private WebSocketServerFactory wsf;

    public class WebSocketWorker extends Thread {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private BlockingQueue<WebSocketImpl> iqueue = new LinkedBlockingQueue();

        public WebSocketWorker() {
            setName("WebSocketWorker-" + getId());
            setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: org.java_websocket.server.WebSocketServer.WebSocketWorker.1
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public void uncaughtException(Thread thread, Throwable th) {
                    WebSocketServer.this.log.i("Uncaught exception in thread {}: {}", thread.getName(), th);
                }
            });
        }

        private void doDecode(WebSocketImpl webSocketImpl, ByteBuffer byteBuffer) throws InterruptedException {
            try {
                try {
                    webSocketImpl.decode(byteBuffer);
                } catch (Exception e) {
                    WebSocketServer.this.log.error("Error while reading from remote connection", e);
                }
            } finally {
                WebSocketServer.this.pushBuffer(byteBuffer);
            }
        }

        public void put(WebSocketImpl webSocketImpl) throws InterruptedException {
            this.iqueue.put(webSocketImpl);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            WebSocketImpl webSocketImplTake;
            Throwable th;
            Throwable e;
            while (true) {
                try {
                    try {
                        webSocketImplTake = this.iqueue.take();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                } catch (LinkageError | ThreadDeath | VirtualMachineError e6) {
                    webSocketImplTake = null;
                    e = e6;
                } catch (Throwable th2) {
                    webSocketImplTake = null;
                    th = th2;
                }
                try {
                    doDecode(webSocketImplTake, webSocketImplTake.inQueue.poll());
                } catch (LinkageError | ThreadDeath | VirtualMachineError e9) {
                    e = e9;
                    WebSocketServer.this.log.e(getName(), "Got fatal error in worker thread {}");
                    WebSocketServer.this.handleFatal(webSocketImplTake, new Exception(e));
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    WebSocketServer.this.log.i("Uncaught exception in thread {}: {}", getName(), th);
                    if (webSocketImplTake != null) {
                        WebSocketServer.this.onWebsocketError(webSocketImplTake, new Exception(th));
                        webSocketImplTake.close();
                        return;
                    }
                    return;
                }
            }
        }
    }

    public WebSocketServer() {
        this(new InetSocketAddress(80), AVAILABLE_PROCESSORS, null);
    }

    private static InetSocketAddress checkAddressOfExistingChannel(ServerSocketChannel serverSocketChannel) throws IOException {
        try {
            SocketAddress localAddress = serverSocketChannel.getLocalAddress();
            if (localAddress != null) {
                return (InetSocketAddress) localAddress;
            }
            throw new IllegalArgumentException("Could not get address of channel passed to WebSocketServer, make sure it is bound");
        } catch (IOException e) {
            throw new IllegalArgumentException("Could not get address of channel passed to WebSocketServer, make sure it is bound", e);
        }
    }

    private void doAccept(SelectionKey selectionKey, Iterator<SelectionKey> it) throws InterruptedException, IOException {
        if (!onConnect(selectionKey)) {
            selectionKey.cancel();
            return;
        }
        SocketChannel socketChannelAccept = this.server.accept();
        if (socketChannelAccept == null) {
            return;
        }
        socketChannelAccept.configureBlocking(false);
        Socket socket = socketChannelAccept.socket();
        socket.setTcpNoDelay(isTcpNoDelay());
        socket.setKeepAlive(true);
        WebSocketImpl webSocketImplCreateWebSocket = this.wsf.createWebSocket((WebSocketAdapter) this, this.drafts);
        webSocketImplCreateWebSocket.setSelectionKey(socketChannelAccept.register(this.selector, 1, webSocketImplCreateWebSocket));
        try {
            webSocketImplCreateWebSocket.setChannel(this.wsf.wrapChannel(socketChannelAccept, webSocketImplCreateWebSocket.getSelectionKey()));
            it.remove();
            allocateBuffers(webSocketImplCreateWebSocket);
        } catch (IOException e) {
            if (webSocketImplCreateWebSocket.getSelectionKey() != null) {
                webSocketImplCreateWebSocket.getSelectionKey().cancel();
            }
            handleIOException(webSocketImplCreateWebSocket.getSelectionKey(), null, e);
        }
    }

    private void doAdditionalRead() throws InterruptedException, IOException {
        while (!this.iqueue.isEmpty()) {
            WebSocketImpl webSocketImplRemove = this.iqueue.remove(0);
            WrappedByteChannel wrappedByteChannel = (WrappedByteChannel) webSocketImplRemove.getChannel();
            ByteBuffer byteBufferTakeBuffer = takeBuffer();
            try {
                if (SocketChannelIOHelper.readMore(byteBufferTakeBuffer, webSocketImplRemove, wrappedByteChannel)) {
                    this.iqueue.add(webSocketImplRemove);
                }
                if (byteBufferTakeBuffer.hasRemaining()) {
                    webSocketImplRemove.inQueue.put(byteBufferTakeBuffer);
                    queue(webSocketImplRemove);
                } else {
                    pushBuffer(byteBufferTakeBuffer);
                }
            } catch (IOException e) {
                pushBuffer(byteBufferTakeBuffer);
                throw e;
            }
        }
    }

    private void doBroadcast(Object obj, Collection<WebSocket> collection) {
        ArrayList arrayList;
        String str = obj instanceof String ? (String) obj : null;
        ByteBuffer byteBuffer = obj instanceof ByteBuffer ? (ByteBuffer) obj : null;
        if (str == null && byteBuffer == null) {
            return;
        }
        HashMap map = new HashMap();
        synchronized (collection) {
            arrayList = new ArrayList(collection);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            WebSocket webSocket = (WebSocket) it.next();
            if (webSocket != null) {
                Draft draft = webSocket.getDraft();
                fillFrames(draft, map, str, byteBuffer);
                try {
                    webSocket.sendFrame((Collection<Framedata>) map.get(draft));
                } catch (WebsocketNotConnectedException unused) {
                }
            }
        }
    }

    private boolean doEnsureSingleThread() {
        synchronized (this) {
            try {
                if (this.selectorthread != null) {
                    throw new IllegalStateException(getClass().getName().concat(" can only be started once."));
                }
                this.selectorthread = Thread.currentThread();
                return !this.isclosed.get();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private boolean doRead(SelectionKey selectionKey, Iterator<SelectionKey> it) throws WrappedIOException, InterruptedException, IOException {
        WebSocketImpl webSocketImpl = (WebSocketImpl) selectionKey.attachment();
        ByteBuffer byteBufferTakeBuffer = takeBuffer();
        if (webSocketImpl.getChannel() == null) {
            selectionKey.cancel();
            handleIOException(selectionKey, webSocketImpl, new IOException());
            return false;
        }
        try {
            if (!SocketChannelIOHelper.read(byteBufferTakeBuffer, webSocketImpl, webSocketImpl.getChannel())) {
                pushBuffer(byteBufferTakeBuffer);
                return true;
            }
            if (!byteBufferTakeBuffer.hasRemaining()) {
                pushBuffer(byteBufferTakeBuffer);
                return true;
            }
            webSocketImpl.inQueue.put(byteBufferTakeBuffer);
            queue(webSocketImpl);
            it.remove();
            if (!(webSocketImpl.getChannel() instanceof WrappedByteChannel) || !((WrappedByteChannel) webSocketImpl.getChannel()).isNeedRead()) {
                return true;
            }
            this.iqueue.add(webSocketImpl);
            return true;
        } catch (IOException e) {
            pushBuffer(byteBufferTakeBuffer);
            throw new WrappedIOException(webSocketImpl, e);
        }
    }

    private void doServerShutdown() throws IOException {
        stopConnectionLostTimer();
        List<WebSocketWorker> list = this.decoders;
        if (list != null) {
            Iterator<WebSocketWorker> it = list.iterator();
            while (it.hasNext()) {
                it.next().interrupt();
            }
        }
        Selector selector = this.selector;
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException e) {
                this.log.error("IOException during selector.close", e);
                onError(null, e);
            }
        }
        ServerSocketChannel serverSocketChannel = this.server;
        if (serverSocketChannel != null) {
            try {
                serverSocketChannel.close();
            } catch (IOException e6) {
                this.log.error("IOException during server.close", e6);
                onError(null, e6);
            }
        }
    }

    private boolean doSetupSelectorAndServerThread() throws IOException {
        this.selectorthread.setName("WebSocketSelector-" + this.selectorthread.getId());
        try {
            if (this.server == null) {
                this.server = ServerSocketChannel.open();
            }
            this.server.configureBlocking(false);
            ServerSocket serverSocketSocket = this.server.socket();
            int receiveBufferSize = getReceiveBufferSize();
            if (receiveBufferSize > 0) {
                serverSocketSocket.setReceiveBufferSize(receiveBufferSize);
            }
            serverSocketSocket.setReuseAddress(isReuseAddr());
            if (!serverSocketSocket.isBound()) {
                serverSocketSocket.bind(this.address, getMaxPendingConnections());
            }
            Selector selectorOpen = Selector.open();
            this.selector = selectorOpen;
            ServerSocketChannel serverSocketChannel = this.server;
            serverSocketChannel.register(selectorOpen, serverSocketChannel.validOps());
            startConnectionLostTimer();
            Iterator<WebSocketWorker> it = this.decoders.iterator();
            while (it.hasNext()) {
                it.next().start();
            }
            onStart();
            return true;
        } catch (IOException e) {
            handleFatal(null, e);
            return false;
        }
    }

    private void doWrite(SelectionKey selectionKey) throws WrappedIOException {
        WebSocketImpl webSocketImpl = (WebSocketImpl) selectionKey.attachment();
        try {
            if (SocketChannelIOHelper.batch(webSocketImpl, webSocketImpl.getChannel()) && selectionKey.isValid()) {
                selectionKey.interestOps(1);
            }
        } catch (IOException e) {
            throw new WrappedIOException(webSocketImpl, e);
        }
    }

    private void fillFrames(Draft draft, Map<Draft, List<Framedata>> map, String str, ByteBuffer byteBuffer) {
        if (map.containsKey(draft)) {
            return;
        }
        List<Framedata> listCreateFrames = str != null ? draft.createFrames(str, false) : null;
        if (byteBuffer != null) {
            listCreateFrames = draft.createFrames(byteBuffer, false);
        }
        if (listCreateFrames != null) {
            map.put(draft, listCreateFrames);
        }
    }

    private Socket getSocket(WebSocket webSocket) {
        return ((SocketChannel) ((WebSocketImpl) webSocket).getSelectionKey().channel()).socket();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleFatal(WebSocket webSocket, Exception exc) {
        this.log.error("Shutdown due to fatal error", exc);
        onError(webSocket, exc);
        try {
            stop(0, "Got error on server side: " + exc.getClass().getName() + (exc.getCause() != null ? " caused by ".concat(exc.getCause().getClass().getName()) : ""));
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.log.error("Interrupt during stop", exc);
            onError(null, e);
        }
        List<WebSocketWorker> list = this.decoders;
        if (list != null) {
            Iterator<WebSocketWorker> it = list.iterator();
            while (it.hasNext()) {
                it.next().interrupt();
            }
        }
        Thread thread = this.selectorthread;
        if (thread != null) {
            thread.interrupt();
        }
    }

    private void handleIOException(SelectionKey selectionKey, WebSocket webSocket, IOException iOException) throws IOException {
        SelectableChannel selectableChannelChannel;
        if (selectionKey != null) {
            selectionKey.cancel();
        }
        if (webSocket != null) {
            webSocket.closeConnection(1006, iOException.getMessage());
        } else {
            if (selectionKey == null || (selectableChannelChannel = selectionKey.channel()) == null || !selectableChannelChannel.isOpen()) {
                return;
            }
            try {
                selectableChannelChannel.close();
            } catch (IOException unused) {
            }
            this.log.trace("Connection closed because of exception", iOException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pushBuffer(ByteBuffer byteBuffer) throws InterruptedException {
        if (this.buffers.size() > this.queuesize.intValue()) {
            return;
        }
        this.buffers.put(byteBuffer);
    }

    private ByteBuffer takeBuffer() throws InterruptedException {
        return this.buffers.take();
    }

    public boolean addConnection(WebSocket webSocket) {
        boolean zAdd;
        if (this.isclosed.get()) {
            webSocket.close(1001);
            return true;
        }
        synchronized (this.connections) {
            zAdd = this.connections.add(webSocket);
        }
        return zAdd;
    }

    public void allocateBuffers(WebSocket webSocket) throws InterruptedException {
        if (this.queuesize.get() >= (this.decoders.size() * 2) + 1) {
            return;
        }
        this.queuesize.incrementAndGet();
        this.buffers.put(createBuffer());
    }

    public void broadcast(String str) {
        broadcast(str, this.connections);
    }

    public ByteBuffer createBuffer() {
        int receiveBufferSize = getReceiveBufferSize();
        if (receiveBufferSize <= 0) {
            receiveBufferSize = AbstractWebSocket.DEFAULT_READ_BUFFER_SIZE;
        }
        return ByteBuffer.allocate(receiveBufferSize);
    }

    public InetSocketAddress getAddress() {
        return this.address;
    }

    @Override // org.java_websocket.AbstractWebSocket
    public Collection<WebSocket> getConnections() {
        Collection<WebSocket> collectionUnmodifiableCollection;
        synchronized (this.connections) {
            collectionUnmodifiableCollection = Collections.unmodifiableCollection(new ArrayList(this.connections));
        }
        return collectionUnmodifiableCollection;
    }

    public List<Draft> getDraft() {
        return Collections.unmodifiableList(this.drafts);
    }

    @Override // org.java_websocket.WebSocketListener
    public InetSocketAddress getLocalSocketAddress(WebSocket webSocket) {
        return (InetSocketAddress) getSocket(webSocket).getLocalSocketAddress();
    }

    public int getMaxPendingConnections() {
        return this.maxPendingConnections;
    }

    public int getPort() {
        ServerSocketChannel serverSocketChannel;
        int port = getAddress().getPort();
        return (port != 0 || (serverSocketChannel = this.server) == null) ? port : serverSocketChannel.socket().getLocalPort();
    }

    @Override // org.java_websocket.WebSocketListener
    public InetSocketAddress getRemoteSocketAddress(WebSocket webSocket) {
        return (InetSocketAddress) getSocket(webSocket).getRemoteSocketAddress();
    }

    public final WebSocketFactory getWebSocketFactory() {
        return this.wsf;
    }

    public abstract void onClose(WebSocket webSocket, int i, String str, boolean z10);

    public void onCloseInitiated(WebSocket webSocket, int i, String str) {
    }

    public void onClosing(WebSocket webSocket, int i, String str, boolean z10) {
    }

    public boolean onConnect(SelectionKey selectionKey) {
        return true;
    }

    public abstract void onError(WebSocket webSocket, Exception exc);

    public abstract void onMessage(WebSocket webSocket, String str);

    public void onMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
    }

    public abstract void onOpen(WebSocket webSocket, ClientHandshake clientHandshake);

    public abstract void onStart();

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketClose(WebSocket webSocket, int i, String str, boolean z10) {
        this.selector.wakeup();
        try {
            if (removeConnection(webSocket)) {
                onClose(webSocket, i, str, z10);
            }
        } finally {
            try {
                releaseBuffers(webSocket);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override // org.java_websocket.WebSocketListener
    public void onWebsocketCloseInitiated(WebSocket webSocket, int i, String str) {
        onCloseInitiated(webSocket, i, str);
    }

    @Override // org.java_websocket.WebSocketListener
    public void onWebsocketClosing(WebSocket webSocket, int i, String str, boolean z10) {
        onClosing(webSocket, i, str, z10);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketError(WebSocket webSocket, Exception exc) {
        onError(webSocket, exc);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, String str) {
        onMessage(webSocket, str);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketOpen(WebSocket webSocket, Handshakedata handshakedata) {
        if (addConnection(webSocket)) {
            onOpen(webSocket, (ClientHandshake) handshakedata);
        }
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWriteDemand(WebSocket webSocket) {
        WebSocketImpl webSocketImpl = (WebSocketImpl) webSocket;
        try {
            webSocketImpl.getSelectionKey().interestOps(5);
        } catch (CancelledKeyException unused) {
            webSocketImpl.outQueue.clear();
        }
        this.selector.wakeup();
    }

    public void queue(WebSocketImpl webSocketImpl) throws InterruptedException {
        if (webSocketImpl.getWorkerThread() == null) {
            List<WebSocketWorker> list = this.decoders;
            webSocketImpl.setWorkerThread(list.get(this.queueinvokes % list.size()));
            this.queueinvokes++;
        }
        webSocketImpl.getWorkerThread().put(webSocketImpl);
    }

    public void releaseBuffers(WebSocket webSocket) throws InterruptedException {
    }

    public boolean removeConnection(WebSocket webSocket) {
        boolean zRemove;
        synchronized (this.connections) {
            try {
                if (this.connections.contains(webSocket)) {
                    zRemove = this.connections.remove(webSocket);
                } else {
                    this.log.g(webSocket, "Removing connection which is not in the connections collection! Possible no handshake received! {}");
                    zRemove = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.isclosed.get() && this.connections.isEmpty()) {
            this.selectorthread.interrupt();
        }
        return zRemove;
    }

    @Override // java.lang.Runnable
    public void run() throws IOException {
        SelectionKey selectionKey;
        if (doEnsureSingleThread() && doSetupSelectorAndServerThread()) {
            int i = 0;
            int i6 = 5;
            while (!this.selectorthread.isInterrupted() && i6 != 0) {
                try {
                    try {
                        try {
                            try {
                                if (this.isclosed.get()) {
                                    i = 5;
                                }
                                if (this.selector.select(i) == 0 && this.isclosed.get()) {
                                    i6--;
                                }
                                Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();
                                selectionKey = null;
                                while (it.hasNext()) {
                                    try {
                                        SelectionKey next = it.next();
                                        try {
                                            if (next.isValid()) {
                                                if (next.isAcceptable()) {
                                                    doAccept(next, it);
                                                } else if ((!next.isReadable() || doRead(next, it)) && next.isWritable()) {
                                                    doWrite(next);
                                                }
                                            }
                                            selectionKey = next;
                                        } catch (IOException e) {
                                            e = e;
                                            selectionKey = next;
                                            handleIOException(selectionKey, null, e);
                                        } catch (WrappedIOException e6) {
                                            e = e6;
                                            selectionKey = next;
                                            handleIOException(selectionKey, e.getConnection(), e.getIOException());
                                        }
                                    } catch (IOException e9) {
                                        e = e9;
                                    } catch (WrappedIOException e10) {
                                        e = e10;
                                    }
                                }
                                doAdditionalRead();
                            } catch (IOException e11) {
                                e = e11;
                                selectionKey = null;
                            } catch (WrappedIOException e12) {
                                e = e12;
                                selectionKey = null;
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        } catch (CancelledKeyException unused2) {
                        } catch (ClosedByInterruptException unused3) {
                            doServerShutdown();
                            return;
                        }
                    } catch (RuntimeException e13) {
                        handleFatal(null, e13);
                    }
                } catch (Throwable th) {
                    doServerShutdown();
                    throw th;
                }
            }
            doServerShutdown();
        }
    }

    @Override // org.java_websocket.AbstractWebSocket
    public void setDaemon(boolean z10) {
        super.setDaemon(z10);
        for (WebSocketWorker webSocketWorker : this.decoders) {
            if (webSocketWorker.isAlive()) {
                throw new IllegalStateException("Cannot call setDaemon after server is already started!");
            }
            webSocketWorker.setDaemon(z10);
        }
    }

    public void setMaxPendingConnections(int i) {
        this.maxPendingConnections = i;
    }

    public final void setWebSocketFactory(WebSocketServerFactory webSocketServerFactory) {
        WebSocketServerFactory webSocketServerFactory2 = this.wsf;
        if (webSocketServerFactory2 != null) {
            webSocketServerFactory2.close();
        }
        this.wsf = webSocketServerFactory;
    }

    public void start() {
        if (this.selectorthread != null) {
            throw new IllegalStateException(getClass().getName().concat(" can only be started once."));
        }
        Thread thread = new Thread(this);
        thread.setDaemon(isDaemon());
        thread.start();
    }

    public void stop(int i) throws InterruptedException {
        stop(i, "");
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress) {
        this(inetSocketAddress, AVAILABLE_PROCESSORS, null);
    }

    public void broadcast(byte[] bArr) {
        broadcast(bArr, this.connections);
    }

    @Override // org.java_websocket.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        onMessage(webSocket, byteBuffer);
    }

    public void stop(int i, String str) throws InterruptedException {
        ArrayList arrayList;
        Selector selector;
        if (this.isclosed.compareAndSet(false, true)) {
            synchronized (this.connections) {
                arrayList = new ArrayList(this.connections);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((WebSocket) it.next()).close(1001, str);
            }
            this.wsf.close();
            synchronized (this) {
                try {
                    if (this.selectorthread != null && (selector = this.selector) != null) {
                        selector.wakeup();
                        this.selectorthread.join(i);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, int i) {
        this(inetSocketAddress, i, null);
    }

    public void broadcast(ByteBuffer byteBuffer) {
        broadcast(byteBuffer, this.connections);
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, List<Draft> list) {
        this(inetSocketAddress, AVAILABLE_PROCESSORS, list);
    }

    public void broadcast(byte[] bArr, Collection<WebSocket> collection) {
        if (bArr != null && collection != null) {
            broadcast(ByteBuffer.wrap(bArr), collection);
            return;
        }
        throw new IllegalArgumentException();
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, int i, List<Draft> list) {
        this(inetSocketAddress, i, list, new HashSet());
    }

    public WebSocketServer(ServerSocketChannel serverSocketChannel) {
        this(checkAddressOfExistingChannel(serverSocketChannel));
        this.server = serverSocketChannel;
    }

    public void broadcast(ByteBuffer byteBuffer, Collection<WebSocket> collection) {
        if (byteBuffer != null && collection != null) {
            doBroadcast(byteBuffer, collection);
            return;
        }
        throw new IllegalArgumentException();
    }

    public WebSocketServer(InetSocketAddress inetSocketAddress, int i, List<Draft> list, Collection<WebSocket> collection) {
        this.log = AbstractC0317d.b(WebSocketServer.class);
        this.isclosed = new AtomicBoolean(false);
        this.queueinvokes = 0;
        this.queuesize = new AtomicInteger(0);
        this.wsf = new DefaultWebSocketServerFactory();
        this.maxPendingConnections = -1;
        if (inetSocketAddress != null && i >= 1 && collection != null) {
            if (list == null) {
                this.drafts = Collections.EMPTY_LIST;
            } else {
                this.drafts = list;
            }
            this.address = inetSocketAddress;
            this.connections = collection;
            setTcpNoDelay(false);
            setReuseAddr(false);
            this.iqueue = new LinkedList();
            this.decoders = new ArrayList(i);
            this.buffers = new LinkedBlockingQueue();
            for (int i6 = 0; i6 < i; i6++) {
                this.decoders.add(new WebSocketWorker());
            }
            return;
        }
        throw new IllegalArgumentException("address and connectionscontainer must not be null and you need at least 1 decoder");
    }

    public void broadcast(String str, Collection<WebSocket> collection) {
        if (str != null && collection != null) {
            doBroadcast(str, collection);
            return;
        }
        throw new IllegalArgumentException();
    }

    public void stop() throws InterruptedException {
        stop(0);
    }
}
