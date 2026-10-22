package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class g1 extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g1 f125378a = null;

    static {
        f125378a = new g1();
    }

    public g1() {
        super("live_lynx_gecko_channel_list", "Lynx gecko channel, 重定向图片离线资源", new ArrayList(), new ArrayList());
    }
}
