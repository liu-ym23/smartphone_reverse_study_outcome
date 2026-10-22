package com.bef.effectsdk.message;

import android.os.Message;

/* JADX INFO: loaded from: classes39.dex */
public interface MessageInterceptor {
    void destroy();

    boolean intercept(Message r100);
}
