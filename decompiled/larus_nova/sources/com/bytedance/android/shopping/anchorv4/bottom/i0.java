package com.bytedance.android.shopping.anchorv4.bottom;

import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.sdk.ECSdk;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class i0 {
    public static final gl.a a(SkuMeta r100, j0 r101) {
        int r102 = ECSdk.f48106a;
        IEntranceInfoService r103 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);
        JSONObject r104 = null;
        if (r103 == null) goto L5;
        gl.a r105 = r103.initEntranceInfo(new EntranceInfoScene("productDetail", "enterSku"), r100.getEntranceInfo());
    L7:
        if (r105 == null) goto L12;
        Pair<String, ? extends Object>[] r106 = new Pair[1];
        String r107 = r100.getItemId();
        if (r107 != null) goto L11;
        r107 = "";
    L11:
        r106[0] = TuplesKt.to("item_id", r107);
        r105.g(r106);
    L12:
        if (r105 == null) goto L18;
        String r108 = r100.getPassThroughEventData();
        if (r108 == null) goto L16;
        r104 = com.bytedance.android.shopping.extensions.k.w(r108);
    L16:
        r105.i(r104);
    L18:
        if (r101.f165831e == true) goto L21;
        int r109 = com.bytedance.android.shopping.feed.utils.b.f175437a;
        if (com.bytedance.android.shopping.feed.utils.b.e(r100.getPassThroughEventData()) == true) goto L21;
    L27:
        if (r105 == null) goto L29;
        r105.j(new Pair[]{TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY, r100.getProductTypeVerified()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_BRAND_VERIFIED, r100.getBrandVerified()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME, r100.getLabelName()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r100.getLabelNameLive()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_REPLAY, r100.getHasReplay()), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_WITH_VIDEO, r100.getWithVideo())}, SkuComponentKt$buildSkuEntranceInfo$1.INSTANCE);
    L29:
        return r105;
    L21:
        if (r105 == null) goto L27;
        Object[] r110 = com.bytedance.android.shopping.feed.f.f175010a.toArray(new String[0]);
        if (r110 == null) goto L26;
        r105.d((String[]) r110);
        goto L27
    L26:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    L5:
        r105 = null;
        goto L7
    }
}
