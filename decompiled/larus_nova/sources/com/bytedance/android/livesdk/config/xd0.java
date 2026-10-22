package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class xd0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xd0 f121595a = null;

    static {
        f121595a = new xd0();
    }

    public xd0() {
        Boolean r100 = Boolean.FALSE;
        super("live_open_platform_audience_version_check_switch", "直播开平观众端，审核版本小程序的 schema 校验", r100, r100);
    }
}
