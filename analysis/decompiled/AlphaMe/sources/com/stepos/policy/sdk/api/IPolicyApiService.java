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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0085\u0001\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u00062\b\b\u0001\u0010\u0011\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0012Jg\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J{\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\f\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0018Jq\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010\u001b\u001a\u00020\n2\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJg\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u00062\b\b\u0001\u0010\u000f\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010!\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/stepos/policy/sdk/api/IPolicyApiService;", "", "getPolicyUsingGET", "Lretrofit2/Response;", "Lcom/stepos/policy/sdk/bean/PolicyNewestResponse;", "appId", "", "appSign", "category", "reqTime", "", "language", Constants.JSON_KEY_VERSION, "brand", "model", "osVersion", "versionName", "policyMd5", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getServiceConfig", "Lcom/stepos/policy/sdk/bean/PolicyServiceConfigResponse;", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "policyHistoryListUsingGET", "Lcom/stepos/policy/sdk/bean/PolicyHistoryListResponse;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "policyVersionInfoUsingGET", "Lcom/stepos/policy/sdk/bean/PolicyVersionResponse;", "versionId", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadOperateRecordUsingPOST", "Lcom/stepos/policy/sdk/bean/PolicyOperateRecordResponse;", "policysdkRecordRequest", "Lcom/stepos/policy/sdk/bean/PolicyRecordRequest;", "(Ljava/lang/String;Ljava/lang/String;JLcom/stepos/policy/sdk/bean/PolicyRecordRequest;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "policysdk_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface IPolicyApiService {
    @GET("internal/v1/policy")
    @Nullable
    Object getPolicyUsingGET(@Header("appId") @NotNull String str, @Header("appSign") @NotNull String str2, @NotNull @Query("category") String str3, @Header("reqTime") long j4, @Header("X-client-language") @NotNull String str4, @Query(Constants.JSON_KEY_VERSION) long j5, @Header("X-brand") @NotNull String str5, @Header("X-model") @NotNull String str6, @Header("X-os-version") @NotNull String str7, @Header("X-version-name") @NotNull String str8, @Header("X-policy-digest") @NotNull String str9, @NotNull Continuation<? super Response<PolicyNewestResponse>> continuation);

    @GET("/internal/v1/service/config")
    @Nullable
    Object getServiceConfig(@Header("appId") @NotNull String str, @Header("appSign") @NotNull String str2, @Header("reqTime") long j4, @Header("X-client-language") @NotNull String str3, @Header("X-brand") @NotNull String str4, @Header("X-model") @NotNull String str5, @Header("X-os-version") @NotNull String str6, @Header("X-version-name") @NotNull String str7, @NotNull Continuation<? super Response<PolicyServiceConfigResponse>> continuation);

    @GET("internal/v1/history/list")
    @Nullable
    Object policyHistoryListUsingGET(@Header("appId") @NotNull String str, @Header("appSign") @NotNull String str2, @NotNull @Query("category") String str3, @Header("reqTime") long j4, @Header("X-client-language") @NotNull String str4, @Query(Constants.JSON_KEY_VERSION) long j5, @Header("X-brand") @NotNull String str5, @Header("X-model") @NotNull String str6, @Header("X-os-version") @NotNull String str7, @Header("X-version-name") @NotNull String str8, @NotNull Continuation<? super Response<PolicyHistoryListResponse>> continuation);

    @GET("internal/v1/version/{versionId}")
    @Nullable
    Object policyVersionInfoUsingGET(@Header("appId") @NotNull String str, @Header("appSign") @NotNull String str2, @Header("reqTime") long j4, @Header("X-client-language") @NotNull String str3, @Path("versionId") long j5, @Header("X-brand") @NotNull String str4, @Header("X-model") @NotNull String str5, @Header("X-os-version") @NotNull String str6, @Header("X-version-name") @NotNull String str7, @NotNull Continuation<? super Response<PolicyVersionResponse>> continuation);

    @POST("internal/v1/operate/record")
    @Nullable
    Object uploadOperateRecordUsingPOST(@Header("appId") @NotNull String str, @Header("appSign") @NotNull String str2, @Header("reqTime") long j4, @Body @NotNull PolicyRecordRequest policyRecordRequest, @Header("X-brand") @NotNull String str3, @Header("X-model") @NotNull String str4, @Header("X-os-version") @NotNull String str5, @Header("X-version-name") @NotNull String str6, @NotNull Continuation<? super Response<PolicyOperateRecordResponse>> continuation);
}
