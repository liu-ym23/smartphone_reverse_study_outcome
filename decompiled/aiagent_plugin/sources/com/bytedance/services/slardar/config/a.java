package com.bytedance.services.slardar.config;

import org.json.JSONObject;

/* JADX INFO: compiled from: IConfigListener.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {
    void onReady();

    void onRefresh(JSONObject r1, boolean r2);
}
