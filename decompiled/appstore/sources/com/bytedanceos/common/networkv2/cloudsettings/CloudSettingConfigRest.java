package com.bytedanceos.common.networkv2.cloudsettings;

import com.bytedanceos.common.networkv2.rest.AbstractRest;
import rx.Subscriber;

/* JADX INFO: loaded from: classes2.dex */
public class CloudSettingConfigRest extends AbstractRest {
    private static CloudSettingConfigRest _instance;
    private CloudSettingConfigService mService;

    private CloudSettingConfigRest() {
        init();
    }

    public static CloudSettingConfigRest instance() {
        if (_instance != null) goto L16;
        monitor-enter(CloudSettingConfigRest.class);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (_instance != null) goto L11;
        _instance = new CloudSettingConfigRest();     // Catch: Throwable -> L9
    L11:
        monitor-exit(CloudSettingConfigRest.class);     // Catch: Throwable -> L9
    L16:
        return _instance;
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public String getBaseUrl() {
        return "";
    }

    public void getSettingConfig(Subscriber r10, String r11) {
    }

    public <T extends BaseSettingItemEntity> void getSettingEntity(Subscriber r10, String r11, Class<T> r12) {
    }

    @Override // com.bytedanceos.common.networkv2.rest.AbstractRest
    public void setService() {
        this.mService = (CloudSettingConfigService) this.retrofit.d(CloudSettingConfigService.class);
    }
}
