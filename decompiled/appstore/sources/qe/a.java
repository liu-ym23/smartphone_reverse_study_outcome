package qe;

import android.text.TextUtils;
import com.google.common.primitives.UnsignedBytes;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f23655a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final char[] f23656b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static me.a f23657c;

    static {
        f23655a = new int[]{45217, 45253, 45761, 46318, 46826, 47010, 47297, 47614, 48119, 49062, 49324, 49896, 50371, 50614, 50622, 50906, 51387, 51446, 52218, 52698, 52980, 53689, 54481, 55457};
        f23656b = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'W', 'X', 'Y', 'Z', '#'};
    }

    public static char a(char r10) {
        if (r10 < 'a') goto L9;
        if (r10 > 'z') goto L9;
        return (char) (r10 - ' ');
    L9:
        if (r10 >= 'A') goto L11;
        return '#';
    L11:
        if (r10 > 'Z') goto L15;
        return r10;
    L15:
        return '#';
    }

    public static char b(String r10) {
        if (f23657c != null) goto L6;
        d();
    L6:
        if (r10 != null) goto L8;
    L36:
        return '#';
    L8:
        if (r10.isEmpty() == true) goto L36;
        int r11 = 0;
        char r12 = r10.charAt(0);
        if (r12 < 128) goto L13;
        int r13 = c(r12);
        if (r13 >= 45217) goto L17;
    L29:
        ArrayList r14 = f23657c.b(String.valueOf(r12));
        if (r14.size() <= 0) goto L36;
        String r15 = ((me.a.C0317a) r14.get(0)).f22276c;
        if (TextUtils.isEmpty(r15) == false) goto L35;
        return '#';
    L35:
        return a(r15.charAt(0));
    L17:
        if (r13 >= 55457) goto L29;
        int r16 = f23655a.length - 1;
        int r17 = 0;
    L20:
        if (r11 > r16) goto L28;
        r17 = (r11 + r16) >> 1;
        int r18 = f23655a[r17];
        if (r13 > r18) goto L23;
        if (r13 == r18) goto L28;
        r17 = r17 - 1;
        r16 = r17;
        goto L20
    L23:
        r11 = r17 + 1;
    L28:
        return f23656b[r17];
    L13:
        return a(r12);
    }

    public static int c(char r10) {
        byte[] r11 = String.valueOf(r10).getBytes("GB2312");     // Catch: Exception -> L9
        if (r11.length >= 2) goto L6;
        return 0;
    L6:
        int r12 = (r11[0] << 8) & 65280;     // Catch: Exception -> L9
        return r12 + (r11[1] & UnsignedBytes.MAX_VALUE);
    L9:
        return 0;
    }

    public static synchronized void d() {
        monitor-enter(a.class);
    L8:
        th = move-exception;
        throw th;
    L5:
        if (f23657c != null) goto L10;
        f23657c = me.a.c();     // Catch: Throwable -> L8
    L10:
        monitor-exit(a.class);
    }
}
