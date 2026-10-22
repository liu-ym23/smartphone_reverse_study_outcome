package com.bytedanceos.common.networkv2.entity.req;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes2.dex */
public class ReqPushReportEntity {

    @SerializedName("package")
    private String pkg;
    private String product_name;
    private String reason;
    private String type;
    private String version_code;

    public ReqPushReportEntity() {
        this.pkg = "";
        this.version_code = "";
        this.type = "";
        this.reason = "";
    }

    public String getPkg() {
        return this.pkg;
    }

    public String getProduct_name() {
        return this.product_name;
    }

    public String getReason() {
        return this.reason;
    }

    public String getType() {
        return this.type;
    }

    public String getVersion_code() {
        return this.version_code;
    }

    public void setPkg(String r10) {
        this.pkg = r10;
    }

    public void setProduct_name(String r10) {
        this.product_name = r10;
    }

    public void setReason(String r10) {
        this.reason = r10;
    }

    public void setType(String r10) {
        this.type = r10;
    }

    public void setVersion_code(String r10) {
        this.version_code = r10;
    }
}
