package com.google.re2j;

import com.google.re2j.Regexp;
import com.stepos.core.common.util.TraceIdKeys;
import java.util.ArrayList;
import java.util.HashMap;
import l5.i;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class Parser {

    /* renamed from: g, reason: collision with root package name */
    public static final int[][] f5481g = {new int[]{0, 1114111, 1}};

    /* renamed from: a, reason: collision with root package name */
    public final String f5482a;

    /* renamed from: b, reason: collision with root package name */
    public int f5483b;

    /* renamed from: d, reason: collision with root package name */
    public Regexp f5485d;

    /* renamed from: c, reason: collision with root package name */
    public final Stack f5484c = new Stack(0);

    /* renamed from: e, reason: collision with root package name */
    public int f5486e = 0;

    /* renamed from: f, reason: collision with root package name */
    public final HashMap f5487f = new HashMap();

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class Stack extends ArrayList<Regexp> {
        private Stack() {
        }

        @Override // java.util.ArrayList, java.util.AbstractList
        public final void removeRange(int i10, int i11) {
            super.removeRange(i10, i11);
        }

        public /* synthetic */ Stack(int i10) {
            this();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a<F, S> {

        /* renamed from: a, reason: collision with root package name */
        public final F f5488a;

        /* renamed from: b, reason: collision with root package name */
        public final S f5489b;

        public a(F f8, S s8) {
            this.f5488a = f8;
            this.f5489b = s8;
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f5490a;

        /* renamed from: b, reason: collision with root package name */
        public int f5491b = 0;

        public b(String str) {
            this.f5490a = str;
        }

        public final String a(int i10) {
            return this.f5490a.substring(i10, this.f5491b);
        }

        public final boolean b(char c9) {
            return this.f5490a.charAt(this.f5491b) == c9;
        }

        public final boolean c(String str) {
            return g().startsWith(str);
        }

        public final boolean d() {
            return this.f5491b < this.f5490a.length();
        }

        public final int e() {
            return this.f5490a.codePointAt(this.f5491b);
        }

        public final int f() {
            int iCodePointAt = this.f5490a.codePointAt(this.f5491b);
            this.f5491b = Character.charCount(iCodePointAt) + this.f5491b;
            return iCodePointAt;
        }

        public final String g() {
            return this.f5490a.substring(this.f5491b);
        }

        public final void h(int i10) {
            this.f5491b += i10;
        }

        public final String toString() {
            return g();
        }
    }

    public Parser(String str, int i10) {
        this.f5482a = str;
        this.f5483b = i10;
    }

    public static void b(Regexp regexp) {
        if (regexp.f5495a == Regexp.Op.f5506d) {
            int[] iArr = regexp.f5498d;
            int length = iArr.length;
            if (length >= 4) {
                l5.a.h(0, length - 2, iArr);
                int i10 = 2;
                for (int i11 = 2; i11 < length; i11 += 2) {
                    int i12 = iArr[i11];
                    int i13 = iArr[i11 + 1];
                    int i14 = i10 - 1;
                    int i15 = iArr[i14];
                    if (i12 > i15 + 1) {
                        iArr[i10] = i12;
                        iArr[i10 + 1] = i13;
                        i10 += 2;
                    } else if (i13 > i15) {
                        iArr[i14] = i13;
                    }
                }
                length = i10;
            }
            if (length != iArr.length) {
                int[] iArr2 = new int[length];
                System.arraycopy(iArr, 0, iArr2, 0, length);
                iArr = iArr2;
            }
            regexp.f5498d = iArr;
            if (iArr.length == 2 && iArr[0] == 0 && iArr[1] == 1114111) {
                regexp.f5498d = null;
                regexp.f5495a = Regexp.Op.h;
            } else if (iArr.length == 4 && iArr[0] == 0 && iArr[1] == 9 && iArr[2] == 11 && iArr[3] == 1114111) {
                regexp.f5498d = null;
                regexp.f5495a = Regexp.Op.f5507e;
            }
        }
    }

    public static boolean e(Regexp regexp) {
        Regexp.Op op = regexp.f5495a;
        return (op == Regexp.Op.f5505c && regexp.f5498d.length == 1) || op == Regexp.Op.f5506d || op == Regexp.Op.f5507e || op == Regexp.Op.h;
    }

    public static void h(Regexp regexp, Regexp regexp2) {
        int iOrdinal = regexp.f5495a.ordinal();
        int i10 = 0;
        if (iOrdinal == 2) {
            int i11 = regexp2.f5498d[0];
            int i12 = regexp.f5498d[0];
            if (i11 == i12 && regexp2.f5496b == regexp.f5496b) {
                return;
            }
            regexp.f5495a = Regexp.Op.f5506d;
            l5.a aVar = new l5.a(0, (byte) 0);
            if ((regexp.f5496b & 1) != 0) {
                aVar.b(i12, i12);
            } else {
                aVar.d(i12, i12);
            }
            int i13 = regexp2.f5498d[0];
            if ((regexp2.f5496b & 1) != 0) {
                aVar.b(i13, i13);
            } else {
                aVar.d(i13, i13);
            }
            regexp.f5498d = aVar.j();
            return;
        }
        if (iOrdinal == 3) {
            if (regexp2.f5495a == Regexp.Op.f5505c) {
                l5.a aVar2 = new l5.a(regexp.f5498d);
                int i14 = regexp2.f5498d[0];
                if ((regexp2.f5496b & 1) != 0) {
                    aVar2.b(i14, i14);
                } else {
                    aVar2.d(i14, i14);
                }
                regexp.f5498d = aVar2.j();
                return;
            }
            l5.a aVar3 = new l5.a(regexp.f5498d);
            int[] iArr = regexp2.f5498d;
            while (i10 < iArr.length) {
                aVar3.d(iArr[i10], iArr[i10 + 1]);
                i10 += 2;
            }
            regexp.f5498d = aVar3.j();
            return;
        }
        if (iOrdinal != 4) {
            return;
        }
        int iOrdinal2 = regexp2.f5495a.ordinal();
        if (iOrdinal2 == 2) {
            int[] iArr2 = regexp2.f5498d;
            if (iArr2.length != 1 || iArr2[0] != 10) {
                return;
            }
        } else if (iOrdinal2 == 3) {
            while (true) {
                int[] iArr3 = regexp2.f5498d;
                if (i10 >= iArr3.length) {
                    return;
                }
                if (iArr3[i10] <= 10 && 10 <= iArr3[i10 + 1]) {
                    break;
                } else {
                    i10 += 2;
                }
            }
        } else if (iOrdinal2 == 4 || iOrdinal2 != 5) {
            return;
        }
        regexp.f5495a = Regexp.Op.h;
    }

    public static int k(b bVar, int i10) {
        if (bVar.d()) {
            return bVar.b('\\') ? l(bVar) : bVar.f();
        }
        throw new PatternSyntaxException("missing closing ]", bVar.a(i10));
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
    
        if (r6.e() <= 55) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int l(com.google.re2j.Parser.b r6) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.re2j.Parser.l(com.google.re2j.Parser$b):int");
    }

    public static int m(b bVar) {
        int iE;
        int i10 = bVar.f5491b;
        while (bVar.d() && (iE = bVar.e()) >= 48 && iE <= 57) {
            bVar.h(1);
        }
        String strA = bVar.a(i10);
        if (strA.isEmpty()) {
            return -1;
        }
        if (strA.length() > 1 && strA.charAt(0) == '0') {
            return -1;
        }
        if (strA.length() > 8) {
            return -2;
        }
        return Integer.valueOf(strA, 10).intValue();
    }

    public static Regexp[] v(Regexp[] regexpArr, int i10, int i11) {
        Regexp[] regexpArr2 = new Regexp[i11 - i10];
        for (int i12 = i10; i12 < i11; i12++) {
            regexpArr2[i12 - i10] = regexpArr[i12];
        }
        return regexpArr2;
    }

    public final void a() {
        Regexp[] regexpArrQ = q();
        if (regexpArrQ.length > 0) {
            b(regexpArrQ[regexpArrQ.length - 1]);
        }
        if (regexpArrQ.length == 0) {
            r(i(Regexp.Op.f5503a));
        } else {
            r(c(regexpArrQ, Regexp.Op.f5519v));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:152:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.re2j.Regexp c(com.google.re2j.Regexp[] r21, com.google.re2j.Regexp.Op r22) {
        /*
            Method dump skipped, instructions count: 673
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.re2j.Parser.c(com.google.re2j.Regexp[], com.google.re2j.Regexp$Op):com.google.re2j.Regexp");
    }

    public final void d() {
        g(-1, 0);
        Regexp[] regexpArrQ = q();
        if (regexpArrQ.length == 0) {
            r(i(Regexp.Op.f5504b));
        } else {
            r(c(regexpArrQ, Regexp.Op.f5518u));
        }
    }

    public final void f(int i10) {
        int i11 = this.f5483b;
        Regexp regexpI = i(Regexp.Op.f5505c);
        regexpI.f5496b = i11;
        if ((i11 & 1) != 0 && i10 >= 65 && i10 <= 66639) {
            int i12 = i10;
            for (int iG = jd.b.G(i10); iG != i10; iG = jd.b.G(iG)) {
                if (i12 > iG) {
                    i12 = iG;
                }
            }
            i10 = i12;
        }
        regexpI.f5498d = new int[]{i10};
        r(regexpI);
    }

    public final boolean g(int i10, int i11) {
        Stack stack = this.f5484c;
        int size = stack.size();
        if (size < 2) {
            return false;
        }
        Regexp regexp = stack.get(size - 1);
        Regexp regexp2 = stack.get(size - 2);
        Regexp.Op op = regexp.f5495a;
        Regexp.Op op2 = Regexp.Op.f5505c;
        if (op == op2 && regexp2.f5495a == op2 && (regexp.f5496b & 1) == (regexp2.f5496b & 1)) {
            int[] iArr = regexp2.f5498d;
            int[] iArr2 = regexp.f5498d;
            int[] iArr3 = new int[iArr.length + iArr2.length];
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            System.arraycopy(iArr2, 0, iArr3, iArr.length, iArr2.length);
            regexp2.f5498d = iArr3;
            if (i10 >= 0) {
                regexp.f5498d = new int[]{i10};
                regexp.f5496b = i11;
                return true;
            }
            p();
            u(regexp);
        }
        return false;
    }

    public final Regexp i(Regexp.Op op) {
        Regexp[] regexpArr;
        Regexp regexp = this.f5485d;
        if (regexp == null || (regexpArr = regexp.f5497c) == null || regexpArr.length <= 0) {
            return new Regexp(op);
        }
        this.f5485d = regexpArr[0];
        regexp.f5496b = 0;
        regexp.f5497c = Regexp.f5494j;
        regexp.f5498d = null;
        regexp.f5500f = 0;
        regexp.f5499e = 0;
        regexp.f5501g = 0;
        regexp.h = null;
        regexp.f5495a = op;
        return regexp;
    }

    public final Regexp j(Regexp.Op op) {
        Regexp regexpI = i(op);
        regexpI.f5496b = this.f5483b;
        return r(regexpI);
    }

    public final boolean n(b bVar, l5.a aVar) {
        int i10 = bVar.f5491b;
        if ((this.f5483b & 64) != 0 && bVar.d() && bVar.f() == 92 && bVar.d()) {
            bVar.f();
            l5.b bVar2 = l5.b.f10235c.get(bVar.a(i10));
            if (bVar2 != null) {
                aVar.c(bVar2, (this.f5483b & 1) != 0);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean o(b bVar, l5.a aVar) {
        String strSubstring;
        a aVar2;
        a aVar3;
        int i10 = bVar.f5491b;
        if ((this.f5483b & TraceIdKeys.MAX_LENGTH) == 0 || !(bVar.c("\\p") || bVar.c("\\P"))) {
            return false;
        }
        bVar.h(1);
        int i11 = bVar.f() == 80 ? -1 : 1;
        if (!bVar.d()) {
            bVar.f5491b = i10;
            throw new PatternSyntaxException("invalid character class range", bVar.g());
        }
        int iF = bVar.f();
        if (iF != 123) {
            char c9 = (char) iF;
            strSubstring = iF == c9 ? String.valueOf(c9) : new String(Character.toChars(c9));
        } else {
            String strG = bVar.g();
            int iIndexOf = strG.indexOf(125);
            if (iIndexOf < 0) {
                bVar.f5491b = i10;
                throw new PatternSyntaxException("invalid character class range", bVar.g());
            }
            strSubstring = strG.substring(0, iIndexOf);
            bVar.f5491b = strSubstring.length() + bVar.f5491b;
            bVar.h(1);
        }
        if (!strSubstring.isEmpty() && strSubstring.charAt(0) == '^') {
            i11 = -i11;
            strSubstring = strSubstring.substring(1);
        }
        if (strSubstring.equals("Any")) {
            int[][] iArr = f5481g;
            aVar2 = new a(iArr, iArr);
        } else {
            int[][] iArr2 = i.D1.get(strSubstring);
            if (iArr2 != null) {
                aVar3 = new a(iArr2, i.N1.get(strSubstring));
            } else {
                int[][] iArr3 = i.E1.get(strSubstring);
                if (iArr3 != null) {
                    aVar3 = new a(iArr3, i.I1.get(strSubstring));
                } else {
                    aVar2 = null;
                }
            }
            aVar2 = aVar3;
        }
        if (aVar2 == null) {
            throw new PatternSyntaxException("invalid character class range", bVar.a(i10));
        }
        int[][] iArr4 = (int[][]) aVar2.f5488a;
        int[][] iArr5 = (int[][]) aVar2.f5489b;
        if ((this.f5483b & 1) != 0 && iArr5 != null) {
            l5.a aVar4 = new l5.a(0, (byte) 0);
            aVar4.e(iArr4);
            aVar4.e(iArr5);
            aVar4.f();
            aVar.a(aVar4.j(), i11);
            return true;
        }
        if (i11 >= 0) {
            aVar.e(iArr4);
            return true;
        }
        int i12 = 0;
        for (int[] iArr6 : iArr4) {
            int i13 = iArr6[0];
            int i14 = iArr6[1];
            int i15 = iArr6[2];
            if (i15 == 1) {
                int i16 = i13 - 1;
                if (i12 <= i16) {
                    aVar.d(i12, i16);
                }
                i12 = i14 + 1;
            } else {
                while (i13 <= i14) {
                    int i17 = i13 - 1;
                    if (i12 <= i17) {
                        aVar.d(i12, i17);
                    }
                    i12 = i13 + 1;
                    i13 += i15;
                }
            }
        }
        if (i12 <= 1114111) {
            aVar.d(i12, 1114111);
        }
        return true;
    }

    public final Regexp p() {
        return this.f5484c.remove(r1.size() - 1);
    }

    public final Regexp[] q() {
        Stack stack = this.f5484c;
        int size = stack.size();
        int i10 = size;
        while (i10 > 0 && stack.get(i10 - 1).f5495a.ordinal() < 19) {
            i10--;
        }
        Regexp[] regexpArr = (Regexp[]) stack.subList(i10, size).toArray(new Regexp[size - i10]);
        stack.removeRange(i10, size);
        return regexpArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.re2j.Regexp r(com.google.re2j.Regexp r11) {
        /*
            r10 = this;
            com.google.re2j.Regexp$Op r0 = r11.f5495a
            com.google.re2j.Regexp$Op r1 = com.google.re2j.Regexp.Op.f5505c
            r2 = 0
            r3 = 2
            r4 = 1
            r5 = 0
            com.google.re2j.Regexp$Op r6 = com.google.re2j.Regexp.Op.f5506d
            if (r0 != r6) goto L36
            int[] r7 = r11.f5498d
            int r8 = r7.length
            if (r8 != r3) goto L36
            r8 = r7[r5]
            r7 = r7[r4]
            if (r8 != r7) goto L36
            int r0 = r10.f5483b
            r0 = r0 & (-2)
            boolean r0 = r10.g(r8, r0)
            if (r0 == 0) goto L22
            return r2
        L22:
            r11.f5495a = r1
            int[] r0 = r11.f5498d
            r0 = r0[r5]
            int[] r0 = new int[]{r0}
            r11.f5498d = r0
            int r0 = r10.f5483b
            r0 = r0 & (-2)
            r11.f5496b = r0
            goto La8
        L36:
            if (r0 != r6) goto L5f
            int[] r0 = r11.f5498d
            int r7 = r0.length
            r8 = 4
            if (r7 != r8) goto L5f
            r7 = r0[r5]
            r8 = r0[r4]
            if (r7 != r8) goto L5f
            r8 = r0[r3]
            r9 = 3
            r0 = r0[r9]
            if (r8 != r0) goto L5f
            int r0 = jd.b.G(r7)
            int[] r7 = r11.f5498d
            r7 = r7[r3]
            if (r0 != r7) goto L5f
            int r0 = jd.b.G(r7)
            int[] r7 = r11.f5498d
            r7 = r7[r5]
            if (r0 == r7) goto L84
        L5f:
            com.google.re2j.Regexp$Op r0 = r11.f5495a
            if (r0 != r6) goto La4
            int[] r0 = r11.f5498d
            int r6 = r0.length
            if (r6 != r3) goto La4
            r3 = r0[r5]
            int r6 = r3 + 1
            r0 = r0[r4]
            if (r6 != r0) goto La4
            int r0 = jd.b.G(r3)
            int[] r3 = r11.f5498d
            r3 = r3[r4]
            if (r0 != r3) goto La4
            int r0 = jd.b.G(r3)
            int[] r3 = r11.f5498d
            r3 = r3[r5]
            if (r0 != r3) goto La4
        L84:
            int[] r0 = r11.f5498d
            r0 = r0[r5]
            int r3 = r10.f5483b
            r3 = r3 | r4
            boolean r0 = r10.g(r0, r3)
            if (r0 == 0) goto L92
            return r2
        L92:
            r11.f5495a = r1
            int[] r0 = r11.f5498d
            r0 = r0[r5]
            int[] r0 = new int[]{r0}
            r11.f5498d = r0
            int r0 = r10.f5483b
            r0 = r0 | r4
            r11.f5496b = r0
            goto La8
        La4:
            r0 = -1
            r10.g(r0, r5)
        La8:
            com.google.re2j.Parser$Stack r10 = r10.f5484c
            r10.add(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.re2j.Parser.r(com.google.re2j.Regexp):com.google.re2j.Regexp");
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.re2j.Regexp s(com.google.re2j.Regexp r8, int r9) {
        /*
            r7 = this;
            com.google.re2j.Regexp$Op r0 = r8.f5495a
            com.google.re2j.Regexp$Op r1 = com.google.re2j.Regexp.Op.f5518u
            com.google.re2j.Regexp$Op r2 = com.google.re2j.Regexp.Op.f5504b
            if (r0 != r1) goto L3e
            com.google.re2j.Regexp[] r1 = r8.f5497c
            int r3 = r1.length
            if (r3 <= 0) goto L3e
            r0 = 0
            r1 = r1[r0]
            com.google.re2j.Regexp r9 = r7.s(r1, r9)
            com.google.re2j.Regexp[] r1 = r8.f5497c
            r1[r0] = r9
            com.google.re2j.Regexp$Op r0 = r9.f5495a
            if (r0 != r2) goto L5b
            r7.u(r9)
            com.google.re2j.Regexp[] r9 = r8.f5497c
            int r0 = r9.length
            if (r0 == 0) goto L38
            r1 = 1
            if (r0 == r1) goto L38
            r2 = 2
            if (r0 == r2) goto L32
            int r7 = r9.length
            com.google.re2j.Regexp[] r7 = v(r9, r1, r7)
            r8.f5497c = r7
            return r8
        L32:
            r9 = r9[r1]
            r7.u(r8)
            return r9
        L38:
            r8.f5495a = r2
            r7 = 0
            r8.f5497c = r7
            return r8
        L3e:
            com.google.re2j.Regexp$Op r7 = com.google.re2j.Regexp.Op.f5505c
            if (r0 != r7) goto L5b
            int[] r7 = r8.f5498d
            int r0 = r7.length
            int r1 = r0 - r9
            int[] r3 = new int[r1]
            r4 = r9
        L4a:
            if (r4 >= r0) goto L55
            int r5 = r4 - r9
            r6 = r7[r4]
            r3[r5] = r6
            int r4 = r4 + 1
            goto L4a
        L55:
            r8.f5498d = r3
            if (r1 != 0) goto L5b
            r8.f5495a = r2
        L5b:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.re2j.Parser.s(com.google.re2j.Regexp, int):com.google.re2j.Regexp");
    }

    public final void t(Regexp.Op op, int i10, int i11, int i12, b bVar, int i13) {
        int i14 = this.f5483b;
        if ((i14 & 64) != 0) {
            if (bVar.d() && bVar.b('?')) {
                bVar.h(1);
                i14 ^= 32;
            }
            if (i13 != -1) {
                throw new PatternSyntaxException("invalid nested repetition operator", bVar.a(i13));
            }
        }
        Stack stack = this.f5484c;
        int size = stack.size();
        if (size == 0) {
            throw new PatternSyntaxException("missing argument to repetition operator", bVar.a(i12));
        }
        int i15 = size - 1;
        Regexp regexp = stack.get(i15);
        if (regexp.f5495a.ordinal() >= 19) {
            throw new PatternSyntaxException("missing argument to repetition operator", bVar.a(i12));
        }
        Regexp regexpI = i(op);
        regexpI.f5499e = i10;
        regexpI.f5500f = i11;
        regexpI.f5496b = i14;
        regexpI.f5497c = new Regexp[]{regexp};
        stack.set(i15, regexpI);
    }

    public final void u(Regexp regexp) {
        Regexp[] regexpArr = regexp.f5497c;
        if (regexpArr != null && regexpArr.length > 0) {
            regexpArr[0] = this.f5485d;
        }
        this.f5485d = regexp;
    }

    public final boolean w() {
        Stack stack = this.f5484c;
        int size = stack.size();
        Regexp.Op op = Regexp.Op.f5521x;
        if (size >= 3 && stack.get(size - 2).f5495a == op) {
            int i10 = size - 1;
            if (e(stack.get(i10))) {
                int i11 = size - 3;
                if (e(stack.get(i11))) {
                    Regexp regexp = stack.get(i10);
                    Regexp regexp2 = stack.get(i11);
                    if (regexp.f5495a.ordinal() > regexp2.f5495a.ordinal()) {
                        stack.set(i11, regexp);
                    } else {
                        regexp2 = regexp;
                        regexp = regexp2;
                    }
                    h(regexp, regexp2);
                    u(regexp2);
                    p();
                    return true;
                }
            }
        }
        if (size < 2) {
            return false;
        }
        int i12 = size - 1;
        Regexp regexp3 = stack.get(i12);
        int i13 = size - 2;
        Regexp regexp4 = stack.get(i13);
        if (regexp4.f5495a != op) {
            return false;
        }
        if (size >= 3) {
            b(stack.get(size - 3));
        }
        stack.set(i13, regexp3);
        stack.set(i12, regexp4);
        return true;
    }
}
