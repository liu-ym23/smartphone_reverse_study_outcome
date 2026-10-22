package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class dv extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dv f120066a = null;

    static {
        f120066a = new dv();
    }

    public dv() {
        Boolean r100 = Boolean.FALSE;
        super("live_external_default_remove_container", "接入层容器移除时机fix", r100, r100, true);
    }
}
