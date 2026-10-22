package com.stepos.ailauncher.taskstore.chat;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\fR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/stepos/ailauncher/taskstore/chat/I;", "", "", "taskId", "versionId", "", "Lcom/stepos/ailauncher/taskstore/chat/H;", "artifacts", "activeToolCallIds", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", Const.INTENT_KEY_UMID, "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: com.stepos.ailauncher.taskstore.chat.I, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TaskResultFilePayload {

    @SerializedName(q4.i.KEY_ACTIVE_TOOL_CALL_IDS)
    private final List<String> activeToolCallIds;

    @SerializedName("artifacts")
    private final List<TaskResultFileItem> artifacts;

    @SerializedName("task_id")
    private final String taskId;

    @SerializedName("version_id")
    private final String versionId;

    public TaskResultFilePayload() {
        this(null, null, null, null, 15, null);
    }

    public final List<String> a() {
        return this.activeToolCallIds;
    }

    public final List<TaskResultFileItem> b() {
        return this.artifacts;
    }

    /* renamed from: c, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: d, reason: from getter */
    public final String getVersionId() {
        return this.versionId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskResultFilePayload)) {
            return false;
        }
        TaskResultFilePayload taskResultFilePayload = (TaskResultFilePayload) other;
        return kotlin.jvm.internal.p.d(this.taskId, taskResultFilePayload.taskId) && kotlin.jvm.internal.p.d(this.versionId, taskResultFilePayload.versionId) && kotlin.jvm.internal.p.d(this.artifacts, taskResultFilePayload.artifacts) && kotlin.jvm.internal.p.d(this.activeToolCallIds, taskResultFilePayload.activeToolCallIds);
    }

    public int hashCode() {
        String str = this.taskId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.versionId;
        return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.artifacts.hashCode()) * 31) + this.activeToolCallIds.hashCode();
    }

    public String toString() {
        return "TaskResultFilePayload(taskId=" + this.taskId + ", versionId=" + this.versionId + ", artifacts=" + this.artifacts + ", activeToolCallIds=" + this.activeToolCallIds + ")";
    }

    public TaskResultFilePayload(String str, String str2, List<TaskResultFileItem> artifacts, List<String> activeToolCallIds) {
        kotlin.jvm.internal.p.i(artifacts, "artifacts");
        kotlin.jvm.internal.p.i(activeToolCallIds, "activeToolCallIds");
        this.taskId = str;
        this.versionId = str2;
        this.artifacts = artifacts;
        this.activeToolCallIds = activeToolCallIds;
    }

    public /* synthetic */ TaskResultFilePayload(String str, String str2, List list, List list2, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? C1173v.m() : list, (i10 & 8) != 0 ? C1173v.m() : list2);
    }
}
