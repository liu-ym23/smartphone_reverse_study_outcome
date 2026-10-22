package com.android.contacts.obricsync;

import com.android.contacts.ContactSaveService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObricSyncSnapshotBulkConverger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0003J-\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/android/contacts/obricsync/SnapshotBulkGroup;", "", ContactSaveService.EXTRA_CONTACT_ID, "", "canonicalId", "redundantIds", "", "(JJLjava/util/List;)V", "getCanonicalId", "()J", "getContactId", "getRedundantIds", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapshotBulkGroup {
    private final long canonicalId;
    private final long contactId;
    private final List<Long> redundantIds;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SnapshotBulkGroup copy$default(SnapshotBulkGroup r6, long r7, long r9, List r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.contactId;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.canonicalId;
    L8:
        long r3 = r9;
        if ((r12 & 4) == 0) goto L12;
        r11 = r6.redundantIds;
    L12:
        return r6.copy(r1, r3, r11);
    }

    public final long component1() {
        return this.contactId;
    }

    public final long component2() {
        return this.canonicalId;
    }

    public final List<Long> component3() {
        return this.redundantIds;
    }

    public final SnapshotBulkGroup copy(long r7, long r9, List<Long> r11) {
        Intrinsics.checkNotNullParameter(r11, "redundantIds");
        return new SnapshotBulkGroup(r7, r9, r11);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SnapshotBulkGroup) == true) goto L8;
        return false;
    L8:
        SnapshotBulkGroup r9 = (SnapshotBulkGroup) r8;
        if (this.contactId == r9.contactId) goto L12;
        return false;
    L12:
        if (this.canonicalId == r9.canonicalId) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.redundantIds, r9.redundantIds) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((Long.hashCode(this.contactId) * 31) + Long.hashCode(this.canonicalId)) * 31) + this.redundantIds.hashCode();
    }

    public String toString() {
        return "SnapshotBulkGroup(contactId=" + this.contactId + ", canonicalId=" + this.canonicalId + ", redundantIds=" + this.redundantIds + ')';
    }

    public SnapshotBulkGroup(long r2, long r4, List<Long> r6) {
        Intrinsics.checkNotNullParameter(r6, "redundantIds");
        this.contactId = r2;
        this.canonicalId = r4;
        this.redundantIds = r6;
    }

    public final long getContactId() {
        return this.contactId;
    }

    public final long getCanonicalId() {
        return this.canonicalId;
    }

    public final List<Long> getRedundantIds() {
        return this.redundantIds;
    }
}
