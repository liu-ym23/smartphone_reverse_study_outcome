package org.threeten.bp.chrono;

import com.bytedance.librarian.LibrarianImpl;
import com.bytedanceos.common.ui.widget.SearchChipsView;
import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.ParseException;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.apache.http.message.TokenParser;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.Temporal;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalAdjuster;
import org.threeten.bp.temporal.TemporalAmount;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* JADX INFO: loaded from: classes4.dex */
public final class HijrahDate extends ChronoDateImpl<HijrahDate> implements Serializable {
    private static final Long[] ADJUSTED_CYCLES = null;
    private static final HashMap<Integer, Integer[]> ADJUSTED_CYCLE_YEARS = null;
    private static final Integer[] ADJUSTED_LEAST_MAX_VALUES = null;
    private static final Integer[] ADJUSTED_MAX_VALUES = null;
    private static final Integer[] ADJUSTED_MIN_VALUES = null;
    private static final HashMap<Integer, Integer[]> ADJUSTED_MONTH_DAYS = null;
    private static final HashMap<Integer, Integer[]> ADJUSTED_MONTH_LENGTHS = null;
    private static final int[] CYCLEYEAR_START_DATE = null;
    private static final String DEFAULT_CONFIG_FILENAME = "hijrah_deviation.cfg";
    private static final String DEFAULT_CONFIG_PATH = null;
    private static final Integer[] DEFAULT_CYCLE_YEARS = null;
    private static final Integer[] DEFAULT_LEAP_MONTH_DAYS = null;
    private static final Integer[] DEFAULT_LEAP_MONTH_LENGTHS = null;
    private static final Integer[] DEFAULT_MONTH_DAYS = null;
    private static final Integer[] DEFAULT_MONTH_LENGTHS = null;
    private static final char FILE_SEP = 0;
    private static final int HIJRAH_JAN_1_1_GREGORIAN_DAY = -492148;
    private static final int[] LEAP_MONTH_LENGTH = null;
    private static final int[] LEAP_NUM_DAYS = null;
    private static final int[] LEAST_MAX_VALUES = null;
    private static final int MAX_ADJUSTED_CYCLE = 334;
    private static final int[] MAX_VALUES = null;
    public static final int MAX_VALUE_OF_ERA = 9999;
    private static final int[] MIN_VALUES = null;
    public static final int MIN_VALUE_OF_ERA = 1;
    private static final int[] MONTH_LENGTH = null;
    private static final int[] NUM_DAYS = null;
    private static final String PATH_SEP = null;
    private static final int POSITION_DAY_OF_MONTH = 5;
    private static final int POSITION_DAY_OF_YEAR = 6;
    private static final long serialVersionUID = -5207853542612002020L;
    private final transient int dayOfMonth;
    private final transient DayOfWeek dayOfWeek;
    private final transient int dayOfYear;
    private final transient HijrahEra era;
    private final long gregorianEpochDay;
    private final transient boolean isLeapYear;
    private final transient int monthOfYear;
    private final transient int yearOfEra;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23089a = null;

        static {
            int[] r10 = new int[ChronoField.values().length];
            f23089a = r10;
            r10[ChronoField.DAY_OF_MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            f23089a[ChronoField.DAY_OF_YEAR.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            f23089a[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            f23089a[ChronoField.YEAR_OF_ERA.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            f23089a[ChronoField.DAY_OF_WEEK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            f23089a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            f23089a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            f23089a[ChronoField.EPOCH_DAY.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            f23089a[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            f23089a[ChronoField.MONTH_OF_YEAR.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            f23089a[ChronoField.YEAR.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            f23089a[ChronoField.ERA.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    static {
        int r10 = 0;
        int[] r11 = {0, 30, 59, 89, 118, SearchChipsView.GRAY, 177, 207, 236, 266, 295, 325};
        NUM_DAYS = r11;
        LEAP_NUM_DAYS = new int[]{0, 30, 59, 89, 118, SearchChipsView.GRAY, 177, 207, 236, 266, 295, 325};
        MONTH_LENGTH = new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29};
        LEAP_MONTH_LENGTH = new int[]{30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 30};
        MIN_VALUES = new int[]{0, 1, 0, 1, 0, 1, 1};
        LEAST_MAX_VALUES = new int[]{1, MAX_VALUE_OF_ERA, 11, 51, 5, 29, 354};
        MAX_VALUES = new int[]{1, MAX_VALUE_OF_ERA, 11, 52, 6, 30, 355};
        CYCLEYEAR_START_DATE = new int[]{0, 354, 709, 1063, 1417, 1772, 2126, 2481, 2835, 3189, 3544, 3898, 4252, 4607, 4961, 5315, 5670, 6024, 6379, 6733, 7087, 7442, 7796, 8150, 8505, 8859, 9214, 9568, 9922, 10277};
        char r12 = File.separatorChar;
        FILE_SEP = r12;
        PATH_SEP = File.pathSeparator;
        DEFAULT_CONFIG_PATH = "org" + r12 + "threeten" + r12 + "bp" + r12 + "chrono";
        ADJUSTED_MONTH_DAYS = new HashMap();
        ADJUSTED_MONTH_LENGTHS = new HashMap();
        ADJUSTED_CYCLE_YEARS = new HashMap();
        DEFAULT_MONTH_DAYS = new Integer[r11.length];
        int r13 = 0;
    L3:
        int[] r14 = NUM_DAYS;
        if (r13 >= r14.length) goto L6;
        DEFAULT_MONTH_DAYS[r13] = new Integer(r14[r13]);
        r13 = r13 + 1;
        goto L3
    L6:
        DEFAULT_LEAP_MONTH_DAYS = new Integer[LEAP_NUM_DAYS.length];
        int r15 = 0;
    L7:
        int[] r16 = LEAP_NUM_DAYS;
        if (r15 >= r16.length) goto L10;
        DEFAULT_LEAP_MONTH_DAYS[r15] = new Integer(r16[r15]);
        r15 = r15 + 1;
        goto L7
    L10:
        DEFAULT_MONTH_LENGTHS = new Integer[MONTH_LENGTH.length];
        int r17 = 0;
    L11:
        int[] r18 = MONTH_LENGTH;
        if (r17 >= r18.length) goto L14;
        DEFAULT_MONTH_LENGTHS[r17] = new Integer(r18[r17]);
        r17 = r17 + 1;
        goto L11
    L14:
        DEFAULT_LEAP_MONTH_LENGTHS = new Integer[LEAP_MONTH_LENGTH.length];
        int r19 = 0;
    L15:
        int[] r20 = LEAP_MONTH_LENGTH;
        if (r19 >= r20.length) goto L18;
        DEFAULT_LEAP_MONTH_LENGTHS[r19] = new Integer(r20[r19]);
        r19 = r19 + 1;
        goto L15
    L18:
        DEFAULT_CYCLE_YEARS = new Integer[CYCLEYEAR_START_DATE.length];
        int r21 = 0;
    L19:
        int[] r22 = CYCLEYEAR_START_DATE;
        if (r21 >= r22.length) goto L22;
        DEFAULT_CYCLE_YEARS[r21] = new Integer(r22[r21]);
        r21 = r21 + 1;
        goto L19
    L22:
        ADJUSTED_CYCLES = new Long[MAX_ADJUSTED_CYCLE];
        int r23 = 0;
    L23:
        Long[] r24 = ADJUSTED_CYCLES;
        if (r23 >= r24.length) goto L26;
        r24[r23] = new Long(r23 * 10631);
        r23 = r23 + 1;
        goto L23
    L26:
        ADJUSTED_MIN_VALUES = new Integer[MIN_VALUES.length];
        int r25 = 0;
    L27:
        int[] r26 = MIN_VALUES;
        if (r25 >= r26.length) goto L30;
        ADJUSTED_MIN_VALUES[r25] = new Integer(r26[r25]);
        r25 = r25 + 1;
        goto L27
    L30:
        ADJUSTED_LEAST_MAX_VALUES = new Integer[LEAST_MAX_VALUES.length];
        int r27 = 0;
    L31:
        int[] r28 = LEAST_MAX_VALUES;
        if (r27 >= r28.length) goto L34;
        ADJUSTED_LEAST_MAX_VALUES[r27] = new Integer(r28[r27]);
        r27 = r27 + 1;
        goto L31
    L34:
        ADJUSTED_MAX_VALUES = new Integer[MAX_VALUES.length];
    L35:
        int[] r29 = MAX_VALUES;
        if (r10 >= r29.length) goto L41;
        ADJUSTED_MAX_VALUES[r10] = new Integer(r29[r10]);
        r10 = r10 + 1;
        goto L35
    L41:
        readDeviationConfig();     // Catch: Throwable -> L40
        return;
    }

    private HijrahDate(long r10) {
        int[] r11 = getHijrahDateInfo(r10);
        checkValidYearOfEra(r11[1]);
        checkValidMonth(r11[2]);
        checkValidDayOfMonth(r11[3]);
        checkValidDayOfYear(r11[4]);
        this.era = HijrahEra.of(r11[0]);
        int r12 = r11[1];
        this.yearOfEra = r12;
        this.monthOfYear = r11[2];
        this.dayOfMonth = r11[3];
        this.dayOfYear = r11[4];
        this.dayOfWeek = DayOfWeek.of(r11[5]);
        this.gregorianEpochDay = r10;
        this.isLeapYear = isLeapYear(r12);
    }

    private static void addDeviationAsHijrah(int r16, int r17, int r18, int r19, int r20) {
        if (r16 < 1) goto L157;
        if (r18 < 1) goto L155;
        if (r17 < 0) goto L153;
        if (r17 > 11) goto L153;
        if (r19 < 0) goto L151;
        if (r19 > 11) goto L151;
        if (r18 > 9999) goto L149;
        if (r18 < r16) goto L147;
        if (r18 != r16) goto L18;
        if (r19 >= r17) goto L18;
        throw new IllegalArgumentException("startYear == endYear && endMonth < startMonth");
    L18:
        boolean r10 = isLeapYear(r16);
        Integer[] r11 = ADJUSTED_MONTH_DAYS.get(new Integer(r16));
        if (r11 != null) goto L29;
        if (r10 == false) goto L25;
        r11 = new Integer[LEAP_NUM_DAYS.length];
        int r12 = 0;
    L22:
        int[] r13 = LEAP_NUM_DAYS;
        if (r12 >= r13.length) goto L29;
        r11[r12] = new Integer(r13[r12]);
        r12 = r12 + 1;
        goto L22
    L25:
        r11 = new Integer[NUM_DAYS.length];
        int r14 = 0;
    L26:
        int[] r15 = NUM_DAYS;
        if (r14 >= r15.length) goto L29;
        r11[r14] = new Integer(r15[r14]);
        r14 = r14 + 1;
    L29:
        Integer[] r110 = new Integer[r11.length];
        int r111 = 0;
    L31:
        if (r111 >= 12) goto L36;
        if (r111 <= r17) goto L34;
        r110[r111] = new Integer(r11[r111].intValue() - r20);
    L35:
        r111 = r111 + 1;
        goto L31
    L34:
        r110[r111] = new Integer(r11[r111].intValue());
        goto L35
    L36:
        ADJUSTED_MONTH_DAYS.put(new Integer(r16), r110);
        Integer[] r21 = ADJUSTED_MONTH_LENGTHS.get(new Integer(r16));
        if (r21 != null) goto L47;
        if (r10 == false) goto L43;
        r21 = new Integer[LEAP_MONTH_LENGTH.length];
        int r22 = 0;
    L40:
        int[] r112 = LEAP_MONTH_LENGTH;
        if (r22 >= r112.length) goto L47;
        r21[r22] = new Integer(r112[r22]);
        r22 = r22 + 1;
        goto L40
    L43:
        r21 = new Integer[MONTH_LENGTH.length];
        int r23 = 0;
    L44:
        int[] r113 = MONTH_LENGTH;
        if (r23 >= r113.length) goto L47;
        r21[r23] = new Integer(r113[r23]);
        r23 = r23 + 1;
    L47:
        Integer[] r24 = new Integer[r21.length];
        int r114 = 0;
    L48:
        if (r114 >= 12) goto L53;
        if (r114 != r17) goto L51;
        r24[r114] = new Integer(r21[r114].intValue() - r20);
    L52:
        r114 = r114 + 1;
        goto L48
    L51:
        r24[r114] = new Integer(r21[r114].intValue());
        goto L52
    L53:
        ADJUSTED_MONTH_LENGTHS.put(new Integer(r16), r24);
        if (r16 == r18) goto L86;
        int r25 = r16 - 1;
        int r26 = r25 / 30;
        int r27 = r25 % 30;
        Integer[] r115 = ADJUSTED_CYCLE_YEARS.get(new Integer(r26));
        if (r115 != null) goto L61;
        int r116 = CYCLEYEAR_START_DATE.length;
        Integer[] r117 = new Integer[r116];
        int r118 = 0;
    L58:
        if (r118 >= r116) goto L60;
        r117[r118] = new Integer(CYCLEYEAR_START_DATE[r118]);
        r118 = r118 + 1;
        goto L58
    L60:
        r115 = r117;
    L61:
        int r28 = r27 + 1;
    L63:
        if (r28 >= CYCLEYEAR_START_DATE.length) goto L65;
        r115[r28] = new Integer(r115[r28].intValue() - r20);
        r28 = r28 + 1;
        goto L63
    L65:
        ADJUSTED_CYCLE_YEARS.put(new Integer(r26), r115);
        int r29 = r18 - 1;
        int r119 = r29 / 30;
        if (r26 == r119) goto L75;
        int r30 = r26 + 1;
    L68:
        Long[] r120 = ADJUSTED_CYCLES;
        if (r30 >= r120.length) goto L71;
        r120[r30] = new Long(r120[r30].longValue() - ((long) r20));
        r30 = r30 + 1;
        goto L68
    L71:
        int r31 = r119 + 1;
    L72:
        Long[] r32 = ADJUSTED_CYCLES;
        if (r31 >= r32.length) goto L75;
        r32[r31] = new Long(r32[r31].longValue() + ((long) r20));
        r31 = r31 + 1;
        r119 = r119;
    L75:
        int r121 = r119;
        int r33 = r29 % 30;
        Integer[] r34 = ADJUSTED_CYCLE_YEARS.get(new Integer(r121));
        if (r34 != null) goto L81;
        int r35 = CYCLEYEAR_START_DATE.length;
        Integer[] r36 = new Integer[r35];
        int r37 = 0;
    L78:
        if (r37 >= r35) goto L80;
        r36[r37] = new Integer(CYCLEYEAR_START_DATE[r37]);
        r37 = r37 + 1;
        goto L78
    L80:
        r34 = r36;
    L81:
        int r38 = r33 + 1;
    L83:
        if (r38 >= CYCLEYEAR_START_DATE.length) goto L85;
        r34[r38] = new Integer(r34[r38].intValue() + r20);
        r38 = r38 + 1;
        goto L83
    L85:
        ADJUSTED_CYCLE_YEARS.put(new Integer(r121), r34);
    L86:
        boolean r39 = isLeapYear(r18);
        Integer[] r40 = ADJUSTED_MONTH_DAYS.get(new Integer(r18));
        if (r40 != null) goto L97;
        if (r39 == false) goto L93;
        r40 = new Integer[LEAP_NUM_DAYS.length];
        int r41 = 0;
    L90:
        int[] r42 = LEAP_NUM_DAYS;
        if (r41 >= r42.length) goto L97;
        r40[r41] = new Integer(r42[r41]);
        r41 = r41 + 1;
        goto L90
    L93:
        r40 = new Integer[NUM_DAYS.length];
        int r43 = 0;
    L94:
        int[] r44 = NUM_DAYS;
        if (r43 >= r44.length) goto L97;
        r40[r43] = new Integer(r44[r43]);
        r43 = r43 + 1;
    L97:
        Integer[] r45 = new Integer[r40.length];
        int r46 = 0;
    L98:
        if (r46 >= 12) goto L103;
        if (r46 <= r19) goto L101;
        r45[r46] = new Integer(r40[r46].intValue() + r20);
    L102:
        r46 = r46 + 1;
        goto L98
    L101:
        r45[r46] = new Integer(r40[r46].intValue());
        goto L102
    L103:
        ADJUSTED_MONTH_DAYS.put(new Integer(r18), r45);
        Integer[] r47 = ADJUSTED_MONTH_LENGTHS.get(new Integer(r18));
        if (r47 != null) goto L114;
        if (r39 == false) goto L110;
        r47 = new Integer[LEAP_MONTH_LENGTH.length];
        int r48 = 0;
    L107:
        int[] r49 = LEAP_MONTH_LENGTH;
        if (r48 >= r49.length) goto L114;
        r47[r48] = new Integer(r49[r48]);
        r48 = r48 + 1;
        goto L107
    L110:
        r47 = new Integer[MONTH_LENGTH.length];
        int r50 = 0;
    L111:
        int[] r51 = MONTH_LENGTH;
        if (r50 >= r51.length) goto L114;
        r47[r50] = new Integer(r51[r50]);
        r50 = r50 + 1;
    L114:
        Integer[] r52 = new Integer[r47.length];
        int r53 = 0;
    L115:
        if (r53 >= 12) goto L120;
        if (r53 != r19) goto L118;
        r52[r53] = new Integer(r47[r53].intValue() + r20);
    L119:
        r53 = r53 + 1;
        goto L115
    L118:
        r52[r53] = new Integer(r47[r53].intValue());
        goto L119
    L120:
        HashMap<Integer, Integer[]> r54 = ADJUSTED_MONTH_LENGTHS;
        r54.put(new Integer(r18), r52);
        Integer[] r55 = r54.get(new Integer(r16));
        Integer[] r56 = r54.get(new Integer(r18));
        HashMap<Integer, Integer[]> r57 = ADJUSTED_MONTH_DAYS;
        Integer[] r58 = r57.get(new Integer(r16));
        Integer[] r59 = r57.get(new Integer(r18));
        int r60 = r55[r17].intValue();
        int r61 = r56[r19].intValue();
        int r62 = r58[11].intValue() + r55[11].intValue();
        int r63 = r59[11].intValue() + r56[11].intValue();
        Integer[] r64 = ADJUSTED_MAX_VALUES;
        int r65 = r64[5].intValue();
        Integer[] r66 = ADJUSTED_LEAST_MAX_VALUES;
        int r67 = r66[5].intValue();
        if (r65 >= r60) goto L123;
        r65 = r60;
    L123:
        if (r65 >= r61) goto L125;
        r65 = r61;
    L125:
        r64[5] = new Integer(r65);
        if (r67 > r60) goto L129;
        r60 = r67;
    L129:
        if (r60 > r61) goto L132;
        r61 = r60;
    L132:
        r66[5] = new Integer(r61);
        int r68 = r64[6].intValue();
        int r69 = r66[6].intValue();
        if (r68 >= r62) goto L135;
        r68 = r62;
    L135:
        if (r68 >= r63) goto L137;
        r68 = r63;
    L137:
        r64[6] = new Integer(r68);
        if (r69 > r62) goto L141;
        r62 = r69;
    L141:
        if (r62 > r63) goto L144;
        r63 = r62;
    L144:
        r66[6] = new Integer(r63);
        return;
    L147:
        throw new IllegalArgumentException("startYear > endYear");
    L149:
        throw new IllegalArgumentException("endYear > 9999");
    L151:
        throw new IllegalArgumentException("endMonth < 0 || endMonth > 11");
    L153:
        throw new IllegalArgumentException("startMonth < 0 || startMonth > 11");
    L155:
        throw new IllegalArgumentException("endYear < 1");
    L157:
        throw new IllegalArgumentException("startYear < 1");
    }

    private static void checkValidDayOfMonth(int r10) {
        if (r10 < 1) goto L8;
        if (r10 > getMaximumDayOfMonth()) goto L8;
        return;
    L8:
        throw new DateTimeException("Invalid day of month of Hijrah date, day " + r10 + " greater than " + getMaximumDayOfMonth() + " or less than 1");
    }

    private static void checkValidDayOfYear(int r10) {
        if (r10 < 1) goto L8;
        if (r10 > getMaximumDayOfYear()) goto L8;
        return;
    L8:
        throw new DateTimeException("Invalid day of year of Hijrah date");
    }

    private static void checkValidMonth(int r10) {
        if (r10 < 1) goto L8;
        if (r10 > 12) goto L8;
        return;
    L8:
        throw new DateTimeException("Invalid month of Hijrah date");
    }

    private static void checkValidYearOfEra(int r10) {
        if (r10 < 1) goto L8;
        if (r10 > 9999) goto L8;
        return;
    L8:
        throw new DateTimeException("Invalid year of Hijrah Era");
    }

    public static HijrahDate from(TemporalAccessor r10) {
        return HijrahChronology.INSTANCE.date(r10);
    }

    private static Integer[] getAdjustedCycle(int r10) {
        Integer[] r11 = ADJUSTED_CYCLE_YEARS.get(new Integer(r10));     // Catch: ArrayIndexOutOfBoundsException -> L4
    L5:
        if (r11 == null) goto L7;
        return r11;
    L7:
        return DEFAULT_CYCLE_YEARS;
    L4:
        r11 = null;
        goto L5
    }

    private static Integer[] getAdjustedMonthDays(int r10) {
        Integer[] r11 = ADJUSTED_MONTH_DAYS.get(new Integer(r10));     // Catch: ArrayIndexOutOfBoundsException -> L4
    L5:
        if (r11 == null) goto L7;
        return r11;
    L7:
        if (isLeapYear(r10) == false) goto L10;
        return DEFAULT_LEAP_MONTH_DAYS;
    L10:
        return DEFAULT_MONTH_DAYS;
    L4:
        r11 = null;
        goto L5
    }

    private static Integer[] getAdjustedMonthLength(int r10) {
        Integer[] r11 = ADJUSTED_MONTH_LENGTHS.get(new Integer(r10));     // Catch: ArrayIndexOutOfBoundsException -> L4
    L5:
        if (r11 == null) goto L7;
        return r11;
    L7:
        if (isLeapYear(r10) == false) goto L10;
        return DEFAULT_LEAP_MONTH_LENGTHS;
    L10:
        return DEFAULT_MONTH_LENGTHS;
    L4:
        r11 = null;
        goto L5
    }

    private static InputStream getConfigFileInputStream() throws IOException {
        String r10 = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigFile");
        if (r10 != null) goto L5;
        r10 = DEFAULT_CONFIG_FILENAME;
    L5:
        String r11 = System.getProperty("org.threeten.bp.i18n.HijrahDate.deviationConfigDir");
        if (r11 != null) goto L8;
        StringTokenizer r12 = new StringTokenizer(System.getProperty("java.class.path"), PATH_SEP);
    L19:
        if (r12.hasMoreTokens() == false) goto L43;
        String r13 = r12.nextToken();
        File r14 = new File(r13);
        if (r14.exists() == false) goto L19;
        if (r14.isDirectory() == true) goto L24;
        ZipFile r15 = new ZipFile(r14);     // Catch: IOException -> L30
    L31:
        if (r15 == null) goto L19;
        StringBuilder r16 = new StringBuilder();
        r16.append(DEFAULT_CONFIG_PATH);
        char r17 = FILE_SEP;
        r16.append(r17);
        r16.append(r10);
        String r18 = r16.toString();
        ZipEntry r19 = r15.getEntry(r18);
        if (r19 == null) goto L35;
    L40:
        if (r19 == null) goto L19;
        return r15.getInputStream(r19);
    L35:
        if (r17 != '/') goto L37;
        r18 = r18.replace('/', TokenParser.ESCAPE);
    L39:
        r19 = r15.getEntry(r18);
        goto L40
    L37:
        if (r17 != '\\') goto L39;
        r18 = r18.replace(TokenParser.ESCAPE, '/');
    L30:
        r15 = null;
        goto L31
    L24:
        StringBuilder r20 = new StringBuilder();
        r20.append(r13);
        char r21 = FILE_SEP;
        r20.append(r21);
        String r22 = DEFAULT_CONFIG_PATH;
        r20.append(r22);
        if (new File(r20.toString(), r10).exists() == false) goto L19;
        return new FileInputStream(r13 + r21 + r22 + r21 + r10);
    L43:
        return null;
    L8:
        if (r11.length() == 0) goto L10;
    L11:
        r11 = r11 + System.getProperty("file.separator");
    L12:
        File r23 = new File(r11 + FILE_SEP + r10);
        if (r23.exists() == true) goto L15;
        return null;
    L15:
        return new FileInputStream(r23);
    L10:
        if (r11.endsWith(System.getProperty("file.separator")) == true) goto L12;
        goto L11
    }

    private static int getCycleNumber(long r10) {
        Long[] r11 = ADJUSTED_CYCLES;
        int r12 = 0;
    L14:
        if (r12 >= r11.length) goto L17;
        if (r10 < r11[r12].longValue()) goto L8;
        r12 = r12 + 1;     // Catch: ArrayIndexOutOfBoundsException -> L12
        goto L14
    L8:
        return r12 - 1;
    L17:
        return ((int) r10) / 10631;
    L13:
        return ((int) r10) / 10631;
    }

    private static int getDayOfCycle(long r10, int r11) {
        Long r12 = ADJUSTED_CYCLES[r11];     // Catch: ArrayIndexOutOfBoundsException -> L4
    L5:
        if (r12 != null) goto L8;
        r12 = new Long(r11 * 10631);
    L8:
        return (int) (r10 - r12.longValue());
    L4:
        r12 = null;
        goto L5
    }

    private static int getDayOfMonth(int r10, int r11, int r12) {
        Integer[] r13 = getAdjustedMonthDays(r12);
        if (r10 < 0) goto L9;
        if (r11 <= 0) goto L15;
        int r14 = r13[r11].intValue();
    L7:
        return r10 - r14;
    L15:
        return r10;
    L9:
        if (isLeapYear(r12) == false) goto L11;
        r10 = r10 + 355;
    L12:
        if (r11 <= 0) goto L14;
        r14 = r13[r11].intValue();
        goto L7
    L14:
        return r10;
    L11:
        r10 = r10 + 354;
        goto L12
    }

    private static int getDayOfYear(int r10, int r11, int r12) {
        Integer[] r13 = getAdjustedCycle(r10);
        if (r11 <= 0) goto L7;
        return r11 - r13[r12].intValue();
    L7:
        return r13[r12].intValue() + r11;
    }

    private static long getGregorianEpochDay(int r10, int r11, int r12) {
        return (yearToGregorianEpochDay(r10) + ((long) getMonthDays(r11 - 1, r10))) + ((long) r12);
    }

    private static int[] getHijrahDateInfo(long r10) {
        long r11 = r10 - (-492148);
        if (r11 < 0) goto L6;
        int r12 = getCycleNumber(r11);
        int r13 = getDayOfCycle(r11, r12);
        int r14 = getYearInCycle(r12, r13);
        int r15 = getDayOfYear(r12, r13, r14);
        int r16 = ((r12 * 30) + r14) + 1;
        int r17 = getMonthOfYear(r15, r16);
        int r18 = getDayOfMonth(r15, r17, r16) + 1;
        int r19 = HijrahEra.AH.getValue();
    L5:
        int r20 = r18;
        int r21 = r16;
        int r22 = r19;
        int r23 = (int) ((r10 - (-492153)) % 7);
        if (r23 > 0) goto L17;
        int r24 = 7;
    L19:
        return new int[]{r22, r21, r17 + 1, r20, r15 + 1, r23 + r24};
    L17:
        r24 = 0;
        goto L19
    L6:
        int r25 = (int) r11;
        int r26 = r25 / 10631;
        int r27 = r25 % 10631;
        if (r27 != 0) goto L9;
        r26 = r26 + 1;
        r27 = -10631;
    L9:
        int r28 = getYearInCycle(r26, r27);
        int r29 = getDayOfYear(r26, r27, r28);
        r16 = 1 - ((r26 * 30) - r28);
        if (isLeapYear(r16) == false) goto L12;
        r15 = r29 + 355;
    L13:
        r17 = getMonthOfYear(r15, r16);
        r18 = getDayOfMonth(r15, r17, r16) + 1;
        r19 = HijrahEra.BEFORE_AH.getValue();
        goto L5
    L12:
        r15 = r29 + 354;
        goto L13
    }

    public static int getMaximumDayOfMonth() {
        return ADJUSTED_MAX_VALUES[5].intValue();
    }

    public static int getMaximumDayOfYear() {
        return ADJUSTED_MAX_VALUES[6].intValue();
    }

    private static int getMonthDays(int r10, int r11) {
        return getAdjustedMonthDays(r11)[r10].intValue();
    }

    public static int getMonthLength(int r10, int r11) {
        return getAdjustedMonthLength(r11)[r10].intValue();
    }

    private static int getMonthOfYear(int r10, int r11) {
        Integer[] r12 = getAdjustedMonthDays(r11);
        int r13 = 0;
        if (r10 < 0) goto L13;
    L5:
        if (r13 >= r12.length) goto L11;
        if (r10 < r12[r13].intValue()) goto L9;
        r13 = r13 + 1;
        goto L5
    L9:
        return r13 - 1;
    L11:
        return 11;
    L13:
        if (isLeapYear(r11) == false) goto L15;
        int r14 = r10 + 355;
    L17:
        if (r13 >= r12.length) goto L23;
        if (r14 < r12[r13].intValue()) goto L21;
        r13 = r13 + 1;
        goto L17
    L21:
        return r13 - 1;
    L23:
        return 11;
    L15:
        r14 = r10 + 354;
        goto L17
    }

    public static int getSmallestMaximumDayOfMonth() {
        return ADJUSTED_LEAST_MAX_VALUES[5].intValue();
    }

    public static int getSmallestMaximumDayOfYear() {
        return ADJUSTED_LEAST_MAX_VALUES[6].intValue();
    }

    private static int getYearInCycle(int r10, long r11) {
        Integer[] r12 = getAdjustedCycle(r10);
        int r13 = 0;
        if (r11 != 0) goto L6;
        return 0;
    L6:
        if (r11 > 0) goto L8;
        long r14 = -r11;
    L17:
        if (r13 >= r12.length) goto L23;
        if (r14 <= r12[r13].intValue()) goto L21;
        r13 = r13 + 1;
        goto L17
    L21:
        return r13 - 1;
    L23:
        return 29;
    L8:
        if (r13 >= r12.length) goto L14;
        if (r11 < r12[r13].intValue()) goto L12;
        r13 = r13 + 1;
        goto L8
    L12:
        return r13 - 1;
    L14:
        return 29;
    }

    public static int getYearLength(int r10) {
        int r11 = r10 - 1;
        int r12 = r11 / 30;
        Integer[] r13 = ADJUSTED_CYCLE_YEARS.get(Integer.valueOf(r12));     // Catch: ArrayIndexOutOfBoundsException -> L5
    L6:
        if (r13 == null) goto L14;
        int r14 = r11 % 30;
        if (r14 != 29) goto L12;
        Long[] r15 = ADJUSTED_CYCLES;
        return (r15[r12 + 1].intValue() - r15[r12].intValue()) - r13[r14].intValue();
    L12:
        return r13[r14 + 1].intValue() - r13[r14].intValue();
    L14:
        if (isLeapYear(r10) == false) goto L16;
        return 355;
    L16:
        return 354;
    L5:
        r13 = null;
        goto L6
    }

    public static HijrahDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static HijrahDate of(int r10, int r11, int r12) {
        if (r10 < 1) goto L6;
        return of(HijrahEra.AH, r10, r11, r12);
    L6:
        return of(HijrahEra.BEFORE_AH, 1 - r10, r11, r12);
    }

    public static HijrahDate ofEpochDay(long r10) {
        return new HijrahDate(r10);
    }

    private static void parseLine(String r10, int r11) throws ParseException {
        StringTokenizer r12 = new StringTokenizer(r10, ";");
    L4:
        if (r12.hasMoreTokens() == false) goto L45;
        String r13 = r12.nextToken();
        int r14 = r13.indexOf(58);
        if (r14 == (-1)) goto L44;
        int r15 = Integer.parseInt(r13.substring(r14 + 1, r13.length()));     // Catch: NumberFormatException -> L41
        int r16 = r13.indexOf(45);
        if (r16 == (-1)) goto L40;
        String r17 = r13.substring(0, r16);
        String r18 = r13.substring(r16 + 1, r14);
        int r19 = r17.indexOf(47);
        int r20 = r18.indexOf(47);
        if (r19 == (-1)) goto L38;
        String r21 = r17.substring(0, r19);
        String r22 = r17.substring(r19 + 1, r17.length());
        int r23 = Integer.parseInt(r21);     // Catch: NumberFormatException -> L35
        int r24 = Integer.parseInt(r22);     // Catch: NumberFormatException -> L33
        if (r20 == (-1)) goto L32;
        String r25 = r18.substring(0, r20);
        String r110 = r18.substring(r20 + 1, r18.length());
        int r26 = Integer.parseInt(r25);     // Catch: NumberFormatException -> L29
        int r111 = Integer.parseInt(r110);     // Catch: NumberFormatException -> L27
        if (r23 == (-1)) goto L26;
        if (r24 == (-1)) goto L26;
        if (r26 == (-1)) goto L26;
        if (r111 == (-1)) goto L26;
        addDeviationAsHijrah(r23, r24, r26, r111, r15);
    L26:
        throw new ParseException("Unknown error at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L28:
        throw new ParseException("End month is not properly set at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L30:
        throw new ParseException("End year is not properly set at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L32:
        throw new ParseException("End year/month has incorrect format at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L34:
        throw new ParseException("Start month is not properly set at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L36:
        throw new ParseException("Start year is not properly set at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L38:
        throw new ParseException("Start year/month has incorrect format at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L40:
        throw new ParseException("Start and end year/month has incorrect format at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L42:
        throw new ParseException("Offset is not properly set at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    L44:
        throw new ParseException("Offset has incorrect format at line " + r11 + LibrarianImpl.Constants.DOT, r11);
    }

    private static void readDeviationConfig() throws IOException, ParseException {
        InputStream r10 = getConfigFileInputStream();
        if (r10 == null) goto L18;
        BufferedReader r11 = null;
        BufferedReader r12 = new BufferedReader(new InputStreamReader(r10));     // Catch: Throwable -> L14
        int r13 = 0;
    L19:
        String r14 = r12.readLine();     // Catch: Throwable -> L11
        if (r14 == null) goto L13;
        r13 = r13 + 1;     // Catch: Throwable -> L11
        parseLine(r14.trim(), r13);     // Catch: Throwable -> L11
        goto L19
    L13:
        r12.close();
        return;
    L11:
        th = th;
        r11 = r12;
    L15:
        if (r11 == null) goto L17;
        r11.close();
    L17:
        throw th;
    L14:
        th = th;
        goto L15
    }

    public static org.threeten.bp.chrono.a readExternal(DataInput r10) throws IOException {
        int r11 = r10.readInt();
        byte r12 = r10.readByte();
        byte r13 = r10.readByte();
        return HijrahChronology.INSTANCE.date(r11, r12, r13);
    }

    private Object readResolve() {
        return new HijrahDate(this.gregorianEpochDay);
    }

    private static HijrahDate resolvePreviousValid(int r10, int r11, int r12) {
        int r13 = getMonthDays(r11 - 1, r10);
        if (r12 <= r13) goto L6;
        r12 = r13;
    L6:
        return of(r10, r11, r12);
    }

    private Object writeReplace() {
        return new Ser((byte) 3, this);
    }

    private static long yearToGregorianEpochDay(int r10) {
        int r11 = r10 - 1;
        int r12 = r11 / 30;
        int r13 = r11 % 30;
        int r14 = getAdjustedCycle(r12)[Math.abs(r13)].intValue();
        if (r13 >= 0) goto L12;
        r14 = -r14;
    L12:
        Long r15 = ADJUSTED_CYCLES[r12];     // Catch: ArrayIndexOutOfBoundsException -> L7
    L8:
        if (r15 != null) goto L11;
        r15 = new Long(r12 * 10631);
    L11:
        return (r15.longValue() + ((long) r14)) - 492149;
    L7:
        r15 = null;
        goto L8
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a
    public final b atTime(LocalTime r10) {
        return super.atTime(r10);
    }

    @Override // org.threeten.bp.chrono.a
    public /* bridge */ /* synthetic */ e getChronology() {
        return getChronology();
    }

    @Override // org.threeten.bp.chrono.a
    public /* bridge */ /* synthetic */ Era getEra() {
        return getEra();
    }

    @Override // org.threeten.bp.temporal.TemporalAccessor
    public long getLong(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L25;
        switch(a.f23089a[((ChronoField) r10).ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L13;
            case 10: goto L12;
            case 11: goto L11;
            case 12: goto L8;
            default: goto L7;
        };
    L8:
        int r11 = this.era.getValue();
    L10:
        return r11;
    L11:
        r11 = this.yearOfEra;
        goto L10
    L12:
        r11 = this.monthOfYear;
        goto L10
    L13:
        int r12 = (this.dayOfYear - 1) / 7;
    L14:
        r11 = r12 + 1;
        goto L10
    L17:
        r12 = (this.dayOfYear - 1) % 7;
        goto L14
    L18:
        r12 = (this.dayOfMonth - 1) % 7;
        goto L14
    L19:
        r11 = this.dayOfWeek.getValue();
        goto L10
    L20:
        r11 = this.yearOfEra;
        goto L10
    L21:
        r12 = (this.dayOfMonth - 1) / 7;
        goto L14
    L22:
        r11 = this.dayOfYear;
        goto L10
    L23:
        r11 = this.dayOfMonth;
        goto L10
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L16:
        return toEpochDay();
    L25:
        return r10.getFrom(this);
    }

    @Override // org.threeten.bp.chrono.a
    public boolean isLeapYear() {
        return this.isLeapYear;
    }

    @Override // org.threeten.bp.chrono.a
    public int lengthOfMonth() {
        return getMonthLength(this.monthOfYear - 1, this.yearOfEra);
    }

    @Override // org.threeten.bp.chrono.a
    public int lengthOfYear() {
        return getYearLength(this.yearOfEra);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ ChronoDateImpl plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public /* bridge */ /* synthetic */ ChronoDateImpl plusDays(long r10) {
        return plusDays(r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public /* bridge */ /* synthetic */ ChronoDateImpl plusMonths(long r10) {
        return plusMonths(r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public /* bridge */ /* synthetic */ ChronoDateImpl plusYears(long r10) {
        return plusYears(r10);
    }

    @Override // ig.c, org.threeten.bp.temporal.TemporalAccessor
    public ValueRange range(TemporalField r10) {
        if ((r10 instanceof ChronoField) == false) goto L27;
        if (isSupported(r10) == false) goto L25;
        ChronoField r11 = (ChronoField) r10;
        int r12 = a.f23089a[r11.ordinal()];
        if (r12 == 1) goto L23;
        if (r12 == 2) goto L21;
        if (r12 == 3) goto L19;
        if (r12 == 4) goto L17;
        return getChronology().range(r11);
    L17:
        return ValueRange.of(1, 1000);
    L19:
        return ValueRange.of(1, 5);
    L21:
        return ValueRange.of(1, lengthOfYear());
    L23:
        return ValueRange.of(1, lengthOfMonth());
    L25:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L27:
        return r10.rangeRefinedBy(this);
    }

    @Override // org.threeten.bp.chrono.a
    public long toEpochDay() {
        return getGregorianEpochDay(this.yearOfEra, this.monthOfYear, this.dayOfMonth);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ long until(Temporal r10, TemporalUnit r11) {
        return super.until(r10, r11);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a with(TemporalAdjuster r10) {
        return with(r10);
    }

    public void writeExternal(DataOutput r10) throws IOException {
        r10.writeInt(get(ChronoField.YEAR));
        r10.writeByte(get(ChronoField.MONTH_OF_YEAR));
        r10.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    public static boolean isLeapYear(long r10) {
        if (r10 > 0) goto L7;
        r10 = -r10;
    L7:
        if ((((r10 * 11) + 14) % 30) >= 11) goto L9;
        return true;
    L9:
        return false;
    }

    public static HijrahDate now(ZoneId r10) {
        return now(Clock.system(r10));
    }

    public static HijrahDate of(HijrahEra r10, int r11, int r12, int r13) {
        ig.d.h(r10, "era");
        checkValidYearOfEra(r11);
        checkValidMonth(r12);
        checkValidDayOfMonth(r13);
        return new HijrahDate(getGregorianEpochDay(r10.prolepticYear(r11), r12, r13));
    }

    @Override // org.threeten.bp.chrono.a
    public HijrahChronology getChronology() {
        return HijrahChronology.INSTANCE;
    }

    @Override // org.threeten.bp.chrono.a
    public HijrahEra getEra() {
        return this.era;
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public HijrahDate plusDays(long r10) {
        return new HijrahDate(this.gregorianEpochDay + r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public HijrahDate plusMonths(long r10) {
        if (r10 != 0) goto L5;
        return this;
    L5:
        int r11 = (this.monthOfYear - 1) + ((int) r10);
        int r12 = r11 / 12;
        int r13 = r11 % 12;
    L6:
        if (r13 >= 0) goto L8;
        r13 = r13 + 12;
        r12 = ig.d.n(r12, 1);
        goto L6
    L8:
        int r14 = ig.d.i(this.yearOfEra, r12);
        return of(this.era, r14, r13 + 1, this.dayOfMonth);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public HijrahDate plusYears(long r10) {
        if (r10 != 0) goto L5;
        return this;
    L5:
        int r11 = ig.d.i(this.yearOfEra, (int) r10);
        return of(this.era, r11, this.monthOfYear, this.dayOfMonth);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a
    public /* bridge */ /* synthetic */ c until(org.threeten.bp.chrono.a r10) {
        return super.until(r10);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    public static HijrahDate now(Clock r10) {
        return HijrahChronology.INSTANCE.dateNow(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(long r10, TemporalUnit r11) {
        return minus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ org.threeten.bp.chrono.a plus(TemporalAmount r10) {
        return plus(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalAdjuster r10) {
        return with(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal minus(TemporalAmount r10) {
        return minus(r10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(long r10, TemporalUnit r11) {
        return plus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal with(TemporalField r10, long r11) {
        return with(r10, r11);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public HijrahDate minus(TemporalAmount r10) {
        return (HijrahDate) super.minus(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public /* bridge */ /* synthetic */ Temporal plus(TemporalAmount r10) {
        return plus(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public HijrahDate with(TemporalAdjuster r10) {
        return (HijrahDate) super.with(r10);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public HijrahDate minus(long r10, TemporalUnit r11) {
        return (HijrahDate) super.minus(r10, r11);
    }

    @Override // org.threeten.bp.chrono.a, ig.b, org.threeten.bp.temporal.Temporal
    public HijrahDate plus(TemporalAmount r10) {
        return (HijrahDate) super.plus(r10);
    }

    @Override // org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public HijrahDate with(TemporalField r10, long r11) {
        if ((r10 instanceof ChronoField) == false) goto L37;
        ChronoField r12 = (ChronoField) r10;
        r12.checkValidValue(r11);
        int r13 = (int) r11;
        switch(a.f23089a[r12.ordinal()]) {
            case 1: goto L35;
            case 2: goto L32;
            case 3: goto L31;
            case 4: goto L25;
            case 5: goto L23;
            case 6: goto L21;
            case 7: goto L19;
            case 8: goto L17;
            case 9: goto L15;
            case 10: goto L13;
            case 11: goto L11;
            case 12: goto L9;
            default: goto L7;
        };
    L32:
        int r14 = r13 - 1;
        return resolvePreviousValid(this.yearOfEra, (r14 / 30) + 1, (r14 % 30) + 1);
    L7:
        throw new UnsupportedTemporalTypeException("Unsupported field: " + r10);
    L9:
        return resolvePreviousValid(1 - this.yearOfEra, this.monthOfYear, this.dayOfMonth);
    L11:
        return resolvePreviousValid(r13, this.monthOfYear, this.dayOfMonth);
    L13:
        return resolvePreviousValid(this.yearOfEra, r13, this.dayOfMonth);
    L15:
        return plusDays((r11 - getLong(ChronoField.ALIGNED_WEEK_OF_YEAR)) * 7);
    L17:
        return new HijrahDate(r13);
    L19:
        return plusDays(r11 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR));
    L21:
        return plusDays(r11 - getLong(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH));
    L23:
        return plusDays(r11 - ((long) this.dayOfWeek.getValue()));
    L25:
        if (this.yearOfEra >= 1) goto L29;
        r13 = 1 - r13;
    L29:
        return resolvePreviousValid(r13, this.monthOfYear, this.dayOfMonth);
    L31:
        return plusDays((r11 - getLong(ChronoField.ALIGNED_WEEK_OF_MONTH)) * 7);
    L35:
        return resolvePreviousValid(this.yearOfEra, this.monthOfYear, r13);
    L37:
        return (HijrahDate) r10.adjustInto(this, r11);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a, org.threeten.bp.temporal.Temporal
    public HijrahDate plus(long r10, TemporalUnit r11) {
        return (HijrahDate) super.plus(r10, r11);
    }

    public static HijrahDate of(LocalDate r10) {
        return new HijrahDate(r10.toEpochDay());
    }
}
