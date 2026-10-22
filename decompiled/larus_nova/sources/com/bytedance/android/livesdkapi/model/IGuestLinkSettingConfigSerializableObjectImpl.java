package com.bytedance.android.livesdkapi.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b&\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0018\u0018\u00002\u00020\u0001:\u0001^B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR \u0010\f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R \u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\u001e\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\bR \u0010'\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0006\"\u0004\b)\u0010\bR \u0010*\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010\bR \u0010-\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0006\"\u0004\b/\u0010\bR \u00100\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0006\"\u0004\b2\u0010\bR \u00103\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR \u00106\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001e\u00109\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0015\"\u0004\b;\u0010\u0017R \u0010<\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR \u0010?\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR \u0010B\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR,\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020G\u0018\u00010F8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR \u0010L\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR \u0010O\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010\bR \u0010R\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0006\"\u0004\bT\u0010\bR \u0010U\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0006\"\u0004\bW\u0010\bR \u0010X\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0006\"\u0004\bZ\u0010\bR \u0010[\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0006\"\u0004\b]\u0010\b¨\u0006_"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/IGuestLinkSettingConfigSerializableObjectImpl;", "Lcom/bytedance/android/livesdkapi/model/IGuestLinkSettingConfig;", "()V", "anchorFinishChannelDoubleCheckMsg", "", "getAnchorFinishChannelDoubleCheckMsg", "()Ljava/lang/String;", "setAnchorFinishChannelDoubleCheckMsg", "(Ljava/lang/String;)V", "anchorFinishChannelDoubleCheckTitle", "getAnchorFinishChannelDoubleCheckTitle", "setAnchorFinishChannelDoubleCheckTitle", "bystanderListSchema", "getBystanderListSchema", "setBystanderListSchema", "bystanderListUrl", "getBystanderListUrl", "setBystanderListUrl", "disableVideo", "", "getDisableVideo", "()Z", "setDisableVideo", "(Z)V", "enabled", "getEnabled", "setEnabled", "enterRoomToast", "getEnterRoomToast", "setEnterRoomToast", "finishChannelDelayInMillis", "", "getFinishChannelDelayInMillis", "()J", "setFinishChannelDelayInMillis", "(J)V", "guidePanelSchema", "getGuidePanelSchema", "setGuidePanelSchema", "guidePanelUrl", "getGuidePanelUrl", "setGuidePanelUrl", "linkerFinishChannelDoubleCheckMsg", "getLinkerFinishChannelDoubleCheckMsg", "setLinkerFinishChannelDoubleCheckMsg", "linkerFinishChannelDoubleCheckTitle", "getLinkerFinishChannelDoubleCheckTitle", "setLinkerFinishChannelDoubleCheckTitle", "linkerPageLeftBtnText", "getLinkerPageLeftBtnText", "setLinkerPageLeftBtnText", "linkerPageRightBtnText", "getLinkerPageRightBtnText", "setLinkerPageRightBtnText", "linkerPageTitle", "getLinkerPageTitle", "setLinkerPageTitle", "needToastAfterEnterRoom", "getNeedToastAfterEnterRoom", "setNeedToastAfterEnterRoom", "reapplyDoubleCheckCancelButtonText", "getReapplyDoubleCheckCancelButtonText", "setReapplyDoubleCheckCancelButtonText", "reapplyDoubleCheckConfirmButtonText", "getReapplyDoubleCheckConfirmButtonText", "setReapplyDoubleCheckConfirmButtonText", "reapplyDoubleCheckTitle", "getReapplyDoubleCheckTitle", "setReapplyDoubleCheckTitle", "seatRatioConfig", "", "", "getSeatRatioConfig", "()Ljava/util/Map;", "setSeatRatioConfig", "(Ljava/util/Map;)V", "settingTitle", "getSettingTitle", "setSettingTitle", "startPanelSchema", "getStartPanelSchema", "setStartPanelSchema", "startPanelUrl", "getStartPanelUrl", "setStartPanelUrl", "watcherPageLeftBtnText", "getWatcherPageLeftBtnText", "setWatcherPageLeftBtnText", "watcherPageRightBtnText", "getWatcherPageRightBtnText", "setWatcherPageRightBtnText", "watcherPageTitle", "getWatcherPageTitle", "setWatcherPageTitle", "Adapter", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGuestLinkSettingConfigSerializableObjectImpl implements IGuestLinkSettingConfig {

    @SerializedName("anchor_finish_channel_double_check_msg")
    private String anchorFinishChannelDoubleCheckMsg;

    @SerializedName("anchor_finish_channel_double_check_title")
    private String anchorFinishChannelDoubleCheckTitle;

    @SerializedName("bystander_list_scheme")
    private String bystanderListSchema;

    @SerializedName("bystander_list_url")
    private String bystanderListUrl;

    @SerializedName("disable_video")
    private boolean disableVideo;

    @SerializedName("enabled")
    private boolean enabled;

    @SerializedName("enter_room_toast")
    private String enterRoomToast;

    @SerializedName("finish_channel_delay")
    private long finishChannelDelayInMillis;

    @SerializedName("guide_panel_schema")
    private String guidePanelSchema;

    @SerializedName("guide_panel_url")
    private String guidePanelUrl;

    @SerializedName("linker_finish_channel_double_check_msg")
    private String linkerFinishChannelDoubleCheckMsg;

    @SerializedName("linker_finish_channel_double_check_title")
    private String linkerFinishChannelDoubleCheckTitle;

    @SerializedName("linker_page_left_btn_text")
    private String linkerPageLeftBtnText;

    @SerializedName("linker_page_right_btn_text")
    private String linkerPageRightBtnText;

    @SerializedName("linker_page_title")
    private String linkerPageTitle;

    @SerializedName("need_toast_after_enter_room")
    private boolean needToastAfterEnterRoom;

    @SerializedName("reapply_double_check_cancel_button_text")
    private String reapplyDoubleCheckCancelButtonText;

    @SerializedName("reapply_double_check_confirm_button_text")
    private String reapplyDoubleCheckConfirmButtonText;

    @SerializedName("reapply_double_check_title")
    private String reapplyDoubleCheckTitle;

    @SerializedName("seat_ratio_config")
    private Map<String, Integer> seatRatioConfig;

    @SerializedName("settting_title")
    private String settingTitle;

    @SerializedName("start_panel_schema")
    private String startPanelSchema;

    @SerializedName("start_panel_url")
    private String startPanelUrl;

    @SerializedName("watcher_page_left_btn_text")
    private String watcherPageLeftBtnText;

    @SerializedName("watcher_page_right_btn_text")
    private String watcherPageRightBtnText;

    @SerializedName("watcher_page_title")
    private String watcherPageTitle;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/IGuestLinkSettingConfigSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(IGuestLinkSettingConfigSerializableObjectImpl.class);
        }
    }

    public IGuestLinkSettingConfigSerializableObjectImpl() {
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getAnchorFinishChannelDoubleCheckMsg() {
        return this.anchorFinishChannelDoubleCheckMsg;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getAnchorFinishChannelDoubleCheckTitle() {
        return this.anchorFinishChannelDoubleCheckTitle;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getBystanderListSchema() {
        return this.bystanderListSchema;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getBystanderListUrl() {
        return this.bystanderListUrl;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final boolean getDisableVideo() {
        return this.disableVideo;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final boolean getEnabled() {
        return this.enabled;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getEnterRoomToast() {
        return this.enterRoomToast;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final long getFinishChannelDelayInMillis() {
        return this.finishChannelDelayInMillis;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getGuidePanelSchema() {
        return this.guidePanelSchema;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getGuidePanelUrl() {
        return this.guidePanelUrl;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getLinkerFinishChannelDoubleCheckMsg() {
        return this.linkerFinishChannelDoubleCheckMsg;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getLinkerFinishChannelDoubleCheckTitle() {
        return this.linkerFinishChannelDoubleCheckTitle;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getLinkerPageLeftBtnText() {
        return this.linkerPageLeftBtnText;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getLinkerPageRightBtnText() {
        return this.linkerPageRightBtnText;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getLinkerPageTitle() {
        return this.linkerPageTitle;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final boolean getNeedToastAfterEnterRoom() {
        return this.needToastAfterEnterRoom;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getReapplyDoubleCheckCancelButtonText() {
        return this.reapplyDoubleCheckCancelButtonText;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getReapplyDoubleCheckConfirmButtonText() {
        return this.reapplyDoubleCheckConfirmButtonText;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getReapplyDoubleCheckTitle() {
        return this.reapplyDoubleCheckTitle;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final Map<String, Integer> getSeatRatioConfig() {
        return this.seatRatioConfig;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getSettingTitle() {
        return this.settingTitle;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getStartPanelSchema() {
        return this.startPanelSchema;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getStartPanelUrl() {
        return this.startPanelUrl;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getWatcherPageLeftBtnText() {
        return this.watcherPageLeftBtnText;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getWatcherPageRightBtnText() {
        return this.watcherPageRightBtnText;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final String getWatcherPageTitle() {
        return this.watcherPageTitle;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setAnchorFinishChannelDoubleCheckMsg(String r100) {
        this.anchorFinishChannelDoubleCheckMsg = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setAnchorFinishChannelDoubleCheckTitle(String r100) {
        this.anchorFinishChannelDoubleCheckTitle = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setBystanderListSchema(String r100) {
        this.bystanderListSchema = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setBystanderListUrl(String r100) {
        this.bystanderListUrl = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setDisableVideo(boolean r100) {
        this.disableVideo = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setEnabled(boolean r100) {
        this.enabled = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setEnterRoomToast(String r100) {
        this.enterRoomToast = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setFinishChannelDelayInMillis(long r100) {
        this.finishChannelDelayInMillis = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setGuidePanelSchema(String r100) {
        this.guidePanelSchema = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setGuidePanelUrl(String r100) {
        this.guidePanelUrl = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setLinkerFinishChannelDoubleCheckMsg(String r100) {
        this.linkerFinishChannelDoubleCheckMsg = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setLinkerFinishChannelDoubleCheckTitle(String r100) {
        this.linkerFinishChannelDoubleCheckTitle = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setLinkerPageLeftBtnText(String r100) {
        this.linkerPageLeftBtnText = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setLinkerPageRightBtnText(String r100) {
        this.linkerPageRightBtnText = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setLinkerPageTitle(String r100) {
        this.linkerPageTitle = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setNeedToastAfterEnterRoom(boolean r100) {
        this.needToastAfterEnterRoom = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setReapplyDoubleCheckCancelButtonText(String r100) {
        this.reapplyDoubleCheckCancelButtonText = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setReapplyDoubleCheckConfirmButtonText(String r100) {
        this.reapplyDoubleCheckConfirmButtonText = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setReapplyDoubleCheckTitle(String r100) {
        this.reapplyDoubleCheckTitle = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setSeatRatioConfig(Map<String, Integer> r100) {
        this.seatRatioConfig = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setSettingTitle(String r100) {
        this.settingTitle = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setStartPanelSchema(String r100) {
        this.startPanelSchema = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setStartPanelUrl(String r100) {
        this.startPanelUrl = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setWatcherPageLeftBtnText(String r100) {
        this.watcherPageLeftBtnText = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setWatcherPageRightBtnText(String r100) {
        this.watcherPageRightBtnText = r100;
    }

    @Override // com.bytedance.android.livesdkapi.model.IGuestLinkSettingConfig
    public final void setWatcherPageTitle(String r100) {
        this.watcherPageTitle = r100;
    }
}
