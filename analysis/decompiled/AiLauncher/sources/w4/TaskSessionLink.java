package w4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u0018R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u0018R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u0018R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u001f\u001a\u0004\b$\u0010!\"\u0004\b%\u0010#¨\u0006&"}, d2 = {"Lw4/l;", "", "", "subSessionKey", "requestSessionKey", "taskId", "agentId", "", "cardTime", "updatedAt", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJ)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_UMID, "setSubSessionKey", "(Ljava/lang/String;)V", "c", "setRequestSessionKey", "e", "setTaskId", Const.INTENT_KEY_APIKEY, "setAgentId", "J", Const.INTENT_KEY_PKGNAME, "()J", "setCardTime", "(J)V", "f", "setUpdatedAt", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: w4.l, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class TaskSessionLink {
    private String agentId;
    private long cardTime;
    private String requestSessionKey;
    private String subSessionKey;
    private String taskId;
    private long updatedAt;

    public TaskSessionLink(String subSessionKey, String requestSessionKey, String taskId, String agentId, long j10, long j11) {
        p.i(subSessionKey, "subSessionKey");
        p.i(requestSessionKey, "requestSessionKey");
        p.i(taskId, "taskId");
        p.i(agentId, "agentId");
        this.subSessionKey = subSessionKey;
        this.requestSessionKey = requestSessionKey;
        this.taskId = taskId;
        this.agentId = agentId;
        this.cardTime = j10;
        this.updatedAt = j11;
    }

    /* renamed from: a, reason: from getter */
    public final String getAgentId() {
        return this.agentId;
    }

    /* renamed from: b, reason: from getter */
    public final long getCardTime() {
        return this.cardTime;
    }

    /* renamed from: c, reason: from getter */
    public final String getRequestSessionKey() {
        return this.requestSessionKey;
    }

    /* renamed from: d, reason: from getter */
    public final String getSubSessionKey() {
        return this.subSessionKey;
    }

    /* renamed from: e, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskSessionLink)) {
            return false;
        }
        TaskSessionLink taskSessionLink = (TaskSessionLink) other;
        return p.d(this.subSessionKey, taskSessionLink.subSessionKey) && p.d(this.requestSessionKey, taskSessionLink.requestSessionKey) && p.d(this.taskId, taskSessionLink.taskId) && p.d(this.agentId, taskSessionLink.agentId) && this.cardTime == taskSessionLink.cardTime && this.updatedAt == taskSessionLink.updatedAt;
    }

    /* renamed from: f, reason: from getter */
    public final long getUpdatedAt() {
        return this.updatedAt;
    }

    public int hashCode() {
        return (((((((((this.subSessionKey.hashCode() * 31) + this.requestSessionKey.hashCode()) * 31) + this.taskId.hashCode()) * 31) + this.agentId.hashCode()) * 31) + Long.hashCode(this.cardTime)) * 31) + Long.hashCode(this.updatedAt);
    }

    public String toString() {
        return "TaskSessionLink(subSessionKey=" + this.subSessionKey + ", requestSessionKey=" + this.requestSessionKey + ", taskId=" + this.taskId + ", agentId=" + this.agentId + ", cardTime=" + this.cardTime + ", updatedAt=" + this.updatedAt + ")";
    }

    public /* synthetic */ TaskSessionLink(String str, String str2, String str3, String str4, long j10, long j11, int i10, kotlin.jvm.internal.i iVar) {
        this(str, str2, str3, str4, j10, (i10 & 32) != 0 ? System.currentTimeMillis() : j11);
    }
}
