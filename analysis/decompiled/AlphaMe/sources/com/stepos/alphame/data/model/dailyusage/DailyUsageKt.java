package com.stepos.alphame.data.model.dailyusage;

import B0.g;
import androidx.room.AbstractC0351g;
import com.stepos.alphame.awareness.AwarenessDataItem;
import com.stepos.alphame.common.utils.LogKt;
import com.stepos.alphame.common.utils.TimeUtilsKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0005\u001a\n\u0010\u0007\u001a\u00020\b*\u00020\t\u001a\n\u0010\u0007\u001a\u00020\n*\u00020\u000b\u001a\n\u0010\u0007\u001a\u00020\f*\u00020\r\u001a\n\u0010\u000e\u001a\u00020\t*\u00020\b\u001a\n\u0010\u000f\u001a\u00020\u000b*\u00020\n\u001a\n\u0010\u0010\u001a\u00020\r*\u00020\f\u001a\u0012\u0010\u0011\u001a\u00020\u0012*\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014\u001a\n\u0010\u0015\u001a\u00020\u0016*\u00020\r\u001a\u0012\u0010\u0017\u001a\u00020\u0012*\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014¨\u0006\u0018"}, d2 = {"getTimeUsageKey", "", "type", "", "asDailyUsage", "Lcom/stepos/alphame/data/model/dailyusage/DailyUsage;", "Lcom/stepos/alphame/data/model/dailyusage/DailyUsageEntity;", "asEntity", "Lcom/stepos/alphame/data/model/dailyusage/NotificationUsageEntity;", "Lcom/stepos/alphame/data/model/dailyusage/NotificationUsage;", "Lcom/stepos/alphame/data/model/dailyusage/ScreenUsageEntity;", "Lcom/stepos/alphame/data/model/dailyusage/ScreenUsage;", "Lcom/stepos/alphame/data/model/dailyusage/TimeUsageEntity;", "Lcom/stepos/alphame/data/model/dailyusage/TimeUsage;", "asNotificationUsage", "asScreenUsage", "asTimeUsage", "endRunning", "", "triggerTime", "", "isRunning", "", "setRunning", "data_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DailyUsageKt {
    @NotNull
    public static final DailyUsage asDailyUsage(@NotNull DailyUsageEntity dailyUsageEntity) {
        Intrinsics.checkNotNullParameter(dailyUsageEntity, "<this>");
        DailyUsage dailyUsage = new DailyUsage(dailyUsageEntity.getDate(), dailyUsageEntity.getMode(), dailyUsageEntity.getUserId(), null, null, null, 56, null);
        Iterator<NotificationUsageEntity> it = dailyUsageEntity.getNotificationUsages().iterator();
        while (it.hasNext()) {
            dailyUsage.getNotificationUsages().add(asNotificationUsage(it.next()));
        }
        Iterator<ScreenUsageEntity> it2 = dailyUsageEntity.getScreenUsages().iterator();
        while (it2.hasNext()) {
            dailyUsage.getScreenUsages().add(asScreenUsage(it2.next()));
        }
        Iterator<TimeUsageEntity> it3 = dailyUsageEntity.getTimeUsages().iterator();
        while (it3.hasNext()) {
            dailyUsage.getTimeUsages().add(asTimeUsage(it3.next()));
        }
        return dailyUsage;
    }

    @NotNull
    public static final DailyUsageEntity asEntity(@NotNull DailyUsage dailyUsage) {
        Intrinsics.checkNotNullParameter(dailyUsage, "<this>");
        long date = dailyUsage.getDate();
        int mode = dailyUsage.getMode();
        long userId = dailyUsage.getUserId();
        DailyUsageEntity dailyUsageEntity = new DailyUsageEntity(DailyUsageEntityKt.generateDailyUsageId(date, mode, userId), date, mode, userId, null, null, null, 112, null);
        Iterator<NotificationUsage> it = dailyUsage.getNotificationUsages().iterator();
        while (it.hasNext()) {
            dailyUsageEntity.getNotificationUsages().add(asEntity(it.next()));
        }
        Iterator<ScreenUsage> it2 = dailyUsage.getScreenUsages().iterator();
        while (it2.hasNext()) {
            dailyUsageEntity.getScreenUsages().add(asEntity(it2.next()));
        }
        Iterator<TimeUsage> it3 = dailyUsage.getTimeUsages().iterator();
        while (it3.hasNext()) {
            dailyUsageEntity.getTimeUsages().add(asEntity(it3.next()));
        }
        return dailyUsageEntity;
    }

    @NotNull
    public static final NotificationUsage asNotificationUsage(@NotNull NotificationUsageEntity notificationUsageEntity) {
        Intrinsics.checkNotNullParameter(notificationUsageEntity, "<this>");
        return new NotificationUsage(notificationUsageEntity.getPackageName(), notificationUsageEntity.getTriggerTime());
    }

    @NotNull
    public static final ScreenUsage asScreenUsage(@NotNull ScreenUsageEntity screenUsageEntity) {
        Intrinsics.checkNotNullParameter(screenUsageEntity, "<this>");
        return new ScreenUsage(screenUsageEntity.getPackageName(), screenUsageEntity.getTriggerTime());
    }

    @NotNull
    public static final TimeUsage asTimeUsage(@NotNull TimeUsageEntity timeUsageEntity) {
        Intrinsics.checkNotNullParameter(timeUsageEntity, "<this>");
        return new TimeUsage(timeUsageEntity.getPackageName(), timeUsageEntity.getStartTime(), timeUsageEntity.getEndTime(), timeUsageEntity.getType());
    }

    public static final void endRunning(@NotNull TimeUsage timeUsage, long j4) {
        Intrinsics.checkNotNullParameter(timeUsage, "<this>");
        timeUsage.setEndTime(j4);
        long endTime = timeUsage.getEndTime() - timeUsage.getStartTime();
        String timeUsageKey = getTimeUsageKey(timeUsage.getType());
        String packageName = timeUsage.getPackageName();
        String dateYear = TimeUtilsKt.formatDateYear(timeUsage.getEndTime());
        String dateYear2 = TimeUtilsKt.formatDateYear(timeUsage.getStartTime());
        StringBuilder sb = new StringBuilder("end timeUsage, time：");
        sb.append(endTime);
        sb.append(AwarenessDataItem.PERMISSION_SPLITTER);
        sb.append(timeUsageKey);
        AbstractC0351g.C(sb, AwarenessDataItem.PERMISSION_SPLITTER, packageName, " end time ", dateYear);
        LogKt.logW$default(DailyUsageSummaryKt.TAG, g.r(sb, " start time ", dateYear2), null, 4, null);
    }

    @NotNull
    public static final String getTimeUsageKey(int i4) {
        TimeUsageType timeUsageType = TimeUsageType.FULL_SCREEN_WINDOW;
        if (i4 == timeUsageType.getType()) {
            return timeUsageType.getKey();
        }
        TimeUsageType timeUsageType2 = TimeUsageType.FOREGROUND_WINDOW;
        if (i4 == timeUsageType2.getType()) {
            return timeUsageType2.getKey();
        }
        TimeUsageType timeUsageType3 = TimeUsageType.FLOATING_WINDOW;
        if (i4 == timeUsageType3.getType()) {
            return timeUsageType3.getKey();
        }
        TimeUsageType timeUsageType4 = TimeUsageType.AUDIO;
        return i4 == timeUsageType4.getType() ? timeUsageType4.getKey() : "";
    }

    public static final boolean isRunning(@NotNull TimeUsage timeUsage) {
        Intrinsics.checkNotNullParameter(timeUsage, "<this>");
        return timeUsage.getStartTime() == timeUsage.getEndTime();
    }

    public static final void setRunning(@NotNull TimeUsage timeUsage, long j4) {
        Intrinsics.checkNotNullParameter(timeUsage, "<this>");
        timeUsage.setStartTime(j4);
        timeUsage.setEndTime(j4);
        String timeUsageKey = getTimeUsageKey(timeUsage.getType());
        String packageName = timeUsage.getPackageName();
        String dateYear = TimeUtilsKt.formatDateYear(timeUsage.getStartTime());
        StringBuilder sbX = g.x("set running time usage,", timeUsageKey, AwarenessDataItem.PERMISSION_SPLITTER, packageName, " start time ");
        sbX.append(dateYear);
        LogKt.logI(DailyUsageSummaryKt.TAG, sbX.toString());
    }

    @NotNull
    public static final TimeUsageEntity asEntity(@NotNull TimeUsage timeUsage) {
        Intrinsics.checkNotNullParameter(timeUsage, "<this>");
        return new TimeUsageEntity(timeUsage.getPackageName(), timeUsage.getStartTime(), timeUsage.getEndTime(), timeUsage.getType());
    }

    @NotNull
    public static final NotificationUsageEntity asEntity(@NotNull NotificationUsage notificationUsage) {
        Intrinsics.checkNotNullParameter(notificationUsage, "<this>");
        return new NotificationUsageEntity(notificationUsage.getPackageName(), notificationUsage.getTriggerTime());
    }

    @NotNull
    public static final ScreenUsageEntity asEntity(@NotNull ScreenUsage screenUsage) {
        Intrinsics.checkNotNullParameter(screenUsage, "<this>");
        return new ScreenUsageEntity(screenUsage.getPackageName(), screenUsage.getTriggerTime());
    }
}
