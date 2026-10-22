package com.stepos.policy.sdk.net;

import com.stepos.policy.sdk.api.IPolicyApiService;

/* loaded from: classes.dex */
public final class PolicySdkRetrofitHelper {
    public static final PolicySdkRetrofitHelper INSTANCE = new PolicySdkRetrofitHelper();

    private PolicySdkRetrofitHelper() {
    }

    public final IPolicyApiService getApiService() {
        return (IPolicyApiService) PolicySdkRetrofitCreator.INSTANCE.create(IPolicyApiService.class);
    }
}
