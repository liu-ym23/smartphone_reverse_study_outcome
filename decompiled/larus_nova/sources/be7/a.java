package be7;

import com.bytedance.ies.bullet.service.base.h;
import com.bytedance.sdk.xbridge.cn.PlatformType;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.heytap.mcssdk.constant.b;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Boolean> f18743a = null;

    static {
        LinkedHashMap r100 = new LinkedHashMap();
        Boolean r101 = Boolean.TRUE;
        r100.put("ttcjpay.bioPaymentShowState", r101);
        r100.put("ttcjpay.sendDeviceInfo", r101);
        r100.put("ttcjpay.bindCard", r101);
        r100.put("ttcjpay.getPhoneInfo", r101);
        r100.put("ttcjpay.goSettings", r101);
        r100.put("ttcjpay.ttpay", r101);
        r100.put("ttcjpay.uploadMedia", r101);
        r100.put("ttcjpay.openAppByScheme", r101);
        r100.put("ttcjpay.subscribeEvent", r101);
        r100.put("ttcjpay.subscribeEvent", r101);
        r100.put("ttcjpay.deviceInfo", r101);
        r100.put("ttcjpay.ocr", r101);
        r100.put("ttcjpay.isAppInstalled", r101);
        r100.put("ttcjpay.authAlipay", r101);
        r100.put("ttcjpay.getGeckoInfo", r101);
        r100.put("ttcjpay.abTest", r101);
        r100.put("ttcjpay.encrypt", r101);
        r100.put("ttcjpay.smsVerify", r101);
        r100.put("ttcjpay.closeCallback", r101);
        r100.put("ttcjpay.chooseMedia", r101);
        r100.put("ttcjpay.faceVerification", r101);
        r100.put("ttcjpay.alog", r101);
        r100.put("ttcjpay.switchBioPaymentState", r101);
        r100.put("ttcjpay.decrypt", r101);
        r100.put("ttcjpay.facepp", r101);
        r100.put("x.reportADLog", r101);
        r100.put("x.startGyroscope", r101);
        r100.put("x.stopGyroscope", r101);
        r100.put("x.setStorageItem", r101);
        r100.put("x.copy", r101);
        r100.put("x.getContainerID", r101);
        r100.put("x.updateGecko", r101);
        r100.put("x.getStorageInfo", r101);
        r100.put("x.vibrate", r101);
        r100.put("x.request", r101);
        r100.put("x.close", r101);
        r100.put("x.hideLoading", r101);
        r100.put("x.makePhoneCall", r101);
        r100.put("x.setCalendarEvent", r101);
        r100.put("x.removeCalendarEvent", r101);
        r100.put("x.createCalendarEvent", r101);
        r100.put("x.deleteCalendarEvent", r101);
        r100.put("x.showToast", r101);
        r100.put("x.open", r101);
        r100.put("x.scanCode", r101);
        r100.put("x.showLoading", r101);
        r100.put("x.chooseMedia", r101);
        r100.put("x.getSettings", r101);
        r100.put("x.reportMonitorLog", r101);
        r100.put("x.getAPIParams", r101);
        r100.put("x.getUserInfo", r101);
        r100.put("x.sendSMS", r101);
        r100.put("x.getMethodList", r101);
        r100.put("x.sendSocketData", r101);
        r100.put("x.configureStatusBar", r101);
        r100.put("x.showActionSheet", r101);
        r100.put("x.reportAppLog", r101);
        r100.put("x.getDebugInfo", r101);
        r100.put("x.getAppInfo", r101);
        r100.put("x.batchEvents", r101);
        r100.put("x.checkPermission", r101);
        r100.put("x.publishEvent", r101);
        r100.put("x.subscribeEvent", r101);
        r100.put("x.unsubscribeEvent", r101);
        r100.put("x.login", r101);
        r100.put("x.logout", r101);
        r100.put("x.showModal", r101);
        r100.put("x.downloadFile", r101);
        r100.put("x.uploadImage", r101);
        r100.put("x.closeSocket", r101);
        r100.put("x.readCalendarEvent", r101);
        r100.put("x.removeStorageItem", r101);
        r100.put("x.connectSocket", r101);
        r100.put("x.getGeckoInfo", r101);
        r100.put("x.reportALog", r101);
        r100.put("x.getStorageItem", r101);
        r100.put("x.allowCaptureScreen", r101);
        r100.put("x.uploadFile", r101);
        r100.put("x.canIUse", r101);
        r100.put("goLocationSettings", r101);
        r100.put("appendEntranceInfo", r101);
        r100.put("getBcmChainAndCartTrack", r101);
        r100.put("setBcmParams", r101);
        r100.put("getBcmChain", r101);
        r100.put("setBcmPageParamsV2", r101);
        r100.put("getBcmChainV2", r101);
        r100.put("registerBtmPage", r101);
        r100.put("createBtmChain", r101);
        r100.put("obtainEventBtmParams", r101);
        r100.put("createBtmId", r101);
        r100.put("willJumpToNextPage", r101);
        r100.put("sendBstExposureMethod", r101);
        r100.put("btm.createJumpSourceBtmToken", r101);
        r100.put("getAddictionInfoCache", r101);
        r100.put("checkLocationEnable", r101);
        r100.put("setElderModeState", r101);
        r100.put("getElderModeState", r101);
        r100.put("backToF2FCampaignVenue", r101);
        r100.put("notifyPushPermissionGuideOption", r101);
        r100.put("read_social_contact_permission", r101);
        r100.put("social_request_system_contact_permission", r101);
        r100.put("showInnerPush", r101);
        r100.put("luckycatRegisterStepListener", r101);
        r100.put("luckycatApplyStepPermission", r101);
        r100.put("luckycatGetStepCount", r101);
        r100.put("luckycatCheckStepPermission", r101);
        r100.put("luckycatIsStepCountSupport", r101);
        r100.put("luckycatTryInitPedometerSDK", r101);
        r100.put("luckycatUnregisterStepListener", r101);
        r100.put("isF2fFriendsFetchDisallow", r101);
        r100.put("requestSystemPermission", r101);
        r100.put("refreshAddictionInfo", r101);
        f18743a = r100;
    }

    public static Map a(String r110, IBDXBridgeContext r111, Map r112) {
        Intrinsics.checkNotNullParameter(r110, "methodName");
        Intrinsics.checkNotNullParameter(r111, "bridgeContext");
        Intrinsics.checkNotNullParameter(r112, "data");
        boolean r100 = false;
        if (Intrinsics.areEqual(r111.getNamespace(), "webcast") == false) goto L40;
        if (r111.getPlatformType() != PlatformType.WEB) goto L40;
        Boolean r101 = (Boolean) ((LinkedHashMap) f18743a).get(r110);
        if (r101 == null) goto L9;
        boolean r102 = r101.booleanValue();
    L10:
        if (r102 == false) goto L40;
        LinkedHashMap r113 = new LinkedHashMap();
        r113.putAll(r112);
        if ((r112.get("data") instanceof Map) == false) goto L33;
        Object r114 = r112.get("code");
        Object r115 = r112.get("data");
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        Iterator r116 = ((Map) r115).entrySet().iterator();
    L15:
        if (r116.hasNext() == false) goto L24;
        Map.Entry r103 = (Map.Entry) r116.next();
        Object r104 = r103.getValue();
        if (r104 == null) goto L15;
        r113.put(String.valueOf(r103.getKey()), r104);
        if (Intrinsics.areEqual("code", String.valueOf(r103.getKey())) == true) goto L20;
        if (Intrinsics.areEqual("data", String.valueOf(r103.getKey())) == false) goto L15;
        r100 = true;
        goto L15
    L20:
        r113.put("__code", r104);
        goto L15
    L24:
        if (r100 == true) goto L27;
        r113.remove("data");
    L27:
        if (h.s() == true) goto L29;
        r113.put("__code", r114);
    L37:
        r113.put("code", 1);
        return r113;
    L29:
        if (r113.get("__code") != null) goto L37;
        r113.put("__code", r114);
        goto L37
    L33:
        if (r112.get("__code") != null) goto L37;
        Object r117 = r112.get("code");
        if (r117 == null) goto L37;
        r113.put("__code", r117);
        goto L37
    L9:
        r102 = false;
    L40:
        if (Intrinsics.areEqual(r111.getNamespace(), "webcast") == true) goto L42;
    L62:
        return r112;
    L42:
        if (r111.getPlatformType() != PlatformType.LYNX) goto L62;
        Boolean r118 = (Boolean) ((LinkedHashMap) f18743a).get(r110);
        if (r118 == null) goto L46;
        boolean r119 = r118.booleanValue();
    L47:
        if (r119 == false) goto L62;
        LinkedHashMap r120 = new LinkedHashMap();
        r120.putAll(r112);
        r120.put("__msg_type", "callback");
        r120.put(b.f276361k, 0);
        r120.put("__callback_id", "0");
        if ((r112.get("data") instanceof Map) == true) goto L51;
    L60:
        r120.put("code", 1);
        return r120;
    L51:
        if (h.s() == false) goto L55;
        Object r121 = r112.get("data");
        Intrinsics.checkNotNull(r121, "null cannot be cast to non-null type kotlin.collections.Map<*, *>");
        Map r122 = (Map) r121;
        Object r105 = r122.get("__code");
        if (r105 != null) goto L56;
        r105 = r122.get("code");
    L56:
        LinkedHashMap r123 = new LinkedHashMap();
        Object r124 = r112.get("data");
        Intrinsics.checkNotNull(r124, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.Any, kotlin.Any>");
        r123.putAll((Map) r124);
        if (r105 == null) goto L59;
        r123.put("__code", r105);
    L59:
        r120.put("data", r123);
        goto L60
    L55:
        r105 = r120.get("code");
        goto L56
    L46:
        r119 = false;
        goto L47
    }
}
