package com.bytedance.android.livesdkapi.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010 \n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u001e\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001e\u0010\u0017\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000f\"\u0004\b\u0019\u0010\u0011R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u001e\u0010#\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001e\u0010)\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001e\u0010,\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0006\"\u0004\b.\u0010\bR\u001e\u0010/\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\bR\u001e\u00102\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0006\"\u0004\b4\u0010\bR\u001e\u00105\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u001d\"\u0004\b7\u0010\u001fR\u001e\u00108\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0006\"\u0004\b:\u0010\bR$\u0010;\u001a\b\u0012\u0004\u0012\u00020$0<8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u0016\u0010A\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0006R\u001e\u0010C\u001a\u00020$8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010&\"\u0004\bE\u0010(R\u001e\u0010F\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u000f\"\u0004\bH\u0010\u0011R\u001e\u0010I\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0006\"\u0004\bK\u0010\bR\u001e\u0010L\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0006\"\u0004\bN\u0010\bR\u001e\u0010O\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u000f\"\u0004\bQ\u0010\u0011R\u0016\u0010R\u001a\u00020\u00048\u0006X\u0087D¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0006R\u001e\u0010T\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0006\"\u0004\bV\u0010\b¨\u0006W"}, d2 = {"Lcom/bytedance/android/livesdkapi/model/LiveAudioSubtitleSetting;", "", "()V", "anchorEnable", "", "getAnchorEnable", "()Z", "setAnchorEnable", "(Z)V", "audioSubtitleGuestEnable", "getAudioSubtitleGuestEnable", "setAudioSubtitleGuestEnable", "audioSubtitleSwitchName", "", "getAudioSubtitleSwitchName", "()Ljava/lang/String;", "setAudioSubtitleSwitchName", "(Ljava/lang/String;)V", "classicTeamFightSubtitleBugfix", "getClassicTeamFightSubtitleBugfix", "dismissKtvComponentLyricsAndMidiOnStageSubtitle", "getDismissKtvComponentLyricsAndMidiOnStageSubtitle", "setDismissKtvComponentLyricsAndMidiOnStageSubtitle", "enlargeStageGuideDialogSchema", "getEnlargeStageGuideDialogSchema", "setEnlargeStageGuideDialogSchema", "enterRoomDelayAdjustPublicScreenTime", "", "getEnterRoomDelayAdjustPublicScreenTime", "()J", "setEnterRoomDelayAdjustPublicScreenTime", "(J)V", "exclusionUpdateAreaHeight", "getExclusionUpdateAreaHeight", "setExclusionUpdateAreaHeight", "guestCanAdjustPublicScreen", "", "getGuestCanAdjustPublicScreen", "()I", "setGuestCanAdjustPublicScreen", "(I)V", "guestCanCloseSubtitle", "getGuestCanCloseSubtitle", "setGuestCanCloseSubtitle", "guestSubtitleFromRtc", "getGuestSubtitleFromRtc", "setGuestSubtitleFromRtc", "radioAnchorEnable", "getRadioAnchorEnable", "setRadioAnchorEnable", "radioEnable", "getRadioEnable", "setRadioEnable", "sameSubtitleContentUpdateFrequencyControlTime", "getSameSubtitleContentUpdateFrequencyControlTime", "setSameSubtitleContentUpdateFrequencyControlTime", "sameSubtitleContentUpdateFrequencyOpt", "getSameSubtitleContentUpdateFrequencyOpt", "setSameSubtitleContentUpdateFrequencyOpt", "stageEnlargeSeatPositionList", "", "getStageEnlargeSeatPositionList", "()Ljava/util/List;", "setStageEnlargeSeatPositionList", "(Ljava/util/List;)V", "stageIsInsertStatusBugfix", "getStageIsInsertStatusBugfix", "subtitleAnimDuration", "getSubtitleAnimDuration", "setSubtitleAnimDuration", "subtitleEffectId", "getSubtitleEffectId", "setSubtitleEffectId", "subtitleEnableEffect", "getSubtitleEnableEffect", "setSubtitleEnableEffect", "subtitlePatchLynxEnable", "getSubtitlePatchLynxEnable", "setSubtitlePatchLynxEnable", "subtitlePatchUrl", "getSubtitlePatchUrl", "setSubtitlePatchUrl", "subtitleSinkListOpt", "getSubtitleSinkListOpt", "subtitleUseDefaultStyleAndPosition", "getSubtitleUseDefaultStyleAndPosition", "setSubtitleUseDefaultStyleAndPosition", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class LiveAudioSubtitleSetting {

    @SerializedName("anchor_enable")
    private boolean anchorEnable;

    @SerializedName("audio_subtitle_guest_enable")
    private boolean audioSubtitleGuestEnable;

    @SerializedName("audio_subtitle_switch_name")
    private String audioSubtitleSwitchName;

    @SerializedName("classic_team_fight_subtitle_bugfix")
    private final boolean classicTeamFightSubtitleBugfix;

    @SerializedName("dismiss_ktv_component_lyrics_and_midi_on_stage_subtitle")
    private boolean dismissKtvComponentLyricsAndMidiOnStageSubtitle;

    @SerializedName("enlarge_stage_guide_dialog_schema")
    private String enlargeStageGuideDialogSchema;

    @SerializedName("enter_room_delay_adjust_public_screen_time")
    private long enterRoomDelayAdjustPublicScreenTime;

    @SerializedName("exclusion_update_area_height")
    private boolean exclusionUpdateAreaHeight;

    @SerializedName("guest_can_adjust_public_screen")
    private int guestCanAdjustPublicScreen;

    @SerializedName("guest_can_close_subtitle")
    private int guestCanCloseSubtitle;

    @SerializedName("guest_subtitle_from_rtc")
    private boolean guestSubtitleFromRtc;

    @SerializedName("radio_anchor_enable")
    private boolean radioAnchorEnable;

    @SerializedName("radio_enable")
    private boolean radioEnable;

    @SerializedName("same_subtitle_content_update_frequency_control_time")
    private long sameSubtitleContentUpdateFrequencyControlTime;

    @SerializedName("same_subtitle_content_update_frequency_opt")
    private boolean sameSubtitleContentUpdateFrequencyOpt;

    @SerializedName("stage_enlarge_seat_position_list")
    private List<Integer> stageEnlargeSeatPositionList;

    @SerializedName("stage_is_insert_status_bugfix")
    private final boolean stageIsInsertStatusBugfix;

    @SerializedName("subtitle_anim_duration")
    private int subtitleAnimDuration;

    @SerializedName("subtitle_effect_id")
    private String subtitleEffectId;

    @SerializedName("subtitle_enable_effect")
    private boolean subtitleEnableEffect;

    @SerializedName("subtitle_patch_lynx_enable")
    private boolean subtitlePatchLynxEnable;

    @SerializedName("subtitle_patch_url")
    private String subtitlePatchUrl;

    @SerializedName("subtitle_sink_list_opt")
    private final boolean subtitleSinkListOpt;

    @SerializedName("subtitle_use_default_style_and_position")
    private boolean subtitleUseDefaultStyleAndPosition;

    public LiveAudioSubtitleSetting() {
        this.subtitleAnimDuration = 200;
        this.audioSubtitleSwitchName = "AUDIO_CAPTION_SWITCH";
        this.exclusionUpdateAreaHeight = true;
        this.enterRoomDelayAdjustPublicScreenTime = 1000;
        this.sameSubtitleContentUpdateFrequencyOpt = true;
        this.sameSubtitleContentUpdateFrequencyControlTime = 100;
        this.subtitlePatchUrl = "https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/audiochat_stage_douyin/pages/subtitle_patch/template.js?business_group=-1";
        this.subtitleEffectId = "50819813";
        this.stageEnlargeSeatPositionList = CollectionsKt.listOf(new Integer[]{15, 247});
        this.dismissKtvComponentLyricsAndMidiOnStageSubtitle = true;
        this.enlargeStageGuideDialogSchema = "sslocal://webcast_lynxview?type=popup&rate_height=350&gravity=bottom&web_bg_color=%23ffffffff&radius=12&url=https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/audiochat_stage_douyin/pages/enlarge_stage_guide/template.js&enable_latch=1&business_type=livelinkmic&business_group=livelinkmic&initialProps=%5B%22current_user%22%2C%22current_room%22%2C%22linkmic%22%5D";
        this.radioEnable = true;
        this.radioAnchorEnable = true;
        this.classicTeamFightSubtitleBugfix = true;
        this.stageIsInsertStatusBugfix = true;
    }

    public final boolean getAnchorEnable() {
        return this.anchorEnable;
    }

    public final boolean getAudioSubtitleGuestEnable() {
        return this.audioSubtitleGuestEnable;
    }

    public final String getAudioSubtitleSwitchName() {
        return this.audioSubtitleSwitchName;
    }

    public final boolean getClassicTeamFightSubtitleBugfix() {
        return this.classicTeamFightSubtitleBugfix;
    }

    public final boolean getDismissKtvComponentLyricsAndMidiOnStageSubtitle() {
        return this.dismissKtvComponentLyricsAndMidiOnStageSubtitle;
    }

    public final String getEnlargeStageGuideDialogSchema() {
        return this.enlargeStageGuideDialogSchema;
    }

    public final long getEnterRoomDelayAdjustPublicScreenTime() {
        return this.enterRoomDelayAdjustPublicScreenTime;
    }

    public final boolean getExclusionUpdateAreaHeight() {
        return this.exclusionUpdateAreaHeight;
    }

    public final int getGuestCanAdjustPublicScreen() {
        return this.guestCanAdjustPublicScreen;
    }

    public final int getGuestCanCloseSubtitle() {
        return this.guestCanCloseSubtitle;
    }

    public final boolean getGuestSubtitleFromRtc() {
        return this.guestSubtitleFromRtc;
    }

    public final boolean getRadioAnchorEnable() {
        return this.radioAnchorEnable;
    }

    public final boolean getRadioEnable() {
        return this.radioEnable;
    }

    public final long getSameSubtitleContentUpdateFrequencyControlTime() {
        return this.sameSubtitleContentUpdateFrequencyControlTime;
    }

    public final boolean getSameSubtitleContentUpdateFrequencyOpt() {
        return this.sameSubtitleContentUpdateFrequencyOpt;
    }

    public final List<Integer> getStageEnlargeSeatPositionList() {
        return this.stageEnlargeSeatPositionList;
    }

    public final boolean getStageIsInsertStatusBugfix() {
        return this.stageIsInsertStatusBugfix;
    }

    public final int getSubtitleAnimDuration() {
        return this.subtitleAnimDuration;
    }

    public final String getSubtitleEffectId() {
        return this.subtitleEffectId;
    }

    public final boolean getSubtitleEnableEffect() {
        return this.subtitleEnableEffect;
    }

    public final boolean getSubtitlePatchLynxEnable() {
        return this.subtitlePatchLynxEnable;
    }

    public final String getSubtitlePatchUrl() {
        return this.subtitlePatchUrl;
    }

    public final boolean getSubtitleSinkListOpt() {
        return this.subtitleSinkListOpt;
    }

    public final boolean getSubtitleUseDefaultStyleAndPosition() {
        return this.subtitleUseDefaultStyleAndPosition;
    }

    public final void setAnchorEnable(boolean r100) {
        this.anchorEnable = r100;
    }

    public final void setAudioSubtitleGuestEnable(boolean r100) {
        this.audioSubtitleGuestEnable = r100;
    }

    public final void setAudioSubtitleSwitchName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.audioSubtitleSwitchName = r100;
    }

    public final void setDismissKtvComponentLyricsAndMidiOnStageSubtitle(boolean r100) {
        this.dismissKtvComponentLyricsAndMidiOnStageSubtitle = r100;
    }

    public final void setEnlargeStageGuideDialogSchema(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.enlargeStageGuideDialogSchema = r100;
    }

    public final void setEnterRoomDelayAdjustPublicScreenTime(long r100) {
        this.enterRoomDelayAdjustPublicScreenTime = r100;
    }

    public final void setExclusionUpdateAreaHeight(boolean r100) {
        this.exclusionUpdateAreaHeight = r100;
    }

    public final void setGuestCanAdjustPublicScreen(int r100) {
        this.guestCanAdjustPublicScreen = r100;
    }

    public final void setGuestCanCloseSubtitle(int r100) {
        this.guestCanCloseSubtitle = r100;
    }

    public final void setGuestSubtitleFromRtc(boolean r100) {
        this.guestSubtitleFromRtc = r100;
    }

    public final void setRadioAnchorEnable(boolean r100) {
        this.radioAnchorEnable = r100;
    }

    public final void setRadioEnable(boolean r100) {
        this.radioEnable = r100;
    }

    public final void setSameSubtitleContentUpdateFrequencyControlTime(long r100) {
        this.sameSubtitleContentUpdateFrequencyControlTime = r100;
    }

    public final void setSameSubtitleContentUpdateFrequencyOpt(boolean r100) {
        this.sameSubtitleContentUpdateFrequencyOpt = r100;
    }

    public final void setStageEnlargeSeatPositionList(List<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.stageEnlargeSeatPositionList = r100;
    }

    public final void setSubtitleAnimDuration(int r100) {
        this.subtitleAnimDuration = r100;
    }

    public final void setSubtitleEffectId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.subtitleEffectId = r100;
    }

    public final void setSubtitleEnableEffect(boolean r100) {
        this.subtitleEnableEffect = r100;
    }

    public final void setSubtitlePatchLynxEnable(boolean r100) {
        this.subtitlePatchLynxEnable = r100;
    }

    public final void setSubtitlePatchUrl(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.subtitlePatchUrl = r100;
    }

    public final void setSubtitleUseDefaultStyleAndPosition(boolean r100) {
        this.subtitleUseDefaultStyleAndPosition = r100;
    }
}
