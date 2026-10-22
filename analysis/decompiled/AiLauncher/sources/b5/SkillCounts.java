package b5;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0004\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\rR\u001a\u0010\u0005\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u0006\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0016\u0010\r¨\u0006\u0017"}, d2 = {"Lb5/h;", "", "", "total", "installed", x5.d.EXTRA_ENABLED, "disabled", "<init>", "(IIII)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", "getTotal", "getInstalled", "getEnabled", "getDisabled", "agent_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: b5.h, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class SkillCounts {

    @SerializedName("disabled")
    private final int disabled;

    @SerializedName(x5.d.EXTRA_ENABLED)
    private final int enabled;

    @SerializedName("installed")
    private final int installed;

    @SerializedName("total")
    private final int total;

    public SkillCounts() {
        this(0, 0, 0, 0, 15, null);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SkillCounts)) {
            return false;
        }
        SkillCounts skillCounts = (SkillCounts) other;
        return this.total == skillCounts.total && this.installed == skillCounts.installed && this.enabled == skillCounts.enabled && this.disabled == skillCounts.disabled;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.total) * 31) + Integer.hashCode(this.installed)) * 31) + Integer.hashCode(this.enabled)) * 31) + Integer.hashCode(this.disabled);
    }

    public String toString() {
        return "SkillCounts(total=" + this.total + ", installed=" + this.installed + ", enabled=" + this.enabled + ", disabled=" + this.disabled + ")";
    }

    public SkillCounts(int i10, int i11, int i12, int i13) {
        this.total = i10;
        this.installed = i11;
        this.enabled = i12;
        this.disabled = i13;
    }

    public /* synthetic */ SkillCounts(int i10, int i11, int i12, int i13, int i14, kotlin.jvm.internal.i iVar) {
        this((i14 & 1) != 0 ? 0 : i10, (i14 & 2) != 0 ? 0 : i11, (i14 & 4) != 0 ? 0 : i12, (i14 & 8) != 0 ? 0 : i13);
    }
}
