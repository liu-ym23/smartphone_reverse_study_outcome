package com.bytedance.android.livesdkapi.commerce.impl;

import com.bytedance.android.livesdkapi.commerce.param.IInitParams;

/* JADX INFO: loaded from: classes12.dex */
public class ECInitParams implements IInitParams {
    private String secUid;
    private String uid;

    @Override // com.bytedance.android.livesdkapi.commerce.param.IInitParams
    public String getSecUid() {
        return this.secUid;
    }

    @Override // com.bytedance.android.livesdkapi.commerce.param.IInitParams
    public String getUid() {
        return this.uid;
    }

    public ECInitParams(String r100, String r101) {
        this.uid = r100;
        this.secUid = r101;
    }
}
