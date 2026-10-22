package k;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public int[] f5529a;

    /* renamed from: b, reason: collision with root package name */
    public int f5530b;

    public s(int i2) {
        this.f5529a = i2 == 0 ? l.f5505a : new int[i2];
    }

    public final void a(int i2) {
        b(this.f5530b + 1);
        int[] iArr = this.f5529a;
        int i10 = this.f5530b;
        iArr[i10] = i2;
        this.f5530b = i10 + 1;
    }

    public final void b(int i2) {
        int[] iArr = this.f5529a;
        if (iArr.length < i2) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, Math.max(i2, (iArr.length * 3) / 2));
            q7.k.d(iArrCopyOf, "copyOf(...)");
            this.f5529a = iArrCopyOf;
        }
    }

    public final int c(int i2) {
        if (i2 >= 0 && i2 < this.f5530b) {
            return this.f5529a[i2];
        }
        l.a.d("Index must be between 0 and size");
        throw null;
    }

    public final void d(int i2) {
        int i10;
        if (i2 < 0 || i2 >= (i10 = this.f5530b)) {
            l.a.d("Index must be between 0 and size");
            throw null;
        }
        int[] iArr = this.f5529a;
        int i11 = iArr[i2];
        if (i2 != i10 - 1) {
            d7.n.W(iArr, iArr, i2, i2 + 1, i10);
        }
        this.f5530b--;
    }

    public final void e(int i2, int i10) {
        if (i2 < 0 || i2 >= this.f5530b) {
            l.a.d("Index must be between 0 and size");
            throw null;
        }
        int[] iArr = this.f5529a;
        int i11 = iArr[i2];
        iArr[i2] = i10;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof s) {
            s sVar = (s) obj;
            int i2 = sVar.f5530b;
            int i10 = this.f5530b;
            if (i2 == i10) {
                int[] iArr = this.f5529a;
                int[] iArr2 = sVar.f5529a;
                v7.d dVarN = nb.i.N(0, i10);
                int i11 = dVarN.f10523f;
                int i12 = dVarN.f10524g;
                if (i11 > i12) {
                    return true;
                }
                while (iArr[i11] == iArr2[i11]) {
                    if (i11 == i12) {
                        return true;
                    }
                    i11++;
                }
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        int[] iArr = this.f5529a;
        int i2 = this.f5530b;
        int iHashCode = 0;
        for (int i10 = 0; i10 < i2; i10++) {
            iHashCode += Integer.hashCode(iArr[i10]) * 31;
        }
        return iHashCode;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "[");
        int[] iArr = this.f5529a;
        int i2 = this.f5530b;
        int i10 = 0;
        while (true) {
            if (i10 >= i2) {
                sb2.append((CharSequence) "]");
                break;
            }
            int i11 = iArr[i10];
            if (i10 == -1) {
                sb2.append((CharSequence) "...");
                break;
            }
            if (i10 != 0) {
                sb2.append((CharSequence) ", ");
            }
            sb2.append(i11);
            i10++;
        }
        String string = sb2.toString();
        q7.k.d(string, "toString(...)");
        return string;
    }

    public /* synthetic */ s() {
        this(16);
    }
}
