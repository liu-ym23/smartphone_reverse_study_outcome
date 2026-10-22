package com.bytedanceos.common.networkv2.entity;

/* JADX INFO: loaded from: classes2.dex */
public class AppInfosEntity extends BaseEntity {
    private Body body;

    public static class Body {
        private AppInfoEntity app_info;
        private RecommendAppsEntity classics_apps;
        private RecommendAppsEntity relation_apps;

        public Body() {
        }

        public AppInfoEntity getApp_info() {
            return this.app_info;
        }

        public RecommendAppsEntity getClassics_apps() {
            return this.classics_apps;
        }

        public RecommendAppsEntity getRelation_apps() {
            return this.relation_apps;
        }

        public void setApp_info(AppInfoEntity r10) {
            this.app_info = r10;
        }

        public void setClassics_apps(RecommendAppsEntity r10) {
            this.classics_apps = r10;
        }

        public void setRelation_apps(RecommendAppsEntity r10) {
            this.relation_apps = r10;
        }
    }

    public AppInfosEntity() {
    }

    public Body getBody() {
        return this.body;
    }

    public boolean isAvailable() {
        if (getBody() != null) goto L5;
    L9:
        return false;
    L5:
        if (getBody().getApp_info() == null) goto L9;
        if (getBody().getApp_info().isAvailable() == false) goto L9;
        return true;
    }

    public void setBody(Body r10) {
        this.body = r10;
    }
}
