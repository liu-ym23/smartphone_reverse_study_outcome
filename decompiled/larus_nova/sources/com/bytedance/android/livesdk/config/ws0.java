package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.SmoothEnterLeaveDoubleRenderConfig;

/* JADX INFO: loaded from: classes8.dex */
public final class ws0 extends SSettingKey<SmoothEnterLeaveDoubleRenderConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ws0 f121550a = null;

    static {
        f121550a = new ws0();
    }

    public ws0() {
        super("live_smooth_enter_leave_double_render", "平滑进退房双surface渲染开关", new SmoothEnterLeaveDoubleRenderConfig(), new SmoothEnterLeaveDoubleRenderConfig());
    }
}
