package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public final class xp extends SettingKey<Map<String, ? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xp f121622a = null;

    static {
        f121622a = new xp();
    }

    public xp() {
        super("live_playmode_item_type_map", "互动面板动态玩法名称与ID映射", new LinkedHashMap(), new LinkedHashMap());
    }
}
