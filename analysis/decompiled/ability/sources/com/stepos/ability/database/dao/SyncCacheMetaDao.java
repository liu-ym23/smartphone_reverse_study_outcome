package com.stepos.ability.database.dao;

import C7.r;
import H7.c;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import com.stepos.ability.database.entity.SyncCacheMetaEntity;
import kotlin.Metadata;

@Dao
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H§@¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H§@¢\u0006\u0004\b\t\u0010\n¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ability/database/dao/SyncCacheMetaDao;", "", "", "id", "Lcom/stepos/ability/database/entity/SyncCacheMetaEntity;", "getById", "(ILH7/c;)Ljava/lang/Object;", "entity", "LC7/r;", "insertOrReplace", "(Lcom/stepos/ability/database/entity/SyncCacheMetaEntity;LH7/c;)Ljava/lang/Object;", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SyncCacheMetaDao {
    static /* synthetic */ Object getById$default(SyncCacheMetaDao syncCacheMetaDao, int i, c cVar, int i6, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getById");
        }
        if ((i6 & 1) != 0) {
            i = 1;
        }
        return syncCacheMetaDao.getById(i, cVar);
    }

    @Query("SELECT * FROM t_sync_cache_meta WHERE id = :id LIMIT 1")
    Object getById(int i, c<? super SyncCacheMetaEntity> cVar);

    @Insert(onConflict = 1)
    Object insertOrReplace(SyncCacheMetaEntity syncCacheMetaEntity, c<? super r> cVar);
}
