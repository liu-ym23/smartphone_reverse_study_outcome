package com.bytedance.android.live.liveinteract.api.utils;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.y4;
import com.bytedance.android.livesdk.config.b60;
import com.bytedance.android.livesdkapi.broadcastgame.GameSeiConstants;
import com.bytedance.android.livesdkapi.model.AnchorInteractInfo;
import com.bytedance.android.livesdkapi.model.SeiAppData;
import com.bytedance.android.livesdkapi.model.SeiCanvas;
import com.bytedance.android.livesdkapi.model.SeiRegion;
import com.bytedance.android.livesdkapi.model.StreamSize;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.backupsei.MultiLinkBizBackupSeiExperimentUtils;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes46.dex */
public final class j implements md0.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f71515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f71516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final md0.a.InterfaceC6802a f71517c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final md0.a.b f71518d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final md0.a.c f71519e;

    public j(md0.a.InterfaceC6802a r100) {
        this.f71515a = 0;
        this.f71516b = 0;
        this.f71517c = r100;
    }

    public final boolean c(JSONObject r100) {
        List<String> r101 = LiveSeiUtil.f71500a;
        int r102 = 0;
    L4:
        if (r102 >= r101.size()) goto L9;
        if (r100.has((String) ListProtector.get(r101, r102)) == true) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        boolean r103 = true;
    L11:
        if (this.f71518d == null) goto L17;
        if (r103 == false) goto L18;
        return true;
    L18:
        return false;
    L17:
        return false;
    L9:
        r103 = false;
        goto L11
    }

    public final void d(String r110) {
        e(r110, new ye1.a(false, "", 0, 0, 0, null));
    }

    public j(md0.a.InterfaceC6802a r100, md0.a.c r101) {
        this(r100);
        this.f71519e = r101;
    }

    public static SeiAppData a(JSONObject r210, String r211) throws JSONException {
        String r100 = "loading";
        String r101 = "talk_volume";
        SeiAppData r110 = new SeiAppData();
        r110.setTimestamp(r210.optLong("timestamp"));
        r110.setVersion(r210.optInt("ver"));
        r110.setUiLayout(r210.optInt("ui_layout"));
        r110.setStyle(r210.optInt("style"));
        r110.setPositionStashStatus(r210.optInt("position_stash_status"));
        r110.setVendor(r210.optString(Constants.OperatorKey.KEY_VENDOR));
        r110.setChannelId(r210.optString("channel_id"));
        r110.setSubScene(r210.optInt(BdpAppEventConstant.PARAMS_SUB_SCENE));
        r110.setGameType(r210.optInt(BdpAppEventConstant.PARAMS_GAME_TYPE));
        r110.setGameFull(r210.optInt("game_full"));
        r110.setGameFullV2(r210.optInt("game_full_v2"));
        r110.setGameMixStreamType(r210.optInt("mix_stream_type"));
        r110.setLayoutKey(r210.optString("layout_key"));
        String r111 = r210.optString("grids");
        r110.setCount(r210.optLong("count", 0));
        r110.setEventParams(r210.optJSONObject("event_params"));
        r110.setShowPlayer(r210.optString("show_player"));
        r110.setHideAudioBg(r210.optInt("hide_audio_bg"));
        if (r210.has("play_mode_list") == false) goto L5;
        r110.setPlayMode(r210.optString("play_mode_list"));
    L5:
        r110.setSubUILayout(r210.optInt("sub_ui_layout"));
        r110.setHideMicseat(r210.optInt("hide_micseat"));
        if (r210.has("ui_feature_list") == false) goto L63;
        r110.setUiFeatureList(r210.optJSONArray("ui_feature_list"));
    L63:
        JSONObject r112 = r210.optJSONObject("anchor_interact_info");     // Catch: Exception -> L55
        if (r112 == null) goto L11;
        AnchorInteractInfo r113 = new AnchorInteractInfo();     // Catch: Exception -> L55
        r113.setFocusID(r112.optString("focus_id"));     // Catch: Exception -> L55
        r113.setLayoutType(r112.optInt("layout_type"));     // Catch: Exception -> L55
        r113.setOwnerIndex(r112.optInt("owner_index"));     // Catch: Exception -> L55
        r110.setAnchorInteractInfo(r113);     // Catch: Exception -> L55
    L11:
        JSONObject r114 = r210.optJSONObject("stream_size");     // Catch: Exception -> L55
        String r102 = "h";
        if (r114 == null) goto L16;
        StreamSize r103 = new StreamSize();     // Catch: Exception -> L55
        r103.setH(r114.optDouble("h"));     // Catch: Exception -> L55
        r103.setW(r114.optDouble("w"));     // Catch: Exception -> L55
        r103.setX(r114.optDouble("x"));     // Catch: Exception -> L55
        r103.setY(r114.optDouble("y"));     // Catch: Exception -> L55
        r103.setGameRatio(r114.optDouble(GameSeiConstants.KEY_GAME_RATIO));     // Catch: Exception -> L55
        r110.setStreamSize(r103);     // Catch: Exception -> L55
    L16:
        JSONArray r104 = new JSONArray(r111);     // Catch: Exception -> L55
        int r105 = r104.length();     // Catch: Exception -> L55
        ArrayList r106 = new ArrayList();     // Catch: Exception -> L55
        int r115 = 0;
    L17:
        if (r115 >= r105) goto L53;
        JSONObject r116 = (JSONObject) r104.opt(r115);     // Catch: Exception -> L55
        JSONArray r117 = r104;
        int r118 = r105;
        ArrayList r212 = r106;
        SeiRegion r107 = new SeiRegion().setType(r116.optInt("type")).setX(r116.optDouble("x")).setY(r116.optDouble("y")).setWidth(r116.optDouble("w")).setHeight(r116.optDouble(r102));     // Catch: Exception -> L55
        r107.setAccount(r116.optLong("account"));     // Catch: Exception -> L55
        if (r116.has("p") == false) goto L22;
        r107.setPosition(r116.optInt("p"));     // Catch: Exception -> L55
    L22:
        if (r116.has("uid") == false) goto L25;
        r107.setUid(r116.optInt("uid"));     // Catch: Exception -> L55
    L25:
        if (r116.has("uid_str") == false) goto L28;
        r107.setUidStr(r116.optString("uid_str"));     // Catch: Exception -> L55
    L28:
        if (r116.has("talk") == false) goto L31;
        r107.setTalk(r116.optInt("talk"));     // Catch: Exception -> L55
    L31:
        if (r116.has("mute_audio") == false) goto L33;
        r107.setMuteAudio(r116.optInt("mute_audio"));     // Catch: Exception -> L55
    L33:
        String r108 = r101;
        if (r116.has(r108) == false) goto L36;
        r107.setTalkVolume(r116.optInt(r108));     // Catch: Exception -> L55
    L36:
        String r109 = r100;
        String r119 = r102;
        if (r116.has(r109) == false) goto L45;
        if (r116.optInt(r109) != 1) goto L41;
        boolean r120 = true;
    L42:
        r107.setIsLocal(r120);     // Catch: Exception -> L55
        goto L45
    L41:
        r120 = false;
    L45:
        if (r116.has("visible") == true) goto L47;
        r107.setVisible(true);     // Catch: Exception -> L55
    L52:
        r107.setStatus(r116.optInt(CloudControlInf.STAT));     // Catch: Exception -> L55
        r212.add(r107);     // Catch: Exception -> L55
        r115 = r115 + 1;     // Catch: Exception -> L55
        r100 = r109;
        r104 = r117;
        r105 = r118;
        r106 = r212;
        r102 = r119;
        r101 = r108;
        goto L17
    L47:
        if (r116.optInt("visible") != 1) goto L49;
        boolean r121 = true;
    L50:
        r107.setVisible(r121);     // Catch: Exception -> L55
        goto L52
    L49:
        r121 = false;
        goto L50
    L53:
        r110.setGrids(r106);     // Catch: Exception -> L55
    L59:
        JSONObject r122 = r210.optJSONObject("canvas");
        if (r122 == null) goto L62;
        SeiCanvas r123 = new SeiCanvas();
        r123.setWidth(r122.optInt("width"));
        r123.setHeight(r122.optInt("height"));
        r123.setBackground(r122.optString("background"));
        r110.setCanvas(r123);
    L62:
        return r110;
    L55:
        e = move-exception;
        ALogger.e("LiveSeiHelper", e);
        if (r211 == null) goto L59;
        ALogger.e("LiveSeiHelper", "createSei crashed with ".concat(r211));
        goto L59
    }

    public final void e(String r110, ye1.a r111) {
        LiveSeiUtil.f71508i.getClass();
        if (LiveSeiUtil.b(r110) == false) goto L79;
        long r100 = b60.f119845a.getValue().getSeiConsumeDebounceTime();
        if (r100 > 0) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == false) goto L80;
        JSONObject r102 = LiveSeiUtil.c(r110);     // Catch: JSONException -> L75
        if (r102.has("info") == false) goto L21;
        if (r102.has("source") == false) goto L21;
        if (TextUtils.equals(r102.optString("source"), "zego") == false) goto L21;
        r102 = (JSONObject) r102.get("info");     // Catch: JSONException -> L75
    L21:
        if (r102.has("audio_subtitle") == false) goto L26;
        md0.a.c r103 = this.f71519e;     // Catch: JSONException -> L75
        if (r103 == null) goto L26;
        r103.onAudioSubtitleUpdate(r110);     // Catch: JSONException -> L75
    L26:
        if (r102.has("audio_live_text_data") == false) goto L31;
        md0.a.c r104 = this.f71519e;     // Catch: JSONException -> L75
        if (r104 == null) goto L31;
        r104.onRadioTextSeiUpdate(r102);     // Catch: JSONException -> L75
    L31:
        if (r102.has("radio_sei") == false) goto L35;
        md0.a.c r105 = this.f71519e;     // Catch: JSONException -> L75
        if (r105 == null) goto L35;
        r105.onRadioSeiUpdate(r102);     // Catch: JSONException -> L75
    L35:
        b(r110, r102, r111);     // Catch: JSONException -> L75
        if (r102.has("app_data") == false) goto L61;
        JSONObject r106 = new JSONObject(JSONObjectProtectorUtils.getString(r102, "app_data").replaceAll("\\\\", ""));     // Catch: JSONException -> L75
        md0.a.InterfaceC6802a r112 = this.f71517c;     // Catch: JSONException -> L75
        if (r112 == null) goto L40;
        r112.onBusinessAppSeiUpdate(r106);     // Catch: JSONException -> L75
    L40:
        long r107 = r106.optLong("timestamp");     // Catch: JSONException -> L75
        long r108 = this.f71515a;     // Catch: JSONException -> L75
        if (r107 > r108) goto L52;
        if (r107 == r108) goto L44;
        return;
    L44:
        if (c(r102) == true) goto L46;
        return;
    L46:
        if (y4.f65463a.getValue().booleanValue() == true) goto L48;
        return;
    L48:
        if (c(r102) == false) goto L81;
        this.f71518d.onKtvSeiUpdate(r110);     // Catch: JSONException -> L75
        return;
    L81:
        return;
    L52:
        if (r106.has("ver") == true) goto L54;
        return;
    L54:
        int r113 = r106.optInt("ver");     // Catch: JSONException -> L75
        int r109 = r106.optInt("ui_layout", 0);     // Catch: JSONException -> L75
        if (r106.has("style") == false) goto L58;
        r106.optInt("style");     // Catch: JSONException -> L75
    L58:
        if (this.f71517c.isVersionSupported(r113, r109) == false) goto L83;
        this.f71515a = r107;     // Catch: JSONException -> L75
        this.f71517c.onSeiUpdated(a(r106, r110));     // Catch: JSONException -> L75
        return;
    L83:
        return;
    L61:
        if (TextUtils.equals(r102.optString("source"), "TTLiveSDK_Android") == true) goto L69;
        if (TextUtils.equals(r102.optString("source"), "TTLiveSDK_IOS") == true) goto L69;
        if (LiveSeiUtil.d(r102.optString("source")) == true) goto L69;
        if (TextUtils.equals(r102.optString("source"), "TTLiveSDK_Windows") == true) goto L69;
        return;
    L69:
        if (r102.has("stream_type") == true) goto L71;
    L73:
        this.f71517c.isVersionSupported(0, 0);     // Catch: JSONException -> L75
        return;
    L71:
        if (JSONObjectProtectorUtils.getInt(r102, "stream_type") != 1) goto L73;
        this.f71517c.isVersionSupported(-1, 0);     // Catch: JSONException -> L75
        return;
    L87:
        return;
    L80:
        return;
    L7:
        if ((System.currentTimeMillis() - this.f71516b) >= r100) goto L9;
        r101 = false;
        goto L11
    L9:
        this.f71516b = System.currentTimeMillis();
        goto L10
    }

    public j(md0.a.InterfaceC6802a r100, md0.a.b r101, md0.a.c r102) {
        this(r100);
        this.f71518d = r101;
        this.f71519e = r102;
    }

    public final void b(String r100, JSONObject r101, ye1.a r102) throws JSONException {
        if (r102 == null) goto L8;
        if (r102.f567358a == false) goto L8;
        if (MultiLinkBizBackupSeiExperimentUtils.INSTANCE.isKtvAllInEnable(r102.f567364g, false) == true) goto L8;
        return;
    L8:
        if (r101.has("music_recognition_result") == false) goto L13;
        md0.a.c r103 = this.f71519e;
        if (r103 == null) goto L13;
        r103.onSpeechRecognitionSeiUpdate(r100);
    L13:
        if (r101.has("audio_mv_sei") == false) goto L18;
        md0.a.c r104 = this.f71519e;
        if (r104 == null) goto L18;
        r104.onAudioMvControllerUpdate(r100);
    L18:
        if (r101.has("music_beat_result") == false) goto L23;
        md0.a.c r105 = this.f71519e;
        if (r105 == null) goto L23;
        r105.onSpeechRhythm(r100);
    L23:
        if (r101.has("interact_video_sei") == false) goto L28;
        if (this.f71519e == null) goto L28;
        LiveSeiUtil.f71508i.getClass();
        ld0.a r106 = ld0.a.a(r100, "interact_video_sei", LiveSeiUtil.c(r100));
        this.f71519e.onVideoStateSeiUpdate(r106);
    L28:
        if (r101.has("interact_full_video_sei") == false) goto L33;
        if (this.f71519e == null) goto L33;
        LiveSeiUtil.f71508i.getClass();
        ld0.a r107 = ld0.a.a(r100, "interact_full_video_sei", LiveSeiUtil.c(r100));
        this.f71519e.onVideoStateSeiUpdate(r107);
    L33:
        if (c(r101) == false) goto L37;
        this.f71518d.onKtvSeiUpdate(r100);
        return;
    }
}
