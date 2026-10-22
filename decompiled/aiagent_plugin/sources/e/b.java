package e;

/* JADX INFO: compiled from: Util.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final e.a f38704a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f38705b = 0;

    public static final int a(int r2) {
        int r0 = ((((-16777216) & r2) >>> 24) | ((16711680 & r2) >>> 8)) | ((65280 & r2) << 8);
        return ((r2 & 255) << 24) | r0;
    }

    public static final long a(long r8) {
        long r0 = ((((((((-72057594037927936L) & r8) >>> 56) | ((71776119061217280L & r8) >>> 40)) | ((280375465082880L & r8) >>> 24)) | ((1095216660480L & r8) >>> 8)) | ((4278190080L & r8) << 8)) | ((16711680 & r8) << 24)) | ((65280 & r8) << 40);
        return ((r8 & 255) << 56) | r0;
    }

    public static final short a(short r1) {
        int r2 = r1 & 65535;
        int r0 = (65280 & r2) >>> 8;
        return (short) (((r2 & 255) << 8) | r0);
    }

    public static final void a(long r4, long r6, long r8) {
        if ((r6 | r8) < 0) goto L10;
        if (r6 > r4) goto L10;
        if ((r4 - r6) < r8) goto L10;
        return;
    L10:
        throw new ArrayIndexOutOfBoundsException("size=" + r4 + " offset=" + r6 + " byteCount=" + r8);
    }

    public static final boolean a(byte[] r4, int r5, byte[] r6, int r7, int r8) {
        d.h.b.o.e(r4, "a");
        d.h.b.o.e(r6, "b");
        int r1 = 0;
    L3:
        if (r1 >= r8) goto L8;
        if (r4[r1 + r5] != r6[r1 + r7]) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    public static final String a(byte r3) {
        return d.o.o.a(new char[]{e.a.b.a()[(r3 >> 4) & 15], e.a.b.a()[r3 & 15]});
    }

    public static final String b(int r6) {
        if (r6 != 0) goto L5;
        return "0";
    L5:
        int r3 = 0;
        char[] r1 = {e.a.b.a()[(r6 >> 28) & 15], e.a.b.a()[(r6 >> 24) & 15], e.a.b.a()[(r6 >> 20) & 15], e.a.b.a()[(r6 >> 16) & 15], e.a.b.a()[(r6 >> 12) & 15], e.a.b.a()[(r6 >> 8) & 15], e.a.b.a()[(r6 >> 4) & 15], e.a.b.a()[r6 & 15]};
    L6:
        if (r3 >= 8) goto L11;
        if (r1[r3] != '0') goto L11;
        r3 = r3 + 1;
    L11:
        return d.o.o.a(r1, r3, 8);
    }

    static {
        f38704a = new e.a();
        f38705b = -1234567890;
    }

    public static final e.a a(e.a r1) {
        d.h.b.o.e(r1, "unsafeCursor");
        if (r1 == f38704a) goto L5;
        return r1;
    L5:
        return new e.a();
    }

    public static final int a() {
        return f38705b;
    }

    public static final int a(h r1, int r2) {
        d.h.b.o.e(r1, "<this>");
        if (r2 == f38705b) goto L5;
        return r2;
    L5:
        return r1.k();
    }

    public static final int a(byte[] r1, int r2) {
        d.h.b.o.e(r1, "<this>");
        if (r2 == f38705b) goto L5;
        return r2;
    L5:
        return r1.length;
    }
}
