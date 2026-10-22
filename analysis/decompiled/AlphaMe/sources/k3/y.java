package k3;

import Z2.I;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class y extends l {

    /* renamed from: e, reason: collision with root package name */
    public final transient byte[][] f13395e;

    /* renamed from: f, reason: collision with root package name */
    public final transient int[] f13396f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(byte[][] segments, int[] directory) {
        super(l.f13358d.f13359a);
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.f13395e = segments;
        this.f13396f = directory;
    }

    @Override // k3.l
    public final String a() {
        throw null;
    }

    @Override // k3.l
    public final l b(String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        byte[][] bArr = this.f13395e;
        int length = bArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int[] iArr = this.f13396f;
            int i6 = iArr[length + i4];
            int i7 = iArr[i4];
            messageDigest.update(bArr[i4], i6, i7 - i5);
            i4++;
            i5 = i7;
        }
        byte[] digestBytes = messageDigest.digest();
        Intrinsics.checkNotNullExpressionValue(digestBytes, "digestBytes");
        return new l(digestBytes);
    }

    @Override // k3.l
    public final int c() {
        return this.f13396f[this.f13395e.length - 1];
    }

    @Override // k3.l
    public final String d() {
        return new l(l()).d();
    }

    @Override // k3.l
    public final byte[] e() {
        return l();
    }

    @Override // k3.l
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (lVar.c() == c() && g(lVar, c())) {
                return true;
            }
        }
        return false;
    }

    @Override // k3.l
    public final byte f(int i4) {
        byte[][] bArr = this.f13395e;
        int length = bArr.length - 1;
        int[] iArr = this.f13396f;
        AbstractC0685G.b(iArr[length], i4, 1L);
        int iB = I.B(this, i4);
        return bArr[iB][(i4 - (iB == 0 ? 0 : iArr[iB - 1])) + iArr[bArr.length + iB]];
    }

    @Override // k3.l
    public final boolean g(l other, int i4) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (c() - i4 < 0) {
            return false;
        }
        int iB = I.B(this, 0);
        int i5 = 0;
        int i6 = 0;
        while (i5 < i4) {
            int[] iArr = this.f13396f;
            int i7 = iB == 0 ? 0 : iArr[iB - 1];
            int i8 = iArr[iB] - i7;
            byte[][] bArr = this.f13395e;
            int i9 = iArr[bArr.length + iB];
            int iMin = Math.min(i4, i8 + i7) - i5;
            if (!other.h(bArr[iB], i6, (i5 - i7) + i9, iMin)) {
                return false;
            }
            i6 += iMin;
            i5 += iMin;
            iB++;
        }
        return true;
    }

    @Override // k3.l
    public final boolean h(byte[] other, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (i4 < 0 || i4 > c() - i6 || i5 < 0 || i5 > other.length - i6) {
            return false;
        }
        int i7 = i6 + i4;
        int iB = I.B(this, i4);
        while (i4 < i7) {
            int[] iArr = this.f13396f;
            int i8 = iB == 0 ? 0 : iArr[iB - 1];
            int i9 = iArr[iB] - i8;
            byte[][] bArr = this.f13395e;
            int i10 = iArr[bArr.length + iB];
            int iMin = Math.min(i7, i9 + i8) - i4;
            if (!AbstractC0685G.a(bArr[iB], (i4 - i8) + i10, i5, other, iMin)) {
                return false;
            }
            i5 += iMin;
            i4 += iMin;
            iB++;
        }
        return true;
    }

    @Override // k3.l
    public final int hashCode() {
        int i4 = this.f13360b;
        if (i4 != 0) {
            return i4;
        }
        byte[][] bArr = this.f13395e;
        int length = bArr.length;
        int i5 = 0;
        int i6 = 1;
        int i7 = 0;
        while (i5 < length) {
            int[] iArr = this.f13396f;
            int i8 = iArr[length + i5];
            int i9 = iArr[i5];
            byte[] bArr2 = bArr[i5];
            int i10 = (i9 - i7) + i8;
            while (i8 < i10) {
                i6 = (i6 * 31) + bArr2[i8];
                i8++;
            }
            i5++;
            i7 = i9;
        }
        this.f13360b = i6;
        return i6;
    }

    @Override // k3.l
    public final l i() {
        return new l(l()).i();
    }

    @Override // k3.l
    public final void k(C0694i buffer, int i4) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int iB = I.B(this, 0);
        int i5 = 0;
        while (i5 < i4) {
            int[] iArr = this.f13396f;
            int i6 = iB == 0 ? 0 : iArr[iB - 1];
            int i7 = iArr[iB] - i6;
            byte[][] bArr = this.f13395e;
            int i8 = iArr[bArr.length + iB];
            int iMin = Math.min(i4, i7 + i6) - i5;
            int i9 = (i5 - i6) + i8;
            w wVar = new w(bArr[iB], i9, i9 + iMin, true, false);
            w wVar2 = buffer.f13356a;
            if (wVar2 == null) {
                wVar.f13391g = wVar;
                wVar.f13390f = wVar;
                buffer.f13356a = wVar;
            } else {
                Intrinsics.checkNotNull(wVar2);
                w wVar3 = wVar2.f13391g;
                Intrinsics.checkNotNull(wVar3);
                wVar3.b(wVar);
            }
            i5 += iMin;
            iB++;
        }
        buffer.f13357b += i4;
    }

    public final byte[] l() {
        byte[] bArr = new byte[c()];
        byte[][] bArr2 = this.f13395e;
        int length = bArr2.length;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i4 < length) {
            int[] iArr = this.f13396f;
            int i7 = iArr[length + i4];
            int i8 = iArr[i4];
            int i9 = i8 - i5;
            ArraysKt.copyInto(bArr2[i4], bArr, i6, i7, i7 + i9);
            i6 += i9;
            i4++;
            i5 = i8;
        }
        return bArr;
    }

    @Override // k3.l
    public final String toString() {
        return new l(l()).toString();
    }
}
