package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.work.Logger;
import androidx.work.impl.WorkManagerImpl;

/* JADX INFO: loaded from: classes17.dex */
public class RescheduleReceiver extends BroadcastReceiver {
    private static final String TAG = null;

    static {
        TAG = Logger.tagWithPrefix("RescheduleReceiver");
    }

    public RescheduleReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        Logger.get().debug(TAG, String.format("Received intent %s", new Object[]{r101}), new Throwable[0]);
        if (Build.VERSION.SDK_INT >= 23) goto L10;
        r100.startService(CommandHandler.createRescheduleIntent(r100));
        return;
    L10:
        WorkManagerImpl.getInstance(r100).setReschedulePendingResult(goAsync());     // Catch: IllegalStateException -> L6
        return;
    L6:
        e = move-exception;
        Logger.get().error(TAG, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", new Throwable[]{e});
    }
}
