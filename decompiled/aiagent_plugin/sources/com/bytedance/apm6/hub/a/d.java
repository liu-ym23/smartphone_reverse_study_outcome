package com.bytedance.apm6.hub.a;

import org.json.JSONObject;

/* JADX INFO: compiled from: FdConfigManager.java */
/* JADX INFO: loaded from: classes.dex */
public class d implements com.bytedance.apm6.fd.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.bytedance.apm6.fd.a.a f5403a;

    static /* synthetic */ void a(d r0, JSONObject r1, boolean r2) {
        r0.a(r1, r2);
    }

    public d() {
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L5;
        com.bytedance.apm6.util.c.b.a("APM-FD", "FdConfigManager:");
    L5:
        com.bytedance.apm6.hub.a.a.a.a().b();
        com.bytedance.apm6.hub.a.a.a.a().a(new AnonymousClass1(this));
    }

    private void a(JSONObject r11, boolean r12) {
        JSONObject r13 = r11.optJSONObject("performance_modules");
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L5;
        com.bytedance.apm6.util.c.b.a("APM-FD", "parseConfig:" + r13);
    L5:
        if (r13 != null) goto L7;
        return;
    L7:
        JSONObject r14 = r13.optJSONObject("fd");
        if (r14 != null) goto L11;
        return;
    L11:
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L14;
        com.bytedance.apm6.util.c.b.a("APM-FD", "parseConfig:" + r14);
    L14:
        if (r14.optInt("enable_upload", 0) != 1) goto L16;
        boolean r9 = true;
    L17:
        long r5 = r14.optInt("fd_count_threshold", 800);
        long r15 = r14.optLong("collect_interval", 10) * 60000;
        if (r15 >= 10) goto L20;
        r15 = 600000;
    L20:
        com.bytedance.apm6.fd.a.a r16 = new com.bytedance.apm6.fd.a.a(r5, r15, r9);
        if (com.bytedance.apm6.foundation.context.a.u() == false) goto L23;
        com.bytedance.apm6.util.c.b.a("APM-FD", "parseConfig:" + r16);
    L23:
        this.f5403a = r16;
        com.bytedance.apm6.fd.a.a().a(r16);
        return;
    L16:
        r9 = false;
        goto L17
    }

    @Override // com.bytedance.apm6.fd.a.b
    public com.bytedance.apm6.fd.a.a a() {
        return this.f5403a;
    }
}
