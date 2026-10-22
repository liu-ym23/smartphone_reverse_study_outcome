package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class j01 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j01 f120493a = null;

    static {
        f120493a = new j01();
    }

    public j01() {
        Boolean r100 = Boolean.TRUE;
        super("location_in_mainland", "是否为大陆地区用户，通过肉身位置判断（获取 geo_name_id 失败时也认为是）", r100, r100);
    }
}
