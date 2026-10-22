package bs8;

import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.BarrageMaskInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\fJ&\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/taskskill/model/RecordExposedSkillResponse;", "", "recorded", "", "updatedAt", "", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Long;)V", "getRecorded", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getUpdatedAt", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;)Lcom/larus/bmhome/taskskill/model/RecordExposedSkillResponse;", "equals", "other", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class k {

    @SerializedName("recorded")
    private final Boolean recorded;

    @SerializedName(BarrageMaskInfo.KEY_MASK_UPDATED_AT)
    private final Long updatedAt;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (Intrinsics.areEqual(this.recorded, r101.recorded) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.updatedAt, r101.updatedAt) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.recorded;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Long r104 = this.updatedAt;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "RecordExposedSkillResponse(recorded=" + this.recorded + ", updatedAt=" + this.updatedAt + ')';
    }

    public k() {
        this.recorded = null;
        this.updatedAt = null;
    }

    public final Boolean a() {
        return this.recorded;
    }
}
