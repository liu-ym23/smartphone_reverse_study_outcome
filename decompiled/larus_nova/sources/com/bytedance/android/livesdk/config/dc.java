package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class dc extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final dc f120020a = null;

    static {
        f120020a = new dc();
    }

    public dc() {
        Boolean r100 = Boolean.TRUE;
        super("live_anchor_more_dialog_cancelable_enable", "更多面板组件挂载校验过程中不允许关闭面板", r100, r100, true);
    }
}
