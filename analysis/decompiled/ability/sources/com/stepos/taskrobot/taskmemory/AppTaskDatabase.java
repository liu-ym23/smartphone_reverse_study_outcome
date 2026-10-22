package com.stepos.taskrobot.taskmemory;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.taskrobot.taskmemory.dao.TaskDao;
import com.stepos.taskrobot.taskmemory.dao.TaskStepDao;
import com.stepos.taskrobot.taskmemory.entity.TaskDeviceInfoEntity;
import com.stepos.taskrobot.taskmemory.entity.TaskEntity;
import com.stepos.taskrobot.taskmemory.entity.TaskStepEntity;
import kotlin.Metadata;
import s6.C1914a;

@Database(entities = {TaskEntity.class, TaskDeviceInfoEntity.class, TaskStepEntity.class}, exportSchema = false, version = 2)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000 \u00042\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/stepos/taskrobot/taskmemory/AppTaskDatabase;", "Landroidx/room/RoomDatabase;", AppAgent.CONSTRUCT, "()V", "Companion", "s6/a", "taskmemory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AppTaskDatabase extends RoomDatabase {
    public static final String DB_NAME = "task_db";
    private static volatile AppTaskDatabase INSTANCE = null;
    private static final String TAG = "AppTaskDatabase";
    public static final C1914a Companion = new C1914a();
    private static final Migration MIGRATION_1_2 = new Q3.b(1, 2, 6);

    public abstract TaskDao taskDao();

    public abstract TaskStepDao taskStepDao();
}
