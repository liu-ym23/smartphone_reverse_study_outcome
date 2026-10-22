package com.bytedanceos.common.ad.entity.req;

/* JADX INFO: loaded from: classes2.dex */
public class BaseReqAdEntity {
    private String api_sskey;
    private String api_version;
    private String request_id;

    public BaseReqAdEntity() {
        this.request_id = "";
        this.api_sskey = "";
        this.api_version = "";
    }

    public String getApi_sskey() {
        return this.api_sskey;
    }

    public String getApi_version() {
        return this.api_version;
    }

    public String getRequest_id() {
        return this.request_id;
    }

    public void setApi_sskey(String r10) {
        this.api_sskey = r10;
    }

    public void setApi_version(String r10) {
        this.api_version = r10;
    }

    public void setRequest_id(String r10) {
        this.request_id = r10;
    }
}
