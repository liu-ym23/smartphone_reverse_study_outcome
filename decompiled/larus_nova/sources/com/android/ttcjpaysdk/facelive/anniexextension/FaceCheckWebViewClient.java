package com.android.ttcjpaysdk.facelive.anniexextension;

import android.app.Activity;
import android.net.Uri;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.android.ttcjpaysdk.base.CJPayConstant;
import com.android.ttcjpaysdk.base.eventbus.EventManager;
import com.android.ttcjpaysdk.base.framework.event.CJPayConfirmAfterGetFaceDataEvent;
import com.android.ttcjpaysdk.base.ktextension.CJPayKotlinExtensionsKt;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.android.ttcjpaysdk.bdpay.counter.outer.bean.CJDyPayResult;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.ContainerContext;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0002J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/anniexextension/FaceCheckWebViewClient;", "Landroid/webkit/WebViewClient;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "containerContext", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;", "(Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;)V", "extendParams", "Lorg/json/JSONObject;", "CJTag", "", "handleFacePlusCallback", "", "isFacePlusCallback", "", "url", "isFromFaceVerifyFullPage", "isReturnUrlCallback", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "view", "Landroid/webkit/WebView;", "request", "Landroid/webkit/WebResourceRequest;", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FaceCheckWebViewClient extends WebViewClient implements ICJTag {
    private final ContainerContext containerContext;
    private final JSONObject extendParams;

    private final boolean isFromFaceVerifyFullPage() {
        String r100 = this.extendParams.optString("enterFrom");     // Catch: Exception -> L10
        if (Intrinsics.areEqual("enter_from_face_verify_native", r100) == false) goto L6;
    L9:
        return true;
    L6:
        if (Intrinsics.areEqual("enter_from_face_verify_h5", r100) == true) goto L9;
        if (Intrinsics.areEqual("enter_from_face_verify_bullet", r100) == true) goto L9;
        return false;
    L10:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("FaceCheckWebViewClient#isFromFaceVerifyFullPage", e);
        CJBasicCommonUtils.logCatch("CJCatch", "FaceCheckWebViewClient#isFromFaceVerifyFullPage", e);
        return false;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public String CJTag() {
        return "FaceCheckWebViewClient";
    }

    private final void handleFacePlusCallback() {
        CJPayConfirmAfterGetFaceDataEvent r110 = new CJPayConfirmAfterGetFaceDataEvent(null, null, null, null, 0, null, null, null, null, null, 1023, null);
        r110.source = CastIntegerProtector.parseInt(this.extendParams.optString("clientSource"));     // Catch: Exception -> L5
        r110.scene = this.extendParams.optString("scene");     // Catch: Exception -> L5
        r110.faceScene = this.extendParams.optString("faceScene");     // Catch: Exception -> L5
    L8:
        if (isFromFaceVerifyFullPage() == false) goto L10;
        r110.enterFrom = this.extendParams.optString("enterFrom");
        EventManager.INSTANCE.notifyLast(r110);
    L11:
        Activity r100 = this.containerContext.getActivity();
        if (r100 == null) goto L14;
        CJPayKotlinExtensionsKt.safeFinish(r100);
        Unit r101 = Unit.INSTANCE;
    L15:
        if (r101 != null) goto L20;
        ICJTag.DefaultImpls.e$default(this, "[handleFacePlusCallback] finish failed!", null, 2, null);
        return;
    L20:
        return;
    L14:
        r101 = null;
        goto L15
    L10:
        EventManager.INSTANCE.notify(r110);
    L5:
        e = move-exception;
        CJBasicCommonUtils.reportCatchException("FaceCheckWebViewClient#handleFacePlusCallback", e);
        CJBasicCommonUtils.logCatch("CJCatch", "FaceCheckWebViewClient#handleFacePlusCallback", e);
        e.printStackTrace();
        goto L8
    }

    public FaceCheckWebViewClient(ContainerContext r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        this.containerContext = r100;
        this.extendParams = KtSafeMethodExtensionKt.safeCreate(KtSafeMethodExtensionKt.ifNullOrBlank(r100.a("extend_params"), FaceCheckWebViewClient$extendParams$1.INSTANCE));
    }

    private final boolean isFacePlusCallback(String r100) {
        if ((!StringsKt.isBlank(r100)) == true) goto L5;
    L7:
        return false;
    L5:
        if (StringsKt.startsWith$default(r100, CJPayConstant.FACE_LITE_RETURN_URL, false, 2, null) == false) goto L7;
        return true;
    }

    private final boolean isReturnUrlCallback(String r100) {
        if ((!StringsKt.isBlank(r100)) == false) goto L11;
        String r101 = this.extendParams.optString(CJDyPayResult.EXT_K_RETURN_URL);
        if ((!StringsKt.isBlank(r101)) == true) goto L7;
    L9:
        return false;
    L7:
        if (StringsKt.startsWith$default(r100, r101, false, 2, null) == false) goto L9;
        return true;
    L11:
        return false;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void w(String r100) {
        ICJTag.DefaultImpls.w(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void e(String r100, Throwable r101) {
        ICJTag.DefaultImpls.e(this, r100, r101);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView r100, WebResourceRequest r101) {
        if (r101 == null) goto L7;
        Uri r102 = r101.getUrl();
        if (r102 == null) goto L7;
        String r103 = r102.toString();
        if (r103 == null) goto L7;
    L8:
        i("shouldInterceptRequest url: " + r103 + ", extendParams: " + this.extendParams);
        if (StringsKt.contains$default(r103, DownloadConstants.VULNERABILITY_PATH, false, 2, null) == false) goto L13;
        ICJTag.DefaultImpls.e$default(this, "[shouldInterceptRequest] url contains '..'", null, 2, null);
        return shouldInterceptRequest(r100, r103);
    L13:
        if (isReturnUrlCallback(r103) == false) goto L19;
        if (isFacePlusCallback(r103) == false) goto L19;
        handleFacePlusCallback();
        return super.shouldInterceptRequest(r100, r101);
    L19:
        return super.shouldInterceptRequest(r100, r101);
    L7:
        r103 = "";
        goto L8
    }
}
