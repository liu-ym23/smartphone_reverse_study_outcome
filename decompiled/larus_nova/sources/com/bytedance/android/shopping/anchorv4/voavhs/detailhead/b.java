package com.bytedance.android.shopping.anchorv4.voavhs.detailhead;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailCombinePropertiesComponent;
import com.bytedance.android.shopping.anchorv3.repository.dto.DetailCombinePropertiesSkusStruct;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f168215a = 0;

    public b() {
    }

    static {
    }

    public static String b(DetailCombinePropertiesComponent r100) {
        if (r100 == null) goto L14;
        List<DetailCombinePropertiesSkusStruct> r101 = r100.getSkus();
        if (r101 == null) goto L8;
        DetailCombinePropertiesSkusStruct r102 = (DetailCombinePropertiesSkusStruct) ListProtector.get(r101, 0);
        if (r102 == null) goto L8;
        ECUrlModel r103 = r102.getPic();
    L9:
        if (r103 != null) goto L12;
        return EffectConfiguration.KEY_SEARCH_WORD;
    L12:
        return "picture";
    L8:
        r103 = null;
        goto L9
    L14:
        return "";
    }

    public static void a(t r100, int r110, boolean r111, String r112) {
        if (r100 == null) goto L9;
        Pair[] r101 = new Pair[3];
        r101[0] = TuplesKt.to("params_cnt", Integer.valueOf(r110));
        if (r111 == false) goto L6;
        String r113 = "1";
    L7:
        r101[1] = TuplesKt.to("is_fold", r113);
        r101[2] = TuplesKt.to("params_list", String.valueOf(r112));
        com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r100, "click_product_feature_unfold", MapsKt.mapOf(r101), false, null, null, null, null, 252);
        return;
    L6:
        r113 = "0";
        goto L7
    }
}
