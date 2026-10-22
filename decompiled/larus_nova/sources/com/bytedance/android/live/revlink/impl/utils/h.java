package com.bytedance.android.live.revlink.impl.utils;

import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import com.bytedance.android.livesdk.model.AlignModeType;
import com.bytedance.android.livesdk.model.RenderViewScaleType;
import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.model.RevStreamSize;
import com.bytedance.android.livesdk.model.m0;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdk.model.q0;
import com.bytedance.android.livesdk.model.r0;
import com.bytedance.android.livesdkapi.broadcastgame.GameSeiConstants;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class h {
    static {
    }

    public static p0 a(JSONObject r110) {
        Intrinsics.checkNotNullParameter(r110, "appData");
        p0 r100 = new p0();
        r100.A(r110.optLong("timestamp"));     // Catch: Throwable -> L54
        r100.D(r110.optInt("ver"));     // Catch: Throwable -> L54
        r100.B(r110.optInt("ui_layout"));     // Catch: Throwable -> L54
        r100.y(r110.optInt("style"));     // Catch: Throwable -> L54
        r100.C(r110.optString(Constants.OperatorKey.KEY_VENDOR));     // Catch: Throwable -> L54
        r100.l(r110.optString("channel_id"));     // Catch: Throwable -> L54
        r100.u(r110.optString("layout_key"));     // Catch: Throwable -> L54
        r100.z(r110.optInt(BdpAppEventConstant.PARAMS_SUB_SCENE));     // Catch: Throwable -> L54
        r100.r(r110.optInt(BdpAppEventConstant.PARAMS_GAME_TYPE));     // Catch: Throwable -> L54
        r100.o(r110.optInt("game_full"));     // Catch: Throwable -> L54
        r100.p(r110.optInt("game_full_v2"));     // Catch: Throwable -> L54
        r100.q(r110.optInt("mix_stream_type"));     // Catch: Throwable -> L54
        String r101 = r110.optString("grids");     // Catch: Throwable -> L54
        int r102 = 0;
        long r103 = 0;
        r103 = r110.optLong("count", r103);     // Catch: Throwable -> L7
    L9:
        r100.m(r103);     // Catch: Throwable -> L54
        r100.t((float) r110.optDouble("landscape_ratio"));     // Catch: Throwable -> L54
        r100.w((float) r110.optDouble("portrait_ratio"));     // Catch: Throwable -> L54
        r100.n(r110.optJSONObject("event_params"));     // Catch: Throwable -> L54
        JSONObject r104 = r110.optJSONObject("anchor_interact_info");     // Catch: Throwable -> L54
        if (r104 == null) goto L23;
        m0 r105 = new m0();     // Catch: Throwable -> L54
        r105.h(r104.optString("focus_id"));     // Catch: Throwable -> L54
        r105.j(r104.optInt("layout_type"));     // Catch: Throwable -> L54
        r105.l(r104.optInt("owner_index"));     // Catch: Throwable -> L54
        r105.k(r104.optInt("mix_owner_index"));     // Catch: Throwable -> L54
        r105.i(r104.optInt("is_horizontal"));     // Catch: Throwable -> L54
        int r111 = r105.c();     // Catch: Throwable -> L54
        UILayout r112 = UILayout.FULL;     // Catch: Throwable -> L54
        if (r111 != r112.ordinal()) goto L15;
        RenderViewScaleType r113 = RenderViewScaleType.HEIGHT_ALIGN;     // Catch: Throwable -> L54
    L16:
        r105.m(r113.getValue());     // Catch: Throwable -> L54
        if (r105.c() != r112.ordinal()) goto L19;
        AlignModeType r114 = AlignModeType.RIGHT_ALIGN;     // Catch: Throwable -> L54
    L20:
        r105.f(r114.getValue());     // Catch: Throwable -> L54
        r100.j(r105);     // Catch: Throwable -> L54
        JSONObject r106 = r104.optJSONObject("content");     // Catch: Throwable -> L54
        if (r106 == null) goto L23;
        r0 r115 = new r0();     // Catch: Throwable -> L54
        r115.g(r106.optDouble("x"));     // Catch: Throwable -> L54
        r115.h(r106.optDouble("y"));     // Catch: Throwable -> L54
        r115.f(r106.optDouble("w"));     // Catch: Throwable -> L54
        r115.e(r106.optDouble("h"));     // Catch: Throwable -> L54
        r105.g(r115);     // Catch: Throwable -> L54
        goto L23
    L19:
        r114 = AlignModeType.HORIZONTAL_CENTER_ALIGN;     // Catch: Throwable -> L54
        goto L20
    L15:
        r113 = RenderViewScaleType.WIDTH_ALIGN;     // Catch: Throwable -> L54
    L23:
        JSONObject r107 = r110.optJSONObject("stream_size");     // Catch: Throwable -> L54
        if (r107 == null) goto L26;
        RevStreamSize r108 = new RevStreamSize();     // Catch: Throwable -> L54
        r108.setH(r107.optDouble("h"));     // Catch: Throwable -> L54
        r108.setW(r107.optDouble("w"));     // Catch: Throwable -> L54
        r108.setX(r107.optDouble("x"));     // Catch: Throwable -> L54
        r108.setY(r107.optDouble("y"));     // Catch: Throwable -> L54
        r108.setGameRatio(r107.optDouble(GameSeiConstants.KEY_GAME_RATIO));     // Catch: Throwable -> L54
        r100.x(r108);     // Catch: Throwable -> L54
    L26:
        JSONArray r109 = new JSONArray(r101);     // Catch: Throwable -> L54
        int r116 = r109.length();     // Catch: Throwable -> L54
        ArrayList r117 = new ArrayList();     // Catch: Throwable -> L54
        int r118 = 0;
    L29:
        if (r118 >= r116) goto L35;
        Object r119 = r109.opt(r118);     // Catch: Throwable -> L54
        if (r119 == null) goto L34;
        r117.add(b((JSONObject) r119, false));     // Catch: Throwable -> L54
        r118 = r118 + 1;     // Catch: Throwable -> L54
        goto L29
    L34:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.JSONObject /* = org.json.JSONObject */");     // Catch: Throwable -> L54
    L35:
        r100.s(r117);     // Catch: Throwable -> L54
        if (z41.g.f569928o.b() == true) goto L38;
    L50:
        JSONObject r120 = r110.optJSONObject("canvas");     // Catch: Throwable -> L54
        if (r120 == null) goto L56;
        q0 r121 = new q0();     // Catch: Throwable -> L54
        r121.e(r120.optInt("width"));     // Catch: Throwable -> L54
        r121.d(r120.optInt("height"));     // Catch: Throwable -> L54
        r121.c(r120.optString("background"));     // Catch: Throwable -> L54
        r100.k(r121);     // Catch: Throwable -> L54
    L56:
        return r100;
    L38:
        if (r110.has("mix_grids") == false) goto L50;
        JSONArray r122 = new JSONArray(r110.optString("mix_grids"));     // Catch: Throwable -> L48
        int r123 = r122.length();     // Catch: Throwable -> L48
        ArrayList r124 = new ArrayList();     // Catch: Throwable -> L48
    L40:
        if (r102 >= r123) goto L46;
        Object r125 = r122.opt(r102);     // Catch: Throwable -> L48
        if (r125 == null) goto L45;
        r124.add(b((JSONObject) r125, true));     // Catch: Throwable -> L48
        r102 = r102 + 1;     // Catch: Throwable -> L48
        goto L40
    L45:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.JSONObject /* = org.json.JSONObject */");     // Catch: Throwable -> L48
    L46:
        r100.v(r124);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L54
        goto L50
    L7:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        th.printStackTrace();
        goto L56
    }

    public static RevSeiRegion b(JSONObject r100, boolean r101) {
        RevSeiRegion r102 = new RevSeiRegion();
        r102.setType(r100.optInt("type"));
        r102.setX(r100.optDouble("x"));
        r102.setY(r100.optDouble("y"));
        r102.setWidth(r100.optDouble("w"));
        r102.setHeight(r100.optDouble("h"));
        r102.setAccount(String.valueOf(r100.optLong("account")));     // Catch: Throwable -> L5
    L7:
        if (r100.has("p") == false) goto L10;
        r102.setPosition(r100.optInt("p"));
    L10:
        if (r100.has("uid") == false) goto L13;
        r102.setUid(r100.optInt("uid"));
    L13:
        if (r100.has("uid_str") == false) goto L16;
        r102.setUidStr(r100.optString("uid_str"));
    L16:
        if (r100.has("talk") == false) goto L19;
        r102.setTalk(r100.optInt("talk"));
    L19:
        if (r100.has("mute_audio") == false) goto L22;
        r102.setMuteAudio(r100.optInt("mute_audio"));
    L22:
        if (r100.has("talk_volume") == false) goto L25;
        r102.setTalkVolume(r100.optInt("talk_volume"));
    L25:
        if (r100.has("loading") == false) goto L31;
        boolean r103 = true;
        if (r100.optInt("loading") == 1) goto L30;
        r103 = false;
    L30:
        r102.setLocal(r103);
    L31:
        r102.setStatus(r100.optInt(CloudControlInf.STAT));
        if (r101 == false) goto L34;
        r102.setWindowType(r100.optInt("w_type"));
    L34:
        return r102;
    }
}
