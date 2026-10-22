package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.config.s81;

/* JADX INFO: loaded from: classes7.dex */
public final class x7 extends SettingKey<s81> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x7 f162540a = null;

    static {
        f162540a = new x7();
    }

    public x7() {
        super("live_component_template", "模版化开关配置", new s81(), new s81(), true);
    }
}
