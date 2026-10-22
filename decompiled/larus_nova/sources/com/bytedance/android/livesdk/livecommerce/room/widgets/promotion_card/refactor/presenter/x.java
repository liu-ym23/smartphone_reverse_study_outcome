package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.core.widget.ECNetImageView;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.RitTagTrack;
import com.bytedance.android.ec.model.promotion.ECUICampaign;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.model.response.ECPreSaleData;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.android.ec.model.response.ECUIConfig;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.RemoteGroupHeadImageView;
import com.bytedance.android.livesdk.livecommerce.largemode.LargeModeConfigHelper;
import com.bytedance.android.livesdk.livecommerce.largemode.model.ComponentLargeModeConfig;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.widget.InfoSubTitleView;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import com.ss.android.ugc.aweme.kiwi.util.Query;
import com.ss.android.ugc.aweme.kiwi.viewmodel.QLiveData;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes10.dex */
public final class x extends p {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f152494j = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public z f152495g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f152496h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f152497i;

    public static final class a {
    }

    public static final class b<T> implements Observer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ x f152498a;

        public b(x r100) {
            this.f152498a = r100;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(Object r210) {
            ECUIPromotion r100 = (ECUIPromotion) r210;
            if (r100 != null) goto L5;
        L245:
            x r101 = this.f152498a;
            r101.f152496h = null;
            z r102 = r101.f152495g;
            if (r102 == null) goto L248;
            r102.a();
        L248:
            r101.f152495g = null;
            return;
        L5:
            if (r100.isAuction() == true) goto L245;
            x r103 = this.f152498a;
            ExplainCardViewModel r104 = r103.f152468e;
            if (r104 == null) goto L9;
            com.bytedance.android.livesdk.livecommerce.largemode.b r105 = r104.getLargeModeAdapter();
        L10:
            r103.w().g(0);
            Query r106 = r103.w().b(R.id.tv_promotion_title);
            Query r110 = r103.w().b(R.id.tv_promotion_info);
            r110.g(8);
            ((InfoSubTitleView) r110.f()).setShowDeleteLine(false);
            int r107 = th.a.a(r103.u().c(), R.color.ec_color_FE2C55);
            View r108 = r110.f450937b;
            if ((r108 instanceof TextView) == false) goto L13;
            ((TextView) r108).setTextColor(r107);
        L13:
            Query r111 = r103.w().b(R.id.layout_rittag_container);
            Query r109 = r103.w().b(R.id.layout_rittag_line1);
            Query r112 = r103.w().b(R.id.layout_rittag_line2);
            if (r105 == null) goto L19;
            ComponentLargeModeConfig r113 = r105.b("ExplainCard", "ExplainCard.SellPoint");
            if (r113 == null) goto L19;
            int r114 = LargeModeConfigHelper.f149249a;
            LargeModeConfigHelper.a(r113, r109.b(R.id.tv_rittag1).f());
        L19:
            if (r105 == null) goto L23;
            ComponentLargeModeConfig r115 = r105.b("ExplainCard", "ExplainCard.SellPoint");
            if (r115 == null) goto L23;
            int r116 = LargeModeConfigHelper.f149249a;
            LargeModeConfigHelper.a(r115, r109.b(R.id.tv_rittag2).f());
        L23:
            if (r105 == null) goto L27;
            ComponentLargeModeConfig r117 = r105.b("ExplainCard", "ExplainCard.SellPoint");
            if (r117 == null) goto L27;
            int r118 = LargeModeConfigHelper.f149249a;
            LargeModeConfigHelper.a(r117, r112.b(R.id.tv_rittag1).f());
        L27:
            if (r105 == null) goto L31;
            ComponentLargeModeConfig r119 = r105.b("ExplainCard", "ExplainCard.SellPoint");
            if (r119 == null) goto L31;
            int r120 = LargeModeConfigHelper.f149249a;
            LargeModeConfigHelper.a(r119, r112.b(R.id.tv_rittag2).f());
        L31:
            TextView r121 = (TextView) r106.f();
            String r122 = r100.title;
            Map<String, List<ECRitTag>> r123 = r100.getRitTag();
            if (r123 == null) goto L46;
            List<ECRitTag> r124 = r123.get("live_info_under_title");
            if (r124 == null) goto L46;
            ECRitTag r125 = (ECRitTag) CollectionsKt.firstOrNull(r124);
            if (r125 == null) goto L46;
            String r126 = r125.getFirstText();
            if (r126 == null) goto L46;
            if ((!StringsKt.isBlank(r126)) == true) goto L43;
            r126 = null;
        L43:
            if (r126 == null) goto L46;
            r110.g(0);
            r110.e(r126);
        L46:
            if (r110.d() == true) goto L57;
            String r127 = r100.flashIcon;
            if (r127 == null) goto L57;
            if (r127.length() <= 0) goto L52;
            boolean r128 = true;
        L53:
            if (r128 != true) goto L57;
            String r129 = "ExplainCard";
            if (r100.stockNum <= 0) goto L58;
            r110.g(0);
            String r211 = r122;
            r110.e(th.a.h(r103.u().c(), R.string.ec_stock_num, new Object[]{Long.valueOf(r100.stockNum)}));
        L108:
            Query r130 = r110;
        L109:
            if (r105 == null) goto L113;
            ComponentLargeModeConfig r131 = r105.b(r129, "ExplainCard.Title");
            if (r131 == null) goto L113;
            int r132 = LargeModeConfigHelper.f149249a;
            LargeModeConfigHelper.a(r131, r106.f());
        L113:
            Map<String, List<ECRitTag>> r133 = r100.getRitTag();
            if (r133 == null) goto L137;
            List<ECRitTag> r134 = r133.get("live_room_product_title_before");
            if (r134 == null) goto L137;
            ECRitTag r135 = (ECRitTag) CollectionsKt.firstOrNull(r134);
            if (r135 == null) goto L137;
            ECUrlModel r136 = r135.getTextIcon();
            if (r136 == null) goto L137;
            r106.g(0);
            if (r103.f152497i == false) goto L124;
            String r137 = r211;
            r121.setText(r137);
        L127:
            r100.isShowPopCardProductTag = true;
            Map<String, List<ECRitTag>> r138 = r100.getRitTag();
            if (r138 == null) goto L136;
            List<ECRitTag> r139 = r138.get("live_room_product_title_before");
            if (r139 == null) goto L136;
            ECRitTag r140 = (ECRitTag) CollectionsKt.firstOrNull(r139);
            if (r140 == null) goto L136;
            RitTagTrack r141 = r140.getTagTrack();
            if (r141 == null) goto L136;
            r141.setVisibile(true);
        L136:
            boolean r142 = true;
        L139:
            if (r100.reservationInfo == null) goto L142;
            r130.g(0);
            ((InfoSubTitleView) r130.f()).setText(r100.priceHeader + ' ' + th.a.g(r103.u().c(), R.string.ec_price_RMB_yang) + com.bytedance.android.livesdk.livecommerce.utils.k.g(r100.reserveMinPrice));
        L142:
            if (r103.f152497i == false) goto L144;
            r130.c();
        L144:
            Map<String, List<ECRitTag>> r143 = r100.getRitTag();
            if (r143 == null) goto L151;
            List<ECRitTag> r144 = r143.get("live_room_pop_biz_under");
            if (r144 == null) goto L151;
            if ((!r144.isEmpty()) == false) goto L151;
        L153:
            if (r130.d() == true) goto L187;
            if (r144 == null) goto L187;
            if (r103.f152497i == true) goto L187;
            r130.c();
            r111.g(0);
            if (r103.f152495g != null) goto L160;
        L163:
            long r145 = r100.carouselTime;
            ArrayList r146 = new ArrayList();
            Iterator<T> r147 = r144.iterator();
            Integer r148 = null;
        L165:
            if (r147.hasNext() == false) goto L179;
            ECRitTag r149 = (ECRitTag) r147.next();
            Iterator<T> r150 = r147;
            int r151 = r149.getType();
            String r212 = r137;
            if (r148 != null) goto L170;
        L171:
            r146.add(CollectionsKt.mutableListOf(new ECRitTag[]{r149}));
            r148 = Integer.valueOf(r149.getType());
        L172:
            r147 = r150;
            r137 = r212;
            goto L165
        L170:
            if (r151 != r148.intValue()) goto L171;
            Object r152 = CollectionsKt.lastOrNull(r146);
            if (TypeIntrinsics.isMutableList(r152) == true) goto L176;
            r152 = null;
        L176:
            List r153 = (List) r152;
            if (r153 == null) goto L172;
            r153.add(r149);
            goto L172
        L179:
            String r213 = r137;
            r109.g(0);
            r112.c();
            if (r146.size() > 1) goto L182;
        L184:
            ECUIPromotion r154 = r100;
            Query r155 = r111;
            Query r214 = r130;
            String r156 = r213;
            int r157 = 8;
            if (r146.size() <= 0) goto L191;
            r103.E(r109, (List) ListProtector.get(r146, 0));
        L191:
            if (r156 != null) goto L193;
        L196:
            boolean r158 = true;
        L197:
            if (r158 == false) goto L199;
            r121.setVisibility(r157);
        L210:
            if (r155.d() == false) goto L212;
            ECUIPromotion r159 = r154;
            boolean r160 = true;
            r159.isShowPopCardRightSimulateTag = true;
        L214:
            if (r121.getVisibility() != r157) goto L216;
            boolean r161 = true;
        L218:
            if (r161 == true) goto L220;
        L234:
            View r162 = r103.w().f();
            ViewGroup.LayoutParams r163 = r162.getLayoutParams();
            if (r163 == null) goto L240;
            if (r161 == true) goto L238;
            int r164 = UtilityKotlinExtentionsKt.d(36);
        L239:
            r163.height = r164;
            Unit r165 = Unit.INSTANCE;
        L241:
            r162.setLayoutParams(r163);
            if (r161 == false) goto L244;
            r162.setPadding(0, UtilityKotlinExtentionsKt.d(4), 0, UtilityKotlinExtentionsKt.d(4));
        L244:
            this.f152498a.f152496h = r159.getPromotionId();
            return;
        L238:
            r164 = -2;
            goto L239
        L240:
            r163 = null;
            goto L241
        L220:
            if (r214.f().getVisibility() != r157) goto L222;
            boolean r166 = true;
        L223:
            if (r166 == false) goto L234;
            if (r155.f().getVisibility() == r157) goto L228;
            r160 = false;
        L228:
            if (r160 == false) goto L234;
            View r167 = r103.w().f();
            ViewGroup.LayoutParams r168 = r167.getLayoutParams();
            if (r168 == null) goto L232;
            r168.height = UtilityKotlinExtentionsKt.d(4);
            Unit r169 = Unit.INSTANCE;
            ViewGroup.LayoutParams r170 = r168;
        L233:
            r167.setLayoutParams(r170);
            goto L244
        L232:
            r170 = null;
            goto L233
        L222:
            r166 = false;
            goto L223
        L216:
            r161 = false;
            goto L218
        L212:
            r159 = r154;
            r160 = true;
            goto L214
        L199:
            if (r142 == true) goto L202;
            r121.setLineSpacing(0.0f, 1.15f);
            r121.setText(r156);
        L202:
            if (r155.d() == false) goto L204;
        L207:
            int r171 = 1;
        L208:
            r121.setMaxLines(r171);
            goto L210
        L204:
            if (r214.d() == true) goto L207;
            r171 = 2;
            goto L208
        L193:
            if (r156.length() == 0) goto L196;
            r158 = false;
            goto L197
        L182:
            if (r145 <= 0) goto L184;
            r154 = r100;
            r155 = r111;
            r214 = r130;
            r156 = r213;
            r157 = 8;
            z r172 = new z(r103, r109, r112, r146, r146, r145, r145);
            r103.f152495g = r172;
            r172.j();
            goto L191
        L160:
            if ((!Intrinsics.areEqual(r103.f152496h, r100.getPromotionId())) == true) goto L163;
            r154 = r100;
            r156 = r137;
            r155 = r111;
            r214 = r130;
            r157 = 8;
        L187:
            r154 = r100;
            r156 = r137;
            r155 = r111;
            r214 = r130;
            r157 = 8;
            r155.c();
            z r173 = r103.f152495g;
            if (r173 == null) goto L190;
            r173.a();
        L190:
            r103.f152495g = null;
        L151:
            r144 = null;
            goto L153
        L124:
            r137 = r211;
            Disposable r174 = mh2.q.b(CollectionsKt.listOf(r136), r137, r136.getHeight(), r121, com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.t.f152708o, 64);
            if (r174 == null) goto L127;
            bk2.c.a(r174, r103);
        L137:
            r137 = r211;
            r142 = false;
        L58:
            r211 = r122;
            if (r110.d() == true) goto L108;
            ECUICampaign r175 = r100.campaign;
            if (r175 == null) goto L108;
            if (r175.isGroup().booleanValue() == false) goto L72;
            if (r100.isPriceDeduce() == true) goto L72;
            r110.g(0);
            if (r175.groupData.getJoined() >= 30) goto L69;
            String r176 = th.a.h(r103.u().c(), R.string.ec_live_group_ing, new Object[]{Integer.valueOf(r175.groupData.getGroupSize())});
        L70:
            r110.e(r176);
            goto L108
        L69:
            r176 = th.a.h(r103.u().c(), R.string.ec_live_group_success, new Object[]{Integer.valueOf(r175.groupData.getGroupSize())});
        L72:
            if (r175.isSecKill().booleanValue() == false) goto L89;
            boolean r177 = com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.q.f152505a;
            if (com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.q.a(r175.startTime, r175.endTime) == false) goto L88;
            String r178 = r175.marketPrice;
            if (r178 != null) goto L78;
            r178 = r100.marketPrice;
        L78:
            if (r178 == null) goto L80;
            float r179 = CastFloatProtector.parseFloat(r178);
        L82:
            if (r179 <= 0) goto L84;
            String r180 = th.a.g(r103.u().c(), R.string.ec_price_RMB_yang) + r178;
        L85:
            r130 = r110;
            if (r180 == null) goto L109;
            r130.g(0);
            InfoSubTitleView r181 = (InfoSubTitleView) r130.f();
            r181.setTextColor(th.a.a(r103.u().c(), R.color.ec_color_black_161823_50));
            r181.setText(r180);
            r181.setShowDeleteLine(true);
            r100.setRealPrice(r178);
            goto L109
        L84:
            r180 = null;
            goto L85
        L80:
            r179 = 0.0f;
            goto L82
        L88:
            r130 = r110;
        L91:
            if (r175.isPreSale().booleanValue() == false) goto L109;
            r130.g(0);
            InfoSubTitleView r182 = (InfoSubTitleView) r130.f();
            ECPreSaleData r183 = r175.preSaleData;
            if (r183 == null) goto L106;
            String r184 = r183.getDiscountDesc();
            if (r184 == null) goto L106;
            if (r184.length() <= 0) goto L99;
            boolean r185 = true;
        L101:
            if (r185 != true) goto L106;
            ECPreSaleData r186 = r175.preSaleData;
            if (r186 == null) goto L105;
            String r187 = r186.getDiscountDesc();
        L107:
            r182.setText(r187);
            goto L109
        L105:
            r187 = null;
            goto L107
        L99:
            r185 = false;
        L106:
            r187 = th.a.g(r103.u().c(), R.string.ec_pre_sale_origin_price) + ' ' + th.a.g(r103.u().c(), R.string.ec_price_RMB_yang) + r100.price;
            goto L107
        L89:
            r130 = r110;
            goto L91
        L52:
            r128 = false;
        L57:
            r129 = "ExplainCard";
            goto L58
        L9:
            r105 = null;
            goto L10
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p, com.ss.android.ugc.aweme.kiwi.presenter.QPresenter
    public final void C() {
        clearDisposable();
        z r100 = this.f152495g;
        if (r100 == null) goto L5;
        r100.a();
    L5:
        this.f152495g = null;
    }

    public x(boolean r100) {
        this.f152497i = r100;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.presenter.p
    public final void D(com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.c r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ExplainCardViewModel r101 = this.f152468e;
        if (r101 == null) goto L8;
        QLiveData<ECUIPromotion> r102 = r101.getPromotionState();
        if (r102 == null) goto L9;
        r102.b(r100.getLifecycleOwner(), new b(this));
        return;
    L9:
        return;
    }

    public final void E(Query r210, List<ECRitTag> r211) {
        Query r100 = r210.b(R.id.view_rittag_divider);
        r100.g(8);
        Query r101 = r210.b(R.id.tv_rittag1);
        r101.g(8);
        Query r102 = r210.b(R.id.tv_rittag2);
        r102.g(8);
        Query r103 = r210.b(R.id.layout_rittag_head);
        r103.g(8);
        if (r211.size() != 1) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        List<ECRitTag> r105 = r211;
    L9:
        if (r105 == null) goto L13;
        ECRitTag r106 = (ECRitTag) CollectionsKt.firstOrNull(r105);
        if (r106 == null) goto L13;
        ECUrlModel r107 = r106.getTextIcon();
    L14:
        ECRitTag r108 = (ECRitTag) CollectionsKt.firstOrNull(r211);
        if (r108 == null) goto L19;
        List<String> r109 = r108.getText();
        if (r109 == null) goto L19;
        String r110 = (String) CollectionsKt.firstOrNull(r109);
    L20:
        if (r110 != null) goto L22;
        r110 = "";
    L22:
        int r111 = com.bytedance.android.ec.core.utils.s.f45717a;
        ECRitTag r112 = (ECRitTag) CollectionsKt.firstOrNull(r211);
        if (r112 == null) goto L27;
        ECUIConfig r113 = r112.getUiConfig();
        if (r113 == null) goto L27;
        String r114 = r113.getTextColor();
    L28:
        Integer r115 = com.bytedance.android.ec.core.utils.s.b(r114);
        if (r211.size() <= 1) goto L31;
        boolean r116 = true;
    L32:
        if (r116 == false) goto L34;
        List<ECRitTag> r117 = r211;
    L35:
        if (r117 == null) goto L41;
        ECRitTag r118 = (ECRitTag) ListProtector.get(r117, 1);
        if (r118 == null) goto L41;
        List<String> r119 = r118.getText();
        if (r119 == null) goto L41;
        String r120 = (String) CollectionsKt.firstOrNull(r119);
    L43:
        if (r211.size() <= 1) goto L45;
        boolean r121 = true;
    L46:
        if (r121 == false) goto L48;
        List<ECRitTag> r122 = r211;
    L49:
        if (r122 == null) goto L55;
        ECRitTag r123 = (ECRitTag) ListProtector.get(r122, 1);
        if (r123 == null) goto L55;
        ECUIConfig r124 = r123.getUiConfig();
        if (r124 == null) goto L55;
        String r125 = r124.getTextColor();
    L56:
        Integer r126 = com.bytedance.android.ec.core.utils.s.b(r125);
        ECRitTag r127 = (ECRitTag) CollectionsKt.firstOrNull(r211);
        if (r211.size() <= 1) goto L59;
        boolean r128 = true;
    L60:
        if (r128 == false) goto L62;
        List<ECRitTag> r129 = r211;
    L63:
        if (r129 == null) goto L65;
        ECRitTag r130 = (ECRitTag) ListProtector.get(r129, 1);
    L66:
        if (r107 == null) goto L106;
        List<String> r131 = r107.getUrlList();
        if (r131 == null) goto L106;
        if ((!r131.isEmpty()) != true) goto L106;
        Integer r132 = Integer.valueOf(r107.getWidth());
        if (r132.intValue() <= 0) goto L74;
        boolean r133 = true;
    L75:
        if (r133 == true) goto L79;
        r132 = null;
    L79:
        if (r132 != null) goto L82;
        r132 = 12;
    L82:
        int r134 = UtilityKotlinExtentionsKt.d(r132);
        Integer r135 = Integer.valueOf(r107.getWidth());
        if (r135.intValue() <= 0) goto L85;
        boolean r136 = true;
    L86:
        if (r136 == true) goto L89;
        r135 = null;
    L89:
        if (r135 == null) goto L91;
        int r137 = UtilityKotlinExtentionsKt.d(r135);
    L92:
        r103.g(0);
        ViewGroup r138 = (ViewGroup) r103.f();
        r138.removeAllViewsInLayout();
        List<String> r139 = r107.getUrlList();
        if (r139 == null) goto L106;
        Iterator r140 = r139.iterator();
    L96:
        if (r140.hasNext() == false) goto L106;
        String r141 = (String) r140.next();
        if (r138.getChildCount() < 2) goto L100;
        r140 = r140;
    L105:
        r140 = r140;
        goto L96
    L100:
        if (r138.getChildCount() != 0) goto L102;
        ECNetImageView r142 = new ECNetImageView(u().c());
        r142.setLayoutParams(new LinearLayout.LayoutParams(r134, r137));
        r142.getHierarchy().setRoundingParams(RoundingParams.asCircle());
        r142.setImageURI(r141);
        Unit r143 = Unit.INSTANCE;
        View r144 = r142;
    L103:
        r138.addView(r144);
        goto L105
    L102:
        RemoteGroupHeadImageView r145 = new RemoteGroupHeadImageView(u().c());
        LinearLayout.LayoutParams r146 = new LinearLayout.LayoutParams(r134, r137);
        r146.leftMargin = UtilityKotlinExtentionsKt.d(Float.valueOf(-2.5f));
        Unit r147 = Unit.INSTANCE;
        r145.setLayoutParams(r146);
        ((GenericDraweeHierarchy) r145.getHierarchy()).setRoundingParams(RoundingParams.asCircle());
        r145.setImageURI(r141);
        r145.setTopOffsetPercent(0.16666667f);
        r145.setRightOffsetPercent(0.375f);
        r144 = r145;
        goto L103
    L91:
        r137 = UtilityKotlinExtentionsKt.d(12);
        goto L92
    L85:
        r136 = false;
        goto L86
    L74:
        r133 = false;
    L106:
        if (r127 == null) goto L110;
        RitTagTrack r148 = r127.getTagTrack();
        if (r148 == null) goto L110;
        r148.setVisibile(true);
    L110:
        r101.g(0);
        r101.e(r110);
        if (r115 == null) goto L115;
        r115.intValue();
        int r149 = r115.intValue();
        View r150 = r101.f450937b;
        if ((r150 instanceof TextView) == false) goto L115;
        ((TextView) r150).setTextColor(r149);
    L115:
        if (r120 == null) goto L148;
        r100.g(0);
        int r151 = com.bytedance.android.ec.core.utils.s.f45717a;
        if (r211.size() <= 1) goto L119;
        boolean r152 = true;
    L120:
        if (r152 == false) goto L122;
        List<ECRitTag> r153 = r211;
    L123:
        if (r153 == null) goto L129;
        ECRitTag r154 = (ECRitTag) ListProtector.get(r153, 1);
        if (r154 == null) goto L129;
        ECUIConfig r155 = r154.getUiConfig();
        if (r155 == null) goto L129;
        String r156 = r155.getTextSplitorColor();
    L130:
        Integer r157 = com.bytedance.android.ec.core.utils.s.b(r156);
        if (r157 == null) goto L135;
        r157.intValue();
        int r158 = r157.intValue();
        View r159 = r100.f450937b;
        if (r159 == null) goto L135;
        r159.setBackgroundColor(r158);
    L135:
        r102.g(0);
        r102.e(r120);
        if (r126 == null) goto L140;
        r126.intValue();
        int r160 = r126.intValue();
        View r161 = r102.f450937b;
        if ((r161 instanceof TextView) == false) goto L140;
        ((TextView) r161).setTextColor(r160);
    L140:
        if (r130 == null) goto L149;
        RitTagTrack r162 = r130.getTagTrack();
        if (r162 == null) goto L150;
        r162.setVisibile(true);
        return;
    L150:
        return;
    L149:
        return;
    L129:
        r156 = null;
        goto L130
    L122:
        r153 = null;
        goto L123
    L119:
        r152 = false;
        goto L120
    L148:
        return;
    L65:
        r130 = null;
        goto L66
    L62:
        r129 = null;
        goto L63
    L59:
        r128 = false;
    L55:
        r125 = null;
        goto L56
    L48:
        r122 = null;
        goto L49
    L45:
        r121 = false;
    L41:
        r120 = null;
        goto L43
    L34:
        r117 = null;
        goto L35
    L31:
        r116 = false;
    L27:
        r114 = null;
    L19:
        r110 = null;
    L13:
        r107 = null;
        goto L14
    L8:
        r105 = null;
        goto L9
    L5:
        r104 = false;
        goto L6
    }
}
