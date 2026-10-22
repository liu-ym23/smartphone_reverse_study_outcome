package com.fasterxml.jackson.a.d;

import com.bytedance.keva.KevaImpl;
import java.math.BigDecimal;

/* JADX INFO: compiled from: NumberInput.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final String f12009a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final String f12010b = null;

    static {
        f12009a = String.valueOf(Long.MIN_VALUE).substring(1);
        f12010b = String.valueOf(Long.MAX_VALUE);
    }

    public static int a(char[] r2, int r3, int r4) {
        int r0 = r2[(r3 + r4) - 1] - '0';
        switch(r4) {
            case 2: goto L13;
            case 3: goto L11;
            case 4: goto L10;
            case 5: goto L9;
            case 6: goto L8;
            case 7: goto L7;
            case 8: goto L6;
            case 9: goto L5;
            default: goto L14;
        };
    L5:
        r0 = r0 + ((r2[r3] - '0') * 100000000);
        r3 = r3 + 1;
    L6:
        r0 = r0 + ((r2[r3] - '0') * 10000000);
        r3 = r3 + 1;
    L7:
        r0 = r0 + ((r2[r3] - '0') * 1000000);
        r3 = r3 + 1;
    L8:
        r0 = r0 + ((r2[r3] - '0') * 100000);
        r3 = r3 + 1;
    L9:
        r0 = r0 + ((r2[r3] - '0') * KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD);
        r3 = r3 + 1;
    L10:
        r0 = r0 + ((r2[r3] - '0') * 1000);
        r3 = r3 + 1;
    L11:
        r0 = r0 + ((r2[r3] - '0') * 100);
        r3 = r3 + 1;
        goto L13
    L14:
        return r0;
    L13:
        return r0 + ((r2[r3] - '0') * 10);
    }

    public static int a(String r9) {
        boolean r0 = false;
        char r1 = r9.charAt(0);
        int r2 = r9.length();
        int r3 = 1;
        if (r1 != '-') goto L6;
        r0 = true;
    L6:
        if (r0 == false) goto L14;
        if (r2 == 1) goto L12;
        if (r2 > 10) goto L12;
        r3 = 2;
        r1 = r9.charAt(1);
    L18:
        if (r1 > '9') goto L54;
        if (r1 < '0') goto L54;
        int r4 = r1 - '0';
        if (r3 >= r2) goto L50;
        int r7 = r3 + 1;
        char r5 = r9.charAt(r3);
        if (r5 > '9') goto L49;
        if (r5 < '0') goto L49;
        r4 = (r4 * 10) + (r5 - '0');
        if (r7 >= r2) goto L50;
        int r6 = r7 + 1;
        char r8 = r9.charAt(r7);
        if (r8 > '9') goto L47;
        if (r8 < '0') goto L47;
        r4 = (r4 * 10) + (r8 - '0');
        if (r6 >= r2) goto L50;
    L36:
        int r10 = r6 + 1;
        char r11 = r9.charAt(r6);
        if (r11 > '9') goto L45;
        if (r11 < '0') goto L45;
        r4 = (r4 * 10) + (r11 - '0');
        if (r10 >= r2) goto L50;
        r6 = r10;
    L45:
        return Integer.parseInt(r9);
    L47:
        return Integer.parseInt(r9);
    L49:
        return Integer.parseInt(r9);
    L50:
        if (r0 == true) goto L52;
        return r4;
    L52:
        return -r4;
    L54:
        return Integer.parseInt(r9);
    L12:
        return Integer.parseInt(r9);
    L14:
        if (r2 <= 9) goto L18;
        return Integer.parseInt(r9);
    }

    public static long b(char[] r5, int r6, int r7) {
        int r8 = r7 - 9;
        return (((long) a(r5, r6, r8)) * 1000000000) + ((long) a(r5, r6 + r8, 9));
    }

    public static long b(String r2) {
        if (r2.length() > 9) goto L7;
        return a(r2);
    L7:
        return Long.parseLong(r2);
    }

    public static boolean a(char[] r5, int r6, int r7, boolean r8) {
        if (r8 == false) goto L4;
        String r9 = f12009a;
    L5:
        int r0 = r9.length();
        if (r7 >= r0) goto L9;
        return true;
    L9:
        if (r7 <= r0) goto L11;
        return false;
    L11:
        int r10 = 0;
    L12:
        if (r10 >= r0) goto L20;
        int r3 = r5[r6 + r10] - r9.charAt(r10);
        if (r3 != 0) goto L15;
        r10 = r10 + 1;
        goto L12
    L15:
        if (r3 >= 0) goto L18;
        return true;
    L18:
        return false;
    L20:
        return true;
    L4:
        r9 = f12010b;
        goto L5
    }

    public static boolean a(String r6, boolean r7) {
        if (r7 == false) goto L4;
        String r8 = f12009a;
    L5:
        int r0 = r8.length();
        int r1 = r6.length();
        if (r1 >= r0) goto L9;
        return true;
    L9:
        if (r1 <= r0) goto L11;
        return false;
    L11:
        int r2 = 0;
    L12:
        if (r2 >= r0) goto L20;
        int r4 = r6.charAt(r2) - r8.charAt(r2);
        if (r4 != 0) goto L15;
        r2 = r2 + 1;
        goto L12
    L15:
        if (r4 >= 0) goto L18;
        return true;
    L18:
        return false;
    L20:
        return true;
    L4:
        r8 = f12010b;
        goto L5
    }

    public static int a(String r5, int r6) {
        if (r5 != null) goto L4;
        return r6;
    L4:
        String r7 = r5.trim();
        int r0 = r7.length();
        if (r0 != 0) goto L7;
        return r6;
    L7:
        int r1 = 0;
        char r2 = r7.charAt(0);
        if (r2 != '+') goto L11;
        r7 = r7.substring(1);
        r0 = r7.length();
    L13:
        if (r1 >= r0) goto L27;
        char r3 = r7.charAt(r1);
        if (r3 <= '9') goto L17;
    L29:
        return (int) c(r7);
    L23:
        return r6;
    L17:
        if (r3 < '0') goto L29;
        r1 = r1 + 1;
        goto L13
    L27:
        return Integer.parseInt(r7);
    L26:
        return r6;
    L11:
        if (r2 != '-') goto L13;
        r1 = 1;
        goto L13
    }

    public static long a(String r5, long r6) {
        if (r5 != null) goto L4;
        return r6;
    L4:
        String r7 = r5.trim();
        int r0 = r7.length();
        if (r0 != 0) goto L7;
        return r6;
    L7:
        int r1 = 0;
        char r2 = r7.charAt(0);
        if (r2 != '+') goto L11;
        r7 = r7.substring(1);
        r0 = r7.length();
    L13:
        if (r1 >= r0) goto L27;
        char r3 = r7.charAt(r1);
        if (r3 <= '9') goto L17;
    L29:
        return (long) c(r7);
    L23:
        return r6;
    L17:
        if (r3 < '0') goto L29;
        r1 = r1 + 1;
        goto L13
    L27:
        return Long.parseLong(r7);
    L26:
        return r6;
    L11:
        if (r2 != '-') goto L13;
        r1 = 1;
        goto L13
    }

    public static double c(String r2) {
        if ("2.2250738585072012e-308".equals(r2) == false) goto L7;
        return Double.MIN_VALUE;
    L7:
        return Double.parseDouble(r2);
    }

    public static BigDecimal d(String r0) {
        return a.a(r0);
    }

    public static BigDecimal c(char[] r0, int r1, int r2) {
        return a.a(r0, r1, r2);
    }

    public static BigDecimal a(char[] r0) {
        return a.a(r0);
    }
}
