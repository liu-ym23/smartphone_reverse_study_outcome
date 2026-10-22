package com.bytedance.android.livesdk.schema;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.schema.interfaces.IRoomActionHandler;
import com.bytedance.android.livesdk.schema.model.RoomSchemaMode;
import com.bytedance.android.livesdk.utils.d5;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class RoomActionUtilsForSaas {
    public static final String TAG = "RoomActionHandlerRoomActionUtilsForSaas";

    public RoomActionUtilsForSaas() {
    }

    private static String generateEcomLiveParamsForSaas(RoomSchemaMode r100) {
        String r101 = r100.getEcomLiveParams();
        if (TextUtils.isEmpty(r101) == true) goto L19;
        JsonObject r102 = new JsonParser().parse(r101).getAsJsonObject();     // Catch: Exception -> L14
        JsonObject r103 = new JsonObject();     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r100.getSearchId()) == true) goto L8;
        r103.addProperty("search_id", r100.getSearchId());     // Catch: Exception -> L14
    L8:
        if (TextUtils.isEmpty(r100.getSearchResultId()) == true) goto L11;
        r103.addProperty("search_result_id", r100.getSearchResultId());     // Catch: Exception -> L14
    L11:
        if (r103.size() <= 0) goto L20;
        r102.addProperty("search_params", r103.toString());     // Catch: Exception -> L14
        return r102.toString();
    L20:
        return r101;
    L14:
        e = move-exception;
        ALogger.e(TAG, "generateEcomLiveParams fail ecomLiveParams:" + r101, e);
        return r101;
    L19:
        return r101;
    }

    private static HashMap<String, String> generateLiveRoomExtraForSaas(String r100) {
        HashMap<String, String> r101 = null;
    L25:
        e = e;
    L26:
        ALogger.e(TAG, "generateLiveRoomExtra fail, ecomLiveParams:" + r100, e);
    L27:
        return r101;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L27;
        JsonObject r102 = new JsonParser().parse(r100).getAsJsonObject().getAsJsonObject("pass_through_log_data");     // Catch: Exception -> L25
        if (r102 == null) goto L27;
        JsonElement r103 = r102.get("group_id");     // Catch: Exception -> L25
        if (r103 != null) goto L10;
    L16:
        JsonElement r104 = r102.get("live_head_type");     // Catch: Exception -> L25
        if (r104 == null) goto L27;
        if (TextUtils.isEmpty(r104.getAsString()) == true) goto L27;
        String r105 = r104.getAsString();     // Catch: Exception -> L25
        if (r101 != null) goto L23;
        r101 = new HashMap();     // Catch: Exception -> L25
    L23:
        r101.put("live_head_type", r105);     // Catch: Exception -> L25
        goto L27
    L10:
        if (TextUtils.isEmpty(r103.getAsString()) == true) goto L16;
        String r106 = r103.getAsString();     // Catch: Exception -> L25
        HashMap<String, String> r107 = new HashMap();     // Catch: Exception -> L25
        r107.put("video_id", r106);     // Catch: Exception -> L14
        r101 = r107;
    L14:
        e = e;
        r101 = r107;
        goto L26
    }

    private static JSONObject parseJsonObject(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return null;
    L8:
        return new JSONObject(r100);
    L7:
        return null;
    }

    public static void fillBundleWithSaaSParams(Bundle r100, IRoomActionHandler.Params r101) {
        r100.putLong(ILiveRoomPlayFragmentConstant.EXTRA_FROM_PORTAL_ID, r101.portalId);
        r100.putString(ILiveRoomPlayFragmentConstant.EXTRA_SHARE_PLATFORM, r101.platform);
        r100.putString("from_user_id", r101.fromUserId);
        r100.putBoolean(ILiveRoomPlayFragmentConstant.CHECK_LIVE_LITE_EXTRA_BUNDlE, r101.checkLiveLiteExtraBundle);
        if (TextUtils.isEmpty(r101.cpsTrack) == true) goto L6;
        r100.putString(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_CPS_TRACK, r101.cpsTrack);
    L6:
        if (TextUtils.isEmpty(r101.ecomLiveParams) == true) goto L9;
        r100.putString(ILiveRoomPlayFragmentConstant.ENTER_ECOM_LIVE_PARAMS, r101.ecomLiveParams);
    L9:
        if (TextUtils.isEmpty(r101.adLiveParams) == true) goto L12;
        r100.putString(ILiveRoomPlayFragmentConstant.ENTER_AD_LIVE_PARAMS, r101.adLiveParams);
    L12:
        if (TextUtils.isEmpty(r101.feedExtraParams) == true) goto L14;
        r100.putString(ILiveRoomPlayFragmentConstant.EXTRA_FEED_EXTRA_PARAMS, r101.feedExtraParams);
    L14:
        HashMap r102 = r101.liveRoomExtra;
        if (r102 == null) goto L18;
        r100.putSerializable(ILiveRoomPlayFragmentConstant.EXTRA_PENETRATE_PARAMS, r102);
    L18:
        if (r101.disableSliding == false) goto L21;
        r100.putBoolean(ILiveRoomPlayFragmentConstant.BAN_VERTICAL_SMOOTH, true);
    L21:
        if (TextUtils.isEmpty(r101.appId) == true) goto L24;
        r100.putLong(ILiveRoomPlayFragmentConstant.EXTRA_APP_ID, d5.c(r101.appId));
    L24:
        if (TextUtils.isEmpty(r101.xiguaUid) == true) goto L27;
        r100.putLong(ILiveRoomPlayFragmentConstant.EXTRA_XIGUA_UID, d5.c(r101.xiguaUid));
    L27:
        if (TextUtils.isEmpty(r101.liveReason) == true) goto L30;
        r100.putLong("live_reason", d5.c(r101.liveReason));
    L30:
        if (TextUtils.isEmpty(r101.liveRecommend) == true) goto L33;
        r100.putLong(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO, d5.c(r101.liveRecommend));
    L33:
        if (TextUtils.isEmpty(r101.isFromCoinTask) == true) goto L36;
        r100.putString(ILiveRoomPlayFragmentConstant.EXTRA_FROM_COIN_TASK, r101.isFromCoinTask);
    L36:
        if (TextUtils.isEmpty(r101.isMedia) == true) goto L39;
        r100.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_IS_MEDIA, "1".equals(r101.isMedia));
        return;
    }

    public static void fillEnterLiveExtraWithSaaSParams(Bundle r100, IRoomActionHandler.Params r101) {
        r100.putString(ILiveRoomPlayFragmentConstant.EXTRA_SEARCH_RESULT_ID, r101.searchResultId);
        r100.putString("search_params", r101.searchParams);
        r100.putString(ILiveRoomPlayFragmentConstant.EXTRA_LIVE_ENTER_ROOM_HANDLE_SCHEMA, r101.schema);
        r100.putString("click_order", r101.clickOrder);
        String r102 = r101.roomLayout;
        if (r102 == null) goto L5;
        r100.putString(ILiveRoomPlayFragmentConstant.EXTRA_ROOM_LAYOUT, r102);
    L5:
        Boolean r103 = r101.autoEnter;
        if (r103 == null) goto L8;
        r100.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_AUTO_ENTER, r103.booleanValue());
    L8:
        Boolean r104 = r101.isFromPreview;
        if (r104 == null) goto L11;
        r100.putBoolean(ILiveRoomPlayFragmentConstant.EXTRA_IS_FROM_PREVIEW, r104.booleanValue());
    L11:
        Integer r105 = r101.isPluginInstall;
        if (r105 == null) goto L14;
        r100.putInt(ILiveRoomPlayFragmentConstant.EXTRA_IS_PLUGIN_INSTALL, r105.intValue());
    L14:
        Integer r106 = r101.isPluginLoad;
        if (r106 == null) goto L17;
        r100.putInt(ILiveRoomPlayFragmentConstant.EXTRA_IS_PLUGIN_LOAD, r106.intValue());
    L17:
        Long r107 = r101.pluginLoadTime;
        if (r107 == null) goto L20;
        r100.putLong(ILiveRoomPlayFragmentConstant.EXTRA_PLUGIN_LOAD_TIME, r107.longValue());
    L20:
        Long r108 = r101.tryEnterRoomTime;
        if (r108 == null) goto L23;
        r100.putLong(ILiveRoomPlayFragmentConstant.EXTRA_TRY_ENTER_ROOM_TIME, r108.longValue());
    L23:
        Integer r109 = r101.enterRoomNum;
        if (r109 == null) goto L26;
        r100.putInt(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_ROOM_NUM, r109.intValue());
    L26:
        Integer r110 = r101.isEnterFromOtherChannel;
        if (r110 == null) goto L30;
        r100.putInt(ILiveRoomPlayFragmentConstant.EXTRA_IS_ENTER_FROM_OTHER_CHANNEL, r110.intValue());
        return;
    }

    public static IRoomActionHandler.Params appendEnterParamsForSaaS(IRoomActionHandler.Params r210, Uri r211, RoomSchemaMode r212) {
        String r100 = UriProtector.getQueryParameter(r211, ILiveRoomPlayFragmentConstant.CHECK_LIVE_LITE_EXTRA_BUNDlE);
        if (r100 != null) goto L5;
    L9:
        boolean r101 = false;
    L10:
        String r102 = UriProtector.getQueryParameter(r211, "host");
        boolean r103 = "1".equals(UriProtector.getQueryParameter(r211, ILiveRoomPlayFragmentConstant.EXTRA_SINGLE_ROOM));
        String r104 = generateEcomLiveParamsForSaas(r212);
        de1.b r105 = (de1.b) jc1.k.f(de1.b.class);
        Boolean r106 = null;
        if (r105 == null) goto L28;
        if (r105.r5(r211) == false) goto L28;
        if (r105.e4(r212.getSchema()) == true) goto L19;
        r212.setSchema(null);
    L19:
        if (TextUtils.isEmpty(r104) == true) goto L28;
        JSONObject r110 = parseJsonObject(r104);
        if (r110 == null) goto L28;
        if (r110.has("jump_schema") == false) goto L28;
        if (r105.e4(r110.optString("jump_schema", null)) == true) goto L28;
        r110.remove("jump_schema");
        r104 = r110.toString();
    L28:
        HashMap<String, String> r107 = generateLiveRoomExtraForSaas(r104);
        String r111 = UriProtector.getQueryParameter(r211, "from_user_id");
        String r112 = UriProtector.getQueryParameter(r211, "platform");
        String r113 = r212.getRoomLayout();
        String r114 = UriProtector.getQueryParameter(r211, ILiveRoomPlayFragmentConstant.EXTRA_IS_MEDIA);
        if (r114 != null) goto L71;
        r114 = UriProtector.getQueryParameter(r211, ILiveRoomPlayFragmentConstant.EXTRA_ROOM_LAYOUT);
    L71:
        Integer r115 = Integer.valueOf(d5.b(r212.getEnterRoomNum()));     // Catch: Throwable -> L33
    L67:
        Boolean r116 = Boolean.valueOf(Boolean.parseBoolean(r212.getAutoEnter()));     // Catch: Throwable -> L36
    L63:
        r106 = Boolean.valueOf(Boolean.parseBoolean(r212.isFromPreview()));     // Catch: Throwable -> L56
    L59:
        Integer r108 = Integer.valueOf(d5.b(r212.isPluginInstall()));     // Catch: Throwable -> L41
    L57:
        Integer r117 = Integer.valueOf(d5.b(r212.isPluginLoad()));     // Catch: Throwable -> L44
    L61:
        Long r213 = Long.valueOf(d5.c(r212.getPluginLoadTime()));     // Catch: Throwable -> L47
    L65:
        Long r214 = Long.valueOf(d5.c(r212.getTryEnterRoomTime()));     // Catch: Throwable -> L50
    L69:
        Integer r215 = Integer.valueOf(d5.b(r212.isEnterFromOtherChannel()));     // Catch: Throwable -> L53
    L54:
        r210.setCheckLiveLiteExtraBundle(r101).setAppId(UriProtector.getQueryParameter(r211, "app_id")).setXiguaUid(UriProtector.getQueryParameter(r211, "xigua_uid")).setLiveReason(UriProtector.getQueryParameter(r211, "live_reason")).setIsFromCoinTask(UriProtector.getQueryParameter(r211, "from_coin_task")).setLiveRecommend(UriProtector.getQueryParameter(r211, ILiveRoomPlayFragmentConstant.EXTRA_LIVE_RECOMMEND_INFO)).setDisableSliding(r103).setIsMedia(r114).setCpsTrack(UriProtector.getQueryParameter(r211, "cps_track")).setSearchResultId(r212.getSearchResultId()).setRoomType(r102).setEcomLiveParams(r104).setFeedExtraParams(UriProtector.getQueryParameter(r211, ILiveRoomPlayFragmentConstant.EXTRA_FEED_EXTRA_PARAMS)).setAdLiveParams(UriProtector.getQueryParameter(r211, ILiveRoomPlayFragmentConstant.ENTER_AD_LIVE_PARAMS)).setForceNewActivityWhenJumpRoom("1".equals(r212.isReenter())).setFromUserId(r111).setPlatform(r112).setRoomLayout(r113).setLiveRoomExtra(r107).setEnterRoomNum(r115).setAutoEnter(r116).setIsFromPreview(r106).setIsPluginInstall(r108).setIsPluginLoad(r117).setPluginLoadTime(r213).setTryEnterRoomTime(r214).setIsEnterFromOtherChannel(r215).setBackHostActivity(UriProtector.getQueryParameter(r211, ILiveRoomPlayFragmentConstant.EXTRA_BACK_HOST_ACTIVITY));
        return r210;
    L53:
        r215 = null;
    L50:
        r214 = null;
    L47:
        r213 = null;
    L44:
        r117 = null;
    L41:
        r108 = null;
    L36:
        r116 = null;
    L33:
        r115 = null;
        goto L67
    L5:
        if (r100.isEmpty() == true) goto L9;
        if (CastIntegerProtector.parseInt(r100) <= 0) goto L9;
        r101 = true;
        goto L10
    }
}
