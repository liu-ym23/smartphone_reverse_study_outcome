package com.stepos.ability.database;

import Q3.a;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.database.dao.AbilityDao;
import com.stepos.ability.database.dao.AbilityReportDao;
import com.stepos.ability.database.dao.AbilityTaskDao;
import com.stepos.ability.database.dao.AtomicAbilityDao;
import com.stepos.ability.database.dao.SyncCacheMetaDao;
import com.stepos.ability.database.entity.AbilityEntity;
import com.stepos.ability.database.entity.AbilityReportTaskEntity;
import com.stepos.ability.database.entity.AbilityTaskEntity;
import com.stepos.ability.database.entity.AtomicAbilityEntity;
import com.stepos.ability.database.entity.SyncCacheMetaEntity;
import kotlin.Metadata;

@Database(entities = {AbilityEntity.class, AbilityTaskEntity.class, AbilityReportTaskEntity.class, AtomicAbilityEntity.class, SyncCacheMetaEntity.class}, exportSchema = false, version = 7)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/stepos/ability/database/AppDatabase;", "Landroidx/room/RoomDatabase;", AppAgent.CONSTRUCT, "()V", "Companion", "Q3/a", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AppDatabase extends RoomDatabase {
    public static final a Companion = new a();
    public static final String DB_NAME = "ability.db";
    private static final String TAG = "AppDatabase";
    private static volatile AppDatabase instance;

    public abstract AbilityDao abilityDao();

    public abstract AbilityReportDao abilityReportDao();

    public abstract AbilityTaskDao abilityTaskDao();

    public abstract AtomicAbilityDao atomicAbilityDao();

    public abstract SyncCacheMetaDao syncCacheMetaDao();
}
