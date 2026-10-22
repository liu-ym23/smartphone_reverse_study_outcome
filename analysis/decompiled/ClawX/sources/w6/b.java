package w6;

import c7.i;
import t1.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final i f6223a;

    static {
        i iVar = i.d;
        f6223a = f.f("xn--");
    }

    public static int a(int i8, int i9, boolean z) {
        int i10 = z ? i8 / 700 : i8 / 2;
        int i11 = (i10 / i9) + i10;
        int i12 = 0;
        while (i11 > 455) {
            i11 /= 35;
            i12 += 36;
        }
        return ((i11 * 36) / (i11 + 38)) + i12;
    }

    public static int b(int i8) {
        if (i8 < 26) {
            return i8 + 97;
        }
        if (i8 < 36) {
            return i8 + 22;
        }
        throw new IllegalStateException(("unexpected digit: " + i8).toString());
    }
}
