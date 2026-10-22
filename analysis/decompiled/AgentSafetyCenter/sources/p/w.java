package p;

import java.util.Arrays;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public long[] f9637a;

    /* renamed from: b, reason: collision with root package name */
    public int f9638b;

    public w(int i) {
        this.f9637a = i == 0 ? m.f9591a : new long[i];
    }

    public final void a(long j10) {
        int i = this.f9638b + 1;
        long[] jArr = this.f9637a;
        if (jArr.length < i) {
            this.f9637a = Arrays.copyOf(jArr, Math.max(i, (jArr.length * 3) / 2));
        }
        long[] jArr2 = this.f9637a;
        int i3 = this.f9638b;
        jArr2[i3] = j10;
        this.f9638b = i3 + 1;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof w) {
            w wVar = (w) obj;
            int i = wVar.f9638b;
            int i3 = this.f9638b;
            if (i == i3) {
                long[] jArr = this.f9637a;
                long[] jArr2 = wVar.f9637a;
                ec.g gVarO = p5.f.O(0, i3);
                int i10 = gVarO.f3758c;
                int i11 = gVarO.f3759f;
                if (i10 > i11) {
                    return true;
                }
                while (jArr[i10] == jArr2[i10]) {
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
        long[] jArr = this.f9637a;
        int i = this.f9638b;
        int iHashCode = 0;
        for (int i3 = 0; i3 < i; i3++) {
            iHashCode += Long.hashCode(jArr[i3]) * 31;
        }
        return iHashCode;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append((CharSequence) "[");
        long[] jArr = this.f9637a;
        int i = this.f9638b;
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                sb2.append((CharSequence) "]");
                break;
            }
            long j10 = jArr[i3];
            if (i3 == -1) {
                sb2.append((CharSequence) "...");
                break;
            }
            if (i3 != 0) {
                sb2.append((CharSequence) ", ");
            }
            sb2.append(j10);
            i3++;
        }
        return sb2.toString();
    }
}
