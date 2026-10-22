package androidx.compose.material3.internal;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\b!\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u001c\u001a\u00020\u001d2\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H&¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!H&J\u0010\u0010\"\u001a\u00020#2\u0006\u0010 \u001a\u00020!H&J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0010H&J\u0018\u0010\"\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0014H&J\u0010\u0010'\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u0010H&J\u0018\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020#2\u0006\u0010*\u001a\u00020\u0014H&J\u0018\u0010+\u001a\u00020#2\u0006\u0010)\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0014H&J)\u0010-\u001a\u00020\f2\u0006\u0010&\u001a\u00020#2\u0006\u0010.\u001a\u00020\f2\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010/J)\u0010-\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\f2\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u00100J)\u00101\u001a\u00020\f2\u0006\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\f2\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H&¢\u0006\u0002\u00104J+\u00105\u001a\u0004\u0018\u00010\u00102\u0006\u0010$\u001a\u00020\f2\u0006\u00103\u001a\u00020\f2\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H&¢\u0006\u0002\u00106R\u0017\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR \u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u00190\u0018X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u00067"}, d2 = {"Landroidx/compose/material3/internal/CalendarModel;", "", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "<init>", "(Ljava/util/Locale;)V", "getLocale", "()Ljava/util/Locale;", "Ljava/util/Locale;", "formatterCache", "", "", "getFormatterCache$material3", "()Ljava/util/Map;", "today", "Landroidx/compose/material3/internal/CalendarDate;", "getToday", "()Landroidx/compose/material3/internal/CalendarDate;", "firstDayOfWeek", "", "getFirstDayOfWeek", "()I", "weekdayNames", "", "Lkotlin/Pair;", "getWeekdayNames", "()Ljava/util/List;", "getDateInputFormat", "Landroidx/compose/material3/internal/DateInputFormat;", "(Ljava/util/Locale;)Landroidx/compose/material3/internal/DateInputFormat;", "getCanonicalDate", "timeInMillis", "", "getMonth", "Landroidx/compose/material3/internal/CalendarMonth;", "date", BdpGameHostBaseUIService.DATE_PICKER_TYPE_YEAR, BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH, "getDayOfWeek", "plusMonths", "from", "addedMonthsCount", "minusMonths", "subtractedMonthsCount", "formatWithSkeleton", "skeleton", "(Landroidx/compose/material3/internal/CalendarMonth;Ljava/lang/String;Ljava/util/Locale;)Ljava/lang/String;", "(Landroidx/compose/material3/internal/CalendarDate;Ljava/lang/String;Ljava/util/Locale;)Ljava/lang/String;", "formatWithPattern", "utcTimeMillis", "pattern", "(JLjava/lang/String;Ljava/util/Locale;)Ljava/lang/String;", "parse", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Locale;)Landroidx/compose/material3/internal/CalendarDate;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class CalendarModel {
    public static final int $stable = 8;
    private final Map<String, Object> formatterCache;
    private final Locale locale;

    public abstract String formatWithPattern(long r100, String r101, Locale r102);

    public abstract CalendarDate getCanonicalDate(long r100);

    public abstract DateInputFormat getDateInputFormat(Locale r100);

    public abstract int getDayOfWeek(CalendarDate r100);

    public abstract int getFirstDayOfWeek();

    public abstract CalendarMonth getMonth(int r100, int r101);

    public abstract CalendarMonth getMonth(long r100);

    public abstract CalendarMonth getMonth(CalendarDate r100);

    public abstract CalendarDate getToday();

    public abstract List<Pair<String, String>> getWeekdayNames();

    public abstract CalendarMonth minusMonths(CalendarMonth r100, int r101);

    public abstract CalendarDate parse(String r100, String r101, Locale r102);

    public abstract CalendarMonth plusMonths(CalendarMonth r100, int r101);

    public final Map<String, Object> getFormatterCache$material3() {
        return this.formatterCache;
    }

    public final Locale getLocale() {
        return this.locale;
    }

    public CalendarModel(Locale r100) {
        this.locale = r100;
        this.formatterCache = new LinkedHashMap();
    }

    public final String formatWithSkeleton(CalendarDate r100, String r101, Locale r102) {
        return CalendarModel_androidKt.formatWithSkeleton(r100.getUtcTimeMillis(), r101, r102, this.formatterCache);
    }

    public final String formatWithSkeleton(CalendarMonth r100, String r101, Locale r102) {
        return CalendarModel_androidKt.formatWithSkeleton(r100.getStartUtcTimeMillis(), r101, r102, this.formatterCache);
    }

    public static /* synthetic */ DateInputFormat getDateInputFormat$default(CalendarModel r100, Locale r101, int r102, Object r103) {
        if (r103 != null) goto L9;
        if ((r102 & 1) == 0) goto L7;
        r101 = r100.locale;
    L7:
        return r100.getDateInputFormat(r101);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDateInputFormat");
    }

    public static /* synthetic */ String formatWithSkeleton$default(CalendarModel r100, CalendarDate r101, String r102, Locale r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 4) == 0) goto L7;
        r103 = r100.locale;
    L7:
        return r100.formatWithSkeleton(r101, r102, r103);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: formatWithSkeleton");
    }

    public static /* synthetic */ String formatWithSkeleton$default(CalendarModel r100, CalendarMonth r101, String r102, Locale r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 4) == 0) goto L7;
        r103 = r100.locale;
    L7:
        return r100.formatWithSkeleton(r101, r102, r103);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: formatWithSkeleton");
    }
}
