package w;

import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a, reason: collision with root package name */
    public static final e f14990a = new e(1);

    /* renamed from: b, reason: collision with root package name */
    public static final e f14991b = new e(0);

    /* renamed from: c, reason: collision with root package name */
    public static final c f14992c = new c();

    /* renamed from: d, reason: collision with root package name */
    public static final d f14993d;

    /* renamed from: e, reason: collision with root package name */
    public static final d f14994e;

    static {
        d dVar = new d(0);
        float f5 = 0;
        dVar.f14962b = f5;
        VarHandle.storeStoreFence();
        f14993d = dVar;
        d dVar2 = new d(1);
        dVar2.f14962b = f5;
        VarHandle.storeStoreFence();
        f14994e = dVar2;
    }

    public static void a(int i, int[] iArr, int[] iArr2, boolean z10) {
        int i3 = 0;
        int i10 = 0;
        for (int i11 : iArr) {
            i10 += i11;
        }
        float f5 = (i - i10) / 2;
        if (!z10) {
            int length = iArr.length;
            int i12 = 0;
            while (i3 < length) {
                int i13 = iArr[i3];
                iArr2[i12] = Math.round(f5);
                f5 += i13;
                i3++;
                i12++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i14 = iArr[length2];
            iArr2[length2] = Math.round(f5);
            f5 += i14;
        }
    }

    public static void b(int[] iArr, int[] iArr2, boolean z10) {
        int i = 0;
        if (!z10) {
            int length = iArr.length;
            int i3 = 0;
            int i10 = 0;
            while (i < length) {
                int i11 = iArr[i];
                iArr2[i3] = i10;
                i10 += i11;
                i++;
                i3++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i12 = iArr[length2];
            iArr2[length2] = i;
            i += i12;
        }
    }

    public static void c(int i, int[] iArr, int[] iArr2, boolean z10) {
        int i3 = 0;
        int i10 = 0;
        for (int i11 : iArr) {
            i10 += i11;
        }
        int i12 = i - i10;
        if (!z10) {
            int length = iArr.length;
            int i13 = 0;
            while (i3 < length) {
                int i14 = iArr[i3];
                iArr2[i13] = i12;
                i12 += i14;
                i3++;
                i13++;
            }
            return;
        }
        int length2 = iArr.length;
        while (true) {
            length2--;
            if (-1 >= length2) {
                return;
            }
            int i15 = iArr[length2];
            iArr2[length2] = i12;
            i12 += i15;
        }
    }

    public static void d(int i, int[] iArr, int[] iArr2, boolean z10) {
        if (iArr.length == 0) {
            return;
        }
        int i3 = 0;
        int i10 = 0;
        for (int i11 : iArr) {
            i10 += i11;
        }
        float fMax = (i - i10) / Math.max(iArr.length - 1, 1);
        float f5 = (z10 && iArr.length == 1) ? fMax : 0.0f;
        if (z10) {
            for (int length = iArr.length - 1; -1 < length; length--) {
                int i12 = iArr[length];
                iArr2[length] = Math.round(f5);
                f5 += i12 + fMax;
            }
            return;
        }
        int length2 = iArr.length;
        int i13 = 0;
        while (i3 < length2) {
            int i14 = iArr[i3];
            iArr2[i13] = Math.round(f5);
            f5 += i14 + fMax;
            i3++;
            i13++;
        }
    }

    public static g e(float f5) {
        return new g(f5, i.f14982c);
    }
}
