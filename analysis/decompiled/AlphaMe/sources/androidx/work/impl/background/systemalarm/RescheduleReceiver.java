package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import s0.t;
import t0.C0913H;

/* loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4330a = t.f("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        t.d().a(f4330a, "Received intent " + intent);
        try {
            C0913H c0913hE0 = C0913H.e0(context);
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            synchronized (C0913H.f15324n) {
                try {
                    BroadcastReceiver.PendingResult pendingResult = c0913hE0.f15333j;
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                    c0913hE0.f15333j = pendingResultGoAsync;
                    if (c0913hE0.f15332i) {
                        pendingResultGoAsync.finish();
                        c0913hE0.f15333j = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (IllegalStateException e4) {
            t.d().c(f4330a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e4);
        }
    }
}
