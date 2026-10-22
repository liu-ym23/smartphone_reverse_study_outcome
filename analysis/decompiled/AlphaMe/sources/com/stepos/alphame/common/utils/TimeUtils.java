package com.stepos.alphame.common.utils;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0007J\u0016\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0016\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stepos/alphame/common/utils/TimeUtils;", "", "()V", "DAY", "", "HOUR", "MINUTE", "SECOND", "TAG", "", "getBaseTimeMill", "timeMill", "getCustomTimeMill", "hour", "", "min", "getSeconds", "common_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TimeUtils {
    public static final long DAY = 86400000;
    public static final long HOUR = 3600000;

    @NotNull
    public static final TimeUtils INSTANCE = new TimeUtils();
    public static final long MINUTE = 60000;
    public static final long SECOND = 1000;

    @NotNull
    public static final String TAG = "TimeUtils";

    private TimeUtils() {
    }

    @JvmStatic
    public static final long getBaseTimeMill(long timeMill) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timeMill);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public final long getCustomTimeMill(int hour, int min) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(11, hour);
        calendar.set(12, min);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public final long getSeconds(int hour, int min) {
        return (min * 60000) + (hour * 3600000);
    }
}
