package com.bytedanceos.common.networkv2.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class GameSubListEntity extends BaseEntity {
    private Body body;

    public static class Body {
        private SubGroupAppEntity group_apps;
        private GroupAppEntity hot_games;
        private SubGroupAppEntity other_apps;
        private List<SubVideoEntity> top_apps;

        public Body() {
        }

        public SubGroupAppEntity getGroup_apps() {
            return this.group_apps;
        }

        public GroupAppEntity getHot_games() {
            return this.hot_games;
        }

        public SubGroupAppEntity getOther_apps() {
            return this.other_apps;
        }

        public List<SubVideoEntity> getTop_apps() {
            return this.top_apps;
        }

        public void setGroup_apps(SubGroupAppEntity r10) {
            this.group_apps = r10;
        }

        public void setHot_games(GroupAppEntity r10) {
            this.hot_games = r10;
        }

        public void setOther_apps(SubGroupAppEntity r10) {
            this.other_apps = r10;
        }

        public void setTop_apps(List<SubVideoEntity> r10) {
            this.top_apps = r10;
        }
    }

    public GameSubListEntity() {
    }

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body r10) {
        this.body = r10;
    }
}
