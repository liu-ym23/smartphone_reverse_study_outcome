package com.bytedance.android.shopping.anchorv4.voavhs.head;

import android.graphics.drawable.Drawable;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.anchorv3.matchpurchase.model.CombinationVO;
import com.bytedance.android.shopping.anchorv4.dto.base.Link;
import com.bytedance.android.shopping.anchorv4.dto.elements.KolReviewElement;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.GaussianBlurConfig;
import com.bytedance.android.shopping.anchorv4.voavhs.head.view.FeaturedComment;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import java.util.HashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final HashMap<Integer, String> f168527J = null;
    public final List<KolReviewElement> A;
    public final h83.a B;
    public final m C;
    public final boolean D;
    public final boolean E;
    public final GaussianBlurConfig F;
    public final String G;
    public final String H;
    public final p I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f168528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECUrlModel f168529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ECUrlModel f168530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ECUrlModel f168531d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Link f168532e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Drawable f168533f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final CombinationVO f168534g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ECUrlModel f168535h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b f168536i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f168537j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.android.shopping.anchorv4.voavhs.head.view.w f168538k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final FeaturedComment f168539l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f168540m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f168541n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Boolean f168542o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f168543p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f168544q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CommonFindSameElement f168545r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.bytedance.android.shopping.anchorv4.dto.business.d f168546s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ScrollMoreText f168547t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f168548u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f168549v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final GaussianBlurConfig f168550w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<ECUrlModel> f168551x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List<String> f168552y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final List<String> f168553z;

    public static final class a {
        public static int a(String r100) {
            if (r100 == null) goto L9;
            String r101 = (String) CollectionsKt.firstOrNull(StringsKt.split$default(r100, new String[]{"_"}, false, 0, 6, null));
            if (r101 == null) goto L9;
            Integer r102 = StringsKt.toIntOrNull(r101);
            if (r102 == null) goto L9;
            return r102.intValue();
        L9:
            return 0;
        }
    }

    public c() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, -1, 7);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L76;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f168528a, r101.f168528a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f168529b, r101.f168529b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f168530c, r101.f168530c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f168531d, r101.f168531d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f168532e, r101.f168532e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f168533f, r101.f168533f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f168534g, r101.f168534g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f168535h, r101.f168535h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f168536i, r101.f168536i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f168537j, r101.f168537j) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.f168538k, r101.f168538k) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.f168539l, r101.f168539l) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f168540m, r101.f168540m) == true) goto L32;
        return false;
    L32:
        if (this.f168541n == r101.f168541n) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f168542o, r101.f168542o) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f168543p, r101.f168543p) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.f168544q, r101.f168544q) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.f168545r, r101.f168545r) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f168546s, r101.f168546s) == true) goto L44;
        return false;
    L44:
        if (Intrinsics.areEqual(this.f168547t, r101.f168547t) == true) goto L46;
        return false;
    L46:
        if (Intrinsics.areEqual(this.f168548u, r101.f168548u) == true) goto L48;
        return false;
    L48:
        if (this.f168549v == r101.f168549v) goto L50;
        return false;
    L50:
        if (Intrinsics.areEqual(this.f168550w, r101.f168550w) == true) goto L52;
        return false;
    L52:
        if (Intrinsics.areEqual(this.f168551x, r101.f168551x) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f168552y, r101.f168552y) == true) goto L56;
        return false;
    L56:
        if (Intrinsics.areEqual(this.f168553z, r101.f168553z) == true) goto L58;
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
        if (this.D == r101.D) goto L66;
        return false;
    L66:
        if (this.E == r101.E) goto L68;
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
        if (Intrinsics.areEqual(this.I, r101.I) == true) goto L115;
        return false;
    L115:
        return true;
    L76:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v44, types: [int] */
    /* JADX WARN: Type inference failed for: r2v105 */
    /* JADX WARN: Type inference failed for: r2v125 */
    /* JADX WARN: Type inference failed for: r2v126 */
    /* JADX WARN: Type inference failed for: r2v59, types: [int] */
    /* JADX WARN: Type inference failed for: r2v82, types: [int] */
    /* JADX WARN: Type inference failed for: r2v97 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public final int hashCode() {
        String r100 = this.f168528a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.f168529b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        ECUrlModel r107 = this.f168530c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        ECUrlModel r110 = this.f168531d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Link r113 = this.f168532e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Drawable r116 = this.f168533f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        CombinationVO r119 = this.f168534g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        ECUrlModel r122 = this.f168535h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r125 = this.f168536i;
        if (r125 == null) goto L37;
        int r126 = r125.hashCode();
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f168537j;
        if (r128 == null) goto L41;
        int r129 = r128.hashCode();
    L42:
        int r130 = (r127 + r129) * 31;
        com.bytedance.android.shopping.anchorv4.voavhs.head.view.w r131 = this.f168538k;
        if (r131 == null) goto L45;
        int r132 = r131.hashCode();
    L46:
        int r133 = (r130 + r132) * 31;
        FeaturedComment r134 = this.f168539l;
        if (r134 == null) goto L49;
        int r135 = r134.hashCode();
    L50:
        int r136 = (r133 + r135) * 31;
        String r137 = this.f168540m;
        if (r137 == null) goto L53;
        int r138 = r137.hashCode();
    L54:
        int r139 = (((r136 + r138) * 31) + this.f168541n) * 31;
        Boolean r140 = this.f168542o;
        if (r140 == null) goto L57;
        int r141 = r140.hashCode();
    L58:
        int r142 = (r139 + r141) * 31;
        String r143 = this.f168543p;
        if (r143 == null) goto L61;
        int r144 = r143.hashCode();
    L62:
        int r145 = (r142 + r144) * 31;
        String r146 = this.f168544q;
        if (r146 == null) goto L65;
        int r147 = r146.hashCode();
    L66:
        int r148 = (r145 + r147) * 31;
        CommonFindSameElement r149 = this.f168545r;
        if (r149 == null) goto L69;
        int r150 = r149.hashCode();
    L70:
        int r151 = (r148 + r150) * 31;
        com.bytedance.android.shopping.anchorv4.dto.business.d r152 = this.f168546s;
        if (r152 == null) goto L73;
        int r153 = r152.hashCode();
    L74:
        int r154 = (r151 + r153) * 31;
        ScrollMoreText r155 = this.f168547t;
        if (r155 == null) goto L77;
        int r156 = r155.hashCode();
    L78:
        int r157 = (r154 + r156) * 31;
        String r158 = this.f168548u;
        if (r158 == null) goto L81;
        int r159 = r158.hashCode();
    L82:
        int r160 = (r157 + r159) * 31;
        boolean r161 = this.f168549v;
        ?? r162 = 1;
        ?? r163 = r161;
        if (r161 == false) goto L85;
        r163 = 1;
    L85:
        int r164 = (r160 + r163) * 31;
        GaussianBlurConfig r165 = this.f168550w;
        if (r165 == null) goto L88;
        int r166 = r165.hashCode();
    L89:
        int r167 = (r164 + r166) * 31;
        List<ECUrlModel> r168 = this.f168551x;
        if (r168 == null) goto L92;
        int r169 = r168.hashCode();
    L93:
        int r170 = (r167 + r169) * 31;
        List<String> r171 = this.f168552y;
        if (r171 == null) goto L96;
        int r172 = r171.hashCode();
    L97:
        int r173 = (r170 + r172) * 31;
        List<String> r174 = this.f168553z;
        if (r174 == null) goto L100;
        int r175 = r174.hashCode();
    L101:
        int r176 = (r173 + r175) * 31;
        List<KolReviewElement> r177 = this.A;
        if (r177 == null) goto L104;
        int r178 = r177.hashCode();
    L105:
        int r179 = (r176 + r178) * 31;
        h83.a r180 = this.B;
        if (r180 == null) goto L108;
        int r181 = r180.hashCode();
    L109:
        int r182 = (r179 + r181) * 31;
        m r183 = this.C;
        if (r183 == null) goto L112;
        int r184 = r183.hashCode();
    L113:
        int r185 = (r182 + r184) * 31;
        boolean r186 = this.D;
        ?? r187 = r186;
        if (r186 == false) goto L116;
        r187 = 1;
    L116:
        int r188 = (r185 + r187) * 31;
        boolean r189 = this.E;
        if (r189 == true) goto L120;
        r162 = r189;
    L120:
        int r190 = (r188 + r162) * 31;
        GaussianBlurConfig r191 = this.F;
        if (r191 == null) goto L123;
        int r192 = r191.hashCode();
    L124:
        int r193 = (r190 + r192) * 31;
        String r194 = this.G;
        if (r194 == null) goto L127;
        int r195 = r194.hashCode();
    L128:
        int r196 = (r193 + r195) * 31;
        String r197 = this.H;
        if (r197 == null) goto L131;
        int r198 = r197.hashCode();
    L132:
        int r199 = (r196 + r198) * 31;
        p r200 = this.I;
        if (r200 == null) goto L136;
        r101 = r200.hashCode();
    L136:
        return r199 + r101;
    L131:
        r198 = 0;
        goto L132
    L127:
        r195 = 0;
        goto L128
    L123:
        r192 = 0;
        goto L124
    L112:
        r184 = 0;
        goto L113
    L108:
        r181 = 0;
        goto L109
    L104:
        r178 = 0;
        goto L105
    L100:
        r175 = 0;
        goto L101
    L96:
        r172 = 0;
        goto L97
    L92:
        r169 = 0;
        goto L93
    L88:
        r166 = 0;
        goto L89
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
        return "AnchorV4HeadNodeVO(type=" + this.f168528a + ", image=" + this.f168529b + ", atmosphereImage=" + this.f168530c + ", entryIcon=" + this.f168531d + ", specialLink=" + this.f168532e + ", headerImagePlaceHolder=" + this.f168533f + ", combinationVO=" + this.f168534g + ", videoCoverImage=" + this.f168535h + ", playInfo=" + this.f168536i + ", videoSource=" + this.f168537j + ", featuredShowVO=" + this.f168538k + ", featuredCommentVO=" + this.f168539l + ", nodeGroupType=" + this.f168540m + ", itemType=" + this.f168541n + ", supportPreview=" + this.f168542o + ", linkSubType=" + this.f168543p + ", findSameGoodsSchema=" + this.f168544q + ", findSameGoodsTab=" + this.f168545r + ", IFindSameResp=" + this.f168546s + ", scrollMoreText=" + this.f168547t + ", contentDescription=" + this.f168548u + ", fullscreen=" + this.f168549v + ", blurConfig=" + this.f168550w + ", skuImageList=" + this.f168551x + ", skuTitleList=" + this.f168552y + ", skuFindSameSchemaList=" + this.f168553z + ", kolReviewList=" + this.A + ", kolAuthorInfo=" + this.B + ", kolVideoExtraInfo=" + this.C + ", supportKolVideoDetail=" + this.D + ", isLengthenedPicture=" + this.E + ", pictureBlurCompatConfig=" + this.F + ", productId=" + this.G + ", tabTypeName=" + this.H + ", slice=" + this.I + ")";
    }

    static {
        f168527J = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(0, "product"), TuplesKt.to(1, "size"), TuplesKt.to(2, "3d"), TuplesKt.to(3, "AR"), TuplesKt.to(4, "matching"), TuplesKt.to(5, EffectConstants.CHANNEL_TEST), TuplesKt.to(6, "comment"), TuplesKt.to(7, "similar"), TuplesKt.to(9, com.bytedance.android.ec.core.event.a.VALUE_INFLOW)});
    }

    public final String getType() {
        return this.f168528a;
    }

    public static c a(c r410, Drawable r411, String r412, int r413, Boolean r414, String r415, CommonFindSameElement r416, ScrollMoreText r417, boolean r418, String r419, String r510, int r511, int r512) {
        p r100 = null;
        if ((r511 & 1) == 0) goto L5;
        String r101 = r410.f168528a;
    L7:
        if ((r511 & 2) == 0) goto L9;
        ECUrlModel r102 = r410.f168529b;
    L11:
        if ((r511 & 4) == 0) goto L13;
        ECUrlModel r103 = r410.f168530c;
    L15:
        if ((r511 & 8) == 0) goto L17;
        ECUrlModel r104 = r410.f168531d;
    L19:
        if ((r511 & 16) == 0) goto L21;
        Link r105 = r410.f168532e;
    L23:
        if ((r511 & 32) == 0) goto L25;
        Drawable r110 = r410.f168533f;
    L27:
        if ((r511 & 64) == 0) goto L29;
        CombinationVO r111 = r410.f168534g;
    L31:
        if ((r511 & 128) == 0) goto L33;
        ECUrlModel r112 = r410.f168535h;
    L35:
        if ((r511 & 256) == 0) goto L37;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r113 = r410.f168536i;
    L39:
        if ((r511 & 512) == 0) goto L41;
        String r114 = r410.f168537j;
    L43:
        if ((r511 & 1024) == 0) goto L45;
        com.bytedance.android.shopping.anchorv4.voavhs.head.view.w r115 = r410.f168538k;
    L47:
        if ((r511 & 2048) == 0) goto L49;
        FeaturedComment r116 = r410.f168539l;
    L51:
        if ((r511 & 4096) == 0) goto L53;
        String r106 = r410.f168540m;
    L55:
        if ((r511 & 8192) == 0) goto L57;
        int r117 = r410.f168541n;
    L59:
        if ((r511 & 16384) == 0) goto L61;
        Boolean r118 = r410.f168542o;
    L63:
        if ((32768 & r511) == 0) goto L65;
        String r210 = r410.f168543p;
    L67:
        if ((65536 & r511) == 0) goto L69;
        String r211 = r410.f168544q;
    L71:
        if ((131072 & r511) == 0) goto L73;
        CommonFindSameElement r212 = r410.f168545r;
    L75:
        if ((262144 & r511) == 0) goto L77;
        com.bytedance.android.shopping.anchorv4.dto.business.d r213 = r410.f168546s;
    L79:
        if ((524288 & r511) == 0) goto L81;
        ScrollMoreText r214 = r410.f168547t;
    L83:
        if ((1048576 & r511) == 0) goto L85;
        String r215 = r410.f168548u;
    L87:
        if ((2097152 & r511) == 0) goto L89;
        boolean r216 = r410.f168549v;
    L91:
        if ((4194304 & r511) == 0) goto L93;
        GaussianBlurConfig r217 = r410.f168550w;
    L95:
        if ((8388608 & r511) == 0) goto L97;
        List<ECUrlModel> r218 = r410.f168551x;
    L99:
        if ((16777216 & r511) == 0) goto L101;
        List<String> r219 = r410.f168552y;
    L103:
        if ((33554432 & r511) == 0) goto L105;
        List<String> r310 = r410.f168553z;
    L107:
        if ((67108864 & r511) == 0) goto L109;
        List<KolReviewElement> r311 = r410.A;
    L111:
        if ((134217728 & r511) == 0) goto L113;
        h83.a r312 = r410.B;
    L115:
        if ((268435456 & r511) == 0) goto L117;
        m r313 = r410.C;
    L119:
        if ((536870912 & r511) == 0) goto L121;
        boolean r314 = r410.D;
    L123:
        if ((1073741824 & r511) == 0) goto L125;
        boolean r315 = r410.E;
    L127:
        if ((r511 & Integer.MIN_VALUE) == 0) goto L129;
        GaussianBlurConfig r316 = r410.F;
    L131:
        if ((r512 & 1) == 0) goto L133;
        String r317 = r410.G;
    L135:
        if ((r512 & 2) == 0) goto L137;
        String r318 = r410.H;
    L139:
        if ((r512 & 4) == 0) goto L141;
        r100 = r410.I;
    L141:
        r410.getClass();
        Intrinsics.checkNotNullParameter(r106, "nodeGroupType");
        return new c(r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r116, r106, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r100);
    L137:
        r318 = r510;
        goto L139
    L133:
        r317 = r419;
        goto L135
    L129:
        r316 = null;
        goto L131
    L125:
        r315 = r418;
        goto L127
    L121:
        r314 = false;
        goto L123
    L117:
        r313 = null;
        goto L119
    L113:
        r312 = null;
        goto L115
    L109:
        r311 = null;
        goto L111
    L105:
        r310 = null;
        goto L107
    L101:
        r219 = null;
        goto L103
    L97:
        r218 = null;
        goto L99
    L93:
        r217 = null;
        goto L95
    L89:
        r216 = false;
        goto L91
    L85:
        r215 = null;
        goto L87
    L81:
        r214 = r417;
        goto L83
    L77:
        r213 = null;
        goto L79
    L73:
        r212 = r416;
        goto L75
    L69:
        r211 = r415;
        goto L71
    L65:
        r210 = null;
        goto L67
    L61:
        r118 = r414;
        goto L63
    L57:
        r117 = r413;
        goto L59
    L53:
        r106 = r412;
        goto L55
    L49:
        r116 = null;
        goto L51
    L45:
        r115 = null;
        goto L47
    L41:
        r114 = null;
        goto L43
    L37:
        r113 = null;
        goto L39
    L33:
        r112 = null;
        goto L35
    L29:
        r111 = null;
        goto L31
    L25:
        r110 = r411;
        goto L27
    L21:
        r105 = null;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public /* synthetic */ c(String r410, ECUrlModel r411, ECUrlModel r412, Link r413, CombinationVO r414, ECUrlModel r415, com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r416, String r417, com.bytedance.android.shopping.anchorv4.voavhs.head.view.w r418, FeaturedComment r419, String r510, String r511, CommonFindSameElement r512, String r513, GaussianBlurConfig r514, List r515, List r516, List r517, List r518, h83.a r519, m r610, boolean r611, p r612, int r613, int r614) {
        if ((r613 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r613 & 2) == 0) goto L9;
        ECUrlModel r101 = null;
    L11:
        if ((r613 & 8) == 0) goto L13;
        ECUrlModel r102 = null;
    L15:
        if ((r613 & 16) == 0) goto L17;
        Link r103 = null;
    L19:
        if ((r613 & 64) == 0) goto L21;
        CombinationVO r110 = null;
    L23:
        if ((r613 & 128) == 0) goto L25;
        ECUrlModel r111 = null;
    L27:
        if ((r613 & 256) == 0) goto L29;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r112 = null;
    L31:
        if ((r613 & 512) == 0) goto L33;
        String r113 = null;
    L35:
        if ((r613 & 1024) == 0) goto L37;
        com.bytedance.android.shopping.anchorv4.voavhs.head.view.w r114 = null;
    L39:
        if ((r613 & 2048) == 0) goto L41;
        FeaturedComment r115 = null;
    L43:
        if ((r613 & 4096) == 0) goto L45;
        String r116 = "0";
    L47:
        if ((32768 & r613) == 0) goto L49;
        String r117 = null;
    L51:
        if ((131072 & r613) == 0) goto L53;
        CommonFindSameElement r210 = null;
    L55:
        if ((1048576 & r613) == 0) goto L57;
        String r211 = null;
    L59:
        if ((2097152 & r613) == 0) goto L61;
        boolean r212 = true;
    L63:
        if ((4194304 & r613) == 0) goto L65;
        GaussianBlurConfig r213 = null;
    L67:
        if ((8388608 & r613) == 0) goto L69;
        List r214 = null;
    L71:
        if ((16777216 & r613) == 0) goto L73;
        List r215 = null;
    L75:
        if ((33554432 & r613) == 0) goto L77;
        List r216 = null;
    L79:
        if ((67108864 & r613) == 0) goto L81;
        List r310 = null;
    L83:
        if ((134217728 & r613) == 0) goto L85;
        h83.a r311 = null;
    L87:
        if ((268435456 & r613) == 0) goto L89;
        m r312 = null;
    L91:
        if ((536870912 & r613) == 0) goto L93;
        boolean r313 = false;
    L95:
        if ((r613 & Integer.MIN_VALUE) == 0) goto L97;
        GaussianBlurConfig r314 = new GaussianBlurConfig(null, null, null, 7, null);
    L99:
        if ((r614 & 4) == 0) goto L101;
        p r315 = null;
    L102:
        this(r100, r101, null, r102, r103, null, r110, r111, r112, r113, r114, r115, r116, 0, null, r117, null, r210, null, null, r211, r212, r213, r214, r215, r216, r310, r311, r312, r313, false, r314, null, null, r315);
        return;
    L101:
        r315 = r612;
        goto L102
    L97:
        r314 = null;
        goto L99
    L93:
        r313 = r611;
        goto L95
    L89:
        r312 = r610;
        goto L91
    L85:
        r311 = r519;
        goto L87
    L81:
        r310 = r518;
        goto L83
    L77:
        r216 = r517;
        goto L79
    L73:
        r215 = r516;
        goto L75
    L69:
        r214 = r515;
        goto L71
    L65:
        r213 = r514;
        goto L67
    L61:
        r212 = false;
        goto L63
    L57:
        r211 = r513;
        goto L59
    L53:
        r210 = r512;
        goto L55
    L49:
        r117 = r511;
        goto L51
    L45:
        r116 = r510;
        goto L47
    L41:
        r115 = r419;
        goto L43
    L37:
        r114 = r418;
        goto L39
    L33:
        r113 = r417;
        goto L35
    L29:
        r112 = r416;
        goto L31
    L25:
        r111 = r415;
        goto L27
    L21:
        r110 = r414;
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

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r100, ECUrlModel r101, ECUrlModel r102, ECUrlModel r103, Link r104, Drawable r105, CombinationVO r110, ECUrlModel r111, com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r112, String r113, com.bytedance.android.shopping.anchorv4.voavhs.head.view.w r114, FeaturedComment r115, String r116, int r117, Boolean r118, String r119, String r210, CommonFindSameElement r211, com.bytedance.android.shopping.anchorv4.dto.business.d r212, ScrollMoreText r213, String r214, boolean r215, GaussianBlurConfig r216, List<? extends ECUrlModel> r217, List<String> r218, List<String> r219, List<KolReviewElement> r310, h83.a r311, m r312, boolean r313, boolean r314, GaussianBlurConfig r315, String r316, String r317, p r318) {
        Intrinsics.checkNotNullParameter(r116, "nodeGroupType");
        this.f168528a = r100;
        this.f168529b = r101;
        this.f168530c = r102;
        this.f168531d = r103;
        this.f168532e = r104;
        this.f168533f = r105;
        this.f168534g = r110;
        this.f168535h = r111;
        this.f168536i = r112;
        this.f168537j = r113;
        this.f168538k = r114;
        this.f168539l = r115;
        this.f168540m = r116;
        this.f168541n = r117;
        this.f168542o = r118;
        this.f168543p = r119;
        this.f168544q = r210;
        this.f168545r = r211;
        this.f168546s = r212;
        this.f168547t = r213;
        this.f168548u = r214;
        this.f168549v = r215;
        this.f168550w = r216;
        this.f168551x = r217;
        this.f168552y = r218;
        this.f168553z = r219;
        this.A = r310;
        this.B = r311;
        this.C = r312;
        this.D = r313;
        this.E = r314;
        this.F = r315;
        this.G = r316;
        this.H = r317;
        this.I = r318;
    }
}
