package com.bytedance.agentrobots.a.b;

import android.os.SystemClock;
import android.util.Log;
import com.aiassistant.security.agentoperation.AgentOperationManager;
import com.obric.agent.trace.toolmetrics.OmniClientToolTraceServiceImpl;
import com.obric.aiagent.apm.impl.BuildConfig;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: AssistantAgentOperationManagerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements com.bytedance.agentrobots.a.a.b {
    private static final String TAG = "AssistantAgentOperationAdapter";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f3987a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f3988b = Long.MIN_VALUE;

    public b() {
    }

    static {
        f3987a = new Object();
    }

    @Override // com.bytedance.agentrobots.a.a.b
    public void a(String r2, String r3, String r4) {
        AgentOperationManager r1 = AgentOperationManager.getInstance();     // Catch: Throwable -> L8
        if (r1 != null) goto L6;
        a("AgentOperationManager is unavailable", null);     // Catch: Throwable -> L8
        return;
    L6:
        r1.notifyOperationState(r2, r3, r4);     // Catch: Throwable -> L8
        a(TAG, "notifyOperationState API returned, target_package=" + r3 + ", status=" + r4 + ", delivery=unconfirmed");     // Catch: Throwable -> L8
        return;
    L8:
        e = move-exception;
        a("notifyOperationState failed", e);
    }

    private static void a(String r7, Throwable r8) {
        long r0 = SystemClock.elapsedRealtime();
        Object r2 = f3987a;
        monitor-enter(r2);
        long r3 = f3988b;     // Catch: Throwable -> L16
        if (r3 != Long.MIN_VALUE) goto L7;
    L10:
        f3988b = r0;     // Catch: Throwable -> L16
        monitor-exit(r2);     // Catch: Throwable -> L16
        if (r8 != null) goto L14;
        b(TAG, r7);
        return;
    L14:
        a(TAG, r7, r8);
        return;
    L7:
        if ((r0 - r3) >= OmniClientToolTraceServiceImpl.WATCHDOG_INTERVAL_MS) goto L10;
        monitor-exit(r2);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2, Throwable r3) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2, r3);
    }
}
