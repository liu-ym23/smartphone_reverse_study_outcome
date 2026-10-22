package com.android.contacts.obricsync;

import com.android.contacts.ContactSaveService;
import kotlin.Metadata;

/* JADX INFO: compiled from: ObricSyncSnapshotBulkConverger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/android/contacts/obricsync/SnapshotRow;", "", ContactSaveService.EXTRA_CONTACT_ID, "", ContactSaveService.EXTRA_DATA_ID, "(JJ)V", "getContactId", "()J", "getDataId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapshotRow {
    private final long contactId;
    private final long dataId;

    public static /* synthetic */ SnapshotRow copy$default(SnapshotRow r0, long r1, long r3, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.contactId;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.dataId;
    L9:
        return r0.copy(r1, r3);
    }

    public final long component1() {
        return this.contactId;
    }

    public final long component2() {
        return this.dataId;
    }

    public final SnapshotRow copy(long r1, long r3) {
        return new SnapshotRow(r1, r3);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SnapshotRow) == true) goto L8;
        return false;
    L8:
        SnapshotRow r9 = (SnapshotRow) r8;
        if (this.contactId == r9.contactId) goto L12;
        return false;
    L12:
        if (this.dataId == r9.dataId) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (Long.hashCode(this.contactId) * 31) + Long.hashCode(this.dataId);
    }

    public String toString() {
        return "SnapshotRow(contactId=" + this.contactId + ", dataId=" + this.dataId + ')';
    }

    public SnapshotRow(long r1, long r3) {
        this.contactId = r1;
        this.dataId = r3;
    }

    public final long getContactId() {
        return this.contactId;
    }

    public final long getDataId() {
        return this.dataId;
    }
}
