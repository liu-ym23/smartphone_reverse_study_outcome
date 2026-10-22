package com.bytedance.android.shopping.anchorv4.log;

import com.bytedance.android.ec.model.ECAdLogParams;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.bmhome.share.panel.ShareChannel;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class AdLogUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s83.g f167035a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f167036b = null;

    public static xi.a a() {
        return (xi.a) f167036b.getValue();
    }

    static {
        int r100 = ECSdk.f48106a;
        f167035a = (s83.g) ECSdk.a(s83.g.class);
        f167036b = LazyKt.lazy(AdLogUtils$adLogServiceSaas$2.INSTANCE);
    }

    public static void g(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "cid");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L11;
    L16:
        a().d("click_expansion", null, Long.valueOf(CastLongProtector.parseLong(r110)), r111);
        return;
    L11:
        if (r101.n() == true) goto L16;
        s83.g r102 = f167035a;
        if (r102 == null) goto L18;
        r102.d("landing_ad", "click_expansion", null, r110, r111, null, null, "umeng");
        return;
    L18:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void o(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "cid");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L11;
    L16:
        a().d("label_receive", null, Long.valueOf(CastLongProtector.parseLong(r110)), r111);
        return;
    L11:
        if (r101.n() == true) goto L16;
        s83.g r102 = f167035a;
        if (r102 == null) goto L18;
        r102.d("product_detail_ad", "label_receive", null, r110, r111, null, null, "umeng");
        return;
    L18:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void b(String r110, Map r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "cid");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L11;
    L16:
        a().d("add_to_cart", null, Long.valueOf(CastLongProtector.parseLong(r110)), r112);
        return;
    L11:
        if (r101.n() == true) goto L16;
        s83.g r102 = f167035a;
        if (r102 == null) goto L18;
        r102.d("product_detail_ad", "add_to_cart", "button", r110, r112, r111, null, "umeng");
        return;
    L18:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void c(String r110, String r111, Map r112) {
        Intrinsics.checkNotNullParameter(r110, "cid");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L11;
    L16:
        a().d("click_return", null, Long.valueOf(CastLongProtector.parseLong(r110)), r111);
        return;
    L11:
        if (r101.n() == true) goto L16;
        s83.g r102 = f167035a;
        if (r102 == null) goto L18;
        r102.d("product_detail_ad", "click_return", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, r110, r111, r112, null, "umeng");
        return;
    L18:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void d(String r110, Map r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "cid");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L11;
    L16:
        a().d("otherclick", null, Long.valueOf(CastLongProtector.parseLong(r110)), r112);
        return;
    L11:
        if (r101.n() == true) goto L16;
        s83.g r102 = f167035a;
        if (r102 == null) goto L18;
        r102.d("product_detail_ad", "otherclick", "shop", r110, r112, r111, null, "umeng");
        return;
    L18:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void e(String r110, Map r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "cid");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L11;
    L16:
        a().d("click_buy_right_now", null, Long.valueOf(CastLongProtector.parseLong(r110)), r112);
        return;
    L11:
        if (r101.n() == true) goto L16;
        s83.g r102 = f167035a;
        if (r102 == null) goto L18;
        r102.d("product_detail_ad", "click_buy_right_now", "button", r110, r112, r111, null, "umeng");
        return;
    L18:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void f(String r110, Map r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "cid");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L11;
    L16:
        a().d("click_cart", null, Long.valueOf(CastLongProtector.parseLong(r110)), r112);
        return;
    L11:
        if (r101.n() == true) goto L16;
        s83.g r102 = f167035a;
        if (r102 == null) goto L18;
        r102.d("product_detail_ad", "click_cart", "button", r110, r112, r111, null, "umeng");
        return;
    L18:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void h(String r110, Map r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "cid");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L11;
    L16:
        a().d("otherclick", null, Long.valueOf(CastLongProtector.parseLong(r110)), r112);
        return;
    L11:
        if (r101.n() == true) goto L16;
        s83.g r102 = f167035a;
        if (r102 == null) goto L18;
        r102.d("product_detail_ad", "otherclick", "button", r110, r112, r111, null, "umeng");
        return;
    L18:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void i(String r110, Map r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "cid");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L11;
    L16:
        a().d("otherclick", null, Long.valueOf(CastLongProtector.parseLong(r110)), r112);
        return;
    L11:
        if (r101.n() == true) goto L16;
        s83.g r102 = f167035a;
        if (r102 == null) goto L18;
        r102.d("product_detail_ad", "otherclick", "main_image", r110, r112, r111, null, "umeng");
        return;
    L18:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void j(String r110, Map r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "cid");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L11;
    L16:
        a().d("landing_page_product_click", null, Long.valueOf(CastLongProtector.parseLong(r110)), r112);
        return;
    L11:
        if (r101.n() == true) goto L16;
        s83.g r102 = f167035a;
        if (r102 == null) goto L18;
        r102.d("product_detail_ad", "landing_page_product_click", "product", r110, r112, r111, null, "umeng");
        return;
    L18:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void k(String r110, Map r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "cid");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L11;
    L16:
        a().d("otherclick", null, Long.valueOf(CastLongProtector.parseLong(r110)), r112);
        return;
    L11:
        if (r101.n() == true) goto L16;
        s83.g r102 = f167035a;
        if (r102 == null) goto L18;
        r102.d("product_detail_ad", "otherclick", SearchResultParam.ENTER_PAGE_GENERAL_SEARCH, r110, r112, r111, null, "umeng");
        return;
    L18:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void l(String r110, Map r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "cid");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L11;
    L16:
        a().d(ShareChannel.COLLECT, null, Long.valueOf(CastLongProtector.parseLong(r110)), r112);
        return;
    L11:
        if (r101.n() == true) goto L16;
        s83.g r102 = f167035a;
        if (r102 == null) goto L18;
        r102.d("product_detail_ad", ShareChannel.COLLECT, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, r110, r112, r111, null, "umeng");
        return;
    L18:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void m(String r110, Map r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "cid");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L11;
    L16:
        a().d("collect_cancel", null, Long.valueOf(CastLongProtector.parseLong(r110)), r112);
        return;
    L11:
        if (r101.n() == true) goto L16;
        s83.g r102 = f167035a;
        if (r102 == null) goto L18;
        r102.d("product_detail_ad", "collect_cancel", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, r110, r112, r111, null, "umeng");
        return;
    L18:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void q(String r110, String r111, Map r112) {
        Intrinsics.checkNotNullParameter(r110, "cid");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L11;
    L16:
        a().d("load_fail", null, Long.valueOf(CastLongProtector.parseLong(r110)), r111);
        return;
    L11:
        if (r101.n() == true) goto L16;
        s83.g r102 = f167035a;
        if (r102 == null) goto L18;
        r102.d("product_detail_ad", "load_fail", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, r110, r111, r112, null, "umeng");
        return;
    L18:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void r(String r110, Map r111, String r112) {
        Intrinsics.checkNotNullParameter(r110, "cid");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L11;
    L16:
        a().d("share", null, Long.valueOf(CastLongProtector.parseLong(r110)), r112);
        return;
    L11:
        if (r101.n() == true) goto L16;
        s83.g r102 = f167035a;
        if (r102 == null) goto L18;
        r102.d("product_detail_ad", "share", "share_sign", r110, r112, r111, null, "umeng");
        return;
    L18:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void n(String r100, String r110, ECAdLogParams r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        boolean r101 = false;
        if (r111 == null) goto L13;
        String r113 = r111.getEnableCommonAdTrack();
        if (r113 != null) goto L7;
    L10:
        boolean r114 = true;
    L11:
        if (r114 == true) goto L13;
    L17:
        ECAppInfoService r115 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L20;
    L28:
        a().d("detail_show", null, Long.valueOf(CastLongProtector.parseLong(r100)), r110);
        return;
    L20:
        if (r115.n() == true) goto L28;
        s83.g r102 = f167035a;
        if (r102 == null) goto L30;
        if (r112 == false) goto L26;
        String r116 = "product_detail_ad";
    L27:
        r102.d(r116, "detail_show", null, r100, r110, null, null, "umeng");
        return;
    L26:
        r116 = "landing_ad";
        goto L27
    L30:
        return;
    L7:
        if (r113.length() == 0) goto L10;
        r114 = false;
    L13:
        if (r100.length() != 0) goto L15;
        r101 = true;
    L15:
        if (r101 == false) goto L17;
    }

    public static void p(String r110, String r111, boolean r112, Map r113) {
        Intrinsics.checkNotNullParameter(r110, "cid");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L11;
    L19:
        a().d("load_finish", null, Long.valueOf(CastLongProtector.parseLong(r110)), r111);
        return;
    L11:
        if (r101.n() == true) goto L19;
        s83.g r102 = f167035a;
        if (r102 == null) goto L21;
        if (r112 == false) goto L17;
        String r114 = "product_detail_ad";
    L18:
        r102.d(r114, "load_finish", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, r110, r111, r113, null, "umeng");
        return;
    L17:
        r114 = "landing_ad";
        goto L18
    L21:
        return;
    L5:
        r100 = false;
        goto L6
    }

    public static void s(String r110, Map r111, String r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "cid");
        Intrinsics.checkNotNullParameter(r113, "tagName");
        if (r110.length() != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L8;
        return;
    L8:
        ECAppInfoService r101 = ECAppInfoService.f48114e;
        if (we.a.f559330a == false) goto L11;
    L16:
        a().d("stay_page", null, Long.valueOf(CastLongProtector.parseLong(r110)), r112);
        return;
    L11:
        if (r101.n() == true) goto L16;
        s83.g r102 = f167035a;
        if (r102 == null) goto L18;
        r102.d(r113, "stay_page", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL, r110, r112, r111, null, "umeng");
        return;
    L18:
        return;
    L5:
        r100 = false;
        goto L6
    }
}
