package com.stepos.alphame.data.model.dailyusage;

import com.stepos.alphame.common.utils.TimeUtilsKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003¨\u0006\u0007"}, d2 = {"generateDailyUsageId", "", "date", "", "mode", "", "userId", "data_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DailyUsageEntityKt {
    @NotNull
    public static final String generateDailyUsageId(long j4, int i4, long j5) {
        return TimeUtilsKt.formatDateDay(j4) + "-" + i4 + "-" + j5;
    }
}
