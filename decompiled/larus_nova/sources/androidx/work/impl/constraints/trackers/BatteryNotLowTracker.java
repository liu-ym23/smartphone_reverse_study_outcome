package androidx.work.impl.constraints.trackers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import androidx.work.Logger;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public class BatteryNotLowTracker extends BroadcastReceiverConstraintTracker<Boolean> {
    static final float BATTERY_LOW_THRESHOLD = 0.15f;
    private static final String TAG = null;

    static {
        TAG = Logger.tagWithPrefix("BatteryNotLowTracker");
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public Boolean getInitialState() {
        Intent r100 = INVOKEVIRTUAL_androidx_work_impl_constraints_trackers_BatteryNotLowTracker_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(this.mAppContext, null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean r101 = false;
        if (r100 != null) goto L6;
        Logger.get().error(TAG, "getInitialState - null intent received", new Throwable[0]);
        return null;
    L6:
        int r102 = r100.getIntExtra("status", -1);
        float r103 = r100.getIntExtra("level", -1) / r100.getIntExtra("scale", -1);
        if (r102 != 1) goto L9;
    L10:
        r101 = true;
    L12:
        return Boolean.valueOf(r101);
    L9:
        if (r103 <= BATTERY_LOW_THRESHOLD) goto L12;
        goto L10
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public IntentFilter getIntentFilter() {
        IntentFilter r100 = new IntentFilter();
        r100.addAction("android.intent.action.BATTERY_OKAY");
        r100.addAction("android.intent.action.BATTERY_LOW");
        return r100;
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public /* bridge */ /* synthetic */ Object getInitialState() {
        return getInitialState();
    }

    public BatteryNotLowTracker(Context r100, TaskExecutor r101) {
        super(r100, r101);
    }

    @Override // androidx.work.impl.constraints.trackers.BroadcastReceiverConstraintTracker
    public void onBroadcastReceive(Context r100, Intent r101) {
        if (r101.getAction() != null) goto L5;
        return;
    L5:
        Logger.get().debug(TAG, String.format("Received %s", new Object[]{r101.getAction()}), new Throwable[0]);
        String r102 = r101.getAction();
        r102.getClass();
        if (r102.equals("android.intent.action.BATTERY_OKAY") == false) goto L8;
        setState(Boolean.TRUE);
        return;
    L8:
        if (r102.equals("android.intent.action.BATTERY_LOW") == false) goto L14;
        setState(Boolean.FALSE);
        return;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent INVOKEVIRTUAL_androidx_work_impl_constraints_trackers_BatteryNotLowTracker_com_bytedance_sysoptimizer_ReceiverRegisterLancet_registerReceiver(Context r100, BroadcastReceiver r101, IntentFilter r110) {
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
