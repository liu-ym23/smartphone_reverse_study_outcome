package com.bytedanceos.common.networkv2.entity;

/* JADX INFO: loaded from: classes2.dex */
public class ReportBaseEntity extends RepBaseEntity {
    private int code;
    private String platform;

    public ReportBaseEntity() {
        this.code = 0;
        this.platform = "";
    }

    public int getCode() {
        return this.code;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setCode(int r10) {
        this.code = r10;
    }

    public void setPlatform(String r10) {
        this.platform = r10;
    }
}
