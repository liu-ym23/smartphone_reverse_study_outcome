package com.bytedance.android.live.livepkaudience.base;

import com.bytedance.android.livesdkapi.broadcastgame.GameSeiConstants;
import com.bytedance.android.livesdkapi.model.AnchorInteractInfo;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiCanvas;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.android.livesdkapi.model.StreamSize;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f81573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f81574b;

    public w(j r100) {
        this.f81573a = 0;
        this.f81574b = r100;
    }

    public static SeiAppData a(JSONObject r210) throws JSONException {
        String r100 = "loading";
        String r101 = "talk_volume";
        SeiAppData r102 = new SeiAppData();
        r102.setTimestamp(r210.optLong("timestamp"));
        r102.setVersion(r210.optInt("ver"));
        r102.setStyle(r210.optInt("style"));
        r102.setVendor(r210.optString(Constants.OperatorKey.KEY_VENDOR));
        r102.setChannelId(r210.optString("channel_id"));
        r102.setSubScene(r210.optInt(BdpAppEventConstant.PARAMS_SUB_SCENE));
        r102.setGameType(r210.optInt(BdpAppEventConstant.PARAMS_GAME_TYPE));
        r102.setGameFull(r210.optInt("game_full"));
        r102.setGameFullV2(r210.optInt("game_full_v2"));
        r102.setGameMixStreamType(r210.optInt("mix_stream_type"));
        r102.setLayoutKey(r210.optString("layout_key"));
        String r103 = r210.optString("grids");
        r102.setCount(r210.optLong("count", 0));
        r102.setEventParams(r210.optJSONObject("event_params"));
        JSONObject r110 = r210.optJSONObject("anchor_interact_info");     // Catch: Exception -> L46
        if (r110 == null) goto L6;
        AnchorInteractInfo r111 = new AnchorInteractInfo();     // Catch: Exception -> L46
        r111.setFocusID(r110.optString("focus_id"));     // Catch: Exception -> L46
        r111.setLayoutType(r110.optInt("layout_type"));     // Catch: Exception -> L46
        r111.setOwnerIndex(r110.optInt("owner_index"));     // Catch: Exception -> L46
        r102.setAnchorInteractInfo(r111);     // Catch: Exception -> L46
    L6:
        JSONObject r112 = r210.optJSONObject("stream_size");     // Catch: Exception -> L46
        if (r112 == null) goto L11;
        StreamSize r113 = new StreamSize();     // Catch: Exception -> L46
        r113.setH(r112.optDouble("h"));     // Catch: Exception -> L46
        r113.setW(r112.optDouble("w"));     // Catch: Exception -> L46
        r113.setX(r112.optDouble("x"));     // Catch: Exception -> L46
        r113.setY(r112.optDouble("y"));     // Catch: Exception -> L46
        r113.setGameRatio(r112.optDouble(GameSeiConstants.KEY_GAME_RATIO));     // Catch: Exception -> L46
        r102.setStreamSize(r113);     // Catch: Exception -> L46
    L11:
        JSONArray r104 = new JSONArray(r103);     // Catch: Exception -> L46
        int r105 = r104.length();     // Catch: Exception -> L46
        ArrayList r106 = new ArrayList();     // Catch: Exception -> L46
        int r114 = 0;
    L12:
        if (r114 >= r105) goto L42;
        JSONObject r115 = (JSONObject) r104.opt(r114);     // Catch: Exception -> L46
        JSONArray r116 = r104;
        int r117 = r105;
        SeiAppData r107 = r102;
        ArrayList r118 = r106;
        SeiRegion r108 = new SeiRegion().setType(r115.optInt("type")).setX(r115.optDouble("x")).setY(r115.optDouble("y")).setWidth(r115.optDouble("w")).setHeight(r115.optDouble("h"));     // Catch: Exception -> L44
        r108.setAccount(r115.optLong("account"));     // Catch: Exception -> L44
        if (r115.has("p") == false) goto L19;
        r108.setPosition(r115.optInt("p"));     // Catch: Exception -> L44
    L19:
        if (r115.has("uid") == false) goto L22;
        r108.setUid(r115.optInt("uid"));     // Catch: Exception -> L44
    L22:
        if (r115.has("uid_str") == false) goto L25;
        r108.setUidStr(r115.optString("uid_str"));     // Catch: Exception -> L44
    L25:
        if (r115.has("talk") == false) goto L28;
        r108.setTalk(r115.optInt("talk"));     // Catch: Exception -> L44
    L28:
        if (r115.has("mute_audio") == false) goto L31;
        r108.setMuteAudio(r115.optInt("mute_audio"));     // Catch: Exception -> L44
    L31:
        if (r115.has(r101) == false) goto L33;
        r108.setTalkVolume(r115.optInt(r101));     // Catch: Exception -> L44
    L33:
        String r109 = r100;
        if (r115.has(r109) == false) goto L41;
        boolean r119 = true;
        if (r115.optInt(r109) == 1) goto L39;
        r119 = false;
    L39:
        r108.setIsLocal(r119);     // Catch: Exception -> L44
    L41:
        r108.setStatus(r115.optInt(CloudControlInf.STAT));     // Catch: Exception -> L44
        r118.add(r108);     // Catch: Exception -> L44
        r114 = r114 + 1;     // Catch: Exception -> L44
        r106 = r118;
        r101 = r101;
        r104 = r116;
        r100 = r109;
        r102 = r107;
        r105 = r117;
    L44:
        e = e;
    L48:
        e.printStackTrace();
    L49:
        JSONObject r120 = r210.optJSONObject("canvas");
        if (r120 == null) goto L52;
        SeiCanvas r121 = new SeiCanvas();
        r121.setWidth(r120.optInt("width"));
        r121.setHeight(r120.optInt("height"));
        r121.setBackground(r120.optString("background"));
        r107.setCanvas(r121);
    L52:
        return r107;
    L42:
        r107 = r102;
        r107.setGrids(r106);     // Catch: Exception -> L44
    L46:
        e = e;
        r107 = r102;
        goto L48
    }
}
