package com.bytedance.android.livesdkapi.model;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
public class SeiAppData {

    @SerializedName("anchor_interact_info")
    private AnchorInteractInfo anchorInteractInfo;

    @SerializedName("canvas")
    private SeiCanvas canvas;

    @SerializedName("channel_id")
    private String channelId;

    @SerializedName("count")
    private long count;

    @SerializedName("event_params")
    private JSONObject eventParams;

    @SerializedName("game_full")
    private int gameFull;

    @SerializedName("game_full_v2")
    private int gameFullV2;

    @SerializedName("mix_stream_type")
    private int gameMixStreamType;

    @SerializedName(BdpAppEventConstant.PARAMS_GAME_TYPE)
    private int gameType;

    @SerializedName("grids")
    private List<SeiRegion> grids;

    @SerializedName("hide_audio_bg")
    private int hideAudioBg;

    @SerializedName("hide_micseat")
    private int hideMicseat;

    @SerializedName("layout_key")
    private String layoutKey;

    @SerializedName("play_mode_list")
    private String playMode;

    @SerializedName("position_stash_status")
    private int positionStashStatus;

    @SerializedName("show_player")
    private String showPlayer;

    @SerializedName("stream_size")
    private StreamSize streamSize;

    @SerializedName("style")
    private int style;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_SCENE)
    private int subScene;

    @SerializedName("sub_ui_layout")
    private int subUILayout;

    @SerializedName("timestamp")
    private long timestamp;

    @SerializedName("ui_feature_list")
    private JSONArray uiFeatureList;

    @SerializedName("ui_layout")
    private int uiLayout;

    /* JADX INFO: renamed from: vendor, reason: collision with root package name */
    @SerializedName(Constants.OperatorKey.KEY_VENDOR)
    private String f162641vendor;

    @SerializedName("ver")
    private int version;

    public SeiAppData() {
    }

    public SeiCanvas getCanvas() {
        SeiCanvas r100 = this.canvas;
        if (r100 == null) goto L5;
        return r100;
    L5:
        return new SeiCanvas();
    }

    public AnchorInteractInfo getAnchorInteractInfo() {
        return this.anchorInteractInfo;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public long getCount() {
        return this.count;
    }

    public JSONObject getEventParams() {
        return this.eventParams;
    }

    public int getGameFull() {
        return this.gameFull;
    }

    public int getGameFullV2() {
        return this.gameFullV2;
    }

    public int getGameMixStreamType() {
        return this.gameMixStreamType;
    }

    public int getGameType() {
        return this.gameType;
    }

    public List<SeiRegion> getGrids() {
        return this.grids;
    }

    public int getHideAudioBg() {
        return this.hideAudioBg;
    }

    public String getLayoutKey() {
        return this.layoutKey;
    }

    public int getPositionStashStatus() {
        return this.positionStashStatus;
    }

    public String getShowPlayer() {
        return this.showPlayer;
    }

    public StreamSize getStreamSize() {
        return this.streamSize;
    }

    public int getStyle() {
        return this.style;
    }

    public int getSubScene() {
        return this.subScene;
    }

    public int getSubUILayout() {
        return this.subUILayout;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public JSONArray getUiFeatureList() {
        return this.uiFeatureList;
    }

    public int getUiLayout() {
        return this.uiLayout;
    }

    public String getVendor() {
        return this.f162641vendor;
    }

    public int getVersion() {
        return this.version;
    }

    public void setAnchorInteractInfo(AnchorInteractInfo r100) {
        this.anchorInteractInfo = r100;
    }

    public void setCanvas(SeiCanvas r100) {
        this.canvas = r100;
    }

    public void setChannelId(String r100) {
        this.channelId = r100;
    }

    @SerializedName("count")
    public void setCount(long r100) {
        this.count = r100;
    }

    public void setEventParams(JSONObject r100) {
        this.eventParams = r100;
    }

    public void setGameFull(int r100) {
        this.gameFull = r100;
    }

    public void setGameFullV2(int r100) {
        this.gameFullV2 = r100;
    }

    public void setGameMixStreamType(int r100) {
        this.gameMixStreamType = r100;
    }

    public void setGameType(int r100) {
        this.gameType = r100;
    }

    @SerializedName("grids")
    public void setGrids(List<SeiRegion> r100) {
        this.grids = r100;
    }

    public void setHideAudioBg(int r100) {
        this.hideAudioBg = r100;
    }

    public void setHideMicseat(int r100) {
        this.hideMicseat = r100;
    }

    public void setLayoutKey(String r100) {
        this.layoutKey = r100;
    }

    public void setPlayMode(String r100) {
        this.playMode = r100;
    }

    public void setPositionStashStatus(int r100) {
        this.positionStashStatus = r100;
    }

    public void setShowPlayer(String r100) {
        this.showPlayer = r100;
    }

    public void setStreamSize(StreamSize r100) {
        this.streamSize = r100;
    }

    public void setStyle(int r100) {
        this.style = r100;
    }

    public void setSubScene(int r100) {
        this.subScene = r100;
    }

    public void setSubUILayout(int r100) {
        this.subUILayout = r100;
    }

    @SerializedName("timestamp")
    public void setTimestamp(long r100) {
        this.timestamp = r100;
    }

    public void setUiFeatureList(JSONArray r100) {
        this.uiFeatureList = r100;
    }

    @SerializedName("ui_layout")
    public void setUiLayout(int r100) {
        this.uiLayout = r100;
    }

    @SerializedName(Constants.OperatorKey.KEY_VENDOR)
    public void setVendor(String r100) {
        this.f162641vendor = r100;
    }

    @SerializedName("ver")
    public void setVersion(int r100) {
        this.version = r100;
    }
}
