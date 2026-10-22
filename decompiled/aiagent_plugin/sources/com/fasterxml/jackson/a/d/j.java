package com.fasterxml.jackson.a.d;

/* JADX INFO: compiled from: NumberOutput.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f12011a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f12012b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f12013c = 1000000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f12014d = 1000000000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f12015e = 1000000000;
    private static long f = -2147483648L;
    private static long g = 2147483647L;
    private static final int[] h = null;
    private static final String[] i = null;
    private static final String[] j = null;

    static {
        f12011a = String.valueOf(Integer.MIN_VALUE);
        f12012b = String.valueOf(Long.MIN_VALUE);
        h = new int[1000];
        int r1 = 0;
        int r2 = 0;
    L4:
        if (r1 >= 10) goto L12;
        int r4 = 0;
    L6:
        if (r4 >= 10) goto L11;
        int r5 = 0;
    L8:
        if (r5 >= 10) goto L10;
        h[r2] = (((r1 + 48) << 16) | ((r4 + 48) << 8)) | (r5 + 48);
        r5 = r5 + 1;
        r2 = r2 + 1;
        goto L8
    L10:
        r4 = r4 + 1;
        goto L6
    L11:
        r1 = r1 + 1;
        goto L4
    L12:
        i = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        j = new String[]{"-1", "-2", "-3", "-4", "-5", "-6", "-7", "-8", "-9", "-10"};
    }

    public static int a(int r3, char[] r4, int r5) {
        if (r3 >= 0) goto L9;
        if (r3 == Integer.MIN_VALUE) goto L6;
        r4[r5] = '-';
        r3 = -r3;
        r5 = r5 + 1;
        goto L9
    L6:
        return b(r4, r5);
    L9:
        if (r3 < f12013c) goto L11;
        int r0 = f12014d;
        if (r3 < r0) goto L28;
        int r6 = r3 - r0;
        if (r6 < r0) goto L25;
        r6 = r6 - r0;
        int r1 = r5 + 1;
        r4[r5] = '2';
    L27:
        return c(r6, r4, r1);
    L25:
        r1 = r5 + 1;
        r4[r5] = '1';
        goto L27
    L28:
        int r2 = r3 / 1000;
        int r7 = r3 - (r2 * 1000);
        int r8 = r2 / 1000;
        return e(r7, r4, e(r2 - (r8 * 1000), r4, d(r8, r4, r5)));
    L11:
        if (r3 < 1000) goto L13;
        int r9 = r3 / 1000;
        return e(r3 - (r9 * 1000), r4, d(r9, r4, r5));
    L13:
        if (r3 >= 10) goto L17;
        r4[r5] = (char) (r3 + 48);
        return r5 + 1;
    L17:
        return d(r3, r4, r5);
    }

    public static int a(long r6, char[] r8, int r9) {
        if (r6 >= 0) goto L14;
        if (r6 <= f) goto L9;
        return a((int) r6, r8, r9);
    L9:
        if (r6 == Long.MIN_VALUE) goto L11;
        r8[r9] = '-';
        r6 = -r6;
        r9 = r9 + 1;
    L17:
        long r0 = f12015e;
        long r2 = r6 / r0;
        long r7 = r6 - (r2 * r0);
        if (r2 >= r0) goto L20;
        int r10 = b((int) r2, r8, r9);
    L22:
        return c((int) r7, r8, r10);
    L20:
        long r4 = r2 / r0;
        long r3 = r2 - (r0 * r4);
        int r11 = d((int) r4, r8, r9);
        r10 = c((int) r3, r8, r11);
        goto L22
    L11:
        return a(r8, r9);
    L14:
        if (r6 > g) goto L17;
        return a((int) r6, r8, r9);
    }

    public static boolean a(double r1) {
        if (Double.isNaN(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (Double.isInfinite(r1) == true) goto L8;
        return false;
    }

    public static boolean a(float r1) {
        if (Float.isNaN(r1) == false) goto L5;
    L8:
        return true;
    L5:
        if (Float.isInfinite(r1) == true) goto L8;
        return false;
    }

    private static int b(int r4, char[] r5, int r6) {
        if (r4 < f12013c) goto L5;
        int r0 = r4 / 1000;
        int r7 = r4 - (r0 * 1000);
        int r1 = r0 / 1000;
        int r2 = r0 - (r1 * 1000);
        int r8 = d(r1, r5, r6);
        int[] r3 = h;
        int r9 = r3[r2];
        int r10 = r8 + 1;
        r5[r8] = (char) (r9 >> 16);
        int r11 = r10 + 1;
        r5[r10] = (char) ((r9 >> 8) & 127);
        int r12 = r11 + 1;
        r5[r11] = (char) (r9 & 127);
        int r13 = r3[r7];
        int r14 = r12 + 1;
        r5[r12] = (char) (r13 >> 16);
        int r15 = r14 + 1;
        r5[r14] = (char) ((r13 >> 8) & 127);
        int r16 = r15 + 1;
        r5[r15] = (char) (r13 & 127);
        return r16;
    L5:
        if (r4 < 1000) goto L7;
        int r17 = r4 / 1000;
        return a(r5, r6, r17, r4 - (r17 * 1000));
    L7:
        return d(r4, r5, r6);
    }

    private static int c(int r6, char[] r7, int r8) {
        int r0 = r6 / 1000;
        int r9 = r6 - (r0 * 1000);
        int r1 = r0 / 1000;
        int[] r2 = h;
        int r3 = r2[r1];
        int r4 = r8 + 1;
        r7[r8] = (char) (r3 >> 16);
        int r10 = r4 + 1;
        r7[r4] = (char) ((r3 >> 8) & 127);
        int r5 = r10 + 1;
        r7[r10] = (char) (r3 & 127);
        int r11 = r2[r0 - (r1 * 1000)];
        int r12 = r5 + 1;
        r7[r5] = (char) (r11 >> 16);
        int r13 = r12 + 1;
        r7[r12] = (char) ((r11 >> 8) & 127);
        int r14 = r13 + 1;
        r7[r13] = (char) (r11 & 127);
        int r15 = r2[r9];
        int r16 = r14 + 1;
        r7[r14] = (char) (r15 >> 16);
        int r17 = r16 + 1;
        r7[r16] = (char) ((r15 >> 8) & 127);
        int r18 = r17 + 1;
        r7[r17] = (char) (r15 & 127);
        return r18;
    }

    private static int a(char[] r3, int r4, int r5, int r6) {
        int[] r0 = h;
        int r1 = r0[r5];
        if (r5 > 9) goto L5;
    L8:
        int r7 = r4 + 1;
        r3[r4] = (char) (r1 & 127);
        int r8 = r0[r6];
        int r9 = r7 + 1;
        r3[r7] = (char) (r8 >> 16);
        int r10 = r9 + 1;
        r3[r9] = (char) ((r8 >> 8) & 127);
        int r11 = r10 + 1;
        r3[r10] = (char) (r8 & 127);
        return r11;
    L5:
        if (r5 <= 99) goto L7;
        r3[r4] = (char) (r1 >> 16);
        r4 = r4 + 1;
    L7:
        r3[r4] = (char) ((r1 >> 8) & 127);
        r4 = r4 + 1;
        goto L8
    }

    private static int d(int r2, char[] r3, int r4) {
        int r0 = h[r2];
        if (r2 > 9) goto L5;
    L8:
        int r5 = r4 + 1;
        r3[r4] = (char) (r0 & 127);
        return r5;
    L5:
        if (r2 <= 99) goto L7;
        r3[r4] = (char) (r0 >> 16);
        r4 = r4 + 1;
    L7:
        r3[r4] = (char) ((r0 >> 8) & 127);
        r4 = r4 + 1;
        goto L8
    }

    private static int e(int r2, char[] r3, int r4) {
        int r5 = h[r2];
        int r0 = r4 + 1;
        r3[r4] = (char) (r5 >> 16);
        int r6 = r0 + 1;
        r3[r0] = (char) ((r5 >> 8) & 127);
        int r1 = r6 + 1;
        r3[r6] = (char) (r5 & 127);
        return r1;
    }

    private static int a(char[] r3, int r4) {
        String r0 = f12012b;
        int r1 = r0.length();
        r0.getChars(0, r1, r3, r4);
        return r4 + r1;
    }

    private static int b(char[] r3, int r4) {
        String r0 = f12011a;
        int r1 = r0.length();
        r0.getChars(0, r1, r3, r4);
        return r4 + r1;
    }
}
