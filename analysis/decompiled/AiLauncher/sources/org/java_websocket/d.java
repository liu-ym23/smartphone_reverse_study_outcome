package org.java_websocket;

import com.amap.api.services.core.AMapException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import kc.AbstractC4846a;
import mc.f;
import mc.h;
import org.java_websocket.enums.CloseHandshakeType;
import org.java_websocket.enums.HandshakeState;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.enums.Role;
import org.java_websocket.exceptions.IncompleteHandshakeException;
import org.java_websocket.exceptions.InvalidDataException;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.exceptions.LimitExceededException;
import org.java_websocket.exceptions.WebsocketNotConnectedException;

/* loaded from: classes5.dex */
public class d implements b {

    /* renamed from: b, reason: collision with root package name */
    public final BlockingQueue<ByteBuffer> f37815b;

    /* renamed from: c, reason: collision with root package name */
    public final BlockingQueue<ByteBuffer> f37816c;

    /* renamed from: d, reason: collision with root package name */
    public final e f37817d;

    /* renamed from: e, reason: collision with root package name */
    public SelectionKey f37818e;

    /* renamed from: f, reason: collision with root package name */
    public ByteChannel f37819f;

    /* renamed from: i, reason: collision with root package name */
    public List<AbstractC4846a> f37822i;

    /* renamed from: j, reason: collision with root package name */
    public AbstractC4846a f37823j;

    /* renamed from: k, reason: collision with root package name */
    public Role f37824k;

    /* renamed from: a, reason: collision with root package name */
    public final vc.c f37814a = vc.e.l(d.class);

    /* renamed from: g, reason: collision with root package name */
    public boolean f37820g = false;

    /* renamed from: h, reason: collision with root package name */
    public volatile ReadyState f37821h = ReadyState.NOT_YET_CONNECTED;

    /* renamed from: l, reason: collision with root package name */
    public ByteBuffer f37825l = ByteBuffer.allocate(0);

    /* renamed from: m, reason: collision with root package name */
    public nc.a f37826m = null;

    /* renamed from: n, reason: collision with root package name */
    public String f37827n = null;

    /* renamed from: o, reason: collision with root package name */
    public Integer f37828o = null;

    /* renamed from: p, reason: collision with root package name */
    public Boolean f37829p = null;

    /* renamed from: q, reason: collision with root package name */
    public String f37830q = null;

    /* renamed from: r, reason: collision with root package name */
    public long f37831r = System.nanoTime();

    /* renamed from: s, reason: collision with root package name */
    public final Object f37832s = new Object();

    public d(e eVar, AbstractC4846a abstractC4846a) {
        this.f37823j = null;
        if (eVar == null || (abstractC4846a == null && this.f37824k == Role.SERVER)) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.f37815b = new LinkedBlockingQueue();
        this.f37816c = new LinkedBlockingQueue();
        this.f37817d = eVar;
        this.f37824k = Role.CLIENT;
        if (abstractC4846a != null) {
            this.f37823j = abstractC4846a.e();
        }
    }

    public void A() throws NullPointerException {
        h hVarE = this.f37817d.e(this);
        if (hVarE == null) {
            throw new NullPointerException("onPreparePing(WebSocket) returned null. PingFrame to sent can't be null.");
        }
        n(hVarE);
    }

    public void B(nc.b bVar) throws InvalidHandshakeException {
        this.f37826m = this.f37823j.k(bVar);
        this.f37830q = bVar.d();
        try {
            this.f37817d.g(this, this.f37826m);
            E(this.f37823j.h(this.f37826m));
        } catch (RuntimeException e10) {
            this.f37814a.error("Exception in startHandshake", e10);
            this.f37817d.l(this, e10);
            throw new InvalidHandshakeException("rejected because of " + e10);
        } catch (InvalidDataException unused) {
            throw new InvalidHandshakeException("Handshake data rejected by client.");
        }
    }

    public void C() {
        this.f37831r = System.nanoTime();
    }

    public final void D(ByteBuffer byteBuffer) {
        this.f37814a.b("write({}): {}", Integer.valueOf(byteBuffer.remaining()), byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
        this.f37815b.add(byteBuffer);
        this.f37817d.j(this);
    }

    public final void E(List<ByteBuffer> list) {
        synchronized (this.f37832s) {
            try {
                Iterator<ByteBuffer> it = list.iterator();
                while (it.hasNext()) {
                    D(it.next());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(int i10) {
        c(i10, "", false);
    }

    public void b(int i10, String str) {
        c(i10, str, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0041 A[Catch: all -> 0x001f, InvalidDataException -> 0x0033, TRY_LEAVE, TryCatch #1 {InvalidDataException -> 0x0033, blocks: (B:19:0x002d, B:25:0x003b, B:27:0x0041, B:24:0x0036), top: B:45:0x002d, outer: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void c(int r6, java.lang.String r7, boolean r8) {
        /*
            r5 = this;
            monitor-enter(r5)
            org.java_websocket.enums.ReadyState r0 = r5.f37821h     // Catch: java.lang.Throwable -> L1f
            org.java_websocket.enums.ReadyState r1 = org.java_websocket.enums.ReadyState.CLOSING     // Catch: java.lang.Throwable -> L1f
            if (r0 == r1) goto L85
            org.java_websocket.enums.ReadyState r0 = r5.f37821h     // Catch: java.lang.Throwable -> L1f
            org.java_websocket.enums.ReadyState r2 = org.java_websocket.enums.ReadyState.CLOSED     // Catch: java.lang.Throwable -> L1f
            if (r0 == r2) goto L85
            org.java_websocket.enums.ReadyState r0 = r5.f37821h     // Catch: java.lang.Throwable -> L1f
            org.java_websocket.enums.ReadyState r2 = org.java_websocket.enums.ReadyState.OPEN     // Catch: java.lang.Throwable -> L1f
            r3 = 0
            if (r0 != r2) goto L68
            r0 = 1006(0x3ee, float:1.41E-42)
            if (r6 != r0) goto L21
            r5.f37821h = r1     // Catch: java.lang.Throwable -> L1f
            r5.o(r6, r7, r3)     // Catch: java.lang.Throwable -> L1f
            monitor-exit(r5)
            return
        L1f:
            r6 = move-exception
            goto L87
        L21:
            kc.a r1 = r5.f37823j     // Catch: java.lang.Throwable -> L1f
            org.java_websocket.enums.CloseHandshakeType r1 = r1.j()     // Catch: java.lang.Throwable -> L1f
            org.java_websocket.enums.CloseHandshakeType r2 = org.java_websocket.enums.CloseHandshakeType.NONE     // Catch: java.lang.Throwable -> L1f
            if (r1 == r2) goto L64
            if (r8 != 0) goto L3b
            org.java_websocket.e r1 = r5.f37817d     // Catch: java.lang.Throwable -> L1f org.java_websocket.exceptions.InvalidDataException -> L33 java.lang.RuntimeException -> L35
            r1.k(r5, r6, r7)     // Catch: java.lang.Throwable -> L1f org.java_websocket.exceptions.InvalidDataException -> L33 java.lang.RuntimeException -> L35
            goto L3b
        L33:
            r1 = move-exception
            goto L53
        L35:
            r1 = move-exception
            org.java_websocket.e r2 = r5.f37817d     // Catch: java.lang.Throwable -> L1f org.java_websocket.exceptions.InvalidDataException -> L33
            r2.l(r5, r1)     // Catch: java.lang.Throwable -> L1f org.java_websocket.exceptions.InvalidDataException -> L33
        L3b:
            boolean r1 = r5.v()     // Catch: java.lang.Throwable -> L1f org.java_websocket.exceptions.InvalidDataException -> L33
            if (r1 == 0) goto L64
            mc.b r1 = new mc.b     // Catch: java.lang.Throwable -> L1f org.java_websocket.exceptions.InvalidDataException -> L33
            r1.<init>()     // Catch: java.lang.Throwable -> L1f org.java_websocket.exceptions.InvalidDataException -> L33
            r1.r(r7)     // Catch: java.lang.Throwable -> L1f org.java_websocket.exceptions.InvalidDataException -> L33
            r1.q(r6)     // Catch: java.lang.Throwable -> L1f org.java_websocket.exceptions.InvalidDataException -> L33
            r1.h()     // Catch: java.lang.Throwable -> L1f org.java_websocket.exceptions.InvalidDataException -> L33
            r5.n(r1)     // Catch: java.lang.Throwable -> L1f org.java_websocket.exceptions.InvalidDataException -> L33
            goto L64
        L53:
            vc.c r2 = r5.f37814a     // Catch: java.lang.Throwable -> L1f
            java.lang.String r4 = "generated frame is invalid"
            r2.error(r4, r1)     // Catch: java.lang.Throwable -> L1f
            org.java_websocket.e r2 = r5.f37817d     // Catch: java.lang.Throwable -> L1f
            r2.l(r5, r1)     // Catch: java.lang.Throwable -> L1f
            java.lang.String r1 = "generated frame is invalid"
            r5.o(r0, r1, r3)     // Catch: java.lang.Throwable -> L1f
        L64:
            r5.o(r6, r7, r8)     // Catch: java.lang.Throwable -> L1f
            goto L7c
        L68:
            r0 = -3
            if (r6 != r0) goto L70
            r6 = 1
            r5.o(r0, r7, r6)     // Catch: java.lang.Throwable -> L1f
            goto L7c
        L70:
            r0 = 1002(0x3ea, float:1.404E-42)
            if (r6 != r0) goto L78
            r5.o(r6, r7, r8)     // Catch: java.lang.Throwable -> L1f
            goto L7c
        L78:
            r6 = -1
            r5.o(r6, r7, r3)     // Catch: java.lang.Throwable -> L1f
        L7c:
            org.java_websocket.enums.ReadyState r6 = org.java_websocket.enums.ReadyState.CLOSING     // Catch: java.lang.Throwable -> L1f
            r5.f37821h = r6     // Catch: java.lang.Throwable -> L1f
            r6 = 0
            r5.f37825l = r6     // Catch: java.lang.Throwable -> L1f
            monitor-exit(r5)
            return
        L85:
            monitor-exit(r5)
            return
        L87:
            monitor-exit(r5)     // Catch: java.lang.Throwable -> L1f
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.java_websocket.d.c(int, java.lang.String, boolean):void");
    }

    public void d(InvalidDataException invalidDataException) {
        c(invalidDataException.a(), invalidDataException.getMessage(), false);
    }

    public void e(int i10, String str) {
        f(i10, str, false);
    }

    public synchronized void f(int i10, String str, boolean z10) {
        try {
            if (this.f37821h == ReadyState.CLOSED) {
                return;
            }
            if (this.f37821h == ReadyState.OPEN && i10 == 1006) {
                this.f37821h = ReadyState.CLOSING;
            }
            SelectionKey selectionKey = this.f37818e;
            if (selectionKey != null) {
                selectionKey.cancel();
            }
            ByteChannel byteChannel = this.f37819f;
            if (byteChannel != null) {
                try {
                    byteChannel.close();
                } catch (IOException e10) {
                    if (e10.getMessage() == null || !e10.getMessage().equals("Broken pipe")) {
                        this.f37814a.error("Exception during channel.close()", e10);
                        this.f37817d.l(this, e10);
                    } else {
                        this.f37814a.trace("Caught IOException: Broken pipe during closeConnection()", e10);
                    }
                }
            }
            try {
                this.f37817d.o(this, i10, str, z10);
            } catch (RuntimeException e11) {
                this.f37817d.l(this, e11);
            }
            AbstractC4846a abstractC4846a = this.f37823j;
            if (abstractC4846a != null) {
                abstractC4846a.q();
            }
            this.f37826m = null;
            this.f37821h = ReadyState.CLOSED;
        } catch (Throwable th) {
            throw th;
        }
    }

    public void g(int i10, boolean z10) {
        f(i10, "", z10);
    }

    public final void h(RuntimeException runtimeException) {
        D(p(500));
        o(-1, runtimeException.getMessage(), false);
    }

    public final void i(InvalidDataException invalidDataException) {
        D(p(404));
        o(invalidDataException.a(), invalidDataException.getMessage(), false);
    }

    public void j(ByteBuffer byteBuffer) {
        if (this.f37814a.isTraceEnabled()) {
            this.f37814a.b("process({}): ({})", Integer.valueOf(byteBuffer.remaining()), byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining()));
        }
        if (this.f37821h != ReadyState.NOT_YET_CONNECTED) {
            if (this.f37821h == ReadyState.OPEN) {
                k(byteBuffer);
            }
        } else {
            if (!l(byteBuffer) || u() || t()) {
                return;
            }
            if (byteBuffer.hasRemaining()) {
                k(byteBuffer);
            } else if (this.f37825l.hasRemaining()) {
                k(this.f37825l);
            }
        }
    }

    public final void k(ByteBuffer byteBuffer) {
        try {
            for (f fVar : this.f37823j.s(byteBuffer)) {
                this.f37814a.m("matched frame: {}", fVar);
                this.f37823j.m(this, fVar);
            }
        } catch (LinkageError | ThreadDeath | VirtualMachineError e10) {
            this.f37814a.error("Got fatal error during frame processing");
            throw e10;
        } catch (Error e11) {
            this.f37814a.error("Closing web socket due to an error during frame processing");
            this.f37817d.l(this, new Exception(e11));
            b(AMapException.CODE_AMAP_NOT_SUPPORT_HTTPS, "Got error " + e11.getClass().getName());
        } catch (LimitExceededException e12) {
            if (e12.b() == Integer.MAX_VALUE) {
                this.f37814a.error("Closing due to invalid size of frame", e12);
                this.f37817d.l(this, e12);
            }
            d(e12);
        } catch (InvalidDataException e13) {
            this.f37814a.error("Closing due to invalid data in frame", e13);
            this.f37817d.l(this, e13);
            d(e13);
        }
    }

    public final boolean l(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        Role role;
        nc.f fVarT;
        if (this.f37825l.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.f37825l.remaining() < byteBuffer.remaining()) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.f37825l.capacity() + byteBuffer.remaining());
                this.f37825l.flip();
                byteBufferAllocate.put(this.f37825l);
                this.f37825l = byteBufferAllocate;
            }
            this.f37825l.put(byteBuffer);
            this.f37825l.flip();
            byteBuffer2 = this.f37825l;
        }
        byteBuffer2.mark();
        try {
            try {
                role = this.f37824k;
            } catch (InvalidHandshakeException e10) {
                this.f37814a.trace("Closing due to invalid handshake", e10);
                d(e10);
            }
        } catch (IncompleteHandshakeException e11) {
            if (this.f37825l.capacity() == 0) {
                byteBuffer2.reset();
                int iA = e11.a();
                if (iA == 0) {
                    iA = byteBuffer2.capacity() + 16;
                }
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(iA);
                this.f37825l = byteBufferAllocate2;
                byteBufferAllocate2.put(byteBuffer);
            } else {
                ByteBuffer byteBuffer3 = this.f37825l;
                byteBuffer3.position(byteBuffer3.limit());
                ByteBuffer byteBuffer4 = this.f37825l;
                byteBuffer4.limit(byteBuffer4.capacity());
            }
        }
        if (role != Role.SERVER) {
            if (role == Role.CLIENT) {
                this.f37823j.r(role);
                nc.f fVarT2 = this.f37823j.t(byteBuffer2);
                if (!(fVarT2 instanceof nc.h)) {
                    this.f37814a.trace("Closing due to protocol error: wrong http function");
                    o(1002, "wrong http function", false);
                    return false;
                }
                nc.h hVar = (nc.h) fVarT2;
                if (this.f37823j.a(this.f37826m, hVar) == HandshakeState.MATCHED) {
                    try {
                        this.f37817d.d(this, this.f37826m, hVar);
                        w(hVar);
                        return true;
                    } catch (RuntimeException e12) {
                        this.f37814a.error("Closing since client was never connected", e12);
                        this.f37817d.l(this, e12);
                        o(-1, e12.getMessage(), false);
                        return false;
                    } catch (InvalidDataException e13) {
                        this.f37814a.trace("Closing due to invalid data exception. Possible handshake rejection", e13);
                        o(e13.a(), e13.getMessage(), false);
                        return false;
                    }
                }
                this.f37814a.m("Closing due to protocol error: draft {} refuses handshake", this.f37823j);
                b(1002, "draft " + this.f37823j + " refuses handshake");
            }
            return false;
        }
        AbstractC4846a abstractC4846a = this.f37823j;
        if (abstractC4846a != null) {
            nc.f fVarT3 = abstractC4846a.t(byteBuffer2);
            if (!(fVarT3 instanceof nc.a)) {
                this.f37814a.trace("Closing due to protocol error: wrong http function");
                o(1002, "wrong http function", false);
                return false;
            }
            nc.a aVar = (nc.a) fVarT3;
            if (this.f37823j.b(aVar) == HandshakeState.MATCHED) {
                w(aVar);
                return true;
            }
            this.f37814a.trace("Closing due to protocol error: the handshake did finally not match");
            b(1002, "the handshake did finally not match");
            return false;
        }
        Iterator<AbstractC4846a> it = this.f37822i.iterator();
        while (it.hasNext()) {
            AbstractC4846a abstractC4846aE = it.next().e();
            try {
                abstractC4846aE.r(this.f37824k);
                byteBuffer2.reset();
                fVarT = abstractC4846aE.t(byteBuffer2);
            } catch (InvalidHandshakeException unused) {
            }
            if (!(fVarT instanceof nc.a)) {
                this.f37814a.trace("Closing due to wrong handshake");
                i(new InvalidDataException(1002, "wrong http function"));
                return false;
            }
            nc.a aVar2 = (nc.a) fVarT;
            if (abstractC4846aE.b(aVar2) == HandshakeState.MATCHED) {
                this.f37830q = aVar2.d();
                try {
                    E(abstractC4846aE.h(abstractC4846aE.l(aVar2, this.f37817d.i(this, abstractC4846aE, aVar2))));
                    this.f37823j = abstractC4846aE;
                    w(aVar2);
                    return true;
                } catch (RuntimeException e14) {
                    this.f37814a.error("Closing due to internal server error", e14);
                    this.f37817d.l(this, e14);
                    h(e14);
                    return false;
                } catch (InvalidDataException e15) {
                    this.f37814a.trace("Closing due to wrong handshake. Possible handshake rejection", e15);
                    i(e15);
                    return false;
                }
            }
        }
        if (this.f37823j == null) {
            this.f37814a.trace("Closing due to protocol error: no draft matches");
            i(new InvalidDataException(1002, "no draft matches"));
        }
        return false;
    }

    public void m() {
        if (this.f37821h == ReadyState.NOT_YET_CONNECTED) {
            g(-1, true);
            return;
        }
        if (this.f37820g) {
            f(this.f37828o.intValue(), this.f37827n, this.f37829p.booleanValue());
            return;
        }
        if (this.f37823j.j() == CloseHandshakeType.NONE) {
            g(1000, true);
            return;
        }
        if (this.f37823j.j() != CloseHandshakeType.ONEWAY) {
            g(1006, true);
        } else if (this.f37824k == Role.SERVER) {
            g(1006, true);
        } else {
            g(1000, true);
        }
    }

    @Override // org.java_websocket.b
    public void n(f fVar) {
        y(Collections.singletonList(fVar));
    }

    public synchronized void o(int i10, String str, boolean z10) {
        if (this.f37820g) {
            return;
        }
        this.f37828o = Integer.valueOf(i10);
        this.f37827n = str;
        this.f37829p = Boolean.valueOf(z10);
        this.f37820g = true;
        this.f37817d.j(this);
        try {
            this.f37817d.b(this, i10, str, z10);
        } catch (RuntimeException e10) {
            this.f37814a.error("Exception in onWebsocketClosing", e10);
            this.f37817d.l(this, e10);
        }
        AbstractC4846a abstractC4846a = this.f37823j;
        if (abstractC4846a != null) {
            abstractC4846a.q();
        }
        this.f37826m = null;
    }

    public final ByteBuffer p(int i10) {
        String str = i10 != 404 ? "500 Internal Server Error" : "404 WebSocket Upgrade Failure";
        return ByteBuffer.wrap(pc.c.a("HTTP/1.1 " + str + "\r\nContent-Type: text/html\r\nServer: TooTallNate Java-WebSocket\r\nContent-Length: " + (str.length() + 48) + "\r\n\r\n<html><head></head><body><h1>" + str + "</h1></body></html>"));
    }

    public long q() {
        return this.f37831r;
    }

    public ReadyState r() {
        return this.f37821h;
    }

    public e s() {
        return this.f37817d;
    }

    public boolean t() {
        return this.f37821h == ReadyState.CLOSED;
    }

    public String toString() {
        return super.toString();
    }

    public boolean u() {
        return this.f37821h == ReadyState.CLOSING;
    }

    public boolean v() {
        return this.f37821h == ReadyState.OPEN;
    }

    public final void w(nc.f fVar) {
        this.f37814a.m("open using draft: {}", this.f37823j);
        this.f37821h = ReadyState.OPEN;
        C();
        try {
            this.f37817d.f(this, fVar);
        } catch (RuntimeException e10) {
            this.f37817d.l(this, e10);
        }
    }

    public void x(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("Cannot send 'null' data to a WebSocketImpl.");
        }
        y(this.f37823j.g(byteBuffer, this.f37824k == Role.CLIENT));
    }

    public final void y(Collection<f> collection) {
        if (!v()) {
            throw new WebsocketNotConnectedException();
        }
        if (collection == null) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList();
        for (f fVar : collection) {
            this.f37814a.m("send frame: {}", fVar);
            arrayList.add(this.f37823j.f(fVar));
        }
        E(arrayList);
    }

    public void z(byte[] bArr) {
        x(ByteBuffer.wrap(bArr));
    }
}
