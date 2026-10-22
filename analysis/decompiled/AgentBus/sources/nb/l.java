package nb;

import java.io.Closeable;
import java.io.IOException;
import java.util.Random;
import java.util.zip.Deflater;
import ob.f0;

/* loaded from: classes.dex */
public final class l implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public final ob.i f6995f;

    /* renamed from: g, reason: collision with root package name */
    public final Random f6996g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f6997h;

    /* renamed from: i, reason: collision with root package name */
    public final boolean f6998i;

    /* renamed from: j, reason: collision with root package name */
    public final long f6999j;

    /* renamed from: k, reason: collision with root package name */
    public final ob.h f7000k;

    /* renamed from: l, reason: collision with root package name */
    public final ob.h f7001l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f7002m;

    /* renamed from: n, reason: collision with root package name */
    public a f7003n;

    /* renamed from: o, reason: collision with root package name */
    public final byte[] f7004o;

    /* renamed from: p, reason: collision with root package name */
    public final ob.g f7005p;

    public l(ob.i iVar, Random random, boolean z4, boolean z10, long j2) {
        q7.k.e(iVar, "sink");
        this.f6995f = iVar;
        this.f6996g = random;
        this.f6997h = z4;
        this.f6998i = z10;
        this.f6999j = j2;
        this.f7000k = new ob.h();
        this.f7001l = iVar.c();
        this.f7004o = new byte[4];
        this.f7005p = new ob.g();
    }

    public final void a(int i2, ob.k kVar) {
        if (this.f7002m) {
            throw new IOException("closed");
        }
        int iD = kVar.d();
        if (iD > 125) {
            throw new IllegalArgumentException("Payload size must be less than or equal to 125");
        }
        ob.h hVar = this.f7001l;
        hVar.Q(i2 | 128);
        hVar.Q(iD | 128);
        byte[] bArr = this.f7004o;
        q7.k.b(bArr);
        this.f6996g.nextBytes(bArr);
        hVar.m22write(bArr);
        if (iD > 0) {
            long j2 = hVar.f7993g;
            hVar.H(kVar);
            ob.g gVar = this.f7005p;
            q7.k.b(gVar);
            hVar.q(gVar);
            gVar.b(j2);
            i.M(gVar, bArr);
            gVar.close();
        }
        this.f6995f.flush();
    }

    public final void b(int i2, ob.k kVar) throws IOException {
        if (this.f7002m) {
            throw new IOException("closed");
        }
        ob.h hVar = this.f7000k;
        hVar.H(kVar);
        int i10 = i2 | 128;
        if (this.f6997h && kVar.f7998f.length >= this.f6999j) {
            a aVar = this.f7003n;
            if (aVar == null) {
                aVar = new a(this.f6998i, 0);
                this.f7003n = aVar;
            }
            gb.f fVar = (gb.f) aVar.f6938j;
            ob.h hVar2 = aVar.f6936h;
            if (hVar2.f7993g != 0) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            if (aVar.f6935g) {
                ((Deflater) aVar.f6937i).reset();
            }
            fVar.write(hVar, hVar.f7993g);
            fVar.flush();
            if (hVar2.o(hVar2.f7993g - r2.f7998f.length, b.f6939a)) {
                long j2 = hVar2.f7993g - 4;
                ob.g gVarQ = hVar2.q(ob.b.f7952a);
                try {
                    gVarQ.a(j2);
                    gVarQ.close();
                } finally {
                }
            } else {
                hVar2.Q(0);
            }
            hVar.write(hVar2, hVar2.f7993g);
            i10 = i2 | 192;
        }
        long j4 = hVar.f7993g;
        ob.h hVar3 = this.f7001l;
        hVar3.Q(i10);
        if (j4 <= 125) {
            hVar3.Q(((int) j4) | 128);
        } else if (j4 <= 65535) {
            hVar3.Q(254);
            hVar3.T((int) j4);
        } else {
            hVar3.Q(255);
            f0 f0VarE = hVar3.E(8);
            byte[] bArr = f0VarE.f7975a;
            int i11 = f0VarE.f7977c;
            bArr[i11] = (byte) ((j4 >>> 56) & 255);
            bArr[i11 + 1] = (byte) ((j4 >>> 48) & 255);
            bArr[i11 + 2] = (byte) ((j4 >>> 40) & 255);
            bArr[i11 + 3] = (byte) ((j4 >>> 32) & 255);
            bArr[i11 + 4] = (byte) ((j4 >>> 24) & 255);
            bArr[i11 + 5] = (byte) ((j4 >>> 16) & 255);
            bArr[i11 + 6] = (byte) ((j4 >>> 8) & 255);
            bArr[i11 + 7] = (byte) (j4 & 255);
            f0VarE.f7977c = i11 + 8;
            hVar3.f7993g += 8;
        }
        byte[] bArr2 = this.f7004o;
        q7.k.b(bArr2);
        this.f6996g.nextBytes(bArr2);
        hVar3.m22write(bArr2);
        if (j4 > 0) {
            ob.g gVar = this.f7005p;
            q7.k.b(gVar);
            hVar.q(gVar);
            gVar.b(0L);
            i.M(gVar, bArr2);
            gVar.close();
        }
        hVar3.write(hVar, j4);
        this.f6995f.m();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        a aVar = this.f7003n;
        if (aVar != null) {
            aVar.close();
        }
    }
}
