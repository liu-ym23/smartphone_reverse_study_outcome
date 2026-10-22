package org.java_websocket.client;

import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import io.ktor.sse.ServerSentEventKt;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import javax.net.SocketFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import kc.AbstractC4846a;
import nc.f;
import nc.h;
import org.java_websocket.d;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.exceptions.InvalidHandshakeException;

/* loaded from: classes5.dex */
public abstract class b extends org.java_websocket.a implements Runnable, org.java_websocket.b {
    private CountDownLatch closeLatch;
    private CountDownLatch connectLatch;
    private Thread connectReadThread;
    private int connectTimeout;
    private org.java_websocket.client.a dnsResolver;
    private AbstractC4846a draft;
    private d engine;
    private Map<String, String> headers;
    private OutputStream ostream;
    private Proxy proxy;
    private Socket socket;
    private SocketFactory socketFactory;
    protected URI uri;
    private Thread writeThread;

    public class a implements org.java_websocket.client.a {
        public a() {
        }

        @Override // org.java_websocket.client.a
        public InetAddress a(URI uri) throws UnknownHostException {
            return InetAddress.getByName(uri.getHost());
        }
    }

    /* renamed from: org.java_websocket.client.b$b, reason: collision with other inner class name */
    public class RunnableC0489b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final b f37812a;

        public RunnableC0489b(b bVar) {
            this.f37812a = bVar;
        }

        public final void a() throws IOException {
            try {
                if (b.this.socket != null) {
                    b.this.socket.close();
                }
            } catch (IOException e10) {
                b.this.l(this.f37812a, e10);
            }
        }

        public final void b() throws InterruptedException, IOException {
            while (!Thread.interrupted()) {
                try {
                    ByteBuffer byteBufferTake = b.this.engine.f37815b.take();
                    b.this.ostream.write(byteBufferTake.array(), 0, byteBufferTake.limit());
                    b.this.ostream.flush();
                } catch (InterruptedException unused) {
                    for (ByteBuffer byteBuffer : b.this.engine.f37815b) {
                        b.this.ostream.write(byteBuffer.array(), 0, byteBuffer.limit());
                        b.this.ostream.flush();
                    }
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() throws IOException {
            Thread.currentThread().setName("WebSocketWriteThread-" + Thread.currentThread().getId());
            try {
                b();
            } catch (IOException e10) {
                b.this.N(e10);
            } finally {
                a();
            }
        }
    }

    public b(URI uri) {
        this(uri, new kc.b());
    }

    public void I() {
        if (this.writeThread != null) {
            this.engine.a(1000);
        }
    }

    public void J() throws InterruptedException {
        I();
        this.closeLatch.await();
    }

    public void K() {
        if (this.connectReadThread != null) {
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
        Thread thread = new Thread(this);
        this.connectReadThread = thread;
        thread.setDaemon(w());
        this.connectReadThread.setName("WebSocketConnectReadThread-" + this.connectReadThread.getId());
        this.connectReadThread.start();
    }

    public final int L() {
        int port = this.uri.getPort();
        String scheme = this.uri.getScheme();
        if ("wss".equals(scheme)) {
            if (port == -1) {
                return 443;
            }
        } else {
            if (!"ws".equals(scheme)) {
                throw new IllegalArgumentException("unknown scheme: " + scheme);
            }
            if (port == -1) {
                return 80;
            }
        }
        return port;
    }

    public ReadyState M() {
        return this.engine.r();
    }

    public final void N(IOException iOException) {
        if (iOException instanceof SSLException) {
            U(iOException);
        }
        this.engine.m();
    }

    public boolean O() {
        return this.engine.t();
    }

    public boolean P() {
        return this.engine.u();
    }

    public boolean Q() {
        return this.engine.v();
    }

    public abstract void R(int i10, String str, boolean z10);

    public void S(int i10, String str) {
    }

    public void T(int i10, String str, boolean z10) {
    }

    public abstract void U(Exception exc);

    public abstract void V(String str);

    public void W(ByteBuffer byteBuffer) {
    }

    public abstract void X(h hVar);

    public void Y(SSLParameters sSLParameters) {
        sSLParameters.setEndpointIdentificationAlgorithm("HTTPS");
    }

    public final boolean Z() throws IOException {
        if (this.proxy != Proxy.NO_PROXY) {
            this.socket = new Socket(this.proxy);
            return true;
        }
        SocketFactory socketFactory = this.socketFactory;
        if (socketFactory != null) {
            this.socket = socketFactory.createSocket();
            return false;
        }
        Socket socket = this.socket;
        if (socket == null) {
            this.socket = new Socket(this.proxy);
            return true;
        }
        if (socket.isClosed()) {
            throw new IOException();
        }
        return false;
    }

    public void a0() throws InterruptedException, IOException {
        b0();
        K();
    }

    @Override // org.java_websocket.e
    public void b(org.java_websocket.b bVar, int i10, String str, boolean z10) {
        T(i10, str, z10);
    }

    public final void b0() throws InterruptedException, IOException {
        Socket socket;
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread == this.writeThread || threadCurrentThread == this.connectReadThread) {
            throw new IllegalStateException("You cannot initialize a reconnect out of the websocket thread. Use reconnect in another thread to ensure a successful cleanup.");
        }
        try {
            if (this.engine.r() == ReadyState.NOT_YET_CONNECTED && (socket = this.socket) != null) {
                socket.close();
            }
            J();
            Thread thread = this.writeThread;
            if (thread != null) {
                thread.interrupt();
                this.writeThread.join();
                this.writeThread = null;
            }
            Thread thread2 = this.connectReadThread;
            if (thread2 != null) {
                thread2.interrupt();
                this.connectReadThread.join();
                this.connectReadThread = null;
            }
            this.draft.q();
            Socket socket2 = this.socket;
            if (socket2 != null) {
                socket2.close();
                this.socket = null;
            }
            this.connectLatch = new CountDownLatch(1);
            this.closeLatch = new CountDownLatch(1);
            this.engine = new d(this, this.draft);
        } catch (Exception e10) {
            U(e10);
            this.engine.e(1006, e10.getMessage());
        }
    }

    @Override // org.java_websocket.e
    public final void c(org.java_websocket.b bVar, ByteBuffer byteBuffer) {
        W(byteBuffer);
    }

    public void c0(byte[] bArr) {
        this.engine.z(bArr);
    }

    public final void d0() throws InvalidHandshakeException {
        String rawPath = this.uri.getRawPath();
        String rawQuery = this.uri.getRawQuery();
        if (rawPath == null || rawPath.length() == 0) {
            rawPath = "/";
        }
        if (rawQuery != null) {
            rawPath = rawPath + '?' + rawQuery;
        }
        int iL = L();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.uri.getHost());
        sb2.append((iL == 80 || iL == 443) ? "" : ServerSentEventKt.COLON + iL);
        String string = sb2.toString();
        nc.d dVar = new nc.d();
        dVar.g(rawPath);
        dVar.a(e.f30852k, string);
        Map<String, String> map = this.headers;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                dVar.a(entry.getKey(), entry.getValue());
            }
        }
        this.engine.B(dVar);
    }

    public final void e0() throws NoSuchAlgorithmException, IOException, KeyManagementException {
        SocketFactory socketFactory = this.socketFactory;
        this.socket = (socketFactory instanceof SSLSocketFactory ? (SSLSocketFactory) socketFactory : (SSLSocketFactory) SSLSocketFactory.getDefault()).createSocket(this.socket, this.uri.getHost(), L(), true);
    }

    @Override // org.java_websocket.e
    public final void f(org.java_websocket.b bVar, f fVar) {
        C();
        X((h) fVar);
        this.connectLatch.countDown();
    }

    @Override // org.java_websocket.e
    public final void j(org.java_websocket.b bVar) {
    }

    @Override // org.java_websocket.e
    public void k(org.java_websocket.b bVar, int i10, String str) {
        S(i10, str);
    }

    @Override // org.java_websocket.e
    public final void l(org.java_websocket.b bVar, Exception exc) {
        U(exc);
    }

    @Override // org.java_websocket.e
    public final void m(org.java_websocket.b bVar, String str) {
        V(str);
    }

    @Override // org.java_websocket.b
    public void n(mc.f fVar) {
        this.engine.n(fVar);
    }

    @Override // org.java_websocket.e
    public final void o(org.java_websocket.b bVar, int i10, String str, boolean z10) {
        D();
        Thread thread = this.writeThread;
        if (thread != null) {
            thread.interrupt();
        }
        R(i10, str, z10);
        this.connectLatch.countDown();
        this.closeLatch.countDown();
    }

    @Override // java.lang.Runnable
    public void run() throws InterruptedException, IOException {
        int i10;
        try {
            boolean Z10 = Z();
            this.socket.setTcpNoDelay(y());
            this.socket.setReuseAddress(x());
            int iV = v();
            if (iV > 0) {
                this.socket.setReceiveBufferSize(iV);
            }
            if (!this.socket.isConnected()) {
                this.socket.connect(this.dnsResolver == null ? InetSocketAddress.createUnresolved(this.uri.getHost(), L()) : new InetSocketAddress(this.dnsResolver.a(this.uri), L()), this.connectTimeout);
            }
            if (Z10 && "wss".equals(this.uri.getScheme())) {
                e0();
            }
            Socket socket = this.socket;
            if (socket instanceof SSLSocket) {
                SSLSocket sSLSocket = (SSLSocket) socket;
                SSLParameters sSLParameters = sSLSocket.getSSLParameters();
                Y(sSLParameters);
                sSLSocket.setSSLParameters(sSLParameters);
            }
            InputStream inputStream = this.socket.getInputStream();
            this.ostream = this.socket.getOutputStream();
            d0();
            Thread thread = this.writeThread;
            if (thread != null) {
                thread.interrupt();
                try {
                    this.writeThread.join();
                } catch (InterruptedException unused) {
                }
            }
            Thread thread2 = new Thread(new RunnableC0489b(this));
            this.writeThread = thread2;
            thread2.setDaemon(w());
            this.writeThread.start();
            int iV2 = v();
            if (iV2 <= 0) {
                iV2 = org.java_websocket.a.DEFAULT_READ_BUFFER_SIZE;
            }
            byte[] bArr = new byte[iV2];
            while (!P() && !O() && (i10 = inputStream.read(bArr)) != -1) {
                try {
                    this.engine.j(ByteBuffer.wrap(bArr, 0, i10));
                } catch (IOException e10) {
                    N(e10);
                    return;
                } catch (RuntimeException e11) {
                    U(e11);
                    this.engine.e(1006, e11.getMessage());
                    return;
                }
            }
            this.engine.m();
        } catch (Exception e12) {
            l(this.engine, e12);
            this.engine.e(-1, e12.getMessage());
        } catch (InternalError e13) {
            if (!(e13.getCause() instanceof InvocationTargetException) || !(e13.getCause().getCause() instanceof IOException)) {
                throw e13;
            }
            IOException iOException = (IOException) e13.getCause().getCause();
            l(this.engine, iOException);
            this.engine.e(-1, iOException.getMessage());
        }
    }

    @Override // org.java_websocket.a
    public Collection<org.java_websocket.b> u() {
        return Collections.singletonList(this.engine);
    }

    public b(URI uri, AbstractC4846a abstractC4846a) {
        this(uri, abstractC4846a, null, 0);
    }

    public b(URI uri, AbstractC4846a abstractC4846a, Map<String, String> map, int i10) {
        this.uri = null;
        this.engine = null;
        this.socket = null;
        this.socketFactory = null;
        this.proxy = Proxy.NO_PROXY;
        this.connectLatch = new CountDownLatch(1);
        this.closeLatch = new CountDownLatch(1);
        this.connectTimeout = 0;
        this.dnsResolver = null;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (abstractC4846a != null) {
            this.uri = uri;
            this.draft = abstractC4846a;
            this.dnsResolver = new a();
            if (map != null) {
                TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
                this.headers = treeMap;
                treeMap.putAll(map);
            }
            this.connectTimeout = i10;
            B(false);
            A(false);
            this.engine = new d(this, abstractC4846a);
            return;
        }
        throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
}
