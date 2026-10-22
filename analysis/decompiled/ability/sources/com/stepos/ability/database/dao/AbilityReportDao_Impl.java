package com.stepos.ability.database.dao;

import C7.r;
import H7.c;
import R3.b;
import R3.d;
import R3.f;
import R3.h;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.database.dao.AbilityReportDao_Impl;
import com.stepos.ability.database.entity.AbilityReportTaskEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\r2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0096@¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0096@¢\u0006\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001e"}, d2 = {"Lcom/stepos/ability/database/dao/AbilityReportDao_Impl;", "Lcom/stepos/ability/database/dao/AbilityReportDao;", "Landroidx/room/RoomDatabase;", "__db", AppAgent.CONSTRUCT, "(Landroidx/room/RoomDatabase;)V", "Lcom/stepos/ability/database/entity/AbilityReportTaskEntity;", "task", "LC7/r;", "insert", "(Lcom/stepos/ability/database/entity/AbilityReportTaskEntity;LH7/c;)Ljava/lang/Object;", "", "maxRetry", "", "getPendingTasksOrdered", "(ILH7/c;)Ljava/lang/Object;", "", "id", "status", "updateStatus", "(JILH7/c;)Ljava/lang/Object;", "increaseRetryCount", "(JLH7/c;)Ljava/lang/Object;", "clearExpiredTasks", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfAbilityReportTaskEntity", "Landroidx/room/EntityInsertAdapter;", "Companion", "R3/h", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityReportDao_Impl implements AbilityReportDao {
    public static final h Companion = new h();
    private final RoomDatabase __db;
    private final EntityInsertAdapter<AbilityReportTaskEntity> __insertAdapterOfAbilityReportTaskEntity;

    public AbilityReportDao_Impl(RoomDatabase __db) {
        k.f(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfAbilityReportTaskEntity = new d(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r clearExpiredTasks$lambda$0(String str, int i, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7170bindLong(1, i);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return r.f317a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List getPendingTasksOrdered$lambda$0(String str, int i, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7170bindLong(1, i);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "timestamp");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "taskCode");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "packageName");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "installType");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "payload");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "status");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "retryCount");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                int i6 = columnIndexOrThrow2;
                int i10 = columnIndexOrThrow3;
                arrayList.add(new AbilityReportTaskEntity(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getLong(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.getText(columnIndexOrThrow6), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow7), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow8)));
                columnIndexOrThrow2 = i6;
                columnIndexOrThrow3 = i10;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r increaseRetryCount$lambda$0(String str, long j5, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7170bindLong(1, j5);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return r.f317a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r insert$lambda$0(AbilityReportDao_Impl abilityReportDao_Impl, AbilityReportTaskEntity abilityReportTaskEntity, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        abilityReportDao_Impl.__insertAdapterOfAbilityReportTaskEntity.insert(_connection, (SQLiteConnection) abilityReportTaskEntity);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r updateStatus$lambda$0(String str, int i, long j5, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7170bindLong(1, i);
            sQLiteStatementPrepare.mo7170bindLong(2, j5);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return r.f317a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.stepos.ability.database.dao.AbilityReportDao
    public Object clearExpiredTasks(int i, c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new D6.d(i, 3), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }

    @Override // com.stepos.ability.database.dao.AbilityReportDao
    public Object getPendingTasksOrdered(int i, c<? super List<AbilityReportTaskEntity>> cVar) {
        return DBUtil.performSuspending(this.__db, true, false, new D6.d(i, 2), cVar);
    }

    @Override // com.stepos.ability.database.dao.AbilityReportDao
    public Object increaseRetryCount(long j5, c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new f(j5, 0), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }

    @Override // com.stepos.ability.database.dao.AbilityReportDao
    public Object insert(AbilityReportTaskEntity abilityReportTaskEntity, c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new b(2, this, abilityReportTaskEntity), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }

    @Override // com.stepos.ability.database.dao.AbilityReportDao
    public Object updateStatus(final long j5, final int i, c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new S7.k() { // from class: R3.g
            @Override // S7.k
            public final Object invoke(Object obj) {
                return AbilityReportDao_Impl.updateStatus$lambda$0("UPDATE t_ability_report_task SET status = ? WHERE id = ?", i, j5, (SQLiteConnection) obj);
            }
        }, cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }
}
