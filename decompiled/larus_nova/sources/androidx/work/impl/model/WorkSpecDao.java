package androidx.work.impl.model;

import androidx.lifecycle.LiveData;
import androidx.work.Data;
import androidx.work.WorkInfo;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface WorkSpecDao {
    void delete(String r100);

    List<WorkSpec> getAllEligibleWorkSpecsForScheduling(int r100);

    List<String> getAllUnfinishedWork();

    List<String> getAllWorkSpecIds();

    LiveData<List<String>> getAllWorkSpecIdsLiveData();

    List<WorkSpec> getEligibleWorkForScheduling(int r100);

    List<Data> getInputsFromPrerequisites(String r100);

    List<WorkSpec> getRecentlyCompletedWork(long r100);

    List<WorkSpec> getRunningWork();

    LiveData<Long> getScheduleRequestedAtLiveData(String r100);

    List<WorkSpec> getScheduledWork();

    WorkInfo.State getState(String r100);

    List<String> getUnfinishedWorkWithName(String r100);

    List<String> getUnfinishedWorkWithTag(String r100);

    WorkSpec getWorkSpec(String r100);

    List<WorkSpec.IdAndState> getWorkSpecIdAndStatesForName(String r100);

    WorkSpec[] getWorkSpecs(List<String> r100);

    WorkSpec.WorkInfoPojo getWorkStatusPojoForId(String r100);

    List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForIds(List<String> r100);

    List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForName(String r100);

    List<WorkSpec.WorkInfoPojo> getWorkStatusPojoForTag(String r100);

    LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForIds(List<String> r100);

    LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForName(String r100);

    LiveData<List<WorkSpec.WorkInfoPojo>> getWorkStatusPojoLiveDataForTag(String r100);

    boolean hasUnfinishedWork();

    int incrementWorkSpecRunAttemptCount(String r100);

    void insertWorkSpec(WorkSpec r100);

    int markWorkSpecScheduled(String r100, long r101);

    void pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast();

    int resetScheduledState();

    int resetWorkSpecRunAttemptCount(String r100);

    void setOutput(String r100, Data r101);

    void setPeriodStartTime(String r100, long r101);

    int setState(WorkInfo.State r100, String... r101);
}
