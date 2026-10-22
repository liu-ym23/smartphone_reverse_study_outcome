package com.bytedance.services.slardar.config;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public interface IConfigListener {
    void onReady();

    void onRefresh(JSONObject r10, boolean r11);
}
