package okhttp3.internal.ws;

import bd.i;
import bd.l;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.g;
import okhttp3.f;
import okio.ByteString;
import qd.c;
import sd.e;
import sd.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final h f11289a;

    /* renamed from: b, reason: collision with root package name */
    public final a f11290b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f11291c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f11292d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f11293e;
    public int h;

    /* renamed from: j, reason: collision with root package name */
    public long f11294j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f11295k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f11296l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f11297m;

    /* renamed from: n, reason: collision with root package name */
    public final e f11298n;

    /* renamed from: o, reason: collision with root package name */
    public final e f11299o;

    /* renamed from: p, reason: collision with root package name */
    public c f11300p;

    /* renamed from: q, reason: collision with root package name */
    public final byte[] f11301q;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public interface a {
        void b(ByteString byteString);

        void c(String str);

        void d(ByteString byteString);

        void f(ByteString byteString);

        void g(int i10, String str);
    }

    public b(h source, a aVar, boolean z, boolean z3) {
        g.f(source, "source");
        this.f11289a = source;
        this.f11290b = aVar;
        this.f11291c = z;
        this.f11292d = z3;
        this.f11298n = new e();
        this.f11299o = new e();
        this.f11301q = null;
    }

    public final void a() throws DataFormatException, IOException {
        w();
        if (this.f11296l) {
            o();
            return;
        }
        int i10 = this.h;
        if (i10 != 1 && i10 != 2) {
            f fVar = l.f3237a;
            String hexString = Integer.toHexString(i10);
            g.e(hexString, "toHexString(...)");
            throw new ProtocolException("Unknown opcode: ".concat(hexString));
        }
        while (!this.f11293e) {
            long j10 = this.f11294j;
            e buffer = this.f11299o;
            if (j10 > 0) {
                this.f11289a.I(buffer, j10);
            }
            if (this.f11295k) {
                if (this.f11297m) {
                    c cVar = this.f11300p;
                    if (cVar == null) {
                        cVar = new c(this.f11292d);
                        this.f11300p = cVar;
                    }
                    Inflater inflater = cVar.f11655c;
                    g.f(buffer, "buffer");
                    e eVar = cVar.f11654b;
                    if (eVar.f11926b != 0) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                    if (cVar.f11653a) {
                        inflater.reset();
                    }
                    eVar.u(buffer);
                    eVar.R0(65535);
                    long bytesRead = inflater.getBytesRead() + eVar.f11926b;
                    do {
                        cVar.f11656d.a(buffer, Long.MAX_VALUE);
                        if (inflater.getBytesRead() >= bytesRead) {
                            break;
                        }
                    } while (!inflater.finished());
                }
                a aVar = this.f11290b;
                if (i10 == 1) {
                    aVar.c(buffer.J0());
                    return;
                } else {
                    aVar.b(buffer.X(buffer.f11926b));
                    return;
                }
            }
            while (!this.f11293e) {
                w();
                if (!this.f11296l) {
                    break;
                } else {
                    o();
                }
            }
            if (this.h != 0) {
                int i11 = this.h;
                f fVar2 = l.f3237a;
                String hexString2 = Integer.toHexString(i11);
                g.e(hexString2, "toHexString(...)");
                throw new ProtocolException("Expected continuation opcode. Got: ".concat(hexString2));
            }
        }
        throw new IOException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        c cVar = this.f11300p;
        if (cVar != null) {
            cVar.close();
        }
    }

    public final void o() throws ProtocolException, EOFException {
        short s8;
        String strJ0;
        long j10 = this.f11294j;
        e eVar = this.f11298n;
        if (j10 > 0) {
            this.f11289a.I(eVar, j10);
        }
        int i10 = this.h;
        a aVar = this.f11290b;
        switch (i10) {
            case 8:
                long j11 = eVar.f11926b;
                if (j11 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (j11 != 0) {
                    s8 = eVar.readShort();
                    strJ0 = eVar.J0();
                    String strA = (s8 < 1000 || s8 >= 5000) ? ai.onnxruntime.providers.a.a(s8, "Code must be in range [1000,5000): ") : ((1004 > s8 || s8 >= 1007) && (1015 > s8 || s8 >= 3000)) ? null : ai.onnxruntime.a.g(s8, "Code ", " is reserved and may not be used.");
                    if (strA != null) {
                        throw new ProtocolException(strA);
                    }
                } else {
                    s8 = 1005;
                    strJ0 = "";
                }
                aVar.g(s8, strJ0);
                this.f11293e = true;
                return;
            case 9:
                aVar.d(eVar.X(eVar.f11926b));
                return;
            case 10:
                aVar.f(eVar.X(eVar.f11926b));
                return;
            default:
                int i11 = this.h;
                f fVar = l.f3237a;
                String hexString = Integer.toHexString(i11);
                g.e(hexString, "toHexString(...)");
                throw new ProtocolException("Unknown control opcode: ".concat(hexString));
        }
    }

    public final void w() throws IOException {
        boolean z;
        if (this.f11293e) {
            throw new IOException("closed");
        }
        h hVar = this.f11289a;
        long jH = hVar.timeout().h();
        hVar.timeout().b();
        try {
            byte b10 = hVar.readByte();
            byte[] bArr = i.f3230a;
            hVar.timeout().g(jH, TimeUnit.NANOSECONDS);
            int i10 = b10 & 15;
            this.h = i10;
            boolean z3 = (b10 & 128) != 0;
            this.f11295k = z3;
            boolean z10 = (b10 & 8) != 0;
            this.f11296l = z10;
            if (z10 && !z3) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z11 = (b10 & 64) != 0;
            if (i10 == 1 || i10 == 2) {
                if (!z11) {
                    z = false;
                } else {
                    if (!this.f11291c) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z = true;
                }
                this.f11297m = z;
            } else if (z11) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((b10 & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((b10 & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            byte b11 = hVar.readByte();
            boolean z12 = (b11 & 128) != 0;
            if (z12) {
                throw new ProtocolException("Server-sent frames must not be masked.");
            }
            long j10 = b11 & 127;
            this.f11294j = j10;
            if (j10 == 126) {
                this.f11294j = hVar.readShort() & 65535;
            } else if (j10 == 127) {
                long j11 = hVar.readLong();
                this.f11294j = j11;
                if (j11 < 0) {
                    StringBuilder sb2 = new StringBuilder("Frame length 0x");
                    long j12 = this.f11294j;
                    f fVar = l.f3237a;
                    String hexString = Long.toHexString(j12);
                    g.e(hexString, "toHexString(...)");
                    sb2.append(hexString);
                    sb2.append(" > 0x7FFFFFFFFFFFFFFF");
                    throw new ProtocolException(sb2.toString());
                }
            }
            if (this.f11296l && this.f11294j > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z12) {
                byte[] bArr2 = this.f11301q;
                g.c(bArr2);
                hVar.readFully(bArr2);
            }
        } catch (Throwable th) {
            hVar.timeout().g(jH, TimeUnit.NANOSECONDS);
            throw th;
        }
    }
}
