package com.bytedanceos.common.ui.recycler.entity;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public class GroupTitleItem extends BaseItem {
    private String group_id;
    private String name;
    private String template;

    public GroupTitleItem() {
        this.name = "";
        this.group_id = "";
        this.template = "";
    }

    public static GroupTitleItem contain(String r10) {
        GroupTitleItem r11 = new GroupTitleItem();
        r11.setName(r10);
        return r11;
    }

    public String getGroup_id() {
        return this.group_id;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 4;
    }

    public String getName() {
        return this.name;
    }

    public String getTemplate() {
        return this.template;
    }

    @Override // com.bytedanceos.common.ui.recycler.entity.BaseItem
    public boolean isAvailable() {
        return !TextUtils.isEmpty(this.name);
    }

    public void setGroup_id(String r10) {
        this.group_id = r10;
    }

    public void setName(String r10) {
        this.name = r10;
    }

    public void setTemplate(String r10) {
        this.template = r10;
    }
}
