package com.bytedance.android.livesdkapi.depend.model.live.audio;

import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.android.livesdkapi.performance.ILoadStallMonitor;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.dypay.api.DyPayConstant;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.List;
import kotlin.Metadata;
import py.k;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes12.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b8\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\bg\u0018\u0000 \u0094\u00012\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003:\u0002\u0094\u0001J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0006H&R\u001a\u0010\u000f\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u001c\u001a\u00020\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010#\u001a\u0004\u0018\u00010\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\u000e\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010'\u001a\u0004\u0018\u00010\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\u000e\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R$\u0010+\u001a\u0004\u0018\u00010\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b*\u0010\u000e\u001a\u0004\b(\u0010\u001f\"\u0004\b)\u0010!R\u001c\u0010.\u001a\u0004\u0018\u00010\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b-\u0010\u000e\u001a\u0004\b,\u0010\u001fR\u001c\u00101\u001a\u0004\u0018\u00010\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b0\u0010\u000e\u001a\u0004\b/\u0010\u001fR\u001c\u00104\u001a\u0004\u0018\u00010\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b3\u0010\u000e\u001a\u0004\b2\u0010\u001fR$\u00108\u001a\u0004\u0018\u00010\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b7\u0010\u000e\u001a\u0004\b5\u0010\u001f\"\u0004\b6\u0010!R\u001c\u0010;\u001a\u0004\u0018\u00010\u00048&X§\u0004¢\u0006\f\u0012\u0004\b:\u0010\u000e\u001a\u0004\b9\u0010\u0011R$\u0010?\u001a\u0004\u0018\u00010\u00048&@&X§\u000e¢\u0006\u0012\u0012\u0004\b>\u0010\u000e\u001a\u0004\b<\u0010\u0011\"\u0004\b=\u0010\u0013R\u001a\u0010B\u001a\u00020\u00168&X§\u0004¢\u0006\f\u0012\u0004\bA\u0010\u000e\u001a\u0004\b@\u0010\u0018R\"\u0010F\u001a\u00020\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\bE\u0010\u000e\u001a\u0004\bC\u0010\u0018\"\u0004\bD\u0010\u001aR\u001c\u0010I\u001a\u0004\u0018\u00010\u00048&X§\u0004¢\u0006\f\u0012\u0004\bH\u0010\u000e\u001a\u0004\bG\u0010\u0011R\u001c\u0010L\u001a\u0004\u0018\u00010\u00048&X§\u0004¢\u0006\f\u0012\u0004\bK\u0010\u000e\u001a\u0004\bJ\u0010\u0011R\u001c\u0010O\u001a\u0004\u0018\u00010\u001d8&X§\u0004¢\u0006\f\u0012\u0004\bN\u0010\u000e\u001a\u0004\bM\u0010\u001fR\u001c\u0010R\u001a\u0004\u0018\u00010\u00048&X§\u0004¢\u0006\f\u0012\u0004\bQ\u0010\u000e\u001a\u0004\bP\u0010\u0011R\u001c\u0010U\u001a\u0004\u0018\u00010\u00048&X§\u0004¢\u0006\f\u0012\u0004\bT\u0010\u000e\u001a\u0004\bS\u0010\u0011R2\u0010[\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u00010Vj\f\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0018\u0001`W8&X§\u0004¢\u0006\f\u0012\u0004\bZ\u0010\u000e\u001a\u0004\bX\u0010YR\u001c\u0010^\u001a\u0004\u0018\u00010\u001d8&X§\u0004¢\u0006\f\u0012\u0004\b]\u0010\u000e\u001a\u0004\b\\\u0010\u001fR\u001c\u0010a\u001a\u0004\u0018\u00010\u00048&X§\u0004¢\u0006\f\u0012\u0004\b`\u0010\u000e\u001a\u0004\b_\u0010\u0011R\u001c\u0010d\u001a\u0004\u0018\u00010\u00048&X§\u0004¢\u0006\f\u0012\u0004\bc\u0010\u000e\u001a\u0004\bb\u0010\u0011R\u001c\u0010g\u001a\u0004\u0018\u00010\u00048&X§\u0004¢\u0006\f\u0012\u0004\bf\u0010\u000e\u001a\u0004\be\u0010\u0011R\"\u0010k\u001a\u00020\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\bj\u0010\u000e\u001a\u0004\bh\u0010\u0018\"\u0004\bi\u0010\u001aR\"\u0010o\u001a\u00020\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\bn\u0010\u000e\u001a\u0004\bl\u0010\u0018\"\u0004\bm\u0010\u001aR\u001c\u0010r\u001a\u0004\u0018\u00010\u00048&X§\u0004¢\u0006\f\u0012\u0004\bq\u0010\u000e\u001a\u0004\bp\u0010\u0011R\u001a\u0010u\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\bt\u0010\u000e\u001a\u0004\bs\u0010\fR\u001a\u0010x\u001a\u00020\n8&X§\u0004¢\u0006\f\u0012\u0004\bw\u0010\u000e\u001a\u0004\bv\u0010\fR\"\u0010|\u001a\u00020\u00168&@&X§\u000e¢\u0006\u0012\u0012\u0004\b{\u0010\u000e\u001a\u0004\by\u0010\u0018\"\u0004\bz\u0010\u001aR(\u0010\u0083\u0001\u001a\u0004\u0018\u00010}8&@&X§\u000e¢\u0006\u0015\u0012\u0005\b\u0082\u0001\u0010\u000e\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R+\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u0084\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\b\u0089\u0001\u0010\u000e\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R+\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u0084\u00018&@&X§\u000e¢\u0006\u0017\u0012\u0005\b\u008d\u0001\u0010\u000e\u001a\u0006\b\u008b\u0001\u0010\u0086\u0001\"\u0006\b\u008c\u0001\u0010\u0088\u0001R*\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00068&@&X§\u000e¢\u0006\u0017\u0012\u0005\b\u0093\u0001\u0010\u000e\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001¨\u0006\u0095\u0001"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme;", "Lvh7/c;", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveThemeDef;", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveThemeEx;", "", "getLocalPath", "", "getChoosing", "isUgcImage", "isRealTimeChorusTheme", "", "getId", "()J", "getId$annotations", "()V", "id", "getImageUri", "()Ljava/lang/String;", "setImageUri", "(Ljava/lang/String;)V", "getImageUri$annotations", "imageUri", "", "getImageType", "()I", "setImageType", "(I)V", "getImageType$annotations", "imageType", "Lpy/k;", "getStaticBackground", "()Lpy/k;", "setStaticBackground", "(Lpy/k;)V", "getStaticBackground$annotations", "staticBackground", "getAnimatedBackground", "setAnimatedBackground", "getAnimatedBackground$annotations", "animatedBackground", "getEffectAvatarTalk", "setEffectAvatarTalk", "getEffectAvatarTalk$annotations", "effectAvatarTalk", "getEffectAvatarStartTalk", "getEffectAvatarStartTalk$annotations", "effectAvatarStartTalk", "getSeatIcon", "getSeatIcon$annotations", "seatIcon", "getThumbnailBackground", "getThumbnailBackground$annotations", "thumbnailBackground", "getSingleStaticBackground", "setSingleStaticBackground", "getSingleStaticBackground$annotations", "singleStaticBackground", "getStatusColorValue", "getStatusColorValue$annotations", "statusColorValue", "getPublicScreenColorValue", "setPublicScreenColorValue", "getPublicScreenColorValue$annotations", "publicScreenColorValue", "getTimeLimit", "getTimeLimit$annotations", "timeLimit", "getBgType", "setBgType", "getBgType$annotations", "bgType", "getEmptyStartColor", "getEmptyStartColor$annotations", "emptyStartColor", "getEmptyEndColor", "getEmptyEndColor$annotations", "emptyEndColor", "getImageColdBg", "getImageColdBg$annotations", "imageColdBg", "getColorMicBG", "getColorMicBG$annotations", "colorMicBG", "getMicBGColorValue", "getMicBGColorValue$annotations", "micBGColorValue", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getIconMicNormals", "()Ljava/util/List;", "getIconMicNormals$annotations", "iconMicNormals", "getIconMicLock", "getIconMicLock$annotations", "iconMicLock", "getColorMicText", "getColorMicText$annotations", "colorMicText", "getColorMicLine", "getColorMicLine$annotations", "colorMicLine", "getThemeLabel", "getThemeLabel$annotations", "themeLabel", "getBgStatus", "setBgStatus", "getBgStatus$annotations", "bgStatus", "getPlayMode", "setPlayMode", "getPlayMode$annotations", Keys.API_EVENT_KEY_PLAY_MODE, "getThemeTag", "getThemeTag$annotations", "themeTag", "getStartTime", "getStartTime$annotations", DyPayConstant.KEY_START_TIME, "getEndTime", "getEndTime$annotations", "endTime", "getFormatType", "setFormatType", "getFormatType$annotations", "formatType", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IAnimatedBgInfo;", "getAnimatedBgInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IAnimatedBgInfo;", "setAnimatedBgInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IAnimatedBgInfo;)V", "getAnimatedBgInfo$annotations", "animatedBgInfo", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IAudioSpeakingImageList;", "getSpeakImageListV2", "()Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IAudioSpeakingImageList;", "setSpeakImageListV2", "(Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IAudioSpeakingImageList;)V", "getSpeakImageListV2$annotations", "speakImageListV2", "getSpeakImageList", "setSpeakImageList", "getSpeakImageList$annotations", "speakImageList", "isPreLoad", "()Ljava/lang/Boolean;", "setPreLoad", "(Ljava/lang/Boolean;)V", "isPreLoad$annotations", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IVoiceLiveTheme extends c<IVoiceLiveTheme>, IVoiceLiveThemeDef, IVoiceLiveThemeEx {
    public static final int BG_STATUS_IN_AUDIT = 1;
    public static final int BG_STATUS_NOT_PASS = 2;
    public static final int BG_STATUS_PASS = 3;
    public static final int BG_STATUS_UNKNOWN = 0;
    public static final Companion Companion = null;
    public static final int IMAGE_TYPE_ADD = -1;
    public static final int IMAGE_TYPE_CONFIG = 2;
    public static final int IMAGE_TYPE_EASY_START = 4;
    public static final int IMAGE_TYPE_OFFICIAL = 0;
    public static final int IMAGE_TYPE_SEND_BG = 3;
    public static final int IMAGE_TYPE_UGC = 1;
    public static final String TAG = "VoiceLiveTheme";
    public static final int TYPE_BOTH = 3;
    public static final int TYPE_GENDER = 2;
    public static final int TYPE_SIZE = 1;
    public static final int TYPE_TIME_LIMIT = 1;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\bR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\bR\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\bR\u0014\u0010\u0017\u001a\u00020\u00168\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveTheme$Companion;", "", "Lpy/k;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "", "isImageModelValid", "", "IMAGE_TYPE_ADD", "I", "IMAGE_TYPE_OFFICIAL", "IMAGE_TYPE_UGC", "IMAGE_TYPE_CONFIG", "IMAGE_TYPE_SEND_BG", "IMAGE_TYPE_EASY_START", "TYPE_SIZE", "TYPE_GENDER", "TYPE_BOTH", "TYPE_TIME_LIMIT", "BG_STATUS_UNKNOWN", "BG_STATUS_IN_AUDIT", "BG_STATUS_NOT_PASS", "BG_STATUS_PASS", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int BG_STATUS_IN_AUDIT = 1;
        public static final int BG_STATUS_NOT_PASS = 2;
        public static final int BG_STATUS_PASS = 3;
        public static final int BG_STATUS_UNKNOWN = 0;
        public static final int IMAGE_TYPE_ADD = -1;
        public static final int IMAGE_TYPE_CONFIG = 2;
        public static final int IMAGE_TYPE_EASY_START = 4;
        public static final int IMAGE_TYPE_OFFICIAL = 0;
        public static final int IMAGE_TYPE_SEND_BG = 3;
        public static final int IMAGE_TYPE_UGC = 1;
        public static final String TAG = "VoiceLiveTheme";
        public static final int TYPE_BOTH = 3;
        public static final int TYPE_GENDER = 2;
        public static final int TYPE_SIZE = 1;
        public static final int TYPE_TIME_LIMIT = 1;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }

        public final boolean isImageModelValid(k r100) {
            if (r100 != null) goto L4;
        L6:
            return false;
        L4:
            if (r100.getUrls().isEmpty() == true) goto L6;
            return true;
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class DefaultImpls {
        @FieldName(name = "imageAnimatedBG")
        public static /* synthetic */ void getAnimatedBackground$annotations() {
        }

        @FieldName(name = "animateInfo")
        public static /* synthetic */ void getAnimatedBgInfo$annotations() {
        }

        @FieldName(name = "bgStatus")
        public static /* synthetic */ void getBgStatus$annotations() {
        }

        @FieldName(name = "bg_type")
        public static /* synthetic */ void getBgType$annotations() {
        }

        @FieldName(name = "colorMicBG")
        public static /* synthetic */ void getColorMicBG$annotations() {
        }

        @FieldName(name = "colorMicLine")
        public static /* synthetic */ void getColorMicLine$annotations() {
        }

        @FieldName(name = "colorMicText")
        public static /* synthetic */ void getColorMicText$annotations() {
        }

        @FieldName(name = "imageStartupAvatar")
        public static /* synthetic */ void getEffectAvatarStartTalk$annotations() {
        }

        @FieldName(name = "imageNormalAvatar")
        public static /* synthetic */ void getEffectAvatarTalk$annotations() {
        }

        @FieldName(name = "empty_end_color")
        public static /* synthetic */ void getEmptyEndColor$annotations() {
        }

        @FieldName(name = "empty_start_color")
        public static /* synthetic */ void getEmptyStartColor$annotations() {
        }

        @FieldName(name = "end_time")
        public static /* synthetic */ void getEndTime$annotations() {
        }

        @FieldName(name = "format_type")
        public static /* synthetic */ void getFormatType$annotations() {
        }

        @FieldName(name = "iconMicLock")
        public static /* synthetic */ void getIconMicLock$annotations() {
        }

        @FieldName(name = "iconMicNormals")
        public static /* synthetic */ void getIconMicNormals$annotations() {
        }

        @FieldName(name = "id")
        public static /* synthetic */ void getId$annotations() {
        }

        @FieldName(name = "imageColdBG")
        public static /* synthetic */ void getImageColdBg$annotations() {
        }

        @FieldName(name = "img_type")
        public static /* synthetic */ void getImageType$annotations() {
        }

        @FieldName(name = "image_uri")
        public static /* synthetic */ void getImageUri$annotations() {
        }

        @FieldName(name = "micBGColorValue")
        public static /* synthetic */ void getMicBGColorValue$annotations() {
        }

        @FieldName(name = FastStartLiveConfig.PLAY_MODE)
        public static /* synthetic */ void getPlayMode$annotations() {
        }

        @FieldName(name = "public_screen_color_value")
        public static /* synthetic */ void getPublicScreenColorValue$annotations() {
        }

        @FieldName(name = "imageChatJoinIcon")
        public static /* synthetic */ void getSeatIcon$annotations() {
        }

        @FieldName(name = "imageStaticBG")
        public static /* synthetic */ void getSingleStaticBackground$annotations() {
        }

        @FieldName(name = "speakingImageList")
        public static /* synthetic */ void getSpeakImageList$annotations() {
        }

        @FieldName(name = "speaking_image_v2")
        public static /* synthetic */ void getSpeakImageListV2$annotations() {
        }

        @FieldName(name = ILoadStallMonitor.START_TIME)
        public static /* synthetic */ void getStartTime$annotations() {
        }

        @FieldName(name = "image")
        public static /* synthetic */ void getStaticBackground$annotations() {
        }

        @FieldName(name = "status_color_value")
        public static /* synthetic */ void getStatusColorValue$annotations() {
        }

        @FieldName(name = "themeLabel")
        public static /* synthetic */ void getThemeLabel$annotations() {
        }

        @FieldName(name = "theme_tag")
        public static /* synthetic */ void getThemeTag$annotations() {
        }

        @FieldName(name = "imageThumbnail")
        public static /* synthetic */ void getThumbnailBackground$annotations() {
        }

        @FieldName(name = "time_limit")
        public static /* synthetic */ void getTimeLimit$annotations() {
        }

        @FieldName(name = "is_pre_load")
        public static /* synthetic */ void isPreLoad$annotations() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    @Override // vh7.c
    /* synthetic */ e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ e castToOrNull(Class r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "imageAnimatedBG")
    k getAnimatedBackground();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "animateInfo")
    IAnimatedBgInfo getAnimatedBgInfo();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "bgStatus")
    int getBgStatus();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "bg_type")
    int getBgType();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeEx
    boolean getChoosing();

    @FieldName(name = "colorMicBG")
    String getColorMicBG();

    @FieldName(name = "colorMicLine")
    String getColorMicLine();

    @FieldName(name = "colorMicText")
    String getColorMicText();

    @FieldName(name = "imageStartupAvatar")
    k getEffectAvatarStartTalk();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "imageNormalAvatar")
    k getEffectAvatarTalk();

    @FieldName(name = "empty_end_color")
    String getEmptyEndColor();

    @FieldName(name = "empty_start_color")
    String getEmptyStartColor();

    @FieldName(name = "end_time")
    long getEndTime();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "format_type")
    int getFormatType();

    @FieldName(name = "iconMicLock")
    k getIconMicLock();

    @FieldName(name = "iconMicNormals")
    List<k> getIconMicNormals();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "id")
    long getId();

    @FieldName(name = "imageColdBG")
    k getImageColdBg();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "img_type")
    int getImageType();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "image_uri")
    String getImageUri();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeEx
    String getLocalPath();

    @FieldName(name = "micBGColorValue")
    String getMicBGColorValue();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = FastStartLiveConfig.PLAY_MODE)
    int getPlayMode();

    @FieldName(name = "public_screen_color_value")
    String getPublicScreenColorValue();

    @FieldName(name = "imageChatJoinIcon")
    k getSeatIcon();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "imageStaticBG")
    k getSingleStaticBackground();

    @FieldName(name = "speakingImageList")
    IAudioSpeakingImageList getSpeakImageList();

    @FieldName(name = "speaking_image_v2")
    IAudioSpeakingImageList getSpeakImageListV2();

    @FieldName(name = ILoadStallMonitor.START_TIME)
    long getStartTime();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "image")
    k getStaticBackground();

    @FieldName(name = "status_color_value")
    String getStatusColorValue();

    @FieldName(name = "themeLabel")
    String getThemeLabel();

    @FieldName(name = "theme_tag")
    String getThemeTag();

    @FieldName(name = "imageThumbnail")
    k getThumbnailBackground();

    @FieldName(name = "time_limit")
    int getTimeLimit();

    @FieldName(name = "is_pre_load")
    Boolean isPreLoad();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeEx
    boolean isRealTimeChorusTheme();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeEx
    boolean isUgcImage();

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "imageAnimatedBG#setter")
    void setAnimatedBackground(k r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "animateInfo#setter")
    void setAnimatedBgInfo(IAnimatedBgInfo r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "bgStatus#setter")
    void setBgStatus(int r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "bg_type#setter")
    void setBgType(int r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "imageNormalAvatar#setter")
    void setEffectAvatarTalk(k r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "format_type#setter")
    void setFormatType(int r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "img_type#setter")
    void setImageType(int r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "image_uri#setter")
    void setImageUri(String r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "play_mode#setter")
    void setPlayMode(int r100);

    @FieldName(name = "is_pre_load#setter")
    void setPreLoad(Boolean r100);

    @FieldName(name = "public_screen_color_value#setter")
    void setPublicScreenColorValue(String r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "imageStaticBG#setter")
    void setSingleStaticBackground(k r100);

    @FieldName(name = "speakingImageList#setter")
    void setSpeakImageList(IAudioSpeakingImageList r100);

    @FieldName(name = "speaking_image_v2#setter")
    void setSpeakImageListV2(IAudioSpeakingImageList r100);

    @Override // com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveThemeDef
    @FieldName(name = "image#setter")
    void setStaticBackground(k r100);
}
