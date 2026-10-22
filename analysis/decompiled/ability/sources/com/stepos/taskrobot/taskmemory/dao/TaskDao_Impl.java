package com.stepos.taskrobot.taskmemory.dao;

import C7.r;
import R3.b;
import R3.f;
import androidx.room.EntityDeleteOrUpdateAdapter;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.room.util.SQLiteStatementUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.taskrobot.taskmemory.dao.TaskDao_Impl;
import com.stepos.taskrobot.taskmemory.entity.TaskDeviceInfoEntity;
import com.stepos.taskrobot.taskmemory.entity.TaskEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import t5.C2016a;
import t6.C2017a;
import t6.c;
import t6.d;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 22\u00020\u0001:\u00013B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001c\u0010\u0018J\u0019\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001d\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010!\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b!\u0010\"J'\u0010&\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\bH\u0016¢\u0006\u0004\b&\u0010'J\u000f\u0010(\u001a\u00020\rH\u0016¢\u0006\u0004\b(\u0010)R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010*R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00060+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00060.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00100¨\u00064"}, d2 = {"Lcom/stepos/taskrobot/taskmemory/dao/TaskDao_Impl;", "Lcom/stepos/taskrobot/taskmemory/dao/TaskDao;", "Landroidx/room/RoomDatabase;", "__db", AppAgent.CONSTRUCT, "(Landroidx/room/RoomDatabase;)V", "Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "task", "", "insert", "(Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;)J", "", "list", "LC7/r;", "insertList", "(Ljava/util/List;)V", "delete", "(Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;)V", "update", "getAll", "()Ljava/util/List;", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "getByTaskId", "(Ljava/lang/String;)Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "id", "getById", "(J)Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "getTaskByTaskId", "deviceId", "Lcom/stepos/taskrobot/taskmemory/entity/TaskDeviceInfoEntity;", "getDeviceById", "(J)Lcom/stepos/taskrobot/taskmemory/entity/TaskDeviceInfoEntity;", "deleteByTaskId", "(Ljava/lang/String;)V", "result", "endTime", "", "updateResultByTaskId", "(Ljava/lang/String;Ljava/lang/String;J)I", "deleteAllTasks", "()V", "Landroidx/room/RoomDatabase;", "Landroidx/room/EntityInsertAdapter;", "__insertAdapterOfTaskEntity", "Landroidx/room/EntityInsertAdapter;", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__deleteAdapterOfTaskEntity", "Landroidx/room/EntityDeleteOrUpdateAdapter;", "__updateAdapterOfTaskEntity", "Companion", "t6/d", "taskmemory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskDao_Impl implements TaskDao {
    public static final d Companion = new d();
    private final RoomDatabase __db;
    private final EntityDeleteOrUpdateAdapter<TaskEntity> __deleteAdapterOfTaskEntity;
    private final EntityInsertAdapter<TaskEntity> __insertAdapterOfTaskEntity;
    private final EntityDeleteOrUpdateAdapter<TaskEntity> __updateAdapterOfTaskEntity;

    public TaskDao_Impl(RoomDatabase __db) {
        k.f(__db, "__db");
        this.__db = __db;
        this.__insertAdapterOfTaskEntity = new R3.d(5);
        this.__deleteAdapterOfTaskEntity = new c(0);
        this.__updateAdapterOfTaskEntity = new c(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r delete$lambda$0(TaskDao_Impl taskDao_Impl, TaskEntity taskEntity, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        taskDao_Impl.__deleteAdapterOfTaskEntity.handle(_connection, taskEntity);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r deleteAllTasks$lambda$0(String str, SQLiteConnection _connection) {
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
    public static final r deleteByTaskId$lambda$0(String str, String str2, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
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
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "deviceInfoId");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME);
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "taskDesc");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "guiTree");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "result");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createTime");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "endTime");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "durationTime");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "coverImage");
            ArrayList arrayList = new ArrayList();
            while (sQLiteStatementPrepare.step()) {
                arrayList.add(new TaskEntity(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getLong(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow9)), sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow10)), sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11)));
            }
            return arrayList;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TaskEntity getById$lambda$0(String str, long j5, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7170bindLong(1, j5);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "deviceInfoId");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME);
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "taskDesc");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "guiTree");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "result");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createTime");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "endTime");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "durationTime");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "coverImage");
            TaskEntity taskEntity = null;
            if (sQLiteStatementPrepare.step()) {
                taskEntity = new TaskEntity(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getLong(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow9)), sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow10)), sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11));
            }
            return taskEntity;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TaskEntity getByTaskId$lambda$0(String str, String str2, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "deviceInfoId");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME);
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "taskDesc");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "guiTree");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "result");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createTime");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "endTime");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "durationTime");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "coverImage");
            TaskEntity taskEntity = null;
            if (sQLiteStatementPrepare.step()) {
                taskEntity = new TaskEntity(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getLong(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow9)), sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow10)), sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11));
            }
            return taskEntity;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TaskDeviceInfoEntity getDeviceById$lambda$0(String str, long j5, SQLiteConnection _connection) {
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
    public static final TaskEntity getTaskByTaskId$lambda$0(String str, String str2, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            int columnIndexOrThrow = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "id");
            int columnIndexOrThrow2 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID);
            int columnIndexOrThrow3 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "deviceInfoId");
            int columnIndexOrThrow4 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_NAME);
            int columnIndexOrThrow5 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "taskDesc");
            int columnIndexOrThrow6 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "guiTree");
            int columnIndexOrThrow7 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "result");
            int columnIndexOrThrow8 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "createTime");
            int columnIndexOrThrow9 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "endTime");
            int columnIndexOrThrow10 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "durationTime");
            int columnIndexOrThrow11 = SQLiteStatementUtil.getColumnIndexOrThrow(sQLiteStatementPrepare, "coverImage");
            TaskEntity taskEntity = null;
            if (sQLiteStatementPrepare.step()) {
                taskEntity = new TaskEntity(sQLiteStatementPrepare.getLong(columnIndexOrThrow), sQLiteStatementPrepare.getText(columnIndexOrThrow2), sQLiteStatementPrepare.getLong(columnIndexOrThrow3), sQLiteStatementPrepare.getText(columnIndexOrThrow4), sQLiteStatementPrepare.getText(columnIndexOrThrow5), sQLiteStatementPrepare.isNull(columnIndexOrThrow6) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow6), sQLiteStatementPrepare.isNull(columnIndexOrThrow7) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow7), sQLiteStatementPrepare.getLong(columnIndexOrThrow8), sQLiteStatementPrepare.isNull(columnIndexOrThrow9) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow9)), sQLiteStatementPrepare.isNull(columnIndexOrThrow10) ? null : Long.valueOf(sQLiteStatementPrepare.getLong(columnIndexOrThrow10)), sQLiteStatementPrepare.isNull(columnIndexOrThrow11) ? null : sQLiteStatementPrepare.getText(columnIndexOrThrow11));
            }
            return taskEntity;
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long insert$lambda$0(TaskDao_Impl taskDao_Impl, TaskEntity taskEntity, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        return taskDao_Impl.__insertAdapterOfTaskEntity.insertAndReturnId(_connection, taskEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r insertList$lambda$0(TaskDao_Impl taskDao_Impl, List list, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        taskDao_Impl.__insertAdapterOfTaskEntity.insert(_connection, list);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r update$lambda$0(TaskDao_Impl taskDao_Impl, TaskEntity taskEntity, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        taskDao_Impl.__updateAdapterOfTaskEntity.handle(_connection, taskEntity);
        return r.f317a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int updateResultByTaskId$lambda$0(String str, String str2, long j5, String str3, SQLiteConnection _connection) {
        k.f(_connection, "_connection");
        SQLiteStatement sQLiteStatementPrepare = _connection.prepare(str);
        try {
            sQLiteStatementPrepare.mo7172bindText(1, str2);
            sQLiteStatementPrepare.mo7170bindLong(2, j5);
            sQLiteStatementPrepare.mo7172bindText(3, str3);
            sQLiteStatementPrepare.step();
            return SQLiteConnectionUtil.getTotalChangedRows(_connection);
        } finally {
            sQLiteStatementPrepare.close();
        }
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDao
    public void delete(TaskEntity task) {
        k.f(task, "task");
        DBUtil.performBlocking(this.__db, false, true, new C2017a(this, task, 2));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDao
    public void deleteAllTasks() {
        DBUtil.performBlocking(this.__db, false, true, new C2016a(16));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDao
    public void deleteByTaskId(String taskId) {
        k.f(taskId, "taskId");
        DBUtil.performBlocking(this.__db, false, true, new R3.c(taskId, 26));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDao
    public List<TaskEntity> getAll() {
        return (List) DBUtil.performBlocking(this.__db, true, false, new C2016a(17));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDao
    public TaskEntity getById(long id) {
        return (TaskEntity) DBUtil.performBlocking(this.__db, true, false, new f(id, 8));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDao
    public TaskEntity getByTaskId(String taskId) {
        k.f(taskId, "taskId");
        return (TaskEntity) DBUtil.performBlocking(this.__db, true, false, new R3.c(taskId, 24));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDao
    public TaskDeviceInfoEntity getDeviceById(long deviceId) {
        return (TaskDeviceInfoEntity) DBUtil.performBlocking(this.__db, true, false, new f(deviceId, 7));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDao
    public TaskEntity getTaskByTaskId(String taskId) {
        k.f(taskId, "taskId");
        return (TaskEntity) DBUtil.performBlocking(this.__db, true, false, new R3.c(taskId, 25));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDao
    public long insert(TaskEntity task) {
        k.f(task, "task");
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new C2017a(this, task, 0))).longValue();
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDao
    public void insertList(List<TaskEntity> list) {
        k.f(list, "list");
        DBUtil.performBlocking(this.__db, false, true, new b(27, this, list));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDao
    public void update(TaskEntity task) {
        k.f(task, "task");
        DBUtil.performBlocking(this.__db, false, true, new C2017a(this, task, 1));
    }

    @Override // com.stepos.taskrobot.taskmemory.dao.TaskDao
    public int updateResultByTaskId(final String taskId, final String result, final long endTime) {
        k.f(taskId, "taskId");
        k.f(result, "result");
        return ((Number) DBUtil.performBlocking(this.__db, false, true, new S7.k() { // from class: t6.b
            @Override // S7.k
            public final Object invoke(Object obj) {
                return Integer.valueOf(TaskDao_Impl.updateResultByTaskId$lambda$0("UPDATE task SET result = ?, endTime = ? WHERE taskId = ?", result, endTime, taskId, (SQLiteConnection) obj));
            }
        })).intValue();
    }
}
