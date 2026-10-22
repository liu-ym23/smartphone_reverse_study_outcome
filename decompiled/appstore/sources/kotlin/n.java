package kotlin;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class n {
    public static final int a(int r10, int r11) {
        return q.i(r10 ^ Integer.MIN_VALUE, r11 ^ Integer.MIN_VALUE);
    }

    public static final int b(long r10, long r11) {
        return q.j(r10 ^ Long.MIN_VALUE, r11 ^ Long.MIN_VALUE);
    }

    public static final String c(long r10) {
        return d(r10, 10);
    }

    public static final String d(long r10, int r11) {
        if (r10 < 0) goto L6;
        String r12 = Long.toString(r10, kotlin.text.a.a(r11));
        q.f(r12, "toString(...)");
        return r12;
    L6:
        long r13 = r11;
        long r14 = ((r10 >>> 1) / r13) << 1;
        long r15 = r10 - (r14 * r13);
        if (r15 < r13) goto L9;
        r15 = r15 - r13;
        r14 = r14 + 1;
    L9:
        StringBuilder r16 = new StringBuilder();
        String r17 = Long.toString(r14, kotlin.text.a.a(r11));
        q.f(r17, "toString(...)");
        r16.append(r17);
        String r18 = Long.toString(r15, kotlin.text.a.a(r11));
        q.f(r18, "toString(...)");
        r16.append(r18);
        return r16.toString();
    }
}
