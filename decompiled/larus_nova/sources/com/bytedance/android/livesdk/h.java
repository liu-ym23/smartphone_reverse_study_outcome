package com.bytedance.android.livesdk;

import com.bytedance.android.livesdk.config.SSettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class h extends SSettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f132621a = null;

    static {
        f132621a = new h();
    }

    public h() {
        Boolean r100 = Boolean.TRUE;
        super("enable_openprofile_jsb_add_report_type_for_log", "openProfile 是否处理 reportTypeForLog", r100, r100);
    }
}
