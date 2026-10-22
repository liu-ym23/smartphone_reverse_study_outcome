package okhttp3.internal.g;

import d.h.b.o;

/* JADX INFO: compiled from: Http2.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f39986a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e.h f39987b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f39988c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f39989d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String[] f39990e = null;

    private e() {
    }

    static {
        f39986a = new e();
        f39987b = e.h.f38722a.a("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f39988c = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f39989d = new String[64];
        String[] r1 = new String[256];
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r3 >= 256) goto L6;
        String r5 = Integer.toBinaryString(r3);
        o.c(r5, "toBinaryString(it)");
        r1[r3] = d.o.o.a(okhttp3.internal.c.a("%8s", new Object[]{r5}), ' ', '0', false, 4, null);
        r3 = r3 + 1;
        goto L4
    L6:
        f39990e = r1;
        String[] r0 = f39989d;
        r0[0] = "";
        r0[1] = "END_STREAM";
        int[] r4 = {1};
        r0[8] = "PADDED";
        int r6 = 0;
    L8:
        if (r6 >= 1) goto L10;
        int r7 = r4[r6];
        String[] r8 = f39989d;
        r8[r7 | 8] = r8[r7] + "|PADDED";
        r6 = r6 + 1;
        goto L8
    L10:
        String[] r9 = f39989d;
        r9[4] = "END_HEADERS";
        r9[32] = "PRIORITY";
        r9[36] = "END_HEADERS|PRIORITY";
        int[] r10 = {4, 32, 36};
        int r11 = 0;
    L11:
        if (r11 >= 3) goto L16;
        int r12 = r10[r11];
        int r13 = 0;
    L13:
        if (r13 >= 1) goto L15;
        int r14 = r4[r13];
        String[] r15 = f39989d;
        int r16 = r14 | r12;
        r15[r16] = r15[r14] + '|' + r15[r12];
        r15[r16 | 8] = r15[r14] + '|' + r15[r12] + "|PADDED";
        r13 = r13 + 1;
        goto L13
    L15:
        r11 = r11 + 1;
        goto L11
    L16:
        int r17 = f39989d.length;
    L17:
        if (r2 >= r17) goto L22;
        String[] r18 = f39989d;
        if (r18[r2] != null) goto L21;
        r18[r2] = f39990e[r2];
    L21:
        r2 = r2 + 1;
        goto L17
    }

    public final String a(boolean r2, int r3, int r4, int r5, int r6) {
        String r0 = a(r5);
        String r1 = a(r5, r6);
        if (r2 == false) goto L5;
        String r7 = "<<";
    L7:
        return okhttp3.internal.c.a("%s 0x%08x %5d %-13s %s", new Object[]{r7, Integer.valueOf(r3), Integer.valueOf(r4), r0, r1});
    L5:
        r7 = ">>";
        goto L7
    }

    public final String a(int r2) {
        String[] r1 = f39988c;
        if (r2 >= r1.length) goto L6;
        return r1[r2];
    L6:
        return okhttp3.internal.c.a("0x%02x", new Object[]{Integer.valueOf(r2)});
    }

    public final String a(int r7, int r8) {
        if (r8 != 0) goto L6;
        return "";
    L6:
        if (r7 == 2) goto L37;
        if (r7 == 3) goto L37;
        if (r7 == 4) goto L32;
        if (r7 == 6) goto L32;
        if (r7 == 7) goto L37;
        if (r7 == 8) goto L37;
        String[] r6 = f39989d;
        if (r8 >= r6.length) goto L20;
        String r9 = r6[r8];
        o.a(r9);
    L21:
        String r0 = r9;
        if (r7 == 5) goto L24;
    L26:
        if (r7 == 0) goto L28;
        return r0;
    L28:
        if ((r8 & 32) != 0) goto L30;
        return r0;
    L30:
        return d.o.o.a(r0, "PRIORITY", "COMPRESSED", false, 4, null);
    L24:
        if ((r8 & 4) == 0) goto L26;
        return d.o.o.a(r0, "HEADERS", "PUSH_PROMISE", false, 4, null);
    L20:
        r9 = f39990e[r8];
    L32:
        if (r8 != 1) goto L35;
        return "ACK";
    L35:
        return f39990e[r8];
    L37:
        return f39990e[r8];
    }
}
