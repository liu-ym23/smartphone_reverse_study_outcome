package com.stepos.alphame.dailyusage.utils;

import com.stepos.alphame.common.model.ResponseKt;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u00072\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/stepos/alphame/dailyusage/utils/DailyUsageRequestValidator;", "", "()V", "DESCRIPTION_ERROR_DATE", "", "DESCRIPTION_ERROR_NORMAL", "validateParameter", "Lkotlin/Pair;", "", "mode", "userId", "", "startDate", "endDate", "dailyusage_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DailyUsageRequestValidator {

    @NotNull
    public static final String DESCRIPTION_ERROR_DATE = "parameter error, start date is greater than end date";

    @NotNull
    public static final String DESCRIPTION_ERROR_NORMAL = "parameter error, in normal mode, user id must be 1";

    @NotNull
    public static final DailyUsageRequestValidator INSTANCE = new DailyUsageRequestValidator();

    private DailyUsageRequestValidator() {
    }

    @NotNull
    public final Pair<Integer, String> validateParameter(int mode, long userId, long startDate, long endDate) {
        return startDate > endDate ? new Pair<>(201, DESCRIPTION_ERROR_DATE) : new Pair<>(200, ResponseKt.DESCRIPTION_SUCCESS);
    }
}
