package com.bytedance.android.livesdk.config;

import com.ss.android.ugc.aweme.debug.LocalTestManager;

/* JADX INFO: loaded from: classes8.dex */
public final class vg extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vg f121447a = null;

    public vg() {
        LocalTestManager.a(new Class[]{wy.a.class});
        Boolean r100 = Boolean.FALSE;
        super("live_broadcast_audio_float_window", "主播端语音直播小窗", r100, r100);
    }

    static {
        f121447a = new vg();
    }
}
