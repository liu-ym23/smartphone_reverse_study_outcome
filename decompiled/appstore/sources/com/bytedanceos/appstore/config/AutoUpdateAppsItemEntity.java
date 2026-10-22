package com.bytedanceos.appstore.config;

import com.bytedanceos.common.networkv2.cloudsettings.BaseSettingItemEntity;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AutoUpdateAppsItemEntity extends BaseSettingItemEntity {
    private List<String> system_app_auto_update_list;
    private List<String> system_apps_allow_update_list;
    private List<String> system_apps_category;
    private String version;

    public AutoUpdateAppsItemEntity() {
    }

    public List<String> getSystemApppAutoUpdateList() {
        return this.system_app_auto_update_list;
    }

    public List<String> getSystemAppsAllowUpdateList() {
        return this.system_apps_allow_update_list;
    }

    public List<String> getSystemAppsCategory() {
        return this.system_apps_category;
    }

    public String getVersion() {
        return this.version;
    }

    public void setSystemAppAutoUpdateList(List<String> r10) {
        this.system_app_auto_update_list = r10;
    }

    public void setSystemAppsAllowUpdateList(List<String> r10) {
        this.system_apps_allow_update_list = r10;
    }

    public void setSystemAppsCategory(List<String> r10) {
        this.system_apps_category = r10;
    }

    public void setVersion(String r10) {
        this.version = r10;
    }
}
