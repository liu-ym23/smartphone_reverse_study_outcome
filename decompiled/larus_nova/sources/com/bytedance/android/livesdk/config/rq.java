package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class rq extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final rq f121150a = null;

    static {
        f121150a = new rq();
    }

    public rq() {
        super("live_enable_anchor_save_draft", Boolean.TRUE, "录屏主播端存草稿入口展示开关");
    }
}
