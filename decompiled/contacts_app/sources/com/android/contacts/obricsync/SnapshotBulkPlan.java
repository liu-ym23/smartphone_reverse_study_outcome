package com.android.contacts.obricsync;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObricSyncSnapshotBulkConverger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R#\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/android/contacts/obricsync/SnapshotBulkPlan;", "", "groups", "", "Lcom/android/contacts/obricsync/SnapshotBulkGroup;", "(Ljava/util/List;)V", "canonicalPairs", "Lkotlin/Pair;", "", "getCanonicalPairs", "()Ljava/util/List;", "getGroups", "redundantIds", "getRedundantIds", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapshotBulkPlan {
    private final List<Pair<Long, Long>> canonicalPairs;
    private final List<SnapshotBulkGroup> groups;
    private final List<Long> redundantIds;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SnapshotBulkPlan copy$default(SnapshotBulkPlan r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.groups;
    L6:
        return r0.copy(r1);
    }

    public final List<SnapshotBulkGroup> component1() {
        return this.groups;
    }

    public final SnapshotBulkPlan copy(List<SnapshotBulkGroup> r1) {
        Intrinsics.checkNotNullParameter(r1, "groups");
        return new SnapshotBulkPlan(r1);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof SnapshotBulkPlan) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.groups, ((SnapshotBulkPlan) r4).groups) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.groups.hashCode();
    }

    public String toString() {
        return "SnapshotBulkPlan(groups=" + this.groups + ')';
    }

    public SnapshotBulkPlan(List<SnapshotBulkGroup> r6) {
        Intrinsics.checkNotNullParameter(r6, "groups");
        this.groups = r6;
        ArrayList r0 = new ArrayList();
        Iterator<T> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        CollectionsKt.addAll(r0, ((SnapshotBulkGroup) r7.next()).getRedundantIds());
        goto L4
    L6:
        this.redundantIds = r0;
        List<SnapshotBulkGroup> r8 = this.groups;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r8, 10));
        Iterator<T> r9 = r8.iterator();
    L8:
        if (r9.hasNext() == false) goto L10;
        SnapshotBulkGroup r2 = (SnapshotBulkGroup) r9.next();
        r1.add(TuplesKt.to(Long.valueOf(r2.getContactId()), Long.valueOf(r2.getCanonicalId())));
        goto L8
    L10:
        this.canonicalPairs = r1;
    }

    public final List<SnapshotBulkGroup> getGroups() {
        return this.groups;
    }

    public final List<Long> getRedundantIds() {
        return this.redundantIds;
    }

    public final List<Pair<Long, Long>> getCanonicalPairs() {
        return this.canonicalPairs;
    }
}
