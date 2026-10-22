package org.threeten.bp.temporal;

import ig.d;
import org.threeten.bp.DayOfWeek;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {

    /* JADX INFO: renamed from: org.threeten.bp.temporal.a$a, reason: collision with other inner class name */
    public static /* synthetic */ class C0334a {
    }

    public static final class b implements TemporalAdjuster {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f23234a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f23235b;

        public /* synthetic */ b(int r10, DayOfWeek r11, C0334a r12) {
            this(r10, r11);
        }

        @Override // org.threeten.bp.temporal.TemporalAdjuster
        public Temporal adjustInto(Temporal r10) {
            int r11 = r10.get(ChronoField.DAY_OF_WEEK);
            int r12 = this.f23234a;
            if (r12 >= 2) goto L8;
            if (r11 != this.f23235b) goto L8;
            return r10;
        L8:
            if ((r12 & 1) != 0) goto L16;
            int r13 = r11 - this.f23235b;
            if (r13 < 0) goto L13;
            int r14 = 7 - r13;
        L15:
            return r10.plus(r14, ChronoUnit.DAYS);
        L13:
            r14 = -r13;
            goto L15
        L16:
            int r15 = this.f23235b - r11;
            if (r15 < 0) goto L20;
            int r16 = 7 - r15;
        L22:
            return r10.minus(r16, ChronoUnit.DAYS);
        L20:
            r16 = -r15;
            goto L22
        }

        public b(int r10, DayOfWeek r11) {
            d.h(r11, "dayOfWeek");
            this.f23234a = r10;
            this.f23235b = r11.getValue();
        }
    }

    public static TemporalAdjuster a(DayOfWeek r10) {
        return new b(0, r10, null);
    }

    public static TemporalAdjuster b(DayOfWeek r10) {
        return new b(1, r10, null);
    }
}
