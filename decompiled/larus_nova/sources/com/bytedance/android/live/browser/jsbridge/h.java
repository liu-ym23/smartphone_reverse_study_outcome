package com.bytedance.android.live.browser.jsbridge;

import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes45.dex */
public interface h {
    void a(IJsBridgeManager r100);

    Map<String, Object> getCacheByScheme(String r100);

    JSONObject getCacheJsonByScheme(String r100);

    void init();

    void prefetch(String r100);
}
