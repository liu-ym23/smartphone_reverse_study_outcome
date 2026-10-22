package com.android.contacts.obricsync;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.Sequence;

/* JADX INFO: compiled from: ObricSyncSnapshotBulkConverger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"SNAPSHOT_BULK_CONVERGE_CHUNK_SIZE", "", "planBulkConvergence", "Lcom/android/contacts/obricsync/SnapshotBulkPlan;", "rows", "Lkotlin/sequences/Sequence;", "Lcom/android/contacts/obricsync/SnapshotRow;", "app_QssiCnRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ObricSyncSnapshotBulkConvergerKt {
    public static final int SNAPSHOT_BULK_CONVERGE_CHUNK_SIZE = 1000;

    public static final SnapshotBulkPlan planBulkConvergence(Sequence<SnapshotRow> r9) {
        Intrinsics.checkNotNullParameter(r9, "rows");
        Ref.LongRef r0 = new Ref.LongRef();
        r0.element = -1;
        Ref.LongRef r3 = new Ref.LongRef();
        r3.element = -1;
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator<SnapshotRow> r10 = r9.iterator();
    L4:
        if (r10.hasNext() == false) goto L14;
        SnapshotRow r4 = r10.next();
        if (r4.getContactId() <= 0) goto L4;
        if (r4.getDataId() <= 0) goto L4;
        if (r4.getContactId() != r0.element) goto L12;
        r1.add(Long.valueOf(r4.getDataId()));
        goto L4
    L12:
        planBulkConvergence$flushGroup(r1, r2, r0, r3);
        r0.element = r4.getContactId();
        r3.element = r4.getDataId();
        goto L4
    L14:
        planBulkConvergence$flushGroup(r1, r2, r0, r3);
        return new SnapshotBulkPlan(r2);
    }

    private static final void planBulkConvergence$flushGroup(ArrayList<Long> r7, ArrayList<SnapshotBulkGroup> r8, Ref.LongRef r9, Ref.LongRef r10) {
        if (r7.isEmpty() == false) goto L5;
        return;
    L5:
        r8.add(new SnapshotBulkGroup(r9.element, r10.element, CollectionsKt.toList(r7)));
        r7.clear();
    }
}
