package com.bytedanceos.common.networkv2.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GroupAppEntity extends BaseGroupAppEntity {
    private List<AppEntity> apps;

    public GroupAppEntity() {
    }

    public List<AppEntity> getApps() {
        return this.apps;
    }

    public void setApps(List<AppEntity> r10) {
        this.apps = r10;
    }
}
