package com.bytedanceos.common.ui.recycler.entity;

import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.networkv2.entity.AppEntity;
import com.bytedanceos.common.utils.h;

/* JADX INFO: loaded from: classes2.dex */
public class AppItem extends BaseItem {
    private AppEntity appEntity;
    private AppInfo appInfo;

    public AppItem() {
    }

    public static AppItem contain(AppEntity r10) {
        return contain(r10, 0);
    }

    public AppEntity getAppEntity() {
        return this.appEntity;
    }

    public AppInfo getAppInfo() {
        return this.appInfo;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 1;
    }

    public void setAppEntity(AppEntity r10) {
        this.appEntity = r10;
    }

    public void setAppInfo(AppInfo r10) {
        this.appInfo = r10;
    }

    public static AppItem contain(AppEntity r10, int r11) {
        AppItem r12 = new AppItem();
        r12.setAppEntity(r10);
        r12.setOrder(r11);
        r12.setAppInfo(h.d(r10, String.valueOf(r11)));
        return r12;
    }
}
