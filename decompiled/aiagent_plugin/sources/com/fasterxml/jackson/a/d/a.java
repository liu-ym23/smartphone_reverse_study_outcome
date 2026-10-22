package com.fasterxml.jackson.a.d;

import java.math.BigDecimal;
import java.util.Arrays;

/* JADX INFO: compiled from: BigDecimalParser.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final char[] f11987a;

    a(char[] r1) {
        this.f11987a = r1;
    }

    public static BigDecimal a(String r0) {
        return a(r0.toCharArray());
    }

    public static BigDecimal a(char[] r1, int r2, int r3) {
        if (r2 <= 0) goto L4;
    L5:
        r1 = Arrays.copyOfRange(r1, r2, r3 + r2);
    L7:
        return a(r1);
    L4:
        if (r3 == r1.length) goto L7;
        goto L5
    }

    public static BigDecimal a(char[] r5) {
        int r0 = r5.length;
        if (r0 >= 500) goto L7;
        return new BigDecimal(r5);
    L7:
        return new a(r5).a(r0 / 10);
    L8:
        e = move-exception;
        String r1 = e.getMessage();
        if (r1 != null) goto L13;
        r1 = "Not a valid number representation";
    L13:
        if (r5.length > 1000) goto L15;
        String r2 = new String(r5);
    L17:
        throw new NumberFormatException("Value \"" + r2 + "\" can not be represented as `java.math.BigDecimal`, reason: " + r1);
    L15:
        r2 = new String(Arrays.copyOfRange(r5, 0, 1000)) + "(truncated, full length is " + r5.length + " chars)";
        goto L17
    }

    private BigDecimal a(int r17) {
        int r2 = this.f11987a.length;
        int r6 = -1;
        int r8 = -1;
        int r5 = 0;
        int r7 = 0;
        boolean r9 = false;
        boolean r10 = false;
        int r11 = 0;
        boolean r12 = false;
    L3:
        if (r5 >= r2) goto L44;
        char r14 = this.f11987a[r5];
        if (r14 != '+') goto L7;
        if (r6 < 0) goto L39;
        if (r10 == true) goto L38;
    L36:
        r10 = true;
    L41:
        r5 = r5 + 1;
        goto L3
    L38:
        throw new NumberFormatException("Multiple signs in exponent");
    L39:
        if (r9 == true) goto L43;
        r11 = r5 + 1;
        r9 = true;
        goto L41
    L43:
        throw new NumberFormatException("Multiple signs in number");
    L7:
        if (r14 != 'E') goto L9;
    L30:
        if (r6 >= 0) goto L33;
        r6 = r5;
        goto L41
    L33:
        throw new NumberFormatException("Multiple exponent markers");
    L9:
        if (r14 == 'e') goto L30;
        if (r14 != '-') goto L13;
        if (r6 < 0) goto L26;
        if (r10 == false) goto L36;
        throw new NumberFormatException("Multiple signs in exponent");
    L26:
        if (r9 == true) goto L29;
        r11 = r5 + 1;
        r9 = true;
        r12 = true;
        goto L41
    L29:
        throw new NumberFormatException("Multiple signs in number");
    L13:
        if (r14 == '.') goto L17;
        if (r8 < 0) goto L41;
        if (r6 != (-1)) goto L41;
        r7 = r7 + 1;
        goto L41
    L17:
        if (r8 >= 0) goto L20;
        r8 = r5;
        goto L41
    L20:
        throw new NumberFormatException("Multiple decimal points");
    L44:
        if (r6 < 0) goto L46;
        int r13 = 1;
        int r4 = Integer.parseInt(new String(this.f11987a, r6 + 1, (r2 - r6) - 1));
        r7 = a(r7, r4);
        r2 = r6;
    L47:
        if (r8 < 0) goto L49;
        int r3 = (r2 - r8) - r13;
        BigDecimal r0 = a(r11, r8 - r11, r4, r17).add(a(r8 + r13, r3, r4 - r3, r17));
    L50:
        if (r7 == 0) goto L52;
        r0 = r0.setScale(r7);
    L52:
        if (r12 == true) goto L54;
        return r0;
    L54:
        return r0.negate();
    L49:
        r0 = a(r11, r2 - r11, r4, r17);
        goto L50
    L46:
        r13 = 1;
        r4 = 0;
        goto L47
    }

    private int a(int r5, long r6) {
        long r0 = ((long) r5) - r6;
        if (r0 > 2147483647L) goto L9;
        if (r0 < (-2147483648L)) goto L9;
        return (int) r0;
    L9:
        throw new NumberFormatException("Scale out of range: " + r0 + " while adjusting scale " + r5 + " to exponent " + r6);
    }

    private BigDecimal a(int r3, int r4, int r5, int r6) {
        if (r4 <= r6) goto L5;
        int r0 = r4 / 2;
        return a(r3, r0, (r5 + r4) - r0, r6).add(a(r3 + r0, r4 - r0, r5, r6));
    L5:
        if (r4 != 0) goto L8;
        return BigDecimal.ZERO;
    L8:
        return new BigDecimal(this.f11987a, r3, r4).movePointRight(r5);
    }
}
