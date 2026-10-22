package com.android.contacts.calllog.record;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* JADX INFO: compiled from: TimeUtil.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0005¨\u0006\t"}, d2 = {"formatDurationAndGetSeconds", "", "milliseconds", "", "formatMillisecondsUsingDuration", "", "formatTimestamp", "timestamp", "pattern", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class TimeUtilKt {
    public static final String formatTimestamp(long r1, String r3) {
        Intrinsics.checkNotNullParameter(r3, "pattern");
        String r2 = LocalDateTime.ofInstant(Instant.ofEpochMilli(r1), ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern(r3));
        Intrinsics.checkNotNullExpressionValue(r2, "dateTime.format(formatter)");
        return r2;
    }

    public static final String formatMillisecondsUsingDuration(int r6) {
        Duration.Companion r0 = Duration.Companion;
        long r1 = DurationKt.toDuration(r6, DurationUnit.MILLISECONDS);
        long r2 = Duration.m2163getInWholeMinutesimpl(r1);
        long r3 = Duration.m2165getInWholeSecondsimpl(r1) % ((long) 60);
        StringCompanionObject r7 = StringCompanionObject.INSTANCE;
        String r8 = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(r2), Long.valueOf(r3)}, 2));
        Intrinsics.checkNotNullExpressionValue(r8, "format(...)");
        return r8;
    }

    public static final long formatDurationAndGetSeconds(int r2) {
        Duration.Companion r0 = Duration.Companion;
        return Duration.m2165getInWholeSecondsimpl(DurationKt.toDuration(r2, DurationUnit.MILLISECONDS));
    }
}
