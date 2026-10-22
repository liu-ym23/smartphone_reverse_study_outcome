package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ev0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ev0 f120157a = null;

    static {
        f120157a = new ev0();
    }

    public ev0() {
        Boolean r100 = Boolean.FALSE;
        super("live_toolbar_permission_check_enable", "toolbar组件挂载校验开关", r100, r100, true);
    }
}
