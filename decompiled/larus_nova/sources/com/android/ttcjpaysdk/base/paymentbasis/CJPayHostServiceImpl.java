package com.android.ttcjpaysdk.base.paymentbasis;

import android.app.Activity;
import com.android.ttcjpaysdk.base.service.ICJPayHostService;
import com.bytedance.caijing.sdk.infra.base.api.env.CJHostService;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u000e0\r0\fH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0010H\u0017J\u001a\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0010H\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001b"}, d2 = {"Lcom/android/ttcjpaysdk/base/paymentbasis/CJPayHostServiceImpl;", "Lcom/android/ttcjpaysdk/base/service/ICJPayHostService;", "()V", "hostServiceImpl", "Lcom/bytedance/caijing/sdk/infra/base/api/env/CJHostService;", "getHostServiceImpl", "()Lcom/bytedance/caijing/sdk/infra/base/api/env/CJHostService;", "hostServiceImpl$delegate", "Lkotlin/Lazy;", "getPackageName", "", "getXBridgeMethods", "", "Ljava/lang/Class;", "", "isLivePluginAvailable", "", "networkParamsLoadToUrl", "baseUrl", "isApi", "openSchemaRouter", "schema", "activity", "Landroid/app/Activity;", "setWXIndependentSign", "", "isSign", "base-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJPayHostServiceImpl implements ICJPayHostService {
    private final Lazy hostServiceImpl$delegate;

    @Override // com.android.ttcjpaysdk.base.service.ICJPayService
    public String getPackageName() {
        return "com.ss.android.ugc.aweme.cjpay";
    }

    private final CJHostService getHostServiceImpl() {
        return (CJHostService) this.hostServiceImpl$delegate.getValue();
    }

    public CJPayHostServiceImpl() {
        this.hostServiceImpl$delegate = LazyKt.lazy(CJPayHostServiceImpl$hostServiceImpl$2.INSTANCE);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayHostService
    public Map<String, Class<? extends Object>> getXBridgeMethods() {
        return MapsKt.emptyMap();
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayHostService
    public boolean isLivePluginAvailable() {
        return getHostServiceImpl().isLivePluginAvailable();
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayHostService
    public void setWXIndependentSign(boolean r100) {
        getHostServiceImpl().setWXIndependentSign(r100);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayHostService
    @Deprecated(message = "")
    public String networkParamsLoadToUrl(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        return getHostServiceImpl().networkParamsLoadToUrl(r100, r101);
    }

    @Override // com.android.ttcjpaysdk.base.service.ICJPayHostService
    public boolean openSchemaRouter(String r100, Activity r101) {
        Intrinsics.checkNotNullParameter(r100, "schema");
        return getHostServiceImpl().openSchemaRouter(r100, r101);
    }
}
