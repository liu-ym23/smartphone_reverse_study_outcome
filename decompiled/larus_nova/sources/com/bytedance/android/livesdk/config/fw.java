package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class fw extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final fw f120235a = null;

    static {
        f120235a = new fw();
    }

    public fw() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_asr_plugin_load", "修复加载asr插件的so的时候的crash", r100, r100);
    }
}
