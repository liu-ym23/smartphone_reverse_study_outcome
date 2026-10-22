package okhttp3.internal.ws;

import ad.v;
import ad.w;
import androidx.datastore.preferences.protobuf.b1;
import bd.i;
import bd.l;
import dd.e;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import kotlin.jvm.internal.Ref$ObjectRef;
import lb.n;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.internal.ws.RealWebSocket;
import okhttp3.internal.ws.b;
import okio.ByteString;
import qd.f;
import sd.g;
import sd.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class RealWebSocket implements v, b.a {

    /* renamed from: x, reason: collision with root package name */
    public static final List<Protocol> f11253x = b1.P(Protocol.f10881d);

    /* renamed from: a, reason: collision with root package name */
    public final w f11254a;

    /* renamed from: b, reason: collision with root package name */
    public final Random f11255b;

    /* renamed from: c, reason: collision with root package name */
    public final long f11256c;

    /* renamed from: d, reason: collision with root package name */
    public qd.d f11257d;

    /* renamed from: e, reason: collision with root package name */
    public final long f11258e;

    /* renamed from: f, reason: collision with root package name */
    public final long f11259f;

    /* renamed from: g, reason: collision with root package name */
    public final String f11260g;
    public okhttp3.internal.connection.d h;

    /* renamed from: i, reason: collision with root package name */
    public d f11261i;

    /* renamed from: j, reason: collision with root package name */
    public okhttp3.internal.ws.b f11262j;

    /* renamed from: k, reason: collision with root package name */
    public f f11263k;

    /* renamed from: l, reason: collision with root package name */
    public final dd.d f11264l;

    /* renamed from: m, reason: collision with root package name */
    public String f11265m;

    /* renamed from: n, reason: collision with root package name */
    public ed.f f11266n;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayDeque<ByteString> f11267o;

    /* renamed from: p, reason: collision with root package name */
    public final ArrayDeque<Object> f11268p;

    /* renamed from: q, reason: collision with root package name */
    public long f11269q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public int f11270s;

    /* renamed from: t, reason: collision with root package name */
    public String f11271t;

    /* renamed from: u, reason: collision with root package name */
    public boolean f11272u;

    /* renamed from: v, reason: collision with root package name */
    public int f11273v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f11274w;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f11275a;

        /* renamed from: b, reason: collision with root package name */
        public final ByteString f11276b;

        /* renamed from: c, reason: collision with root package name */
        public final long f11277c;

        public a(int i10, ByteString byteString, long j10) {
            this.f11275a = i10;
            this.f11276b = byteString;
            this.f11277c = j10;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final ByteString f11278a;

        public b(ByteString byteString) {
            this.f11278a = byteString;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static abstract class c implements Closeable {

        /* renamed from: a, reason: collision with root package name */
        public final h f11279a;

        /* renamed from: b, reason: collision with root package name */
        public final g f11280b;

        public c(h source, g sink) {
            kotlin.jvm.internal.g.f(source, "source");
            kotlin.jvm.internal.g.f(sink, "sink");
            this.f11279a = source;
            this.f11280b = sink;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public final class d extends dd.a {
        public d() {
            super(ai.onnxruntime.a.o(new StringBuilder(), RealWebSocket.this.f11265m, " writer"), true);
        }

        @Override // dd.a
        public final long a() {
            RealWebSocket realWebSocket = RealWebSocket.this;
            try {
                return realWebSocket.l() ? 0L : -1L;
            } catch (IOException e10) {
                RealWebSocket.i(realWebSocket, e10, null, 2);
                return -1L;
            }
        }
    }

    public RealWebSocket(e taskRunner, okhttp3.h hVar, w wVar, Random random, long j10, long j11, long j12) {
        kotlin.jvm.internal.g.f(taskRunner, "taskRunner");
        this.f11254a = wVar;
        this.f11255b = random;
        this.f11256c = j10;
        this.f11257d = null;
        this.f11258e = j11;
        this.f11259f = j12;
        this.f11264l = taskRunner.e();
        this.f11267o = new ArrayDeque<>();
        this.f11268p = new ArrayDeque<>();
        this.f11270s = -1;
        String str = hVar.f10993b;
        if (!"GET".equals(str)) {
            throw new IllegalArgumentException(ai.onnxruntime.a.k("Request must be GET: ", str).toString());
        }
        ByteString byteString = ByteString.f11312d;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        n nVar = n.f10413a;
        this.f11260g = ByteString.a.c(bArr).a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [T, qd.f] */
    public static void i(RealWebSocket realWebSocket, Exception exc, Response response, int i10) {
        T t8 = 0;
        t8 = 0;
        if ((i10 & 2) != 0) {
            response = null;
        }
        boolean z = (i10 & 4) == 0;
        realWebSocket.getClass();
        final Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        final Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
        synchronized (realWebSocket) {
            try {
                if (realWebSocket.f11272u) {
                    return;
                }
                realWebSocket.f11272u = true;
                ed.f fVar = realWebSocket.f11266n;
                ?? r02 = realWebSocket.f11263k;
                ref$ObjectRef2.f10076a = r02;
                realWebSocket.f11263k = null;
                if (r02 != 0 && realWebSocket.f11262j == null) {
                    t8 = fVar;
                }
                ref$ObjectRef.f10076a = t8;
                if (!z && ref$ObjectRef2.f10076a != 0) {
                    dd.d.c(realWebSocket.f11264l, realWebSocket.f11265m + " writer close", 0L, new zb.a<n>() { // from class: okhttp3.internal.ws.RealWebSocket$failWebSocket$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // zb.a
                        public final n invoke() {
                            i.b(ref$ObjectRef2.f10076a);
                            RealWebSocket.c cVar = ref$ObjectRef.f10076a;
                            if (cVar != null) {
                                i.b(cVar);
                            }
                            return n.f10413a;
                        }
                    }, 2);
                }
                realWebSocket.f11264l.f();
                n nVar = n.f10413a;
                try {
                    realWebSocket.f11254a.onFailure(realWebSocket, exc, response);
                    if (fVar != null) {
                        fVar.a();
                    }
                    if (z) {
                        f fVar2 = (f) ref$ObjectRef2.f10076a;
                        if (fVar2 != null) {
                            i.b(fVar2);
                        }
                        c cVar = (c) ref$ObjectRef.f10076a;
                        if (cVar != null) {
                            i.b(cVar);
                        }
                    }
                } finally {
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // ad.v
    public final boolean a(String str) {
        ByteString byteString = ByteString.f11312d;
        ByteString byteStringB = ByteString.a.b(str);
        synchronized (this) {
            if (!this.f11272u && !this.r) {
                long j10 = this.f11269q;
                byte[] bArr = byteStringB.f11313a;
                if (bArr.length + j10 > 16777216) {
                    close(1001, null);
                    return false;
                }
                this.f11269q = j10 + bArr.length;
                this.f11268p.add(new b(byteStringB));
                k();
                return true;
            }
            return false;
        }
    }

    @Override // okhttp3.internal.ws.b.a
    public final void b(ByteString bytes) {
        kotlin.jvm.internal.g.f(bytes, "bytes");
        this.f11254a.onMessage(this, bytes);
    }

    @Override // okhttp3.internal.ws.b.a
    public final void c(String str) {
        this.f11254a.onMessage(this, str);
    }

    @Override // ad.v
    public final void cancel() {
        okhttp3.internal.connection.d dVar = this.h;
        kotlin.jvm.internal.g.c(dVar);
        dVar.cancel();
    }

    @Override // ad.v
    public final boolean close(int i10, String str) {
        String str2;
        long j10 = this.f11259f;
        synchronized (this) {
            ByteString byteStringB = null;
            try {
                if (i10 < 1000 || i10 >= 5000) {
                    str2 = "Code must be in range [1000,5000): " + i10;
                } else if ((1004 > i10 || i10 >= 1007) && (1015 > i10 || i10 >= 3000)) {
                    str2 = null;
                } else {
                    str2 = "Code " + i10 + " is reserved and may not be used.";
                }
                if (str2 != null) {
                    throw new IllegalArgumentException(str2.toString());
                }
                if (str != null) {
                    ByteString byteString = ByteString.f11312d;
                    byteStringB = ByteString.a.b(str);
                    if (byteStringB.f11313a.length > 123) {
                        throw new IllegalArgumentException("reason.size() > 123: ".concat(str).toString());
                    }
                }
                if (!this.f11272u && !this.r) {
                    this.r = true;
                    this.f11268p.add(new a(i10, byteStringB, j10));
                    k();
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    @Override // okhttp3.internal.ws.b.a
    public final synchronized void d(ByteString payload) {
        try {
            kotlin.jvm.internal.g.f(payload, "payload");
            if (!this.f11272u && (!this.r || !this.f11268p.isEmpty())) {
                this.f11267o.add(payload);
                k();
            }
        } finally {
        }
    }

    @Override // ad.v
    public final synchronized long e() {
        return this.f11269q;
    }

    @Override // okhttp3.internal.ws.b.a
    public final synchronized void f(ByteString payload) {
        kotlin.jvm.internal.g.f(payload, "payload");
        this.f11274w = false;
    }

    @Override // okhttp3.internal.ws.b.a
    public final void g(int i10, String str) {
        if (i10 == -1) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        synchronized (this) {
            if (this.f11270s != -1) {
                throw new IllegalStateException("already closed");
            }
            this.f11270s = i10;
            this.f11271t = str;
            n nVar = n.f10413a;
        }
        this.f11254a.onClosing(this, i10, str);
    }

    public final void h(Response response, ed.d dVar) throws ProtocolException {
        int i10 = response.f10891d;
        if (i10 != 101) {
            StringBuilder sb2 = new StringBuilder("Expected HTTP 101 response but was '");
            sb2.append(i10);
            sb2.append(' ');
            throw new ProtocolException(ai.onnxruntime.a.n(sb2, response.f10890c, '\''));
        }
        String strA = Response.a("Connection", response);
        if (!"Upgrade".equalsIgnoreCase(strA)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + strA + '\'');
        }
        String strA2 = Response.a("Upgrade", response);
        if (!"websocket".equalsIgnoreCase(strA2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + strA2 + '\'');
        }
        String strA3 = Response.a("Sec-WebSocket-Accept", response);
        ByteString byteString = ByteString.f11312d;
        String strA4 = ByteString.a.b(this.f11260g + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").c("SHA-1").a();
        if (kotlin.jvm.internal.g.b(strA4, strA3)) {
            if (dVar == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strA4 + "' but was '" + strA3 + '\'');
    }

    public final void j() {
        boolean z;
        int i10;
        String str;
        okhttp3.internal.ws.b bVar;
        ed.f fVar;
        synchronized (this) {
            try {
                z = this.f11272u;
                i10 = this.f11270s;
                str = this.f11271t;
                bVar = this.f11262j;
                this.f11262j = null;
                if (this.r && this.f11268p.isEmpty()) {
                    final f fVar2 = this.f11263k;
                    if (fVar2 != null) {
                        this.f11263k = null;
                        dd.d.c(this.f11264l, this.f11265m + " writer close", 0L, new zb.a<n>() { // from class: okhttp3.internal.ws.RealWebSocket$finishReader$1$1
                            {
                                super(0);
                            }

                            @Override // zb.a
                            public final n invoke() {
                                i.b(fVar2);
                                return n.f10413a;
                            }
                        }, 2);
                    }
                    this.f11264l.f();
                }
                fVar = this.f11263k == null ? this.f11266n : null;
                n nVar = n.f10413a;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z && fVar != null && this.f11270s != -1) {
            w wVar = this.f11254a;
            kotlin.jvm.internal.g.c(str);
            wVar.onClosed(this, i10, str);
        }
        if (bVar != null) {
            i.b(bVar);
        }
        if (fVar != null) {
            i.b(fVar);
        }
    }

    public final void k() {
        okhttp3.f fVar = l.f3237a;
        d dVar = this.f11261i;
        if (dVar != null) {
            this.f11264l.d(dVar, 0L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0081 A[Catch: all -> 0x008d, TRY_ENTER, TryCatch #3 {all -> 0x008d, blocks: (B:36:0x0081, B:39:0x0090, B:41:0x0094, B:42:0x009e, B:44:0x00aa, B:47:0x00ae, B:48:0x00af, B:49:0x00b0, B:51:0x00b4, B:81:0x0126, B:83:0x012a, B:90:0x013e, B:91:0x0140, B:69:0x00df, B:73:0x0104, B:74:0x010d, B:70:0x00f3, B:75:0x010e, B:77:0x0118, B:78:0x011b, B:92:0x0141, B:93:0x0146, B:80:0x0123, B:43:0x009f), top: B:107:0x007f, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0090 A[Catch: all -> 0x008d, TryCatch #3 {all -> 0x008d, blocks: (B:36:0x0081, B:39:0x0090, B:41:0x0094, B:42:0x009e, B:44:0x00aa, B:47:0x00ae, B:48:0x00af, B:49:0x00b0, B:51:0x00b4, B:81:0x0126, B:83:0x012a, B:90:0x013e, B:91:0x0140, B:69:0x00df, B:73:0x0104, B:74:0x010d, B:70:0x00f3, B:75:0x010e, B:77:0x0118, B:78:0x011b, B:92:0x0141, B:93:0x0146, B:80:0x0123, B:43:0x009f), top: B:107:0x007f, inners: #1, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0134 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0139 A[DONT_GENERATE] */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l() {
        /*
            Method dump skipped, instructions count: 340
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.ws.RealWebSocket.l():boolean");
    }
}
