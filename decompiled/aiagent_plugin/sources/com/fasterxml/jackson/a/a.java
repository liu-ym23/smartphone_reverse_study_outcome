package com.fasterxml.jackson.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: Base64Variant.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f11964a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final transient int[] f11965b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final transient char[] f11966c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final transient byte[] f11967d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final char f11968e;
    private final int f;
    private final boolean g;
    private final EnumC0265a h;

    /* JADX INFO: renamed from: com.fasterxml.jackson.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Base64Variant.java */
    public static final enum EnumC0265a extends Enum<EnumC0265a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0265a f11969a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0265a f11970b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0265a f11971c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumC0265a[] f11972d = null;

        private EnumC0265a(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumC0265a valueOf(String r2) {
            return (EnumC0265a) ZeusTransformUtils.preCheckCast(Enum.valueOf(EnumC0265a.class, r2), EnumC0265a.class, "com.obric.aiagent.plugin");
        }

        public static EnumC0265a[] values() {
            return (EnumC0265a[]) ZeusTransformUtils.preCheckCast(f11972d.clone(), EnumC0265a[].class, "com.obric.aiagent.plugin");
        }

        static {
            EnumC0265a r0 = new EnumC0265a("PADDING_FORBIDDEN", 0);
            f11969a = r0;
            EnumC0265a r1 = new EnumC0265a("PADDING_REQUIRED", 1);
            f11970b = r1;
            EnumC0265a r3 = new EnumC0265a("PADDING_ALLOWED", 2);
            f11971c = r3;
            f11972d = new EnumC0265a[]{r0, r1, r3};
        }
    }

    public a(String r5, String r6, boolean r7, char r8, int r9) {
        int[] r0 = new int[128];
        this.f11965b = r0;
        char[] r2 = new char[64];
        this.f11966c = r2;
        this.f11967d = new byte[64];
        this.f11964a = r5;
        this.g = r7;
        this.f11968e = r8;
        this.f = r9;
        int r10 = r6.length();
        if (r10 != 64) goto L15;
        int r11 = 0;
        r6.getChars(0, r10, r2, 0);
        Arrays.fill(r0, -1);
    L5:
        if (r11 >= r10) goto L7;
        char r12 = this.f11966c[r11];
        this.f11967d[r11] = (byte) r12;
        this.f11965b[r12] = r11;
        r11 = r11 + 1;
        goto L5
    L7:
        if (r7 == false) goto L9;
        this.f11965b[r8] = -2;
    L9:
        if (r7 == false) goto L11;
        EnumC0265a r13 = EnumC0265a.f11970b;
    L12:
        this.h = r13;
        return;
    L11:
        r13 = EnumC0265a.f11969a;
        goto L12
    L15:
        throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + r10 + ")");
    }

    public a(a r7, String r8, int r9) {
        this(r7, r8, r7.g, r7.f11968e, r9);
    }

    public a(a r8, String r9, boolean r10, char r11, int r12) {
        this(r8, r9, r10, r11, r8.h, r12);
    }

    private a(a r6, String r7, boolean r8, char r9, EnumC0265a r10, int r11) {
        int[] r0 = new int[128];
        this.f11965b = r0;
        char[] r2 = new char[64];
        this.f11966c = r2;
        byte[] r1 = new byte[64];
        this.f11967d = r1;
        this.f11964a = r7;
        byte[] r12 = r6.f11967d;
        System.arraycopy(r12, 0, r1, 0, r12.length);
        char[] r13 = r6.f11966c;
        System.arraycopy(r13, 0, r2, 0, r13.length);
        int[] r14 = r6.f11965b;
        System.arraycopy(r14, 0, r0, 0, r14.length);
        this.g = r8;
        this.f11968e = r9;
        this.f = r11;
        this.h = r10;
    }

    public String a() {
        return this.f11964a;
    }

    public boolean b() {
        return this.g;
    }

    public boolean c() {
        if (this.h != EnumC0265a.f11970b) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean d() {
        if (this.h == EnumC0265a.f11969a) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean a(char r1) {
        if (r1 != this.f11968e) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean a(int r1) {
        if (r1 != this.f11968e) goto L5;
        return true;
    L5:
        return false;
    }

    public char e() {
        return this.f11968e;
    }

    public int f() {
        return this.f;
    }

    public int b(char r2) {
        if (r2 <= 127) goto L7;
        return -1;
    L7:
        return this.f11965b[r2];
    }

    public int a(int r3, char[] r4, int r5) {
        int r0 = r5 + 1;
        char[] r2 = this.f11966c;
        r4[r5] = r2[(r3 >> 18) & 63];
        int r6 = r0 + 1;
        r4[r0] = r2[(r3 >> 12) & 63];
        int r1 = r6 + 1;
        r4[r6] = r2[(r3 >> 6) & 63];
        int r7 = r1 + 1;
        r4[r1] = r2[r3 & 63];
        return r7;
    }

    public void a(StringBuilder r3, int r4) {
        r3.append(this.f11966c[(r4 >> 18) & 63]);
        r3.append(this.f11966c[(r4 >> 12) & 63]);
        r3.append(this.f11966c[(r4 >> 6) & 63]);
        r3.append(this.f11966c[r4 & 63]);
    }

    public int a(int r4, int r5, char[] r6, int r7) {
        int r0 = r7 + 1;
        char[] r1 = this.f11966c;
        r6[r7] = r1[(r4 >> 18) & 63];
        int r8 = r0 + 1;
        r6[r0] = r1[(r4 >> 12) & 63];
        if (b() == false) goto L9;
        int r2 = r8 + 1;
        if (r5 != 2) goto L7;
        char r9 = this.f11966c[(r4 >> 6) & 63];
    L8:
        r6[r8] = r9;
        int r10 = r2 + 1;
        r6[r2] = this.f11968e;
        return r10;
    L7:
        r9 = this.f11968e;
        goto L8
    L9:
        if (r5 != 2) goto L13;
        int r11 = r8 + 1;
        r6[r8] = this.f11966c[(r4 >> 6) & 63];
        return r11;
    L13:
        return r8;
    }

    public void a(StringBuilder r3, int r4, int r5) {
        r3.append(this.f11966c[(r4 >> 18) & 63]);
        r3.append(this.f11966c[(r4 >> 12) & 63]);
        if (b() == false) goto L8;
        if (r5 != 2) goto L6;
        char r6 = this.f11966c[(r4 >> 6) & 63];
    L7:
        r3.append(r6);
        r3.append(this.f11968e);
        return;
    L6:
        r6 = this.f11968e;
        goto L7
    L8:
        if (r5 != 2) goto L12;
        r3.append(this.f11966c[(r4 >> 6) & 63]);
        return;
    }

    public String a(byte[] r2) {
        return a(r2, false);
    }

    public String a(byte[] r10, boolean r11) {
        int r0 = r10.length;
        StringBuilder r1 = new StringBuilder(((r0 >> 2) + r0) + (r0 >> 3));
        if (r11 == false) goto L5;
        r1.append('\"');
    L5:
        int r3 = f() >> 2;
        int r5 = 0;
        int r6 = r0 - 3;
    L6:
        if (r5 > r6) goto L11;
        int r7 = r5 + 1;
        int r8 = r7 + 1;
        int r9 = ((r10[r5] << 8) | (r10[r7] & 255)) << 8;
        int r12 = r8 + 1;
        a(r1, r9 | (r10[r8] & 255));
        r3 = r3 - 1;
        if (r3 > 0) goto L10;
        r1.append('\\');
        r1.append('n');
        r3 = f() >> 2;
    L10:
        r5 = r12;
        goto L6
    L11:
        int r2 = r0 - r5;
        if (r2 <= 0) goto L17;
        int r4 = r5 + 1;
        int r13 = r10[r5] << 16;
        if (r2 != 2) goto L16;
        r13 = r13 | ((r10[r4] & 255) << 8);
    L16:
        a(r1, r13, r2);
    L17:
        if (r11 == false) goto L20;
        r1.append('\"');
    L20:
        return r1.toString();
    }

    public byte[] a(String r2) {
        com.fasterxml.jackson.a.h.c r0 = new com.fasterxml.jackson.a.h.c();
        a(r2, r0);
        return r0.b();
    }

    public void a(String r11, com.fasterxml.jackson.a.h.c r12) {
        int r0 = r11.length();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L61;
        int r3 = r2 + 1;
        char r4 = r11.charAt(r2);
        if (r4 <= ' ') goto L50;
        int r5 = b(r4);
        if (r5 >= 0) goto L10;
        a(r4, 0, null);
    L10:
        if (r3 < r0) goto L12;
        g();
    L12:
        int r6 = r3 + 1;
        char r7 = r11.charAt(r3);
        int r8 = b(r7);
        if (r8 >= 0) goto L15;
        a(r7, 1, null);
    L15:
        int r9 = (r5 << 6) | r8;
        if (r6 >= r0) goto L18;
    L21:
        int r10 = r6 + 1;
        char r13 = r11.charAt(r6);
        int r14 = b(r13);
        if (r14 < 0) goto L23;
        int r15 = (r9 << 6) | r14;
        if (r10 >= r0) goto L37;
    L41:
        r3 = r10 + 1;
        char r16 = r11.charAt(r10);
        int r17 = b(r16);
        if (r17 >= 0) goto L49;
        if (r17 == (-2)) goto L46;
        a(r16, 3, null);
    L46:
        if (d() == true) goto L48;
        h();
    L48:
        r12.b(r15 >> 2);
        goto L50
    L49:
        r12.c((r15 << 6) | r17);
        goto L50
    L37:
        if (c() == false) goto L38;
        g();
        goto L41
    L38:
        r12.b(r15 >> 2);
        return;
    L23:
        if (r14 == (-2)) goto L26;
        a(r13, 2, null);
    L26:
        if (d() == true) goto L28;
        h();
    L28:
        if (r10 < r0) goto L30;
        g();
    L30:
        r2 = r10 + 1;
        char r18 = r11.charAt(r10);
        if (a(r18) == true) goto L33;
        a(r18, 3, "expected padding character '" + e() + "'");
    L33:
        r12.a(r9 >> 4);
        goto L3
    L18:
        if (c() == false) goto L19;
        g();
        goto L21
    L19:
        r12.a(r9 >> 4);
        return;
    L50:
        r2 = r3;
        goto L3
    }

    public String toString() {
        return this.f11964a;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L23:
        return false;
    L8:
        if (r5.getClass() != getClass()) goto L23;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
        if (r6.f11968e != this.f11968e) goto L22;
        if (r6.f != this.f) goto L22;
        if (r6.g != this.g) goto L22;
        if (r6.h != this.h) goto L22;
        if (this.f11964a.equals(r6.f11964a) == false) goto L22;
        return true;
    L22:
        return false;
    }

    public int hashCode() {
        return this.f11964a.hashCode();
    }

    public void a(char r2, int r3, String r4) {
        if (r2 > ' ') goto L6;
        String r1 = "Illegal white space character (code 0x" + Integer.toHexString(r2) + ") as character #" + (r3 + 1) + " of 4-char base64 unit: can only used between units";
    L15:
        if (r4 == null) goto L18;
        r1 = r1 + ": " + r4;
    L18:
        throw new IllegalArgumentException(r1);
    L6:
        if (a(r2) == false) goto L9;
        r1 = "Unexpected padding character ('" + e() + "') as character #" + (r3 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
        goto L15
    L9:
        if (Character.isDefined(r2) == true) goto L11;
    L14:
        r1 = "Illegal character (code 0x" + Integer.toHexString(r2) + ") in base64 content";
        goto L15
    L11:
        if (Character.isISOControl(r2) == true) goto L14;
        r1 = "Illegal character '" + r2 + "' (code 0x" + Integer.toHexString(r2) + ") in base64 content";
        goto L15
    }

    public void g() {
        throw new IllegalArgumentException(j());
    }

    public void h() {
        throw new IllegalArgumentException(i());
    }

    public String i() {
        return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects no padding at the end while decoding. This Base64Variant might have been incorrectly configured", new Object[]{a()});
    }

    public String j() {
        return String.format("Unexpected end of base64-encoded String: base64 variant '%s' expects padding (one or more '%c' characters) at the end. This Base64Variant might have been incorrectly configured", new Object[]{a(), Character.valueOf(e())});
    }
}
