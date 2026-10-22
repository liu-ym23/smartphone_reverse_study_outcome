package com.stepos.ability.database.dao;

import C7.r;
import H7.c;
import R3.a;
import R3.b;
import R3.d;
import R3.e;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.database.entity.AbilityEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\r\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0096@¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b\u0017\u0010\u0018J0\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b\u001b\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/stepos/ability/database/dao/AbilityDao_Impl;", "Lcom/stepos/ability/database/dao/AbilityDao;", "Landroidx/room/RoomDatabase;", "__db", AppAgent.CONSTRUCT, "(Landroidx/room/RoomDatabase;)V", "Lcom/stepos/ability/database/entity/AbilityEntity;", "entity", "LC7/r;", "insertOrUpdate", "(Lcom/stepos/ability/database/entity/AbilityEntity;LH7/c;)Ljava/lang/Object;", "", "entities", "batchInsertOrUpdate", "(Ljava/util/List;LH7/c;)Ljava/lang/Object;", "", "pkgName", "getAbilityByPackageName", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "originStatus", "newStatus", "", "updateTime", "updateStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLH7/c;)Ljava/lang/Object;", "originSyncStatus", "newSyncStatus", "updateSyncStatus", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfAbilityEntity", "Landroidx/room/EntityInsertAdapter;", "Companion", "R3/e", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityDao_Impl implements AbilityDao {
    public static final e Companion = new e();
    private final RoomDatabase __db;
    private final EntityInsertAdapter<AbilityEntity> __insertAdapterOfAbilityEntity;

    public AbilityDao_Impl(RoomDatabase __db) {
        k.f(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfAbilityEntity = new d(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r batchInsertOrUpdate$lambda$0(AbilityDao_Impl abilityDao_Impl, List list, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        abilityDao_Impl.__insertAdapterOfAbilityEntity.insert(_connection, list);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbilityEntity getAbilityByPackageName$lambda$0(String str, String str2, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            return sQLiteStatementPrepare.step() ? new AbilityEntity(sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "packageName")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "version")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "status")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "icon")), sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "updateTime")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "syncStatus")), sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "syncTime")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "tools"))) : null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r insertOrUpdate$lambda$0(AbilityDao_Impl abilityDao_Impl, AbilityEntity abilityEntity, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        abilityDao_Impl.__insertAdapterOfAbilityEntity.insert(_connection, (SQLiteConnection) abilityEntity);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r updateStatus$lambda$0(String str, String str2, long j5, String str3, String str4, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            sQLiteStatementPrepare.mo7170bindLong(2, j5);
            sQLiteStatementPrepare.mo7172bindText(3, str3);
            sQLiteStatementPrepare.mo7172bindText(4, str4);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return r.f317a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r updateSyncStatus$lambda$0(String str, String str2, long j5, String str3, String str4, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            sQLiteStatementPrepare.mo7170bindLong(2, j5);
            sQLiteStatementPrepare.mo7172bindText(3, str3);
            sQLiteStatementPrepare.mo7172bindText(4, str4);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return r.f317a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.stepos.ability.database.dao.AbilityDao
    public Object batchInsertOrUpdate(List<AbilityEntity> list, c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new b(1, this, list), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }

    @Override // com.stepos.ability.database.dao.AbilityDao
    public Object getAbilityByPackageName(String str, c<? super AbilityEntity> cVar) {
        return DBUtil.performSuspending(this.__db, true, false, new R3.c(str, 0), cVar);
    }

    @Override // com.stepos.ability.database.dao.AbilityDao
    public Object insertOrUpdate(AbilityEntity abilityEntity, c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new b(0, this, abilityEntity), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }

    @Override // com.stepos.ability.database.dao.AbilityDao
    public Object updateStatus(String str, String str2, String str3, long j5, c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new a(str3, 1, str, str2, j5), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }

    @Override // com.stepos.ability.database.dao.AbilityDao
    public Object updateSyncStatus(String str, String str2, String str3, long j5, c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new a(str3, 0, str, str2, j5), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }
}
