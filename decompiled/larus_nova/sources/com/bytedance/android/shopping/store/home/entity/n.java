package com.bytedance.android.shopping.store.home.entity;

import com.bytedance.android.ec.core.utils.t0;
import com.bytedance.android.ec.core.utils.w0;
import com.bytedance.android.ec.host.api.split.ECFoldScene;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ec.model.response.anchorv3.AuthorReputationDTO;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.bytedance.android.ec.store.repository.vo.AuthorReputationVO;
import com.bytedance.android.shopping.store.home.api.ECStoreParam;
import com.bytedance.android.shopping.store.home.slice.ECStoreHeaderInfoSliceConfig;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoInfoVO;
import com.bytedance.android.shopping.store.repository.vo.ShopHeaderVideoVO;
import com.bytedance.android.shopping.store.viewmodel.ShopFrameworkType;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes14.dex */
public final class n {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f183746r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ECAbnormalShopBasicInfo f183747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f183748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f183749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public uj3.b f183750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f183751e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public c f183752f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i f183753g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public p f183754h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public j f183755i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ECShopBrandHeaderStyleDto f183756j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Map<String, String> f183757k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ECShopBrandModuleInfo f183758l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Map<String, String> f183759m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ECShopHeadInfoBlock f183760n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public com.bytedance.android.shopping.store.home.slice.d f183761o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public im.v f183762p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f183763q;

    public static final class a {
        public static n a(ECShopHeadInfoBlock r210, ECStoreParam r211) {
            Intrinsics.checkNotNullParameter(r210, "response");
            n r100 = new n();
            Blcok r101 = r210.getBlock();
            if (r101 == null) goto L69;
            List<Module> r102 = r101.getModuleList();
            if (r102 == null) goto L69;
            Iterator r103 = r102.iterator();
            ECShopBrandHeaderStyleDto r104 = null;
            ECShopBrandModuleInfo r105 = null;
            ECShopBasicInfoModuleDTO r106 = null;
            Map<String, String> r107 = null;
            ECShopAccountInfoModuleDTO r108 = null;
            sj3.b r110 = null;
            ECShopConfigInfoModuleDTO r111 = null;
            ECShopMediaInfoModuleDTO r112 = null;
            ECShopLiveTabHomeInfoModuleDTO r113 = null;
            ECShopShareInfoModuleDTO r114 = null;
            ECAbnormalShopBasicInfo r115 = null;
            c r116 = null;
            p r117 = null;
        L8:
            if (r103.hasNext() == false) goto L68;
            Module r109 = (Module) r103.next();
            Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L64
            String r119 = r109.getName();     // Catch: Throwable -> L64
            Iterator r212 = r103;
            if (Intrinsics.areEqual(r119, ECShopModuleType.ABNORMAL_SHOP_BASIC_INFO.getType()) == false) goto L16;
            r115 = (ECAbnormalShopBasicInfo) new Gson().fromJson(r109.getData(), ECAbnormalShopBasicInfo.class);     // Catch: Throwable -> L62
        L60:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L62
        L67:
            r103 = r212;
            goto L8
        L16:
            if (Intrinsics.areEqual(r119, ECShopModuleType.SHOPBASICINFO.getType()) == false) goto L19;
            r106 = (ECShopBasicInfoModuleDTO) new Gson().fromJson(r109.getData(), ECShopBasicInfoModuleDTO.class);     // Catch: Throwable -> L62
            goto L60
        L19:
            if (Intrinsics.areEqual(r119, ECShopModuleType.SHOPACCOUNTINFO.getType()) == false) goto L22;
            r108 = (ECShopAccountInfoModuleDTO) new Gson().fromJson(r109.getData(), ECShopAccountInfoModuleDTO.class);     // Catch: Throwable -> L62
            goto L60
        L22:
            if (Intrinsics.areEqual(r119, ECShopModuleType.SHOPLISTINFO.getType()) == false) goto L25;
            r110 = (sj3.b) new Gson().fromJson(r109.getData(), sj3.b.class);     // Catch: Throwable -> L62
            goto L60
        L25:
            if (Intrinsics.areEqual(r119, ECShopModuleType.HOMECONFIGINFO.getType()) == false) goto L28;
            r111 = (ECShopConfigInfoModuleDTO) new Gson().fromJson(r109.getData(), ECShopConfigInfoModuleDTO.class);     // Catch: Throwable -> L62
            goto L60
        L28:
            if (Intrinsics.areEqual(r119, ECShopModuleType.ABNORMAL_SHOP_HOME_CONFIG_INFO.getType()) == false) goto L31;
            r116 = (c) new Gson().fromJson(r109.getData(), c.class);     // Catch: Throwable -> L62
            goto L60
        L31:
            if (Intrinsics.areEqual(r119, ECShopModuleType.SHOPMEDIAINFO.getType()) == false) goto L40;
            if (r211 == null) goto L34;
            ECFoldScene r120 = r211.getSplitParent();     // Catch: Throwable -> L62
        L36:
            if (r120 != ECFoldScene.VIDEO) goto L38;
            r100.f183762p = ((ECShopMediaInfoModuleDTO) new Gson().fromJson(r109.getData(), ECShopMediaInfoModuleDTO.class)).getLiveInfo();     // Catch: Throwable -> L62
            goto L60
        L38:
            r112 = (ECShopMediaInfoModuleDTO) new Gson().fromJson(r109.getData(), ECShopMediaInfoModuleDTO.class);     // Catch: Throwable -> L62
            goto L60
        L34:
            r120 = null;
            goto L36
        L40:
            if (Intrinsics.areEqual(r119, ECShopModuleType.SHOPHEADERSTYLE.getType()) == false) goto L43;
            r117 = (p) new Gson().fromJson(r109.getData(), p.class);     // Catch: Throwable -> L62
            goto L60
        L43:
            if (Intrinsics.areEqual(r119, ECShopModuleType.SHOP_LIVE_TAB_INFO.getType()) == false) goto L46;
            r113 = (ECShopLiveTabHomeInfoModuleDTO) new Gson().fromJson(r109.getData(), ECShopLiveTabHomeInfoModuleDTO.class);     // Catch: Throwable -> L62
            goto L60
        L46:
            if (Intrinsics.areEqual(r119, ECShopModuleType.SHOP_SHARE_INFO.getType()) == false) goto L49;
            r114 = (ECShopShareInfoModuleDTO) new Gson().fromJson(r109.getData(), ECShopShareInfoModuleDTO.class);     // Catch: Throwable -> L62
            goto L60
        L49:
            if (Intrinsics.areEqual(r119, ECShopModuleType.SHOPINFOLYNX.getType()) == true) goto L60;
            if (Intrinsics.areEqual(r119, ECShopModuleType.SHOPLOGEXTRA.getType()) == false) goto L55;
            int r121 = w0.f45736a;     // Catch: Throwable -> L62
            r107 = w0.a(r109.getData());     // Catch: Throwable -> L62
            goto L60
        L55:
            if (Intrinsics.areEqual(r119, ECShopModuleType.SHOP_BRAND_MODULE_INFO.getType()) == false) goto L58;
            r105 = (ECShopBrandModuleInfo) new Gson().fromJson(r109.getData(), ECShopBrandModuleInfo.class);     // Catch: Throwable -> L62
            goto L60
        L58:
            if (Intrinsics.areEqual(r119, ECShopModuleType.SHOP_BRAND_HEADER_STYLE.getType()) == false) goto L60;
            r104 = (ECShopBrandHeaderStyleDto) new Gson().fromJson(r109.getData(), ECShopBrandHeaderStyleDto.class);     // Catch: Throwable -> L62
        L62:
            th = th;
        L66:
            Result.Companion r122 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        L64:
            th = th;
            r212 = r103;
            goto L66
        L68:
            c r123 = r116;
            p r124 = r117;
        L70:
            r100.f183760n = r210;
            if (r106 == null) goto L80;
            int r125 = e.f183685s;
            Intrinsics.checkNotNullParameter(r106, "dto");
            e r126 = new e();
            r126.f183686a = r106.getShopId();
            r126.f183687b = r106.getShopName();
            r126.f183688c = r106.getShopLogo();
            r106.getBrandTag();
            AuthorReputationVO.a r127 = AuthorReputationVO.Companion;
            AuthorReputationDTO r128 = r106.getReputationDTO();
            r127.getClass();
            if (r128 != null) goto L75;
            AuthorReputationVO r129 = null;
        L76:
            r126.f183689d = r129;
            r126.f183690e = r106.getShowSales();
            r126.f183691f = r106.getShopValueInfo();
            r126.f183692g = r106.getShopValueInfoWhite();
            r126.f183693h = r106.getShopDisplayName();
            r126.f183694i = r106.getTagList();
            r106.getShopLogoIcon();
            r126.f183695j = r106.getShopXZGInfo();
            r126.f183696k = r106.getShopType();
            r126.f183697l = r106.getHeaderStyleConfig();
            r126.f183698m = r106.getShopTypeDescription();
            List<ECShopSellingPointDTO> r130 = r106.getShopSellingPoint();
            if (r130 != null) goto L79;
            r130 = CollectionsKt.emptyList();
        L79:
            Intrinsics.checkNotNullParameter(r130, "<set-?>");
            r126.f183699n = r130;
            r126.f183700o = r106.getTagV2List();
            r126.f183701p = r106.getTopTagList();
            r126.f183702q = r106.getWelfareCorpLabelDTO();
            r126.f183703r = r106.getShopTags();
        L81:
            r100.f183748b = r126;
            if (r108 == null) goto L84;
            int r131 = d.f183674k;
            Intrinsics.checkNotNullParameter(r108, "dto");
            d r132 = new d();
            r132.f183675a = r108.getAuthorId();
            r132.f183676b = r108.getSecAuthorId();
            r132.f183677c = r108.getFollowStatus();
            r132.f183678d = r108.getHideFollowBtn();
            r132.f183679e = r108.getShowInfoColumn();
            r108.getFollowIconType();
            r132.f183680f = r108.getFollowGiftConfig();
            r132.f183681g = r108.getEntranceInformation();
            r132.f183682h = r108.getFansInfo();
            r132.f183683i = r108.getAuthorAvatar();
            r132.f183684j = r108.getAuthorNickName();
            r108.getFollowTaskText();
        L85:
            r100.f183749c = r132;
            if (r110 == null) goto L88;
            uj3.b r133 = new uj3.b();
            r133.f550261a = r110.getType();
            r133.f550263c = r110.a();
            r133.f550262b = r110.b();
        L89:
            r100.f183750d = r133;
            if (r111 == null) goto L105;
            int r134 = g.f183707r;
            Intrinsics.checkNotNullParameter(r111, "dto");
            g r135 = new g();
            r135.f183708a = r111.getProductCount();
            r135.f183709b = r111.getStoreDetailUrl();
            r135.f183710c = r111.getHideStoreDetailEntry();
            r135.f183711d = r111.getCartEntryConfig();
            r135.f183712e = r111.getDisplaySearch();
            r135.f183713f = r111.getSearchHint();
            r135.f183714g = r111.getOrderUrl();
            r135.f183715h = r111.getCustomServiceEntryInfo();
            ServiceEntryInfo r136 = r111.getCustomServiceEntryInfo();
            if (r136 == null) goto L94;
            ECUrlModel r137 = r136.getIcon();
        L95:
            if (r137 != null) goto L103;
            ServiceEntryInfo r138 = r111.getCustomServiceEntryInfo();
            if (r138 == null) goto L99;
            String r139 = r138.getSchema();
        L100:
            if (r139 != null) goto L103;
            ServiceEntryInfo r140 = new ServiceEntryInfo();
            r140.setSchema(r111.getCustomServiceEntry());
            Unit r141 = Unit.INSTANCE;
            r135.f183715h = r140;
        L104:
            r135.f183716i = r111.getTopSearchInfo();
            r135.f183717j = r111.getHideLiveInfo();
            r135.f183718k = r111.getLiveStyle();
            r135.f183719l = Boolean.valueOf(r111.getDisplayShopWindowEntry());
            r135.f183720m = r111.getShopWindowUrl();
            r135.f183721n = r111.getShopWindowProductCount();
            r135.f183722o = r111.getRedpacketEntrance();
            r135.f183723p = r111.getRedirectSchema();
            r135.f183724q = r111.getMoreEntryInfo();
        L106:
            r100.f183751e = r135;
            if (r112 == null) goto L120;
            int r142 = i.f183728d;
            Intrinsics.checkNotNullParameter(r112, "dto");
            i r143 = new i();
            im.v r144 = r112.getLiveInfo();
            if (r144 == null) goto L111;
            StoreV3LiveRoomVO.Companion.getClass();
            StoreV3LiveRoomVO r145 = StoreV3LiveRoomVO.a.a(r144);
        L112:
            r143.f183729a = r145;
            ShopHeaderVideoVO.a r146 = ShopHeaderVideoVO.Companion;
            List<ShopHeaderVideoInfo> r147 = r112.getVideoInfos();
            r146.getClass();
            ShopHeaderVideoVO r148 = new ShopHeaderVideoVO();
            if (r147 == null) goto L118;
            List<ShopHeaderVideoInfo> r149 = r147;
            ArrayList r150 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r149, 10));
            Iterator<T> r151 = r149.iterator();
        L116:
            if (r151.hasNext() == false) goto L119;
            ShopHeaderVideoInfo r152 = (ShopHeaderVideoInfo) r151.next();
            ShopHeaderVideoInfoVO.Companion.getClass();
            Intrinsics.checkNotNullParameter(r152, "dto");
            ShopHeaderVideoInfoVO r153 = new ShopHeaderVideoInfoVO();
            r153.setAwemedata(r152.getAwemeMoule());
            r150.add(r153);
        L119:
            r148.setFeedData(r150);
            r143.f183730b = r148;
            r143.f183731c = r112.getShowType();
        L121:
            r100.f183753g = r143;
            if (r113 == null) goto L127;
            int r154 = h.f183725c;
            Intrinsics.checkNotNullParameter(r113, "dto");
            h r155 = new h();
            r113.getShopDisplayName();
            r113.getShopDisplayName();
            r113.getShopLogo();
            r155.f183726a = r113.getTagList();
            r113.getTagV2List();
            r113.getShopXZGInfo();
            List<ECShopSellingPointDTO> r156 = r113.getShopSellingPoint();
            if (r156 != null) goto L126;
            r156 = CollectionsKt.emptyList();
        L126:
            Intrinsics.checkNotNullParameter(r156, "<set-?>");
            r155.f183727b = r156;
            r113.getHeaderStyleConfig();
        L127:
            if (r114 == null) goto L129;
            int r157 = j.f183732g;
            Intrinsics.checkNotNullParameter(r114, "dto");
            j r158 = new j();
            r158.f183733a = r114.getIcon();
            r158.f183734b = r114.getBubbleText();
            r158.f183735c = r114.getBubbleDismissTime();
            r158.f183736d = r114.getBubbleMaxShowTimes();
            r114.getShareQrCodeStyle();
            r158.f183737e = r114.getAnimationStyle();
        L130:
            r100.f183755i = r158;
            r100.f183747a = r115;
            r100.f183752f = r123;
            r100.f183754h = r124;
            r100.f183757k = r107;
            LinkedHashMap r159 = new LinkedHashMap();
            Type r160 = new o().getType();
            ECShopHeadInfoBlock r161 = r100.f183760n;
            boolean r162 = true;
            if (r161 == null) goto L156;
            Blcok r163 = r161.getBlock();
            if (r163 == null) goto L156;
            List<Module> r164 = r163.getModuleList();
            if (r164 == null) goto L156;
            Iterator<T> r165 = r164.iterator();
        L138:
            if (r165.hasNext() == false) goto L156;
            Module r166 = (Module) r165.next();
            Result.Companion r167 = Result.Companion;     // Catch: Throwable -> L154
            int r168 = t0.f45720a;     // Catch: Throwable -> L154
            Map r169 = (Map) t0.a.f45721a.fromJson(r166.getData(), r160);     // Catch: Throwable -> L154
            Map<String, String> r170 = r166.getModuleExtra();     // Catch: Throwable -> L154
            if (r170 != null) goto L143;
            r170 = MapsKt.emptyMap();     // Catch: Throwable -> L154
        L143:
            Map r171 = MapsKt.mapOf(new Pair[]{TuplesKt.to("data", r169), TuplesKt.to("module_extra", r170)});     // Catch: Throwable -> L154
            String r172 = r166.getName();     // Catch: Throwable -> L154
            if (r172 != null) goto L147;
            r172 = "";
        L147:
            if (r172.length() <= 0) goto L149;
            boolean r173 = true;
        L150:
            if (r173 == false) goto L152;
            r159.put(r172, r171);     // Catch: Throwable -> L154
        L152:
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L154
            goto L138
        L149:
            r173 = false;
        L154:
            th = move-exception;
            Result.Companion r174 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
        L156:
            com.bytedance.android.shopping.store.home.slice.d r175 = new com.bytedance.android.shopping.store.home.slice.d();
            Intrinsics.checkNotNullParameter(r159, "<set-?>");
            r175.f184506b = r159;
            ECStoreHeaderInfoSliceConfig.a r176 = ECStoreHeaderInfoSliceConfig.Companion;
            ECShopHeadInfoBlock r177 = r100.f183760n;
            if (r177 == null) goto L159;
            Map<String, String> r178 = r177.getExtra();
        L160:
            r176.getClass();
            if (r178 == null) goto L173;
            String r179 = r178.get("slice_configs");
            if (r179 == null) goto L173;
            Type r180 = new com.bytedance.android.shopping.store.home.slice.e().getType();
            Map<String, ECStoreHeaderInfoSliceConfig> r181 = MapsKt.emptyMap();
            Result.Companion r182 = Result.Companion;     // Catch: Throwable -> L171
            int r183 = t0.f45720a;     // Catch: Throwable -> L171
            Map<String, ECStoreHeaderInfoSliceConfig> r184 = (Map) t0.a.f45722b.fromJson(r179, r180);     // Catch: Throwable -> L171
            Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L169
        L174:
            r175.f184505a = r184;
            r100.f183761o = r175;
            r100.f183756j = r104;
            r100.f183759m = r210.getExtra();
            ECShopBrandModuleInfo r185 = r105;
            r100.f183758l = r185;
            com.bytedance.android.shopping.store.home.slice.d r186 = r100.f183761o;
            if (r186 == null) goto L179;
            Map<String, ? extends Object> r187 = r186.f184506b;
            if (r187 == null) goto L179;
            Object r188 = r187.get(ECShopModuleType.SHOP_NORMAL_HEADER_INFO.getType());
        L181:
            if ((r188 instanceof Map) == true) goto L183;
            r188 = null;
        L183:
            Map r189 = (Map) r188;
            if (r189 == null) goto L186;
            Object r190 = r189.get("data");
        L188:
            if ((r190 instanceof Map) == true) goto L190;
            Object r191 = null;
        L191:
            Map r192 = (Map) r191;
            if (r192 == null) goto L198;
            Object r193 = r192.get("is_anchored");
            if (r193 == null) goto L198;
            Integer r194 = ECHybridExtensionsKt.i(r193);
            if (r194 == null) goto L198;
            int r195 = r194.intValue();
        L199:
            if (r195 >= 1) goto L209;
            if (r185 == null) goto L208;
            List<ECShopBrandHeaderModule> r196 = r185.getModuleList();
            if (r196 == null) goto L208;
            ECShopBrandHeaderModule r197 = (ECShopBrandHeaderModule) CollectionsKt.firstOrNull(r196);
            if (r197 == null) goto L208;
            if (r197.isAnchored() == true) goto L209;
        L208:
            r162 = false;
        L209:
            r100.f183763q = r162;
            return r100;
        L198:
            r195 = 0;
            goto L199
        L190:
            r191 = r190;
            goto L191
        L186:
            r190 = null;
        L179:
            r188 = null;
        L169:
            th = th;
            r181 = r184;
        L172:
            Result.Companion r198 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            r184 = r181;
        L171:
            th = th;
        L173:
            r184 = MapsKt.emptyMap();
            goto L174
        L159:
            r178 = null;
            goto L160
        L129:
            r158 = null;
            goto L130
        L118:
            r150 = null;
            goto L119
        L111:
            r145 = null;
            goto L112
        L120:
            r143 = null;
            goto L121
        L99:
            r139 = null;
        L103:
            r135.f183715h = r111.getCustomServiceEntryInfo();
            goto L104
        L94:
            r137 = null;
            goto L95
        L105:
            r135 = null;
            goto L106
        L88:
            r133 = null;
            goto L89
        L84:
            r132 = null;
            goto L85
        L75:
            r129 = new AuthorReputationVO();
            r129.setScore(r128.getScore());
            r129.setSales(r128.getSales());
            r129.setScoreNormalText(r128.getScoreNormalText());
            goto L76
        L80:
            r107 = r107;
            r126 = null;
        L69:
            r123 = null;
            r124 = null;
            r104 = null;
            r105 = null;
            r106 = null;
            r107 = null;
            r108 = null;
            r110 = null;
            r111 = null;
            r112 = null;
            r113 = null;
            r114 = null;
            r115 = null;
            goto L70
        }
    }

    static {
    }

    public n() {
    }

    public final int a() {
        Map<String, String> r100 = this.f183759m;
        if (r100 == null) goto L10;
        String r101 = r100.get("framework_type");
        if (r101 == null) goto L10;
        Integer r102 = StringsKt.toIntOrNull(r101);
        if (r102 == null) goto L10;
        return r102.intValue();
    L10:
        return ShopFrameworkType.NORMAL.getType();
    }

    public final boolean b() {
        ECShopBrandModuleInfo r100 = this.f183758l;
        Object r101 = null;
        if (r100 == null) goto L16;
        List<ECShopBrandHeaderModule> r102 = r100.getModuleList();
        if (r102 == null) goto L16;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L15;
        Object r104 = r103.next();
        if (((ECShopBrandHeaderModule) r104).getModuleType() != 1) goto L12;
        boolean r105 = true;
    L13:
        if (r105 == false) goto L8;
        r101 = r104;
        goto L15
    L12:
        r105 = false;
    L15:
        r101 = (ECShopBrandHeaderModule) r101;
    L16:
        if (r101 == null) goto L24;
        return true;
    L24:
        return false;
    }

    public final boolean c() {
        ECAbnormalShopBasicInfo r100 = this.f183747a;
        if (r100 == null) goto L7;
        ShopExtraStatus r101 = r100.getExtraStatus();
        if (r101 == null) goto L7;
        Integer r102 = r101.getExtraStatusType();
    L8:
        int r103 = ShopExtraStatusType.NON_OPERATE_STATUS.getType();
        if (r102 != null) goto L12;
    L14:
        return false;
    L12:
        if (r102.intValue() != r103) goto L14;
        return true;
    L7:
        r102 = null;
        goto L8
    }

    public final boolean d() {
        Map<String, String> r100 = this.f183759m;
        if (r100 == null) goto L5;
        String r101 = r100.get("brand_shop");
    L7:
        if (Intrinsics.areEqual(r101, "1") == true) goto L9;
    L11:
        return false;
    L9:
        if (c() == true) goto L11;
        return true;
    L5:
        r101 = null;
        goto L7
    }
}
