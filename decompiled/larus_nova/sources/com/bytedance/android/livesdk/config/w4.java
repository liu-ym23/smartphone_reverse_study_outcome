package com.bytedance.android.livesdk.config;

import com.ttnet.org.chromium.base.TimeUtils;

/* JADX INFO: loaded from: classes8.dex */
public final class w4 extends SSettingKey<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w4 f121495a = null;

    static {
        f121495a = new w4();
    }

    public w4() {
        Long r100 = Long.valueOf(TimeUtils.SECONDS_PER_HOUR);
        super("feedback_show_interval_length", "反馈问卷展示间隔", r100, r100);
    }
}
