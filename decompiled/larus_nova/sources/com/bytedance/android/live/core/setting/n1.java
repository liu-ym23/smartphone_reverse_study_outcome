package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes45.dex */
public final class n1 extends SSettingKey<List<? extends String>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n1 f65364a = null;

    static {
        f65364a = new n1();
    }

    public n1() {
        super("live_fold_fix_black", "修复折叠屏背景黑边", new ArrayList(), new ArrayList());
    }
}
