package c4;

import okio.Buffer;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static String a(int r10) {
        if (r10 < 1000) goto L20;
        if (r10 >= 5000) goto L20;
        if (r10 < 1004) goto L12;
        if (r10 > 1006) goto L12;
    L16:
        return "Code " + r10 + " is reserved and may not be used.";
    L12:
        if (r10 >= 1012) goto L14;
        return null;
    L14:
        if (r10 <= 2999) goto L16;
        return null;
    L20:
        return "Code must be in range [1000,5000): " + r10;
    }

    public static void b(Buffer.UnsafeCursor r10, byte[] r11) {
        int r12 = r11.length;
        int r13 = 0;
    L3:
        byte[] r14 = r10.f23026e;
        int r15 = r10.f23027f;
        int r16 = r10.f23028g;
    L4:
        if (r15 >= r16) goto L7;
        int r17 = r13 % r12;
        r14[r15] = (byte) (r14[r15] ^ r11[r17]);
        r15 = r15 + 1;
        r13 = r17 + 1;
        goto L4
    L7:
        if (r10.a() != (-1)) goto L3;
    }

    public static void c(int r10) {
        String r11 = a(r10);
        if (r11 != null) goto L6;
        return;
    L6:
        throw new IllegalArgumentException(r11);
    }
}
