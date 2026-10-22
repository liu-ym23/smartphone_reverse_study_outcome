package com.bytedanceos.common.networkv2.entity;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class FirstRecommendDescEntity {

    @SerializedName("bio")
    private String description;

    public FirstRecommendDescEntity() {
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String r10) {
        this.description = r10;
    }
}
