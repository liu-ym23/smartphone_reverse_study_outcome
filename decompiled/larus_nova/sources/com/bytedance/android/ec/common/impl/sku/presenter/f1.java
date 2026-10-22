package com.bytedance.android.ec.common.impl.sku.presenter;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import com.android.ttcjpaysdk.base.theme.CJPayColorConstants;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.ec.base.api.ai.ECAIConstants;
import com.bytedance.android.ec.common.impl.sku.SkuViewModel;
import com.bytedance.android.ec.common.impl.sku.model.SkuDiscountDescText;
import com.bytedance.android.ec.common.impl.sku.model.SkuHighlightItem;
import com.bytedance.android.ec.common.impl.sku.model.SkuInfoVO;
import com.bytedance.android.ec.common.impl.sku.model.SkuItemInfoVO;
import com.bytedance.android.ec.core.abtest.ECSettingKeys;
import com.bytedance.android.ec.core.imagex.ImageExtensionsKt;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.ECQuickUtilKt;
import com.bytedance.android.ec.core.widget.PriceView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.SourceType;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.api.accessibility.AccessibilityDelegateCompatImpl;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.bytedance.applet.aibridge.ecommerce.api.OpenECommerceSource;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.kiwi.model.QModel;
import com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class f1 extends QFragmentPresenter {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SkuViewModel f43211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f43212g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f43213h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f43214i;

    public f1(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100);
        this.f43214i = "";
    }

    public static final String d0(f1 r210) {
        SkuViewModel r100 = r210.f43211f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        String r101 = r100.getSkuParams().getDetailUrl();
        if (r101 == null) goto L212;
        SkuViewModel r102 = r210.f43211f;
        if (r102 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L10:
        Map<String, String> r103 = r102.getSkuParams().getLiveEventParams();
        String r110 = "";
        if (r103 == null) goto L71;
        Map r104 = MapsKt.toMutableMap(r103);
        if (r104 == null) goto L71;
        SkuViewModel r105 = r210.f43211f;
        if (r105 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L17:
        Map<String, String> r106 = r105.getSkuParams().getEventParams();
        Object r111 = "1";
        if (r106 == null) goto L21;
        String r107 = r106.get("screen_type");
        if (r107 == null) goto L21;
    L22:
        r104.put("screen_type", r107);
        SkuViewModel r108 = r210.f43211f;
        if (r108 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        Map<String, String> r109 = r108.getSkuParams().getEventParams();
        if (r109 == null) goto L28;
        String r112 = r109.get(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY);
    L29:
        if (r112 != null) goto L31;
        r112 = "";
    L31:
        r104.put(com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY, r112);
        SkuViewModel r113 = r210.f43211f;
        if (r113 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L35:
        if (r113.isInDepositPresale() == false) goto L37;
        Object r114 = r111;
    L38:
        r104.put(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL, r114);
        SkuViewModel r115 = r210.f43211f;
        if (r115 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L41:
        Map<String, String> r116 = r115.getSkuParams().getEventParams();
        if (r116 == null) goto L44;
        String r117 = r116.get(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME);
    L45:
        if (r117 != null) goto L47;
        r117 = "";
    L47:
        r104.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r117);
        SkuViewModel r118 = r210.f43211f;
        if (r118 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L50:
        Map<String, String> r119 = r118.getSkuParams().getEventParams();
        if (r119 == null) goto L54;
        String r120 = r119.get("is_explaining");
        if (r120 == null) goto L54;
    L55:
        r104.put("is_explaining", r120);
        SkuViewModel r121 = r210.f43211f;
        if (r121 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L58:
        Map<String, String> r122 = r121.getSkuParams().getEventParams();
        if (r122 == null) goto L61;
        String r123 = r122.get(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS);
    L62:
        if (r123 != null) goto L64;
        r123 = "";
    L64:
        r104.put(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r123);
        SkuViewModel r124 = r210.f43211f;
        if (r124 != null) goto L67;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L67:
        String r125 = r124.getSkuParams().getTransmissibleJson();
        if (r125 != null) goto L70;
        r125 = "";
    L70:
        r104.put("transmissible_json", r125);
    L72:
        String r126 = com.bytedance.android.ec.common.impl.sku.utils.d.c(r101, "v3_events_additions", r104);
        String r127 = UriProtector.getQueryParameter(UriProtector.parse(r126), "meta_params");
        if (r127 != null) goto L75;
    L164:
        String r211 = com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY;
    L165:
        SkuViewModel r128 = r210.f43211f;
        if (r128 != null) goto L168;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L168:
        String r129 = com.bytedance.android.ec.common.impl.sku.utils.d.d(r126, "disable_live_window", String.valueOf(r128.getSkuParams().isFromPlayback()));
        Lazy r130 = ECAppInfoService.f48110a;
        if (ECAppInfoService.h() == false) goto L171;
        r129 = com.bytedance.android.ec.common.impl.sku.utils.d.d(r129, "request_page", ECAIConstants.SCENE_ECOM_PRODUCT);
    L171:
        SkuViewModel r131 = r210.f43211f;
        if (r131 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L174:
        Map<String, String> r132 = r131.getSkuParams().getEventParams();
        if (r132 == null) goto L177;
        String r133 = r132.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE);
    L178:
        String r134 = com.bytedance.android.ec.common.impl.sku.utils.d.d(r129, com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME_LIVE, r133);
        SkuViewModel r135 = r210.f43211f;
        if (r135 != null) goto L181;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L181:
        Map<String, String> r136 = r135.getSkuParams().getEventParams();
        if (r136 == null) goto L184;
        String r137 = r136.get(com.bytedance.android.ec.core.event.a.KEY_LABEL_NAME);
    L185:
        String r138 = com.bytedance.android.ec.common.impl.sku.utils.d.d(r134, "label_name_from_live", r137);
        SkuViewModel r139 = r210.f43211f;
        if (r139 != null) goto L188;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L188:
        Map<String, String> r140 = r139.getSkuParams().getEventParams();
        String r141 = r211;
        if (r140 == null) goto L191;
        String r142 = r140.get(r141);
    L192:
        String r143 = com.bytedance.android.ec.common.impl.sku.utils.d.d(com.bytedance.android.ec.common.impl.sku.utils.d.d(r138, r141, r142), PdpOpenThirdParam.KEY_PROMOTION_SOURCE, String.valueOf(SourceType.XIAO_DIAN.getType()));
        SkuViewModel r144 = r210.f43211f;
        if (r144 != null) goto L195;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L195:
        r144.setLastBehaviorBeforeDismiss("click");
        if (jg.h.f498946a.getActivity(r210.a0()) == null) goto L198;
        r110 = BtmSDK.INSTANCE.createBtmId(new BtmItemBuilder("a1.b5267.c6709.d2425", Boolean.FALSE).withView(r210.a0()).build());
    L198:
        String r145 = r110;
        SkuViewModel r146 = r210.f43211f;
        if (r146 != null) goto L201;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L201:
        Pair[] r147 = new Pair[2];
        SkuViewModel r148 = r210.f43211f;
        if (r148 != null) goto L204;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L204:
        SkuInfoVO r149 = r148.getSkuInfo().a();
        if (r149 == null) goto L207;
        Long r150 = r149.getDiscountPrice();
    L208:
        if (r150 == null) goto L210;
        Object r151 = r111;
    L211:
        r147[0] = TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_AVL_DISCOUNT, r151);
        r147[1] = TuplesKt.to("btm_id", r145);
        SkuViewModel.doSkuEventAction$default(r146, OpenECommerceSource.CLICK_PRODUCT_DETAIL, r147, null, null, null, 28, null);
        return com.bytedance.android.ec.core.btm.c.c(r143, r210.a0(), "a1.b5267.c6709.d2425", new Pair[0]);
    L210:
        r151 = "0";
        goto L211
    L207:
        r150 = null;
        goto L208
    L191:
        r142 = null;
        goto L192
    L184:
        r137 = null;
        goto L185
    L177:
        r133 = null;
        goto L178
    L75:
        if (r127.length() <= 0) goto L77;
        boolean r212 = true;
    L78:
        if (r212 == true) goto L81;
        r127 = null;
    L81:
        if (r127 == null) goto L164;
        JSONObject r152 = new JSONObject(r127);     // Catch: JSONException -> L161
        String r153 = r152.optString(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO);     // Catch: JSONException -> L161
        if (r153.length() <= 0) goto L85;
        boolean r213 = true;
    L86:
        if (r213 == true) goto L89;
        r153 = null;
    L89:
        if (r153 == null) goto L143;
        r211 = com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY;
        JSONObject r154 = new JSONObject(r153);     // Catch: JSONException -> L159
        r154.put(com.bytedance.android.ec.core.event.a.KEY_FROM_ENTRANCE, "live_sku_card");     // Catch: JSONException -> L159
        SkuViewModel r155 = r210.f43211f;     // Catch: JSONException -> L159
        if (r155 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L159
    L95:
        if (r155.isInDepositPresale() == false) goto L97;
        Object r156 = r111;
    L98:
        r154.put(com.bytedance.android.ec.core.event.a.KEY_UPFRONT_PRESELL, r156);     // Catch: JSONException -> L159
        SkuViewModel r157 = r210.f43211f;     // Catch: JSONException -> L159
        if (r157 != null) goto L101;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L159
    L101:
        SkuInfoVO r158 = r157.getSkuInfo().a();     // Catch: JSONException -> L159
        if (r158 != null) goto L104;
    L106:
        int r159 = 0;
    L107:
        r154.put(com.bytedance.android.ec.core.event.a.KEY_IS_UNDER_STOCK, r159);     // Catch: JSONException -> L159
        SkuViewModel r160 = r210.f43211f;     // Catch: JSONException -> L159
        if (r160 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L159
    L110:
        Map<String, String> r161 = r160.getSkuParams().getEventParams();     // Catch: JSONException -> L159
        if (r161 == null) goto L115;
        String r162 = r161.get(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY);     // Catch: JSONException -> L159
        if (r162 == null) goto L115;
    L116:
        r154.put(com.bytedance.android.ec.core.event.a.KEY_IS_EXPLAIN_APPLY, r162);     // Catch: JSONException -> L159
        SkuViewModel r163 = r210.f43211f;     // Catch: JSONException -> L159
        if (r163 != null) goto L119;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L159
    L119:
        Map<String, String> r164 = r163.getSkuParams().getEventParams();     // Catch: JSONException -> L159
        if (r164 == null) goto L122;
        String r165 = r164.get(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME);     // Catch: JSONException -> L159
    L123:
        if (r165 != null) goto L125;
        r165 = "";
    L125:
        r154.put(com.bytedance.android.ec.core.event.a.KEY_TAB_NAME, r165);     // Catch: JSONException -> L159
        SkuViewModel r166 = r210.f43211f;     // Catch: JSONException -> L159
        if (r166 != null) goto L128;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L159
    L128:
        Map<String, String> r167 = r166.getSkuParams().getEventParams();     // Catch: JSONException -> L159
        if (r167 == null) goto L132;
        String r168 = r167.get("is_explaining");     // Catch: JSONException -> L159
        if (r168 == null) goto L132;
    L133:
        r154.put("is_explaining", r168);     // Catch: JSONException -> L159
        SkuViewModel r169 = r210.f43211f;     // Catch: JSONException -> L159
        if (r169 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L159
    L136:
        Map<String, String> r170 = r169.getSkuParams().getEventParams();     // Catch: JSONException -> L159
        if (r170 == null) goto L139;
        String r171 = r170.get(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS);     // Catch: JSONException -> L159
    L140:
        if (r171 != null) goto L142;
        r171 = "";
    L142:
        r154.put(com.bytedance.android.ec.core.event.a.KEY_CARD_STATUS, r171);     // Catch: JSONException -> L159
        r152.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r154.toString());     // Catch: JSONException -> L159
    L144:
        r126 = com.bytedance.android.ec.common.impl.sku.utils.d.b(r126, "meta_params", r152.toString());     // Catch: JSONException -> L159
        SkuViewModel r172 = r210.f43211f;     // Catch: JSONException -> L159
        if (r172 != null) goto L147;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");     // Catch: JSONException -> L159
    L147:
        String r173 = r172.getSkuParams().getSkuLogExtra();     // Catch: JSONException -> L159
        if (r173 == null) goto L165;
        if (r173.length() <= 0) goto L152;
        boolean r174 = true;
    L153:
        if (r174 == true) goto L156;
        r173 = null;
    L156:
        if (r173 == null) goto L165;
        JSONObject r175 = new JSONObject(r173);     // Catch: JSONException -> L159
        r126 = com.bytedance.android.ec.common.impl.sku.utils.d.a(r126, new Pair[]{new Pair(com.bytedance.android.ec.core.event.a.KEY_FXH_WHITE_LIST_FLAG, r175.optString(com.bytedance.android.ec.core.event.a.KEY_FXH_WHITE_LIST_FLAG)), new Pair(com.bytedance.android.ec.core.event.a.KEY_USER_OPEN_FXH_FLAG, r175.optString(com.bytedance.android.ec.core.event.a.KEY_USER_OPEN_FXH_FLAG)), new Pair(com.bytedance.android.ec.core.event.a.KEY_BIND_CARD_FLAG, r175.optString(com.bytedance.android.ec.core.event.a.KEY_BIND_CARD_FLAG)), new Pair(com.bytedance.android.ec.core.event.a.KEY_SHOP_OPEN_FLAG, r175.optString(com.bytedance.android.ec.core.event.a.KEY_SHOP_OPEN_FLAG))});     // Catch: JSONException -> L159
        goto L165
    L152:
        r174 = false;
        goto L153
    L139:
        r171 = null;
    L132:
        r168 = "0";
        goto L133
    L122:
        r165 = null;
    L115:
        r162 = "0";
        goto L116
    L104:
        if (r158.isUnderStock() != true) goto L106;
        r159 = 1;
        goto L107
    L97:
        r156 = "0";
    L159:
        e = e;
    L163:
        ECExceptionMonitor.e(e);
        Unit r176 = Unit.INSTANCE;
        goto L165
    L143:
        r211 = com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY;
        goto L144
    L85:
        r213 = false;
    L161:
        e = e;
        r211 = com.bytedance.android.ec.core.event.a.KEY_BASE_VERIFIED_CATEGORY;
        goto L163
    L77:
        r212 = false;
        goto L78
    L61:
        r123 = null;
    L54:
        r120 = "0";
        goto L55
    L44:
        r117 = null;
        goto L45
    L37:
        r114 = "0";
        goto L38
    L28:
        r112 = null;
    L21:
        r107 = "0";
    L71:
        r111 = "1";
        r104 = null;
        goto L72
    L212:
        return null;
    }

    public static final /* synthetic */ SkuViewModel e0(f1 r100) {
        SkuViewModel r101 = r100.f43211f;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        return r101;
    }

    public static final void i0(f1 r110) {
        SkuViewModel r100 = r110.f43211f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r101 = r100.getSkuInfo().a();
        if (r101 == null) goto L191;
        SkuViewModel r102 = r110.f43211f;
        if (r102 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L11:
        Long r103 = r102.m8148getCurrentPrice().a();
        if (r103 == null) goto L14;
        long r104 = r103.longValue();
    L15:
        SkuViewModel r105 = r110.f43211f;
        if (r105 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L18:
        long r106 = r105.getCurrentOriginPrice();
        SkuViewModel r107 = r110.f43211f;
        if (r107 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L21:
        long r111 = r107.getCurrentDiscountPrice();
        SkuViewModel r108 = r110.f43211f;
        if (r108 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L24:
        String r109 = r108.getCurrentDiscountPriceText();
        String r112 = "";
        if (r109 != null) goto L27;
        r109 = "";
    L27:
        SkuViewModel r113 = r110.f43211f;
        if (r113 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L30:
        String r114 = r113.getCurrentCampainPriceHeader();
        SkuViewModel r115 = r110.f43211f;
        if (r115 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L33:
        Integer r116 = r115.getCurrentCampainPriceHeaderStyle();
        String r117 = r101.getPriceHeader();
        if (r104 <= 0) goto L37;
        r117 = r114;
    L37:
        if (r116 != null) goto L40;
    L41:
        Integer r118 = r101.getPriceHeaderStyle();
        if (r118 != null) goto L45;
    L46:
        Query r119 = r110.Z();
        int r120 = R.id.pv_sku_price;
        ((PriceView) r119.b(R.id.pv_sku_price).f()).setPrefixText(r117);
    L48:
        ((PriceView) r110.Z().b(r120).f()).C(HeaderPresenter$updatePrice$1.INSTANCE);
        TextView r121 = (TextView) r110.Z().b(R.id.sku_price_header).f();
        r121.setVisibility(8);
        if (r116 != null) goto L51;
        int r122 = 1;
    L53:
        Integer r123 = r101.getPriceHeaderStyle();
        if (r123 != null) goto L57;
    L68:
        int r124 = 0;
    L77:
        CharSequence r125 = null;
        if (r104 <= 0) goto L111;
        r110.m0(r104, null, r124);
        SkuViewModel r126 = r110.f43211f;
        if (r126 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L83:
        if (r126.isInDepositPresale() == false) goto L85;
    L92:
        ((PriceView) r110.Z().b(R.id.pv_sku_origin_price).f()).setVisibility(8);
    L94:
        if (1 <= r111) goto L97;
    L105:
        boolean r127 = true;
    L106:
        boolean r128 = false;
    L107:
        if (r128 == false) goto L109;
        r110.k0(r111, r109, r127);
    L159:
        RelativeLayout r129 = (RelativeLayout) r110.Z().b(R.id.rl_sku_price_container).f();
        LinearLayout r130 = (LinearLayout) r110.Z().b(R.id.ll_sku_first_container).f();
        LinearLayout r131 = (LinearLayout) r110.Z().b(R.id.ll_sku_price_container).f();
        LinearLayout r132 = (LinearLayout) r110.Z().b(R.id.ll_sku_sec_kill_wrapper).f();
        if (r110.Z().b(R.id.layout_discount_price_container).f().getVisibility() != 0) goto L162;
        int r133 = r110.j0(R.id.layout_discount_price_container);
    L164:
        if (((r110.j0(R.id.rl_sku_price_container) + r133) + vf4.a.b(Float.valueOf(166.0f))) <= UIUtils.getScreenWidth(r110.Y().c())) goto L177;
        if ((!Intrinsics.areEqual(r129.getParent(), r130)) == false) goto L183;
        r131.removeView(r129);
        r130.addView(r129, 1);
        ViewGroup.LayoutParams r134 = r129.getLayoutParams();
        if (r134 == null) goto L175;
        ((LinearLayout.LayoutParams) r134).setMargins(0, 0, 0, 0);
        if (r132.getVisibility() != 0) goto L172;
        int r135 = r110.j0(R.id.ll_sku_sec_kill_wrapper) + vf4.a.b(Float.valueOf(10.0f));
    L173:
        ((PriceView) r110.Z().b(R.id.pv_sku_price).f()).setMaxWidth(r130.getMeasuredWidth() - r135);
        goto L183
    L172:
        r135 = 0;
        goto L173
    L175:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L183:
        View r136 = r110.Z().b(R.id.sku_header_container).f();
        AccessibilityDelegateCompatImpl r137 = new AccessibilityDelegateCompatImpl(r136);
        if (ECSettingKeys.J0() == true) goto L189;
        StringBuilder r138 = new StringBuilder();
        r138.append(com.bytedance.android.ec.core.widget.d0.b((PriceView) r110.Z().b(R.id.pv_sku_price).f()));
        r138.append(((TextView) r110.Z().b(R.id.tv_sku_discount_price_text).f()).getText());
        r138.append(com.bytedance.android.ec.core.widget.d0.b((PriceView) r110.Z().b(R.id.tv_sku_discount_price).f()));
        View r139 = r110.Z().b(R.id.tv_sku_total).f450937b;
        if ((r139 instanceof TextView) == false) goto L188;
        r125 = ((TextView) r139).getText();
    L188:
        r138.append(r125);
        Unit r140 = Unit.INSTANCE;
        r137.f170190b = r138.toString();
    L189:
        ViewCompat.setAccessibilityDelegate(r136, r137);
        return;
    L177:
        if ((!Intrinsics.areEqual(r129.getParent(), r131)) == false) goto L183;
        r130.removeView(r129);
        r131.addView(r129, 0);
        ViewGroup.LayoutParams r141 = r129.getLayoutParams();
        if (r141 == null) goto L182;
        ((LinearLayout.LayoutParams) r141).setMargins(0, 0, vf4.a.b(Float.valueOf(6.0f)), 0);
        ((PriceView) r110.Z().b(R.id.pv_sku_price).f()).setMaxWidth(0.0f);
        goto L183
    L182:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L162:
        r133 = 0;
        goto L164
    L109:
        r110.Z().b(R.id.layout_discount_price_container).f().setVisibility(8);
        goto L159
    L97:
        if (r104 <= r111) goto L105;
        if (r109.length() <= 0) goto L101;
        boolean r142 = true;
    L102:
        r127 = true;
        if (r142 != true) goto L106;
        r128 = true;
        goto L107
    L101:
        r142 = false;
        goto L102
    L85:
        if (r109.length() != 0) goto L87;
        boolean r143 = true;
    L88:
        if (r143 == false) goto L92;
        if (r106 <= 0) goto L92;
        PriceView r144 = (PriceView) r110.Z().b(R.id.pv_sku_origin_price).f();
        r144.setPriceText(jg.b.b(r106));
        r144.setVisibility(0);
        goto L94
    L87:
        r143 = false;
        goto L88
    L111:
        if (r101.getMaxPrice() > 0) goto L113;
    L115:
        r110.m0(r101.getMinPrice(), null, 0);
    L116:
        Long r145 = r101.getDiscountPrice();
        if (r145 == null) goto L119;
        long r146 = r145.longValue();
    L120:
        long r147 = r101.getMinPrice();
        String r148 = r101.getDiscountPriceHeader();
        if (1 <= r146) goto L124;
    L133:
        int r149 = 1;
    L134:
        boolean r150 = false;
    L136:
        if (r101.getShowPriceStyle() == r149) goto L140;
        if (r150 == true) goto L140;
        r110.Z().b(R.id.layout_discount_price_container).f().setVisibility(8);
    L147:
        SkuViewModel r151 = r110.f43211f;
        if (r151 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L151:
        if (r151.isInDepositPresale() == true) goto L158;
        if (r150 == true) goto L158;
        if (r101.getShowPriceStyle() == 1) goto L158;
        if (r101.getMarketPrice() <= 0) goto L158;
        PriceView r152 = (PriceView) r110.Z().b(R.id.pv_sku_origin_price).f();
        r152.setVisibility(0);
        int r153 = jg.b.f498941a;
        r152.setPriceText(jg.b.b(r101.getMarketPrice()));
    L158:
        ((PriceView) r110.Z().b(R.id.pv_sku_origin_price).f()).setVisibility(8);
    L140:
        SkuViewModel r154 = r110.f43211f;
        if (r154 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L143:
        r154.setCurrentDiscountPrice(r146);
        SkuViewModel r155 = r110.f43211f;
        if (r155 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L146:
        r155.setCurrentDiscountPriceText(r101.getDiscountPriceHeader());
        r110.k0(r146, r101.getDiscountPriceHeader(), false);
        goto L147
    L124:
        if (r147 <= r146) goto L133;
        if (r148 == null) goto L133;
        if (r148.length() <= 0) goto L129;
        boolean r156 = true;
    L130:
        r149 = 1;
        if (r156 != true) goto L134;
        r150 = true;
        goto L136
    L129:
        r156 = false;
        goto L130
    L119:
        r146 = 0;
        goto L120
    L113:
        if (r101.getMaxPrice() <= r101.getMinPrice()) goto L115;
        r110.m0(r101.getMinPrice(), Long.valueOf(r101.getMaxPrice()), r101.getShowPriceStyle());
        goto L116
    L57:
        if (r123.intValue() != r122) goto L68;
        SkuViewModel r157 = r110.f43211f;
        if (r157 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L62:
        if (r157.isInSecKill() == true) goto L68;
    L63:
        if (r116 != null) goto L66;
    L69:
        if (r116 != null) goto L72;
    L76:
        r124 = 0;
        r121.setText(r101.getPriceHeader());
        r121.setVisibility(0);
        goto L77
    L72:
        if (r116.intValue() != 1) goto L76;
        if (r114 == null) goto L75;
        r112 = r114;
    L75:
        r121.setText(r112);
        r124 = 0;
        r121.setVisibility(0);
        goto L77
    L66:
        if (r116.intValue() != 0) goto L69;
        r121.setVisibility(8);
        goto L68
    L51:
        r122 = 1;
        if (r116.intValue() == 1) goto L63;
    L45:
        if (r118.intValue() != 1) goto L46;
    L47:
        r120 = R.id.pv_sku_price;
        goto L48
    L40:
        if (r116.intValue() == 1) goto L47;
    L14:
        r104 = 0;
        goto L15
    }

    @Override // com.ss.android.ugc.aweme.kiwi.presenter.QFragmentPresenter
    public final void b0(QModel r100) {
        this.f43211f = (SkuViewModel) Y().g(SkuViewModel.class);
        if (ECAppInfoService.f48114e.f() == false) goto L10;
        ViewGroup.LayoutParams r101 = Z().b(R.id.sdv_sku_right_container).f().getLayoutParams();
        if ((r101 instanceof ConstraintLayout.LayoutParams) == true) goto L7;
        r101 = null;
    L7:
        ConstraintLayout.LayoutParams r102 = (ConstraintLayout.LayoutParams) r101;
        if (r102 == null) goto L10;
        r102.bottomToBottom = -1;
    L10:
        View r103 = Z().b(R.id.sdv_sku_select_pop_cover).f();
        AccessibilityDelegateCompatImpl r104 = new AccessibilityDelegateCompatImpl(r103);
        r104.f170190b = "商品图片";
        ViewCompat.setAccessibilityDelegate(r103, r104);
        ImageExtensionsKt.D((GenericDraweeView) Z().b(R.id.sdv_sku_select_pop_cover).f(), new com.bytedance.android.ec.core.imagex.r("ec_sku", "ec_sku_product_image"));
        ((SimpleDraweeView) Z().b(R.id.sdv_sku_select_pop_cover).f()).setOnClickListener(new e1(this));
        SkuViewModel r105 = this.f43211f;
        if (r105 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L13:
        r105.m8148getCurrentPrice().b(ECQuickUtilKt.a(Y()), new t0(this));
        SkuViewModel r106 = this.f43211f;
        if (r106 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        r106.getCurrentDouInstallmentItem().b(ECQuickUtilKt.a(Y()), new u0(this));
        SkuViewModel r107 = this.f43211f;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L19:
        r107.getValidInstallmentInfo().b(ECQuickUtilKt.a(Y()), new v0(this));
        SkuViewModel r108 = this.f43211f;
        if (r108 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        r108.getCurrentStock().b(ECQuickUtilKt.a(Y()), new w0(this));
        SkuViewModel r109 = this.f43211f;
        if (r109 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L25:
        r109.getCurrentAvatar().b(ECQuickUtilKt.a(Y()), new x0(this));
        SkuViewModel r110 = this.f43211f;
        if (r110 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L28:
        r110.m8147getCurrentCount().b(ECQuickUtilKt.a(Y()), new y0(this));
        SkuViewModel r111 = this.f43211f;
        if (r111 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L31:
        r111.getCheckedNames().b(ECQuickUtilKt.a(Y()), new z0(this));
        SkuViewModel r112 = this.f43211f;
        if (r112 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L34:
        r112.getOnItemChange().b(Y().e(), new a1(this));
        SkuViewModel r113 = this.f43211f;
        if (r113 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L37:
        r113.getSkuInfo().b(ECQuickUtilKt.a(Y()), new d1(this));
    }

    public final int j0(int r100) {
        View r101 = Z().b(r100).f();
        r101.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        return r101.getMeasuredWidth();
    }

    public final void l0(String r110) {
        SkuViewModel r100 = this.f43211f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r101 = r100.getSkuInfo().a();
        ViewGroup.LayoutParams r102 = null;
        if (r101 == null) goto L10;
        Map<String, SkuItemInfoVO> r103 = r101.getSkuList();
        if (r103 == null) goto L10;
        SkuItemInfoVO r111 = r103.get(r110);
    L11:
        if (r111 == null) goto L13;
        Boolean r104 = Boolean.valueOf(r111.isSecKill());
        Boolean r105 = Boolean.valueOf(r111.isDepositPresale());
        ECUrlModel r106 = r111.getActivityIcon();
        Integer r107 = r111.getCampaignSubType();
        String r108 = r111.getAtmosphereHeader();
        long r109 = r111.getDepositPrice();
    L29:
        View r112 = Z().b(R.id.ll_sku_sec_kill_wrapper).f();
        Boolean r113 = Boolean.TRUE;
        if (Intrinsics.areEqual(r104, r113) == false) goto L33;
        if (r106 != null) goto L33;
        int r114 = 0;
    L34:
        r112.setVisibility(r114);
        if (Intrinsics.areEqual(r104, r113) == false) goto L43;
        if (r107 != null) goto L38;
    L39:
        Z().b(R.id.sec_kill_image).g(0);
        Query r115 = Z().b(R.id.sec_kill_text);
        View r116 = r115.f450937b;
        if ((r116 instanceof TextView) == false) goto L42;
        ((TextView) r116).setText(R.string.shopping_sku_seckill);
    L42:
        r115.g(0);
    L52:
        SimpleDraweeView r117 = (SimpleDraweeView) Z().b(R.id.sku_sv_activity_icon).f();
        if (r106 == null) goto L62;
        r117.setVisibility(0);
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
        if ((r118 instanceof LinearLayout.LayoutParams) == false) goto L58;
        r102 = r118;
    L58:
        LinearLayout.LayoutParams r119 = (LinearLayout.LayoutParams) r102;
        if (r119 == null) goto L61;
        r119.width = vf4.a.b(Integer.valueOf(r106.getWidth()));
        r119.height = vf4.a.b(Integer.valueOf(r106.getHeight()));
        r117.setLayoutParams(r119);
    L61:
        com.bytedance.android.ec.core.utils.y.a(r117, r106);
    L64:
        if (Intrinsics.areEqual(r105, r113) == false) goto L69;
        TextView r120 = (TextView) Z().b(R.id.tv_sku_deposit_price).f();
        r120.setVisibility(0);
        String r121 = jg.b.b(r109);
        if (r121 != null) goto L68;
        r121 = "";
    L68:
        r120.setText(ag4.a.a(R.string.shopping_presale_deposit_price, CollectionsKt.listOf(r121)));
        return;
    L69:
        ((TextView) Z().b(R.id.tv_sku_deposit_price).f()).setVisibility(8);
        return;
    L62:
        r117.setVisibility(8);
        goto L64
    L38:
        if (r107.intValue() == 0) goto L39;
    L43:
        Z().b(R.id.sec_kill_image).g(8);
        if (r108 != null) goto L46;
    L51:
        Z().b(R.id.ll_sku_sec_kill_wrapper).g(8);
        Z().b(R.id.sec_kill_text).g(8);
        goto L52
    L46:
        if ((!StringsKt.isBlank(r108)) == true) goto L49;
        r108 = null;
    L49:
        if (r108 == null) goto L51;
        Z().b(R.id.ll_sku_sec_kill_wrapper).g(0);
        Query r122 = Z().b(R.id.sec_kill_text);
        r122.e(r108);
        r122.g(0);
    L33:
        r114 = 8;
        goto L34
    L13:
        SkuViewModel r123 = this.f43211f;
        if (r123 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L16:
        SkuInfoVO r124 = r123.getSkuInfo().a();
        r104 = Boolean.valueOf(this.f43212g);
        r105 = Boolean.valueOf(this.f43213h);
        if (r124 == null) goto L19;
        r106 = r124.getActivityIcon();
    L20:
        if (r124 == null) goto L22;
        r107 = r124.getCampaignSubType();
    L23:
        if (r124 == null) goto L25;
        r108 = r124.getAtmosphereHeader();
    L26:
        if (r124 == null) goto L28;
        r109 = r124.getDepositPrice();
        goto L29
    L28:
        r109 = 0;
        goto L29
    L25:
        r108 = null;
        goto L26
    L22:
        r107 = null;
        goto L23
    L19:
        r106 = null;
    L10:
        r111 = null;
        goto L11
    }

    public static final SpannableStringBuilder h0(f1 r100, SkuDiscountDescText r101) {
        r100.getClass();
        if (r101 == null) goto L17;
        if (r101.getText() == null) goto L17;
        SpannableStringBuilder r102 = new SpannableStringBuilder(r101.getText());
        List<SkuHighlightItem> r103 = r101.getHighlightItems();
        if (r103 == null) goto L25;
        Iterator<T> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L26;
        SkuHighlightItem r105 = (SkuHighlightItem) r104.next();
        Integer r106 = r105.getStartIndex();
        Integer r107 = r105.getEndIndex();
        if (r106 == null) goto L11;
        if (r107 == null) goto L11;
        int r108 = r107.intValue();
        int r109 = r106.intValue();
        r102.setSpan(new ForegroundColorSpan(ColorProtector.parseColor(CJPayColorConstants.CJ_PAY_RED)), r109, r108, 17);
        goto L11
    L26:
        return r102;
    L25:
        return r102;
    L17:
        return new SpannableStringBuilder("");
    }

    public final void k0(long r110, String r111, boolean r112) {
        SkuViewModel r100 = this.f43211f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L5:
        SkuInfoVO r101 = r100.getSkuInfo().a();
        if (r101 != null) goto L8;
        return;
    L8:
        boolean r102 = false;
        Z().b(R.id.layout_discount_price_container).f().setVisibility(0);
        ((PriceView) Z().b(R.id.pv_sku_origin_price).f()).setVisibility(8);
        ((TextView) Z().b(R.id.tv_sku_discount_price_text).f()).setText(r111);
        String r113 = jg.b.b(r110);
        if (r112 == false) goto L11;
    L15:
        String r114 = "";
    L16:
        PriceView r103 = (PriceView) Z().b(R.id.tv_sku_discount_price).f();
        r103.setPriceText(r113);
        r103.setExtraText(r114);
        if (r111 != null) goto L19;
    L20:
        r102 = true;
    L21:
        if (r102 == true) goto L23;
        View r115 = Z().b(R.id.layout_discount_price_container).f();
        r115.setContentDescription(r111 + r113 + th.a.g(Y().c(), R.string.shopping_currency_yuan) + r114);
        r115.setFocusable(true);
        ((TextView) Z().b(R.id.tv_sku_discount_price_text).f()).setImportantForAccessibility(2);
        ((PriceView) Z().b(R.id.tv_sku_discount_price).f()).setImportantForAccessibility(2);
        return;
    L23:
        Z().b(R.id.layout_discount_price_container).f().setContentDescription(null);
        return;
    L19:
        if (StringsKt.isBlank(r111) == false) goto L21;
    L11:
        if (r101.getMaxPrice() == r101.getMinPrice()) goto L15;
        if (r101.getShowPriceStyle() == 1) goto L15;
        r114 = th.a.g(Y().c(), R.string.shopping_tip_price_append_text);
        goto L16
    }

    public final void m0(long r100, Long r101, int r102) {
        PriceView r103 = (PriceView) Z().b(R.id.pv_sku_price).f();
        if (r101 != null) goto L5;
    L8:
        r103.setExtraText(null);
    L9:
        r103.setPriceText(jg.b.b(r100));
        if (r102 != 1) goto L15;
        if (r101 == null) goto L15;
        if (r101.longValue() <= r100) goto L15;
        r103.setMaxPriceText(jg.b.b(r101.longValue()));
        return;
    L15:
        r103.setMaxPriceText(null);
        return;
    L5:
        if (r101.longValue() == r100) goto L8;
        if (r102 != 0) goto L8;
        r103.setExtraText(th.a.g(Y().c(), R.string.shopping_tip_price_append_text));
        goto L9
    }
}
