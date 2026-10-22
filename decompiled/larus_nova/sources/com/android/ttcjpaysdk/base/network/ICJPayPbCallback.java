package com.android.ttcjpaysdk.base.network;

import java.io.InputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
public interface ICJPayPbCallback {
    void onFailure(JSONObject r100);

    void onResponse(InputStream r100, te4.b r101);
}
