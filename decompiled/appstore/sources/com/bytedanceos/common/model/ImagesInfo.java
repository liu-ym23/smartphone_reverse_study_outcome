package com.bytedanceos.common.model;

import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ImagesInfo implements IAppExtra, Serializable {
    public static final int LIST_SIZE = 3;
    private List<String> imageUrlList;

    public ImagesInfo() {
    }

    public List<String> getImageUrlList() {
        return this.imageUrlList;
    }

    @Override // com.bytedanceos.common.model.IAppExtra
    public int getItemType() {
        return 7;
    }

    public void setImageUrlList(List<String> r10) {
        this.imageUrlList = r10;
    }
}
