package org.threeten.bp.chrono;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjusters;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes5.dex */
public final class JapaneseChronology extends Chronology implements Serializable {
    private static final Map<String, String[]> ERA_FULL_NAMES = null;
    private static final Map<String, String[]> ERA_NARROW_NAMES = null;
    private static final Map<String, String[]> ERA_SHORT_NAMES = null;
    private static final String FALLBACK_LANGUAGE = "en";
    public static final JapaneseChronology INSTANCE = null;
    static final Locale LOCALE = null;
    private static final String TARGET_LANGUAGE = "ja";
    private static final long serialVersionUID = 459996390165777884L;

    /* JADX INFO: renamed from: org.threeten.bp.chrono.JapaneseChronology$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$threeten$bp$temporal$ChronoField = null;

        static {
            int[] r0 = new int[ChronoField.values().length];
            $SwitchMap$org$threeten$bp$temporal$ChronoField = r0;
            r0[ChronoField.DAY_OF_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L27
        L80:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.DAY_OF_WEEK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L28
        L58:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MICRO_OF_DAY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L29
        L74:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MICRO_OF_SECOND.ordinal()] = 4;     // Catch: NoSuchFieldError -> L30
        L82:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.HOUR_OF_DAY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L31
        L60:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.HOUR_OF_AMPM.ordinal()] = 6;     // Catch: NoSuchFieldError -> L32
        L66:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MINUTE_OF_DAY.ordinal()] = 7;     // Catch: NoSuchFieldError -> L33
        L94:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MINUTE_OF_HOUR.ordinal()] = 8;     // Catch: NoSuchFieldError -> L34
        L52:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.SECOND_OF_DAY.ordinal()] = 9;     // Catch: NoSuchFieldError -> L35
        L86:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.SECOND_OF_MINUTE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L36
        L90:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MILLI_OF_DAY.ordinal()] = 11;     // Catch: NoSuchFieldError -> L37
        L70:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MILLI_OF_SECOND.ordinal()] = 12;     // Catch: NoSuchFieldError -> L38
        L78:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.NANO_OF_DAY.ordinal()] = 13;     // Catch: NoSuchFieldError -> L39
        L56:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.NANO_OF_SECOND.ordinal()] = 14;     // Catch: NoSuchFieldError -> L40
        L64:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.CLOCK_HOUR_OF_DAY.ordinal()] = 15;     // Catch: NoSuchFieldError -> L41
        L92:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.CLOCK_HOUR_OF_AMPM.ordinal()] = 16;     // Catch: NoSuchFieldError -> L42
        L50:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.EPOCH_DAY.ordinal()] = 17;     // Catch: NoSuchFieldError -> L43
        L84:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.PROLEPTIC_MONTH.ordinal()] = 18;     // Catch: NoSuchFieldError -> L44
        L88:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.ERA.ordinal()] = 19;     // Catch: NoSuchFieldError -> L45
        L68:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR.ordinal()] = 20;     // Catch: NoSuchFieldError -> L46
        L76:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.YEAR_OF_ERA.ordinal()] = 21;     // Catch: NoSuchFieldError -> L47
        L54:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.MONTH_OF_YEAR.ordinal()] = 22;     // Catch: NoSuchFieldError -> L48
        L62:
            $SwitchMap$org$threeten$bp$temporal$ChronoField[ChronoField.DAY_OF_YEAR.ordinal()] = 23;     // Catch: NoSuchFieldError -> L49
            return;
        }
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getCalendarType() {
        return "japanese";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public String getId() {
        return "Japanese";
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate date(int r1, int r2, int r3) {
        return date(r1, r2, r3);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* synthetic */ ChronoLocalDate date(Era r3, int r4, int r5, int r6) {
        return date((Era) ZeusTransformUtils.wrapperContextForParams(r3, Era.class, "com.obric.aiagent.plugin"), r4, r5, r6);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* synthetic */ ChronoLocalDate date(TemporalAccessor r3) {
        return date((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate dateEpochDay(long r1) {
        return dateEpochDay(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate dateNow() {
        return dateNow();
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate dateNow(Clock r1) {
        return dateNow(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate dateNow(ZoneId r1) {
        return dateNow(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ ChronoLocalDate dateYearDay(int r1, int r2) {
        return dateYearDay(r1, r2);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* synthetic */ ChronoLocalDate dateYearDay(Era r3, int r4, int r5) {
        return dateYearDay((Era) ZeusTransformUtils.wrapperContextForParams(r3, Era.class, "com.obric.aiagent.plugin"), r4, r5);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* bridge */ /* synthetic */ Era eraOf(int r1) {
        return eraOf(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public /* synthetic */ ChronoLocalDate resolveDate(Map r3, ResolverStyle r4) {
        return resolveDate((Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin"), r4);
    }

    static {
        LOCALE = new Locale(TARGET_LANGUAGE, "JP", "JP");
        INSTANCE = new JapaneseChronology();
        HashMap r0 = new HashMap();
        ERA_NARROW_NAMES = r0;
        HashMap r2 = new HashMap();
        ERA_SHORT_NAMES = r2;
        HashMap r3 = new HashMap();
        ERA_FULL_NAMES = r3;
        r0.put("en", new String[]{"Unknown", "K", "M", "T", "S", "H"});
        r0.put(TARGET_LANGUAGE, new String[]{"Unknown", "K", "M", "T", "S", "H"});
        r2.put("en", new String[]{"Unknown", "K", "M", "T", "S", "H"});
        r2.put(TARGET_LANGUAGE, new String[]{"Unknown", "慶", "明", "大", "昭", "平"});
        r3.put("en", new String[]{"Unknown", "Keio", "Meiji", "Taisho", "Showa", "Heisei"});
        r3.put(TARGET_LANGUAGE, new String[]{"Unknown", "慶応", "明治", "大正", "昭和", "平成"});
    }

    private JapaneseChronology() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate date(Era r2, int r3, int r4, int r5) {
        Era r1 = (Era) ZeusTransformUtils.wrapperContextForParams(r2, Era.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, JapaneseEra.class) == false) goto L7;
        return JapaneseDate.of((JapaneseEra) ZeusTransformUtils.preCheckCast(r1, JapaneseEra.class, "com.obric.aiagent.plugin"), r3, r4, r5);
    L7:
        throw new ClassCastException("Era must be JapaneseEra");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate date(int r1, int r2, int r3) {
        return new JapaneseDate(LocalDate.of(r1, r2, r3));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate dateYearDay(Era r2, int r3, int r4) {
        Era r1 = (Era) ZeusTransformUtils.wrapperContextForParams(r2, Era.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, JapaneseEra.class) == false) goto L7;
        return JapaneseDate.ofYearDay((JapaneseEra) ZeusTransformUtils.preCheckCast(r1, JapaneseEra.class, "com.obric.aiagent.plugin"), r3, r4);
    L7:
        throw new ClassCastException("Era must be JapaneseEra");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate dateYearDay(int r2, int r3) {
        LocalDate r4 = LocalDate.ofYearDay(r2, r3);
        return date(r2, r4.getMonthValue(), r4.getDayOfMonth());
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate dateEpochDay(long r1) {
        return new JapaneseDate(LocalDate.ofEpochDay(r1));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate date(TemporalAccessor r2) {
        TemporalAccessor r1 = (TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r2, TemporalAccessor.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, JapaneseDate.class) == false) goto L7;
        return (JapaneseDate) ZeusTransformUtils.preCheckCast(r1, JapaneseDate.class, "com.obric.aiagent.plugin");
    L7:
        return new JapaneseDate(LocalDate.from(r1));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoLocalDateTime<JapaneseDate> localDateTime(TemporalAccessor r3) {
        return super.localDateTime((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime<JapaneseDate> zonedDateTime(TemporalAccessor r3) {
        return super.zonedDateTime((TemporalAccessor) ZeusTransformUtils.wrapperContextForParams(r3, TemporalAccessor.class, "com.obric.aiagent.plugin"));
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ChronoZonedDateTime<JapaneseDate> zonedDateTime(Instant r1, ZoneId r2) {
        return super.zonedDateTime(r1, r2);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate dateNow() {
        return (JapaneseDate) ZeusTransformUtils.preCheckCast(super.dateNow(), JapaneseDate.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate dateNow(ZoneId r2) {
        return (JapaneseDate) ZeusTransformUtils.preCheckCast(super.dateNow(r2), JapaneseDate.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate dateNow(Clock r2) {
        Jdk8Methods.requireNonNull(r2, "clock");
        return (JapaneseDate) ZeusTransformUtils.preCheckCast(super.dateNow(r2), JapaneseDate.class, "com.obric.aiagent.plugin");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public boolean isLeapYear(long r1) {
        return IsoChronology.INSTANCE.isLeapYear(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public int prolepticYear(Era r5, int r6) {
        Era r4 = (Era) ZeusTransformUtils.wrapperContextForParams(r5, Era.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, JapaneseEra.class) == false) goto L7;
        JapaneseEra r7 = (JapaneseEra) ZeusTransformUtils.preCheckCast(r4, JapaneseEra.class, "com.obric.aiagent.plugin");
        int r8 = (r7.startDate().getYear() + r6) - 1;
        ValueRange.of(1, (r7.endDate().getYear() - r7.startDate().getYear()) + 1).checkValidValue(r6, ChronoField.YEAR_OF_ERA);
        return r8;
    L7:
        throw new ClassCastException("Era must be JapaneseEra");
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseEra eraOf(int r1) {
        return JapaneseEra.of(r1);
    }

    @Override // org.threeten.bp.chrono.Chronology
    public List<Era> eras() {
        return Arrays.asList(JapaneseEra.values());
    }

    @Override // org.threeten.bp.chrono.Chronology
    public ValueRange range(ChronoField r11) {
        switch(AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[r11.ordinal()]) {
            case 1: goto L9;
            case 2: goto L9;
            case 3: goto L9;
            case 4: goto L9;
            case 5: goto L9;
            case 6: goto L9;
            case 7: goto L9;
            case 8: goto L9;
            case 9: goto L9;
            case 10: goto L9;
            case 11: goto L9;
            case 12: goto L9;
            case 13: goto L9;
            case 14: goto L9;
            case 15: goto L9;
            case 16: goto L9;
            case 17: goto L9;
            case 18: goto L9;
            default: goto L4;
        };
    L4:
        Calendar r10 = Calendar.getInstance(LOCALE);
        int r1 = 0;
        switch(AnonymousClass1.$SwitchMap$org$threeten$bp$temporal$ChronoField[r11.ordinal()]) {
            case 19: goto L26;
            case 20: goto L24;
            case 21: goto L18;
            case 22: goto L17;
            case 23: goto L10;
            default: goto L7;
        };
    L10:
        JapaneseEra[] r12 = JapaneseEra.values();
        int r13 = 366;
    L12:
        if (r1 >= r12.length) goto L15;
        r13 = Math.min(r13, (r12[r1].startDate().lengthOfYear() - r12[r1].startDate().getDayOfYear()) + 1);
        r1 = r1 + 1;
        goto L12
    L15:
        return ValueRange.of(1, r13, 366);
    L18:
        JapaneseEra[] r14 = JapaneseEra.values();
        int r15 = (r14[r14.length - 1].endDate().getYear() - r14[r14.length - 1].startDate().getYear()) + 1;
        int r0 = Integer.MAX_VALUE;
    L20:
        if (r1 >= r14.length) goto L23;
        r0 = Math.min(r0, (r14[r1].endDate().getYear() - r14[r1].startDate().getYear()) + 1);
        r1 = r1 + 1;
        goto L20
    L23:
        return ValueRange.of(1, 6, r0, r15);
    L24:
        JapaneseEra[] r16 = JapaneseEra.values();
        return ValueRange.of(JapaneseDate.MIN_DATE.getYear(), r16[r16.length - 1].endDate().getYear());
    L26:
        JapaneseEra[] r17 = JapaneseEra.values();
        return ValueRange.of(r17[0].getValue(), r17[r17.length - 1].getValue());
    L7:
        throw new UnsupportedOperationException("Unimplementable field: " + r11);
    L17:
        return ValueRange.of(r10.getMinimum(2) + 1, r10.getGreatestMinimum(2) + 1, r10.getLeastMaximum(2) + 1, r10.getMaximum(2) + 1);
    L9:
        return r11.range();
    }

    @Override // org.threeten.bp.chrono.Chronology
    public JapaneseDate resolveDate(Map<TemporalField, Long> r10, ResolverStyle r11) {
        Map<TemporalField, Long> r12 = (Map) ZeusTransformUtils.wrapperContextForParams(r10, Map.class, "com.obric.aiagent.plugin");
        if (r12.containsKey(ChronoField.EPOCH_DAY) == true) goto L5;
        Long r0 = (Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.PROLEPTIC_MONTH), Long.class, "com.obric.aiagent.plugin");
        if (r0 != null) goto L9;
    L12:
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(r12.get(ChronoField.ERA), Long.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L15;
        JapaneseEra r2 = eraOf(range(ChronoField.ERA).checkValidIntValue(r1.longValue(), ChronoField.ERA));
    L16:
        Long r4 = (Long) ZeusTransformUtils.preCheckCast(r12.get(ChronoField.YEAR_OF_ERA), Long.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L38;
        int r5 = range(ChronoField.YEAR_OF_ERA).checkValidIntValue(r4.longValue(), ChronoField.YEAR_OF_ERA);
        if (r2 == null) goto L21;
    L25:
        if (r2 != null) goto L27;
    L32:
        if (r2 == null) goto L38;
        if (r12.containsKey(ChronoField.DAY_OF_YEAR) == false) goto L38;
        r12.remove(ChronoField.ERA);
        r12.remove(ChronoField.YEAR_OF_ERA);
        return resolveEYD(r12, r11, r2, r5);
    L27:
        if (r12.containsKey(ChronoField.MONTH_OF_YEAR) == false) goto L32;
        if (r12.containsKey(ChronoField.DAY_OF_MONTH) == false) goto L32;
        r12.remove(ChronoField.ERA);
        r12.remove(ChronoField.YEAR_OF_ERA);
        return resolveEYMD(r12, r11, r2, r5);
    L21:
        if (r11 == ResolverStyle.STRICT) goto L25;
        if (r12.containsKey(ChronoField.YEAR) == true) goto L25;
        List<Era> r3 = eras();
        r2 = (JapaneseEra) ZeusTransformUtils.preCheckCast(r3.get(r3.size() - 1), JapaneseEra.class, "com.obric.aiagent.plugin");
    L38:
        if (r12.containsKey(ChronoField.YEAR) == true) goto L40;
    L122:
        return null;
    L40:
        if (r12.containsKey(ChronoField.MONTH_OF_YEAR) == false) goto L85;
        if (r12.containsKey(ChronoField.DAY_OF_MONTH) == false) goto L55;
        int r6 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.YEAR), Long.class, "com.obric.aiagent.plugin")).longValue());
        if (r11 != ResolverStyle.LENIENT) goto L47;
        long r7 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue(), 1);
        return date(r6, 1, 1).plusMonths(r7).plusDays(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.DAY_OF_MONTH), Long.class, "com.obric.aiagent.plugin")).longValue(), 1));
    L47:
        int r8 = range(ChronoField.MONTH_OF_YEAR).checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue(), ChronoField.MONTH_OF_YEAR);
        int r13 = range(ChronoField.DAY_OF_MONTH).checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.DAY_OF_MONTH), Long.class, "com.obric.aiagent.plugin")).longValue(), ChronoField.DAY_OF_MONTH);
        if (r11 != ResolverStyle.SMART) goto L53;
        if (r13 <= 28) goto L53;
        r13 = Math.min(r13, date(r6, r8, 1).lengthOfMonth());
    L53:
        return date(r6, r8, r13);
    L55:
        if (r12.containsKey(ChronoField.ALIGNED_WEEK_OF_MONTH) == false) goto L85;
        if (r12.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH) == false) goto L71;
        int r9 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.YEAR), Long.class, "com.obric.aiagent.plugin")).longValue());
        if (r11 != ResolverStyle.LENIENT) goto L62;
        long r14 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue(), 1);
        long r15 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.ALIGNED_WEEK_OF_MONTH), Long.class, "com.obric.aiagent.plugin")).longValue(), 1);
        return date(r9, 1, 1).plus(r14, ChronoUnit.MONTHS).plus(r15, ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH), Long.class, "com.obric.aiagent.plugin")).longValue(), 1), ChronoUnit.DAYS);
    L62:
        int r16 = ChronoField.MONTH_OF_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue());
        JapaneseDate r17 = date(r9, r16, 1).plus(((ChronoField.ALIGNED_WEEK_OF_MONTH.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.ALIGNED_WEEK_OF_MONTH), Long.class, "com.obric.aiagent.plugin")).longValue()) - 1) * 7) + (ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH), Long.class, "com.obric.aiagent.plugin")).longValue()) - 1), ChronoUnit.DAYS);
        if (r11 == ResolverStyle.STRICT) goto L65;
    L69:
        return r17;
    L65:
        if (r17.get(ChronoField.MONTH_OF_YEAR) == r16) goto L69;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L71:
        if (r12.containsKey(ChronoField.DAY_OF_WEEK) == false) goto L85;
        int r18 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.YEAR), Long.class, "com.obric.aiagent.plugin")).longValue());
        if (r11 != ResolverStyle.LENIENT) goto L76;
        long r19 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue(), 1);
        long r20 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.ALIGNED_WEEK_OF_MONTH), Long.class, "com.obric.aiagent.plugin")).longValue(), 1);
        return date(r18, 1, 1).plus(r19, ChronoUnit.MONTHS).plus(r20, ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.DAY_OF_WEEK), Long.class, "com.obric.aiagent.plugin")).longValue(), 1), ChronoUnit.DAYS);
    L76:
        int r21 = ChronoField.MONTH_OF_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue());
        JapaneseDate r22 = date(r18, r21, 1).plus(ChronoField.ALIGNED_WEEK_OF_MONTH.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.ALIGNED_WEEK_OF_MONTH), Long.class, "com.obric.aiagent.plugin")).longValue()) - 1, ChronoUnit.WEEKS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(ChronoField.DAY_OF_WEEK.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.DAY_OF_WEEK), Long.class, "com.obric.aiagent.plugin")).longValue()))));
        if (r11 == ResolverStyle.STRICT) goto L79;
    L83:
        return r22;
    L79:
        if (r22.get(ChronoField.MONTH_OF_YEAR) == r21) goto L83;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L85:
        if (r12.containsKey(ChronoField.DAY_OF_YEAR) == false) goto L93;
        int r23 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.YEAR), Long.class, "com.obric.aiagent.plugin")).longValue());
        if (r11 != ResolverStyle.LENIENT) goto L91;
        return dateYearDay(r23, 1).plusDays(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.DAY_OF_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue(), 1));
    L91:
        return dateYearDay(r23, ChronoField.DAY_OF_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.DAY_OF_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue()));
    L93:
        if (r12.containsKey(ChronoField.ALIGNED_WEEK_OF_YEAR) == false) goto L122;
        if (r12.containsKey(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR) == false) goto L109;
        int r24 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.YEAR), Long.class, "com.obric.aiagent.plugin")).longValue());
        if (r11 != ResolverStyle.LENIENT) goto L100;
        long r25 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.ALIGNED_WEEK_OF_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue(), 1);
        return date(r24, 1, 1).plus(r25, ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue(), 1), ChronoUnit.DAYS);
    L100:
        JapaneseDate r26 = date(r24, 1, 1).plusDays(((ChronoField.ALIGNED_WEEK_OF_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.ALIGNED_WEEK_OF_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue()) - 1) * 7) + (ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue()) - 1));
        if (r11 == ResolverStyle.STRICT) goto L103;
    L107:
        return r26;
    L103:
        if (r26.get(ChronoField.YEAR) == r24) goto L107;
        throw new DateTimeException("Strict mode rejected date parsed to a different year");
    L109:
        if (r12.containsKey(ChronoField.DAY_OF_WEEK) == false) goto L122;
        int r27 = ChronoField.YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.YEAR), Long.class, "com.obric.aiagent.plugin")).longValue());
        if (r11 != ResolverStyle.LENIENT) goto L114;
        long r28 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.ALIGNED_WEEK_OF_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue(), 1);
        return date(r27, 1, 1).plus(r28, ChronoUnit.WEEKS).plus(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.DAY_OF_WEEK), Long.class, "com.obric.aiagent.plugin")).longValue(), 1), ChronoUnit.DAYS);
    L114:
        JapaneseDate r29 = date(r27, 1, 1).plus(ChronoField.ALIGNED_WEEK_OF_YEAR.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.ALIGNED_WEEK_OF_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue()) - 1, ChronoUnit.WEEKS).with(TemporalAdjusters.nextOrSame(DayOfWeek.of(ChronoField.DAY_OF_WEEK.checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.DAY_OF_WEEK), Long.class, "com.obric.aiagent.plugin")).longValue()))));
        if (r11 == ResolverStyle.STRICT) goto L117;
    L121:
        return r29;
    L117:
        if (r29.get(ChronoField.YEAR) == r27) goto L121;
        throw new DateTimeException("Strict mode rejected date parsed to a different month");
    L15:
        r2 = null;
        goto L16
    L9:
        if (r11 == ResolverStyle.LENIENT) goto L11;
        ChronoField.PROLEPTIC_MONTH.checkValidValue(r0.longValue());
    L11:
        updateResolveMap(r12, ChronoField.MONTH_OF_YEAR, Jdk8Methods.floorMod(r0.longValue(), 12) + 1);
        updateResolveMap(r12, ChronoField.YEAR, Jdk8Methods.floorDiv(r0.longValue(), 12));
        goto L12
    L5:
        return dateEpochDay(((Long) ZeusTransformUtils.preCheckCast(r12.remove(ChronoField.EPOCH_DAY), Long.class, "com.obric.aiagent.plugin")).longValue());
    }

    private JapaneseDate resolveEYMD(Map<TemporalField, Long> r7, ResolverStyle r8, JapaneseEra r9, int r10) {
        Map r11 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.aiagent.plugin");
        if (r8 != ResolverStyle.LENIENT) goto L6;
        int r12 = (r9.startDate().getYear() + r10) - 1;
        long r13 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r11.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue(), 1);
        return date(r12, 1, 1).plus(r13, ChronoUnit.MONTHS).plus(Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r11.remove(ChronoField.DAY_OF_MONTH), Long.class, "com.obric.aiagent.plugin")).longValue(), 1), ChronoUnit.DAYS);
    L6:
        int r0 = range(ChronoField.MONTH_OF_YEAR).checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r11.remove(ChronoField.MONTH_OF_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue(), ChronoField.MONTH_OF_YEAR);
        int r14 = range(ChronoField.DAY_OF_MONTH).checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r11.remove(ChronoField.DAY_OF_MONTH), Long.class, "com.obric.aiagent.plugin")).longValue(), ChronoField.DAY_OF_MONTH);
        if (r8 != ResolverStyle.SMART) goto L28;
        if (r10 < 1) goto L26;
        int r15 = (r9.startDate().getYear() + r10) - 1;
        if (r14 <= 28) goto L12;
        r14 = Math.min(r14, date(r15, r0, 1).lengthOfMonth());
    L12:
        JapaneseDate r6 = date(r15, r0, r14);
        if (r6.getEra() != r9) goto L15;
    L24:
        return r6;
    L15:
        if (Math.abs(r6.getEra().getValue() - r9.getValue()) > 1) goto L23;
        if (r6.get(ChronoField.YEAR_OF_ERA) == 1) goto L24;
        if (r10 == 1) goto L24;
        throw new DateTimeException("Invalid Era/YearOfEra: " + r9 + " " + r10);
    L23:
        throw new DateTimeException("Invalid Era/YearOfEra: " + r9 + " " + r10);
    L26:
        throw new DateTimeException("Invalid YearOfEra: " + r10);
    L28:
        return date(r9, r10, r0, r14);
    }

    private JapaneseDate resolveEYD(Map<TemporalField, Long> r5, ResolverStyle r6, JapaneseEra r7, int r8) {
        Map r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
        if (r6 != ResolverStyle.LENIENT) goto L7;
        int r10 = (r7.startDate().getYear() + r8) - 1;
        long r0 = Jdk8Methods.safeSubtract(((Long) ZeusTransformUtils.preCheckCast(r9.remove(ChronoField.DAY_OF_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue(), 1);
        return dateYearDay(r10, 1).plus(r0, ChronoUnit.DAYS);
    L7:
        return dateYearDay(r7, r8, range(ChronoField.DAY_OF_YEAR).checkValidIntValue(((Long) ZeusTransformUtils.preCheckCast(r9.remove(ChronoField.DAY_OF_YEAR), Long.class, "com.obric.aiagent.plugin")).longValue(), ChronoField.DAY_OF_YEAR));
    }
}
