package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class m0 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m0 f153483a = null;

    static {
        f153483a = new m0();
    }

    public m0() {
        Boolean r100 = Boolean.FALSE;
        super("live_enable_lynx_popup_prefetch", "是否打开Lynx的NativePrefetch能力", r100, r100);
    }
}
