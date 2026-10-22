package com.bytedance.b.a;

import com.bytedance.apm.util.i;
import com.bytedance.services.slardar.config.IConfigManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: TraceSettings.java */
/* JADX INFO: loaded from: classes.dex */
public class c implements com.bytedance.services.slardar.config.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile c f6064e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f6065a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f6066b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private JSONObject f6067c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private JSONObject f6068d;

    @Override // com.bytedance.services.slardar.config.a
    public void onReady() {
    }

    private c() {
        this.f6066b = true;
    }

    public static c a() {
        if (f6064e != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f6064e != null) goto L9;
        f6064e = new c();     // Catch: Throwable -> L11
        ((IConfigManager) ZeusTransformUtils.preCheckCast(com.bytedance.news.common.service.manager.d.a(IConfigManager.class), IConfigManager.class, "com.obric.aiagent.plugin")).registerConfigListener(f6064e);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f6064e;
    }

    @Override // com.bytedance.services.slardar.config.a
    public void onRefresh(JSONObject r3, boolean r4) {
        this.f6066b = i.a(r3, "tracing", "enable_open", true);
        if (this.f6065a == true) goto L6;
        this.f6067c = i.a(r3, "tracing", "allow_service_list");
        this.f6068d = i.a(r3, "tracing", "allow_error_list");
        this.f6065a = true;
        return;
    }

    public int a(boolean r9, String r10) {
        int r1 = 0;
        if (this.f6066b == true) goto L6;
        return 0;
    L6:
        if (r9 == false) goto L12;
        JSONObject r11 = this.f6068d;
        if (r11 != null) goto L10;
    L11:
        r1 = 16;
        goto L12
    L10:
        if (r11.optDouble(r10, -1.0d) > 0.0d) goto L11;
    L12:
        JSONObject r8 = this.f6067c;
        if (r8 != null) goto L15;
        return r1;
    L15:
        if (r8.optDouble(r10, -1.0d) > 0.0d) goto L17;
        return r1;
    L17:
        return r1 | 1;
    }
}
