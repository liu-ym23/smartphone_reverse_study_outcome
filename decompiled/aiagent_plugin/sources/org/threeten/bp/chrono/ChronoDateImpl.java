package org.threeten.bp.chrono;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.chrono.ChronoLocalDate;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalUnit;

/* JADX INFO: loaded from: classes5.dex */
abstract class ChronoDateImpl<D extends ChronoLocalDate> extends ChronoLocalDate implements Serializable, Temporal, TemporalAdjuster {
    private static final long serialVersionUID = 6282433883239719096L;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.ChronoDateImpl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoUnit = null;

        static {
            int[] r0 = new int[ChronoUnit.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit = r0;
            r0[ChronoUnit.DAYS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.WEEKS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MONTHS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.YEARS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.DECADES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.CENTURIES.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            $SwitchMap$org$threeten$bp$temporal$ChronoUnit[ChronoUnit.MILLENNIA.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    abstract ChronoDateImpl<D> plusDays(long r1);

    abstract ChronoDateImpl<D> plusMonths(long r1);

    abstract ChronoDateImpl<D> plusYears(long r1);

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* synthetic */ ChronoLocalDate plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public /* synthetic */ Temporal plus(long r3, TemporalUnit r5) {
        return plus(r3, (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin"));
    }

    ChronoDateImpl() {
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate, org.threeten.bp.temporal.Temporal
    public ChronoDateImpl<D> plus(long r3, TemporalUnit r5) {
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r5, TemporalUnit.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r6, ChronoUnit.class) == false) goto L23;
        switch(AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoUnit[((ChronoUnit) ZeusTransformUtils.preCheckCast(r6, ChronoUnit.class, "com.obric.aiagent.plugin")).ordinal()]) {
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
        throw new DateTimeException(r6 + " not valid for chronology " + getChronology().getId());
    L9:
        return plusYears(Jdk8Methods.safeMultiply(r3, 1000));
    L11:
        return plusYears(Jdk8Methods.safeMultiply(r3, 100));
    L13:
        return plusYears(Jdk8Methods.safeMultiply(r3, 10));
    L15:
        return plusYears(r3);
    L17:
        return plusMonths(r3);
    L19:
        return plusDays(Jdk8Methods.safeMultiply(r3, 7));
    L21:
        return plusDays(r3);
    L23:
        return (ChronoDateImpl) ZeusTransformUtils.preCheckCast(getChronology().ensureChronoLocalDate(r6.addTo(this, r3)), ChronoDateImpl.class, "com.obric.aiagent.plugin");
    }

    ChronoDateImpl<D> plusWeeks(long r2) {
        return plusDays(Jdk8Methods.safeMultiply(r2, 7));
    }

    ChronoDateImpl<D> minusYears(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        ChronoDateImpl<D> this = plusYears(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusYears(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    ChronoDateImpl<D> minusMonths(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        ChronoDateImpl<D> this = plusMonths(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusMonths(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    ChronoDateImpl<D> minusWeeks(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        ChronoDateImpl<D> this = plusWeeks(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusWeeks(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    ChronoDateImpl<D> minusDays(long r3) {
        if (r3 != Long.MIN_VALUE) goto L5;
        ChronoDateImpl<D> this = plusDays(Long.MAX_VALUE);
        long r4 = 1;
    L7:
        return this.plusDays(r4);
    L5:
        r4 = -r3;
        goto L7
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public ChronoLocalDateTime<?> atTime(LocalTime r1) {
        return ChronoLocalDateTimeImpl.of(this, r1);
    }

    @Override // org.threeten.bp.temporal.Temporal
    public long until(Temporal r3, TemporalUnit r4) {
        Temporal r5 = (Temporal) ZeusTransformUtils.wrapperContextForParams(r3, Temporal.class, "com.obric.aiagent.plugin");
        TemporalUnit r6 = (TemporalUnit) ZeusTransformUtils.wrapperContextForParams(r4, TemporalUnit.class, "com.obric.aiagent.plugin");
        ChronoLocalDate r7 = getChronology().date(r5);
        if (ZeusTransformUtils.instanceOf(r6, ChronoUnit.class) == false) goto L7;
        return LocalDate.from(this).until(r7, r6);
    L7:
        return r6.between(this, r7);
    }

    @Override // org.threeten.bp.chrono.ChronoLocalDate
    public ChronoPeriod until(ChronoLocalDate r1) {
        throw new UnsupportedOperationException("Not supported in ThreeTen backport");
    }
}
