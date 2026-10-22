package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class vn extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final vn f121464a = null;

    static {
        f121464a = new vn();
    }

    public vn() {
        Boolean r100 = Boolean.FALSE;
        super("live_disable_enter_anchor_identity_param", "关闭进房接口的anchor_identity参数透传", r100, r100);
    }
}
