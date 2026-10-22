package k;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class v {

    /* renamed from: a, reason: collision with root package name */
    public long[] f5537a;

    /* renamed from: b, reason: collision with root package name */
    public int f5538b;

    public v(int i2) {
        this.f5537a = i2 == 0 ? m.f5506a : new long[i2];
    }

    public final void a(long j2) {
        int i2 = this.f5538b + 1;
        long[] jArr = this.f5537a;
        if (jArr.length < i2) {
            long[] jArrCopyOf = Arrays.copyOf(jArr, Math.max(i2, (jArr.length * 3) / 2));
            q7.k.d(jArrCopyOf, "copyOf(...)");
            this.f5537a = jArrCopyOf;
        }
        long[] jArr2 = this.f5537a;
        int i10 = this.f5538b;
        jArr2[i10] = j2;
        this.f5538b = i10 + 1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof v) {
            v vVar = (v) obj;
            int i2 = vVar.f5538b;
            int i10 = this.f5538b;
            if (i2 == i10) {
                long[] jArr = this.f5537a;
                long[] jArr2 = vVar.f5537a;
                v7.d dVarN = nb.i.N(0, i10);
                int i11 = dVarN.f10523f;
                int i12 = dVarN.f10524g;
                if (i11 > i12) {
                    return true;
                }
                while (jArr[i11] == jArr2[i11]) {
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
        long[] jArr = this.f5537a;
        int i2 = this.f5538b;
        int iHashCode = 0;
        for (int i10 = 0; i10 < i2; i10++) {
            iHashCode += Long.hashCode(jArr[i10]) * 31;
        }
        return iHashCode;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "[");
        long[] jArr = this.f5537a;
        int i2 = this.f5538b;
        int i10 = 0;
        while (true) {
            if (i10 >= i2) {
                sb2.append((CharSequence) "]");
                break;
            }
            long j2 = jArr[i10];
            if (i10 == -1) {
                sb2.append((CharSequence) "...");
                break;
            }
            if (i10 != 0) {
                sb2.append((CharSequence) ", ");
            }
            sb2.append(j2);
            i10++;
        }
        String string = sb2.toString();
        q7.k.d(string, "toString(...)");
        return string;
    }
}
