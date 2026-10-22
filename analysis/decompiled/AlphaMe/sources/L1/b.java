package L1;

import com.stepos.activeview.utils.Constants;
import java.util.Vector;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final byte[] f1219a;

    /* renamed from: b, reason: collision with root package name */
    public int f1220b;

    /* renamed from: c, reason: collision with root package name */
    public int f1221c;

    /* renamed from: d, reason: collision with root package name */
    public int f1222d;

    /* renamed from: e, reason: collision with root package name */
    public int f1223e;

    /* renamed from: f, reason: collision with root package name */
    public int f1224f;

    /* renamed from: g, reason: collision with root package name */
    public int f1225g = Integer.MAX_VALUE;

    /* renamed from: h, reason: collision with root package name */
    public int f1226h;

    public b(int i4, int i5, byte[] bArr) {
        this.f1219a = bArr;
        this.f1220b = i5 + i4;
        this.f1222d = i4;
    }

    public final boolean a() {
        return k() != 0;
    }

    public final a b() throws e {
        int iK = k();
        int i4 = this.f1220b;
        int i5 = this.f1222d;
        if (iK > i4 - i5 || iK <= 0) {
            byte[] bArrH = h(iK);
            int length = bArrH.length;
            byte[] bArr = new byte[length];
            System.arraycopy(bArrH, 0, bArr, 0, length);
            return new a(bArr);
        }
        byte[] bArr2 = new byte[iK];
        System.arraycopy(this.f1219a, i5, bArr2, 0, iK);
        a aVar = new a(bArr2);
        this.f1222d += iK;
        return aVar;
    }

    public final double c() {
        return Double.longBitsToDouble(j());
    }

    public final int d() {
        return k();
    }

    public final long e() {
        return l();
    }

    public final void f(f fVar) throws e {
        int iK = k();
        if (this.f1226h >= 64) {
            throw new e("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        if (iK < 0) {
            throw new e("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i4 = this.f1224f + this.f1222d + iK;
        int i5 = this.f1225g;
        if (i4 > i5) {
            throw e.a();
        }
        this.f1225g = i4;
        p();
        this.f1226h++;
        fVar.mergeFrom(this);
        if (this.f1223e != 0) {
            throw new e("Protocol message end-group tag did not match expected tag.");
        }
        this.f1226h--;
        this.f1225g = i5;
        p();
    }

    public final byte g() throws e {
        if (this.f1222d == this.f1220b) {
            q(true);
        }
        int i4 = this.f1222d;
        this.f1222d = i4 + 1;
        return this.f1219a[i4];
    }

    public final byte[] h(int i4) throws e {
        if (i4 < 0) {
            throw new e("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i5 = this.f1224f;
        int i6 = this.f1222d;
        int i7 = i5 + i6 + i4;
        int i8 = this.f1225g;
        if (i7 > i8) {
            s((i8 - i5) - i6);
            throw e.a();
        }
        int i9 = this.f1220b;
        int length = i9 - i6;
        byte[] bArr = this.f1219a;
        if (i4 <= length) {
            byte[] bArr2 = new byte[i4];
            System.arraycopy(bArr, i6, bArr2, 0, i4);
            this.f1222d += i4;
            return bArr2;
        }
        if (i4 >= 4096) {
            this.f1224f = i5 + i9;
            this.f1222d = 0;
            this.f1220b = 0;
            int i10 = i4 - length;
            Vector vector = new Vector();
            while (i10 > 0) {
                int iMin = Math.min(i10, 4096);
                byte[] bArr3 = new byte[iMin];
                if (iMin > 0) {
                    throw e.a();
                }
                i10 -= iMin;
                vector.addElement(bArr3);
            }
            byte[] bArr4 = new byte[i4];
            System.arraycopy(bArr, i6, bArr4, 0, length);
            for (int i11 = 0; i11 < vector.size(); i11++) {
                byte[] bArr5 = (byte[]) vector.elementAt(i11);
                System.arraycopy(bArr5, 0, bArr4, length, bArr5.length);
                length += bArr5.length;
            }
            return bArr4;
        }
        byte[] bArr6 = new byte[i4];
        System.arraycopy(bArr, i6, bArr6, 0, length);
        this.f1222d = this.f1220b;
        q(true);
        while (true) {
            int i12 = i4 - length;
            int i13 = this.f1220b;
            if (i12 <= i13) {
                System.arraycopy(bArr, 0, bArr6, length, i12);
                this.f1222d = i12;
                return bArr6;
            }
            System.arraycopy(bArr, 0, bArr6, length, i13);
            int i14 = this.f1220b;
            length += i14;
            this.f1222d = i14;
            q(true);
        }
    }

    public final int i() throws e {
        byte bG = g();
        byte bG2 = g();
        byte bG3 = g();
        byte bG4 = g();
        return ((bG4 & UByte.MAX_VALUE) << 24) | (bG & UByte.MAX_VALUE) | ((bG2 & UByte.MAX_VALUE) << 8) | ((bG3 & UByte.MAX_VALUE) << 16);
    }

    public final long j() throws e {
        return ((g() & 255) << 8) | (g() & 255) | ((g() & 255) << 16) | ((g() & 255) << 24) | ((g() & 255) << 32) | ((g() & 255) << 40) | ((g() & 255) << 48) | ((g() & 255) << 56);
    }

    public final int k() throws e {
        int i4;
        byte bG = g();
        if (bG >= 0) {
            return bG;
        }
        int i5 = bG & ByteCompanionObject.MAX_VALUE;
        byte bG2 = g();
        if (bG2 >= 0) {
            i4 = bG2 << 7;
        } else {
            i5 |= (bG2 & ByteCompanionObject.MAX_VALUE) << 7;
            byte bG3 = g();
            if (bG3 >= 0) {
                i4 = bG3 << 14;
            } else {
                i5 |= (bG3 & ByteCompanionObject.MAX_VALUE) << 14;
                byte bG4 = g();
                if (bG4 < 0) {
                    int i6 = i5 | ((bG4 & ByteCompanionObject.MAX_VALUE) << 21);
                    byte bG5 = g();
                    int i7 = i6 | (bG5 << 28);
                    if (bG5 >= 0) {
                        return i7;
                    }
                    for (int i8 = 0; i8 < 5; i8++) {
                        if (g() >= 0) {
                            return i7;
                        }
                    }
                    throw new e("CodedInputStream encountered a malformed varint.");
                }
                i4 = bG4 << 21;
            }
        }
        return i4 | i5;
    }

    public final long l() throws e {
        long j4 = 0;
        for (int i4 = 0; i4 < 64; i4 += 7) {
            j4 |= (r3 & ByteCompanionObject.MAX_VALUE) << i4;
            if ((g() & ByteCompanionObject.MIN_VALUE) == 0) {
                return j4;
            }
        }
        throw new e("CodedInputStream encountered a malformed varint.");
    }

    public final int m() throws e {
        int iK = k();
        return (-(iK & 1)) ^ (iK >>> 1);
    }

    public final String n() throws e {
        int iK = k();
        int i4 = this.f1220b;
        int i5 = this.f1222d;
        if (iK > i4 - i5 || iK <= 0) {
            return new String(h(iK), Constants.UTF_8_CODE);
        }
        String str = new String(this.f1219a, i5, iK, Constants.UTF_8_CODE);
        this.f1222d += iK;
        return str;
    }

    public final int o() throws e {
        if (this.f1222d == this.f1220b) {
            q(false);
            this.f1223e = 0;
            return 0;
        }
        int iK = k();
        this.f1223e = iK;
        if (iK != 0) {
            return iK;
        }
        throw new e("Protocol message contained an invalid tag (zero).");
    }

    public final void p() {
        int i4 = this.f1220b + this.f1221c;
        this.f1220b = i4;
        int i5 = this.f1224f + i4;
        int i6 = this.f1225g;
        if (i5 <= i6) {
            this.f1221c = 0;
            return;
        }
        int i7 = i5 - i6;
        this.f1221c = i7;
        this.f1220b = i4 - i7;
    }

    public final void q(boolean z4) throws e {
        int i4 = this.f1222d;
        int i5 = this.f1220b;
        if (i4 < i5) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        int i6 = this.f1224f + i5;
        if (i6 == this.f1225g) {
            if (z4) {
                throw e.a();
            }
            return;
        }
        this.f1224f = i6;
        this.f1222d = 0;
        this.f1220b = 0;
        if (z4) {
            throw e.a();
        }
    }

    public final boolean r(int i4) throws e {
        int iO;
        int i5 = i4 & 7;
        if (i5 == 0) {
            k();
            return true;
        }
        if (i5 == 1) {
            j();
            return true;
        }
        if (i5 == 2) {
            s(k());
            return true;
        }
        if (i5 != 3) {
            if (i5 == 4) {
                return false;
            }
            if (i5 != 5) {
                throw new e("Protocol message tag had invalid wire type.");
            }
            i();
            return true;
        }
        do {
            iO = o();
            if (iO == 0) {
                break;
            }
        } while (r(iO));
        if (this.f1223e == (((i4 >>> 3) << 3) | 4)) {
            return true;
        }
        throw new e("Protocol message end-group tag did not match expected tag.");
    }

    public final void s(int i4) throws e {
        if (i4 < 0) {
            throw new e("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i5 = this.f1224f;
        int i6 = this.f1222d;
        int i7 = i5 + i6 + i4;
        int i8 = this.f1225g;
        if (i7 > i8) {
            s((i8 - i5) - i6);
            throw e.a();
        }
        int i9 = this.f1220b;
        int i10 = i9 - i6;
        if (i4 <= i10) {
            this.f1222d = i6 + i4;
            return;
        }
        this.f1224f = i5 + i9;
        this.f1222d = 0;
        this.f1220b = 0;
        if (i10 < i4) {
            throw e.a();
        }
    }
}
