package com.networknt.schema.utils;

import com.autonavi.aps.amapapi.config.Const;

/* loaded from: classes2.dex */
public enum JsonType {
    OBJECT("object"),
    ARRAY("array"),
    STRING("string"),
    NUMBER(Const.JSON_KEY_NUMBER),
    INTEGER("integer"),
    BOOLEAN("boolean"),
    NULL("null"),
    ANY("any"),
    UNKNOWN("unknown"),
    UNION("union");

    private final String type;

    JsonType(String str) {
        this.type = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.type;
    }
}
