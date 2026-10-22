package okhttp3.internal.ws;

import com.bytedanceos.common.model.Topic;
import com.google.common.net.HttpHeaders;
import fg.j;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000;
    private static final long MAX_QUEUE_SIZE = 16777216;
    private static final List<Protocol> ONLY_HTTP1 = null;
    private boolean awaitingPong;
    private Call call;
    private ScheduledFuture<?> cancelFuture;
    private boolean enqueuedClose;
    private ScheduledExecutorService executor;
    private boolean failed;
    private final String key;
    final WebSocketListener listener;
    private final ArrayDeque<Object> messageAndCloseQueue;
    private final Request originalRequest;
    private final long pingIntervalMillis;
    private final ArrayDeque<ByteString> pongQueue;
    private long queueSize;
    private final Random random;
    private WebSocketReader reader;
    private int receivedCloseCode;
    private String receivedCloseReason;
    private int receivedPingCount;
    private int receivedPongCount;
    private int sentPingCount;
    private Streams streams;
    private WebSocketWriter writer;
    private final Runnable writerRunnable;

    public final class CancelRunnable implements Runnable {
        final /* synthetic */ RealWebSocket this$0;

        public CancelRunnable(RealWebSocket r10) {
            this.this$0 = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.cancel();
        }
    }

    public static final class Close {
        final long cancelAfterCloseMillis;
        final int code;
        final ByteString reason;

        public Close(int r10, ByteString r11, long r12) {
            this.code = r10;
            this.reason = r11;
            this.cancelAfterCloseMillis = r12;
        }
    }

    public static final class Message {
        final ByteString data;
        final int formatOpcode;

        public Message(int r10, ByteString r11) {
            this.formatOpcode = r10;
            this.data = r11;
        }
    }

    public final class PingRunnable implements Runnable {
        final /* synthetic */ RealWebSocket this$0;

        public PingRunnable(RealWebSocket r10) {
            this.this$0 = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.writePingFrame();
        }
    }

    public static abstract class Streams implements Closeable {
        public final boolean client;
        public final BufferedSink sink;
        public final BufferedSource source;

        public Streams(boolean r10, BufferedSource r11, BufferedSink r12) {
            this.client = r10;
            this.source = r11;
            this.sink = r12;
        }
    }

    static {
        ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
    }

    public RealWebSocket(Request r10, WebSocketListener r11, Random r12, long r13) {
        this.pongQueue = new ArrayDeque();
        this.messageAndCloseQueue = new ArrayDeque();
        this.receivedCloseCode = -1;
        if ("GET".equals(r10.g()) == false) goto L7;
        this.originalRequest = r10;
        this.listener = r11;
        this.random = r12;
        this.pingIntervalMillis = r13;
        byte[] r14 = new byte[16];
        r12.nextBytes(r14);
        this.key = ByteString.of(r14).base64();
        this.writerRunnable = new AnonymousClass1(this);
        return;
    L7:
        throw new IllegalArgumentException("Request must be GET: " + r10.g());
    }

    private void runWriter() {
        ScheduledExecutorService r10 = this.executor;
        if (r10 == null) goto L6;
        r10.execute(this.writerRunnable);
        return;
    }

    public void awaitTermination(int r10, TimeUnit r11) throws InterruptedException {
        this.executor.awaitTermination(r10, r11);
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        this.call.cancel();
    }

    public void checkResponse(Response r10) throws ProtocolException {
        if (r10.d() != 101) goto L18;
        String r11 = r10.f("Connection");
        if ("Upgrade".equalsIgnoreCase(r11) == false) goto L16;
        String r12 = r10.f("Upgrade");
        if ("websocket".equalsIgnoreCase(r12) == false) goto L14;
        String r13 = r10.f(HttpHeaders.SEC_WEBSOCKET_ACCEPT);
        String r14 = ByteString.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (r14.equals(r13) == false) goto L12;
        return;
    L12:
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + r14 + "' but was '" + r13 + "'");
    L14:
        throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + r12 + "'");
    L16:
        throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + r11 + "'");
    L18:
        throw new ProtocolException("Expected HTTP 101 response but was '" + r10.d() + " " + r10.l() + "'");
    }

    @Override // okhttp3.WebSocket
    public boolean close(int r10, String r11) {
        return close(r10, r11, 60000);
    }

    public void connect(OkHttpClient r10) {
        OkHttpClient r11 = r10.p().i(EventListener.NONE).m(ONLY_HTTP1).c();
        final Request r12 = this.originalRequest.h().d("Upgrade", "websocket").d("Connection", "Upgrade").d(HttpHeaders.SEC_WEBSOCKET_KEY, this.key).d(HttpHeaders.SEC_WEBSOCKET_VERSION, Topic.PAGE_ID_VENDOR_ZONE).b();
        Call r13 = Internal.instance.newWebSocketCall(r11, r12);
        this.call = r13;
        r13.enqueue(new AnonymousClass2(this, r12));
    }

    public void failWebSocket(Exception r10, @Nullable Response r11) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.failed = true;     // Catch: Throwable -> L7
        Streams r12 = this.streams;     // Catch: Throwable -> L7
        this.streams = null;     // Catch: Throwable -> L7
        ScheduledFuture<?> r13 = this.cancelFuture;     // Catch: Throwable -> L7
        if (r13 == null) goto L12;
        r13.cancel(false);     // Catch: Throwable -> L7
    L12:
        ScheduledExecutorService r14 = this.executor;     // Catch: Throwable -> L7
        if (r14 == null) goto L15;
        r14.shutdown();     // Catch: Throwable -> L7
    L15:
        monitor-exit(this);     // Catch: Throwable -> L7
        this.listener.c(this, r10, r11);     // Catch: Throwable -> L19
        Util.closeQuietly(r12);
        return;
    L19:
        th = move-exception;
        Util.closeQuietly(r12);
        throw th;
    }

    public void initReaderAndWriter(String r12, Streams r13) throws IOException {
        monitor-enter(this);
        this.streams = r13;     // Catch: Throwable -> L6
        this.writer = new WebSocketWriter(r13.client, r13.sink, this.random);     // Catch: Throwable -> L6
        ScheduledThreadPoolExecutor r10 = new ScheduledThreadPoolExecutor(1, Util.threadFactory(r12, false));     // Catch: Throwable -> L6
        this.executor = r10;     // Catch: Throwable -> L6
        if (this.pingIntervalMillis == 0) goto L9;
        PingRunnable r11 = new PingRunnable(this);     // Catch: Throwable -> L6
        long r14 = this.pingIntervalMillis;     // Catch: Throwable -> L6
        r10.scheduleAtFixedRate(r11, r14, r14, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L6
    L9:
        if (this.messageAndCloseQueue.isEmpty() == true) goto L11;
        runWriter();     // Catch: Throwable -> L6
    L11:
        monitor-exit(this);     // Catch: Throwable -> L6
        this.reader = new WebSocketReader(r13.client, r13.source, this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void loopReader() throws IOException {
    L3:
        if (this.receivedCloseCode != (-1)) goto L5;
        this.reader.processNextFrame();
        goto L3
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int r10, String r11) {
        if (r10 == (-1)) goto L33;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (this.receivedCloseCode != (-1)) goto L29;
        this.receivedCloseCode = r10;     // Catch: Throwable -> L14
        this.receivedCloseReason = r11;     // Catch: Throwable -> L14
        Streams r12 = null;
        if (this.enqueuedClose == true) goto L10;
    L17:
        monitor-exit(this);     // Catch: Throwable -> L14
        this.listener.b(this, r10, r11);     // Catch: Throwable -> L22
        if (r12 == null) goto L24;
        this.listener.a(this, r10, r11);     // Catch: Throwable -> L22
    L24:
        Util.closeQuietly(r12);
        return;
    L22:
        th = move-exception;
        Util.closeQuietly(r12);
        throw th;
    L10:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L17;
        Streams r13 = this.streams;     // Catch: Throwable -> L14
        this.streams = null;     // Catch: Throwable -> L14
        ScheduledFuture<?> r14 = this.cancelFuture;     // Catch: Throwable -> L14
        if (r14 == null) goto L16;
        r14.cancel(false);     // Catch: Throwable -> L14
    L16:
        this.executor.shutdown();     // Catch: Throwable -> L14
        r12 = r13;
        goto L17
    L29:
        throw new IllegalStateException("already closed");     // Catch: Throwable -> L14
    L33:
        throw new IllegalArgumentException();
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String r10) throws IOException {
        this.listener.d(this, r10);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString r10) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (this.enqueuedClose == true) goto L8;
    L12:
        this.pongQueue.add(r10);     // Catch: Throwable -> L10
        runWriter();     // Catch: Throwable -> L10
        this.receivedPingCount++;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L8:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L12;
        goto L12
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString r10) {
        monitor-enter(this);
        this.receivedPongCount++;     // Catch: Throwable -> L6
        this.awaitingPong = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean pong(ByteString r10) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L6;
    L16:
        monitor-exit(this);
        return false;
    L6:
        if (this.enqueuedClose == true) goto L8;
    L12:
        this.pongQueue.add(r10);     // Catch: Throwable -> L10
        runWriter();     // Catch: Throwable -> L10
        monitor-exit(this);
        return true;
    L8:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L12;
        goto L12
    }

    public boolean processNextFrame() throws IOException {
        this.reader.processNextFrame();     // Catch: Exception -> L8
        if (this.receivedCloseCode != (-1)) goto L13;
        return true;
    L13:
        return false;
    L8:
        e = move-exception;
        failWebSocket(e, null);
        return false;
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        monitor-enter(this);
        long r10 = this.queueSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int receivedPingCount() {
        monitor-enter(this);
        int r10 = this.receivedPingCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized int receivedPongCount() {
        monitor-enter(this);
        int r10 = this.receivedPongCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public boolean send(String r10) {
        if (r10 == null) goto L6;
        return send(ByteString.encodeUtf8(r10), 1);
    L6:
        throw new NullPointerException("text == null");
    }

    public synchronized int sentPingCount() {
        monitor-enter(this);
        int r10 = this.sentPingCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    public void tearDown() throws InterruptedException {
        ScheduledFuture<?> r10 = this.cancelFuture;
        if (r10 == null) goto L5;
        r10.cancel(false);
    L5:
        this.executor.shutdown();
        this.executor.awaitTermination(10, TimeUnit.SECONDS);
    }

    public boolean writeOneFrame() throws IOException {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return false;
    L9:
        WebSocketWriter r10 = this.writer;     // Catch: Throwable -> L7
        ByteString r11 = this.pongQueue.poll();     // Catch: Throwable -> L7
        Object r12 = null;
        if (r11 != null) goto L22;
        Object r13 = this.messageAndCloseQueue.poll();     // Catch: Throwable -> L7
        if ((r13 instanceof Close) == false) goto L18;
        int r14 = this.receivedCloseCode;     // Catch: Throwable -> L7
        String r15 = this.receivedCloseReason;     // Catch: Throwable -> L7
        if (r14 == (-1)) goto L17;
        Streams r16 = this.streams;     // Catch: Throwable -> L7
        this.streams = null;     // Catch: Throwable -> L7
        this.executor.shutdown();     // Catch: Throwable -> L7
    L16:
        r12 = r13;
    L23:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r11 == null) goto L29;
        r10.writePong(r11);     // Catch: Throwable -> L26
    L43:
        Util.closeQuietly(r16);
        return true;
    L29:
        if ((r12 instanceof Message) == false) goto L39;
        ByteString r17 = ((Message) r12).data;     // Catch: Throwable -> L26
        BufferedSink r18 = j.c(r10.newMessageSink(((Message) r12).formatOpcode, r17.size()));     // Catch: Throwable -> L26
        r18.write(r17);     // Catch: Throwable -> L26
        r18.close();     // Catch: Throwable -> L26
        monitor-enter(this);     // Catch: Throwable -> L26
        this.queueSize -= (long) r17.size();     // Catch: Throwable -> L35
        monitor-exit(this);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L39:
        if ((r12 instanceof Close) == false) goto L46;
        Close r19 = (Close) r12;     // Catch: Throwable -> L26
        r10.writeClose(r19.code, r19.reason);     // Catch: Throwable -> L26
        if (r16 == null) goto L43;
        this.listener.a(this, r14, r15);     // Catch: Throwable -> L26
        goto L43
    L46:
        throw new AssertionError();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Util.closeQuietly(r16);
        throw th;
    L17:
        this.cancelFuture = this.executor.schedule(new CancelRunnable(this), ((Close) r13).cancelAfterCloseMillis, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L7
        r16 = null;
        goto L16
    L18:
        if (r13 != null) goto L21;
        monitor-exit(this);     // Catch: Throwable -> L7
        return false;
    L21:
        r15 = null;
        r14 = -1;
        r16 = null;
        goto L16
    L22:
        r15 = null;
        r14 = -1;
        r16 = null;
        goto L23
    }

    public void writePingFrame() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        WebSocketWriter r10 = this.writer;     // Catch: Throwable -> L7
        if (this.awaitingPong == false) goto L12;
        int r11 = this.sentPingCount;     // Catch: Throwable -> L7
    L13:
        this.sentPingCount++;     // Catch: Throwable -> L7
        this.awaitingPong = true;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r11 == (-1)) goto L27;
        failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (r11 - 1) + " successful ping/pongs)"), null);
        return;
    L27:
        r10.writePing(ByteString.EMPTY);     // Catch: IOException -> L21
        return;
    L21:
        e = move-exception;
        failWebSocket(e, null);
        return;
    L12:
        r11 = -1;
        goto L13
    }

    public synchronized boolean close(int r10, String r11, long r12) {
        monitor-enter(this);
        WebSocketProtocol.validateCloseCode(r10);     // Catch: Throwable -> L10
        if (r11 == null) goto L12;
        ByteString r13 = ByteString.encodeUtf8(r11);     // Catch: Throwable -> L10
        if (r13.size() > 123) goto L9;
    L14:
        if (this.failed == false) goto L16;
    L21:
        monitor-exit(this);
        return false;
    L16:
        if (this.enqueuedClose == true) goto L21;
        this.enqueuedClose = true;     // Catch: Throwable -> L10
        this.messageAndCloseQueue.add(new Close(r10, r13, r12));     // Catch: Throwable -> L10
        runWriter();     // Catch: Throwable -> L10
        monitor-exit(this);
        return true;
    L9:
        throw new IllegalArgumentException("reason.size() > 123: " + r11);     // Catch: Throwable -> L10
    L12:
        r13 = null;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString r10) throws IOException {
        this.listener.e(this, r10);
    }

    @Override // okhttp3.WebSocket
    public boolean send(ByteString r10) {
        if (r10 == null) goto L6;
        return send(r10, 2);
    L6:
        throw new NullPointerException("bytes == null");
    }

    private synchronized boolean send(ByteString r10, int r11) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L6;
    L19:
        monitor-exit(this);
        return false;
    L6:
        if (this.enqueuedClose == true) goto L19;
        if ((this.queueSize + ((long) r10.size())) <= MAX_QUEUE_SIZE) goto L15;
        close(1001, null);     // Catch: Throwable -> L13
        monitor-exit(this);
        return false;
    L15:
        this.queueSize += (long) r10.size();     // Catch: Throwable -> L13
        this.messageAndCloseQueue.add(new Message(r11, r10));     // Catch: Throwable -> L13
        runWriter();     // Catch: Throwable -> L13
        monitor-exit(this);
        return true;
    }
}
