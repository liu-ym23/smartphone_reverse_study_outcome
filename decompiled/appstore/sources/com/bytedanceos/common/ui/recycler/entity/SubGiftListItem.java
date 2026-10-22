package com.bytedanceos.common.ui.recycler.entity;

import com.bytedanceos.common.toolbox.c;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SubGiftListItem extends BaseItem {
    private List<SubGiftItem> gifts;

    public SubGiftListItem() {
    }

    public static SubGiftListItem contain(List<SubGiftItem> r10) {
        SubGiftListItem r11 = new SubGiftListItem();
        r11.setGifts(r10);
        return r11;
    }

    public List<SubGiftItem> getGifts() {
        return this.gifts;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 7;
    }

    @Override // com.bytedanceos.common.ui.recycler.entity.BaseItem
    public boolean isAvailable() {
        return !c.a(this.gifts);
    }

    public void setGifts(List<SubGiftItem> r10) {
        this.gifts = r10;
    }
}
