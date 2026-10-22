package com.obric.performance.power.monitor.constants;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: PowerMonitorConstants.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f36952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ObricPerformancePowerMonitorConfig f36953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f36954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final c f36955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final e f36956e;

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
        return false;
    L8:
        f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
        if (o.a(this.f36952a, r6.f36952a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f36953b, r6.f36953b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f36954c, r6.f36954c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f36955d, r6.f36955d) == true) goto L21;
        return false;
    L21:
        if (o.a(this.f36956e, r6.f36956e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r0 = ((this.f36952a.hashCode() * 31) + this.f36953b.hashCode()) * 31;
        d r1 = this.f36954c;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return ((((r0 + r2) * 31) + this.f36955d.hashCode()) * 31) + this.f36956e.hashCode();
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "PowerMonitorInitConfig(context=" + this.f36952a + ", settings=" + this.f36953b + ", reportDelegate=" + this.f36954c + ", appBackgroundDelegate=" + this.f36955d + ", screenStateDelegate=" + this.f36956e + ')';
    }

    public f(Context r3, ObricPerformancePowerMonitorConfig r4, d r5, c r6, e r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
        c r10 = (c) ZeusTransformUtils.wrapperContextForParams(r6, c.class, "com.obric.aiagent.plugin");
        e r11 = (e) ZeusTransformUtils.wrapperContextForParams(r7, e.class, "com.obric.aiagent.plugin");
        o.e(r8, "context");
        o.e(r4, "settings");
        o.e(r10, "appBackgroundDelegate");
        o.e(r11, "screenStateDelegate");
        this.f36952a = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");
        this.f36953b = r4;
        this.f36954c = r9;
        this.f36955d = r10;
        this.f36956e = r11;
    }

    public final Context getContext() {
        return this.f36952a;
    }

    public final ObricPerformancePowerMonitorConfig a() {
        return this.f36953b;
    }

    public final d b() {
        return this.f36954c;
    }

    public final c c() {
        return this.f36955d;
    }

    public final e d() {
        return this.f36956e;
    }
}
