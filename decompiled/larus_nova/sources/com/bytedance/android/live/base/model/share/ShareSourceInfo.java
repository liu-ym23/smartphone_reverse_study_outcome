package com.bytedance.android.live.base.model.share;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import py.k;

/* JADX INFO: loaded from: classes45.dex */
public class ShareSourceInfo {

    @SerializedName("app_name")
    private String appName;

    @SerializedName("img_title")
    private String imgTitle;

    @SerializedName(VideoThumbInfo.KEY_IMG_URL)
    private k imgUrl;

    @SerializedName("pkg_name")
    private String pkgName;

    @SerializedName(a.KEY_SCHEMA_URL)
    private String schemaUrl;

    @SerializedName("title")
    private String title;

    public ShareSourceInfo() {
    }

    public String getAppName() {
        return this.appName;
    }

    public String getImgTitle() {
        return this.imgTitle;
    }

    public k getImgUrl() {
        return this.imgUrl;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getSchemaUrl() {
        return this.schemaUrl;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAppName(String r100) {
        this.appName = r100;
    }

    public void setImgTitle(String r100) {
        this.imgTitle = r100;
    }

    public void setImgUrl(k r100) {
        this.imgUrl = r100;
    }

    public void setPkgName(String r100) {
        this.pkgName = r100;
    }

    public void setSchemaUrl(String r100) {
        this.schemaUrl = r100;
    }

    public void setTitle(String r100) {
        this.title = r100;
    }
}
