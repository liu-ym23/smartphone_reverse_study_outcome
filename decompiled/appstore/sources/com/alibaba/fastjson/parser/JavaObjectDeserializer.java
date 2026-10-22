package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class JavaObjectDeserializer implements ObjectDeserializer {
    public static final JavaObjectDeserializer instance = null;

    static {
        instance = new JavaObjectDeserializer();
    }

    public JavaObjectDeserializer() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser r10, Type r11, Object r12) {
        if ((r11 instanceof GenericArrayType) == false) goto L14;
        Type r13 = ((GenericArrayType) r11).getGenericComponentType();
        if ((r13 instanceof TypeVariable) == false) goto L7;
        r13 = ((TypeVariable) r13).getBounds()[0];
    L7:
        ArrayList r14 = new ArrayList();
        r10.parseArray(r13, r14);
        if ((r13 instanceof Class) == false) goto L12;
        T r15 = (T) ((Object[]) Array.newInstance((Class) r13, r14.size()));
        r14.toArray(r15);
        return r15;
    L12:
        return (T) r14.toArray();
    L14:
        return (T) r10.parse(r12);
    }
}
