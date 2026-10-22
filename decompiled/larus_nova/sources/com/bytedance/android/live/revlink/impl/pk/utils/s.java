package com.bytedance.android.live.revlink.impl.pk.utils;

import com.bytedance.android.livesdk.model.RevSeiRegion;
import com.bytedance.android.livesdk.model.RevStreamSize;
import com.bytedance.android.livesdk.model.m0;
import com.bytedance.android.livesdk.model.p0;
import com.bytedance.android.livesdk.model.q0;
import com.bytedance.android.livesdkapi.broadcastgame.GameSeiConstants;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f97134c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f97135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f97136b;

    public static final class a {
        public static p0 a(JSONObject r110, String r210) {
            String r100 = "loading";
            String r101 = "talk_volume";
            String r102 = "mute_audio";
            Intrinsics.checkNotNullParameter(r110, "appData");
            p0 r103 = new p0();
            r103.A(r110.optLong("timestamp"));
            r103.D(r110.optInt("ver"));
            r103.y(r110.optInt("style"));
            r103.C(r110.optString(Constants.OperatorKey.KEY_VENDOR));
            r103.l(r110.optString("channel_id"));
            r103.u(r110.optString("layout_key"));
            r103.z(r110.optInt(BdpAppEventConstant.PARAMS_SUB_SCENE));
            r103.r(r110.optInt(BdpAppEventConstant.PARAMS_GAME_TYPE));
            r103.o(r110.optInt("game_full"));
            r103.p(r110.optInt("game_full_v2"));
            r103.q(r110.optInt("mix_stream_type"));
            String r111 = r110.optString("grids");
            r103.m(r110.optLong("count", 0));
            r103.n(r110.optJSONObject("event_params"));
            JSONObject r112 = r110.optJSONObject("anchor_interact_info");     // Catch: Exception -> L55
            if (r112 == null) goto L6;
            m0 r113 = new m0();     // Catch: Exception -> L55
            r113.h(r112.optString("focus_id"));     // Catch: Exception -> L55
            r113.j(r112.optInt("layout_type"));     // Catch: Exception -> L55
            r113.l(r112.optInt("owner_index"));     // Catch: Exception -> L55
            r103.j(r113);     // Catch: Exception -> L55
        L6:
            JSONObject r114 = r110.optJSONObject("stream_size");     // Catch: Exception -> L55
            if (r114 == null) goto L12;
            RevStreamSize r104 = new RevStreamSize();     // Catch: Exception -> L55
            r104.setH(r114.optDouble("h"));     // Catch: Exception -> L55
            r104.setW(r114.optDouble("w"));     // Catch: Exception -> L55
            r104.setX(r114.optDouble("x"));     // Catch: Exception -> L55
            r104.setY(r114.optDouble("y"));     // Catch: Exception -> L55
            r104.setGameRatio(r114.optDouble(GameSeiConstants.KEY_GAME_RATIO));     // Catch: Exception -> L55
            r103.x(r104);     // Catch: Exception -> L55
        L12:
            JSONArray r105 = r110.optJSONArray("grids");     // Catch: Exception -> L55
            if (z41.d.f569904c.a9() == false) goto L16;
            if (r105 == null) goto L16;
        L17:
            int r106 = r105.length();     // Catch: Exception -> L55
            ArrayList r107 = new ArrayList();     // Catch: Exception -> L55
            int r108 = 0;
        L18:
            if (r108 >= r106) goto L53;
            Object r115 = r105.opt(r108);     // Catch: Exception -> L55
            if (r115 == null) goto L52;
            JSONObject r116 = (JSONObject) r115;     // Catch: Exception -> L55
            RevSeiRegion r117 = new RevSeiRegion();     // Catch: Exception -> L55
            JSONArray r118 = r105;
            r117.setType(r116.optInt("type"));     // Catch: Exception -> L55
            r117.setX(r116.optDouble("x"));     // Catch: Exception -> L55
            r117.setY(r116.optDouble("y"));     // Catch: Exception -> L55
            r117.setWidth(r116.optDouble("w"));     // Catch: Exception -> L55
            r117.setHeight(r116.optDouble("h"));     // Catch: Exception -> L55
            r117.setAccount(String.valueOf(r116.optLong("account")));     // Catch: Throwable -> L61
        L24:
            if (r116.has("p") == false) goto L27;
            r117.setPosition(r116.optInt("p"));     // Catch: Exception -> L55
        L27:
            if (r116.has("uid") == false) goto L30;
            r117.setUid(r116.optInt("uid"));     // Catch: Exception -> L55
        L30:
            if (r116.has("uid_str") == false) goto L33;
            r117.setUidStr(r116.optString("uid_str"));     // Catch: Exception -> L55
        L33:
            if (r116.has("talk") == false) goto L35;
            r117.setTalk(r116.optInt("talk"));     // Catch: Exception -> L55
        L35:
            r102 = r102;
            if (r116.has(r102) == false) goto L38;
            r117.setMuteAudio(r116.optInt(r102));     // Catch: Exception -> L55
        L38:
            r101 = r101;
            if (r116.has(r101) == false) goto L42;
            r117.setTalkVolume(r116.optInt(r101));     // Catch: Exception -> L55
        L42:
            r100 = r100;
            if (r116.has(r100) == false) goto L50;
            int r109 = r116.optInt(r100);     // Catch: Exception -> L55
            boolean r119 = true;
            if (r109 == 1) goto L48;
            r119 = false;
        L48:
            r117.setLocal(r119);     // Catch: Exception -> L55
        L50:
            r117.setStatus(r116.optInt(CloudControlInf.STAT));     // Catch: Exception -> L55
            r107.add(r117);     // Catch: Exception -> L55
            r108 = r108 + 1;     // Catch: Exception -> L55
            r105 = r118;
            goto L18
        L52:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.revenue.platform.api.core.JSONObject /* = org.json.JSONObject */");     // Catch: Exception -> L55
        L53:
            r103.s(r107);     // Catch: Exception -> L55
        L57:
            JSONObject r120 = r110.optJSONObject("canvas");
            if (r120 == null) goto L60;
            q0 r121 = new q0();
            r121.e(r120.optInt("width"));
            r121.d(r120.optInt("height"));
            r121.c(r120.optString("background"));
            r103.k(r121);
        L60:
            return r103;
        L16:
            r105 = new JSONArray(r111);     // Catch: Exception -> L55
        L55:
            e = move-exception;
            e.printStackTrace();
            goto L57
        }
    }

    static {
    }

    public s(g r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f97136b = r100;
    }
}
