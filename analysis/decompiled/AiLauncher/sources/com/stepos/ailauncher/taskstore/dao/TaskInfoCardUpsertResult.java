package com.stepos.ailauncher.taskstore.dao;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCardEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/stepos/ailauncher/taskstore/dao/C;", "", "Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardUpsertOutcome;", "outcome", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", Const.LBS_FAIL_BD_ENTITY, "<init>", "(Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardUpsertOutcome;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardUpsertOutcome;", Const.INTENT_KEY_PKGNAME, "()Lcom/stepos/ailauncher/taskstore/dao/TaskInfoCardUpsertOutcome;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", Const.INTENT_KEY_APIKEY, "()Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCardEntity;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.dao.C, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TaskInfoCardUpsertResult {
    private final TaskInfoCardEntity entity;
    private final TaskInfoCardUpsertOutcome outcome;

    public TaskInfoCardUpsertResult(TaskInfoCardUpsertOutcome outcome, TaskInfoCardEntity taskInfoCardEntity) {
        kotlin.jvm.internal.p.i(outcome, "outcome");
        this.outcome = outcome;
        this.entity = taskInfoCardEntity;
    }

    /* renamed from: a, reason: from getter */
    public final TaskInfoCardEntity getEntity() {
        return this.entity;
    }

    /* renamed from: b, reason: from getter */
    public final TaskInfoCardUpsertOutcome getOutcome() {
        return this.outcome;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskInfoCardUpsertResult)) {
            return false;
        }
        TaskInfoCardUpsertResult taskInfoCardUpsertResult = (TaskInfoCardUpsertResult) other;
        return this.outcome == taskInfoCardUpsertResult.outcome && kotlin.jvm.internal.p.d(this.entity, taskInfoCardUpsertResult.entity);
    }

    public int hashCode() {
        int iHashCode = this.outcome.hashCode() * 31;
        TaskInfoCardEntity taskInfoCardEntity = this.entity;
        return iHashCode + (taskInfoCardEntity == null ? 0 : taskInfoCardEntity.hashCode());
    }

    public String toString() {
        return "TaskInfoCardUpsertResult(outcome=" + this.outcome + ", entity=" + this.entity + ")";
    }
}
