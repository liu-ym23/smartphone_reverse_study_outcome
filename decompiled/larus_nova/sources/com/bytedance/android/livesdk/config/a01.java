package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.LiveTabRecomModel;

/* JADX INFO: loaded from: classes8.dex */
public final class a01 extends SSettingKey<LiveTabRecomModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a01 f119756a = null;

    static {
        f119756a = new a01();
    }

    public a01() {
        super("live_xtab_guide_config", "退出直播间弹窗引导", new LiveTabRecomModel(), new LiveTabRecomModel());
    }
}
