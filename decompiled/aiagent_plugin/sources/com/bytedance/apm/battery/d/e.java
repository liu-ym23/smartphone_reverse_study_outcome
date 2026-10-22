package com.bytedance.apm.battery.d;

import android.content.Context;
import android.os.BatteryManager;
import android.os.Build;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: BatteryConsumeStatsImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final BatteryManager f4310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f4312e;

    public e() {
        super("battery_consume");
        this.f4311d = false;
        this.f4312e = -1;
        this.f4310c = (BatteryManager) ZeusTransformUtils.preCheckCast(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getSystemService("batterymanager"), BatteryManager.class, "com.obric.aiagent.plugin");
    }

    @Override // com.bytedance.apm.battery.d.b
    public void b(boolean r4, boolean r5) {
        if (a() == true) goto L6;
        return;
    L6:
        if (r4 == true) goto L21;
    L13:
        boolean r6 = true;
    L14:
        c(r5, r6);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        if (com.bytedance.apm.c.i() == false) goto L19;
        com.bytedance.apm.h.e.c(com.bytedance.apm.h.b.f4646b, new String[]{"BatteryConsumeStatsImpl error: " + th.getCause()});
    L19:
        com.bytedance.services.apm.api.a.a("BatteryConsumeStatsImpl");
        return;
    L21:
        if (this.f4301b == true) goto L13;
        r6 = false;
        goto L14
    }

    private void c(boolean r4, boolean r5) {
        if (Build.VERSION.SDK_INT < 21) goto L12;
        int r0 = this.f4310c.getIntProperty(1);
        if (r5 == true) goto L10;
        if (r4 == false) goto L10;
        if (this.f4311d == false) goto L10;
        a(true, Math.abs(r0 - this.f4312e), com.bytedance.apm.battery.a.a().h());
    L10:
        this.f4312e = r0;
        this.f4311d = true;
        return;
    }

    @Override // com.bytedance.apm.battery.d.l
    public void a(com.bytedance.apm.battery.c.b r5, com.bytedance.apm.e.a r6) {
        r5.s(r6.d() / 1000);
    }
}
