package com.fasterxml.jackson.databind.type;

import java.util.Collection;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public enum LogicalType {
    Array,
    Collection,
    Map,
    POJO,
    Untyped,
    Integer,
    Float,
    Boolean,
    Enum,
    Textual,
    Binary,
    DateTime,
    OtherScalar;

    public static LogicalType fromClass(Class<?> cls, LogicalType logicalType) {
        return cls.isEnum() ? Enum : cls.isArray() ? cls == byte[].class ? Binary : Array : Collection.class.isAssignableFrom(cls) ? Collection : Map.class.isAssignableFrom(cls) ? Map : cls == String.class ? Textual : logicalType;
    }
}
