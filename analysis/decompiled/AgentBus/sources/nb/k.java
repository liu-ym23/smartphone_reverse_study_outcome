package nb;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class k implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public final ob.j f6981f;

    /* renamed from: g, reason: collision with root package name */
    public final j f6982g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f6983h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f6984i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6985j;

    /* renamed from: k, reason: collision with root package name */
    public int f6986k;

    /* renamed from: l, reason: collision with root package name */
    public long f6987l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f6988m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f6989n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f6990o;

    /* renamed from: p, reason: collision with root package name */
    public final ob.h f6991p;

    /* renamed from: q, reason: collision with root package name */
    public final ob.h f6992q;

    /* renamed from: r, reason: collision with root package name */
    public a f6993r;

    /* renamed from: s, reason: collision with root package name */
    public final byte[] f6994s;

    public k(ob.j jVar, g gVar, boolean z4, boolean z10) {
        q7.k.e(jVar, "source");
        q7.k.e(gVar, "frameCallback");
        this.f6981f = jVar;
        this.f6982g = gVar;
        this.f6983h = z4;
        this.f6984i = z10;
        this.f6991p = new ob.h();
        this.f6992q = new ob.h();
        this.f6994s = null;
    }

    public final void a() throws IOException {
        String strZ;
        short s10;
        k kVar;
        l lVar;
        long j2 = this.f6987l;
        if (j2 > 0) {
            this.f6981f.J(this.f6991p, j2);
        }
        switch (this.f6986k) {
            case 8:
                ob.h hVar = this.f6991p;
                long j4 = hVar.f7993g;
                if (j4 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                eb.l lVar2 = null;
                if (j4 != 0) {
                    s10 = hVar.readShort();
                    strZ = this.f6991p.z();
                    String strC = (s10 < 1000 || s10 >= 5000) ? n.f.c(s10, "Code must be in range [1000,5000): ") : ((1004 > s10 || s10 >= 1007) && (1015 > s10 || s10 >= 3000)) ? null : a1.a.f(s10, "Code ", " is reserved and may not be used.");
                    if (strC != null) {
                        throw new ProtocolException(strC);
                    }
                } else {
                    strZ = "";
                    s10 = 1005;
                }
                g gVar = (g) this.f6982g;
                gVar.getClass();
                if (s10 == -1) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                synchronized (gVar) {
                    if (gVar.f6967r != -1) {
                        throw new IllegalStateException("already closed");
                    }
                    gVar.f6967r = s10;
                    gVar.f6968s = strZ;
                    if (gVar.f6966q && gVar.f6964o.isEmpty()) {
                        eb.l lVar3 = gVar.f6962m;
                        gVar.f6962m = null;
                        kVar = gVar.f6958i;
                        gVar.f6958i = null;
                        lVar = gVar.f6959j;
                        gVar.f6959j = null;
                        gVar.f6960k.e();
                        lVar2 = lVar3;
                    } else {
                        kVar = null;
                        lVar = null;
                    }
                }
                try {
                    gVar.f6950a.L(gVar, s10, strZ);
                    if (lVar2 != null) {
                        gVar.f6950a.K(gVar, s10, strZ);
                    }
                    this.f6985j = true;
                    return;
                } finally {
                    if (lVar2 != null) {
                        bb.b.d(lVar2);
                    }
                    if (kVar != null) {
                        bb.b.d(kVar);
                    }
                    if (lVar != null) {
                        bb.b.d(lVar);
                    }
                }
            case 9:
                j jVar = this.f6982g;
                ob.h hVar2 = this.f6991p;
                ob.k kVarJ = hVar2.j(hVar2.f7993g);
                g gVar2 = (g) jVar;
                synchronized (gVar2) {
                    try {
                        q7.k.e(kVarJ, "payload");
                        if (!gVar2.f6969t && (!gVar2.f6966q || !gVar2.f6964o.isEmpty())) {
                            gVar2.f6963n.add(kVarJ);
                            gVar2.f();
                            return;
                        }
                        return;
                    } finally {
                    }
                }
            case 10:
                j jVar2 = this.f6982g;
                ob.h hVar3 = this.f6991p;
                ob.k kVarJ2 = hVar3.j(hVar3.f7993g);
                g gVar3 = (g) jVar2;
                synchronized (gVar3) {
                    q7.k.e(kVarJ2, "payload");
                    gVar3.f6971v = false;
                }
                return;
            default:
                int i2 = this.f6986k;
                byte[] bArr = bb.b.f1659a;
                String hexString = Integer.toHexString(i2);
                q7.k.d(hexString, "toHexString(this)");
                throw new ProtocolException("Unknown control opcode: ".concat(hexString));
        }
    }

    public final void b() throws IOException {
        boolean z4;
        if (this.f6985j) {
            throw new IOException("closed");
        }
        ob.j jVar = this.f6981f;
        long jH = jVar.timeout().h();
        jVar.timeout().b();
        try {
            byte b10 = jVar.readByte();
            byte[] bArr = bb.b.f1659a;
            jVar.timeout().g(jH, TimeUnit.NANOSECONDS);
            int i2 = b10 & 15;
            this.f6986k = i2;
            boolean z10 = (b10 & 128) != 0;
            this.f6988m = z10;
            boolean z11 = (b10 & 8) != 0;
            this.f6989n = z11;
            if (z11 && !z10) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z12 = (b10 & 64) != 0;
            if (i2 == 1 || i2 == 2) {
                if (!z12) {
                    z4 = false;
                } else {
                    if (!this.f6983h) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z4 = true;
                }
                this.f6990o = z4;
            } else if (z12) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((b10 & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((b10 & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            byte b11 = jVar.readByte();
            boolean z13 = (b11 & 128) != 0;
            if (z13) {
                throw new ProtocolException("Server-sent frames must not be masked.");
            }
            long j2 = b11 & 127;
            this.f6987l = j2;
            if (j2 == 126) {
                this.f6987l = jVar.readShort() & 65535;
            } else if (j2 == 127) {
                long j4 = jVar.readLong();
                this.f6987l = j4;
                if (j4 < 0) {
                    StringBuilder sb2 = new StringBuilder("Frame length 0x");
                    String hexString = Long.toHexString(this.f6987l);
                    q7.k.d(hexString, "toHexString(this)");
                    sb2.append(hexString);
                    sb2.append(" > 0x7FFFFFFFFFFFFFFF");
                    throw new ProtocolException(sb2.toString());
                }
            }
            if (this.f6989n && this.f6987l > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z13) {
                byte[] bArr2 = this.f6994s;
                q7.k.b(bArr2);
                jVar.readFully(bArr2);
            }
        } catch (Throwable th) {
            jVar.timeout().g(jH, TimeUnit.NANOSECONDS);
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        a aVar = this.f6993r;
        if (aVar != null) {
            aVar.close();
        }
    }
}
