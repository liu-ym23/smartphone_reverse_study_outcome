package com.bytedance.android.livehostapi.platform;

import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public interface IHostSessionAuth {
    String getAccountId();

    Map<String, String> getTokenRequestHeaders(String r100);

    boolean isLogin();
}
