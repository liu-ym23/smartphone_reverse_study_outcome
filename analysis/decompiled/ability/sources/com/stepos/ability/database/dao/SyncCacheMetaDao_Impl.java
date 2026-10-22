package com.stepos.ability.database.dao;

import C7.r;
import H7.c;
import R3.b;
import R3.d;
import R3.n;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.database.entity.SyncCacheMetaEntity;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/stepos/ability/database/dao/SyncCacheMetaDao_Impl;", "Lcom/stepos/ability/database/dao/SyncCacheMetaDao;", "Landroidx/room/RoomDatabase;", "__db", AppAgent.CONSTRUCT, "(Landroidx/room/RoomDatabase;)V", "Lcom/stepos/ability/database/entity/SyncCacheMetaEntity;", "entity", "LC7/r;", "insertOrReplace", "(Lcom/stepos/ability/database/entity/SyncCacheMetaEntity;LH7/c;)Ljava/lang/Object;", "", "id", "getById", "(ILH7/c;)Ljava/lang/Object;", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfSyncCacheMetaEntity", "Landroidx/room/EntityInsertAdapter;", "Companion", "R3/n", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SyncCacheMetaDao_Impl implements SyncCacheMetaDao {
    public static final n Companion = new n();
    private final RoomDatabase __db;
    private final EntityInsertAdapter<SyncCacheMetaEntity> __insertAdapterOfSyncCacheMetaEntity;

    public SyncCacheMetaDao_Impl(RoomDatabase __db) {
        k.f(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfSyncCacheMetaEntity = new d(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SyncCacheMetaEntity getById$lambda$0(String str, int i, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7170bindLong(1, i);
            return sQLiteStatementPrepare.step() ? new SyncCacheMetaEntity((int) sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id")), sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "localScanGeneration")), sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "cloudSyncGeneration")), sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "localScanCompletedAt")), sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "cloudSyncCompletedAt")), sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "uploadLastSuccessAt")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "deviceId"))) : null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r insertOrReplace$lambda$0(SyncCacheMetaDao_Impl syncCacheMetaDao_Impl, SyncCacheMetaEntity syncCacheMetaEntity, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        syncCacheMetaDao_Impl.__insertAdapterOfSyncCacheMetaEntity.insert(_connection, (SQLiteConnection) syncCacheMetaEntity);
        return r.f317a;
    }

    @Override // com.stepos.ability.database.dao.SyncCacheMetaDao
    public Object getById(int i, c<? super SyncCacheMetaEntity> cVar) {
        return DBUtil.performSuspending(this.__db, true, false, new D6.d(i, 5), cVar);
    }

    @Override // com.stepos.ability.database.dao.SyncCacheMetaDao
    public Object insertOrReplace(SyncCacheMetaEntity syncCacheMetaEntity, c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new b(7, this, syncCacheMetaEntity), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }
}
