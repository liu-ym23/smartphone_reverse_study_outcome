package com.bytedance.android.ec.common.impl.sku.presenter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.base.api.ai.ECAIConstants;
import com.bytedance.android.ec.common.api.entranceinfo.IEntranceInfoService;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.view.SkuBenefitLabelGroupOptimizeLayout;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.widget.PriceView;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.entranceinfo.EntranceInfoScene;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.api.accessibility.AccessibilityDelegateCompatImpl;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.android.ui.ec.widget.tools.UnitExtensionKt;
import com.bytedance.applet.aibridge.ecommerce.api.OpenECommerceSource;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class s0 extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43286f;

    public final void k0() {
        int r100 = UIUtils.getScreenWidth(Y().c());
        if (Z().b(R.id.ll_sku_detail_entrance).f().getVisibility() != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == false) goto L9;
        int r102 = i0(R.id.ll_sku_detail_entrance);
        ((TextView) Z().b(R.id.tv_sku_select_spec).f()).setMaxWidth(((((r100 - vf4.a.b(56)) - vf4.a.b(24)) - vf4.a.b(8)) - r102) - vf4.a.b(8));
        return;
    L9:
        ((TextView) Z().b(R.id.tv_sku_select_spec).f()).setMaxWidth(((r100 - vf4.a.b(56)) - vf4.a.b(24)) - vf4.a.b(8));
        return;
    L5:
        r101 = false;
        goto L7
    }

    public s0(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
    }

    public static final String d0(s0 r310) {
        String r100 = com.bytedance.android.ec.core.event.a.KEY_FXH_WHITE_LIST_FLAG;
        SkuViewModel r101 = r310.f43286f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        String r102 = r101.getSkuParams().getDetailUrl();
        if (r102 == null) goto L231;
        SkuViewModel r110 = r310.f43286f;
        if (r110 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L10:
        Map<String, String> r111 = r110.getSkuParams().getLiveEventParams();
        String r103 = com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY;
        String r112 = "";
        if (r111 == null) goto L76;
        Map r113 = MapsKt.toMutableMap(r111);
        if (r113 == null) goto L76;
        String r210 = com.bytedance.android.ec.core.event.a.KEY_SHOP_OPEN_FLAG;
        SkuViewModel r104 = r310.f43286f;
        if (r104 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        Map<String, String> r105 = r104.getSkuParams().getEventParams();
        String r211 = com.bytedance.android.ec.core.event.a.KEY_USER_OPEN_FXH_FLAG;
        if (r105 == null) goto L21;
        String r106 = r105.get("screen_type");
        if (r106 == null) goto L21;
    L22:
        r113.put("screen_type", r106);
        SkuViewModel r107 = r310.f43286f;
        if (r107 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        Map<String, String> r108 = r107.getSkuParams().getEventParams();
        if (r108 == null) goto L28;
        String r109 = r108.get(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY);
    L29:
        if (r109 != null) goto L31;
        r109 = "";
    L31:
        r113.put(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY, r109);
        SkuViewModel r114 = r310.f43286f;
        if (r114 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L35:
        if (r114.isInDepositPresale() == false) goto L37;
        Object r115 = "1";
    L38:
        r113.put(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL, r115);
        SkuViewModel r116 = r310.f43286f;
        if (r116 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L41:
        Map<String, String> r117 = r116.getSkuParams().getEventParams();
        if (r117 == null) goto L44;
        String r118 = r117.get(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME);
    L45:
        if (r118 != null) goto L47;
        r118 = "";
    L47:
        r113.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r118);
        SkuViewModel r119 = r310.f43286f;
        if (r119 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L50:
        Map<String, String> r120 = r119.getSkuParams().getEventParams();
        if (r120 == null) goto L54;
        String r121 = r120.get("is_explaining");
        if (r121 == null) goto L54;
    L55:
        r113.put("is_explaining", r121);
        SkuViewModel r122 = r310.f43286f;
        if (r122 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L58:
        Map<String, String> r123 = r122.getSkuParams().getEventParams();
        if (r123 == null) goto L61;
        String r124 = r123.get(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS);
    L62:
        if (r124 != null) goto L64;
        r124 = "";
    L64:
        r113.put(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r124);
        SkuViewModel r125 = r310.f43286f;
        if (r125 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L67:
        String r126 = r125.getSkuParams().getTransmissibleJson();
        if (r126 != null) goto L70;
        r126 = "";
    L70:
        r113.put("transmissible_json", r126);
        SkuViewModel r127 = r310.f43286f;
        if (r127 != null) goto L74;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L74:
        if (r127.getSkuParams().isLiveSkuCheck() == false) goto L77;
        r113.put(com.bytedance.android.ec.core.event.a.KEY_FROM_ENTRANCE, "live_sku_card");
    L77:
        String r128 = com.bytedance.android.ec.common.impl.sku.utils.d.c(r102, "v3_events_additions", r113);
        String r129 = "meta_params";
        String r130 = UriProtector.getQueryParameter(UriProtector.parse(r128), "meta_params");
        if (r130 != null) goto L80;
    L183:
        r103 = com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY;
        String r131 = r128;
    L184:
        SkuViewModel r132 = r310.f43286f;
        if (r132 != null) goto L187;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L187:
        String r133 = com.bytedance.android.ec.common.impl.sku.utils.d.d(r131, "disable_live_window", String.valueOf(r132.getSkuParams().isFromPlayback()));
        Lazy r134 = ECAppInfoService.f48110a;
        if (ECAppInfoService.h() == false) goto L190;
        r133 = com.bytedance.android.ec.common.impl.sku.utils.d.d(r133, "request_page", ECAIConstants.SCENE_ECOM_PRODUCT);
    L190:
        SkuViewModel r135 = r310.f43286f;
        if (r135 != null) goto L193;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L193:
        Map<String, String> r136 = r135.getSkuParams().getEventParams();
        if (r136 == null) goto L196;
        String r137 = r136.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE);
    L197:
        String r138 = com.bytedance.android.ec.common.impl.sku.utils.d.d(r133, com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r137);
        SkuViewModel r139 = r310.f43286f;
        if (r139 != null) goto L200;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L200:
        Map<String, String> r140 = r139.getSkuParams().getEventParams();
        if (r140 == null) goto L203;
        String r141 = r140.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME);
    L204:
        String r142 = com.bytedance.android.ec.common.impl.sku.utils.d.d(r138, "label_name_from_live", r141);
        SkuViewModel r143 = r310.f43286f;
        if (r143 != null) goto L207;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L207:
        Map<String, String> r144 = r143.getSkuParams().getEventParams();
        String r145 = r103;
        if (r144 == null) goto L210;
        String r146 = r144.get(r145);
    L211:
        String r147 = com.bytedance.android.ec.common.impl.sku.utils.d.d(com.bytedance.android.ec.common.impl.sku.utils.d.d(r142, r145, r146), PdpOpenThirdParam.KEY_PROMOTION_SOURCE, String.valueOf(SourceType.XIAO_DIAN.getType()));
        SkuViewModel r148 = r310.f43286f;
        if (r148 != null) goto L214;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L214:
        r148.setLastBehaviorBeforeDismiss("click");
        if (jg.h.f498946a.getActivity(r310.a0()) == null) goto L217;
        r112 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b5267.c6709.d2425", Boolean.FALSE).withView(r310.a0()).build());
    L217:
        String r149 = r112;
        SkuViewModel r150 = r310.f43286f;
        if (r150 != null) goto L220;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L220:
        Pair[] r151 = new Pair[2];
        SkuViewModel r152 = r310.f43286f;
        if (r152 != null) goto L223;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L223:
        SkuInfoVO r153 = r152.getSkuInfo().a();
        if (r153 == null) goto L226;
        Long r154 = r153.getDiscountPrice();
    L227:
        if (r154 == null) goto L229;
        Object r155 = "1";
    L230:
        r151[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_AVL_DISCOUNT, r155);
        r151[1] = TuplesKt.to("btm_id", r149);
        SkuViewModel.doSkuEventAction$default(r150, OpenECommerceSource.CLICK_PRODUCT_DETAIL, r151, null, null, null, 28, null);
        return com.bytedance.android.ec.core.btm.c.c(r147, r310.a0(), "a1.b5267.c6709.d2425", new Pair[0]);
    L229:
        r155 = "0";
        goto L230
    L226:
        r154 = null;
        goto L227
    L210:
        r146 = null;
        goto L211
    L203:
        r141 = null;
        goto L204
    L196:
        r137 = null;
        goto L197
    L80:
        if (r130.length() <= 0) goto L82;
        boolean r212 = true;
    L83:
        if (r212 == true) goto L86;
        r130 = null;
    L86:
        if (r130 == null) goto L183;
        JSONObject r156 = new JSONObject(r130);     // Catch: JSONException -> L179
        String r157 = r156.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);     // Catch: JSONException -> L179
        if (r157.length() <= 0) goto L90;
        boolean r213 = true;
    L91:
        if (r213 == true) goto L95;
        r157 = null;
    L95:
        if (r157 != null) goto L237;
        String r214 = r128;
        r100 = com.bytedance.android.ec.core.event.a.KEY_FXH_WHITE_LIST_FLAG;
        r129 = "meta_params";
    L239:
        String r158 = r214;
        r131 = com.bytedance.android.ec.common.impl.sku.utils.d.b(r158, r129, r156.toString());     // Catch: JSONException -> L175
        SkuViewModel r159 = r310.f43286f;     // Catch: JSONException -> L173
        if (r159 != null) goto L161;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L173
    L161:
        String r160 = r159.getSkuParams().getSkuLogExtra();     // Catch: JSONException -> L173
        if (r160 == null) goto L184;
        if (r160.length() <= 0) goto L166;
        boolean r161 = true;
    L167:
        if (r161 == true) goto L170;
        r160 = null;
    L170:
        if (r160 == null) goto L184;
        JSONObject r162 = new JSONObject(r160);     // Catch: JSONException -> L173
        String r163 = r100;
        String r164 = r211;
        String r165 = r210;
        r131 = com.bytedance.android.ec.common.impl.sku.utils.d.a(r131, new Pair[]{new Pair(r163, r162.optString(r163)), new Pair(r164, r162.optString(r164)), new Pair(com.bytedance.android.ec.core.event.a.KEY_BIND_CARD_FLAG, r162.optString(com.bytedance.android.ec.core.event.a.KEY_BIND_CARD_FLAG)), new Pair(r165, r162.optString(r165))});     // Catch: JSONException -> L173
        goto L184
    L166:
        r161 = false;
    L173:
        e = e;
    L182:
        ECExceptionMonitor.e(e);
        Unit r166 = Unit.INSTANCE;
    L175:
        e = e;
    L181:
        r131 = r158;
    L177:
        e = e;
        r158 = r214;
        goto L181
    L237:
        int r215 = ECSdk.f48106a;     // Catch: JSONException -> L151
        IEntranceInfoService r167 = (IEntranceInfoService) ECSdk.a(IEntranceInfoService.class);     // Catch: JSONException -> L151
        if (r167 == null) goto L101;
        r214 = r128;
        gl.a r168 = r167.initEntranceInfo(new EntranceInfoScene(ECPromotion.SKU, "enterProductDetail"), r157);     // Catch: JSONException -> L144
    L102:
        if (r168 == null) goto L146;
        Pair<String, ? extends Object>[] r169 = new Pair[7];     // Catch: JSONException -> L144
        r169[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_FROM_ENTRANCE, "live_sku_card");     // Catch: JSONException -> L144
        SkuViewModel r170 = r310.f43286f;     // Catch: JSONException -> L144
        if (r170 != null) goto L107;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L144
    L107:
        if (r170.isInDepositPresale() == false) goto L109;
        Object r171 = "1";
    L110:
        r169[1] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL, r171);     // Catch: JSONException -> L144
        SkuViewModel r172 = r310.f43286f;     // Catch: JSONException -> L144
        if (r172 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L144
    L113:
        SkuInfoVO r173 = r172.getSkuInfo().a();     // Catch: JSONException -> L144
        if (r173 != null) goto L116;
    L118:
        int r174 = 0;
    L119:
        r169[2] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_UNDER_STOCK, Integer.valueOf(r174));     // Catch: JSONException -> L144
        SkuViewModel r175 = r310.f43286f;     // Catch: JSONException -> L144
        if (r175 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L144
    L122:
        String r176 = r175.getSkuParams().getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY);     // Catch: JSONException -> L144
        if (r176 != null) goto L125;
        r176 = "0";
    L125:
        r169[3] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY, r176);     // Catch: JSONException -> L144
        SkuViewModel r177 = r310.f43286f;     // Catch: JSONException -> L144
        if (r177 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L144
    L128:
        String r178 = r177.getSkuParams().getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME);     // Catch: JSONException -> L144
        if (r178 != null) goto L131;
        r178 = "";
    L131:
        r169[4] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r178);     // Catch: JSONException -> L144
        SkuViewModel r179 = r310.f43286f;     // Catch: JSONException -> L144
        if (r179 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L144
    L134:
        String r180 = r179.getSkuParams().getEventParams().get("is_explaining");     // Catch: JSONException -> L144
        if (r180 != null) goto L137;
        r180 = "0";
    L137:
        r169[5] = TuplesKt.to("is_explaining", r180);     // Catch: JSONException -> L144
        SkuViewModel r181 = r310.f43286f;     // Catch: JSONException -> L144
        if (r181 != null) goto L140;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L144
    L140:
        String r182 = r181.getSkuParams().getEventParams().get(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS);     // Catch: JSONException -> L144
        if (r182 != null) goto L143;
        r182 = "";
    L143:
        r169[6] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r182);     // Catch: JSONException -> L144
        r168.g(r169);     // Catch: JSONException -> L144
        goto L146
    L116:
        if (r173.isUnderStock() != true) goto L118;
        r174 = 1;
        goto L119
    L109:
        r171 = "0";
    L146:
        if (r168 == null) goto L148;
        String r183 = r168.h();     // Catch: JSONException -> L144
    L149:
        r156.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r183);     // Catch: JSONException -> L144
        goto L239
    L148:
        r183 = null;
    L144:
        e = e;
    L153:
        r131 = r214;
        goto L182
    L101:
        r214 = r128;
        r168 = null;
    L151:
        e = e;
        r214 = r128;
        goto L153
    L90:
        r213 = false;
    L179:
        e = e;
        r103 = com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY;
        r158 = r128;
        goto L181
    L82:
        r212 = false;
        goto L83
    L61:
        r124 = null;
    L54:
        r121 = "0";
        goto L55
    L44:
        r118 = null;
        goto L45
    L37:
        r115 = "0";
        goto L38
    L28:
        r109 = null;
    L21:
        r106 = "0";
    L76:
        r210 = com.bytedance.android.ec.core.event.a.KEY_SHOP_OPEN_FLAG;
        r211 = com.bytedance.android.ec.core.event.a.KEY_USER_OPEN_FXH_FLAG;
        r113 = null;
        goto L77
    L231:
        return null;
    }

    public static final /* synthetic */ SkuViewModel e0(s0 r100) {
        SkuViewModel r101 = r100.f43286f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r101;
    }

    public static final void h0(s0 r210) {
        SkuViewModel r100 = r210.f43286f;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L6:
        if (r100.getCurrentHotMinPrice() == null) goto L8;
        boolean r101 = true;
    L9:
        int r102 = R.id.pv_sku_origin_price;
        if (r101 == false) goto L60;
        SkuViewModel r103 = r210.f43286f;
        if (r103 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        if (r103.getCurrentHotMaxPrice() == null) goto L17;
        boolean r104 = true;
    L18:
        if (r104 == false) goto L60;
        SkuViewModel r105 = r210.f43286f;
        if (r105 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        Long r106 = r105.getCurrentPriceType();
        if (r106 != null) goto L26;
    L45:
        PriceView r107 = (PriceView) r210.Z().b(R.id.pv_sku_hot_min_price).f();
        int r110 = jg.b.f498941a;
        SkuViewModel r111 = r210.f43286f;
        if (r111 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L48:
        Long r112 = r111.getCurrentHotMinPrice();
        if (r112 == null) goto L51;
        long r113 = r112.longValue();
    L52:
        r107.setPriceText(jg.b.b(r113));
        PriceView r108 = (PriceView) r210.Z().b(R.id.pv_sku_hot_max_price).f();
        SkuViewModel r114 = r210.f43286f;
        if (r114 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L55:
        Long r115 = r114.getCurrentHotMaxPrice();
        if (r115 == null) goto L58;
        long r116 = r115.longValue();
    L59:
        r108.setPriceText(jg.b.b(r116));
        r210.Z().b(R.id.pv_sku_hot_min_price).f().setVisibility(0);
        r210.Z().b(R.id.tv_sku_hot_price_divider).f().setVisibility(0);
        r210.Z().b(R.id.pv_sku_hot_max_price).f().setVisibility(0);
    L61:
        SkuViewModel r109 = r210.f43286f;
        if (r109 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L65:
        if (r109.getCurrentFirstPrice() == null) goto L67;
        boolean r117 = true;
    L69:
        if (r117 == false) goto L100;
        PriceView r118 = (PriceView) r210.Z().b(R.id.pv_sku_first_price).f();
        SkuViewModel r119 = r210.f43286f;
        if (r119 != null) goto L73;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L73:
        r118.setPrefixText(r119.getCurrentFirstPricePrefix());
        SkuViewModel r120 = r210.f43286f;
        if (r120 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L76:
        r118.setExtraText(r120.getCurrentFirstPriceSuffix());
        SkuViewModel r121 = r210.f43286f;
        if (r121 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L79:
        Boolean r122 = r121.getCurrentFirstPriceIsUnderline();
        if (r122 == null) goto L82;
        boolean r123 = r122.booleanValue();
    L83:
        r118.setShowDeleteLine(r123);
        int r124 = jg.b.f498941a;
        SkuViewModel r125 = r210.f43286f;
        if (r125 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L86:
        Long r126 = r125.getCurrentFirstPrice();
        if (r126 == null) goto L89;
        long r127 = r126.longValue();
    L90:
        r118.setPriceText(jg.b.b(r127));
        r118.setVisibility(0);
        SkuViewModel r128 = r210.f43286f;
        if (r128 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L94:
        if (cg4.a.a(r128.getCurrentFirstPriceSupplement()) == false) goto L99;
        TextView r129 = (TextView) r210.Z().b(R.id.pv_sku_first_supplement).f();
        SkuViewModel r130 = r210.f43286f;
        if (r130 != null) goto L98;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L98:
        r129.setText(r130.getCurrentFirstPriceSupplement());
        r129.setVisibility(0);
    L101:
        SkuViewModel r131 = r210.f43286f;
        if (r131 != null) goto L105;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L105:
        if (r131.getCurrentSecondPrice() == null) goto L107;
        boolean r132 = true;
    L109:
        if (r132 == false) goto L209;
        SkuViewModel r133 = r210.f43286f;
        if (r133 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L113:
        Long r134 = r133.getCurrentPriceType();
        if (r134 != null) goto L117;
    L148:
        PriceView r135 = (PriceView) r210.Z().b(R.id.pv_sku_second_price).f();
        SkuViewModel r136 = r210.f43286f;
        if (r136 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L151:
        r135.setPrefixText(r136.getCurrentSecondPricePrefix());
        SkuViewModel r137 = r210.f43286f;
        if (r137 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L154:
        r135.setExtraText(r137.getCurrentSecondPriceSuffix());
        SkuViewModel r138 = r210.f43286f;
        if (r138 != null) goto L157;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L157:
        Boolean r139 = r138.getCurrentSecondPriceIsUnderline();
        if (r139 == null) goto L160;
        boolean r140 = r139.booleanValue();
    L161:
        r135.setShowDeleteLine(r140);
        int r141 = jg.b.f498941a;
        SkuViewModel r142 = r210.f43286f;
        if (r142 != null) goto L164;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L164:
        Long r143 = r142.getCurrentSecondPrice();
        if (r143 == null) goto L167;
        long r144 = r143.longValue();
    L168:
        r135.setPriceText(jg.b.b(r144));
        r135.setVisibility(0);
        SkuViewModel r145 = r210.f43286f;
        if (r145 != null) goto L172;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L172:
        if (cg4.a.a(r145.getCurrentSecondPriceSupplement()) == false) goto L177;
        TextView r146 = (TextView) r210.Z().b(R.id.pv_sku_second_supplement).f();
        SkuViewModel r147 = r210.f43286f;
        if (r147 != null) goto L176;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L176:
        r146.setText(r147.getCurrentSecondPriceSupplement());
        r146.setVisibility(0);
    L178:
        SkuViewModel r148 = r210.f43286f;
        if (r148 != null) goto L181;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L181:
        Boolean r149 = r148.getCurrentSecondPriceIsReducePrice();
        Boolean r150 = Boolean.TRUE;
        if (Intrinsics.areEqual(r149, r150) == false) goto L189;
        r135.setHideYang(true);
        r135.C(HeaderOptimizePresenter$updatePriceNew$3$2.INSTANCE);
        r135.setPadding(UnitExtensionKt.dp2px(6), UnitExtensionKt.dp2px(2), UnitExtensionKt.dp2px(6), UnitExtensionKt.dp2px(2));
        Drawable r151 = r135.getBackground();
        if ((r151 instanceof GradientDrawable) == true) goto L186;
        r151 = null;
    L186:
        GradientDrawable r152 = (GradientDrawable) r151;
        if (r152 == null) goto L195;
        r152.setCornerRadii(new float[]{com.bytedance.android.ec.core.utils.q.a(10), com.bytedance.android.ec.core.utils.q.a(10), com.bytedance.android.ec.core.utils.q.a(8), com.bytedance.android.ec.core.utils.q.a(8), com.bytedance.android.ec.core.utils.q.a(8), com.bytedance.android.ec.core.utils.q.a(8), com.bytedance.android.ec.core.utils.q.a(0), com.bytedance.android.ec.core.utils.q.a(0)});
        r135.setBackgroundDrawable(r152);
    L195:
        SkuViewModel r153 = r210.f43286f;
        if (r153 != null) goto L198;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L198:
        Long r154 = r153.getCurrentPriceType();
        if (r154 != null) goto L202;
    L210:
        SkuViewModel r155 = r210.f43286f;
        if (r155 != null) goto L214;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L214:
        if (r155.getCurrentRegularPrice() == null) goto L216;
        boolean r156 = true;
    L218:
        if (r156 == false) goto L249;
        PriceView r157 = (PriceView) r210.Z().b(R.id.pv_sku_regular_price).f();
        SkuViewModel r158 = r210.f43286f;
        if (r158 != null) goto L222;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L222:
        r157.setPrefixText(r158.getCurrentRegularPricePrefix());
        SkuViewModel r159 = r210.f43286f;
        if (r159 != null) goto L225;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L225:
        r157.setExtraText(r159.getCurrentRegularPriceSuffix());
        SkuViewModel r160 = r210.f43286f;
        if (r160 != null) goto L228;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L228:
        Boolean r161 = r160.getCurrentRegularPriceIsUnderline();
        if (r161 == null) goto L231;
        boolean r162 = r161.booleanValue();
    L232:
        r157.setShowDeleteLine(r162);
        int r163 = jg.b.f498941a;
        SkuViewModel r164 = r210.f43286f;
        if (r164 != null) goto L235;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L235:
        Long r165 = r164.getCurrentRegularPrice();
        if (r165 == null) goto L238;
        long r166 = r165.longValue();
    L239:
        r157.setPriceText(jg.b.b(r166));
        r157.setVisibility(0);
        SkuViewModel r167 = r210.f43286f;
        if (r167 != null) goto L243;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L243:
        if (cg4.a.a(r167.getCurrentRegularPriceSupplement()) == false) goto L248;
        TextView r168 = (TextView) r210.Z().b(R.id.pv_sku_regular_supplement).f();
        SkuViewModel r169 = r210.f43286f;
        if (r169 != null) goto L247;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L247:
        r168.setText(r169.getCurrentRegularPriceSupplement());
        r168.setVisibility(0);
    L250:
        LinearLayout r170 = (LinearLayout) r210.Z().b(R.id.ll_sku_price_first_container).f();
        LinearLayout r171 = (LinearLayout) r210.Z().b(R.id.ll_sku_price_second_container).f();
        RelativeLayout r172 = (RelativeLayout) r210.Z().b(R.id.rl_sku_price_container).f();
        SkuViewModel r173 = r210.f43286f;
        if (r173 != null) goto L253;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L253:
        Long r174 = r173.getCurrentPriceType();
        if (r174 != null) goto L257;
    L258:
        PriceView r175 = (PriceView) r210.Z().b(R.id.pv_sku_second_price).f();
    L260:
        TextView r176 = (TextView) r210.Z().b(R.id.pv_sku_second_supplement).f();
        if (r175.getVisibility() != 0) goto L272;
        SkuViewModel r177 = r210.f43286f;
        if (r177 != null) goto L265;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L265:
        Long r178 = r177.getCurrentPriceType();
        if (r178 != null) goto L269;
    L270:
        r102 = R.id.pv_sku_second_price;
    L271:
        int r179 = r210.i0(r102);
    L274:
        if (r176.getVisibility() != 0) goto L276;
        int r180 = r210.i0(R.id.pv_sku_second_supplement);
    L278:
        if (com.bytedance.android.ec.core.abtest.d.F() != 1) goto L280;
    L283:
        int r181 = (((((r210.i0(R.id.rl_sku_price_container) + r179) + vf4.a.b(16)) + vf4.a.b(24)) + vf4.a.b(52)) + vf4.a.b(8)) + vf4.a.b(8);
        int r182 = vf4.a.b(12);
    L285:
        if (((r181 + r182) + r180) <= UIUtils.getScreenWidth(r210.Y().c())) goto L302;
        if ((!Intrinsics.areEqual(r175.getParent(), r171)) == false) goto L316;
        r170.removeView(r175);
        r170.removeView(r176);
        r171.addView(r175, 0);
        r171.addView(r176, 1);
        ViewGroup.LayoutParams r183 = r175.getLayoutParams();
        if ((r183 instanceof ViewGroup.MarginLayoutParams) == true) goto L291;
        r183 = null;
    L291:
        ViewGroup.MarginLayoutParams r184 = (ViewGroup.MarginLayoutParams) r183;
        if (r184 == null) goto L294;
        r184.topMargin = vf4.a.b(4);
        r175.setLayoutParams(r184);
    L294:
        ViewGroup.LayoutParams r185 = r176.getLayoutParams();
        if ((r185 instanceof ViewGroup.MarginLayoutParams) == true) goto L297;
        ViewGroup.LayoutParams r186 = null;
    L298:
        ViewGroup.MarginLayoutParams r187 = (ViewGroup.MarginLayoutParams) r186;
        if (r187 == null) goto L316;
        r187.topMargin = vf4.a.b(4);
        r176.setLayoutParams(r187);
        goto L316
    L297:
        r186 = r185;
    L316:
        View r188 = r210.Z().b(R.id.sku_header_container).f();
        AccessibilityDelegateCompatImpl r189 = new AccessibilityDelegateCompatImpl(r188);
        if (ECSettingKeys.J0() == true) goto L319;
        Unit r190 = Unit.INSTANCE;
        r189.f170190b = com.bytedance.android.ec.core.widget.d0.b((PriceView) r210.Z().b(R.id.pv_sku_first_price).f()) + ((TextView) r210.Z().b(R.id.pv_sku_second_price).f()).getText() + com.bytedance.android.ec.core.widget.d0.b((PriceView) r210.Z().b(R.id.pv_sku_regular_price).f());
    L319:
        ViewCompat.setAccessibilityDelegate(r188, r189);
        return;
    L302:
        if ((!Intrinsics.areEqual(r175.getParent(), r170)) == false) goto L316;
        r171.removeView(r175);
        r171.removeView(r176);
        r170.addView(r175, 1);
        r170.addView(r176, 2);
        ViewGroup.LayoutParams r191 = r175.getLayoutParams();
        if ((r191 instanceof ViewGroup.MarginLayoutParams) == true) goto L306;
        r191 = null;
    L306:
        ViewGroup.MarginLayoutParams r192 = (ViewGroup.MarginLayoutParams) r191;
        if (r192 == null) goto L309;
        r192.topMargin = vf4.a.b(0);
        r175.setLayoutParams(r192);
    L309:
        ViewGroup.LayoutParams r193 = r176.getLayoutParams();
        if ((r193 instanceof ViewGroup.MarginLayoutParams) == true) goto L312;
        ViewGroup.LayoutParams r194 = null;
    L313:
        ViewGroup.MarginLayoutParams r195 = (ViewGroup.MarginLayoutParams) r194;
        if (r195 == null) goto L316;
        r195.topMargin = vf4.a.b(0);
        r176.setLayoutParams(r195);
        goto L316
    L312:
        r194 = r193;
        goto L313
    L280:
        if (com.bytedance.android.ec.core.abtest.d.F() == 2) goto L283;
        r181 = ((((r210.i0(R.id.rl_sku_price_container) + r179) + vf4.a.b(12)) + vf4.a.b(56)) + vf4.a.b(8)) + vf4.a.b(16);
        r182 = vf4.a.b(12);
        goto L285
    L276:
        r180 = 0;
        goto L278
    L269:
        if (r178.longValue() == 2) goto L271;
    L272:
        r179 = 0;
        goto L274
    L257:
        if (r174.longValue() != 2) goto L258;
        r175 = (PriceView) r210.Z().b(R.id.pv_sku_origin_price).f();
        goto L260
    L248:
        r210.Z().b(R.id.pv_sku_regular_supplement).f().setVisibility(8);
        goto L250
    L238:
        r166 = 0;
        goto L239
    L231:
        r162 = false;
        goto L232
    L249:
        r210.Z().b(R.id.pv_sku_regular_price).f().setVisibility(8);
        r210.Z().b(R.id.pv_sku_regular_supplement).f().setVisibility(8);
        goto L250
    L216:
        r156 = false;
        goto L218
    L202:
        if (r154.longValue() != 1) goto L210;
        SkuViewModel r196 = r210.f43286f;
        if (r196 != null) goto L207;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L207:
        if ((!Intrinsics.areEqual(r196.getCurrentSecondPriceIsReducePrice(), r150)) == false) goto L210;
        r135.C(HeaderOptimizePresenter$updatePriceNew$3$6.INSTANCE);
        goto L210
    L189:
        r135.setHideYang(false);
        r135.C(HeaderOptimizePresenter$updatePriceNew$3$4.INSTANCE);
        r135.setPadding(UnitExtensionKt.dp2px(8), UnitExtensionKt.dp2px(3), UnitExtensionKt.dp2px(8), UnitExtensionKt.dp2px(3));
        Drawable r197 = r135.getBackground();
        if ((r197 instanceof GradientDrawable) == true) goto L192;
        r197 = null;
    L192:
        GradientDrawable r198 = (GradientDrawable) r197;
        if (r198 == null) goto L195;
        r198.setCornerRadius(com.bytedance.android.ec.core.utils.q.a(30));
        r135.setBackgroundDrawable(r198);
        goto L195
    L177:
        r210.Z().b(R.id.pv_sku_second_supplement).f().setVisibility(8);
        goto L178
    L167:
        r144 = 0;
        goto L168
    L160:
        r140 = false;
        goto L161
    L117:
        if (r134.longValue() != 2) goto L148;
        PriceView r199 = (PriceView) r210.Z().b(R.id.pv_sku_origin_price).f();
        SkuViewModel r1100 = r210.f43286f;
        if (r1100 != null) goto L121;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L121:
        r199.setPrefixText(r1100.getCurrentSecondPricePrefix());
        SkuViewModel r1101 = r210.f43286f;
        if (r1101 != null) goto L124;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L124:
        r199.setExtraText(r1101.getCurrentSecondPriceSuffix());
        SkuViewModel r1102 = r210.f43286f;
        if (r1102 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L127:
        Boolean r1103 = r1102.getCurrentSecondPriceIsUnderline();
        if (r1103 == null) goto L130;
        boolean r1104 = r1103.booleanValue();
    L131:
        r199.setShowDeleteLine(r1104);
        int r1105 = jg.b.f498941a;
        SkuViewModel r1106 = r210.f43286f;
        if (r1106 != null) goto L134;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L134:
        Long r1107 = r1106.getCurrentSecondPrice();
        if (r1107 == null) goto L137;
        long r1108 = r1107.longValue();
    L138:
        r199.setPriceText(jg.b.b(r1108));
        r199.setVisibility(0);
        SkuViewModel r200 = r210.f43286f;
        if (r200 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L142:
        if (cg4.a.a(r200.getCurrentOriginPriceSupplement()) == false) goto L147;
        TextView r201 = (TextView) r210.Z().b(R.id.pv_sku_origin_supplement).f();
        SkuViewModel r202 = r210.f43286f;
        if (r202 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L146:
        r201.setText(r202.getCurrentOriginPriceSupplement());
        r201.setVisibility(0);
        goto L210
    L147:
        r210.Z().b(R.id.pv_sku_origin_supplement).f().setVisibility(8);
        goto L210
    L137:
        r1108 = 0;
        goto L138
    L130:
        r1104 = false;
        goto L131
    L209:
        r210.Z().b(R.id.pv_sku_second_price).f().setVisibility(8);
        r210.Z().b(R.id.pv_sku_origin_price).f().setVisibility(8);
        r210.Z().b(R.id.pv_sku_second_supplement).f().setVisibility(8);
        r210.Z().b(R.id.pv_sku_origin_supplement).f().setVisibility(8);
        goto L210
    L107:
        r132 = false;
        goto L109
    L99:
        r210.Z().b(R.id.pv_sku_first_supplement).f().setVisibility(8);
        goto L101
    L89:
        r127 = 0;
        goto L90
    L82:
        r123 = false;
        goto L83
    L100:
        r210.Z().b(R.id.pv_sku_first_price).f().setVisibility(8);
        r210.Z().b(R.id.pv_sku_first_supplement).f().setVisibility(8);
        goto L101
    L67:
        r117 = false;
        goto L69
    L58:
        r116 = 0;
        goto L59
    L51:
        r113 = 0;
        goto L52
    L26:
        if (r106.longValue() != 2) goto L45;
        r210.Z().b(R.id.pv_sku_hot_min_price).f().setVisibility(8);
        r210.Z().b(R.id.tv_sku_hot_price_divider).f().setVisibility(8);
        r210.Z().b(R.id.pv_sku_hot_max_price).f().setVisibility(8);
        PriceView r203 = (PriceView) r210.Z().b(R.id.pv_sku_origin_price).f();
        r203.setVisibility(0);
        int r1109 = jg.b.f498941a;
        SkuViewModel r1110 = r210.f43286f;
        if (r1110 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L30:
        Long r1111 = r1110.getCurrentHotMinPrice();
        if (r1111 == null) goto L33;
        long r1112 = r1111.longValue();
    L34:
        r203.setPriceText(jg.b.b(r1112));
        SkuViewModel r1113 = r210.f43286f;
        if (r1113 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        Long r1114 = r1113.getCurrentHotMaxPrice();
        if (r1114 == null) goto L40;
        long r1115 = r1114.longValue();
    L41:
        r203.setMaxPriceText(jg.b.b(r1115));
        SkuViewModel r1116 = r210.f43286f;
        if (r1116 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L44:
        r203.setPrefixText(r1116.getCurrentHotPricePrefix());
        goto L61
    L40:
        r1115 = 0;
        goto L41
    L33:
        r1112 = 0;
        goto L34
    L17:
        r104 = false;
    L60:
        r210.Z().b(R.id.pv_sku_hot_min_price).f().setVisibility(8);
        r210.Z().b(R.id.tv_sku_hot_price_divider).f().setVisibility(8);
        r210.Z().b(R.id.pv_sku_hot_max_price).f().setVisibility(8);
        goto L61
    L8:
        r101 = false;
        goto L9
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r110) {
        this.f43286f = (SkuViewModel) Y().g(SkuViewModel.class);
        View r100 = Z().b(R.id.sdv_sku_select_pop_cover).f();
        AccessibilityDelegateCompatImpl r101 = new AccessibilityDelegateCompatImpl(r100);
        r101.f170190b = "商品图片";
        ViewCompat.setAccessibilityDelegate(r100, r101);
        ImageExtensionsKt.D((GenericDraweeView) Z().b(R.id.sdv_sku_select_pop_cover).f(), new com.bytedance.android.ec.core.imagex.r("ec_sku", "ec_sku_product_image"));
        ((SimpleDraweeView) Z().b(R.id.sdv_sku_select_pop_cover).f()).setOnClickListener(new r0(this));
        SkuViewModel r102 = this.f43286f;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        List<PromotionBenefitLabel> r103 = r102.getSkuParams().getBenefitLabels();
        if (r103 == null) goto L27;
        if ((!r103.isEmpty()) == true) goto L11;
        r103 = null;
    L11:
        if (r103 == null) goto L27;
        SkuBenefitLabelGroupOptimizeLayout r104 = (SkuBenefitLabelGroupOptimizeLayout) Z().b(R.id.ll_sku_benefit_label).f();
        r104.setVisibility(0);
        SkuViewModel r105 = this.f43286f;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L15:
        Intrinsics.checkNotNullParameter(r103, "benefitLabelList");
        Intrinsics.checkNotNullParameter(r105, "viewModel");
        r104.f43412c = r105;
        ((ArrayList) r104.f43410a).clear();
        ((ArrayList) r104.f43411b).clear();
        Iterator<T> r106 = r103.iterator();
    L17:
        if (r106.hasNext() == false) goto L19;
        PromotionBenefitLabel r107 = (PromotionBenefitLabel) r106.next();
        ((ArrayList) r104.f43410a).add(r107);
        ((ArrayList) r104.f43411b).add(r107);
        goto L17
    L19:
        r104.a();
        if (com.bytedance.android.ec.core.abtest.d.F() != 5) goto L25;
        Z().b(R.id.iv_sku_benefit_entrance).f().setVisibility(0);
        com.bytedance.android.ec.core.widget.f.c(Z().b(R.id.coupon_layout).f(), null, null, new HeaderOptimizePresenter$initViews$$inlined$apply$lambda$1(this), 3);
        View r108 = Z().b(R.id.coupon_layout).f();
        int r109 = vf4.a.b(14);
        int r111 = vf4.a.b(14);
        Intrinsics.checkNotNullParameter(r108, "$this$expendTouch");
        r108.post(new com.bytedance.android.ec.common.impl.sku.utils.s(r108, r109, r111));
        SkuViewModel r112 = this.f43286f;
        if (r112 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L24:
        SkuViewModel.doSkuEventAction$default(r112, "sku_panel_module_show", new Pair[]{TuplesKt.to("module_name", "discount_info")}, null, null, null, 28, null);
        goto L27
    L25:
        Z().b(R.id.iv_sku_benefit_entrance).f().setVisibility(8);
    L27:
        if (com.bytedance.android.ec.core.abtest.d.F() != 4) goto L29;
    L32:
        Z().b(R.id.tv_sku_select_spec).f().setVisibility(0);
        k0();
    L33:
        SkuViewModel r113 = this.f43286f;
        if (r113 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L36:
        r113.m8148getCurrentPrice().b(ECQuickUtilKt.a(Y()), new l0(this));
        SkuViewModel r114 = this.f43286f;
        if (r114 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L39:
        r114.getCurrentAvatar().b(ECQuickUtilKt.a(Y()), new m0(this));
        SkuViewModel r115 = this.f43286f;
        if (r115 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L42:
        r115.getCheckedNames().b(ECQuickUtilKt.a(Y()), new n0(this));
        SkuViewModel r116 = this.f43286f;
        if (r116 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L45:
        r116.getSkuInfo().b(ECQuickUtilKt.a(Y()), new o0(this));
        SkuViewModel r117 = this.f43286f;
        if (r117 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L48:
        r117.getCurrentBenefitLabel().b(ECQuickUtilKt.a(Y()), new p0(this));
        SkuViewModel r118 = this.f43286f;
        if (r118 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L51:
        r118.getCurrentAtmosphereStyle().b(ECQuickUtilKt.a(Y()), new q0(this));
        return;
    L29:
        if (com.bytedance.android.ec.core.abtest.d.F() == 5) goto L32;
        Z().b(R.id.tv_sku_select_spec).f().setVisibility(8);
        goto L33
    }

    public final int i0(int r100) {
        View r101 = Z().b(r100).f();
        r101.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r101.getMeasuredWidth();
    }

    public final void j0(int r100) {
        PriceView r101 = (PriceView) Z().b(R.id.pv_sku_first_price).f();
        r101.setPriceTextColor(r100);
        r101.setExtraTextColor(r100);
        r101.setPrefixTextColor(r100);
        PriceView r102 = (PriceView) Z().b(R.id.pv_sku_second_price).f();
        Drawable r103 = r102.getBackground();
        if ((r103 instanceof GradientDrawable) == true) goto L5;
        r103 = null;
    L5:
        GradientDrawable r104 = (GradientDrawable) r103;
        if (r104 == null) goto L8;
        r104.setColor(r100);
        r102.setBackgroundDrawable(r104);
    L8:
        ((PriceView) Z().b(R.id.pv_sku_hot_min_price).f()).setPriceTextColor(r100);
        ((PriceView) Z().b(R.id.pv_sku_hot_max_price).f()).setPriceTextColor(r100);
        ((TextView) Z().b(R.id.tv_sku_hot_price_divider).f()).setTextColor(r100);
    }

    public final void l0(int r100) {
        ((TextView) Z().b(R.id.pv_sku_first_supplement).f()).setTextColor(r100);
        ((TextView) Z().b(R.id.pv_sku_second_supplement).f()).setTextColor(r100);
        ((TextView) Z().b(R.id.pv_sku_origin_supplement).f()).setTextColor(r100);
    }
}
