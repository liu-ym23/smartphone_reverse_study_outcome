package com.bytedanceos.common.model;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class SearchResultInfo {
    private Body body;

    public static class Body {
        private RelatedAppInfos related_apps;
        private List<TopAdAppInfo> topad_apps;

        public Body() {
        }

        public RelatedAppInfos getRelated_apps() {
            return this.related_apps;
        }

        public List<TopAdAppInfo> getTopad_apps() {
            return this.topad_apps;
        }

        public void setRelated_apps(RelatedAppInfos r10) {
            this.related_apps = r10;
        }

        public void setTopad_apps(List<TopAdAppInfo> r10) {
            this.topad_apps = r10;
        }
    }

    public SearchResultInfo() {
    }

    public Body getBody() {
        return this.body;
    }

    public void setBody(Body r10) {
        this.body = r10;
    }
}
