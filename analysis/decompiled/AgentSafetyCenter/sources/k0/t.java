package k0;

import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static final e1 f7062a = new e1("provider");

    /* renamed from: b, reason: collision with root package name */
    public static final e1 f7063b = new e1("provider");

    /* renamed from: c, reason: collision with root package name */
    public static final e1 f7064c = new e1("compositionLocalMap");

    /* renamed from: d, reason: collision with root package name */
    public static final e1 f7065d = new e1("providers");

    /* renamed from: e, reason: collision with root package name */
    public static final e1 f7066e = new e1("reference");

    /* renamed from: f, reason: collision with root package name */
    public static final e2.d f7067f = new e2.d(1);

    public static final void a(ArrayList arrayList, int i, int i3) {
        int iE = e(i, arrayList);
        if (iE < 0) {
            iE = -(iE + 1);
        }
        while (iE < arrayList.size() && ((s0) arrayList.get(iE)).f7059b < i3) {
        }
    }

    public static final void b(e2 e2Var, ArrayList arrayList, int i) {
        boolean zL = e2Var.l(i);
        int[] iArr = e2Var.f6883b;
        if (zL) {
            arrayList.add(e2Var.n(i));
            return;
        }
        int iA = h2.a(iArr, i) + i;
        for (int i3 = i + 1; i3 < iA; i3 += iArr[(i3 * 5) + 3]) {
            b(e2Var, arrayList, i3);
        }
    }

    public static final void c(String str) {
        throw new l(a.C("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (", str, "). Please report to Google or use https://goo.gle/compose-feedback"));
    }

    public static final Void d(String str) {
        throw new l(a.C("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (", str, "). Please report to Google or use https://goo.gle/compose-feedback"));
    }

    public static final int e(int i, List list) {
        int size = list.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i10 = (i3 + size) >>> 1;
            int iB = yb.k.b(((s0) list.get(i10)).f7059b, i);
            if (iB < 0) {
                i3 = i10 + 1;
            } else {
                if (iB <= 0) {
                    return i10;
                }
                size = i10 - 1;
            }
        }
        return -(i3 + 1);
    }

    public static final Object f(Object obj, Integer num, Object obj2) {
        u0 u0Var = obj instanceof u0 ? (u0) obj : null;
        if (u0Var == null) {
            return null;
        }
        Object obj3 = u0Var.f7080b;
        Integer num2 = u0Var.f7079a;
        if (num2.equals(num) && yb.k.a(obj3, obj2)) {
            return obj;
        }
        Object objF = f(num2, num, obj2);
        return objF == null ? f(obj3, num, obj2) : objF;
    }

    public static final void g(i2 i2Var, s0.i iVar) {
        int i = i2Var.f6956t;
        e9.m mVar = new e9.m(2);
        mVar.f3688f = iVar;
        VarHandle.storeStoreFence();
        i2Var.n(i, mVar);
        i2Var.G();
    }

    public static final void h(i2 i2Var, int i, Object obj) {
        int iH = i2Var.h(i);
        Object[] objArr = i2Var.f6940c;
        Object obj2 = objArr[iH];
        objArr[iH] = m.f6974a;
        if (obj == obj2) {
            return;
        }
        c("Slot table is out of sync (expected " + obj + ", got " + obj2 + ')');
    }
}
