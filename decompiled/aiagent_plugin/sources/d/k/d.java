package d.k;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.l.m;

/* JADX INFO: compiled from: Random.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {
    public static final int a(int r1, int r2) {
        return (r1 >>> (32 - r2)) & ((-r2) >> 31);
    }

    public static final c a(long r3) {
        return (c) ZeusTransformUtils.preCheckCast(new f((int) r3, (int) (r3 >> 32)), c.class, "com.obric.aiagent.plugin");
    }

    public static final long a(c r7, m r8) {
        o.e(r7, "<this>");
        o.e(r8, "range");
        if (r8.d() == true) goto L13;
        if (r8.b() >= Long.MAX_VALUE) goto L8;
        return r7.a(r8.a(), r8.b() + 1);
    L8:
        if (r8.a() <= Long.MIN_VALUE) goto L11;
        return r7.a(r8.a() - 1, r8.b()) + 1;
    L11:
        return r7.c();
    L13:
        throw new IllegalArgumentException("Cannot get random in empty range: " + r8);
    }

    public static final int a(int r0) {
        return 31 - Integer.numberOfLeadingZeros(r0);
    }

    public static final void a(long r1, long r3) {
        if (r3 <= r1) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L9;
        return;
    L9:
        throw new IllegalArgumentException(a(Long.valueOf(r1), Long.valueOf(r3)).toString());
    L5:
        r0 = false;
        goto L6
    }

    public static final String a(Object r2, Object r3) {
        o.e(r2, "from");
        o.e(r3, "until");
        return "Random range is empty: [" + r2 + ", " + r3 + ").";
    }
}
