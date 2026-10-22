package com.android.contacts.obricsync;

import com.android.contacts.ContactSaveService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: compiled from: ObricSyncSnapshotBulkConverger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\fH&J\u0016\u0010\r\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\u000e"}, d2 = {"Lcom/android/contacts/obricsync/SnapshotBulkConvergeGateway;", "", "deleteSnapshots", "", "dataIds", "", "", "refreshCanonical", "", ContactSaveService.EXTRA_CONTACT_ID, ContactSaveService.EXTRA_DATA_ID, "scanDuplicateGroups", "Lcom/android/contacts/obricsync/SnapshotBulkPlan;", "stageDeleted", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SnapshotBulkConvergeGateway {
    int deleteSnapshots(List<Long> r1);

    void refreshCanonical(long r1, long r3);

    SnapshotBulkPlan scanDuplicateGroups();

    void stageDeleted(List<Long> r1);
}
