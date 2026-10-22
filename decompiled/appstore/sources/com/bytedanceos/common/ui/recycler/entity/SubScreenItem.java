package com.bytedanceos.common.ui.recycler.entity;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class SubScreenItem extends BaseItem {
    private String screen;

    public SubScreenItem() {
    }

    public static SubScreenItem contain(String r10) {
        SubScreenItem r11 = new SubScreenItem();
        r11.setScreen(r10);
        return r11;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 12;
    }

    public String getScreen() {
        return this.screen;
    }

    @Override // com.bytedanceos.common.ui.recycler.entity.BaseItem
    public boolean isAvailable() {
        return !TextUtils.isEmpty(this.screen);
    }

    public void setScreen(String r10) {
        this.screen = r10;
    }
}
