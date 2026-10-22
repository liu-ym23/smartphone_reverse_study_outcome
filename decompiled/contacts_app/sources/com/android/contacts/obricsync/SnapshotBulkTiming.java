package com.android.contacts.obricsync;

import kotlin.Metadata;

/* JADX INFO: compiled from: ObricSyncSnapshotBulkConverger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001d"}, d2 = {"Lcom/android/contacts/obricsync/SnapshotBulkTiming;", "", "scanMs", "", "setDeletedMs", "refreshMs", "deleteMs", "totalMs", "(JJJJJ)V", "getDeleteMs", "()J", "getRefreshMs", "getScanMs", "getSetDeletedMs", "getTotalMs", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toLogString", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapshotBulkTiming {
    private final long deleteMs;
    private final long refreshMs;
    private final long scanMs;
    private final long setDeletedMs;
    private final long totalMs;

    public static /* synthetic */ SnapshotBulkTiming copy$default(SnapshotBulkTiming r11, long r12, long r14, long r16, long r18, long r20, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        long r1 = r11.scanMs;
    L7:
        if ((r22 & 2) == 0) goto L9;
        long r3 = r11.setDeletedMs;
    L11:
        if ((r22 & 4) == 0) goto L13;
        long r5 = r11.refreshMs;
    L15:
        if ((r22 & 8) == 0) goto L17;
        long r7 = r11.deleteMs;
    L19:
        if ((r22 & 16) == 0) goto L21;
        long r9 = r11.totalMs;
    L23:
        return r11.copy(r1, r3, r5, r7, r9);
    L21:
        r9 = r20;
        goto L23
    L17:
        r7 = r18;
        goto L19
    L13:
        r5 = r16;
        goto L15
    L9:
        r3 = r14;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }

    public final long component1() {
        return this.scanMs;
    }

    public final long component2() {
        return this.setDeletedMs;
    }

    public final long component3() {
        return this.refreshMs;
    }

    public final long component4() {
        return this.deleteMs;
    }

    public final long component5() {
        return this.totalMs;
    }

    public final SnapshotBulkTiming copy(long r13, long r15, long r17, long r19, long r21) {
        return new SnapshotBulkTiming(r13, r15, r17, r19, r21);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SnapshotBulkTiming) == true) goto L8;
        return false;
    L8:
        SnapshotBulkTiming r9 = (SnapshotBulkTiming) r8;
        if (this.scanMs == r9.scanMs) goto L12;
        return false;
    L12:
        if (this.setDeletedMs == r9.setDeletedMs) goto L15;
        return false;
    L15:
        if (this.refreshMs == r9.refreshMs) goto L18;
        return false;
    L18:
        if (this.deleteMs == r9.deleteMs) goto L21;
        return false;
    L21:
        if (this.totalMs == r9.totalMs) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.scanMs) * 31) + Long.hashCode(this.setDeletedMs)) * 31) + Long.hashCode(this.refreshMs)) * 31) + Long.hashCode(this.deleteMs)) * 31) + Long.hashCode(this.totalMs);
    }

    public String toString() {
        return "SnapshotBulkTiming(scanMs=" + this.scanMs + ", setDeletedMs=" + this.setDeletedMs + ", refreshMs=" + this.refreshMs + ", deleteMs=" + this.deleteMs + ", totalMs=" + this.totalMs + ')';
    }

    public SnapshotBulkTiming(long r1, long r3, long r5, long r7, long r9) {
        this.scanMs = r1;
        this.setDeletedMs = r3;
        this.refreshMs = r5;
        this.deleteMs = r7;
        this.totalMs = r9;
    }

    public final long getScanMs() {
        return this.scanMs;
    }

    public final long getSetDeletedMs() {
        return this.setDeletedMs;
    }

    public final long getRefreshMs() {
        return this.refreshMs;
    }

    public final long getDeleteMs() {
        return this.deleteMs;
    }

    public final long getTotalMs() {
        return this.totalMs;
    }

    public final String toLogString() {
        return "scanMs=" + this.scanMs + ",setDeletedMs=" + this.setDeletedMs + ",refreshMs=" + this.refreshMs + ",deleteMs=" + this.deleteMs + ",totalMs=" + this.totalMs;
    }
}
