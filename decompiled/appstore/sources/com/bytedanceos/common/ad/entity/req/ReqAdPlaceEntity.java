package com.bytedanceos.common.ad.entity.req;

/* JADX INFO: loaded from: classes2.dex */
public class ReqAdPlaceEntity {
    private String aid;
    private String size;
    private int type;

    public ReqAdPlaceEntity() {
        this.aid = "";
        this.size = "";
        this.type = 0;
    }

    public String getAid() {
        return this.aid;
    }

    public String getSize() {
        return this.size;
    }

    public int getType() {
        return this.type;
    }

    public void setAid(String r10) {
        this.aid = r10;
    }

    public void setSize(String r10) {
        this.size = r10;
    }

    public void setType(int r10) {
        this.type = r10;
    }
}
