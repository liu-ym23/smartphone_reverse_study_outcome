package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Logger;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.impl.workers.DiagnosticsWorker;

/* JADX INFO: loaded from: classes17.dex */
public class DiagnosticsReceiver extends BroadcastReceiver {
    private static final String TAG = null;

    static {
        TAG = Logger.tagWithPrefix("DiagnosticsRcvr");
    }

    public DiagnosticsReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        Logger.get().debug(TAG, "Requesting diagnostics", new Throwable[0]);
        WorkManager.getInstance(r100).enqueue(OneTimeWorkRequest.from(DiagnosticsWorker.class));     // Catch: IllegalStateException -> L7
        return;
    L7:
        e = move-exception;
        Logger.get().error(TAG, "WorkManager is not initialized", new Throwable[]{e});
    }
}
