package com.bytedance.android.livesdk.chatroom.setting;

import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;

/* JADX INFO: loaded from: classes7.dex */
public interface j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SettingKey<Boolean> f111528a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SettingKey<Integer> f111529b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final SettingKey<Boolean> f111530c = null;

    static {
        Boolean r100 = Boolean.FALSE;
        f111528a = new SettingKey("live_dynamic_toolbar_modify_theme", r100, "toolbar标准化换肤能力");
        new SettingKey(EComABUtils.AB_KEY_LIVE_OPT_SLOT, Boolean.TRUE, "新公共槽位");
        f111529b = new SettingKey("live_commerce_room_gift", "电商直播间关闭礼物功能实验", 0, 0);
        f111530c = new SettingKey("use_new_admin_danmaku", r100, "管理员弹幕效果弱化开关");
    }
}
