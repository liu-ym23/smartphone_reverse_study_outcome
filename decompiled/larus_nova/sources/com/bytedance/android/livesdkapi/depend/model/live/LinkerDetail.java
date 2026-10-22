package com.bytedance.android.livesdkapi.depend.model.live;

import com.bytedance.android.livesdk.link.model.z5;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class LinkerDetail extends FlexModelBase<z5> implements z5 {

    @SerializedName("accept_audience_pre_apply")
    public boolean anchorAcceptAudiencePreApply;

    @SerializedName("manual_open_ui")
    public int anchorManualOpenUiLayout;

    @SerializedName("client_ui_info")
    public String clientUiInfo;

    @SerializedName("enlarge_guest_turn_on_source")
    public long enlargeGuestTurnOnSource;

    @SerializedName("feature_list")
    public List<Long> featureList;

    @SerializedName("forbid_apply_from_other")
    public boolean forbidApplyFromOther;

    @SerializedName("function_type")
    public String functionType2;

    @SerializedName("init_source")
    public String initSource;

    @SerializedName("enable_audience_linkmic")
    public int integrationAnchorEnableAudienceLinkmic;
    public boolean isFlexibleTeamFight;
    public boolean isTeamFightShowing;

    @SerializedName("ktv_exhibit_mode")
    public int ktvExhibitMode;

    @SerializedName("ktv_lyric_mode")
    public String ktvLyricMode;

    @SerializedName("big_party_layout_config_version")
    public int layoutConfigVersion;

    @SerializedName("playmode_detail")
    public Map<String, String> playModeDetail;

    @SerializedName("linker_play_modes")
    public List<Long> playModes;

    @SerializedName("linker_ui_layout")
    public int uiLayout;

    @Override // com.bytedance.android.livesdk.link.model.z5
    public void setIntegrationAnchorEnableAudienceLinkmic(int r100) {
    }

    public LinkerDetail() {
        super(z5.class);
    }

    public String toString() {
        return "LinkerDetail{uiLayout=" + this.uiLayout + ", playModes=" + this.playModes + ", function_type =" + this.functionType2 + ", init_source =" + this.initSource + '}';
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public boolean getAnchorAcceptAudiencePreApply() {
        return this.anchorAcceptAudiencePreApply;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public int getAnchorManualUiLayout() {
        return this.anchorManualOpenUiLayout;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public String getClientUiInfo() {
        return this.clientUiInfo;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public long getEnlargeGuestTurnOnSource() {
        return this.enlargeGuestTurnOnSource;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public List<Long> getFeatureList() {
        return this.featureList;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public boolean getForbidApplyFromOther() {
        return this.forbidApplyFromOther;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public String getFunctionType2() {
        return this.functionType2;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public String getInitSource() {
        return this.initSource;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public int getIntegrationAnchorEnableAudienceLinkmic() {
        return this.integrationAnchorEnableAudienceLinkmic;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public int getKtvExhibitMode() {
        return this.ktvExhibitMode;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public String getKtvLyricMode() {
        return this.ktvLyricMode;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public int getLayoutConfigVersion() {
        return this.layoutConfigVersion;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public Map<String, String> getPlayModeDetail() {
        return this.playModeDetail;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public List<Long> getPlayModes() {
        return this.playModes;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public int getUiLayout() {
        return this.uiLayout;
    }

    public boolean isAnchorAcceptAudiencePreApply() {
        return this.anchorAcceptAudiencePreApply;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public boolean isFlexibleTeamFight() {
        return this.isFlexibleTeamFight;
    }

    public boolean isForbidApplyFromOther() {
        return this.forbidApplyFromOther;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public boolean isTeamFightShowing() {
        return this.isTeamFightShowing;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public void setAnchorAcceptAudiencePreApply(boolean r100) {
        this.anchorAcceptAudiencePreApply = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public void setAnchorManualUiLayout(int r100) {
        this.anchorManualOpenUiLayout = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public void setClientUiInfo(String r100) {
        this.clientUiInfo = r100;
    }

    public void setEnlargeGuestTurnOnSource(long r100) {
        this.enlargeGuestTurnOnSource = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public void setFlexibleTeamFight(boolean r100) {
        this.isFlexibleTeamFight = r100;
    }

    public void setForbidApplyFromOther(boolean r100) {
        this.forbidApplyFromOther = r100;
    }

    public void setFunctionType2(String r100) {
        this.functionType2 = r100;
    }

    public void setInitSource(String r100) {
        this.initSource = r100;
    }

    public void setKtvExhibitMode(int r100) {
        this.ktvExhibitMode = r100;
    }

    public void setKtvLyricMode(String r100) {
        this.ktvLyricMode = r100;
    }

    public void setLayoutConfigVersion(int r100) {
        this.layoutConfigVersion = r100;
    }

    public void setPlayModeDetail(Map<String, String> r100) {
        this.playModeDetail = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public void setPlayModes(List<Long> r100) {
        this.playModes = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public void setTeamFightShowing(boolean r100) {
        this.isTeamFightShowing = r100;
    }

    @Override // com.bytedance.android.livesdk.link.model.z5
    public void setUiLayout(int r100) {
        this.uiLayout = r100;
    }
}
