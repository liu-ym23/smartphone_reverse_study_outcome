package com.stepos.policy.sdk.net;

import com.stepos.policy.sdk.api.IPolicyApiService;
import kotlin.Metadata;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/policy/sdk/net/PolicySdkRetrofitHelper;", "", "()V", "apiService", "Lcom/stepos/policy/sdk/api/IPolicyApiService;", "getApiService", "()Lcom/stepos/policy/sdk/api/IPolicyApiService;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@SourceDebugExtension({"SMAP\nPolicySdkRetrofitHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PolicySdkRetrofitHelper.kt\ncom/stepos/policy/sdk/net/PolicySdkRetrofitHelper\n+ 2 PolicySdkRetrofitCreator.kt\ncom/stepos/policy/sdk/net/PolicySdkRetrofitCreator\n*L\n1#1,9:1\n91#2:10\n*S KotlinDebug\n*F\n+ 1 PolicySdkRetrofitHelper.kt\ncom/stepos/policy/sdk/net/PolicySdkRetrofitHelper\n*L\n7#1:10\n*E\n"})
/* loaded from: classes.dex */
public final class PolicySdkRetrofitHelper {

    @NotNull
    public static final PolicySdkRetrofitHelper INSTANCE = new PolicySdkRetrofitHelper();

    private PolicySdkRetrofitHelper() {
    }

    @NotNull
    public final IPolicyApiService getApiService() {
        return (IPolicyApiService) PolicySdkRetrofitCreator.INSTANCE.create(IPolicyApiService.class);
    }
}
