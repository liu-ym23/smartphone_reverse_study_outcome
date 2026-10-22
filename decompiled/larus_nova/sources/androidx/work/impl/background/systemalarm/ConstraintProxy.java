package androidx.work.impl.background.systemalarm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.work.Constraints;
import androidx.work.Logger;
import androidx.work.NetworkType;
import androidx.work.impl.model.WorkSpec;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes17.dex */
abstract class ConstraintProxy extends BroadcastReceiver {
    private static final String TAG = null;

    public static class BatteryChargingProxy extends ConstraintProxy {
        public BatteryChargingProxy() {
        }

        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context r100, Intent r101) {
            super.onReceive(r100, r101);
        }
    }

    public static class BatteryNotLowProxy extends ConstraintProxy {
        public BatteryNotLowProxy() {
        }

        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context r100, Intent r101) {
            super.onReceive(r100, r101);
        }
    }

    public static class NetworkStateProxy extends ConstraintProxy {
        public NetworkStateProxy() {
        }

        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context r100, Intent r101) {
            super.onReceive(r100, r101);
        }
    }

    public static class StorageNotLowProxy extends ConstraintProxy {
        public StorageNotLowProxy() {
        }

        @Override // androidx.work.impl.background.systemalarm.ConstraintProxy, android.content.BroadcastReceiver
        public /* bridge */ /* synthetic */ void onReceive(Context r100, Intent r101) {
            super.onReceive(r100, r101);
        }
    }

    static {
        TAG = Logger.tagWithPrefix("ConstraintProxy");
    }

    public ConstraintProxy() {
    }

    public static void updateAll(Context r100, List<WorkSpec> r101) {
        Iterator<WorkSpec> r102 = r101.iterator();
        boolean r103 = false;
        boolean r104 = false;
        boolean r105 = false;
        boolean r106 = false;
    L4:
        if (r102.hasNext() == false) goto L14;
        Constraints r107 = r102.next().constraints;
        r103 = r103 | r107.requiresBatteryNotLow();
        r104 = r104 | r107.requiresCharging();
        r105 = r105 | r107.requiresStorageNotLow();
        if (r107.getRequiredNetworkType() == NetworkType.NOT_REQUIRED) goto L8;
        boolean r108 = true;
    L9:
        r106 = r106 | r108;
        if (r103 == false) goto L4;
        if (r104 == false) goto L4;
        if (r105 == false) goto L4;
        if (r106 == false) goto L4;
    L8:
        r108 = false;
    L14:
        r100.sendBroadcast(ConstraintProxyUpdateReceiver.newConstraintProxyUpdateIntent(r100, r103, r104, r105, r106));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        Logger.get().debug(TAG, String.format("onReceive : %s", new Object[]{r101}), new Throwable[0]);
        r100.startService(CommandHandler.createConstraintsChangedIntent(r100));
    }
}
