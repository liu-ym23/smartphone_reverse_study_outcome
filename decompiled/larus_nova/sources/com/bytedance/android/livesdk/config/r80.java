package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;

/* JADX INFO: loaded from: classes8.dex */
public final class r80 extends SSettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r80 f121111a = null;

    static {
        f121111a = new r80();
    }

    public r80() {
        Long r100 = Long.valueOf(KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL);
        super("live_message_server_limit_max_fetch_interval", "消息server限流最大轮询间隔", r100, r100);
    }
}
