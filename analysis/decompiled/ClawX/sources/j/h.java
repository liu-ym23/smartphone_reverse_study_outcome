package j;

import java.util.ConcurrentModificationException;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f3296a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static final Object f3297b = new Object();

    public static final int a(f fVar, Object obj, int i8) {
        int i9 = fVar.f3292c;
        if (i9 == 0) {
            return -1;
        }
        try {
            int iA = k.a.a(i9, i8, fVar.f3290a);
            if (iA < 0 || p.a(obj, fVar.f3291b[iA])) {
                return iA;
            }
            int i10 = iA + 1;
            while (i10 < i9 && fVar.f3290a[i10] == i8) {
                if (p.a(obj, fVar.f3291b[i10])) {
                    return i10;
                }
                i10++;
            }
            for (int i11 = iA - 1; i11 >= 0 && fVar.f3290a[i11] == i8; i11--) {
                if (p.a(obj, fVar.f3291b[i11])) {
                    return i11;
                }
            }
            return ~i10;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }
}
