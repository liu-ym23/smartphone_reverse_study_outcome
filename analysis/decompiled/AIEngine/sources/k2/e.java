package k2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import h2.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f9881a = j.f("RescheduleReceiver");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        j.d().a(f9881a, "Received intent " + intent);
        try {
            androidx.work.impl.b bVarA = androidx.work.impl.b.a(context);
            BroadcastReceiver.PendingResult pendingResultGoAsync = goAsync();
            bVarA.getClass();
            synchronized (androidx.work.impl.b.f2876n) {
                try {
                    BroadcastReceiver.PendingResult pendingResult = bVarA.f2884i;
                    if (pendingResult != null) {
                        pendingResult.finish();
                    }
                    bVarA.f2884i = pendingResultGoAsync;
                    if (bVarA.h) {
                        pendingResultGoAsync.finish();
                        bVarA.f2884i = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (IllegalStateException e10) {
            j.d().c(f9881a, "Cannot reschedule jobs. WorkManager needs to be initialized via a ContentProvider#onCreate() or an Application#onCreate().", e10);
        }
    }
}
