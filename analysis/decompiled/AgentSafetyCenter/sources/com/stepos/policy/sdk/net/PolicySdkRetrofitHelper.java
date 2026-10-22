package com.stepos.policy.sdk.net;

import com.stepos.policy.sdk.api.IPolicyApiService;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicySdkRetrofitHelper {
    public static final PolicySdkRetrofitHelper INSTANCE = new PolicySdkRetrofitHelper();

    private PolicySdkRetrofitHelper() {
    }

    public final IPolicyApiService getApiService() {
        return (IPolicyApiService) PolicySdkRetrofitCreator.INSTANCE.create(IPolicyApiService.class);
    }
}
