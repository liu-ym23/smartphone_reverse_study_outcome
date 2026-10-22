package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ls extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ls f120704a = null;

    static {
        f120704a = new ls();
    }

    public ls() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_normal_live", "快捷开播接入加号主场景", r100, r100, true);
    }
}
