package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class a31 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a31 f119762a = null;

    static {
        f119762a = new a31();
    }

    public a31() {
        Boolean r100 = Boolean.TRUE;
        super("live_fix_fb_show_repeat", "修复问卷展示后滑走滑回重复展示的问题", r100, r100);
    }
}
