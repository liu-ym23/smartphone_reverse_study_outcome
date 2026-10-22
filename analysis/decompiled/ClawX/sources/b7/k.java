package b7;

import c7.m;
import com.stepos.stepclaw.SecurePrefs;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.p;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.bouncycastle.crypto.digests.Blake2xsDigest;
import org.bouncycastle.crypto.hpke.HPKE;
import org.tukaani.xz.common.Util;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    public final c7.h f975a;

    /* renamed from: b, reason: collision with root package name */
    public final j f976b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f977c;
    public final boolean d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f978e;

    /* renamed from: f, reason: collision with root package name */
    public int f979f;

    /* renamed from: g, reason: collision with root package name */
    public long f980g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f981h;

    /* renamed from: j, reason: collision with root package name */
    public boolean f982j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f983k;

    /* renamed from: l, reason: collision with root package name */
    public final c7.f f984l;

    /* renamed from: m, reason: collision with root package name */
    public final c7.f f985m;

    /* renamed from: n, reason: collision with root package name */
    public a f986n;

    /* renamed from: o, reason: collision with root package name */
    public final byte[] f987o;

    public k(c7.h source, j jVar, boolean z, boolean z2) {
        p.e(source, "source");
        this.f975a = source;
        this.f976b = jVar;
        this.f977c = z;
        this.d = z2;
        this.f984l = new c7.f();
        this.f985m = new c7.f();
        this.f987o = null;
    }

    public final void a() throws DataFormatException, IOException {
        e();
        if (this.f982j) {
            b();
            return;
        }
        int i8 = this.f979f;
        if (i8 != 1 && i8 != 2) {
            TimeZone timeZone = o6.f.f4330a;
            String hexString = Integer.toHexString(i8);
            p.d(hexString, "toHexString(...)");
            throw new ProtocolException("Unknown opcode: ".concat(hexString));
        }
        while (!this.f978e) {
            long j4 = this.f980g;
            c7.f fVar = this.f985m;
            if (j4 > 0) {
                this.f975a.D(j4, fVar);
            }
            if (this.f981h) {
                if (this.f983k) {
                    a aVar = this.f986n;
                    if (aVar == null) {
                        aVar = new a(this.d, 1);
                        this.f986n = aVar;
                    }
                    c7.f fVar2 = aVar.f933c;
                    if (fVar2.f1164b != 0) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                    Inflater inflater = (Inflater) aVar.d;
                    if (inflater == null) {
                        inflater = new Inflater(true);
                        aVar.d = inflater;
                    }
                    m mVar = (m) aVar.f934e;
                    if (mVar == null) {
                        mVar = new m(c7.b.b(fVar2), inflater);
                        aVar.f934e = mVar;
                    }
                    if (aVar.f932b) {
                        inflater.reset();
                    }
                    fVar2.z(fVar);
                    fVar2.F(Blake2xsDigest.UNKNOWN_DIGEST_LENGTH);
                    long bytesRead = inflater.getBytesRead() + fVar2.f1164b;
                    do {
                        mVar.a(Util.VLI_MAX, fVar);
                        if (inflater.getBytesRead() >= bytesRead) {
                            break;
                        }
                    } while (!inflater.finished());
                    if (inflater.getBytesRead() < bytesRead) {
                        fVar2.skip(fVar2.f1164b);
                        mVar.close();
                        aVar.f934e = null;
                        aVar.d = null;
                    }
                }
                j jVar = this.f976b;
                if (i8 == 1) {
                    h hVar = (h) jVar;
                    hVar.f948a.onMessage(hVar, fVar.o());
                    return;
                } else {
                    c7.i bytes = fVar.i(fVar.f1164b);
                    h hVar2 = (h) jVar;
                    p.e(bytes, "bytes");
                    hVar2.f948a.onMessage(hVar2, bytes);
                    return;
                }
            }
            while (!this.f978e) {
                e();
                if (!this.f982j) {
                    break;
                } else {
                    b();
                }
            }
            if (this.f979f != 0) {
                int i9 = this.f979f;
                TimeZone timeZone2 = o6.f.f4330a;
                String hexString2 = Integer.toHexString(i9);
                p.d(hexString2, "toHexString(...)");
                throw new ProtocolException("Expected continuation opcode. Got: ".concat(hexString2));
            }
        }
        throw new IOException("closed");
    }

    public final void b() throws ProtocolException, EOFException {
        String strO;
        short s8;
        long j4 = this.f980g;
        if (j4 > 0) {
            this.f975a.D(j4, this.f984l);
        }
        switch (this.f979f) {
            case 8:
                c7.f fVar = this.f984l;
                long j8 = fVar.f1164b;
                if (j8 == 1) {
                    throw new ProtocolException("Malformed close payload length of 1.");
                }
                if (j8 != 0) {
                    s8 = fVar.readShort();
                    strO = this.f984l.o();
                    String strJ = (s8 < 1000 || s8 >= 5000) ? a8.b.j(s8, "Code must be in range [1000,5000): ") : ((1004 > s8 || s8 >= 1007) && (1015 > s8 || s8 >= 3000)) ? null : a8.b.k(s8, "Code ", " is reserved and may not be used.");
                    if (strJ != null) {
                        throw new ProtocolException(strJ);
                    }
                } else {
                    strO = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
                    s8 = 1005;
                }
                h hVar = (h) this.f976b;
                if (s8 == -1) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                synchronized (hVar) {
                    if (hVar.f965s != -1) {
                        throw new IllegalStateException("already closed");
                    }
                    hVar.f965s = s8;
                    hVar.f966t = strO;
                }
                hVar.f948a.onClosing(hVar, s8, strO);
                this.f978e = true;
                return;
            case 9:
                j jVar = this.f976b;
                c7.f fVar2 = this.f984l;
                c7.i payload = fVar2.i(fVar2.f1164b);
                h hVar2 = (h) jVar;
                synchronized (hVar2) {
                    try {
                        p.e(payload, "payload");
                        if (!hVar2.f967u && (!hVar2.f964r || !hVar2.f962p.isEmpty())) {
                            hVar2.f961o.add(payload);
                            hVar2.e();
                            return;
                        }
                        return;
                    } finally {
                    }
                }
            case 10:
                j jVar2 = this.f976b;
                c7.f fVar3 = this.f984l;
                c7.i payload2 = fVar3.i(fVar3.f1164b);
                h hVar3 = (h) jVar2;
                synchronized (hVar3) {
                    p.e(payload2, "payload");
                    hVar3.f969w = false;
                }
                return;
            default:
                int i8 = this.f979f;
                TimeZone timeZone = o6.f.f4330a;
                String hexString = Integer.toHexString(i8);
                p.d(hexString, "toHexString(...)");
                throw new ProtocolException("Unknown control opcode: ".concat(hexString));
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        a aVar = this.f986n;
        if (aVar != null) {
            o6.d.a(aVar);
        }
        o6.d.a(this.f975a);
    }

    public final void e() throws IOException {
        boolean z;
        if (this.f978e) {
            throw new IOException("closed");
        }
        c7.h hVar = this.f975a;
        long jH = hVar.d().h();
        hVar.d().b();
        try {
            byte b9 = hVar.readByte();
            byte[] bArr = o6.d.f4327a;
            hVar.d().g(jH, TimeUnit.NANOSECONDS);
            int i8 = b9 & 15;
            this.f979f = i8;
            boolean z2 = (b9 & 128) != 0;
            this.f981h = z2;
            boolean z8 = (b9 & 8) != 0;
            this.f982j = z8;
            if (z8 && !z2) {
                throw new ProtocolException("Control frames must be final.");
            }
            boolean z9 = (b9 & 64) != 0;
            if (i8 == 1 || i8 == 2) {
                if (!z9) {
                    z = false;
                } else {
                    if (!this.f977c) {
                        throw new ProtocolException("Unexpected rsv1 flag");
                    }
                    z = true;
                }
                this.f983k = z;
            } else if (z9) {
                throw new ProtocolException("Unexpected rsv1 flag");
            }
            if ((b9 & 32) != 0) {
                throw new ProtocolException("Unexpected rsv2 flag");
            }
            if ((b9 & 16) != 0) {
                throw new ProtocolException("Unexpected rsv3 flag");
            }
            byte b10 = hVar.readByte();
            boolean z10 = (b10 & 128) != 0;
            if (z10) {
                throw new ProtocolException("Server-sent frames must not be masked.");
            }
            long j4 = b10 & AbstractJsonLexerKt.TC_INVALID;
            this.f980g = j4;
            if (j4 == 126) {
                this.f980g = hVar.readShort() & HPKE.aead_EXPORT_ONLY;
            } else if (j4 == 127) {
                long j8 = hVar.readLong();
                this.f980g = j8;
                if (j8 < 0) {
                    StringBuilder sb = new StringBuilder("Frame length 0x");
                    long j9 = this.f980g;
                    TimeZone timeZone = o6.f.f4330a;
                    String hexString = Long.toHexString(j9);
                    p.d(hexString, "toHexString(...)");
                    sb.append(hexString);
                    sb.append(" > 0x7FFFFFFFFFFFFFFF");
                    throw new ProtocolException(sb.toString());
                }
            }
            if (this.f982j && this.f980g > 125) {
                throw new ProtocolException("Control frame must be less than 125B.");
            }
            if (z10) {
                byte[] bArr2 = this.f987o;
                p.b(bArr2);
                hVar.readFully(bArr2);
            }
        } catch (Throwable th) {
            hVar.d().g(jH, TimeUnit.NANOSECONDS);
            throw th;
        }
    }
}
