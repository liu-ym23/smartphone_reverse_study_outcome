package com.stepos.ability.database.dao;

import C7.r;
import H7.c;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.stepos.ability.database.entity.AbilityEntity;
import java.util.List;
import kotlin.Metadata;

@Dao
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H§@¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH§@¢\u0006\u0004\b\r\u0010\u000eJ2\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H§@¢\u0006\u0004\b\u0013\u0010\u0014J2\u0010\u0017\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H§@¢\u0006\u0004\b\u0017\u0010\u0014¨\u0006\u0018À\u0006\u0003"}, d2 = {"Lcom/stepos/ability/database/dao/AbilityDao;", "", "Lcom/stepos/ability/database/entity/AbilityEntity;", "entity", "LC7/r;", "insertOrUpdate", "(Lcom/stepos/ability/database/entity/AbilityEntity;LH7/c;)Ljava/lang/Object;", "", "entities", "batchInsertOrUpdate", "(Ljava/util/List;LH7/c;)Ljava/lang/Object;", "", "pkgName", "getAbilityByPackageName", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "originStatus", "newStatus", "", "updateTime", "updateStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLH7/c;)Ljava/lang/Object;", "originSyncStatus", "newSyncStatus", "updateSyncStatus", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface AbilityDao {
    static /* synthetic */ Object updateStatus$default(AbilityDao abilityDao, String str, String str2, String str3, long j5, c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateStatus");
        }
        if ((i & 8) != 0) {
            j5 = System.currentTimeMillis();
        }
        return abilityDao.updateStatus(str, str2, str3, j5, cVar);
    }

    static /* synthetic */ Object updateSyncStatus$default(AbilityDao abilityDao, String str, String str2, String str3, long j5, c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateSyncStatus");
        }
        if ((i & 8) != 0) {
            j5 = System.currentTimeMillis();
        }
        return abilityDao.updateSyncStatus(str, str2, str3, j5, cVar);
    }

    @Insert(onConflict = 1)
    Object batchInsertOrUpdate(List<AbilityEntity> list, c<? super r> cVar);

    @Query("SELECT * FROM t_ability WHERE packageName = :pkgName LIMIT 1")
    Object getAbilityByPackageName(String str, c<? super AbilityEntity> cVar);

    @Insert(onConflict = 1)
    Object insertOrUpdate(AbilityEntity abilityEntity, c<? super r> cVar);

    @Query("UPDATE t_ability SET status = :newStatus, updateTime = :updateTime WHERE packageName = :pkgName AND status = :originStatus ")
    Object updateStatus(String str, String str2, String str3, long j5, c<? super r> cVar);

    @Query("UPDATE t_ability SET syncStatus = :newSyncStatus, updateTime = :updateTime WHERE packageName = :pkgName AND syncStatus = :originSyncStatus ")
    Object updateSyncStatus(String str, String str2, String str3, long j5, c<? super r> cVar);
}
