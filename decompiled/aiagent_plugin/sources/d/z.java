package d;

/* JADX INFO: compiled from: UnsignedJVM.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class z {
    public static final int a(int r1, int r2) {
        return d.h.b.o.a(r1 ^ Integer.MIN_VALUE, r2 ^ Integer.MIN_VALUE);
    }

    public static final String a(long r8, int r10) {
        if (r8 < 0) goto L6;
        String r9 = Long.toString(r8, d.o.a.a(r10));
        d.h.b.o.c(r9, "toString(...)");
        return r9;
    L6:
        long r4 = r10;
        long r2 = ((r8 >>> 1) / r4) << 1;
        long r11 = r8 - (r2 * r4);
        if (r11 < r4) goto L9;
        r11 = r11 - r4;
        r2 = r2 + 1;
    L9:
        StringBuilder r0 = new StringBuilder();
        String r3 = Long.toString(r2, d.o.a.a(r10));
        d.h.b.o.c(r3, "toString(...)");
        StringBuilder r1 = r0.append(r3);
        String r12 = Long.toString(r11, d.o.a.a(r10));
        d.h.b.o.c(r12, "toString(...)");
        return r1.append(r12).toString();
    }
}
