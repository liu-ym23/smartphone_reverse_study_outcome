package com.bytedance.android.shopping.abscontainer.common_biz.custom_event;

import com.bytedance.android.shopping.abscontainer.common_biz.helper.RefreshHelper;
import com.bytedance.android.shopping.sku.common.controller.SkuCommonBigPicCacheController;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import t43.c;
import u33.a;
import v43.a;

/* JADX INFO: loaded from: classes12.dex */
public final class f0<STATE extends v43.a, PROPS extends u33.a & t43.c> extends m33.a<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f164244b;

    @Override // m33.a
    public final String d() {
        return this.f164244b;
    }

    public f0(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f164244b = "selfSaveSpecShowMode";
    }

    @Override // m33.a
    public final void e(e43.a r100) {
        Intrinsics.checkNotNullParameter(r100, "eventData");
        Object r101 = null;
        if (com.bytedance.android.shopping.abscontainer.common_biz.helper.a.a(this.f511708a.f507250d.c(), r100) == false) goto L28;
        Map<String, Object> r102 = r100.e();
        if (r102 == null) goto L7;
        Object r103 = r102.get("specs_state");
    L9:
        if ((r103 instanceof Map) == true) goto L11;
        r103 = null;
    L11:
        Map r104 = (Map) r103;
        if (r104 == null) goto L14;
        Object r105 = r104.get("0");
    L16:
        if ((r105 instanceof Map) == true) goto L18;
        r105 = null;
    L18:
        Map r106 = (Map) r105;
        if (r106 == null) goto L21;
        Object r107 = r106.get("cur_show_mode");
    L23:
        if ((r107 instanceof String) == false) goto L26;
        r101 = r107;
    L26:
        String r108 = ((t43.c) this.f511708a.f507249c).getProductID();
        SkuCommonBigPicCacheController.a r109 = SkuCommonBigPicCacheController.f182622a;
        SkuCommonBigPicCacheController.b(r108, Intrinsics.areEqual((String) r101, "big_pic"));
        int r110 = RefreshHelper.f164294a;
        RefreshHelper.a(this.f511708a.f507250d.g(), (v43.a) this.f511708a.f507247a);
        return;
    L21:
        r107 = null;
        goto L23
    L14:
        r105 = null;
        goto L16
    L7:
        r103 = null;
        goto L9
    L28:
        Map<String, Object> r111 = r100.e();
        if (r111 == null) goto L31;
        Object r112 = r111.get("specs_state");
    L33:
        if ((r112 instanceof Map) == true) goto L35;
        r112 = null;
    L35:
        Map r113 = (Map) r112;
        if (r113 == null) goto L38;
        Object r114 = r113.get("0");
    L40:
        if ((r114 instanceof Map) == true) goto L42;
        r114 = null;
    L42:
        Map r115 = (Map) r114;
        if (r115 == null) goto L45;
        Object r116 = r115.get("cur_show_mode");
    L47:
        if ((r116 instanceof String) == false) goto L50;
        r101 = r116;
    L50:
        String r117 = ((t43.c) this.f511708a.f507249c).getProductID();
        SkuCommonBigPicCacheController.a r118 = SkuCommonBigPicCacheController.f182622a;
        SkuCommonBigPicCacheController.b(r117, Intrinsics.areEqual((String) r101, "big_pic"));
        r100.d(new m33.c(true, null, false, null, 30));
        return;
    L45:
        r116 = null;
        goto L47
    L38:
        r114 = null;
        goto L40
    L31:
        r112 = null;
        goto L33
    }
}
