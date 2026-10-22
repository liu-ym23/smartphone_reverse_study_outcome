package bytedance.jvm.time.chrono;

import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.UnsupportedTemporalTypeException;

/* JADX INFO: loaded from: classes28.dex */
public final /* synthetic */ class k {
    public static bytedance.jvm.time.temporal.b a(l r100, bytedance.jvm.time.temporal.b r101) {
        return r101.with(ChronoField.ERA, r100.getValue());
    }

    public static int b(l r100, bytedance.jvm.time.temporal.j r101) {
        if (r101 != ChronoField.ERA) goto L7;
        return r100.getValue();
    L7:
        return bytedance.jvm.time.temporal.c.a(r100, r101);
    }

    public static long c(l r100, bytedance.jvm.time.temporal.j r101) {
        if (r101 != ChronoField.ERA) goto L7;
        return r100.getValue();
    L7:
        if ((r101 instanceof ChronoField) == true) goto L11;
        return r101.getFrom(r100);
    L11:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r101);
    }

    public static boolean d(l r100, bytedance.jvm.time.temporal.j r101) {
        if ((r101 instanceof ChronoField) == true) goto L5;
        if (r101 != null) goto L11;
    L13:
        return false;
    L11:
        if (r101.isSupportedBy(r100) == false) goto L13;
        return true;
    L5:
        if (r101 == ChronoField.ERA) goto L15;
        return false;
    L15:
        return true;
    }

    public static Object e(l r100, bytedance.jvm.time.temporal.l r101) {
        if (r101 != bytedance.jvm.time.temporal.k.f21716c) goto L7;
        return ChronoUnit.ERAS;
    L7:
        return bytedance.jvm.time.temporal.c.b(r100, r101);
    }
}
