package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public final class w6 extends SettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w6 f160655a = null;

    static {
        f160655a = new w6();
    }

    public w6() {
        super("live_prefetch_channels", new ArrayList());
    }
}
