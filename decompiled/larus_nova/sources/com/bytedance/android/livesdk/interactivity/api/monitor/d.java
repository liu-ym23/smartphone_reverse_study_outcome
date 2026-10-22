package com.bytedance.android.livesdk.interactivity.api.monitor;

import com.bytedance.android.live.core.log.ALogger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class d {
    public static final void a(JSONObject r100, String r101, String r102) {
    L6:
        e = move-exception;
        ALogger.e("InteractivityTraceMonitor", e);
        return;
    L3:
        if (r100.has(r101) == true) goto L11;
        r100.putOpt(r101, r102);     // Catch: Exception -> L6
        return;
    }
}
