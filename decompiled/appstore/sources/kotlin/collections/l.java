package kotlin.collections;

import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public abstract class l extends k {
    public static boolean c(Object[] r10, Object[] r11) {
        if (r10 != r11) goto L6;
        return true;
    L6:
        if (r10 == null) goto L88;
        if (r11 == null) goto L88;
        if (r10.length != r11.length) goto L88;
        int r12 = r10.length;
        int r13 = 0;
    L12:
        if (r13 >= r12) goto L87;
        Object r14 = r10[r13];
        Object r15 = r11[r13];
        if (r14 == r15) goto L85;
        if (r14 == null) goto L86;
        if (r15 == null) goto L86;
        if ((r14 instanceof Object[]) == false) goto L27;
        if ((r15 instanceof Object[]) == false) goto L27;
        if (c((Object[]) r14, (Object[]) r15) == true) goto L85;
        return false;
    L27:
        if ((r14 instanceof byte[]) == false) goto L34;
        if ((r15 instanceof byte[]) == false) goto L34;
        if (Arrays.equals((byte[]) r14, (byte[]) r15) == true) goto L85;
        return false;
    L34:
        if ((r14 instanceof short[]) == false) goto L41;
        if ((r15 instanceof short[]) == false) goto L41;
        if (Arrays.equals((short[]) r14, (short[]) r15) == true) goto L85;
        return false;
    L41:
        if ((r14 instanceof int[]) == false) goto L48;
        if ((r15 instanceof int[]) == false) goto L48;
        if (Arrays.equals((int[]) r14, (int[]) r15) == true) goto L85;
        return false;
    L48:
        if ((r14 instanceof long[]) == false) goto L55;
        if ((r15 instanceof long[]) == false) goto L55;
        if (Arrays.equals((long[]) r14, (long[]) r15) == true) goto L85;
        return false;
    L55:
        if ((r14 instanceof float[]) == false) goto L62;
        if ((r15 instanceof float[]) == false) goto L62;
        if (Arrays.equals((float[]) r14, (float[]) r15) == true) goto L85;
        return false;
    L62:
        if ((r14 instanceof double[]) == false) goto L69;
        if ((r15 instanceof double[]) == false) goto L69;
        if (Arrays.equals((double[]) r14, (double[]) r15) == true) goto L85;
        return false;
    L69:
        if ((r14 instanceof char[]) == false) goto L76;
        if ((r15 instanceof char[]) == false) goto L76;
        if (Arrays.equals((char[]) r14, (char[]) r15) == true) goto L85;
        return false;
    L76:
        if ((r14 instanceof boolean[]) == false) goto L83;
        if ((r15 instanceof boolean[]) == false) goto L83;
        if (Arrays.equals((boolean[]) r14, (boolean[]) r15) == true) goto L85;
        return false;
    L83:
        if (kotlin.jvm.internal.q.b(r14, r15) == true) goto L85;
        return false;
    L86:
        return false;
    L85:
        r13 = r13 + 1;
        goto L12
    L87:
        return true;
    L88:
        return false;
    }
}
