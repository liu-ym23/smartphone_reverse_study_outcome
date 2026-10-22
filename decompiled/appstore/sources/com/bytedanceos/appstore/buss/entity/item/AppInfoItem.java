package com.bytedanceos.appstore.buss.entity.item;

import com.bytedanceos.appstore.buss.entity.AppInfoEntity;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.SizeConverter;

/* JADX INFO: loaded from: classes2.dex */
public class AppInfoItem {
    private AppInfo mAppInfo;

    public AppInfoItem(AppInfoEntity r10) {
        AppInfo r11 = r10.convertAppInfo();
        this.mAppInfo = r11;
        r11.setAppSize(SizeConverter.BTrim.convert(r11.appBytes));
    }

    public AppInfo getAppInfo() {
        return this.mAppInfo;
    }

    public AppInfoItem(AppInfoEntity r10, AppInfo r11) {
        this.mAppInfo = r11;
        r11.setAppSize(SizeConverter.BTrim.convert(r11.appBytes));
    }
}
