package com.android.ttcjpaysdk.base.h5.anniexbiz.wx;

import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.IWxPayBizExtension;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.ContainerContext;
import fe4.a;
import fe4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/anniexbiz/wx/WxPayBizExtensionImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/IWxPayBizExtension;", "", "getBizName", "Lcom/bytedance/caijing/sdk/infra/base/api/plugin/container/biz/base/ContainerContext;", "containerContext", "Lfe4/b;", "getWebGlobalConfigService", "Lfe4/a;", "getLifecycle", "<init>", "()V", "base-context_release"}, k = 1, mv = {1, 6, 0})
public final class WxPayBizExtensionImpl implements IWxPayBizExtension {
    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.IBizExtension
    public String getBizName() {
        return "weixin";
    }

    public WxPayBizExtensionImpl() {
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.IBizExtension
    public a getLifecycle(ContainerContext r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        return new WxPayPageLifecycle(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.IBizExtension
    public b getWebGlobalConfigService(ContainerContext r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        return new AnonymousClass1();
    }
}
