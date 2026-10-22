package com.bytedance.android.livesdkapi.model;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.google.gson.annotations.SerializedName;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import py.k;
import vh7.f;

/* JADX INFO: loaded from: classes12.dex */
public class DefaultVoiceLiveThemeResource {
    public static String ANIMATED_BACKGROUND_URL = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/audio_bg_3_animated_1.webp";
    public static String SINGLE_STATIC_BACKGROUND_URL = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/audio_bg_3_static.png";
    public static String STATIC_BACKGROUND_URL = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/audio_bg_3.png";
    public static String TALK_EFFECT_URL = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/audio_bg_3_normal_avatar_1.webp";

    @SerializedName("animated_bg")
    public String animatedBackground;

    @SerializedName("talk_effect")
    public String effectAvatarTalk;

    @SerializedName("image_uri")
    public String imageUri;

    @SerializedName("single_static_bg")
    public String singleStaticBackground;

    @SerializedName("static_bg")
    public String staticBackground;

    public DefaultVoiceLiveThemeResource() {
    }

    public static IVoiceLiveTheme guestBattleDefaultTheme() {
        IVoiceLiveTheme r100 = (IVoiceLiveTheme) f.c(IVoiceLiveTheme.class);
        r100.setBgType(0);
        r100.setImageUri("webcast/guest_battle_default.png");
        r100.setStaticBackground(createImgModel("webcast/guest_battle_default.png", Collections.singletonList(LiveCommonConstants.assembleTosObjectUrl("obj/live-android/guest_battle_videotalk_background.png"))));
        r100.setSingleStaticBackground(createImgModel("webcast/guest_battle_default.png", Collections.singletonList(LiveCommonConstants.assembleTosObjectUrl("obj/live-android/guest_battle_videotalk_background.png"))));
        r100.setFormatType(1);
        return r100;
    }

    public static DefaultVoiceLiveThemeResource localRes() {
        DefaultVoiceLiveThemeResource r100 = new DefaultVoiceLiveThemeResource();
        r100.imageUri = "webcast/audio_bg_3.png";
        r100.staticBackground = STATIC_BACKGROUND_URL;
        r100.singleStaticBackground = SINGLE_STATIC_BACKGROUND_URL;
        r100.animatedBackground = ANIMATED_BACKGROUND_URL;
        r100.effectAvatarTalk = TALK_EFFECT_URL;
        return r100;
    }

    public static IVoiceLiveTheme videoTalkRoomDefaultTheme() {
        IVoiceLiveTheme r100 = (IVoiceLiveTheme) f.c(IVoiceLiveTheme.class);
        r100.setBgType(0);
        r100.setImageUri("webcast/video_bg.png");
        r100.setStaticBackground(createImgModel("webcast/video_bg.png", Collections.singletonList(LiveCommonConstants.assembleTosObjectUrl("obj/live-android/ttlive_video_talk_room_bg_douyin.webp"))));
        r100.setSingleStaticBackground(createImgModel("webcast/video_bg.png", Collections.singletonList(LiveCommonConstants.assembleTosObjectUrl("obj/live-android/ttlive_video_talk_room_bg_douyin.webp"))));
        r100.setFormatType(1);
        return r100;
    }

    public IVoiceLiveTheme toVoiceLiveTheme() {
        if (TextUtils.isEmpty(this.imageUri) == true) goto L10;
        if (TextUtils.isEmpty(this.staticBackground) == true) goto L10;
        IVoiceLiveTheme r100 = (IVoiceLiveTheme) f.c(IVoiceLiveTheme.class);
        r100.setImageType(0);
        r100.setImageUri(this.imageUri);
        r100.setStaticBackground(createImgModel("webcast/audio_bg_3.png", Arrays.asList(new String[]{this.staticBackground})));
        r100.setSingleStaticBackground(createImgModel("webcast/audio_bg_3_static.png", Arrays.asList(new String[]{this.singleStaticBackground})));
        r100.setAnimatedBackground(createImgModel("webcast/audio_bg_3_animated_1.webp", Arrays.asList(new String[]{this.animatedBackground})));
        r100.setEffectAvatarTalk(createImgModel("webcast/audio_bg_3_normal_avatar_1.webp", Arrays.asList(new String[]{this.effectAvatarTalk})));
        r100.setFormatType(2);
        return r100;
    L10:
        return localRes().toVoiceLiveTheme();
    }

    private static k createImgModel(String r100, List<String> r101) {
        k r102 = (k) f.c(k.class);
        r102.setUri(r100);
        r102.setUrls(r101);
        return r102;
    }
}
