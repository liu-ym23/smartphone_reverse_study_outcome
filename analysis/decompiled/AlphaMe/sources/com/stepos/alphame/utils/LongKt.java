package com.stepos.alphame.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0002*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\t*\u00020\u0002\u001a\n\u0010\n\u001a\u00020\t*\u00020\u0002¨\u0006\u000b"}, d2 = {"formatDateFull", "", "", "pattern", "formatDateHour", "formatDateHourAndMin", "formatDateYear", "getDayZero", "getHour", "", "getMin", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LongKt {
    @NotNull
    public static final String formatDateFull(long j4, @NotNull String pattern) {
        Intrinsics.checkNotNullParameter(pattern, "pattern");
        String str = new SimpleDateFormat(pattern, Locale.CHINA).format(Long.valueOf(j4));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @NotNull
    public static final String formatDateHour(long j4) {
        String str = new SimpleDateFormat("HH:mm:ss", Locale.CHINA).format(Long.valueOf(j4));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @NotNull
    public static final String formatDateHourAndMin(long j4) {
        String str = new SimpleDateFormat("HH:mm", Locale.CHINA).format(Long.valueOf(j4));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @NotNull
    public static final String formatDateYear(long j4) {
        String str = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.CHINA).format(Long.valueOf(j4));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    public static final long getDayZero(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j4);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        return calendar.getTimeInMillis();
    }

    public static final int getHour(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j4);
        return calendar.get(11);
    }

    public static final int getMin(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j4);
        return calendar.get(12);
    }
}
