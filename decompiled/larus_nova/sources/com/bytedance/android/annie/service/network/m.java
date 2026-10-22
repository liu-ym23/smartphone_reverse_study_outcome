package com.bytedance.android.annie.service.network;

import com.bytedance.retrofit2.client.Client;
import com.bytedance.ttnet.retrofit.SsRetrofitClient;

/* JADX INFO: loaded from: classes43.dex */
public final class m implements Client.Provider {
    public m() {
    }

    @Override // com.bytedance.retrofit2.client.Client.Provider
    public final Client get() {
        return new SsRetrofitClient();
    }
}
