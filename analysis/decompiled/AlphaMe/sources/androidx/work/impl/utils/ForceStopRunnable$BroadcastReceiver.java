package androidx.work.impl.utils;

import C0.f;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.annotation.RestrictTo;
import e.EnumC0546d;
import s0.t;

@RestrictTo({EnumC0546d.f12493b})
/* loaded from: classes.dex */
public class ForceStopRunnable$BroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4345a = t.f("ForceStopRunnable$Rcvr");

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent == null || !"ACTION_FORCE_STOP_RESCHEDULE".equals(intent.getAction())) {
            return;
        }
        if (t.d().f14213a <= 2) {
            Log.v(f4345a, "Rescheduling alarm that keeps track of force-stops.");
        }
        String str = f.f296e;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        Intent intent2 = new Intent();
        intent2.setComponent(new ComponentName(context, (Class<?>) ForceStopRunnable$BroadcastReceiver.class));
        intent2.setAction("ACTION_FORCE_STOP_RESCHEDULE");
        PendingIntent broadcast = PendingIntent.getBroadcast(context, -1, intent2, 167772160);
        long jCurrentTimeMillis = System.currentTimeMillis() + f.f297f;
        if (alarmManager != null) {
            alarmManager.setExact(0, jCurrentTimeMillis, broadcast);
        }
    }
}
