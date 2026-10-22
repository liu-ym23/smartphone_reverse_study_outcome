package kotlin.time;

import kotlin.jvm.internal.q;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e {
    public static final long a(long r10, DurationUnit r11, DurationUnit r12) {
        q.g(r11, "sourceUnit");
        q.g(r12, "targetUnit");
        return r12.getTimeUnit$kotlin_stdlib().convert(r10, r11.getTimeUnit$kotlin_stdlib());
    }

    public static final long b(long r10, DurationUnit r11, DurationUnit r12) {
        q.g(r11, "sourceUnit");
        q.g(r12, "targetUnit");
        return r12.getTimeUnit$kotlin_stdlib().convert(r10, r11.getTimeUnit$kotlin_stdlib());
    }
}
