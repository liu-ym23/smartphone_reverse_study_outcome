package com.bytedance.apm.battery.d;

import android.content.Context;
import com.bytedance.apm.core.ActivityLifeObserver;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AbsBatteryValueStats.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    volatile boolean f4300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    volatile boolean f4301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f4302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f4303d;

    public abstract void b(boolean r1, boolean r2);

    b(String r3) {
        this.f4302c = r3;
        this.f4303d = com.bytedance.apm.c.d();
        this.f4300a = ActivityLifeObserver.getInstance().isForeground();
        this.f4301b = com.bytedance.apm.battery.e.a.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(com.bytedance.apm.c.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
    }

    public boolean a() {
        return this.f4303d;
    }

    @Override // com.bytedance.apm.battery.d.l
    public void b(boolean r2) {
        b(this.f4300a, r2);
        this.f4300a = true;
    }

    @Override // com.bytedance.apm.battery.d.l
    public void a(boolean r2) {
        b(this.f4300a, r2);
        this.f4300a = false;
    }

    @Override // com.bytedance.apm.battery.d.l
    public void c(boolean r2) {
        b(this.f4300a, r2);
    }

    @Override // com.bytedance.apm.battery.d.l
    public void a(boolean r2, boolean r3) {
        b(this.f4300a, r3);
        this.f4301b = r2;
    }

    void a(boolean r11, long r12, String r14) {
        if (r12 < 0) goto L5;
        com.bytedance.apm.battery.c.a.a().a(new com.bytedance.apm.e.a(r11, System.currentTimeMillis(), this.f4302c, this.f4301b, r12, r14));
        return;
    L5:
        if (com.bytedance.apm.c.i() == false) goto L7;
        com.bytedance.apm.h.e.c(com.bytedance.apm.h.b.f4646b, new String[]{"AbsBatteryValueStats value error: " + r12 + " type:" + this.f4302c});
    L7:
        com.bytedance.apm.h.a.b("APM-Battery", "AbsBatteryValueStats value error: " + r12 + " type:" + this.f4302c);
    }
}
