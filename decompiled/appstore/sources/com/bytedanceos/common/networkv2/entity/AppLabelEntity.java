package com.bytedanceos.common.networkv2.entity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class AppLabelEntity {
    public static final int TYPE_AD = 0;
    public static final int TYPE_CATEGORY = 2;
    public static final int TYPE_PROMOTE = 1;
    private String click;
    private String impression;
    private String name;

    @SerializedName("package")
    private String pkg;
    private String sstj;
    private int type;

    public AppLabelEntity() {
        this.name = "";
        this.pkg = "";
        this.impression = "";
        this.click = "";
        this.sstj = "";
        this.type = -1;
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

    public String getPkg() {
        return this.pkg;
    }

    public String getSstj() {
        return this.sstj;
    }

    public int getType() {
        return this.type;
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

    public AppLabelEntity(int r10) {
        this.name = "";
        this.pkg = "";
        this.impression = "";
        this.click = "";
        this.sstj = "";
        this.type = r10;
    }
}
