package com.bytedance.android.shopping.sku.outer.business.buynow;

import android.content.Context;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.data.api.ChainPoint;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class SkuOuterBuyNowOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f183039a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f183040b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f183041c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PageFinder f183042d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final mh3.a f183043e;

    public final void a() {
        String r100 = this.f183041c.f183051b.getEntranceInfo();
        final com.bytedance.android.shopping.buynow.monitor.firstscreen.a r101 = null;
        if (r100 == null) goto L5;
        final JSONObject r102 = z1.g(r100);
    L6:
        int r103 = ECSdk.f48106a;
        IEShoppingService r104 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r104 == null) goto L9;
        sc3.c r105 = r104.getBuyNowService();
    L10:
        if (r105 == null) goto L12;
        r101 = r105.n(new com.bytedance.android.ec.model.d(this.f183040b, "SkuOuterBuyNowOpenHelper", System.currentTimeMillis()));
    L12:
        if (r101 == null) goto L14;
        r101.c(ChainPoint.PAGE_INIT, Long.valueOf(System.currentTimeMillis()));
    L14:
        if (r101 == null) goto L16;
        r101.c(ChainPoint.PAGE_START, Long.valueOf(System.currentTimeMillis()));
    L16:
        com.bytedance.android.shopping.sku.common.utils.d.b(CollectionsKt.listOf(new com.bytedance.android.shopping.sku.common.utils.a[]{com.bytedance.android.shopping.sku.common.utils.d.a("监控", new SkuOuterBuyNowOpenHelper$start$1(this, r102)), com.bytedance.android.shopping.sku.common.utils.d.a("提单以后的周期内把小窗关掉", SkuOuterBuyNowOpenHelper$start$2.INSTANCE), com.bytedance.android.shopping.sku.common.utils.d.a("提单", new SkuOuterBuyNowOpenHelper$start$3(this, r101)), com.bytedance.android.shopping.sku.common.utils.d.a("ecom.sku.buynow", new SkuOuterBuyNowOpenHelper$start$4(this)), com.bytedance.android.shopping.sku.common.utils.d.a("通知营销层用户下单行为", SkuOuterBuyNowOpenHelper$start$5.INSTANCE), com.bytedance.android.shopping.sku.common.utils.d.a("logAdEvent host service", new SkuOuterBuyNowOpenHelper$start$6(this, r102))}));
        return;
    L9:
        r105 = null;
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    public SkuOuterBuyNowOpenHelper(Context r100, c r101, PageFinder r102, mh3.a r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "buyNowData");
        Intrinsics.checkNotNullParameter(r102, "btmPageFinder");
        this.f183040b = r100;
        this.f183041c = r101;
        this.f183042d = r102;
        this.f183043e = r103;
        this.f183039a = "";
    }
}
