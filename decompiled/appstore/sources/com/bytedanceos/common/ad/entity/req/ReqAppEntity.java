package com.bytedanceos.common.ad.entity.req;

/* JADX INFO: loaded from: classes2.dex */
public class ReqAppEntity {
    private String name;
    private String package_name;
    private String version;

    public ReqAppEntity() {
        this.version = "";
        this.package_name = "";
        this.name = "";
    }

    public String getName() {
        return this.name;
    }

    public String getPackage_name() {
        return this.package_name;
    }

    public String getVersion() {
        return this.version;
    }

    public void setName(String r10) {
        this.name = r10;
    }

    public void setPackage_name(String r10) {
        this.package_name = r10;
    }

    public void setVersion(String r10) {
        this.version = r10;
    }
}
