package com.bytedance.android.gamecp.host_api.callback;

import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public class TTCJPayResult {
    private Map<String, String> mCallBackInfo;
    private volatile int mCode;

    public TTCJPayResult() {
    }

    public Map<String, String> getCallBackInfo() {
        return this.mCallBackInfo;
    }

    public int getCode() {
        return this.mCode;
    }

    public void setCallBackInfo(Map<String, String> r100) {
        this.mCallBackInfo = r100;
    }

    public void setCode(int r100) {
        this.mCode = r100;
    }

    public TTCJPayResult(Map<String, String> r100, int r101) {
        this.mCallBackInfo = r100;
        this.mCode = r101;
    }
}
