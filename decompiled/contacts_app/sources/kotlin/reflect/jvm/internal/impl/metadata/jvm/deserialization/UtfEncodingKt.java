package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: utfEncoding.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UtfEncodingKt {
    public static final byte[] stringsToBytes(String[] r10) {
        Intrinsics.checkNotNullParameter(r10, "strings");
        int r0 = r10.length;
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r2 >= r0) goto L5;
        r3 = r3 + r10[r2].length();
        r2 = r2 + 1;
        goto L3
    L5:
        byte[] r1 = new byte[r3];
        int r4 = r10.length;
        int r5 = 0;
        int r6 = 0;
    L6:
        if (r5 >= r4) goto L11;
        String r7 = r10[r5];
        int r8 = r7.length();
        int r9 = 0;
    L8:
        if (r9 >= r8) goto L10;
        r1[r6] = (byte) r7.charAt(r9);
        r9 = r9 + 1;
        r6 = r6 + 1;
        goto L8
    L10:
        r5 = r5 + 1;
        goto L6
    L11:
        return r1;
    }
}
