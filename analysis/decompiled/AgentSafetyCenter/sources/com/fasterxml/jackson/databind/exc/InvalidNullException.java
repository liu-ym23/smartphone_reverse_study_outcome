package com.fasterxml.jackson.databind.exc;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.PropertyName;
import com.fasterxml.jackson.databind.util.ClassUtil;
import w2.c;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class InvalidNullException extends MismatchedInputException {
    private static final long serialVersionUID = 1;
    protected final PropertyName _propertyName;

    public InvalidNullException(DeserializationContext deserializationContext, String str, PropertyName propertyName) {
        this(deserializationContext == null ? null : deserializationContext.getParser(), str, propertyName);
    }

    public static InvalidNullException from(DeserializationContext deserializationContext, PropertyName propertyName, JavaType javaType) {
        InvalidNullException invalidNullException = new InvalidNullException(deserializationContext, c.b("Invalid `null` value encountered for property ", ClassUtil.quotedOr(propertyName, "<UNKNOWN>")), propertyName);
        if (javaType != null) {
            invalidNullException.setTargetType(javaType);
        }
        return invalidNullException;
    }

    public PropertyName getPropertyName() {
        return this._propertyName;
    }

    public InvalidNullException(JsonParser jsonParser, String str, PropertyName propertyName) {
        super(jsonParser, str);
        this._propertyName = propertyName;
    }
}
