package bytedance.jvm.time.format;

import bytedance.jvm.time.DateTimeException;
import bytedance.jvm.time.ZoneId;
import bytedance.jvm.time.chrono.IsoChronology;
import bytedance.jvm.time.temporal.ChronoField;
import bytedance.jvm.time.temporal.IsoFields;
import bytedance.jvm.time.temporal.l;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.OthersPermission;
import java.io.IOException;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: loaded from: classes28.dex */
public final class DateTimeFormatter {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final DateTimeFormatter f21578h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final DateTimeFormatter f21579i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final DateTimeFormatter f21580j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final DateTimeFormatter f21581k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final DateTimeFormatter f21582l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final DateTimeFormatter f21583m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final DateTimeFormatter f21584n = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DateTimeFormatterBuilder.d f21585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Locale f21586b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f21587c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ResolverStyle f21588d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<bytedance.jvm.time.temporal.j> f21589e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bytedance.jvm.time.chrono.j f21590f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ZoneId f21591g;

    public static class ClassicFormat extends Format {
        private final DateTimeFormatter formatter;
        private final l<?> parseType;

        @Override // java.text.Format
        public Object parseObject(String r100) throws ParseException {
            Objects.requireNonNull(r100, "text");
            l<?> r101 = this.parseType;     // Catch: RuntimeException -> L9 DateTimeParseException -> L12
            if (r101 != null) goto L8;
            DateTimeFormatter r102 = this.formatter;     // Catch: RuntimeException -> L9 DateTimeParseException -> L12
            DateTimeFormatter r103 = DateTimeFormatter.f21578h;     // Catch: RuntimeException -> L9 DateTimeParseException -> L12
            return r102.d(r100);
        L8:
            return this.formatter.c(r100, r101);
        L12:
            e = move-exception;
            throw new ParseException(e.getMessage(), e.getErrorIndex());
        L9:
            e = move-exception;
            throw ((ParseException) new ParseException(e.getMessage(), 0).initCause(e));
        }

        public ClassicFormat(DateTimeFormatter r100, l<?> r101) {
            this.formatter = r100;
            this.parseType = r101;
        }

        @Override // java.text.Format
        public Object parseObject(String r100, ParsePosition r101) {
            Objects.requireNonNull(r100, "text");
            DateTimeFormatter r102 = this.formatter;     // Catch: IndexOutOfBoundsException -> L16
            DateTimeFormatter r103 = DateTimeFormatter.f21578h;     // Catch: IndexOutOfBoundsException -> L16
            c r104 = r102.e(r100, r101);     // Catch: IndexOutOfBoundsException -> L16
            if (r104 == null) goto L6;
            DateTimeFormatter r105 = this.formatter;     // Catch: RuntimeException -> L14
            i r106 = r104.h(r105.f21588d, r105.f21589e);     // Catch: RuntimeException -> L14
            l<?> r107 = this.parseType;     // Catch: RuntimeException -> L14
            if (r107 != null) goto L12;
            return r106;
        L12:
            return r106.query(r107);
        L14:
            r101.setErrorIndex(0);
            return null;
        L6:
            if (r101.getErrorIndex() >= 0) goto L8;
            r101.setErrorIndex(0);
        L8:
            return null;
        L17:
            if (r101.getErrorIndex() >= 0) goto L19;
            r101.setErrorIndex(0);
        L19:
            return null;
        }

        @Override // java.text.Format
        public StringBuffer format(Object r100, StringBuffer r101, FieldPosition r102) {
            Objects.requireNonNull(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            Objects.requireNonNull(r101, "toAppendTo");
            Objects.requireNonNull(r102, ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION);
            if ((r100 instanceof bytedance.jvm.time.temporal.d) == false) goto L11;
            r102.setBeginIndex(0);
            r102.setEndIndex(0);
            this.formatter.b((bytedance.jvm.time.temporal.d) r100, r101);     // Catch: RuntimeException -> L7
            return r101;
        L7:
            e = move-exception;
            throw new IllegalArgumentException(e.getMessage(), e);
        L11:
            throw new IllegalArgumentException("Format target must implement TemporalAccessor");
        }
    }

    static {
        DateTimeFormatterBuilder r100 = new DateTimeFormatterBuilder();
        ChronoField r101 = ChronoField.YEAR;
        SignStyle r102 = SignStyle.EXCEEDS_PAD;
        r100.g(r101, 4, 10, r102);
        r100.c('-');
        ChronoField r103 = ChronoField.MONTH_OF_YEAR;
        r100.i(r103, 2);
        r100.c('-');
        ChronoField r104 = ChronoField.DAY_OF_MONTH;
        r100.i(r104, 2);
        ResolverStyle r105 = ResolverStyle.STRICT;
        IsoChronology r110 = IsoChronology.INSTANCE;
        DateTimeFormatter r106 = r100.n(r105, r110);
        f21578h = r106;
        DateTimeFormatterBuilder r111 = new DateTimeFormatterBuilder();
        DateTimeFormatterBuilder.SettingsParser r112 = DateTimeFormatterBuilder.SettingsParser.INSENSITIVE;
        r111.b(r112);
        r111.a(r106);
        DateTimeFormatterBuilder.i r113 = DateTimeFormatterBuilder.i.f21613e;
        r111.b(r113);
        r111.n(r105, r110);
        DateTimeFormatterBuilder r114 = new DateTimeFormatterBuilder();
        r114.b(r112);
        r114.a(r106);
        r114.k();
        r114.b(r113);
        r114.n(r105, r110);
        DateTimeFormatterBuilder r115 = new DateTimeFormatterBuilder();
        ChronoField r116 = ChronoField.HOUR_OF_DAY;
        r115.i(r116, 2);
        r115.c(':');
        ChronoField r107 = ChronoField.MINUTE_OF_HOUR;
        r115.i(r107, 2);
        r115.k();
        r115.c(':');
        ChronoField r117 = ChronoField.SECOND_OF_MINUTE;
        r115.i(r117, 2);
        r115.k();
        r115.b(new DateTimeFormatterBuilder.f(ChronoField.NANO_OF_SECOND));
        DateTimeFormatter r108 = r115.n(r105, null);
        f21579i = r108;
        DateTimeFormatterBuilder r118 = new DateTimeFormatterBuilder();
        r118.b(r112);
        r118.a(r108);
        r118.b(r113);
        f21580j = r118.n(r105, null);
        DateTimeFormatterBuilder r119 = new DateTimeFormatterBuilder();
        r119.b(r112);
        r119.a(r108);
        r119.k();
        r119.b(r113);
        r119.n(r105, null);
        DateTimeFormatterBuilder r120 = new DateTimeFormatterBuilder();
        r120.b(r112);
        r120.a(r106);
        r120.c(OthersPermission.STICKY);
        r120.a(r108);
        DateTimeFormatter r109 = r120.n(r105, r110);
        f21581k = r109;
        DateTimeFormatterBuilder r121 = new DateTimeFormatterBuilder();
        r121.b(r112);
        r121.a(r109);
        DateTimeFormatterBuilder.SettingsParser r122 = DateTimeFormatterBuilder.SettingsParser.LENIENT;
        r121.b(r122);
        r121.b(r113);
        DateTimeFormatterBuilder.SettingsParser r123 = DateTimeFormatterBuilder.SettingsParser.STRICT;
        r121.b(r123);
        DateTimeFormatter r124 = r121.n(r105, r110);
        f21582l = r124;
        DateTimeFormatterBuilder r125 = new DateTimeFormatterBuilder();
        r125.a(r124);
        r125.k();
        r125.c('[');
        DateTimeFormatterBuilder.SettingsParser r126 = DateTimeFormatterBuilder.SettingsParser.SENSITIVE;
        r125.b(r126);
        a r127 = DateTimeFormatterBuilder.f21592f;
        r125.b(new DateTimeFormatterBuilder.m(r127, "ZoneRegionId()"));
        r125.c(']');
        f21583m = r125.n(r105, r110);
        DateTimeFormatterBuilder r128 = new DateTimeFormatterBuilder();
        r128.a(r109);
        r128.k();
        r128.b(r113);
        r128.k();
        r128.c('[');
        r128.b(r126);
        r128.b(new DateTimeFormatterBuilder.m(r127, "ZoneRegionId()"));
        r128.c(']');
        r128.n(r105, r110);
        DateTimeFormatterBuilder r129 = new DateTimeFormatterBuilder();
        r129.b(r112);
        r129.g(r101, 4, 10, r102);
        r129.c('-');
        r129.i(ChronoField.DAY_OF_YEAR, 3);
        r129.k();
        r129.b(r113);
        r129.n(r105, r110);
        DateTimeFormatterBuilder r130 = new DateTimeFormatterBuilder();
        r130.b(r112);
        r130.g(IsoFields.f21683c, 4, 10, r102);
        r130.d("-W");
        r130.i(IsoFields.f21682b, 2);
        r130.c('-');
        ChronoField r131 = ChronoField.DAY_OF_WEEK;
        r130.i(r131, 1);
        r130.k();
        r130.b(r113);
        r130.n(r105, r110);
        DateTimeFormatterBuilder r132 = new DateTimeFormatterBuilder();
        r132.b(r112);
        r132.b(new DateTimeFormatterBuilder.g());
        f21584n = r132.n(r105, null);
        DateTimeFormatterBuilder r133 = new DateTimeFormatterBuilder();
        r133.b(r112);
        r133.i(r101, 4);
        r133.i(r103, 2);
        r133.i(r104, 2);
        r133.k();
        r133.b(r122);
        r133.b(new DateTimeFormatterBuilder.i("+HHMMss", "Z"));
        r133.b(r123);
        r133.n(r105, r110);
        HashMap r134 = new HashMap();
        r134.put(1L, "Mon");
        r134.put(2L, "Tue");
        r134.put(3L, "Wed");
        r134.put(4L, "Thu");
        r134.put(5L, "Fri");
        r134.put(6L, "Sat");
        r134.put(7L, "Sun");
        HashMap r135 = new HashMap();
        r135.put(1L, "Jan");
        r135.put(2L, "Feb");
        r135.put(3L, "Mar");
        r135.put(4L, "Apr");
        r135.put(5L, "May");
        r135.put(6L, "Jun");
        r135.put(7L, "Jul");
        r135.put(8L, "Aug");
        r135.put(9L, "Sep");
        r135.put(10L, "Oct");
        r135.put(11L, "Nov");
        r135.put(12L, "Dec");
        DateTimeFormatterBuilder r136 = new DateTimeFormatterBuilder();
        r136.b(r112);
        r136.b(r122);
        r136.k();
        r136.f(r131, r134);
        r136.d(", ");
        r136.j();
        r136.g(r104, 1, 2, SignStyle.NOT_NEGATIVE);
        r136.c(' ');
        r136.f(r103, r135);
        r136.c(' ');
        r136.i(r101, 4);
        r136.c(' ');
        r136.i(r116, 2);
        r136.c(':');
        r136.i(r107, 2);
        r136.k();
        r136.c(':');
        r136.i(r117, 2);
        r136.j();
        r136.c(' ');
        r136.b(new DateTimeFormatterBuilder.i("+HHMM", "GMT"));
        r136.n(ResolverStyle.SMART, r110);
    }

    public final String toString() {
        String r100 = this.f21585a.toString();
        if (r100.startsWith("[") == false) goto L6;
        return r100;
    L6:
        return r100.substring(1, r100.length() - 1);
    }

    public final String a(bytedance.jvm.time.temporal.d r100) {
        StringBuilder r101 = new StringBuilder(32);
        b(r100, r101);
        return r101.toString();
    }

    public final i d(CharSequence r100) {
        ParsePosition r101 = new ParsePosition(0);
        c r102 = e(r100, r101);
        if (r102 == null) goto L12;
        if (r101.getErrorIndex() >= 0) goto L12;
        if (r101.getIndex() < r100.length()) goto L12;
        return r102.h(this.f21588d, this.f21589e);
    L12:
        if (r100.length() <= 64) goto L14;
        String r103 = r100.subSequence(0, 64).toString() + "...";
    L16:
        if (r101.getErrorIndex() < 0) goto L20;
        throw new DateTimeParseException("Text '" + r103 + "' could not be parsed at index " + r101.getErrorIndex(), r100, r101.getErrorIndex());
    L20:
        throw new DateTimeParseException("Text '" + r103 + "' could not be parsed, unparsed text found at index " + r101.getIndex(), r100, r101.getIndex());
    L14:
        r103 = r100.toString();
        goto L16
    }

    public final DateTimeFormatter f(bytedance.jvm.time.chrono.a r110) {
        if (Objects.equals(this.f21590f, r110) == false) goto L6;
        return this;
    L6:
        return new DateTimeFormatter(this.f21585a, this.f21586b, this.f21587c, this.f21588d, this.f21589e, r110, this.f21591g);
    }

    public final void b(bytedance.jvm.time.temporal.d r100, Appendable r101) {
        Objects.requireNonNull(r100, "temporal");
        Objects.requireNonNull(r101, "appendable");
        e r102 = new e(r100, this);     // Catch: IOException -> L8
        if ((r101 instanceof StringBuilder) == false) goto L6;
        this.f21585a.format(r102, (StringBuilder) r101);     // Catch: IOException -> L8
        return;
    L6:
        StringBuilder r103 = new StringBuilder(32);     // Catch: IOException -> L8
        this.f21585a.format(r102, r103);     // Catch: IOException -> L8
        r101.append(r103);     // Catch: IOException -> L8
        return;
    L8:
        e = move-exception;
        throw new DateTimeException(e.getMessage(), e);
    }

    public final <T> T c(CharSequence r100, l<T> r101) {
        Objects.requireNonNull(r100, "text");
        Objects.requireNonNull(r101, "query");
        return (T) d(r100).query(r101);
    L12:
        e = move-exception;
        throw e;
    L5:
        e = move-exception;
        if (r100.length() <= 64) goto L9;
        String r102 = r100.subSequence(0, 64).toString() + "...";
    L11:
        throw new DateTimeParseException("Text '" + r102 + "' could not be parsed: " + e.getMessage(), r100, 0, e);
    L9:
        r102 = r100.toString();
        goto L11
    }

    public final c e(CharSequence r100, ParsePosition r101) {
        Objects.requireNonNull(r100, "text");
        Objects.requireNonNull(r101, "position");
        c r102 = new c(this);
        int r103 = r101.getIndex();
        int r104 = this.f21585a.parse(r102, r100, r103);
        if (r104 >= 0) goto L6;
        r101.setErrorIndex(~r104);
        return null;
    L6:
        r101.setIndex(r104);
        return r102;
    }

    public DateTimeFormatter(DateTimeFormatterBuilder.d r100, Locale r101, g r102, ResolverStyle r103, Set r104, bytedance.jvm.time.chrono.a r105, ZoneId r106) {
        Objects.requireNonNull(r100, "printerParser");
        this.f21585a = r100;
        this.f21589e = r104;
        Objects.requireNonNull(r101, "locale");
        this.f21586b = r101;
        Objects.requireNonNull(r102, "decimalStyle");
        this.f21587c = r102;
        Objects.requireNonNull(r103, "resolverStyle");
        this.f21588d = r103;
        this.f21590f = r105;
        this.f21591g = r106;
    }
}
