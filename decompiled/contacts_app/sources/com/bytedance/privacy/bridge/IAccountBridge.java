package com.bytedance.privacy.bridge;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public interface IAccountBridge {
    String onGetDeviceId();

    String onGetUDID();

    String onGetUserId();

    Map<String, String> onGetXttTokenMap();

    boolean onIsAccountLogin();

    void onTeaEvent(String r1, JSONObject r2);
}
