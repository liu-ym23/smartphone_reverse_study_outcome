package com.bytedanceos.common.eventbus;

import com.bytedanceos.common.networkv2.entity.SubAppEntity;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GameSubDetailEvent extends BaseEvent {
    private List<MultiItemEntity> dataList;
    private SubAppEntity subAppEntity;

    public GameSubDetailEvent() {
    }

    public List<MultiItemEntity> getDataList() {
        return this.dataList;
    }

    public SubAppEntity getSubAppEntity() {
        return this.subAppEntity;
    }

    public void setDataList(List<MultiItemEntity> r10) {
        this.dataList = r10;
    }

    public void setSubAppEntity(SubAppEntity r10) {
        this.subAppEntity = r10;
    }
}
