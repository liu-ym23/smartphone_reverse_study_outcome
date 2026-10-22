package org.c.a.e.a.a.a.a.a.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: PercentEscaper.java */
/* JADX INFO: loaded from: classes5.dex */
public class b extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f40410b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f40411c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f40412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean[] f40413e;

    static {
        f40410b = new char[]{'+'};
        f40411c = "0123456789ABCDEF".toCharArray();
    }

    public b(String r2, boolean r3) {
        if (r2.matches(".*[0-9A-Za-z].*") == true) goto L17;
        if (r3 == false) goto L11;
        if (r2.contains(" ") == false) goto L11;
        throw new IllegalArgumentException("plusForSpace cannot be specified when space is a 'safe' character");
    L11:
        if (r2.contains("%") == true) goto L15;
        this.f40412d = r3;
        this.f40413e = b(r2);
        return;
    L15:
        throw new IllegalArgumentException("The '%' character cannot be specified as 'safe'");
    L17:
        throw new IllegalArgumentException("Alphanumeric characters are always 'safe' and should not be explicitly specified");
    }

    private static boolean[] b(String r6) {
        char[] r7 = r6.toCharArray();
        int r0 = r7.length;
        int r1 = 0;
        int r3 = 0;
        int r4 = 122;
    L3:
        if (r3 >= r0) goto L5;
        r4 = Math.max(r7[r3], r4);
        r3 = r3 + 1;
        goto L3
    L5:
        boolean[] r5 = new boolean[r4 + 1];
        int r8 = 48;
    L7:
        if (r8 > 57) goto L9;
        r5[r8] = true;
        r8 = r8 + 1;
        goto L7
    L9:
        int r9 = 65;
    L11:
        if (r9 > 90) goto L13;
        r5[r9] = true;
        r9 = r9 + 1;
        goto L11
    L13:
        int r10 = 97;
    L14:
        if (r10 > 122) goto L16;
        r5[r10] = true;
        r10 = r10 + 1;
        goto L14
    L16:
        int r2 = r7.length;
    L17:
        if (r1 >= r2) goto L19;
        r5[r7[r1]] = true;
        r1 = r1 + 1;
        goto L17
    L19:
        return r5;
    }

    @Override // org.c.a.e.a.a.a.a.a.a.c
    public int a(CharSequence r4, int r5, int r6) {
        CharSequence r7 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r4, CharSequence.class, "com.obric.aiagent.plugin");
    L3:
        if (r5 >= r6) goto L10;
        char r0 = r7.charAt(r5);
        boolean[] r1 = this.f40413e;
        if (r0 >= r1.length) goto L10;
        if (r1[r0] == false) goto L10;
        r5 = r5 + 1;
    L10:
        return r5;
    }

    @Override // org.c.a.e.a.a.a.a.a.a.c, org.c.a.e.a.a.a.a.a.a.a
    public String a(String r6) {
        int r0 = r6.length();
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L12;
        char r2 = r6.charAt(r1);
        boolean[] r3 = this.f40413e;
        if (r2 >= r3.length) goto L11;
        if (r3[r2] == false) goto L11;
        r1 = r1 + 1;
    L11:
        return a(r6, r1);
    L12:
        return r6;
    }

    @Override // org.c.a.e.a.a.a.a.a.a.c
    public char[] a(int r13) {
        boolean[] r0 = this.f40413e;
        if (r13 >= r0.length) goto L9;
        if (r0[r13] == false) goto L9;
        return null;
    L9:
        if (r13 != 32) goto L15;
        if (this.f40412d == false) goto L15;
        return f40410b;
    L15:
        if (r13 > 127) goto L19;
        char[] r1 = f40411c;
        return new char[]{'%', r1[r13 >>> 4], r1[r13 & 15]};
    L19:
        if (r13 > 2047) goto L23;
        char[] r2 = f40411c;
        char[] r12 = {'%', r2[(r13 >>> 4) | 12], r2[r13 & 15], '%', r2[(r13 & 3) | 8], r2[r13 & 15]};
        int r14 = r13 >>> 4;
        int r15 = r14 >>> 2;
        return r12;
    L23:
        if (r13 > 65535) goto L27;
        char[] r3 = f40411c;
        char[] r16 = {'%', 'E', r3[r13 >>> 2], '%', r3[(r13 & 3) | 8], r3[r13 & 15], '%', r3[(r13 & 3) | 8], r3[r13 & 15]};
        int r17 = r13 >>> 4;
        int r18 = r17 >>> 2;
        int r19 = r18 >>> 4;
        return r16;
    L27:
        if (r13 > 1114111) goto L31;
        char[] r4 = f40411c;
        char[] r110 = {'%', 'F', r4[(r13 >>> 2) & 7], '%', r4[(r13 & 3) | 8], r4[r13 & 15], '%', r4[(r13 & 3) | 8], r4[r13 & 15], '%', r4[(r13 & 3) | 8], r4[r13 & 15]};
        int r111 = r13 >>> 4;
        int r112 = r111 >>> 2;
        int r113 = r112 >>> 4;
        int r114 = r113 >>> 2;
        int r115 = r114 >>> 4;
        return r110;
    L31:
        throw new IllegalArgumentException("Invalid unicode character value " + r13);
    }
}
