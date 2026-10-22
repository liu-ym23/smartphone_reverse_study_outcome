package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.content.ContextCompat;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryChargingTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    private static final String TAG = null;

    static {
        TAG = Logger.tagWithPrefix("BatteryChrgTracker");
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public Boolean getInitialState() {
        IntentFilter r100 = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        Intent r101 = INVOKEVIRTUAL_androidx_work_impl_constraints_trackers_BatteryChargingTracker_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mAppContext, null, r100);
        if (r101 != null) goto L7;
        Logger.get().error(TAG, "getInitialState - null intent received", new Throwable[0]);
        return null;
    L7:
        return Boolean.valueOf(isBatteryChangedIntentCharging(r101));
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public IntentFilter getIntentFilter() {
        IntentFilter r100 = new IntentFilter();
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r100.addAction("android.os.action.CHARGING");
        r100.addAction("android.os.action.DISCHARGING");
    L6:
        return r100;
    L5:
        r100.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        r100.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        goto L6
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public /* bridge */ /* synthetic */ Object getInitialState() {
        return getInitialState();
    }

    private boolean isBatteryChangedIntentCharging(Intent r100) {
        if (Build.VERSION.SDK_INT < 23) goto L11;
        int r101 = r100.getIntExtra("status", -1);
        if (r101 != 2) goto L7;
        return true;
    L7:
        if (r101 == 5) goto L15;
    L9:
        return false;
    L15:
        return true;
    L11:
        if (r100.getIntExtra("plugged", 0) == 0) goto L9;
        return true;
    }

    public BatteryChargingTracker(Context r100, TaskExecutor r101) {
        super(r100, r101);
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void onBroadcastReceive(Context r100, Intent r101) {
        String r102 = r101.getAction();
        if (r102 != null) goto L5;
        return;
    L5:
        byte r103 = 1;
        Logger.get().debug(TAG, String.format("Received %s", new Object[]{r102}), new Throwable[0]);
        switch(r102.hashCode()) {
            case -1886648615: goto L20;
            case -54942926: goto L17;
            case 948344062: goto L13;
            case 1019184907: goto L9;
            default: goto L7;
        };
    L7:
        r103 = -1;
    L23:
        switch(r103) {
            case 0: goto L28;
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            default: goto L33;
        };
    L25:
        setState(Boolean.TRUE);
        return;
    L26:
        setState(Boolean.TRUE);
        return;
    L27:
        setState(Boolean.FALSE);
        return;
    L28:
        setState(Boolean.FALSE);
        return;
    L33:
        return;
    L9:
        if (r102.equals("android.intent.action.ACTION_POWER_CONNECTED") == false) goto L7;
        r103 = 3;
        goto L23
    L13:
        if (r102.equals("android.os.action.CHARGING") == false) goto L7;
        r103 = 2;
        goto L23
    L17:
        if (r102.equals("android.os.action.DISCHARGING") == true) goto L23;
    L20:
        if (r102.equals("android.intent.action.ACTION_POWER_DISCONNECTED") == false) goto L7;
        r103 = 0;
        goto L23
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_androidx_work_impl_constraints_trackers_BatteryChargingTracker_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L42;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L42:
    L36:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L40;
        throw e;
    L40:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L25;
        if (r110 == null) goto L25;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L25;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L36
        int r103 = r102.result;     // Catch: Exception -> L36
        if (r103 == 1) goto L23;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L19;
        return r100.registerReceiver(r101, r110);
    L19:
        return r102.intent;
    L21:
        return new Intent();
    L23:
        return r100.registerReceiver(r101, r110);
    L25:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L29;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L36
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L35;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L35;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L36
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L35:
        return r100.registerReceiver(r101, r110);
    }
}
