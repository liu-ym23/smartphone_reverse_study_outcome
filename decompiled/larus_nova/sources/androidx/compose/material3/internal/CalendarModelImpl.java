package androidx.compose.material3.internal;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.chrono.Chronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.format.DecimalStyle;
import java.time.format.FormatStyle;
import java.time.format.TextStyle;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000 -2\u00020\u0001:\u0001-B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0015\u001a\u00020\u00162\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\fH\u0016J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\fH\u0016J$\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00122\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0016J&\u0010(\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00122\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0016J\b\u0010)\u001a\u00020\u0012H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010*\u001a\u00020+H\u0002J\f\u0010,\u001a\u00020+*\u00020\u001bH\u0002J\f\u0010,\u001a\u00020+*\u00020\bH\u0002R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006."}, d2 = {"Landroidx/compose/material3/internal/CalendarModelImpl;", "Landroidx/compose/material3/internal/CalendarModel;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "<init>", "(Ljava/util/Locale;)V", "today", "Landroidx/compose/material3/internal/CalendarDate;", "getToday", "()Landroidx/compose/material3/internal/CalendarDate;", "firstDayOfWeek", "", "getFirstDayOfWeek", "()I", "weekdayNames", "", "Lkotlin/Pair;", "", "getWeekdayNames", "()Ljava/util/List;", "getDateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "getCanonicalDate", "timeInMillis", "", "getMonth", "Landroidx/compose/material3/internal/CalendarMonth;", "date", BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR, BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH, "getDayOfWeek", "plusMonths", "from", "addedMonthsCount", "minusMonths", "subtractedMonthsCount", "formatWithPattern", "utcTimeMillis", "pattern", "parse", "toString", "firstDayLocalDate", "Ljava/time/LocalDate;", "toLocalDate", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CalendarModelImpl extends CalendarModel {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final ZoneId utcTimeZoneId = null;
    private final int firstDayOfWeek;
    private final List<Pair<String, String>> weekdayNames;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rJ0\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00052\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rH\u0002R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/internal/CalendarModelImpl$Companion;", "", "<init>", "()V", "formatWithPattern", "", "utcTimeMillis", "", "pattern", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "cache", "", "utcTimeZoneId", "Ljava/time/ZoneId;", "getUtcTimeZoneId$material3", "()Ljava/time/ZoneId;", "getCachedDateTimeFormatter", "Ljava/time/format/DateTimeFormatter;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final ZoneId getUtcTimeZoneId$material3() {
            return CalendarModelImpl.access$getUtcTimeZoneId$cp();
        }

        private final DateTimeFormatter getCachedDateTimeFormatter(String r100, Locale r101, Map<String, Object> r102) {
            String r103 = "P:" + r100 + r101.toLanguageTag();
            Object r104 = r102.get(r103);
            if (r104 != null) goto L5;
            r104 = DateTimeFormatter.ofPattern(r100, r101).withDecimalStyle(DecimalStyle.of(r101));
            r102.put(r103, r104);
        L5:
            Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type java.time.format.DateTimeFormatter");
            return (DateTimeFormatter) r104;
        }

        public static final /* synthetic */ DateTimeFormatter access$getCachedDateTimeFormatter(Companion r100, String r101, Locale r102, Map r103) {
            return r100.getCachedDateTimeFormatter(r101, r102, r103);
        }

        public final String formatWithPattern(long r100, String r101, Locale r102, Map<String, Object> r103) {
            DateTimeFormatter r104 = getCachedDateTimeFormatter(r101, r102, r103);
            return Instant.ofEpochMilli(r100).atZone(getUtcTimeZoneId$material3()).toLocalDate().format(r104);
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<DayOfWeek> entries$0 = null;

        static {
            entries$0 = EnumEntriesKt.enumEntries(DayOfWeek.values());
        }
    }

    public String toString() {
        return "CalendarModel";
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        utcTimeZoneId = ZoneId.of("UTC");
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.time.ZonedDateTime] */
    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarDate getToday() {
        LocalDate r100 = LocalDate.now();
        return new CalendarDate(r100.getYear(), r100.getMonthValue(), r100.getDayOfMonth(), r100.atTime(LocalTime.MIDNIGHT).atZone(utcTimeZoneId).toInstant().toEpochMilli());
    }

    public static final /* synthetic */ ZoneId access$getUtcTimeZoneId$cp() {
        return utcTimeZoneId;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public List<Pair<String, String>> getWeekdayNames() {
        return this.weekdayNames;
    }

    public CalendarModelImpl(Locale r100) {
        super(r100);
        this.firstDayOfWeek = WeekFields.of(r100).getFirstDayOfWeek().getValue();
        EnumEntries<DayOfWeek> r101 = EntriesMappings.entries$0;
        ArrayList r102 = new ArrayList(r101.size());
        int r103 = r101.size();
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        DayOfWeek r105 = (DayOfWeek) ListProtector.get(r101, r104);
        r102.add(TuplesKt.to(r105.getDisplayName(TextStyle.FULL_STANDALONE, r100), r105.getDisplayName(TextStyle.NARROW_STANDALONE, r100)));
        r104 = r104 + 1;
        goto L3
    L5:
        this.weekdayNames = r102;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [java.time.ZonedDateTime] */
    private final CalendarMonth getMonth(LocalDate r100) {
        int r101 = r100.getDayOfWeek().getValue() - getFirstDayOfWeek();
        if (r101 >= 0) goto L5;
        r101 = r101 + 7;
    L5:
        int r102 = r101;
        long r103 = r100.atTime(LocalTime.MIDNIGHT).atZone(utcTimeZoneId).toInstant().toEpochMilli();
        return new CalendarMonth(r100.getYear(), r100.getMonthValue(), r100.lengthOfMonth(), r102, r103);
    }

    private final LocalDate toLocalDate(CalendarMonth r100) {
        return Instant.ofEpochMilli(r100.getStartUtcTimeMillis()).atZone(utcTimeZoneId).toLocalDate();
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarDate getCanonicalDate(long r100) {
        LocalDate r101 = Instant.ofEpochMilli(r100).atZone(utcTimeZoneId).toLocalDate();
        return new CalendarDate(r101.getYear(), r101.getMonthValue(), r101.getDayOfMonth(), r101.atStartOfDay().toEpochSecond(ZoneOffset.UTC) * ((long) 1000));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public DateInputFormat getDateInputFormat(Locale r100) {
        return CalendarModelKt.datePatternAsInputFormat(DateTimeFormatterBuilder.getLocalizedDateTimePattern(FormatStyle.SHORT, null, Chronology.ofLocale(r100), r100));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public int getDayOfWeek(CalendarDate r100) {
        return toLocalDate(r100).getDayOfWeek().getValue();
    }

    private final LocalDate toLocalDate(CalendarDate r100) {
        return LocalDate.of(r100.getYear(), r100.getMonth(), r100.getDayOfMonth());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth getMonth(long r100) {
        return getMonth(Instant.ofEpochMilli(r100).atZone(utcTimeZoneId).withDayOfMonth(1).toLocalDate());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth getMonth(CalendarDate r100) {
        return getMonth(LocalDate.of(r100.getYear(), r100.getMonth(), 1));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth getMonth(int r100, int r101) {
        return getMonth(LocalDate.of(r100, r101, 1));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth minusMonths(CalendarMonth r100, int r101) {
        if (r101 > 0) goto L5;
        return r100;
    L5:
        return getMonth(toLocalDate(r100).minusMonths(r101));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth plusMonths(CalendarMonth r100, int r101) {
        if (r101 > 0) goto L5;
        return r100;
    L5:
        return getMonth(toLocalDate(r100).plusMonths(r101));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public String formatWithPattern(long r100, String r101, Locale r110) {
        return Companion.formatWithPattern(r100, r101, r110, getFormatterCache$material3());
    }

    /* JADX WARN: Type inference failed for: r7v3, types: [java.time.ZonedDateTime] */
    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarDate parse(String r100, String r101, Locale r102) {
        LocalDate r103 = LocalDate.parse(r100, Companion.access$getCachedDateTimeFormatter(Companion, r101, r102, getFormatterCache$material3()));     // Catch: DateTimeParseException -> L5
        return new CalendarDate(r103.getYear(), r103.getMonth().getValue(), r103.getDayOfMonth(), r103.atTime(LocalTime.MIDNIGHT).atZone(utcTimeZoneId).toInstant().toEpochMilli());
    L5:
        return null;
    }
}
