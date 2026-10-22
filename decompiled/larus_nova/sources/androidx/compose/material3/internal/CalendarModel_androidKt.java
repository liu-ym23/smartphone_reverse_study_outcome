package androidx.compose.material3.internal;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import android.os.Build;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u0000\u001a8\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000bH\u0000¨\u0006\r"}, d2 = {"createCalendarModel", "Landroidx/compose/material3/internal/CalendarModel;", "locale", "Ljava/util/Locale;", "Landroidx/compose/material3/CalendarLocale;", "formatWithSkeleton", "", "utcTimeMillis", "", "skeleton", "cache", "", "", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CalendarModel_androidKt {
    public static final CalendarModel createCalendarModel(Locale r100) {
        if (Build.VERSION.SDK_INT < 26) goto L6;
        return new CalendarModelImpl(r100);
    L6:
        return new LegacyCalendarModelImpl(r100);
    }

    public static final String formatWithSkeleton(long r100, String r110, Locale r111, Map<String, Object> r112) {
        if (Build.VERSION.SDK_INT < 24) goto L9;
        String r101 = "S:" + r110 + r111.toLanguageTag();
        Object r102 = r112.get(r101);
        Object r103 = r102;
        if (r102 != null) goto L7;
        DateFormat r104 = DateFormat.getInstanceForSkeleton(r110, r111);
        r104.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
        r104.setTimeZone(TimeZone.GMT_ZONE);
        r112.put(r101, r104);
        r103 = r104;
    L7:
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.icu.text.DateFormat");
        return ((DateFormat) r103).format(new Date(r100));
    L9:
        String r105 = "S:" + r110 + r111.toLanguageTag();
        Object r106 = r112.get(r105);
        if (r106 != null) goto L13;
        r106 = android.text.format.DateFormat.getBestDateTimePattern(r111, r110);
        r112.put(r105, r106);
    L13:
        return LegacyCalendarModelImpl.Companion.formatWithPattern(r100, r106.toString(), r111, r112);
    }
}
