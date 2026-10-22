package d.o;

/* JADX INFO: compiled from: StringNumberConversions.kt */
/* JADX INFO: loaded from: classes4.dex */
class w extends v {
    public w() {
    }

    public static final Integer d(String r1) {
        d.h.b.o.e(r1, "<this>");
        return o.a(r1, 10);
    }

    public static final Integer a(String r10, int r11) {
        d.h.b.o.e(r10, "<this>");
        a.a(r11);
        int r0 = r10.length();
        if (r0 != 0) goto L5;
        return null;
    L5:
        int r2 = 0;
        char r3 = r10.charAt(0);
        int r5 = -2147483647;
        int r6 = 1;
        if (d.h.b.o.a(r3, 48) >= 0) goto L16;
        if (r0 != 1) goto L10;
        return null;
    L10:
        if (r3 != '+') goto L12;
        boolean r4 = false;
    L17:
        int r7 = -59652323;
    L18:
        if (r6 >= r0) goto L31;
        int r8 = a.a(r10.charAt(r6), r11);
        if (r8 < 0) goto L21;
        if (r2 >= r7) goto L27;
        if (r7 != (-59652323)) goto L26;
        r7 = r5 / r11;
        if (r2 >= r7) goto L27;
    L26:
        return null;
    L27:
        int r9 = r2 * r11;
        if (r9 < (r5 + r8)) goto L29;
        r2 = r9 - r8;
        r6 = r6 + 1;
        goto L18
    L29:
        return null;
    L21:
        return null;
    L31:
        if (r4 == false) goto L34;
        return Integer.valueOf(r2);
    L34:
        return Integer.valueOf(-r2);
    L12:
        if (r3 == '-') goto L14;
        return null;
    L14:
        r5 = Integer.MIN_VALUE;
        r4 = true;
        goto L17
    L16:
        r4 = false;
        r6 = 0;
        goto L17
    }

    public static final Long e(String r1) {
        d.h.b.o.e(r1, "<this>");
        return o.b(r1, 10);
    }

    public static final Long b(String r19, int r20) {
        d.h.b.o.e(r19, "<this>");
        a.a(r20);
        int r2 = r19.length();
        if (r2 != 0) goto L5;
        return null;
    L5:
        int r4 = 0;
        char r5 = r19.charAt(0);
        long r7 = -9223372036854775807L;
        boolean r9 = true;
        if (d.h.b.o.a(r5, 48) >= 0) goto L16;
        if (r2 != 1) goto L10;
        return null;
    L10:
        if (r5 != '+') goto L12;
        r9 = false;
        r4 = 1;
    L17:
        long r6 = -256204778801521550L;
        long r10 = 0;
        long r12 = -256204778801521550L;
    L18:
        if (r4 >= r2) goto L33;
        int r14 = a.a(r19.charAt(r4), r20);
        if (r14 < 0) goto L21;
        if (r10 < r12) goto L25;
    L29:
        long r11 = r10 * ((long) r20);
        long r8 = r14;
        if (r11 < (r7 + r8)) goto L31;
        r10 = r11 - r8;
        r4 = r4 + 1;
        r6 = -256204778801521550L;
        goto L18
    L31:
        return null;
    L25:
        if (r12 != r6) goto L28;
        r12 = r7 / ((long) r20);
        if (r10 >= r12) goto L29;
    L28:
        return null;
    L21:
        return null;
    L33:
        if (r9 == false) goto L36;
        return Long.valueOf(r10);
    L36:
        return Long.valueOf(-r10);
    L12:
        if (r5 == '-') goto L14;
        return null;
    L14:
        r7 = Long.MIN_VALUE;
        r4 = 1;
        goto L17
    L16:
        r9 = false;
        goto L17
    }
}
