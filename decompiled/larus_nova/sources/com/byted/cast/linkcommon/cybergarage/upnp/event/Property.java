package com.byted.cast.linkcommon.cybergarage.upnp.event;

/* JADX INFO: loaded from: classes28.dex */
public class Property {
    private String name;
    private String value;

    public Property() {
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
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.name = r100;
    }

    public void setValue(String r100) {
        if (r100 != null) goto L4;
        r100 = "";
    L4:
        this.value = r100;
    }
}
