package com.bytedanceos.common.networkv2.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class MySubListEntity extends BaseEntity {
    private Body body;

    public static class Body {
        private List<SubAppEntity> apps;

        public Body() {
        }

        public List<SubAppEntity> getApps() {
            return this.apps;
        }

        public void setApps(List<SubAppEntity> r10) {
            this.apps = r10;
        }
    }

    public MySubListEntity() {
    }

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body r10) {
        this.body = r10;
    }
}
