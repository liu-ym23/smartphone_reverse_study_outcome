package com.byted.cast.common.api;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
public interface IMonitor {

    /* JADX INFO: renamed from: com.byted.cast.common.api.IMonitor$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onAppLogEvent(IMonitor r100, String r101, JSONObject r102) {
        }
    }

    void onAppLogEvent(String r100, JSONObject r101);
}
