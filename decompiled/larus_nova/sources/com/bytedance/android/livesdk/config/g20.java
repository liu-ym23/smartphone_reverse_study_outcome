package com.bytedance.android.livesdk.config;

import android.os.Build;

/* JADX INFO: loaded from: classes8.dex */
public final class g20 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g20 f120251a = null;

    static {
        f120251a = new g20();
    }

    public g20() {
        if (Build.VERSION.SDK_INT <= 29) goto L5;
        boolean r100 = true;
    L6:
        super("live_interaction_fragment_add", "在Android10及以下版本是否同步：修复Android11黑屏花屏将添加fragment的方式从show换成了add", Boolean.valueOf(r100), Boolean.TRUE);
        return;
    L5:
        r100 = false;
        goto L6
    }
}
