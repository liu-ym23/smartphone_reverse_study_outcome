package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class hn0 extends SettingKey<Map<Integer, ? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final hn0 f120391a = null;

    static {
        f120391a = new hn0();
    }

    public hn0() {
        super("live_play_mode_map", "营收玩法plyamode映射", new LinkedHashMap(), new LinkedHashMap());
    }
}
