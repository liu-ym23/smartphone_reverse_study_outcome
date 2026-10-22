package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class aw0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final aw0 f119824a = null;

    static {
        f119824a = new aw0();
    }

    public aw0() {
        Boolean r100 = Boolean.TRUE;
        super("live_useraction_call_oncancel_click_outside", "UserAction取关确认弹窗点击外部消失时是否回调OnCancel", r100, r100);
    }
}
