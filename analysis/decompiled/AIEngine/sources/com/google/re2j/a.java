package com.google.re2j;

import java.util.Arrays;
import l5.c;
import l5.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f5523b = {0, 9, 11, 1114111};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f5524c = {0, 1114111};

    /* renamed from: a, reason: collision with root package name */
    public final g f5525a;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: com.google.re2j.a$a, reason: collision with other inner class name */
    public static class C0037a {

        /* renamed from: a, reason: collision with root package name */
        public final int f5526a;

        /* renamed from: b, reason: collision with root package name */
        public int f5527b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f5528c;

        public C0037a(int i10, int i11, boolean z) {
            this.f5526a = i10;
            this.f5527b = i11;
            this.f5528c = z;
        }
    }

    public a() {
        g gVar = new g();
        gVar.f10261a = new c[10];
        gVar.f10262b = 0;
        gVar.f10264d = 2;
        this.f5525a = gVar;
        f(5);
    }

    public final C0037a a(int i10) {
        C0037a c0037aF = f(3);
        int i11 = c0037aF.f5526a;
        c0037aF.f5527b = i11 << 1;
        g gVar = this.f5525a;
        gVar.f10261a[i11].f10241c = i10;
        int i12 = i10 + 1;
        if (gVar.f10264d < i12) {
            gVar.f10264d = i12;
        }
        return c0037aF;
    }

    public final C0037a b(C0037a c0037a, C0037a c0037a2) {
        int i10;
        int i11 = c0037a.f5526a;
        boolean z = false;
        if (i11 == 0 || (i10 = c0037a2.f5526a) == 0) {
            return new C0037a(0, 0, false);
        }
        this.f5525a.b(c0037a.f5527b, i10);
        int i12 = c0037a2.f5527b;
        if (c0037a.f5528c && c0037a2.f5528c) {
            z = true;
        }
        return new C0037a(i11, i12, z);
    }

    public final C0037a c(Regexp regexp) {
        int i10;
        int iOrdinal = regexp.f5495a.ordinal();
        g gVar = this.f5525a;
        C0037a c0037aB = null;
        switch (iOrdinal) {
            case 0:
                return new C0037a(0, 0, false);
            case 1:
                return g();
            case 2:
                int[] iArr = regexp.f5498d;
                if (iArr.length == 0) {
                    return g();
                }
                for (int i11 : iArr) {
                    C0037a c0037aH = h(new int[]{i11}, regexp.f5496b);
                    c0037aB = c0037aB == null ? c0037aH : b(c0037aB, c0037aH);
                }
                return c0037aB;
            case 3:
                return h(regexp.f5498d, regexp.f5496b);
            case 4:
                return h(f5523b, 0);
            case 5:
                return h(f5524c, 0);
            case 6:
                return d(1);
            case 7:
                return d(2);
            case 8:
                return d(4);
            case 9:
                return d(8);
            case 10:
                return d(16);
            case 11:
                return d(32);
            case 12:
                return b(b(a(regexp.f5501g << 1), c(regexp.f5497c[0])), a((regexp.f5501g << 1) | 1));
            case 13:
                C0037a c0037aC = c(regexp.f5497c[0]);
                boolean z = (regexp.f5496b & 32) != 0;
                if (!c0037aC.f5528c) {
                    return e(c0037aC, z);
                }
                int i12 = c0037aC.f5526a;
                int i13 = e(c0037aC, z).f5527b;
                C0037a c0037aF = f(1);
                int i14 = c0037aF.f5526a;
                c cVar = gVar.f10261a[i14];
                if (z) {
                    cVar.f10241c = i12;
                    c0037aF.f5527b = i14 << 1;
                } else {
                    cVar.f10240b = i12;
                    c0037aF.f5527b = (i14 << 1) | 1;
                }
                c0037aF.f5527b = gVar.a(c0037aF.f5527b, i13);
                return c0037aF;
            case 14:
                C0037a c0037aC2 = c(regexp.f5497c[0]);
                return new C0037a(c0037aC2.f5526a, e(c0037aC2, (regexp.f5496b & 32) != 0).f5527b, c0037aC2.f5528c);
            case 15:
                C0037a c0037aC3 = c(regexp.f5497c[0]);
                boolean z3 = (regexp.f5496b & 32) != 0;
                C0037a c0037aF2 = f(1);
                int i15 = c0037aF2.f5526a;
                g gVar2 = this.f5525a;
                c cVar2 = gVar2.f10261a[i15];
                if (z3) {
                    cVar2.f10241c = c0037aC3.f5526a;
                    c0037aF2.f5527b = i15 << 1;
                } else {
                    cVar2.f10240b = c0037aC3.f5526a;
                    c0037aF2.f5527b = 1 | (i15 << 1);
                }
                c0037aF2.f5527b = gVar2.a(c0037aF2.f5527b, c0037aC3.f5527b);
                return c0037aF2;
            case 16:
            default:
                throw new IllegalStateException("regexp: unhandled case in compile");
            case 17:
                Regexp[] regexpArr = regexp.f5497c;
                if (regexpArr.length == 0) {
                    return g();
                }
                for (Regexp regexp2 : regexpArr) {
                    C0037a c0037aC4 = c(regexp2);
                    if (c0037aB != null) {
                        c0037aC4 = b(c0037aB, c0037aC4);
                    }
                    c0037aB = c0037aC4;
                }
                return c0037aB;
            case 18:
                Regexp[] regexpArr2 = regexp.f5497c;
                if (regexpArr2.length == 0) {
                    return g();
                }
                for (Regexp regexp3 : regexpArr2) {
                    C0037a c0037aC5 = c(regexp3);
                    if (c0037aB == null || (i10 = c0037aB.f5526a) == 0) {
                        c0037aB = c0037aC5;
                    } else if (c0037aC5.f5526a != 0) {
                        C0037a c0037aF3 = f(1);
                        c cVar3 = gVar.f10261a[c0037aF3.f5526a];
                        cVar3.f10240b = i10;
                        cVar3.f10241c = c0037aC5.f5526a;
                        c0037aF3.f5527b = gVar.a(c0037aB.f5527b, c0037aC5.f5527b);
                        c0037aF3.f5528c = c0037aB.f5528c || c0037aC5.f5528c;
                        c0037aB = c0037aF3;
                    }
                }
                return c0037aB;
        }
    }

    public final C0037a d(int i10) {
        C0037a c0037aF = f(4);
        int i11 = c0037aF.f5526a;
        this.f5525a.f10261a[i11].f10241c = i10;
        c0037aF.f5527b = i11 << 1;
        return c0037aF;
    }

    public final C0037a e(C0037a c0037a, boolean z) {
        C0037a c0037aF = f(1);
        int i10 = c0037aF.f5526a;
        g gVar = this.f5525a;
        c cVar = gVar.f10261a[i10];
        if (z) {
            cVar.f10241c = c0037a.f5526a;
            c0037aF.f5527b = i10 << 1;
        } else {
            cVar.f10240b = c0037a.f5526a;
            c0037aF.f5527b = (i10 << 1) | 1;
        }
        gVar.b(c0037a.f5527b, i10);
        return c0037aF;
    }

    public final C0037a f(int i10) {
        g gVar = this.f5525a;
        int i11 = gVar.f10262b;
        c[] cVarArr = gVar.f10261a;
        if (i11 >= cVarArr.length) {
            gVar.f10261a = (c[]) Arrays.copyOf(cVarArr, cVarArr.length * 2);
        }
        c[] cVarArr2 = gVar.f10261a;
        int i12 = gVar.f10262b;
        c cVar = new c();
        cVar.f10239a = i10;
        cVarArr2[i12] = cVar;
        gVar.f10262b = i12 + 1;
        return new C0037a(i12, 0, true);
    }

    public final C0037a g() {
        C0037a c0037aF = f(7);
        c0037aF.f5527b = c0037aF.f5526a << 1;
        return c0037aF;
    }

    public final C0037a h(int[] iArr, int i10) {
        C0037a c0037aF = f(8);
        c0037aF.f5528c = false;
        int i11 = c0037aF.f5526a;
        c cVar = this.f5525a.f10261a[i11];
        cVar.f10242d = iArr;
        int i12 = i10 & 1;
        if (iArr.length != 1 || jd.b.G(iArr[0]) == iArr[0]) {
            i12 = 0;
        }
        cVar.f10241c = i12;
        c0037aF.f5527b = i11 << 1;
        if (((i12 & 1) == 0 && iArr.length == 1) || (iArr.length == 2 && iArr[0] == iArr[1])) {
            cVar.f10239a = 9;
            return c0037aF;
        }
        if (iArr.length == 2 && iArr[0] == 0 && iArr[1] == 1114111) {
            cVar.f10239a = 10;
            return c0037aF;
        }
        if (iArr.length == 4 && iArr[0] == 0 && iArr[1] == 9 && iArr[2] == 11 && iArr[3] == 1114111) {
            cVar.f10239a = 11;
        }
        return c0037aF;
    }
}
