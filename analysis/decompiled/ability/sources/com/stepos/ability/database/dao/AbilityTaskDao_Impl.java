package com.stepos.ability.database.dao;

import Ba.f;
import C7.r;
import H7.c;
import R3.b;
import R3.d;
import R3.i;
import R3.j;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.ability.commoninternal.Key;
import com.stepos.ability.database.entity.AbilityTaskEntity;
import com.stepos.taskrobot.llmapi.stepfun.InjectExperienceResult;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.k;
import stepai.aios.guiagent.config.GuiAgentConfigKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0096@¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0096@¢\u0006\u0004\b\f\u0010\rJ(\u0010\u0012\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000eH\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u0014\u0010\rJ\u0010\u0010\u0015\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u0015\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u001a\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00060\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001c"}, d2 = {"Lcom/stepos/ability/database/dao/AbilityTaskDao_Impl;", "Lcom/stepos/ability/database/dao/AbilityTaskDao;", "Landroidx/room/RoomDatabase;", "__db", AppAgent.CONSTRUCT, "(Landroidx/room/RoomDatabase;)V", "Lcom/stepos/ability/database/entity/AbilityTaskEntity;", "task", "LC7/r;", "insert", "(Lcom/stepos/ability/database/entity/AbilityTaskEntity;LH7/c;)Ljava/lang/Object;", "", "loadUnfinishedTasks", "(LH7/c;)Ljava/lang/Object;", "", "taskCode", "newStatus", "originStatus", "updateStatus", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "cleanFinished", "cleanAll", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfAbilityTaskEntity", "Landroidx/room/EntityInsertAdapter;", "Companion", "R3/j", "database_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AbilityTaskDao_Impl implements AbilityTaskDao {
    public static final j Companion = new j();
    private final RoomDatabase __db;
    private final EntityInsertAdapter<AbilityTaskEntity> __insertAdapterOfAbilityTaskEntity;

    public AbilityTaskDao_Impl(RoomDatabase __db) {
        k.f(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfAbilityTaskEntity = new d(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r cleanAll$lambda$0(String str, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return r.f317a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r cleanFinished$lambda$0(String str, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return r.f317a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r insert$lambda$0(AbilityTaskDao_Impl abilityTaskDao_Impl, AbilityTaskEntity abilityTaskEntity, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        abilityTaskDao_Impl.__insertAdapterOfAbilityTaskEntity.insert(_connection, (SQLiteConnection) abilityTaskEntity);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List loadUnfinishedTasks$lambda$0(String str, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "taskCode");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "abilityId");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "pkgName");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "paramsJson");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "extra");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "status");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "retryCount");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "priority");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createTime");
            int columnIndexOrThrow12 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "is_cloud_ability");
            int columnIndexOrThrow13 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, Key.KEY_TRACE_ID);
            int columnIndexOrThrow14 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, GuiAgentConfigKt.META_KEY_TOOL_CALL_ID);
            int columnIndexOrThrow15 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, InjectExperienceResult.REASON_TIMEOUT);
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                long j5 = sQLiteStatementPrepare.getLong(columnIndexOrThrow);
                String text = sQLiteStatementPrepare.getText(columnIndexOrThrow2);
                int i = columnIndexOrThrow2;
                int i6 = columnIndexOrThrow3;
                int i10 = columnIndexOrThrow15;
                int i11 = columnIndexOrThrow4;
                arrayList.add(new AbilityTaskEntity(j5, text, sQLiteStatementPrepare.isNull(columnIndexOrThrow3) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow3)), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.getText(columnIndexOrThrow8), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow9), (int) sQLiteStatementPrepare.getLong(columnIndexOrThrow10), sQLiteStatementPrepare.getLong(columnIndexOrThrow11), ((int) sQLiteStatementPrepare.getLong(columnIndexOrThrow12)) != 0, sQLiteStatementPrepare.getText(columnIndexOrThrow13), sQLiteStatementPrepare.getText(columnIndexOrThrow14), (int) sQLiteStatementPrepare.getLong(i10)));
                columnIndexOrThrow4 = i11;
                columnIndexOrThrow15 = i10;
                columnIndexOrThrow3 = i6;
                columnIndexOrThrow2 = i;
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r updateStatus$lambda$0(String str, String str2, String str3, String str4, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            sQLiteStatementPrepare.mo7172bindText(2, str3);
            sQLiteStatementPrepare.mo7172bindText(3, str4);
            sQLiteStatementPrepare.step();
            sQLiteStatementPrepare.close();
            return r.f317a;
        } catch (Throwable th) {
            sQLiteStatementPrepare.close();
            throw th;
        }
    }

    @Override // com.stepos.ability.database.dao.AbilityTaskDao
    public Object cleanAll(c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new f(20), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }

    @Override // com.stepos.ability.database.dao.AbilityTaskDao
    public Object cleanFinished(c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new f(22), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }

    @Override // com.stepos.ability.database.dao.AbilityTaskDao
    public Object insert(AbilityTaskEntity abilityTaskEntity, c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new b(3, this, abilityTaskEntity), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }

    @Override // com.stepos.ability.database.dao.AbilityTaskDao
    public Object loadUnfinishedTasks(c<? super List<AbilityTaskEntity>> cVar) {
        return DBUtil.performSuspending(this.__db, true, false, new f(21), cVar);
    }

    @Override // com.stepos.ability.database.dao.AbilityTaskDao
    public Object updateStatus(String str, String str2, String str3, c<? super r> cVar) {
        Object objPerformSuspending = DBUtil.performSuspending(this.__db, false, true, new i(str2, str, str3, 0), cVar);
        return objPerformSuspending == CoroutineSingletons.f4909a ? objPerformSuspending : r.f317a;
    }
}
