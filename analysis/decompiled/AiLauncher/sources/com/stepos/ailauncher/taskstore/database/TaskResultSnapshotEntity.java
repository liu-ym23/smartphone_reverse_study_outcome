package com.stepos.ailauncher.taskstore.database;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0081\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u001b\u0010\rR\u001a\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/database/i;", "", "", "taskId", "", "sequence", "version", "resultJson", "", "savedAt", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;J)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "I", "c", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", Const.INTENT_KEY_APIKEY, "J", Const.INTENT_KEY_PKGNAME, "()J", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.database.i, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TaskResultSnapshotEntity {
    private final String resultJson;
    private final long savedAt;
    private final int sequence;
    private final String taskId;
    private final Integer version;

    public TaskResultSnapshotEntity(String taskId, int i10, Integer num, String resultJson, long j10) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        kotlin.jvm.internal.p.i(resultJson, "resultJson");
        this.taskId = taskId;
        this.sequence = i10;
        this.version = num;
        this.resultJson = resultJson;
        this.savedAt = j10;
    }

    /* renamed from: a, reason: from getter */
    public final String getResultJson() {
        return this.resultJson;
    }

    /* renamed from: b, reason: from getter */
    public final long getSavedAt() {
        return this.savedAt;
    }

    /* renamed from: c, reason: from getter */
    public final int getSequence() {
        return this.sequence;
    }

    /* renamed from: d, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: e, reason: from getter */
    public final Integer getVersion() {
        return this.version;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskResultSnapshotEntity)) {
            return false;
        }
        TaskResultSnapshotEntity taskResultSnapshotEntity = (TaskResultSnapshotEntity) other;
        return kotlin.jvm.internal.p.d(this.taskId, taskResultSnapshotEntity.taskId) && this.sequence == taskResultSnapshotEntity.sequence && kotlin.jvm.internal.p.d(this.version, taskResultSnapshotEntity.version) && kotlin.jvm.internal.p.d(this.resultJson, taskResultSnapshotEntity.resultJson) && this.savedAt == taskResultSnapshotEntity.savedAt;
    }

    public int hashCode() {
        int iHashCode = ((this.taskId.hashCode() * 31) + Integer.hashCode(this.sequence)) * 31;
        Integer num = this.version;
        return ((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.resultJson.hashCode()) * 31) + Long.hashCode(this.savedAt);
    }

    public String toString() {
        return "TaskResultSnapshotEntity(taskId=" + this.taskId + ", sequence=" + this.sequence + ", version=" + this.version + ", resultJson=" + this.resultJson + ", savedAt=" + this.savedAt + ")";
    }
}
