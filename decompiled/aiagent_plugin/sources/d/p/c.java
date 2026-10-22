package d.p;

import com.bytedance.crash.dumper.Scraps;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.n;

/* JADX INFO: compiled from: Duration.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {
    public static final /* synthetic */ long a(long r0) {
        return c(r0);
    }

    public static final /* synthetic */ long a(long r0, int r2) {
        return b(r0, r2);
    }

    public static final /* synthetic */ long b(long r0) {
        return e(r0);
    }

    private static final long c(long r2) {
        return r2 * ((long) 1000000);
    }

    public static final long a(int r3, d r4) {
        o.e(r4, Scraps.INNER_UNIT);
        if (r4.compareTo((Enum) ZeusTransformUtils.preCheckCast(d.f38681d, Enum.class, "com.obric.aiagent.plugin")) > 0) goto L6;
        return d(e.a(r3, r4, d.f38678a));
    L6:
        return a(r3, r4);
    }

    public static final long a(long r7, d r9) {
        o.e(r9, Scraps.INNER_UNIT);
        long r0 = e.a(4611686018426999999L, d.f38678a, r9);
        boolean r3 = false;
        if ((-r0) <= r7) goto L5;
    L7:
        if (r3 == false) goto L11;
        return d(e.a(r7, r9, d.f38678a));
    L11:
        return e(n.a(e.b(r7, r9, d.f38680c), -4611686018427387903L, 4611686018427387903L));
    L5:
        if (r7 > r0) goto L7;
        r3 = true;
        goto L7
    }

    private static final long d(long r1) {
        return a.p(r1 << 1);
    }

    private static final long e(long r2) {
        return a.p((r2 << 1) + 1);
    }

    private static final long b(long r2, int r4) {
        return a.p((r2 << 1) + ((long) r4));
    }
}
