package com.bytedanceos.common.networkv2.entity;

/* JADX INFO: loaded from: classes2.dex */
public class AppManagerCountsEntity extends BaseEntity {
    private BodyBean body;

    public static class BodyBean {
        private int app_num;
        private int gamesub_num;

        public BodyBean() {
        }

        public int getAppNum() {
            return this.app_num;
        }

        public int getGamesubNum() {
            return this.gamesub_num;
        }

        public void setAppNum(int r10) {
            this.app_num = r10;
        }

        public void setGamesubNum(int r10) {
            this.gamesub_num = r10;
        }
    }

    public AppManagerCountsEntity() {
    }

    public BodyBean getBody() {
        return this.body;
    }

    public void setBody(BodyBean r10) {
        this.body = r10;
    }
}
