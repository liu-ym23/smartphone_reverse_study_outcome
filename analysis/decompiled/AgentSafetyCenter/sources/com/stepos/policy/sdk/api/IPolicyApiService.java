package com.stepos.policy.sdk.api;

import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import ke.a;
import ke.f;
import ke.i;
import ke.o;
import ke.s;
import ke.t;
import nb.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public interface IPolicyApiService {
    @f("internal/v1/policy")
    Object getPolicyUsingGET(@i("appId") String str, @i("appSign") String str2, @t("category") String str3, @i("reqTime") long j10, @i("X-client-language") String str4, @t("version") long j11, @i("X-brand") String str5, @i("X-model") String str6, @i("X-os-version") String str7, @i("X-version-name") String str8, @i("X-policy-digest") String str9, c cVar);

    @f("/internal/v1/service/config")
    Object getServiceConfig(@i("appId") String str, @i("appSign") String str2, @i("reqTime") long j10, @i("X-client-language") String str3, @i("X-brand") String str4, @i("X-model") String str5, @i("X-os-version") String str6, @i("X-version-name") String str7, c cVar);

    @f("internal/v1/history/list")
    Object policyHistoryListUsingGET(@i("appId") String str, @i("appSign") String str2, @t("category") String str3, @i("reqTime") long j10, @i("X-client-language") String str4, @t("version") long j11, @i("X-brand") String str5, @i("X-model") String str6, @i("X-os-version") String str7, @i("X-version-name") String str8, c cVar);

    @f("internal/v1/version/{versionId}")
    Object policyVersionInfoUsingGET(@i("appId") String str, @i("appSign") String str2, @i("reqTime") long j10, @i("X-client-language") String str3, @s("versionId") long j11, @i("X-brand") String str4, @i("X-model") String str5, @i("X-os-version") String str6, @i("X-version-name") String str7, c cVar);

    @o("internal/v1/operate/record")
    Object uploadOperateRecordUsingPOST(@i("appId") String str, @i("appSign") String str2, @i("reqTime") long j10, @a PolicyRecordRequest policyRecordRequest, @i("X-brand") String str3, @i("X-model") String str4, @i("X-os-version") String str5, @i("X-version-name") String str6, c cVar);
}
