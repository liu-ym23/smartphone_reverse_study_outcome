package com.bytedanceos.common.networkv2.entity.req;

/* JADX INFO: loaded from: classes2.dex */
public class ReqSearchInfo {
    private String position;
    private String search_keywords;
    private String search_type;
    private String trace_id;

    public ReqSearchInfo() {
        this.trace_id = "";
        this.search_keywords = "";
        this.search_type = "";
        this.position = "";
    }

    public String getPosition() {
        return this.position;
    }

    public String getSearch_keywords() {
        return this.search_keywords;
    }

    public String getSearch_type() {
        return this.search_type;
    }

    public String getTrace_id() {
        return this.trace_id;
    }

    public void setPosition(String r10) {
        this.position = r10;
    }

    public void setSearch_keywords(String r10) {
        this.search_keywords = r10;
    }

    public void setSearch_type(String r10) {
        this.search_type = r10;
    }

    public void setTrace_id(String r10) {
        this.trace_id = r10;
    }
}
