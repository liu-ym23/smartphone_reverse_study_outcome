package com.bytedance.android.service.manager.push.interfaze;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public interface IMultiProcessEventSenderService {
    void onEventV3(String r100, JSONObject r101);

    void onEventV3(boolean r100, String r101, JSONObject r102);
}
