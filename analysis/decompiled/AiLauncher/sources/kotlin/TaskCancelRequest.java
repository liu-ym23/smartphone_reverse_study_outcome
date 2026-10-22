package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\rR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\rR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0019\u0010\rR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"LK6/F;", "", "", "taskId", "reason", "", "expectedVersion", "idempotencyKey", "", "killSubagents", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Boolean;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "e", Const.INTENT_KEY_UMID, "Ljava/lang/Integer;", Const.INTENT_KEY_APIKEY, "()Ljava/lang/Integer;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.F, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TaskCancelRequest {
    private final Integer expectedVersion;
    private final String idempotencyKey;
    private final Boolean killSubagents;
    private final String reason;
    private final String taskId;

    public TaskCancelRequest(String taskId, String str, Integer num, String str2, Boolean bool) {
        p.i(taskId, "taskId");
        this.taskId = taskId;
        this.reason = str;
        this.expectedVersion = num;
        this.idempotencyKey = str2;
        this.killSubagents = bool;
    }

    /* renamed from: a, reason: from getter */
    public final Integer getExpectedVersion() {
        return this.expectedVersion;
    }

    /* renamed from: b, reason: from getter */
    public final String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /* renamed from: c, reason: from getter */
    public final Boolean getKillSubagents() {
        return this.killSubagents;
    }

    /* renamed from: d, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: e, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskCancelRequest)) {
            return false;
        }
        TaskCancelRequest taskCancelRequest = (TaskCancelRequest) other;
        return p.d(this.taskId, taskCancelRequest.taskId) && p.d(this.reason, taskCancelRequest.reason) && p.d(this.expectedVersion, taskCancelRequest.expectedVersion) && p.d(this.idempotencyKey, taskCancelRequest.idempotencyKey) && p.d(this.killSubagents, taskCancelRequest.killSubagents);
    }

    public int hashCode() {
        int iHashCode = this.taskId.hashCode() * 31;
        String str = this.reason;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num = this.expectedVersion;
        int iHashCode3 = (iHashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.idempotencyKey;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.killSubagents;
        return iHashCode4 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        return "TaskCancelRequest(taskId=" + this.taskId + ", reason=" + this.reason + ", expectedVersion=" + this.expectedVersion + ", idempotencyKey=" + this.idempotencyKey + ", killSubagents=" + this.killSubagents + ")";
    }

    public /* synthetic */ TaskCancelRequest(String str, String str2, Integer num, String str3, Boolean bool, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : num, (i10 & 8) != 0 ? null : str3, (i10 & 16) != 0 ? null : bool);
    }
}
