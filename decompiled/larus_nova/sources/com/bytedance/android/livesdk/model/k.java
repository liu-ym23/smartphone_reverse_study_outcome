package com.bytedance.android.livesdk.model;

import android.text.TextUtils;
import com.bytedance.android.livesdk.config.c70;
import com.bytedance.android.livesdk.config.ef;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.android.livesdkapi.model.AudioBgDeviceConfig;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes11.dex */
public class k {

    @SerializedName("audio_bg_even")
    private String audioBackgroundEven;

    @SerializedName("audio_bg_odd")
    private String audioBackgroundOdd;

    public static IVoiceLiveTheme a() {
        return c70.f119926a.getValue().toVoiceLiveTheme();
    }

    public k() {
        this.audioBackgroundEven = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/ttfe/ttlive/live_bg/live_audio_bg_o.png";
        this.audioBackgroundOdd = "https://lf1-webcastcdn-tos.douyinstatic.com/obj/ttfe/ttlive/live_bg/live_audio_bg_j.png";
    }

    public static boolean c(boolean r100) {
        AudioBgDeviceConfig r101 = ef.f120120a.getValue();
        if (r100 == false) goto L5;
        float r102 = r101.anchorScore;
    L6:
        float r103 = com.bytedance.android.livesdk.utils.z0.b(r100);
        if (r103 > 0.0f) goto L10;
        return false;
    L10:
        if (r103 >= r102) goto L13;
        return true;
    L13:
        return false;
    L5:
        r102 = r101.audienceScore;
        goto L6
    }

    public static String b(k r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L10;
        if ((r101.charAt(r101.length() - 1) % 2) == 0) goto L10;
        return r100.audioBackgroundOdd;
    L10:
        return r100.audioBackgroundEven;
    }
}
