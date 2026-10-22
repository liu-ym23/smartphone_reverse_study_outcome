package com.bytedance.android.service.manager.push.monitor;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IMultiProcessMonitor {
    void init(Context r100);

    void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103);
}
