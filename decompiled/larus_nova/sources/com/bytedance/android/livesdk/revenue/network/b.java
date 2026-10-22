package com.bytedance.android.livesdk.revenue.network;

import java.util.Map;

/* JADX INFO: loaded from: classes11.dex */
public interface b {
    byte[] getBody();

    Map<String, String> getHeaders();

    String getMimeType();

    String getReason();

    int getStatusCode();
}
