package com.stepos.policy.sdk.api;

import com.stepos.activeview.utils.Constants;
import com.stepos.policy.sdk.bean.PolicyHistoryListResponse;
import com.stepos.policy.sdk.bean.PolicyNewestResponse;
import com.stepos.policy.sdk.bean.PolicyOperateRecordResponse;
import com.stepos.policy.sdk.bean.PolicyRecordRequest;
import com.stepos.policy.sdk.bean.PolicyServiceConfigResponse;
import com.stepos.policy.sdk.bean.PolicyVersionResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Jo\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0015JW\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018Jg\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ_\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJW\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Lcom/stepos/policy/sdk/api/PolicyApiService;", "", "apiService", "Lcom/stepos/policy/sdk/api/IPolicyApiService;", "(Lcom/stepos/policy/sdk/api/IPolicyApiService;)V", "getPolicyUsingGET", "Lretrofit2/Response;", "Lcom/stepos/policy/sdk/bean/PolicyNewestResponse;", "appId", "", "appSign", "category", "eqTime", "", "language", Constants.JSON_KEY_VERSION, "brand", "model", "osVersion", "versionName", "policyMd5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServiceConfig", "Lcom/stepos/policy/sdk/bean/PolicyServiceConfigResponse;", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "policyHistoryListUsingGET", "Lcom/stepos/policy/sdk/bean/PolicyHistoryListResponse;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "policyVersionInfoUsingGET", "Lcom/stepos/policy/sdk/bean/PolicyVersionResponse;", "versionId", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadOperateRecordUsingPOST", "Lcom/stepos/policy/sdk/bean/PolicyOperateRecordResponse;", "policyRecordRequest", "Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;", "(Ljava/lang/String;Ljava/lang/String;JLcom/stepos/policy/sdk/bean/PolicyRecordRequest;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PolicyApiService {

    @NotNull
    private final IPolicyApiService apiService;

    public PolicyApiService(@NotNull IPolicyApiService apiService) {
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        this.apiService = apiService;
    }

    @Nullable
    public final Object getPolicyUsingGET(@NotNull String str, @NotNull String str2, @NotNull String str3, long j4, @NotNull String str4, long j5, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull Continuation<? super Response<PolicyNewestResponse>> continuation) {
        return this.apiService.getPolicyUsingGET(str, str2, str3, j4, str4, j5, str5, str6, str7, str8, str9, continuation);
    }

    @Nullable
    public final Object getServiceConfig(@NotNull String str, @NotNull String str2, long j4, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull Continuation<? super Response<PolicyServiceConfigResponse>> continuation) {
        return this.apiService.getServiceConfig(str, str2, j4, str3, str4, str5, str6, str7, continuation);
    }

    @Nullable
    public final Object policyHistoryListUsingGET(@NotNull String str, @NotNull String str2, @NotNull String str3, long j4, @NotNull String str4, long j5, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull Continuation<? super Response<PolicyHistoryListResponse>> continuation) {
        return this.apiService.policyHistoryListUsingGET(str, str2, str3, j4, str4, j5, str5, str6, str7, str8, continuation);
    }

    @Nullable
    public final Object policyVersionInfoUsingGET(@NotNull String str, @NotNull String str2, long j4, @NotNull String str3, long j5, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull Continuation<? super Response<PolicyVersionResponse>> continuation) {
        return this.apiService.policyVersionInfoUsingGET(str, str2, j4, str3, j5, str4, str5, str6, str7, continuation);
    }

    @Nullable
    public final Object uploadOperateRecordUsingPOST(@NotNull String str, @NotNull String str2, long j4, @NotNull PolicyRecordRequest policyRecordRequest, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull Continuation<? super Response<PolicyOperateRecordResponse>> continuation) {
        return this.apiService.uploadOperateRecordUsingPOST(str, str2, j4, policyRecordRequest, str3, str4, str5, str6, continuation);
    }
}
