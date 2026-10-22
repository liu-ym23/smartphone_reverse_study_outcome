package com.bytedanceos.common.ui.recycler.entity;

import com.bytedanceos.common.networkv2.entity.SubAppEntity;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseSubAppItem extends BaseItem {
    private SubAppEntity subAppEntity;

    public BaseSubAppItem() {
    }

    public SubAppEntity getSubAppEntity() {
        return this.subAppEntity;
    }

    public void setSubAppEntity(SubAppEntity r10) {
        this.subAppEntity = r10;
    }
}
