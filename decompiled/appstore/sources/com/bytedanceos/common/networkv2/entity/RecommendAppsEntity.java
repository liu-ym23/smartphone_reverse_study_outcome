package com.bytedanceos.common.networkv2.entity;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class RecommendAppsEntity {
    private List<CategoryEntity> category;
    private String name;

    public class CategoryEntity {
        private List<AppEntity> apps;
        private AppCategoryEntity category;
        private String name;
        final /* synthetic */ RecommendAppsEntity this$0;

        public CategoryEntity(RecommendAppsEntity r10) {
            this.this$0 = r10;
            this.name = "";
            this.apps = new ArrayList();
        }

        public List<AppEntity> getApps() {
            return this.apps;
        }

        public AppCategoryEntity getCategory() {
            return this.category;
        }

        public String getName() {
            return this.name;
        }

        public void setApps(List<AppEntity> r10) {
            this.apps = r10;
        }

        public void setCategory(AppCategoryEntity r10) {
            this.category = r10;
        }

        public void setName(String r10) {
            this.name = r10;
        }
    }

    public RecommendAppsEntity() {
        this.name = "";
    }

    public List<CategoryEntity> getCategory() {
        return this.category;
    }

    public String getName() {
        return this.name;
    }

    public void setCategory(List<CategoryEntity> r10) {
        this.category = r10;
    }

    public void setName(String r10) {
        this.name = r10;
    }
}
