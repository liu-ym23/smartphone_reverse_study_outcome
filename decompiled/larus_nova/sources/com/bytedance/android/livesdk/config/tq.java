package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class tq extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final tq f121318a = null;

    static {
        f121318a = new tq();
    }

    public tq() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_annie_fragment_proxy_anniex", "AnnieFragmentProxy生成schema时是否处理AnnieX参数", r100, r100);
    }
}
