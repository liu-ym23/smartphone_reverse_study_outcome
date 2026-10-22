package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class qs extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final qs f121079a = null;

    static {
        f121079a = new qs();
    }

    public qs() {
        Boolean r100 = Boolean.FALSE;
        super(LiveInitSettingKeys.LIVE_ENABLE_PULL_STREAM_SO_PLUGIN, "是否使用拉流so插件", r100, r100);
    }
}
