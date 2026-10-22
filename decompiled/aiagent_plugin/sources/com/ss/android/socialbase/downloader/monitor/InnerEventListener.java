package com.ss.android.socialbase.downloader.monitor;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public interface InnerEventListener {
    void onEvent(int r1, String r2, JSONObject r3);

    void onUnityEvent(int r1, String r2, JSONObject r3);
}
