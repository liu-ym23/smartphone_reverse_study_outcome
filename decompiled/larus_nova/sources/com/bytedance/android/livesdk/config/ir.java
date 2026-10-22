package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ir extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ir f120474a = null;

    static {
        f120474a = new ir();
    }

    public ir() {
        Boolean r100 = Boolean.FALSE;
        super(LiveInitSettingKeys.LIVE_ENABLE_DOWNLOAD_BMF_SO_PLUGIN, "是否使用bmf so插件", r100, r100);
    }
}
