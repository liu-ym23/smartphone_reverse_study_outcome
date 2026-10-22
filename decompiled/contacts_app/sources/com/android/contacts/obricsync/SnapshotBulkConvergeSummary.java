package com.android.contacts.obricsync;

import kotlin.Metadata;

/* JADX INFO: compiled from: ObricSyncSnapshotBulkConverger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0006\u0010\u0016\u001a\u00020\u0017J\t\u0010\u0018\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/android/contacts/obricsync/SnapshotBulkConvergeSummary;", "", "groupCount", "", "redundantCount", "canonicalCount", "deletedCount", "(IIII)V", "getCanonicalCount", "()I", "getDeletedCount", "getGroupCount", "getRedundantCount", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toLogString", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapshotBulkConvergeSummary {
    private final int canonicalCount;
    private final int deletedCount;
    private final int groupCount;
    private final int redundantCount;

    public static /* synthetic */ SnapshotBulkConvergeSummary copy$default(SnapshotBulkConvergeSummary r0, int r1, int r2, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.groupCount;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.redundantCount;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.canonicalCount;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.deletedCount;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.groupCount;
    }

    public final int component2() {
        return this.redundantCount;
    }

    public final int component3() {
        return this.canonicalCount;
    }

    public final int component4() {
        return this.deletedCount;
    }

    public final SnapshotBulkConvergeSummary copy(int r1, int r2, int r3, int r4) {
        return new SnapshotBulkConvergeSummary(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SnapshotBulkConvergeSummary) == true) goto L8;
        return false;
    L8:
        SnapshotBulkConvergeSummary r6 = (SnapshotBulkConvergeSummary) r5;
        if (this.groupCount == r6.groupCount) goto L12;
        return false;
    L12:
        if (this.redundantCount == r6.redundantCount) goto L15;
        return false;
    L15:
        if (this.canonicalCount == r6.canonicalCount) goto L18;
        return false;
    L18:
        if (this.deletedCount == r6.deletedCount) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.groupCount) * 31) + Integer.hashCode(this.redundantCount)) * 31) + Integer.hashCode(this.canonicalCount)) * 31) + Integer.hashCode(this.deletedCount);
    }

    public String toString() {
        return "SnapshotBulkConvergeSummary(groupCount=" + this.groupCount + ", redundantCount=" + this.redundantCount + ", canonicalCount=" + this.canonicalCount + ", deletedCount=" + this.deletedCount + ')';
    }

    public SnapshotBulkConvergeSummary(int r1, int r2, int r3, int r4) {
        this.groupCount = r1;
        this.redundantCount = r2;
        this.canonicalCount = r3;
        this.deletedCount = r4;
    }

    public final int getGroupCount() {
        return this.groupCount;
    }

    public final int getRedundantCount() {
        return this.redundantCount;
    }

    public final int getCanonicalCount() {
        return this.canonicalCount;
    }

    public final int getDeletedCount() {
        return this.deletedCount;
    }

    public final String toLogString() {
        return "groups=" + this.groupCount + ",redundant=" + this.redundantCount + ",canonical=" + this.canonicalCount + ",deleted=" + this.deletedCount;
    }
}
