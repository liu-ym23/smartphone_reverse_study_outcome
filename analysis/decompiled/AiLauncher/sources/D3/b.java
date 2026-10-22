package D3;

import java.util.Arrays;

/* loaded from: classes2.dex */
public final class b implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public int f2247a;

    /* renamed from: b, reason: collision with root package name */
    public int f2248b;

    /* renamed from: c, reason: collision with root package name */
    public int f2249c;

    /* renamed from: d, reason: collision with root package name */
    public int[] f2250d;

    public b(int i10) {
        this(i10, i10);
    }

    public final String a(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(this.f2248b * (this.f2247a + 1));
        for (int i10 = 0; i10 < this.f2248b; i10++) {
            for (int i11 = 0; i11 < this.f2247a; i11++) {
                sb2.append(g(i11, i10) ? str : str2);
            }
            sb2.append(str3);
        }
        return sb2.toString();
    }

    public void d() {
        int length = this.f2250d.length;
        for (int i10 = 0; i10 < length; i10++) {
            this.f2250d[i10] = 0;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2247a == bVar.f2247a && this.f2248b == bVar.f2248b && this.f2249c == bVar.f2249c && Arrays.equals(this.f2250d, bVar.f2250d);
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public b clone() {
        return new b(this.f2247a, this.f2248b, this.f2249c, (int[]) this.f2250d.clone());
    }

    public boolean g(int i10, int i11) {
        return ((this.f2250d[(i11 * this.f2249c) + (i10 / 32)] >>> (i10 & 31)) & 1) != 0;
    }

    public int h() {
        return this.f2248b;
    }

    public int hashCode() {
        int i10 = this.f2247a;
        return (((((((i10 * 31) + i10) * 31) + this.f2248b) * 31) + this.f2249c) * 31) + Arrays.hashCode(this.f2250d);
    }

    public int i() {
        return this.f2247a;
    }

    public void j(int i10, int i11) {
        int i12 = (i11 * this.f2249c) + (i10 / 32);
        int[] iArr = this.f2250d;
        iArr[i12] = (1 << (i10 & 31)) | iArr[i12];
    }

    public void k(int i10, int i11, int i12, int i13) {
        if (i11 < 0 || i10 < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i13 < 1 || i12 < 1) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i14 = i12 + i10;
        int i15 = i13 + i11;
        if (i15 > this.f2248b || i14 > this.f2247a) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i11 < i15) {
            int i16 = this.f2249c * i11;
            for (int i17 = i10; i17 < i14; i17++) {
                int[] iArr = this.f2250d;
                int i18 = (i17 / 32) + i16;
                iArr[i18] = iArr[i18] | (1 << (i17 & 31));
            }
            i11++;
        }
    }

    public String n(String str, String str2) {
        return a(str, str2, "\n");
    }

    public String toString() {
        return n("X ", "  ");
    }

    public b(int i10, int i11) {
        if (i10 < 1 || i11 < 1) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f2247a = i10;
        this.f2248b = i11;
        int i12 = (i10 + 31) / 32;
        this.f2249c = i12;
        this.f2250d = new int[i12 * i11];
    }

    public b(int i10, int i11, int i12, int[] iArr) {
        this.f2247a = i10;
        this.f2248b = i11;
        this.f2249c = i12;
        this.f2250d = iArr;
    }
}
