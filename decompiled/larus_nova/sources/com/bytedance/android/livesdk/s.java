package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class s extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f157853a = null;

    static {
        f157853a = new s();
    }

    public s() {
        super("live_anniex_lite_black_list", "直播路由轻量级全页黑名单", new ArrayList(), new ArrayList());
    }
}
