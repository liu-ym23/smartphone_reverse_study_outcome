package com.bytedance.ai.resource.core.net;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.bytedance.ai.resource.core.bean.FetchAppletDownLoadInfoRequest;
import com.bytedance.ai.resource.core.bean.FetchAppletPreDownLoadInfoRequest;
import com.bytedance.ai.resource.core.bean.IsInAppWhitelistData;
import com.bytedance.ai.resource.core.bean.IsInAppWhitelistRequest;
import com.bytedance.ai.resource.core.bean.OpenPlatformAppletList;
import com.bytedance.ai.resource.core.bean.OpenPlatformBaseResponse;
import com.bytedance.ai.resource.core.bean.OpenPlatformDebugSchemaData;
import com.bytedance.ai.resource.core.bean.OpenPlatformDekDecryptRequest;
import com.bytedance.ai.resource.core.bean.OpenPlatformDekDecryptResponseData;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfoList;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfoRequest;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppVersionList;
import com.bytedance.ai.resource.core.bean.OpenPlatformPublicKeyListData;
import com.bytedance.ai.resource.core.bean.QrCodeRequest;
import com.bytedance.bdturing.loginverify.LoginVerifyService;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Header;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Path;
import com.bytedance.retrofit2.http.Query;
import com.heytap.mcssdk.constant.b;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u001e\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u001e\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u0007H'J\u001e\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u000bH'J2\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0006\u001a\u00020\u0012H'J<\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u0010\u001a\u00020\u00112\b\b\u0003\u0010\u0015\u001a\u00020\u000f2\b\b\u0001\u0010\u0006\u001a\u00020\u0016H'J(\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00040\u00032\b\b\u0001\u0010\u0019\u001a\u00020\u000f2\b\b\u0001\u0010\u0006\u001a\u00020\u001aH'J\u001e\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00040\u00032\b\b\u0001\u0010\u0019\u001a\u00020\u000fH'J\u001e\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00040\u00032\b\b\u0001\u0010\u0006\u001a\u00020\u001fH'J<\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020!0\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u0010\u001a\u00020\u00112\b\b\u0003\u0010\u0015\u001a\u00020\u000f2\b\b\u0001\u0010\u0006\u001a\u00020\"H'J\\\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020$0\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0003\u0010\u0010\u001a\u00020\u00112\b\b\u0001\u0010\u0019\u001a\u00020\u000f2\b\b\u0001\u0010%\u001a\u00020\u000f2\b\b\u0001\u0010&\u001a\u00020\u000f2\n\b\u0003\u0010'\u001a\u0004\u0018\u00010\u000f2\b\b\u0003\u0010(\u001a\u00020\u0011H'¨\u0006)"}, d2 = {"Lcom/bytedance/ai/resource/core/net/OpenPlatformNetApi;", "", "fetchAppletDownLoadInfoById", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformBaseResponse;", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformAppletList;", ContainerPosition.BODY, "Lcom/bytedance/ai/resource/core/bean/FetchAppletDownLoadInfoRequest;", "fetchAppletDownLoadInfo", "checkAppletUpdate", "fetchAppletPreDownLoadInfo", "Lcom/bytedance/ai/resource/core/bean/FetchAppletPreDownLoadInfoRequest;", "isInAppWhitelist", "Lcom/bytedance/ai/resource/core/bean/IsInAppWhitelistData;", "xToken", "", b.C, "", "Lcom/bytedance/ai/resource/core/bean/IsInAppWhitelistRequest;", "verifyDebugChannel", "Lcom/bytedance/ai/resource/core/net/AIRealDeviceDebugVerifyResponseData;", "contentType", "Lcom/bytedance/ai/resource/core/net/AIRealDeviceDebugVerifyRequestBody;", "decryptDek", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformDekDecryptResponseData;", b.f276376z, "Lcom/bytedance/ai/resource/core/bean/OpenPlatformDekDecryptRequest;", "getSignPublicKeys", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPublicKeyListData;", "getDebugSchema", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformDebugSchemaData;", "Lcom/bytedance/ai/resource/core/bean/QrCodeRequest;", "getPreviewAppInfoList", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfoList;", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppInfoRequest;", "getPreviewAppVersionList", "Lcom/bytedance/ai/resource/core/bean/OpenPlatformPreviewAppVersionList;", "deviceId", "mode", EffectConfiguration.KEY_CURSOR, VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface OpenPlatformNetApi {
    @POST("/developer/resource_api/package/check_update")
    Call<OpenPlatformBaseResponse<OpenPlatformAppletList>> checkAppletUpdate(@Body FetchAppletDownLoadInfoRequest r100);

    @POST("/developer/resource_api/apps/{app_key}/dek/decrypt")
    Call<OpenPlatformBaseResponse<OpenPlatformDekDecryptResponseData>> decryptDek(@Path("app_key") String r100, @Body OpenPlatformDekDecryptRequest r101);

    @POST("/developer/resource_api/package/download_info")
    Call<OpenPlatformBaseResponse<OpenPlatformAppletList>> fetchAppletDownLoadInfo(@Body FetchAppletDownLoadInfoRequest r100);

    @POST("/developer/resource_api/package/download_info_sub_package")
    Call<OpenPlatformBaseResponse<OpenPlatformAppletList>> fetchAppletDownLoadInfoById(@Body FetchAppletDownLoadInfoRequest r100);

    @POST("/developer/resource_api/package/pre_download_info")
    Call<OpenPlatformBaseResponse<OpenPlatformAppletList>> fetchAppletPreDownLoadInfo(@Body FetchAppletPreDownLoadInfoRequest r100);

    @POST("/developer/resource_api/package/qrcode_url")
    Call<OpenPlatformBaseResponse<OpenPlatformDebugSchemaData>> getDebugSchema(@Body QrCodeRequest r100);

    @POST("/app_developer/debugger/apps")
    Call<OpenPlatformBaseResponse<OpenPlatformPreviewAppInfoList>> getPreviewAppInfoList(@Header(LoginVerifyService.X_TT_TOKEN) String r100, @Header("sdk-version") int r101, @Header("Content-Type") String r102, @Body OpenPlatformPreviewAppInfoRequest r103);

    @GET("/app_developer/debugger/apps/{app_key}/versions")
    Call<OpenPlatformBaseResponse<OpenPlatformPreviewAppVersionList>> getPreviewAppVersionList(@Header(LoginVerifyService.X_TT_TOKEN) String r100, @Header("sdk-version") int r101, @Path("app_key") String r102, @Query("device_id") String r103, @Query("mode") String r104, @Query(EffectConfiguration.KEY_CURSOR) String r105, @Query(VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT) int r106);

    @GET("/developer/resource_api/apps/{app_key}/sign/public_key")
    Call<OpenPlatformBaseResponse<OpenPlatformPublicKeyListData>> getSignPublicKeys(@Path("app_key") String r100);

    @POST("/developer/resource_api/package/debug_download_info")
    Call<OpenPlatformBaseResponse<IsInAppWhitelistData>> isInAppWhitelist(@Header("x-tt-token") String r100, @Header("sdk-version") int r101, @Body IsInAppWhitelistRequest r102);

    @POST("/developer/check_api/debug/verify")
    Call<OpenPlatformBaseResponse<AIRealDeviceDebugVerifyResponseData>> verifyDebugChannel(@Header("x-tt-token") String r100, @Header("sdk-version") int r101, @Header("Content-Type") String r102, @Body AIRealDeviceDebugVerifyRequestBody r103);
}
