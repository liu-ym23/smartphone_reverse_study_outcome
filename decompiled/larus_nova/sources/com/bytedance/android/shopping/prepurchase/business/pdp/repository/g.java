package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.response.anchorv3.PromotionLogPbData;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonVO;
import com.bytedance.android.shopping.anchorv4.bottomnav.BottomNavVO;
import com.bytedance.android.shopping.anchorv4.components.BackToTopEntryVO;
import com.bytedance.android.shopping.anchorv4.components.PendantsComponentVO;
import com.bytedance.android.shopping.anchorv4.components.ShopFloatEntryVO;
import com.bytedance.android.shopping.anchorv4.components.SmallVideoWindowVO;
import com.bytedance.android.shopping.anchorv4.components.topbanner.HalfStrandVO;
import com.bytedance.android.shopping.anchorv4.data.y0;
import com.bytedance.android.shopping.anchorv4.dto.Control;
import com.bytedance.android.shopping.anchorv4.dto.PackParsedDTO;
import com.bytedance.android.shopping.anchorv4.dto.PackResponseDTO;
import com.bytedance.android.shopping.anchorv4.dto.PageConfig;
import com.bytedance.android.shopping.anchorv4.dto.PendantContainer;
import com.bytedance.android.shopping.anchorv4.dto.QuestionnaireEntrance;
import com.bytedance.android.shopping.anchorv4.dto.ScrollNode;
import com.bytedance.android.shopping.anchorv4.dto.business.ComponentDTO;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryBottom;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryPendants;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import com.bytedance.android.shopping.anchorv4.dto.business.HeadMoreVideo;
import com.bytedance.android.shopping.anchorv4.dto.business.UI;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.PendantContainerVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.PlayBackEntryVO;
import com.bytedance.android.shopping.anchorv4.helper.GlobalActionHandler;
import com.bytedance.android.shopping.anchorv4.helper.PdpSliceLocalCacheHelper;
import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsVO;
import com.bytedance.android.shopping.anchorv4.topbanner.TopBannerVO;
import com.bytedance.android.shopping.anchorv4.topnav.TopNavVO;
import com.bytedance.android.shopping.anchorv4.voavhs.ComponentIDs;
import com.bytedance.android.shopping.anchorv4.voavhs.VOIdentifier;
import com.bytedance.android.shopping.anchorv4.voavhs.head.AnchorV4HeadVO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class g implements e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f181924i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PackResponseDTO f181925a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public PackResponseDTO f181926b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TopRightControlsVO f181927c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.vm.a f181928d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<com.bytedance.android.ecom.arch.slice.adapter.b> f181929e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public BottomButtonVO f181930f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, com.bytedance.android.ecom.arch.slice.adapter.b> f181931g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PdpSliceLocalCacheHelper f181932h;

    public static final class a {
        public a() {
        }

        public static void b(List r100, PdpSliceLocalCacheHelper r101) {
            if (r100 == null) goto L18;
            Iterator r102 = r100.iterator();
        L5:
            if (r102.hasNext() == false) goto L24;
            com.bytedance.android.ecom.arch.slice.g r103 = (com.bytedance.android.ecom.arch.slice.g) r102.next();
            String r104 = r103.getSliceId();
            if (r104 != null) goto L9;
            r104 = "";
        L9:
            r101.getClass();
            if (r104.length() != 0) goto L12;
            boolean r105 = true;
        L13:
            if (r105 == false) goto L15;
            Map r106 = null;
        L16:
            if (r106 == null) goto L5;
            com.bytedance.android.ecom.arch.slice.g.a.a(r103, r106, false, 4);
            goto L5
        L15:
            r106 = (Map) ((LinkedHashMap) r101.f166926a).get(r104);
            goto L16
        L12:
            r105 = false;
            goto L13
        L24:
            return;
        }

        public static List a(Map r100, PackResponseDTO r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "voParseCache");
            Intrinsics.checkNotNullParameter(r101, "packDTO");
            ArrayList r103 = new ArrayList();
            PackParsedDTO r104 = r101.getParsedDTO();
            if (r104 == null) goto L7;
            AnchorV4HeadV2VO r105 = r104.getHeaderV2();
            if (r105 == null) goto L7;
            r103.add(r105);
        L7:
            PackParsedDTO r106 = r101.getParsedDTO();
            if (r106 == null) goto L107;
            List<com.bytedance.android.ecom.arch.slice.g> r107 = r106.getComponents();
            if (r107 == null) goto L107;
            List r108 = CollectionsKt.filterNotNull(r107);
            if (r108 == null) goto L107;
            Iterator r109 = r108.iterator();
        L15:
            if (r109.hasNext() == false) goto L107;
            com.bytedance.android.ecom.arch.slice.g r110 = (com.bytedance.android.ecom.arch.slice.g) r109.next();
            if ((r110 instanceof ComponentDTO) == true) goto L18;
            r103.add(r110);
            goto L15
        L18:
            ComponentDTO r111 = (ComponentDTO) r110;
            String r112 = r111.getComponentId();
            ComponentIDs r113 = ComponentIDs.HEAD_SLIDES;
            if (Intrinsics.areEqual(r112, r113.getId()) == true) goto L20;
            if (Intrinsics.areEqual(r112, ComponentIDs.RECEIVING_NOTICE.getId()) == true) goto L25;
            if (Intrinsics.areEqual(r112, ComponentIDs.BASE_INFO.getId()) == true) goto L30;
            if (Intrinsics.areEqual(r112, ComponentIDs.LOGISTICS_AND_COUPON.getId()) == true) goto L35;
            if (Intrinsics.areEqual(r112, ComponentIDs.CAR_ADDRESS.getId()) == true) goto L40;
            if (Intrinsics.areEqual(r112, ComponentIDs.COMMENTS.getId()) == true) goto L45;
            if (Intrinsics.areEqual(r112, ComponentIDs.SHOP_AND_STORE.getId()) == true) goto L50;
            if (Intrinsics.areEqual(r112, ComponentIDs.AUCTION_FLOW.getId()) == true) goto L55;
            if (Intrinsics.areEqual(r112, ComponentIDs.OFFER_RECORDS.getId()) == true) goto L60;
            if (Intrinsics.areEqual(r112, ComponentIDs.SHOP_COUPONS.getId()) == true) goto L65;
            if (Intrinsics.areEqual(r112, ComponentIDs.EP_COURSES.getId()) == true) goto L68;
            if (Intrinsics.areEqual(r112, ComponentIDs.EP_REGISTER.getId()) == true) goto L71;
            if (Intrinsics.areEqual(r112, ComponentIDs.EP_TEACHER.getId()) == true) goto L74;
            if (Intrinsics.areEqual(r112, ComponentIDs.SHOP_CONFIGURED_GOODS.getId()) == true) goto L77;
            if (Intrinsics.areEqual(r112, ComponentIDs.DELETED_PRODUCT_TIP.getId()) == true) goto L80;
            if (Intrinsics.areEqual(r112, ComponentIDs.KOL_EVALUATION.getId()) == true) goto L85;
            if (Intrinsics.areEqual(r112, ComponentIDs.COMBINE.getId()) == true) goto L90;
            UI r114 = r111.getUi();
            String r115 = null;
            if (r114 == null) goto L96;
            String r116 = r114.getContainerType();
        L98:
            if (Intrinsics.areEqual(r116, "lynx") == false) goto L100;
            int r117 = com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.f169990h;
            r103.add(com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.C2555a.a(r111));
        L100:
            UI r118 = r111.getUi();
            if (r118 == null) goto L104;
            r115 = r118.getContainerType();
        L104:
            if (Intrinsics.areEqual(r115, "lynx-air") == false) goto L15;
            int r119 = com.bytedance.android.shopping.anchorv4.voavhs.lynx.air.a.f170001g;
            r103.add(com.bytedance.android.shopping.anchorv4.voavhs.lynx.air.a.C2556a.a(r111));
            goto L15
        L96:
            r116 = null;
            goto L98
        L90:
            int r120 = com.bytedance.android.shopping.anchorv4.voavhs.detailhead.a.f168212d;
            com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r121 = com.bytedance.android.shopping.anchorv4.voavhs.detailhead.a.C2546a.a(r111);
            if (r121 == null) goto L15;
            r103.add(r121);
            goto L15
        L85:
            int r122 = com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation.b.f169942e;
            com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation.b r123 = com.bytedance.android.shopping.anchorv4.voavhs.kolevaluation.b.a.a(r111);
            if (r123 == null) goto L15;
            r103.add(r123);
            goto L15
        L80:
            int r124 = c83.a.f22709d;
            c83.a r125 = c83.a.C0414a.a(r111);
            if (r125 == null) goto L15;
            r103.add(r125);
            goto L15
        L77:
            int r126 = com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.f169990h;
            r103.add(com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.C2555a.a(r111));
            goto L15
        L74:
            int r127 = com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.f169990h;
            r103.add(com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.C2555a.a(r111));
            goto L15
        L71:
            int r128 = com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.f169990h;
            r103.add(com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.C2555a.a(r111));
            goto L15
        L68:
            int r129 = com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.f169990h;
            r103.add(com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.C2555a.a(r111));
            goto L15
        L65:
            int r130 = com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.f169990h;
            r103.add(com.bytedance.android.shopping.anchorv4.voavhs.lynx.a.C2555a.a(r111));
            goto L15
        L60:
            int r131 = l83.a.f507910e;
            l83.a r132 = l83.a.C6660a.a(r111);
            if (r132 == null) goto L15;
            r103.add(r132);
            goto L15
        L55:
            int r133 = m83.a.f512463e;
            m83.a r134 = m83.a.C6782a.a(r111);
            if (r134 == null) goto L15;
            r103.add(r134);
            goto L15
        L50:
            int r135 = com.bytedance.android.shopping.anchorv4.voavhs.shop.b.f170108f;
            com.bytedance.android.shopping.anchorv4.voavhs.shop.b r136 = com.bytedance.android.shopping.anchorv4.voavhs.shop.b.a.a(r111);
            if (r136 == null) goto L15;
            r103.add(r136);
            goto L15
        L45:
            int r137 = com.bytedance.android.shopping.anchorv4.voavhs.comment.e.f168141e;
            com.bytedance.android.shopping.anchorv4.voavhs.comment.e r138 = com.bytedance.android.shopping.anchorv4.voavhs.comment.e.a.b(r111);
            if (r138 == null) goto L15;
            r103.add(r138);
            goto L15
        L40:
            int r139 = com.bytedance.android.shopping.anchorv4.voavhs.car.b.f168080f;
            com.bytedance.android.shopping.anchorv4.voavhs.car.b r140 = com.bytedance.android.shopping.anchorv4.voavhs.car.b.a.a(r111);
            if (r140 == null) goto L15;
            r103.add(r140);
            goto L15
        L35:
            int r141 = com.bytedance.android.shopping.anchorv4.voavhs.logistics.a.f169981e;
            com.bytedance.android.shopping.anchorv4.voavhs.logistics.a r142 = com.bytedance.android.shopping.anchorv4.voavhs.logistics.a.C2554a.a(r111);
            if (r142 == null) goto L15;
            r103.add(r142);
            goto L15
        L30:
            int r143 = com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.c.f167952f;
            com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.c r144 = com.bytedance.android.shopping.anchorv4.voavhs.baseinfo.c.a.a(r111, r102);
            if (r144 == null) goto L15;
            r103.add(r144);
            goto L15
        L25:
            int r145 = com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice.c.f170051f;
            com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice.c r146 = com.bytedance.android.shopping.anchorv4.voavhs.receivingnotice.c.a.a(r111);
            if (r146 == null) goto L15;
            r103.add(r146);
            goto L15
        L20:
            AnchorV4HeadVO.Companion.getClass();
            AnchorV4HeadVO r147 = AnchorV4HeadVO.a.a(r111);
            if (r147 == null) goto L15;
            r100.put(r113.getId(), r147);
            r103.add(r147);
        L107:
            return r103;
        }
    }

    static {
        f181924i = new a();
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.repository.d
    public final void a(PackResponseDTO r100) {
        Intrinsics.checkNotNullParameter(r100, "dTO");
        ComponentDTO r101 = null;
        Boolean r102 = null;
        r102 = null;
        if (r100.isFirstChunk() == false) goto L5;
    L22:
        this.f181925a = r100;
        PackParsedDTO r103 = r100.getParsedDTO();
        if (r103 == null) goto L27;
        PageConfig r104 = r103.getPageConfig();
        if (r104 == null) goto L27;
        Boolean r105 = Boolean.valueOf(r104.getCollapseDetail());
    L28:
        boolean r106 = com.bytedance.android.shopping.extensions.k.i(r105);
        PackResponseDTO r107 = this.f181925a;
        if (r107 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L31:
        PackParsedDTO r108 = r107.getParsedDTO();
        if (r108 == null) goto L36;
        PageConfig r109 = r108.getPageConfig();
        if (r109 == null) goto L36;
        List<String> r110 = r109.getCollapseIgnoreList();
    L37:
        this.f181928d = new com.bytedance.android.shopping.anchorv4.vm.a(r106, r110);
        BottomButtonVO.a r111 = BottomButtonVO.Companion;
        PackResponseDTO r112 = this.f181925a;
        if (r112 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L40:
        PackParsedDTO r113 = r112.getParsedDTO();
        if (r113 == null) goto L43;
        ComponentDTO r114 = r113.getBottomButton();
    L44:
        r111.getClass();
        this.f181930f = BottomButtonVO.a.a(r114);
        a r115 = f181924i;
        Map<String, com.bytedance.android.ecom.arch.slice.adapter.b> r116 = this.f181931g;
        PackResponseDTO r117 = this.f181925a;
        if (r117 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L47:
        r115.getClass();
        this.f181929e = a.a(r116, r117, r106);
        TopRightControlsVO.a r118 = TopRightControlsVO.Companion;
        PackResponseDTO r119 = this.f181925a;
        if (r119 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L50:
        PackParsedDTO r120 = r119.getParsedDTO();
        if (r120 == null) goto L53;
        r101 = r120.getTopRightControls();
    L53:
        r118.getClass();
        this.f181927c = TopRightControlsVO.a.a(r101);
        return;
    L43:
        r114 = null;
    L36:
        r110 = null;
    L27:
        r105 = null;
        goto L28
    L5:
        if (r100.hasMultipleChunks() == false) goto L22;
        this.f181926b = r100;
        PackParsedDTO r121 = r100.getParsedDTO();
        if (r121 == null) goto L12;
        PageConfig r122 = r121.getPageConfig();
        if (r122 == null) goto L12;
        r102 = Boolean.valueOf(r122.getCollapseDetail());
    L12:
        boolean r123 = com.bytedance.android.shopping.extensions.k.i(r102);
        a r124 = f181924i;
        Map<String, com.bytedance.android.ecom.arch.slice.adapter.b> r125 = this.f181931g;
        r124.getClass();
        List r126 = a.a(r125, r100, r123);
        if (this.f181929e == null) goto L15;
        boolean r127 = true;
    L16:
        if (r127 == true) goto L18;
        ECExceptionMonitor.e(new IllegalStateException("pdp componentList is null"));
    L18:
        ArrayList r128 = new ArrayList();
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r129 = this.f181929e;
        if (r129 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("componentList");
    L21:
        r128.addAll(r129);
        r128.addAll(r126);
        Unit r130 = Unit.INSTANCE;
        this.f181929e = r128;
        return;
    L15:
        r127 = false;
        goto L16
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.repository.e
    public final n b(n r410) {
        Intrinsics.checkNotNullParameter(r410, "data");
        PackResponseDTO r100 = this.f181925a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L5:
        PromotionLogPbData r101 = r100.getLogPb();
        if (r101 == null) goto L8;
        String r102 = r101.getImprId();
    L9:
        PackResponseDTO r103 = this.f181925a;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L12:
        PackParsedDTO r104 = r103.getParsedDTO();
        if (r104 == null) goto L15;
        Control r105 = r104.getControl();
    L16:
        PackResponseDTO r106 = this.f181925a;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L19:
        PackParsedDTO r107 = r106.getParsedDTO();
        if (r107 == null) goto L22;
        PageMeta r108 = r107.getPageMeta();
    L23:
        com.bytedance.android.shopping.anchorv4.vm.a r110 = this.f181928d;
        if (r110 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("collapseInfo");
    L26:
        PackResponseDTO r109 = this.f181925a;
        if (r109 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L29:
        PackParsedDTO r111 = r109.getParsedDTO();
        if (r111 == null) goto L35;
        PageConfig r112 = r111.getPageConfig();
        if (r112 == null) goto L35;
        String r113 = r112.getBackgroundColor();
        if (r113 == null) goto L35;
    L36:
        String r210 = r113;
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r114 = this.f181929e;
        if (r114 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("componentList");
    L39:
        BottomButtonVO r115 = this.f181930f;
        PackResponseDTO r116 = this.f181925a;
        if (r116 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L42:
        PackParsedDTO r117 = r116.getParsedDTO();
        if (r117 == null) goto L45;
        List<ScrollNode> r211 = r117.getScrollNodes();
    L46:
        PackResponseDTO r118 = this.f181925a;
        if (r118 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L49:
        PackParsedDTO r119 = r118.getParsedDTO();
        if (r119 == null) goto L52;
        Map<String, SlcElement> r212 = r119.getTemplates();
    L53:
        TopRightControlsVO r120 = this.f181927c;
        PackResponseDTO r121 = this.f181925a;
        if (r121 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L56:
        PackParsedDTO r122 = r121.getParsedDTO();
        if (r122 == null) goto L59;
        TopNavVO r310 = r122.getTopNavVO();
    L60:
        PackResponseDTO r123 = this.f181925a;
        if (r123 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L63:
        PackParsedDTO r124 = r123.getParsedDTO();
        if (r124 == null) goto L66;
        BottomNavVO r311 = r124.getBottomNavVO();
    L67:
        PackResponseDTO r125 = this.f181925a;
        if (r125 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L70:
        PackParsedDTO r126 = r125.getParsedDTO();
        if (r126 == null) goto L73;
        AnchorV4HeadV2VO r411 = r126.getHeaderV2();
    L74:
        PackResponseDTO r127 = this.f181925a;
        if (r127 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L77:
        PackParsedDTO r128 = r127.getParsedDTO();
        if (r128 == null) goto L80;
        TopBannerVO r412 = r128.getTopBannerVO();
    L82:
        return n.a(r410, r108, r105, r102, r114, r212, null, null, null, null, r115, r120, null, null, null, null, null, null, null, r411, null, null, null, r211, r110, r210, null, null, null, null, null, r310, r311, r412, null, null, null, null, null, 2088236000, 124);
    L80:
        r412 = null;
        goto L82
    L73:
        r411 = null;
        goto L74
    L66:
        r311 = null;
        goto L67
    L59:
        r310 = null;
        goto L60
    L52:
        r212 = null;
        goto L53
    L45:
        r211 = null;
    L35:
        r113 = r410.f181971z;
        goto L36
    L22:
        r108 = null;
        goto L23
    L15:
        r105 = null;
        goto L16
    L8:
        r102 = null;
        goto L9
    }

    public final n d(n r410) {
        PackResponseDTO r100 = this.f181925a;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L5:
        PromotionLogPbData r101 = r100.getLogPb();
        if (r101 == null) goto L8;
        String r102 = r101.getImprId();
    L9:
        PackResponseDTO r103 = this.f181925a;
        if (r103 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L12:
        PackParsedDTO r104 = r103.getParsedDTO();
        if (r104 == null) goto L15;
        Control r105 = r104.getControl();
    L16:
        PackResponseDTO r106 = this.f181925a;
        if (r106 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L19:
        PackParsedDTO r107 = r106.getParsedDTO();
        if (r107 == null) goto L22;
        PageMeta r108 = r107.getPageMeta();
    L23:
        com.bytedance.android.shopping.anchorv4.vm.a r109 = this.f181928d;
        if (r109 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("collapseInfo");
    L26:
        PackResponseDTO r110 = this.f181925a;
        if (r110 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L29:
        PackParsedDTO r111 = r110.getParsedDTO();
        if (r111 == null) goto L37;
        PageConfig r112 = r111.getPageConfig();
        if (r112 == null) goto L37;
        String r113 = r112.getBackgroundColor();
        if (r113 == null) goto L37;
        String r210 = r113;
    L38:
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r114 = this.f181929e;
        if (r114 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("componentList");
    L41:
        BottomButtonVO r115 = this.f181930f;
        PackResponseDTO r116 = this.f181925a;
        if (r116 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L44:
        PackParsedDTO r117 = r116.getParsedDTO();
        if (r117 == null) goto L47;
        List<ScrollNode> r211 = r117.getScrollNodes();
    L48:
        PackResponseDTO r118 = this.f181925a;
        if (r118 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L51:
        PackParsedDTO r119 = r118.getParsedDTO();
        if (r119 == null) goto L54;
        Map<String, SlcElement> r120 = r119.getTemplates();
    L55:
        TopRightControlsVO r121 = this.f181927c;
        HalfStrandVO.a r122 = HalfStrandVO.Companion;
        PackResponseDTO r123 = this.f181925a;
        if (r123 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L58:
        PackParsedDTO r124 = r123.getParsedDTO();
        if (r124 == null) goto L61;
        ComponentDTO r125 = r124.getHalfStrandVO();
    L62:
        r122.getClass();
        HalfStrandVO r126 = HalfStrandVO.a.a(r125);
        SmallVideoWindowVO.a r127 = SmallVideoWindowVO.Companion;
        PackResponseDTO r128 = this.f181925a;
        if (r128 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L65:
        PackParsedDTO r129 = r128.getParsedDTO();
        if (r129 == null) goto L68;
        ComponentDTO r130 = r129.getSmallVideoVO();
    L69:
        r127.getClass();
        SmallVideoWindowVO r131 = SmallVideoWindowVO.a.a(r130);
        ShopFloatEntryVO.a r132 = ShopFloatEntryVO.Companion;
        PackResponseDTO r133 = this.f181925a;
        if (r133 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L72:
        PackParsedDTO r134 = r133.getParsedDTO();
        if (r134 == null) goto L75;
        ComponentDTO r135 = r134.getShopFloatEntry();
    L76:
        r132.getClass();
        ShopFloatEntryVO r212 = ShopFloatEntryVO.a.a(r135);
        BackToTopEntryVO.a r136 = BackToTopEntryVO.Companion;
        PackResponseDTO r137 = this.f181925a;
        if (r137 != null) goto L79;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L79:
        PackParsedDTO r138 = r137.getParsedDTO();
        if (r138 == null) goto L82;
        ComponentDTO r139 = r138.getBackToTopEntry();
    L83:
        r136.getClass();
        BackToTopEntryVO r213 = BackToTopEntryVO.a.a(r139);
        PlayBackEntryVO.a r140 = PlayBackEntryVO.Companion;
        PackResponseDTO r141 = this.f181925a;
        if (r141 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L86:
        PackParsedDTO r142 = r141.getParsedDTO();
        if (r142 == null) goto L89;
        ComponentDTO r143 = r142.getPlayBackFloatEntry();
    L90:
        PackResponseDTO r144 = this.f181925a;
        if (r144 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L93:
        PackParsedDTO r145 = r144.getParsedDTO();
        if (r145 == null) goto L96;
        AnchorV4HeadV2VO r146 = r145.getHeaderV2();
    L97:
        PackResponseDTO r147 = this.f181925a;
        if (r147 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L100:
        boolean r148 = r147.getFromCache();
        r140.getClass();
        PlayBackEntryVO r214 = PlayBackEntryVO.a.b(r143, r146, r148);
        PendantsComponentVO.a r149 = PendantsComponentVO.Companion;
        PackResponseDTO r150 = this.f181925a;
        if (r150 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L103:
        PackParsedDTO r151 = r150.getParsedDTO();
        if (r151 == null) goto L106;
        ComponentDTO r152 = r151.getPendantInfo();
    L107:
        r149.getClass();
        Map r310 = PendantsComponentVO.a.a(r152);
        int r153 = GlobalActionHandler.f166863e;
        PackResponseDTO r154 = this.f181925a;
        if (r154 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L110:
        e73.a r311 = GlobalActionHandler.a.a(r154);
        PackResponseDTO r155 = this.f181925a;
        if (r155 != null) goto L113;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L113:
        PackParsedDTO r156 = r155.getParsedDTO();
        if (r156 == null) goto L120;
        PageMeta r157 = r156.getPageMeta();
        if (r157 == null) goto L120;
        CommonMeta r158 = r157.getCommonMeta();
        if (r158 == null) goto L120;
        JSONObject r312 = h73.a.d(r158);
    L121:
        PackResponseDTO r159 = this.f181925a;
        if (r159 != null) goto L124;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L124:
        PackParsedDTO r160 = r159.getParsedDTO();
        if (r160 == null) goto L129;
        e73.e r161 = r160.getGlobal();
        if (r161 == null) goto L129;
        List<String> r313 = r161.b();
    L130:
        PackResponseDTO r162 = this.f181925a;
        if (r162 != null) goto L133;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L133:
        PackParsedDTO r163 = r162.getParsedDTO();
        if (r163 == null) goto L138;
        e73.e r164 = r163.getGlobal();
        if (r164 == null) goto L138;
        Map<String, Object> r314 = r164.d();
    L139:
        PackResponseDTO r165 = this.f181925a;
        if (r165 != null) goto L142;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L142:
        PackParsedDTO r166 = r165.getParsedDTO();
        if (r166 == null) goto L147;
        e73.e r167 = r166.getGlobal();
        if (r167 == null) goto L147;
        String r315 = r167.a();
    L148:
        PackResponseDTO r168 = this.f181925a;
        if (r168 != null) goto L151;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L151:
        PackParsedDTO r169 = r168.getParsedDTO();
        if (r169 == null) goto L156;
        e73.e r170 = r169.getGlobal();
        if (r170 == null) goto L156;
        String r411 = r170.c();
    L157:
        PackResponseDTO r171 = this.f181925a;
        if (r171 != null) goto L160;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L160:
        PackParsedDTO r172 = r171.getParsedDTO();
        if (r172 == null) goto L163;
        TopNavVO r316 = r172.getTopNavVO();
    L164:
        PackResponseDTO r173 = this.f181925a;
        if (r173 != null) goto L167;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L167:
        PackParsedDTO r174 = r173.getParsedDTO();
        if (r174 == null) goto L170;
        BottomNavVO r317 = r174.getBottomNavVO();
    L171:
        PackResponseDTO r175 = this.f181925a;
        if (r175 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L174:
        PackParsedDTO r176 = r175.getParsedDTO();
        if (r176 == null) goto L177;
        AnchorV4HeadV2VO r215 = r176.getHeaderV2();
    L178:
        PackResponseDTO r177 = this.f181925a;
        if (r177 != null) goto L181;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L181:
        PackParsedDTO r178 = r177.getParsedDTO();
        if (r178 == null) goto L184;
        TopBannerVO r318 = r178.getTopBannerVO();
    L185:
        PackResponseDTO r179 = this.f181925a;
        if (r179 != null) goto L188;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L188:
        PackParsedDTO r180 = r179.getParsedDTO();
        if (r180 == null) goto L191;
        GalleryVO r319 = r180.getGalleryVO();
    L192:
        int r181 = l73.c.f507786e;
        PackResponseDTO r182 = this.f181925a;
        if (r182 != null) goto L195;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L195:
        PackParsedDTO r183 = r182.getParsedDTO();
        if (r183 == null) goto L198;
        QuestionnaireEntrance r184 = r183.getQuestionnaireEntrance();
    L199:
        l73.c r185 = l73.c.a.a(r184);
        PackResponseDTO r186 = this.f181925a;
        if (r186 != null) goto L202;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L202:
        PackParsedDTO r187 = r186.getParsedDTO();
        if (r187 == null) goto L207;
        e73.b r188 = r187.getActionStorage();
        if (r188 == null) goto L207;
        Map<String, IAction> r412 = r188.a();
    L209:
        return n.a(r410, r108, r105, r102, r114, r120, null, null, null, null, r115, r121, r126, r185, null, r131, r212, r213, r214, r215, null, null, null, r211, r109, r210, r310, r311, r312, r313, r314, r316, r317, r318, r319, r315, r411, null, r412, 7357408, 32);
    L207:
        r412 = null;
        goto L209
    L198:
        r184 = null;
        goto L199
    L191:
        r319 = null;
        goto L192
    L184:
        r318 = null;
        goto L185
    L177:
        r215 = null;
        goto L178
    L170:
        r317 = null;
        goto L171
    L163:
        r316 = null;
    L156:
        r411 = null;
    L147:
        r315 = null;
    L138:
        r314 = null;
    L129:
        r313 = null;
    L120:
        r312 = null;
        goto L121
    L106:
        r152 = null;
        goto L107
    L96:
        r146 = null;
        goto L97
    L89:
        r143 = null;
        goto L90
    L82:
        r139 = null;
        goto L83
    L75:
        r135 = null;
        goto L76
    L68:
        r130 = null;
        goto L69
    L61:
        r125 = null;
        goto L62
    L54:
        r120 = null;
        goto L55
    L47:
        r211 = null;
    L37:
        r210 = r410.f181971z;
        goto L38
    L22:
        r108 = null;
        goto L23
    L15:
        r105 = null;
        goto L16
    L8:
        r102 = null;
        goto L9
    }

    public g(Map<String, com.bytedance.android.ecom.arch.slice.adapter.b> r100, PdpSliceLocalCacheHelper r101) {
        Intrinsics.checkNotNullParameter(r100, "voParseCache");
        Intrinsics.checkNotNullParameter(r101, "sliceLocalCacheHelper");
        this.f181931g = r100;
        this.f181932h = r101;
    }

    @Override // com.bytedance.android.shopping.prepurchase.business.pdp.repository.e
    public final n c(n r410, int r411) {
        Intrinsics.checkNotNullParameter(r410, "data");
        PackResponseDTO r100 = this.f181925a;
        if (r100 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L6:
        if (r100.hasMultipleChunks() == false) goto L11;
        PackResponseDTO r101 = this.f181926b;
        if (r101 == null) goto L229;
        return e(r410, r101);
    L229:
        return d(r410);
    L11:
        if (r411 <= 0) goto L215;
        PackResponseDTO r102 = this.f181925a;
        if (r102 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L15:
        PromotionLogPbData r103 = r102.getLogPb();
        if (r103 == null) goto L18;
        String r104 = r103.getImprId();
    L19:
        PackResponseDTO r105 = this.f181925a;
        if (r105 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L22:
        PackParsedDTO r106 = r105.getParsedDTO();
        if (r106 == null) goto L25;
        Control r107 = r106.getControl();
    L26:
        PackResponseDTO r108 = this.f181925a;
        if (r108 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L29:
        PackParsedDTO r109 = r108.getParsedDTO();
        if (r109 == null) goto L32;
        PageMeta r110 = r109.getPageMeta();
    L33:
        PackResponseDTO r111 = this.f181925a;
        if (r111 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L36:
        PackParsedDTO r112 = r111.getParsedDTO();
        if (r112 == null) goto L42;
        PageConfig r113 = r112.getPageConfig();
        if (r113 == null) goto L42;
        String r114 = r113.getBackgroundColor();
        if (r114 == null) goto L42;
    L43:
        String r210 = r114;
        a r115 = f181924i;
        Map<String, com.bytedance.android.ecom.arch.slice.adapter.b> r116 = this.f181931g;
        PackResponseDTO r117 = this.f181925a;
        if (r117 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L46:
        com.bytedance.android.shopping.anchorv4.vm.a r118 = this.f181928d;
        if (r118 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("collapseInfo");
    L50:
        if (r118.f167729a != true) goto L52;
        boolean r119 = true;
    L53:
        r115.getClass();
        List r120 = a.a(r116, r117, r119);
        PdpSliceLocalCacheHelper r121 = this.f181932h;
        Intrinsics.checkNotNullParameter(r121, "cacheHelper");
        ArrayList r122 = new ArrayList();
        Iterator r123 = ((ArrayList) r120).iterator();
    L55:
        if (r123.hasNext() == false) goto L65;
        com.bytedance.android.ecom.arch.slice.adapter.b r124 = (com.bytedance.android.ecom.arch.slice.adapter.b) r123.next();
        if ((r124 instanceof com.bytedance.android.ecom.arch.slice.g) == true) goto L58;
        if ((r124 instanceof VOIdentifier) == false) goto L55;
        r122.add(r124);
        goto L55
    L58:
        com.bytedance.android.ecom.arch.slice.g r125 = (com.bytedance.android.ecom.arch.slice.g) r124;
        f181924i.getClass();
        if ((r125 instanceof com.bytedance.android.ecom.arch.slice.p) == false) goto L61;
        a.b(((com.bytedance.android.ecom.arch.slice.p) r125).a(), r121);
    L61:
        r122.add(r125);
        goto L55
    L65:
        int r126 = y0.f166501a;
        Map<String, SlcElement> r127 = r410.f181950e;
        PackResponseDTO r128 = this.f181925a;
        if (r128 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L68:
        PackParsedDTO r129 = r128.getParsedDTO();
        if (r129 == null) goto L71;
        Map<String, SlcElement> r130 = r129.getTemplates();
    L72:
        Map r131 = y0.e(r127, r130);
        BottomButtonVO.a r132 = BottomButtonVO.Companion;
        PackResponseDTO r133 = this.f181925a;
        if (r133 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L75:
        PackParsedDTO r134 = r133.getParsedDTO();
        if (r134 == null) goto L78;
        ComponentDTO r135 = r134.getBottomButton();
    L79:
        r132.getClass();
        BottomButtonVO r136 = BottomButtonVO.a.a(r135);
        PackResponseDTO r137 = this.f181925a;
        if (r137 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L82:
        PackParsedDTO r138 = r137.getParsedDTO();
        if (r138 == null) goto L89;
        PageMeta r139 = r138.getPageMeta();
        if (r139 == null) goto L89;
        CommonMeta r140 = r139.getCommonMeta();
        if (r140 == null) goto L89;
        JSONObject r211 = h73.a.d(r140);
    L90:
        PackResponseDTO r141 = this.f181925a;
        if (r141 != null) goto L93;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L93:
        PackParsedDTO r142 = r141.getParsedDTO();
        if (r142 == null) goto L98;
        e73.e r143 = r142.getGlobal();
        if (r143 == null) goto L98;
        List<String> r310 = r143.b();
    L99:
        PackResponseDTO r144 = this.f181925a;
        if (r144 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L102:
        PackParsedDTO r145 = r144.getParsedDTO();
        if (r145 == null) goto L107;
        e73.e r146 = r145.getGlobal();
        if (r146 == null) goto L107;
        Map<String, Object> r311 = r146.d();
    L108:
        PackResponseDTO r147 = this.f181925a;
        if (r147 != null) goto L111;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L111:
        PackParsedDTO r148 = r147.getParsedDTO();
        if (r148 == null) goto L116;
        e73.e r149 = r148.getGlobal();
        if (r149 == null) goto L116;
        String r312 = r149.a();
    L117:
        PackResponseDTO r150 = this.f181925a;
        if (r150 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L120:
        PackParsedDTO r151 = r150.getParsedDTO();
        if (r151 == null) goto L125;
        e73.e r152 = r151.getGlobal();
        if (r152 == null) goto L125;
        String r313 = r152.c();
    L126:
        PackResponseDTO r153 = this.f181925a;
        if (r153 != null) goto L129;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L129:
        PackParsedDTO r154 = r153.getParsedDTO();
        if (r154 == null) goto L132;
        BottomNavVO r314 = r154.getBottomNavVO();
    L133:
        PackResponseDTO r155 = this.f181925a;
        if (r155 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L136:
        PackParsedDTO r156 = r155.getParsedDTO();
        if (r156 == null) goto L139;
        TopBannerVO r315 = r156.getTopBannerVO();
    L140:
        PendantContainerVO.Companion r157 = PendantContainerVO.Companion;
        PackResponseDTO r158 = this.f181925a;
        if (r158 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L143:
        PackParsedDTO r159 = r158.getParsedDTO();
        if (r159 == null) goto L146;
        PendantContainer r160 = r159.getPendantContainer();
    L147:
        r157.getClass();
        PendantContainerVO r412 = PendantContainerVO.Companion.c(r160);
        a r161 = f181924i;
        PackResponseDTO r162 = this.f181925a;
        if (r162 != null) goto L150;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L150:
        PackParsedDTO r163 = r162.getParsedDTO();
        if (r163 == null) goto L153;
        GalleryVO r413 = r163.getGalleryVO();
    L154:
        PdpSliceLocalCacheHelper r164 = this.f181932h;
        r161.getClass();
        Intrinsics.checkNotNullParameter(r164, "cacheHelper");
        if (r413 == null) goto L165;
        GalleryPendants r165 = r413.getPendants();
        if (r165 == null) goto L159;
        List<com.bytedance.android.ecom.arch.slice.g> r166 = r165.getSlices();
    L160:
        a.b(r166, r164);
        GalleryBottom r167 = r413.getBottom();
        if (r167 == null) goto L163;
        List<com.bytedance.android.ecom.arch.slice.g> r168 = r167.getSlices();
    L164:
        a.b(r168, r164);
        goto L165
    L163:
        r168 = null;
        goto L164
    L159:
        r166 = null;
    L165:
        PackResponseDTO r169 = this.f181925a;
        if (r169 != null) goto L168;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L168:
        PackParsedDTO r170 = r169.getParsedDTO();
        if (r170 == null) goto L171;
        HeadMoreVideo r414 = r170.getMoreVideo();
    L172:
        PackResponseDTO r171 = this.f181925a;
        if (r171 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L175:
        PackParsedDTO r172 = r171.getParsedDTO();
        if (r172 == null) goto L178;
        AnchorV4HeadV2VO r415 = r172.getHeaderV2();
    L179:
        Map<String, IAction> r173 = r410.M;
        if (r173 != null) goto L182;
    L185:
        boolean r174 = true;
    L186:
        if (r174 == false) goto L196;
        PackResponseDTO r175 = this.f181925a;
        if (r175 != null) goto L190;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L190:
        PackParsedDTO r176 = r175.getParsedDTO();
        if (r176 == null) goto L195;
        e73.b r177 = r176.getActionStorage();
        if (r177 == null) goto L195;
        Map<String, IAction> r416 = r177.a();
    L230:
        return n.a(r410, r110, r107, r104, r122, r131, null, null, null, null, r136, null, null, null, r412, null, null, null, null, r415, null, null, null, null, null, r210, null, null, r211, r310, r311, null, r314, r315, r413, r312, r313, r414, r416, -1913144352, 0);
    L195:
        r416 = null;
        goto L230
    L196:
        LinkedHashMap r178 = new LinkedHashMap();
        r178.putAll(r410.M);
        PackResponseDTO r179 = this.f181925a;
        if (r179 != null) goto L199;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L199:
        PackParsedDTO r180 = r179.getParsedDTO();
        if (r180 == null) goto L204;
        e73.b r181 = r180.getActionStorage();
        if (r181 == null) goto L204;
        Map<String, IAction> r182 = r181.a();
    L205:
        if (r182 != null) goto L207;
    L210:
        boolean r183 = true;
    L211:
        if (r183 == true) goto L213;
        Intrinsics.checkNotNull(r182);
        r178.putAll(r182);
    L213:
        Unit r184 = Unit.INSTANCE;
        r416 = r178;
        goto L230
    L207:
        if (r182.isEmpty() == true) goto L210;
        r183 = false;
    L204:
        r182 = null;
        goto L205
    L182:
        if (r173.isEmpty() == true) goto L185;
        r174 = false;
        goto L186
    L178:
        r415 = null;
        goto L179
    L171:
        r414 = null;
        goto L172
    L153:
        r413 = null;
        goto L154
    L146:
        r160 = null;
        goto L147
    L139:
        r315 = null;
        goto L140
    L132:
        r314 = null;
    L125:
        r313 = null;
    L116:
        r312 = null;
    L107:
        r311 = null;
    L98:
        r310 = null;
    L89:
        r211 = null;
        goto L90
    L78:
        r135 = null;
        goto L79
    L71:
        r130 = null;
        goto L72
    L52:
        r119 = false;
    L42:
        r114 = r410.f181971z;
        goto L43
    L32:
        r110 = null;
        goto L33
    L25:
        r107 = null;
        goto L26
    L18:
        r104 = null;
        goto L19
    L215:
        n r185 = d(r410);
        PackResponseDTO r186 = this.f181925a;
        if (r186 != null) goto L219;
        Intrinsics.throwUninitializedPropertyAccessException("firstChunk");
    L219:
        return e(r185, r186);
    }

    public final n e(n r410, PackResponseDTO r411) {
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r100 = this.f181929e;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("componentList");
    L5:
        Map<String, IAction> r110 = null;
        if (r411 == null) goto L12;
        PackParsedDTO r111 = r411.getParsedDTO();
        if (r111 == null) goto L12;
        e73.e r112 = r111.getGlobal();
        if (r112 == null) goto L12;
        String r310 = r112.a();
    L14:
        if (r411 == null) goto L21;
        PackParsedDTO r113 = r411.getParsedDTO();
        if (r113 == null) goto L21;
        e73.e r114 = r113.getGlobal();
        if (r114 == null) goto L21;
        String r115 = r114.c();
        if (r115 == null) goto L21;
    L22:
        String r311 = r115;
        PendantContainerVO.Companion r116 = PendantContainerVO.Companion;
        if (r411 == null) goto L27;
        PackParsedDTO r117 = r411.getParsedDTO();
        if (r117 == null) goto L27;
        PendantContainer r118 = r117.getPendantContainer();
    L28:
        r116.getClass();
        PendantContainerVO r119 = PendantContainerVO.Companion.c(r118);
        if (r411 == null) goto L33;
        PackParsedDTO r120 = r411.getParsedDTO();
        if (r120 == null) goto L33;
        GalleryVO r312 = r120.getGalleryVO();
    L34:
        if (r411 == null) goto L38;
        PackParsedDTO r121 = r411.getParsedDTO();
        if (r121 == null) goto L38;
        HeadMoreVideo r313 = r121.getMoreVideo();
    L39:
        if (r411 == null) goto L48;
        PackParsedDTO r122 = r411.getParsedDTO();
        if (r122 == null) goto L48;
        PageMeta r123 = r122.getPageMeta();
        if (r123 == null) goto L48;
        CommonMeta r124 = r123.getCommonMeta();
        if (r124 == null) goto L48;
        JSONObject r125 = h73.a.d(r124);
        if (r125 == null) goto L48;
    L49:
        JSONObject r314 = r125;
        if (r410.M != null) goto L58;
        if (r411 == null) goto L69;
        PackParsedDTO r126 = r411.getParsedDTO();
        if (r126 == null) goto L69;
        e73.b r127 = r126.getActionStorage();
        if (r127 == null) goto L69;
        r110 = r127.a();
    L69:
        return n.a(r410, null, null, null, r100, null, null, null, null, null, null, null, null, null, r119, null, null, null, null, null, null, null, null, null, null, null, null, null, r314, null, null, null, null, null, r312, r310, r311, r313, r110, -268451849, 3);
    L58:
        r110 = new LinkedHashMap();
        r110.putAll(r410.M);
        if (r411 == null) goto L67;
        PackParsedDTO r128 = r411.getParsedDTO();
        if (r128 == null) goto L67;
        e73.b r129 = r128.getActionStorage();
        if (r129 == null) goto L67;
        Map<String, IAction> r130 = r129.a();
        if (r130 == null) goto L67;
        r110.putAll(r130);
    L67:
        Unit r131 = Unit.INSTANCE;
    L48:
        r125 = r410.C;
    L38:
        r313 = null;
    L33:
        r312 = null;
    L27:
        r118 = null;
    L21:
        r115 = r410.K;
    L12:
        r310 = null;
        goto L14
    }
}
