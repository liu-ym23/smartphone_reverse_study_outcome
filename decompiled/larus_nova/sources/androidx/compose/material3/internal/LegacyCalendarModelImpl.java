package androidx.compose.material3.internal;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 12\u00020\u0001:\u00011B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0015\u001a\u00020\u00162\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\bH\u0016J\u0018\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\fH\u0016J\u0018\u0010#\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\fH\u0016J$\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00122\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0016J&\u0010(\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u00122\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0016J\b\u0010)\u001a\u00020\u0012H\u0016J\u0010\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\fH\u0002J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-H\u0002J\f\u0010.\u001a\u00020-*\u00020\u001bH\u0002J\u0014\u0010.\u001a\u00020-*\u00020\b2\u0006\u0010/\u001a\u000200H\u0002R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR&\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u00062"}, d2 = {"Landroidx/compose/material3/internal/LegacyCalendarModelImpl;", "Landroidx/compose/material3/internal/CalendarModel;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "<init>", "(Ljava/util/Locale;)V", "today", "Landroidx/compose/material3/internal/CalendarDate;", "getToday", "()Landroidx/compose/material3/internal/CalendarDate;", "firstDayOfWeek", "", "getFirstDayOfWeek", "()I", "weekdayNames", "", "Lkotlin/Pair;", "", "getWeekdayNames", "()Ljava/util/List;", "getDateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "getCanonicalDate", "timeInMillis", "", "getMonth", "Landroidx/compose/material3/internal/CalendarMonth;", "date", BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR, BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH, "getDayOfWeek", "plusMonths", "from", "addedMonthsCount", "minusMonths", "subtractedMonthsCount", "formatWithPattern", "utcTimeMillis", "pattern", "parse", "toString", "dayInISO8601", BdpGameHostBaseUIService.DATE_PICKER_TYPE_DAY, "firstDayCalendar", "Ljava/util/Calendar;", "toCalendar", TimeZoneItemV2.TIME_ZONE, "Ljava/util/TimeZone;", "Companion", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LegacyCalendarModelImpl extends CalendarModel {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final TimeZone utcTimeZone = null;
    private final int firstDayOfWeek;
    private final List<Pair<String, String>> weekdayNames;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00052\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rJ0\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\u00052\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\rH\u0002R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Landroidx/compose/material3/internal/LegacyCalendarModelImpl$Companion;", "", "<init>", "()V", "formatWithPattern", "", "utcTimeMillis", "", "pattern", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "cache", "", "utcTimeZone", "Ljava/util/TimeZone;", "getUtcTimeZone$material3", "()Ljava/util/TimeZone;", "getCachedSimpleDateFormat", "Ljava/text/SimpleDateFormat;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final TimeZone getUtcTimeZone$material3() {
            return LegacyCalendarModelImpl.access$getUtcTimeZone$cp();
        }

        private final SimpleDateFormat getCachedSimpleDateFormat(String r100, Locale r101, Map<String, Object> r102) {
            String r103 = r100 + r101.toLanguageTag();
            Object r104 = r102.get(r103);
            Object r105 = r104;
            if (r104 != null) goto L6;
            SimpleDateFormat r106 = new SimpleDateFormat(r100, r101);
            r106.setTimeZone(LegacyCalendarModelImpl.Companion.getUtcTimeZone$material3());
            r102.put(r103, r106);
            r105 = r106;
        L6:
            return (SimpleDateFormat) r105;
        }

        public final String formatWithPattern(long r100, String r101, Locale r102, Map<String, Object> r103) {
            SimpleDateFormat r104 = getCachedSimpleDateFormat(r101, r102, r103);
            Calendar r105 = Calendar.getInstance(getUtcTimeZone$material3());
            r105.setTimeInMillis(r100);
            return r104.format(Long.valueOf(r105.getTimeInMillis()));
        }
    }

    public String toString() {
        return "LegacyCalendarModel";
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        utcTimeZone = TimeZone.getTimeZone("UTC");
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarDate getToday() {
        Calendar r100 = Calendar.getInstance();
        r100.set(11, 0);
        r100.set(12, 0);
        r100.set(13, 0);
        r100.set(14, 0);
        int r101 = r100.get(15) + r100.get(16);
        return new CalendarDate(r100.get(1), r100.get(2) + 1, r100.get(5), r100.getTimeInMillis() + ((long) r101));
    }

    public static final /* synthetic */ TimeZone access$getUtcTimeZone$cp() {
        return utcTimeZone;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public List<Pair<String, String>> getWeekdayNames() {
        return this.weekdayNames;
    }

    public LegacyCalendarModelImpl(Locale r100) {
        super(r100);
        this.firstDayOfWeek = dayInISO8601(Calendar.getInstance(r100).getFirstDayOfWeek());
        List r101 = CollectionsKt.createListBuilder();
        String[] r102 = new DateFormatSymbols(r100).getWeekdays();
        String[] r103 = new DateFormatSymbols(r100).getShortWeekdays();
        List r104 = ArraysKt.drop(r102, 2);
        int r105 = r104.size();
        int r106 = 0;
    L3:
        if (r106 >= r105) goto L5;
        r101.add(new Pair((String) ListProtector.get(r104, r106), r103[r106 + 2]));
        r106 = r106 + 1;
        goto L3
    L5:
        r101.add(new Pair(r102[1], r103[1]));
        this.weekdayNames = CollectionsKt.build(r101);
    }

    private final int dayInISO8601(int r100) {
        int r101 = (r100 + 6) % 7;
        if (r101 != 0) goto L5;
        return 7;
    L5:
        return r101;
    }

    private final CalendarMonth getMonth(Calendar r100) {
        int r101 = dayInISO8601(r100.get(7)) - getFirstDayOfWeek();
        if (r101 >= 0) goto L5;
        r101 = r101 + 7;
    L5:
        int r102 = r100.get(1);
        int r103 = r100.get(2) + 1;
        int r104 = r100.getActualMaximum(5);
        return new CalendarMonth(r102, r103, r104, r101, r100.getTimeInMillis());
    }

    private final Calendar toCalendar(CalendarMonth r100) {
        Calendar r101 = Calendar.getInstance(utcTimeZone);
        r101.setTimeInMillis(r100.getStartUtcTimeMillis());
        return r101;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarDate getCanonicalDate(long r100) {
        Calendar r101 = Calendar.getInstance(utcTimeZone);
        r101.setTimeInMillis(r100);
        r101.set(11, 0);
        r101.set(12, 0);
        r101.set(13, 0);
        r101.set(14, 0);
        return new CalendarDate(r101.get(1), r101.get(2) + 1, r101.get(5), r101.getTimeInMillis());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public DateInputFormat getDateInputFormat(Locale r100) {
        DateFormat r101 = DateFormat.getDateInstance(3, r100);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.text.SimpleDateFormat");
        return CalendarModelKt.datePatternAsInputFormat(((SimpleDateFormat) r101).toPattern());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public int getDayOfWeek(CalendarDate r100) {
        return dayInISO8601(toCalendar(r100, TimeZone.getDefault()).get(7));
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth getMonth(long r100) {
        Calendar r101 = Calendar.getInstance(utcTimeZone);
        r101.setTimeInMillis(r100);
        r101.set(5, 1);
        r101.set(11, 0);
        r101.set(12, 0);
        r101.set(13, 0);
        r101.set(14, 0);
        return getMonth(r101);
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth getMonth(CalendarDate r100) {
        return getMonth(r100.getYear(), r100.getMonth());
    }

    private final Calendar toCalendar(CalendarDate r100, TimeZone r101) {
        Calendar r102 = Calendar.getInstance(r101);
        r102.clear();
        r102.set(1, r100.getYear());
        r102.set(2, r100.getMonth() - 1);
        r102.set(5, r100.getDayOfMonth());
        return r102;
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth getMonth(int r100, int r101) {
        Calendar r102 = Calendar.getInstance(utcTimeZone);
        r102.clear();
        r102.set(1, r100);
        r102.set(2, r101 - 1);
        r102.set(5, 1);
        return getMonth(r102);
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth minusMonths(CalendarMonth r100, int r101) {
        if (r101 > 0) goto L4;
        return r100;
    L4:
        Calendar r102 = toCalendar(r100);
        r102.add(2, -r101);
        return getMonth(r102);
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarMonth plusMonths(CalendarMonth r100, int r101) {
        if (r101 > 0) goto L4;
        return r100;
    L4:
        Calendar r102 = toCalendar(r100);
        r102.add(2, r101);
        return getMonth(r102);
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public String formatWithPattern(long r100, String r101, Locale r110) {
        return Companion.formatWithPattern(r100, r101, r110, getFormatterCache$material3());
    }

    @Override // androidx.compose.material3.internal.CalendarModel
    public CalendarDate parse(String r100, String r101, Locale r110) {
        SimpleDateFormat r111 = new SimpleDateFormat(r101);
        TimeZone r102 = utcTimeZone;
        r111.setTimeZone(r102);
        r111.setLenient(false);
        Date r103 = r111.parse(r100);     // Catch: ParseException -> L9
        if (r103 != null) goto L6;
        return null;
    L6:
        Calendar r104 = Calendar.getInstance(r102);     // Catch: ParseException -> L9
        r104.setTime(r103);     // Catch: ParseException -> L9
        return new CalendarDate(r104.get(1), r104.get(2) + 1, r104.get(5), r104.getTimeInMillis());
    L12:
        return null;
    }
}
