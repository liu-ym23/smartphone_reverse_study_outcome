package F9;

import java.util.Comparator;

/* renamed from: F9.i, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0231i implements Comparator {
    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        String a3 = (String) obj;
        String b = (String) obj2;
        kotlin.jvm.internal.k.f(a3, "a");
        kotlin.jvm.internal.k.f(b, "b");
        int iMin = Math.min(a3.length(), b.length());
        for (int i = 4; i < iMin; i++) {
            char cCharAt = a3.charAt(i);
            char cCharAt2 = b.charAt(i);
            if (cCharAt != cCharAt2) {
                return kotlin.jvm.internal.k.g(cCharAt, cCharAt2) < 0 ? -1 : 1;
            }
        }
        int length = a3.length();
        int length2 = b.length();
        if (length != length2) {
            return length < length2 ? -1 : 1;
        }
        return 0;
    }
}
