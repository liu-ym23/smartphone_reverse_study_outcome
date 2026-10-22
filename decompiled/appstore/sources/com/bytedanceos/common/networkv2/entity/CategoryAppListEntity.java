package com.bytedanceos.common.networkv2.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class CategoryAppListEntity extends BaseEntity {
    private Body body;

    public static class Body {
        private List<AppEntity> apps;

        public Body() {
        }

        public List<AppEntity> getApps() {
            return this.apps;
        }

        public void setApps(List<AppEntity> r10) {
            this.apps = r10;
        }
    }

    public CategoryAppListEntity() {
    }

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body r10) {
        this.body = r10;
    }
}
