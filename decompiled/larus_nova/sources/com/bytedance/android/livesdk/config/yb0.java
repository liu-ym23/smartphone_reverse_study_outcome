package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class yb0 extends SSettingKey<MultiLinkFirstFrameOptConfig> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final yb0 f121673a = null;

    static {
        f121673a = new yb0();
    }

    public yb0() {
        super("live_multi_link_first_frame_opt", "是否支持多人场景内流首帧加载优化", new MultiLinkFirstFrameOptConfig(), new MultiLinkFirstFrameOptConfig());
    }
}
