package com.bytedance.android.sdk.bdticketguard.init;

import android.os.Process;
import com.bytedance.android.sdk.bdticketguard.r0;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final void a(Function0<Unit> r100) {
        int r101 = Process.myTid();
        Integer r102 = null;
        r102 = Integer.valueOf(Process.getThreadPriority(r101));     // Catch: Throwable -> L5
        Process.setThreadPriority(r101, r102.intValue() - 1);     // Catch: Throwable -> L5
    L7:
        r100.invoke();
        if (r102 == null) goto L18;
        Process.setThreadPriority(r101, r102.intValue());     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        r0.d(6, "InitTaskManager", "restoreThreadPriority failed", th);
        return;
    L18:
        return;
    L5:
        th = move-exception;
        r0.d(6, "InitTaskManager", "setThreadPriority failed", th);
        goto L7
    }
}
