package com.bytedanceos.common.core.account.cloudsync.http;

import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public interface HttpCallBackListener {
    void onEnd(String r10, HashMap<String, String> r11) throws Exception;

    void onError(int r10, String r11) throws Exception;

    void onStart(String r10);
}
