package kotlinx.coroutines.internal;

import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class e0 {
    public static final int a(String r10, int r11, int r12, int r13) {
        return (int) c0.c(r10, r11, r12, r13);
    }

    public static final long b(String r10, long r11, long r12, long r13) {
        String r14 = c0.d(r10);
        if (r14 != null) goto L5;
        return r11;
    L5:
        Long r15 = kotlin.text.n.i(r14);
        if (r15 == null) goto L15;
        long r16 = r15.longValue();
        if (r12 > r16) goto L13;
        if (r16 > r13) goto L13;
        return r16;
    L13:
        throw new IllegalStateException(("System property '" + r10 + "' should be in range " + r12 + ".." + r13 + ", but is '" + r16 + '\'').toString());
    L15:
        throw new IllegalStateException(("System property '" + r10 + "' has unrecognized value '" + r14 + '\'').toString());
    }

    public static final String c(String r10, String r11) {
        String r12 = c0.d(r10);
        if (r12 != null) goto L6;
        return r11;
    L6:
        return r12;
    }

    public static final boolean d(String r10, boolean r11) {
        String r12 = c0.d(r10);
        if (r12 != null) goto L5;
        return r11;
    L5:
        return Boolean.parseBoolean(r12);
    }

    public static /* synthetic */ int e(String r10, int r11, int r12, int r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L6;
        r12 = 1;
    L6:
        if ((r14 & 8) == 0) goto L9;
        r13 = Channel.UNLIMITED;
    L9:
        return c0.b(r10, r11, r12, r13);
    }

    public static /* synthetic */ long f(String r10, long r11, long r12, long r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r12 = 1;
    L5:
        long r16 = r12;
        if ((r14 & 8) == 0) goto L9;
        r13 = Long.MAX_VALUE;
    L9:
        return c0.c(r10, r11, r16, r13);
    }
}
