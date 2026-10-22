package com.stepos.ability.database.dao;

import C7.r;
import H7.c;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.stepos.ability.database.entity.AbilityReportTaskEntity;
import java.util.List;
import kotlin.Metadata;

@Dao
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0007H§@¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH§@¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H§@¢\u0006\u0004\b\u0013\u0010\u000b¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lcom/stepos/ability/database/dao/AbilityReportDao;", "", "Lcom/stepos/ability/database/entity/AbilityReportTaskEntity;", "task", "LC7/r;", "insert", "(Lcom/stepos/ability/database/entity/AbilityReportTaskEntity;LH7/c;)Ljava/lang/Object;", "", "maxRetry", "", "getPendingTasksOrdered", "(ILH7/c;)Ljava/lang/Object;", "", "id", "status", "updateStatus", "(JILH7/c;)Ljava/lang/Object;", "increaseRetryCount", "(JLH7/c;)Ljava/lang/Object;", "clearExpiredTasks", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AbilityReportDao {
    @Query("DELETE FROM t_ability_report_task WHERE status != 0 AND retryCount >= :maxRetry")
    Object clearExpiredTasks(int i, c<? super r> cVar);

    @Query("SELECT * FROM t_ability_report_task WHERE status = 0 AND retryCount < :maxRetry ORDER BY id ASC")
    Object getPendingTasksOrdered(int i, c<? super List<AbilityReportTaskEntity>> cVar);

    @Query("UPDATE t_ability_report_task SET retryCount = retryCount + 1 WHERE id = :id")
    Object increaseRetryCount(long j5, c<? super r> cVar);

    @Insert(onConflict = 1)
    Object insert(AbilityReportTaskEntity abilityReportTaskEntity, c<? super r> cVar);

    @Query("UPDATE t_ability_report_task SET status = :status WHERE id = :id")
    Object updateStatus(long j5, int i, c<? super r> cVar);
}
