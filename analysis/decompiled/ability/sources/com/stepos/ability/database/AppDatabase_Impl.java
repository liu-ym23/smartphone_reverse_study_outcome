package com.stepos.ability.database;

import C7.f;
import Q3.e;
import Z7.d;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.database.AppDatabase_Impl;
import com.stepos.ability.database.dao.AbilityDao;
import com.stepos.ability.database.dao.AbilityDao_Impl;
import com.stepos.ability.database.dao.AbilityReportDao;
import com.stepos.ability.database.dao.AbilityReportDao_Impl;
import com.stepos.ability.database.dao.AbilityTaskDao;
import com.stepos.ability.database.dao.AbilityTaskDao_Impl;
import com.stepos.ability.database.dao.AtomicAbilityDao;
import com.stepos.ability.database.dao.AtomicAbilityDao_Impl;
import com.stepos.ability.database.dao.SyncCacheMetaDao;
import com.stepos.ability.database.dao.SyncCacheMetaDao_Impl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u0003J)\u0010\u000f\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000e0\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\r0\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u001a\u0010\u0015\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\r\u0012\u0004\u0012\u00020\u00120\fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00190(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u001c0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010*R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001f0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010*R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\"0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010*R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020%0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010*¨\u0006/"}, d2 = {"Lcom/stepos/ability/database/AppDatabase_Impl;", "Lcom/stepos/ability/database/AppDatabase;", AppAgent.CONSTRUCT, "()V", "Landroidx/room/RoomOpenDelegate;", "createOpenDelegate", "()Landroidx/room/RoomOpenDelegate;", "Landroidx/room/InvalidationTracker;", "createInvalidationTracker", "()Landroidx/room/InvalidationTracker;", "LC7/r;", "clearAllTables", "", "LZ7/d;", "", "getRequiredTypeConverterClasses", "()Ljava/util/Map;", "", "Landroidx/room/migration/AutoMigrationSpec;", "getRequiredAutoMigrationSpecClasses", "()Ljava/util/Set;", "autoMigrationSpecs", "Landroidx/room/migration/Migration;", "createAutoMigrations", "(Ljava/util/Map;)Ljava/util/List;", "Lcom/stepos/ability/database/dao/AbilityDao;", "abilityDao", "()Lcom/stepos/ability/database/dao/AbilityDao;", "Lcom/stepos/ability/database/dao/AbilityTaskDao;", "abilityTaskDao", "()Lcom/stepos/ability/database/dao/AbilityTaskDao;", "Lcom/stepos/ability/database/dao/AbilityReportDao;", "abilityReportDao", "()Lcom/stepos/ability/database/dao/AbilityReportDao;", "Lcom/stepos/ability/database/dao/AtomicAbilityDao;", "atomicAbilityDao", "()Lcom/stepos/ability/database/dao/AtomicAbilityDao;", "Lcom/stepos/ability/database/dao/SyncCacheMetaDao;", "syncCacheMetaDao", "()Lcom/stepos/ability/database/dao/SyncCacheMetaDao;", "LC7/f;", "_abilityDao", "LC7/f;", "_abilityTaskDao", "_abilityReportDao", "_atomicAbilityDao", "_syncCacheMetaDao", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppDatabase_Impl extends AppDatabase {
    private final f _abilityDao;
    private final f _abilityReportDao;
    private final f _abilityTaskDao;
    private final f _atomicAbilityDao;
    private final f _syncCacheMetaDao;

    public AppDatabase_Impl() {
        final int i = 0;
        this._abilityDao = a.a(new S7.a(this) { // from class: Q3.d
            public final /* synthetic */ AppDatabase_Impl b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i6 = i;
                AppDatabase_Impl appDatabase_Impl = this.b;
                switch (i6) {
                    case 0:
                        return AppDatabase_Impl._abilityDao$lambda$0(appDatabase_Impl);
                    case 1:
                        return AppDatabase_Impl._abilityTaskDao$lambda$0(appDatabase_Impl);
                    case 2:
                        return AppDatabase_Impl._abilityReportDao$lambda$0(appDatabase_Impl);
                    case 3:
                        return AppDatabase_Impl._atomicAbilityDao$lambda$0(appDatabase_Impl);
                    default:
                        return AppDatabase_Impl._syncCacheMetaDao$lambda$0(appDatabase_Impl);
                }
            }
        });
        final int i6 = 1;
        this._abilityTaskDao = a.a(new S7.a(this) { // from class: Q3.d
            public final /* synthetic */ AppDatabase_Impl b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i62 = i6;
                AppDatabase_Impl appDatabase_Impl = this.b;
                switch (i62) {
                    case 0:
                        return AppDatabase_Impl._abilityDao$lambda$0(appDatabase_Impl);
                    case 1:
                        return AppDatabase_Impl._abilityTaskDao$lambda$0(appDatabase_Impl);
                    case 2:
                        return AppDatabase_Impl._abilityReportDao$lambda$0(appDatabase_Impl);
                    case 3:
                        return AppDatabase_Impl._atomicAbilityDao$lambda$0(appDatabase_Impl);
                    default:
                        return AppDatabase_Impl._syncCacheMetaDao$lambda$0(appDatabase_Impl);
                }
            }
        });
        final int i10 = 2;
        this._abilityReportDao = a.a(new S7.a(this) { // from class: Q3.d
            public final /* synthetic */ AppDatabase_Impl b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i62 = i10;
                AppDatabase_Impl appDatabase_Impl = this.b;
                switch (i62) {
                    case 0:
                        return AppDatabase_Impl._abilityDao$lambda$0(appDatabase_Impl);
                    case 1:
                        return AppDatabase_Impl._abilityTaskDao$lambda$0(appDatabase_Impl);
                    case 2:
                        return AppDatabase_Impl._abilityReportDao$lambda$0(appDatabase_Impl);
                    case 3:
                        return AppDatabase_Impl._atomicAbilityDao$lambda$0(appDatabase_Impl);
                    default:
                        return AppDatabase_Impl._syncCacheMetaDao$lambda$0(appDatabase_Impl);
                }
            }
        });
        final int i11 = 3;
        this._atomicAbilityDao = a.a(new S7.a(this) { // from class: Q3.d
            public final /* synthetic */ AppDatabase_Impl b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i62 = i11;
                AppDatabase_Impl appDatabase_Impl = this.b;
                switch (i62) {
                    case 0:
                        return AppDatabase_Impl._abilityDao$lambda$0(appDatabase_Impl);
                    case 1:
                        return AppDatabase_Impl._abilityTaskDao$lambda$0(appDatabase_Impl);
                    case 2:
                        return AppDatabase_Impl._abilityReportDao$lambda$0(appDatabase_Impl);
                    case 3:
                        return AppDatabase_Impl._atomicAbilityDao$lambda$0(appDatabase_Impl);
                    default:
                        return AppDatabase_Impl._syncCacheMetaDao$lambda$0(appDatabase_Impl);
                }
            }
        });
        final int i12 = 4;
        this._syncCacheMetaDao = a.a(new S7.a(this) { // from class: Q3.d
            public final /* synthetic */ AppDatabase_Impl b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i62 = i12;
                AppDatabase_Impl appDatabase_Impl = this.b;
                switch (i62) {
                    case 0:
                        return AppDatabase_Impl._abilityDao$lambda$0(appDatabase_Impl);
                    case 1:
                        return AppDatabase_Impl._abilityTaskDao$lambda$0(appDatabase_Impl);
                    case 2:
                        return AppDatabase_Impl._abilityReportDao$lambda$0(appDatabase_Impl);
                    case 3:
                        return AppDatabase_Impl._atomicAbilityDao$lambda$0(appDatabase_Impl);
                    default:
                        return AppDatabase_Impl._syncCacheMetaDao$lambda$0(appDatabase_Impl);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbilityDao_Impl _abilityDao$lambda$0(AppDatabase_Impl appDatabase_Impl) {
        return new AbilityDao_Impl(appDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbilityReportDao_Impl _abilityReportDao$lambda$0(AppDatabase_Impl appDatabase_Impl) {
        return new AbilityReportDao_Impl(appDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbilityTaskDao_Impl _abilityTaskDao$lambda$0(AppDatabase_Impl appDatabase_Impl) {
        return new AbilityTaskDao_Impl(appDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AtomicAbilityDao_Impl _atomicAbilityDao$lambda$0(AppDatabase_Impl appDatabase_Impl) {
        return new AtomicAbilityDao_Impl(appDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SyncCacheMetaDao_Impl _syncCacheMetaDao$lambda$0(AppDatabase_Impl appDatabase_Impl) {
        return new SyncCacheMetaDao_Impl(appDatabase_Impl);
    }

    @Override // com.stepos.ability.database.AppDatabase
    public AbilityDao abilityDao() {
        return (AbilityDao) this._abilityDao.getF4884a();
    }

    @Override // com.stepos.ability.database.AppDatabase
    public AbilityReportDao abilityReportDao() {
        return (AbilityReportDao) this._abilityReportDao.getF4884a();
    }

    @Override // com.stepos.ability.database.AppDatabase
    public AbilityTaskDao abilityTaskDao() {
        return (AbilityTaskDao) this._abilityTaskDao.getF4884a();
    }

    @Override // com.stepos.ability.database.AppDatabase
    public AtomicAbilityDao atomicAbilityDao() {
        return (AtomicAbilityDao) this._atomicAbilityDao.getF4884a();
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        performClear(false, "t_ability", "t_ability_task", "t_ability_report_task", "t_atomic_ability", "t_sync_cache_meta");
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> createAutoMigrations(Map<d, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        k.f(autoMigrationSpecs, "autoMigrationSpecs");
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "t_ability", "t_ability_task", "t_ability_report_task", "t_atomic_ability", "t_sync_cache_meta");
    }

    @Override // androidx.room.RoomDatabase
    public Set<d> getRequiredAutoMigrationSpecClasses() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<d, List<d>> getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        n nVar = m.f4928a;
        d dVarB = nVar.b(AbilityDao.class);
        AbilityDao_Impl.Companion.getClass();
        EmptyList emptyList = EmptyList.f4893a;
        linkedHashMap.put(dVarB, emptyList);
        d dVarB2 = nVar.b(AbilityTaskDao.class);
        AbilityTaskDao_Impl.Companion.getClass();
        linkedHashMap.put(dVarB2, emptyList);
        d dVarB3 = nVar.b(AbilityReportDao.class);
        AbilityReportDao_Impl.Companion.getClass();
        linkedHashMap.put(dVarB3, emptyList);
        d dVarB4 = nVar.b(AtomicAbilityDao.class);
        AtomicAbilityDao_Impl.Companion.getClass();
        linkedHashMap.put(dVarB4, emptyList);
        d dVarB5 = nVar.b(SyncCacheMetaDao.class);
        SyncCacheMetaDao_Impl.Companion.getClass();
        linkedHashMap.put(dVarB5, emptyList);
        return linkedHashMap;
    }

    @Override // com.stepos.ability.database.AppDatabase
    public SyncCacheMetaDao syncCacheMetaDao() {
        return (SyncCacheMetaDao) this._syncCacheMetaDao.getF4884a();
    }

    @Override // androidx.room.RoomDatabase
    public RoomOpenDelegate createOpenDelegate() {
        return new e(this);
    }
}
