package com.bytedanceos.common.ui.recycler.entity;

import com.bytedanceos.common.networkv2.entity.SubGiftEntity;

/* JADX INFO: loaded from: classes2.dex */
public class SubGiftItem extends BaseItem {
    private SubGiftEntity gift;

    public SubGiftItem() {
    }

    public static SubGiftItem contain(SubGiftEntity r10) {
        SubGiftItem r11 = new SubGiftItem();
        r11.setGift(r10);
        return r11;
    }

    public SubGiftEntity getGift() {
        return this.gift;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 11;
    }

    @Override // com.bytedanceos.common.ui.recycler.entity.BaseItem
    public boolean isAvailable() {
        if (this.gift == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void setGift(SubGiftEntity r10) {
        this.gift = r10;
    }
}
