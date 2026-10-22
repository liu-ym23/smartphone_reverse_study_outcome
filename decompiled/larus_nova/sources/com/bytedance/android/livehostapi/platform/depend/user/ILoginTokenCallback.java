package com.bytedance.android.livehostapi.platform.depend.user;

import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class ILoginTokenCallback {

    public interface TokenCallBack {
        void onCancel();

        void onSuccess(Map<String, String> r100);
    }

    public ILoginTokenCallback() {
    }
}
