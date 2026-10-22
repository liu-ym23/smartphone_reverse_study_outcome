package com.bytedanceos.common.ui.recycler.entity;

import com.bytedanceos.common.networkv2.entity.SubVideoEntity;

/* JADX INFO: loaded from: classes2.dex */
public class SubVideoItem extends BaseItem {
    private boolean isControlVisable;
    private SubVideoEntity subVideoEntity;

    public SubVideoItem() {
        this.isControlVisable = true;
    }

    public static SubVideoItem contain(SubVideoEntity r10) {
        SubVideoItem r11 = new SubVideoItem();
        r11.setSubVideoEntity(r10);
        return r11;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 3;
    }

    public SubVideoEntity getSubVideoEntity() {
        return this.subVideoEntity;
    }

    @Override // com.bytedanceos.common.ui.recycler.entity.BaseItem
    public boolean isAvailable() {
        SubVideoEntity r10 = this.subVideoEntity;
        if (r10 != null) goto L5;
    L7:
        return false;
    L5:
        if (r10.getVideo() == null) goto L7;
        return true;
    }

    public boolean isControlVisable() {
        return this.isControlVisable;
    }

    public void setControlVisable(boolean r10) {
        this.isControlVisable = r10;
    }

    public void setSubVideoEntity(SubVideoEntity r10) {
        this.subVideoEntity = r10;
    }
}
