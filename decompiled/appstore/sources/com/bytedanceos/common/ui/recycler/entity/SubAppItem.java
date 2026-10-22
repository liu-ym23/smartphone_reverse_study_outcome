package com.bytedanceos.common.ui.recycler.entity;

import com.bytedanceos.common.networkv2.entity.SubAppEntity;
import com.bytedanceos.common.toolbox.e;

/* JADX INFO: loaded from: classes2.dex */
public class SubAppItem extends BaseSubAppItem {
    private String onlineTime;

    public SubAppItem() {
        this.onlineTime = "";
    }

    public static SubAppItem contain(SubAppEntity r10) {
        SubAppItem r11 = new SubAppItem();
        r11.setSubAppEntity(r10);
        r11.setOnlineTime(e.T(r10.getOnline_time()));
        return r11;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 2;
    }

    public String getOnlineTime() {
        return this.onlineTime;
    }

    @Override // com.bytedanceos.common.ui.recycler.entity.BaseItem
    public boolean isAvailable() {
        if (getSubAppEntity() == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void setOnlineTime(String r10) {
        this.onlineTime = r10;
    }
}
