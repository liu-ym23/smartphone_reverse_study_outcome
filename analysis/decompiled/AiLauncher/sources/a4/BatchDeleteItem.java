package a4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0014\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"La4/m;", "", "", "taskId", "", "ok", "", "deletedAt", "La4/t;", "error", "<init>", "(Ljava/lang/String;ZLjava/lang/Long;La4/t;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/lang/String;", "getTaskId", Const.INTENT_KEY_PKGNAME, "Z", "()Z", "c", "Ljava/lang/Long;", "getDeletedAt", "()Ljava/lang/Long;", Const.INTENT_KEY_UMID, "La4/t;", "getError", "()La4/t;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a4.m, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class BatchDeleteItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final String taskId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean ok;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final Long deletedAt;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final ErrorShape error;

    public BatchDeleteItem(String taskId, boolean z10, Long l10, ErrorShape errorShape) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        this.taskId = taskId;
        this.ok = z10;
        this.deletedAt = l10;
        this.error = errorShape;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getOk() {
        return this.ok;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatchDeleteItem)) {
            return false;
        }
        BatchDeleteItem batchDeleteItem = (BatchDeleteItem) other;
        return kotlin.jvm.internal.p.d(this.taskId, batchDeleteItem.taskId) && this.ok == batchDeleteItem.ok && kotlin.jvm.internal.p.d(this.deletedAt, batchDeleteItem.deletedAt) && kotlin.jvm.internal.p.d(this.error, batchDeleteItem.error);
    }

    public int hashCode() {
        int iHashCode = ((this.taskId.hashCode() * 31) + Boolean.hashCode(this.ok)) * 31;
        Long l10 = this.deletedAt;
        int iHashCode2 = (iHashCode + (l10 == null ? 0 : l10.hashCode())) * 31;
        ErrorShape errorShape = this.error;
        return iHashCode2 + (errorShape != null ? errorShape.hashCode() : 0);
    }

    public String toString() {
        return "BatchDeleteItem(taskId=" + this.taskId + ", ok=" + this.ok + ", deletedAt=" + this.deletedAt + ", error=" + this.error + ")";
    }
}
