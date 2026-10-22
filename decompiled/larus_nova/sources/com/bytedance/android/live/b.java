package com.bytedance.android.live;

import com.bytedance.android.live.core.setting.SettingKey;

/* JADX INFO: loaded from: classes45.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SettingKey<Boolean> f58795a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SettingKey<Boolean> f58796b = null;

    static {
        Boolean r100 = Boolean.FALSE;
        Boolean r101 = Boolean.TRUE;
        new SettingKey("web_dialog_user_annie", "web_dialog接口使用annie.", r100, r101);
        f58795a = new SettingKey("live_room_switch_close_all_annie_dialog", "直播间切换时关闭所有annie容器弹窗", r100, r100);
        f58796b = new SettingKey("jsb_context_use_resume_activity", "jsb调用时，若context不为activity，取最近的activity", r101, r101);
    }
}
