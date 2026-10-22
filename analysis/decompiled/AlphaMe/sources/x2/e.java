package x2;

import com.baidu.platform.comapi.bmsdk.BmLocated;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class e implements Iterable, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final b[] f15930a;

    /* renamed from: b, reason: collision with root package name */
    public final int f15931b;

    /* renamed from: c, reason: collision with root package name */
    public long f15932c = -1;

    /* renamed from: d, reason: collision with root package name */
    public c f15933d;

    public e(b... bVarArr) {
        if (bVarArr.length == 0) {
            throw new IllegalArgumentException("attributes must be >= 1");
        }
        b[] bVarArr2 = new b[bVarArr.length];
        for (int i4 = 0; i4 < bVarArr.length; i4++) {
            bVarArr2[i4] = bVarArr[i4];
        }
        this.f15930a = bVarArr2;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            b[] bVarArr3 = this.f15930a;
            if (i5 >= bVarArr3.length) {
                this.f15931b = i6;
                return;
            }
            b bVar = bVarArr3[i5];
            bVar.f15920e = i6;
            int i7 = bVar.f15917b;
            int i8 = bVar.f15919d;
            if (i8 != 5126 && i8 != 5132) {
                switch (i8) {
                    case BmLocated.HALF_LEFT_TOP /* 5120 */:
                    case 5121:
                        break;
                    case 5122:
                    case 5123:
                        i7 *= 2;
                        break;
                    default:
                        i7 = 0;
                        break;
                }
            } else {
                i7 *= 4;
            }
            i6 += i7;
            i5++;
        }
    }

    public final long a() {
        if (this.f15932c == -1) {
            long j4 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= this.f15930a.length) {
                    break;
                }
                j4 |= r3[i4].f15916a;
                i4++;
            }
            this.f15932c = j4;
        }
        return this.f15932c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        if (r6 != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
    
        if (r1 < r3) goto L8;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int compareTo(java.lang.Object r8) {
        /*
            r7 = this;
            x2.e r8 = (x2.e) r8
            x2.b[] r0 = r7.f15930a
            int r1 = r0.length
            x2.b[] r2 = r8.f15930a
            int r3 = r2.length
            if (r1 == r3) goto Le
            int r7 = r0.length
            int r8 = r2.length
            int r7 = r7 - r8
            goto L59
        Le:
            long r1 = r7.a()
            long r3 = r8.a()
            int r7 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r1 = -1
            r2 = 1
            if (r7 == 0) goto L22
            if (r7 >= 0) goto L20
        L1e:
            r7 = r1
            goto L59
        L20:
            r7 = r2
            goto L59
        L22:
            int r7 = r0.length
            int r7 = r7 - r2
        L24:
            if (r7 < 0) goto L58
            r3 = r0[r7]
            x2.b[] r4 = r8.f15930a
            r4 = r4[r7]
            int r5 = r3.f15916a
            int r6 = r4.f15916a
            if (r5 == r6) goto L35
        L32:
            int r7 = r5 - r6
            goto L59
        L35:
            int r5 = r3.f15922g
            int r6 = r4.f15922g
            if (r5 == r6) goto L3c
            goto L32
        L3c:
            int r5 = r3.f15917b
            int r6 = r4.f15917b
            if (r5 == r6) goto L43
            goto L32
        L43:
            boolean r5 = r4.f15918c
            boolean r6 = r3.f15918c
            if (r6 == r5) goto L4c
            if (r6 == 0) goto L1e
            goto L20
        L4c:
            int r3 = r3.f15919d
            int r4 = r4.f15919d
            if (r3 == r4) goto L55
            int r7 = r3 - r4
            goto L59
        L55:
            int r7 = r7 + (-1)
            goto L24
        L58:
            r7 = 0
        L59:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.e.compareTo(java.lang.Object):int");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        b[] bVarArr = this.f15930a;
        if (bVarArr.length != eVar.f15930a.length) {
            return false;
        }
        for (int i4 = 0; i4 < bVarArr.length; i4++) {
            if (!bVarArr[i4].a(eVar.f15930a[i4])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        b[] bVarArr = this.f15930a;
        long length = bVarArr.length * 61;
        for (b bVar : bVarArr) {
            length = (length * 61) + bVar.hashCode();
        }
        return (int) (length ^ (length >> 32));
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        if (this.f15933d == null) {
            this.f15933d = new c(this.f15930a);
        }
        return this.f15933d.iterator();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        int i4 = 0;
        while (true) {
            b[] bVarArr = this.f15930a;
            if (i4 >= bVarArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append("(");
            sb.append(bVarArr[i4].f15921f);
            sb.append(", ");
            sb.append(bVarArr[i4].f15916a);
            sb.append(", ");
            sb.append(bVarArr[i4].f15917b);
            sb.append(", ");
            sb.append(bVarArr[i4].f15920e);
            sb.append(")\n");
            i4++;
        }
    }
}
