package com.bytedance.android.livesdk;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes7.dex */
public final class c1 extends SettingKey<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c1 f104410a = null;

    static {
        f104410a = new c1();
    }

    public c1() {
        Boolean r100 = Boolean.TRUE;
        super("live_link_guest_mem_leak_fix", "嘉宾上麦内存泄漏修改", r100, r100);
    }
}
