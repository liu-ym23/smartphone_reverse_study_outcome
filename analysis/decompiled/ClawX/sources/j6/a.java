package j6;

import c5.l;
import java.io.EOFException;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a implements j, i {

    /* renamed from: a, reason: collision with root package name */
    public g f3510a;

    /* renamed from: b, reason: collision with root package name */
    public g f3511b;

    /* renamed from: c, reason: collision with root package name */
    public long f3512c;

    public final byte a(long j4) {
        long j8 = 0;
        if (j4 >= 0) {
            long j9 = this.f3512c;
            if (j4 < j9) {
                if (j4 == 0) {
                    g gVar = this.f3510a;
                    p.b(gVar);
                    return gVar.c(0);
                }
                g gVar2 = this.f3510a;
                if (gVar2 == null) {
                    p.b(null);
                    throw null;
                }
                if (j9 - j4 >= j4) {
                    while (gVar2 != null) {
                        long j10 = (gVar2.f3526c - gVar2.f3525b) + j8;
                        if (j10 > j4) {
                            break;
                        }
                        gVar2 = gVar2.f3528f;
                        j8 = j10;
                    }
                    p.b(gVar2);
                    return gVar2.c((int) (j4 - j8));
                }
                g gVar3 = this.f3511b;
                while (gVar3 != null && j9 > j4) {
                    j9 -= gVar3.f3526c - gVar3.f3525b;
                    if (j9 <= j4) {
                        break;
                    }
                    gVar3 = gVar3.f3529g;
                }
                p.b(gVar3);
                return gVar3.c((int) (j4 - j9));
            }
        }
        StringBuilder sb = new StringBuilder("position (");
        sb.append(j4);
        sb.append(") is not within the range [0..size(");
        throw new IndexOutOfBoundsException(a8.b.r(sb, this.f3512c, "))"));
    }

    public final int b(int i8, int i9, byte[] bArr) {
        k.a(bArr.length, i8, i9);
        g gVar = this.f3510a;
        if (gVar == null) {
            return -1;
        }
        int iMin = Math.min(i9 - i8, gVar.b());
        int i10 = (i8 + iMin) - i8;
        byte[] bArr2 = gVar.f3524a;
        int i11 = gVar.f3525b;
        l.U(i8, bArr2, i11, bArr, i11 + i10);
        gVar.f3525b += i10;
        this.f3512c -= iMin;
        if (gVar.b() == 0) {
            g();
        }
        return iMin;
    }

    public final void e(i sink, long j4) throws EOFException {
        p.e(sink, "sink");
        if (j4 < 0) {
            throw new IllegalArgumentException(("byteCount (" + j4 + ") < 0").toString());
        }
        long j8 = this.f3512c;
        if (j8 >= j4) {
            ((a) sink).o(this, j4);
            return;
        }
        ((a) sink).o(this, j8);
        StringBuilder sb = new StringBuilder("Buffer exhausted before writing ");
        sb.append(j4);
        sb.append(" bytes. Only ");
        throw new EOFException(a8.b.r(sb, this.f3512c, " bytes were written."));
    }

    @Override // j6.j
    public final void f(long j4) throws EOFException {
        if (j4 < 0) {
            throw new IllegalArgumentException(a8.b.l(j4, "byteCount: ").toString());
        }
        if (this.f3512c >= j4) {
            return;
        }
        throw new EOFException("Buffer doesn't contain required number of bytes (size: " + this.f3512c + ", required: " + j4 + ')');
    }

    public final void g() {
        g gVar = this.f3510a;
        p.b(gVar);
        g gVar2 = gVar.f3528f;
        this.f3510a = gVar2;
        if (gVar2 == null) {
            this.f3511b = null;
        } else {
            gVar2.f3529g = null;
        }
        gVar.f3528f = null;
        h.a(gVar);
    }

    public final long j(d source) {
        p.e(source, "source");
        long j4 = 0;
        while (true) {
            long jM = source.m(this, 8192L);
            if (jM == -1) {
                return j4;
            }
            j4 += jM;
        }
    }

    @Override // j6.j
    public final boolean k(long j4) {
        if (j4 >= 0) {
            return this.f3512c >= j4;
        }
        throw new IllegalArgumentException(("byteCount: " + j4 + " < 0").toString());
    }

    public final long l(i sink) {
        p.e(sink, "sink");
        long j4 = this.f3512c;
        if (j4 > 0) {
            ((a) sink).o(this, j4);
        }
        return j4;
    }

    @Override // j6.d
    public final long m(a aVar, long j4) {
        if (j4 < 0) {
            throw new IllegalArgumentException(("byteCount (" + j4 + ") < 0").toString());
        }
        long j8 = this.f3512c;
        if (j8 == 0) {
            return -1L;
        }
        if (j4 > j8) {
            j4 = j8;
        }
        aVar.o(this, j4);
        return j4;
    }

    public final /* synthetic */ g n(int i8) {
        if (i8 < 1 || i8 > 8192) {
            throw new IllegalArgumentException(a8.b.k(i8, "unexpected capacity (", "), should be in range [1, 8192]").toString());
        }
        g gVar = this.f3511b;
        if (gVar == null) {
            g gVarB = h.b();
            this.f3510a = gVarB;
            this.f3511b = gVarB;
            return gVarB;
        }
        if (gVar.f3526c + i8 <= 8192 && gVar.f3527e) {
            return gVar;
        }
        g gVarB2 = h.b();
        gVar.e(gVarB2);
        this.f3511b = gVarB2;
        return gVarB2;
    }

    public final void o(a aVar, long j4) {
        g gVarB;
        if (aVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        k.b(aVar.f3512c, j4);
        while (j4 > 0) {
            p.b(aVar.f3510a);
            int i8 = 0;
            if (j4 < r0.b()) {
                g gVar = this.f3511b;
                if (gVar != null && gVar.f3527e) {
                    long j8 = gVar.f3526c + j4;
                    k kVar = gVar.d;
                    if (j8 - ((kVar == null || ((f) kVar).f3523b <= 0) ? gVar.f3525b : 0) <= 8192) {
                        g gVar2 = aVar.f3510a;
                        p.b(gVar2);
                        gVar2.g(gVar, (int) j4);
                        aVar.f3512c -= j4;
                        this.f3512c += j4;
                        return;
                    }
                }
                g gVar3 = aVar.f3510a;
                p.b(gVar3);
                int i9 = (int) j4;
                if (i9 <= 0 || i9 > gVar3.f3526c - gVar3.f3525b) {
                    throw new IllegalArgumentException("byteCount out of range");
                }
                if (i9 >= 1024) {
                    gVarB = gVar3.f();
                } else {
                    gVarB = h.b();
                    byte[] bArr = gVar3.f3524a;
                    byte[] bArr2 = gVarB.f3524a;
                    int i10 = gVar3.f3525b;
                    l.U(0, bArr, i10, bArr2, i10 + i9);
                }
                gVarB.f3526c = gVarB.f3525b + i9;
                gVar3.f3525b += i9;
                g gVar4 = gVar3.f3529g;
                if (gVar4 != null) {
                    gVar4.e(gVarB);
                } else {
                    gVarB.f3528f = gVar3;
                    gVar3.f3529g = gVarB;
                }
                aVar.f3510a = gVarB;
            }
            g gVar5 = aVar.f3510a;
            p.b(gVar5);
            long jB = gVar5.b();
            g gVarD = gVar5.d();
            aVar.f3510a = gVarD;
            if (gVarD == null) {
                aVar.f3511b = null;
            }
            if (this.f3510a == null) {
                this.f3510a = gVar5;
                this.f3511b = gVar5;
            } else {
                g gVar6 = this.f3511b;
                p.b(gVar6);
                gVar6.e(gVar5);
                g gVar7 = gVar5.f3529g;
                if (gVar7 == null) {
                    throw new IllegalStateException("cannot compact");
                }
                if (gVar7.f3527e) {
                    int i11 = gVar5.f3526c - gVar5.f3525b;
                    p.b(gVar7);
                    int i12 = 8192 - gVar7.f3526c;
                    g gVar8 = gVar5.f3529g;
                    p.b(gVar8);
                    k kVar2 = gVar8.d;
                    if (kVar2 == null || ((f) kVar2).f3523b <= 0) {
                        g gVar9 = gVar5.f3529g;
                        p.b(gVar9);
                        i8 = gVar9.f3525b;
                    }
                    if (i11 <= i12 + i8) {
                        g gVar10 = gVar5.f3529g;
                        p.b(gVar10);
                        gVar5.g(gVar10, i11);
                        if (gVar5.d() != null) {
                            throw new IllegalStateException("Check failed.");
                        }
                        h.a(gVar5);
                        gVar5 = gVar10;
                    }
                }
                this.f3511b = gVar5;
                if (gVar5.f3529g == null) {
                    this.f3510a = gVar5;
                }
            }
            aVar.f3512c -= jB;
            this.f3512c += jB;
            j4 -= jB;
        }
    }

    @Override // j6.j
    public final e peek() {
        return new e(new c(this));
    }

    @Override // j6.j
    public final boolean q() {
        return this.f3512c == 0;
    }

    public final byte readByte() throws EOFException {
        g gVar = this.f3510a;
        if (gVar == null) {
            throw new EOFException(a8.b.r(new StringBuilder("Buffer doesn't contain required number of bytes (size: "), this.f3512c, ", required: 1)"));
        }
        int iB = gVar.b();
        if (iB == 0) {
            g();
            return readByte();
        }
        byte[] bArr = gVar.f3524a;
        int i8 = gVar.f3525b;
        gVar.f3525b = i8 + 1;
        byte b9 = bArr[i8];
        this.f3512c--;
        if (iB == 1) {
            g();
        }
        return b9;
    }

    public final void s(byte[] source, int i8) {
        p.e(source, "source");
        int i9 = 0;
        k.a(source.length, 0, i8);
        while (i9 < i8) {
            g gVarN = n(1);
            int iMin = Math.min(i8 - i9, gVarN.a()) + i9;
            l.U(gVarN.f3526c, source, i9, gVarN.f3524a, iMin);
            gVarN.f3526c = (iMin - i9) + gVarN.f3526c;
            i9 = iMin;
        }
        this.f3512c += i8;
    }

    public final void skip(long j4) throws EOFException {
        if (j4 < 0) {
            throw new IllegalArgumentException(("byteCount (" + j4 + ") < 0").toString());
        }
        long j8 = j4;
        while (j8 > 0) {
            g gVar = this.f3510a;
            if (gVar == null) {
                throw new EOFException("Buffer exhausted before skipping " + j4 + " bytes.");
            }
            int iMin = (int) Math.min(j8, gVar.f3526c - gVar.f3525b);
            long j9 = iMin;
            this.f3512c -= j9;
            j8 -= j9;
            int i8 = gVar.f3525b + iMin;
            gVar.f3525b = i8;
            if (i8 == gVar.f3526c) {
                g();
            }
        }
    }

    public final void t(byte b9) {
        g gVarN = n(1);
        byte[] bArr = gVarN.f3524a;
        int i8 = gVarN.f3526c;
        gVarN.f3526c = i8 + 1;
        bArr[i8] = b9;
        this.f3512c++;
    }

    public final String toString() {
        long j4 = this.f3512c;
        if (j4 == 0) {
            return "Buffer(size=0)";
        }
        long j8 = 64;
        int iMin = (int) Math.min(j8, j4);
        StringBuilder sb = new StringBuilder((iMin * 2) + (this.f3512c > j8 ? 1 : 0));
        int i8 = 0;
        for (g gVar = this.f3510a; gVar != null; gVar = gVar.f3528f) {
            int i9 = 0;
            while (i8 < iMin && i9 < gVar.b()) {
                int i10 = i9 + 1;
                byte bC = gVar.c(i9);
                i8++;
                char[] cArr = k.f3536a;
                sb.append(cArr[(bC >> 4) & 15]);
                sb.append(cArr[bC & 15]);
                i9 = i10;
            }
        }
        if (this.f3512c > j8) {
            sb.append((char) 8230);
        }
        return "Buffer(size=" + this.f3512c + " hex=" + ((Object) sb) + ')';
    }

    @Override // j6.j
    public final a c() {
        return this;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Flushable
    public final void flush() {
    }
}
