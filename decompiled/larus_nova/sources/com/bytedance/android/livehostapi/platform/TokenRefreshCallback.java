package com.bytedance.android.livehostapi.platform;

/* JADX INFO: loaded from: classes7.dex */
public interface TokenRefreshCallback {
    void onFailed(Throwable r100);

    void onSuccess(TokenInfo r100);
}
