package b0;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class s {

    /* renamed from: a, reason: collision with root package name */
    public static final i1 f1331a = new i1("provider");

    /* renamed from: b, reason: collision with root package name */
    public static final i1 f1332b = new i1("provider");

    /* renamed from: c, reason: collision with root package name */
    public static final i1 f1333c = new i1("compositionLocalMap");

    /* renamed from: d, reason: collision with root package name */
    public static final i1 f1334d = new i1("providers");

    /* renamed from: e, reason: collision with root package name */
    public static final i1 f1335e = new i1("reference");

    /* renamed from: f, reason: collision with root package name */
    public static final q f1336f = new q(0);

    public static final void a(ArrayList arrayList, int i2, int i10) {
        int iE = e(i2, arrayList);
        if (iE < 0) {
            iE = -(iE + 1);
        }
        while (iE < arrayList.size() && ((s0) arrayList.get(iE)).f1338b < i10) {
        }
    }

    public static final void b(o2 o2Var, ArrayList arrayList, int i2) {
        boolean zJ = o2Var.j(i2);
        int[] iArr = o2Var.f1258b;
        if (zJ) {
            arrayList.add(o2Var.l(i2));
            return;
        }
        int i10 = iArr[(i2 * 5) + 3] + i2;
        for (int i11 = i2 + 1; i11 < i10; i11 += iArr[(i11 * 5) + 3]) {
            b(o2Var, arrayList, i11);
        }
    }

    public static final void c(String str) {
        throw new j(a1.a.j("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (", str, "). Please report to Google or use https://goo.gle/compose-feedback"));
    }

    public static final Void d(String str) {
        throw new j(a1.a.j("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (", str, "). Please report to Google or use https://goo.gle/compose-feedback"));
    }

    public static final int e(int i2, List list) {
        int size = list.size() - 1;
        int i10 = 0;
        while (i10 <= size) {
            int i11 = (i10 + size) >>> 1;
            int iF = q7.k.f(((s0) list.get(i11)).f1338b, i2);
            if (iF < 0) {
                i10 = i11 + 1;
            } else {
                if (iF <= 0) {
                    return i11;
                }
                size = i11 - 1;
            }
        }
        return -(i10 + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f8, code lost:
    
        l.a.d("Index must be between 0 and size");
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fd, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f(b0.s2 r19, i1.a1 r20) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b0.s.f(b0.s2, i1.a1):void");
    }
}
