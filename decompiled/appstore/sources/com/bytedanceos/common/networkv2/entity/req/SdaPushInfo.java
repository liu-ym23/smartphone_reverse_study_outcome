package com.bytedanceos.common.networkv2.entity.req;

/* JADX INFO: loaded from: classes2.dex */
public class SdaPushInfo {
    private String push_id;
    private String push_source;

    public SdaPushInfo() {
        this.push_id = "";
        this.push_source = "";
    }

    public String getPush_id() {
        return this.push_id;
    }

    public String getPush_source() {
        return this.push_source;
    }

    public void setPush_id(String r10) {
        this.push_id = r10;
    }

    public void setPush_source(String r10) {
        this.push_source = r10;
    }
}
