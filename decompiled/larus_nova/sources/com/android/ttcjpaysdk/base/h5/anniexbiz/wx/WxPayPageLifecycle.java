package com.android.ttcjpaysdk.base.h5.anniexbiz.wx;

import com.android.ttcjpaysdk.base.CJPayCallBackCenter;
import com.android.ttcjpaysdk.base.CJPayHostInfo;
import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.android.ttcjpaysdk.base.utils.CJPayParamsUtils;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.ContainerContext;
import fe4.a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/anniexbiz/wx/WxPayPageLifecycle;", "Lfe4/a;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "", "CJTag", "", "onPageCreate", "onPageResume", "onBackPressClick", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;", "containerContext", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isFirstShow", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "(Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;)V", "base-context_release"}, k = 1, mv = {1, 6, 0})
public final class WxPayPageLifecycle implements a, ICJTag {
    private final ContainerContext containerContext;
    private final AtomicBoolean isFirstShow;

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public String CJTag() {
        return "WxPayPageLifecycle";
    }

    @Override // fe4.a
    public boolean isInterceptorBackPress() {
        return false;
    }

    @Override // fe4.a
    public void onInterceptorBackPress() {
    }

    @Override // fe4.a
    public void onPageDestroy() {
    }

    @Override // fe4.a
    public void onPageCreate() {
        CJPayHostInfo r100 = CJPayHostInfo.Companion.toBean(KtSafeMethodExtensionKt.safeCreate(KtSafeMethodExtensionKt.ifNullOrBlank(this.containerContext.a("cjpay_host_info"), WxPayPageLifecycle$onPageCreate$hostInfo$1.INSTANCE)));
        String r101 = r100.merchantId;
        String r102 = "";
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        String r103 = r100.appId;
        if (r103 == null) goto L9;
        r102 = r103;
    L9:
        JSONObject r104 = CJPayParamsUtils.getCommonLogParams(r101, r102);
        CJPayCallBackCenter.getInstance().onEvent("wallet_rd_wx_h5pay_webview_start", new JSONObject[]{r104});
    }

    @Override // fe4.a
    public void onPageResume() {
        if (this.isFirstShow.getAndSet(false) == false) goto L5;
        return;
    L5:
        if (this.containerContext.getActivity() != null) goto L7;
        ICJTag.DefaultImpls.e$default(this, "[shouldOverrideUrlLoading] activity is null", null, 2, null);
    L7:
        CJPayCallBackCenter.getInstance().setResultCode(0);
        com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.a r100 = this.containerContext.f202238g;
        if (r100 == null) goto L12;
        r100.close();
        return;
    }

    @Override // fe4.a
    public void onBackPressClick() {
        CJPayCallBackCenter.getInstance().setResultCode(0);
    }

    public WxPayPageLifecycle(ContainerContext r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        this.containerContext = r100;
        this.isFirstShow = new AtomicBoolean(true);
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
}
