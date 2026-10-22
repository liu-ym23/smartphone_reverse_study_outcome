package com.bytedanceos.common.networkv2.entity.req;

/* JADX INFO: loaded from: classes2.dex */
public class SdaSourceInfo {
    private String source_pkg_name;
    private String source_position;

    public SdaSourceInfo() {
        this.source_pkg_name = "";
        this.source_position = "";
    }

    public String getSource_pkg_name() {
        return this.source_pkg_name;
    }

    public String getSource_position() {
        return this.source_position;
    }

    public void setSource_pkg_name(String r10) {
        this.source_pkg_name = r10;
    }

    public void setSource_position(String r10) {
        this.source_position = r10;
    }
}
