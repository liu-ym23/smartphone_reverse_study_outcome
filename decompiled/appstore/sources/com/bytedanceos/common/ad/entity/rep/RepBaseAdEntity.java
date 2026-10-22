package com.bytedanceos.common.ad.entity.rep;

/* JADX INFO: loaded from: classes2.dex */
public class RepBaseAdEntity {
    private int code;
    private String errinfo;

    public RepBaseAdEntity() {
        this.code = -1;
        this.errinfo = "";
    }

    public int getCode() {
        return this.code;
    }

    public String getErrinfo() {
        return this.errinfo;
    }

    public void setCode(int r10) {
        this.code = r10;
    }

    public void setErrinfo(String r10) {
        this.errinfo = r10;
    }
}
