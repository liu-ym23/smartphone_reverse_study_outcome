package com.bytedanceos.common.networkv2.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SubGroupAppEntity extends BaseGroupAppEntity {
    private List<SubAppEntity> apps;

    public SubGroupAppEntity() {
    }

    public List<SubAppEntity> getApps() {
        return this.apps;
    }

    public void setApps(List<SubAppEntity> r10) {
        this.apps = r10;
    }
}
