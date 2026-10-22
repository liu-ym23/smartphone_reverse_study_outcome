package androidx.work.impl.diagnostics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import androidx.work.WorkManager;
import androidx.work.i;
import androidx.work.impl.workers.DiagnosticsWorker;
import androidx.work.j;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DiagnosticsReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5556a = null;

    static {
        f5556a = i.i("DiagnosticsRcvr");
    }

    public DiagnosticsReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        i.e().a(f5556a, "Requesting diagnostics");
        WorkManager.e(r10).a(j.e(DiagnosticsWorker.class));     // Catch: IllegalStateException -> L7
        return;
    L7:
        e = move-exception;
        i.e().d(f5556a, "WorkManager is not initialized", e);
    }
}
