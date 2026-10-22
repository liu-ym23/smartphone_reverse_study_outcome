package com.bytedance.android.shopping.anchorv3.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.baidu.platform.comapi.bmsdk.BmLocated;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.core.monitor.listener.ActionRateListener;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.ec.model.ECBoltParam;
import com.bytedance.android.ec.model.order.ECOrderTrackerData;
import com.bytedance.android.ec.model.order.ProductDetailPageParams;
import com.bytedance.android.ec.model.response.anchorv3.GroupInfo;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductActivitiesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductBaseStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductExtraStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPageConfigStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductPrivilegesStruct;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.sku.DefaultSelect;
import com.bytedance.android.ec.model.sku.SkuExtraData;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.livehostapi.business.depend.livead.MiniAppConstants;
import com.bytedance.android.shopping.anchorv3.AnchorV3Param;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3PromotionRequestParam;
import com.bytedance.android.shopping.anchorv3.repository.api.LubanParam;
import com.bytedance.android.shopping.anchorv3.sku.SkuDataCollection;
import com.bytedance.android.shopping.anchorv3.sku.SkuParam;
import com.bytedance.android.shopping.api.anchorv3.ECLogExtraData;
import com.bytedance.android.shopping.feed.model.InflowFeedPageParams;
import com.bytedance.android.shopping.verify.AuthUtils;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f165357a = 0;

    public v() {
    }

    static {
    }

    public static void f(boolean r100) {
        Activity r101 = ECAppInfoService.f48114e.getCurrentActivity();
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = R.string.commerce_cancel_collect_failed;
    L7:
        UIUtils.displayToast(r101, th.a.h(r101, r102, new Object[]{th.a.g(r101, R.string.commerce_collection)}));
        return;
    L6:
        r102 = R.string.commerce_collect_failed;
        goto L7
    }

    public static void g(boolean r100) {
        Intrinsics.checkNotNullParameter("喜欢", "text");
        Activity r101 = ECAppInfoService.f48114e.getCurrentActivity();
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = R.string.commerce_cancel_collect_failed;
    L7:
        UIUtils.displayToast(r101, th.a.h(r101, r102, new Object[]{"喜欢"}));
        return;
    L6:
        r102 = R.string.commerce_collect_failed;
        goto L7
    }

    public static void e(String r100, String r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "btmId");
        Intrinsics.checkNotNullParameter(r102, "btmView");
        Activity r103 = ECAppInfoService.f48114e.getCurrentActivity();
        if (r103 == null) goto L6;
        Set<String> r104 = ECProcessMonitor.f45118a;
        ECProcessMonitor.c("ec_product_detail", "enter_im").g();
        com.bytedance.android.ec.sdk.helper.p.f48130a.d(com.bytedance.android.ec.core.btm.c.c(r100, r102, r101, new Pair[0]), r103);
        return;
    }

    public static void b(final Context r110, final FragmentManager r111, final boolean r210, final PromotionProductStruct r211, final AnchorV3Param r212) {
        final boolean r100 = false;
        final com.bytedance.android.btm.api.model.d r112 = null;
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "fragmentManager");
        if (com.bytedance.android.shopping.utils.i.a() == false) goto L13;
        int r101 = AuthUtils.f187163a;
        if (r211 == null) goto L11;
        PromotionProductBaseStruct r102 = r211.getBaseInfo();
        if (r102 == null) goto L11;
        Integer r103 = r102.getPromotionSource();
        if (r103 == null) goto L11;
        long r104 = r103.intValue();
    L12:
        AuthUtils.a(r110, r104, null, new NavBtnClickHelper$onClickAddShopCartBtn$3(r110, r111, r212, r210, r100, r211, r112));
        return;
    L11:
        r104 = 0;
        goto L12
    L13:
        d(r110, r111, null, null, null, r210, false, r211, "", null, null, null, null, null, null, null, 129024);
    }

    public static void a(final Context r110, final Fragment r111, final FragmentManager r112, final AnchorV3Param r210, final boolean r211, final PromotionProductStruct r212, final com.bytedance.android.btm.api.model.d r213, final t r214) {
        final boolean r100 = false;
        final String r101 = "";
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "fragmentManager");
        if (com.bytedance.android.shopping.utils.i.a() == false) goto L13;
        int r102 = AuthUtils.f187163a;
        if (r212 == null) goto L11;
        PromotionProductBaseStruct r103 = r212.getBaseInfo();
        if (r103 == null) goto L11;
        Integer r104 = r103.getPromotionSource();
        if (r104 == null) goto L11;
        long r105 = r104.intValue();
    L12:
        AuthUtils.a(r110, r105, null, new NavBtnClickHelper$onClickAddShopCartBtn$2(r110, r112, r111, r210, r211, r100, r212, r101, r213, r214));
        return;
    L11:
        r105 = 0;
        goto L12
    L13:
        d(r110, r112, r111, r210, null, r211, false, r212, "", r213, null, r214, null, null, null, null, 124928);
    }

    public static void c(final Fragment r310, final AnchorV3Param r311, final ProductDetailPageParams r312, final boolean r313, final boolean r314, final PromotionProductStruct r315, final String r316, final com.bytedance.android.btm.api.model.d r410, final InflowFeedPageParams r411, final SkuRestoreState r412, final Function1 r413, final Function1 r414) {
        final s r110 = null;
        final String r210 = null;
        Intrinsics.checkNotNullParameter(r310, WidgetService.PARAM_FRAGMENT);
        final Context r111 = r310.getContext();
        if (r111 != null) goto L6;
        return;
    L6:
        if (com.bytedance.android.shopping.utils.i.a() == false) goto L17;
        int r100 = AuthUtils.f187163a;
        if (r315 == null) goto L14;
        PromotionProductBaseStruct r101 = r315.getBaseInfo();
        if (r101 == null) goto L14;
        Integer r102 = r101.getPromotionSource();
        if (r102 == null) goto L14;
        long r103 = r102.intValue();
    L15:
        AuthUtils.a(r111, r103, null, new NavBtnClickHelper$onClickAddShopCartBtn$1(r310, r111, r311, r312, r313, r314, r315, r316, r410, r411, r110, r412, r413, r414, r210));
        return;
    L14:
        r103 = 0;
        goto L15
    L17:
        if (r310.isAdded() == false) goto L23;
        d(r111, r310.getChildFragmentManager(), r310, r311, r312, r313, r314, r315, r316, r410, r411, null, r412, r413, r414, null, 4096);
        return;
    }

    public static void d(final Context r810, FragmentManager r811, Fragment r812, AnchorV3Param r813, ProductDetailPageParams r814, boolean r815, boolean r816, PromotionProductStruct r817, String r910, com.bytedance.android.btm.api.model.d r911, InflowFeedPageParams r912, t r913, SkuRestoreState r914, Function1 r915, Function1 r916, String r917, int r918) {
        if ((r918 & 4) == 0) goto L5;
        Fragment r100 = null;
    L7:
        if ((r918 & 16) == 0) goto L9;
        ProductDetailPageParams r101 = null;
    L10:
        String r102 = "";
        if ((r918 & 256) == 0) goto L13;
        String r103 = "";
    L15:
        if ((r918 & 512) == 0) goto L17;
        com.bytedance.android.btm.api.model.d r104 = null;
    L19:
        if ((r918 & 1024) == 0) goto L21;
        final InflowFeedPageParams r110 = null;
    L23:
        if ((r918 & 4096) == 0) goto L25;
        final t r111 = null;
    L27:
        if ((r918 & 8192) == 0) goto L29;
        SkuRestoreState r112 = null;
    L31:
        if ((r918 & 16384) == 0) goto L33;
        Function1 r113 = null;
    L35:
        if ((32768 & r918) == 0) goto L37;
        Function1 r114 = null;
    L39:
        if ((r918 & 65536) == 0) goto L41;
        String r115 = null;
    L42:
        if (r817 != null) goto L45;
        return;
    L45:
        if (r817.isThirdParty() == true) goto L404;
        PromotionProductPageConfigStruct r105 = r817.getPageComsConfig();
        if (r105 != null) goto L49;
    L51:
        int r106 = ul.h.f550588a;
        if (r110 == null) goto L54;
        Long r107 = r110.getTag();
    L56:
        if (ul.h.a(com.bytedance.android.shopping.extensions.k.h(r107), null, false, null, false, 30) != 301) goto L58;
        boolean r108 = true;
    L59:
        if (r108 == true) goto L61;
        r102 = "";
    L97:
        r112 = r112;
    L99:
        if (r813 == null) goto L103;
        AnchorV3PromotionRequestParam r109 = r813.getRequestParam();
        if (r109 == null) goto L103;
        String r116 = r109.getMetaParam();
    L104:
        JSONObject r117 = com.bytedance.android.shopping.extensions.k.w(r116);
        if (r117 == null) goto L107;
        String r118 = r117.optString(MiniAppConstants.KEY_MINI_APP_LIVE_ROOM_ID);
    L108:
        if (r118 != null) goto L110;
        r118 = r102;
    L110:
        yj.g r119 = com.bytedance.android.ec.hybrid.a.b();
        if (r119 == null) goto L115;
        r119.c();
        if (com.bytedance.android.shopping.extensions.k.c(r115) == false) goto L115;
        DefaultSelect r610 = new DefaultSelect(r115, 1, null, null, false, false, 44, null);
    L116:
        PromotionProductBaseStruct r120 = r817.getBaseInfo();
        if (r120 == null) goto L119;
        String r210 = r120.getPromotionId();
    L120:
        PromotionProductBaseStruct r121 = r817.getBaseInfo();
        if (r121 == null) goto L123;
        String r211 = r121.getProductId();
    L124:
        PromotionProductBaseStruct r122 = r817.getBaseInfo();
        if (r122 == null) goto L127;
        Integer r212 = r122.getPromotionSource();
    L128:
        long r123 = 0;
        if (r101 == null) goto L131;
        long r213 = r101.getPageResumeDuration();
    L132:
        int r124 = a.f165300a;
        if (r813 == null) goto L135;
        String r310 = r813.getAuthorId();
    L136:
        if (r813 == null) goto L138;
        String r311 = r813.getSecAuthorId();
    L139:
        if (r813 == null) goto L143;
        AnchorV3PromotionRequestParam r125 = r813.getRequestParam();
        if (r125 == null) goto L143;
        String r312 = r125.getItemId();
    L144:
        if (r813 == null) goto L146;
        Integer r313 = r813.getFollowStatus();
    L147:
        if (r813 == null) goto L151;
        AnchorV3PromotionRequestParam r126 = r813.getRequestParam();
        if (r126 == null) goto L151;
        String r314 = r126.getSourcePage();
    L152:
        PromotionProductExtraStruct r127 = r817.getExtraInfo();
        if (r127 == null) goto L155;
        String r128 = r127.getShopId();
    L156:
        if (r128 != null) goto L158;
        String r410 = r102;
    L159:
        if (r813 == null) goto L161;
        String r315 = r813.getEnterMethod();
    L162:
        if (r110 != null) goto L166;
        if (r813 == null) goto L165;
        String r129 = r813.getEntranceInfo();
    L167:
        String r316 = r129;
    L168:
        if (r813 == null) goto L170;
        ECAdLogExtra r317 = r813.getAdLogExtra();
    L171:
        if (r813 == null) goto L173;
        ECBoltParam r318 = r813.getBoltParam();
    L174:
        if (r813 == null) goto L176;
        boolean r411 = r813.isLuban();
    L177:
        if (r101 == null) goto L182;
        String r130 = r101.getMessagePVInfo();
        if (r130 == null) goto L182;
        String r412 = r130;
    L183:
        if (r101 == null) goto L188;
        String r131 = r101.getPageType();
        if (r131 == null) goto L188;
        String r413 = r131;
    L190:
        if (r813 == null) goto L196;
        AnchorV3PromotionRequestParam r132 = r813.getRequestParam();
        if (r132 == null) goto L196;
        LubanParam r133 = r132.getLubanParam();
        if (r133 == null) goto L196;
        String r414 = r133.getPageId();
    L197:
        PromotionProductExtraStruct r134 = r817.getExtraInfo();
        if (r134 == null) goto L200;
        String r135 = r134.getOriginType();
    L201:
        if (r135 != null) goto L203;
        String r415 = r102;
    L204:
        PromotionProductExtraStruct r136 = r817.getExtraInfo();
        if (r136 == null) goto L207;
        String r137 = r136.getOriginId();
    L208:
        if (r137 != null) goto L210;
        String r416 = r102;
    L212:
        if (r813 == null) goto L214;
        String r510 = r813.getWhichAccount();
    L215:
        if (r813 == null) goto L217;
        String r511 = r813.getEComEntranceFrom();
    L218:
        int r138 = y.f165360a;
        if (r110 != null) goto L223;
        if (r813 == null) goto L222;
        String r139 = r813.getEntranceInfo();
    L224:
        String r512 = y.o(r817, r139);
        if (r813 == null) goto L227;
        String r513 = r813.getRecommendInfo();
    L228:
        PromotionProductPrivilegesStruct r140 = r817.getPrivilegeInfo();
        if (r140 == null) goto L235;
        PromotionProductActivitiesStruct r141 = r140.getActivities();
        if (r141 == null) goto L235;
        GroupInfo r142 = r141.getGroupInfoActivity();
        if (r142 == null) goto L235;
        Long r514 = Long.valueOf(r142.getGroupId());
    L237:
        if (r813 == null) goto L241;
        ECLogExtraData r143 = r813.getLogExtraData();
        if (r143 == null) goto L241;
        String r144 = r143.getBaseVerifiedCategory();
    L242:
        String r611 = y.b(r144, r817);
        String r612 = y.d(r817);
        boolean r613 = y.r(r817);
        String r614 = y.g(r817);
        String r710 = y.s(r817);
        String r711 = y.i(r817);
        if (r813 == null) goto L247;
        ECLogExtraData r145 = r813.getLogExtraData();
        if (r145 == null) goto L247;
        String r712 = r145.getLabelNameLive();
    L248:
        String r713 = y.p(r817);
        if (r813 == null) goto L253;
        AnchorV3PromotionRequestParam r146 = r813.getRequestParam();
        if (r146 == null) goto L253;
        String r714 = r146.getSourcePage();
    L254:
        String r715 = y.h(r817);
        if (r110 == null) goto L257;
        String r716 = r110.getTransitionTrackerData();
    L258:
        SkuExtraData r515 = new SkuExtraData(r611, r612, r613, r614, r710, r711, r712, r713, r714, r715, null, r716, null, BmLocated.HALF_LEFT_TOP, null);
        if (r101 == null) goto L261;
        String r516 = r101.getReceiveAddressId();
    L263:
        if (r813 == null) goto L267;
        ECLogExtraData r147 = r813.getLogExtraData();
        if (r147 == null) goto L267;
        String r615 = r147.getTransitionTrackerData();
    L268:
        if (r110 == null) goto L270;
        Long r148 = r110.getTag();
    L271:
        if (r148 == null) goto L273;
        r123 = r148.longValue();
    L273:
        Long r616 = Long.valueOf(r123);
        PromotionProductExtraStruct r149 = r817.getExtraInfo();
        if (r149 == null) goto L278;
        Map<String, String> r150 = r149.getExtra();
        if (r150 == null) goto L278;
        String r617 = r150.get("channel_id");
    L279:
        PromotionProductExtraStruct r151 = r817.getExtraInfo();
        if (r151 == null) goto L286;
        Map<String, String> r152 = r151.getExtra();
        if (r152 == null) goto L286;
        String r153 = r152.get(WsConstants.KEY_CHANNEL_TYPE);
        if (r153 == null) goto L286;
        int r154 = CastIntegerProtector.parseInt(r153);
    L287:
        Integer r618 = Integer.valueOf(r154);
        if (r813 == null) goto L290;
        String r717 = r813.getAuthorOpenId();
    L291:
        SkuParam r155 = new SkuParam(r210, r211, r212, r213, "large_stabilization", r310, r311, r312, r313, r314, null, r315, r316, r317, r318, r411, r414, r412, r413, null, null, r415, r416, r410, null, r510, r511, r512, r118, r513, r514, r816, r515, r516, 0, true, r615, r616, false, r610, null, null, null, r617, r618, null, null, null, r717, null, null, 18351104, 452420, null);
        PromotionProductExtraStruct r156 = r817.getExtraInfo();
        if (r156 == null) goto L294;
        Boolean r157 = r156.getNeedCheck();
    L296:
        if (Intrinsics.areEqual(r157, Boolean.FALSE) == false) goto L396;
        int r158 = ECSdk.f48106a;
        IECCommonService r159 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r159 == null) goto L391;
        int r160 = ul.h.f550588a;
        if (r110 == null) goto L302;
        Long r161 = r110.getTag();
    L303:
        int r162 = ul.h.a(com.bytedance.android.shopping.extensions.k.h(r161), null, false, null, false, 30);
        int r163 = ul.a.f550584a;
        if (r110 == null) goto L306;
        Long r164 = r110.getTag();
    L308:
        if (com.bytedance.android.shopping.extensions.k.h(r164) != 9) goto L310;
        int r165 = 1;
    L311:
        PromotionProductExtraStruct r166 = r817.getExtraInfo();
        if (r166 == null) goto L314;
        String r167 = r166.getOriginType();
    L315:
        if (r167 != null) goto L317;
        r167 = r102;
    L317:
        PromotionProductExtraStruct r168 = r817.getExtraInfo();
        if (r168 == null) goto L320;
        String r169 = r168.getOriginId();
    L321:
        if (r169 != null) goto L323;
        r169 = r102;
    L323:
        PromotionProductBaseStruct r170 = r817.getBaseInfo();
        if (r170 == null) goto L326;
        String r171 = r170.getPromotionId();
    L327:
        if (r171 != null) goto L329;
        r171 = r102;
    L329:
        PromotionProductBaseStruct r172 = r817.getBaseInfo();
        if (r172 == null) goto L332;
        String r173 = r172.getProductId();
    L333:
        if (r173 != null) goto L335;
        r173 = r102;
    L335:
        if (r813 == null) goto L338;
        String r174 = r813.getAuthorId();
        if (r174 == null) goto L338;
    L339:
        if (r813 == null) goto L341;
        String r214 = r813.getSecAuthorId();
    L342:
        PromotionProductExtraStruct r215 = r817.getExtraInfo();
        if (r215 == null) goto L345;
        String r216 = r215.getShopId();
    L346:
        if (r216 != null) goto L348;
        r216 = r102;
    L348:
        if (r110 != null) goto L352;
        if (r813 == null) goto L351;
        String r175 = r813.getEntranceInfo();
    L353:
        String r217 = y.o(r817, r175);
        boolean r218 = r155.isGroupingBuy();
        String r319 = r155.getReceiveAddressId();
        if (r110 == null) goto L356;
        Long r176 = r110.getTag();
    L357:
        if (r176 != null) goto L360;
    L361:
        if (r111 != null) goto L363;
        boolean r320 = false;
    L365:
        if (r104 != null) goto L371;
        com.bytedance.android.btm.api.model.d r177 = new com.bytedance.android.btm.api.model.d();
        if (r103 != null) goto L369;
        String r178 = r102;
    L370:
        r177.f42022a = r178;
        r177.f42023b = PageFinder.via(r100);
        Unit r179 = Unit.INSTANCE;
        com.bytedance.android.btm.api.model.d r219 = r177;
    L372:
        PromotionProductExtraStruct r180 = r817.getExtraInfo();
        if (r180 == null) goto L377;
        Map<String, String> r181 = r180.getExtra();
        if (r181 == null) goto L377;
        String r417 = r181.get("channel_id");
    L378:
        PromotionProductExtraStruct r182 = r817.getExtraInfo();
        if (r182 == null) goto L385;
        Map<String, String> r183 = r182.getExtra();
        if (r183 == null) goto L385;
        String r184 = r183.get(WsConstants.KEY_CHANNEL_TYPE);
        if (r184 == null) goto L385;
        int r185 = CastIntegerProtector.parseInt(r184);
    L386:
        Integer r418 = Integer.valueOf(r185);
        if (r813 == null) goto L389;
        String r419 = r813.getAuthorOpenId();
    L390:
        final s r186 = null;
        IECCommonService.a.a(r159, r810, r162, r165, r167, r169, r171, r173, r174, r214, r118, r216, r217, r218, r319, null, r320, null, null, r219, false, null, r417, r418, r419, null, null, null, null, null, null, new NavBtnClickHelper$onClickAddShopCartBtnReal$5(r110, r186, r810, r111), -59834368, 1);
        Unit r187 = Unit.INSTANCE;
        goto L391
    L389:
        r419 = null;
    L385:
        r185 = 0;
    L377:
        r417 = null;
        goto L378
    L369:
        r178 = r103;
        goto L370
    L371:
        r219 = r104;
    L363:
        r320 = true;
        goto L365
    L360:
        if (r176.longValue() == 8) goto L363;
    L356:
        r176 = null;
        goto L357
    L351:
        r175 = null;
        goto L353
    L352:
        int r220 = com.bytedance.android.shopping.feed.utils.b.f175437a;
        r175 = com.bytedance.android.shopping.feed.utils.b.c(r817, r813, r110.isFromGuessULike());
        goto L353
    L345:
        r216 = null;
        goto L346
    L341:
        r214 = null;
    L338:
        r174 = r102;
        goto L339
    L332:
        r173 = null;
        goto L333
    L326:
        r171 = null;
        goto L327
    L320:
        r169 = null;
        goto L321
    L314:
        r167 = null;
        goto L315
    L310:
        r165 = 0;
        goto L311
    L306:
        r164 = null;
        goto L308
    L302:
        r161 = null;
    L391:
        IECUserTrackerService r188 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r188 == null) goto L410;
        of.a r189 = r188.getMarketingService();
        if (r189 == null) goto L411;
        r189.a(com.bytedance.android.ec.core.event.a.VALUE_ADD_CART, PostActionType.DO, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
        Unit r190 = Unit.INSTANCE;
        return;
    L411:
        return;
    L410:
        return;
    L396:
        int r191 = com.bytedance.android.shopping.anchorv3.sku.a.f165291a;
        ECOrderTrackerData r192 = y.x(r813);
        SkuDataCollection r193 = com.bytedance.android.shopping.anchorv3.sku.b.a(r817, true, r815, r816);
        HashMap r194 = com.bytedance.android.shopping.anchorv3.track.b.a(r810);
        if (r104 != null) goto L403;
        com.bytedance.android.btm.api.model.d r195 = new com.bytedance.android.btm.api.model.d();
        if (r103 != null) goto L401;
        String r196 = r102;
    L402:
        r195.f42022a = r196;
        r195.f42023b = PageFinder.via(r100);
        Unit r197 = Unit.INSTANCE;
        r104 = r195;
        goto L403
    L401:
        r196 = r103;
    L403:
        final s r198 = null;
        com.bytedance.android.shopping.anchorv3.sku.a.c(r810, r811, r192, r101, r817, r193, r155, r194, r104, r112, r113, r114, null, new NavBtnClickHelper$onClickAddShopCartBtnReal$7(r111, r198), null, null, 20480);
        return;
    L294:
        r157 = null;
        goto L296
    L290:
        r717 = null;
    L286:
        r154 = 0;
    L278:
        r617 = null;
        goto L279
    L270:
        r148 = null;
    L267:
        r615 = null;
        goto L268
    L261:
        r516 = null;
        goto L263
    L257:
        r716 = null;
    L253:
        r714 = null;
    L247:
        r712 = null;
    L241:
        r144 = null;
    L235:
        r514 = null;
        goto L237
    L227:
        r513 = null;
        goto L228
    L222:
        r139 = null;
        goto L224
    L223:
        int r199 = com.bytedance.android.shopping.feed.utils.b.f175437a;
        r139 = com.bytedance.android.shopping.feed.utils.b.c(r817, r813, r110.isFromGuessULike());
        goto L224
    L217:
        r511 = null;
        goto L218
    L214:
        r510 = null;
        goto L215
    L210:
        r416 = r137;
        goto L212
    L207:
        r137 = null;
        goto L208
    L203:
        r415 = r135;
        goto L204
    L200:
        r135 = null;
    L196:
        r414 = null;
    L188:
        r413 = r102;
    L182:
        r412 = r102;
        goto L183
    L176:
        r411 = false;
        goto L177
    L173:
        r318 = null;
        goto L174
    L170:
        r317 = null;
        goto L171
    L165:
        r316 = null;
        goto L168
    L166:
        int r200 = com.bytedance.android.shopping.feed.utils.b.f175437a;
        r129 = com.bytedance.android.shopping.feed.utils.b.c(r817, r813, r110.isFromGuessULike());
        goto L167
    L161:
        r315 = null;
        goto L162
    L158:
        r410 = r128;
        goto L159
    L155:
        r128 = null;
    L151:
        r314 = null;
        goto L152
    L146:
        r313 = null;
    L143:
        r312 = null;
        goto L144
    L138:
        r311 = null;
        goto L139
    L135:
        r310 = null;
        goto L136
    L131:
        r213 = 0;
        goto L132
    L127:
        r212 = null;
        goto L128
    L123:
        r211 = null;
        goto L124
    L119:
        r210 = null;
    L115:
        r610 = null;
        goto L116
    L107:
        r118 = null;
    L103:
        r116 = null;
        goto L104
    L61:
        if (r813 == null) goto L67;
        String r1100 = r813.getEntranceInfo();
        if (r1100 == null) goto L67;
        JSONObject r1101 = com.bytedance.android.shopping.extensions.k.w(r1100);
        if (r1101 == null) goto L67;
        String r1102 = r1101.optString("enter_from");
        Unit r1103 = Unit.INSTANCE;
    L69:
        if (r110 == null) goto L75;
        String r1104 = r110.getTransitionTrackerData();
        if (r1104 == null) goto L75;
        JSONObject r1105 = com.bytedance.android.shopping.extensions.k.w(r1104);
        if (r1105 == null) goto L75;
        String r201 = r1105.optString("carrier_type");
        String r1106 = r1105.optString(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL);
        Unit r221 = Unit.INSTANCE;
    L76:
        if (r201 == null) goto L97;
        PromotionProductExtraStruct r222 = r817.getExtraInfo();
        if (r222 == null) goto L80;
        Boolean r1107 = r222.getNeedCheck();
    L82:
        if (Intrinsics.areEqual(r1107, Boolean.FALSE) == false) goto L89;
        Set<String> r202 = ECProcessMonitor.f45118a;
        r100 = r100;
        com.bytedance.android.ec.core.monitor.listener.a r203 = ECProcessMonitor.d("ec_product_flow_page");
        r103 = r103;
        JSONObject r204 = new JSONObject();
        r204.put("enter_from", r1102);     // Catch: Exception -> L86
        r204.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, r201);     // Catch: Exception -> L86
        r204.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, r1106);     // Catch: Exception -> L86
    L88:
        Unit r205 = Unit.INSTANCE;
        ActionRateListener.c(r203, r204, null, false, 6);
        Set<String> r206 = ECProcessMonitor.f45118a;
        ECProcessMonitor.d("ec_product_flow_page").d();
    L86:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L88
    L89:
        r100 = r100;
        r103 = r103;
        Set<String> r207 = ECProcessMonitor.f45118a;
        com.bytedance.android.ec.core.monitor.listener.e r208 = ECProcessMonitor.p();
        JSONObject r209 = new JSONObject();
        r209.put("enter_from", r1102);     // Catch: Exception -> L92
        r209.put(com.bytedance.android.ec.core.event.a.KEY_PRODUCT_SOURCE_PAGE, r201);     // Catch: Exception -> L92
        r209.put(com.bytedance.android.ec.core.event.a.KEY_MODULE_LABEL, r1106);     // Catch: Exception -> L92
    L94:
        Unit r223 = Unit.INSTANCE;
        ActionRateListener.c(r208, r209, null, false, 6);
        Set<String> r224 = ECProcessMonitor.f45118a;
        ECProcessMonitor.p().d();
    L92:
        e = move-exception;
        ECExceptionMonitor.e(e);
        goto L94
    L80:
        r1107 = null;
    L75:
        r201 = null;
        r1106 = null;
    L67:
        r1102 = null;
        goto L69
    L58:
        r108 = false;
        goto L59
    L54:
        r107 = null;
        goto L56
    L49:
        if (r105.getSetCartGray() != true) goto L51;
    L404:
        UIUtils.displayToast(r810, R.string.commerce_add_shop_cart_unsupported);
        return;
    L41:
        r115 = r917;
        goto L42
    L37:
        r114 = r916;
        goto L39
    L33:
        r113 = r915;
        goto L35
    L29:
        r112 = r914;
        goto L31
    L25:
        r111 = r913;
        goto L27
    L21:
        r110 = r912;
        goto L23
    L17:
        r104 = r911;
        goto L19
    L13:
        r103 = r910;
        goto L15
    L9:
        r101 = r814;
        goto L10
    L5:
        r100 = r812;
        goto L7
    }
}
