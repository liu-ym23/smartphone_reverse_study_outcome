package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class m8 extends SettingKey<List<? extends Long>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m8 f153491a = null;

    static {
        f153491a = new m8();
    }

    public m8() {
        super("live_watch_xseconds_log_config", "直播间观看x秒上报埋点", new ArrayList(), new ArrayList(), true);
    }
}
