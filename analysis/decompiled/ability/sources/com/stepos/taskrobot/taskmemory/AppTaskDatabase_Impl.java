package com.stepos.taskrobot.taskmemory;

import C7.f;
import Z7.d;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenDelegate;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.taskmemory.AppTaskDatabase_Impl;
import com.stepos.taskrobot.taskmemory.dao.TaskDao;
import com.stepos.taskrobot.taskmemory.dao.TaskDao_Impl;
import com.stepos.taskrobot.taskmemory.dao.TaskDeviceInfoDao;
import com.stepos.taskrobot.taskmemory.dao.TaskDeviceInfoDao_Impl;
import com.stepos.taskrobot.taskmemory.dao.TaskStepDao;
import com.stepos.taskrobot.taskmemory.dao.TaskStepDao_Impl;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.n;
import s6.C1917d;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\u0003J)\u0010\u000f\u001a\u001c\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\u000e0\fH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\r0\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u001a\u0010\u0015\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00120\r\u0012\u0004\u0012\u00020\u00120\fH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!R\u001a\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001a\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001f0\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010$¨\u0006'"}, d2 = {"Lcom/stepos/taskrobot/taskmemory/AppTaskDatabase_Impl;", "Lcom/stepos/taskrobot/taskmemory/AppTaskDatabase;", AppAgent.CONSTRUCT, "()V", "Landroidx/room/RoomOpenDelegate;", "createOpenDelegate", "()Landroidx/room/RoomOpenDelegate;", "Landroidx/room/InvalidationTracker;", "createInvalidationTracker", "()Landroidx/room/InvalidationTracker;", "LC7/r;", "clearAllTables", "", "LZ7/d;", "", "getRequiredTypeConverterClasses", "()Ljava/util/Map;", "", "Landroidx/room/migration/AutoMigrationSpec;", "getRequiredAutoMigrationSpecClasses", "()Ljava/util/Set;", "autoMigrationSpecs", "Landroidx/room/migration/Migration;", "createAutoMigrations", "(Ljava/util/Map;)Ljava/util/List;", "Lcom/stepos/taskrobot/taskmemory/dao/TaskDao;", "taskDao", "()Lcom/stepos/taskrobot/taskmemory/dao/TaskDao;", "Lcom/stepos/taskrobot/taskmemory/dao/TaskDeviceInfoDao;", "taskDeviceInfoDao", "()Lcom/stepos/taskrobot/taskmemory/dao/TaskDeviceInfoDao;", "Lcom/stepos/taskrobot/taskmemory/dao/TaskStepDao;", "taskStepDao", "()Lcom/stepos/taskrobot/taskmemory/dao/TaskStepDao;", "LC7/f;", "_taskDao", "LC7/f;", "_taskDeviceInfoDao", "_taskStepDao", "taskmemory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AppTaskDatabase_Impl extends AppTaskDatabase {
    private final f _taskDao;
    private final f _taskDeviceInfoDao;
    private final f _taskStepDao;

    public AppTaskDatabase_Impl() {
        final int i = 0;
        this._taskDao = kotlin.a.a(new S7.a(this) { // from class: s6.c
            public final /* synthetic */ AppTaskDatabase_Impl b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i6 = i;
                AppTaskDatabase_Impl appTaskDatabase_Impl = this.b;
                switch (i6) {
                    case 0:
                        return AppTaskDatabase_Impl._taskDao$lambda$0(appTaskDatabase_Impl);
                    case 1:
                        return AppTaskDatabase_Impl._taskDeviceInfoDao$lambda$0(appTaskDatabase_Impl);
                    default:
                        return AppTaskDatabase_Impl._taskStepDao$lambda$0(appTaskDatabase_Impl);
                }
            }
        });
        final int i6 = 1;
        this._taskDeviceInfoDao = kotlin.a.a(new S7.a(this) { // from class: s6.c
            public final /* synthetic */ AppTaskDatabase_Impl b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i62 = i6;
                AppTaskDatabase_Impl appTaskDatabase_Impl = this.b;
                switch (i62) {
                    case 0:
                        return AppTaskDatabase_Impl._taskDao$lambda$0(appTaskDatabase_Impl);
                    case 1:
                        return AppTaskDatabase_Impl._taskDeviceInfoDao$lambda$0(appTaskDatabase_Impl);
                    default:
                        return AppTaskDatabase_Impl._taskStepDao$lambda$0(appTaskDatabase_Impl);
                }
            }
        });
        final int i10 = 2;
        this._taskStepDao = kotlin.a.a(new S7.a(this) { // from class: s6.c
            public final /* synthetic */ AppTaskDatabase_Impl b;

            {
                this.b = this;
            }

            @Override // S7.a
            public final Object invoke() {
                int i62 = i10;
                AppTaskDatabase_Impl appTaskDatabase_Impl = this.b;
                switch (i62) {
                    case 0:
                        return AppTaskDatabase_Impl._taskDao$lambda$0(appTaskDatabase_Impl);
                    case 1:
                        return AppTaskDatabase_Impl._taskDeviceInfoDao$lambda$0(appTaskDatabase_Impl);
                    default:
                        return AppTaskDatabase_Impl._taskStepDao$lambda$0(appTaskDatabase_Impl);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TaskDao_Impl _taskDao$lambda$0(AppTaskDatabase_Impl appTaskDatabase_Impl) {
        return new TaskDao_Impl(appTaskDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TaskDeviceInfoDao_Impl _taskDeviceInfoDao$lambda$0(AppTaskDatabase_Impl appTaskDatabase_Impl) {
        return new TaskDeviceInfoDao_Impl(appTaskDatabase_Impl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TaskStepDao_Impl _taskStepDao$lambda$0(AppTaskDatabase_Impl appTaskDatabase_Impl) {
        return new TaskStepDao_Impl(appTaskDatabase_Impl);
    }

    @Override // androidx.room.RoomDatabase
    public void clearAllTables() {
        performClear(false, "task", "task_device_info", "task_step");
    }

    @Override // androidx.room.RoomDatabase
    public List<Migration> createAutoMigrations(Map<d, ? extends AutoMigrationSpec> autoMigrationSpecs) {
        k.f(autoMigrationSpecs, "autoMigrationSpecs");
        return new ArrayList();
    }

    @Override // androidx.room.RoomDatabase
    public InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new LinkedHashMap(), new LinkedHashMap(), "task", "task_device_info", "task_step");
    }

    @Override // androidx.room.RoomDatabase
    public Set<d> getRequiredAutoMigrationSpecClasses() {
        return new LinkedHashSet();
    }

    @Override // androidx.room.RoomDatabase
    public Map<d, List<d>> getRequiredTypeConverterClasses() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        n nVar = m.f4928a;
        d dVarB = nVar.b(TaskDao.class);
        TaskDao_Impl.Companion.getClass();
        EmptyList emptyList = EmptyList.f4893a;
        linkedHashMap.put(dVarB, emptyList);
        d dVarB2 = nVar.b(TaskDeviceInfoDao.class);
        TaskDeviceInfoDao_Impl.Companion.getClass();
        linkedHashMap.put(dVarB2, emptyList);
        d dVarB3 = nVar.b(TaskStepDao.class);
        TaskStepDao_Impl.Companion.getClass();
        linkedHashMap.put(dVarB3, emptyList);
        return linkedHashMap;
    }

    @Override // com.stepos.taskrobot.taskmemory.AppTaskDatabase
    public TaskDao taskDao() {
        return (TaskDao) this._taskDao.getF4884a();
    }

    public TaskDeviceInfoDao taskDeviceInfoDao() {
        return (TaskDeviceInfoDao) this._taskDeviceInfoDao.getF4884a();
    }

    @Override // com.stepos.taskrobot.taskmemory.AppTaskDatabase
    public TaskStepDao taskStepDao() {
        return (TaskStepDao) this._taskStepDao.getF4884a();
    }

    @Override // androidx.room.RoomDatabase
    public RoomOpenDelegate createOpenDelegate() {
        return new C1917d(this);
    }
}
