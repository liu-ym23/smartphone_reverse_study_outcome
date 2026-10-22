package androidx.work.impl.model;

import android.annotation.SuppressLint;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;
import androidx.work.WorkInfo;
import com.bytedance.common.wschannel.WsConstants;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes.dex */
@Dao
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0017\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH'¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000e0\u0014H'¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\u001c\u0010\nJ\u001f\u0010\u001f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001dH'¢\u0006\u0004\b\u001f\u0010 J\u001f\u0010#\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020!H'¢\u0006\u0004\b#\u0010$J\u0017\u0010%\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b'\u0010&J\u0019\u0010(\u001a\u0004\u0018\u00010\u00172\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b(\u0010)J\u0019\u0010+\u001a\u0004\u0018\u00010*2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b+\u0010,J#\u0010.\u001a\b\u0012\u0004\u0012\u00020*0\u000e2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH'¢\u0006\u0004\b.\u0010/J)\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u000e0\u00142\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH'¢\u0006\u0004\b0\u00101J\u001d\u00103\u001a\b\u0012\u0004\u0012\u00020*0\u000e2\u0006\u00102\u001a\u00020\u0007H'¢\u0006\u0004\b3\u0010\u0011J#\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u000e0\u00142\u0006\u00102\u001a\u00020\u0007H'¢\u0006\u0004\b4\u00105J\u001d\u00106\u001a\b\u0012\u0004\u0012\u00020*0\u000e2\u0006\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\b6\u0010\u0011J#\u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0\u000e0\u00142\u0006\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\b7\u00105J\u001d\u00108\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b8\u0010\u0011J\u001d\u00109\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u00102\u001a\u00020\u0007H'¢\u0006\u0004\b9\u0010\u0011J\u001d\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e2\u0006\u0010\r\u001a\u00020\u0007H'¢\u0006\u0004\b:\u0010\u0011J\u0015\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH'¢\u0006\u0004\b;\u0010\u0013J\u000f\u0010=\u001a\u00020<H'¢\u0006\u0004\b=\u0010>J\u001f\u0010@\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010?\u001a\u00020!H'¢\u0006\u0004\b@\u0010AJ\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020!0\u00142\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\bB\u00105J\u000f\u0010C\u001a\u00020\u0019H'¢\u0006\u0004\bC\u0010DJ\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010E\u001a\u00020\u0019H'¢\u0006\u0004\bF\u0010GJ\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010H\u001a\u00020\u0019H'¢\u0006\u0004\bI\u0010GJ\u0015\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH'¢\u0006\u0004\bJ\u0010\u0013J\u0015\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH'¢\u0006\u0004\bK\u0010\u0013J\u001d\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010L\u001a\u00020!H'¢\u0006\u0004\bM\u0010NJ\u000f\u0010O\u001a\u00020\u0004H'¢\u0006\u0004\bO\u0010PJ\u0017\u0010Q\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\bQ\u0010\nJ\u0017\u0010R\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\bR\u0010\u0006¨\u0006S"}, d2 = {"Landroidx/work/impl/model/WorkSpecDao;", "", "Landroidx/work/impl/model/o;", "workSpec", "", "insertWorkSpec", "(Landroidx/work/impl/model/o;)V", "", "id", "delete", "(Ljava/lang/String;)V", "getWorkSpec", "(Ljava/lang/String;)Landroidx/work/impl/model/o;", "name", "", "Landroidx/work/impl/model/o$b;", "getWorkSpecIdAndStatesForName", "(Ljava/lang/String;)Ljava/util/List;", "getAllWorkSpecIds", "()Ljava/util/List;", "Landroidx/lifecycle/LiveData;", "getAllWorkSpecIdsLiveData", "()Landroidx/lifecycle/LiveData;", "Landroidx/work/WorkInfo$State;", WsConstants.KEY_CONNECTION_STATE, "", "setState", "(Landroidx/work/WorkInfo$State;Ljava/lang/String;)I", "incrementPeriodCount", "Landroidx/work/c;", "output", "setOutput", "(Ljava/lang/String;Landroidx/work/c;)V", "", "enqueueTime", "setLastEnqueuedTime", "(Ljava/lang/String;J)V", "incrementWorkSpecRunAttemptCount", "(Ljava/lang/String;)I", "resetWorkSpecRunAttemptCount", "getState", "(Ljava/lang/String;)Landroidx/work/WorkInfo$State;", "Landroidx/work/impl/model/o$c;", "getWorkStatusPojoForId", "(Ljava/lang/String;)Landroidx/work/impl/model/o$c;", "ids", "getWorkStatusPojoForIds", "(Ljava/util/List;)Ljava/util/List;", "getWorkStatusPojoLiveDataForIds", "(Ljava/util/List;)Landroidx/lifecycle/LiveData;", "tag", "getWorkStatusPojoForTag", "getWorkStatusPojoLiveDataForTag", "(Ljava/lang/String;)Landroidx/lifecycle/LiveData;", "getWorkStatusPojoForName", "getWorkStatusPojoLiveDataForName", "getInputsFromPrerequisites", "getUnfinishedWorkWithTag", "getUnfinishedWorkWithName", "getAllUnfinishedWork", "", "hasUnfinishedWork", "()Z", "startTime", "markWorkSpecScheduled", "(Ljava/lang/String;J)I", "getScheduleRequestedAtLiveData", "resetScheduledState", "()I", "schedulerLimit", "getEligibleWorkForScheduling", "(I)Ljava/util/List;", "maxLimit", "getAllEligibleWorkSpecsForScheduling", "getScheduledWork", "getRunningWork", "startingAt", "getRecentlyCompletedWork", "(J)Ljava/util/List;", "pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast", "()V", "incrementGeneration", "updateWorkSpec", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"UnknownNullness"})
public interface WorkSpecDao {
    @Query("DELETE FROM workspec WHERE id=:id")
    void delete(@NotNull String r10);

    @Query("SELECT * FROM workspec WHERE state=0 ORDER BY last_enqueue_time LIMIT :maxLimit")
    @NotNull
    List<o> getAllEligibleWorkSpecsForScheduling(int r10);

    @Query("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5)")
    @NotNull
    List<String> getAllUnfinishedWork();

    @Query("SELECT id FROM workspec")
    @NotNull
    List<String> getAllWorkSpecIds();

    @Query("SELECT id FROM workspec")
    @Transaction
    @NotNull
    LiveData getAllWorkSpecIdsLiveData();

    @Query("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at=-1 ORDER BY last_enqueue_time LIMIT (SELECT MAX(:schedulerLimit-COUNT(*), 0) FROM workspec WHERE schedule_requested_at<>-1 AND state NOT IN (2, 3, 5))")
    @NotNull
    List<o> getEligibleWorkForScheduling(int r10);

    @Query("SELECT output FROM workspec WHERE id IN\n             (SELECT prerequisite_id FROM dependency WHERE work_spec_id=:id)")
    @NotNull
    List<androidx.work.c> getInputsFromPrerequisites(@NotNull String r10);

    @Query("SELECT * FROM workspec WHERE last_enqueue_time >= :startingAt AND state IN (2, 3, 5) ORDER BY last_enqueue_time DESC")
    @NotNull
    List<o> getRecentlyCompletedWork(long r10);

    @Query("SELECT * FROM workspec WHERE state=1")
    @NotNull
    List<o> getRunningWork();

    @Query("SELECT schedule_requested_at FROM workspec WHERE id=:id")
    @NotNull
    LiveData getScheduleRequestedAtLiveData(@NotNull String r10);

    @Query("SELECT * FROM workspec WHERE state=0 AND schedule_requested_at<>-1")
    @NotNull
    List<o> getScheduledWork();

    @Query("SELECT state FROM workspec WHERE id=:id")
    @Nullable
    WorkInfo.State getState(@NotNull String r10);

    @Query("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM workname WHERE name=:name)")
    @NotNull
    List<String> getUnfinishedWorkWithName(@NotNull String r10);

    @Query("SELECT id FROM workspec WHERE state NOT IN (2, 3, 5) AND id IN (SELECT work_spec_id FROM worktag WHERE tag=:tag)")
    @NotNull
    List<String> getUnfinishedWorkWithTag(@NotNull String r10);

    @Query("SELECT * FROM workspec WHERE id=:id")
    @Nullable
    o getWorkSpec(@NotNull String r10);

    @Query("SELECT id, state FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=:name)")
    @NotNull
    List<o.b> getWorkSpecIdAndStatesForName(@NotNull String r10);

    @Query("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id=:id")
    @Transaction
    @Nullable
    o.c getWorkStatusPojoForId(@NotNull String r10);

    @Query("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (:ids)")
    @Transaction
    @NotNull
    List<o.c> getWorkStatusPojoForIds(@NotNull List<String> r10);

    @Query("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=:name)")
    @Transaction
    @NotNull
    List<o.c> getWorkStatusPojoForName(@NotNull String r10);

    @Query("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=:tag)")
    @Transaction
    @NotNull
    List<o.c> getWorkStatusPojoForTag(@NotNull String r10);

    @Query("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (:ids)")
    @Transaction
    @NotNull
    LiveData getWorkStatusPojoLiveDataForIds(@NotNull List<String> r10);

    @Query("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=:name)")
    @Transaction
    @NotNull
    LiveData getWorkStatusPojoLiveDataForName(@NotNull String r10);

    @Query("SELECT id, state, output, run_attempt_count, generation FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=:tag)")
    @Transaction
    @NotNull
    LiveData getWorkStatusPojoLiveDataForTag(@NotNull String r10);

    @Query("SELECT COUNT(*) > 0 FROM workspec WHERE state NOT IN (2, 3, 5) LIMIT 1")
    boolean hasUnfinishedWork();

    @Query("UPDATE workspec SET generation=generation+1 WHERE id=:id")
    void incrementGeneration(@NotNull String r10);

    @Query("UPDATE workspec SET period_count=period_count+1 WHERE id=:id")
    void incrementPeriodCount(@NotNull String r10);

    @Query("UPDATE workspec SET run_attempt_count=run_attempt_count+1 WHERE id=:id")
    int incrementWorkSpecRunAttemptCount(@NotNull String r10);

    @Insert(onConflict = 5)
    void insertWorkSpec(@NotNull o r10);

    @Query("UPDATE workspec SET schedule_requested_at=:startTime WHERE id=:id")
    int markWorkSpecScheduled(@NotNull String r10, long r11);

    @Query("DELETE FROM workspec WHERE state IN (2, 3, 5) AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))")
    void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();

    @Query("UPDATE workspec SET schedule_requested_at=-1 WHERE state NOT IN (2, 3, 5)")
    int resetScheduledState();

    @Query("UPDATE workspec SET run_attempt_count=0 WHERE id=:id")
    int resetWorkSpecRunAttemptCount(@NotNull String r10);

    @Query("UPDATE workspec SET last_enqueue_time=:enqueueTime WHERE id=:id")
    void setLastEnqueuedTime(@NotNull String r10, long r11);

    @Query("UPDATE workspec SET output=:output WHERE id=:id")
    void setOutput(@NotNull String r10, @NotNull androidx.work.c r11);

    @Query("UPDATE workspec SET state=:state WHERE id=:id")
    int setState(@NotNull WorkInfo.State r10, @NotNull String r11);

    @Update
    void updateWorkSpec(@NotNull o r10);
}
