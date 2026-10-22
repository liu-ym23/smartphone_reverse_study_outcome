package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class k4 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k4 f142265a = null;

    static {
        f142265a = new k4();
    }

    public k4() {
        Boolean r100 = Boolean.TRUE;
        super("live_announce_red_package_opt", "宠粉红包与预告结合的端上兜底开关，开关关闭后会无视 server 下发将所有端上改动进行回滚", r100, r100);
    }
}
