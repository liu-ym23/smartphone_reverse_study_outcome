package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class d5 extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d5 f65282a = null;

    static {
        f65282a = new d5();
    }

    public d5() {
        super("live_short_touch_countdown_list", "有倒计时的可配短触typeId", new ArrayList(), new ArrayList());
    }
}
