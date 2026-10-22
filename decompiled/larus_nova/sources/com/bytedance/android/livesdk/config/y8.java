package com.bytedance.android.livesdk.config;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes8.dex */
public class y8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f121662a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f121663b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f121664c = null;

    @SerializedName("auth_icon")
    public String authIcon;

    @SerializedName("auth")
    public String authUrl;

    @SerializedName("boy_bg")
    public String boyWithBg;

    @SerializedName("girl_bg")
    public String girlWithBg;

    public y8() {
    }

    static {
        boolean r100 = tb1.c.f545229a;
        if (r100 == true) goto L5;
        boolean r101 = tb1.c.f545231c;
    L5:
        f121662a = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/avatar_male.png";
        if (r100 == true) goto L8;
        boolean r102 = tb1.c.f545231c;
    L8:
        f121663b = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/avatar_female.png";
        if (r100 == true) goto L11;
        boolean r103 = tb1.c.f545231c;
    L11:
        f121664c = "https://lf3-webcastcdn-tos.douyinstatic.com/obj/live-android/ttlive_icon_ktv_avatar_agreement.png";
    }
}
