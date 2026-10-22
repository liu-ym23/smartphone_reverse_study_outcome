package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class InvalidFormatException extends MismatchedInputException {
    private static final long serialVersionUID = 1;
    protected final Object _value;

    @Deprecated
    public InvalidFormatException(String str, Object obj, Class<?> cls) {
        super(null, str);
        this._value = obj;
        this._targetType = cls;
    }

    public static InvalidFormatException from(JsonParser jsonParser, String str, Object obj, Class<?> cls) {
        return new InvalidFormatException(jsonParser, str, obj, cls);
    }

    public Object getValue() {
        return this._value;
    }

    @Deprecated
    public InvalidFormatException(String str, JsonLocation jsonLocation, Object obj, Class<?> cls) {
        super((JsonParser) null, str, jsonLocation);
        this._value = obj;
        this._targetType = cls;
    }

    public InvalidFormatException(JsonParser jsonParser, String str, Object obj, Class<?> cls) {
        super(jsonParser, str, cls);
        this._value = obj;
    }
}
