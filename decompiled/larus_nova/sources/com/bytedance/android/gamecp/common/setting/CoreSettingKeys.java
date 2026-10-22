package com.bytedance.android.gamecp.common.setting;

/* JADX INFO: loaded from: classes44.dex */
public interface CoreSettingKeys {
    public static final SettingKey<Integer> TEST_FAKE_REGION = null;

    static {
        TEST_FAKE_REGION = new SettingKey("fake_regions", "local_test fake国家", 0, 0, new String[]{"0:中国", "1:摩洛哥", "2:沙特阿拉伯", "3:法国", "4:阿联酋"});
    }
}
