package p;

import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public int[] f9629a;

    /* renamed from: b, reason: collision with root package name */
    public int f9630b;

    public t(int i) {
        this.f9629a = i == 0 ? l.f9589a : new int[i];
    }

    public final void a(int i) {
        b(this.f9630b + 1);
        int[] iArr = this.f9629a;
        int i3 = this.f9630b;
        iArr[i3] = i;
        this.f9630b = i3 + 1;
    }

    public final void b(int i) {
        int[] iArr = this.f9629a;
        if (iArr.length < i) {
            this.f9629a = Arrays.copyOf(iArr, Math.max(i, (iArr.length * 3) / 2));
        }
    }

    public final int c(int i) {
        if (i >= 0 && i < this.f9630b) {
            return this.f9629a[i];
        }
        g5.f.q("Index must be between 0 and size");
        return 0;
    }

    public final void d(int i) {
        int i3;
        if (i < 0 || i >= (i3 = this.f9630b)) {
            g5.f.q("Index must be between 0 and size");
            return;
        }
        int[] iArr = this.f9629a;
        int i10 = iArr[i];
        if (i != i3 - 1) {
            kb.k.f0(i, i + 1, iArr, iArr, i3);
        }
        this.f9630b--;
    }

    public final void e(int i, int i3) {
        if (i < 0 || i >= this.f9630b) {
            g5.f.q("Index must be between 0 and size");
            return;
        }
        int[] iArr = this.f9629a;
        int i10 = iArr[i];
        iArr[i] = i3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof t) {
            t tVar = (t) obj;
            int i = tVar.f9630b;
            int i3 = this.f9630b;
            if (i == i3) {
                int[] iArr = this.f9629a;
                int[] iArr2 = tVar.f9629a;
                ec.g gVarO = p5.f.O(0, i3);
                int i10 = gVarO.f3758c;
                int i11 = gVarO.f3759f;
                if (i10 > i11) {
                    return true;
                }
                while (iArr[i10] == iArr2[i10]) {
                    if (i10 == i11) {
                        return true;
                    }
                    i10++;
                }
                return false;
            }
        }
        return false;
    }

    public final int hashCode() {
        int[] iArr = this.f9629a;
        int i = this.f9630b;
        int iHashCode = 0;
        for (int i3 = 0; i3 < i; i3++) {
            iHashCode += Integer.hashCode(iArr[i3]) * 31;
        }
        return iHashCode;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "[");
        int[] iArr = this.f9629a;
        int i = this.f9630b;
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                sb2.append((CharSequence) "]");
                break;
            }
            int i10 = iArr[i3];
            if (i3 == -1) {
                sb2.append((CharSequence) "...");
                break;
            }
            if (i3 != 0) {
                sb2.append((CharSequence) ", ");
            }
            sb2.append(i10);
            i3++;
        }
        return sb2.toString();
    }

    public /* synthetic */ t() {
        this(16);
    }
}
