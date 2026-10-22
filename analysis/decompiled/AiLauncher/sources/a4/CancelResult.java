package a4;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b!\b\u0086\b\u0018\u0000 32\u00020\u0001:\u0001\u0019Bg\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001bR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0012R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b'\u0010%\u001a\u0004\b(\u0010\u0012R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b-\u0010%\u001a\u0004\b.\u0010\u0012R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"La4/p;", "", "", "ok", "La4/A;", "task", "", "", "skippedSubtaskIds", "killMethod", "killKey", "killOk", "killStatus", "La4/t;", "error", "<init>", "(ZLa4/A;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;La4/t;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Z", "()Z", Const.INTENT_KEY_PKGNAME, "La4/A;", "getTask", "()La4/A;", "c", "Ljava/util/List;", "getSkippedSubtaskIds", "()Ljava/util/List;", Const.INTENT_KEY_UMID, "Ljava/lang/String;", "getKillMethod", "e", "getKillKey", "f", "Ljava/lang/Boolean;", "getKillOk", "()Ljava/lang/Boolean;", Const.INTENT_KEY_BACKGROUND_COMMAND, "getKillStatus", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "La4/t;", "getError", "()La4/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a4.p, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class CancelResult {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean ok;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final Task task;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<String> skippedSubtaskIds;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final String killMethod;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final String killKey;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final Boolean killOk;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final String killStatus;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    public final ErrorShape error;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"La4/p$a;", "", "<init>", "()V", "", "code", "message", "La4/p;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)La4/p;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: a4.p$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final CancelResult a(String code, String message) {
            kotlin.jvm.internal.p.i(code, "code");
            kotlin.jvm.internal.p.i(message, "message");
            return new CancelResult(false, null, C1173v.m(), null, null, null, null, new ErrorShape(code, message));
        }

        public Companion() {
        }
    }

    public CancelResult(boolean z10, Task task, List<String> skippedSubtaskIds, String str, String str2, Boolean bool, String str3, ErrorShape errorShape) {
        kotlin.jvm.internal.p.i(skippedSubtaskIds, "skippedSubtaskIds");
        this.ok = z10;
        this.task = task;
        this.skippedSubtaskIds = skippedSubtaskIds;
        this.killMethod = str;
        this.killKey = str2;
        this.killOk = bool;
        this.killStatus = str3;
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
        if (!(other instanceof CancelResult)) {
            return false;
        }
        CancelResult cancelResult = (CancelResult) other;
        return this.ok == cancelResult.ok && kotlin.jvm.internal.p.d(this.task, cancelResult.task) && kotlin.jvm.internal.p.d(this.skippedSubtaskIds, cancelResult.skippedSubtaskIds) && kotlin.jvm.internal.p.d(this.killMethod, cancelResult.killMethod) && kotlin.jvm.internal.p.d(this.killKey, cancelResult.killKey) && kotlin.jvm.internal.p.d(this.killOk, cancelResult.killOk) && kotlin.jvm.internal.p.d(this.killStatus, cancelResult.killStatus) && kotlin.jvm.internal.p.d(this.error, cancelResult.error);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.ok) * 31;
        Task task = this.task;
        int iHashCode2 = (((iHashCode + (task == null ? 0 : task.hashCode())) * 31) + this.skippedSubtaskIds.hashCode()) * 31;
        String str = this.killMethod;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.killKey;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.killOk;
        int iHashCode5 = (iHashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.killStatus;
        int iHashCode6 = (iHashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        ErrorShape errorShape = this.error;
        return iHashCode6 + (errorShape != null ? errorShape.hashCode() : 0);
    }

    public String toString() {
        return "CancelResult(ok=" + this.ok + ", task=" + this.task + ", skippedSubtaskIds=" + this.skippedSubtaskIds + ", killMethod=" + this.killMethod + ", killKey=" + this.killKey + ", killOk=" + this.killOk + ", killStatus=" + this.killStatus + ", error=" + this.error + ")";
    }
}
