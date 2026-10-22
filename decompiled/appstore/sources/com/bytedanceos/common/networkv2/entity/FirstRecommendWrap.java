package com.bytedanceos.common.networkv2.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class FirstRecommendWrap extends BaseEntity {
    private List<FirstRecommend> body;

    public class FirstRecommend extends FirstRecommendBannerEntity {
        private List<AppEntity> apps;

        @SerializedName("bio")
        private String description;
        final /* synthetic */ FirstRecommendWrap this$0;

        public FirstRecommend(FirstRecommendWrap r10) {
            this.this$0 = r10;
        }

        public List<AppEntity> getApps() {
            return this.apps;
        }

        public String getDescription() {
            return this.description;
        }

        public void setApps(List<AppEntity> r10) {
            this.apps = r10;
        }

        public void setDescription(String r10) {
            this.description = r10;
        }
    }

    public FirstRecommendWrap() {
    }

    public List<FirstRecommend> getBody() {
        return this.body;
    }

    public void setBody(List<FirstRecommend> r10) {
        this.body = r10;
    }
}
