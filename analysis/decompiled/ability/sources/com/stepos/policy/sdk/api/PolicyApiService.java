package com.stepos.policy.sdk.api;

import H7.c;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.policy.sdk.bean.PolicyHistoryListResponse;
import com.stepos.policy.sdk.bean.PolicyNewestResponse;
import com.stepos.policy.sdk.bean.PolicyOperateRecordResponse;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.bean.PolicyServiceConfigResponse;
import com.stepos.policy.sdk.bean.PolicyVersionResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import qa.L;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005Jq\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016Ji\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019Ja\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJY\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b!\u0010\"JY\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00132\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010&\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006'"}, d2 = {"Lcom/stepos/policy/sdk/api/PolicyApiService;", "", "Lcom/stepos/policy/sdk/api/IPolicyApiService;", "apiService", AppAgent.CONSTRUCT, "(Lcom/stepos/policy/sdk/api/IPolicyApiService;)V", "", "appId", "appSign", QueryAlgorithmBundle.KEY_CATEGORY, "", "eqTime", "language", "version", "brand", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "osVersion", "versionName", "policyMd5", "Lqa/L;", "Lcom/stepos/policy/sdk/bean/PolicyNewestResponse;", "getPolicyUsingGET", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/policy/sdk/bean/PolicyHistoryListResponse;", "policyHistoryListUsingGET", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "versionId", "Lcom/stepos/policy/sdk/bean/PolicyVersionResponse;", "policyVersionInfoUsingGET", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;", "policyRecordRequest", "Lcom/stepos/policy/sdk/bean/PolicyOperateRecordResponse;", "uploadOperateRecordUsingPOST", "(Ljava/lang/String;Ljava/lang/String;JLcom/stepos/policy/sdk/bean/PolicyRecordRequest;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/policy/sdk/bean/PolicyServiceConfigResponse;", "getServiceConfig", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/policy/sdk/api/IPolicyApiService;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PolicyApiService {
    private final IPolicyApiService apiService;

    public PolicyApiService(IPolicyApiService apiService) {
        k.f(apiService, "apiService");
        this.apiService = apiService;
    }

    public final Object getPolicyUsingGET(String str, String str2, String str3, long j5, String str4, long j6, String str5, String str6, String str7, String str8, String str9, c<? super L<PolicyNewestResponse>> cVar) {
        return this.apiService.getPolicyUsingGET(str, str2, str3, j5, str4, j6, str5, str6, str7, str8, str9, cVar);
    }

    public final Object getServiceConfig(String str, String str2, long j5, String str3, String str4, String str5, String str6, String str7, c<? super L<PolicyServiceConfigResponse>> cVar) {
        return this.apiService.getServiceConfig(str, str2, j5, str3, str4, str5, str6, str7, cVar);
    }

    public final Object policyHistoryListUsingGET(String str, String str2, String str3, long j5, String str4, long j6, String str5, String str6, String str7, String str8, c<? super L<PolicyHistoryListResponse>> cVar) {
        return this.apiService.policyHistoryListUsingGET(str, str2, str3, j5, str4, j6, str5, str6, str7, str8, cVar);
    }

    public final Object policyVersionInfoUsingGET(String str, String str2, long j5, String str3, long j6, String str4, String str5, String str6, String str7, c<? super L<PolicyVersionResponse>> cVar) {
        return this.apiService.policyVersionInfoUsingGET(str, str2, j5, str3, j6, str4, str5, str6, str7, cVar);
    }

    public final Object uploadOperateRecordUsingPOST(String str, String str2, long j5, PolicyRecordRequest policyRecordRequest, String str3, String str4, String str5, String str6, c<? super L<PolicyOperateRecordResponse>> cVar) {
        return this.apiService.uploadOperateRecordUsingPOST(str, str2, j5, policyRecordRequest, str3, str4, str5, str6, cVar);
    }
}
