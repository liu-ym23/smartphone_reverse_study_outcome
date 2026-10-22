package com.stepos.alphame.data.local.database.dailyusage;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.stepos.alphame.data.model.dailyusage.DailyUsageEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Dao
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H§@¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H§@¢\u0006\u0002\u0010\bJ\u0016\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH§@¢\u0006\u0002\u0010\fJ\"\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH'J \u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH'J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00112\u0006\u0010\u000f\u001a\u00020\u000bH'J(\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH'J0\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00112\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH'J\u0016\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u000eH§@¢\u0006\u0002\u0010\u0019J\u0016\u0010\u001a\u001a\u00020\u00072\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0011H'¨\u0006\u001c"}, d2 = {"Lcom/stepos/alphame/data/local/database/dailyusage/DailyUsageDao;", "", "clearDailyUsage", "", "mode", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteDailyUsage", "userId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDailyUsage", "Lcom/stepos/alphame/data/model/dailyusage/DailyUsageEntity;", "date", "getDailyUsages", "", "startDate", "endDate", "getDailyUsagesByDate", "getDailyUsagesByMode", "getUserDailyUsages", "insertDailyUsage", "dailyUsageEntity", "(Lcom/stepos/alphame/data/model/dailyusage/DailyUsageEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertDailyUsages", "dailyUsageEntities", "data_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface DailyUsageDao {
    @Query("DELETE FROM daily_usage WHERE mode = :mode")
    @Nullable
    Object clearDailyUsage(int i4, @NotNull Continuation<? super Integer> continuation);

    @Query("DELETE FROM daily_usage")
    @Nullable
    Object clearData(@NotNull Continuation<? super Unit> continuation);

    @Query("DELETE FROM daily_usage WHERE user_id = :userId")
    @Nullable
    Object deleteDailyUsage(long j4, @NotNull Continuation<? super Integer> continuation);

    @Query("SELECT * FROM daily_usage WHERE date =:date AND mode = :mode AND user_id = :userId")
    @Nullable
    DailyUsageEntity getDailyUsage(long date, int mode, long userId);

    @Query("SELECT * FROM daily_usage WHERE date >= :startDate AND date < :endDate ORDER BY date ASC")
    @Nullable
    List<DailyUsageEntity> getDailyUsages(long startDate, long endDate);

    @Query("SELECT * FROM daily_usage WHERE date = :date")
    @NotNull
    List<DailyUsageEntity> getDailyUsagesByDate(long date);

    @Query("SELECT * FROM daily_usage WHERE mode =:mode AND date >= :startDate AND date < :endDate ORDER BY date ASC")
    @Nullable
    List<DailyUsageEntity> getDailyUsagesByMode(int mode, long startDate, long endDate);

    @Query("SELECT * FROM daily_usage WHERE date >= :startDate AND date <= :endDate AND mode = :mode AND user_id = :userId ORDER BY date ASC")
    @Nullable
    List<DailyUsageEntity> getUserDailyUsages(int mode, long userId, long startDate, long endDate);

    @Insert(onConflict = 1)
    @Nullable
    Object insertDailyUsage(@NotNull DailyUsageEntity dailyUsageEntity, @NotNull Continuation<? super Unit> continuation);

    @Insert(onConflict = 1)
    void insertDailyUsages(@NotNull List<DailyUsageEntity> dailyUsageEntities);
}
