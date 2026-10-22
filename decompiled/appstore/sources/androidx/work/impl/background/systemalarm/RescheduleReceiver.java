package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.i;
import androidx.work.impl.c0;

/* JADX INFO: loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5442a = null;

    static {
        f5442a = i.i("RescheduleReceiver");
    }

    public RescheduleReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        i.e().a(f5442a, "Received intent " + r11);
        c0.l(r10).v(goAsync());     // Catch: IllegalStateException -> L5
        return;
    L5:
        e = move-exception;
        i.e().d(f5442a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e);
    }
}
