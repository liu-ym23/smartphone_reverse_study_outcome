package com.android.ttcjpaysdk.base.h5.anniexbiz.wx;

import com.android.ttcjpaysdk.base.ktextension.ICJTag;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.ContainerContext;
import fe4.c;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J(\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007H\u0016R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/anniexbiz/wx/WxWebViewLoadUrlInterceptor;", "Lfe4/c;", "Lcom/android/ttcjpaysdk/base/ktextension/ICJTag;", "", "CJTag", "url", "overrideLoadUrl", "", "headers", "overrideHeaders", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;", "containerContext", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;", "getContainerContext", "()Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;", "<init>", "(Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;)V", "base-context_release"}, k = 1, mv = {1, 6, 0})
public final class WxWebViewLoadUrlInterceptor implements c, ICJTag {
    private final ContainerContext containerContext;

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public String CJTag() {
        return "WxWebViewLoadUrlInterceptor";
    }

    @Override // fe4.c
    public String overrideLoadUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return r100;
    }

    public final ContainerContext getContainerContext() {
        return this.containerContext;
    }

    public WxWebViewLoadUrlInterceptor(ContainerContext r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        this.containerContext = r100;
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void d(String r100) {
        ICJTag.DefaultImpls.d(this, r100);
    }

    @Override // com.android.ttcjpaysdk.base.ktextension.ICJTag
    public void i(String r100) {
        ICJTag.DefaultImpls.i(this, r100);
    }

    @Override // fe4.c
    public Map<String, String> overrideHeaders(Map<String, String> r100) {
        Intrinsics.checkNotNullParameter(r100, "headers");
        String r101 = this.containerContext.a("wx_pay_referer");
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        if (StringsKt.isBlank(r101) == false) goto L8;
        ICJTag.DefaultImpls.e$default(this, "[overrideHeaders] wx_pay_referer is blank", null, 2, null);
    L8:
        i("[overrideHeaders] referer=".concat(r101));
        r100.put(AppConstants.HTTP_H_REFERER, r101);
        return r100;
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
