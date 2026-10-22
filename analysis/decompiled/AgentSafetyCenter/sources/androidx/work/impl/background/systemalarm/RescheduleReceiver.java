package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import g5.u;
import h5.r;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class RescheduleReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f1670a = u.f("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        u.d().a(f1670a, "Received intent " + intent);
        try {
            r rVarB = r.b(context);
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            synchronized (r.f5369m) {
                try {
                    BroadcastReceiver.PendingResult pendingResult = rVarB.i;
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                    rVarB.i = pendingResultGoAsync;
                    if (rVarB.f5377h) {
                        pendingResultGoAsync.finish();
                        rVarB.i = null;
                    }
                } finally {
                }
            }
        } catch (IllegalStateException e10) {
            u.d().c(f1670a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e10);
        }
    }
}
