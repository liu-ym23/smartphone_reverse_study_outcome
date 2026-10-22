package bytedance.jvm.time.chrono;

import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.ChronoUnit;
import bytedance.jvm.time.temporal.m;

/* JADX INFO: loaded from: classes28.dex */
public final /* synthetic */ class b {
    public static boolean f(c r100) {
        return r100.getChronology().isLeapYear(r100.getLong(ChronoField.YEAR));
    }

    public static bytedance.jvm.time.temporal.b a(c r100, bytedance.jvm.time.temporal.b r101) {
        return r101.with(ChronoField.EPOCH_DAY, r100.toEpochDay());
    }

    public static int b(c r100, c r101) {
        int r102 = Long.compare(r100.toEpochDay(), r101.toEpochDay());
        if (r102 == 0) goto L5;
        return r102;
    L5:
        return r100.getChronology().compareTo(r101.getChronology());
    }

    public static boolean c(c r100, c r101) {
        if (r100.toEpochDay() <= r101.toEpochDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean d(c r100, c r101) {
        if (r100.toEpochDay() >= r101.toEpochDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean e(c r100, c r101) {
        if (r100.toEpochDay() != r101.toEpochDay()) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean g(c r100, bytedance.jvm.time.temporal.j r101) {
        if ((r101 instanceof ChronoField) == true) goto L5;
        if (r101 != null) goto L8;
    L10:
        return false;
    L8:
        if (r101.isSupportedBy(r100) == false) goto L10;
        return true;
    L5:
        return r101.isDateBased();
    }

    public static boolean h(c r100, m r101) {
        if ((r101 instanceof ChronoUnit) == true) goto L5;
        if (r101 != null) goto L8;
    L10:
        return false;
    L8:
        if (r101.isSupportedBy(r100) == false) goto L10;
        return true;
    L5:
        return r101.isDateBased();
    }

    public static Object i(c r100, bytedance.jvm.time.temporal.l r101) {
        if (r101 != bytedance.jvm.time.temporal.k.f21714a) goto L5;
    L22:
        return null;
    L5:
        if (r101 == bytedance.jvm.time.temporal.k.f21718e) goto L22;
        if (r101 == bytedance.jvm.time.temporal.k.f21717d) goto L22;
        if (r101 != bytedance.jvm.time.temporal.k.f21720g) goto L13;
        return null;
    L13:
        if (r101 != bytedance.jvm.time.temporal.k.f21715b) goto L17;
        return r100.getChronology();
    L17:
        if (r101 != bytedance.jvm.time.temporal.k.f21716c) goto L21;
        return ChronoUnit.DAYS;
    L21:
        return r101.a(r100);
    }
}
