package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes4.dex */
public final class HijrahChronology extends e implements Serializable {
    private static final HashMap<String, String[]> ERA_FULL_NAMES = null;
    private static final HashMap<String, String[]> ERA_NARROW_NAMES = null;
    private static final HashMap<String, String[]> ERA_SHORT_NAMES = null;
    private static final String FALLBACK_LANGUAGE = "en";
    public static final HijrahChronology INSTANCE = null;
    private static final long serialVersionUID = 3127340209035924785L;

    static {
        INSTANCE = new HijrahChronology();
        HashMap<String, String[]> r10 = new HashMap();
        ERA_NARROW_NAMES = r10;
        HashMap<String, String[]> r11 = new HashMap();
        ERA_SHORT_NAMES = r11;
        HashMap<String, String[]> r12 = new HashMap();
        ERA_FULL_NAMES = r12;
        r10.put(FALLBACK_LANGUAGE, new String[]{"BH", "HE"});
        r11.put(FALLBACK_LANGUAGE, new String[]{"B.H.", "H.E."});
        r12.put(FALLBACK_LANGUAGE, new String[]{"Before Hijrah", "Hijrah Era"});
    }

    private HijrahChronology() {
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
        return Arrays.asList(HijrahEra.values());
    }

    @Override // org.threeten.bp.chrono.e
    public String getCalendarType() {
        return "islamic-umalqura";
    }

    @Override // org.threeten.bp.chrono.e
    public String getId() {
        return "Hijrah-umalqura";
    }

    @Override // org.threeten.bp.chrono.e
    public boolean isLeapYear(long r10) {
        return HijrahDate.isLeapYear(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public b localDateTime(TemporalAccessor r10) {
        return super.localDateTime(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public int prolepticYear(Era r10, int r11) {
        if ((r10 instanceof HijrahEra) == false) goto L10;
        if (r10 != HijrahEra.AH) goto L8;
        return r11;
    L8:
        return 1 - r11;
    L10:
        throw new ClassCastException("Era must be HijrahEra");
    }

    @Override // org.threeten.bp.chrono.e
    public ValueRange range(ChronoField r10) {
        return r10.range();
    }

    /* JADX INFO: renamed from: resolveDate, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ a m68resolveDate(Map r10, ResolverStyle r11) {
        return resolveDate(r10, r11);
    }

    @Override // org.threeten.bp.chrono.e
    public d zonedDateTime(TemporalAccessor r10) {
        return super.zonedDateTime(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ a date(Era r10, int r11, int r12, int r13) {
        return date(r10, r11, r12, r13);
    }

    @Override // org.threeten.bp.chrono.e
    public HijrahDate dateEpochDay(long r10) {
        return HijrahDate.of(LocalDate.ofEpochDay(r10));
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
    public HijrahEra eraOf(int r10) {
        if (r10 == 0) goto L10;
        if (r10 != 1) goto L8;
        return HijrahEra.AH;
    L8:
        throw new DateTimeException("invalid Hijrah era");
    L10:
        return HijrahEra.BEFORE_AH;
    }

    public HijrahDate resolveDate(Map<TemporalField, Long> r11, ResolverStyle r12) {
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
        if (r11.containsKey(r18) == false) goto L131;
        ChronoField r19 = ChronoField.MONTH_OF_YEAR;
        if (r11.containsKey(r19) == false) goto L93;
        ChronoField r20 = ChronoField.DAY_OF_MONTH;
        if (r11.containsKey(r20) == false) goto L63;
        int r21 = r18.checkValidIntValue(r11.remove(r18).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L56;
        long r22 = ig.d.o(r11.remove(r19).longValue(), 1);
        return date(r21, 1, 1).plusMonths(r22).plusDays(ig.d.o(r11.remove(r20).longValue(), 1));
    L56:
        int r23 = range(r19).checkValidIntValue(r11.remove(r19).longValue(), r19);
        int r110 = range(r20).checkValidIntValue(r11.remove(r20).longValue(), r20);
        if (r12 != ResolverStyle.SMART) goto L62;
        if (r110 <= 28) goto L62;
        r110 = Math.min(r110, date(r21, r23, 1).lengthOfMonth());
    L62:
        return date(r21, r23, r110);
    L63:
        ChronoField r24 = ChronoField.ALIGNED_WEEK_OF_MONTH;
        if (r11.containsKey(r24) == false) goto L93;
        ChronoField r25 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
        if (r11.containsKey(r25) == false) goto L79;
        int r26 = r18.checkValidIntValue(r11.remove(r18).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L71;
        long r27 = ig.d.o(r11.remove(r19).longValue(), 1);
        long r28 = ig.d.o(r11.remove(r24).longValue(), 1);
        return date(r26, 1, 1).plus(r27, ChronoUnit.MONTHS).plus(r28, ChronoUnit.WEEKS).plus(ig.d.o(r11.remove(r25).longValue(), 1), ChronoUnit.DAYS);
    L71:
        int r29 = r19.checkValidIntValue(r11.remove(r19).longValue());
        HijrahDate r111 = date(r26, r29, 1).plus(((r24.checkValidIntValue(r11.remove(r24).longValue()) - 1) * 7) + (r25.checkValidIntValue(r11.remove(r25).longValue()) - 1), ChronoUnit.DAYS);
        if (r12 == ResolverStyle.STRICT) goto L74;
    L78:
        return r111;
    L74:
        if (r111.get(r19) == r29) goto L78;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L79:
        ChronoField r30 = ChronoField.DAY_OF_WEEK;
        if (r11.containsKey(r30) == false) goto L93;
        int r31 = r18.checkValidIntValue(r11.remove(r18).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L85;
        long r32 = ig.d.o(r11.remove(r19).longValue(), 1);
        long r33 = ig.d.o(r11.remove(r24).longValue(), 1);
        return date(r31, 1, 1).plus(r32, ChronoUnit.MONTHS).plus(r33, ChronoUnit.WEEKS).plus(ig.d.o(r11.remove(r30).longValue(), 1), ChronoUnit.DAYS);
    L85:
        int r34 = r19.checkValidIntValue(r11.remove(r19).longValue());
        HijrahDate r112 = date(r31, r34, 1).plus(r24.checkValidIntValue(r11.remove(r24).longValue()) - 1, ChronoUnit.WEEKS).with(org.threeten.bp.temporal.a.a(DayOfWeek.of(r30.checkValidIntValue(r11.remove(r30).longValue()))));
        if (r12 == ResolverStyle.STRICT) goto L88;
    L92:
        return r112;
    L88:
        if (r112.get(r19) == r34) goto L92;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L93:
        ChronoField r35 = ChronoField.DAY_OF_YEAR;
        if (r11.containsKey(r35) == false) goto L101;
        int r36 = r18.checkValidIntValue(r11.remove(r18).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L100;
        return dateYearDay(r36, 1).plusDays(ig.d.o(r11.remove(r35).longValue(), 1));
    L100:
        return dateYearDay(r36, r35.checkValidIntValue(r11.remove(r35).longValue()));
    L101:
        ChronoField r37 = ChronoField.ALIGNED_WEEK_OF_YEAR;
        if (r11.containsKey(r37) == false) goto L133;
        ChronoField r38 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        if (r11.containsKey(r38) == false) goto L117;
        int r39 = r18.checkValidIntValue(r11.remove(r18).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L109;
        long r40 = ig.d.o(r11.remove(r37).longValue(), 1);
        return date(r39, 1, 1).plus(r40, ChronoUnit.WEEKS).plus(ig.d.o(r11.remove(r38).longValue(), 1), ChronoUnit.DAYS);
    L109:
        HijrahDate r113 = date(r39, 1, 1).plusDays(((r37.checkValidIntValue(r11.remove(r37).longValue()) - 1) * 7) + (r38.checkValidIntValue(r11.remove(r38).longValue()) - 1));
        if (r12 == ResolverStyle.STRICT) goto L112;
    L116:
        return r113;
    L112:
        if (r113.get(r18) == r39) goto L116;
        throw new DateTimeException("Strict mode rejected date parsed to a different year");
    L117:
        ChronoField r41 = ChronoField.DAY_OF_WEEK;
        if (r11.containsKey(r41) == false) goto L134;
        int r42 = r18.checkValidIntValue(r11.remove(r18).longValue());
        if (r12 != ResolverStyle.LENIENT) goto L123;
        long r43 = ig.d.o(r11.remove(r37).longValue(), 1);
        return date(r42, 1, 1).plus(r43, ChronoUnit.WEEKS).plus(ig.d.o(r11.remove(r41).longValue(), 1), ChronoUnit.DAYS);
    L123:
        HijrahDate r114 = date(r42, 1, 1).plus(r37.checkValidIntValue(r11.remove(r37).longValue()) - 1, ChronoUnit.WEEKS).with(org.threeten.bp.temporal.a.a(DayOfWeek.of(r41.checkValidIntValue(r11.remove(r41).longValue()))));
        if (r12 == ResolverStyle.STRICT) goto L126;
    L130:
        return r114;
    L126:
        if (r114.get(r18) == r42) goto L130;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L134:
        return null;
    L133:
        return null;
    L131:
        return null;
    L15:
        if (r12 == ResolverStyle.LENIENT) goto L17;
        r15.checkValidValue(r16.longValue());
    L17:
        Long r44 = r11.remove(ChronoField.ERA);
        if (r44 != null) goto L36;
        ChronoField r45 = ChronoField.YEAR;
        Long r46 = r11.get(r45);
        if (r12 != ResolverStyle.STRICT) goto L28;
        if (r46 != null) goto L23;
        r11.put(r15, r16);
        goto L46
    L23:
        if (r46.longValue() <= 0) goto L25;
        long r47 = r16.longValue();
    L26:
        updateResolveMap(r11, r45, r47);
        goto L46
    L25:
        r47 = ig.d.o(1, r16.longValue());
        goto L26
    L28:
        if (r46 != null) goto L30;
    L33:
        long r48 = r16.longValue();
    L34:
        updateResolveMap(r11, r45, r48);
        goto L46
    L30:
        if (r46.longValue() > 0) goto L33;
        r48 = ig.d.o(1, r16.longValue());
        goto L34
    L36:
        if (r44.longValue() != 1) goto L39;
        updateResolveMap(r11, ChronoField.YEAR, r16.longValue());
        goto L46
    L39:
        if (r44.longValue() != 0) goto L42;
        updateResolveMap(r11, ChronoField.YEAR, ig.d.o(1, r16.longValue()));
        goto L46
    L42:
        throw new DateTimeException("Invalid value for era: " + r44);
    L9:
        if (r12 == ResolverStyle.LENIENT) goto L11;
        r13.checkValidValue(r14.longValue());
    L11:
        updateResolveMap(r11, ChronoField.MONTH_OF_YEAR, ig.d.f(r14.longValue(), 12) + 1);
        updateResolveMap(r11, ChronoField.YEAR, ig.d.d(r14.longValue(), 12));
        goto L12
    L5:
        return dateEpochDay(r11.remove(r10).longValue());
    }

    @Override // org.threeten.bp.chrono.e
    public d zonedDateTime(Instant r10, ZoneId r11) {
        return super.zonedDateTime(r10, r11);
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
    public HijrahDate dateYearDay(Era r10, int r11, int r12) {
        return (HijrahDate) super.dateYearDay(r10, r11, r12);
    }

    @Override // org.threeten.bp.chrono.e
    public HijrahDate date(Era r10, int r11, int r12, int r13) {
        return (HijrahDate) super.date(r10, r11, r12, r13);
    }

    @Override // org.threeten.bp.chrono.e
    public HijrahDate dateNow() {
        return (HijrahDate) super.dateNow();
    }

    @Override // org.threeten.bp.chrono.e
    public HijrahDate dateYearDay(int r10, int r11) {
        return HijrahDate.of(r10, 1, 1).plusDays(r11 - 1);
    }

    @Override // org.threeten.bp.chrono.e
    public HijrahDate date(int r10, int r11, int r12) {
        return HijrahDate.of(r10, r11, r12);
    }

    @Override // org.threeten.bp.chrono.e
    public HijrahDate dateNow(ZoneId r10) {
        return (HijrahDate) super.dateNow(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public HijrahDate date(TemporalAccessor r10) {
        if ((r10 instanceof HijrahDate) == false) goto L7;
        return (HijrahDate) r10;
    L7:
        return HijrahDate.ofEpochDay(r10.getLong(ChronoField.EPOCH_DAY));
    }

    @Override // org.threeten.bp.chrono.e
    public HijrahDate dateNow(Clock r10) {
        ig.d.h(r10, "clock");
        return (HijrahDate) super.dateNow(r10);
    }
}
