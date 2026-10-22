package kotlin.reflect.jvm.internal.impl.protobuf;

import ia.AbstractC4182b;
import ia.C4181a;
import ia.C4186f;
import ia.InterfaceC4188h;
import ia.l;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f35858a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f35859b;

    /* renamed from: c, reason: collision with root package name */
    public int f35860c;

    /* renamed from: d, reason: collision with root package name */
    public int f35861d;

    /* renamed from: e, reason: collision with root package name */
    public int f35862e;

    /* renamed from: f, reason: collision with root package name */
    public final InputStream f35863f;

    /* renamed from: g, reason: collision with root package name */
    public int f35864g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f35865h;

    /* renamed from: i, reason: collision with root package name */
    public int f35866i;

    /* renamed from: j, reason: collision with root package name */
    public int f35867j;

    /* renamed from: k, reason: collision with root package name */
    public int f35868k;

    /* renamed from: l, reason: collision with root package name */
    public int f35869l;

    /* renamed from: m, reason: collision with root package name */
    public int f35870m;

    public c(InputStream inputStream) {
        this.f35865h = false;
        this.f35867j = Integer.MAX_VALUE;
        this.f35869l = 64;
        this.f35870m = 67108864;
        this.f35858a = new byte[4096];
        this.f35860c = 0;
        this.f35862e = 0;
        this.f35866i = 0;
        this.f35863f = inputStream;
        this.f35859b = false;
    }

    public static int B(int i10, InputStream inputStream) throws IOException {
        if ((i10 & 128) == 0) {
            return i10;
        }
        int i11 = i10 & 127;
        int i12 = 7;
        while (i12 < 32) {
            int i13 = inputStream.read();
            if (i13 == -1) {
                throw InvalidProtocolBufferException.k();
            }
            i11 |= (i13 & 127) << i12;
            if ((i13 & 128) == 0) {
                return i11;
            }
            i12 += 7;
        }
        while (i12 < 64) {
            int i14 = inputStream.read();
            if (i14 == -1) {
                throw InvalidProtocolBufferException.k();
            }
            if ((i14 & 128) == 0) {
                return i11;
            }
            i12 += 7;
        }
        throw InvalidProtocolBufferException.f();
    }

    public static int b(int i10) {
        return (-(i10 & 1)) ^ (i10 >>> 1);
    }

    public static long c(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static c g(C4186f c4186f) {
        c cVar = new c(c4186f);
        try {
            cVar.j(c4186f.size());
            return cVar;
        } catch (InvalidProtocolBufferException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    public static c h(InputStream inputStream) {
        return new c(inputStream);
    }

    public int A() throws IOException {
        int i10;
        int i11 = this.f35862e;
        int i12 = this.f35860c;
        if (i12 != i11) {
            byte[] bArr = this.f35858a;
            int i13 = i11 + 1;
            byte b10 = bArr[i11];
            if (b10 >= 0) {
                this.f35862e = i13;
                return b10;
            }
            if (i12 - i13 >= 9) {
                int i14 = i11 + 2;
                int i15 = (bArr[i13] << 7) ^ b10;
                long j10 = i15;
                if (j10 < 0) {
                    i10 = (int) ((-128) ^ j10);
                } else {
                    int i16 = i11 + 3;
                    int i17 = (bArr[i14] << 14) ^ i15;
                    long j11 = i17;
                    if (j11 >= 0) {
                        i10 = (int) (16256 ^ j11);
                    } else {
                        int i18 = i11 + 4;
                        long j12 = i17 ^ (bArr[i16] << 21);
                        if (j12 < 0) {
                            i10 = (int) ((-2080896) ^ j12);
                        } else {
                            i16 = i11 + 5;
                            int i19 = (int) ((r1 ^ (r3 << 28)) ^ 266354560);
                            if (bArr[i18] < 0) {
                                i18 = i11 + 6;
                                if (bArr[i16] < 0) {
                                    i16 = i11 + 7;
                                    if (bArr[i18] < 0) {
                                        i18 = i11 + 8;
                                        if (bArr[i16] < 0) {
                                            i16 = i11 + 9;
                                            if (bArr[i18] < 0) {
                                                int i20 = i11 + 10;
                                                if (bArr[i16] >= 0) {
                                                    i14 = i20;
                                                    i10 = i19;
                                                }
                                            }
                                        }
                                    }
                                }
                                i10 = i19;
                            }
                            i10 = i19;
                        }
                        i14 = i18;
                    }
                    i14 = i16;
                }
                this.f35862e = i14;
                return i10;
            }
        }
        return (int) D();
    }

    public long C() throws IOException {
        long j10;
        long j11;
        long j12;
        int i10 = this.f35862e;
        int i11 = this.f35860c;
        if (i11 != i10) {
            byte[] bArr = this.f35858a;
            int i12 = i10 + 1;
            byte b10 = bArr[i10];
            if (b10 >= 0) {
                this.f35862e = i12;
                return b10;
            }
            if (i11 - i12 >= 9) {
                int i13 = i10 + 2;
                long j13 = (bArr[i12] << 7) ^ b10;
                if (j13 >= 0) {
                    int i14 = i10 + 3;
                    long j14 = j13 ^ (bArr[i13] << 14);
                    if (j14 >= 0) {
                        j12 = 16256;
                    } else {
                        i13 = i10 + 4;
                        j13 = j14 ^ (bArr[i14] << 21);
                        if (j13 < 0) {
                            j11 = -2080896;
                        } else {
                            i14 = i10 + 5;
                            j14 = j13 ^ (bArr[i13] << 28);
                            if (j14 >= 0) {
                                j12 = 266354560;
                            } else {
                                i13 = i10 + 6;
                                j13 = j14 ^ (bArr[i14] << 35);
                                if (j13 < 0) {
                                    j11 = -34093383808L;
                                } else {
                                    i14 = i10 + 7;
                                    j14 = j13 ^ (bArr[i13] << 42);
                                    if (j14 >= 0) {
                                        j12 = 4363953127296L;
                                    } else {
                                        i13 = i10 + 8;
                                        j13 = j14 ^ (bArr[i14] << 49);
                                        if (j13 < 0) {
                                            j11 = -558586000294016L;
                                        } else {
                                            i14 = i10 + 9;
                                            long j15 = (j13 ^ (bArr[i13] << 56)) ^ 71499008037633920L;
                                            if (j15 >= 0) {
                                                j10 = j15;
                                                i13 = i14;
                                                this.f35862e = i13;
                                                return j10;
                                            }
                                            i13 = i10 + 10;
                                            if (bArr[i14] >= 0) {
                                                j10 = j15;
                                                this.f35862e = i13;
                                                return j10;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    j10 = j14 ^ j12;
                    i13 = i14;
                    this.f35862e = i13;
                    return j10;
                }
                j11 = -128;
                j10 = j13 ^ j11;
                this.f35862e = i13;
                return j10;
            }
        }
        return D();
    }

    public long D() throws IOException {
        long j10 = 0;
        for (int i10 = 0; i10 < 64; i10 += 7) {
            j10 |= (r3 & 127) << i10;
            if ((w() & 128) == 0) {
                return j10;
            }
        }
        throw InvalidProtocolBufferException.f();
    }

    public int E() throws IOException {
        return y();
    }

    public long F() throws IOException {
        return z();
    }

    public int G() throws IOException {
        return b(A());
    }

    public long H() throws IOException {
        return c(C());
    }

    public String I() throws IOException {
        int iA = A();
        int i10 = this.f35860c;
        int i11 = this.f35862e;
        if (iA > i10 - i11 || iA <= 0) {
            return iA == 0 ? "" : new String(x(iA), "UTF-8");
        }
        String str = new String(this.f35858a, i11, iA, "UTF-8");
        this.f35862e += iA;
        return str;
    }

    public String J() throws IOException {
        byte[] bArrX;
        int iA = A();
        int i10 = this.f35862e;
        if (iA <= this.f35860c - i10 && iA > 0) {
            bArrX = this.f35858a;
            this.f35862e = i10 + iA;
        } else {
            if (iA == 0) {
                return "";
            }
            bArrX = x(iA);
            i10 = 0;
        }
        if (l.f(bArrX, i10, i10 + iA)) {
            return new String(bArrX, i10, iA, "UTF-8");
        }
        throw InvalidProtocolBufferException.d();
    }

    public int K() throws IOException {
        if (f()) {
            this.f35864g = 0;
            return 0;
        }
        int iA = A();
        this.f35864g = iA;
        if (WireFormat.a(iA) != 0) {
            return this.f35864g;
        }
        throw InvalidProtocolBufferException.c();
    }

    public int L() throws IOException {
        return A();
    }

    public long M() throws IOException {
        return C();
    }

    public final void N() {
        int i10 = this.f35860c + this.f35861d;
        this.f35860c = i10;
        int i11 = this.f35866i + i10;
        int i12 = this.f35867j;
        if (i11 <= i12) {
            this.f35861d = 0;
            return;
        }
        int i13 = i11 - i12;
        this.f35861d = i13;
        this.f35860c = i10 - i13;
    }

    public final void O(int i10) throws IOException {
        if (!T(i10)) {
            throw InvalidProtocolBufferException.k();
        }
    }

    public boolean P(int i10, CodedOutputStream codedOutputStream) throws IOException {
        int iB = WireFormat.b(i10);
        if (iB == 0) {
            long jT = t();
            codedOutputStream.o0(i10);
            codedOutputStream.z0(jT);
            return true;
        }
        if (iB == 1) {
            long jZ = z();
            codedOutputStream.o0(i10);
            codedOutputStream.V(jZ);
            return true;
        }
        if (iB == 2) {
            AbstractC4182b abstractC4182bL = l();
            codedOutputStream.o0(i10);
            codedOutputStream.P(abstractC4182bL);
            return true;
        }
        if (iB == 3) {
            codedOutputStream.o0(i10);
            Q(codedOutputStream);
            int iC = WireFormat.c(WireFormat.a(i10), 4);
            a(iC);
            codedOutputStream.o0(iC);
            return true;
        }
        if (iB == 4) {
            return false;
        }
        if (iB != 5) {
            throw InvalidProtocolBufferException.e();
        }
        int iY = y();
        codedOutputStream.o0(i10);
        codedOutputStream.U(iY);
        return true;
    }

    public void Q(CodedOutputStream codedOutputStream) throws IOException {
        int iK;
        do {
            iK = K();
            if (iK == 0) {
                return;
            }
        } while (P(iK, codedOutputStream));
    }

    public void R(int i10) throws IOException {
        int i11 = this.f35860c;
        int i12 = this.f35862e;
        if (i10 > i11 - i12 || i10 < 0) {
            S(i10);
        } else {
            this.f35862e = i12 + i10;
        }
    }

    public final void S(int i10) throws IOException {
        if (i10 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        int i11 = this.f35866i;
        int i12 = this.f35862e;
        int i13 = i11 + i12 + i10;
        int i14 = this.f35867j;
        if (i13 > i14) {
            R((i14 - i11) - i12);
            throw InvalidProtocolBufferException.k();
        }
        int i15 = this.f35860c;
        int i16 = i15 - i12;
        this.f35862e = i15;
        O(1);
        while (true) {
            int i17 = i10 - i16;
            int i18 = this.f35860c;
            if (i17 <= i18) {
                this.f35862e = i17;
                return;
            } else {
                i16 += i18;
                this.f35862e = i18;
                O(1);
            }
        }
    }

    public final boolean T(int i10) throws IOException {
        int i11 = this.f35862e;
        int i12 = i11 + i10;
        int i13 = this.f35860c;
        if (i12 <= i13) {
            StringBuilder sb2 = new StringBuilder(77);
            sb2.append("refillBuffer() called when ");
            sb2.append(i10);
            sb2.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb2.toString());
        }
        if (this.f35866i + i11 + i10 <= this.f35867j && this.f35863f != null) {
            if (i11 > 0) {
                if (i13 > i11) {
                    byte[] bArr = this.f35858a;
                    System.arraycopy(bArr, i11, bArr, 0, i13 - i11);
                }
                this.f35866i += i11;
                this.f35860c -= i11;
                this.f35862e = 0;
            }
            InputStream inputStream = this.f35863f;
            byte[] bArr2 = this.f35858a;
            int i14 = this.f35860c;
            int i15 = inputStream.read(bArr2, i14, bArr2.length - i14);
            if (i15 == 0 || i15 < -1 || i15 > this.f35858a.length) {
                StringBuilder sb3 = new StringBuilder(102);
                sb3.append("InputStream#read(byte[]) returned invalid result: ");
                sb3.append(i15);
                sb3.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb3.toString());
            }
            if (i15 > 0) {
                this.f35860c += i15;
                if ((this.f35866i + i10) - this.f35870m > 0) {
                    throw InvalidProtocolBufferException.j();
                }
                N();
                if (this.f35860c >= i10) {
                    return true;
                }
                return T(i10);
            }
        }
        return false;
    }

    public void a(int i10) throws InvalidProtocolBufferException {
        if (this.f35864g != i10) {
            throw InvalidProtocolBufferException.b();
        }
    }

    public final void d(int i10) throws IOException {
        if (this.f35860c - this.f35862e < i10) {
            O(i10);
        }
    }

    public int e() {
        int i10 = this.f35867j;
        if (i10 == Integer.MAX_VALUE) {
            return -1;
        }
        return i10 - (this.f35866i + this.f35862e);
    }

    public boolean f() throws IOException {
        return this.f35862e == this.f35860c && !T(1);
    }

    public void i(int i10) {
        this.f35867j = i10;
        N();
    }

    public int j(int i10) throws InvalidProtocolBufferException {
        if (i10 < 0) {
            throw InvalidProtocolBufferException.g();
        }
        int i11 = i10 + this.f35866i + this.f35862e;
        int i12 = this.f35867j;
        if (i11 > i12) {
            throw InvalidProtocolBufferException.k();
        }
        this.f35867j = i11;
        N();
        return i12;
    }

    public boolean k() throws IOException {
        return C() != 0;
    }

    public AbstractC4182b l() throws IOException {
        int iA = A();
        int i10 = this.f35860c;
        int i11 = this.f35862e;
        if (iA > i10 - i11 || iA <= 0) {
            return iA == 0 ? AbstractC4182b.f33086a : new C4186f(x(iA));
        }
        AbstractC4182b c4181a = (this.f35859b && this.f35865h) ? new C4181a(this.f35858a, this.f35862e, iA) : AbstractC4182b.i(this.f35858a, i11, iA);
        this.f35862e += iA;
        return c4181a;
    }

    public double m() throws IOException {
        return Double.longBitsToDouble(z());
    }

    public int n() throws IOException {
        return A();
    }

    public int o() throws IOException {
        return y();
    }

    public long p() throws IOException {
        return z();
    }

    public float q() throws IOException {
        return Float.intBitsToFloat(y());
    }

    public void r(int i10, h.a aVar, d dVar) throws IOException {
        int i11 = this.f35868k;
        if (i11 >= this.f35869l) {
            throw InvalidProtocolBufferException.h();
        }
        this.f35868k = i11 + 1;
        aVar.m(this, dVar);
        a(WireFormat.c(i10, 4));
        this.f35868k--;
    }

    public int s() throws IOException {
        return A();
    }

    public long t() throws IOException {
        return C();
    }

    public <T extends h> T u(InterfaceC4188h<T> interfaceC4188h, d dVar) throws IOException {
        int iA = A();
        if (this.f35868k >= this.f35869l) {
            throw InvalidProtocolBufferException.h();
        }
        int iJ = j(iA);
        this.f35868k++;
        T tC = interfaceC4188h.c(this, dVar);
        a(0);
        this.f35868k--;
        i(iJ);
        return tC;
    }

    public void v(h.a aVar, d dVar) throws IOException {
        int iA = A();
        if (this.f35868k >= this.f35869l) {
            throw InvalidProtocolBufferException.h();
        }
        int iJ = j(iA);
        this.f35868k++;
        aVar.m(this, dVar);
        a(0);
        this.f35868k--;
        i(iJ);
    }

    public byte w() throws IOException {
        if (this.f35862e == this.f35860c) {
            O(1);
        }
        byte[] bArr = this.f35858a;
        int i10 = this.f35862e;
        this.f35862e = i10 + 1;
        return bArr[i10];
    }

    public final byte[] x(int i10) throws IOException {
        if (i10 <= 0) {
            if (i10 == 0) {
                return f.f35881a;
            }
            throw InvalidProtocolBufferException.g();
        }
        int i11 = this.f35866i;
        int i12 = this.f35862e;
        int i13 = i11 + i12 + i10;
        int i14 = this.f35867j;
        if (i13 > i14) {
            R((i14 - i11) - i12);
            throw InvalidProtocolBufferException.k();
        }
        if (i10 < 4096) {
            byte[] bArr = new byte[i10];
            int i15 = this.f35860c - i12;
            System.arraycopy(this.f35858a, i12, bArr, 0, i15);
            this.f35862e = this.f35860c;
            int i16 = i10 - i15;
            d(i16);
            System.arraycopy(this.f35858a, 0, bArr, i15, i16);
            this.f35862e = i16;
            return bArr;
        }
        int i17 = this.f35860c;
        this.f35866i = i11 + i17;
        this.f35862e = 0;
        this.f35860c = 0;
        int length = i17 - i12;
        int i18 = i10 - length;
        ArrayList<byte[]> arrayList = new ArrayList();
        while (i18 > 0) {
            int iMin = Math.min(i18, 4096);
            byte[] bArr2 = new byte[iMin];
            int i19 = 0;
            while (i19 < iMin) {
                InputStream inputStream = this.f35863f;
                int i20 = inputStream == null ? -1 : inputStream.read(bArr2, i19, iMin - i19);
                if (i20 == -1) {
                    throw InvalidProtocolBufferException.k();
                }
                this.f35866i += i20;
                i19 += i20;
            }
            i18 -= iMin;
            arrayList.add(bArr2);
        }
        byte[] bArr3 = new byte[i10];
        System.arraycopy(this.f35858a, i12, bArr3, 0, length);
        for (byte[] bArr4 : arrayList) {
            System.arraycopy(bArr4, 0, bArr3, length, bArr4.length);
            length += bArr4.length;
        }
        return bArr3;
    }

    public int y() throws IOException {
        int i10 = this.f35862e;
        if (this.f35860c - i10 < 4) {
            O(4);
            i10 = this.f35862e;
        }
        byte[] bArr = this.f35858a;
        this.f35862e = i10 + 4;
        return (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24);
    }

    public long z() throws IOException {
        int i10 = this.f35862e;
        if (this.f35860c - i10 < 8) {
            O(8);
            i10 = this.f35862e;
        }
        byte[] bArr = this.f35858a;
        this.f35862e = i10 + 8;
        return ((bArr[i10 + 7] & 255) << 56) | (bArr[i10] & 255) | ((bArr[i10 + 1] & 255) << 8) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 3] & 255) << 24) | ((bArr[i10 + 4] & 255) << 32) | ((bArr[i10 + 5] & 255) << 40) | ((bArr[i10 + 6] & 255) << 48);
    }

    public c(C4186f c4186f) {
        this.f35865h = false;
        this.f35867j = Integer.MAX_VALUE;
        this.f35869l = 64;
        this.f35870m = 67108864;
        this.f35858a = c4186f.f33099b;
        int iH = c4186f.H();
        this.f35862e = iH;
        this.f35860c = iH + c4186f.size();
        this.f35866i = -this.f35862e;
        this.f35863f = null;
        this.f35859b = true;
    }
}
