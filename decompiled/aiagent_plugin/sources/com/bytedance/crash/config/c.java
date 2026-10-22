package com.bytedance.crash.config;

import com.bytedance.crash.o.q;
import org.json.JSONObject;

/* JADX INFO: compiled from: InnerAppMonitorConfigService.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends com.bytedance.crash.monitor.b {
    public c(com.bytedance.crash.monitor.d r1) {
        super(r1);
    }

    @Override // com.bytedance.crash.monitor.e
    public ConfigManager a() {
        return new d(this.f7589d);
    }

    @Override // com.bytedance.crash.monitor.e
    public void b(JSONObject r1) {
        super.b(r1);
        if (this.f7590e == null) goto L6;
        q.a().a(this.f7590e);
        return;
    }

    @Override // com.bytedance.crash.monitor.e
    public void c(JSONObject r2) {
        if (com.bytedance.crash.dumper.c.b() == false) goto L5;
        this.f = new com.bytedance.crash.d.d(true);
        return;
    L5:
        super.c(r2);
    }

    @Override // com.bytedance.crash.monitor.b
    public void d(JSONObject r1) {
        super.d(r1);
    }
}
