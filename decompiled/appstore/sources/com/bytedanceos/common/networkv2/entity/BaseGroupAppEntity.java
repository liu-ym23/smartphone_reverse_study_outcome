package com.bytedanceos.common.networkv2.entity;

/* JADX INFO: loaded from: classes2.dex */
public class BaseGroupAppEntity {
    private String group_id;
    private String name;
    private int rows;
    private String template;

    public BaseGroupAppEntity() {
        this.name = "";
        this.group_id = "";
        this.template = "";
        this.rows = 0;
    }

    public String getGroup_id() {
        return this.group_id;
    }

    public String getName() {
        return this.name;
    }

    public int getRows() {
        return this.rows;
    }

    public String getTemplate() {
        return this.template;
    }

    public void setGroup_id(String r10) {
        this.group_id = r10;
    }

    public void setName(String r10) {
        this.name = r10;
    }

    public void setRows(int r10) {
        this.rows = r10;
    }

    public void setTemplate(String r10) {
        this.template = r10;
    }
}
