package com.bytedance.android.ec.core.event;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f44010a = null;

    public b() {
    }

    static {
        f44010a = new b();
    }

    public final void registerReceiver(Context r100, BroadcastReceiver r110, IntentFilter r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "var1");
        Intrinsics.checkNotNullParameter(r111, "var2");
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L35;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L35:
    L29:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L34;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r111);
        return;
    L34:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L20;
        if (r111 == null) goto L20;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L20;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r111, 0, null, null, 2, r100).result;     // Catch: Exception -> L29
        if (r101 != 1) goto L13;
        r100.registerReceiver(r110, r111);     // Catch: Exception -> L29
        return;
    L13:
        if (r101 != 2) goto L15;
        new Intent();     // Catch: Exception -> L29
        return;
    L15:
        if (r101 == 3) goto L36;
        r100.registerReceiver(r110, r111);     // Catch: Exception -> L29
        return;
    L36:
        return;
    L20:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L23;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L29
        r100.registerReceiver(r110, r111, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L29
        return;
    L23:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L25;
    L27:
        r100.registerReceiver(r110, r111);     // Catch: Exception -> L29
        return;
    L25:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r111) == false) goto L27;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L29
        ContextCompat.registerReceiver(r100, r110, r111, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L29
    }
}
