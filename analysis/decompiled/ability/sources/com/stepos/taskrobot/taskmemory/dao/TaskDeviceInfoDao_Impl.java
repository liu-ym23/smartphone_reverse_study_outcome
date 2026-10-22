package com.stepos.taskrobot.taskmemory.dao;

import C7.r;
import R3.d;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.taskrobot.taskmemory.entity.TaskDeviceInfoEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import t5.C2016a;
import t6.c;
import t6.e;
import t6.f;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\u00020\u0001:\u0001 B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001d¨\u0006!"}, d2 = {"Lcom/stepos/taskrobot/taskmemory/dao/TaskDeviceInfoDao_Impl;", "Lcom/stepos/taskrobot/taskmemory/dao/TaskDeviceInfoDao;", "Landroidx/room/RoomDatabase;", "__db", AppAgent.CONSTRUCT, "(Landroidx/room/RoomDatabase;)V", "Lcom/stepos/taskrobot/taskmemory/entity/TaskDeviceInfoEntity;", "info", "", "insert", "(Lcom/stepos/taskrobot/taskmemory/entity/TaskDeviceInfoEntity;)J", "LC7/r;", "delete", "(Lcom/stepos/taskrobot/taskmemory/entity/TaskDeviceInfoEntity;)V", "update", "", "getAll", "()Ljava/util/List;", "id", "getById", "(J)Lcom/stepos/taskrobot/taskmemory/entity/TaskDeviceInfoEntity;", "deleteById", "(J)V", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfTaskDeviceInfoEntity", "Landroidx/room/EntityInsertAdapter;", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__deleteAdapterOfTaskDeviceInfoEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfTaskDeviceInfoEntity", "Companion", "t6/f", "taskmemory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskDeviceInfoDao_Impl implements TaskDeviceInfoDao {
    public static final f Companion = new f();
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<TaskDeviceInfoEntity> __deleteAdapterOfTaskDeviceInfoEntity;
    private final EntityInsertAdapter<TaskDeviceInfoEntity> __insertAdapterOfTaskDeviceInfoEntity;
    private final EntityDeleteOrUpdateAdapter<TaskDeviceInfoEntity> __updateAdapterOfTaskDeviceInfoEntity;

    public TaskDeviceInfoDao_Impl(RoomDatabase __db) {
        k.f(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfTaskDeviceInfoEntity = new d(6);
        this.__deleteAdapterOfTaskDeviceInfoEntity = new c(2);
        this.__updateAdapterOfTaskDeviceInfoEntity = new c(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r delete$lambda$0(TaskDeviceInfoDao_Impl taskDeviceInfoDao_Impl, TaskDeviceInfoEntity taskDeviceInfoEntity, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        taskDeviceInfoDao_Impl.__deleteAdapterOfTaskDeviceInfoEntity.handle(_connection, taskDeviceInfoEntity);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r deleteById$lambda$0(String str, long j5, SQLiteConnection _connection) {
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
    public static final List getAll$lambda$0(String str, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "brand");
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "userId");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "deviceId");
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, AlgorithmUpdateBundle.KEY_SUFFIX_MODEL);
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "product");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "osVersion");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "resolution");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "density");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createTime");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new TaskDeviceInfoEntity(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getText(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.getText(columnIndexOrThrow8), (float) sQLiteStatementPrepare.getDouble(columnIndexOrThrow9), sQLiteStatementPrepare.getLong(columnIndexOrThrow10)));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TaskDeviceInfoEntity getById$lambda$0(String str, long j5, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7170bindLong(1, j5);
            return sQLiteStatementPrepare.step() ? new TaskDeviceInfoEntity(sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "brand")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "userId")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "deviceId")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, AlgorithmUpdateBundle.KEY_SUFFIX_MODEL)), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "product")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "osVersion")), sQLiteStatementPrepare.getText(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "resolution")), (float) sQLiteStatementPrepare.getDouble(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "density")), sQLiteStatementPrepare.getLong(SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createTime"))) : null;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insert$lambda$0(TaskDeviceInfoDao_Impl taskDeviceInfoDao_Impl, TaskDeviceInfoEntity taskDeviceInfoEntity, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        return taskDeviceInfoDao_Impl.__insertAdapterOfTaskDeviceInfoEntity.insertAndReturnId(_connection, taskDeviceInfoEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r update$lambda$0(TaskDeviceInfoDao_Impl taskDeviceInfoDao_Impl, TaskDeviceInfoEntity taskDeviceInfoEntity, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        taskDeviceInfoDao_Impl.__updateAdapterOfTaskDeviceInfoEntity.handle(_connection, taskDeviceInfoEntity);
        return r.f317a;
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDeviceInfoDao
    public void delete(TaskDeviceInfoEntity info) {
        k.f(info, "info");
        DBUtil.performBlocking(this.__db, false, true, new e(this, info, 1));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDeviceInfoDao
    public void deleteById(long id) {
        DBUtil.performBlocking(this.__db, false, true, new R3.f(id, 9));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDeviceInfoDao
    public List<TaskDeviceInfoEntity> getAll() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new C2016a(18));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDeviceInfoDao
    public TaskDeviceInfoEntity getById(long id) {
        return (TaskDeviceInfoEntity) DBUtil.performBlocking(this.__db, true, false, new R3.f(id, 10));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDeviceInfoDao
    public long insert(TaskDeviceInfoEntity info) {
        k.f(info, "info");
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new e(this, info, 2))).longValue();
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDeviceInfoDao
    public void update(TaskDeviceInfoEntity info) {
        k.f(info, "info");
        DBUtil.performBlocking(this.__db, false, true, new e(this, info, 0));
    }
}
