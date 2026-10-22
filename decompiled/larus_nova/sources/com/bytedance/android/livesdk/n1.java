package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class n1 extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n1 f153993a = null;

    static {
        f153993a = new n1();
    }

    public n1() {
        Boolean r100 = Boolean.FALSE;
        super("live_openudid_header_enable", "header增加工程openudid", r100, r100);
    }
}
