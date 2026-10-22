package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class ai1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f119793a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f119794b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f119795c = null;

    @SerializedName("background")
    public String backgroundImage;

    @SerializedName("flexible_blue_win_animation")
    public String flexibleBlueWinAnimation;

    @SerializedName("flexible_even_result_animation")
    public String flexibleEvenResultAnimation;

    @SerializedName("flexible_red_win_animation")
    public String flexibleRedWinAnimation;

    @SerializedName("start_animation")
    public String startAnimation;

    @SerializedName("start_btn_animation")
    public String startBtnAnimation;

    @SerializedName("team_fight_rule")
    public String teamFightRule;

    static {
        StringBuilder r100 = new StringBuilder("https://");
        LiveCommonConstants r101 = LiveCommonConstants.INSTANCE;
        r100.append(r101.getObjectTosPath());
        r100.append("/obj/live-android/team_fight_red_team_win_anim.webp");
        f119793a = r100.toString();
        f119794b = "https://" + r101.getObjectTosPath() + "/obj/live-android/team_fight_blue_team_win_anim.webp";
        f119795c = "https://" + r101.getObjectTosPath() + "/obj/live-android/team_fight_even_result_anim.webp";
    }

    public ai1() {
        this.backgroundImage = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/audio_team_fight_bg.png";
        this.startAnimation = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/team_fight_start_anim_dy.webp";
        this.startBtnAnimation = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/team_fight_start_btn_guide_douyin.webp";
        this.teamFightRule = "obj/live-android/ttlive_bg_team_fight_rule.png";
        this.flexibleRedWinAnimation = f119793a;
        this.flexibleBlueWinAnimation = f119794b;
        this.flexibleEvenResultAnimation = f119795c;
    }
}
