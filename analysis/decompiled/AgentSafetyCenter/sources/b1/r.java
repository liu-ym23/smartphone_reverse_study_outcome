package b1;

import java.util.Comparator;
import u1.g0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r implements Comparator {

    /* renamed from: c, reason: collision with root package name */
    public static final r f1852c = new r();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.Object, java.lang.Object[]] */
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        q qVar = (q) obj;
        q qVar2 = (q) obj2;
        int i = 0;
        if (e.r(qVar) && e.r(qVar2)) {
            g0 g0VarU = u1.f.u(qVar);
            g0 g0VarU2 = u1.f.u(qVar2);
            if (!yb.k.a(g0VarU, g0VarU2)) {
                g0[] g0VarArr = new g0[16];
                int i3 = 0;
                while (g0VarU != null) {
                    int i10 = i3 + 1;
                    if (g0VarArr.length < i10) {
                        int length = g0VarArr.length;
                        ?? r42 = new Object[Math.max(i10, length * 2)];
                        System.arraycopy(g0VarArr, 0, r42, 0, length);
                        g0VarArr = r42;
                    }
                    if (i3 != 0) {
                        System.arraycopy(g0VarArr, 0, g0VarArr, 0 + 1, i3 + 0);
                    }
                    g0VarArr[0] = g0VarU;
                    i3++;
                    g0VarU = g0VarU.t();
                }
                g0[] g0VarArr2 = new g0[16];
                int i11 = 0;
                while (g0VarU2 != null) {
                    int i12 = i11 + 1;
                    if (g0VarArr2.length < i12) {
                        int length2 = g0VarArr2.length;
                        ?? r43 = new Object[Math.max(i12, length2 * 2)];
                        System.arraycopy(g0VarArr2, 0, r43, 0, length2);
                        g0VarArr2 = r43;
                    }
                    if (i11 != 0) {
                        System.arraycopy(g0VarArr2, 0, g0VarArr2, 0 + 1, i11 + 0);
                    }
                    g0VarArr2[0] = g0VarU2;
                    i11++;
                    g0VarU2 = g0VarU2.t();
                }
                int iMin = Math.min(i3 - 1, i11 - 1);
                if (iMin >= 0) {
                    while (yb.k.a(g0VarArr[i], g0VarArr2[i])) {
                        if (i != iMin) {
                            i++;
                        }
                    }
                    return yb.k.b(g0VarArr[i].u(), g0VarArr2[i].u());
                }
                od.f.e("Could not find a common ancestor between the two FocusModifiers.");
                return 0;
            }
        } else {
            if (e.r(qVar)) {
                return -1;
            }
            if (e.r(qVar2)) {
                return 1;
            }
        }
        return 0;
    }
}
