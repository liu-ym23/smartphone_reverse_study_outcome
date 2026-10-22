package com.networknt.schema.utils;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.EnvironmentCompat;

/* loaded from: classes3.dex */
public enum JsonType {
    OBJECT("object"),
    ARRAY("array"),
    STRING(TypedValues.Custom.S_STRING),
    NUMBER("number"),
    INTEGER(TypedValues.Custom.S_INT),
    BOOLEAN(TypedValues.Custom.S_BOOLEAN),
    NULL("null"),
    ANY("any"),
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN),
    UNION("union");


    /* renamed from: a, reason: collision with root package name */
    public final String f3057a;

    JsonType(String str) {
        this.f3057a = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f3057a;
    }
}
