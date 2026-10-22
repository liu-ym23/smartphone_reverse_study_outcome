package com.bytedance.android.shopping.deepfeed.utlis;

import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.shopping.deepfeed.data.api.Coupon;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackData;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductPackDataElements;
import com.bytedance.android.shopping.infeed.data.idl.InFeedProductV2;
import com.bytedance.android.shopping.infeed.data.idl.InFeedUrlModel;
import he3.a0;
import he3.b0;
import he3.e1;
import he3.e2;
import he3.h2;
import he3.k0;
import he3.k1;
import he3.m0;
import he3.n0;
import he3.p0;
import he3.p1;
import he3.r1;
import he3.y;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class a {
    public static final e1 a(InFeedProductV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$baseInfo");
        InFeedProductPackDataElements r101 = d(r100);
        if (r101 == null) goto L10;
        List<p0> r102 = r101.getProducts();
        if (r102 == null) goto L10;
        p0 r103 = (p0) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L10;
        e1 r104 = r103.b();
        if (r104 == null) goto L10;
        return r104;
    L10:
        if (r101 == null) goto L16;
        n0 r105 = r101.getSliceCard();
        if (r105 == null) goto L16;
        k0 r106 = r105.e();
        if (r106 == null) goto L16;
        return r106.b();
    L16:
        return null;
    }

    public static final InFeedProductPackDataElements d(InFeedProductV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$elements");
        InFeedProductPackData r101 = r100.getPackData();
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getElements();
    }

    public static final String e(InFeedProductPackDataElements r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$eventProductId");
        List<p0> r101 = r100.getProducts();
        if (r101 == null) goto L10;
        p0 r102 = (p0) CollectionsKt.firstOrNull(r101);
        if (r102 == null) goto L10;
        e1 r103 = r102.b();
        if (r103 == null) goto L10;
        String r104 = r103.a();
        if (r104 == null) goto L10;
        return r104;
    L10:
        n0 r105 = r100.getSliceCard();
        if (r105 == null) goto L17;
        k0 r106 = r105.e();
        if (r106 == null) goto L17;
        e1 r107 = r106.b();
        if (r107 == null) goto L17;
        return r107.a();
    L17:
        return null;
    }

    public static final List<e2> f(InFeedProductPackDataElements r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$eventProductVideo");
        List<p0> r101 = r100.getProducts();
        if (r101 == null) goto L10;
        p0 r102 = (p0) CollectionsKt.firstOrNull(r101);
        if (r102 == null) goto L10;
        k1 r103 = r102.g();
        if (r103 == null) goto L10;
        List<e2> r104 = r103.c();
        if (r104 == null) goto L10;
        return r104;
    L10:
        n0 r105 = r100.getSliceCard();
        if (r105 == null) goto L17;
        y r106 = r105.f484835c;
        if (r106 == null) goto L17;
        a0 r107 = r106.a();
        if (r107 == null) goto L17;
        return r107.c();
    L17:
        return null;
    }

    public static final boolean g(Coupon r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isValid");
        Integer r101 = r100.getStatus();
        if (r101 != null) goto L6;
    L12:
        return false;
    L6:
        if (r101.intValue() != 1) goto L12;
        if (r100.getCountDown() == null) goto L12;
        if (r100.getCountDown().longValue() <= 0) goto L12;
        return true;
    }

    public static final List<InFeedUrlModel> h(InFeedProductV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$mainImage");
        InFeedProductPackDataElements r101 = d(r100);
        if (r101 == null) goto L12;
        List<p0> r102 = r101.getProducts();
        if (r102 == null) goto L12;
        p0 r103 = (p0) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L12;
        k1 r104 = r103.g();
        if (r104 == null) goto L12;
        List<InFeedUrlModel> r105 = r104.b();
        if (r105 == null) goto L12;
        return r105;
    L12:
        if (r101 == null) goto L20;
        n0 r106 = r101.getSliceCard();
        if (r106 == null) goto L20;
        y r107 = r106.f484835c;
        if (r107 == null) goto L20;
        a0 r108 = r107.a();
        if (r108 == null) goto L20;
        return r108.a();
    L20:
        return null;
    }

    public static final p1 i(InFeedProductV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$priceInfo");
        InFeedProductPackDataElements r101 = d(r100);
        if (r101 == null) goto L10;
        List<p0> r102 = r101.getProducts();
        if (r102 == null) goto L10;
        p0 r103 = (p0) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L10;
        p1 r104 = r103.k();
        if (r104 == null) goto L10;
        return r104;
    L10:
        if (r101 == null) goto L16;
        n0 r105 = r101.getSliceCard();
        if (r105 == null) goto L16;
        y r106 = r105.f484835c;
        if (r106 == null) goto L16;
        return r106.c();
    L16:
        return null;
    }

    public static final h2 j(InFeedProductV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$promotionInfo");
        InFeedProductPackDataElements r101 = d(r100);
        if (r101 == null) goto L10;
        List<p0> r102 = r101.getProducts();
        if (r102 == null) goto L10;
        p0 r103 = (p0) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L10;
        h2 r104 = r103.l();
        if (r104 == null) goto L10;
        return r104;
    L10:
        if (r101 == null) goto L16;
        n0 r105 = r101.getSliceCard();
        if (r105 == null) goto L16;
        k0 r106 = r105.e();
        if (r106 == null) goto L16;
        return r106.f();
    L16:
        return null;
    }

    public static final r1 k(InFeedProductV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$recReason");
        InFeedProductPackDataElements r101 = d(r100);
        if (r101 == null) goto L10;
        List<p0> r102 = r101.getProducts();
        if (r102 == null) goto L10;
        p0 r103 = (p0) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L10;
        r1 r104 = r103.m();
        if (r104 == null) goto L10;
        return r104;
    L10:
        if (r101 == null) goto L16;
        n0 r105 = r101.getSliceCard();
        if (r105 == null) goto L16;
        y r106 = r105.f484835c;
        if (r106 == null) goto L16;
        return r106.d();
    L16:
        return null;
    }

    public static final Map<String, Object> l(InFeedProductPackDataElements r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$trackInfo");
        List<p0> r101 = r100.getProducts();
        if (r101 == null) goto L8;
        p0 r102 = (p0) CollectionsKt.firstOrNull(r101);
        if (r102 == null) goto L8;
        Map<String, Object> r103 = r102.s();
        if (r103 == null) goto L8;
        return r103;
    L8:
        n0 r104 = r100.getSliceCard();
        if (r104 == null) goto L13;
        k0 r105 = r104.e();
        if (r105 == null) goto L13;
        return r105.h();
    L13:
        return null;
    }

    public static final List<e2> m(InFeedProductV2 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$video");
        InFeedProductPackDataElements r101 = d(r100);
        if (r101 == null) goto L12;
        List<p0> r102 = r101.getProducts();
        if (r102 == null) goto L12;
        p0 r103 = (p0) CollectionsKt.firstOrNull(r102);
        if (r103 == null) goto L12;
        k1 r104 = r103.g();
        if (r104 == null) goto L12;
        List<e2> r105 = r104.c();
        if (r105 == null) goto L12;
        return r105;
    L12:
        if (r101 == null) goto L20;
        n0 r106 = r101.getSliceCard();
        if (r106 == null) goto L20;
        y r107 = r106.f484835c;
        if (r107 == null) goto L20;
        a0 r108 = r107.a();
        if (r108 == null) goto L20;
        return r108.c();
    L20:
        return null;
    }

    public static final Map<String, Object> b(InFeedProductV2 r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$commonParams");
        Intrinsics.checkNotNullParameter(r101, "eventName");
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L9;
        return null;
    L9:
        LinkedHashMap r103 = new LinkedHashMap();
        n0 r104 = r100.slcCard();
        if (r104 == null) goto L14;
        Map<String, ? extends Object> r105 = r104.f484834b;
        if (r105 == null) goto L14;
        r103.putAll(r105);
    L14:
        n0 r106 = r100.slcCard();
        if (r106 == null) goto L33;
        m0 r107 = r106.g();
        if (r107 == null) goto L33;
        Map<String, Object> r108 = r107.c();
        if (r108 == null) goto L21;
        r103.putAll(r108);
    L21:
        Map<String, b0> r109 = r107.a();
        if (r109 == null) goto L33;
        b0 r110 = r109.get(r101);
        if (r110 == null) goto L33;
        if (r110.a() == false) goto L30;
        Map<String, Object> r111 = r107.b();
        if (r111 == null) goto L30;
        r103.putAll(r111);
    L30:
        Map<String, Object> r112 = r110.b();
        if (r112 == null) goto L33;
        r103.putAll(r112);
    L33:
        return r103;
    L5:
        r102 = false;
        goto L6
    }

    public static final String c(InFeedProductV2 r100, String r101, View r102) {
        Intrinsics.checkNotNullParameter(r101, "btm");
        Intrinsics.checkNotNullParameter(r102, "view");
        String r103 = null;
        if (r100 == null) goto L7;
        InFeedProductPackData r104 = r100.getPackData();
        if (r104 == null) goto L7;
        InFeedProductPackDataElements r105 = r104.getElements();
    L8:
        if (r105 == null) goto L15;
        List<p0> r106 = r105.getProducts();
        if (r106 == null) goto L15;
        p0 r107 = (p0) CollectionsKt.firstOrNull(r106);
        if (r107 == null) goto L15;
        Map<String, Object> r108 = r107.s();
        if (r108 == null) goto L15;
    L22:
        BcmParams r109 = new BcmParams();
        r109.put(com.bytedance.android.ec.core.event.a.KEY_BST_GROUP_TYPE, "product");
        int r110 = vd3.a.f554187a;
        if (r108 == null) goto L29;
        String r111 = r108.toString();
        if (r111 == null) goto L29;
        JSONObject r112 = com.bytedance.android.ec.hybrid.list.util.k.c(r111);
        if (r112 == null) goto L29;
        r103 = r112.optString(com.bytedance.android.ec.core.event.a.KEY_STANDARD_CHAIN_PARAM);
    L29:
        vd3.a.a(r109, r103);
        return le3.b.d(r101, r102, r109);
    L15:
        if (r105 == null) goto L21;
        n0 r113 = r105.getSliceCard();
        if (r113 == null) goto L21;
        k0 r114 = r113.e();
        if (r114 == null) goto L21;
        r108 = r114.h();
    L21:
        r108 = null;
    L7:
        r105 = null;
        goto L8
    }
}
