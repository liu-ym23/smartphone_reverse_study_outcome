package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class ik extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ik f120460a = null;

    static {
        f120460a = new ik();
    }

    public ik() {
        Boolean r100 = Boolean.TRUE;
        super("live_chorus_anchor_join_chorus", "主播续播检测加入合唱", r100, r100);
    }
}
