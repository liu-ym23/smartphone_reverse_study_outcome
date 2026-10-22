package q;

import r.C0990a;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f19650a = new Object();

    public static final <E> E c(j<E> jVar, int i5) {
        E e6;
        j4.k.g(jVar, "<this>");
        int iA = C0990a.a(jVar.f19647b, jVar.f19649d, i5);
        if (iA < 0 || (e6 = (E) jVar.f19648c[iA]) == f19650a) {
            return null;
        }
        return e6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> void d(j<E> jVar) {
        int i5 = jVar.f19649d;
        int[] iArr = jVar.f19647b;
        Object[] objArr = jVar.f19648c;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            Object obj = objArr[i7];
            if (obj != f19650a) {
                if (i7 != i6) {
                    iArr[i6] = iArr[i7];
                    objArr[i6] = obj;
                    objArr[i7] = null;
                }
                i6++;
            }
        }
        jVar.f19646a = false;
        jVar.f19649d = i6;
    }
}
