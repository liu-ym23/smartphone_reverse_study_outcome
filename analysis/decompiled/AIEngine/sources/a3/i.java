package a3;

import java.math.BigDecimal;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: l, reason: collision with root package name */
    public static final char[] f23l = new char[0];

    /* renamed from: a, reason: collision with root package name */
    public final a f24a;

    /* renamed from: b, reason: collision with root package name */
    public char[] f25b;

    /* renamed from: c, reason: collision with root package name */
    public int f26c;

    /* renamed from: d, reason: collision with root package name */
    public int f27d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList<char[]> f28e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f29f;

    /* renamed from: g, reason: collision with root package name */
    public int f30g;
    public char[] h;

    /* renamed from: i, reason: collision with root package name */
    public int f31i;

    /* renamed from: j, reason: collision with root package name */
    public String f32j;

    /* renamed from: k, reason: collision with root package name */
    public char[] f33k;

    public i(a aVar) {
        this.f24a = aVar;
    }

    public final void a(int i10, int i11, String str) {
        if (this.f26c >= 0) {
            q(i11);
        }
        this.f32j = null;
        this.f33k = null;
        char[] cArr = this.h;
        int length = cArr.length;
        int i12 = this.f31i;
        int i13 = length - i12;
        if (i13 >= i11) {
            str.getChars(i10, i10 + i11, cArr, i12);
            this.f31i += i11;
            return;
        }
        if (i13 > 0) {
            int i14 = i10 + i13;
            str.getChars(i10, i14, cArr, i12);
            i11 -= i13;
            i10 = i14;
        }
        while (true) {
            j();
            int iMin = Math.min(this.h.length, i11);
            int i15 = i10 + iMin;
            str.getChars(i10, i15, this.h, 0);
            this.f31i += iMin;
            i11 -= iMin;
            if (i11 <= 0) {
                return;
            } else {
                i10 = i15;
            }
        }
    }

    public final void b(char[] cArr, int i10, int i11) {
        if (this.f26c >= 0) {
            q(i11);
        }
        this.f32j = null;
        this.f33k = null;
        char[] cArr2 = this.h;
        int length = cArr2.length;
        int i12 = this.f31i;
        int i13 = length - i12;
        if (i13 >= i11) {
            System.arraycopy(cArr, i10, cArr2, i12, i11);
            this.f31i += i11;
            return;
        }
        if (i13 > 0) {
            System.arraycopy(cArr, i10, cArr2, i12, i13);
            i10 += i13;
            i11 -= i13;
        }
        do {
            j();
            int iMin = Math.min(this.h.length, i11);
            System.arraycopy(cArr, i10, this.h, 0, iMin);
            this.f31i += iMin;
            i10 += iMin;
            i11 -= iMin;
        } while (i11 > 0);
    }

    public final char[] c(int i10) {
        a aVar = this.f24a;
        return aVar != null ? aVar.b(2, i10) : new char[Math.max(i10, 500)];
    }

    public final void d() {
        this.f29f = false;
        this.f28e.clear();
        this.f30g = 0;
        this.f31i = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final char[] e() {
        /*
            r7 = this;
            char[] r0 = r7.f33k
            if (r0 != 0) goto L5b
            java.lang.String r0 = r7.f32j
            if (r0 == 0) goto Ld
            char[] r0 = r0.toCharArray()
            goto L59
        Ld:
            int r0 = r7.f26c
            char[] r1 = a3.i.f23l
            r2 = 1
            if (r0 < 0) goto L2b
            int r3 = r7.f27d
            if (r3 >= r2) goto L1a
        L18:
            r0 = r1
            goto L59
        L1a:
            if (r0 != 0) goto L23
            char[] r0 = r7.f25b
            char[] r0 = java.util.Arrays.copyOf(r0, r3)
            goto L59
        L23:
            char[] r1 = r7.f25b
            int r3 = r3 + r0
            char[] r0 = java.util.Arrays.copyOfRange(r1, r0, r3)
            goto L59
        L2b:
            int r0 = r7.p()
            if (r0 >= r2) goto L32
            goto L18
        L32:
            char[] r0 = new char[r0]
            java.util.ArrayList<char[]> r1 = r7.f28e
            r2 = 0
            if (r1 == 0) goto L51
            int r1 = r1.size()
            r3 = r2
            r4 = r3
        L3f:
            if (r3 >= r1) goto L52
            java.util.ArrayList<char[]> r5 = r7.f28e
            java.lang.Object r5 = r5.get(r3)
            char[] r5 = (char[]) r5
            int r6 = r5.length
            java.lang.System.arraycopy(r5, r2, r0, r4, r6)
            int r4 = r4 + r6
            int r3 = r3 + 1
            goto L3f
        L51:
            r4 = r2
        L52:
            char[] r1 = r7.h
            int r3 = r7.f31i
            java.lang.System.arraycopy(r1, r2, r0, r4, r3)
        L59:
            r7.f33k = r0
        L5b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.i.e():char[]");
    }

    public final BigDecimal f() {
        char[] cArr;
        char[] cArr2;
        char[] cArr3 = this.f33k;
        if (cArr3 != null) {
            return x2.d.a(cArr3, 0, cArr3.length);
        }
        int i10 = this.f26c;
        if (i10 >= 0 && (cArr2 = this.f25b) != null) {
            return x2.d.a(cArr2, i10, this.f27d);
        }
        if (this.f30g == 0 && (cArr = this.h) != null) {
            return x2.d.a(cArr, 0, this.f31i);
        }
        char[] cArrE = e();
        String str = x2.d.f13725a;
        return x2.d.a(cArrE, 0, cArrE.length);
    }

    public final int g(boolean z) {
        char[] cArr;
        int i10 = this.f26c;
        return (i10 < 0 || (cArr = this.f25b) == null) ? z ? -x2.d.d(this.h, 1, this.f31i - 1) : x2.d.d(this.h, 0, this.f31i) : z ? -x2.d.d(cArr, i10 + 1, this.f27d - 1) : x2.d.d(cArr, i10, this.f27d);
    }

    public final String h() {
        if (this.f32j == null) {
            char[] cArr = this.f33k;
            if (cArr != null) {
                this.f32j = new String(cArr);
            } else {
                int i10 = this.f26c;
                if (i10 >= 0) {
                    int i11 = this.f27d;
                    if (i11 < 1) {
                        this.f32j = "";
                        return "";
                    }
                    this.f32j = new String(this.f25b, i10, i11);
                } else {
                    int i12 = this.f30g;
                    int i13 = this.f31i;
                    if (i12 == 0) {
                        this.f32j = i13 != 0 ? new String(this.h, 0, i13) : "";
                    } else {
                        StringBuilder sb2 = new StringBuilder(i12 + i13);
                        ArrayList<char[]> arrayList = this.f28e;
                        if (arrayList != null) {
                            int size = arrayList.size();
                            for (int i14 = 0; i14 < size; i14++) {
                                char[] cArr2 = this.f28e.get(i14);
                                sb2.append(cArr2, 0, cArr2.length);
                            }
                        }
                        sb2.append(this.h, 0, this.f31i);
                        this.f32j = sb2.toString();
                    }
                }
            }
        }
        return this.f32j;
    }

    public final char[] i() {
        this.f26c = -1;
        this.f31i = 0;
        this.f27d = 0;
        this.f25b = null;
        this.f32j = null;
        this.f33k = null;
        if (this.f29f) {
            d();
        }
        char[] cArr = this.h;
        if (cArr != null) {
            return cArr;
        }
        char[] cArrC = c(0);
        this.h = cArrC;
        return cArrC;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0026 A[PHI: r1
      0x0026: PHI (r1v8 int) = (r1v6 int), (r1v7 int) binds: [B:6:0x0024, B:9:0x002a] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            r3 = this;
            java.util.ArrayList<char[]> r0 = r3.f28e
            if (r0 != 0) goto Lb
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r3.f28e = r0
        Lb:
            char[] r0 = r3.h
            r1 = 1
            r3.f29f = r1
            java.util.ArrayList<char[]> r1 = r3.f28e
            r1.add(r0)
            int r1 = r3.f30g
            int r2 = r0.length
            int r1 = r1 + r2
            r3.f30g = r1
            r1 = 0
            r3.f31i = r1
            int r0 = r0.length
            int r1 = r0 >> 1
            int r0 = r0 + r1
            r1 = 500(0x1f4, float:7.0E-43)
            if (r0 >= r1) goto L28
        L26:
            r0 = r1
            goto L2d
        L28:
            r1 = 65536(0x10000, float:9.1835E-41)
            if (r0 <= r1) goto L2d
            goto L26
        L2d:
            char[] r0 = new char[r0]
            r3.h = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.i.j():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0027 A[PHI: r1
      0x0027: PHI (r1v7 int) = (r1v5 int), (r1v6 int) binds: [B:6:0x0025, B:9:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final char[] k() {
        /*
            r2 = this;
            java.util.ArrayList<char[]> r0 = r2.f28e
            if (r0 != 0) goto Lb
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r2.f28e = r0
        Lb:
            r0 = 1
            r2.f29f = r0
            java.util.ArrayList<char[]> r0 = r2.f28e
            char[] r1 = r2.h
            r0.add(r1)
            char[] r0 = r2.h
            int r0 = r0.length
            int r1 = r2.f30g
            int r1 = r1 + r0
            r2.f30g = r1
            r1 = 0
            r2.f31i = r1
            int r1 = r0 >> 1
            int r0 = r0 + r1
            r1 = 500(0x1f4, float:7.0E-43)
            if (r0 >= r1) goto L29
        L27:
            r0 = r1
            goto L2e
        L29:
            r1 = 65536(0x10000, float:9.1835E-41)
            if (r0 <= r1) goto L2e
            goto L27
        L2e:
            char[] r0 = new char[r0]
            r2.h = r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a3.i.k():char[]");
    }

    public final char[] l() {
        if (this.f26c >= 0) {
            q(1);
        } else {
            char[] cArr = this.h;
            if (cArr == null) {
                this.h = c(0);
            } else if (this.f31i >= cArr.length) {
                j();
            }
        }
        return this.h;
    }

    public final char[] m() {
        if (this.f26c >= 0) {
            return this.f25b;
        }
        char[] cArr = this.f33k;
        if (cArr != null) {
            return cArr;
        }
        String str = this.f32j;
        if (str != null) {
            char[] charArray = str.toCharArray();
            this.f33k = charArray;
            return charArray;
        }
        if (this.f29f) {
            return e();
        }
        char[] cArr2 = this.h;
        return cArr2 == null ? f23l : cArr2;
    }

    public final void n() {
        char[] cArr;
        this.f26c = -1;
        this.f31i = 0;
        this.f27d = 0;
        this.f25b = null;
        this.f33k = null;
        if (this.f29f) {
            d();
        }
        a aVar = this.f24a;
        if (aVar == null || (cArr = this.h) == null) {
            return;
        }
        this.h = null;
        aVar.f11b.set(2, cArr);
    }

    public final void o(char[] cArr, int i10, int i11) {
        this.f32j = null;
        this.f33k = null;
        this.f25b = cArr;
        this.f26c = i10;
        this.f27d = i11;
        if (this.f29f) {
            d();
        }
    }

    public final int p() {
        if (this.f26c >= 0) {
            return this.f27d;
        }
        char[] cArr = this.f33k;
        if (cArr != null) {
            return cArr.length;
        }
        String str = this.f32j;
        return str != null ? str.length() : this.f30g + this.f31i;
    }

    public final void q(int i10) {
        int i11 = this.f27d;
        this.f27d = 0;
        char[] cArr = this.f25b;
        this.f25b = null;
        int i12 = this.f26c;
        this.f26c = -1;
        int i13 = i10 + i11;
        char[] cArr2 = this.h;
        if (cArr2 == null || i13 > cArr2.length) {
            this.h = c(i13);
        }
        if (i11 > 0) {
            System.arraycopy(cArr, i12, this.h, 0, i11);
        }
        this.f30g = 0;
        this.f31i = i11;
    }

    public final String toString() {
        return h();
    }

    public i(char[] cArr) {
        this.f24a = null;
        this.h = cArr;
        this.f31i = cArr.length;
        this.f26c = -1;
    }
}
