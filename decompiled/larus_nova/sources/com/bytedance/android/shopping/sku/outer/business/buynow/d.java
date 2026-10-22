package com.bytedance.android.shopping.sku.outer.business.buynow;

import com.bytedance.android.ec.core.monitor.o;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.core.vmsdk.VmSdkSetting;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class d<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SkuOuterBuyNowOpenHelper f183055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f183056b;

    public d(SkuOuterBuyNowOpenHelper r100, String r101) {
        this.f183055a = r100;
        this.f183056b = r101;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        JSONObject r100 = z1.g(UriProtector.getQueryParameter(UriProtector.parse(this.f183056b), com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO));
        if (r100 == null) goto L5;
        String r101 = r100.optString(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE);
    L7:
        if (Intrinsics.areEqual(r101, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_FLOW_PAGE) == false) goto L12;
        int r102 = ECSdk.f48106a;
        o r103 = (o) ECSdk.a(o.class);
        if (r103 == null) goto L13;
        r103.a(this.f183055a.f183040b, "inflow_feed_place_order", this.f183056b, null, VmSdkSetting.a().i());
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r101 = null;
        goto L7
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
