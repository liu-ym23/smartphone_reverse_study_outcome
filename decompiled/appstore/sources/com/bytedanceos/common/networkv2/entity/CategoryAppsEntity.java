package com.bytedanceos.common.networkv2.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CategoryAppsEntity extends BaseEntity {
    private BodyBean body;

    public static class BodyBean {
        private List<AppEntity> apps;

        public BodyBean() {
        }

        public List<AppEntity> getApps() {
            return this.apps;
        }

        public void setApps(List<AppEntity> r10) {
            this.apps = r10;
        }
    }

    public CategoryAppsEntity() {
    }

    public BodyBean getBody() {
        return this.body;
    }

    public void setBody(BodyBean r10) {
        this.body = r10;
    }
}
