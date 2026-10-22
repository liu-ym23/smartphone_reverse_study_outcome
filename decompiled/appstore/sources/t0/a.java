package t0;

import com.google.common.base.Ascii;
import com.google.common.primitives.UnsignedBytes;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f24700a = null;

    static {
        f24700a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    public static String a(byte[] r10) {
        if (r10 != null) goto L11;
    L9:
        return null;
    L11:
        if (r10.length == 0) goto L9;
        MessageDigest r11 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r11.update(r10);     // Catch: Exception -> L10
        return b(r11.digest());
    }

    public static String b(byte[] r10) {
        if (r10 == null) goto L6;
        return c(r10, 0, r10.length);
    L6:
        throw new NullPointerException("bytes is null");
    }

    public static String c(byte[] r10, int r11, int r12) {
        if (r10 == null) goto L14;
        if (r11 < 0) goto L12;
        if ((r11 + r12) > r10.length) goto L12;
        int r13 = r12 * 2;
        char[] r14 = new char[r13];
        int r15 = 0;
        int r16 = 0;
    L7:
        if (r15 >= r12) goto L10;
        byte r17 = r10[r15 + r11];
        int r18 = r17 & UnsignedBytes.MAX_VALUE;
        int r19 = r16 + 1;
        char[] r20 = f24700a;
        r14[r16] = r20[r18 >> 4];
        r16 = r16 + 2;
        r14[r19] = r20[r17 & Ascii.SI];
        r15 = r15 + 1;
        goto L7
    L10:
        return new String(r14, 0, r13);
    L12:
        throw new IndexOutOfBoundsException();
    L14:
        throw new NullPointerException("bytes is null");
    }
}
