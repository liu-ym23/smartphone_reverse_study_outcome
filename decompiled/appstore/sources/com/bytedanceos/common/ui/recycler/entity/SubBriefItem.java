package com.bytedanceos.common.ui.recycler.entity;

/* JADX INFO: loaded from: classes2.dex */
public class SubBriefItem extends BaseItem {
    private String brief;

    public SubBriefItem() {
        this.brief = "";
    }

    public static SubBriefItem contain(String r10) {
        SubBriefItem r11 = new SubBriefItem();
        r11.setBrief(r10);
        return r11;
    }

    public String getBrief() {
        return this.brief;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return 9;
    }

    public void setBrief(String r10) {
        this.brief = r10;
    }
}
