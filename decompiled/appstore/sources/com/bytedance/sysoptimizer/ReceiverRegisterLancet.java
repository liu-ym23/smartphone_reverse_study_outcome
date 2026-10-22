package com.bytedance.sysoptimizer;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import androidx.annotation.RequiresApi;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.Scope;
import me.ele.lancet.base.annotations.Proxy;
import me.ele.lancet.base.annotations.Skip;
import me.ele.lancet.base.annotations.TargetClass;

/* JADX INFO: loaded from: classes.dex */
public class ReceiverRegisterLancet {
    public ReceiverRegisterLancet() {
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public Intent registerReceiver(BroadcastReceiver r10, IntentFilter r11) {
        return (Intent) Origin.call();
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r10, r11);
    }

    @Proxy("registerReceiver")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @RequiresApi(api = 26)
    public Intent registerReceiver(BroadcastReceiver r10, IntentFilter r11, int r12) {
        return (Intent) Origin.call();
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r10, r11, r12);
    }

    @Proxy("registerReceiver")
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    public Intent registerReceiver(BroadcastReceiver r10, IntentFilter r11, String r12, Handler r13) {
        return (Intent) Origin.call();
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r10, r11, r12, r13);
    }

    @Proxy("registerReceiver")
    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer"})
    @TargetClass(scope = Scope.ALL_SELF, value = "android.content.Context")
    @RequiresApi(api = 26)
    public Intent registerReceiver(BroadcastReceiver r10, IntentFilter r11, String r12, Handler r13, int r14) {
        return (Intent) Origin.call();
    L4:
        e = move-exception;
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L8;
        throw e;
    L8:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r10, r11, r12, r13, r14);
    }
}
