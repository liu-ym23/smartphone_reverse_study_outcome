package d.p;

import d.h.b.o;

/* JADX INFO: compiled from: DurationUnitJvm.kt */
/* JADX INFO: loaded from: classes4.dex */
class f {
    public static final long a(long r1, d r3, d r4) {
        o.e(r3, "sourceUnit");
        o.e(r4, "targetUnit");
        return r4.a().convert(r1, r3.a());
    }

    public static final long b(long r1, d r3, d r4) {
        o.e(r3, "sourceUnit");
        o.e(r4, "targetUnit");
        return r4.a().convert(r1, r3.a());
    }
}
