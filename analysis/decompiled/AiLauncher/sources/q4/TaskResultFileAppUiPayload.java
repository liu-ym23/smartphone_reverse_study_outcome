package q4;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0004\b\t\u0010\nJH\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000eR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0016\u001a\u0004\b\u0018\u0010\u000eR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001c\u0010\u001b¨\u0006\u001d"}, d2 = {"Lq4/f;", "", "", "taskId", "versionId", "", "Lq4/e;", "artifacts", "activeToolCallIds", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)Lq4/f;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "e", "f", "Ljava/util/List;", Const.INTENT_KEY_UMID, "()Ljava/util/List;", "c", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: q4.f, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class TaskResultFileAppUiPayload {

    @SerializedName(i.KEY_ACTIVE_TOOL_CALL_IDS)
    private final List<String> activeToolCallIds;

    @SerializedName("artifacts")
    private final List<TaskResultFileAppUiItem> artifacts;

    @SerializedName("task_id")
    private final String taskId;

    @SerializedName("version_id")
    private final String versionId;

    public TaskResultFileAppUiPayload() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TaskResultFileAppUiPayload b(TaskResultFileAppUiPayload taskResultFileAppUiPayload, String str, String str2, List list, List list2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = taskResultFileAppUiPayload.taskId;
        }
        if ((i10 & 2) != 0) {
            str2 = taskResultFileAppUiPayload.versionId;
        }
        if ((i10 & 4) != 0) {
            list = taskResultFileAppUiPayload.artifacts;
        }
        if ((i10 & 8) != 0) {
            list2 = taskResultFileAppUiPayload.activeToolCallIds;
        }
        return taskResultFileAppUiPayload.a(str, str2, list, list2);
    }

    public final TaskResultFileAppUiPayload a(String taskId, String versionId, List<TaskResultFileAppUiItem> artifacts, List<String> activeToolCallIds) {
        p.i(artifacts, "artifacts");
        p.i(activeToolCallIds, "activeToolCallIds");
        return new TaskResultFileAppUiPayload(taskId, versionId, artifacts, activeToolCallIds);
    }

    public final List<String> c() {
        return this.activeToolCallIds;
    }

    public final List<TaskResultFileAppUiItem> d() {
        return this.artifacts;
    }

    /* renamed from: e, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskResultFileAppUiPayload)) {
            return false;
        }
        TaskResultFileAppUiPayload taskResultFileAppUiPayload = (TaskResultFileAppUiPayload) other;
        return p.d(this.taskId, taskResultFileAppUiPayload.taskId) && p.d(this.versionId, taskResultFileAppUiPayload.versionId) && p.d(this.artifacts, taskResultFileAppUiPayload.artifacts) && p.d(this.activeToolCallIds, taskResultFileAppUiPayload.activeToolCallIds);
    }

    /* renamed from: f, reason: from getter */
    public final String getVersionId() {
        return this.versionId;
    }

    public int hashCode() {
        String str = this.taskId;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.versionId;
        return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.artifacts.hashCode()) * 31) + this.activeToolCallIds.hashCode();
    }

    public String toString() {
        return "TaskResultFileAppUiPayload(taskId=" + this.taskId + ", versionId=" + this.versionId + ", artifacts=" + this.artifacts + ", activeToolCallIds=" + this.activeToolCallIds + ")";
    }

    public TaskResultFileAppUiPayload(String str, String str2, List<TaskResultFileAppUiItem> artifacts, List<String> activeToolCallIds) {
        p.i(artifacts, "artifacts");
        p.i(activeToolCallIds, "activeToolCallIds");
        this.taskId = str;
        this.versionId = str2;
        this.artifacts = artifacts;
        this.activeToolCallIds = activeToolCallIds;
    }

    public /* synthetic */ TaskResultFileAppUiPayload(String str, String str2, List list, List list2, int i10, kotlin.jvm.internal.i iVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? C1173v.m() : list, (i10 & 8) != 0 ? C1173v.m() : list2);
    }
}
