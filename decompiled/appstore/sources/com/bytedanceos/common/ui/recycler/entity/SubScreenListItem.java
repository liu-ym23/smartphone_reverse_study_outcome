package com.bytedanceos.common.ui.recycler.entity;

import com.bytedanceos.common.toolbox.c;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SubScreenListItem extends BaseItem {
    private List<SubScreenItem> screens;

    public SubScreenListItem() {
    }

    public static SubScreenListItem contain(List<SubScreenItem> r10) {
        SubScreenListItem r11 = new SubScreenListItem();
        r11.setScreens(r10);
        return r11;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 8;
    }

    public List<SubScreenItem> getScreens() {
        return this.screens;
    }

    @Override // com.bytedanceos.common.ui.recycler.entity.BaseItem
    public boolean isAvailable() {
        return !c.a(this.screens);
    }

    public void setScreens(List<SubScreenItem> r10) {
        this.screens = r10;
    }
}
