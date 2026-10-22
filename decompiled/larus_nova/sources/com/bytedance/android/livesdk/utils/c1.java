package com.bytedance.android.livesdk.utils;

import android.os.Bundle;
import com.bytedance.android.live.base.model.commerce.DouPlusEntry;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.room.state.RoomState;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class c1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f158903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static HashMap<String, String> f158904b;

    public static DouPlusEntry a(DataCenter r100) {
        if (r100 == null) goto L5;
        DouPlusEntry r101 = (DouPlusEntry) r100.get("data_dou_plus_promote_entry", DouPlusEntry.defaultOne());
    L6:
        if (r100 != null) goto L8;
    L9:
        boolean r102 = true;
        if (r100 != null) goto L12;
    L11:
        boolean r103 = true;
    L19:
        if (r103 == true) goto L22;
    L21:
        r102 = false;
    L22:
        r101.enableShareEntry = r102;
        return (DouPlusEntry) r100.get("data_dou_plus_promote_entry", DouPlusEntry.defaultOne());
    L12:
        IRoom r104 = (IRoom) r100.get("data_room", null);
        if (r104 == null) goto L11;
        IRoomAuthStatus r105 = r104.getRoomAuthStatus();
        if (r105 == null) goto L11;
        r103 = r105.isEnableDouPlus();
        goto L19
    L8:
        if (((Boolean) r100.get("data_dou_plus_share_entry_enable", Boolean.TRUE)).booleanValue() == false) goto L21;
    L5:
        r101 = DouPlusEntry.defaultOne();
        goto L6
    }

    public static boolean b(DataCenter r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (((Boolean) r100.get("enter_from_dou_plus", Boolean.FALSE)).booleanValue() == false) goto L6;
        return true;
    }

    public static boolean c(DataCenter r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (((Boolean) r100.get("enter_from_effect_ad", Boolean.FALSE)).booleanValue() == false) goto L6;
        return true;
    }

    public static boolean d(DataCenter r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (((Boolean) r100.get("param_send_ad_click_event", Boolean.FALSE)).booleanValue() == false) goto L6;
        return true;
    }

    public static Map<String, String> e(DataCenter r100) {
        if (r100 != null) goto L6;
        return new HashMap();
    L6:
        return (Map) r100.get("live_douplus_log_extra", new HashMap());
    }

    public static Map<String, String> f(DataCenter r100) {
        if (r100 == null) goto L7;
        Map<String, String> r101 = (Map) r100.get(ILiveRoomPlayFragmentConstant.DATA_LIVE_EFFECT_AD_LOG_EXTRA_MAP, new HashMap());
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new HashMap();
    }

    public static com.bytedance.android.livesdk.sharedpref.e<Boolean> g(String r100) {
        return new com.bytedance.android.livesdk.sharedpref.e("has_enter_dou_plus_entry_" + r100, Boolean.FALSE);
    }

    public static com.bytedance.android.livesdk.sharedpref.e<Long> h(String r100) {
        return new com.bytedance.android.livesdk.sharedpref.e("enter_live_room_times_" + r100, 0L);
    }

    public static int i(DataCenter r100) {
        if (r100 != null) goto L5;
    L9:
        return 0;
    L5:
        if (c(r100) == false) goto L9;
        return ((Integer) r100.get(LiveCommonConstants.EXTRA_LIVE_AD_TYPE, 0)).intValue();
    }

    public static void k(DataCenter r100, Bundle r101) {
        if (r100 == null) goto L7;
        if (r101 == null) goto L8;
        r100.put("enter_from_dou_plus", Boolean.valueOf(r101.getBoolean("enter_from_dou_plus", false)));
        r100.put("live_douplus_log_extra", r101.getSerializable("live_douplus_log_extra"));
        return;
    L8:
        return;
    }

    public static void l(DataCenter r100, Bundle r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L13;
        r100.put("enter_from_effect_ad", Boolean.valueOf(r101.getBoolean("enter_from_effect_ad", false)));
        r100.put(ILiveRoomPlayFragmentConstant.DATA_LIVE_EFFECT_AD_LOG_EXTRA_MAP, r101.getSerializable(ILiveRoomPlayFragmentConstant.DATA_LIVE_EFFECT_AD_LOG_EXTRA_MAP));
        r100.put(RoomState.EXTRA_BOOL_AUTO_OPEN_LIVE_AD_LANDING_PAGE, Boolean.valueOf(r101.getBoolean(RoomState.EXTRA_BOOL_AUTO_OPEN_LIVE_AD_LANDING_PAGE, false)));
        r100.put("param_send_ad_click_event", Boolean.valueOf(r101.getBoolean("param_send_ad_click_event")));
        r100.put("param_live_stay_send_click_delay", Integer.valueOf(r101.getInt("param_live_stay_send_click_delay")));
        r100.put("param_live_after_seconds_track_click", Integer.valueOf(r101.getInt("param_live_after_seconds_track_click")));
        r100.put(LiveCommonConstants.EXTRA_LIVE_AD_TYPE, Integer.valueOf(CastIntegerProtector.parseInt(r101.getString(LiveCommonConstants.EXTRA_LIVE_AD_TYPE))));     // Catch: Exception -> L8
        return;
    L8:
        r100.put(LiveCommonConstants.EXTRA_LIVE_AD_TYPE, 0);
        return;
    L13:
        return;
    }

    public static void j(DouPlusEntry r100, Room r101, DataCenter r102) {
        if (r100 != null) goto L4;
        r100 = DouPlusEntry.defaultOne();
    L4:
        if (r101 == null) goto L6;
        r101.setDouPlusPromotion(r100.hasDouPlusEntry);
    L6:
        if (r102 == null) goto L9;
        r102.put("data_dou_plus_promote_entry", r100);
        return;
    }
}
