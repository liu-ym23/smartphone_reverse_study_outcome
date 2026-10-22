package com.bytedance.android.shopping.router;

import android.content.Context;
import android.net.Uri;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.android.shopping.searchsimilar.utils.SimilarProductHelper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.selector.strategy.GearStrategy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class j implements bf.c {
    public j() {
    }

    @Override // bf.c
    public final void a() {
    }

    @Override // bf.c
    public final String b() {
        return "ec_similar_product";
    }

    @Override // bf.c
    public final boolean c(Context r110, Uri r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "uri");
        new SimilarProductHelper().a(r110, r111, r112);
        String r113 = UriProtector.getQueryParameter(r111, SimilarProductParam.AWEME_ID);
        String r100 = "";
        if (r113 != null) goto L5;
        r113 = "";
    L5:
        String r101 = UriProtector.getQueryParameter(r111, "author_id");
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        String r114 = UriProtector.getQueryParameter(r111, "enter_from");
        if (r114 == null) goto L13;
        r100 = r114;
    L13:
        if (r113.length() != 0) goto L15;
        boolean r115 = true;
    L17:
        if (r115 == false) goto L20;
        int r116 = com.bytedance.android.ec.core.monitor.d.f45144a;
        com.bytedance.android.ec.core.monitor.d.b(SimilarProductParam.AWEME_ID, MapsKt.hashMapOf(new Pair[]{TuplesKt.to("scene", "ec_similar_product_page"), TuplesKt.to(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, "aweme_id字段为空")}));
    L20:
        if (r101.length() != 0) goto L22;
        boolean r117 = true;
    L23:
        if (r117 == false) goto L26;
        int r118 = com.bytedance.android.ec.core.monitor.d.f45144a;
        com.bytedance.android.ec.core.monitor.d.b("author_id", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("scene", "ec_similar_product_page"), TuplesKt.to(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, "author_id字段为空")}));
    L26:
        if (r100.length() != 0) goto L28;
        boolean r119 = true;
    L29:
        if (r119 == false) goto L31;
        int r120 = com.bytedance.android.ec.core.monitor.d.f45144a;
        com.bytedance.android.ec.core.monitor.d.b("enter_from", MapsKt.hashMapOf(new Pair[]{TuplesKt.to("scene", "ec_similar_product_page"), TuplesKt.to(GearStrategy.GEAR_STRATEGY_KEY_ERROR_DESC, "enter_from字段为空")}));
    L31:
        return true;
    L28:
        r119 = false;
        goto L29
    L22:
        r117 = false;
        goto L23
    L15:
        r115 = false;
        goto L17
    }
}
