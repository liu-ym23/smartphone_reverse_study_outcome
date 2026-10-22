package org.threeten.bp.chrono;

import java.io.Serializable;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.chrono.a;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalUnit;

/* JADX INFO: loaded from: classes4.dex */
abstract class ChronoDateImpl<D extends org.threeten.bp.chrono.a> extends org.threeten.bp.chrono.a implements Temporal, TemporalAdjuster, Serializable {
    private static final long serialVersionUID = 6282433883239719096L;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23086a = null;

        static {
            int[] r10 = new int[ChronoUnit.values().length];
            f23086a = r10;
            r10[ChronoUnit.DAYS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f23086a[ChronoUnit.WEEKS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f23086a[ChronoUnit.MONTHS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f23086a[ChronoUnit.YEARS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f23086a[ChronoUnit.DECADES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f23086a[ChronoUnit.CENTURIES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f23086a[ChronoUnit.MILLENNIA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public ChronoDateImpl() {
    }

    @Override // org.threeten.bp.chrono.a
    public b atTime(LocalTime r10) {
        return ChronoLocalDateTimeImpl.of(this, r10);
    }

    public ChronoDateImpl<D> minusDays(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        ChronoDateImpl<D> this = plusDays(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusDays(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public ChronoDateImpl<D> minusMonths(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        ChronoDateImpl<D> this = plusMonths(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusMonths(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public ChronoDateImpl<D> minusWeeks(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        ChronoDateImpl<D> this = plusWeeks(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusWeeks(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    public ChronoDateImpl<D> minusYears(long r10) {
        if (r10 != Long.MIN_VALUE) goto L6;
        ChronoDateImpl<D> this = plusYears(Long.MAX_VALUE);
        long r11 = 1;
    L7:
        return this.plusYears(r11);
    L6:
        r11 = -r10;
        goto L7
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    public abstract ChronoDateImpl<D> plusDays(long r10);

    public abstract ChronoDateImpl<D> plusMonths(long r10);

    public ChronoDateImpl<D> plusWeeks(long r10) {
        return plusDays(ig.d.l(r10, 7));
    }

    public abstract ChronoDateImpl<D> plusYears(long r10);

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r10, TemporalUnit r11) {
        org.threeten.bp.chrono.a r12 = getChronology().date(r10);
        if ((r11 instanceof ChronoUnit) == false) goto L7;
        return LocalDate.from(this).until(r12, r11);
    L7:
        return r11.between(this, r12);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public ChronoDateImpl<D> plus(long r10, TemporalUnit r11) {
        if ((r11 instanceof ChronoUnit) == false) goto L23;
        switch(a.f23086a[((ChronoUnit) r11).ordinal()]) {
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L17;
            case 4: goto L15;
            case 5: goto L13;
            case 6: goto L11;
            case 7: goto L9;
            default: goto L7;
        };
    L7:
        throw new DateTimeException(r11 + " not valid for chronology " + getChronology().getId());
    L9:
        return plusYears(ig.d.l(r10, 1000));
    L11:
        return plusYears(ig.d.l(r10, 100));
    L13:
        return plusYears(ig.d.l(r10, 10));
    L15:
        return plusYears(r10);
    L17:
        return plusMonths(r10);
    L19:
        return plusDays(ig.d.l(r10, 7));
    L21:
        return plusDays(r10);
    L23:
        return (ChronoDateImpl) getChronology().ensureChronoLocalDate(r11.addTo(this, r10));
    }

    @Override // org.threeten.bp.chrono.a
    public c until(org.threeten.bp.chrono.a r10) {
        throw new UnsupportedOperationException("Not supported in ThreeTen backport");
    }
}
