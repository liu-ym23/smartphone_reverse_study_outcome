package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0017\u0010\n¨\u0006\u0018"}, d2 = {"LK6/E;", "", "", "", "taskIds", "reason", "idempotencyKey", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "c", "()Ljava/util/List;", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.E, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TaskBatchDeleteRequest {
    private final String idempotencyKey;
    private final String reason;
    private final List<String> taskIds;

    public TaskBatchDeleteRequest(List<String> taskIds, String str, String str2) {
        p.i(taskIds, "taskIds");
        this.taskIds = taskIds;
        this.reason = str;
        this.idempotencyKey = str2;
    }

    /* renamed from: a, reason: from getter */
    public final String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /* renamed from: b, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    public final List<String> c() {
        return this.taskIds;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskBatchDeleteRequest)) {
            return false;
        }
        TaskBatchDeleteRequest taskBatchDeleteRequest = (TaskBatchDeleteRequest) other;
        return p.d(this.taskIds, taskBatchDeleteRequest.taskIds) && p.d(this.reason, taskBatchDeleteRequest.reason) && p.d(this.idempotencyKey, taskBatchDeleteRequest.idempotencyKey);
    }

    public int hashCode() {
        int iHashCode = this.taskIds.hashCode() * 31;
        String str = this.reason;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.idempotencyKey;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "TaskBatchDeleteRequest(taskIds=" + this.taskIds + ", reason=" + this.reason + ", idempotencyKey=" + this.idempotencyKey + ")";
    }

    public /* synthetic */ TaskBatchDeleteRequest(List list, String str, String str2, int i10, i iVar) {
        this(list, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2);
    }
}
