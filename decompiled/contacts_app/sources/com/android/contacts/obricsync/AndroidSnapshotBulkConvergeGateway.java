package com.android.contacts.obricsync;

import android.content.Context;
import android.database.Cursor;
import com.android.contacts.ContactSaveService;
import com.android.contacts.common.SimContactsConstants;
import com.obric.cloudsdk.kv.base.KvSyncManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: compiled from: ObricSyncSnapshotBulkConverger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\u00020\u000b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/contacts/obricsync/AndroidSnapshotBulkConvergeGateway;", "Lcom/android/contacts/obricsync/SnapshotBulkConvergeGateway;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "deleteSnapshots", "", "dataIds", "", "", "refreshCanonical", "", ContactSaveService.EXTRA_CONTACT_ID, ContactSaveService.EXTRA_DATA_ID, "scanDuplicateGroups", "Lcom/android/contacts/obricsync/SnapshotBulkPlan;", "stageDeleted", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AndroidSnapshotBulkConvergeGateway implements SnapshotBulkConvergeGateway {
    private final Context context;

    public AndroidSnapshotBulkConvergeGateway(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.context = r2;
    }

    @Override // com.android.contacts.obricsync.SnapshotBulkConvergeGateway
    public SnapshotBulkPlan scanDuplicateGroups() {
        Cursor r0 = this.context.getContentResolver().query(SyncContractKt.getContactSyncUri(), new String[]{"contact_id", "_id"}, null, null, "contact_id ASC, _id ASC");
        if (r0 == null) goto L5;
        Cursor r1 = r0;
        Cursor r2 = r1;     // Catch: Throwable -> L10
        SnapshotBulkPlan r7 = ObricSyncSnapshotBulkConvergerKt.planBulkConvergence(SequencesKt.sequence(new AndroidSnapshotBulkConvergeGateway$scanDuplicateGroups$1$rows$1(r2, r2.getColumnIndexOrThrow("contact_id"), r2.getColumnIndexOrThrow("_id"), null)));     // Catch: Throwable -> L10
        CloseableKt.closeFinally(r1, null);
        return r7;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);
        throw th;
    L5:
        return new SnapshotBulkPlan(CollectionsKt.emptyList());
    }

    @Override // com.android.contacts.obricsync.SnapshotBulkConvergeGateway
    public void stageDeleted(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "dataIds");
        KvSyncManager.INSTANCE.setDeleted(r2, SyncContractKt.TAB_NAME_SYNC);
    }

    @Override // com.android.contacts.obricsync.SnapshotBulkConvergeGateway
    public void refreshCanonical(long r1, long r3) {
        LocalToSyncUtils.updateSnapshot2Sync(this.context, r1, r3);
    }

    @Override // com.android.contacts.obricsync.SnapshotBulkConvergeGateway
    public int deleteSnapshots(List<Long> r12) {
        Intrinsics.checkNotNullParameter(r12, "dataIds");
        if (r12.isEmpty() == false) goto L7;
        return 0;
    L7:
        return this.context.getContentResolver().delete(SyncContractKt.getContactSyncUri(), "_id IN (" + CollectionsKt.joinToString$default(r12, SimContactsConstants.EMAIL_SEP, null, null, 0, null, null, 62, null) + ')', null);
    }
}
