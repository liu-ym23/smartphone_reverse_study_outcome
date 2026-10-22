package com.bytedance.android.live.ktv.common.midi;

import com.bytedance.android.livesdkapi.LiveCommonConstants;

/* JADX INFO: loaded from: classes45.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f69852a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f69853b = null;

    static {
        StringBuilder r100 = new StringBuilder("https://");
        LiveCommonConstants r101 = LiveCommonConstants.INSTANCE;
        r100.append(r101.getImageTosPath());
        r100.append("/obj/live-android/ttlive_real_time_chorus_operate_bg_circle_light.png");
        f69852a = r100.toString();
        f69853b = "https://" + r101.getImageTosPath() + "/obj/live-android/ttlive_real_time_chorus_operate_bg_circle_dark.png";
    }
}
