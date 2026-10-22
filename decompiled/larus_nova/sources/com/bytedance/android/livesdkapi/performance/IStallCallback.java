package com.bytedance.android.livesdkapi.performance;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public interface IStallCallback {
    void onBlockReady(long r100, int r101, long r102);

    void onFpsReady(double r100, JSONObject r101);
}
