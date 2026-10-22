package com.bytedanceos.common.networkv2.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class ManagerSubListEntity extends BaseEntity {
    private List<SubGroupAppEntity> body;

    public ManagerSubListEntity() {
    }

    public List<SubGroupAppEntity> getBody() {
        return this.body;
    }

    public void setBody(List<SubGroupAppEntity> r10) {
        this.body = r10;
    }
}
