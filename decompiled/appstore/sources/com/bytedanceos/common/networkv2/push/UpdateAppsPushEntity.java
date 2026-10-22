package com.bytedanceos.common.networkv2.push;

import com.bytedanceos.common.networkv2.entity.BaseEntity;

/* JADX INFO: loaded from: classes2.dex */
public class UpdateAppsPushEntity extends BaseEntity {
    private int allow_update;

    public UpdateAppsPushEntity() {
    }

    public int getAllow_update() {
        return this.allow_update;
    }

    public void setAllow_update(int r10) {
        this.allow_update = r10;
    }
}
