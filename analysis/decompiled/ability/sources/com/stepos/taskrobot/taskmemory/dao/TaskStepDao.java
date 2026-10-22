package com.stepos.taskrobot.taskmemory.dao;

import H7.c;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.taskrobot.taskmemory.entity.TaskStepEntity;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.k;

@Dao
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0004H'¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u0004H'¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0011H'¢\u0006\u0004\b\u001f\u0010 J\u0019\u0010!\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\tH'¢\u0006\u0004\b#\u0010$J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H§@¢\u0006\u0004\b%\u0010&J\u001f\u0010(\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u0011H'¢\u0006\u0004\b(\u0010)J\u001f\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u00072\u0006\u0010\u0012\u001a\u00020\u0011H'¢\u0006\u0004\b*\u0010\u0016J\u0019\u0010+\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u0004H'¢\u0006\u0004\b+\u0010,J)\u0010/\u001a\u00020\t2\u0018\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00110-0\u0007H\u0017¢\u0006\u0004\b/\u0010\u000b¨\u00060À\u0006\u0003"}, d2 = {"Lcom/stepos/taskrobot/taskmemory/dao/TaskStepDao;", "", "Lcom/stepos/taskrobot/taskmemory/entity/TaskStepEntity;", "step", "", "insert", "(Lcom/stepos/taskrobot/taskmemory/entity/TaskStepEntity;)J", "", "list", "LC7/r;", "insertList", "(Ljava/util/List;)V", "", "update", "(Lcom/stepos/taskrobot/taskmemory/entity/TaskStepEntity;)I", "delete", "(Lcom/stepos/taskrobot/taskmemory/entity/TaskStepEntity;)V", "", GuiTaskProgressKt.GuiTaskProgress_KEY_TASK_ID, "deleteByTaskId", "(Ljava/lang/String;)V", "getStepsByTaskId", "(Ljava/lang/String;)Ljava/util/List;", "id", "getById", "(J)Lcom/stepos/taskrobot/taskmemory/entity/TaskStepEntity;", "actionResult", "endTime", "updatePartialById", "(JLjava/lang/String;J)V", "screenshotPath", "updatePartialFieldsById", "(JLjava/lang/String;JLjava/lang/String;)V", "getFirstStepByTaskId", "(Ljava/lang/String;)Lcom/stepos/taskrobot/taskmemory/entity/TaskStepEntity;", "deleteAllSteps", "()V", "getSteps", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "durationData", "updateDurationDataById", "(JLjava/lang/String;)I", "getDurationDataByTaskId", "getDurationDataById", "(J)Ljava/lang/String;", "Lkotlin/Pair;", AlgorithmUpdateBundle.KEY_UPDATES, "updateMultipleDurationData", "taskmemory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface TaskStepDao {
    @Delete
    void delete(TaskStepEntity step);

    @Query("DELETE FROM task_step")
    void deleteAllSteps();

    @Query("DELETE FROM task_step WHERE taskId = :taskId")
    void deleteByTaskId(String taskId);

    @Query("SELECT * FROM task_step WHERE id = :id")
    TaskStepEntity getById(long id);

    @Query("SELECT durationData FROM task_step WHERE id = :id")
    String getDurationDataById(long id);

    @Query("SELECT durationData FROM task_step WHERE taskId = :taskId")
    List<String> getDurationDataByTaskId(String taskId);

    @Query("SELECT * FROM task_step WHERE taskId = :taskId ORDER BY startTime ASC LIMIT 1")
    TaskStepEntity getFirstStepByTaskId(String taskId);

    @Query("SELECT * FROM task_step WHERE taskId = :taskId ORDER BY endTime ASC")
    Object getSteps(String str, c<? super List<TaskStepEntity>> cVar);

    @Query("SELECT * FROM task_step WHERE taskId = :taskId ORDER BY startTime ASC")
    List<TaskStepEntity> getStepsByTaskId(String taskId);

    @Insert(onConflict = 1)
    long insert(TaskStepEntity step);

    @Insert(onConflict = 1)
    void insertList(List<TaskStepEntity> list);

    @Update
    int update(TaskStepEntity step);

    @Query("UPDATE task_step SET durationData = :durationData WHERE id = :id")
    int updateDurationDataById(long id, String durationData);

    @Transaction
    default void updateMultipleDurationData(List<Pair<Long, String>> updates) {
        k.f(updates, "updates");
        Iterator<T> it = updates.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            updateDurationDataById(((Number) pair.f4886a).longValue(), (String) pair.b);
        }
    }

    @Query("UPDATE task_step SET actionResult = :actionResult, endTime = :endTime WHERE id = :id")
    void updatePartialById(long id, String actionResult, long endTime);

    @Query("UPDATE task_step SET actionResult = :actionResult, endTime = :endTime, screenshotPath = :screenshotPath WHERE id = :id")
    void updatePartialFieldsById(long id, String actionResult, long endTime, String screenshotPath);
}
