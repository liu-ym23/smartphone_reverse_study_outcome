package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class StdConverter<IN, OUT> implements Converter<IN, OUT> {
    public JavaType _findConverterType(TypeFactory typeFactory) {
        JavaType javaTypeFindSuperType = typeFactory.constructType(getClass()).findSuperType(Converter.class);
        if (javaTypeFindSuperType != null && javaTypeFindSuperType.containedTypeCount() >= 2) {
            return javaTypeFindSuperType;
        }
        f.e("Cannot find OUT type parameter for Converter of type ".concat(getClass().getName()));
        return null;
    }

    @Override // com.fasterxml.jackson.databind.util.Converter
    public abstract OUT convert(IN in);

    @Override // com.fasterxml.jackson.databind.util.Converter
    public JavaType getInputType(TypeFactory typeFactory) {
        return _findConverterType(typeFactory).containedType(0);
    }

    @Override // com.fasterxml.jackson.databind.util.Converter
    public JavaType getOutputType(TypeFactory typeFactory) {
        return _findConverterType(typeFactory).containedType(1);
    }
}
