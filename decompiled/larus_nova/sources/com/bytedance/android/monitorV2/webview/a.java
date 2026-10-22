package com.bytedance.android.monitorV2.webview;

import com.bytedance.apm.ApmAgent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class a implements b {
    public a() {
    }

    @Override // com.bytedance.android.monitorV2.webview.b
    public final void a(JSONObject r100) {
        ApmAgent.monitorEvent("bd_hybrid_monitor_service_all_in_one", null, null, r100);     // Catch: Throwable -> L5
        nz2.b.f("WebViewMonitorDefault", "apm upload: bd_hybrid_monitor_service_all_in_one");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.bytedance.android.monitorV2.util.f.b(th);
    }
}
