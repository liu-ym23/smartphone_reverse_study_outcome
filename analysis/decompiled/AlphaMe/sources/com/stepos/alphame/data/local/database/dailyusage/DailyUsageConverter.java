package com.stepos.alphame.data.local.database.dailyusage;

import F1.n;
import androidx.room.TypeConverter;
import com.baidu.mapapi.http.wrapper.annotation.BodyData;
import com.google.gson.reflect.TypeToken;
import com.stepos.alphame.data.model.dailyusage.NotificationUsageEntity;
import com.stepos.alphame.data.model.dailyusage.ScreenUsageEntity;
import com.stepos.alphame.data.model.dailyusage.TimeUsageEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0002H\u0007¢\u0006\u0004\b\r\u0010\u0007J\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u000e\u0010\nJ\u001d\u0010\u0011\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\u0007J\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00022\u0006\u0010\b\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0012\u0010\nR\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/stepos/alphame/data/local/database/dailyusage/DailyUsageConverter;", "", "", "Lcom/stepos/alphame/data/model/dailyusage/TimeUsageEntity;", "timeRecords", "", "fromTimeUsages", "(Ljava/util/List;)Ljava/lang/String;", BodyData.TYPE_JSON, "toTimeUsages", "(Ljava/lang/String;)Ljava/util/List;", "Lcom/stepos/alphame/data/model/dailyusage/NotificationUsageEntity;", "notificationRecords", "fromNotificationUsages", "toNotificationUsages", "Lcom/stepos/alphame/data/model/dailyusage/ScreenUsageEntity;", "screenOnUsages", "fromScreenOnUsage", "toScreenOnUsages", "LF1/n;", "gson", "LF1/n;", "<init>", "()V", "data_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes.dex */
public final class DailyUsageConverter {

    @NotNull
    private final n gson = new n();

    @TypeConverter
    @NotNull
    public final String fromNotificationUsages(@NotNull List<NotificationUsageEntity> notificationRecords) {
        Intrinsics.checkNotNullParameter(notificationRecords, "notificationRecords");
        String strG = this.gson.g(notificationRecords);
        Intrinsics.checkNotNullExpressionValue(strG, "toJson(...)");
        return strG;
    }

    @TypeConverter
    @NotNull
    public final String fromScreenOnUsage(@NotNull List<ScreenUsageEntity> screenOnUsages) {
        Intrinsics.checkNotNullParameter(screenOnUsages, "screenOnUsages");
        String strG = this.gson.g(screenOnUsages);
        Intrinsics.checkNotNullExpressionValue(strG, "toJson(...)");
        return strG;
    }

    @TypeConverter
    @NotNull
    public final String fromTimeUsages(@NotNull List<TimeUsageEntity> timeRecords) {
        Intrinsics.checkNotNullParameter(timeRecords, "timeRecords");
        String strG = this.gson.g(timeRecords);
        Intrinsics.checkNotNullExpressionValue(strG, "toJson(...)");
        return strG;
    }

    @TypeConverter
    @NotNull
    public final List<NotificationUsageEntity> toNotificationUsages(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        Object objD = this.gson.d(json, new TypeToken<List<? extends NotificationUsageEntity>>() { // from class: com.stepos.alphame.data.local.database.dailyusage.DailyUsageConverter$toNotificationUsages$listType$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objD, "fromJson(...)");
        return (List) objD;
    }

    @TypeConverter
    @NotNull
    public final List<ScreenUsageEntity> toScreenOnUsages(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        Object objD = this.gson.d(json, new TypeToken<List<? extends ScreenUsageEntity>>() { // from class: com.stepos.alphame.data.local.database.dailyusage.DailyUsageConverter$toScreenOnUsages$listType$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objD, "fromJson(...)");
        return (List) objD;
    }

    @TypeConverter
    @NotNull
    public final List<TimeUsageEntity> toTimeUsages(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        Object objD = this.gson.d(json, new TypeToken<List<? extends TimeUsageEntity>>() { // from class: com.stepos.alphame.data.local.database.dailyusage.DailyUsageConverter$toTimeUsages$listType$1
        }.getType());
        Intrinsics.checkNotNullExpressionValue(objD, "fromJson(...)");
        return (List) objD;
    }
}
