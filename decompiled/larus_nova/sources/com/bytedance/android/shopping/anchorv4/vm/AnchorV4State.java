package com.bytedance.android.shopping.anchorv4.vm;

import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionRecommendResponse;
import com.bytedance.android.shopping.anchorv4.bottom.BottomButtonVO;
import com.bytedance.android.shopping.anchorv4.bottomnav.BottomNavVO;
import com.bytedance.android.shopping.anchorv4.components.BackToTopEntryVO;
import com.bytedance.android.shopping.anchorv4.components.PendantsComponentVO;
import com.bytedance.android.shopping.anchorv4.components.ShopFloatEntryVO;
import com.bytedance.android.shopping.anchorv4.components.SmallVideoWindowVO;
import com.bytedance.android.shopping.anchorv4.components.topbanner.HalfStrandVO;
import com.bytedance.android.shopping.anchorv4.dto.ScrollNode;
import com.bytedance.android.shopping.anchorv4.dto.business.GalleryVO;
import com.bytedance.android.shopping.anchorv4.dto.business.HeadMoreVideo;
import com.bytedance.android.shopping.anchorv4.floatwidget.pendantContainer.PendantContainerVO;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.PlayBackEntryVO;
import com.bytedance.android.shopping.anchorv4.nav.controls.TopRightControlsVO;
import com.bytedance.android.shopping.anchorv4.topbanner.TopBannerVO;
import com.bytedance.android.shopping.anchorv4.topnav.TopNavVO;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.AnchorV4HeadV2VO;
import com.bytedance.jedi.arch.State;
import fi3.w0;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/vm/AnchorV4State;", "Lcom/bytedance/jedi/arch/State;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4State implements State {
    public final com.bytedance.android.shopping.anchorv4.bottom.b A;
    public final Boolean B;
    public final e73.a C;
    public final JSONObject D;
    public final List<String> E;
    public final Map<String, Object> F;
    public final TopNavVO G;
    public final BottomNavVO H;
    public final TopBannerVO I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final w0 f167682J;
    public final GalleryVO K;
    public final String L;
    public final String M;
    public final List<com.bytedance.android.ecom.arch.slice.adapter.b> N;
    public final HeadMoreVideo O;
    public final String P;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.ecom.arch.slice.adapter.b> f167683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, SlcElement> f167684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d f167685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.bytedance.android.shopping.anchorv4.voavhs.detailimages.d> f167686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<d63.d> f167687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<j63.c> f167688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j63.a f167689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BottomButtonVO f167690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TopRightControlsVO f167691i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final HalfStrandVO f167692j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final l73.c f167693k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PendantContainerVO f167694l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<String> f167695m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SmallVideoWindowVO f167696n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ShopFloatEntryVO f167697o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final BackToTopEntryVO f167698p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final PlayBackEntryVO f167699q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AnchorV4HeadV2VO f167700r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final PromotionRecommendResponse f167701s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.dto.business.d f167702t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv3.i f167703u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List<ScrollNode> f167704v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final a f167705w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final d f167706x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Map<String, PendantsComponentVO> f167707y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f167708z;

    public AnchorV4State() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorV4State) == false) goto L90;
        AnchorV4State r101 = (AnchorV4State) r100;
        if (Intrinsics.areEqual(this.f167683a, r101.f167683a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f167684b, r101.f167684b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f167685c, r101.f167685c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f167686d, r101.f167686d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f167687e, r101.f167687e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f167688f, r101.f167688f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f167689g, r101.f167689g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f167690h, r101.f167690h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f167691i, r101.f167691i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f167692j, r101.f167692j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f167693k, r101.f167693k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f167694l, r101.f167694l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f167695m, r101.f167695m) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f167696n, r101.f167696n) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f167697o, r101.f167697o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f167698p, r101.f167698p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f167699q, r101.f167699q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f167700r, r101.f167700r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f167701s, r101.f167701s) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.f167702t, r101.f167702t) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.f167703u, r101.f167703u) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f167704v, r101.f167704v) == true) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.f167705w, r101.f167705w) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.f167706x, r101.f167706x) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f167707y, r101.f167707y) == true) goto L56;
        return false;
    L56:
        if (this.f167708z == r101.f167708z) goto L58;
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
        if (Intrinsics.areEqual(this.f167682J, r101.f167682J) == true) goto L78;
        return false;
    L78:
        if (Intrinsics.areEqual(this.K, r101.K) == true) goto L80;
        return false;
    L80:
        if (Intrinsics.areEqual(this.L, r101.L) == true) goto L82;
        return false;
    L82:
        if (Intrinsics.areEqual(this.M, r101.M) == true) goto L84;
        return false;
    L84:
        if (Intrinsics.areEqual(this.N, r101.N) == true) goto L86;
        return false;
    L86:
        if (Intrinsics.areEqual(this.O, r101.O) == true) goto L88;
        return false;
    L88:
        if (Intrinsics.areEqual(this.P, r101.P) == true) goto L136;
        return false;
    L136:
        return true;
    L90:
        return false;
    }

    public final int hashCode() {
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r100 = this.f167683a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Map<String, SlcElement> r104 = this.f167684b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r107 = this.f167685c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<com.bytedance.android.shopping.anchorv4.voavhs.detailimages.d> r110 = this.f167686d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        List<d63.d> r113 = this.f167687e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        List<j63.c> r116 = this.f167688f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        j63.a r119 = this.f167689g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        BottomButtonVO r122 = this.f167690h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        TopRightControlsVO r125 = this.f167691i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        HalfStrandVO r128 = this.f167692j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        l73.c r131 = this.f167693k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        PendantContainerVO r134 = this.f167694l;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        List<String> r137 = this.f167695m;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (r136 + r138) * 31;
        SmallVideoWindowVO r140 = this.f167696n;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        ShopFloatEntryVO r143 = this.f167697o;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        BackToTopEntryVO r146 = this.f167698p;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        PlayBackEntryVO r149 = this.f167699q;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        AnchorV4HeadV2VO r152 = this.f167700r;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        PromotionRecommendResponse r155 = this.f167701s;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        com.bytedance.android.shopping.anchorv4.dto.business.d r158 = this.f167702t;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        com.bytedance.android.shopping.anchorv3.i r161 = this.f167703u;
        if (r161 == null) goto L85;
        int r162 = r161.hashCode();
    L86:
        int r163 = (r160 + r162) * 31;
        List<ScrollNode> r164 = this.f167704v;
        if (r164 == null) goto L89;
        int r165 = r164.hashCode();
    L90:
        int r166 = (r163 + r165) * 31;
        a r167 = this.f167705w;
        if (r167 == null) goto L93;
        int r168 = r167.hashCode();
    L94:
        int r169 = (r166 + r168) * 31;
        d r170 = this.f167706x;
        if (r170 == null) goto L97;
        int r171 = r170.hashCode();
    L98:
        int r172 = (r169 + r171) * 31;
        Map<String, PendantsComponentVO> r173 = this.f167707y;
        if (r173 == null) goto L101;
        int r174 = r173.hashCode();
    L102:
        int r175 = (((r172 + r174) * 31) + this.f167708z) * 31;
        com.bytedance.android.shopping.anchorv4.bottom.b r176 = this.A;
        if (r176 == null) goto L105;
        int r177 = r176.hashCode();
    L106:
        int r178 = (r175 + r177) * 31;
        Boolean r179 = this.B;
        if (r179 == null) goto L109;
        int r180 = r179.hashCode();
    L110:
        int r181 = (r178 + r180) * 31;
        e73.a r182 = this.C;
        if (r182 == null) goto L113;
        int r183 = r182.hashCode();
    L114:
        int r184 = (r181 + r183) * 31;
        JSONObject r185 = this.D;
        if (r185 == null) goto L117;
        int r186 = r185.hashCode();
    L118:
        int r187 = (r184 + r186) * 31;
        List<String> r188 = this.E;
        if (r188 == null) goto L121;
        int r189 = r188.hashCode();
    L122:
        int r190 = (r187 + r189) * 31;
        Map<String, Object> r191 = this.F;
        if (r191 == null) goto L125;
        int r192 = r191.hashCode();
    L126:
        int r193 = (r190 + r192) * 31;
        TopNavVO r194 = this.G;
        if (r194 == null) goto L129;
        int r195 = r194.hashCode();
    L130:
        int r196 = (r193 + r195) * 31;
        BottomNavVO r197 = this.H;
        if (r197 == null) goto L133;
        int r198 = r197.hashCode();
    L134:
        int r199 = (r196 + r198) * 31;
        TopBannerVO r200 = this.I;
        if (r200 == null) goto L137;
        int r201 = r200.hashCode();
    L138:
        int r202 = (r199 + r201) * 31;
        w0 r203 = this.f167682J;
        if (r203 == null) goto L141;
        int r204 = r203.hashCode();
    L142:
        int r205 = (r202 + r204) * 31;
        GalleryVO r206 = this.K;
        if (r206 == null) goto L145;
        int r207 = r206.hashCode();
    L146:
        int r208 = (r205 + r207) * 31;
        String r209 = this.L;
        if (r209 == null) goto L149;
        int r210 = r209.hashCode();
    L150:
        int r211 = (r208 + r210) * 31;
        String r212 = this.M;
        if (r212 == null) goto L153;
        int r213 = r212.hashCode();
    L154:
        int r214 = (r211 + r213) * 31;
        List<com.bytedance.android.ecom.arch.slice.adapter.b> r215 = this.N;
        if (r215 == null) goto L157;
        int r216 = r215.hashCode();
    L158:
        int r217 = (r214 + r216) * 31;
        HeadMoreVideo r218 = this.O;
        if (r218 == null) goto L161;
        int r219 = r218.hashCode();
    L162:
        int r220 = (r217 + r219) * 31;
        String r221 = this.P;
        if (r221 == null) goto L166;
        r101 = r221.hashCode();
    L166:
        return r220 + r101;
    L161:
        r219 = 0;
        goto L162
    L157:
        r216 = 0;
        goto L158
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
        return "AnchorV4State(componentVOS=" + this.f167683a + ", templates=" + this.f167684b + ", detailHeadVO=" + this.f167685c + ", detailImageVOS=" + this.f167686d + ", unifiedTipsVOS=" + this.f167687e + ", guessUVOS=" + this.f167688f + ", showGuessULike=" + this.f167689g + ", bottomButtonVO=" + this.f167690h + ", topRightControlsVO=" + this.f167691i + ", halfStrandVO=" + this.f167692j + ", questionnaireEntrance=" + this.f167693k + ", pendantContainerVO=" + this.f167694l + ", showMoreEntrance=" + this.f167695m + ", smallVideoWindowVO=" + this.f167696n + ", shopFloatEntry=" + this.f167697o + ", backToTopEntry=" + this.f167698p + ", playBackEntryVO=" + this.f167699q + ", headV2=" + this.f167700r + ", shopRecommends=" + this.f167701s + ", IFindSameGoods=" + this.f167702t + ", searchSuggest=" + this.f167703u + ", scrollNodes=" + this.f167704v + ", collapseInfo=" + this.f167705w + ", lastPageState=" + this.f167706x + ", pendantsVOS=" + this.f167707y + ", interactTime=" + this.f167708z + ", addCartGuide=" + this.A + ", bottomTipsVisible=" + this.B + ", globalAction=" + this.C + ", pdpLynxDataAfterPack=" + this.D + ", detailImageList=" + this.E + ", supermarketCartBarData=" + this.F + ", topNavVO=" + this.G + ", bottomNavVO=" + this.H + ", topBannerVO=" + this.I + ", titleSingleLineData=" + this.f167682J + ", galleryVO=" + this.K + ", commentPreloadData=" + this.L + ", mcpData=" + this.M + ", instantRevisionRecommendData=" + this.N + ", moreVideo=" + this.O + ", backgroundColor=" + this.P + ")";
    }

    public /* synthetic */ AnchorV4State(int r410) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnchorV4State(List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r100, Map<String, SlcElement> r101, com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r102, List<com.bytedance.android.shopping.anchorv4.voavhs.detailimages.d> r103, List<d63.d> r104, List<j63.c> r105, j63.a r106, BottomButtonVO r110, TopRightControlsVO r111, HalfStrandVO r112, l73.c r113, PendantContainerVO r114, List<String> r115, SmallVideoWindowVO r116, ShopFloatEntryVO r117, BackToTopEntryVO r118, PlayBackEntryVO r119, AnchorV4HeadV2VO r210, PromotionRecommendResponse r211, com.bytedance.android.shopping.anchorv4.dto.business.d r212, com.bytedance.android.shopping.anchorv3.i r213, List<ScrollNode> r214, a r215, d r216, Map<String, PendantsComponentVO> r217, int r218, com.bytedance.android.shopping.anchorv4.bottom.b r219, Boolean r310, e73.a r311, JSONObject r312, List<String> r313, Map<String, ? extends Object> r314, TopNavVO r315, BottomNavVO r316, TopBannerVO r317, w0 r318, GalleryVO r319, String r410, String r411, List<? extends com.bytedance.android.ecom.arch.slice.adapter.b> r412, HeadMoreVideo r413, String r414) {
        this.f167683a = r100;
        this.f167684b = r101;
        this.f167685c = r102;
        this.f167686d = r103;
        this.f167687e = r104;
        this.f167688f = r105;
        this.f167689g = r106;
        this.f167690h = r110;
        this.f167691i = r111;
        this.f167692j = r112;
        this.f167693k = r113;
        this.f167694l = r114;
        this.f167695m = r115;
        this.f167696n = r116;
        this.f167697o = r117;
        this.f167698p = r118;
        this.f167699q = r119;
        this.f167700r = r210;
        this.f167701s = r211;
        this.f167702t = r212;
        this.f167703u = r213;
        this.f167704v = r214;
        this.f167705w = r215;
        this.f167706x = r216;
        this.f167707y = r217;
        this.f167708z = r218;
        this.A = r219;
        this.B = r310;
        this.C = r311;
        this.D = r312;
        this.E = r313;
        this.F = r314;
        this.G = r315;
        this.H = r316;
        this.I = r317;
        this.f167682J = r318;
        this.K = r319;
        this.L = r410;
        this.M = r411;
        this.N = r412;
        this.O = r413;
        this.P = r414;
    }

    public static AnchorV4State a(AnchorV4State r110, List r111, Map r112, com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r210, List r211, List r212, List r213, j63.a r214, BottomButtonVO r215, TopRightControlsVO r216, HalfStrandVO r217, l73.c r218, PendantContainerVO r219, List r310, SmallVideoWindowVO r311, ShopFloatEntryVO r312, BackToTopEntryVO r313, PlayBackEntryVO r314, AnchorV4HeadV2VO r315, PromotionRecommendResponse r316, com.bytedance.android.shopping.anchorv4.dto.business.d r317, com.bytedance.android.shopping.anchorv3.i r318, List r319, a r410, d r411, Map r412, int r413, com.bytedance.android.shopping.anchorv4.bottom.b r414, Boolean r415, e73.a r416, JSONObject r417, List r418, Map r419, TopNavVO r510, BottomNavVO r511, TopBannerVO r512, w0 r513, GalleryVO r514, String r515, String r516, List r517, HeadMoreVideo r518, String r519, int r610, int r611) {
        if ((r610 & 1) == 0) goto L5;
        List r100 = r110.f167683a;
    L7:
        if ((r610 & 2) == 0) goto L9;
        Map r101 = r110.f167684b;
    L11:
        if ((r610 & 4) == 0) goto L13;
        com.bytedance.android.shopping.anchorv4.voavhs.detailhead.d r102 = r110.f167685c;
    L15:
        if ((r610 & 8) == 0) goto L17;
        List r103 = r110.f167686d;
    L19:
        if ((r610 & 16) == 0) goto L21;
        List r104 = r110.f167687e;
    L23:
        if ((r610 & 32) == 0) goto L25;
        List r105 = r110.f167688f;
    L27:
        if ((r610 & 64) == 0) goto L29;
        j63.a r106 = r110.f167689g;
    L31:
        if ((r610 & 128) == 0) goto L33;
        BottomButtonVO r113 = r110.f167690h;
    L35:
        if ((r610 & 256) == 0) goto L37;
        TopRightControlsVO r114 = r110.f167691i;
    L39:
        if ((r610 & 512) == 0) goto L41;
        HalfStrandVO r115 = r110.f167692j;
    L43:
        if ((r610 & 1024) == 0) goto L45;
        l73.c r116 = r110.f167693k;
    L47:
        if ((r610 & 2048) == 0) goto L49;
        PendantContainerVO r117 = r110.f167694l;
    L51:
        if ((r610 & 4096) == 0) goto L53;
        List r118 = r110.f167695m;
    L54:
        List r320 = r118;
        if ((r610 & 8192) == 0) goto L57;
        SmallVideoWindowVO r119 = r110.f167696n;
    L58:
        SmallVideoWindowVO r321 = r119;
        if ((r610 & 16384) == 0) goto L61;
        ShopFloatEntryVO r120 = r110.f167697o;
    L62:
        ShopFloatEntryVO r322 = r120;
        if ((r610 & 32768) == 0) goto L65;
        BackToTopEntryVO r121 = r110.f167698p;
    L66:
        BackToTopEntryVO r323 = r121;
        if ((r610 & 65536) == 0) goto L69;
        PlayBackEntryVO r122 = r110.f167699q;
    L70:
        PlayBackEntryVO r324 = r122;
        if ((r610 & 131072) == 0) goto L73;
        AnchorV4HeadV2VO r123 = r110.f167700r;
    L74:
        AnchorV4HeadV2VO r325 = r123;
        if ((r610 & 262144) == 0) goto L77;
        PromotionRecommendResponse r124 = r110.f167701s;
    L78:
        PromotionRecommendResponse r326 = r124;
        if ((r610 & 524288) == 0) goto L81;
        com.bytedance.android.shopping.anchorv4.dto.business.d r125 = r110.f167702t;
    L82:
        com.bytedance.android.shopping.anchorv4.dto.business.d r327 = r125;
        if ((r610 & 1048576) == 0) goto L85;
        com.bytedance.android.shopping.anchorv3.i r126 = r110.f167703u;
    L86:
        com.bytedance.android.shopping.anchorv3.i r328 = r126;
        if ((r610 & 2097152) == 0) goto L89;
        List r127 = r110.f167704v;
    L90:
        List r329 = r127;
        if ((r610 & 4194304) == 0) goto L93;
        a r128 = r110.f167705w;
    L94:
        a r420 = r128;
        if ((r610 & 8388608) == 0) goto L97;
        d r129 = r110.f167706x;
    L98:
        d r421 = r129;
        if ((r610 & 16777216) == 0) goto L101;
        Map r130 = r110.f167707y;
    L102:
        Map r422 = r130;
        if ((r610 & 33554432) == 0) goto L105;
        int r131 = r110.f167708z;
    L106:
        int r423 = r131;
        if ((r610 & 67108864) == 0) goto L109;
        com.bytedance.android.shopping.anchorv4.bottom.b r132 = r110.A;
    L110:
        com.bytedance.android.shopping.anchorv4.bottom.b r424 = r132;
        if ((r610 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L113;
        Boolean r133 = r110.B;
    L114:
        Boolean r425 = r133;
        if ((r610 & 268435456) == 0) goto L117;
        e73.a r134 = r110.C;
    L118:
        e73.a r426 = r134;
        if ((r610 & 536870912) == 0) goto L121;
        JSONObject r135 = r110.D;
    L122:
        JSONObject r427 = r135;
        if ((r610 & 1073741824) == 0) goto L125;
        List r136 = r110.E;
    L127:
        if ((r610 & Integer.MIN_VALUE) == 0) goto L129;
        Map r107 = r110.F;
    L130:
        Map r428 = r107;
        if ((r611 & 1) == 0) goto L133;
        TopNavVO r108 = r110.G;
    L134:
        TopNavVO r520 = r108;
        if ((r611 & 2) == 0) goto L137;
        BottomNavVO r109 = r110.H;
    L138:
        BottomNavVO r521 = r109;
        if ((r611 & 4) == 0) goto L141;
        TopBannerVO r137 = r110.I;
    L142:
        TopBannerVO r522 = r137;
        if ((r611 & 8) == 0) goto L145;
        w0 r138 = r110.f167682J;
    L146:
        w0 r523 = r138;
        if ((r611 & 16) == 0) goto L149;
        GalleryVO r139 = r110.K;
    L150:
        GalleryVO r524 = r139;
        if ((r611 & 32) == 0) goto L153;
        String r140 = r110.L;
    L154:
        String r525 = r140;
        if ((r611 & 64) == 0) goto L157;
        String r141 = r110.M;
    L158:
        String r526 = r141;
        if ((r611 & 128) == 0) goto L161;
        List r142 = r110.N;
    L162:
        List r527 = r142;
        if ((r611 & 256) == 0) goto L165;
        HeadMoreVideo r143 = r110.O;
    L167:
        if ((r611 & 512) == 0) goto L169;
        String r144 = r110.P;
    L170:
        r110.getClass();
        return new AnchorV4State(r100, r101, r102, r103, r104, r105, r106, r113, r114, r115, r116, r117, r320, r321, r322, r323, r324, r325, r326, r327, r328, r329, r420, r421, r422, r423, r424, r425, r426, r427, r136, r428, r520, r521, r522, r523, r524, r525, r526, r527, r143, r144);
    L169:
        r144 = r519;
        goto L170
    L165:
        r143 = r518;
        goto L167
    L161:
        r142 = r517;
        goto L162
    L157:
        r141 = r516;
        goto L158
    L153:
        r140 = r515;
        goto L154
    L149:
        r139 = r514;
        goto L150
    L145:
        r138 = r513;
        goto L146
    L141:
        r137 = r512;
        goto L142
    L137:
        r109 = r511;
        goto L138
    L133:
        r108 = r510;
        goto L134
    L129:
        r107 = r419;
        goto L130
    L125:
        r136 = r418;
        goto L127
    L121:
        r135 = r417;
        goto L122
    L117:
        r134 = r416;
        goto L118
    L113:
        r133 = r415;
        goto L114
    L109:
        r132 = r414;
        goto L110
    L105:
        r131 = r413;
        goto L106
    L101:
        r130 = r412;
        goto L102
    L97:
        r129 = r411;
        goto L98
    L93:
        r128 = r410;
        goto L94
    L89:
        r127 = r319;
        goto L90
    L85:
        r126 = r318;
        goto L86
    L81:
        r125 = r317;
        goto L82
    L77:
        r124 = r316;
        goto L78
    L73:
        r123 = r315;
        goto L74
    L69:
        r122 = r314;
        goto L70
    L65:
        r121 = r313;
        goto L66
    L61:
        r120 = r312;
        goto L62
    L57:
        r119 = r311;
        goto L58
    L53:
        r118 = r310;
        goto L54
    L49:
        r117 = r219;
        goto L51
    L45:
        r116 = r218;
        goto L47
    L41:
        r115 = r217;
        goto L43
    L37:
        r114 = r216;
        goto L39
    L33:
        r113 = r215;
        goto L35
    L29:
        r106 = r214;
        goto L31
    L25:
        r105 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }
}
