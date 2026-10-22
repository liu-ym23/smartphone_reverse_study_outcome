package com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.PromotionBenefitType;
import com.bytedance.android.ec.model.response.b0;
import com.bytedance.android.ec.model.response.i0;
import com.bytedance.android.ec.model.response.o0;
import com.bytedance.android.ec.model.response.p0;
import com.bytedance.android.livesdk.livecommerce.ab.ECLiveABUtils;
import com.bytedance.android.livesdk.livecommerce.promotion.card.IPromotionUIConfig;
import com.bytedance.android.livesdk.livecommerce.promotion.card.PromotionCardModuleName;
import com.bytedance.android.livesdk.livecommerce.promotion.card.k;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.UIConfigHelper;
import com.bytedance.android.livesdk.livecommerce.promotion.card.utils.d;
import com.bytedance.android.livesdk.livecommerce.promotion.card.view.CountDownView;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.LivePromotionCardArgsV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECBenefitLabelView;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECBenefitLabelViewV2;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECFlashMaterialWidget;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECStockProgressLayout;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.ECUserRightsTagWidget;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.g;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.h;
import com.bytedance.android.livesdk.livecommerce.promotion.cardV2.info.widget.m;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotion/cardV2/info/PromotionCardInfoLineContainer;", "Landroid/widget/LinearLayout;", "", "", "getLineContentDescription", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PromotionCardInfoLineContainer extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, a> f150570a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a f150571b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LivePromotionCardArgsV2 f150572c;

    public PromotionCardInfoLineContainer(Context r100) {
        this(r100, null, null, null, 30);
    }

    public PromotionCardInfoLineContainer(Context r100, AttributeSet r101) {
        this(r100, r101, null, null, 28);
    }

    public final String getLineContentDescription() {
        StringBuilder r100 = new StringBuilder();
        List<View> r101 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if ((r104 instanceof a) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        Iterator r105 = r102.iterator();
    L10:
        if (r105.hasNext() == false) goto L13;
        r100.append(((a) r105.next()).getCurrentContentDescription());
        goto L10
    L13:
        return r100.toString();
    }

    public final void d() {
        List<View> r100 = com.bytedance.commerce.base.view.b.a(this);
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Object r103 = r102.next();
        if ((r103 instanceof a) == false) goto L4;
        r101.add(r103);
        goto L4
    L8:
        Iterator r104 = r101.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        ((a) r104.next()).release();
        goto L10
    }

    public final <T extends a> T c(String r100, Function0<? extends T> r101) {
        if (ECLiveABUtils.INSTANCE.getLIST_FPS_OPT_CONFIG().getEnableOpt() == false) goto L19;
        T r102 = (T) ((LinkedHashMap) this.f150570a).get(r100);
        if (r102 == null) goto L17;
        ViewParent r103 = null;
        if ((r102 instanceof View) == true) goto L9;
        Object r104 = null;
    L10:
        View r105 = (View) r104;
        if (r105 == null) goto L13;
        r103 = r105.getParent();
    L13:
        if (r103 == null) goto L16;
        r102 = r101.invoke();
        this.f150570a.put(r100, r102);
    L16:
        if (r102 == null) goto L17;
        return r102;
    L9:
        r104 = r102;
    L17:
        T r106 = r101.invoke();
        this.f150570a.put(r100, r106);
        return r106;
    L19:
        return r101.invoke();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void a(a r100, int r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "widget");
        if ((r100 instanceof View) == false) goto L11;
        View r103 = (View) r100;
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(r101, -2);
        if (r102 == false) goto L7;
    L9:
        Unit r105 = Unit.INSTANCE;
        addView(r103, r104);
        return;
    L7:
        if (r101 == (-1)) goto L9;
        r104.setMarginStart(UtilityKotlinExtentionsKt.d(4));
        goto L9
    }

    public final void b(i0 r210, final boolean r310, final long r311, final k r312) {
        Intrinsics.checkNotNullParameter(r210, "linePromotionBenefit");
        Intrinsics.checkNotNullParameter(r312, "uiConfig");
        List<ECRitTag> r110 = null;
        if (Intrinsics.areEqual(null, r210) == false) goto L5;
        return;
    L5:
        d();
        removeAllViews();
        List<p0> r100 = r210.a();
        if (r100 == null) goto L231;
        Iterator<T> r111 = r100.iterator();
        int r112 = 0;
        int r113 = 0;
    L9:
        if (r111.hasNext() == false) goto L251;
        Object r101 = r111.next();
        int r114 = r113 + 1;
        if (r113 >= 0) goto L13;
        CollectionsKt.throwIndexOverflow();
    L13:
        final p0 r115 = (p0) r101;
        PromotionBenefitType r102 = r115.b();
        if (r102 == null) goto L215;
        int r103 = b.f150573a[r102.ordinal()];
        boolean r104 = true;
        if (r103 != 1) goto L19;
        List<ECRitTag> r105 = r110;
        m r106 = (m) c("tag_and_sales_point", new PromotionCardInfoLineContainer$bindData$$inlined$forEachIndexed$lambda$1(this, r310, r311, r312));
        if (r113 == 0) goto L227;
        r104 = false;
    L227:
        a(r106, -2, r104);
        b0 r107 = r115.d();
        if (r107 == null) goto L230;
        r106.a(r107, r310, r311, r312);
    L230:
        r110 = r105;
        r113 = r114;
        r112 = 0;
        goto L9
    L19:
        if (r103 != 2) goto L21;
        r105 = r110;
        ECUserRightsTagWidget r108 = (ECUserRightsTagWidget) c("user_right_tag_widget", new PromotionCardInfoLineContainer$bindData$$inlined$forEachIndexed$lambda$2(this, r310, r311, r312));
        if (r113 == 0) goto L220;
        r104 = false;
    L220:
        a(r108, -2, r104);
        List<ECRitTag> r109 = r115.f();
        if (r109 == null) goto L230;
        r108.a(r109, r312);
        goto L230
    L21:
        if (r103 == 3) goto L129;
        if (r103 != 4) goto L24;
        final LivePromotionCardArgsV2 r116 = this.f150572c;
        if (r116 == null) goto L215;
        final int r117 = r113;
        h r118 = (h) c("seckill_bar_widget", new PromotionCardInfoLineContainer$bindData$$inlined$forEachIndexed$lambda$4(r116, r117, r115, this, r310, r311, r312));
        if (r113 != 0) goto L74;
        boolean r119 = true;
    L75:
        a(r118, -1, r119);
        o0 r120 = r115.e();
        if (r120 == null) goto L215;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r120, "progressBar");
        Intrinsics.checkNotNullParameter(r312, "uiConfig");
        if (Intrinsics.areEqual(r118.f150644a, r120) == true) goto L215;
        r118.f150644a = r120;
        IPromotionUIConfig.d r121 = r312.a(PromotionCardModuleName.InfoAreaSecKillTextModule);
        if (r121 == null) goto L104;
        IPromotionUIConfig.b r122 = r121.a();
        if (r122 == null) goto L104;
        CountDownView r123 = (CountDownView) r118.findViewById(R.id.countdown_view);
        if (r123 == null) goto L87;
        r123.c(r122);
    L87:
        ECStockProgressLayout r124 = (ECStockProgressLayout) r118.findViewById(R.id.campaign_progress);
        if (r124 == null) goto L104;
        TextView r125 = r124.f150623b;
        if (r125 == null) goto L92;
        UIConfigHelper.c(r125, r122);
    L92:
        TextView r126 = r124.f150625d;
        if (r126 == null) goto L95;
        UIConfigHelper.c(r126, r122);
    L95:
        Float r127 = Float.valueOf(r122.e());
        if (r127.floatValue() <= r112) goto L98;
        boolean r128 = true;
    L99:
        if (r128 == true) goto L102;
        r127 = null;
    L102:
        if (r127 == null) goto L104;
        r124.f150629h = r127.floatValue();
        goto L104
    L98:
        r128 = false;
    L104:
        IPromotionUIConfig.d r129 = r312.a(PromotionCardModuleName.InfoAreaSecKillModule);
        if (r129 == null) goto L121;
        IPromotionUIConfig.c r130 = r129.b();
        if (r130 == null) goto L121;
        Integer r131 = Integer.valueOf(r130.c());
        if (r131.intValue() <= 0) goto L111;
        boolean r132 = true;
    L112:
        if (r132 == true) goto L115;
        r131 = null;
    L115:
        if (r131 == null) goto L121;
        int r133 = r131.intValue();
        ECStockProgressLayout r134 = (ECStockProgressLayout) r118.findViewById(R.id.campaign_progress);
        if (r134 == null) goto L121;
        ViewGroup.LayoutParams r135 = r134.getLayoutParams();
        if (r135 == null) goto L121;
        r135.height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r133));
        r134.setLayoutParams(r135);
        goto L121
    L111:
        r132 = false;
    L121:
        ECStockProgressLayout r136 = (ECStockProgressLayout) r118.findViewById(R.id.campaign_progress);
        String r137 = r120.b();
        Long r138 = r120.c();
        if (r138 == null) goto L124;
        Float r139 = Float.valueOf(r138.longValue());
    L125:
        r136.c(r137, r139, r120.d());
        if (r120.a() == null) goto L128;
        r118.f150647d.f150038b.a();
        d.f150309a.a(r118.f150645b);
        goto L215
    L128:
        r118.findViewById(R.id.countdown_view).setVisibility(4);
        r118.f150647d.f150038b.a();
        d.f150309a.b(r118.f150645b);
        Unit r140 = Unit.INSTANCE;
        goto L215
    L124:
        r139 = null;
        goto L125
    L74:
        r119 = false;
        goto L75
    L24:
        if (r103 != 5) goto L215;
        ECFlashMaterialWidget r141 = (ECFlashMaterialWidget) c("flash_material_info", new PromotionCardInfoLineContainer$bindData$$inlined$forEachIndexed$lambda$5(this, r310, r311, r312));
        if (r113 != 0) goto L29;
        boolean r142 = true;
    L30:
        a(r141, -2, r142);
        List<ECRitTag> r143 = r115.c();
        if (r143 == null) goto L215;
        r141.getClass();
        Intrinsics.checkNotNullParameter(r143, "tagList");
        Intrinsics.checkNotNullParameter(r312, "uiConfig");
        if ((!r143.isEmpty()) == true) goto L36;
        r143 = r110;
    L36:
        if (r143 == null) goto L215;
        ArrayList r144 = new ArrayList();
        Iterator<T> r145 = r143.iterator();
    L39:
        if (r145.hasNext() == false) goto L44;
        String r146 = ((ECRitTag) r145.next()).getFirstText();
        if (r146 == null) goto L39;
        r144.add(r146);
        goto L39
    L44:
        if ((!Intrinsics.areEqual(r141.f150606a, r144)) == false) goto L215;
        r141.f150606a = r144;
        r141.removeAllViews();
        r141.f150607b = new StringBuilder();
        Iterator r147 = r144.iterator();
        int r148 = 0;
    L47:
        if (r147.hasNext() == false) goto L67;
        Object r149 = r147.next();
        int r150 = r148 + 1;
        if (r148 >= 0) goto L51;
        CollectionsKt.throwIndexOverflow();
    L51:
        String r151 = (String) r149;
        if (r148 != 0) goto L59;
        TextView r152 = r141.a(r151, r112);
        IPromotionUIConfig.d r153 = r312.a(PromotionCardModuleName.InfoAreaSalePointModule);
        if (r153 == null) goto L58;
        IPromotionUIConfig.b r154 = r153.a();
        if (r154 == null) goto L58;
        UIConfigHelper.c(r152, r154);
    L58:
        Unit r155 = Unit.INSTANCE;
        r141.addView(r152);
    L65:
        r148 = r150;
        goto L47
    L59:
        View r156 = new View(r141.getContext());
        r156.setTag(ItemStyle.ITEM_STYLE_DIVIDER);
        r156.setBackgroundColor(th.a.a(r156.getContext(), R.color.shopping_std_line_black_1));
        r141.setGravity(16);
        LinearLayout.LayoutParams r157 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.d(Float.valueOf(0.5f)), UtilityKotlinExtentionsKt.d(Float.valueOf(8.0f)));
        r157.leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(4.0f));
        r157.topMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(1.0f));
        Unit r158 = Unit.INSTANCE;
        r156.setLayoutParams(r157);
        r141.addView(r156);
        TextView r159 = r141.a(r151, r148);
        IPromotionUIConfig.d r160 = r312.a(PromotionCardModuleName.InfoAreaSalePointModule);
        if (r160 == null) goto L64;
        IPromotionUIConfig.b r161 = r160.a();
        if (r161 == null) goto L64;
        UIConfigHelper.c(r159, r161);
    L64:
        r141.addView(r159);
        goto L65
    L67:
        if (r141.getChildCount() <= 0) goto L215;
        r141.addView(new Space(r141.getContext()), new LinearLayout.LayoutParams(1, r112));
        goto L215
    L29:
        r142 = false;
        goto L30
    L129:
        final LivePromotionCardArgsV2 r162 = this.f150572c;
        if (r162 == null) goto L215;
        final int r163 = r113;
        g r164 = (g) c("coupon_group_widget", new PromotionCardInfoLineContainer$bindData$$inlined$forEachIndexed$lambda$3(r162, r163, r115, this, r310, r311, r312));
        if (r113 != 0) goto L134;
        boolean r165 = true;
    L135:
        a(r164, -2, r165);
        List<PromotionBenefitLabel> r166 = r115.a();
        if (r166 == null) goto L215;
        r164.getClass();
        Intrinsics.checkNotNullParameter(r166, "benefitList");
        Intrinsics.checkNotNullParameter(r312, "uiConfig");
        Iterator<T> r167 = r166.iterator();
        int r168 = 0;
    L139:
        if (r167.hasNext() == false) goto L199;
        Object r169 = r167.next();
        int r170 = r168 + 1;
        if (r168 >= 0) goto L143;
        CollectionsKt.throwIndexOverflow();
    L143:
        PromotionBenefitLabel r171 = (PromotionBenefitLabel) r169;
        if (((Boolean) r164.f150641a.getValue()).booleanValue() == false) goto L171;
        View r172 = r164.getChildAt(r168);
        if ((r172 instanceof ECBenefitLabelViewV2) == true) goto L148;
        r172 = null;
    L148:
        ECBenefitLabelViewV2 r173 = (ECBenefitLabelViewV2) r172;
        if (r173 == null) goto L151;
        r173.setVisibility(0);
        int r174 = ECBenefitLabelViewV2.f150585m;
        r173.a(r171, null);
    L198:
        r168 = r170;
        goto L139
    L151:
        int r211 = r168;
        ECBenefitLabelViewV2 r175 = new ECBenefitLabelViewV2(r164.getContext(), null, 0, r164.f150642b, r164.f150643c, r312, 6);
        LinearLayout.LayoutParams r176 = new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(14));
        if (r211 != 0) goto L154;
        int r177 = 0;
    L155:
        r176.setMargins(UtilityKotlinExtentionsKt.d(r177), 0, 0, 0);
        r175.setLayoutParams(r176);
        r175.setFocusable(true);
        IPromotionUIConfig.d r178 = r312.a(PromotionCardModuleName.InfoAreaBenefitLabelModule);
        if (r178 == null) goto L170;
        IPromotionUIConfig.c r179 = r178.b();
        if (r179 == null) goto L170;
        Integer r180 = Integer.valueOf(r179.c());
        if (r180.intValue() <= 0) goto L162;
        boolean r181 = true;
    L163:
        if (r181 == true) goto L166;
        r180 = null;
    L166:
        if (r180 == null) goto L170;
        int r182 = r180.intValue();
        ViewGroup.LayoutParams r183 = r175.getLayoutParams();
        if (r183 == null) goto L170;
        r183.height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r182));
        r175.setLayoutParams(r183);
        goto L170
    L162:
        r181 = false;
    L170:
        r164.addView(r175, r211);
        r175.a(r171, null);
        Unit r184 = Unit.INSTANCE;
        goto L198
    L154:
        r177 = 4;
        goto L155
    L171:
        View r185 = r164.getChildAt(r168);
        if ((r185 instanceof ECBenefitLabelView) == true) goto L174;
        r185 = null;
    L174:
        ECBenefitLabelView r186 = (ECBenefitLabelView) r185;
        if (r186 == null) goto L178;
        r186.setVisibility(0);
        int r187 = ECBenefitLabelView.f150574k;
        r186.a(r171, null);
        goto L198
    L178:
        int r212 = r168;
        ECBenefitLabelView r188 = new ECBenefitLabelView(r164.getContext(), null, 0, r164.f150642b, r164.f150643c, r312, 6);
        LinearLayout.LayoutParams r189 = new LinearLayout.LayoutParams(-2, UtilityKotlinExtentionsKt.d(14));
        if (r212 != 0) goto L181;
        int r190 = 0;
    L182:
        r189.setMargins(UtilityKotlinExtentionsKt.d(r190), 0, 0, 0);
        r188.setLayoutParams(r189);
        r188.setFocusable(true);
        IPromotionUIConfig.d r191 = r312.a(PromotionCardModuleName.InfoAreaBenefitLabelModule);
        if (r191 == null) goto L197;
        IPromotionUIConfig.c r192 = r191.b();
        if (r192 == null) goto L197;
        Integer r193 = Integer.valueOf(r192.c());
        if (r193.intValue() <= 0) goto L189;
        boolean r194 = true;
    L190:
        if (r194 == true) goto L193;
        r193 = null;
    L193:
        if (r193 == null) goto L197;
        int r195 = r193.intValue();
        ViewGroup.LayoutParams r196 = r188.getLayoutParams();
        if (r196 == null) goto L197;
        r196.height = UtilityKotlinExtentionsKt.d(Integer.valueOf(r195));
        r188.setLayoutParams(r196);
        goto L197
    L189:
        r194 = false;
    L197:
        r164.addView(r188, r212);
        r188.a(r171, null);
        Unit r197 = Unit.INSTANCE;
        goto L198
    L181:
        r190 = 4;
        goto L182
    L199:
        r105 = null;
        Iterator<T> r198 = com.bytedance.commerce.base.view.b.a(r164).subList(r166.size(), com.bytedance.commerce.base.view.b.a(r164).size()).iterator();
    L201:
        if (r198.hasNext() == false) goto L204;
        ((View) r198.next()).setVisibility(8);
        goto L201
    L204:
        if ((r164.getChildAt(r164.getChildCount() - 1) instanceof ECBenefitLabelView) == false) goto L208;
        r164.addView(new Space(r164.getContext()), new LinearLayout.LayoutParams(1, 0));
        goto L230
    L208:
        if ((r164.getChildAt(r164.getChildCount() - 1) instanceof ECBenefitLabelViewV2) == false) goto L211;
        r164.addView(new Space(r164.getContext()), new LinearLayout.LayoutParams(1, 0));
        goto L230
    L211:
        if ((r164.getChildAt(r164.getChildCount() - 1) instanceof Space) == false) goto L230;
        View r199 = r164.getChildAt(r164.getChildCount() - 1);
        if (r199 == null) goto L230;
        r199.setVisibility(0);
        goto L230
    L134:
        r165 = false;
    L215:
        r105 = null;
        goto L230
    L251:
        return;
    }

    public PromotionCardInfoLineContainer(Context r100, AttributeSet r101, com.bytedance.android.livesdk.livecommerce.promotion.cardV2.a r102, LivePromotionCardArgsV2 r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = null;
    L6:
        if ((r104 & 4) == 0) goto L9;
        r102 = null;
    L9:
        if ((r104 & 16) == 0) goto L11;
        r103 = null;
    L11:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0);
        this.f150571b = r102;
        this.f150572c = r103;
        this.f150570a = new LinkedHashMap();
        setGravity(16);
        setOrientation(0);
        setImportantForAccessibility(4);
    }
}
