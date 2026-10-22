package k;

import java.util.ConcurrentModificationException;

/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f5511a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f5512b = new Object();

    public static final int a(f fVar, Object obj, int i2) {
        int i10 = fVar.f5486h;
        if (i10 == 0) {
            return -1;
        }
        try {
            int iA = l.a.a(i10, i2, fVar.f5484f);
            if (iA < 0 || q7.k.a(obj, fVar.f5485g[iA])) {
                return iA;
            }
            int i11 = iA + 1;
            while (i11 < i10 && fVar.f5484f[i11] == i2) {
                if (q7.k.a(obj, fVar.f5485g[i11])) {
                    return i11;
                }
                i11++;
            }
            for (int i12 = iA - 1; i12 >= 0 && fVar.f5484f[i12] == i2; i12--) {
                if (q7.k.a(obj, fVar.f5485g[i12])) {
                    return i12;
                }
            }
            return ~i11;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }
}
