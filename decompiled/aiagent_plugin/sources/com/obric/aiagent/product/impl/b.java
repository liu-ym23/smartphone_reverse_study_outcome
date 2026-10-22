package com.obric.aiagent.product.impl;

import com.obric.aiagent.assistant.idl.IFlowSettingsIDL;
import com.obric.aiagent.assistant.idl.at;
import com.obric.aiagent.ipc.utils.d;
import com.obric.aiagent.platform.depend.ILogDepend;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.aa;
import d.h.b.o;
import d.n;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: IPCAnomalySettingsConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static final String TAG = "IPCAnomalySettings";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f18795a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.aiagent.ipc.utils.a f18796b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f18797c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final a f18798d = null;

    public static /* synthetic */ void lambda$FLR9hyVqcEfJveCs5MSHjeN0Rp4(IFlowSettingsIDL r0) {
        a(r0);
    }

    private b() {
    }

    static {
        f18795a = new b();
        f18796b = new com.obric.aiagent.ipc.utils.a(false, 0, 0, 0, 14, null);
        f18797c = new AtomicBoolean(false);
        f18798d = new a();
    }

    public final void a() {
        if (f18797c.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        at.a(aa.b(IFlowSettingsIDL.class), false, false, $$Lambda$b$FLR9hyVqcEfJveCs5MSHjeN0Rp4.INSTANCE, 3, null);
    }

    private static final void a(IFlowSettingsIDL r3) {
        o.e((IFlowSettingsIDL) ZeusTransformUtils.wrapperContextForParams(r3, IFlowSettingsIDL.class, "com.obric.aiagent.plugin"), "it");
        com.obric.aiagent.ipc.utils.a r4 = f18795a.b();
        d.f18654a.a(r4);
        ILogDepend.Companion.i(TAG, "IPC anomaly config updated: " + r4);
    }

    private final com.obric.aiagent.ipc.utils.a b() {
        n.a r2 = n.f38560a;     // Catch: Throwable -> L9
        b r10 = (b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L9
        JSONObject r3 = f18798d.getSettingsConfig("obric_ipc_anomaly_report_config");     // Catch: Throwable -> L9
        if (r3 != null) goto L6;
        ILogDepend.Companion.i(TAG, "IPC anomaly config is empty, reporting stays disabled");     // Catch: Throwable -> L9
        com.obric.aiagent.ipc.utils.a r11 = f18796b;     // Catch: Throwable -> L9
    L7:
        Object r12 = n.f(r11);     // Catch: Throwable -> L9
    L11:
        Throwable r4 = n.c(r12);
        if (r4 == null) goto L16;
        ILogDepend.Companion.e(TAG, "Failed to read IPC anomaly config", r4);
        r12 = f18796b;
    L16:
        return (com.obric.aiagent.ipc.utils.a) ZeusTransformUtils.preCheckCast(r12, com.obric.aiagent.ipc.utils.a.class, "com.obric.aiagent.plugin");
    L6:
        com.obric.aiagent.ipc.utils.a r5 = f18796b;     // Catch: Throwable -> L9
        r11 = new com.obric.aiagent.ipc.utils.a(r3.optBoolean("enable", r5.a()), r10.a(r3, "slow_call_threshold_ms", r5.b()), r10.a(r3, "frequent_call_threshold_per_minute", r5.c()), r10.a(r3, "report_limit_per_minute", r5.d()));     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        n.a r6 = n.f38560a;
        r12 = n.f(d.o.a(th));
        goto L11
    }

    private final long a(JSONObject r3, String r4, long r5) {
        Long r2 = Long.valueOf(r3.optLong(r4, r5));
        if (((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).longValue() < 0) goto L5;
        boolean r6 = true;
    L6:
        if (r6 == true) goto L9;
        r2 = null;
    L9:
        if (r2 != null) goto L11;
        return r5;
    L11:
        return r2.longValue();
    L5:
        r6 = false;
        goto L6
    }

    private final int a(JSONObject r1, String r2, int r3) {
        Integer r0 = Integer.valueOf(r1.optInt(r2, r3));
        if (((Number) ZeusTransformUtils.preCheckCast(r0, Number.class, "com.obric.aiagent.plugin")).intValue() <= 0) goto L5;
        boolean r4 = true;
    L6:
        if (r4 == true) goto L9;
        r0 = null;
    L9:
        if (r0 != null) goto L11;
        return r3;
    L11:
        return r0.intValue();
    L5:
        r4 = false;
        goto L6
    }
}
