package com.stepos.policy.sdk.net;

import com.stepos.policy.sdk.api.IPolicyApiService;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicySdkRetrofitHelper {
    public static final PolicySdkRetrofitHelper INSTANCE = new PolicySdkRetrofitHelper();

    private PolicySdkRetrofitHelper() {
    }

    public final IPolicyApiService getApiService() {
        return (IPolicyApiService) PolicySdkRetrofitCreator.INSTANCE.create(IPolicyApiService.class);
    }
}
