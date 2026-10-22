package com.bytedance.android.shopping.anchorv4.voavhs.guess;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.response.anchorv3.AdInfoStruct;
import com.bytedance.android.shopping.anchorv3.detail.StaggeredGridDoubleColumnDecoration;
import com.bytedance.android.shopping.anchorv3.guessulike.model.GULFeedbackDislikeReq;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardLiveStruct;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardProductStruct;
import com.bytedance.android.shopping.anchorv3.guessulike.model.ItemCardRecommendReasonStruct;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.jedi.ext.adapter.JediSimpleViewHolder;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/guess/AnchorV4GuessBaseVH;", "Lcom/bytedance/jedi/ext/adapter/JediSimpleViewHolder;", "Lj63/c;", "Lcom/bytedance/android/shopping/anchorv4/log/d;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class AnchorV4GuessBaseVH extends JediSimpleViewHolder<j63.c> implements com.bytedance.android.shopping.anchorv4.log.d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public j63.c f168338l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final a f168339m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.lynx.d f168340n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final RecyclerView f168341o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final h f168342p;

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AnchorV4GuessBaseVH f168343a;

        public a(AnchorV4GuessBaseVH r100) {
            this.f168343a = r100;
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.f
        public final void p(GULFeedbackDislikeReq r100) {
            Intrinsics.checkNotNullParameter(r100, HiAnalyticsConstant.Direction.REQUEST);
            this.f168343a.f168342p.p(r100);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.f
        public final void v(j63.c r110, String r111) {
            Intrinsics.checkNotNullParameter(r111, "clickArea");
            h r100 = this.f168343a.f168342p;
            Pair[] r101 = new Pair[7];
            Integer r102 = null;
            if (r110 == null) goto L7;
            ItemCardLiveStruct r103 = r110.b();
            if (r103 == null) goto L7;
            String r104 = r103.getUid();
        L8:
            r101[0] = TuplesKt.to("anchor_id", r104);
            if (r110 == null) goto L13;
            ItemCardLiveStruct r105 = r110.b();
            if (r105 == null) goto L13;
            String r106 = r105.getRoomId();
        L14:
            r101[1] = TuplesKt.to("room_id", r106);
            if (r110 == null) goto L19;
            ItemCardProductStruct r107 = r110.d();
            if (r107 == null) goto L19;
            String r108 = r107.getProductId();
        L20:
            r101[2] = TuplesKt.to("product_id", r108);
            if (r110 == null) goto L28;
            ItemCardLiveStruct r109 = r110.b();
            if (r109 == null) goto L28;
            Integer r112 = r109.getStatus();
            if (r112 == null) goto L28;
            String r113 = String.valueOf(r112.intValue());
            if (r113 == null) goto L28;
        L29:
            r101[3] = TuplesKt.to("live_status", r113);
            r101[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r111);
            r101[5] = TuplesKt.to("enter_from_merge", com.bytedance.android.ec.core.event.a.VALUE_GUESSULIKE_PRODUCT_DETAIL);
            r101[6] = TuplesKt.to("enter_method", "native");
            Map r114 = MapsKt.mutableMapOf(r101);
            AnchorV4GuessBaseVH r115 = this.f168343a;
            if (r110 == null) goto L32;
            AdInfoStruct r116 = r110.a();
        L33:
            if (r110 == null) goto L35;
            r102 = Integer.valueOf(r110.f497513b);
        L35:
            r115.getClass();
            AnchorV4GuessBaseVH.d4(r116, r102, r114);
            Unit r117 = Unit.INSTANCE;
            com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r100, "anchor_card_click", r114, false, null, null, null, null, 252);
            return;
        L32:
            r116 = null;
        L28:
            r113 = "0";
        L19:
            r108 = null;
        L13:
            r106 = null;
        L7:
            r104 = null;
            goto L8
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.f
        public final void u(ItemCardRecommendReasonStruct r110, j63.c r111, Integer r112) {
            h r100 = this.f168343a.f168342p;
            Pair[] r101 = new Pair[4];
            r101[0] = TuplesKt.to("page_name", "product_detail_guessyoulike");
            r101[1] = TuplesKt.to("display_rank", String.valueOf(r112));
            String r113 = null;
            if (r111 == null) goto L7;
            ItemCardProductStruct r114 = r111.d();
            if (r114 == null) goto L7;
            String r115 = r114.getProductId();
        L8:
            r101[2] = TuplesKt.to("product_id", r115);
            if (r110 == null) goto L11;
            r113 = r110.getRankId();
        L11:
            r101[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_RANK_ID, r113);
            com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r100, "product_ranking_entrance_click", MapsKt.mapOf(r101), false, null, null, null, null, 252);
            return;
        L7:
            r115 = null;
            goto L8
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.f
        public final void q(String r110, String r111, PageFinder r112, boolean r113) {
            Intrinsics.checkNotNullParameter(r110, "event");
            Integer r100 = AnchorV4GuessBaseVH.c4(this.f168343a).getType();
            String r101 = null;
            if (r100 != null) goto L6;
        L8:
            if (r100 != null) goto L11;
        L13:
            if (r100 != null) goto L16;
        L18:
            if (r100 != null) goto L21;
        L23:
            String r102 = null;
        L24:
            AnchorV4GuessBaseVH r103 = this.f168343a;
            h r104 = r103.f168342p;
            ItemCardProductStruct r105 = r103.getItem().d();
            if (r105 == null) goto L27;
            String r106 = r105.getProductId();
        L28:
            Pair[] r114 = new Pair[5];
            r114[0] = TuplesKt.to("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
            r114[1] = TuplesKt.to("outflow_order", Integer.valueOf(AnchorV4GuessBaseVH.c4(this.f168343a).f497513b));
            r114[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_TYPE, r102);
            if (AnchorV4GuessBaseVH.c4(this.f168343a).a() == null) goto L31;
            r101 = com.bytedance.android.ec.core.event.a.VALUE_EFFECTIVE_AD;
        L31:
            r114[3] = TuplesKt.to("is_other_channel", r101);
            r114[4] = TuplesKt.to("btm", r111);
            com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r104, r110, MapsKt.mapOf(r114), r113, null, r112, r106, null, 148);
            return;
        L27:
            r106 = null;
            goto L28
        L21:
            if (r100.intValue() != 4) goto L23;
            r102 = "video";
            goto L24
        L16:
            if (r100.intValue() != 3) goto L18;
            r102 = "activity";
            goto L24
        L11:
            if (r100.intValue() != 2) goto L13;
            r102 = "product";
            goto L24
        L6:
            if (r100.intValue() != 1) goto L8;
            r102 = "live";
            goto L24
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.f
        public final void s(String r110, String r111, String r112, String r113) {
            Intrinsics.checkNotNullParameter(r111, "enterMethod");
            com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(this.f168343a.f168342p, "show_ecom_similar", MapsKt.mapOf(new Pair[]{TuplesKt.to("product_id", r112), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r113), TuplesKt.to("enter_method", r111), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_TYPE, r110)}), false, null, null, null, null, 252);
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.f
        public final void t(String r110, String r111, String r112, String r113) {
            Intrinsics.checkNotNullParameter(r110, "ecomType");
            Intrinsics.checkNotNullParameter(r111, "enterMethod");
            h r100 = this.f168343a.f168342p;
            Pair[] r101 = new Pair[6];
            r101[0] = TuplesKt.to("product_id", r113);
            r101[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r112);
            r101[2] = TuplesKt.to("enter_method", r111);
            r101[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_TYPE, r110);
            HashSet<String> r114 = l63.a.f507661a;
            if (l63.a.b(AnchorV4GuessBaseVH.c4(this.f168343a).getType()) == false) goto L5;
            String r115 = "1";
        L6:
            r101[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_WITH_MORE, r115);
            r101[5] = TuplesKt.to("outflow_order", Integer.valueOf(AnchorV4GuessBaseVH.c4(this.f168343a).f497513b));
            com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r100, "show_ecom_dislike", MapsKt.mapOf(r101), false, null, null, null, null, 252);
            return;
        L5:
            r115 = "0";
            goto L6
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.f
        public final void r(String r110, String r111, String r112, String r210, String r211) {
            Intrinsics.checkNotNullParameter(r110, "ecomType");
            Intrinsics.checkNotNullParameter(r111, "enterMethod");
            int r100 = this.f168343a.getAdapterPosition();
            RecyclerView.Adapter r101 = this.f168343a.f168341o.getAdapter();
            if (r101 == null) goto L5;
            int r102 = r101.getItemCount();
        L6:
            int r103 = ((r100 - r102) + this.f168343a.f168342p.C()) + 1;
            h r104 = this.f168343a.f168342p;
            Pair[] r105 = new Pair[7];
            r105[0] = TuplesKt.to("product_id", r210);
            r105[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r112);
            r105[2] = TuplesKt.to("enter_method", r111);
            r105[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_TYPE, r110);
            HashSet<String> r106 = l63.a.f507661a;
            if (l63.a.b(AnchorV4GuessBaseVH.c4(this.f168343a).getType()) == false) goto L9;
            String r107 = "1";
        L10:
            r105[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_WITH_MORE, r107);
            r105[5] = TuplesKt.to("outflow_order", Integer.valueOf(r103));
            r105[6] = TuplesKt.to("close_type", r211);
            com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r104, "close_ecom_dislike", MapsKt.mapOf(r105), false, null, null, null, null, 252);
            return;
        L9:
            r107 = "0";
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.f
        public final void w(String r210, String r211, String r212, boolean r213, String r214, j63.c r215) {
            Intrinsics.checkNotNullParameter(r210, "confirmContent");
            Intrinsics.checkNotNullParameter(r211, "ecomType");
            Intrinsics.checkNotNullParameter(r212, "enterMethod");
            Intrinsics.checkNotNullParameter(r214, "clickArea");
            Intrinsics.checkNotNullParameter(r215, MapController.ITEM_LAYER_TAG);
            int r100 = this.f168343a.getAdapterPosition();
            RecyclerView.Adapter r101 = this.f168343a.f168341o.getAdapter();
            if (r101 == null) goto L5;
            int r102 = r101.getItemCount();
        L6:
            int r103 = ((r100 - r102) + this.f168343a.f168342p.C()) + 1;
            h r110 = this.f168343a.f168342p;
            Pair[] r104 = new Pair[11];
            r104[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CONFIRM_CONTENT, r210);
            r104[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ECOM_TYPE, r211);
            r104[2] = TuplesKt.to("enter_method", r212);
            ItemCardProductStruct r105 = r215.d();
            String r106 = null;
            if (r105 == null) goto L9;
            String r107 = r105.getProductId();
        L10:
            r104[3] = TuplesKt.to("product_id", r107);
            ItemCardProductStruct r108 = r215.d();
            if (r108 == null) goto L13;
            String r109 = r108.getCommodityType();
        L14:
            r104[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_COMMODITY_TYPE, r109);
            if (r213 == false) goto L17;
            String r111 = "1";
        L18:
            r104[5] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_WITH_MORE, r111);
            r104[6] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CLICK_AREA, r214);
            r104[7] = TuplesKt.to("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
            String r112 = r215.getRequestId();
            String r113 = "";
            if (r112 != null) goto L21;
            r112 = "";
        L21:
            r104[8] = TuplesKt.to("request_id", r112);
            ItemCardProductStruct r114 = r215.d();
            if (r114 == null) goto L24;
            r106 = r114.getRecommendInfo();
        L24:
            if (r106 == null) goto L27;
            r113 = r106;
        L27:
            r104[9] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_RECOMMEND_INFO, r113);
            r104[10] = TuplesKt.to("outflow_order", Integer.valueOf(r103));
            com.bytedance.android.shopping.anchorv4.voavhs.car.f.a.a(r110, "click_ecom_dislike", MapsKt.mapOf(r104), false, null, null, null, null, 252);
            return;
        L17:
            r111 = "0";
            goto L18
        L13:
            r109 = null;
            goto L14
        L9:
            r107 = null;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }
    }

    @Override // com.bytedance.android.shopping.anchorv4.log.d
    public final void onScan() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.log.d
    public final void onVisible() {
    }

    @Override // com.bytedance.android.shopping.anchorv4.log.d
    public final int M0() {
        return com.bytedance.android.shopping.extensions.b.b(60);
    }

    @Override // com.bytedance.jedi.ext.adapter.JediViewHolder, com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder
    public final void T3() {
        super.T3();
        CommonMeta r100 = this.f168342p.a();
        if (r100 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "$this$addGulVHCount");
        r100.setGulVHCount(r100.getGulVHCount() + 1);
        return;
    }

    @Override // com.bytedance.jedi.ext.adapter.JediViewHolder, com.bytedance.jedi.ext.adapter.multitype.MultiTypeViewHolder
    public final void V3() {
        super.V3();
        CommonMeta r100 = this.f168342p.a();
        if (r100 == null) goto L8;
        Intrinsics.checkNotNullParameter(r100, "$this$minusGulVHCount");
        r100.setGulVHCount(r100.getGulVHCount() - 1);
        if (r100.getGulVHCount() != 0) goto L9;
        r100.setHeadViewScrollToGUL(false);
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.shopping.anchorv4.log.d
    public View t() {
        return this.itemView;
    }

    public static final /* synthetic */ j63.c c4(AnchorV4GuessBaseVH r100) {
        return r100.getItem();
    }

    @Override // com.bytedance.jedi.ext.adapter.JediSimpleViewHolder
    public /* bridge */ /* synthetic */ void a4(j63.c r100) {
        e4(r100);
    }

    public void e4(j63.c r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        this.f168340n.b(this, r100);
    }

    public static void d4(AdInfoStruct r100, Integer r101, Map r102) {
        Intrinsics.checkNotNullParameter(r102, "map");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L28
        if (r100 == null) goto L6;
        String r104 = r100.getRawData();     // Catch: Throwable -> L28
    L7:
        if (r104 != null) goto L9;
    L12:
        boolean r105 = true;
    L14:
        if (r105 == false) goto L16;
        Object r106 = r102.put("is_other_channel", "");     // Catch: Throwable -> L28
    L26:
        Object r107 = Result.m9449constructorimpl(r106);     // Catch: Throwable -> L28
    L30:
        Throwable r108 = Result.m9452exceptionOrNullimpl(r107);
        if (r108 == null) goto L36;
        ECExceptionMonitor.e(r108);
        return;
    L36:
        return;
    L16:
        if (r100 == null) goto L18;
        String r109 = r100.getRawData();     // Catch: Throwable -> L28
    L19:
        JSONObject r110 = k.w(r109);     // Catch: Throwable -> L28
        if (r110 == null) goto L24;
        JSONObject r111 = r110.optJSONObject("raw_ad_data");     // Catch: Throwable -> L28
        if (r111 == null) goto L24;
        r102.put("creative_id", r111.optString("creative_id"));     // Catch: Throwable -> L28
        r102.put("is_other_channel", com.bytedance.android.ec.core.event.a.VALUE_EFFECTIVE_AD);     // Catch: Throwable -> L28
        r102.put("log_extra", r111.optString("log_extra"));     // Catch: Throwable -> L28
        r102.put("outflow_order", r101);     // Catch: Throwable -> L28
        r102.put("page_name", com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);     // Catch: Throwable -> L28
        r102.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, "guess_you_like_product");     // Catch: Throwable -> L28
    L25:
        r106 = r102;
    L24:
        r102 = null;
        goto L25
    L18:
        r109 = null;
        goto L19
    L9:
        if (r104.length() == 0) goto L12;
        r105 = false;
        goto L14
    L6:
        r104 = null;
    L28:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L30
    }

    @Override // com.bytedance.jedi.ext.adapter.JediSimpleViewHolder
    public /* bridge */ /* synthetic */ void b4(j63.c r100, int r101, List r102) {
        f4(r100, r101, r102);
    }

    public void f4(j63.c r100, int r101, List<Object> r102) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if ((!Intrinsics.areEqual(this.f168338l, r100)) == false) goto L6;
        this.f168338l = r100;
        e4(r100);
        return;
    }

    public AnchorV4GuessBaseVH(View r100, com.bytedance.android.shopping.anchorv4.voavhs.lynx.d r101, RecyclerView r102, h r103) {
        Intrinsics.checkNotNullParameter(r100, "theView");
        Intrinsics.checkNotNullParameter(r101, "logManager");
        Intrinsics.checkNotNullParameter(r102, "recyclerView");
        Intrinsics.checkNotNullParameter(r103, "anchorV4VM");
        super(r100);
        this.f168340n = r101;
        this.f168341o = r102;
        this.f168342p = r103;
        StaggeredGridDoubleColumnDecoration.a r104 = StaggeredGridDoubleColumnDecoration.f164806g;
        View r105 = this.itemView;
        r104.getClass();
        StaggeredGridDoubleColumnDecoration.a.b(r105, true);
        this.f168339m = new a(this);
    }
}
