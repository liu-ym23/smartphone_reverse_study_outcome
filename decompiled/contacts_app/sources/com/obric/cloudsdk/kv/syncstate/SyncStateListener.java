package com.obric.cloudsdk.kv.syncstate;

import android.os.Bundle;
import com.android.contacts.ContactSaveService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SyncStateListener.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0016J0\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0005H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0016¨\u0006\u001c"}, d2 = {"Lcom/obric/cloudsdk/kv/syncstate/SyncStateListener;", "", "onFileTaskInit", "", "localUpsertCount", "", "localDeleteCount", "cloudUpsertCount", "cloudDeleteCount", "onFileTaskProgress", "taskType", "uniqueId", "", "cloudId", "failCode", "failMsg", "onSwitchChanged", "enabled", "", "onSyncSettingsChanged", "onSyncStateChanged", "state", "extra", "Landroid/os/Bundle;", "tryRenameLocalFile", ContactSaveService.EXTRA_DATA_ID, "", "newFileName", "cloudsdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SyncStateListener {

    /* JADX INFO: compiled from: SyncStateListener.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void onFileTaskInit(SyncStateListener r0, int r1, int r2, int r3, int r4) {
        }

        public static void onFileTaskProgress(SyncStateListener r0, int r1, String r2, String r3, int r4, String r5) {
            Intrinsics.checkNotNullParameter(r2, "uniqueId");
            Intrinsics.checkNotNullParameter(r3, "cloudId");
            Intrinsics.checkNotNullParameter(r5, "failMsg");
        }

        public static void onSwitchChanged(SyncStateListener r0, boolean r1) {
        }

        public static void onSyncSettingsChanged(SyncStateListener r0, boolean r1) {
        }

        public static void onSyncStateChanged(SyncStateListener r0, int r1, Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "extra");
        }

        public static boolean tryRenameLocalFile(SyncStateListener r0, long r1, String r3) {
            Intrinsics.checkNotNullParameter(r3, "newFileName");
            return true;
        }
    }

    void onFileTaskInit(int r1, int r2, int r3, int r4);

    void onFileTaskProgress(int r1, String r2, String r3, int r4, String r5);

    void onSwitchChanged(boolean r1);

    void onSyncSettingsChanged(boolean r1);

    void onSyncStateChanged(int r1);

    void onSyncStateChanged(int r1, Bundle r2);

    boolean tryRenameLocalFile(long r1, String r3);
}
