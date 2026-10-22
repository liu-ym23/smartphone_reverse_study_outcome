package fa;

import kotlin.jvm.internal.p;

/* renamed from: fa.i, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C4072i {
    public static final byte[] a(String[] strings) {
        p.i(strings, "strings");
        int length = 0;
        for (String str : strings) {
            length += str.length();
        }
        byte[] bArr = new byte[length];
        int i10 = 0;
        for (String str2 : strings) {
            int length2 = str2.length();
            int i11 = 0;
            while (i11 < length2) {
                bArr[i10] = (byte) str2.charAt(i11);
                i11++;
                i10++;
            }
        }
        return bArr;
    }
}
