package com.bytedance.android.live.base.model.user;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes45.dex */
public class ProfilePoiInfo {

    @SerializedName("city")
    String city;

    @SerializedName("content")
    String content;

    @SerializedName("icon")
    py.k icon;

    @SerializedName("jump_schema")
    String jumpSchema;

    @SerializedName("poi_id")
    long poiId;

    @SerializedName("poi_id_str")
    String poiIdStr;

    @SerializedName("poi_name")
    String poiName;

    @SerializedName("is_poi_enabled")
    boolean poiPermission;

    public ProfilePoiInfo() {
    }

    public String getCity() {
        return this.city;
    }

    public String getContent() {
        return this.content;
    }

    public py.k getIcon() {
        return this.icon;
    }

    public String getJumpSchema() {
        return this.jumpSchema;
    }

    public long getPoiId() {
        return this.poiId;
    }

    public String getPoiIdStr() {
        return this.poiIdStr;
    }

    public String getPoiName() {
        return this.poiName;
    }

    public boolean isPoiPermission() {
        return this.poiPermission;
    }

    public void setCity(String r100) {
        this.city = r100;
    }

    public void setContent(String r100) {
        this.content = r100;
    }

    public void setIcon(py.k r100) {
        this.icon = r100;
    }

    public void setJumpSchema(String r100) {
        this.jumpSchema = r100;
    }

    public void setPoiId(long r100) {
        this.poiId = r100;
    }

    public void setPoiIdStr(String r100) {
        this.poiIdStr = r100;
    }

    public void setPoiName(String r100) {
        this.poiName = r100;
    }

    public void setPoiPermission(boolean r100) {
        this.poiPermission = r100;
    }
}
