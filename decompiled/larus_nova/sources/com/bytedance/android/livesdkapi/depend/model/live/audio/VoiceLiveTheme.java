package com.bytedance.android.livesdkapi.depend.model.live.audio;

import android.text.TextUtils;
import com.bytedance.android.live.d;
import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.common.utility.Lists;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.List;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
public class VoiceLiveTheme extends FlexModelBase<IVoiceLiveTheme> implements IVoiceLiveTheme {
    public static final int BG_STATUS_IN_AUDIT = 1;
    public static final int BG_STATUS_NOT_PASS = 2;
    public static final int BG_STATUS_PASS = 3;
    public static final int BG_STATUS_UNKNOWN = 0;
    public static final int IMAGE_TYPE_ADD = -1;
    public static final int IMAGE_TYPE_CONFIG = 2;
    public static final int IMAGE_TYPE_EASY_START = 4;
    public static final int IMAGE_TYPE_OFFICIAL = 0;
    public static final int IMAGE_TYPE_PLAY_MODE = 5;
    public static final int IMAGE_TYPE_SEND_BG = 3;
    public static final int IMAGE_TYPE_UGC = 1;
    public static final int REAL_TIME_CHORUS = 36;
    public static String TAG = "VoiceLiveTheme";
    public static final int TYPE_BOTH = 3;
    public static final int TYPE_GENDER = 2;
    public static final int TYPE_SIZE = 1;
    public static final int TYPE_TIME_LIMIT = 1;

    @SerializedName("imageAnimatedBG")
    public k animatedBackground;

    @SerializedName("animateInfo")
    public AnimatedBgInfo animatedBgInfo;

    @SerializedName("bgStatus")
    public int bgStatus;

    @SerializedName("bg_type")
    public int bgType;

    @IgnoreProtoFieldCheck
    public boolean changeByAnchor;

    @IgnoreProtoFieldCheck
    public boolean choosing;

    @SerializedName("colorMicBG")
    public String colorMicBG;

    @SerializedName("colorMicLine")
    public String colorMicLine;

    @SerializedName("colorMicText")
    public String colorMicText;

    @SerializedName("imageStartupAvatar")
    public k effectAvatarStartTalk;

    @SerializedName("imageNormalAvatar")
    public k effectAvatarTalk;

    @SerializedName("empty_end_color")
    public String emptyEndColor;

    @SerializedName("empty_start_color")
    public String emptyStartColor;

    @SerializedName("end_time")
    public long endTime;

    @SerializedName("format_type")
    public int formatType;

    @IgnoreProtoFieldCheck
    public boolean fromPush;

    @SerializedName("iconMicLock")
    public k iconMicLock;

    @SerializedName("iconMicNormals")
    public List<k> iconMicNormals;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    public long f162615id;

    @SerializedName("imageColdBG")
    public k imageColdBg;

    @SerializedName("img_type")
    public int imageType;

    @SerializedName("image_uri")
    public String imageUri;

    @SerializedName("is_pre_load")
    public boolean isPreLoad;

    @IgnoreProtoFieldCheck
    public String localPath;

    @SerializedName("micBGColorValue")
    public String micBGColorValue;

    @SerializedName(FastStartLiveConfig.PLAY_MODE)
    public int playMode;

    @SerializedName("public_screen_color_value")
    public String publicScreenColorValue;

    @SerializedName("imageChatJoinIcon")
    public k seatIcon;

    @SerializedName("imageStaticBG")
    public k singleStaticBackground;

    @SerializedName("speakingImageList")
    public AudioSpeakingImageList speakImageList;

    @SerializedName("speaking_image_v2")
    public AudioSpeakingImageList speakImageListV2;

    @SerializedName(ILoadStallMonitor.START_TIME)
    public long startTime;

    @SerializedName("image")
    public k staticBackground;

    @SerializedName("status_color_value")
    public String statusColorValue;

    @SerializedName("themeLabel")
    public String themeLabel;

    @SerializedName("theme_tag")
    public String themeTag;

    @SerializedName("imageThumbnail")
    public k thumbnailBackground;

    @SerializedName("time_limit")
    public int timeLimit;

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeEx
    public void setUgcImage(boolean r100) {
    }

    public VoiceLiveTheme() {
        super(IVoiceLiveTheme.class);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.f162615id), this.imageUri, Integer.valueOf(this.imageType), Integer.valueOf(this.bgType), Integer.valueOf(this.playMode), Long.valueOf(this.startTime), Long.valueOf(this.endTime), Integer.valueOf(this.bgStatus)});
    }

    public boolean isAddImage() {
        if (this.imageType != (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isConfig() {
        if (this.imageType != 2) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public Boolean isPreLoad() {
        return Boolean.valueOf(this.isPreLoad);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeEx
    public boolean isRealTimeChorusTheme() {
        if (this.imageType == 5) goto L5;
    L7:
        return false;
    L5:
        if (this.playMode != 36) goto L7;
        return true;
    }

    public boolean isSendBag() {
        if (this.imageType != 3) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeEx
    public boolean isUgcImage() {
        if (this.imageType == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isUgcVideoTheme() {
        if (this.imageType != 1) goto L13;
        AnimatedBgInfo r100 = this.animatedBgInfo;
        if (r100 == null) goto L13;
        if (r100.getAnimatedBg() == null) goto L13;
        if (this.animatedBgInfo.getAnimatedBg().getUri() == null) goto L13;
        if ("mp4".equals(this.animatedBgInfo.getFileFormat()) == false) goto L13;
        return true;
    L13:
        return false;
    }

    public boolean isVideoTheme() {
        AnimatedBgInfo r100 = this.animatedBgInfo;
        if (r100 != null) goto L5;
    L11:
        return false;
    L5:
        if (r100.getAnimatedBg() == null) goto L11;
        if (this.animatedBgInfo.getAnimatedBg().getUri() == null) goto L11;
        if ("mp4".equals(this.animatedBgInfo.getFileFormat()) == false) goto L11;
        return true;
    }

    public boolean isVoiceAnimInvalid() {
        AudioSpeakingImageList r100 = this.speakImageList;
        if (r100 != null) goto L5;
    L6:
        AudioSpeakingImageList r101 = this.speakImageListV2;
        if (r101 != null) goto L9;
    L11:
        return false;
    L9:
        if (r101.isV2Invalide() == false) goto L11;
    L10:
        return true;
    L5:
        if (r100.isInvalide() == true) goto L10;
        goto L6
    }

    public String toString() {
        k r100 = this.staticBackground;
        if (r100 != null) goto L5;
        String r101 = this.localPath;
    L7:
        return "Theme{imageUri='" + this.imageUri + "', id=" + this.f162615id + ", imageType=" + this.imageType + ", staticBg=" + r101 + ", bgType=" + this.bgType + ", bgStatus=" + this.bgStatus + ", isPreLoad=" + this.isPreLoad + '}';
    L5:
        r101 = r100.getUri();
        goto L7
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public /* bridge */ /* synthetic */ IAnimatedBgInfo getAnimatedBgInfo() {
        return getAnimatedBgInfo();
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public /* bridge */ /* synthetic */ IAudioSpeakingImageList getSpeakImageListV2() {
        return getSpeakImageListV2();
    }

    public boolean isLocalUgcTheme() {
        if (isUgcImage() == true) goto L5;
    L9:
        return false;
    L5:
        if (this.staticBackground != null) goto L9;
        if (TextUtils.isEmpty(this.localPath) == true) goto L9;
        return true;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public k getAnimatedBackground() {
        return this.animatedBackground;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public int getBgStatus() {
        return this.bgStatus;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public int getBgType() {
        return this.bgType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeEx
    public boolean getChangeByAnchor() {
        return this.changeByAnchor;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeEx
    public boolean getChoosing() {
        return this.choosing;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public String getColorMicBG() {
        return this.colorMicBG;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public String getColorMicLine() {
        return this.colorMicLine;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public String getColorMicText() {
        return this.colorMicText;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public k getEffectAvatarStartTalk() {
        return this.effectAvatarStartTalk;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public k getEffectAvatarTalk() {
        return this.effectAvatarTalk;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public String getEmptyEndColor() {
        return this.emptyEndColor;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public String getEmptyStartColor() {
        return this.emptyStartColor;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public long getEndTime() {
        return this.endTime;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public int getFormatType() {
        return this.formatType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeEx
    public boolean getFromPush() {
        return this.fromPush;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public k getIconMicLock() {
        return this.iconMicLock;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public List<k> getIconMicNormals() {
        return this.iconMicNormals;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public long getId() {
        return this.f162615id;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public k getImageColdBg() {
        return this.imageColdBg;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public int getImageType() {
        return this.imageType;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public String getImageUri() {
        return this.imageUri;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeEx
    public String getLocalPath() {
        return this.localPath;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public String getMicBGColorValue() {
        return this.micBGColorValue;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public int getPlayMode() {
        return this.playMode;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public String getPublicScreenColorValue() {
        return this.publicScreenColorValue;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public k getSeatIcon() {
        return this.seatIcon;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public k getSingleStaticBackground() {
        return this.singleStaticBackground;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public IAudioSpeakingImageList getSpeakImageList() {
        return this.speakImageList;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public long getStartTime() {
        return this.startTime;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public k getStaticBackground() {
        return this.staticBackground;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public String getStatusColorValue() {
        return this.statusColorValue;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public String getThemeLabel() {
        return this.themeLabel;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public String getThemeTag() {
        return this.themeTag;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public k getThumbnailBackground() {
        return this.thumbnailBackground;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public int getTimeLimit() {
        return this.timeLimit;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public AnimatedBgInfo getAnimatedBgInfo() {
        return this.animatedBgInfo;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public AudioSpeakingImageList getSpeakImageListV2() {
        return this.speakImageListV2;
    }

    public static boolean isImageModelValid(k r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (Lists.isEmpty(r100.getUrls()) == true) goto L6;
        return true;
    }

    public static boolean isValid(VoiceLiveTheme r100) {
        if (r100 == null) goto L20;
        k r101 = r100.staticBackground;
        if (r101 != null) goto L6;
    L8:
        k r102 = r100.singleStaticBackground;
        if (r102 != null) goto L11;
    L13:
        AnimatedBgInfo r103 = r100.animatedBgInfo;
        if (r103 != null) goto L16;
        return false;
    L16:
        if (r103.getAnimatedBg() != null) goto L18;
        return false;
    L18:
        if (Lists.isEmpty(r100.animatedBgInfo.getAnimatedBg().getUrls()) == true) goto L24;
        return true;
    L24:
        return false;
    L11:
        if (Lists.isEmpty(r102.getUrls()) == true) goto L13;
        return true;
    L6:
        if (Lists.isEmpty(r101.getUrls()) == true) goto L8;
        return true;
    L20:
        return false;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L29:
        return false;
    L8:
        if (getClass() != r100.getClass()) goto L29;
        VoiceLiveTheme r101 = (VoiceLiveTheme) r100;
        if (this.f162615id == r101.f162615id) goto L13;
    L27:
        return false;
    L13:
        if (d.a(this.imageUri, r101.imageUri) == false) goto L27;
        if (this.imageType != r101.imageType) goto L27;
        if (this.bgStatus != r101.bgStatus) goto L27;
        if (this.bgType != r101.bgType) goto L27;
        if (this.playMode != r101.playMode) goto L27;
        if (this.startTime != r101.startTime) goto L27;
        if (this.endTime != r101.endTime) goto L27;
        return true;
    }

    public boolean isSourceEqual(VoiceLiveTheme r100) {
        return IVoiceLiveThemeKt.isSourceEqual(this, r100);
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public void setAnimatedBackground(k r100) {
        this.animatedBackground = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public void setAnimatedBgInfo(IAnimatedBgInfo r100) {
        this.animatedBgInfo = (AnimatedBgInfo) r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public void setBgStatus(int r100) {
        this.bgStatus = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public void setBgType(int r100) {
        this.bgType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeEx
    public void setChangeByAnchor(boolean r100) {
        this.changeByAnchor = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeEx
    public void setChoosing(boolean r100) {
        this.choosing = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public void setEffectAvatarTalk(k r100) {
        this.effectAvatarTalk = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public void setFormatType(int r100) {
        this.formatType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeEx
    public void setFromPush(boolean r100) {
        this.fromPush = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public void setImageType(int r100) {
        this.imageType = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public void setImageUri(String r100) {
        this.imageUri = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeEx
    public void setLocalPath(String r100) {
        this.localPath = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public void setPlayMode(int r100) {
        this.playMode = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public void setPreLoad(Boolean r100) {
        if (r100 == null) goto L5;
        this.isPreLoad = r100.booleanValue();
        return;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public void setPublicScreenColorValue(String r100) {
        this.publicScreenColorValue = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public void setSingleStaticBackground(k r100) {
        this.singleStaticBackground = r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public void setSpeakImageList(IAudioSpeakingImageList r100) {
        this.speakImageList = (AudioSpeakingImageList) r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme
    public void setSpeakImageListV2(IAudioSpeakingImageList r100) {
        this.speakImageListV2 = (AudioSpeakingImageList) r100;
    }

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme, com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    public void setStaticBackground(k r100) {
        this.staticBackground = r100;
    }

    public static boolean isValid(IVoiceLiveTheme r100) {
        return isValid((VoiceLiveTheme) r100);
    }

    public k getVolumeAnim(int r100, int r101, int r102, int r103) {
        k r104 = this.effectAvatarTalk;
        if (r103 != 1) goto L15;
        AudioSpeakingImageList r105 = this.speakImageListV2;
        if (r105 == null) goto L10;
        SpeakingImage r106 = r105.unknownImage;
        if (r106 == null) goto L10;
        return r106.medium;
    L10:
        AudioSpeakingImageList r107 = this.speakImageList;
        if (r107 != null) goto L13;
        return r104;
    L13:
        return r107.getSizeImage(2);
    L15:
        if (r103 != 2) goto L27;
        AudioSpeakingImageList r108 = this.speakImageListV2;
        if (r108 != null) goto L19;
    L22:
        AudioSpeakingImageList r109 = this.speakImageList;
        if (r109 != null) goto L25;
        return r104;
    L25:
        return r109.getGenderImage(r102);
    L19:
        if (r108.isV2Invalide() == false) goto L22;
        return this.speakImageListV2.getGenderImage(r102);
    L27:
        AudioSpeakingImageList r110 = this.speakImageList;
        if (r110 != null) goto L30;
        return r104;
    L30:
        if (r100 == 1) goto L40;
        if (r100 != 2) goto L35;
        return r110.getGenderImage(r102);
    L35:
        if (r100 == 3) goto L37;
        return r104;
    L37:
        return r110.getGenderSizeImage(r102, r101);
    L40:
        return r110.getSizeImage(r101);
    }
}
