package com.stepos.policy.sdk.api;

import com.stepos.policy.sdk.bean.AppSecretQueryRequest;
import com.stepos.policy.sdk.bean.AppSecretQueryResponse;
import com.stepos.policy.sdk.bean.PolicyHistoryListResponse;
import com.stepos.policy.sdk.bean.PolicyNewestResponse;
import com.stepos.policy.sdk.bean.PolicyOperateRecordResponse;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.bean.PolicyServiceConfigResponse;
import com.stepos.policy.sdk.bean.PolicyVersionResponse;
import qb.b;
import xd.r;
import zd.a;
import zd.f;
import zd.i;
import zd.o;
import zd.s;
import zd.t;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface IPolicyApiService {
    @f("internal/v1/policy")
    Object getPolicyUsingGET(@i("appId") String str, @i("appSign") String str2, @t("category") String str3, @i("reqTime") long j10, @i("X-client-language") String str4, @t("version") long j11, @i("X-brand") String str5, @i("X-model") String str6, @i("X-os-version") String str7, @i("X-version-name") String str8, @i("X-policy-digest") String str9, b<? super r<PolicyNewestResponse>> bVar);

    @f("/internal/v1/service/config")
    Object getServiceConfig(@i("appId") String str, @i("appSign") String str2, @i("reqTime") long j10, @i("X-client-language") String str3, @i("X-brand") String str4, @i("X-model") String str5, @i("X-os-version") String str6, @i("X-version-name") String str7, b<? super r<PolicyServiceConfigResponse>> bVar);

    @f("internal/v1/history/list")
    Object policyHistoryListUsingGET(@i("appId") String str, @i("appSign") String str2, @t("category") String str3, @i("reqTime") long j10, @i("X-client-language") String str4, @t("version") long j11, @i("X-brand") String str5, @i("X-model") String str6, @i("X-os-version") String str7, @i("X-version-name") String str8, b<? super r<PolicyHistoryListResponse>> bVar);

    @f("internal/v1/version/{versionId}")
    Object policyVersionInfoUsingGET(@i("appId") String str, @i("appSign") String str2, @i("reqTime") long j10, @i("X-client-language") String str3, @s("versionId") long j11, @i("X-brand") String str4, @i("X-model") String str5, @i("X-os-version") String str6, @i("X-version-name") String str7, b<? super r<PolicyVersionResponse>> bVar);

    @o("internal/v1/app/secret")
    Object queryAppSecret(@a AppSecretQueryRequest appSecretQueryRequest, b<? super r<AppSecretQueryResponse>> bVar);

    @o("internal/v1/operate/record")
    Object uploadOperateRecordUsingPOST(@i("appId") String str, @i("appSign") String str2, @i("reqTime") long j10, @a PolicyRecordRequest policyRecordRequest, @i("X-brand") String str3, @i("X-model") String str4, @i("X-os-version") String str5, @i("X-version-name") String str6, b<? super r<PolicyOperateRecordResponse>> bVar);
}
