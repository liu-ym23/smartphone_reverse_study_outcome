package com.baidu.b.a;

import androidx.room.AbstractC0351g;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* loaded from: classes.dex */
public class b implements Serializable, Cloneable {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ boolean f4709a = true;

    /* renamed from: b, reason: collision with root package name */
    private static final ObjectStreamField[] f4710b = {new ObjectStreamField("bits", long[].class)};

    /* renamed from: c, reason: collision with root package name */
    private long[] f4711c;

    /* renamed from: d, reason: collision with root package name */
    private transient int f4712d;

    /* renamed from: e, reason: collision with root package name */
    private transient boolean f4713e;

    public b() {
        this.f4712d = 0;
        this.f4713e = false;
        g(64);
        this.f4713e = false;
    }

    public static b a(long[] jArr) {
        int length = jArr.length;
        while (length > 0 && jArr[length - 1] == 0) {
            length--;
        }
        return new b(Arrays.copyOf(jArr, length));
    }

    private static int f(int i4) {
        return i4 >> 6;
    }

    private void g(int i4) {
        this.f4711c = new long[f(i4 - 1) + 1];
    }

    private void h(int i4) {
        long[] jArr = this.f4711c;
        if (jArr.length < i4) {
            this.f4711c = Arrays.copyOf(this.f4711c, Math.max(jArr.length * 2, i4));
            this.f4713e = false;
        }
    }

    private void i(int i4) {
        int i5 = i4 + 1;
        if (this.f4712d < i5) {
            h(i5);
            this.f4712d = i5;
        }
    }

    public int b() {
        int i4 = this.f4712d;
        if (i4 == 0) {
            return 0;
        }
        int i5 = i4 - 1;
        return (64 - Long.numberOfLeadingZeros(this.f4711c[i5])) + (i5 * 64);
    }

    public int c() {
        int iBitCount = 0;
        for (int i4 = 0; i4 < this.f4712d; i4++) {
            iBitCount += Long.bitCount(this.f4711c[i4]);
        }
        return iBitCount;
    }

    public Object clone() {
        if (!this.f4713e) {
            f();
        }
        try {
            b bVar = (b) super.clone();
            bVar.f4711c = (long[]) this.f4711c.clone();
            bVar.d();
            return bVar;
        } catch (CloneNotSupportedException unused) {
            throw new InternalError();
        }
    }

    public int d(int i4) {
        if (i4 < 0) {
            throw new IndexOutOfBoundsException(AbstractC0351g.m("fromIndex < 0: ", i4));
        }
        d();
        int iF = f(i4);
        if (iF >= this.f4712d) {
            return -1;
        }
        long j4 = this.f4711c[iF] & ((-1) << i4);
        while (j4 == 0) {
            iF++;
            if (iF == this.f4712d) {
                return -1;
            }
            j4 = this.f4711c[iF];
        }
        return Long.numberOfTrailingZeros(j4) + (iF * 64);
    }

    public int e(int i4) {
        if (i4 < 0) {
            throw new IndexOutOfBoundsException(AbstractC0351g.m("fromIndex < 0: ", i4));
        }
        d();
        int iF = f(i4);
        if (iF >= this.f4712d) {
            return i4;
        }
        long j4 = (~this.f4711c[iF]) & ((-1) << i4);
        while (j4 == 0) {
            iF++;
            int i5 = this.f4712d;
            if (iF == i5) {
                return i5 * 64;
            }
            j4 = ~this.f4711c[iF];
        }
        return Long.numberOfTrailingZeros(j4) + (iF * 64);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        b bVar = (b) obj;
        d();
        bVar.d();
        if (this.f4712d != bVar.f4712d) {
            return false;
        }
        for (int i4 = 0; i4 < this.f4712d; i4++) {
            if (this.f4711c[i4] != bVar.f4711c[i4]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i4 = this.f4712d;
        long j4 = 1234;
        while (true) {
            int i5 = i4 - 1;
            if (i5 < 0) {
                return (int) ((j4 >> 32) ^ j4);
            }
            j4 ^= this.f4711c[i5] * i4;
            i4 = i5;
        }
    }

    public String toString() {
        d();
        int i4 = this.f4712d;
        StringBuilder sb = new StringBuilder(((i4 > 128 ? c() : i4 * 64) * 6) + 2);
        sb.append('{');
        int iD = d(0);
        if (iD != -1) {
            sb.append(iD);
            int i5 = iD + 1;
            while (true) {
                int iD2 = d(i5);
                if (iD2 < 0) {
                    break;
                }
                int iE = e(iD2);
                while (true) {
                    sb.append(", ");
                    sb.append(iD2);
                    int i6 = iD2 + 1;
                    if (i6 >= iE) {
                        break;
                    }
                    iD2 = i6;
                }
                i5 = iD2 + 2;
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public b(int i4) {
        this.f4712d = 0;
        this.f4713e = false;
        if (i4 < 0) {
            throw new NegativeArraySizeException(AbstractC0351g.m("nbits < 0: ", i4));
        }
        g(i4);
        this.f4713e = true;
    }

    private void f() {
        int i4 = this.f4712d;
        long[] jArr = this.f4711c;
        if (i4 != jArr.length) {
            this.f4711c = Arrays.copyOf(jArr, i4);
            d();
        }
    }

    public void a(int i4) {
        if (i4 < 0) {
            throw new IndexOutOfBoundsException(AbstractC0351g.m("bitIndex < 0: ", i4));
        }
        int iF = f(i4);
        i(iF);
        long[] jArr = this.f4711c;
        jArr[iF] = jArr[iF] | (1 << i4);
        d();
    }

    public void b(int i4) {
        if (i4 < 0) {
            throw new IndexOutOfBoundsException(AbstractC0351g.m("bitIndex < 0: ", i4));
        }
        int iF = f(i4);
        if (iF >= this.f4712d) {
            return;
        }
        long[] jArr = this.f4711c;
        jArr[iF] = jArr[iF] & (~(1 << i4));
        e();
        d();
    }

    public b c(int i4, int i5) {
        int i6 = i5;
        d(i4, i5);
        d();
        int iB = b();
        int i7 = 0;
        if (iB <= i4 || i4 == i6) {
            return new b(0);
        }
        if (i6 > iB) {
            i6 = iB;
        }
        int i8 = i6 - i4;
        b bVar = new b(i8);
        int iF = f(i8 - 1);
        int i9 = iF + 1;
        int iF2 = f(i4);
        int i10 = i4 & 63;
        boolean z4 = i10 == 0;
        while (i7 < iF) {
            long[] jArr = bVar.f4711c;
            long[] jArr2 = this.f4711c;
            jArr[i7] = z4 ? jArr2[iF2] : (jArr2[iF2] >>> i4) | (jArr2[iF2 + 1] << (-i4));
            i7++;
            iF2++;
        }
        long j4 = (-1) >>> (-i6);
        long[] jArr3 = bVar.f4711c;
        int i11 = (i6 - 1) & 63;
        long[] jArr4 = this.f4711c;
        jArr3[iF] = i11 < i10 ? ((jArr4[iF2 + 1] & j4) << (-i4)) | (jArr4[iF2] >>> i4) : (jArr4[iF2] & j4) >>> i4;
        bVar.f4712d = i9;
        bVar.e();
        bVar.d();
        return bVar;
    }

    public void c(b bVar) {
        int iMin = Math.min(this.f4712d, bVar.f4712d);
        int i4 = this.f4712d;
        int i5 = bVar.f4712d;
        if (i4 < i5) {
            h(i5);
            this.f4712d = bVar.f4712d;
        }
        for (int i6 = 0; i6 < iMin; i6++) {
            long[] jArr = this.f4711c;
            jArr[i6] = jArr[i6] ^ bVar.f4711c[i6];
        }
        int i7 = bVar.f4712d;
        if (iMin < i7) {
            System.arraycopy(bVar.f4711c, iMin, this.f4711c, iMin, i7 - iMin);
        }
        e();
        d();
    }

    public boolean c(int i4) {
        if (i4 < 0) {
            throw new IndexOutOfBoundsException(AbstractC0351g.m("bitIndex < 0: ", i4));
        }
        d();
        int iF = f(i4);
        if (iF < this.f4712d) {
            if (((1 << i4) & this.f4711c[iF]) != 0) {
                return true;
            }
        }
        return false;
    }

    private void d() {
        int i4;
        int i5;
        boolean z4 = f4709a;
        if (!z4 && (i5 = this.f4712d) != 0 && this.f4711c[i5 - 1] == 0) {
            throw new AssertionError();
        }
        if (!z4 && ((i4 = this.f4712d) < 0 || i4 > this.f4711c.length)) {
            throw new AssertionError();
        }
        if (z4) {
            return;
        }
        int i6 = this.f4712d;
        long[] jArr = this.f4711c;
        if (i6 != jArr.length && jArr[i6] != 0) {
            throw new AssertionError();
        }
    }

    private void e() {
        int i4 = this.f4712d - 1;
        while (i4 >= 0 && this.f4711c[i4] == 0) {
            i4--;
        }
        this.f4712d = i4 + 1;
    }

    private b(long[] jArr) {
        this.f4712d = 0;
        this.f4713e = false;
        this.f4711c = jArr;
        this.f4712d = jArr.length;
        d();
    }

    private static void d(int i4, int i5) {
        if (i4 < 0) {
            throw new IndexOutOfBoundsException(AbstractC0351g.m("fromIndex < 0: ", i4));
        }
        if (i5 < 0) {
            throw new IndexOutOfBoundsException(AbstractC0351g.m("toIndex < 0: ", i5));
        }
        if (i4 > i5) {
            throw new IndexOutOfBoundsException(B0.g.k("fromIndex: ", i4, " > toIndex: ", i5));
        }
    }

    public void a(int i4, int i5) {
        d(i4, i5);
        if (i4 == i5) {
            return;
        }
        int iF = f(i4);
        int iF2 = f(i5 - 1);
        i(iF2);
        long j4 = (-1) << i4;
        long j5 = (-1) >>> (-i5);
        if (iF == iF2) {
            long[] jArr = this.f4711c;
            jArr[iF] = (j5 & j4) | jArr[iF];
        } else {
            long[] jArr2 = this.f4711c;
            jArr2[iF] = j4 | jArr2[iF];
            while (true) {
                iF++;
                if (iF >= iF2) {
                    break;
                } else {
                    this.f4711c[iF] = -1;
                }
            }
            long[] jArr3 = this.f4711c;
            jArr3[iF2] = j5 | jArr3[iF2];
        }
        d();
    }

    public void b(int i4, int i5) {
        int iF;
        d(i4, i5);
        if (i4 != i5 && (iF = f(i4)) < this.f4712d) {
            int iF2 = f(i5 - 1);
            if (iF2 >= this.f4712d) {
                i5 = b();
                iF2 = this.f4712d - 1;
            }
            long j4 = (-1) << i4;
            long j5 = (-1) >>> (-i5);
            if (iF == iF2) {
                long[] jArr = this.f4711c;
                jArr[iF] = (~(j5 & j4)) & jArr[iF];
            } else {
                long[] jArr2 = this.f4711c;
                jArr2[iF] = (~j4) & jArr2[iF];
                while (true) {
                    iF++;
                    if (iF >= iF2) {
                        break;
                    } else {
                        this.f4711c[iF] = 0;
                    }
                }
                long[] jArr3 = this.f4711c;
                jArr3[iF2] = (~j5) & jArr3[iF2];
            }
            e();
            d();
        }
    }

    public void a(int i4, int i5, boolean z4) {
        if (z4) {
            a(i4, i5);
        } else {
            b(i4, i5);
        }
    }

    public void b(b bVar) {
        if (this == bVar) {
            return;
        }
        int iMin = Math.min(this.f4712d, bVar.f4712d);
        int i4 = this.f4712d;
        int i5 = bVar.f4712d;
        if (i4 < i5) {
            h(i5);
            this.f4712d = bVar.f4712d;
        }
        for (int i6 = 0; i6 < iMin; i6++) {
            long[] jArr = this.f4711c;
            jArr[i6] = jArr[i6] | bVar.f4711c[i6];
        }
        if (iMin < bVar.f4712d) {
            System.arraycopy(bVar.f4711c, iMin, this.f4711c, iMin, this.f4712d - iMin);
        }
        d();
    }

    public void a(int i4, boolean z4) {
        if (z4) {
            a(i4);
        } else {
            b(i4);
        }
    }

    public void a(b bVar) {
        if (this == bVar) {
            return;
        }
        while (true) {
            int i4 = this.f4712d;
            if (i4 <= bVar.f4712d) {
                break;
            }
            long[] jArr = this.f4711c;
            int i5 = i4 - 1;
            this.f4712d = i5;
            jArr[i5] = 0;
        }
        for (int i6 = 0; i6 < this.f4712d; i6++) {
            long[] jArr2 = this.f4711c;
            jArr2[i6] = jArr2[i6] & bVar.f4711c[i6];
        }
        e();
        d();
    }

    public byte[] a() {
        int i4 = this.f4712d;
        if (i4 == 0) {
            return new byte[0];
        }
        int i5 = i4 - 1;
        int i6 = i5 * 8;
        for (long j4 = this.f4711c[i5]; j4 != 0; j4 >>>= 8) {
            i6++;
        }
        byte[] bArr = new byte[i6];
        ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        for (int i7 = 0; i7 < i5; i7++) {
            byteBufferOrder.putLong(this.f4711c[i7]);
        }
        for (long j5 = this.f4711c[i5]; j5 != 0; j5 >>>= 8) {
            byteBufferOrder.put((byte) (255 & j5));
        }
        return bArr;
    }

    public void d(b bVar) {
        for (int iMin = Math.min(this.f4712d, bVar.f4712d) - 1; iMin >= 0; iMin--) {
            long[] jArr = this.f4711c;
            jArr[iMin] = jArr[iMin] & (~bVar.f4711c[iMin]);
        }
        e();
        d();
    }
}
