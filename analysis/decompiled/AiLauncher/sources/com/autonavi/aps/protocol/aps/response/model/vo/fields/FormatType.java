package com.autonavi.aps.protocol.aps.response.model.vo.fields;

/* loaded from: classes.dex */
public enum FormatType {
    BIN("bin"),
    JSON("json"),
    XML("xml"),
    PB("pb");


    /* renamed from: a, reason: collision with root package name */
    private String f19112a;

    FormatType(String str) {
        this.f19112a = str;
    }

    public static FormatType fromString(String str) {
        if (str == null) {
            return XML;
        }
        String strTrim = str.trim();
        return "json".equals(strTrim) ? JSON : "bin".equals(strTrim) ? BIN : "pb".equals(strTrim) ? PB : XML;
    }

    public String getCode() {
        return this.f19112a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f19112a;
    }
}
