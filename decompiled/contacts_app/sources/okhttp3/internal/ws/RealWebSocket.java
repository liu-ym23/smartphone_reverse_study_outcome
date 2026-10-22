package okhttp3.internal.ws;

import com.android.contacts.util.HanziToPinyin;
import com.bytedance.retrofit2.HttpMethodContrants;
import com.google.common.net.HttpHeaders;
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
import okio.Okio;

/* JADX INFO: loaded from: classes5.dex */
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

    final class CancelRunnable implements Runnable {
        final /* synthetic */ RealWebSocket this$0;

        CancelRunnable(RealWebSocket r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.cancel();
        }
    }

    static final class Close {
        final long cancelAfterCloseMillis;
        final int code;
        final ByteString reason;

        Close(int r1, ByteString r2, long r3) {
            this.code = r1;
            this.reason = r2;
            this.cancelAfterCloseMillis = r3;
        }
    }

    static final class Message {
        final ByteString data;
        final int formatOpcode;

        Message(int r1, ByteString r2) {
            this.formatOpcode = r1;
            this.data = r2;
        }
    }

    private final class PingRunnable implements Runnable {
        final /* synthetic */ RealWebSocket this$0;

        PingRunnable(RealWebSocket r1) {
            this.this$0 = r1;
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

        public Streams(boolean r1, BufferedSource r2, BufferedSink r3) {
            this.client = r1;
            this.source = r2;
            this.sink = r3;
        }
    }

    static {
        ONLY_HTTP1 = Collections.singletonList(Protocol.HTTP_1_1);
    }

    public RealWebSocket(Request r3, WebSocketListener r4, Random r5, long r6) {
        this.pongQueue = new ArrayDeque();
        this.messageAndCloseQueue = new ArrayDeque();
        this.receivedCloseCode = -1;
        if (HttpMethodContrants.GET.equals(r3.method()) == false) goto L7;
        this.originalRequest = r3;
        this.listener = r4;
        this.random = r5;
        this.pingIntervalMillis = r6;
        byte[] r7 = new byte[16];
        r5.nextBytes(r7);
        this.key = ByteString.of(r7).base64();
        this.writerRunnable = new AnonymousClass1(this);
        return;
    L7:
        throw new IllegalArgumentException("Request must be GET: " + r3.method());
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        return this.originalRequest;
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        monitor-enter(this);
        long r0 = this.queueSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.WebSocket
    public void cancel() {
        this.call.cancel();
    }

    public void connect(OkHttpClient r4) {
        OkHttpClient r5 = r4.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
        final Request r0 = this.originalRequest.newBuilder().header(HttpHeaders.UPGRADE, "websocket").header("Connection", HttpHeaders.UPGRADE).header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
        Call r6 = Internal.instance.newWebSocketCall(r5, r0);
        this.call = r6;
        r6.timeout().clearTimeout();
        this.call.enqueue(new AnonymousClass2(this, r0));
    }

    void checkResponse(Response r5) throws ProtocolException {
        if (r5.code() != 101) goto L18;
        String r0 = r5.header("Connection");
        if (HttpHeaders.UPGRADE.equalsIgnoreCase(r0) == false) goto L16;
        String r1 = r5.header(HttpHeaders.UPGRADE);
        if ("websocket".equalsIgnoreCase(r1) == false) goto L14;
        String r6 = r5.header("Sec-WebSocket-Accept");
        String r4 = ByteString.encodeUtf8(this.key + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (r4.equals(r6) == false) goto L12;
        return;
    L12:
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + r4 + "' but was '" + r6 + "'");
    L14:
        throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + r1 + "'");
    L16:
        throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + r0 + "'");
    L18:
        throw new ProtocolException("Expected HTTP 101 response but was '" + r5.code() + HanziToPinyin.Token.SEPARATOR + r5.message() + "'");
    }

    public void initReaderAndWriter(String r12, Streams r13) throws IOException {
        monitor-enter(this);
        this.streams = r13;     // Catch: Throwable -> L12
        this.writer = new WebSocketWriter(r13.client, r13.sink, this.random);     // Catch: Throwable -> L12
        ScheduledThreadPoolExecutor r4 = new ScheduledThreadPoolExecutor(1, Util.threadFactory(r12, false));     // Catch: Throwable -> L12
        this.executor = r4;     // Catch: Throwable -> L12
        if (this.pingIntervalMillis == 0) goto L7;
        PingRunnable r5 = new PingRunnable(this);     // Catch: Throwable -> L12
        long r8 = this.pingIntervalMillis;     // Catch: Throwable -> L12
        r4.scheduleAtFixedRate(r5, r8, r8, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L12
    L7:
        if (this.messageAndCloseQueue.isEmpty() == true) goto L9;
        runWriter();     // Catch: Throwable -> L12
    L9:
        monitor-exit(this);     // Catch: Throwable -> L12
        this.reader = new WebSocketReader(r13.client, r13.source, this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void loopReader() throws IOException {
    L3:
        if (this.receivedCloseCode != (-1)) goto L5;
        this.reader.processNextFrame();
        goto L3
    }

    boolean processNextFrame() throws IOException {
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

    void awaitTermination(int r3, TimeUnit r4) throws InterruptedException {
        this.executor.awaitTermination(r3, r4);
    }

    void tearDown() throws InterruptedException {
        ScheduledFuture<?> r0 = this.cancelFuture;
        if (r0 == null) goto L5;
        r0.cancel(false);
    L5:
        this.executor.shutdown();
        this.executor.awaitTermination(10, TimeUnit.SECONDS);
    }

    synchronized int sentPingCount() {
        monitor-enter(this);
        int r0 = this.sentPingCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized int receivedPingCount() {
        monitor-enter(this);
        int r0 = this.receivedPingCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    synchronized int receivedPongCount() {
        monitor-enter(this);
        int r0 = this.receivedPongCount;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String r2) throws IOException {
        this.listener.onMessage(this, r2);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString r2) throws IOException {
        this.listener.onMessage(this, r2);
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString r2) {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L6;
    L13:
        monitor-exit(this);
        return;
    L6:
        if (this.enqueuedClose == true) goto L8;
    L10:
        this.pongQueue.add(r2);     // Catch: Throwable -> L15
        runWriter();     // Catch: Throwable -> L15
        this.receivedPingCount++;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L8:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L10;
        goto L10
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString r1) {
        monitor-enter(this);
        this.receivedPongCount++;     // Catch: Throwable -> L6
        this.awaitingPong = false;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int r4, String r5) {
        if (r4 == (-1)) goto L30;
        monitor-enter(this);
    L26:
        th = move-exception;
        throw th;
    L6:
        if (this.receivedCloseCode != (-1)) goto L25;
        this.receivedCloseCode = r4;     // Catch: Throwable -> L26
        this.receivedCloseReason = r5;     // Catch: Throwable -> L26
        Streams r1 = null;
        if (this.enqueuedClose == true) goto L10;
    L15:
        monitor-exit(this);     // Catch: Throwable -> L26
        this.listener.onClosing(this, r4, r5);     // Catch: Throwable -> L21
        if (r1 == null) goto L19;
        this.listener.onClosed(this, r4, r5);     // Catch: Throwable -> L21
    L19:
        Util.closeQuietly(r1);
        return;
    L21:
        th = move-exception;
        Util.closeQuietly(r1);
        throw th;
    L10:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L15;
        Streams r0 = this.streams;     // Catch: Throwable -> L26
        this.streams = null;     // Catch: Throwable -> L26
        ScheduledFuture<?> r2 = this.cancelFuture;     // Catch: Throwable -> L26
        if (r2 == null) goto L14;
        r2.cancel(false);     // Catch: Throwable -> L26
    L14:
        this.executor.shutdown();     // Catch: Throwable -> L26
        r1 = r0;
        goto L15
    L25:
        throw new IllegalStateException("already closed");     // Catch: Throwable -> L26
    L30:
        throw new IllegalArgumentException();
    }

    @Override // okhttp3.WebSocket
    public boolean send(String r2) {
        if (r2 == null) goto L6;
        return send(ByteString.encodeUtf8(r2), 1);
    L6:
        throw new NullPointerException("text == null");
    }

    @Override // okhttp3.WebSocket
    public boolean send(ByteString r2) {
        if (r2 == null) goto L6;
        return send(r2, 2);
    L6:
        throw new NullPointerException("bytes == null");
    }

    private synchronized boolean send(ByteString r7, int r8) {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L6;
    L17:
        monitor-exit(this);
        return false;
    L6:
        if (this.enqueuedClose == true) goto L17;
        if ((this.queueSize + ((long) r7.size())) <= MAX_QUEUE_SIZE) goto L13;
        close(1001, null);     // Catch: Throwable -> L19
        monitor-exit(this);
        return false;
    L13:
        this.queueSize += (long) r7.size();     // Catch: Throwable -> L19
        this.messageAndCloseQueue.add(new Message(r8, r7));     // Catch: Throwable -> L19
        runWriter();     // Catch: Throwable -> L19
        monitor-exit(this);
        return true;
    }

    synchronized boolean pong(ByteString r2) {
        monitor-enter(this);
    L17:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L6;
    L14:
        monitor-exit(this);
        return false;
    L6:
        if (this.enqueuedClose == true) goto L8;
    L10:
        this.pongQueue.add(r2);     // Catch: Throwable -> L17
        runWriter();     // Catch: Throwable -> L17
        monitor-exit(this);
        return true;
    L8:
        if (this.messageAndCloseQueue.isEmpty() == false) goto L10;
        goto L10
    }

    @Override // okhttp3.WebSocket
    public boolean close(int r3, String r4) {
        return close(r3, r4, 60000);
    }

    synchronized boolean close(int r7, String r8, long r9) {
        monitor-enter(this);
        WebSocketProtocol.validateCloseCode(r7);     // Catch: Throwable -> L23
        if (r8 == null) goto L11;
        ByteString r1 = ByteString.encodeUtf8(r8);     // Catch: Throwable -> L23
        if (r1.size() > 123) goto L10;
    L13:
        if (this.failed == false) goto L15;
    L20:
        monitor-exit(this);
        return false;
    L15:
        if (this.enqueuedClose == true) goto L20;
        this.enqueuedClose = true;     // Catch: Throwable -> L23
        this.messageAndCloseQueue.add(new Close(r7, r1, r9));     // Catch: Throwable -> L23
        runWriter();     // Catch: Throwable -> L23
        monitor-exit(this);
        return true;
    L10:
        throw new IllegalArgumentException("reason.size() > 123: " + r8);     // Catch: Throwable -> L23
    L11:
        r1 = null;
    L23:
        th = move-exception;
        throw th;
    }

    private void runWriter() {
        ScheduledExecutorService r0 = this.executor;
        if (r0 == null) goto L6;
        r0.execute(this.writerRunnable);
        return;
    }

    boolean writeOneFrame() throws IOException {
        monitor-enter(this);
    L46:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L46
        return false;
    L7:
        WebSocketWriter r0 = this.writer;     // Catch: Throwable -> L46
        ByteString r2 = this.pongQueue.poll();     // Catch: Throwable -> L46
        Object r3 = null;
        if (r2 != null) goto L20;
        Object r5 = this.messageAndCloseQueue.poll();     // Catch: Throwable -> L46
        if ((r5 instanceof Close) == false) goto L15;
        int r1 = this.receivedCloseCode;     // Catch: Throwable -> L46
        String r6 = this.receivedCloseReason;     // Catch: Throwable -> L46
        if (r1 == (-1)) goto L14;
        Streams r4 = this.streams;     // Catch: Throwable -> L46
        this.streams = null;     // Catch: Throwable -> L46
        this.executor.shutdown();     // Catch: Throwable -> L46
    L19:
        r3 = r5;
    L21:
        monitor-exit(this);     // Catch: Throwable -> L46
        if (r2 == null) goto L25;
        r0.writePong(r2);     // Catch: Throwable -> L43
    L39:
        Util.closeQuietly(r4);
        return true;
    L25:
        if ((r3 instanceof Message) == false) goto L35;
        ByteString r7 = ((Message) r3).data;     // Catch: Throwable -> L43
        BufferedSink r8 = Okio.buffer(r0.newMessageSink(((Message) r3).formatOpcode, r7.size()));     // Catch: Throwable -> L43
        r8.write(r7);     // Catch: Throwable -> L43
        r8.close();     // Catch: Throwable -> L43
        monitor-enter(this);     // Catch: Throwable -> L43
        this.queueSize -= (long) r7.size();     // Catch: Throwable -> L31
        monitor-exit(this);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L43
    L35:
        if ((r3 instanceof Close) == false) goto L42;
        Close r9 = (Close) r3;     // Catch: Throwable -> L43
        r0.writeClose(r9.code, r9.reason);     // Catch: Throwable -> L43
        if (r4 == null) goto L39;
        this.listener.onClosed(this, r1, r6);     // Catch: Throwable -> L43
        goto L39
    L42:
        throw new AssertionError();     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        Util.closeQuietly(r4);
        throw th;
    L14:
        this.cancelFuture = this.executor.schedule(new CancelRunnable(this), ((Close) r5).cancelAfterCloseMillis, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L46
        r4 = null;
        goto L19
    L15:
        if (r5 != null) goto L18;
        monitor-exit(this);     // Catch: Throwable -> L46
        return false;
    L18:
        r6 = null;
        r1 = -1;
        r4 = null;
        goto L19
    L20:
        r6 = null;
        r1 = -1;
        r4 = null;
        goto L21
    }

    void writePingFrame() {
        monitor-enter(this);
    L22:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L22
        return;
    L7:
        WebSocketWriter r0 = this.writer;     // Catch: Throwable -> L22
        if (this.awaitingPong == false) goto L10;
        int r1 = this.sentPingCount;     // Catch: Throwable -> L22
    L11:
        this.sentPingCount++;     // Catch: Throwable -> L22
        this.awaitingPong = true;     // Catch: Throwable -> L22
        monitor-exit(this);     // Catch: Throwable -> L22
        if (r1 == (-1)) goto L26;
        failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.pingIntervalMillis + "ms (after " + (r1 - 1) + " successful ping/pongs)"), null);
        return;
    L26:
        r0.writePing(ByteString.EMPTY);     // Catch: IOException -> L19
        return;
    L19:
        e = move-exception;
        failWebSocket(e, null);
        return;
    L10:
        r1 = -1;
        goto L11
    }

    public void failWebSocket(Exception r4, @Nullable Response r5) {
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L4:
        if (this.failed == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L20
        return;
    L7:
        this.failed = true;     // Catch: Throwable -> L20
        Streams r0 = this.streams;     // Catch: Throwable -> L20
        this.streams = null;     // Catch: Throwable -> L20
        ScheduledFuture<?> r1 = this.cancelFuture;     // Catch: Throwable -> L20
        if (r1 == null) goto L10;
        r1.cancel(false);     // Catch: Throwable -> L20
    L10:
        ScheduledExecutorService r2 = this.executor;     // Catch: Throwable -> L20
        if (r2 == null) goto L13;
        r2.shutdown();     // Catch: Throwable -> L20
    L13:
        monitor-exit(this);     // Catch: Throwable -> L20
        this.listener.onFailure(this, r4, r5);     // Catch: Throwable -> L17
        Util.closeQuietly(r0);
        return;
    L17:
        th = move-exception;
        Util.closeQuietly(r0);
        throw th;
    }
}
