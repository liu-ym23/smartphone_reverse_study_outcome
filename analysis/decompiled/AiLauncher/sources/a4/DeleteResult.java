package a4;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001d\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001\u0018BW\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0018\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0011R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b&\u0010\u0019\u001a\u0004\b'\u0010\u001aR\u0017\u0010\u000b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b(\u0010\u0019\u001a\u0004\b)\u0010\u001aR\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u0006/"}, d2 = {"La4/s;", "", "", "ok", "", "taskId", "", "deletedAt", "", "deletedIds", "sessionDeleted", "artifactsDeleted", "La4/t;", "error", "<init>", "(ZLjava/lang/String;Ljava/lang/Long;Ljava/util/List;ZZLa4/t;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Z", "()Z", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "getTaskId", "c", "Ljava/lang/Long;", "getDeletedAt", "()Ljava/lang/Long;", Const.INTENT_KEY_UMID, "Ljava/util/List;", "getDeletedIds", "()Ljava/util/List;", "e", "getSessionDeleted", "f", "getArtifactsDeleted", Const.INTENT_KEY_BACKGROUND_COMMAND, "La4/t;", "getError", "()La4/t;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: a4.s, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class DeleteResult {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean ok;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final String taskId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final Long deletedAt;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final List<String> deletedIds;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean sessionDeleted;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean artifactsDeleted;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    public final ErrorShape error;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"La4/s$a;", "", "<init>", "()V", "", "code", "message", "La4/s;", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;Ljava/lang/String;)La4/s;", "protocol_agentbus_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: a4.s$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        public final DeleteResult a(String code, String message) {
            kotlin.jvm.internal.p.i(code, "code");
            kotlin.jvm.internal.p.i(message, "message");
            return new DeleteResult(false, null, null, C1173v.m(), false, false, new ErrorShape(code, message));
        }

        public Companion() {
        }
    }

    public DeleteResult(boolean z10, String str, Long l10, List<String> deletedIds, boolean z11, boolean z12, ErrorShape errorShape) {
        kotlin.jvm.internal.p.i(deletedIds, "deletedIds");
        this.ok = z10;
        this.taskId = str;
        this.deletedAt = l10;
        this.deletedIds = deletedIds;
        this.sessionDeleted = z11;
        this.artifactsDeleted = z12;
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
        if (!(other instanceof DeleteResult)) {
            return false;
        }
        DeleteResult deleteResult = (DeleteResult) other;
        return this.ok == deleteResult.ok && kotlin.jvm.internal.p.d(this.taskId, deleteResult.taskId) && kotlin.jvm.internal.p.d(this.deletedAt, deleteResult.deletedAt) && kotlin.jvm.internal.p.d(this.deletedIds, deleteResult.deletedIds) && this.sessionDeleted == deleteResult.sessionDeleted && this.artifactsDeleted == deleteResult.artifactsDeleted && kotlin.jvm.internal.p.d(this.error, deleteResult.error);
    }

    public int hashCode() {
        int iHashCode = Boolean.hashCode(this.ok) * 31;
        String str = this.taskId;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l10 = this.deletedAt;
        int iHashCode3 = (((((((iHashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31) + this.deletedIds.hashCode()) * 31) + Boolean.hashCode(this.sessionDeleted)) * 31) + Boolean.hashCode(this.artifactsDeleted)) * 31;
        ErrorShape errorShape = this.error;
        return iHashCode3 + (errorShape != null ? errorShape.hashCode() : 0);
    }

    public String toString() {
        return "DeleteResult(ok=" + this.ok + ", taskId=" + this.taskId + ", deletedAt=" + this.deletedAt + ", deletedIds=" + this.deletedIds + ", sessionDeleted=" + this.sessionDeleted + ", artifactsDeleted=" + this.artifactsDeleted + ", error=" + this.error + ")";
    }
}
