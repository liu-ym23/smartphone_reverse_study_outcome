package com.stepos.policy.sdk.api;

import U4.a;
import U4.f;
import U4.i;
import U4.o;
import U4.s;
import U4.t;
import Z3.e;
import com.stepos.policy.sdk.bean.AppSecretQueryRequest;
import com.stepos.policy.sdk.bean.AppSecretQueryResponse;
import com.stepos.policy.sdk.bean.PolicyHistoryListResponse;
import com.stepos.policy.sdk.bean.PolicyNewestResponse;
import com.stepos.policy.sdk.bean.PolicyOperateRecordResponse;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.bean.PolicyServiceConfigResponse;
import com.stepos.policy.sdk.bean.PolicyVersionResponse;

/* loaded from: classes.dex */
public interface IPolicyApiService {
    @f("internal/v1/policy")
    Object getPolicyUsingGET(@i("appId") String str, @i("appSign") String str2, @t("category") String str3, @i("reqTime") long j5, @i("X-client-language") String str4, @t("version") long j6, @i("X-brand") String str5, @i("X-model") String str6, @i("X-os-version") String str7, @i("X-version-name") String str8, @i("X-policy-digest") String str9, e<? super R4.t<PolicyNewestResponse>> eVar);

    @f("/internal/v1/service/config")
    Object getServiceConfig(@i("appId") String str, @i("appSign") String str2, @i("reqTime") long j5, @i("X-client-language") String str3, @i("X-brand") String str4, @i("X-model") String str5, @i("X-os-version") String str6, @i("X-version-name") String str7, e<? super R4.t<PolicyServiceConfigResponse>> eVar);

    @f("internal/v1/history/list")
    Object policyHistoryListUsingGET(@i("appId") String str, @i("appSign") String str2, @t("category") String str3, @i("reqTime") long j5, @i("X-client-language") String str4, @t("version") long j6, @i("X-brand") String str5, @i("X-model") String str6, @i("X-os-version") String str7, @i("X-version-name") String str8, e<? super R4.t<PolicyHistoryListResponse>> eVar);

    @f("internal/v1/version/{versionId}")
    Object policyVersionInfoUsingGET(@i("appId") String str, @i("appSign") String str2, @i("reqTime") long j5, @i("X-client-language") String str3, @s("versionId") long j6, @i("X-brand") String str4, @i("X-model") String str5, @i("X-os-version") String str6, @i("X-version-name") String str7, e<? super R4.t<PolicyVersionResponse>> eVar);

    @o("internal/v1/app/secret")
    Object queryAppSecret(@a AppSecretQueryRequest appSecretQueryRequest, e<? super R4.t<AppSecretQueryResponse>> eVar);

    @o("internal/v1/operate/record")
    Object uploadOperateRecordUsingPOST(@i("appId") String str, @i("appSign") String str2, @i("reqTime") long j5, @a PolicyRecordRequest policyRecordRequest, @i("X-brand") String str3, @i("X-model") String str4, @i("X-os-version") String str5, @i("X-version-name") String str6, e<? super R4.t<PolicyOperateRecordResponse>> eVar);
}
