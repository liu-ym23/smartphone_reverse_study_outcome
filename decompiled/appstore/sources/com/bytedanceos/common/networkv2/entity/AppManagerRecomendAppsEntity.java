package com.bytedanceos.common.networkv2.entity;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class AppManagerRecomendAppsEntity extends BaseEntity {
    private List<BodyBean> body;

    public static class BodyBean {
        private List<AppEntity> apps;
        private String group_id;
        private String info_type;
        private String name;
        private int rows;
        private String template;

        public BodyBean() {
        }

        public List<AppEntity> getApps() {
            return this.apps;
        }

        public String getGroup_id() {
            return this.group_id;
        }

        public String getInfo_type() {
            return this.info_type;
        }

        public String getName() {
            return this.name;
        }

        public int getRows() {
            return this.rows;
        }

        public String getTemplate() {
            return this.template;
        }

        public void setApps(List<AppEntity> r10) {
            this.apps = r10;
        }

        public void setGroup_id(String r10) {
            this.group_id = r10;
        }

        public void setInfo_type(String r10) {
            this.info_type = r10;
        }

        public void setName(String r10) {
            this.name = r10;
        }

        public void setRows(int r10) {
            this.rows = r10;
        }

        public void setTemplate(String r10) {
            this.template = r10;
        }
    }

    public AppManagerRecomendAppsEntity() {
    }

    public List<BodyBean> getBody() {
        return this.body;
    }

    public void setBody(List<BodyBean> r10) {
        this.body = r10;
    }
}
