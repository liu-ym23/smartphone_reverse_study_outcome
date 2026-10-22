package e.a;

import d.h.b.o;
import e.ad;
import e.e;
import e.r;
import e.v;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f38697a = null;

    static {
        f38697a = ad.a("0123456789abcdef");
    }

    public static final byte[] a() {
        return f38697a;
    }

    public static final String a(e r6, long r7) {
        o.e(r6, "<this>");
        if (r7 <= 0) goto L7;
        long r3 = r7 - 1;
        if (r6.c(r3) != 13) goto L7;
        String r8 = r6.e(r3);
        r6.h(2);
        return r8;
    L7:
        String r9 = r6.e(r7);
        r6.h(1);
        return r9;
    }

    public static /* synthetic */ int a(e r0, r r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return a(r0, r1, r2);
    }

    public static final int a(e r17, r r18, boolean r19) {
        o.e(r17, "<this>");
        o.e(r18, "options");
        v r0 = r17.f38713a;
        if (r0 != null) goto L8;
        if (r19 == false) goto L7;
        return -2;
    L7:
        return -1;
    L8:
        byte[] r4 = r0.f38756b;
        int r5 = r0.f38757c;
        int r6 = r0.f38758d;
        int[] r2 = r18.c();
        v r9 = r0;
        int r10 = -1;
        int r8 = 0;
    L9:
        int r11 = r8 + 1;
        int r12 = r2[r8];
        int r13 = r11 + 1;
        int r14 = r2[r11];
        if (r14 == (-1)) goto L12;
        r10 = r14;
    L12:
        if (r9 == null) goto L28;
        if (r12 >= 0) goto L36;
        int r15 = r13 + (r12 * (-1));
    L17:
        int r16 = r5 + 1;
        int r110 = r13 + 1;
        if ((r4[r5] & 255) != r2[r13]) goto L19;
        if (r110 != r15) goto L22;
        boolean r7 = true;
    L23:
        if (r16 != r6) goto L32;
        o.a(r9);
        v r20 = r9.g;
        o.a(r20);
        int r21 = r20.f38757c;
        byte[] r22 = r20.f38756b;
        int r23 = r20.f38758d;
        if (r20 != r0) goto L31;
        if (r7 == false) goto L28;
        r4 = r22;
        v r24 = null;
    L33:
        if (r7 == true) goto L34;
        r5 = r21;
        r6 = r23;
        r13 = r110;
        r9 = r24;
        goto L17
    L34:
        int r25 = r2[r110];
        int r111 = r21;
        r6 = r23;
        r9 = r24;
    L46:
        if (r25 >= 0) goto L47;
        r8 = -r25;
        r5 = r111;
        goto L9
    L47:
        return r25;
    L31:
        r24 = r20;
        r4 = r22;
        goto L33
    L32:
        v r112 = r9;
        r23 = r6;
        r21 = r16;
        r24 = r112;
        goto L33
    L22:
        r7 = false;
        goto L23
    L19:
        return r10;
    L36:
        r111 = r5 + 1;
        int r26 = r4[r5] & 255;
        int r113 = r13 + r12;
    L37:
        if (r13 == r113) goto L38;
        if (r26 == r2[r13]) goto L41;
        r13 = r13 + 1;
        goto L37
    L41:
        r25 = r2[r13 + r12];
        if (r111 != r6) goto L46;
        r9 = r9.g;
        o.a(r9);
        int r27 = r9.f38757c;
        r111 = r27;
        r4 = r9.f38756b;
        r6 = r9.f38758d;
        if (r9 != r0) goto L46;
        r9 = null;
        goto L46
    L38:
        return r10;
    L28:
        if (r19 == false) goto L30;
        return -2;
    L30:
        return r10;
    }

    public static final e.a a(e r2, e.a r3) {
        o.e(r2, "<this>");
        o.e(r3, "unsafeCursor");
        e.a r4 = e.b.a(r3);
        if (r4.f38715a != null) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L10;
        r4.f38715a = r2;
        r4.f38716b = true;
        return r4;
    L10:
        throw new IllegalStateException("already attached to a buffer".toString());
    L5:
        r0 = false;
        goto L6
    }
}
