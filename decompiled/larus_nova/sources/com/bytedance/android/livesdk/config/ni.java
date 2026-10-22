package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes8.dex */
public final class ni extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ni f120834a = null;

    static {
        f120834a = new ni();
    }

    public ni() {
        Boolean r100 = Boolean.FALSE;
        super("live_broadcast_stream_process_opt", "直播暂停状态处理及内容一致性校验", r100, r100);
    }
}
