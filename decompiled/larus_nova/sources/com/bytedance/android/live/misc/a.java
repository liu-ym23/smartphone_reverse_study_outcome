package com.bytedance.android.live.misc;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes46.dex */
public final class a extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f83223a = null;

    static {
        f83223a = new a();
    }

    public a() {
        Boolean r100 = Boolean.TRUE;
        super("enable_large_font_fix", "是否允许大字化适配", r100, r100);
    }
}
