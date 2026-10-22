package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class iu0 extends SSettingKey<ls1.y> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final iu0 f120480a = null;

    static {
        iu0 r100 = new iu0();
        f120480a = r100;
        r100.setPreloadCache(com.bytedance.android.livesdk.config.setting.w.a());
    }

    public iu0() {
        super("live_tag_request_method", "直播TAG请求方式", new ls1.y(), new ls1.y());
    }
}
