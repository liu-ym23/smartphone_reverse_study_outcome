package n6;

import java.util.Comparator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class f implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        String a9 = (String) obj;
        String b9 = (String) obj2;
        kotlin.jvm.internal.p.e(a9, "a");
        kotlin.jvm.internal.p.e(b9, "b");
        int iMin = Math.min(a9.length(), b9.length());
        for (int i8 = 4; i8 < iMin; i8++) {
            char cCharAt = a9.charAt(i8);
            char cCharAt2 = b9.charAt(i8);
            if (cCharAt != cCharAt2) {
                return kotlin.jvm.internal.p.g(cCharAt, cCharAt2) < 0 ? -1 : 1;
            }
        }
        int length = a9.length();
        int length2 = b9.length();
        if (length != length2) {
            return length < length2 ? -1 : 1;
        }
        return 0;
    }
}
