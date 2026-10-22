package okio;

import androidx.datastore.preferences.protobuf.b1;
import com.stepos.core.ota.d;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.jvm.internal.g;
import mb.y;
import sd.a0;
import sd.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class SegmentedByteString extends ByteString {

    /* renamed from: e, reason: collision with root package name */
    public final transient byte[][] f11316e;
    public final transient int[] h;

    public SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.f11312d.f11313a);
        this.f11316e = bArr;
        this.h = iArr;
    }

    private final Object writeReplace() {
        return u();
    }

    @Override // okio.ByteString
    public final String a() {
        throw null;
    }

    @Override // okio.ByteString
    public final ByteString c(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.f11316e;
        int length = bArr.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int[] iArr = this.h;
            int i12 = iArr[length + i10];
            int i13 = iArr[i10];
            messageDigest.update(bArr[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
        byte[] bArrDigest = messageDigest.digest();
        g.c(bArrDigest);
        return new ByteString(bArrDigest);
    }

    @Override // okio.ByteString
    public final int d() {
        return this.h[this.f11316e.length - 1];
    }

    @Override // okio.ByteString
    public final String e() {
        return u().e();
    }

    @Override // okio.ByteString
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.d() == d() && m(0, byteString, d())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public final int g(byte[] other, int i10) {
        g.f(other, "other");
        return u().g(other, i10);
    }

    @Override // okio.ByteString
    public final int hashCode() {
        int i10 = this.f11314b;
        if (i10 != 0) {
            return i10;
        }
        byte[][] bArr = this.f11316e;
        int length = bArr.length;
        int i11 = 0;
        int i12 = 1;
        int i13 = 0;
        while (i11 < length) {
            int[] iArr = this.h;
            int i14 = iArr[length + i11];
            int i15 = iArr[i11];
            byte[] bArr2 = bArr[i11];
            int i16 = (i15 - i13) + i14;
            while (i14 < i16) {
                i12 = (i12 * 31) + bArr2[i14];
                i14++;
            }
            i11++;
            i13 = i15;
        }
        this.f11314b = i12;
        return i12;
    }

    @Override // okio.ByteString
    public final byte[] i() {
        return t();
    }

    @Override // okio.ByteString
    public final byte j(int i10) {
        byte[][] bArr = this.f11316e;
        int length = bArr.length - 1;
        int[] iArr = this.h;
        sd.a.b(iArr[length], i10, 1L);
        int iK = y.K(this, i10);
        return bArr[iK][(i10 - (iK == 0 ? 0 : iArr[iK - 1])) + iArr[bArr.length + iK]];
    }

    @Override // okio.ByteString
    public final int k(byte[] other, int i10) {
        g.f(other, "other");
        return u().k(other, i10);
    }

    @Override // okio.ByteString
    public final boolean m(int i10, ByteString other, int i11) {
        g.f(other, "other");
        if (i10 >= 0 && i10 <= d() - i11) {
            int i12 = i11 + i10;
            int iK = y.K(this, i10);
            int i13 = 0;
            while (i10 < i12) {
                int[] iArr = this.h;
                int i14 = iK == 0 ? 0 : iArr[iK - 1];
                int i15 = iArr[iK] - i14;
                byte[][] bArr = this.f11316e;
                int i16 = iArr[bArr.length + iK];
                int iMin = Math.min(i12, i15 + i14) - i10;
                if (other.n(bArr[iK], i13, (i10 - i14) + i16, iMin)) {
                    i13 += iMin;
                    i10 += iMin;
                    iK++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // okio.ByteString
    public final boolean n(byte[] other, int i10, int i11, int i12) {
        g.f(other, "other");
        if (i10 < 0 || i10 > d() - i12 || i11 < 0 || i11 > other.length - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int iK = y.K(this, i10);
        while (i10 < i13) {
            int[] iArr = this.h;
            int i14 = iK == 0 ? 0 : iArr[iK - 1];
            int i15 = iArr[iK] - i14;
            byte[][] bArr = this.f11316e;
            int i16 = iArr[bArr.length + iK];
            int iMin = Math.min(i13, i15 + i14) - i10;
            if (!sd.a.a((i10 - i14) + i16, i11, iMin, bArr[iK], other)) {
                return false;
            }
            i11 += iMin;
            i10 += iMin;
            iK++;
        }
        return true;
    }

    @Override // okio.ByteString
    public final ByteString o(int i10, int i11) {
        int iC = sd.a.c(i11, this);
        if (i10 < 0) {
            throw new IllegalArgumentException(ai.onnxruntime.a.g(i10, "beginIndex=", " < 0").toString());
        }
        if (iC > d()) {
            StringBuilder sbK = d.k(iC, "endIndex=", " > length(");
            sbK.append(d());
            sbK.append(')');
            throw new IllegalArgumentException(sbK.toString().toString());
        }
        int i12 = iC - i10;
        if (i12 < 0) {
            throw new IllegalArgumentException(a0.a.f("endIndex=", iC, i10, " < beginIndex=").toString());
        }
        if (i10 == 0 && iC == d()) {
            return this;
        }
        if (i10 == iC) {
            return ByteString.f11312d;
        }
        int iK = y.K(this, i10);
        int iK2 = y.K(this, iC - 1);
        byte[][] bArr = this.f11316e;
        byte[][] bArr2 = (byte[][]) b1.v(bArr, iK, iK2 + 1);
        int[] iArr = new int[bArr2.length * 2];
        int[] iArr2 = this.h;
        if (iK <= iK2) {
            int i13 = iK;
            int i14 = 0;
            while (true) {
                iArr[i14] = Math.min(iArr2[i13] - i10, i12);
                int i15 = i14 + 1;
                iArr[i14 + bArr2.length] = iArr2[bArr.length + i13];
                if (i13 == iK2) {
                    break;
                }
                i13++;
                i14 = i15;
            }
        }
        int i16 = iK != 0 ? iArr2[iK - 1] : 0;
        int length = bArr2.length;
        iArr[length] = (i10 - i16) + iArr[length];
        return new SegmentedByteString(bArr2, iArr);
    }

    @Override // okio.ByteString
    public final ByteString q() {
        return u().q();
    }

    @Override // okio.ByteString
    public final void s(e eVar, int i10) {
        int iK = y.K(this, 0);
        int i11 = 0;
        while (i11 < i10) {
            int[] iArr = this.h;
            int i12 = iK == 0 ? 0 : iArr[iK - 1];
            int i13 = iArr[iK] - i12;
            byte[][] bArr = this.f11316e;
            int i14 = iArr[bArr.length + iK];
            int iMin = Math.min(i10, i13 + i12) - i11;
            int i15 = (i11 - i12) + i14;
            a0 a0Var = new a0(bArr[iK], i15, i15 + iMin, true, false);
            a0 a0Var2 = eVar.f11925a;
            if (a0Var2 == null) {
                a0Var.f11907g = a0Var;
                a0Var.f11906f = a0Var;
                eVar.f11925a = a0Var;
            } else {
                a0 a0Var3 = a0Var2.f11907g;
                g.c(a0Var3);
                a0Var3.b(a0Var);
            }
            i11 += iMin;
            iK++;
        }
        eVar.f11926b += i10;
    }

    public final byte[] t() {
        byte[] bArr = new byte[d()];
        byte[][] bArr2 = this.f11316e;
        int length = bArr2.length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int[] iArr = this.h;
            int i13 = iArr[length + i10];
            int i14 = iArr[i10];
            int i15 = i14 - i11;
            b1.n(i12, i13, i13 + i15, bArr2[i10], bArr);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public final String toString() {
        return u().toString();
    }

    public final ByteString u() {
        return new ByteString(t());
    }
}
