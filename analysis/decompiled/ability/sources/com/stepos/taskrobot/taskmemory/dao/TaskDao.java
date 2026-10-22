package com.stepos.taskrobot.taskmemory.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.taskrobot.taskmemory.entity.TaskDeviceInfoEntity;
import com.stepos.taskrobot.taskmemory.entity.TaskEntity;
import java.util.List;
import kotlin.Metadata;

@Dao
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0012\u0010\rJ\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0004H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u001a\u0010\u0016J\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001b\u001a\u00020\u0004H'¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\"\u001a\u00020!2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020\u0004H'¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\tH'¢\u0006\u0004\b$\u0010%¨\u0006&À\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/taskmemory/dao/TaskDao;", "", "Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "task", "", "insert", "(Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;)J", "", "list", "LC7/r;", "insertList", "(Ljava/util/List;)V", "delete", "(Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;)V", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "deleteByTaskId", "(Ljava/lang/String;)V", "update", "getAll", "()Ljava/util/List;", "getByTaskId", "(Ljava/lang/String;)Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "id", "getById", "(J)Lcom/stepos/taskrobot/taskmemory/entity/TaskEntity;", "getTaskByTaskId", "deviceId", "Lcom/stepos/taskrobot/taskmemory/entity/TaskDeviceInfoEntity;", "getDeviceById", "(J)Lcom/stepos/taskrobot/taskmemory/entity/TaskDeviceInfoEntity;", "result", "endTime", "", "updateResultByTaskId", "(Ljava/lang/String;Ljava/lang/String;J)I", "deleteAllTasks", "()V", "taskmemory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface TaskDao {
    @Delete
    void delete(TaskEntity task);

    @Query("DELETE FROM task")
    void deleteAllTasks();

    @Query("DELETE FROM task WHERE taskId = :taskId")
    void deleteByTaskId(String taskId);

    @Query("SELECT * FROM task ORDER BY createTime DESC")
    List<TaskEntity> getAll();

    @Query("SELECT * FROM task WHERE id = :id")
    TaskEntity getById(long id);

    @Query("SELECT * FROM task WHERE taskId = :taskId LIMIT 1")
    TaskEntity getByTaskId(String taskId);

    @Query("SELECT * FROM task_device_info WHERE id = :deviceId LIMIT 1")
    TaskDeviceInfoEntity getDeviceById(long deviceId);

    @Query("SELECT * FROM task WHERE taskId = :taskId LIMIT 1")
    TaskEntity getTaskByTaskId(String taskId);

    @Insert(onConflict = 1)
    long insert(TaskEntity task);

    @Insert(onConflict = 1)
    void insertList(List<TaskEntity> list);

    @Update
    void update(TaskEntity task);

    @Query("UPDATE task SET result = :result, endTime = :endTime WHERE taskId = :taskId")
    int updateResultByTaskId(String taskId, String result, long endTime);
}
