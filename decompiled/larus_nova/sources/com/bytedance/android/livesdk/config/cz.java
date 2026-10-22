package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class cz extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cz f119989a = null;

    static {
        f119989a = new cz();
    }

    public cz() {
        super(LiveInitSettingKeys.LIVE_GIFT_PANEL_STYLE, "礼物面板样式", 2, 2, new String[]{"0:- 线上对照", "1:- 仅tab上移", "2:- 仅tab上移+上下划", "3:- tab上移+上下划 + 下划时隐藏tab栏", "4:- 仅上下划", "5:- 上下划+ 下划时隐藏原下方tab栏"});
    }
}
