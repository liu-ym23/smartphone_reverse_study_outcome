package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.work.i;
import androidx.work.impl.c0;
import androidx.work.impl.utils.l;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintProxyUpdateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f5437a = null;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Intent f5438a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f5439b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ BroadcastReceiver.PendingResult f5440c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ConstraintProxyUpdateReceiver f5441d;

        public a(ConstraintProxyUpdateReceiver r10, Intent r11, Context r12, BroadcastReceiver.PendingResult r13) {
            this.f5441d = r10;
            this.f5438a = r11;
            this.f5439b = r12;
            this.f5440c = r13;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean r10 = this.f5438a.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);     // Catch: Throwable -> L5
            boolean r11 = this.f5438a.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);     // Catch: Throwable -> L5
            boolean r12 = this.f5438a.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);     // Catch: Throwable -> L5
            boolean r13 = this.f5438a.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);     // Catch: Throwable -> L5
            i.e().a(ConstraintProxyUpdateReceiver.f5437a, "Updating proxies: (BatteryNotLowProxy (" + r10 + "), BatteryChargingProxy (" + r11 + "), StorageNotLowProxy (" + r12 + "), NetworkStateProxy (" + r13 + "), ");     // Catch: Throwable -> L5
            l.a(this.f5439b, ConstraintProxy.BatteryNotLowProxy.class, r10);     // Catch: Throwable -> L5
            l.a(this.f5439b, ConstraintProxy.BatteryChargingProxy.class, r11);     // Catch: Throwable -> L5
            l.a(this.f5439b, ConstraintProxy.StorageNotLowProxy.class, r12);     // Catch: Throwable -> L5
            l.a(this.f5439b, ConstraintProxy.NetworkStateProxy.class, r13);     // Catch: Throwable -> L5
            this.f5440c.finish();
            return;
        L5:
            th = move-exception;
            this.f5440c.finish();
            throw th;
        }
    }

    static {
        f5437a = i.i("ConstrntProxyUpdtRecvr");
    }

    public ConstraintProxyUpdateReceiver() {
    }

    public static Intent a(Context r10, boolean r11, boolean r12, boolean r13, boolean r14) {
        Intent r15 = new Intent("androidx.work.impl.background.systemalarm.UpdateProxies");
        r15.setComponent(new ComponentName(r10, ConstraintProxyUpdateReceiver.class));
        r15.putExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", r11).putExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", r12).putExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", r13).putExtra("KEY_NETWORK_STATE_PROXY_ENABLED", r14);
        return r15;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if (r11 == null) goto L4;
        String r12 = r11.getAction();
    L6:
        if ("androidx.work.impl.background.systemalarm.UpdateProxies".equals(r12) == true) goto L8;
        i.e().a(f5437a, "Ignoring unknown action " + r12);
        return;
    L8:
        c0.l(r10).r().executeOnTaskThread(new a(this, r11, r10, goAsync()));
        return;
    L4:
        r12 = null;
        goto L6
    }
}
