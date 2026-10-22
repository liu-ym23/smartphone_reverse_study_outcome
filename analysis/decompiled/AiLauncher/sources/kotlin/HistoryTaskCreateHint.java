package kotlin;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\nR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\n¨\u0006\u0017"}, d2 = {"LK6/x;", "", "", "taskId", "childSessionKey", "type", "title", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, "c", "common_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: K6.x, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class HistoryTaskCreateHint {
    private final String childSessionKey;
    private final String taskId;
    private final String title;
    private final String type;

    public HistoryTaskCreateHint(String taskId, String str, String str2, String str3) {
        p.i(taskId, "taskId");
        this.taskId = taskId;
        this.childSessionKey = str;
        this.type = str2;
        this.title = str3;
    }

    /* renamed from: a, reason: from getter */
    public final String getChildSessionKey() {
        return this.childSessionKey;
    }

    /* renamed from: b, reason: from getter */
    public final String getTaskId() {
        return this.taskId;
    }

    /* renamed from: c, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: d, reason: from getter */
    public final String getType() {
        return this.type;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof HistoryTaskCreateHint)) {
            return false;
        }
        HistoryTaskCreateHint historyTaskCreateHint = (HistoryTaskCreateHint) other;
        return p.d(this.taskId, historyTaskCreateHint.taskId) && p.d(this.childSessionKey, historyTaskCreateHint.childSessionKey) && p.d(this.type, historyTaskCreateHint.type) && p.d(this.title, historyTaskCreateHint.title);
    }

    public int hashCode() {
        int iHashCode = this.taskId.hashCode() * 31;
        String str = this.childSessionKey;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.type;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.title;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        return "HistoryTaskCreateHint(taskId=" + this.taskId + ", childSessionKey=" + this.childSessionKey + ", type=" + this.type + ", title=" + this.title + ")";
    }
}
