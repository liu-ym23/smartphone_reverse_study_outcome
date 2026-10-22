package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u000fR%\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u001e\u0010\u000fR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u001f\u0010\u000fR\u0019\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b \u0010\u000fR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0016\u001a\u0004\b!\u0010\u000f¨\u0006\""}, d2 = {"LK6/H;", "", "", "taskId", "", "answers", "", "cancel", "reason", "label", "freeText", "idempotencyKey", "<init>", "(Ljava/lang/String;Ljava/util/Map;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "Ljava/util/Map;", Const.INTENT_KEY_APIKEY, "()Ljava/util/Map;", "Z", Const.INTENT_KEY_PKGNAME, "()Z", "f", "e", "c", Const.INTENT_KEY_UMID, "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.H, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class TaskInteractRequest {
    private final Map<String, Object> answers;
    private final boolean cancel;
    private final String freeText;
    private final String idempotencyKey;
    private final String label;
    private final String reason;
    private final String taskId;

    public TaskInteractRequest(String taskId, Map<String, ? extends Object> map, boolean z10, String str, String str2, String str3, String str4) {
        p.i(taskId, "taskId");
        this.taskId = taskId;
        this.answers = map;
        this.cancel = z10;
        this.reason = str;
        this.label = str2;
        this.freeText = str3;
        this.idempotencyKey = str4;
    }

    public final Map<String, Object> a() {
        return this.answers;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getCancel() {
        return this.cancel;
    }

    /* renamed from: c, reason: from getter */
    public final String getFreeText() {
        return this.freeText;
    }

    /* renamed from: d, reason: from getter */
    public final String getIdempotencyKey() {
        return this.idempotencyKey;
    }

    /* renamed from: e, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TaskInteractRequest)) {
            return false;
        }
        TaskInteractRequest taskInteractRequest = (TaskInteractRequest) other;
        return p.d(this.taskId, taskInteractRequest.taskId) && p.d(this.answers, taskInteractRequest.answers) && this.cancel == taskInteractRequest.cancel && p.d(this.reason, taskInteractRequest.reason) && p.d(this.label, taskInteractRequest.label) && p.d(this.freeText, taskInteractRequest.freeText) && p.d(this.idempotencyKey, taskInteractRequest.idempotencyKey);
    }

    /* renamed from: f, reason: from getter */
    public final String getReason() {
        return this.reason;
    }

    /* renamed from: g, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    public int hashCode() {
        int iHashCode = this.taskId.hashCode() * 31;
        Map<String, Object> map = this.answers;
        int iHashCode2 = (((iHashCode + (map == null ? 0 : map.hashCode())) * 31) + Boolean.hashCode(this.cancel)) * 31;
        String str = this.reason;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.label;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.freeText;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.idempotencyKey;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public String toString() {
        return "TaskInteractRequest(taskId=" + this.taskId + ", answers=" + this.answers + ", cancel=" + this.cancel + ", reason=" + this.reason + ", label=" + this.label + ", freeText=" + this.freeText + ", idempotencyKey=" + this.idempotencyKey + ")";
    }

    public /* synthetic */ TaskInteractRequest(String str, Map map, boolean z10, String str2, String str3, String str4, String str5, int i10, i iVar) {
        this(str, (i10 & 2) != 0 ? null : map, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? null : str2, (i10 & 16) != 0 ? null : str3, (i10 & 32) != 0 ? null : str4, (i10 & 64) != 0 ? null : str5);
    }
}
