package com.stepos.policy.sdk.api;

import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import nb.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class PolicyApiService {
    private final IPolicyApiService apiService;

    public PolicyApiService(IPolicyApiService iPolicyApiService) {
        iPolicyApiService.getClass();
        this.apiService = iPolicyApiService;
    }

    public final Object getPolicyUsingGET(String str, String str2, String str3, long j10, String str4, long j11, String str5, String str6, String str7, String str8, String str9, c cVar) {
        return this.apiService.getPolicyUsingGET(str, str2, str3, j10, str4, j11, str5, str6, str7, str8, str9, cVar);
    }

    public final Object getServiceConfig(String str, String str2, long j10, String str3, String str4, String str5, String str6, String str7, c cVar) {
        return this.apiService.getServiceConfig(str, str2, j10, str3, str4, str5, str6, str7, cVar);
    }

    public final Object policyHistoryListUsingGET(String str, String str2, String str3, long j10, String str4, long j11, String str5, String str6, String str7, String str8, c cVar) {
        return this.apiService.policyHistoryListUsingGET(str, str2, str3, j10, str4, j11, str5, str6, str7, str8, cVar);
    }

    public final Object policyVersionInfoUsingGET(String str, String str2, long j10, String str3, long j11, String str4, String str5, String str6, String str7, c cVar) {
        return this.apiService.policyVersionInfoUsingGET(str, str2, j10, str3, j11, str4, str5, str6, str7, cVar);
    }

    public final Object uploadOperateRecordUsingPOST(String str, String str2, long j10, PolicyRecordRequest policyRecordRequest, String str3, String str4, String str5, String str6, c cVar) {
        return this.apiService.uploadOperateRecordUsingPOST(str, str2, j10, policyRecordRequest, str3, str4, str5, str6, cVar);
    }
}
