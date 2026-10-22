package com.bytedance.android.livesdkapi.commerce.impl;

import com.bytedance.android.livesdkapi.commerce.param.IOpenShowcaseParams;

/* JADX INFO: loaded from: classes12.dex */
public class OpenShowcaseParams implements IOpenShowcaseParams {
    private String secUserId;
    private String userId;

    @Override // com.bytedance.android.livesdkapi.commerce.param.IOpenShowcaseParams
    public String secUserId() {
        return this.secUserId;
    }

    @Override // com.bytedance.android.livesdkapi.commerce.param.IOpenShowcaseParams
    public String userId() {
        return this.userId;
    }

    public OpenShowcaseParams(String r100, String r101) {
        this.userId = r100;
        this.secUserId = r101;
    }
}
