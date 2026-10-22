package nb;

import ab.e0;
import ab.u;
import ab.w;
import ab.z;
import c1.o;
import h4.n;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.zip.Inflater;
import ob.t;

/* loaded from: classes.dex */
public final class g implements e0, j {

    /* renamed from: w, reason: collision with root package name */
    public static final List f6949w = a.a.S(u.HTTP_1_1);

    /* renamed from: a, reason: collision with root package name */
    public final s7.a f6950a;

    /* renamed from: b, reason: collision with root package name */
    public final Random f6951b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6952c;

    /* renamed from: d, reason: collision with root package name */
    public h f6953d;

    /* renamed from: e, reason: collision with root package name */
    public final long f6954e;

    /* renamed from: f, reason: collision with root package name */
    public final String f6955f;

    /* renamed from: g, reason: collision with root package name */
    public eb.i f6956g;

    /* renamed from: h, reason: collision with root package name */
    public e f6957h;

    /* renamed from: i, reason: collision with root package name */
    public k f6958i;

    /* renamed from: j, reason: collision with root package name */
    public l f6959j;

    /* renamed from: k, reason: collision with root package name */
    public final db.c f6960k;

    /* renamed from: l, reason: collision with root package name */
    public String f6961l;

    /* renamed from: m, reason: collision with root package name */
    public eb.l f6962m;

    /* renamed from: n, reason: collision with root package name */
    public final ArrayDeque f6963n;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayDeque f6964o;

    /* renamed from: p, reason: collision with root package name */
    public long f6965p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f6966q;

    /* renamed from: r, reason: collision with root package name */
    public int f6967r;

    /* renamed from: s, reason: collision with root package name */
    public String f6968s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f6969t;

    /* renamed from: u, reason: collision with root package name */
    public int f6970u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f6971v;

    public g(db.e eVar, w wVar, s7.a aVar, Random random, long j2, long j4) {
        q7.k.e(eVar, "taskRunner");
        this.f6950a = aVar;
        this.f6951b = random;
        this.f6952c = j2;
        this.f6953d = null;
        this.f6954e = j4;
        this.f6960k = eVar.e();
        this.f6963n = new ArrayDeque();
        this.f6964o = new ArrayDeque();
        this.f6967r = -1;
        String str = wVar.f662b;
        if (!"GET".equals(str)) {
            throw new IllegalArgumentException(a1.a.w("Request must be GET: ", str).toString());
        }
        ob.k kVar = ob.k.f7997i;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.f6955f = n.q(bArr).a();
    }

    public final void a(z zVar, o oVar) {
        int i2 = zVar.f687i;
        if (i2 != 101) {
            StringBuilder sb2 = new StringBuilder("Expected HTTP 101 response but was '");
            sb2.append(i2);
            sb2.append(' ');
            throw new ProtocolException(a1.a.l(sb2, zVar.f686h, '\''));
        }
        String strA = z.a(zVar, "Connection");
        if (!"Upgrade".equalsIgnoreCase(strA)) {
            throw new ProtocolException(a1.a.e('\'', "Expected 'Connection' header value 'Upgrade' but was '", strA));
        }
        String strA2 = z.a(zVar, "Upgrade");
        if (!"websocket".equalsIgnoreCase(strA2)) {
            throw new ProtocolException(a1.a.e('\'', "Expected 'Upgrade' header value 'websocket' but was '", strA2));
        }
        String strA3 = z.a(zVar, "Sec-WebSocket-Accept");
        ob.k kVar = ob.k.f7997i;
        String strA4 = n.j(this.f6955f + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").c("SHA-1").a();
        if (q7.k.a(strA4, strA3)) {
            if (oVar == null) {
                throw new ProtocolException("Web Socket exchange missing: bad interceptor?");
            }
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + strA4 + "' but was '" + strA3 + '\'');
    }

    public final boolean b(int i2, String str) {
        String str2;
        synchronized (this) {
            ob.k kVarJ = null;
            try {
                if (i2 < 1000 || i2 >= 5000) {
                    str2 = "Code must be in range [1000,5000): " + i2;
                } else if ((1004 > i2 || i2 >= 1007) && (1015 > i2 || i2 >= 3000)) {
                    str2 = null;
                } else {
                    str2 = "Code " + i2 + " is reserved and may not be used.";
                }
                if (str2 != null) {
                    throw new IllegalArgumentException(str2.toString());
                }
                if (str != null) {
                    ob.k kVar = ob.k.f7997i;
                    kVarJ = n.j(str);
                    if (kVarJ.f7998f.length > 123) {
                        throw new IllegalArgumentException("reason.size() > 123: ".concat(str).toString());
                    }
                }
                if (!this.f6969t && !this.f6966q) {
                    this.f6966q = true;
                    this.f6964o.add(new c(i2, kVarJ));
                    f();
                    return true;
                }
                return false;
            } finally {
            }
        }
    }

    public final void c(Exception exc, z zVar) {
        synchronized (this) {
            if (this.f6969t) {
                return;
            }
            this.f6969t = true;
            eb.l lVar = this.f6962m;
            this.f6962m = null;
            k kVar = this.f6958i;
            this.f6958i = null;
            l lVar2 = this.f6959j;
            this.f6959j = null;
            this.f6960k.e();
            try {
                this.f6950a.M(this, exc, zVar);
            } finally {
                if (lVar != null) {
                    bb.b.d(lVar);
                }
                if (kVar != null) {
                    bb.b.d(kVar);
                }
                if (lVar2 != null) {
                    bb.b.d(lVar2);
                }
            }
        }
    }

    public final void d(String str, eb.l lVar) {
        g gVar;
        q7.k.e(str, "name");
        h hVar = this.f6953d;
        q7.k.b(hVar);
        synchronized (this) {
            try {
                this.f6961l = str;
                this.f6962m = lVar;
                this.f6959j = new l(lVar.f3294g, this.f6951b, hVar.f6972a, hVar.f6974c, this.f6954e);
                this.f6957h = new e(this);
                long j2 = this.f6952c;
                if (j2 != 0) {
                    long nanos = TimeUnit.MILLISECONDS.toNanos(j2);
                    gVar = this;
                    try {
                        this.f6960k.c(new hb.n(str.concat(" ping"), gVar, nanos, 1), nanos);
                    } catch (Throwable th) {
                        th = th;
                        Throwable th2 = th;
                        throw th2;
                    }
                } else {
                    gVar = this;
                }
                if (!gVar.f6964o.isEmpty()) {
                    gVar.f();
                }
                gVar.f6958i = new k(lVar.f3293f, gVar, hVar.f6972a, hVar.f6976e);
            } catch (Throwable th3) {
                th = th3;
                gVar = this;
            }
        }
    }

    public final void e() {
        while (this.f6967r == -1) {
            k kVar = this.f6958i;
            q7.k.b(kVar);
            kVar.b();
            if (!kVar.f6989n) {
                j jVar = kVar.f6982g;
                ob.h hVar = kVar.f6992q;
                int i2 = kVar.f6986k;
                if (i2 != 1 && i2 != 2) {
                    byte[] bArr = bb.b.f1659a;
                    String hexString = Integer.toHexString(i2);
                    q7.k.d(hexString, "toHexString(this)");
                    throw new ProtocolException("Unknown opcode: ".concat(hexString));
                }
                while (!kVar.f6985j) {
                    long j2 = kVar.f6987l;
                    if (j2 > 0) {
                        kVar.f6981f.J(hVar, j2);
                    }
                    if (kVar.f6988m) {
                        if (kVar.f6990o) {
                            a aVar = kVar.f6993r;
                            if (aVar == null) {
                                aVar = new a(kVar.f6984i, 1);
                                kVar.f6993r = aVar;
                            }
                            Inflater inflater = (Inflater) aVar.f6937i;
                            ob.h hVar2 = aVar.f6936h;
                            if (hVar2.f7993g != 0) {
                                throw new IllegalArgumentException("Failed requirement.");
                            }
                            if (aVar.f6935g) {
                                inflater.reset();
                            }
                            hVar2.K(hVar);
                            hVar2.S(65535);
                            long bytesRead = inflater.getBytesRead() + hVar2.f7993g;
                            do {
                                ((t) aVar.f6938j).a(hVar, Long.MAX_VALUE);
                            } while (inflater.getBytesRead() < bytesRead);
                        }
                        if (i2 == 1) {
                            String strZ = hVar.z();
                            g gVar = (g) jVar;
                            gVar.getClass();
                            gVar.f6950a.N(gVar, strZ);
                        } else {
                            ob.k kVarJ = hVar.j(hVar.f7993g);
                            g gVar2 = (g) jVar;
                            gVar2.getClass();
                            q7.k.e(kVarJ, "bytes");
                            gVar2.f6950a.O(gVar2, kVarJ);
                        }
                    } else {
                        while (!kVar.f6985j) {
                            kVar.b();
                            if (!kVar.f6989n) {
                                break;
                            } else {
                                kVar.a();
                            }
                        }
                        if (kVar.f6986k != 0) {
                            int i10 = kVar.f6986k;
                            byte[] bArr2 = bb.b.f1659a;
                            String hexString2 = Integer.toHexString(i10);
                            q7.k.d(hexString2, "toHexString(this)");
                            throw new ProtocolException("Expected continuation opcode. Got: ".concat(hexString2));
                        }
                    }
                }
                throw new IOException("closed");
            }
            kVar.a();
        }
    }

    public final void f() {
        byte[] bArr = bb.b.f1659a;
        e eVar = this.f6957h;
        if (eVar != null) {
            this.f6960k.c(eVar, 0L);
        }
    }

    public final synchronized boolean g(int i2, ob.k kVar) {
        if (!this.f6969t && !this.f6966q) {
            long j2 = this.f6965p;
            byte[] bArr = kVar.f7998f;
            if (bArr.length + j2 > 16777216) {
                b(1001, null);
                return false;
            }
            this.f6965p = j2 + bArr.length;
            this.f6964o.add(new d(i2, kVar));
            f();
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074 A[Catch: all -> 0x0080, TRY_ENTER, TryCatch #0 {all -> 0x0080, blocks: (B:28:0x0074, B:31:0x0083, B:33:0x0087, B:34:0x0093, B:36:0x009f, B:39:0x00a3, B:40:0x00a4, B:41:0x00a5, B:43:0x00a9, B:73:0x011b, B:75:0x011f, B:84:0x0138, B:85:0x013a, B:61:0x00d4, B:65:0x00f9, B:66:0x0102, B:62:0x00e8, B:67:0x0103, B:69:0x010d, B:70:0x0110, B:86:0x013b, B:87:0x0140, B:35:0x0094, B:72:0x0118), top: B:97:0x0072, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0083 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:28:0x0074, B:31:0x0083, B:33:0x0087, B:34:0x0093, B:36:0x009f, B:39:0x00a3, B:40:0x00a4, B:41:0x00a5, B:43:0x00a9, B:73:0x011b, B:75:0x011f, B:84:0x0138, B:85:0x013a, B:61:0x00d4, B:65:0x00f9, B:66:0x0102, B:62:0x00e8, B:67:0x0103, B:69:0x010d, B:70:0x0110, B:86:0x013b, B:87:0x0140, B:35:0x0094, B:72:0x0118), top: B:97:0x0072, inners: #1, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0129 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x012e A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0133 A[DONT_GENERATE] */
    /* JADX WARN: Type inference failed for: r7v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7, types: [nb.l] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean h() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: nb.g.h():boolean");
    }
}
