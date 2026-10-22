package org.threeten.bp.format;

import com.blankj.utilcode.constant.CacheConstants;
import com.bytedance.keva.KevaImpl;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import org.apache.http.message.TokenParser;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.IsoFields;
import org.threeten.bp.temporal.TemporalAccessor;
import org.threeten.bp.temporal.TemporalField;
import org.threeten.bp.temporal.TemporalQuery;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.temporal.WeekFields;

/* JADX INFO: loaded from: classes4.dex */
public final class DateTimeFormatterBuilder {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final TemporalQuery f23122h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Map f23123i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Comparator f23124j = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public DateTimeFormatterBuilder f23125a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DateTimeFormatterBuilder f23126b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f23127c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f23128d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f23129e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public char f23130f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f23131g;

    public interface DateTimePrinterParser {
        int parse(org.threeten.bp.format.b r10, CharSequence r11, int r12);

        boolean print(org.threeten.bp.format.c r10, StringBuilder r11);
    }

    public static final enum SettingsParser extends Enum<SettingsParser> implements DateTimePrinterParser {
        private static final /* synthetic */ SettingsParser[] $VALUES = null;
        public static final SettingsParser INSENSITIVE = null;
        public static final SettingsParser LENIENT = null;
        public static final SettingsParser SENSITIVE = null;
        public static final SettingsParser STRICT = null;

        static {
            SettingsParser r10 = new SettingsParser("SENSITIVE", 0);
            SENSITIVE = r10;
            SettingsParser r11 = new SettingsParser("INSENSITIVE", 1);
            INSENSITIVE = r11;
            SettingsParser r12 = new SettingsParser("STRICT", 2);
            STRICT = r12;
            SettingsParser r13 = new SettingsParser("LENIENT", 3);
            LENIENT = r13;
            $VALUES = new SettingsParser[]{r10, r11, r12, r13};
        }

        private SettingsParser(String r10, int r11) {
            super(r10, r11);
        }

        public static SettingsParser valueOf(String r10) {
            return (SettingsParser) Enum.valueOf(SettingsParser.class, r10);
        }

        public static SettingsParser[] values() {
            return (SettingsParser[]) $VALUES.clone();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(org.threeten.bp.format.b r10, CharSequence r11, int r12) {
            int r13 = ordinal();
            if (r13 != 0) goto L5;
            r10.n(true);
        L15:
            return r12;
        L5:
            if (r13 != 1) goto L7;
            r10.n(false);
            goto L15
        L7:
            if (r13 != 2) goto L9;
            r10.s(true);
            goto L15
        L9:
            if (r13 != 3) goto L15;
            r10.s(false);
            goto L15
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(org.threeten.bp.format.c r10, StringBuilder r11) {
            return true;
        }

        @Override // java.lang.Enum
        public String toString() {
            int r10 = ordinal();
            if (r10 != 0) goto L5;
            return "ParseCaseSensitive(true)";
        L5:
            if (r10 != 1) goto L7;
            return "ParseCaseSensitive(false)";
        L7:
            if (r10 != 2) goto L9;
            return "ParseStrict(true)";
        L9:
            if (r10 != 3) goto L13;
            return "ParseStrict(false)";
        L13:
            throw new IllegalStateException("Unreachable");
        }
    }

    public static class a implements TemporalQuery {
        public a() {
        }

        public ZoneId a(TemporalAccessor r10) {
            ZoneId r11 = (ZoneId) r10.query(org.threeten.bp.temporal.b.g());
            if (r11 != null) goto L5;
        L7:
            return null;
        L5:
            if ((r11 instanceof ZoneOffset) == true) goto L7;
            return r11;
        }

        @Override // org.threeten.bp.temporal.TemporalQuery
        public /* bridge */ /* synthetic */ Object queryFrom(TemporalAccessor r10) {
            return a(r10);
        }
    }

    public class b extends org.threeten.bp.format.d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ org.threeten.bp.format.f.b f23132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DateTimeFormatterBuilder f23133c;

        public b(DateTimeFormatterBuilder r10, org.threeten.bp.format.f.b r11) {
            this.f23133c = r10;
            this.f23132b = r11;
        }

        @Override // org.threeten.bp.format.d
        public String c(TemporalField r10, long r11, TextStyle r12, Locale r13) {
            return this.f23132b.a(r11, r12);
        }

        @Override // org.threeten.bp.format.d
        public Iterator d(TemporalField r10, TextStyle r11, Locale r12) {
            return this.f23132b.b(r11);
        }
    }

    public static class c implements Comparator {
        public c() {
        }

        public int a(String r10, String r11) {
            if (r10.length() != r11.length()) goto L6;
            return r10.compareTo(r11);
        L6:
            return r10.length() - r11.length();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
            return a((String) r10, (String) r11);
        }
    }

    public static /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f23134a = null;

        static {
            int[] r10 = new int[SignStyle.values().length];
            f23134a = r10;
            r10[SignStyle.EXCEEDS_PAD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f23134a[SignStyle.ALWAYS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f23134a[SignStyle.NORMAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f23134a[SignStyle.NOT_NEGATIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final class e implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f23135a;

        public e(char r10) {
            this.f23135a = r10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(org.threeten.bp.format.b r10, CharSequence r11, int r12) {
            if (r12 == r11.length()) goto L5;
            char r13 = r11.charAt(r12);
            if (r10.c(this.f23135a, r13) == true) goto L11;
            return ~r12;
        L11:
            return r12 + 1;
        L5:
            return ~r12;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(org.threeten.bp.format.c r10, StringBuilder r11) {
            r11.append(this.f23135a);
            return true;
        }

        public String toString() {
            if (this.f23135a != '\'') goto L7;
            return "''";
        L7:
            return "'" + this.f23135a + "'";
        }
    }

    public static final class f implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextStyle f23136a;

        public f(TextStyle r10) {
            this.f23136a = r10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(org.threeten.bp.format.b r11, CharSequence r12, int r13) {
            if (r13 < 0) goto L19;
            if (r13 > r12.length()) goto L19;
            Iterator<org.threeten.bp.chrono.e> r10 = org.threeten.bp.chrono.e.getAvailableChronologies().iterator();
            org.threeten.bp.chrono.e r14 = null;
            int r15 = -1;
        L7:
            if (r10.hasNext() == false) goto L13;
            org.threeten.bp.chrono.e r16 = r10.next();
            String r17 = r16.getId();
            int r18 = r17.length();
            if (r18 <= r15) goto L7;
            if (r11.u(r12, r13, r17, 0, r18) == false) goto L7;
            r14 = r16;
            r15 = r18;
            goto L7
        L13:
            if (r14 == null) goto L15;
            r11.p(r14);
            return r13 + r15;
        L15:
            return ~r13;
        L19:
            throw new IndexOutOfBoundsException();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(org.threeten.bp.format.c r10, StringBuilder r11) {
            org.threeten.bp.chrono.e r12 = (org.threeten.bp.chrono.e) r10.g(org.threeten.bp.temporal.b.a());
            if (r12 != null) goto L7;
            return false;
        L7:
            if (this.f23136a != null) goto L9;
            r11.append(r12.getId());
            return true;
        L9:
            ResourceBundle r13 = ResourceBundle.getBundle("org.threeten.bp.format.ChronologyText", r10.c(), DateTimeFormatterBuilder.class.getClassLoader());
            r11.append(r13.getString(r12.getId()));     // Catch: MissingResourceException -> L12
            return true;
        L12:
            r11.append(r12.getId());
            return true;
        }
    }

    public static final class g implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DateTimePrinterParser[] f23137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f23138b;

        public g(List r10, boolean r11) {
            this((DateTimePrinterParser[]) r10.toArray(new DateTimePrinterParser[r10.size()]), r11);
        }

        public g a(boolean r10) {
            if (r10 != this.f23138b) goto L6;
            return this;
        L6:
            return new g(this.f23137a, r10);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(org.threeten.bp.format.b r10, CharSequence r11, int r12) {
            int r13 = 0;
            if (this.f23138b == false) goto L13;
            r10.t();
            DateTimePrinterParser[] r14 = this.f23137a;
            int r15 = r14.length;
            int r16 = r12;
            int r17 = 0;
        L5:
            if (r17 >= r15) goto L11;
            r16 = r14[r17].parse(r10, r11, r16);
            if (r16 < 0) goto L8;
            r17 = r17 + 1;
            goto L5
        L8:
            r10.g(false);
            return r12;
        L11:
            r10.g(true);
            return r16;
        L13:
            DateTimePrinterParser[] r18 = this.f23137a;
            int r19 = r18.length;
        L14:
            if (r13 >= r19) goto L19;
            r12 = r18[r13].parse(r10, r11, r12);
            if (r12 < 0) goto L19;
            r13 = r13 + 1;
        L19:
            return r12;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(org.threeten.bp.format.c r10, StringBuilder r11) {
            int r12 = r11.length();
            if (this.f23138b == false) goto L26;
            r10.h();
        L26:
            DateTimePrinterParser[] r13 = this.f23137a;     // Catch: Throwable -> L15
            int r14 = r13.length;     // Catch: Throwable -> L15
            int r15 = 0;
        L7:
            if (r15 >= r14) goto L19;
            if (r13[r15].print(r10, r11) == false) goto L10;
            r15 = r15 + 1;
            goto L7
        L10:
            r11.setLength(r12);     // Catch: Throwable -> L15
            if (this.f23138b == false) goto L14;
            r10.b();
        L14:
            return true;
        L19:
            if (this.f23138b == false) goto L21;
            r10.b();
        L21:
            return true;
        L15:
            th = move-exception;
            if (this.f23138b == false) goto L25;
            r10.b();
        L25:
            throw th;
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            if (this.f23137a == null) goto L17;
            if (this.f23138b == false) goto L7;
            String r11 = "[";
        L8:
            r10.append(r11);
            DateTimePrinterParser[] r12 = this.f23137a;
            int r13 = r12.length;
            int r14 = 0;
        L9:
            if (r14 >= r13) goto L12;
            r10.append(r12[r14]);
            r14 = r14 + 1;
            goto L9
        L12:
            if (this.f23138b == false) goto L14;
            String r15 = "]";
        L15:
            r10.append(r15);
            goto L17
        L14:
            r15 = ")";
            goto L15
        L7:
            r11 = "(";
        L17:
            return r10.toString();
        }

        public g(DateTimePrinterParser[] r10, boolean r11) {
            this.f23137a = r10;
            this.f23138b = r11;
        }
    }

    public static final class h implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TemporalField f23139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f23140b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f23141c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f23142d;

        public h(TemporalField r10, int r11, int r12, boolean r13) {
            ig.d.h(r10, "field");
            if (r10.range().isFixed() == false) goto L20;
            if (r11 < 0) goto L18;
            if (r11 > 9) goto L18;
            if (r12 < 1) goto L16;
            if (r12 > 9) goto L16;
            if (r12 < r11) goto L14;
            this.f23139a = r10;
            this.f23140b = r11;
            this.f23141c = r12;
            this.f23142d = r13;
            return;
        L14:
            throw new IllegalArgumentException("Maximum width must exceed or equal the minimum width but " + r12 + " < " + r11);
        L16:
            throw new IllegalArgumentException("Maximum width must be from 1 to 9 inclusive but was " + r12);
        L18:
            throw new IllegalArgumentException("Minimum width must be from 0 to 9 inclusive but was " + r11);
        L20:
            throw new IllegalArgumentException("Field must have a fixed set of values: " + r10);
        }

        public final long a(BigDecimal r10) {
            ValueRange r11 = this.f23139a.range();
            BigDecimal r12 = BigDecimal.valueOf(r11.getMinimum());
            return r10.multiply(BigDecimal.valueOf(r11.getMaximum()).subtract(r12).add(BigDecimal.ONE)).setScale(0, RoundingMode.FLOOR).add(r12).longValueExact();
        }

        public final BigDecimal b(long r10) {
            ValueRange r11 = this.f23139a.range();
            r11.checkValidValue(r10, this.f23139a);
            BigDecimal r12 = BigDecimal.valueOf(r11.getMinimum());
            BigDecimal r13 = BigDecimal.valueOf(r11.getMaximum()).subtract(r12).add(BigDecimal.ONE);
            BigDecimal r14 = BigDecimal.valueOf(r10).subtract(r12).divide(r13, 9, RoundingMode.FLOOR);
            BigDecimal r15 = BigDecimal.ZERO;
            if (r14.compareTo(r15) != 0) goto L6;
            return r15;
        L6:
            return r14.stripTrailingZeros();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(org.threeten.bp.format.b r11, CharSequence r12, int r13) {
            int r10 = 0;
            if (r11.m() == false) goto L5;
            int r14 = this.f23140b;
        L7:
            if (r11.m() == false) goto L9;
            int r15 = this.f23141c;
        L10:
            int r16 = r12.length();
            if (r13 != r16) goto L16;
            if (r14 > 0) goto L14;
            return r13;
        L14:
            return ~r13;
        L16:
            if (this.f23142d == true) goto L18;
        L23:
            int r17 = r13;
            int r18 = r14 + r17;
            if (r18 > r16) goto L26;
            int r19 = Math.min(r15 + r17, r16);
            int r20 = r17;
        L28:
            if (r20 >= r19) goto L36;
            int r21 = r20 + 1;
            int r22 = r11.k().b(r12.charAt(r20));
            if (r22 < 0) goto L31;
            r10 = (r10 * 10) + r22;
            r20 = r21;
            goto L28
        L31:
            if (r21 >= r18) goto L36;
            return ~r17;
        L36:
            return r11.q(this.f23139a, a(new BigDecimal(r10).movePointLeft(r20 - r17)), r17, r20);
        L26:
            return ~r17;
        L18:
            if (r12.charAt(r13) == r11.k().c()) goto L22;
            if (r14 > 0) goto L21;
            return r13;
        L21:
            return ~r13;
        L22:
            r13 = r13 + 1;
            goto L23
        L9:
            r15 = 9;
            goto L10
        L5:
            r14 = 0;
            goto L7
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(org.threeten.bp.format.c r10, StringBuilder r11) {
            Long r12 = r10.f(this.f23139a);
            int r13 = 0;
            if (r12 != null) goto L5;
            return false;
        L5:
            org.threeten.bp.format.e r14 = r10.d();
            BigDecimal r15 = b(r12.longValue());
            if (r15.scale() == 0) goto L8;
            String r16 = r14.a(r15.setScale(Math.min(Math.max(r15.scale(), this.f23140b), this.f23141c), RoundingMode.FLOOR).toPlainString().substring(2));
            if (this.f23142d == false) goto L18;
            r11.append(r14.c());
        L18:
            r11.append(r16);
            return true;
        L8:
            if (this.f23140b > 0) goto L10;
            return true;
        L10:
            if (this.f23142d == false) goto L13;
            r11.append(r14.c());
        L13:
            if (r13 >= this.f23140b) goto L24;
            r11.append(r14.f());
            r13 = r13 + 1;
            goto L13
        L24:
            return true;
        }

        public String toString() {
            if (this.f23142d == false) goto L5;
            String r10 = ",DecimalPoint";
        L7:
            return "Fraction(" + this.f23139a + "," + this.f23140b + "," + this.f23141c + r10 + ")";
        L5:
            r10 = "";
            goto L7
        }
    }

    public static final class i implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f23143a;

        public i(int r10) {
            this.f23143a = r10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(org.threeten.bp.format.b r20, CharSequence r21, int r22) {
            org.threeten.bp.format.b r10 = r20.e();
            int r11 = this.f23143a;
            int r12 = 0;
            if (r11 >= 0) goto L5;
            int r13 = 0;
        L6:
            if (r11 >= 0) goto L8;
            r11 = 9;
        L8:
            DateTimeFormatterBuilder r14 = new DateTimeFormatterBuilder().a(DateTimeFormatter.f23098h).f('T');
            ChronoField r15 = ChronoField.HOUR_OF_DAY;
            DateTimeFormatterBuilder r16 = r14.p(r15, 2).f(':');
            ChronoField r17 = ChronoField.MINUTE_OF_HOUR;
            DateTimeFormatterBuilder r18 = r16.p(r17, 2).f(':');
            ChronoField r19 = ChronoField.SECOND_OF_MINUTE;
            DateTimeFormatterBuilder r23 = r18.p(r19, 2);
            ChronoField r24 = ChronoField.NANO_OF_SECOND;
            int r110 = r23.c(r24, r13, r11, true).f('Z').E().q(false).parse(r10, r21, r22);
            if (r110 >= 0) goto L11;
            return r110;
        L11:
            long r25 = r10.j(ChronoField.YEAR).longValue();
            int r111 = r10.j(ChronoField.MONTH_OF_YEAR).intValue();
            int r112 = r10.j(ChronoField.DAY_OF_MONTH).intValue();
            int r26 = r10.j(r15).intValue();
            int r27 = r10.j(r17).intValue();
            Long r28 = r10.j(r19);
            Long r29 = r10.j(r24);
            if (r28 == null) goto L14;
            int r30 = r28.intValue();
        L15:
            if (r29 == null) goto L17;
            int r31 = r29.intValue();
        L18:
            int r113 = ((int) r25) % KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            if (r26 != 24) goto L25;
            if (r27 != 0) goto L25;
            if (r30 != 0) goto L25;
            if (r31 != 0) goto L25;
            int r114 = 0;
            int r115 = r30;
            r12 = 1;
        L38:
            return r20.q(r24, r31, r22, r20.q(ChronoField.INSTANT_SECONDS, ig.d.m(r25 / 10000, 315569520000L) + LocalDateTime.of(r113, r111, r112, r114, r27, r115, 0).plusDays(r12).toEpochSecond(ZoneOffset.UTC), r22, r110));
        L37:
            return ~r22;
        L25:
            if (r26 == 23) goto L27;
        L31:
            r114 = r26;
            r115 = r30;
            goto L38
        L27:
            if (r27 != 59) goto L31;
            if (r30 != 60) goto L31;
            r20.r();
            r115 = 59;
            r114 = r26;
            goto L38
        L17:
            r31 = 0;
            goto L18
        L14:
            r30 = 0;
            goto L15
        L5:
            r13 = r11;
            goto L6
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(org.threeten.bp.format.c r18, StringBuilder r19) {
            Long r10 = r18.f(ChronoField.INSTANT_SECONDS);
            Long r11 = 0L;
            TemporalAccessor r12 = r18.e();
            ChronoField r13 = ChronoField.NANO_OF_SECOND;
            if (r12.isSupported(r13) == false) goto L5;
            r11 = Long.valueOf(r18.e().getLong(r13));
        L5:
            int r14 = 0;
            if (r10 != null) goto L8;
            return false;
        L8:
            long r15 = r10.longValue();
            int r16 = r13.checkValidIntValue(r11.longValue());
            if (r15 < (-62167219200L)) goto L16;
            long r17 = r15 - 253402300800L;
            long r110 = 1 + ig.d.d(r17, 315569520000L);
            LocalDateTime r20 = LocalDateTime.ofEpochSecond(ig.d.g(r17, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
            if (r110 <= 0) goto L13;
            r19.append('+');
            r19.append(r110);
        L13:
            r19.append(r20);
            if (r20.getSecond() != 0) goto L28;
            r19.append(":00");
        L28:
            int r21 = this.f23143a;
            if (r21 != (-2)) goto L39;
            if (r16 == 0) goto L48;
            r19.append('.');
            if ((r16 % 1000000) != 0) goto L35;
            r19.append(Integer.toString((r16 / 1000000) + 1000).substring(1));
            goto L48
        L35:
            if ((r16 % 1000) != 0) goto L37;
            r19.append(Integer.toString((r16 / 1000) + 1000000).substring(1));
            goto L48
        L37:
            r19.append(Integer.toString(r16 + 1000000000).substring(1));
        L48:
            r19.append('Z');
            return true;
        L39:
            if (r21 > 0) goto L42;
            if (r21 != (-1)) goto L48;
            if (r16 <= 0) goto L48;
        L42:
            r19.append('.');
            int r22 = 100000000;
        L43:
            int r23 = this.f23143a;
            if (r23 != (-1)) goto L46;
            if (r16 <= 0) goto L46;
        L47:
            int r24 = r16 / r22;
            r19.append((char) (r24 + 48));
            r16 = r16 - (r24 * r22);
            r22 = r22 / 10;
            r14 = r14 + 1;
        L46:
            if (r14 >= r23) goto L48;
        L16:
            long r25 = r15 + 62167219200L;
            long r111 = r25 / 315569520000L;
            long r26 = r25 % 315569520000L;
            LocalDateTime r27 = LocalDateTime.ofEpochSecond(r26 - 62167219200L, 0, ZoneOffset.UTC);
            int r28 = r19.length();
            r19.append(r27);
            if (r27.getSecond() != 0) goto L20;
            r19.append(":00");
        L20:
            if (r111 >= 0) goto L28;
            if (r27.getYear() != (-10000)) goto L25;
            r19.replace(r28, r28 + 2, Long.toString(r111 - 1));
            goto L28
        L25:
            if (r26 != 0) goto L27;
            r19.insert(r28, r111);
            goto L28
        L27:
            r19.insert(r28 + 1, Math.abs(r111));
            goto L28
        }

        public String toString() {
            return "Instant()";
        }
    }

    public static final class j implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextStyle f23144a;

        public j(TextStyle r10) {
            this.f23144a = r10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(org.threeten.bp.format.b r14, CharSequence r15, int r16) {
            if (r14.u(r15, r16, "GMT", 0, 3) == false) goto L5;
            int r10 = r16 + 3;
            if (this.f23144a == TextStyle.FULL) goto L9;
            int r11 = r15.length();
            if (r10 == r11) goto L13;
            char r12 = r15.charAt(r10);
            if (r12 == '+') goto L19;
            if (r12 == '-') goto L19;
            return r14.q(ChronoField.OFFSET_SECONDS, 0, r10, r10);
        L19:
            if (r12 != '-') goto L21;
            int r13 = -1;
        L22:
            if (r10 == r11) goto L24;
            int r17 = r16 + 4;
            char r18 = r15.charAt(r17);
            if (r18 < '0') goto L96;
            if (r18 > '9') goto L96;
            int r19 = r16 + 5;
            int r20 = r18 - '0';
            if (r19 == r11) goto L40;
            char r21 = r15.charAt(r19);
            if (r21 < '0') goto L40;
            if (r21 > '9') goto L40;
            r20 = (r20 * 10) + (r21 - '0');
            if (r20 > 23) goto L38;
            r19 = r16 + 6;
            goto L40
        L38:
            return ~r19;
        L40:
            int r22 = r19;
            if (r22 == r11) goto L94;
            if (r15.charAt(r22) != ':') goto L94;
            int r23 = r22 + 1;
            int r110 = r11 - 2;
            if (r23 > r110) goto L48;
            char r111 = r15.charAt(r23);
            if (r111 < '0') goto L92;
            if (r111 > '9') goto L92;
            int r24 = r22 + 2;
            int r112 = r111 - '0';
            char r113 = r15.charAt(r24);
            if (r113 < '0') goto L90;
            if (r113 > '9') goto L90;
            int r25 = r22 + 3;
            int r114 = (r112 * 10) + (r113 - '0');
            if (r114 > 59) goto L60;
            if (r25 == r11) goto L88;
            if (r15.charAt(r25) != ':') goto L88;
            int r26 = r22 + 4;
            if (r26 > r110) goto L68;
            char r27 = r15.charAt(r26);
            if (r27 < '0') goto L86;
            if (r27 > '9') goto L86;
            int r28 = r22 + 5;
            int r29 = r27 - '0';
            char r30 = r15.charAt(r28);
            if (r30 < '0') goto L84;
            if (r30 > '9') goto L84;
            int r31 = r22 + 6;
            int r32 = (r29 * 10) + (r30 - '0');
            if (r32 <= 59) goto L82;
            return ~r31;
        L82:
            return r14.q(ChronoField.OFFSET_SECONDS, r13 * (((r20 * CacheConstants.HOUR) + (r114 * 60)) + r32), r31, r31);
        L84:
            return ~r28;
        L86:
            return ~r26;
        L68:
            return ~r26;
        L88:
            return r14.q(ChronoField.OFFSET_SECONDS, r13 * ((r20 * CacheConstants.HOUR) + (r114 * 60)), r25, r25);
        L60:
            return ~r25;
        L90:
            return ~r24;
        L92:
            return ~r23;
        L48:
            return ~r23;
        L94:
            return r14.q(ChronoField.OFFSET_SECONDS, (r13 * CacheConstants.HOUR) * r20, r22, r22);
        L96:
            return ~r17;
        L24:
            return ~r10;
        L21:
            r13 = 1;
            goto L22
        L13:
            return r14.q(ChronoField.OFFSET_SECONDS, 0, r10, r10);
        L9:
            return new l("", "+HH:MM:ss").parse(r14, r15, r10);
        L5:
            return ~r16;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(org.threeten.bp.format.c r10, StringBuilder r11) {
            Long r12 = r10.f(ChronoField.OFFSET_SECONDS);
            if (r12 != null) goto L6;
            return false;
        L6:
            r11.append("GMT");
            if (this.f23144a == TextStyle.FULL) goto L9;
            int r13 = ig.d.p(r12.longValue());
            if (r13 == 0) goto L24;
            int r14 = Math.abs((r13 / CacheConstants.HOUR) % 100);
            int r15 = Math.abs((r13 / 60) % 60);
            int r16 = Math.abs(r13 % 60);
            if (r13 >= 0) goto L15;
            String r17 = "-";
        L16:
            r11.append(r17);
            r11.append(r14);
            if (r15 > 0) goto L19;
            if (r16 > 0) goto L19;
            return true;
        L19:
            r11.append(":");
            r11.append((char) ((r15 / 10) + 48));
            r11.append((char) ((r15 % 10) + 48));
            if (r16 <= 0) goto L26;
            r11.append(":");
            r11.append((char) ((r16 / 10) + 48));
            r11.append((char) ((r16 % 10) + 48));
            return true;
        L26:
            return true;
        L15:
            r17 = "+";
            goto L16
        L24:
            return true;
        L9:
            return new l("", "+HH:MM:ss").print(r10, r11);
        }
    }

    public static class k implements DateTimePrinterParser {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final int[] f23145f = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TemporalField f23146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f23147b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f23148c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final SignStyle f23149d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f23150e;

        static {
            f23145f = new int[]{0, 10, 100, 1000, KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD, 100000, 1000000, 10000000, 100000000, 1000000000};
        }

        public /* synthetic */ k(TemporalField r10, int r11, int r12, SignStyle r13, int r14, a r15) {
            this(r10, r11, r12, r13, r14);
        }

        public long a(org.threeten.bp.format.c r10, long r11) {
            return r11;
        }

        public boolean b(org.threeten.bp.format.b r10) {
            int r11 = this.f23150e;
            if (r11 == (-1)) goto L11;
            if (r11 > 0) goto L6;
        L10:
            return false;
        L6:
            if (this.f23147b != this.f23148c) goto L10;
            if (this.f23149d != SignStyle.NOT_NEGATIVE) goto L10;
        L11:
            return true;
        }

        public int c(org.threeten.bp.format.b r10, long r11, int r12, int r13) {
            return r10.q(this.f23146a, r11, r12, r13);
        }

        public k d() {
            if (this.f23150e != (-1)) goto L6;
            return this;
        L6:
            return new k(this.f23146a, this.f23147b, this.f23148c, this.f23149d, -1);
        }

        public k e(int r10) {
            return new k(this.f23146a, this.f23147b, this.f23148c, this.f23149d, this.f23150e + r10);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(org.threeten.bp.format.b r20, CharSequence r21, int r22) {
            int r10 = r21.length();
            if (r22 == r10) goto L5;
            char r11 = r21.charAt(r22);
            int r12 = 0;
            if (r11 != r20.k().e()) goto L18;
            SignStyle r13 = this.f23149d;
            boolean r14 = r20.m();
            if (this.f23147b != this.f23148c) goto L11;
            boolean r15 = true;
        L13:
            if (r13.parse(true, r14, r15) == false) goto L15;
            int r16 = r22 + 1;
            boolean r17 = false;
            boolean r18 = true;
        L36:
            if (r20.m() == false) goto L38;
        L41:
            int r19 = this.f23147b;
        L42:
            int r23 = r16 + r19;
            if (r23 <= r10) goto L47;
            return ~r16;
        L47:
            if (r20.m() == false) goto L49;
        L52:
            int r24 = this.f23148c;
        L53:
            int r25 = r24 + Math.max(this.f23150e, 0);
        L54:
            BigInteger r110 = null;
            if (r12 >= 2) goto L77;
            int r26 = Math.min(r25 + r16, r10);
            int r111 = r16;
            long r112 = 0;
        L57:
            if (r111 >= r26) goto L63;
            int r113 = r111 + 1;
            int r27 = r20.k().b(r21.charAt(r111));
            if (r27 < 0) goto L60;
            if ((r113 - r16) <= 18) goto L69;
            if (r110 != null) goto L68;
            r110 = BigInteger.valueOf(r112);
        L68:
            r110 = r110.multiply(BigInteger.TEN).add(BigInteger.valueOf(r27));
        L70:
            r23 = r23;
            r26 = r26;
            r111 = r113;
            goto L57
        L69:
            r112 = (r112 * 10) + ((long) r27);
            goto L70
        L60:
            if (r111 >= r23) goto L63;
            return ~r16;
        L63:
            int r28 = r23;
            int r29 = this.f23150e;
            if (r29 <= 0) goto L76;
            if (r12 != 0) goto L76;
            r25 = Math.max(r19, (r111 - r16) - r29);
            r12 = r12 + 1;
            r23 = r28;
        L76:
            int r30 = r111;
        L78:
            if (r17 == false) goto L96;
            if (r110 == null) goto L89;
            if (r110.equals(BigInteger.ZERO) == true) goto L83;
        L86:
            r110 = r110.negate();
        L87:
            long r31 = r112;
        L109:
            if (r110 == null) goto L116;
            if (r110.bitLength() <= 63) goto L114;
            r110 = r110.divide(BigInteger.TEN);
            r30 = r30 - 1;
        L114:
            return c(r20, r110.longValue(), r16, r30);
        L116:
            return c(r20, r31, r16, r30);
        L83:
            if (r20.m() == false) goto L86;
            return ~(r16 - 1);
        L89:
            if (r112 == 0) goto L91;
        L94:
            r31 = -r112;
            goto L109
        L91:
            if (r20.m() == false) goto L94;
            return ~(r16 - 1);
        L96:
            if (this.f23149d != SignStyle.EXCEEDS_PAD) goto L87;
            if (r20.m() == false) goto L87;
            int r32 = r30 - r16;
            if (r18 == false) goto L106;
            if (r32 > this.f23147b) goto L87;
            return ~(r16 - 1);
        L106:
            if (r32 <= this.f23147b) goto L87;
            return ~r16;
        L77:
            r30 = r16;
            r112 = 0;
            goto L78
        L49:
            if (b(r20) == true) goto L52;
            r24 = 9;
            goto L53
        L38:
            if (b(r20) == true) goto L41;
            r19 = 1;
            goto L42
        L15:
            return ~r22;
        L11:
            r15 = false;
            goto L13
        L18:
            if (r11 != r20.k().d()) goto L29;
            SignStyle r33 = this.f23149d;
            boolean r34 = r20.m();
            if (this.f23147b != this.f23148c) goto L22;
            boolean r35 = true;
        L24:
            if (r33.parse(false, r34, r35) == false) goto L26;
            r16 = r22 + 1;
            r18 = false;
            r17 = true;
            goto L36
        L26:
            return ~r22;
        L22:
            r35 = false;
            goto L24
        L29:
            if (this.f23149d == SignStyle.ALWAYS) goto L31;
        L34:
            r16 = r22;
            r17 = false;
            r18 = false;
            goto L36
        L31:
            if (r20.m() == false) goto L34;
            return ~r22;
        L5:
            return ~r22;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(org.threeten.bp.format.c r11, StringBuilder r12) {
            Long r10 = r11.f(this.f23146a);
            int r13 = 0;
            if (r10 != null) goto L5;
            return false;
        L5:
            long r14 = a(r11, r10.longValue());
            org.threeten.bp.format.e r15 = r11.d();
            if (r14 != Long.MIN_VALUE) goto L8;
            String r16 = "9223372036854775808";
        L10:
            if (r16.length() > this.f23148c) goto L40;
            String r17 = r15.a(r16);
            if (r14 < 0) goto L23;
            int r18 = d.f23134a[this.f23149d.ordinal()];
            if (r18 == 1) goto L18;
            if (r18 != 2) goto L35;
            r12.append(r15.e());
        L35:
            if (r13 >= (this.f23147b - r17.length())) goto L37;
            r12.append(r15.f());
            r13 = r13 + 1;
            goto L35
        L37:
            r12.append(r17);
            return true;
        L18:
            int r19 = this.f23147b;
            if (r19 >= 19) goto L35;
            if (r14 < f23145f[r19]) goto L35;
            r12.append(r15.e());
            goto L35
        L23:
            int r20 = d.f23134a[this.f23149d.ordinal()];
            if (r20 == 1) goto L33;
            if (r20 == 2) goto L33;
            if (r20 == 3) goto L33;
            if (r20 != 4) goto L35;
            throw new DateTimeException("Field " + this.f23146a + " cannot be printed as the value " + r14 + " cannot be negative according to the SignStyle");
        L33:
            r12.append(r15.d());
            goto L35
        L40:
            throw new DateTimeException("Field " + this.f23146a + " cannot be printed as the value " + r14 + " exceeds the maximum print width of " + this.f23148c);
        L8:
            r16 = Long.toString(Math.abs(r14));
            goto L10
        }

        public String toString() {
            int r10 = this.f23147b;
            if (r10 != 1) goto L11;
            if (this.f23148c != 19) goto L11;
            if (this.f23149d != SignStyle.NORMAL) goto L11;
            return "Value(" + this.f23146a + ")";
        L11:
            if (r10 != this.f23148c) goto L17;
            if (this.f23149d != SignStyle.NOT_NEGATIVE) goto L17;
            return "Value(" + this.f23146a + "," + this.f23147b + ")";
        L17:
            return "Value(" + this.f23146a + "," + this.f23147b + "," + this.f23148c + "," + this.f23149d + ")";
        }

        public k(TemporalField r10, int r11, int r12, SignStyle r13) {
            this.f23146a = r10;
            this.f23147b = r11;
            this.f23148c = r12;
            this.f23149d = r13;
            this.f23150e = 0;
        }

        public k(TemporalField r10, int r11, int r12, SignStyle r13, int r14) {
            this.f23146a = r10;
            this.f23147b = r11;
            this.f23148c = r12;
            this.f23149d = r13;
            this.f23150e = r14;
        }
    }

    public static final class l implements DateTimePrinterParser {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String[] f23151c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final l f23152d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f23153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f23154b;

        static {
            f23151c = new String[]{"+HH", "+HHmm", "+HH:mm", "+HHMM", "+HH:MM", "+HHMMss", "+HH:MM:ss", "+HHMMSS", "+HH:MM:SS"};
            f23152d = new l("Z", "+HH:MM:ss");
        }

        public l(String r10, String r11) {
            ig.d.h(r10, "noOffsetText");
            ig.d.h(r11, "pattern");
            this.f23153a = r10;
            this.f23154b = a(r11);
        }

        public final int a(String r10) {
            int r11 = 0;
        L3:
            String[] r12 = f23151c;
            if (r11 >= r12.length) goto L10;
            if (r12[r11].equals(r10) == true) goto L7;
            r11 = r11 + 1;
            goto L3
        L7:
            return r11;
        L10:
            throw new IllegalArgumentException("Invalid zone offset pattern: " + r10);
        }

        public final boolean b(int[] r10, int r11, CharSequence r12, boolean r13) {
            int r14 = this.f23154b;
            if (((r14 + 3) / 2) >= r11) goto L5;
            return false;
        L5:
            int r15 = r10[0];
            if ((r14 % 2) != 0) goto L17;
            if (r11 <= 1) goto L17;
            int r16 = r15 + 1;
            if (r16 <= r12.length()) goto L12;
        L15:
            return r13;
        L12:
            if (r12.charAt(r15) != ':') goto L15;
            r15 = r16;
        L17:
            if ((r15 + 2) <= r12.length()) goto L19;
            return r13;
        L19:
            int r17 = r15 + 1;
            char r18 = r12.charAt(r15);
            int r19 = r15 + 2;
            char r20 = r12.charAt(r17);
            if (r18 >= '0') goto L22;
        L33:
            return r13;
        L22:
            if (r18 > '9') goto L33;
            if (r20 < '0') goto L33;
            if (r20 > '9') goto L33;
            int r21 = ((r18 - '0') * 10) + (r20 - '0');
            if (r21 < 0) goto L33;
            if (r21 > 59) goto L33;
            r10[r11] = r21;
            r10[0] = r19;
            return false;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(org.threeten.bp.format.b r16, CharSequence r17, int r18) {
            int r10 = r17.length();
            int r11 = this.f23153a.length();
            if (r11 != 0) goto L7;
            if (r18 == r10) goto L6;
        L14:
            char r12 = r17.charAt(r18);
            if (r12 == '+') goto L18;
            if (r12 == '-') goto L18;
        L34:
            if (r11 != 0) goto L38;
            return r16.q(ChronoField.OFFSET_SECONDS, 0, r18, r18 + r11);
        L38:
            return ~r18;
        L18:
            if (r12 != '-') goto L20;
            int r13 = -1;
        L21:
            int[] r14 = new int[4];
            r14[0] = r18 + 1;
            if (b(r14, 1, r17, true) == true) goto L34;
            if (this.f23154b < 3) goto L26;
            boolean r15 = true;
        L28:
            if (b(r14, 2, r17, r15) == true) goto L34;
            if (b(r14, 3, r17, false) == true) goto L34;
            return r16.q(ChronoField.OFFSET_SECONDS, ((long) r13) * (((((long) r14[1]) * 3600) + (((long) r14[2]) * 60)) + ((long) r14[3])), r18, r14[0]);
        L26:
            r15 = false;
            goto L28
        L20:
            r13 = 1;
            goto L21
        L6:
            return r16.q(ChronoField.OFFSET_SECONDS, 0, r18, r18);
        L7:
            if (r18 != r10) goto L11;
            return ~r18;
        L11:
            if (r16.u(r17, r18, this.f23153a, 0, r11) == false) goto L14;
            return r16.q(ChronoField.OFFSET_SECONDS, 0, r18, r18 + r11);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(org.threeten.bp.format.c r10, StringBuilder r11) {
            Long r12 = r10.f(ChronoField.OFFSET_SECONDS);
            if (r12 != null) goto L6;
            return false;
        L6:
            int r13 = ig.d.p(r12.longValue());
            if (r13 != 0) goto L9;
            r11.append(this.f23153a);
        L32:
            return true;
        L9:
            int r14 = Math.abs((r13 / CacheConstants.HOUR) % 100);
            int r15 = Math.abs((r13 / 60) % 60);
            int r16 = Math.abs(r13 % 60);
            int r17 = r11.length();
            if (r13 >= 0) goto L12;
            String r18 = "-";
        L13:
            r11.append(r18);
            r11.append((char) ((r14 / 10) + 48));
            r11.append((char) ((r14 % 10) + 48));
            int r19 = this.f23154b;
            if (r19 >= 3) goto L17;
            if (r19 < 1) goto L30;
            if (r15 > 0) goto L17;
        L30:
            if (r14 != 0) goto L32;
            r11.setLength(r17);
            r11.append(this.f23153a);
        L17:
            String r20 = "";
            if ((r19 % 2) != 0) goto L20;
            String r21 = ":";
        L21:
            r11.append(r21);
            r11.append((char) ((r15 / 10) + 48));
            r11.append((char) ((r15 % 10) + 48));
            r14 = r14 + r15;
            int r22 = this.f23154b;
            if (r22 >= 7) goto L27;
            if (r22 < 5) goto L30;
            if (r16 <= 0) goto L30;
        L27:
            if ((r22 % 2) != 0) goto L29;
            r20 = ":";
        L29:
            r11.append(r20);
            r11.append((char) ((r16 / 10) + 48));
            r11.append((char) ((r16 % 10) + 48));
            r14 = r14 + r16;
            goto L30
        L20:
            r21 = "";
            goto L21
        L12:
            r18 = "+";
            goto L13
        }

        public String toString() {
            return "Offset(" + f23151c[this.f23154b] + ",'" + this.f23153a.replace("'", "''") + "')";
        }
    }

    public static final class m implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DateTimePrinterParser f23155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f23156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final char f23157c;

        public m(DateTimePrinterParser r10, int r11, char r12) {
            this.f23155a = r10;
            this.f23156b = r11;
            this.f23157c = r12;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(org.threeten.bp.format.b r10, CharSequence r11, int r12) {
            boolean r13 = r10.m();
            boolean r14 = r10.l();
            if (r12 > r11.length()) goto L29;
            if (r12 == r11.length()) goto L7;
            int r15 = this.f23156b + r12;
            if (r15 <= r11.length()) goto L14;
            if (r13 == true) goto L12;
            r15 = r11.length();
            goto L14
        L12:
            return ~r12;
        L14:
            int r16 = r12;
        L15:
            if (r16 >= r15) goto L23;
            char r17 = r11.charAt(r16);
            char r18 = this.f23157c;
            if (r14 == false) goto L21;
            if (r17 != r18) goto L23;
        L22:
            r16 = r16 + 1;
            goto L15
        L21:
            if (r10.c(r17, r18) == true) goto L22;
        L23:
            CharSequence r19 = r11.subSequence(0, r15);
            int r20 = this.f23155a.parse(r10, r19, r16);
            if (r20 == r15) goto L35;
            if (r13 == true) goto L27;
            return r20;
        L27:
            return ~(r12 + r16);
        L35:
            return r20;
        L7:
            return ~r12;
        L29:
            throw new IndexOutOfBoundsException();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(org.threeten.bp.format.c r10, StringBuilder r11) {
            int r12 = r11.length();
            int r13 = 0;
            if (this.f23155a.print(r10, r11) == true) goto L5;
            return false;
        L5:
            int r14 = r11.length() - r12;
            if (r14 > this.f23156b) goto L13;
        L8:
            if (r13 >= (this.f23156b - r14)) goto L10;
            r11.insert(r12, this.f23157c);
            r13 = r13 + 1;
            goto L8
        L10:
            return true;
        L13:
            throw new DateTimeException("Cannot print as output of " + r14 + " characters exceeds pad width of " + this.f23156b);
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append("Pad(");
            r10.append(this.f23155a);
            r10.append(",");
            r10.append(this.f23156b);
            if (this.f23157c != ' ') goto L5;
            String r11 = ")";
        L6:
            r10.append(r11);
            return r10.toString();
        L5:
            r11 = ",'" + this.f23157c + "')";
            goto L6
        }
    }

    public static final class n extends k {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final LocalDate f23158i = null;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f23159g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final org.threeten.bp.chrono.a f23160h;

        static {
            f23158i = LocalDate.of(2000, 1, 1);
        }

        public n(TemporalField r10, int r11, int r12, int r13, org.threeten.bp.chrono.a r14) {
            super(r10, r11, r12, SignStyle.NOT_NEGATIVE);
            if (r11 < 1) goto L26;
            if (r11 > 10) goto L26;
            if (r12 < 1) goto L24;
            if (r12 > 10) goto L24;
            if (r12 < r11) goto L22;
            if (r14 != null) goto L19;
            long r15 = r13;
            if (r10.range().isValidValue(r15) == false) goto L18;
            if ((r15 + ((long) k.f23145f[r11])) <= 2147483647L) goto L19;
            throw new DateTimeException("Unable to add printer-parser as the range exceeds the capacity of an int");
        L18:
            throw new IllegalArgumentException("The base value must be within the range of the field");
        L19:
            this.f23159g = r13;
            this.f23160h = r14;
            return;
        L22:
            throw new IllegalArgumentException("The maxWidth must be greater than the width");
        L24:
            throw new IllegalArgumentException("The maxWidth must be from 1 to 10 inclusive but was " + r12);
        L26:
            throw new IllegalArgumentException("The width must be from 1 to 10 inclusive but was " + r11);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.k
        public long a(org.threeten.bp.format.c r10, long r11) {
            long r12 = Math.abs(r11);
            int r13 = this.f23159g;
            if (this.f23160h == null) goto L6;
            r13 = org.threeten.bp.chrono.e.from(r10.e()).date(this.f23160h).get(this.f23146a);
        L6:
            if (r11 < r13) goto L12;
            int r14 = k.f23145f[this.f23147b];
            if (r11 >= (r13 + r14)) goto L12;
            return r12 % ((long) r14);
        L12:
            return r12 % ((long) k.f23145f[this.f23148c]);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.k
        public boolean b(org.threeten.bp.format.b r10) {
            if (r10.m() == true) goto L7;
            return false;
        L7:
            return super.b(r10);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.k
        public int c(org.threeten.bp.format.b r10, long r11, int r12, int r13) {
            int r14 = this.f23159g;
            if (this.f23160h == null) goto L5;
            r14 = r10.h().date(this.f23160h).get(this.f23146a);
            r10.b(this, r11, r12, r13);
        L5:
            int r15 = r13 - r12;
            int r16 = this.f23147b;
            if (r15 != r16) goto L18;
            if (r11 < 0) goto L18;
            long r17 = k.f23145f[r16];
            long r18 = r14;
            long r19 = r18 - (r18 % r17);
            if (r14 <= 0) goto L13;
            long r20 = r19 + r11;
        L12:
            r11 = r20;
            if (r11 >= r18) goto L18;
            r11 = r11 + r17;
            goto L18
        L13:
            r20 = r19 - r11;
        L18:
            return r10.q(this.f23146a, r11, r12, r13);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.k
        public k d() {
            if (this.f23150e != (-1)) goto L6;
            return this;
        L6:
            return new n(this.f23146a, this.f23147b, this.f23148c, this.f23159g, this.f23160h, -1);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.k
        public /* bridge */ /* synthetic */ k e(int r10) {
            return f(r10);
        }

        public n f(int r10) {
            return new n(this.f23146a, this.f23147b, this.f23148c, this.f23159g, this.f23160h, this.f23150e + r10);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.k
        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append("ReducedValue(");
            r10.append(this.f23146a);
            r10.append(",");
            r10.append(this.f23147b);
            r10.append(",");
            r10.append(this.f23148c);
            r10.append(",");
            Object r11 = this.f23160h;
            if (r11 != null) goto L6;
            r11 = Integer.valueOf(this.f23159g);
        L6:
            r10.append(r11);
            r10.append(")");
            return r10.toString();
        }

        public n(TemporalField r10, int r11, int r12, int r13, org.threeten.bp.chrono.a r14, int r15) {
            super(r10, r11, r12, SignStyle.NOT_NEGATIVE, r15, null);
            this.f23159g = r13;
            this.f23160h = r14;
        }
    }

    public static final class o implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f23161a;

        public o(String r10) {
            this.f23161a = r10;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(org.threeten.bp.format.b r10, CharSequence r11, int r12) {
            if (r12 > r11.length()) goto L12;
            if (r12 < 0) goto L12;
            String r13 = this.f23161a;
            if (r10.u(r11, r12, r13, 0, r13.length()) == true) goto L10;
            return ~r12;
        L10:
            return r12 + this.f23161a.length();
        L12:
            throw new IndexOutOfBoundsException();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(org.threeten.bp.format.c r10, StringBuilder r11) {
            r11.append(this.f23161a);
            return true;
        }

        public String toString() {
            return "'" + this.f23161a.replace("'", "''") + "'";
        }
    }

    public static final class p implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TemporalField f23162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final TextStyle f23163b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final org.threeten.bp.format.d f23164c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile k f23165d;

        public p(TemporalField r10, TextStyle r11, org.threeten.bp.format.d r12) {
            this.f23162a = r10;
            this.f23163b = r11;
            this.f23164c = r12;
        }

        public final k a() {
            if (this.f23165d != null) goto L6;
            this.f23165d = new k(this.f23162a, 1, 19, SignStyle.NORMAL);
        L6:
            return this.f23165d;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(org.threeten.bp.format.b r11, CharSequence r12, int r13) {
            int r10 = r12.length();
            if (r13 < 0) goto L24;
            if (r13 > r10) goto L24;
            if (r11.m() == false) goto L8;
            TextStyle r14 = this.f23163b;
        L9:
            Iterator r15 = this.f23164c.d(this.f23162a, r14, r11.i());
            if (r15 == null) goto L22;
        L12:
            if (r15.hasNext() == false) goto L18;
            Map.Entry r16 = (Map.Entry) r15.next();
            String r17 = (String) r16.getKey();
            if (r11.u(r17, 0, r12, r13, r17.length()) == false) goto L12;
            return r11.q(this.f23162a, ((Long) r16.getValue()).longValue(), r13, r13 + r17.length());
        L18:
            if (r11.m() == false) goto L22;
            return ~r13;
        L22:
            return a().parse(r11, r12, r13);
        L8:
            r14 = null;
        L24:
            throw new IndexOutOfBoundsException();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(org.threeten.bp.format.c r10, StringBuilder r11) {
            Long r12 = r10.f(this.f23162a);
            if (r12 != null) goto L6;
            return false;
        L6:
            String r13 = this.f23164c.c(this.f23162a, r12.longValue(), this.f23163b, r10.c());
            if (r13 == null) goto L9;
            r11.append(r13);
            return true;
        L9:
            return a().print(r10, r11);
        }

        public String toString() {
            if (this.f23163b != TextStyle.FULL) goto L7;
            return "Text(" + this.f23162a + ")";
        L7:
            return "Text(" + this.f23162a + "," + this.f23163b + ")";
        }
    }

    public static final class q implements DateTimePrinterParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final char f23166a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f23167b;

        public q(char r10, int r11) {
            this.f23166a = r10;
            this.f23167b = r11;
        }

        public final DateTimePrinterParser a(WeekFields r18) {
            char r10 = this.f23166a;
            if (r10 == 'W') goto L27;
            if (r10 == 'Y') goto L18;
            if (r10 != 'c') goto L9;
            k r11 = new k(r18.dayOfWeek(), this.f23167b, 2, SignStyle.NOT_NEGATIVE);
        L29:
            return r11;
        L9:
            if (r10 != 'e') goto L11;
            r11 = new k(r18.dayOfWeek(), this.f23167b, 2, SignStyle.NOT_NEGATIVE);
            goto L29
        L11:
            if (r10 == 'w') goto L13;
            return null;
        L13:
            r11 = new k(r18.weekOfWeekBasedYear(), this.f23167b, 2, SignStyle.NOT_NEGATIVE);
            goto L29
        L18:
            if (this.f23167b == 2) goto L30;
            TemporalField r12 = r18.weekBasedYear();
            int r13 = this.f23167b;
            if (r13 >= 4) goto L24;
            SignStyle r14 = SignStyle.NORMAL;
        L25:
            int r15 = 19;
            r11 = new k(r12, r13, r15, r14, -1, null);
            goto L29
        L24:
            r14 = SignStyle.EXCEEDS_PAD;
            goto L25
        L30:
            return new n(r18.weekBasedYear(), 2, 2, 0, n.f23158i);
        L27:
            return new k(r18.weekOfMonth(), 1, 2, SignStyle.NOT_NEGATIVE);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(org.threeten.bp.format.b r10, CharSequence r11, int r12) {
            return a(WeekFields.of(r10.i())).parse(r10, r11, r12);
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(org.threeten.bp.format.c r10, StringBuilder r11) {
            return a(WeekFields.of(r10.c())).print(r10, r11);
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder(30);
            r10.append("Localized(");
            char r11 = this.f23166a;
            if (r11 != 'Y') goto L16;
            int r12 = this.f23167b;
            if (r12 != 1) goto L8;
            r10.append("WeekBasedYear");
        L28:
            r10.append(")");
            return r10.toString();
        L8:
            if (r12 != 2) goto L10;
            r10.append("ReducedValue(WeekBasedYear,2,2,2000-01-01)");
            goto L28
        L10:
            r10.append("WeekBasedYear,");
            r10.append(this.f23167b);
            r10.append(",");
            r10.append(19);
            r10.append(",");
            if (this.f23167b >= 4) goto L13;
            SignStyle r13 = SignStyle.NORMAL;
        L14:
            r10.append(r13);
            goto L28
        L13:
            r13 = SignStyle.EXCEEDS_PAD;
            goto L14
        L16:
            if (r11 != 'c') goto L18;
        L26:
            r10.append("DayOfWeek");
        L27:
            r10.append(",");
            r10.append(this.f23167b);
            goto L28
        L18:
            if (r11 == 'e') goto L26;
            if (r11 != 'w') goto L24;
            r10.append("WeekOfWeekBasedYear");
            goto L27
        L24:
            if (r11 != 'W') goto L27;
            r10.append("WeekOfMonth");
            goto L27
        }
    }

    public static final class r implements DateTimePrinterParser {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static volatile Map.Entry f23168c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TemporalQuery f23169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f23170b;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f23171a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Map f23172b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final Map f23173c;

            public /* synthetic */ a(int r10, a r11) {
                this(r10);
            }

            public static /* synthetic */ a a(a r10, CharSequence r11, boolean r12) {
                return r10.d(r11, r12);
            }

            public static /* synthetic */ void b(a r10, String r11) {
                r10.c(r11);
            }

            public final void c(String r10) {
                int r11 = r10.length();
                int r12 = this.f23171a;
                if (r11 != r12) goto L5;
                this.f23172b.put(r10, null);
                this.f23173c.put(r10.toLowerCase(Locale.ENGLISH), null);
                return;
            L5:
                if (r11 <= r12) goto L12;
                String r13 = r10.substring(0, r12);
                a r14 = (a) this.f23172b.get(r13);
                if (r14 != null) goto L9;
                r14 = new a(r11);
                this.f23172b.put(r13, r14);
                this.f23173c.put(r13.toLowerCase(Locale.ENGLISH), r14);
            L9:
                r14.c(r10);
                return;
            }

            public final a d(CharSequence r10, boolean r11) {
                if (r11 == false) goto L6;
                return (a) this.f23172b.get(r10);
            L6:
                return (a) this.f23173c.get(r10.toString().toLowerCase(Locale.ENGLISH));
            }

            public a(int r10) {
                this.f23172b = new HashMap();
                this.f23173c = new HashMap();
                this.f23171a = r10;
            }
        }

        public r(TemporalQuery r10, String r11) {
            this.f23169a = r10;
            this.f23170b = r11;
        }

        public static a c(Set r10) {
            ArrayList r11 = new ArrayList(r10);
            Collections.sort(r11, DateTimeFormatterBuilder.f23124j);
            a r12 = new a(((String) r11.get(0)).length(), null);
            Iterator r13 = r11.iterator();
        L4:
            if (r13.hasNext() == false) goto L6;
            a.b(r12, (String) r13.next());
            goto L4
        L6:
            return r12;
        }

        public final ZoneId a(Set r10, String r11, boolean r12) {
            if (r11 != null) goto L5;
            return null;
        L5:
            if (r12 == true) goto L7;
            Iterator r13 = r10.iterator();
        L12:
            if (r13.hasNext() == false) goto L21;
            String r14 = (String) r13.next();
            if (r14.equalsIgnoreCase(r11) == false) goto L12;
            return ZoneId.of(r14);
        L21:
            return null;
        L7:
            if (r10.contains(r11) == true) goto L9;
            return null;
        L9:
            return ZoneId.of(r11);
        }

        public final int b(org.threeten.bp.format.b r10, CharSequence r11, int r12, int r13) {
            String r14 = r11.subSequence(r12, r13).toString().toUpperCase();
            org.threeten.bp.format.b r15 = r10.e();
            if (r13 < r11.length()) goto L5;
        L8:
            int r16 = l.f23152d.parse(r15, r11, r13);
            if (r16 >= 0) goto L12;
            r10.o(ZoneId.ofOffset(r14, ZoneOffset.UTC));
            return r13;
        L12:
            r10.o(ZoneId.ofOffset(r14, ZoneOffset.ofTotalSeconds((int) r15.j(ChronoField.OFFSET_SECONDS).longValue())));
            return r16;
        L5:
            if (r10.c(r11.charAt(r13), 'Z') == false) goto L8;
            r10.o(ZoneId.ofOffset(r14, ZoneOffset.UTC));
            return r13;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(org.threeten.bp.format.b r10, CharSequence r11, int r12) {
            int r13 = r11.length();
            if (r12 > r13) goto L77;
            if (r12 == r13) goto L6;
            char r14 = r11.charAt(r12);
            if (r14 != '+') goto L10;
        L71:
            org.threeten.bp.format.b r15 = r10.e();
            int r16 = l.f23152d.parse(r15, r11, r12);
            if (r16 >= 0) goto L74;
            return r16;
        L74:
            r10.o(ZoneOffset.ofTotalSeconds((int) r15.j(ChronoField.OFFSET_SECONDS).longValue()));
            return r16;
        L10:
            if (r14 == '-') goto L71;
            int r17 = r12 + 2;
            if (r13 < r17) goto L36;
            char r18 = r11.charAt(r12 + 1);
            if (r10.c(r14, 'U') == false) goto L27;
            if (r10.c(r18, 'T') == false) goto L27;
            int r19 = r12 + 3;
            if (r13 < r19) goto L25;
            if (r10.c(r11.charAt(r17), 'C') == false) goto L25;
            return b(r10, r11, r12, r19);
        L25:
            return b(r10, r11, r12, r17);
        L27:
            if (r10.c(r14, 'G') == false) goto L36;
            int r20 = r12 + 3;
            if (r13 < r20) goto L36;
            if (r10.c(r18, 'M') == false) goto L36;
            if (r10.c(r11.charAt(r17), 'T') == false) goto L36;
            return b(r10, r11, r12, r20);
        L36:
            Set r21 = org.threeten.bp.zone.c.a();
            int r22 = r21.size();
            Map.Entry r23 = f23168c;
            if (r23 != null) goto L39;
        L40:
            monitor-enter(this);
            r23 = f23168c;     // Catch: Throwable -> L46
            if (r23 != null) goto L44;
        L48:
            r23 = new AbstractMap.SimpleImmutableEntry(Integer.valueOf(r22), c(r21));     // Catch: Throwable -> L46
            f23168c = r23;     // Catch: Throwable -> L46
        L49:
            monitor-exit(this);     // Catch: Throwable -> L46
        L50:
            a r24 = (a) r23.getValue();
            String r25 = null;
            String r26 = null;
        L51:
            if (r24 == null) goto L56;
            int r27 = r24.f23171a + r12;
            if (r27 > r13) goto L56;
            String r28 = r11.subSequence(r12, r27).toString();
            r24 = a.a(r24, r28, r10.l());
            r26 = r25;
            r25 = r28;
        L56:
            ZoneId r110 = a(r21, r25, r10.l());
            if (r110 != null) goto L67;
            r110 = a(r21, r26, r10.l());
            if (r110 == null) goto L61;
            r25 = r26;
            goto L67
        L61:
            if (r10.c(r14, 'Z') == false) goto L65;
            r10.o(ZoneOffset.UTC);
            return r12 + 1;
        L65:
            return ~r12;
        L67:
            r10.o(r110);
            return r12 + r25.length();
        L44:
            if (((Integer) r23.getKey()).intValue() == r22) goto L49;
        L46:
            th = move-exception;
            throw th;
        L39:
            if (((Integer) r23.getKey()).intValue() == r22) goto L50;
        L6:
            return ~r12;
        L77:
            throw new IndexOutOfBoundsException();
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(org.threeten.bp.format.c r10, StringBuilder r11) {
            ZoneId r12 = (ZoneId) r10.g(this.f23169a);
            if (r12 != null) goto L6;
            return false;
        L6:
            r11.append(r12.getId());
            return true;
        }

        public String toString() {
            return this.f23170b;
        }
    }

    public static final class s implements DateTimePrinterParser {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Comparator f23174b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TextStyle f23175a;

        public static class a implements Comparator {
            public a() {
            }

            public int a(String r10, String r11) {
                int r12 = r11.length() - r10.length();
                if (r12 == 0) goto L5;
                return r12;
            L5:
                return r10.compareTo(r11);
            }

            @Override // java.util.Comparator
            public /* bridge */ /* synthetic */ int compare(Object r10, Object r11) {
                return a((String) r10, (String) r11);
            }
        }

        static {
            f23174b = new a();
        }

        public s(TextStyle r10) {
            this.f23175a = (TextStyle) ig.d.h(r10, "textStyle");
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public int parse(org.threeten.bp.format.b r10, CharSequence r11, int r12) {
            TreeMap r13 = new TreeMap(f23174b);
            Iterator<String> r14 = ZoneId.getAvailableZoneIds().iterator();
        L4:
            if (r14.hasNext() == false) goto L10;
            String r15 = r14.next();
            r13.put(r15, r15);
            TimeZone r16 = TimeZone.getTimeZone(r15);
            if (this.f23175a.asNormal() != TextStyle.FULL) goto L8;
            int r17 = 1;
        L9:
            r13.put(r16.getDisplayName(false, r17, r10.i()), r15);
            r13.put(r16.getDisplayName(true, r17, r10.i()), r15);
            goto L4
        L8:
            r17 = 0;
            goto L9
        L10:
            Iterator r18 = r13.entrySet().iterator();
        L12:
            if (r18.hasNext() == false) goto L18;
            Map.Entry r19 = (Map.Entry) r18.next();
            String r20 = (String) r19.getKey();
            if (r10.u(r11, r12, r20, 0, r20.length()) == false) goto L12;
            r10.o(ZoneId.of((String) r19.getValue()));
            return r12 + r20.length();
        L18:
            return ~r12;
        }

        @Override // org.threeten.bp.format.DateTimeFormatterBuilder.DateTimePrinterParser
        public boolean print(org.threeten.bp.format.c r10, StringBuilder r11) {
            ZoneId r12 = (ZoneId) r10.g(org.threeten.bp.temporal.b.g());
            int r13 = 0;
            if (r12 != null) goto L6;
            return false;
        L6:
            if ((r12.normalized() instanceof ZoneOffset) == false) goto L9;
            r11.append(r12.getId());
            return true;
        L9:
            TemporalAccessor r14 = r10.e();
            ChronoField r15 = ChronoField.INSTANT_SECONDS;
            if (r14.isSupported(r15) == false) goto L12;
            boolean r16 = r12.getRules().isDaylightSavings(Instant.ofEpochSecond(r14.getLong(r15)));
        L13:
            TimeZone r17 = TimeZone.getTimeZone(r12.getId());
            if (this.f23175a.asNormal() != TextStyle.FULL) goto L16;
            r13 = 1;
        L16:
            r11.append(r17.getDisplayName(r16, r13, r10.c()));
            return true;
        L12:
            r16 = false;
            goto L13
        }

        public String toString() {
            return "ZoneText(" + this.f23175a + ")";
        }
    }

    static {
        f23122h = new a();
        HashMap r10 = new HashMap();
        f23123i = r10;
        r10.put('G', ChronoField.ERA);
        r10.put('y', ChronoField.YEAR_OF_ERA);
        r10.put('u', ChronoField.YEAR);
        TemporalField r11 = IsoFields.f23218b;
        r10.put('Q', r11);
        r10.put('q', r11);
        ChronoField r12 = ChronoField.MONTH_OF_YEAR;
        r10.put('M', r12);
        r10.put('L', r12);
        r10.put('D', ChronoField.DAY_OF_YEAR);
        r10.put('d', ChronoField.DAY_OF_MONTH);
        r10.put('F', ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
        ChronoField r13 = ChronoField.DAY_OF_WEEK;
        r10.put('E', r13);
        r10.put('c', r13);
        r10.put('e', r13);
        r10.put('a', ChronoField.AMPM_OF_DAY);
        r10.put('H', ChronoField.HOUR_OF_DAY);
        r10.put('k', ChronoField.CLOCK_HOUR_OF_DAY);
        r10.put('K', ChronoField.HOUR_OF_AMPM);
        r10.put('h', ChronoField.CLOCK_HOUR_OF_AMPM);
        r10.put('m', ChronoField.MINUTE_OF_HOUR);
        r10.put('s', ChronoField.SECOND_OF_MINUTE);
        ChronoField r14 = ChronoField.NANO_OF_SECOND;
        r10.put('S', r14);
        r10.put('A', ChronoField.MILLI_OF_DAY);
        r10.put('n', r14);
        r10.put('N', ChronoField.NANO_OF_DAY);
        f23124j = new c();
    }

    public DateTimeFormatterBuilder() {
        this.f23125a = this;
        this.f23127c = new ArrayList();
        this.f23131g = -1;
        this.f23126b = null;
        this.f23128d = false;
    }

    public DateTimeFormatterBuilder A() {
        e(SettingsParser.SENSITIVE);
        return this;
    }

    public final void B(char r10, int r11, TemporalField r12) {
        if (r10 != 'Q') goto L5;
    L101:
        if (r11 == 1) goto L112;
        if (r11 == 2) goto L111;
        if (r11 == 3) goto L110;
        if (r11 == 4) goto L109;
        if (r11 != 5) goto L108;
        m(r12, TextStyle.NARROW);
        return;
    L108:
        throw new IllegalArgumentException("Too many pattern letters: " + r10);
    L109:
        m(r12, TextStyle.FULL);
        return;
    L110:
        m(r12, TextStyle.SHORT);
        return;
    L111:
        p(r12, 2);
        return;
    L112:
        o(r12);
        return;
    L5:
        if (r10 != 'S') goto L7;
        c(ChronoField.NANO_OF_SECOND, r11, r11, false);
        return;
    L7:
        if (r10 != 'a') goto L9;
        if (r11 != 1) goto L99;
        m(r12, TextStyle.SHORT);
        return;
    L99:
        throw new IllegalArgumentException("Too many pattern letters: " + r10);
    L9:
        if (r10 != 'h') goto L11;
    L90:
        if (r11 != 1) goto L92;
        o(r12);
        return;
    L92:
        if (r11 != 2) goto L95;
        p(r12, r11);
        return;
    L95:
        throw new IllegalArgumentException("Too many pattern letters: " + r10);
    L11:
        if (r10 == 'k') goto L90;
        if (r10 == 'm') goto L90;
        if (r10 != 'q') goto L17;
    L78:
        if (r11 == 1) goto L89;
        if (r11 == 2) goto L88;
        if (r11 == 3) goto L87;
        if (r11 == 4) goto L86;
        if (r11 != 5) goto L85;
        m(r12, TextStyle.NARROW_STANDALONE);
        return;
    L85:
        throw new IllegalArgumentException("Too many pattern letters: " + r10);
    L86:
        m(r12, TextStyle.FULL_STANDALONE);
        return;
    L87:
        m(r12, TextStyle.SHORT_STANDALONE);
        return;
    L88:
        p(r12, 2);
        return;
    L89:
        o(r12);
        return;
    L17:
        if (r10 == 's') goto L90;
        if (r10 != 'u') goto L21;
    L72:
        if (r11 != 2) goto L75;
        r(r12, 2, 2, n.f23158i);
        return;
    L75:
        if (r11 >= 4) goto L77;
        q(r12, r11, 19, SignStyle.NORMAL);
        return;
    L77:
        q(r12, r11, 19, SignStyle.EXCEEDS_PAD);
        return;
    L21:
        if (r10 == 'y') goto L72;
        switch(r10) {
            case 68: goto L66;
            case 69: goto L56;
            case 70: goto L52;
            case 71: goto L56;
            case 72: goto L90;
            default: goto L23;
        };
    L23:
        switch(r10) {
            case 75: goto L90;
            case 76: goto L78;
            case 77: goto L101;
            default: goto L24;
        };
    L24:
        switch(r10) {
            case 99: goto L39;
            case 100: goto L90;
            case 101: goto L28;
            default: goto L25;
        };
    L25:
        if (r11 != 1) goto L27;
        o(r12);
        return;
    L27:
        p(r12, r11);
        return;
    L28:
        if (r11 == 1) goto L38;
        if (r11 == 2) goto L38;
        if (r11 == 3) goto L37;
        if (r11 == 4) goto L36;
        if (r11 != 5) goto L35;
        m(r12, TextStyle.NARROW);
        return;
    L35:
        throw new IllegalArgumentException("Too many pattern letters: " + r10);
    L36:
        m(r12, TextStyle.FULL);
        return;
    L37:
        m(r12, TextStyle.SHORT);
        return;
    L38:
        e(new q('e', r11));
        return;
    L39:
        if (r11 == 1) goto L51;
        if (r11 == 2) goto L50;
        if (r11 == 3) goto L48;
        if (r11 == 4) goto L47;
        if (r11 != 5) goto L46;
        m(r12, TextStyle.NARROW_STANDALONE);
        return;
    L46:
        throw new IllegalArgumentException("Too many pattern letters: " + r10);
    L47:
        m(r12, TextStyle.FULL_STANDALONE);
        return;
    L48:
        m(r12, TextStyle.SHORT_STANDALONE);
        return;
    L50:
        throw new IllegalArgumentException("Invalid number of pattern letters: " + r10);
    L51:
        e(new q('c', r11));
        return;
    L52:
        if (r11 != 1) goto L55;
        o(r12);
        return;
    L55:
        throw new IllegalArgumentException("Too many pattern letters: " + r10);
    L56:
        if (r11 == 1) goto L65;
        if (r11 == 2) goto L65;
        if (r11 == 3) goto L65;
        if (r11 == 4) goto L64;
        if (r11 != 5) goto L63;
        m(r12, TextStyle.NARROW);
        return;
    L63:
        throw new IllegalArgumentException("Too many pattern letters: " + r10);
    L64:
        m(r12, TextStyle.FULL);
        return;
    L65:
        m(r12, TextStyle.SHORT);
        return;
    L66:
        if (r11 != 1) goto L68;
        o(r12);
        return;
    L68:
        if (r11 > 3) goto L71;
        p(r12, r11);
        return;
    L71:
        throw new IllegalArgumentException("Too many pattern letters: " + r10);
    }

    public DateTimeFormatterBuilder C() {
        e(SettingsParser.LENIENT);
        return this;
    }

    public final void D(String r13) {
        int r10 = 0;
    L4:
        if (r10 >= r13.length()) goto L158;
        char r11 = r13.charAt(r10);
        if (r11 < 'A') goto L8;
        if (r11 > 'Z') goto L8;
    L10:
        int r12 = r10 + 1;
    L12:
        if (r12 >= r13.length()) goto L16;
        if (r13.charAt(r12) != r11) goto L16;
        r12 = r12 + 1;
    L16:
        int r14 = r12 - r10;
        if (r11 == 'p') goto L19;
    L37:
        TemporalField r15 = (TemporalField) f23123i.get(Character.valueOf(r11));
        if (r15 == null) goto L41;
        B(r11, r14, r15);
    L113:
        r10 = r12 - 1;
    L155:
        r10 = r10 + 1;
        goto L4
    L41:
        if (r11 != 'z') goto L49;
        if (r14 > 4) goto L47;
        if (r14 != 4) goto L45;
        u(TextStyle.FULL);
        goto L113
    L45:
        u(TextStyle.SHORT);
        goto L113
    L47:
        throw new IllegalArgumentException("Too many pattern letters: " + r11);
    L49:
        if (r11 != 'V') goto L54;
        if (r14 != 2) goto L53;
        s();
        goto L113
    L53:
        throw new IllegalArgumentException("Pattern letter count must be 2: " + r11);
    L54:
        String r16 = "+0000";
        if (r11 != 'Z') goto L65;
        if (r14 >= 4) goto L58;
        i("+HHMM", "+0000");
        goto L113
    L58:
        if (r14 != 4) goto L60;
        h(TextStyle.FULL);
        goto L113
    L60:
        if (r14 != 5) goto L63;
        i("+HH:MM:ss", "Z");
        goto L113
    L63:
        throw new IllegalArgumentException("Too many pattern letters: " + r11);
    L65:
        if (r11 != 'O') goto L73;
        if (r14 != 1) goto L68;
        h(TextStyle.SHORT);
        goto L113
    L68:
        if (r14 != 4) goto L71;
        h(TextStyle.FULL);
        goto L113
    L71:
        throw new IllegalArgumentException("Pattern letter count must be 1 or 4: " + r11);
    L73:
        if (r11 != 'X') goto L83;
        if (r14 > 5) goto L81;
        String[] r17 = l.f23151c;
        if (r14 != 1) goto L78;
        int r18 = 0;
    L79:
        i(r17[r14 + r18], "Z");
        goto L113
    L78:
        r18 = 1;
        goto L79
    L81:
        throw new IllegalArgumentException("Too many pattern letters: " + r11);
    L83:
        if (r11 != 'x') goto L99;
        if (r14 > 5) goto L97;
        if (r14 != 1) goto L88;
        r16 = "+00";
    L91:
        String[] r19 = l.f23151c;
        if (r14 != 1) goto L94;
        int r20 = 0;
    L95:
        i(r19[r14 + r20], r16);
        goto L113
    L94:
        r20 = 1;
        goto L95
    L88:
        if ((r14 % 2) == 0) goto L91;
        r16 = "+00:00";
        goto L91
    L97:
        throw new IllegalArgumentException("Too many pattern letters: " + r11);
    L99:
        if (r11 != 'W') goto L105;
        if (r14 > 1) goto L103;
        e(new q('W', r14));
        goto L113
    L103:
        throw new IllegalArgumentException("Too many pattern letters: " + r11);
    L105:
        if (r11 != 'w') goto L111;
        if (r14 > 2) goto L109;
        e(new q('w', r14));
        goto L113
    L109:
        throw new IllegalArgumentException("Too many pattern letters: " + r11);
    L111:
        if (r11 != 'Y') goto L115;
        e(new q('Y', r14));
        goto L113
    L115:
        throw new IllegalArgumentException("Unknown pattern letter: " + r11);
    L19:
        if (r12 >= r13.length()) goto L32;
        r11 = r13.charAt(r12);
        if (r11 < 'A') goto L23;
        if (r11 > 'Z') goto L23;
    L25:
        int r21 = r12 + 1;
    L27:
        if (r21 >= r13.length()) goto L31;
        if (r13.charAt(r21) != r11) goto L31;
        r21 = r21 + 1;
    L31:
        int r22 = r21 - r12;
        r12 = r21;
    L33:
        if (r14 == 0) goto L36;
        x(r14);
        r14 = r22;
        goto L37
    L36:
        throw new IllegalArgumentException("Pad letter 'p' must be followed by valid pad pattern: " + r13);
    L23:
        if (r11 < 'a') goto L32;
        if (r11 <= 'z') goto L25;
    L32:
        r22 = r14;
        r14 = 0;
    L8:
        if (r11 < 'a') goto L117;
        if (r11 <= 'z') goto L10;
    L117:
        if (r11 != '\'') goto L139;
        int r23 = r10 + 1;
        int r24 = r23;
    L120:
        if (r24 >= r13.length()) goto L130;
        if (r13.charAt(r24) != '\'') goto L128;
        int r25 = r24 + 1;
        if (r25 >= r13.length()) goto L130;
        if (r13.charAt(r25) != '\'') goto L130;
        r24 = r25;
    L128:
        r24 = r24 + 1;
    L130:
        if (r24 >= r13.length()) goto L137;
        String r26 = r13.substring(r23, r24);
        if (r26.length() != 0) goto L134;
        f('\'');
    L135:
        r10 = r24;
        goto L155
    L134:
        g(r26.replace("''", "'"));
        goto L135
    L137:
        throw new IllegalArgumentException("Pattern ends with an incomplete string literal: " + r13);
    L139:
        if (r11 != '[') goto L142;
        w();
        goto L155
    L142:
        if (r11 != ']') goto L149;
        if (this.f23125a.f23126b == null) goto L147;
        v();
        goto L155
    L147:
        throw new IllegalArgumentException("Pattern invalid as it contains ] without previous [");
    L149:
        if (r11 == '{') goto L157;
        if (r11 == '}') goto L157;
        if (r11 == '#') goto L157;
        f(r11);
    L157:
        throw new IllegalArgumentException("Pattern includes reserved character: '" + r11 + "'");
    }

    public DateTimeFormatter E() {
        return F(Locale.getDefault());
    }

    public DateTimeFormatter F(Locale r10) {
        ig.d.h(r10, "locale");
    L4:
        if (this.f23125a.f23126b == null) goto L7;
        v();
        goto L4
    L7:
        return new DateTimeFormatter(new g(this.f23127c, false), r10, org.threeten.bp.format.e.f23207e, ResolverStyle.SMART, null, null, null);
    }

    public DateTimeFormatter G(ResolverStyle r10) {
        return E().s(r10);
    }

    public DateTimeFormatterBuilder a(DateTimeFormatter r10) {
        ig.d.h(r10, "formatter");
        e(r10.q(false));
        return this;
    }

    public DateTimeFormatterBuilder b(TextStyle r10) {
        ig.d.h(r10, "textStyle");
        e(new f(r10));
        return this;
    }

    public DateTimeFormatterBuilder c(TemporalField r10, int r11, int r12, boolean r13) {
        e(new h(r10, r11, r12, r13));
        return this;
    }

    public DateTimeFormatterBuilder d() {
        e(new i(-2));
        return this;
    }

    public final int e(DateTimePrinterParser r10) {
        ig.d.h(r10, "pp");
        DateTimeFormatterBuilder r11 = this.f23125a;
        int r12 = r11.f23129e;
        if (r12 <= 0) goto L7;
        if (r10 == null) goto L6;
        r10 = new m(r10, r12, r11.f23130f);
    L6:
        DateTimeFormatterBuilder r13 = this.f23125a;
        r13.f23129e = 0;
        r13.f23130f = 0;
    L7:
        this.f23125a.f23127c.add(r10);
        DateTimeFormatterBuilder r14 = this.f23125a;
        r14.f23131g = -1;
        return r14.f23127c.size() - 1;
    }

    public DateTimeFormatterBuilder f(char r10) {
        e(new e(r10));
        return this;
    }

    public DateTimeFormatterBuilder g(String r10) {
        ig.d.h(r10, "literal");
        if (r10.length() > 0) goto L5;
    L8:
        return this;
    L5:
        if (r10.length() != 1) goto L7;
        e(new e(r10.charAt(0)));
        goto L8
    L7:
        e(new o(r10));
        goto L8
    }

    public DateTimeFormatterBuilder h(TextStyle r10) {
        ig.d.h(r10, "style");
        if (r10 != TextStyle.FULL) goto L5;
    L9:
        e(new j(r10));
        return this;
    L5:
        if (r10 == TextStyle.SHORT) goto L9;
        throw new IllegalArgumentException("Style must be either full or short");
    }

    public DateTimeFormatterBuilder i(String r10, String r11) {
        e(new l(r11, r10));
        return this;
    }

    public DateTimeFormatterBuilder j() {
        e(l.f23152d);
        return this;
    }

    public DateTimeFormatterBuilder k(String r10) {
        ig.d.h(r10, "pattern");
        D(r10);
        return this;
    }

    public DateTimeFormatterBuilder l(TemporalField r10, Map r11) {
        ig.d.h(r10, "field");
        ig.d.h(r11, "textLookup");
        LinkedHashMap r12 = new LinkedHashMap(r11);
        TextStyle r13 = TextStyle.FULL;
        e(new p(r10, r13, new b(this, new org.threeten.bp.format.f.b(Collections.singletonMap(r13, r12)))));
        return this;
    }

    public DateTimeFormatterBuilder m(TemporalField r10, TextStyle r11) {
        ig.d.h(r10, "field");
        ig.d.h(r11, "textStyle");
        e(new p(r10, r11, org.threeten.bp.format.d.b()));
        return this;
    }

    public final DateTimeFormatterBuilder n(k r10) {
        DateTimeFormatterBuilder r11 = this.f23125a;
        int r12 = r11.f23131g;
        if (r12 >= 0) goto L5;
    L13:
        DateTimeFormatterBuilder r13 = this.f23125a;
        r13.f23131g = e(r10);
    L14:
        return this;
    L5:
        if ((r11.f23127c.get(r12) instanceof k) == false) goto L13;
        DateTimeFormatterBuilder r14 = this.f23125a;
        int r15 = r14.f23131g;
        k r16 = (k) r14.f23127c.get(r15);
        int r17 = r10.f23147b;
        int r18 = r10.f23148c;
        if (r17 == r18) goto L9;
    L11:
        k r19 = r16.d();
        DateTimeFormatterBuilder r20 = this.f23125a;
        r20.f23131g = e(r10);
    L12:
        this.f23125a.f23127c.set(r15, r19);
        goto L14
    L9:
        if (r10.f23149d != SignStyle.NOT_NEGATIVE) goto L11;
        r19 = r16.e(r18);
        e(r10.d());
        this.f23125a.f23131g = r15;
        goto L12
    }

    public DateTimeFormatterBuilder o(TemporalField r10) {
        ig.d.h(r10, "field");
        n(new k(r10, 1, 19, SignStyle.NORMAL));
        return this;
    }

    public DateTimeFormatterBuilder p(TemporalField r10, int r11) {
        ig.d.h(r10, "field");
        if (r11 < 1) goto L9;
        if (r11 > 19) goto L9;
        n(new k(r10, r11, r11, SignStyle.NOT_NEGATIVE));
        return this;
    L9:
        throw new IllegalArgumentException("The width must be from 1 to 19 inclusive but was " + r11);
    }

    public DateTimeFormatterBuilder q(TemporalField r10, int r11, int r12, SignStyle r13) {
        if (r11 == r12) goto L4;
    L7:
        ig.d.h(r10, "field");
        ig.d.h(r13, "signStyle");
        if (r11 < 1) goto L21;
        if (r11 > 19) goto L21;
        if (r12 < 1) goto L19;
        if (r12 > 19) goto L19;
        if (r12 < r11) goto L17;
        n(new k(r10, r11, r12, r13));
        return this;
    L17:
        throw new IllegalArgumentException("The maximum width must exceed or equal the minimum width but " + r12 + " < " + r11);
    L19:
        throw new IllegalArgumentException("The maximum width must be from 1 to 19 inclusive but was " + r12);
    L21:
        throw new IllegalArgumentException("The minimum width must be from 1 to 19 inclusive but was " + r11);
    L4:
        if (r13 != SignStyle.NOT_NEGATIVE) goto L7;
        return p(r10, r12);
    }

    public DateTimeFormatterBuilder r(TemporalField r10, int r11, int r12, org.threeten.bp.chrono.a r13) {
        ig.d.h(r10, "field");
        ig.d.h(r13, "baseDate");
        n(new n(r10, r11, r12, 0, r13));
        return this;
    }

    public DateTimeFormatterBuilder s() {
        e(new r(org.threeten.bp.temporal.b.g(), "ZoneId()"));
        return this;
    }

    public DateTimeFormatterBuilder t() {
        e(new r(f23122h, "ZoneRegionId()"));
        return this;
    }

    public DateTimeFormatterBuilder u(TextStyle r10) {
        e(new s(r10));
        return this;
    }

    public DateTimeFormatterBuilder v() {
        DateTimeFormatterBuilder r10 = this.f23125a;
        if (r10.f23126b == null) goto L10;
        if (r10.f23127c.size() <= 0) goto L7;
        DateTimeFormatterBuilder r11 = this.f23125a;
        g r12 = new g(r11.f23127c, r11.f23128d);
        this.f23125a = this.f23125a.f23126b;
        e(r12);
    L8:
        return this;
    L7:
        this.f23125a = this.f23125a.f23126b;
        goto L8
    L10:
        throw new IllegalStateException("Cannot call optionalEnd() as there was no previous call to optionalStart()");
    }

    public DateTimeFormatterBuilder w() {
        DateTimeFormatterBuilder r10 = this.f23125a;
        r10.f23131g = -1;
        this.f23125a = new DateTimeFormatterBuilder(r10, true);
        return this;
    }

    public DateTimeFormatterBuilder x(int r10) {
        return y(r10, TokenParser.SP);
    }

    public DateTimeFormatterBuilder y(int r10, char r11) {
        if (r10 < 1) goto L7;
        DateTimeFormatterBuilder r12 = this.f23125a;
        r12.f23129e = r10;
        r12.f23130f = r11;
        r12.f23131g = -1;
        return this;
    L7:
        throw new IllegalArgumentException("The pad width must be at least one but was " + r10);
    }

    public DateTimeFormatterBuilder z() {
        e(SettingsParser.INSENSITIVE);
        return this;
    }

    public DateTimeFormatterBuilder(DateTimeFormatterBuilder r10, boolean r11) {
        this.f23125a = this;
        this.f23127c = new ArrayList();
        this.f23131g = -1;
        this.f23126b = r10;
        this.f23128d = r11;
    }
}
