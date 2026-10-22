package com.bytedance.android.ec.core.utils;

import com.bytedance.android.ec.model.response.ProductSelectPoiInfo;
import com.bytedance.android.ec.model.sku.SkuPoiInfo;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class d1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static ProductSelectPoiInfo f45575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SkuPoiInfo f45576b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f45577c = null;

    public static final class a implements ti.j {
        public a() {
        }

        @Override // ti.j
        public final void a(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            if (a2.b(r100.optString("poi_name")) == true) goto L5;
            return;
        L5:
            if (a2.b(r100.optString("address")) == false) goto L9;
            ProductSelectPoiInfo r101 = new ProductSelectPoiInfo();
            r101.setPoiId(r100.optString("poi_id"));
            r101.setPoiName(r100.optString("poi_name"));
            r101.setDistance(Double.valueOf(r100.optDouble("distance")));
            r101.setDistanceDesc(r100.optString("distance_desc"));
            r101.setAddress(r100.optString("address"));
            r101.setPoiPhone(r100.optString("poi_phone"));
            r101.setParamsObj(z1.k(r100));
            d1.f45575a = r101;
            s0.a(new hl.n(r101));
            return;
        }
    }

    static {
        f45577c = new a();
    }
}
