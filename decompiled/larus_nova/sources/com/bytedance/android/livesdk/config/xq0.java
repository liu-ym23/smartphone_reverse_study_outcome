package com.bytedance.android.livesdk.config;

import com.bytedance.android.livehostapi.LiveSdkInitHelper;

/* JADX INFO: loaded from: classes8.dex */
public final class xq0 extends SSettingKey<c81> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xq0 f121625a = null;

    static {
        f121625a = new xq0();
    }

    public xq0() {
        super(LiveSdkInitHelper.LIVE_SDK_INIT_DURATION_OPT, "直播初始化耗时优化 v2", new c81(), new c81());
    }
}
