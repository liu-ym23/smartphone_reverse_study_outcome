package okio;

import D7.q;
import H4.o;
import V9.g;
import V9.s;
import W9.b;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "Ljava/lang/Object;", "writeReplace", "()Ljava/lang/Object;", "okio"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SegmentedByteString extends ByteString {
    public final transient byte[][] e;
    public final transient int[] f;

    public SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.d.data);
        this.e = bArr;
        this.f = iArr;
    }

    private final Object writeReplace() {
        return new ByteString(l());
    }

    @Override // okio.ByteString
    public final String a() {
        throw null;
    }

    @Override // okio.ByteString
    public final ByteString b(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        byte[][] bArr = this.e;
        int length = bArr.length;
        int i = 0;
        int i6 = 0;
        while (i < length) {
            int[] iArr = this.f;
            int i10 = iArr[length + i];
            int i11 = iArr[i];
            messageDigest.update(bArr[i], i10, i11 - i6);
            i++;
            i6 = i11;
        }
        byte[] bArrDigest = messageDigest.digest();
        k.c(bArrDigest);
        return new ByteString(bArrDigest);
    }

    @Override // okio.ByteString
    public final int c() {
        return this.f[this.e.length - 1];
    }

    @Override // okio.ByteString
    public final String d() {
        return new ByteString(l()).d();
    }

    @Override // okio.ByteString
    /* renamed from: e */
    public final byte[] getData() {
        return l();
    }

    @Override // okio.ByteString
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString)) {
            return false;
        }
        ByteString byteString = (ByteString) obj;
        return byteString.c() == c() && h(byteString, c());
    }

    @Override // okio.ByteString
    public final byte f(int i) {
        byte[][] bArr = this.e;
        int length = bArr.length - 1;
        int[] iArr = this.f;
        o.t(iArr[length], i, 1L);
        int iB = b.b(this, i);
        return bArr[iB][(i - (iB == 0 ? 0 : iArr[iB - 1])) + iArr[bArr.length + iB]];
    }

    @Override // okio.ByteString
    public final boolean g(int i, int i6, byte[] other, int i10) {
        k.f(other, "other");
        if (i < 0 || i > c() - i10 || i6 < 0 || i6 > other.length - i10) {
            return false;
        }
        int i11 = i10 + i;
        int iB = b.b(this, i);
        while (i < i11) {
            int[] iArr = this.f;
            int i12 = iB == 0 ? 0 : iArr[iB - 1];
            int i13 = iArr[iB] - i12;
            byte[][] bArr = this.e;
            int i14 = iArr[bArr.length + iB];
            int iMin = Math.min(i11, i13 + i12) - i;
            if (!o.l(bArr[iB], (i - i12) + i14, i6, other, iMin)) {
                return false;
            }
            i6 += iMin;
            i += iMin;
            iB++;
        }
        return true;
    }

    @Override // okio.ByteString
    public final boolean h(ByteString other, int i) {
        k.f(other, "other");
        if (c() - i >= 0) {
            int iB = b.b(this, 0);
            int i6 = 0;
            int i10 = 0;
            while (i6 < i) {
                int[] iArr = this.f;
                int i11 = iB == 0 ? 0 : iArr[iB - 1];
                int i12 = iArr[iB] - i11;
                byte[][] bArr = this.e;
                int i13 = iArr[bArr.length + iB];
                int iMin = Math.min(i, i12 + i11) - i6;
                if (other.g(i10, (i6 - i11) + i13, bArr[iB], iMin)) {
                    i10 += iMin;
                    i6 += iMin;
                    iB++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // okio.ByteString
    public final int hashCode() {
        int i = this.b;
        if (i != 0) {
            return i;
        }
        byte[][] bArr = this.e;
        int length = bArr.length;
        int i6 = 0;
        int i10 = 1;
        int i11 = 0;
        while (i6 < length) {
            int[] iArr = this.f;
            int i12 = iArr[length + i6];
            int i13 = iArr[i6];
            byte[] bArr2 = bArr[i6];
            int i14 = (i13 - i11) + i12;
            while (i12 < i14) {
                i10 = (i10 * 31) + bArr2[i12];
                i12++;
            }
            i6++;
            i11 = i13;
        }
        this.b = i10;
        return i10;
    }

    @Override // okio.ByteString
    public final ByteString i() {
        return new ByteString(l()).i();
    }

    @Override // okio.ByteString
    public final void k(g gVar, int i) {
        int iB = b.b(this, 0);
        int i6 = 0;
        while (i6 < i) {
            int[] iArr = this.f;
            int i10 = iB == 0 ? 0 : iArr[iB - 1];
            int i11 = iArr[iB] - i10;
            byte[][] bArr = this.e;
            int i12 = iArr[bArr.length + iB];
            int iMin = Math.min(i, i11 + i10) - i6;
            int i13 = (i6 - i10) + i12;
            s sVar = new s(bArr[iB], i13, i13 + iMin, true);
            s sVar2 = gVar.f1418a;
            if (sVar2 == null) {
                sVar.g = sVar;
                sVar.f = sVar;
                gVar.f1418a = sVar;
            } else {
                s sVar3 = sVar2.g;
                k.c(sVar3);
                sVar3.b(sVar);
            }
            i6 += iMin;
            iB++;
        }
        gVar.b += i;
    }

    public final byte[] l() {
        byte[] bArr = new byte[c()];
        byte[][] bArr2 = this.e;
        int length = bArr2.length;
        int i = 0;
        int i6 = 0;
        int i10 = 0;
        while (i < length) {
            int[] iArr = this.f;
            int i11 = iArr[length + i];
            int i12 = iArr[i];
            int i13 = i12 - i6;
            q.S(bArr2[i], i10, i11, bArr, i11 + i13);
            i10 += i13;
            i++;
            i6 = i12;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public final String toString() {
        return new ByteString(l()).toString();
    }
}
