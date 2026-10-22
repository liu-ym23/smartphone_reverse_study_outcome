package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes8.dex */
public class KtvAudioVolumeAnimConfig {

    @SerializedName("female_high_animation")
    public String femaleHighAnim;

    @SerializedName("female_low_animation")
    public String femaleLowAnim;

    @SerializedName("female_default_animation")
    public String femaleMediaAnim;

    @SerializedName("male_high_animation")
    public String maleHighAnim;

    @SerializedName("male_low_animation")
    public String maleLowAnim;

    @SerializedName("male_default_animation")
    public String maleMediaAnim;

    @SerializedName("unknown_high_animation")
    public String unkownHighAnim;

    @SerializedName("unknown_low_animation")
    public String unkownLowAnim;

    @SerializedName("unknown_default_animation")
    public String unkownMediaAnim;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Gender {
    }

    public KtvAudioVolumeAnimConfig() {
        StringBuilder r100 = new StringBuilder("https://");
        LiveCommonConstants r101 = LiveCommonConstants.INSTANCE;
        r100.append(r101.getImageTosPath());
        r100.append("/img/webcast/audio_bg_test5_speak_male_low.webp~tplv-obj.image");
        this.maleLowAnim = r100.toString();
        this.maleMediaAnim = "https://" + r101.getImageTosPath() + "/img/webcast/audio_bg_test5_speak_male_default.webp~tplv-obj.image";
        this.maleHighAnim = "https://" + r101.getImageTosPath() + "/img/webcast/audio_bg_test5_speak_male_high.webp~tplv-obj.image";
        this.femaleLowAnim = "https://" + r101.getImageTosPath() + "/img/webcast/audio_bg_test5_speak_female_low.webp~tplv-obj.image";
        this.femaleMediaAnim = "https://" + r101.getImageTosPath() + "/img/webcast/audio_bg_test5_speak_female_default.webp~tplv-obj.image";
        this.femaleHighAnim = "https://" + r101.getImageTosPath() + "/img/webcast/audio_bg_test5_speak_female_high.webp~tplv-obj.image";
        this.unkownLowAnim = "https://" + r101.getImageTosPath() + "/img/webcast/audio_bg_test5_speak_unknown_low.webp~tplv-obj.image";
        this.unkownMediaAnim = "https://" + r101.getImageTosPath() + "/img/webcast/audio_bg_test5_speak_unknown_default.webp~tplv-obj.image";
        this.unkownHighAnim = "https://" + r101.getImageTosPath() + "/img/webcast/audio_bg_test5_speak_unknown_high.webp~tplv-obj.image";
    }

    public final String a(int r100, int r101) {
        if (r100 != 1) goto L9;
        if (r101 == 1) goto L21;
        if (r101 != 2) goto L23;
        return this.maleMediaAnim;
    L23:
        return this.maleHighAnim;
    L21:
        return this.maleLowAnim;
    L9:
        if (r100 != 2) goto L15;
        if (r101 == 1) goto L24;
        if (r101 != 2) goto L26;
        return this.femaleMediaAnim;
    L26:
        return this.femaleHighAnim;
    L24:
        return this.femaleLowAnim;
    L15:
        if (r101 == 1) goto L27;
        if (r101 != 2) goto L20;
        return this.unkownMediaAnim;
    L20:
        return this.unkownHighAnim;
    L27:
        return this.unkownLowAnim;
    }
}
