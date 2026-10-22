package e;

import java.util.Arrays;

/* JADX INFO: compiled from: Base64.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f38695a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final byte[] f38696b = null;

    static {
        f38695a = h.f38722a.a("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").a();
        f38696b = h.f38722a.a("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").a();
    }

    public static final byte[] a(String r16) {
        d.h.b.o.e(r16, "<this>");
        int r1 = r16.length();
    L4:
        if (r1 <= 0) goto L13;
        char r6 = r16.charAt(r1 - 1);
        if (r6 == '=') goto L12;
        if (r6 == '\n') goto L12;
        if (r6 == '\r') goto L12;
        if (r6 == ' ') goto L12;
        if (r6 != '\t') goto L13;
    L12:
        r1 = r1 - 1;
    L13:
        int r7 = (int) ((((long) r1) * 6) / 8);
        byte[] r8 = new byte[r7];
        int r9 = 0;
        int r10 = 0;
        int r11 = 0;
        int r12 = 0;
    L14:
        boolean r14 = true;
        if (r9 >= r1) goto L62;
        char r15 = r16.charAt(r9);
        if ('A' <= r15) goto L19;
    L21:
        boolean r13 = false;
    L22:
        if (r13 == false) goto L25;
        int r17 = r15 - 'A';
    L58:
        r11 = (r11 << 6) | r17;
        r10 = r10 + 1;
        if ((r10 % 4) != 0) goto L61;
        int r18 = r12 + 1;
        r8[r12] = (byte) (r11 >> 16);
        int r19 = r18 + 1;
        r8[r18] = (byte) (r11 >> 8);
        r8[r19] = (byte) r11;
        r12 = r19 + 1;
    L61:
        r9 = r9 + 1;
        goto L14
    L25:
        if ('a' <= r15) goto L27;
    L29:
        boolean r20 = false;
    L30:
        if (r20 == false) goto L33;
        r17 = r15 - 'G';
        goto L58
    L33:
        if ('0' <= r15) goto L35;
    L37:
        r14 = false;
    L38:
        if (r14 == false) goto L41;
        r17 = r15 + 4;
        goto L58
    L41:
        if (r15 != '+') goto L43;
    L57:
        r17 = 62;
        goto L58
    L43:
        if (r15 == '-') goto L57;
        if (r15 != '/') goto L48;
    L56:
        r17 = 63;
        goto L58
    L48:
        if (r15 == '_') goto L56;
        if (r15 == '\n') goto L61;
        if (r15 == '\r') goto L61;
        if (r15 == ' ') goto L61;
        if (r15 == '\t') goto L61;
        return null;
    L35:
        if (r15 >= ':') goto L37;
    L27:
        if (r15 >= '{') goto L29;
        r20 = true;
        goto L30
    L19:
        if (r15 >= '[') goto L21;
        r13 = true;
        goto L22
    L62:
        int r110 = r10 % 4;
        if (r110 != 1) goto L65;
        return null;
    L65:
        if (r110 != 2) goto L67;
        r8[r12] = (byte) ((r11 << 12) >> 16);
        r12 = r12 + 1;
    L71:
        if (r12 != r7) goto L73;
        return r8;
    L73:
        byte[] r0 = Arrays.copyOf(r8, r12);
        d.h.b.o.c(r0, "copyOf(this, newSize)");
        return r0;
    L67:
        if (r110 != 3) goto L71;
        int r2 = r11 << 6;
        int r3 = r12 + 1;
        r8[r12] = (byte) (r2 >> 16);
        r12 = r3 + 1;
        r8[r3] = (byte) (r2 >> 8);
        goto L71
    }

    public static /* synthetic */ String a(byte[] r0, byte[] r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = f38695a;
    L6:
        return a(r0, r1);
    }

    public static final String a(byte[] r10, byte[] r11) {
        d.h.b.o.e(r10, "<this>");
        d.h.b.o.e(r11, "map");
        byte[] r0 = new byte[((r10.length + 2) / 3) * 4];
        int r2 = r10.length - (r10.length % 3);
        int r3 = 0;
        int r4 = 0;
    L3:
        if (r3 >= r2) goto L5;
        int r5 = r3 + 1;
        byte r6 = r10[r3];
        int r7 = r5 + 1;
        byte r8 = r10[r5];
        int r9 = r7 + 1;
        byte r12 = r10[r7];
        int r13 = r4 + 1;
        r0[r4] = r11[(r6 & 255) >> 2];
        int r14 = r13 + 1;
        r0[r13] = r11[((r6 & 3) << 4) | ((r8 & 255) >> 4)];
        int r15 = r14 + 1;
        r0[r14] = r11[((r8 & 15) << 2) | ((r12 & 255) >> 6)];
        r4 = r15 + 1;
        r0[r15] = r11[r12 & 63];
        r3 = r9;
        goto L3
    L5:
        int r16 = r10.length - r2;
        if (r16 == 1) goto L10;
        if (r16 != 2) goto L12;
        int r17 = r3 + 1;
        byte r18 = r10[r3];
        byte r19 = r10[r17];
        int r20 = r4 + 1;
        r0[r4] = r11[(r18 & 255) >> 2];
        int r21 = r20 + 1;
        r0[r20] = r11[((r18 & 3) << 4) | ((r19 & 255) >> 4)];
        r0[r21] = r11[(r19 & 15) << 2];
        r0[r21 + 1] = 61;
    L12:
        return ad.a(r0);
    L10:
        byte r110 = r10[r3];
        int r22 = r4 + 1;
        r0[r4] = r11[(r110 & 255) >> 2];
        int r1 = r22 + 1;
        r0[r22] = r11[(r110 & 3) << 4];
        r0[r1] = 61;
        r0[r1 + 1] = 61;
        goto L12
    }
}
