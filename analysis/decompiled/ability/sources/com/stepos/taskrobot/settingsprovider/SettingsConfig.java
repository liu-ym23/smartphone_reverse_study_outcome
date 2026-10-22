package com.stepos.taskrobot.settingsprovider;

import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0014\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/stepos/taskrobot/settingsprovider/SettingsConfig;", "", AppAgent.CONSTRUCT, "()V", "AUTHORITY", "", "PERMISSION", "PATH_MASTER_SWITCH", "PATH_WHITELIST", "PATH_TRIGGER_SYNC", "PATH_AUTHORIZATION_STATUS", "PATH_LOCAL_RUN", "PATH_HOST_ACTIVITY_DISMISSED", "KEY_ENABLED", "KEY_DATA", "KEY_STATUS", "MMKV_KEY_MASTER_SWITCH", "MMKV_KEY_WHITELIST_CACHE", "MMKV_KEY_WHITELIST_OVERRIDES", "MMKV_KEY_AUTHORIZED", "MMKV_KEY_ALLOW_ALL_APPS", "MMKV_KEY_REDIRECT_GROUPS_CACHE", "ACTION_MASTER_SWITCH_CHANGED", "ACTION_WHITELIST_ITEM_CHANGED", "ACTION_AUTHORIZATION_STATUS_CHANGED", "settingsprovider_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SettingsConfig {
    public static final String ACTION_AUTHORIZATION_STATUS_CHANGED = "com.stepos.taskrobot.AUTHORIZATION_STATUS_CHANGED";
    public static final String ACTION_MASTER_SWITCH_CHANGED = "com.stepos.taskrobot.MASTER_SWITCH_CHANGED";
    public static final String ACTION_WHITELIST_ITEM_CHANGED = "com.stepos.taskrobot.WHITELIST_ITEM_CHANGED";
    public static final String AUTHORITY = "com.stepos.taskrobot.settingsprovider";
    public static final SettingsConfig INSTANCE = new SettingsConfig();
    public static final String KEY_DATA = "data";
    public static final String KEY_ENABLED = "enabled";
    public static final String KEY_STATUS = "status";
    public static final String MMKV_KEY_ALLOW_ALL_APPS = "allow_all_apps_enabled";
    public static final String MMKV_KEY_AUTHORIZED = "authorization_status";
    public static final String MMKV_KEY_MASTER_SWITCH = "master_switch_enabled";
    public static final String MMKV_KEY_REDIRECT_GROUPS_CACHE = "redirect_groups_cache";
    public static final String MMKV_KEY_WHITELIST_CACHE = "whitelist_cache";
    public static final String MMKV_KEY_WHITELIST_OVERRIDES = "whitelist_overrides";
    public static final String PATH_AUTHORIZATION_STATUS = "authorization_status";
    public static final String PATH_HOST_ACTIVITY_DISMISSED = "host_activity_dismissed";
    public static final String PATH_LOCAL_RUN = "local_run";
    public static final String PATH_MASTER_SWITCH = "master_switch";
    public static final String PATH_TRIGGER_SYNC = "trigger_sync";
    public static final String PATH_WHITELIST = "whitelist";
    public static final String PERMISSION = "com.stepos.taskrobot.permission.ACCESS_SETTINGS";

    private SettingsConfig() {
    }
}
