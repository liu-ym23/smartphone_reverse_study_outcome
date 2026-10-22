package D3;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class a implements Cloneable {

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f2244c = new int[0];

    /* renamed from: a, reason: collision with root package name */
    public int[] f2245a;

    /* renamed from: b, reason: collision with root package name */
    public int f2246b;

    public a() {
        this.f2246b = 0;
        this.f2245a = f2244c;
    }

    public static int[] n(int i10) {
        return new int[(i10 + 31) / 32];
    }

    public void a(boolean z10) {
        h(this.f2246b + 1);
        if (z10) {
            int[] iArr = this.f2245a;
            int i10 = this.f2246b;
            int i11 = i10 / 32;
            iArr[i11] = (1 << (i10 & 31)) | iArr[i11];
        }
        this.f2246b++;
    }

    public void d(a aVar) {
        int i10 = aVar.f2246b;
        h(this.f2246b + i10);
        for (int i11 = 0; i11 < i10; i11++) {
            a(aVar.i(i11));
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f2246b == aVar.f2246b && Arrays.equals(this.f2245a, aVar.f2245a);
    }

    public void f(int i10, int i11) {
        if (i11 < 0 || i11 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        int i12 = this.f2246b;
        h(i12 + i11);
        for (int i13 = i11 - 1; i13 >= 0; i13--) {
            if (((1 << i13) & i10) != 0) {
                int[] iArr = this.f2245a;
                int i14 = i12 / 32;
                iArr[i14] = iArr[i14] | (1 << (i12 & 31));
            }
            i12++;
        }
        this.f2246b = i12;
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public a clone() {
        return new a((int[]) this.f2245a.clone(), this.f2246b);
    }

    public final void h(int i10) {
        if (i10 > this.f2245a.length * 32) {
            int[] iArrN = n((int) Math.ceil(i10 / 0.75f));
            int[] iArr = this.f2245a;
            System.arraycopy(iArr, 0, iArrN, 0, iArr.length);
            this.f2245a = iArrN;
        }
    }

    public int hashCode() {
        return (this.f2246b * 31) + Arrays.hashCode(this.f2245a);
    }

    public boolean i(int i10) {
        return (this.f2245a[i10 / 32] & (1 << (i10 & 31))) != 0;
    }

    public int j() {
        return this.f2246b;
    }

    public int k() {
        return (this.f2246b + 7) / 8;
    }

    public void o(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = 0; i13 < i12; i13++) {
            int i14 = 0;
            for (int i15 = 0; i15 < 8; i15++) {
                if (i(i10)) {
                    i14 |= 1 << (7 - i15);
                }
                i10++;
            }
            bArr[i11 + i13] = (byte) i14;
        }
    }

    public void p(a aVar) {
        if (this.f2246b != aVar.f2246b) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i10 = 0;
        while (true) {
            int[] iArr = this.f2245a;
            if (i10 >= iArr.length) {
                return;
            }
            iArr[i10] = iArr[i10] ^ aVar.f2245a[i10];
            i10++;
        }
    }

    public String toString() {
        int i10 = this.f2246b;
        StringBuilder sb2 = new StringBuilder(i10 + (i10 / 8) + 1);
        for (int i11 = 0; i11 < this.f2246b; i11++) {
            if ((i11 & 7) == 0) {
                sb2.append(' ');
            }
            sb2.append(i(i11) ? 'X' : '.');
        }
        return sb2.toString();
    }

    public a(int[] iArr, int i10) {
        this.f2245a = iArr;
        this.f2246b = i10;
    }
}
