package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class wu extends SSettingKey<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wu f121553a = null;

    static {
        f121553a = new wu();
    }

    public wu() {
        Float r100 = Float.valueOf(0.2019f);
        super(LiveInitSettingKeys.LIVE_EQUAL_TALK_ROOM_TOP_MARGIN_RATIO, "平权九宫格上边距的合流比例", r100, r100);
    }
}
