package x2;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f13722a = (char[]) a.f13703a.clone();

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f13723b = (byte[]) a.f13704b.clone();

    /* renamed from: c, reason: collision with root package name */
    public static final c f13724c = new c();

    public static int a(int i10, int i11) {
        if (i11 >= 56320 && i11 <= 57343) {
            return (i11 - 56320) + ((i10 - 55296) << 10) + 65536;
        }
        throw new IllegalArgumentException("Broken surrogate pair: first char 0x" + Integer.toHexString(i10) + ", second 0x" + Integer.toHexString(i11) + "; illegal combination");
    }

    public static void b(int i10) {
        throw new IllegalArgumentException(h.a(i10));
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00fe, code lost:
    
        if (r7 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0104, code lost:
    
        return java.util.Arrays.copyOfRange(r2, 0, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0105, code lost:
    
        r7.f18e = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x010b, code lost:
    
        return r7.P();
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] c(java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.c.c(java.lang.String):byte[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        r6 = new char[]{'\\', 0, '0', '0', 0, 0};
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x002d, code lost:
    
        r11 = r7 + 1;
        r7 = r14.charAt(r7);
        r12 = r1[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0036, code lost:
    
        if (r12 >= 0) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0038, code lost:
    
        r6[1] = 'u';
        r12 = x2.c.f13722a;
        r6[4] = r12[r7 >> 4];
        r6[5] = r12[r7 & 15];
        r9 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004e, code lost:
    
        r6[1] = (char) r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0051, code lost:
    
        r7 = r8 + r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0054, code lost:
    
        if (r7 <= r0.length) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
    
        r7 = r0.length - r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
    
        if (r7 <= 0) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        java.lang.System.arraycopy(r6, 0, r0, r8, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005d, code lost:
    
        if (r5 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005f, code lost:
    
        r5 = new a3.i(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0064, code lost:
    
        r0 = r5.k();
        r9 = r9 - r7;
        java.lang.System.arraycopy(r6, r7, r0, 0, r9);
        r8 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x006e, code lost:
    
        java.lang.System.arraycopy(r6, 0, r0, r8, r9);
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001c, code lost:
    
        r9 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        if (r6 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static char[] d(java.lang.String r14) {
        /*
            r0 = 30
            char[] r0 = new char[r0]
            int[] r1 = x2.a.h
            int r2 = r1.length
            int r3 = r14.length()
            r4 = 0
            r5 = 0
            r7 = r4
            r8 = r7
            r6 = r5
        L10:
            if (r7 >= r3) goto L8f
        L12:
            char r9 = r14.charAt(r7)
            if (r9 >= r2) goto L74
            r10 = r1[r9]
            if (r10 == 0) goto L74
            r9 = 2
            r10 = 6
            if (r6 != 0) goto L2d
            char[] r6 = new char[r10]
            r11 = 92
            r6[r4] = r11
            r11 = 48
            r6[r9] = r11
            r12 = 3
            r6[r12] = r11
        L2d:
            int r11 = r7 + 1
            char r7 = r14.charAt(r7)
            r12 = r1[r7]
            r13 = 1
            if (r12 >= 0) goto L4e
            r9 = 117(0x75, float:1.64E-43)
            r6[r13] = r9
            int r9 = r7 >> 4
            char[] r12 = x2.c.f13722a
            char r9 = r12[r9]
            r13 = 4
            r6[r13] = r9
            r7 = r7 & 15
            char r7 = r12[r7]
            r9 = 5
            r6[r9] = r7
            r9 = r10
            goto L51
        L4e:
            char r7 = (char) r12
            r6[r13] = r7
        L51:
            int r7 = r8 + r9
            int r10 = r0.length
            if (r7 <= r10) goto L6e
            int r7 = r0.length
            int r7 = r7 - r8
            if (r7 <= 0) goto L5d
            java.lang.System.arraycopy(r6, r4, r0, r8, r7)
        L5d:
            if (r5 != 0) goto L64
            a3.i r5 = new a3.i
            r5.<init>(r0)
        L64:
            char[] r0 = r5.k()
            int r9 = r9 - r7
            java.lang.System.arraycopy(r6, r7, r0, r4, r9)
            r8 = r9
            goto L72
        L6e:
            java.lang.System.arraycopy(r6, r4, r0, r8, r9)
            r8 = r7
        L72:
            r7 = r11
            goto L10
        L74:
            int r10 = r0.length
            if (r8 < r10) goto L83
            if (r5 != 0) goto L7e
            a3.i r5 = new a3.i
            r5.<init>(r0)
        L7e:
            char[] r0 = r5.k()
            r8 = r4
        L83:
            int r10 = r8 + 1
            r0[r8] = r9
            int r7 = r7 + 1
            if (r7 < r3) goto L8d
            r8 = r10
            goto L8f
        L8d:
            r8 = r10
            goto L12
        L8f:
            if (r5 != 0) goto L96
            char[] r14 = java.util.Arrays.copyOfRange(r0, r4, r8)
            return r14
        L96:
            r5.f31i = r8
            char[] r14 = r5.e()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.c.d(java.lang.String):char[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:71:0x014d, code lost:
    
        if (r6 != null) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0153, code lost:
    
        return java.util.Arrays.copyOfRange(r1, 0, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0154, code lost:
    
        r6.f18e = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x015a, code lost:
    
        return r6.P();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] e(java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.c.e(java.lang.String):byte[]");
    }
}
