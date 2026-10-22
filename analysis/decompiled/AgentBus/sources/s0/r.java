package s0;

import i1.f0;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class r implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public static final r f9202a = new r();

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object, java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.lang.Object, java.lang.Object[]] */
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        q qVar = (q) obj;
        q qVar2 = (q) obj2;
        int i2 = 0;
        if (e.r(qVar) && e.r(qVar2)) {
            f0 f0VarU = i1.l.u(qVar);
            f0 f0VarU2 = i1.l.u(qVar2);
            if (!q7.k.a(f0VarU, f0VarU2)) {
                f0[] f0VarArr = new f0[16];
                int i10 = 0;
                while (f0VarU != null) {
                    int i11 = i10 + 1;
                    if (f0VarArr.length < i11) {
                        int length = f0VarArr.length;
                        ?? r42 = new Object[Math.max(i11, length * 2)];
                        System.arraycopy(f0VarArr, 0, r42, 0, length);
                        f0VarArr = r42;
                    }
                    if (i10 != 0) {
                        System.arraycopy(f0VarArr, 0, f0VarArr, 0 + 1, i10 + 0);
                    }
                    f0VarArr[0] = f0VarU;
                    i10++;
                    f0VarU = f0VarU.n();
                }
                f0[] f0VarArr2 = new f0[16];
                int i12 = 0;
                while (f0VarU2 != null) {
                    int i13 = i12 + 1;
                    if (f0VarArr2.length < i13) {
                        int length2 = f0VarArr2.length;
                        ?? r43 = new Object[Math.max(i13, length2 * 2)];
                        System.arraycopy(f0VarArr2, 0, r43, 0, length2);
                        f0VarArr2 = r43;
                    }
                    if (i12 != 0) {
                        System.arraycopy(f0VarArr2, 0, f0VarArr2, 0 + 1, i12 + 0);
                    }
                    f0VarArr2[0] = f0VarU2;
                    i12++;
                    f0VarU2 = f0VarU2.n();
                }
                int iMin = Math.min(i10 - 1, i12 - 1);
                if (iMin >= 0) {
                    while (q7.k.a(f0VarArr[i2], f0VarArr2[i2])) {
                        if (i2 != iMin) {
                            i2++;
                        }
                    }
                    return q7.k.f(f0VarArr[i2].o(), f0VarArr2[i2].o());
                }
                throw new IllegalStateException("Could not find a common ancestor between the two FocusModifiers.");
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
