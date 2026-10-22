package kotlin;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u000eR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0015\u001a\u0004\b\u001d\u0010\u0017¨\u0006\u001e"}, d2 = {"LK6/D;", "", "", "LK6/B;", "messages", "", "success", "", "errorMessage", "LK6/x;", "taskCreates", "<init>", "(Ljava/util/List;ZLjava/lang/String;Ljava/util/List;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "()Ljava/util/List;", "Z", "c", "()Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.D, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SyncHistoryResult {
    private final String errorMessage;
    private final List<RemoteChatMessage> messages;
    private final boolean success;
    private final List<HistoryTaskCreateHint> taskCreates;

    public SyncHistoryResult() {
        this(null, false, null, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final List<RemoteChatMessage> b() {
        return this.messages;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getSuccess() {
        return this.success;
    }

    public final List<HistoryTaskCreateHint> d() {
        return this.taskCreates;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncHistoryResult)) {
            return false;
        }
        SyncHistoryResult syncHistoryResult = (SyncHistoryResult) other;
        return p.d(this.messages, syncHistoryResult.messages) && this.success == syncHistoryResult.success && p.d(this.errorMessage, syncHistoryResult.errorMessage) && p.d(this.taskCreates, syncHistoryResult.taskCreates);
    }

    public int hashCode() {
        int iHashCode = ((this.messages.hashCode() * 31) + Boolean.hashCode(this.success)) * 31;
        String str = this.errorMessage;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.taskCreates.hashCode();
    }

    public String toString() {
        return "SyncHistoryResult(messages=" + this.messages + ", success=" + this.success + ", errorMessage=" + this.errorMessage + ", taskCreates=" + this.taskCreates + ")";
    }

    public SyncHistoryResult(List<RemoteChatMessage> messages, boolean z10, String str, List<HistoryTaskCreateHint> taskCreates) {
        p.i(messages, "messages");
        p.i(taskCreates, "taskCreates");
        this.messages = messages;
        this.success = z10;
        this.errorMessage = str;
        this.taskCreates = taskCreates;
    }

    public /* synthetic */ SyncHistoryResult(List list, boolean z10, String str, List list2, int i10, i iVar) {
        this((i10 & 1) != 0 ? C1173v.m() : list, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? null : str, (i10 & 8) != 0 ? C1173v.m() : list2);
    }
}
