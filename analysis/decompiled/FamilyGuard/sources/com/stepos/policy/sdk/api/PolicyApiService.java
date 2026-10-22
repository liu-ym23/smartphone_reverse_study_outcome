package com.stepos.policy.sdk.api;

import R4.t;
import Z3.e;
import com.stepos.policy.sdk.bean.AppSecretQueryRequest;
import com.stepos.policy.sdk.bean.AppSecretQueryResponse;
import com.stepos.policy.sdk.bean.PolicyHistoryListResponse;
import com.stepos.policy.sdk.bean.PolicyNewestResponse;
import com.stepos.policy.sdk.bean.PolicyOperateRecordResponse;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.bean.PolicyServiceConfigResponse;
import com.stepos.policy.sdk.bean.PolicyVersionResponse;
import j4.k;

/* loaded from: classes.dex */
public final class PolicyApiService {
    private final IPolicyApiService apiService;

    public PolicyApiService(IPolicyApiService iPolicyApiService) {
        k.g(iPolicyApiService, "apiService");
        this.apiService = iPolicyApiService;
    }

    public final Object getPolicyUsingGET(String str, String str2, String str3, long j5, String str4, long j6, String str5, String str6, String str7, String str8, String str9, e<? super t<PolicyNewestResponse>> eVar) {
        return this.apiService.getPolicyUsingGET(str, str2, str3, j5, str4, j6, str5, str6, str7, str8, str9, eVar);
    }

    public final Object getServiceConfig(String str, String str2, long j5, String str3, String str4, String str5, String str6, String str7, e<? super t<PolicyServiceConfigResponse>> eVar) {
        return this.apiService.getServiceConfig(str, str2, j5, str3, str4, str5, str6, str7, eVar);
    }

    public final Object policyHistoryListUsingGET(String str, String str2, String str3, long j5, String str4, long j6, String str5, String str6, String str7, String str8, e<? super t<PolicyHistoryListResponse>> eVar) {
        return this.apiService.policyHistoryListUsingGET(str, str2, str3, j5, str4, j6, str5, str6, str7, str8, eVar);
    }

    public final Object policyVersionInfoUsingGET(String str, String str2, long j5, String str3, long j6, String str4, String str5, String str6, String str7, e<? super t<PolicyVersionResponse>> eVar) {
        return this.apiService.policyVersionInfoUsingGET(str, str2, j5, str3, j6, str4, str5, str6, str7, eVar);
    }

    public final Object queryAppSecret(AppSecretQueryRequest appSecretQueryRequest, e<? super t<AppSecretQueryResponse>> eVar) {
        return this.apiService.queryAppSecret(appSecretQueryRequest, eVar);
    }

    public final Object uploadOperateRecordUsingPOST(String str, String str2, long j5, PolicyRecordRequest policyRecordRequest, String str3, String str4, String str5, String str6, e<? super t<PolicyOperateRecordResponse>> eVar) {
        return this.apiService.uploadOperateRecordUsingPOST(str, str2, j5, policyRecordRequest, str3, str4, str5, str6, eVar);
    }
}
