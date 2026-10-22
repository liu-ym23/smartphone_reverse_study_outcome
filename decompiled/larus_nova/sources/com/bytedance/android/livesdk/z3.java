package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.GameCardOptConfig;

/* JADX INFO: loaded from: classes7.dex */
public final class z3 extends SettingKey<GameCardOptConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z3 f162561a = null;

    static {
        f162561a = new z3();
    }

    public z3() {
        super("gamecp_introduce_card_load_opt", "讲解卡加载优化", new GameCardOptConfig(false, false, 3, null), new GameCardOptConfig(false, false, 3, null));
    }
}
