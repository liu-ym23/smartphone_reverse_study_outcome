package com.bytedance.android.shopping.prepurchase.business.pdp.repository;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionRecommendResponse;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonVO;
import com.bytedance.android.shopping.anchorv4.bottomnav.BottomNavVO;
import com.bytedance.android.shopping.anchorv4.components.BackToTopEntryVO;
import com.bytedance.android.shopping.anchorv4.components.PendantsComponentVO;
import com.bytedance.android.shopping.anchorv4.components.ShopFloatEntryVO;
import com.bytedance.android.shopping.anchorv4.components.SmallVideoWindowVO;
import com.bytedance.android.shopping.anchorv4.components.topbanner.HalfStrandVO;
import com.bytedance.android.shopping.anchorv4.dto.Control;
import com.bytedance.android.shopping.anchorv4.dto.ScrollNode;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import com.bytedance.android.shopping.anchorv4.dto.business.HeadMoreVideo;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.PendantContainerVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.PlayBackEntryVO;
import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsVO;
import com.bytedance.android.shopping.anchorv4.topbanner.TopBannerVO;
import com.bytedance.android.shopping.anchorv4.topnav.TopNavVO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class n {
    public final Map<String, PendantsComponentVO> A;
    public final e73.a B;
    public final JSONObject C;
    public final List<String> D;
    public final Map<String, Object> E;
    public final TopNavVO F;
    public final BottomNavVO G;
    public final TopBannerVO H;
    public final GalleryVO I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final String f181945J;
    public final String K;
    public final HeadMoreVideo L;
    public final Map<String, IAction> M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PageMeta f181946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Control f181947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f181948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.android.ecom.arch.slice.adapter.b> f181949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, SlcElement> f181950e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d f181951f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<com.bytedance.android.shopping.anchorv4.voavhs.detailimages.d> f181952g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<d63.d> f181953h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<j63.c> f181954i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final j63.a f181955j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final BottomButtonVO f181956k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final TopRightControlsVO f181957l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final HalfStrandVO f181958m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final l73.c f181959n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final PendantContainerVO f181960o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final SmallVideoWindowVO f181961p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ShopFloatEntryVO f181962q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final BackToTopEntryVO f181963r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final PlayBackEntryVO f181964s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final AnchorV4HeadV2VO f181965t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final PromotionRecommendResponse f181966u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.dto.business.d f181967v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv3.i f181968w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<ScrollNode> f181969x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.vm.a f181970y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final String f181971z;

    public n() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof n) == false) goto L84;
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f181946a, r101.f181946a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f181947b, r101.f181947b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f181948c, r101.f181948c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f181949d, r101.f181949d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f181950e, r101.f181950e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f181951f, r101.f181951f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f181952g, r101.f181952g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f181953h, r101.f181953h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f181954i, r101.f181954i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f181955j, r101.f181955j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f181956k, r101.f181956k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f181957l, r101.f181957l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f181958m, r101.f181958m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f181959n, r101.f181959n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f181960o, r101.f181960o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f181961p, r101.f181961p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f181962q, r101.f181962q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f181963r, r101.f181963r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f181964s, r101.f181964s) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.f181965t, r101.f181965t) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.f181966u, r101.f181966u) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f181967v, r101.f181967v) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.f181968w, r101.f181968w) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.f181969x, r101.f181969x) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f181970y, r101.f181970y) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.f181971z, r101.f181971z) == true) goto L58;
        return false;
    L58:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.B, r101.B) == true) goto L62;
        return false;
    L62:
        if (Intrinsics.areEqual(this.C, r101.C) == true) goto L64;
        return false;
    L64:
        if (Intrinsics.areEqual(this.D, r101.D) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.E, r101.E) == true) goto L68;
        return false;
    L68:
        if (Intrinsics.areEqual(this.F, r101.F) == true) goto L70;
        return false;
    L70:
        if (Intrinsics.areEqual(this.G, r101.G) == true) goto L72;
        return false;
    L72:
        if (Intrinsics.areEqual(this.H, r101.H) == true) goto L74;
        return false;
    L74:
        if (Intrinsics.areEqual(this.I, r101.I) == true) goto L76;
        return false;
    L76:
        if (Intrinsics.areEqual(this.f181945J, r101.f181945J) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.K, r101.K) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.L, r101.L) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.M, r101.M) == true) goto L127;
        return false;
    L127:
        return true;
    L84:
        return false;
    }

    public final int hashCode() {
        PageMeta r100 = this.f181946a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Control r104 = this.f181947b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f181948c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r110 = this.f181949d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, SlcElement> r113 = this.f181950e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r116 = this.f181951f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        List<com.bytedance.android.shopping.anchorv4.voavhs.detailimages.d> r119 = this.f181952g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        List<d63.d> r122 = this.f181953h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        List<j63.c> r125 = this.f181954i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        j63.a r128 = this.f181955j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        BottomButtonVO r131 = this.f181956k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        TopRightControlsVO r134 = this.f181957l;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        HalfStrandVO r137 = this.f181958m;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        l73.c r140 = this.f181959n;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        PendantContainerVO r143 = this.f181960o;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        SmallVideoWindowVO r146 = this.f181961p;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        ShopFloatEntryVO r149 = this.f181962q;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        BackToTopEntryVO r152 = this.f181963r;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        PlayBackEntryVO r155 = this.f181964s;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        AnchorV4HeadV2VO r158 = this.f181965t;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        PromotionRecommendResponse r161 = this.f181966u;
        if (r161 == null) goto L85;
        int r162 = r161.hashCode();
    L86:
        int r163 = (r160 + r162) * 31;
        com.bytedance.android.shopping.anchorv4.dto.business.d r164 = this.f181967v;
        if (r164 == null) goto L89;
        int r165 = r164.hashCode();
    L90:
        int r166 = (r163 + r165) * 31;
        com.bytedance.android.shopping.anchorv3.i r167 = this.f181968w;
        if (r167 == null) goto L93;
        int r168 = r167.hashCode();
    L94:
        int r169 = (r166 + r168) * 31;
        List<ScrollNode> r170 = this.f181969x;
        if (r170 == null) goto L97;
        int r171 = r170.hashCode();
    L98:
        int r172 = (r169 + r171) * 31;
        com.bytedance.android.shopping.anchorv4.vm.a r173 = this.f181970y;
        if (r173 == null) goto L101;
        int r174 = r173.hashCode();
    L102:
        int r175 = (r172 + r174) * 31;
        String r176 = this.f181971z;
        if (r176 == null) goto L105;
        int r177 = r176.hashCode();
    L106:
        int r178 = (r175 + r177) * 31;
        Map<String, PendantsComponentVO> r179 = this.A;
        if (r179 == null) goto L109;
        int r180 = r179.hashCode();
    L110:
        int r181 = (r178 + r180) * 31;
        e73.a r182 = this.B;
        if (r182 == null) goto L113;
        int r183 = r182.hashCode();
    L114:
        int r184 = (r181 + r183) * 31;
        JSONObject r185 = this.C;
        if (r185 == null) goto L117;
        int r186 = r185.hashCode();
    L118:
        int r187 = (r184 + r186) * 31;
        List<String> r188 = this.D;
        if (r188 == null) goto L121;
        int r189 = r188.hashCode();
    L122:
        int r190 = (r187 + r189) * 31;
        Map<String, Object> r191 = this.E;
        if (r191 == null) goto L125;
        int r192 = r191.hashCode();
    L126:
        int r193 = (r190 + r192) * 31;
        TopNavVO r194 = this.F;
        if (r194 == null) goto L129;
        int r195 = r194.hashCode();
    L130:
        int r196 = (r193 + r195) * 31;
        BottomNavVO r197 = this.G;
        if (r197 == null) goto L133;
        int r198 = r197.hashCode();
    L134:
        int r199 = (r196 + r198) * 31;
        TopBannerVO r200 = this.H;
        if (r200 == null) goto L137;
        int r201 = r200.hashCode();
    L138:
        int r202 = (r199 + r201) * 31;
        GalleryVO r203 = this.I;
        if (r203 == null) goto L141;
        int r204 = r203.hashCode();
    L142:
        int r205 = (r202 + r204) * 31;
        String r206 = this.f181945J;
        if (r206 == null) goto L145;
        int r207 = r206.hashCode();
    L146:
        int r208 = (r205 + r207) * 31;
        String r209 = this.K;
        if (r209 == null) goto L149;
        int r210 = r209.hashCode();
    L150:
        int r211 = (r208 + r210) * 31;
        HeadMoreVideo r212 = this.L;
        if (r212 == null) goto L153;
        int r213 = r212.hashCode();
    L154:
        int r214 = (r211 + r213) * 31;
        Map<String, IAction> r215 = this.M;
        if (r215 == null) goto L158;
        r101 = r215.hashCode();
    L158:
        return r214 + r101;
    L153:
        r213 = 0;
        goto L154
    L149:
        r210 = 0;
        goto L150
    L145:
        r207 = 0;
        goto L146
    L141:
        r204 = 0;
        goto L142
    L137:
        r201 = 0;
        goto L138
    L133:
        r198 = 0;
        goto L134
    L129:
        r195 = 0;
        goto L130
    L125:
        r192 = 0;
        goto L126
    L121:
        r189 = 0;
        goto L122
    L117:
        r186 = 0;
        goto L118
    L113:
        r183 = 0;
        goto L114
    L109:
        r180 = 0;
        goto L110
    L105:
        r177 = 0;
        goto L106
    L101:
        r174 = 0;
        goto L102
    L97:
        r171 = 0;
        goto L98
    L93:
        r168 = 0;
        goto L94
    L89:
        r165 = 0;
        goto L90
    L85:
        r162 = 0;
        goto L86
    L81:
        r159 = 0;
        goto L82
    L77:
        r156 = 0;
        goto L78
    L73:
        r153 = 0;
        goto L74
    L69:
        r150 = 0;
        goto L70
    L65:
        r147 = 0;
        goto L66
    L61:
        r144 = 0;
        goto L62
    L57:
        r141 = 0;
        goto L58
    L53:
        r138 = 0;
        goto L54
    L49:
        r135 = 0;
        goto L50
    L45:
        r132 = 0;
        goto L46
    L41:
        r129 = 0;
        goto L42
    L37:
        r126 = 0;
        goto L38
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "PdpNetworkData(pageMeta=" + this.f181946a + ", control=" + this.f181947b + ", logId=" + this.f181948c + ", componentVOS=" + this.f181949d + ", templates=" + this.f181950e + ", detailHeadVO=" + this.f181951f + ", detailImageVOS=" + this.f181952g + ", unifiedTipsVOS=" + this.f181953h + ", guessUVOS=" + this.f181954i + ", showGuessULike=" + this.f181955j + ", bottomButtonVO=" + this.f181956k + ", topRightControlsVO=" + this.f181957l + ", halfStrandVO=" + this.f181958m + ", questionnaireEntrance=" + this.f181959n + ", pendantContainerVO=" + this.f181960o + ", smallVideoWindowVO=" + this.f181961p + ", shopFloatEntry=" + this.f181962q + ", backToTopEntry=" + this.f181963r + ", playBackEntryVO=" + this.f181964s + ", headV2=" + this.f181965t + ", shopRecommends=" + this.f181966u + ", findSameGoods=" + this.f181967v + ", searchSuggest=" + this.f181968w + ", scrollNodes=" + this.f181969x + ", collapseInfo=" + this.f181970y + ", backgroundColor=" + this.f181971z + ", pendantsVOS=" + this.A + ", globalAction=" + this.B + ", pdpLynxDataAfterPack=" + this.C + ", detailImageList=" + this.D + ", supermarketCartBarData=" + this.E + ", topNavVO=" + this.F + ", bottomNavVO=" + this.G + ", topBannerVO=" + this.H + ", galleryVO=" + this.I + ", commentPreloadData=" + this.f181945J + ", mcpData=" + this.K + ", moreVideo=" + this.L + ", actionStorage=" + this.M + ")";
    }

    public /* synthetic */ n(int r410) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public n(PageMeta r100, Control r101, String r102, List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r103, Map<String, SlcElement> r104, com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r105, List<com.bytedance.android.shopping.anchorv4.voavhs.detailimages.d> r106, List<d63.d> r110, List<j63.c> r111, j63.a r112, BottomButtonVO r113, TopRightControlsVO r114, HalfStrandVO r115, l73.c r116, PendantContainerVO r117, SmallVideoWindowVO r118, ShopFloatEntryVO r119, BackToTopEntryVO r210, PlayBackEntryVO r211, AnchorV4HeadV2VO r212, PromotionRecommendResponse r213, com.bytedance.android.shopping.anchorv4.dto.business.d r214, com.bytedance.android.shopping.anchorv3.i r215, List<ScrollNode> r216, com.bytedance.android.shopping.anchorv4.vm.a r217, String r218, Map<String, PendantsComponentVO> r219, e73.a r310, JSONObject r311, List<String> r312, Map<String, ? extends Object> r313, TopNavVO r314, BottomNavVO r315, TopBannerVO r316, GalleryVO r317, String r318, String r319, HeadMoreVideo r410, Map<String, ? extends IAction> r411) {
        this.f181946a = r100;
        this.f181947b = r101;
        this.f181948c = r102;
        this.f181949d = r103;
        this.f181950e = r104;
        this.f181951f = r105;
        this.f181952g = r106;
        this.f181953h = r110;
        this.f181954i = r111;
        this.f181955j = r112;
        this.f181956k = r113;
        this.f181957l = r114;
        this.f181958m = r115;
        this.f181959n = r116;
        this.f181960o = r117;
        this.f181961p = r118;
        this.f181962q = r119;
        this.f181963r = r210;
        this.f181964s = r211;
        this.f181965t = r212;
        this.f181966u = r213;
        this.f181967v = r214;
        this.f181968w = r215;
        this.f181969x = r216;
        this.f181970y = r217;
        this.f181971z = r218;
        this.A = r219;
        this.B = r310;
        this.C = r311;
        this.D = r312;
        this.E = r313;
        this.F = r314;
        this.G = r315;
        this.H = r316;
        this.I = r317;
        this.f181945J = r318;
        this.K = r319;
        this.L = r410;
        this.M = r411;
    }

    public static n a(n r310, PageMeta r410, Control r411, String r412, List r413, Map r414, com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r415, List r416, List r417, List r418, BottomButtonVO r419, TopRightControlsVO r510, HalfStrandVO r511, l73.c r512, PendantContainerVO r513, SmallVideoWindowVO r514, ShopFloatEntryVO r515, BackToTopEntryVO r516, PlayBackEntryVO r517, AnchorV4HeadV2VO r518, PromotionRecommendResponse r519, com.bytedance.android.shopping.anchorv4.dto.business.d r610, com.bytedance.android.shopping.anchorv3.i r611, List r612, com.bytedance.android.shopping.anchorv4.vm.a r613, String r614, Map r615, e73.a r616, JSONObject r617, List r618, Map r619, TopNavVO r710, BottomNavVO r711, TopBannerVO r712, GalleryVO r713, String r714, String r715, HeadMoreVideo r716, Map r717, int r718, int r719) {
        if ((r718 & 1) == 0) goto L5;
        PageMeta r100 = r310.f181946a;
    L7:
        if ((r718 & 2) == 0) goto L9;
        Control r101 = r310.f181947b;
    L11:
        if ((r718 & 4) == 0) goto L13;
        String r102 = r310.f181948c;
    L15:
        if ((r718 & 8) == 0) goto L17;
        List r103 = r310.f181949d;
    L19:
        if ((r718 & 16) == 0) goto L21;
        Map r104 = r310.f181950e;
    L23:
        if ((r718 & 32) == 0) goto L25;
        com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r105 = r310.f181951f;
    L27:
        if ((r718 & 64) == 0) goto L29;
        List r106 = r310.f181952g;
    L31:
        if ((r718 & 128) == 0) goto L33;
        List r107 = r310.f181953h;
    L35:
        if ((r718 & 256) == 0) goto L37;
        List r110 = r310.f181954i;
    L39:
        if ((r718 & 512) == 0) goto L41;
        j63.a r111 = r310.f181955j;
    L43:
        if ((r718 & 1024) == 0) goto L45;
        BottomButtonVO r112 = r310.f181956k;
    L47:
        if ((r718 & 2048) == 0) goto L49;
        TopRightControlsVO r113 = r310.f181957l;
    L51:
        if ((r718 & 4096) == 0) goto L53;
        HalfStrandVO r114 = r310.f181958m;
    L55:
        if ((r718 & 8192) == 0) goto L57;
        l73.c r115 = r310.f181959n;
    L58:
        l73.c r116 = r115;
        if ((r718 & 16384) == 0) goto L61;
        PendantContainerVO r117 = r310.f181960o;
    L63:
        if ((r718 & 32768) == 0) goto L65;
        SmallVideoWindowVO r118 = r310.f181961p;
    L67:
        if ((r718 & 65536) == 0) goto L69;
        ShopFloatEntryVO r119 = r310.f181962q;
    L71:
        if ((r718 & 131072) == 0) goto L73;
        BackToTopEntryVO r120 = r310.f181963r;
    L75:
        if ((r718 & 262144) == 0) goto L77;
        PlayBackEntryVO r121 = r310.f181964s;
    L79:
        if ((r718 & 524288) == 0) goto L81;
        AnchorV4HeadV2VO r122 = r310.f181965t;
    L83:
        if ((r718 & 1048576) == 0) goto L85;
        PromotionRecommendResponse r123 = r310.f181966u;
    L87:
        if ((r718 & 2097152) == 0) goto L89;
        com.bytedance.android.shopping.anchorv4.dto.business.d r124 = r310.f181967v;
    L91:
        if ((r718 & 4194304) == 0) goto L93;
        com.bytedance.android.shopping.anchorv3.i r125 = r310.f181968w;
    L95:
        if ((r718 & 8388608) == 0) goto L97;
        List r126 = r310.f181969x;
    L99:
        if ((r718 & 16777216) == 0) goto L101;
        com.bytedance.android.shopping.anchorv4.vm.a r127 = r310.f181970y;
    L103:
        if ((r718 & 33554432) == 0) goto L105;
        String r128 = r310.f181971z;
    L107:
        if ((r718 & 67108864) == 0) goto L109;
        Map r129 = r310.A;
    L111:
        if ((r718 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        e73.a r130 = r310.B;
    L115:
        if ((r718 & 268435456) == 0) goto L117;
        JSONObject r131 = r310.C;
    L119:
        if ((r718 & 536870912) == 0) goto L121;
        List r132 = r310.D;
    L123:
        if ((r718 & 1073741824) == 0) goto L125;
        Map r133 = r310.E;
    L127:
        if ((r718 & Integer.MIN_VALUE) == 0) goto L129;
        TopNavVO r108 = r310.F;
    L130:
        TopNavVO r720 = r108;
        if ((r719 & 1) == 0) goto L133;
        BottomNavVO r109 = r310.G;
    L135:
        if ((r719 & 2) == 0) goto L137;
        TopBannerVO r134 = r310.H;
    L139:
        if ((r719 & 4) == 0) goto L141;
        GalleryVO r135 = r310.I;
    L143:
        if ((r719 & 8) == 0) goto L145;
        String r136 = r310.f181945J;
    L147:
        if ((r719 & 16) == 0) goto L149;
        String r137 = r310.K;
    L151:
        if ((r719 & 32) == 0) goto L153;
        HeadMoreVideo r138 = r310.L;
    L155:
        if ((r719 & 64) == 0) goto L157;
        Map r139 = r310.M;
    L158:
        r310.getClass();
        return new n(r100, r101, r102, r103, r104, r105, r106, r107, r110, r111, r112, r113, r114, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127, r128, r129, r130, r131, r132, r133, r720, r109, r134, r135, r136, r137, r138, r139);
    L157:
        r139 = r717;
        goto L158
    L153:
        r138 = r716;
        goto L155
    L149:
        r137 = r715;
        goto L151
    L145:
        r136 = r714;
        goto L147
    L141:
        r135 = r713;
        goto L143
    L137:
        r134 = r712;
        goto L139
    L133:
        r109 = r711;
        goto L135
    L129:
        r108 = r710;
        goto L130
    L125:
        r133 = r619;
        goto L127
    L121:
        r132 = r618;
        goto L123
    L117:
        r131 = r617;
        goto L119
    L113:
        r130 = r616;
        goto L115
    L109:
        r129 = r615;
        goto L111
    L105:
        r128 = r614;
        goto L107
    L101:
        r127 = r613;
        goto L103
    L97:
        r126 = r612;
        goto L99
    L93:
        r125 = r611;
        goto L95
    L89:
        r124 = r610;
        goto L91
    L85:
        r123 = r519;
        goto L87
    L81:
        r122 = r518;
        goto L83
    L77:
        r121 = r517;
        goto L79
    L73:
        r120 = r516;
        goto L75
    L69:
        r119 = r515;
        goto L71
    L65:
        r118 = r514;
        goto L67
    L61:
        r117 = r513;
        goto L63
    L57:
        r115 = r512;
        goto L58
    L53:
        r114 = r511;
        goto L55
    L49:
        r113 = r510;
        goto L51
    L45:
        r112 = r419;
        goto L47
    L41:
        r111 = null;
        goto L43
    L37:
        r110 = r418;
        goto L39
    L33:
        r107 = r417;
        goto L35
    L29:
        r106 = r416;
        goto L31
    L25:
        r105 = r415;
        goto L27
    L21:
        r104 = r414;
        goto L23
    L17:
        r103 = r413;
        goto L19
    L13:
        r102 = r412;
        goto L15
    L9:
        r101 = r411;
        goto L11
    L5:
        r100 = r410;
        goto L7
    }
}
