package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.impl.b;
import androidx.work.impl.background.systemalarm.ConstraintProxy;
import h2.j;
import r2.h;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2888a = j.f("ConstrntProxyUpdtRecvr");

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f2889a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f2890b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BroadcastReceiver.PendingResult f2891c;

        public a(Intent intent, Context context, BroadcastReceiver.PendingResult pendingResult) {
            this.f2889a = intent;
            this.f2890b = context;
            this.f2891c = pendingResult;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BroadcastReceiver.PendingResult pendingResult = this.f2891c;
            Context context = this.f2890b;
            Intent intent = this.f2889a;
            try {
                boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                j.d().a(ConstraintProxyUpdateReceiver.f2888a, "Updating proxies: (BatteryNotLowProxy (" + booleanExtra + "), BatteryChargingProxy (" + booleanExtra2 + "), StorageNotLowProxy (" + booleanExtra3 + "), NetworkStateProxy (" + booleanExtra4 + "), ");
                h.a(context, ConstraintProxy.BatteryNotLowProxy.class, booleanExtra);
                h.a(context, ConstraintProxy.BatteryChargingProxy.class, booleanExtra2);
                h.a(context, ConstraintProxy.StorageNotLowProxy.class, booleanExtra3);
                h.a(context, ConstraintProxy.NetworkStateProxy.class, booleanExtra4);
            } finally {
                pendingResult.finish();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent != null ? intent.getAction() : null;
        if ("androidx.work.impl.background.systemalarm.UpdateProxies".equals(action)) {
            b.a(context).f2880d.d(new a(intent, context, goAsync()));
            return;
        }
        j.d().a(f2888a, "Ignoring unknown action " + action);
    }
}
