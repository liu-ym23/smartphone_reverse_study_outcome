package kotlin.text;

/* JADX INFO: loaded from: classes4.dex */
public abstract class n extends m {
    public static Integer g(String r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return h(r10, 10);
    }

    public static final Integer h(String r10, int r11) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        a.a(r11);
        int r12 = r10.length();
        if (r12 != 0) goto L5;
        return null;
    L5:
        int r13 = 0;
        char r14 = r10.charAt(0);
        int r15 = -2147483647;
        if (kotlin.jvm.internal.q.i(r14, 48) >= 0) goto L17;
        int r16 = 1;
        if (r12 != 1) goto L11;
        return null;
    L11:
        if (r14 != '-') goto L14;
        r15 = Integer.MIN_VALUE;
        boolean r17 = true;
    L18:
        int r18 = -59652323;
    L19:
        if (r16 >= r12) goto L32;
        int r19 = a.b(r10.charAt(r16), r11);
        if (r19 < 0) goto L22;
        if (r13 >= r18) goto L28;
        if (r18 != (-59652323)) goto L27;
        r18 = r15 / r11;
        if (r13 >= r18) goto L28;
    L27:
        return null;
    L28:
        int r20 = r13 * r11;
        if (r20 < (r15 + r19)) goto L30;
        r13 = r20 - r19;
        r16 = r16 + 1;
        goto L19
    L30:
        return null;
    L22:
        return null;
    L32:
        if (r17 == false) goto L35;
        return Integer.valueOf(r13);
    L35:
        return Integer.valueOf(-r13);
    L14:
        if (r14 != '+') goto L16;
        r17 = false;
        goto L18
    L16:
        return null;
    L17:
        r17 = false;
        r16 = 0;
        goto L18
    }

    public static Long i(String r10) {
        kotlin.jvm.internal.q.g(r10, "<this>");
        return j(r10, 10);
    }

    public static final Long j(String r19, int r20) {
        kotlin.jvm.internal.q.g(r19, "<this>");
        a.a(r20);
        int r10 = r19.length();
        if (r10 != 0) goto L5;
        return null;
    L5:
        int r11 = 0;
        char r12 = r19.charAt(0);
        long r13 = -9223372036854775807L;
        if (kotlin.jvm.internal.q.i(r12, 48) >= 0) goto L17;
        boolean r14 = true;
        if (r10 != 1) goto L11;
        return null;
    L11:
        if (r12 != '-') goto L14;
        r13 = Long.MIN_VALUE;
        r11 = 1;
    L18:
        long r15 = -256204778801521550L;
        long r16 = 0;
        long r17 = -256204778801521550L;
    L19:
        if (r11 >= r10) goto L34;
        int r18 = a.b(r19.charAt(r11), r20);
        if (r18 < 0) goto L22;
        if (r16 < r17) goto L26;
    L30:
        long r110 = r16 * ((long) r20);
        long r21 = r18;
        if (r110 < (r13 + r21)) goto L32;
        r16 = r110 - r21;
        r11 = r11 + 1;
        r15 = -256204778801521550L;
        goto L19
    L32:
        return null;
    L26:
        if (r17 != r15) goto L29;
        r17 = r13 / ((long) r20);
        if (r16 >= r17) goto L30;
    L29:
        return null;
    L22:
        return null;
    L34:
        if (r14 == false) goto L37;
        return Long.valueOf(r16);
    L37:
        return Long.valueOf(-r16);
    L14:
        if (r12 != '+') goto L16;
        r14 = false;
        r11 = 1;
        goto L18
    L16:
        return null;
    L17:
        r14 = false;
        goto L18
    }
}
