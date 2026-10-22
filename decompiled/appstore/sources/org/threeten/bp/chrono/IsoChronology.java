package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.Month;
import org.threeten.bp.Year;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes4.dex */
public final class IsoChronology extends e implements Serializable {
    public static final IsoChronology INSTANCE = null;
    private static final long serialVersionUID = -1440403870442975015L;

    static {
        INSTANCE = new IsoChronology();
    }

    private IsoChronology() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ a date(int r10, int r11, int r12) {
        return date(r10, r11, r12);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ a dateEpochDay(long r10) {
        return dateEpochDay(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ a dateNow() {
        return dateNow();
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ a dateYearDay(int r10, int r11) {
        return dateYearDay(r10, r11);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ Era eraOf(int r10) {
        return eraOf(r10);
    }

    public List<Era> eras() {
        return Arrays.asList(IsoEra.values());
    }

    @Override // org.threeten.bp.chrono.e
    public String getCalendarType() {
        return "iso8601";
    }

    @Override // org.threeten.bp.chrono.e
    public String getId() {
        return "ISO";
    }

    @Override // org.threeten.bp.chrono.e
    public boolean isLeapYear(long r10) {
        if ((3 & r10) == 0) goto L5;
    L9:
        return false;
    L5:
        if ((r10 % 100) == 0) goto L7;
    L8:
        return true;
    L7:
        if ((r10 % 400) != 0) goto L9;
        goto L8
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ b localDateTime(TemporalAccessor r10) {
        return localDateTime(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public int prolepticYear(Era r10, int r11) {
        if ((r10 instanceof IsoEra) == false) goto L10;
        if (r10 != IsoEra.CE) goto L8;
        return r11;
    L8:
        return 1 - r11;
    L10:
        throw new ClassCastException("Era must be IsoEra");
    }

    @Override // org.threeten.bp.chrono.e
    public ValueRange range(ChronoField r10) {
        return r10.range();
    }

    /* JADX INFO: renamed from: resolveDate, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ a m69resolveDate(Map r10, ResolverStyle r11) {
        return resolveDate(r10, r11);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ d zonedDateTime(Instant r10, ZoneId r11) {
        return zonedDateTime(r10, r11);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ a date(Era r10, int r11, int r12, int r13) {
        return date(r10, r11, r12, r13);
    }

    @Override // org.threeten.bp.chrono.e
    public LocalDate dateEpochDay(long r10) {
        return LocalDate.ofEpochDay(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ a dateNow(Clock r10) {
        return dateNow(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ a dateYearDay(Era r10, int r11, int r12) {
        return dateYearDay(r10, r11, r12);
    }

    @Override // org.threeten.bp.chrono.e
    public IsoEra eraOf(int r10) {
        return IsoEra.of(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public LocalDateTime localDateTime(TemporalAccessor r10) {
        return LocalDateTime.from(r10);
    }

    public LocalDate resolveDate(Map<TemporalField, Long> r11, ResolverStyle r12) {
        ChronoField r10 = ChronoField.EPOCH_DAY;
        if (r11.containsKey(r10) == true) goto L5;
        ChronoField r13 = ChronoField.PROLEPTIC_MONTH;
        Long r14 = r11.remove(r13);
        if (r14 != null) goto L9;
    L12:
        ChronoField r15 = ChronoField.YEAR_OF_ERA;
        Long r16 = r11.remove(r15);
        if (r16 != null) goto L15;
        ChronoField r17 = ChronoField.ERA;
        if (r11.containsKey(r17) == false) goto L46;
        r17.checkValidValue(r11.get(r17).longValue());
    L46:
        ChronoField r18 = ChronoField.YEAR;
        if (r11.containsKey(r18) == false) goto L143;
        ChronoField r19 = ChronoField.MONTH_OF_YEAR;
        if (r11.containsKey(r19) == false) goto L105;
        ChronoField r20 = ChronoField.DAY_OF_MONTH;
        if (r11.containsKey(r20) == false) goto L75;
        int r110 = r18.checkValidIntValue(r11.remove(r18).longValue());
        int r21 = ig.d.p(r11.remove(r19).longValue());
        int r111 = ig.d.p(r11.remove(r20).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L57;
        long r22 = ig.d.n(r21, 1);
        return LocalDate.of(r110, 1, 1).plusMonths(r22).plusDays(ig.d.n(r111, 1));
    L57:
        if (r12 != ResolverStyle.SMART) goto L74;
        r20.checkValidValue(r111);
        if (r21 != 4) goto L61;
    L70:
        r111 = Math.min(r111, 30);
    L72:
        return LocalDate.of(r110, r21, r111);
    L61:
        if (r21 == 6) goto L70;
        if (r21 == 9) goto L70;
        if (r21 == 11) goto L70;
        if (r21 != 2) goto L72;
        r111 = Math.min(r111, Month.FEBRUARY.length(Year.isLeap(r110)));
        goto L72
    L74:
        return LocalDate.of(r110, r21, r111);
    L75:
        ChronoField r23 = ChronoField.ALIGNED_WEEK_OF_MONTH;
        if (r11.containsKey(r23) == false) goto L105;
        ChronoField r24 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
        if (r11.containsKey(r24) == false) goto L91;
        int r112 = r18.checkValidIntValue(r11.remove(r18).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L83;
        long r25 = ig.d.o(r11.remove(r19).longValue(), 1);
        long r26 = ig.d.o(r11.remove(r23).longValue(), 1);
        return LocalDate.of(r112, 1, 1).plusMonths(r25).plusWeeks(r26).plusDays(ig.d.o(r11.remove(r24).longValue(), 1));
    L83:
        int r27 = r19.checkValidIntValue(r11.remove(r19).longValue());
        LocalDate r113 = LocalDate.of(r112, r27, 1).plusDays(((r23.checkValidIntValue(r11.remove(r23).longValue()) - 1) * 7) + (r24.checkValidIntValue(r11.remove(r24).longValue()) - 1));
        if (r12 == ResolverStyle.STRICT) goto L86;
    L90:
        return r113;
    L86:
        if (r113.get(r19) == r27) goto L90;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L91:
        ChronoField r28 = ChronoField.DAY_OF_WEEK;
        if (r11.containsKey(r28) == false) goto L105;
        int r114 = r18.checkValidIntValue(r11.remove(r18).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L97;
        long r29 = ig.d.o(r11.remove(r19).longValue(), 1);
        long r30 = ig.d.o(r11.remove(r23).longValue(), 1);
        return LocalDate.of(r114, 1, 1).plusMonths(r29).plusWeeks(r30).plusDays(ig.d.o(r11.remove(r28).longValue(), 1));
    L97:
        int r31 = r19.checkValidIntValue(r11.remove(r19).longValue());
        LocalDate r115 = LocalDate.of(r114, r31, 1).plusWeeks(r23.checkValidIntValue(r11.remove(r23).longValue()) - 1).with(org.threeten.bp.temporal.a.a(DayOfWeek.of(r28.checkValidIntValue(r11.remove(r28).longValue()))));
        if (r12 == ResolverStyle.STRICT) goto L100;
    L104:
        return r115;
    L100:
        if (r115.get(r19) == r31) goto L104;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L105:
        ChronoField r32 = ChronoField.DAY_OF_YEAR;
        if (r11.containsKey(r32) == false) goto L113;
        int r116 = r18.checkValidIntValue(r11.remove(r18).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L112;
        return LocalDate.ofYearDay(r116, 1).plusDays(ig.d.o(r11.remove(r32).longValue(), 1));
    L112:
        return LocalDate.ofYearDay(r116, r32.checkValidIntValue(r11.remove(r32).longValue()));
    L113:
        ChronoField r33 = ChronoField.ALIGNED_WEEK_OF_YEAR;
        if (r11.containsKey(r33) == false) goto L145;
        ChronoField r34 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        if (r11.containsKey(r34) == false) goto L129;
        int r35 = r18.checkValidIntValue(r11.remove(r18).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L121;
        long r36 = ig.d.o(r11.remove(r33).longValue(), 1);
        return LocalDate.of(r35, 1, 1).plusWeeks(r36).plusDays(ig.d.o(r11.remove(r34).longValue(), 1));
    L121:
        LocalDate r117 = LocalDate.of(r35, 1, 1).plusDays(((r33.checkValidIntValue(r11.remove(r33).longValue()) - 1) * 7) + (r34.checkValidIntValue(r11.remove(r34).longValue()) - 1));
        if (r12 == ResolverStyle.STRICT) goto L124;
    L128:
        return r117;
    L124:
        if (r117.get(r18) == r35) goto L128;
        throw new DateTimeException("Strict mode rejected date parsed to a different year");
    L129:
        ChronoField r37 = ChronoField.DAY_OF_WEEK;
        if (r11.containsKey(r37) == false) goto L146;
        int r38 = r18.checkValidIntValue(r11.remove(r18).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L135;
        long r39 = ig.d.o(r11.remove(r33).longValue(), 1);
        return LocalDate.of(r38, 1, 1).plusWeeks(r39).plusDays(ig.d.o(r11.remove(r37).longValue(), 1));
    L135:
        LocalDate r118 = LocalDate.of(r38, 1, 1).plusWeeks(r33.checkValidIntValue(r11.remove(r33).longValue()) - 1).with(org.threeten.bp.temporal.a.a(DayOfWeek.of(r37.checkValidIntValue(r11.remove(r37).longValue()))));
        if (r12 == ResolverStyle.STRICT) goto L138;
    L142:
        return r118;
    L138:
        if (r118.get(r18) == r38) goto L142;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L146:
        return null;
    L145:
        return null;
    L143:
        return null;
    L15:
        if (r12 == ResolverStyle.LENIENT) goto L17;
        r15.checkValidValue(r16.longValue());
    L17:
        Long r40 = r11.remove(ChronoField.ERA);
        if (r40 != null) goto L36;
        ChronoField r41 = ChronoField.YEAR;
        Long r42 = r11.get(r41);
        if (r12 != ResolverStyle.STRICT) goto L28;
        if (r42 != null) goto L23;
        r11.put(r15, r16);
        goto L46
    L23:
        if (r42.longValue() <= 0) goto L25;
        long r43 = r16.longValue();
    L26:
        updateResolveMap(r11, r41, r43);
        goto L46
    L25:
        r43 = ig.d.o(1, r16.longValue());
        goto L26
    L28:
        if (r42 != null) goto L30;
    L33:
        long r44 = r16.longValue();
    L34:
        updateResolveMap(r11, r41, r44);
        goto L46
    L30:
        if (r42.longValue() > 0) goto L33;
        r44 = ig.d.o(1, r16.longValue());
        goto L34
    L36:
        if (r40.longValue() != 1) goto L39;
        updateResolveMap(r11, ChronoField.YEAR, r16.longValue());
        goto L46
    L39:
        if (r40.longValue() != 0) goto L42;
        updateResolveMap(r11, ChronoField.YEAR, ig.d.o(1, r16.longValue()));
        goto L46
    L42:
        throw new DateTimeException("Invalid value for era: " + r40);
    L9:
        if (r12 == ResolverStyle.LENIENT) goto L11;
        r13.checkValidValue(r14.longValue());
    L11:
        updateResolveMap(r11, ChronoField.MONTH_OF_YEAR, ig.d.f(r14.longValue(), 12) + 1);
        updateResolveMap(r11, ChronoField.YEAR, ig.d.d(r14.longValue(), 12));
        goto L12
    L5:
        return LocalDate.ofEpochDay(r11.remove(r10).longValue());
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ d zonedDateTime(TemporalAccessor r10) {
        return zonedDateTime(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ a date(TemporalAccessor r10) {
        return date(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ a dateNow(ZoneId r10) {
        return dateNow(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public LocalDate dateYearDay(Era r10, int r11, int r12) {
        return dateYearDay(prolepticYear(r10, r11), r12);
    }

    @Override // org.threeten.bp.chrono.e
    public ZonedDateTime zonedDateTime(TemporalAccessor r10) {
        return ZonedDateTime.from(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public LocalDate date(Era r10, int r11, int r12, int r13) {
        return date(prolepticYear(r10, r11), r12, r13);
    }

    @Override // org.threeten.bp.chrono.e
    public LocalDate dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    @Override // org.threeten.bp.chrono.e
    public LocalDate dateYearDay(int r10, int r11) {
        return LocalDate.ofYearDay(r10, r11);
    }

    @Override // org.threeten.bp.chrono.e
    public ZonedDateTime zonedDateTime(Instant r10, ZoneId r11) {
        return ZonedDateTime.ofInstant(r10, r11);
    }

    @Override // org.threeten.bp.chrono.e
    public LocalDate date(int r10, int r11, int r12) {
        return LocalDate.of(r10, r11, r12);
    }

    @Override // org.threeten.bp.chrono.e
    public LocalDate dateNow(ZoneId r10) {
        return dateNow(Clock.system(r10));
    }

    @Override // org.threeten.bp.chrono.e
    public LocalDate date(TemporalAccessor r10) {
        return LocalDate.from(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public LocalDate dateNow(Clock r10) {
        ig.d.h(r10, "clock");
        return date(LocalDate.now(r10));
    }
}
