package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class vw extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vw f121482a = null;

    static {
        f121482a = new vw();
    }

    public vw() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_single_page_resume_start_audio_error_v2", "修复单页面开播resume时打开音频采集的异常2", r100, r100);
    }
}
