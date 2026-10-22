package com.bytedance.android.livesdk.config;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class bw0 extends SettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final bw0 f119904a = null;

    static {
        f119904a = new bw0();
    }

    public bw0() {
        super("live_usercenter_block_list", "UserCenter trace上报黑名单", new ArrayList(), new ArrayList());
    }
}
