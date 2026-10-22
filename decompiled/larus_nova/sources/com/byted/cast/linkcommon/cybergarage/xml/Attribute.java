package com.byted.cast.linkcommon.cybergarage.xml;

/* JADX INFO: loaded from: classes28.dex */
public class Attribute {
    private String name;
    private String value;

    public Attribute() {
        this.name = "";
        this.value = "";
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public Attribute(Attribute r100) {
        this();
        set(r100);
    }

    public void set(Attribute r100) {
        setName(r100.getName());
        setValue(r100.getValue());
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setValue(String r100) {
        this.value = r100;
    }

    public Attribute(String r100, String r101) {
        this();
        setName(r100);
        setValue(r101);
    }
}
