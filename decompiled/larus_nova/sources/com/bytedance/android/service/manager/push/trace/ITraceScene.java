package com.bytedance.android.service.manager.push.trace;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface ITraceScene {
    void enterNode(String r100);

    void enterNode(String r100, String r101);

    void enterNode(String r100, String r101, JSONObject r102);
}
