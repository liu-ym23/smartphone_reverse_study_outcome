package com.bytedance.android.gamecp.common.setting;

import com.bytedance.android.gamecp.common.monitor.SafetyGuard;
import gu.c;
import java.util.List;

/* JADX INFO: loaded from: classes44.dex */
public interface LiveInfraSettingKeys {
    public static final SettingKey<List<gu.a>> KEVA_REMOTE_CONFIG_SETTING_KEY = null;
    public static final SettingKey<Boolean> LIVE_ENABLE_BY_CHECKER = null;
    public static final SettingKey<Boolean> LIVE_ENABLE_KEVA_OPT = null;
    public static final SettingKey<Boolean> LIVE_EZPERMISSION_QUERY = null;
    public static final SettingKey<Boolean> LIVE_EZPERMISSION_REQUEST = null;
    public static final SettingKey<SafetyGuard.a> LIVE_SAFETY_GUARD_CONFIG = null;
    public static final SettingKey<Boolean> LIVE_SHOW_NEVER_ASK_DIALOG = null;

    static {
        Boolean r100 = Boolean.FALSE;
        LIVE_EZPERMISSION_QUERY = new SettingKey("live_ezpermission_query", "使用ezpermission查询权限", r100, r100);
        LIVE_EZPERMISSION_REQUEST = new SettingKey("live_ezpermission_request", "使用ezpermission申请权限", r100, r100);
        LIVE_SAFETY_GUARD_CONFIG = new SettingKey("live_safety_guard_config", "SafetyGuard配置", new SafetyGuard.a(), new SafetyGuard.a());
        Boolean r101 = Boolean.TRUE;
        LIVE_ENABLE_BY_CHECKER = new SettingKey("live_enable_by_checker", "是否开启checker校验", r101, r101);
        List<gu.a> r102 = c.f482734a;
        KEVA_REMOTE_CONFIG_SETTING_KEY = new SettingKey("keva_remote_config_setting_keys", "keva远程配置key参数信息", c.a(), c.a());
        LIVE_ENABLE_KEVA_OPT = new SettingKey("live_enable_keva_opt", "是否开启keva优化的总开关", r101, r101, true);
        LIVE_SHOW_NEVER_ASK_DIALOG = new SettingKey("live_show_never_ask_dialog", "在使用EzPermission的前提下是否还需要弹权限申请的弹窗", r101, r101);
    }
}
