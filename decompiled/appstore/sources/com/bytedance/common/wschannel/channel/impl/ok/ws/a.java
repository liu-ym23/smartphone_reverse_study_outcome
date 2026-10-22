package com.bytedance.common.wschannel.channel.impl.ok.ws;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedanceos.common.model.Topic;
import com.google.common.net.HttpHeaders;
import fg.j;
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
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.ws.RealWebSocket;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: loaded from: classes.dex */
public class a implements CustomHeartBeatWebSocket, WebSocketReader.FrameCallback {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final List f6992x = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c4.a f6993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Request f6994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Random f6995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Runnable f6997e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayDeque f6998f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayDeque f6999g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f7000h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Call f7001i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public WebSocketReader f7002j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public c4.c f7003k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ScheduledExecutorService f7004l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public RealWebSocket.Streams f7005m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public long f7006n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f7007o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public ScheduledFuture f7008p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f7009q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f7010r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f7011s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f7012t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f7013u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public int f7014v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f7015w;

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.channel.impl.ok.ws.a$a, reason: collision with other inner class name */
    public class RunnableC0087a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f7016a;

        public RunnableC0087a(a r10) {
            this.f7016a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
        L8:
            if (this.f7016a.l() == true) goto L8;
            return;
        L5:
            e = move-exception;
            this.f7016a.g(e, null);
        }
    }

    public class b implements Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Request f7017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f7018b;

        public b(a r10, Request r11) {
            this.f7018b = r10;
            this.f7017a = r11;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call r10, IOException r11) {
            this.f7018b.g(r11, null);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call r10, Response r11) {
            this.f7018b.b(r11);     // Catch: ProtocolException -> L13
            StreamAllocation r12 = Internal.instance.streamAllocation(r10);
            r12.noNewStreams();
            RealWebSocket.Streams r13 = r12.connection().newWebSocketStreams(r12);
        L7:
            e = move-exception;
            this.f7018b.g(e, null);
            return;
        L5:
            if (a.a(this.f7018b) == null) goto L9;
            a.a(this.f7018b).f(this.f7018b, r11);     // Catch: Exception -> L7
        L9:
            this.f7018b.h("OkHttp WebSocket " + this.f7017a.k().E(), r13);     // Catch: Exception -> L7
            r12.connection().socket().setSoTimeout(0);     // Catch: Exception -> L7
            this.f7018b.i();     // Catch: Exception -> L7
            return;
        L13:
            e = move-exception;
            this.f7018b.g(e, r11);
            Util.closeQuietly(r11);
        }
    }

    public final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f7019a;

        public c(a r10) {
            this.f7019a = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f7019a.cancel();
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteString f7021b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f7022c;

        public d(int r10, ByteString r11, long r12) {
            this.f7020a = r10;
            this.f7021b = r11;
            this.f7022c = r12;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f7023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ByteString f7024b;

        public e(int r10, ByteString r11) {
            this.f7023a = r10;
            this.f7024b = r11;
        }
    }

    static {
        f6992x = Collections.singletonList(Protocol.HTTP_1_1);
    }

    public a(Request r10, long r11, c4.a r12, Random r13) {
        this.f6998f = new ArrayDeque();
        this.f6999g = new ArrayDeque();
        this.f7009q = -1;
        if ("GET".equals(r10.g()) == false) goto L7;
        this.f6994b = r10;
        this.f6993a = r12;
        this.f6995c = r13;
        this.f7000h = r11;
        byte[] r14 = new byte[16];
        r13.nextBytes(r14);
        this.f6996d = ByteString.of(r14).base64();
        this.f6997e = new RunnableC0087a(this);
        return;
    L7:
        throw new IllegalArgumentException("Request must be GET: " + r10.g());
    }

    public static /* synthetic */ c4.a a(a r10) {
        return r10.f6993a;
    }

    public static a f(Request r10, long r11, c4.a r12) {
        return new a(r10, r11, r12, new Random());
    }

    public void b(Response r10) {
        if (r10.d() != 101) goto L18;
        String r11 = r10.f("Connection");
        if ("Upgrade".equalsIgnoreCase(r11) == false) goto L16;
        String r12 = r10.f("Upgrade");
        if ("websocket".equalsIgnoreCase(r12) == false) goto L14;
        String r13 = r10.f(HttpHeaders.SEC_WEBSOCKET_ACCEPT);
        String r14 = ByteString.encodeUtf8(this.f6996d + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
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

    public synchronized boolean c(int r10, String r11, long r12) {
        monitor-enter(this);
        c4.b.c(r10);     // Catch: Throwable -> L10
        if (r11 == null) goto L12;
        ByteString r13 = ByteString.encodeUtf8(r11);     // Catch: Throwable -> L10
        if (r13.size() > 123) goto L9;
    L14:
        if (this.f7011s == false) goto L16;
    L21:
        monitor-exit(this);
        return false;
    L16:
        if (this.f7007o == true) goto L21;
        this.f7007o = true;     // Catch: Throwable -> L10
        this.f6999g.add(new d(r10, r13, r12));     // Catch: Throwable -> L10
        j();     // Catch: Throwable -> L10
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

    @Override // okhttp3.WebSocket
    public void cancel() {
        this.f7001i.cancel();
    }

    @Override // okhttp3.WebSocket
    public boolean close(int r10, String r11) {
        return c(r10, r11, 60000);
    }

    public void d(int r10, String r11) {
        this.f6993a = null;
        close(r10, r11);     // Catch: Throwable -> L5
        return;
    }

    public void e(OkHttpClient r10) {
        Request r11 = this.f6994b.h().d("Upgrade", "websocket").d("Connection", "Upgrade").d(HttpHeaders.SEC_WEBSOCKET_KEY, this.f6996d).d(HttpHeaders.SEC_WEBSOCKET_VERSION, Topic.PAGE_ID_VENDOR_ZONE).b();
        Call r12 = Internal.instance.newWebSocketCall(r10, r11);
        this.f7001i = r12;
        r12.enqueue(new b(this, r11));
    }

    public void g(Exception r10, Response r11) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.f7011s == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        this.f7011s = true;     // Catch: Throwable -> L7
        RealWebSocket.Streams r12 = this.f7005m;     // Catch: Throwable -> L7
        this.f7005m = null;     // Catch: Throwable -> L7
        ScheduledFuture r13 = this.f7008p;     // Catch: Throwable -> L7
        if (r13 == null) goto L12;
        r13.cancel(false);     // Catch: Throwable -> L7
    L12:
        ScheduledExecutorService r14 = this.f7004l;     // Catch: Throwable -> L7
        if (r14 == null) goto L15;
        r14.shutdown();     // Catch: Throwable -> L7
    L15:
        monitor-exit(this);     // Catch: Throwable -> L7
        c4.a r15 = this.f6993a;     // Catch: Throwable -> L20
        if (r15 == null) goto L22;
        r15.c(this, r10, r11);     // Catch: Throwable -> L20
    L22:
        Util.closeQuietly(r12);
        return;
    L20:
        th = move-exception;
        Util.closeQuietly(r12);
        throw th;
    }

    public void h(String r10, RealWebSocket.Streams r11) {
        monitor-enter(this);
        this.f7005m = r11;     // Catch: Throwable -> L6
        this.f7003k = new c4.c(r11.client, r11.sink, this.f6995c);     // Catch: Throwable -> L6
        this.f7004l = new ScheduledThreadPoolExecutor(1, Util.threadFactory(r10, false));     // Catch: Throwable -> L6
        if (this.f6999g.isEmpty() == true) goto L8;
        j();     // Catch: Throwable -> L6
    L8:
        monitor-exit(this);     // Catch: Throwable -> L6
        this.f7002j = new WebSocketReader(r11.client, r11.source, this, this.f7000h);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void i() {
    L3:
        if (this.f7009q != (-1)) goto L5;
        this.f7002j.a();
        goto L3
    }

    public final void j() {
        ScheduledExecutorService r10 = this.f7004l;
        if (r10 == null) goto L6;
        r10.execute(this.f6997e);
        return;
    }

    public final synchronized boolean k(ByteString r10, int r11) {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.f7011s == false) goto L6;
    L19:
        monitor-exit(this);
        return false;
    L6:
        if (this.f7007o == true) goto L19;
        if ((this.f7006n + ((long) r10.size())) <= 16777216) goto L15;
        close(1001, null);     // Catch: Throwable -> L13
        monitor-exit(this);
        return false;
    L15:
        this.f7006n += (long) r10.size();     // Catch: Throwable -> L13
        this.f6999g.add(new e(r11, r10));     // Catch: Throwable -> L13
        j();     // Catch: Throwable -> L13
        monitor-exit(this);
        return true;
    }

    public boolean l() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.f7011s == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return false;
    L9:
        c4.c r10 = this.f7003k;     // Catch: Throwable -> L7
        ByteString r11 = (ByteString) this.f6998f.poll();     // Catch: Throwable -> L7
        Object r12 = null;
        if (r11 != null) goto L22;
        Object r13 = this.f6999g.poll();     // Catch: Throwable -> L7
        if ((r13 instanceof d) == false) goto L18;
        int r14 = this.f7009q;     // Catch: Throwable -> L7
        String r15 = this.f7010r;     // Catch: Throwable -> L7
        if (r14 == (-1)) goto L17;
        RealWebSocket.Streams r16 = this.f7005m;     // Catch: Throwable -> L7
        this.f7005m = null;     // Catch: Throwable -> L7
        this.f7004l.shutdown();     // Catch: Throwable -> L7
    L16:
        r12 = r13;
    L23:
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r11 == null) goto L29;
        r10.f(r11);     // Catch: Throwable -> L26
    L45:
        Util.closeQuietly(r16);
        return true;
    L29:
        if ((r12 instanceof e) == false) goto L39;
        ByteString r17 = ((e) r12).f7024b;     // Catch: Throwable -> L26
        BufferedSink r18 = j.c(r10.a(((e) r12).f7023a, r17.size()));     // Catch: Throwable -> L26
        r18.write(r17);     // Catch: Throwable -> L26
        r18.close();     // Catch: Throwable -> L26
        monitor-enter(this);     // Catch: Throwable -> L26
        this.f7006n -= (long) r17.size();     // Catch: Throwable -> L35
        monitor-exit(this);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L26
    L39:
        if ((r12 instanceof d) == false) goto L48;
        d r19 = (d) r12;     // Catch: Throwable -> L26
        r10.b(r19.f7020a, r19.f7021b);     // Catch: Throwable -> L26
        if (r16 == null) goto L45;
        c4.a r20 = this.f6993a;     // Catch: Throwable -> L26
        if (r20 == null) goto L45;
        r20.a(this, r14, r15);     // Catch: Throwable -> L26
        goto L45
    L48:
        throw new AssertionError();     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Util.closeQuietly(r16);
        throw th;
    L17:
        this.f7008p = this.f7004l.schedule(new c(this), ((d) r13).f7022c, TimeUnit.MILLISECONDS);     // Catch: Throwable -> L7
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

    public void m(ByteString r10) {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L4:
        if (this.f7011s == false) goto L9;
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L9:
        c4.c r11 = this.f7003k;     // Catch: Throwable -> L7
        if (this.f7015w == false) goto L12;
        int r12 = this.f7012t;     // Catch: Throwable -> L7
    L13:
        this.f7012t++;     // Catch: Throwable -> L7
        this.f7015w = true;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        if (r12 == (-1)) goto L19;
        g(new SocketTimeoutException(WsConstants.PING_NOT_RECEIVE_PONG_MSG), null);
        return;
    L19:
        if (r11 == null) goto L30;
        r11.e(r10);     // Catch: IOException -> L22
        return;
    L22:
        e = move-exception;
        g(e, null);
        return;
    L30:
        return;
    L12:
        r12 = -1;
        goto L13
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public void onReadClose(int r10, String r11) {
        if (r10 == (-1)) goto L35;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (this.f7009q != (-1)) goto L31;
        this.f7009q = r10;     // Catch: Throwable -> L14
        this.f7010r = r11;     // Catch: Throwable -> L14
        RealWebSocket.Streams r12 = null;
        if (this.f7007o == true) goto L10;
    L17:
        monitor-exit(this);     // Catch: Throwable -> L14
        c4.a r13 = this.f6993a;     // Catch: Throwable -> L24
        if (r13 == null) goto L26;
        r13.b(this, r10, r11);     // Catch: Throwable -> L24
        if (r12 == null) goto L26;
        this.f6993a.a(this, r10, r11);     // Catch: Throwable -> L24
    L26:
        Util.closeQuietly(r12);
        return;
    L24:
        th = move-exception;
        Util.closeQuietly(r12);
        throw th;
    L10:
        if (this.f6999g.isEmpty() == false) goto L17;
        RealWebSocket.Streams r14 = this.f7005m;     // Catch: Throwable -> L14
        this.f7005m = null;     // Catch: Throwable -> L14
        ScheduledFuture r15 = this.f7008p;     // Catch: Throwable -> L14
        if (r15 == null) goto L16;
        r15.cancel(false);     // Catch: Throwable -> L14
    L16:
        this.f7004l.shutdown();     // Catch: Throwable -> L14
        r12 = r14;
        goto L17
    L31:
        throw new IllegalStateException("already closed");     // Catch: Throwable -> L14
    L35:
        throw new IllegalArgumentException();
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String r10) {
        c4.a r11 = this.f6993a;
        if (r11 == null) goto L6;
        r11.d(this, r10);
        return;
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPing(ByteString r10) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.f7011s == false) goto L6;
    L15:
        monitor-exit(this);
        return;
    L6:
        if (this.f7007o == true) goto L8;
    L12:
        this.f6998f.add(r10);     // Catch: Throwable -> L10
        j();     // Catch: Throwable -> L10
        this.f7013u++;     // Catch: Throwable -> L10
        monitor-exit(this);
        return;
    L8:
        if (this.f6999g.isEmpty() == false) goto L12;
        goto L12
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public synchronized void onReadPong(ByteString r10) {
        monitor-enter(this);
        this.f7014v++;     // Catch: Throwable -> L7
        this.f7015w = false;     // Catch: Throwable -> L7
        c4.a r11 = this.f6993a;     // Catch: Throwable -> L7
        if (r11 == null) goto L9;
        r11.g(this, r10);     // Catch: Throwable -> L7
    L9:
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.WebSocket
    public synchronized long queueSize() {
        monitor-enter(this);
        long r10 = this.f7006n;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r10;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.WebSocket
    public Request request() {
        return this.f6994b;
    }

    @Override // okhttp3.WebSocket
    public boolean send(String r10) {
        if (r10 == null) goto L6;
        return k(ByteString.encodeUtf8(r10), 1);
    L6:
        throw new NullPointerException("text == null");
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.CustomHeartBeatWebSocket
    public void sendPing(ByteString r10) {
        if (r10 != null) goto L4;
        r10 = ByteString.EMPTY;
    L4:
        m(r10);
    }

    @Override // com.bytedance.common.wschannel.channel.impl.ok.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString r10) {
        c4.a r11 = this.f6993a;
        if (r11 == null) goto L6;
        r11.e(this, r10);
        return;
    }

    @Override // okhttp3.WebSocket
    public boolean send(ByteString r10) {
        if (r10 == null) goto L6;
        return k(r10, 2);
    L6:
        throw new NullPointerException("bytes == null");
    }
}
