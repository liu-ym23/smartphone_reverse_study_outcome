package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class g2 extends SSettingKey<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g2 f65304a = null;

    static {
        f65304a = new g2();
    }

    public g2() {
        super("live_load_more_inhibition", "首个直播间loadMore回调抑制", 0, 0, new String[]{"0:对照组", "1:延迟到P1交互层加载完成", "2:延迟到P2交互层加载完成", "3:延迟到交互层加载完成", "4:延迟到滑动操作时或不执行"});
    }
}
