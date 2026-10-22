package com.google.protobuf;

import com.google.protobuf.ByteString;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.google.protobuf.m, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0964m extends AbstractC0972o {
    public final InputStream c;
    public final byte[] d;
    public int e;
    public int f;
    public int g;
    public int h;
    public int i;

    /* renamed from: j, reason: collision with root package name */
    public int f2929j = Integer.MAX_VALUE;

    public C0964m(InputStream inputStream) {
        AbstractC0989s1.a(inputStream, "input");
        this.c = inputStream;
        this.d = new byte[4096];
        this.e = 0;
        this.g = 0;
        this.i = 0;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final long A() {
        return AbstractC0972o.d(M());
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final String B() throws InvalidProtocolBufferException {
        int iW = w();
        byte[] bArr = this.d;
        if (iW > 0) {
            int i = this.e;
            int i6 = this.g;
            if (iW <= i - i6) {
                String str = new String(bArr, i6, iW, AbstractC0989s1.f2940a);
                this.g += iW;
                return str;
            }
        }
        if (iW == 0) {
            return "";
        }
        if (iW > this.e) {
            return new String(H(iW), AbstractC0989s1.f2940a);
        }
        P(iW);
        String str2 = new String(bArr, this.g, iW, AbstractC0989s1.f2940a);
        this.g += iW;
        return str2;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final String C() throws IOException {
        int iW = w();
        int i = this.g;
        int i6 = this.e;
        int i10 = i6 - i;
        byte[] bArrH = this.d;
        if (iW <= i10 && iW > 0) {
            this.g = i + iW;
        } else {
            if (iW == 0) {
                return "";
            }
            i = 0;
            if (iW <= i6) {
                P(iW);
                this.g = iW;
            } else {
                bArrH = H(iW);
            }
        }
        return Y2.f2904a.m(bArrH, i, iW);
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int D() throws InvalidProtocolBufferException {
        if (g()) {
            this.h = 0;
            return 0;
        }
        int iW = w();
        this.h = iW;
        if ((iW >>> 3) != 0) {
            return iW;
        }
        throw InvalidProtocolBufferException.a();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int E() {
        return w();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final long F() {
        return M();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final boolean G(int i) throws InvalidProtocolBufferException {
        int iD;
        int i6 = i & 7;
        int i10 = 0;
        if (i6 == 0) {
            int i11 = this.e - this.g;
            byte[] bArr = this.d;
            if (i11 >= 10) {
                while (i10 < 10) {
                    int i12 = this.g;
                    this.g = i12 + 1;
                    if (bArr[i12] < 0) {
                        i10++;
                    }
                }
                throw InvalidProtocolBufferException.d();
            }
            while (i10 < 10) {
                if (this.g == this.e) {
                    P(1);
                }
                int i13 = this.g;
                this.g = i13 + 1;
                if (bArr[i13] < 0) {
                    i10++;
                }
            }
            throw InvalidProtocolBufferException.d();
            return true;
        }
        if (i6 == 1) {
            Q(8);
            return true;
        }
        if (i6 == 2) {
            Q(w());
            return true;
        }
        if (i6 != 3) {
            if (i6 == 4) {
                return false;
            }
            if (i6 != 5) {
                throw InvalidProtocolBufferException.c();
            }
            Q(4);
            return true;
        }
        do {
            iD = D();
            if (iD == 0) {
                break;
            }
        } while (G(iD));
        a(((i >>> 3) << 3) | 4);
        return true;
    }

    public final byte[] H(int i) throws IOException {
        byte[] bArrI = I(i);
        if (bArrI != null) {
            return bArrI;
        }
        int i6 = this.g;
        int i10 = this.e;
        int length = i10 - i6;
        this.i += i10;
        this.g = 0;
        this.e = 0;
        ArrayList arrayListJ = J(i - length);
        byte[] bArr = new byte[i];
        System.arraycopy(this.d, i6, bArr, 0, length);
        Iterator it = arrayListJ.iterator();
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) it.next();
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }

    public final byte[] I(int i) throws IOException {
        if (i == 0) {
            return AbstractC0989s1.c;
        }
        if (i < 0) {
            throw InvalidProtocolBufferException.e();
        }
        int i6 = this.i;
        int i10 = this.g;
        int i11 = i6 + i10 + i;
        if (i11 - Integer.MAX_VALUE > 0) {
            throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        int i12 = this.f2929j;
        if (i11 > i12) {
            Q((i12 - i6) - i10);
            throw InvalidProtocolBufferException.g();
        }
        int i13 = this.e - i10;
        int i14 = i - i13;
        InputStream inputStream = this.c;
        if (i14 >= 4096) {
            try {
                if (i14 > inputStream.available()) {
                    return null;
                }
            } catch (InvalidProtocolBufferException e) {
                e.f2842a = true;
                throw e;
            }
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.d, this.g, bArr, 0, i13);
        this.i += this.e;
        this.g = 0;
        this.e = 0;
        while (i13 < i) {
            try {
                int i15 = inputStream.read(bArr, i13, i - i13);
                if (i15 == -1) {
                    throw InvalidProtocolBufferException.g();
                }
                this.i += i15;
                i13 += i15;
            } catch (InvalidProtocolBufferException e6) {
                e6.f2842a = true;
                throw e6;
            }
        }
        return bArr;
    }

    public final ArrayList J(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i6 = 0;
            while (i6 < iMin) {
                int i10 = this.c.read(bArr, i6, iMin - i6);
                if (i10 == -1) {
                    throw InvalidProtocolBufferException.g();
                }
                this.i += i10;
                i6 += i10;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final int K() throws InvalidProtocolBufferException {
        int i = this.g;
        if (this.e - i < 4) {
            P(4);
            i = this.g;
        }
        this.g = i + 4;
        byte[] bArr = this.d;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long L() throws InvalidProtocolBufferException {
        int i = this.g;
        if (this.e - i < 8) {
            P(8);
            i = this.g;
        }
        this.g = i + 8;
        byte[] bArr = this.d;
        return ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((bArr[i + 6] & 255) << 48) | ((bArr[i + 7] & 255) << 56);
    }

    public final long M() {
        long j5;
        long j6;
        long j10;
        long j11;
        int i = this.g;
        int i6 = this.e;
        if (i6 != i) {
            int i10 = i + 1;
            byte[] bArr = this.d;
            byte b = bArr[i];
            if (b >= 0) {
                this.g = i10;
                return b;
            }
            if (i6 - i10 >= 9) {
                int i11 = i + 2;
                int i12 = (bArr[i10] << 7) ^ b;
                if (i12 < 0) {
                    j5 = i12 ^ (-128);
                } else {
                    int i13 = i + 3;
                    int i14 = (bArr[i11] << 14) ^ i12;
                    if (i14 >= 0) {
                        j5 = i14 ^ 16256;
                        i11 = i13;
                    } else {
                        int i15 = i + 4;
                        int i16 = i14 ^ (bArr[i13] << 21);
                        if (i16 < 0) {
                            j11 = (-2080896) ^ i16;
                        } else {
                            long j12 = i16;
                            i11 = i + 5;
                            long j13 = j12 ^ (bArr[i15] << 28);
                            if (j13 >= 0) {
                                j10 = 266354560;
                            } else {
                                i15 = i + 6;
                                long j14 = j13 ^ (bArr[i11] << 35);
                                if (j14 < 0) {
                                    j6 = -34093383808L;
                                } else {
                                    i11 = i + 7;
                                    j13 = j14 ^ (bArr[i15] << 42);
                                    if (j13 >= 0) {
                                        j10 = 4363953127296L;
                                    } else {
                                        i15 = i + 8;
                                        j14 = j13 ^ (bArr[i11] << 49);
                                        if (j14 < 0) {
                                            j6 = -558586000294016L;
                                        } else {
                                            i11 = i + 9;
                                            long j15 = (j14 ^ (bArr[i15] << 56)) ^ 71499008037633920L;
                                            if (j15 < 0) {
                                                int i17 = i + 10;
                                                if (bArr[i11] >= 0) {
                                                    i11 = i17;
                                                }
                                            }
                                            j5 = j15;
                                        }
                                    }
                                }
                                j11 = j6 ^ j14;
                            }
                            j5 = j10 ^ j13;
                        }
                        i11 = i15;
                        j5 = j11;
                    }
                }
                this.g = i11;
                return j5;
            }
        }
        return N();
    }

    public final long N() throws InvalidProtocolBufferException {
        long j5 = 0;
        for (int i = 0; i < 64; i += 7) {
            if (this.g == this.e) {
                P(1);
            }
            int i6 = this.g;
            this.g = i6 + 1;
            j5 |= (r3 & 127) << i;
            if ((this.d[i6] & 128) == 0) {
                return j5;
            }
        }
        throw InvalidProtocolBufferException.d();
    }

    public final void O() {
        int i = this.e + this.f;
        this.e = i;
        int i6 = this.i + i;
        int i10 = this.f2929j;
        if (i6 <= i10) {
            this.f = 0;
            return;
        }
        int i11 = i6 - i10;
        this.f = i11;
        this.e = i - i11;
    }

    public final void P(int i) throws InvalidProtocolBufferException {
        if (R(i)) {
            return;
        }
        if (i <= (Integer.MAX_VALUE - this.i) - this.g) {
            throw InvalidProtocolBufferException.g();
        }
        throw new InvalidProtocolBufferException("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public final void Q(int i) throws InvalidProtocolBufferException {
        int i6 = this.e;
        int i10 = this.g;
        if (i <= i6 - i10 && i >= 0) {
            this.g = i10 + i;
            return;
        }
        InputStream inputStream = this.c;
        if (i < 0) {
            throw InvalidProtocolBufferException.e();
        }
        int i11 = this.i;
        int i12 = i11 + i10;
        int i13 = i12 + i;
        int i14 = this.f2929j;
        if (i13 > i14) {
            Q((i14 - i11) - i10);
            throw InvalidProtocolBufferException.g();
        }
        this.i = i12;
        int i15 = i6 - i10;
        this.e = 0;
        this.g = 0;
        while (i15 < i) {
            long j5 = i - i15;
            try {
                try {
                    long jSkip = inputStream.skip(j5);
                    if (jSkip < 0 || jSkip > j5) {
                        throw new IllegalStateException(inputStream.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i15 += (int) jSkip;
                    }
                } catch (InvalidProtocolBufferException e) {
                    e.f2842a = true;
                    throw e;
                }
            } catch (Throwable th) {
                this.i += i15;
                O();
                throw th;
            }
        }
        this.i += i15;
        O();
        if (i15 >= i) {
            return;
        }
        int i16 = this.e;
        int i17 = i16 - this.g;
        this.g = i16;
        P(1);
        while (true) {
            int i18 = i - i17;
            int i19 = this.e;
            if (i18 <= i19) {
                this.g = i18;
                return;
            } else {
                i17 += i19;
                this.g = i19;
                P(1);
            }
        }
    }

    public final boolean R(int i) throws IOException {
        InputStream inputStream = this.c;
        int i6 = this.g;
        int i10 = i6 + i;
        int i11 = this.e;
        if (i10 <= i11) {
            throw new IllegalStateException(androidx.appfunctions.metadata.a.i(i, "refillBuffer() called when ", " bytes were already available in buffer"));
        }
        int i12 = this.i;
        if (i <= (Integer.MAX_VALUE - i12) - i6 && i12 + i6 + i <= this.f2929j) {
            byte[] bArr = this.d;
            if (i6 > 0) {
                if (i11 > i6) {
                    System.arraycopy(bArr, i6, bArr, 0, i11 - i6);
                }
                this.i += i6;
                this.e -= i6;
                this.g = 0;
            }
            int i13 = this.e;
            try {
                int i14 = inputStream.read(bArr, i13, Math.min(bArr.length - i13, (Integer.MAX_VALUE - this.i) - i13));
                if (i14 == 0 || i14 < -1 || i14 > bArr.length) {
                    throw new IllegalStateException(inputStream.getClass() + "#read(byte[]) returned invalid result: " + i14 + "\nThe InputStream implementation is buggy.");
                }
                if (i14 > 0) {
                    this.e += i14;
                    O();
                    if (this.e >= i) {
                        return true;
                    }
                    return R(i);
                }
            } catch (InvalidProtocolBufferException e) {
                e.f2842a = true;
                throw e;
            }
        }
        return false;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final void a(int i) throws InvalidProtocolBufferException {
        if (this.h != i) {
            throw new InvalidProtocolBufferException("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int e() {
        int i = this.f2929j;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.i + this.g);
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int f() {
        return this.i + this.g;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final boolean g() {
        return this.g == this.e && !R(1);
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final void i(int i) {
        this.f2929j = i;
        O();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int j(int i) throws InvalidProtocolBufferException {
        if (i < 0) {
            throw InvalidProtocolBufferException.e();
        }
        int i6 = this.i + this.g + i;
        int i10 = this.f2929j;
        if (i6 > i10) {
            throw InvalidProtocolBufferException.g();
        }
        this.f2929j = i6;
        O();
        return i10;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final boolean k() {
        return M() != 0;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final ByteString l() throws IOException {
        int iW = w();
        int i = this.e;
        int i6 = this.g;
        int i10 = i - i6;
        byte[] bArr = this.d;
        if (iW <= i10 && iW > 0) {
            ByteString byteStringE = ByteString.e(bArr, i6, iW);
            this.g += iW;
            return byteStringE;
        }
        if (iW == 0) {
            return ByteString.b;
        }
        byte[] bArrI = I(iW);
        if (bArrI != null) {
            return ByteString.e(bArrI, 0, bArrI.length);
        }
        int i11 = this.g;
        int i12 = this.e;
        int length = i12 - i11;
        this.i += i12;
        this.g = 0;
        this.e = 0;
        ArrayList arrayListJ = J(iW - length);
        byte[] bArr2 = new byte[iW];
        System.arraycopy(bArr, i11, bArr2, 0, length);
        Iterator it = arrayListJ.iterator();
        while (it.hasNext()) {
            byte[] bArr3 = (byte[]) it.next();
            System.arraycopy(bArr3, 0, bArr2, length, bArr3.length);
            length += bArr3.length;
        }
        ByteString byteString = ByteString.b;
        return new ByteString.LiteralByteString(bArr2);
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final double m() {
        return Double.longBitsToDouble(L());
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int n() {
        return w();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int o() {
        return K();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final long p() {
        return L();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final float q() {
        return Float.intBitsToFloat(K());
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final void r(int i, W1 w12, R0 r02) throws InvalidProtocolBufferException {
        b();
        this.f2933a++;
        w12.mergeFrom(this, r02);
        a((i << 3) | 4);
        this.f2933a--;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int s() {
        return w();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final long t() {
        return M();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final X1 u(InterfaceC0955j2 interfaceC0955j2, R0 r02) throws InvalidProtocolBufferException {
        int iW = w();
        b();
        int iJ = j(iW);
        this.f2933a++;
        X1 x12 = (X1) interfaceC0955j2.a(this, r02);
        a(0);
        this.f2933a--;
        if (e() != 0) {
            throw InvalidProtocolBufferException.g();
        }
        i(iJ);
        return x12;
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final void v(W1 w12, R0 r02) throws InvalidProtocolBufferException {
        int iW = w();
        b();
        int iJ = j(iW);
        this.f2933a++;
        w12.mergeFrom(this, r02);
        a(0);
        this.f2933a--;
        if (e() != 0) {
            throw InvalidProtocolBufferException.g();
        }
        i(iJ);
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int w() {
        int i;
        int i6 = this.g;
        int i10 = this.e;
        if (i10 != i6) {
            int i11 = i6 + 1;
            byte[] bArr = this.d;
            byte b = bArr[i6];
            if (b >= 0) {
                this.g = i11;
                return b;
            }
            if (i10 - i11 >= 9) {
                int i12 = i6 + 2;
                int i13 = (bArr[i11] << 7) ^ b;
                if (i13 < 0) {
                    i = i13 ^ (-128);
                } else {
                    int i14 = i6 + 3;
                    int i15 = (bArr[i12] << 14) ^ i13;
                    if (i15 >= 0) {
                        i = i15 ^ 16256;
                    } else {
                        int i16 = i6 + 4;
                        int i17 = i15 ^ (bArr[i14] << 21);
                        if (i17 < 0) {
                            i = (-2080896) ^ i17;
                        } else {
                            i14 = i6 + 5;
                            byte b5 = bArr[i16];
                            int i18 = (i17 ^ (b5 << 28)) ^ 266354560;
                            if (b5 < 0) {
                                i16 = i6 + 6;
                                if (bArr[i14] < 0) {
                                    i14 = i6 + 7;
                                    if (bArr[i16] < 0) {
                                        i16 = i6 + 8;
                                        if (bArr[i14] < 0) {
                                            i14 = i6 + 9;
                                            if (bArr[i16] < 0) {
                                                int i19 = i6 + 10;
                                                if (bArr[i14] >= 0) {
                                                    i12 = i19;
                                                    i = i18;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i18;
                            }
                            i = i18;
                        }
                        i12 = i16;
                    }
                    i12 = i14;
                }
                this.g = i12;
                return i;
            }
        }
        return (int) N();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int x() {
        return K();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final long y() {
        return L();
    }

    @Override // com.google.protobuf.AbstractC0972o
    public final int z() {
        return AbstractC0972o.c(w());
    }
}
