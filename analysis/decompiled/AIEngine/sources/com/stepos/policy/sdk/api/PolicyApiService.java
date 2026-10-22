package com.stepos.policy.sdk.api;

import com.stepos.policy.sdk.bean.AppSecretQueryRequest;
import com.stepos.policy.sdk.bean.AppSecretQueryResponse;
import com.stepos.policy.sdk.bean.PolicyHistoryListResponse;
import com.stepos.policy.sdk.bean.PolicyNewestResponse;
import com.stepos.policy.sdk.bean.PolicyOperateRecordResponse;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.bean.PolicyServiceConfigResponse;
import com.stepos.policy.sdk.bean.PolicyVersionResponse;
import kotlin.jvm.internal.g;
import qb.b;
import xd.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class PolicyApiService {
    private final IPolicyApiService apiService;

    public PolicyApiService(IPolicyApiService apiService) {
        g.f(apiService, "apiService");
        this.apiService = apiService;
    }

    public final Object getPolicyUsingGET(String str, String str2, String str3, long j10, String str4, long j11, String str5, String str6, String str7, String str8, String str9, b<? super r<PolicyNewestResponse>> bVar) {
        return this.apiService.getPolicyUsingGET(str, str2, str3, j10, str4, j11, str5, str6, str7, str8, str9, bVar);
    }

    public final Object getServiceConfig(String str, String str2, long j10, String str3, String str4, String str5, String str6, String str7, b<? super r<PolicyServiceConfigResponse>> bVar) {
        return this.apiService.getServiceConfig(str, str2, j10, str3, str4, str5, str6, str7, bVar);
    }

    public final Object policyHistoryListUsingGET(String str, String str2, String str3, long j10, String str4, long j11, String str5, String str6, String str7, String str8, b<? super r<PolicyHistoryListResponse>> bVar) {
        return this.apiService.policyHistoryListUsingGET(str, str2, str3, j10, str4, j11, str5, str6, str7, str8, bVar);
    }

    public final Object policyVersionInfoUsingGET(String str, String str2, long j10, String str3, long j11, String str4, String str5, String str6, String str7, b<? super r<PolicyVersionResponse>> bVar) {
        return this.apiService.policyVersionInfoUsingGET(str, str2, j10, str3, j11, str4, str5, str6, str7, bVar);
    }

    public final Object queryAppSecret(AppSecretQueryRequest appSecretQueryRequest, b<? super r<AppSecretQueryResponse>> bVar) {
        return this.apiService.queryAppSecret(appSecretQueryRequest, bVar);
    }

    public final Object uploadOperateRecordUsingPOST(String str, String str2, long j10, PolicyRecordRequest policyRecordRequest, String str3, String str4, String str5, String str6, b<? super r<PolicyOperateRecordResponse>> bVar) {
        return this.apiService.uploadOperateRecordUsingPOST(str, str2, j10, policyRecordRequest, str3, str4, str5, str6, bVar);
    }
}
