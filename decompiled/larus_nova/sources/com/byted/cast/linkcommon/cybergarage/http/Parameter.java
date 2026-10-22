package com.byted.cast.linkcommon.cybergarage.http;

/* JADX INFO: loaded from: classes28.dex */
public class Parameter {
    private String name;
    private String value;

    public Parameter() {
        this.name = "";
        this.value = "";
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setValue(String r100) {
        this.value = r100;
    }

    public Parameter(String r100, String r101) {
        this.name = "";
        this.value = "";
        setName(r100);
        setValue(r101);
    }
}
