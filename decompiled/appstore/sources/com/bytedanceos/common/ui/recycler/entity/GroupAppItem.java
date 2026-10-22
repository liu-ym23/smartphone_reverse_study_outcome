package com.bytedanceos.common.ui.recycler.entity;

import com.bytedanceos.common.networkv2.entity.AppEntity;

/* JADX INFO: loaded from: classes2.dex */
public class GroupAppItem extends BaseAppItem {
    public GroupAppItem() {
    }

    public static GroupAppItem contain(AppEntity r10) {
        GroupAppItem r11 = new GroupAppItem();
        r11.setAppEntity(r10);
        return r11;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 14;
    }

    @Override // com.bytedanceos.common.ui.recycler.entity.BaseItem
    public boolean isAvailable() {
        if (getAppEntity() == null) goto L5;
        return true;
    L5:
        return false;
    }
}
