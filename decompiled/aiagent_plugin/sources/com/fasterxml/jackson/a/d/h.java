package com.fasterxml.jackson.a.d;

import com.fasterxml.jackson.a.h.o;
import java.util.Arrays;

/* JADX INFO: compiled from: JsonStringEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f12006a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f12007b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final h f12008c = null;

    private char[] b() {
        return new char[]{'\\', 0, '0', '0', 0, 0};
    }

    static {
        f12006a = b.d();
        f12007b = b.e();
        f12008c = new h();
    }

    public h() {
    }

    public static h a() {
        return f12008c;
    }

    public char[] a(String r13) {
        int r0 = r13.length();
        char[] r1 = new char[a(r0)];
        int[] r2 = b.c();
        int r3 = r2.length;
        o r4 = null;
        char[] r6 = null;
        int r7 = 0;
        int r8 = 0;
    L3:
        if (r7 >= r0) goto L33;
    L4:
        char r9 = r13.charAt(r7);
        if (r9 >= r3) goto L25;
        if (r2[r9] == 0) goto L25;
        if (r6 != null) goto L10;
        r6 = b();
    L10:
        int r10 = r7 + 1;
        char r11 = r13.charAt(r7);
        int r12 = r2[r11];
        if (r12 >= 0) goto L13;
        int r14 = a(r11, r6);
    L14:
        int r15 = r8 + r14;
        if (r15 <= r1.length) goto L22;
        int r16 = r1.length - r8;
        if (r16 <= 0) goto L19;
        System.arraycopy(r6, 0, r1, r8, r16);
    L19:
        if (r4 != null) goto L21;
        r4 = o.a(r1);
    L21:
        r1 = r4.l();
        int r17 = r14 - r16;
        System.arraycopy(r6, r16, r1, 0, r17);
        r8 = r17;
    L23:
        r7 = r10;
        goto L3
    L22:
        System.arraycopy(r6, 0, r1, r8, r14);
        r8 = r15;
        goto L23
    L13:
        r14 = b(r12, r6);
    L25:
        if (r8 < r1.length) goto L29;
        if (r4 != null) goto L28;
        r4 = o.a(r1);
    L28:
        r1 = r4.l();
        r8 = 0;
    L29:
        int r18 = r8 + 1;
        r1[r8] = r9;
        r7 = r7 + 1;
        if (r7 >= r0) goto L31;
        r8 = r18;
        goto L4
    L31:
        r8 = r18;
    L33:
        if (r4 == null) goto L35;
        r4.a(r8);
        return r4.f();
    L35:
        return Arrays.copyOfRange(r1, 0, r8);
    }

    private int a(int r3, char[] r4) {
        r4[1] = 'u';
        char[] r2 = f12006a;
        r4[4] = r2[r3 >> 4];
        r4[5] = r2[r3 & 15];
        return 6;
    }

    private int b(int r1, char[] r2) {
        r2[1] = (char) r1;
        return 2;
    }

    static int a(int r2) {
        return Math.min(Math.max(16, r2 + Math.min((r2 >> 3) + 6, 1000)), 32000);
    }
}
