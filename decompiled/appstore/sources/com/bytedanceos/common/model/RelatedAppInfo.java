package com.bytedanceos.common.model;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class RelatedAppInfo implements AppInfoFilterInterface {
    public static final int TYPE_AD = 0;
    public static final int TYPE_CATEGORY = 2;
    public static final int TYPE_PROMOTE = 1;
    private String category;
    private String click;
    private String impression;
    private String name;

    @SerializedName("package")
    private String pkg;
    private String sstj;
    private int type;

    public RelatedAppInfo() {
        this.name = "";
        this.pkg = "";
        this.impression = "";
        this.click = "";
        this.sstj = "";
        this.category = "";
        this.type = -1;
    }

    public String getCategory() {
        return this.category;
    }

    public String getClick() {
        return this.click;
    }

    public String getImpression() {
        return this.impression;
    }

    public String getName() {
        return this.name;
    }

    @Override // com.bytedanceos.common.model.AppInfoFilterInterface
    public String getPackageNameForFilter() {
        String r10 = this.pkg;
        if (r10 != null) goto L6;
        return "";
    L6:
        return r10;
    }

    public String getPkg() {
        return this.pkg;
    }

    public String getSstj() {
        return this.sstj;
    }

    public int getType() {
        return this.type;
    }

    public void setCategory(String r10) {
        this.category = r10;
    }

    public void setClick(String r10) {
        this.click = r10;
    }

    public void setImpression(String r10) {
        this.impression = r10;
    }

    public void setName(String r10) {
        this.name = r10;
    }

    public void setPkg(String r10) {
        this.pkg = r10;
    }

    public void setSstj(String r10) {
        this.sstj = r10;
    }

    public void setType(int r10) {
        this.type = r10;
    }

    public RelatedAppInfo(int r10) {
        this.name = "";
        this.pkg = "";
        this.impression = "";
        this.click = "";
        this.sstj = "";
        this.category = "";
        this.type = r10;
    }

    public RelatedAppInfo(String r10) {
        this.name = "";
        this.pkg = "";
        this.impression = "";
        this.click = "";
        this.sstj = "";
        this.type = 2;
        this.category = r10;
    }
}
