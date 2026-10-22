package com.bytedanceos.common.ui.recycler.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/* JADX INFO: loaded from: classes2.dex */
public abstract class BaseItem extends ReportItem implements MultiItemEntity {
    private boolean isLast;
    private boolean isShowDiv;

    public BaseItem() {
        this.isLast = false;
        this.isShowDiv = true;
    }

    public boolean isAvailable() {
        return true;
    }

    public boolean isLast() {
        return this.isLast;
    }

    public boolean isShowDiv() {
        return this.isShowDiv;
    }

    public void setLast(boolean r10) {
        this.isLast = r10;
    }

    public void setShowDiv(boolean r10) {
        this.isShowDiv = r10;
    }
}
