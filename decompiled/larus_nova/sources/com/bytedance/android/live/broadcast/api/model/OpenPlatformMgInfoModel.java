package com.bytedance.android.live.broadcast.api.model;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010(\u001a\u00020\u0004H\u0016R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014R \u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR \u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR \u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR \u0010\"\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR \u0010%\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\b¨\u0006)"}, d2 = {"Lcom/bytedance/android/live/broadcast/api/model/OpenPlatformMgInfoModel;", "Ljava/io/Serializable;", "()V", "appIcon", "", "getAppIcon", "()Ljava/lang/String;", "setAppIcon", "(Ljava/lang/String;)V", "appId", "getAppId", "setAppId", "appName", "getAppName", "setAppName", "bidType", "", "getBidType", "()Ljava/lang/Integer;", "setBidType", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "entranceFrom", "getEntranceFrom", "setEntranceFrom", "gameSummary", "getGameSummary", "setGameSummary", "gameType", "getGameType", "setGameType", "panelFrom", "getPanelFrom", "setPanelFrom", DBDefinition.TASK_ID, "getTaskId", "setTaskId", "taskSource", "getTaskSource", "setTaskSource", "toString", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenPlatformMgInfoModel implements Serializable {

    @SerializedName("icon_url")
    @Expose
    private String appIcon;

    @SerializedName(BdpAppEventConstant.PARAMS_MP_ID)
    @Expose
    private String appId;

    @SerializedName(BdpAppEventConstant.PARAMS_MP_NAME)
    @Expose
    private String appName;

    @SerializedName("bid_type")
    @Expose
    private Integer bidType;

    @SerializedName("entrance_from")
    @Expose
    private Integer entranceFrom;

    @SerializedName("game_summary")
    @Expose
    private String gameSummary;

    @SerializedName(BdpAppEventConstant.PARAMS_GAME_TYPE)
    @Expose
    private String gameType;

    @SerializedName("panel_from")
    @Expose
    private String panelFrom;

    @SerializedName("task_id")
    @Expose
    private String taskId;

    @SerializedName("task_source")
    @Expose
    private String taskSource;

    public String toString() {
        return "OpenPlatformMgInfoModel(appId=" + this.appId + ", appName=" + this.appName + ", appIcon=" + this.appIcon + ", gameSummary=" + this.gameSummary + ", gameType=" + this.gameType + ", taskId=" + this.taskId + ", taskSource=" + this.taskSource + ", entranceFrom=" + this.entranceFrom + ", panelFrom=" + this.panelFrom + ", bidType=" + this.bidType + ')';
    }

    public OpenPlatformMgInfoModel() {
        this.appId = "";
        this.appName = "";
        this.appIcon = "";
        this.gameSummary = "";
        this.gameType = "";
        this.taskId = "";
        this.taskSource = "pop";
    }

    public final String getAppIcon() {
        return this.appIcon;
    }

    public final String getAppId() {
        return this.appId;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final Integer getBidType() {
        return this.bidType;
    }

    public final Integer getEntranceFrom() {
        return this.entranceFrom;
    }

    public final String getGameSummary() {
        return this.gameSummary;
    }

    public final String getGameType() {
        return this.gameType;
    }

    public final String getPanelFrom() {
        return this.panelFrom;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    public final String getTaskSource() {
        return this.taskSource;
    }

    public final void setAppIcon(String r100) {
        this.appIcon = r100;
    }

    public final void setAppId(String r100) {
        this.appId = r100;
    }

    public final void setAppName(String r100) {
        this.appName = r100;
    }

    public final void setBidType(Integer r100) {
        this.bidType = r100;
    }

    public final void setEntranceFrom(Integer r100) {
        this.entranceFrom = r100;
    }

    public final void setGameSummary(String r100) {
        this.gameSummary = r100;
    }

    public final void setGameType(String r100) {
        this.gameType = r100;
    }

    public final void setPanelFrom(String r100) {
        this.panelFrom = r100;
    }

    public final void setTaskId(String r100) {
        this.taskId = r100;
    }

    public final void setTaskSource(String r100) {
        this.taskSource = r100;
    }
}
