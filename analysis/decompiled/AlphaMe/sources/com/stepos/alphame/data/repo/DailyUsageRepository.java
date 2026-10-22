package com.stepos.alphame.data.repo;

import ch.qos.logback.core.joran.action.Action;
import com.stepos.alphame.appinfo.AppInfoDbHelper;
import com.stepos.alphame.data.model.dailyusage.DailyUsage;
import com.stepos.alphame.data.model.dailyusage.DailyUsageEntity;
import com.stepos.alphame.data.model.dailyusage.DailyUsageSummary;
import com.stepos.alphame.data.model.dailyusage.NotificationUsage;
import com.stepos.alphame.data.model.dailyusage.ScreenUsage;
import com.stepos.alphame.data.model.dailyusage.TimeUsage;
import com.stepos.alphame.data.model.dailyusage.TimeUsageEntity;
import com.stepos.alphame.data.model.dailyusage.TimeUsageType;
import com.stepos.alphame.model.event.DailyUsageMessage;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u000e\u0010\f\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\rJ\b\u0010\u000f\u001a\u00020\u0003H&J\u001e\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH¦@¢\u0006\u0002\u0010\u0014J(\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u0018H&J\b\u0010\u0019\u001a\u00020\u001aH&J\b\u0010\u001b\u001a\u00020\u000bH&J\b\u0010\u001c\u001a\u00020\u0012H&J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001a0\u001eH&J.\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020\u000bH&J\u0016\u0010%\u001a\b\u0012\u0004\u0012\u00020&0!2\u0006\u0010'\u001a\u00020\u000bH&J\u000e\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001f0!H&J\u0012\u0010)\u001a\u0004\u0018\u00010&2\u0006\u0010*\u001a\u00020\u001fH&J\u0014\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020&0\u001eH&J\u001e\u0010,\u001a\b\u0012\u0004\u0012\u00020-0!2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH&J\u001a\u0010.\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH&J\u0016\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u000201H¦@¢\u0006\u0002\u00102J\u0010\u00103\u001a\u0002042\u0006\u00105\u001a\u00020\u001fH&J\b\u00106\u001a\u00020\u0003H&J\u0010\u00107\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u001fH&J\u0010\u00108\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000bH&J\u0010\u00109\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u000e\u0010:\u001a\u000204H¦@¢\u0006\u0002\u0010\rJ\b\u0010;\u001a\u000204H&J\u0016\u0010<\u001a\u00020\u00032\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001f0!H&J\u0018\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00182\u0006\u0010@\u001a\u00020AH&J\u0018\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020&2\u0006\u0010D\u001a\u00020\u000bH&J\u0018\u0010E\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH&J\u0018\u0010F\u001a\u00020\u00032\u0006\u0010G\u001a\u00020\u000b2\u0006\u0010H\u001a\u00020\u000bH&¨\u0006I"}, d2 = {"Lcom/stepos/alphame/data/repo/DailyUsageRepository;", "", "addNotificationUsage", "", "notificationUsage", "Lcom/stepos/alphame/data/model/dailyusage/NotificationUsage;", "addScreenUsage", "screenUsage", "Lcom/stepos/alphame/data/model/dailyusage/ScreenUsage;", "clampTodayUsagesToWallClock", "now", "", "clearDailyUsage", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearData", "clearTodayDailyUsage", "deleteDailyUsage", "mode", "", "userId", "(IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "endRunningTimeUsages", "triggerTime", "dailyUsageMessage", "Lcom/stepos/alphame/model/event/DailyUsageMessage;", "getCurrentDailyUsage", "Lcom/stepos/alphame/data/model/dailyusage/DailyUsage;", "getCurrentUserId", "getCurrentUserMode", "getDailyUsageMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getMultiDailyUsageSummary", "", "Lcom/stepos/alphame/data/model/dailyusage/DailyUsageSummary;", "startDate", "endDate", "getRunningTimeUsagesUntilCurrentTime", "Lcom/stepos/alphame/data/model/dailyusage/TimeUsage;", "currentTime", "getTimeRestrictedAppList", "getTimeUsage", Action.KEY_ATTRIBUTE, "getTimeUsageMap", "getTodayTimeRestrictedAppTimeUsages", "Lcom/stepos/alphame/data/model/dailyusage/TimeUsageEntity;", "getTodayUsageSummary", "insertDailyUsage", "dailyRecordEntity", "Lcom/stepos/alphame/data/model/dailyusage/DailyUsageEntity;", "(Lcom/stepos/alphame/data/model/dailyusage/DailyUsageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isInTimeRestrictedAppList", "", AppInfoDbHelper.TAG_U_PACKAGE_NAME, "onInit", "removeTimeUsage", "resetRunningTimeUsages", "restartFutureRunningTimeUsages", "restoreDailyUsage", "saveDailyUsages", "setTimeRestrictedAppList", "dataList", "setTimeUsageWhenRunning", "dailyUsageEvent", "timeUsageType", "Lcom/stepos/alphame/data/model/dailyusage/TimeUsageType;", "setTimeUsageWhenRunningEnd", "endTimeUsage", "endTime", "setUserInfo", "splitRunningTimeUsagesAtJump", "boundaryTime", "restartTime", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DailyUsageRepository {
    void addNotificationUsage(@NotNull NotificationUsage notificationUsage);

    void addScreenUsage(@NotNull ScreenUsage screenUsage);

    void clampTodayUsagesToWallClock(long now);

    @Nullable
    Object clearDailyUsage(@NotNull Continuation<? super Unit> continuation);

    @Nullable
    Object clearData(@NotNull Continuation<? super Unit> continuation);

    void clearTodayDailyUsage();

    @Nullable
    Object deleteDailyUsage(int i4, long j4, @NotNull Continuation<? super Unit> continuation);

    void endRunningTimeUsages(long triggerTime, int mode, long userId, @NotNull DailyUsageMessage dailyUsageMessage);

    @NotNull
    DailyUsage getCurrentDailyUsage();

    long getCurrentUserId();

    int getCurrentUserMode();

    @NotNull
    ConcurrentHashMap<String, DailyUsage> getDailyUsageMap();

    @NotNull
    List<DailyUsageSummary> getMultiDailyUsageSummary(int mode, long userId, long startDate, long endDate);

    @NotNull
    List<TimeUsage> getRunningTimeUsagesUntilCurrentTime(long currentTime);

    @NotNull
    List<String> getTimeRestrictedAppList();

    @Nullable
    TimeUsage getTimeUsage(@NotNull String key);

    @NotNull
    ConcurrentHashMap<String, TimeUsage> getTimeUsageMap();

    @NotNull
    List<TimeUsageEntity> getTodayTimeRestrictedAppTimeUsages(int mode, long userId);

    @Nullable
    DailyUsageSummary getTodayUsageSummary(int mode, long userId);

    @Nullable
    Object insertDailyUsage(@NotNull DailyUsageEntity dailyUsageEntity, @NotNull Continuation<? super Unit> continuation);

    boolean isInTimeRestrictedAppList(@NotNull String packageName);

    void onInit();

    void removeTimeUsage(@NotNull String key);

    void resetRunningTimeUsages(long triggerTime);

    void restartFutureRunningTimeUsages(long now);

    @Nullable
    Object restoreDailyUsage(@NotNull Continuation<? super Boolean> continuation);

    boolean saveDailyUsages();

    void setTimeRestrictedAppList(@NotNull List<String> dataList);

    void setTimeUsageWhenRunning(@NotNull DailyUsageMessage dailyUsageEvent, @NotNull TimeUsageType timeUsageType);

    void setTimeUsageWhenRunningEnd(@NotNull TimeUsage endTimeUsage, long endTime);

    void setUserInfo(int mode, long userId);

    void splitRunningTimeUsagesAtJump(long boundaryTime, long restartTime);
}
