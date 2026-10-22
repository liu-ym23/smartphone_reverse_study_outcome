package com.stepos.alphame.common.utils;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0003\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"YYYY_MM_DD", "", "formatDateDay", "", "formatDateYear", "formatDuration", "formatDurationWithApi", "isSameDay", "", "timeMill", "common_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TimeUtilsKt {

    @NotNull
    public static final String YYYY_MM_DD = "yyyy-MM-dd";

    @NotNull
    public static final String formatDateDay(long j4) {
        String str = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA).format(Long.valueOf(j4));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @NotNull
    public static final String formatDateYear(long j4) {
        String str = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.CHINA).format(Long.valueOf(j4));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }

    @NotNull
    public static final String formatDuration(long j4) {
        long j5 = j4 / 1000;
        long j6 = 3600;
        long j7 = j5 / j6;
        long j8 = j5 % j6;
        long j9 = 60;
        return j7 + "小时 " + (j8 / j9) + "分 " + (j8 % j9) + "秒";
    }

    @NotNull
    public static final String formatDurationWithApi(long j4) {
        Duration durationOfMillis = Duration.ofMillis(j4);
        long hours = durationOfMillis.toHours();
        long minutes = durationOfMillis.minusHours(hours).toMinutes();
        return hours + "小时 " + minutes + "分 " + durationOfMillis.minusHours(hours).minusMinutes(minutes).getSeconds() + "秒";
    }

    public static final boolean isSameDay(long j4, long j5) {
        return Intrinsics.areEqual(formatDateDay(j4), formatDateDay(j5));
    }
}
