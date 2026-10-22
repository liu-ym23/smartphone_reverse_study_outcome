package com.bytedance.android.livesdkapi.wallet;

import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
public class LiveCJPayResult {
    private Map<String, String> mCallBackInfo;
    private volatile int mCode;

    public Map<String, String> getCallBackInfo() {
        return this.mCallBackInfo;
    }

    public int getCode() {
        return this.mCode;
    }

    public LiveCJPayResult(Map<String, String> r100, int r101) {
        this.mCallBackInfo = r100;
        this.mCode = r101;
    }
}
