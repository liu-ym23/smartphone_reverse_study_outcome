package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdkapi.model.MultiLinkFirstFrameOptConfigV2;

/* JADX INFO: loaded from: classes45.dex */
public final class u2 extends SSettingKey<MultiLinkFirstFrameOptConfigV2> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u2 f65422a = null;

    static {
        f65422a = new u2();
    }

    public u2() {
        super("multi_link_first_frame_opt_config_v2", "多人场景进房首帧耗时优化Config", new MultiLinkFirstFrameOptConfigV2(), new MultiLinkFirstFrameOptConfigV2());
    }
}
