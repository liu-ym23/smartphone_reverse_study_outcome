package d7;

import c7.s;
import kotlin.jvm.internal.p;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f1926a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f1927b = new byte[0];

    public static final int a(char c3) {
        if ('0' <= c3 && c3 < ':') {
            return c3 - '0';
        }
        if ('a' <= c3 && c3 < 'g') {
            return c3 - 'W';
        }
        if ('A' <= c3 && c3 < 'G') {
            return c3 - '7';
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c3);
    }

    public static final int b(s sVar, int i8) {
        int i9;
        int[] iArr = sVar.f1197f;
        int i10 = i8 + 1;
        int length = sVar.f1196e.length;
        p.e(iArr, "<this>");
        int i11 = length - 1;
        int i12 = 0;
        while (true) {
            if (i12 <= i11) {
                i9 = (i12 + i11) >>> 1;
                int i13 = iArr[i9];
                if (i13 >= i10) {
                    if (i13 <= i10) {
                        break;
                    }
                    i11 = i9 - 1;
                } else {
                    i12 = i9 + 1;
                }
            } else {
                i9 = (-i12) - 1;
                break;
            }
        }
        return i9 >= 0 ? i9 : ~i9;
    }
}
