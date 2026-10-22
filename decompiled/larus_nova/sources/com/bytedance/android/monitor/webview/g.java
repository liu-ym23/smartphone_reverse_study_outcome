package com.bytedance.android.monitor.webview;

import com.bytedance.apm.ApmAgent;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class g implements a {
    public g() {
    }

    @Override // com.bytedance.android.monitor.webview.a
    public final void a(String r100, JSONObject r101) {
        ApmAgent.monitorEvent(r100, null, null, r101);     // Catch: Throwable -> L5
        return;
    L5:
        bz2.c.a();
    }
}
