package a4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"La4/k;", "", "", "accepted", "La4/A;", "task", "La4/t;", "error", "<init>", "(ZLa4/A;La4/t;)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Z", "()Z", Const.INTENT_KEY_PKGNAME, "La4/A;", "getTask", "()La4/A;", "c", "La4/t;", "getError", "()La4/t;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a4.k, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class AnswerResult {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean accepted;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final Task task;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final ErrorShape error;

    public AnswerResult(boolean z10, Task task, ErrorShape errorShape) {
        this.accepted = z10;
        this.task = task;
        this.error = errorShape;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getAccepted() {
        return this.accepted;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnswerResult)) {
            return false;
        }
        AnswerResult answerResult = (AnswerResult) other;
        return this.accepted == answerResult.accepted && kotlin.jvm.internal.p.d(this.task, answerResult.task) && kotlin.jvm.internal.p.d(this.error, answerResult.error);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.accepted) * 31;
        Task task = this.task;
        int iHashCode2 = (iHashCode + (task == null ? 0 : task.hashCode())) * 31;
        ErrorShape errorShape = this.error;
        return iHashCode2 + (errorShape != null ? errorShape.hashCode() : 0);
    }

    public String toString() {
        return "AnswerResult(accepted=" + this.accepted + ", task=" + this.task + ", error=" + this.error + ")";
    }
}
