package com.bytedanceos.common.ui.recycler.entity;

import com.bytedanceos.common.networkv2.entity.AppEntity;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseAppItem extends BaseItem {
    private AppEntity appEntity;

    public BaseAppItem() {
    }

    public AppEntity getAppEntity() {
        return this.appEntity;
    }

    public void setAppEntity(AppEntity r10) {
        this.appEntity = r10;
    }
}
