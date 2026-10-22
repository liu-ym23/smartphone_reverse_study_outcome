package com.bytedance.android.livesdkapi.depend.model.live.audio;

import com.bytedance.android.livesdkapi.config.FastStartLiveConfig;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.Metadata;
import py.k;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\bg\u0018\u00002\u00020\u0001R\u001e\u0010\b\u001a\u00060\u0002j\u0002`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u000f\u001a\u00020\t8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000e\u0010\u0007\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR*\u0010\u0017\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\u0007\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u001b\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\u0007\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R*\u0010\u001f\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001e\u0010\u0007\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R\"\u0010#\u001a\u00020\t8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\u0007\u001a\u0004\b \u0010\u000b\"\u0004\b!\u0010\rR$\u0010*\u001a\u0004\u0018\u00010$8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b)\u0010\u0007\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R*\u0010.\u001a\n\u0018\u00010\u0010j\u0004\u0018\u0001`\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b-\u0010\u0007\u001a\u0004\b+\u0010\u0013\"\u0004\b,\u0010\u0015R\"\u00102\u001a\u00020\t8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b1\u0010\u0007\u001a\u0004\b/\u0010\u000b\"\u0004\b0\u0010\rR$\u00109\u001a\u0004\u0018\u0001038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b8\u0010\u0007\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010=\u001a\u00020\t8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b<\u0010\u0007\u001a\u0004\b:\u0010\u000b\"\u0004\b;\u0010\rR\"\u0010A\u001a\u00020\t8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b@\u0010\u0007\u001a\u0004\b>\u0010\u000b\"\u0004\b?\u0010\r¨\u0006B"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IVoiceLiveThemeDef;", "", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getId", "()J", "getId$annotations", "()V", "id", "", "getBgType", "()I", "setBgType", "(I)V", "getBgType$annotations", "bgType", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getStaticBackground", "()Lpy/k;", "setStaticBackground", "(Lpy/k;)V", "getStaticBackground$annotations", "staticBackground", "getSingleStaticBackground", "setSingleStaticBackground", "getSingleStaticBackground$annotations", "singleStaticBackground", "getAnimatedBackground", "setAnimatedBackground", "getAnimatedBackground$annotations", "animatedBackground", "getImageType", "setImageType", "getImageType$annotations", "imageType", "", "getImageUri", "()Ljava/lang/String;", "setImageUri", "(Ljava/lang/String;)V", "getImageUri$annotations", "imageUri", "getEffectAvatarTalk", "setEffectAvatarTalk", "getEffectAvatarTalk$annotations", "effectAvatarTalk", "getFormatType", "setFormatType", "getFormatType$annotations", "formatType", "Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IAnimatedBgInfo;", "getAnimatedBgInfo", "()Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IAnimatedBgInfo;", "setAnimatedBgInfo", "(Lcom/bytedance/android/livesdkapi/depend/model/live/audio/IAnimatedBgInfo;)V", "getAnimatedBgInfo$annotations", "animatedBgInfo", "getBgStatus", "setBgStatus", "getBgStatus$annotations", "bgStatus", "getPlayMode", "setPlayMode", "getPlayMode$annotations", Keys.API_EVENT_KEY_PLAY_MODE, "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface IVoiceLiveThemeDef {

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

        @FieldName(name = "imageNormalAvatar")
        public static /* synthetic */ void getEffectAvatarTalk$annotations() {
        }

        @FieldName(name = "format_type")
        public static /* synthetic */ void getFormatType$annotations() {
        }

        @FieldName(name = "id")
        public static /* synthetic */ void getId$annotations() {
        }

        @FieldName(name = "img_type")
        public static /* synthetic */ void getImageType$annotations() {
        }

        @FieldName(name = "image_uri")
        public static /* synthetic */ void getImageUri$annotations() {
        }

        @FieldName(name = FastStartLiveConfig.PLAY_MODE)
        public static /* synthetic */ void getPlayMode$annotations() {
        }

        @FieldName(name = "imageStaticBG")
        public static /* synthetic */ void getSingleStaticBackground$annotations() {
        }

        @FieldName(name = "image")
        public static /* synthetic */ void getStaticBackground$annotations() {
        }
    }

    k getAnimatedBackground();

    IAnimatedBgInfo getAnimatedBgInfo();

    int getBgStatus();

    int getBgType();

    k getEffectAvatarTalk();

    int getFormatType();

    long getId();

    int getImageType();

    String getImageUri();

    int getPlayMode();

    k getSingleStaticBackground();

    k getStaticBackground();

    void setAnimatedBackground(k r100);

    void setAnimatedBgInfo(IAnimatedBgInfo r100);

    void setBgStatus(int r100);

    void setBgType(int r100);

    void setEffectAvatarTalk(k r100);

    void setFormatType(int r100);

    void setImageType(int r100);

    void setImageUri(String r100);

    void setPlayMode(int r100);

    void setSingleStaticBackground(k r100);

    void setStaticBackground(k r100);
}
