package com.stepos.policy.sdk.api;

import H7.c;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.policy.sdk.bean.PolicyHistoryListResponse;
import com.stepos.policy.sdk.bean.PolicyNewestResponse;
import com.stepos.policy.sdk.bean.PolicyOperateRecordResponse;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.bean.PolicyServiceConfigResponse;
import com.stepos.policy.sdk.bean.PolicyVersionResponse;
import kotlin.Metadata;
import qa.L;
import sa.InterfaceC1926a;
import sa.f;
import sa.i;
import sa.o;
import sa.s;
import sa.t;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0087\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J}\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\t\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015Js\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\u0016\u001a\u00020\u00062\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019Ji\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\u001b\u001a\u00020\u001a2\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJi\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u000f2\b\b\u0001\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0004\u001a\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00022\b\b\u0001\u0010\n\u001a\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\u00022\b\b\u0001\u0010\f\u001a\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b \u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/stepos/policy/sdk/api/IPolicyApiService;", "", "", "appId", "appSign", QueryAlgorithmBundle.KEY_CATEGORY, "", "reqTime", "language", "version", "brand", AlgorithmUpdateBundle.KEY_SUFFIX_MODEL, "osVersion", "versionName", "policyMd5", "Lqa/L;", "Lcom/stepos/policy/sdk/bean/PolicyNewestResponse;", "getPolicyUsingGET", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/policy/sdk/bean/PolicyHistoryListResponse;", "policyHistoryListUsingGET", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "versionId", "Lcom/stepos/policy/sdk/bean/PolicyVersionResponse;", "policyVersionInfoUsingGET", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;", "policysdkRecordRequest", "Lcom/stepos/policy/sdk/bean/PolicyOperateRecordResponse;", "uploadOperateRecordUsingPOST", "(Ljava/lang/String;Ljava/lang/String;JLcom/stepos/policy/sdk/bean/PolicyRecordRequest;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "Lcom/stepos/policy/sdk/bean/PolicyServiceConfigResponse;", "getServiceConfig", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface IPolicyApiService {
    @f("internal/v1/policy")
    Object getPolicyUsingGET(@i("appId") String str, @i("appSign") String str2, @t(QueryAlgorithmBundle.KEY_CATEGORY) String str3, @i("reqTime") long j5, @i("X-client-language") String str4, @t("version") long j6, @i("X-brand") String str5, @i("X-model") String str6, @i("X-os-version") String str7, @i("X-version-name") String str8, @i("X-policy-digest") String str9, c<? super L<PolicyNewestResponse>> cVar);

    @f("/internal/v1/service/config")
    Object getServiceConfig(@i("appId") String str, @i("appSign") String str2, @i("reqTime") long j5, @i("X-client-language") String str3, @i("X-brand") String str4, @i("X-model") String str5, @i("X-os-version") String str6, @i("X-version-name") String str7, c<? super L<PolicyServiceConfigResponse>> cVar);

    @f("internal/v1/history/list")
    Object policyHistoryListUsingGET(@i("appId") String str, @i("appSign") String str2, @t(QueryAlgorithmBundle.KEY_CATEGORY) String str3, @i("reqTime") long j5, @i("X-client-language") String str4, @t("version") long j6, @i("X-brand") String str5, @i("X-model") String str6, @i("X-os-version") String str7, @i("X-version-name") String str8, c<? super L<PolicyHistoryListResponse>> cVar);

    @f("internal/v1/version/{versionId}")
    Object policyVersionInfoUsingGET(@i("appId") String str, @i("appSign") String str2, @i("reqTime") long j5, @i("X-client-language") String str3, @s("versionId") long j6, @i("X-brand") String str4, @i("X-model") String str5, @i("X-os-version") String str6, @i("X-version-name") String str7, c<? super L<PolicyVersionResponse>> cVar);

    @o("internal/v1/operate/record")
    Object uploadOperateRecordUsingPOST(@i("appId") String str, @i("appSign") String str2, @i("reqTime") long j5, @InterfaceC1926a PolicyRecordRequest policyRecordRequest, @i("X-brand") String str3, @i("X-model") String str4, @i("X-os-version") String str5, @i("X-version-name") String str6, c<? super L<PolicyOperateRecordResponse>> cVar);
}
