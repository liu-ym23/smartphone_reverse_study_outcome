package com.bytedance.android.livesdk.config;

/* JADX INFO: loaded from: classes8.dex */
public final class w30 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w30 f121494a = null;

    static {
        f121494a = new w30();
    }

    public w30() {
        Boolean r100 = Boolean.FALSE;
        super("live_jsb_storage_async", "storage jsb 使用异步读取", r100, r100, true);
    }
}
