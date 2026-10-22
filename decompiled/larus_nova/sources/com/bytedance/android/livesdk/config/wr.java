package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class wr extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wr f121547a = null;

    static {
        f121547a = new wr();
    }

    public wr() {
        Boolean r100 = Boolean.TRUE;
        super("live_enable_guide_view_only_for_qa", "端上是否支持引导页展示，该开关不会关闭，只有在QA自动化测试时临时关闭", r100, r100, true);
    }
}
