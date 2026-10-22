package com.android.ttcjpaysdk.verify.utils;

import android.content.Context;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.service.CJPayServiceManager;
import com.android.ttcjpaysdk.base.service.ICJPaySecurityLoadingService;
import com.android.ttcjpaysdk.base.ui.Utils.CJPayDyBrandLoadingUtils;
import com.android.ttcjpaysdk.bdpay.security.loading.data.CJPaySecurityLoadingConstant;
import com.bytedance.caijing.sdk.infra.base.logger.CJLogger;
import com.ss.android.dypay.api.DyPayConstant;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/verify/utils/DyVerifyLoadingHelper;", "", "()V", "TAG", "", "isSetTempLoadingInfo", "Ljava/util/concurrent/atomic/AtomicBoolean;", "loadingService", "Lcom/android/ttcjpaysdk/base/service/ICJPaySecurityLoadingService;", "buildTempLoadingInfo", "hideLoading", "", DyPayConstant.KEY_SHOW_LOADING, "ctx", "Landroid/content/Context;", "copyWriting", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DyVerifyLoadingHelper {
    private final String TAG;
    private final AtomicBoolean isSetTempLoadingInfo;
    private ICJPaySecurityLoadingService loadingService;

    private final String buildTempLoadingInfo() {
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r101, "loading_style", CJPaySecurityLoadingConstant.CJ_PAY_SECURITY_LOADING_BREATHE_STYLE);
        KtSafeMethodExtensionKt.safePut(r101, "version", "StandardV1");
        Unit r102 = Unit.INSTANCE;
        KtSafeMethodExtensionKt.safePut(r100, "loading_style_info", r101);
        return r100.toString();
    }

    public final void hideLoading() {
        if (this.isSetTempLoadingInfo.getAndSet(false) == false) goto L7;
        CJLogger.d(this.TAG, "invoke release for set temporary SecurityLoadingInfo for dyVerify");
        ICJPaySecurityLoadingService r100 = this.loadingService;
        if (r100 == null) goto L7;
        r100.release();
    L7:
        ICJPaySecurityLoadingService r101 = this.loadingService;
        if (r101 == null) goto L10;
        r101.hideDialogLoadingForInnerInvoke();
    L10:
        CJPayDyBrandLoadingUtils.INSTANCE.hideLoading();
    }

    public DyVerifyLoadingHelper() {
        this.TAG = "DyVerifyLoadingHelper";
        this.isSetTempLoadingInfo = new AtomicBoolean(false);
        this.loadingService = (ICJPaySecurityLoadingService) CJPayServiceManager.getInstance().getIService(ICJPaySecurityLoadingService.class);
    }

    public final void showLoading(Context r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "ctx");
        Intrinsics.checkNotNullParameter(r111, "copyWriting");
        ICJPaySecurityLoadingService r100 = this.loadingService;
        Boolean r101 = null;
        if (r100 == null) goto L5;
        String r102 = r100.getSecurityLoadingInfo();
    L6:
        boolean r112 = false;
        if (r102 != null) goto L27;
        ICJPaySecurityLoadingService r103 = this.loadingService;
        if (r103 == null) goto L11;
        Boolean r104 = Boolean.valueOf(r103.isDialogLoadingShowing());
    L12:
        if (r104 == null) goto L14;
        boolean r105 = r104.booleanValue();
    L15:
        if (r105 == true) goto L27;
        ICJPaySecurityLoadingService r106 = this.loadingService;
        if (r106 == null) goto L19;
        Boolean r107 = Boolean.valueOf(r106.isPanelLoadingShowing());
    L20:
        if (r107 == null) goto L22;
        boolean r108 = r107.booleanValue();
    L23:
        if (r108 == true) goto L27;
        CJLogger.d(this.TAG, "set temporary SecurityLoadingInfo for dyVerify");
        this.isSetTempLoadingInfo.set(true);
        ICJPaySecurityLoadingService r109 = this.loadingService;
        if (r109 == null) goto L27;
        r109.setSecurityLoadingInfo(buildTempLoadingInfo());
        goto L27
    L22:
        r108 = false;
        goto L23
    L19:
        r107 = null;
        goto L20
    L14:
        r105 = false;
        goto L15
    L11:
        r104 = null;
    L27:
        ICJPaySecurityLoadingService r113 = this.loadingService;
        if (r113 == null) goto L30;
        r101 = Boolean.valueOf(ICJPaySecurityLoadingService.DefaultImpls.showDialogLoadingForSpecialCopyWriting$default(r113, r110, r111, null, null, null, null, null, 124, null));
    L30:
        if (r101 == null) goto L32;
        r112 = r101.booleanValue();
    L32:
        if (r112 == true) goto L37;
        CJPayDyBrandLoadingUtils r114 = CJPayDyBrandLoadingUtils.INSTANCE;
        if (r114.showLoading(r110, r111) == true) goto L38;
        CJPayDyBrandLoadingUtils.showOldLoading$default(r114, r110, false, null, null, 14, null);
        return;
    L38:
        return;
    L37:
        return;
    L5:
        r102 = null;
        goto L6
    }
}
