package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class d9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f120008a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f120009b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f120010c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f120011d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f120012e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f120013f = null;

    @SerializedName("ktv_bg_degrade_anchor_limit")
    public double ktvBgDegradeAnchorLimit;

    @SerializedName("ktv_bg_degrade_audience_limit")
    public double ktvBgDegradeAudienceLimit;

    @SerializedName("ktv_stage_animated_background")
    public String ktvStageAnimatedBg;

    @SerializedName("ktv_stage_static_background")
    public String ktvStageStaticBg;

    @SerializedName("ktv_talk_effect")
    public String seatTalkEffect;

    @SerializedName("ktv_sing_effect_url")
    public String stageSingEffect;

    @SerializedName("ktv_start_talk_effect")
    public String startTalkEffect;

    static {
        f120008a = LiveCommonConstants.assembleTosObjectUrl("obj/live-android/ttlive_ktv_theme_bg_default.webp");
        f120009b = LiveCommonConstants.assembleTosObjectUrl("obj/live-android/ttlive_ktv_theme_bg_default.webp");
        boolean r100 = tb1.c.f545229a;
        if (r100 == true) goto L5;
        boolean r101 = tb1.c.f545231c;
    L5:
        f120010c = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ktv_stage_sing_effect1.webp";
        f120011d = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/live-android/red_circle_singing.webp";
        if (r100 == true) goto L8;
        boolean r102 = tb1.c.f545231c;
    L8:
        f120012e = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ktv_seat_talk_effect.webp";
        if (r100 == true) goto L11;
        boolean r103 = tb1.c.f545231c;
    L11:
        f120013f = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ktv_seat_talk_start_effect.webp";
    }

    public d9() {
        this.ktvBgDegradeAnchorLimit = 7.09d;
        this.ktvBgDegradeAudienceLimit = 6.11d;
    }
}
