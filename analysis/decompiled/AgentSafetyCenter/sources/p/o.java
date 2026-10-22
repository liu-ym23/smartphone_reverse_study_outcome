package p;

import java.util.ConcurrentModificationException;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f9598a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final long[] f9599b = new long[0];

    /* renamed from: c, reason: collision with root package name */
    public static final Object f9600c = new Object();

    public static final int a(f fVar, Object obj, int i) {
        int i3 = fVar.f9551g;
        if (i3 == 0) {
            return -1;
        }
        try {
            int iA = q.a.a(i3, i, fVar.f9549c);
            if (iA < 0 || yb.k.a(obj, fVar.f9550f[iA])) {
                return iA;
            }
            int i10 = iA + 1;
            while (i10 < i3 && fVar.f9549c[i10] == i) {
                if (yb.k.a(obj, fVar.f9550f[i10])) {
                    return i10;
                }
                i10++;
            }
            for (int i11 = iA - 1; i11 >= 0 && fVar.f9549c[i11] == i; i11--) {
                if (yb.k.a(obj, fVar.f9550f[i11])) {
                    return i11;
                }
            }
            return ~i10;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }
}
