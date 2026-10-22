package com.fasterxml.jackson.a.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: compiled from: CharTypes.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static final char[] f11988a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final byte[] f11989b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected static final int[] f11990c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected static final int[] f11991d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected static final int[] f11992e = null;
    protected static final int[] f = null;
    protected static final int[] g = null;
    protected static final int[] h = null;
    protected static final int[] i = null;
    protected static final int[] j = null;

    /* JADX INFO: compiled from: CharTypes.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11993a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int[][] f11994b;

        private a() {
            this.f11994b = new int[128][];
        }

        static {
            f11993a = new a();
        }

        public int[] a(int r3) {
            int[] r0 = this.f11994b[r3];
            if (r0 != null) goto L8;
            r0 = Arrays.copyOf(b.i, 128);
            if (r0[r3] != 0) goto L7;
            r0[r3] = -1;
        L7:
            this.f11994b[r3] = r0;
        L8:
            return r0;
        }
    }

    static {
        char[] r0 = "0123456789ABCDEF".toCharArray();
        f11988a = r0;
        int r1 = r0.length;
        f11989b = new byte[r1];
        int r2 = 0;
        int r3 = 0;
    L3:
        if (r3 >= r1) goto L5;
        f11989b[r3] = (byte) f11988a[r3];
        r3 = r3 + 1;
        goto L3
    L5:
        int[] r4 = new int[256];
        int r5 = 0;
    L7:
        if (r5 >= 32) goto L9;
        r4[r5] = -1;
        r5 = r5 + 1;
        goto L7
    L9:
        r4[34] = 1;
        r4[92] = 1;
        f11990c = r4;
        int r8 = r4.length;
        int[] r9 = new int[r8];
        System.arraycopy(r4, 0, r9, 0, r8);
        int r10 = 128;
    L10:
        if (r10 >= 256) goto L22;
        if ((r10 & 224) != 192) goto L15;
        int r11 = 2;
    L21:
        r9[r10] = r11;
        r10 = r10 + 1;
        goto L10
    L15:
        if ((r10 & 240) != 224) goto L18;
        r11 = 3;
        goto L21
    L18:
        if ((r10 & 248) != 240) goto L20;
        r11 = 4;
        goto L21
    L20:
        r11 = -1;
        goto L21
    L22:
        f11991d = r9;
        int[] r12 = new int[256];
        Arrays.fill(r12, -1);
        int r13 = 33;
    L23:
        if (r13 >= 256) goto L28;
        if (Character.isJavaIdentifierPart((char) r13) == false) goto L27;
        r12[r13] = 0;
    L27:
        r13 = r13 + 1;
        goto L23
    L28:
        r12[64] = 0;
        r12[35] = 0;
        r12[42] = 0;
        r12[45] = 0;
        r12[43] = 0;
        f11992e = r12;
        int[] r14 = new int[256];
        System.arraycopy(r12, 0, r14, 0, 256);
        Arrays.fill(r14, 128, 128, 0);
        f = r14;
        int[] r15 = new int[256];
        int[] r16 = f11991d;
        System.arraycopy(r16, 128, r15, 128, 128);
        Arrays.fill(r15, 0, 32, -1);
        r15[9] = 0;
        r15[10] = 10;
        r15[13] = 13;
        r15[42] = 42;
        g = r15;
        int[] r17 = new int[256];
        System.arraycopy(r16, 128, r17, 128, 128);
        Arrays.fill(r17, 0, 32, -1);
        r17[32] = 1;
        r17[9] = 1;
        r17[10] = 10;
        r17[13] = 13;
        r17[47] = 47;
        r17[35] = 35;
        h = r17;
        int[] r6 = new int[128];
        int r7 = 0;
    L29:
        if (r7 >= 32) goto L31;
        r6[r7] = -1;
        r7 = r7 + 1;
        goto L29
    L31:
        r6[34] = 34;
        r6[92] = 92;
        r6[8] = 98;
        r6[9] = 116;
        r6[12] = 102;
        r6[10] = 110;
        r6[13] = 114;
        i = r6;
        int[] r18 = new int[256];
        j = r18;
        Arrays.fill(r18, -1);
        int r19 = 0;
    L32:
        if (r19 >= 10) goto L35;
        j[r19 + 48] = r19;
        r19 = r19 + 1;
    L35:
        if (r2 >= 6) goto L37;
        int[] r20 = j;
        int r21 = r2 + 10;
        r20[r2 + 97] = r21;
        r20[r2 + 65] = r21;
        r2 = r2 + 1;
        goto L35
    }

    public static int[] a() {
        return f11990c;
    }

    public static int[] b() {
        return f11992e;
    }

    public static int[] c() {
        return i;
    }

    public static int[] a(int r1) {
        if (r1 != 34) goto L7;
        return i;
    L7:
        return a.f11993a.a(r1);
    }

    public static int b(int r1) {
        return j[r1 & 255];
    }

    public static char c(int r1) {
        return f11988a[r1];
    }

    public static void a(StringBuilder r7, String r8) {
        int[] r0 = i;
        int r1 = r0.length;
        int r2 = r8.length();
        int r3 = 0;
    L3:
        if (r3 >= r2) goto L15;
        char r4 = r8.charAt(r3);
        if (r4 < r1) goto L7;
    L13:
        r7.append(r4);
    L14:
        r3 = r3 + 1;
        goto L3
    L7:
        if (r0[r4] == 0) goto L13;
        r7.append('\\');
        int r5 = r0[r4];
        if (r5 >= 0) goto L12;
        r7.append('u');
        r7.append('0');
        r7.append('0');
        char[] r6 = f11988a;
        r7.append(r6[r4 >> 4]);
        r7.append(r6[r4 & 15]);
        goto L14
    L12:
        r7.append((char) r5);
        goto L14
    }

    public static char[] d() {
        return (char[]) ZeusTransformUtils.preCheckCast((char[]) ZeusTransformUtils.preCheckCast(f11988a.clone(), char[].class, "com.obric.aiagent.plugin"), char[].class, "com.obric.aiagent.plugin");
    }

    public static byte[] e() {
        return (byte[]) ZeusTransformUtils.preCheckCast((byte[]) ZeusTransformUtils.preCheckCast(f11989b.clone(), byte[].class, "com.obric.aiagent.plugin"), byte[].class, "com.obric.aiagent.plugin");
    }
}
