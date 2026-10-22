package com.stepos.ability.database.dao;

import C7.r;
import H7.c;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.stepos.ability.database.entity.AbilityTaskEntity;
import java.util.List;
import kotlin.Metadata;

@Dao
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J(\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H§@¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rH§@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0004H§@¢\u0006\u0004\b\u0011\u0010\u000f¨\u0006\u0012À\u0006\u0003"}, d2 = {"Lcom/stepos/ability/database/dao/AbilityTaskDao;", "", "Lcom/stepos/ability/database/entity/AbilityTaskEntity;", "task", "LC7/r;", "insert", "(Lcom/stepos/ability/database/entity/AbilityTaskEntity;LH7/c;)Ljava/lang/Object;", "", "taskCode", "newStatus", "originStatus", "updateStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "", "loadUnfinishedTasks", "(LH7/c;)Ljava/lang/Object;", "cleanFinished", "cleanAll", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AbilityTaskDao {
    @Query("DELETE FROM t_ability_task")
    Object cleanAll(c<? super r> cVar);

    @Query("DELETE FROM t_ability_task WHERE status IN ('success','failed')")
    Object cleanFinished(c<? super r> cVar);

    @Insert(onConflict = 1)
    Object insert(AbilityTaskEntity abilityTaskEntity, c<? super r> cVar);

    @Query("SELECT * FROM t_ability_task WHERE status IN ('pending','running')")
    Object loadUnfinishedTasks(c<? super List<AbilityTaskEntity>> cVar);

    @Query("UPDATE t_ability_task SET status = :newStatus WHERE taskCode = :taskCode AND status=:originStatus")
    Object updateStatus(String str, String str2, String str3, c<? super r> cVar);
}
