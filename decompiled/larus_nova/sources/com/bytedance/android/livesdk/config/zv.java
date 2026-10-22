package com.bytedance.android.livesdk.config;

import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.FirstCompShowData;

/* JADX INFO: loaded from: classes8.dex */
public final class zv extends SSettingKey<FirstCompShowData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final zv f121794a = null;

    static {
        f121794a = new zv();
    }

    public zv() {
        super("live_first_comp_show_opt", "第一个组件加载优化", new FirstCompShowData(), new FirstCompShowData(), true);
    }
}
