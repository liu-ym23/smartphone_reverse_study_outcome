package kotlin.time;

import bg.f;
import bg.h;
import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {
    public static final /* synthetic */ long a(long r10, int r11) {
        return d(r10, r11);
    }

    public static final /* synthetic */ long b(long r10) {
        return e(r10);
    }

    public static final /* synthetic */ long c(long r10) {
        return g(r10);
    }

    public static final long d(long r10, int r11) {
        return b.d((r10 << 1) + ((long) r11));
    }

    public static final long e(long r10) {
        return b.d((r10 << 1) + 1);
    }

    public static final long f(long r10) {
        return b.d(r10 << 1);
    }

    public static final long g(long r10) {
        return r10 * ((long) 1000000);
    }

    public static final long h(long r10, DurationUnit r11) {
        q.g(r11, "unit");
        DurationUnit r12 = DurationUnit.NANOSECONDS;
        long r13 = e.b(4611686018426999999L, r12, r11);
        if (new f(-r13, r13).d(r10) == false) goto L7;
        return f(e.b(r10, r11, r12));
    L7:
        return e(h.l(e.a(r10, r11, DurationUnit.MILLISECONDS), -4611686018427387903L, 4611686018427387903L));
    }
}
