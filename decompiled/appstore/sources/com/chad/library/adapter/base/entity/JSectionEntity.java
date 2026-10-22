package com.chad.library.adapter.base.entity;

/* JADX INFO: loaded from: classes2.dex */
public abstract class JSectionEntity implements SectionEntity {
    public JSectionEntity() {
    }

    @Override // com.chad.library.adapter.base.entity.SectionEntity, com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        if (isHeader() == false) goto L6;
        return -99;
    L6:
        return -100;
    }
}
