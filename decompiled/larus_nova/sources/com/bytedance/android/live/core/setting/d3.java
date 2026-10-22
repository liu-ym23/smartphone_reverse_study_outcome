package com.bytedance.android.live.core.setting;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class d3 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d3 f65280a = null;

    static {
        f65280a = new d3();
    }

    public d3() {
        Boolean r100 = Boolean.TRUE;
        super("live_multi_link_report_page_audio_capture_release_bugfix", "举报页面拉起相册释放音频权限", r100, r100);
    }
}
