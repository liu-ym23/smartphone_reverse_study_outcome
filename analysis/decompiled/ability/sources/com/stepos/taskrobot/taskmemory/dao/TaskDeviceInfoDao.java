package com.stepos.taskrobot.taskmemory.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.stepos.taskrobot.taskmemory.entity.TaskDeviceInfoEntity;
import java.util.List;
import kotlin.Metadata;

@Dao
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\n\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004H'¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u0004H'¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0013À\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/taskmemory/dao/TaskDeviceInfoDao;", "", "Lcom/stepos/taskrobot/taskmemory/entity/TaskDeviceInfoEntity;", "info", "", "insert", "(Lcom/stepos/taskrobot/taskmemory/entity/TaskDeviceInfoEntity;)J", "LC7/r;", "update", "(Lcom/stepos/taskrobot/taskmemory/entity/TaskDeviceInfoEntity;)V", "delete", "id", "deleteById", "(J)V", "", "getAll", "()Ljava/util/List;", "getById", "(J)Lcom/stepos/taskrobot/taskmemory/entity/TaskDeviceInfoEntity;", "taskmemory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface TaskDeviceInfoDao {
    @Delete
    void delete(TaskDeviceInfoEntity info);

    @Query("DELETE FROM task_device_info WHERE id = :id")
    void deleteById(long id);

    @Query("SELECT * FROM task_device_info ORDER BY createTime DESC")
    List<TaskDeviceInfoEntity> getAll();

    @Query("SELECT * FROM task_device_info WHERE id = :id LIMIT 1")
    TaskDeviceInfoEntity getById(long id);

    @Insert(onConflict = 1)
    long insert(TaskDeviceInfoEntity info);

    @Update
    void update(TaskDeviceInfoEntity info);
}
