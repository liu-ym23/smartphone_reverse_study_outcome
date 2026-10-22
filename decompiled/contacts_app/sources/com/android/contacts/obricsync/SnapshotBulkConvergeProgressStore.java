package com.android.contacts.obricsync;

import android.content.Context;
import android.content.SharedPreferences;
import com.obric.callsummary.widget.CallSummaryWidget;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ObricSyncSnapshotBulkConverger.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/contacts/obricsync/SnapshotBulkConvergeProgressStore;", "Lcom/android/contacts/obricsync/SnapshotBulkConvergeStore;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "markComplete", "", CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY, "Lcom/android/contacts/obricsync/SnapshotBulkConvergeSummary;", "markRunning", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SnapshotBulkConvergeProgressStore implements SnapshotBulkConvergeStore {
    private final SharedPreferences prefs;

    public SnapshotBulkConvergeProgressStore(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this.prefs = r3.getSharedPreferences("obric_sync_snapshot_bulk_converge", 0);
    }

    @Override // com.android.contacts.obricsync.SnapshotBulkConvergeStore
    public boolean markRunning() {
        return this.prefs.edit().putBoolean("running", true).putLong("started_at", System.currentTimeMillis()).commit();
    }

    @Override // com.android.contacts.obricsync.SnapshotBulkConvergeStore
    public boolean markComplete(SnapshotBulkConvergeSummary r3) {
        Intrinsics.checkNotNullParameter(r3, CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY);
        return this.prefs.edit().putBoolean("running", false).putString("last_summary", r3.toLogString()).putLong("finished_at", System.currentTimeMillis()).commit();
    }
}
