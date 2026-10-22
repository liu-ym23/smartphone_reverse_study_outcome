package com.stepos.digitalwellbeing.server.category.data.room;

/* loaded from: classes.dex */
public class PackageCategoryInfo {
    private int categoryId;
    private String packageName;

    public PackageCategoryInfo() {
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setCategoryId(int i5) {
        this.categoryId = i5;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public String toString() {
        return "PackageCategoryInfo{packageName='" + this.packageName + "', categoryId=" + this.categoryId + '}';
    }

    public PackageCategoryInfo(String str, int i5) {
        this.packageName = str;
        this.categoryId = i5;
    }
}
