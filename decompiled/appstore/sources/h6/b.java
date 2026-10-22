package h6;

import com.google.common.base.Ascii;
import java.io.InputStream;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f20349a = null;

    static {
        f20349a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    }

    public static char[] a(byte[] r10, char[] r11) {
        int r12 = r10.length;
        char[] r13 = new char[r12 << 1];
        int r14 = 0;
        int r15 = 0;
    L3:
        if (r14 >= r12) goto L5;
        int r16 = r15 + 1;
        byte r17 = r10[r14];
        r13[r15] = r11[(r17 & 240) >>> 4];
        r15 = r15 + 2;
        r13[r16] = r11[r17 & Ascii.SI];
        r14 = r14 + 1;
        goto L3
    L5:
        return r13;
    }

    public static String b(InputStream r10) {
        MessageDigest r11 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L8
        byte[] r12 = new byte[1024];     // Catch: Throwable -> L8
        int r13 = r10.read(r12, 0, 1024);     // Catch: Throwable -> L8
    L4:
        if (r13 <= (-1)) goto L6;
        r11.update(r12, 0, r13);     // Catch: Throwable -> L8
        r13 = r10.read(r12, 0, 1024);     // Catch: Throwable -> L8
        goto L4
    L6:
        return new String(a(r11.digest(), f20349a));
    L8:
        return null;
    }

    public static String c(byte[] r10) {
        return new String(a(MessageDigest.getInstance("MD5").digest(r10), f20349a));
    L4:
        return null;
    }
}
