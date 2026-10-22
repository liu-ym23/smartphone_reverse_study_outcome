package org.threeten.bp.chrono;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlinx.coroutines.channels.Channel;
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
public final class JapaneseChronology extends e implements Serializable {
    private static final Map<String, String[]> ERA_FULL_NAMES = null;
    private static final Map<String, String[]> ERA_NARROW_NAMES = null;
    private static final Map<String, String[]> ERA_SHORT_NAMES = null;
    private static final String FALLBACK_LANGUAGE = "en";
    public static final JapaneseChronology INSTANCE = null;
    static final Locale LOCALE = null;
    private static final String TARGET_LANGUAGE = "ja";
    private static final long serialVersionUID = 459996390165777884L;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23090a = null;

        static {
            int[] r10 = new int[ChronoField.values().length];
            f23090a = r10;
            r10[ChronoField.DAY_OF_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L80:
            f23090a[ChronoField.DAY_OF_WEEK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L58:
            f23090a[ChronoField.MICRO_OF_DAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L74:
            f23090a[ChronoField.MICRO_OF_SECOND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L82:
            f23090a[ChronoField.HOUR_OF_DAY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L60:
            f23090a[ChronoField.HOUR_OF_AMPM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L32
        L66:
            f23090a[ChronoField.MINUTE_OF_DAY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L33
        L94:
            f23090a[ChronoField.MINUTE_OF_HOUR.ordinal()] = 8;     // Catch: NoSuchFieldError -> L34
        L52:
            f23090a[ChronoField.SECOND_OF_DAY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L35
        L86:
            f23090a[ChronoField.SECOND_OF_MINUTE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L36
        L90:
            f23090a[ChronoField.MILLI_OF_DAY.ordinal()] = 11;     // Catch: NoSuchFieldError -> L37
        L70:
            f23090a[ChronoField.MILLI_OF_SECOND.ordinal()] = 12;     // Catch: NoSuchFieldError -> L38
        L78:
            f23090a[ChronoField.NANO_OF_DAY.ordinal()] = 13;     // Catch: NoSuchFieldError -> L39
        L56:
            f23090a[ChronoField.NANO_OF_SECOND.ordinal()] = 14;     // Catch: NoSuchFieldError -> L40
        L64:
            f23090a[ChronoField.CLOCK_HOUR_OF_DAY.ordinal()] = 15;     // Catch: NoSuchFieldError -> L41
        L92:
            f23090a[ChronoField.CLOCK_HOUR_OF_AMPM.ordinal()] = 16;     // Catch: NoSuchFieldError -> L42
        L50:
            f23090a[ChronoField.EPOCH_DAY.ordinal()] = 17;     // Catch: NoSuchFieldError -> L43
        L84:
            f23090a[ChronoField.PROLEPTIC_MONTH.ordinal()] = 18;     // Catch: NoSuchFieldError -> L44
        L88:
            f23090a[ChronoField.ERA.ordinal()] = 19;     // Catch: NoSuchFieldError -> L45
        L68:
            f23090a[ChronoField.YEAR.ordinal()] = 20;     // Catch: NoSuchFieldError -> L46
        L76:
            f23090a[ChronoField.YEAR_OF_ERA.ordinal()] = 21;     // Catch: NoSuchFieldError -> L47
        L54:
            f23090a[ChronoField.MONTH_OF_YEAR.ordinal()] = 22;     // Catch: NoSuchFieldError -> L48
        L62:
            f23090a[ChronoField.DAY_OF_YEAR.ordinal()] = 23;     // Catch: NoSuchFieldError -> L49
            return;
        }
    }

    static {
        LOCALE = new Locale(TARGET_LANGUAGE, "JP", "JP");
        INSTANCE = new JapaneseChronology();
        HashMap r10 = new HashMap();
        ERA_NARROW_NAMES = r10;
        HashMap r11 = new HashMap();
        ERA_SHORT_NAMES = r11;
        HashMap r12 = new HashMap();
        ERA_FULL_NAMES = r12;
        r10.put(FALLBACK_LANGUAGE, new String[]{"Unknown", "K", "M", "T", "S", "H"});
        r10.put(TARGET_LANGUAGE, new String[]{"Unknown", "K", "M", "T", "S", "H"});
        r11.put(FALLBACK_LANGUAGE, new String[]{"Unknown", "K", "M", "T", "S", "H"});
        r11.put(TARGET_LANGUAGE, new String[]{"Unknown", "慶", "明", "大", "昭", "平"});
        r12.put(FALLBACK_LANGUAGE, new String[]{"Unknown", "Keio", "Meiji", "Taisho", "Showa", "Heisei"});
        r12.put(TARGET_LANGUAGE, new String[]{"Unknown", "慶応", "明治", "大正", "昭和", "平成"});
    }

    private JapaneseChronology() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    private JapaneseDate resolveEYD(Map<TemporalField, Long> r10, ResolverStyle r11, JapaneseEra r12, int r13) {
        if (r11 != ResolverStyle.LENIENT) goto L6;
        int r14 = (r12.startDate().getYear() + r13) - 1;
        long r15 = ig.d.o(r10.remove(ChronoField.DAY_OF_YEAR).longValue(), 1);
        return dateYearDay(r14, 1).plus(r15, ChronoUnit.DAYS);
    L6:
        ChronoField r16 = ChronoField.DAY_OF_YEAR;
        return dateYearDay(r12, r13, range(r16).checkValidIntValue(r10.remove(r16).longValue(), r16));
    }

    private JapaneseDate resolveEYMD(Map<TemporalField, Long> r10, ResolverStyle r11, JapaneseEra r12, int r13) {
        if (r11 != ResolverStyle.LENIENT) goto L6;
        int r14 = (r12.startDate().getYear() + r13) - 1;
        long r15 = ig.d.o(r10.remove(ChronoField.MONTH_OF_YEAR).longValue(), 1);
        return date(r14, 1, 1).plus(r15, ChronoUnit.MONTHS).plus(ig.d.o(r10.remove(ChronoField.DAY_OF_MONTH).longValue(), 1), ChronoUnit.DAYS);
    L6:
        ChronoField r16 = ChronoField.MONTH_OF_YEAR;
        int r17 = range(r16).checkValidIntValue(r10.remove(r16).longValue(), r16);
        ChronoField r18 = ChronoField.DAY_OF_MONTH;
        int r19 = range(r18).checkValidIntValue(r10.remove(r18).longValue(), r18);
        if (r11 != ResolverStyle.SMART) goto L28;
        if (r13 < 1) goto L26;
        int r20 = (r12.startDate().getYear() + r13) - 1;
        if (r19 <= 28) goto L12;
        r19 = Math.min(r19, date(r20, r17, 1).lengthOfMonth());
    L12:
        JapaneseDate r21 = date(r20, r17, r19);
        if (r21.getEra() != r12) goto L15;
    L24:
        return r21;
    L15:
        if (Math.abs(r21.getEra().getValue() - r12.getValue()) > 1) goto L23;
        if (r21.get(ChronoField.YEAR_OF_ERA) == 1) goto L24;
        if (r13 == 1) goto L24;
        throw new DateTimeException("Invalid Era/YearOfEra: " + r12 + " " + r13);
    L23:
        throw new DateTimeException("Invalid Era/YearOfEra: " + r12 + " " + r13);
    L26:
        throw new DateTimeException("Invalid YearOfEra: " + r13);
    L28:
        return date(r12, r13, r17, r19);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a date(int r10, int r11, int r12) {
        return date(r10, r11, r12);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a dateEpochDay(long r10) {
        return dateEpochDay(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a dateNow() {
        return dateNow();
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a dateYearDay(int r10, int r11) {
        return dateYearDay(r10, r11);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ Era eraOf(int r10) {
        return eraOf(r10);
    }

    public List<Era> eras() {
        return Arrays.asList(JapaneseEra.values());
    }

    @Override // org.threeten.bp.chrono.e
    public String getCalendarType() {
        return "japanese";
    }

    @Override // org.threeten.bp.chrono.e
    public String getId() {
        return "Japanese";
    }

    @Override // org.threeten.bp.chrono.e
    public boolean isLeapYear(long r10) {
        return IsoChronology.INSTANCE.isLeapYear(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public b localDateTime(TemporalAccessor r10) {
        return super.localDateTime(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public int prolepticYear(Era r10, int r11) {
        if ((r10 instanceof JapaneseEra) == false) goto L7;
        JapaneseEra r12 = (JapaneseEra) r10;
        int r13 = (r12.startDate().getYear() + r11) - 1;
        ValueRange.of(1, (r12.endDate().getYear() - r12.startDate().getYear()) + 1).checkValidValue(r11, ChronoField.YEAR_OF_ERA);
        return r13;
    L7:
        throw new ClassCastException("Era must be JapaneseEra");
    }

    @Override // org.threeten.bp.chrono.e
    public ValueRange range(ChronoField r11) {
        int[] r10 = a.f23090a;
        switch(r10[r11.ordinal()]) {
            case 1: goto L27;
            case 2: goto L27;
            case 3: goto L27;
            case 4: goto L27;
            case 5: goto L27;
            case 6: goto L27;
            case 7: goto L27;
            case 8: goto L27;
            case 9: goto L27;
            case 10: goto L27;
            case 11: goto L27;
            case 12: goto L27;
            case 13: goto L27;
            case 14: goto L27;
            case 15: goto L27;
            case 16: goto L27;
            case 17: goto L27;
            case 18: goto L27;
            default: goto L4;
        };
    L4:
        Calendar r12 = Calendar.getInstance(LOCALE);
        int r13 = 0;
        switch(r10[r11.ordinal()]) {
            case 19: goto L24;
            case 20: goto L22;
            case 21: goto L16;
            case 22: goto L15;
            case 23: goto L8;
            default: goto L7;
        };
    L8:
        JapaneseEra[] r14 = JapaneseEra.values();
        int r15 = 366;
    L10:
        if (r13 >= r14.length) goto L13;
        r15 = Math.min(r15, (r14[r13].startDate().lengthOfYear() - r14[r13].startDate().getDayOfYear()) + 1);
        r13 = r13 + 1;
        goto L10
    L13:
        return ValueRange.of(1, r15, 366);
    L16:
        JapaneseEra[] r16 = JapaneseEra.values();
        int r17 = (r16[r16.length - 1].endDate().getYear() - r16[r16.length - 1].startDate().getYear()) + 1;
        int r18 = Channel.UNLIMITED;
    L18:
        if (r13 >= r16.length) goto L21;
        r18 = Math.min(r18, (r16[r13].endDate().getYear() - r16[r13].startDate().getYear()) + 1);
        r13 = r13 + 1;
        goto L18
    L21:
        return ValueRange.of(1, 6, r18, r17);
    L22:
        JapaneseEra[] r19 = JapaneseEra.values();
        return ValueRange.of(JapaneseDate.MIN_DATE.getYear(), r19[r19.length - 1].endDate().getYear());
    L24:
        JapaneseEra[] r110 = JapaneseEra.values();
        return ValueRange.of(r110[0].getValue(), r110[r110.length - 1].getValue());
    L7:
        throw new UnsupportedOperationException("Unimplementable field: " + r11);
    L15:
        return ValueRange.of(r12.getMinimum(2) + 1, r12.getGreatestMinimum(2) + 1, r12.getLeastMaximum(2) + 1, r12.getMaximum(2) + 1);
    L27:
        return r11.range();
    }

    /* JADX INFO: renamed from: resolveDate, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a m70resolveDate(Map r10, ResolverStyle r11) {
        return resolveDate(r10, r11);
    }

    @Override // org.threeten.bp.chrono.e
    public d zonedDateTime(TemporalAccessor r10) {
        return super.zonedDateTime(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a date(Era r10, int r11, int r12, int r13) {
        return date(r10, r11, r12, r13);
    }

    @Override // org.threeten.bp.chrono.e
    public JapaneseDate dateEpochDay(long r10) {
        return new JapaneseDate(LocalDate.ofEpochDay(r10));
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a dateNow(Clock r10) {
        return dateNow(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a dateYearDay(Era r10, int r11, int r12) {
        return dateYearDay(r10, r11, r12);
    }

    @Override // org.threeten.bp.chrono.e
    public JapaneseEra eraOf(int r10) {
        return JapaneseEra.of(r10);
    }

    public JapaneseDate resolveDate(Map<TemporalField, Long> r12, ResolverStyle r13) {
        ChronoField r10 = ChronoField.EPOCH_DAY;
        if (r12.containsKey(r10) == true) goto L5;
        ChronoField r11 = ChronoField.PROLEPTIC_MONTH;
        Long r14 = r12.remove(r11);
        if (r14 != null) goto L9;
    L12:
        ChronoField r15 = ChronoField.ERA;
        Long r16 = r12.get(r15);
        if (r16 == null) goto L15;
        JapaneseEra r17 = eraOf(range(r15).checkValidIntValue(r16.longValue(), r15));
    L16:
        ChronoField r18 = ChronoField.YEAR_OF_ERA;
        Long r19 = r12.get(r18);
        if (r19 == null) goto L37;
        int r20 = range(r18).checkValidIntValue(r19.longValue(), r18);
        if (r17 == null) goto L21;
    L25:
        if (r17 != null) goto L27;
    L32:
        if (r17 == null) goto L37;
        if (r12.containsKey(ChronoField.DAY_OF_YEAR) == false) goto L37;
        r12.remove(r15);
        r12.remove(r18);
        return resolveEYD(r12, r13, r17, r20);
    L27:
        if (r12.containsKey(ChronoField.MONTH_OF_YEAR) == false) goto L32;
        if (r12.containsKey(ChronoField.DAY_OF_MONTH) == false) goto L32;
        r12.remove(r15);
        r12.remove(r18);
        return resolveEYMD(r12, r13, r17, r20);
    L21:
        if (r13 == ResolverStyle.STRICT) goto L25;
        if (r12.containsKey(ChronoField.YEAR) == true) goto L25;
        List<Era> r21 = eras();
        r17 = (JapaneseEra) r21.get(r21.size() - 1);
    L37:
        ChronoField r22 = ChronoField.YEAR;
        if (r12.containsKey(r22) == false) goto L122;
        ChronoField r23 = ChronoField.MONTH_OF_YEAR;
        if (r12.containsKey(r23) == false) goto L84;
        ChronoField r24 = ChronoField.DAY_OF_MONTH;
        if (r12.containsKey(r24) == false) goto L54;
        int r25 = r22.checkValidIntValue(r12.remove(r22).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L47;
        long r26 = ig.d.o(r12.remove(r23).longValue(), 1);
        return date(r25, 1, 1).plusMonths(r26).plusDays(ig.d.o(r12.remove(r24).longValue(), 1));
    L47:
        int r27 = range(r23).checkValidIntValue(r12.remove(r23).longValue(), r23);
        int r110 = range(r24).checkValidIntValue(r12.remove(r24).longValue(), r24);
        if (r13 != ResolverStyle.SMART) goto L53;
        if (r110 <= 28) goto L53;
        r110 = Math.min(r110, date(r25, r27, 1).lengthOfMonth());
    L53:
        return date(r25, r27, r110);
    L54:
        ChronoField r28 = ChronoField.ALIGNED_WEEK_OF_MONTH;
        if (r12.containsKey(r28) == false) goto L84;
        ChronoField r29 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH;
        if (r12.containsKey(r29) == false) goto L70;
        int r30 = r22.checkValidIntValue(r12.remove(r22).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L62;
        long r31 = ig.d.o(r12.remove(r23).longValue(), 1);
        long r32 = ig.d.o(r12.remove(r28).longValue(), 1);
        return date(r30, 1, 1).plus(r31, ChronoUnit.MONTHS).plus(r32, ChronoUnit.WEEKS).plus(ig.d.o(r12.remove(r29).longValue(), 1), ChronoUnit.DAYS);
    L62:
        int r33 = r23.checkValidIntValue(r12.remove(r23).longValue());
        JapaneseDate r111 = date(r30, r33, 1).plus(((r28.checkValidIntValue(r12.remove(r28).longValue()) - 1) * 7) + (r29.checkValidIntValue(r12.remove(r29).longValue()) - 1), ChronoUnit.DAYS);
        if (r13 == ResolverStyle.STRICT) goto L65;
    L69:
        return r111;
    L65:
        if (r111.get(r23) == r33) goto L69;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L70:
        ChronoField r34 = ChronoField.DAY_OF_WEEK;
        if (r12.containsKey(r34) == false) goto L84;
        int r35 = r22.checkValidIntValue(r12.remove(r22).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L76;
        long r36 = ig.d.o(r12.remove(r23).longValue(), 1);
        long r37 = ig.d.o(r12.remove(r28).longValue(), 1);
        return date(r35, 1, 1).plus(r36, ChronoUnit.MONTHS).plus(r37, ChronoUnit.WEEKS).plus(ig.d.o(r12.remove(r34).longValue(), 1), ChronoUnit.DAYS);
    L76:
        int r38 = r23.checkValidIntValue(r12.remove(r23).longValue());
        JapaneseDate r112 = date(r35, r38, 1).plus(r28.checkValidIntValue(r12.remove(r28).longValue()) - 1, ChronoUnit.WEEKS).with(org.threeten.bp.temporal.a.a(DayOfWeek.of(r34.checkValidIntValue(r12.remove(r34).longValue()))));
        if (r13 == ResolverStyle.STRICT) goto L79;
    L83:
        return r112;
    L79:
        if (r112.get(r23) == r38) goto L83;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L84:
        ChronoField r39 = ChronoField.DAY_OF_YEAR;
        if (r12.containsKey(r39) == false) goto L92;
        int r40 = r22.checkValidIntValue(r12.remove(r22).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L91;
        return dateYearDay(r40, 1).plusDays(ig.d.o(r12.remove(r39).longValue(), 1));
    L91:
        return dateYearDay(r40, r39.checkValidIntValue(r12.remove(r39).longValue()));
    L92:
        ChronoField r41 = ChronoField.ALIGNED_WEEK_OF_YEAR;
        if (r12.containsKey(r41) == false) goto L122;
        ChronoField r42 = ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR;
        if (r12.containsKey(r42) == false) goto L108;
        int r43 = r22.checkValidIntValue(r12.remove(r22).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L100;
        long r44 = ig.d.o(r12.remove(r41).longValue(), 1);
        return date(r43, 1, 1).plus(r44, ChronoUnit.WEEKS).plus(ig.d.o(r12.remove(r42).longValue(), 1), ChronoUnit.DAYS);
    L100:
        JapaneseDate r113 = date(r43, 1, 1).plusDays(((r41.checkValidIntValue(r12.remove(r41).longValue()) - 1) * 7) + (r42.checkValidIntValue(r12.remove(r42).longValue()) - 1));
        if (r13 == ResolverStyle.STRICT) goto L103;
    L107:
        return r113;
    L103:
        if (r113.get(r22) == r43) goto L107;
        throw new DateTimeException("Strict mode rejected date parsed to a different year");
    L108:
        ChronoField r45 = ChronoField.DAY_OF_WEEK;
        if (r12.containsKey(r45) == false) goto L122;
        int r46 = r22.checkValidIntValue(r12.remove(r22).longValue());
        if (r13 != ResolverStyle.LENIENT) goto L114;
        long r47 = ig.d.o(r12.remove(r41).longValue(), 1);
        return date(r46, 1, 1).plus(r47, ChronoUnit.WEEKS).plus(ig.d.o(r12.remove(r45).longValue(), 1), ChronoUnit.DAYS);
    L114:
        JapaneseDate r114 = date(r46, 1, 1).plus(r41.checkValidIntValue(r12.remove(r41).longValue()) - 1, ChronoUnit.WEEKS).with(org.threeten.bp.temporal.a.a(DayOfWeek.of(r45.checkValidIntValue(r12.remove(r45).longValue()))));
        if (r13 == ResolverStyle.STRICT) goto L117;
    L121:
        return r114;
    L117:
        if (r114.get(r22) == r46) goto L121;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L122:
        return null;
    L15:
        r17 = null;
        goto L16
    L9:
        if (r13 == ResolverStyle.LENIENT) goto L11;
        r11.checkValidValue(r14.longValue());
    L11:
        updateResolveMap(r12, ChronoField.MONTH_OF_YEAR, ig.d.f(r14.longValue(), 12) + 1);
        updateResolveMap(r12, ChronoField.YEAR, ig.d.d(r14.longValue(), 12));
        goto L12
    L5:
        return dateEpochDay(r12.remove(r10).longValue());
    }

    @Override // org.threeten.bp.chrono.e
    public d zonedDateTime(Instant r10, ZoneId r11) {
        return super.zonedDateTime(r10, r11);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a date(TemporalAccessor r10) {
        return date(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a dateNow(ZoneId r10) {
        return dateNow(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public JapaneseDate dateYearDay(Era r10, int r11, int r12) {
        if ((r10 instanceof JapaneseEra) == false) goto L7;
        return JapaneseDate.ofYearDay((JapaneseEra) r10, r11, r12);
    L7:
        throw new ClassCastException("Era must be JapaneseEra");
    }

    @Override // org.threeten.bp.chrono.e
    public JapaneseDate date(Era r10, int r11, int r12, int r13) {
        if ((r10 instanceof JapaneseEra) == false) goto L7;
        return JapaneseDate.of((JapaneseEra) r10, r11, r12, r13);
    L7:
        throw new ClassCastException("Era must be JapaneseEra");
    }

    @Override // org.threeten.bp.chrono.e
    public JapaneseDate dateNow() {
        return (JapaneseDate) super.dateNow();
    }

    @Override // org.threeten.bp.chrono.e
    public JapaneseDate dateNow(ZoneId r10) {
        return (JapaneseDate) super.dateNow(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public JapaneseDate dateNow(Clock r10) {
        ig.d.h(r10, "clock");
        return (JapaneseDate) super.dateNow(r10);
    }

    @Override // org.threeten.bp.chrono.e
    public JapaneseDate dateYearDay(int r10, int r11) {
        LocalDate r12 = LocalDate.ofYearDay(r10, r11);
        return date(r10, r12.getMonthValue(), r12.getDayOfMonth());
    }

    @Override // org.threeten.bp.chrono.e
    public JapaneseDate date(int r10, int r11, int r12) {
        return new JapaneseDate(LocalDate.of(r10, r11, r12));
    }

    @Override // org.threeten.bp.chrono.e
    public JapaneseDate date(TemporalAccessor r10) {
        if ((r10 instanceof JapaneseDate) == false) goto L7;
        return (JapaneseDate) r10;
    L7:
        return new JapaneseDate(LocalDate.from(r10));
    }
}
