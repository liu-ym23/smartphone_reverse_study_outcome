package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class t extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final t f158502a = null;

    static {
        f158502a = new t();
    }

    public t() {
        super("live_anniex_lite_white_list", "直播路由轻量级全页白名单", new ArrayList(), new ArrayList());
    }
}
