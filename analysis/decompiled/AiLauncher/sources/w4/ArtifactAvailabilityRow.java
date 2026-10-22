package w4;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lw4/b;", "", "", "fileId", "", "availability", "", "checkedAt", "<init>", "(Ljava/lang/String;IJ)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "c", "I", Const.INTENT_KEY_APIKEY, "J", Const.INTENT_KEY_PKGNAME, "()J", "chatcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* renamed from: w4.b, reason: case insensitive filesystem and from toString */
/* loaded from: classes2.dex */
public final /* data */ class ArtifactAvailabilityRow {
    private final int availability;
    private final long checkedAt;
    private final String fileId;

    public ArtifactAvailabilityRow(String fileId, int i10, long j10) {
        p.i(fileId, "fileId");
        this.fileId = fileId;
        this.availability = i10;
        this.checkedAt = j10;
    }

    /* renamed from: a, reason: from getter */
    public final int getAvailability() {
        return this.availability;
    }

    /* renamed from: b, reason: from getter */
    public final long getCheckedAt() {
        return this.checkedAt;
    }

    /* renamed from: c, reason: from getter */
    public final String getFileId() {
        return this.fileId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ArtifactAvailabilityRow)) {
            return false;
        }
        ArtifactAvailabilityRow artifactAvailabilityRow = (ArtifactAvailabilityRow) other;
        return p.d(this.fileId, artifactAvailabilityRow.fileId) && this.availability == artifactAvailabilityRow.availability && this.checkedAt == artifactAvailabilityRow.checkedAt;
    }

    public int hashCode() {
        return (((this.fileId.hashCode() * 31) + Integer.hashCode(this.availability)) * 31) + Long.hashCode(this.checkedAt);
    }

    public String toString() {
        return "ArtifactAvailabilityRow(fileId=" + this.fileId + ", availability=" + this.availability + ", checkedAt=" + this.checkedAt + ")";
    }
}
